package cn.eskyzdt.wordgame.entity.pet;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * <p>
 * 宠物表
 * </p>
 *
 * @author timber
 * @since 2020-06-18
 */
@Data
public class Pet {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 和user表关联的字段
     */
    private Long userId;

    /**
     * 宠物名称,冗余存储
     */
    private String name;

    /**
     * 宠物昵称
     */
    private String nickName;

    /**
     * 宠物头像
     */
    private String pic;

    /**
     * 等级
     */
    private Integer level;

    /**
     * 品级 1.普通 2.精品 3.稀有 4.传说 5史诗 6.神话  品质:0白色,1绿色,2蓝色,3红色,4金色
     */
    private Integer quality;

    /**
     * 宠物类型 1.朱雀 2.玄武 3.
     */
    private Integer petType;

    /**
     * 神器
     */
    private Integer item;

    /**
     * 经验
     */
    private Long exp;

    /**
     * 战力combat effectiveness
     */
    private Integer ce;

    /**
     * 金钱
     */
    private Integer gold;

    /**
     * 攻击
     */
    private Integer dp;

    /**
     * 防御
     */
    private Integer de;

    /**
     * 体力
     */
    private Integer hd;

    /**
     * 最大体力
     */
    private Integer maxhd;

    /**
     * hp
     */
    private Integer hp;

    /**
     * mp
     */
    private Integer mp;

    /**
     * 最大hp
     */
    private Integer maxhp;

    /**
     * 最大mp
     */
    private Integer maxmp;

    /**
     * 所在x坐标
     */
    private Integer nowZoneX;

    /**
     * 所在y坐标
     */
    private Integer nowZoneY;

    /**
     * 移动速度
     */
    private Integer speedMove;

    /**
     * 攻击速度
     */
    private Integer speedAttack;

    /**
     * 技能施放速度
     */
    private Integer speedSkill;

    /**
     * 力量
     */
    private Integer str;

    /**
     * 智力
     */
    private Integer intel;

    /**
     * 身法
     */
    private Integer dex;

    /**
     * 体质
     */
    private Integer life;

    /**
     * 精准
     */
    private Integer aim;

    /**
     * 福缘
     */
    private Integer luck;

    /**
     * 魅力
     */
    private Integer attr;

    /**
     * 武器
     */
    private Integer weapon;

    /**
     * 头部
     */
    private Integer head;

    /**
     * 上衣
     */
    private Integer clothes;

    /**
     * 下装
     */
    private Integer pants;

    /**
     * 护手
     */
    private Integer hand;


}
