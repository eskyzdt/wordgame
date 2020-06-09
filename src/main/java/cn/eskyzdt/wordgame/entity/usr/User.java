package cn.eskyzdt.wordgame.entity.usr;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author timber
 * @since 2020-06-09
 */
@Data
public class User {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 电话
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 用户创建时间
     */
    private LocalDateTime createTime;

}
