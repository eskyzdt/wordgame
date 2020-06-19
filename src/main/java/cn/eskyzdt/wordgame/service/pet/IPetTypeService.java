package cn.eskyzdt.wordgame.service.pet;

import cn.eskyzdt.wordgame.entity.pet.PetType;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 宠物表 服务类
 * </p>
 *
 * @author timber
 * @since 2020-06-19
 */
public interface IPetTypeService extends IService<PetType> {

    /**
     * 查询宠物类型总数
     * @return
     */
    int queryCount();

}
