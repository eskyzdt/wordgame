package cn.eskyzdt.wordgame.service.pet.impl;

import cn.eskyzdt.wordgame.entity.pet.PetType;
import cn.eskyzdt.wordgame.mapper.pet.PetTypeMapper;
import cn.eskyzdt.wordgame.service.pet.IPetTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 宠物表 服务实现类
 * </p>
 *
 * @author timber
 * @since 2020-06-19
 */
@Service
public class PetTypeServiceImpl extends ServiceImpl<PetTypeMapper, PetType> implements IPetTypeService {

    @Resource
    private PetTypeMapper petTypeMapper;

    @Override
    public int queryCount() {
        return petTypeMapper.queryCount();
    }
}
