package cn.eskyzdt.wordgame;

import cn.eskyzdt.wordgame.entity.usr.User;
import cn.eskyzdt.wordgame.mapper.usr.UserMapper;
import cn.eskyzdt.wordgame.service.usr.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class WordgameApplicationTests {

    @Autowired
    private UserServiceImpl userService;


    @Resource
    private UserMapper userMapper;

    @Test
    public void contextLoads() {
        User user1 = userMapper.selectById(1);
        System.out.println(user1);
    }

}
