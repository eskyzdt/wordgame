package cn.eskyzdt.wordgame.controller.usr;


import cn.eskyzdt.wordgame.entity.usr.User;
import cn.eskyzdt.wordgame.module.exception.WrongException;
import cn.eskyzdt.wordgame.module.result.Result;
import cn.eskyzdt.wordgame.module.utils.encrypt.EncryptUtil;
import cn.eskyzdt.wordgame.service.usr.IUserService;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

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

    @RequestMapping("/regist")
    public Result regist(@RequestParam Map<String, String> param, HttpServletRequest request, HttpServletResponse response) {
        String username = param.get("username");
        String password = param.get("password");

        String phone= param.get("phone");
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
        boolean result= false;
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
    public void login(@RequestParam Map<String, String> param, HttpServletRequest request, HttpServletResponse response) {
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
            // 暂时没用的cookie
            response.addCookie(new Cookie("webgame_token", token));

            // 在session中存入token和用户名对应的
            HttpSession session = request.getSession();
            session.setAttribute("token", username);
        }
    }

    /**
     * 根据session获取用户名
     * @param request
     * @return
     */
    public String getUsername(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String token = (String) session.getAttribute("token");
        return token;
    }

}
