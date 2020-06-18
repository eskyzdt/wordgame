package cn.eskyzdt.wordgame.controller;

import cn.eskyzdt.wordgame.module.exception.WrongException;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

public class BaseMapper {

    @Resource
    private RedisTemplate redisTemplate;

    protected Long getAuth(HttpServletRequest request) {
        String id = request.getSession().getId();
        Long userId = (Long) redisTemplate.opsForValue().get(id);
        if (userId == null) {
            throw new WrongException("请重新登陆");
        }
        return userId;
    }


}
