package cn.eskyzdt.wordgame.mapper.pet;

import cn.eskyzdt.wordgame.entity.pet.Pet;
import cn.eskyzdt.wordgame.entity.pet.PetDto;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.Map;

/**
 * <p>
 * 宠物表 Mapper 接口
 * </p>
 *
 * @author timber
 * @since 2020-06-18
 */
public interface PetMapper extends BaseMapper<Pet> {

    PetDto queryMyPet(Map<String, Object> params);

}
