package cn.eskyzdt.wordgame.controller.usr;


import cn.eskyzdt.wordgame.entity.usr.User;
import cn.eskyzdt.wordgame.module.exception.WrongException;
import cn.eskyzdt.wordgame.module.result.Result;
import cn.eskyzdt.wordgame.module.utils.encrypt.EncryptUtil;
import cn.eskyzdt.wordgame.service.usr.IUserService;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author timber
 * @since 2020-06-09
 */
@RestController
@RequestMapping("/wordgame/user")
public class UserController {

    @Resource
    private IUserService userService;

    @Resource
    private RedisTemplate redisTemplate;

    @RequestMapping("/regist")
    public Result regist(@RequestBody Map<String, String> param) {
        String username = param.get("username");
        String password = param.get("password");

        String phone = param.get("phone");
        String email = param.get("email");
        if (StringUtils.isEmpty(username)) {
            throw new WrongException("用户名不能为空");
        }
        if (StringUtils.isEmpty(password)) {
            throw new WrongException("密码不能为空");
        }
        if (StringUtils.isEmpty(phone)) {
            throw new WrongException("手机号不能为空");
        }
        if (StringUtils.isEmpty(email)) {
            throw new WrongException("邮箱不能为空");
        }
        // 注册
        // 注册时加密密码
        password = EncryptUtil.passwordEncrypt(password);
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setPhone(phone);
        user.setEmail(email);
        boolean result = false;
        try {
            result = userService.save(user);
        } catch (DuplicateKeyException e) {
            return Result.error("用户名已被注册,请更换用户名");
        }
        if (result) {
            return Result.ok("注册成功");
        } else {
            return Result.error("注册失败,请重试");
        }
    }

    @RequestMapping("/login")
    public Result login(@RequestBody Map<String, String> param, HttpServletRequest request, HttpServletResponse response) {
        String username = param.get("username");
        String password = param.get("password");
        if (StringUtils.isEmpty(username)) {
            throw new WrongException("用户名不能为空");
        }
        if (StringUtils.isEmpty(password)) {
            throw new WrongException("密码不能为空");
        }
        // 密码加密后进行比对,防止库泄露
        password = EncryptUtil.passwordEncrypt(password);
        User one = userService.query().eq("username", username).eq("password", password).one();
        if (one != null) {
            // 创建一个随机数作为身份认证标识
            long randomNum = ThreadLocalRandom.current().nextLong();
            String token = String.valueOf(randomNum);
            // 这个token存入cookie
            response.addCookie(new Cookie("webgame_token", token));
            // 在redis中存入token和用户名,根据token获得用户
            // 这里暂时用jessionId
            redisTemplate.opsForValue().set(request.getSession().getId(), one.getId(), 1, TimeUnit.HOURS);
            return Result.ok("登陆成功");
        } else {
            // 登陆失败
            return Result.error("用户名或密码错误");
        }
    }

}
