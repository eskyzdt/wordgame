package cn.eskyzdt.wordgame.service.pet;

import cn.eskyzdt.wordgame.entity.pet.Pet;
import cn.eskyzdt.wordgame.entity.pet.PetDto;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 宠物表 服务类
 * </p>
 *
 * @author timber
 * @since 2020-06-18
 */
public interface IPetService extends IService<Pet> {

    /**
     * 查询宠物
     * @param params
     * @return
     */
    PetDto queryMyPet(Map<String, Object> params) ;


}
