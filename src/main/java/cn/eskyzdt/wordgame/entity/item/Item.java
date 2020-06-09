package cn.eskyzdt.wordgame.entity.item;

import lombok.Data;

/**
 * <p>
 * 物品表
 * </p>
 *
 * @author timber
 * @since 2020-06-09
 */
@Data
public class Item  {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private Long id;

    /**
     * 道具名
     */
    private String itemName;

    /**
     * 道具序列号
     */
    private Long serial;

    /**
     * 道具类型
     */
    private Integer itemType;

    /**
     * 道具价值
     */
    private Integer itemPrice;

    /**
     * 物攻
     */
    private Long ad;

    /**
     * 魔攻
     */
    private Long ap;

    /**
     * 物防
     */
    private Long adDef;

    /**
     * 魔防
     */
    private Long apDef;

    /**
     * 速度
     */
    private Long speed;

    /**
     * 品质:0白色,1绿色,2蓝色,3红色,4金色
     */
    private Boolean quality;


}
