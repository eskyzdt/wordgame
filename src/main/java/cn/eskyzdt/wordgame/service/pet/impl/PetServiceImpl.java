package cn.eskyzdt.wordgame.service.pet.impl;

import cn.eskyzdt.wordgame.entity.pet.Pet;
import cn.eskyzdt.wordgame.mapper.pet.PetMapper;
import cn.eskyzdt.wordgame.service.pet.IPetService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 宠物表 服务实现类
 * </p>
 *
 * @author timber
 * @since 2020-06-18
 */
@Service
public class PetServiceImpl extends ServiceImpl<PetMapper, Pet> implements IPetService {

}
