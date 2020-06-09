package cn.eskyzdt.wordgame.entity.index;

import lombok.Data;

/**
 * <p>
 * 首页留言表
 * </p>
 *
 * @author timber
 * @since 2020-06-09
 */
@Data
public class IndexMsg  {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 昵称
     */
    private String name;

    /**
     * 内容
     */
    private String content;

    /**
     * ip地址
     */
    private String ip;


}
