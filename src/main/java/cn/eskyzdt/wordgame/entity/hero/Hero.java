package cn.eskyzdt.wordgame.entity.hero;

import lombok.Data;

/**
 * <p>
 * 人物表
 * </p>
 *
 * @author timber
 * @since 2020-06-09
 */
@Data
public class Hero {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private Long id;

    /**
     * 序列号
     */
    private Long serial;

    /**
     * 姓名
     */
    private String name;

    /**
     * 等级
     */
    private String level;

    /**
     * 种族
     */
    private Integer classType;

    /**
     * 0:战士 1:法师 2:盗贼
     */
    private Integer heroType;

    /**
     * 职业
     */
    private Integer profession;

    /**
     * 公会
     */
    private String guild;

    /**
     * 所在位置
     */
    private Integer nowZoneIdx;

    /**
     * 所在x坐标
     */
    private Integer nowZoneX;

    /**
     * 所在y坐标
     */
    private Integer nowZoneY;

    /**
     * 金钱
     */
    private Integer gold;

    /**
     * 经验
     */
    private Long exp;

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
     * 物攻
     */
    private Integer dp;

    /**
     * 魔攻
     */
    private Integer ap;

    /**
     * 精力
     */
    private Integer hc;

    /**
     * 体力
     */
    private Integer hd;

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
     * 坐骑
     */
    private Integer mount;

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

    /**
     * 鞋子
     */
    private Integer foot;

    /**
     * 道具
     */
    private Integer item;

    /**
     * 国家
     */
    private Integer country;


}
