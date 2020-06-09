package cn.eskyzdt.wordgame.mapper.usr;

import cn.eskyzdt.wordgame.entity.usr.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author timber
 * @since 2020-06-09
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    public User queryOne();

}
