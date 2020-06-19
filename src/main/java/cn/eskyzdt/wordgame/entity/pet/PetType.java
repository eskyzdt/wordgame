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
 * @since 2020-06-19
 */
@Data
public class PetType {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private String id;
    /**
     * 宠物名称
     */
    private String name;

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

    public Pet toPet() {
        Pet pet = new Pet();
        pet.setName(this.name);
        pet.setPic(this.pic);
        pet.setLevel(this.level);
        pet.setQuality(this.quality);
        pet.setPetType(new Integer(this.id));
        pet.setItem(this.item);
        pet.setExp(this.exp);
        pet.setCe(this.ce);
        pet.setGold(this.gold);
        pet.setDp(this.dp);
        pet.setDe(this.de);

        pet.setHp(this.hp);
        pet.setMp(this.mp);
        pet.setHd(this.hd);
        pet.setMaxhp(this.hp);
        pet.setMaxmp(this.mp);
        pet.setMaxhd(this.hd);
        return pet;
    }
}
