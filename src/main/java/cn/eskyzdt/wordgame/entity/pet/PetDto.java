package cn.eskyzdt.wordgame.entity.pet;

/**
 * <p>
 * 宠物表
 * </p>
 *
 * @author timber
 * @since 2020-06-18
 */
public class PetDto  extends Pet{

    private String itemName;

    public String getQualityStr() {
        return qualityStr;
    }

    public void setQualityStr(String qualityStr) {
        this.qualityStr = qualityStr;
    }

    private String qualityStr;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
