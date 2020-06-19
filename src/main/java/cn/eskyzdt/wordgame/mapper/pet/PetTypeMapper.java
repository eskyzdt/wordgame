package cn.eskyzdt.wordgame.mapper.pet;

import cn.eskyzdt.wordgame.entity.pet.PetType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 宠物表 Mapper 接口
 * </p>
 *
 * @author timber
 * @since 2020-06-19
 */
public interface PetTypeMapper extends BaseMapper<PetType> {

    int queryCount();
}
