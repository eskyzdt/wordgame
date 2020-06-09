package cn.eskyzdt.wordgame.service.usr.impl;

import cn.eskyzdt.wordgame.entity.usr.User;
import cn.eskyzdt.wordgame.mapper.usr.UserMapper;
import cn.eskyzdt.wordgame.service.usr.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author timber
 * @since 2020-06-09
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
