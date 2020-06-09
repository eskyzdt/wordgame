package cn.eskyzdt.wordgame.service.hero.impl;

import cn.eskyzdt.wordgame.entity.hero.Hero;
import cn.eskyzdt.wordgame.mapper.hero.HeroMapper;
import cn.eskyzdt.wordgame.service.hero.IHeroService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 人物表 服务实现类
 * </p>
 *
 * @author timber
 * @since 2020-06-09
 */
@Service
public class HeroServiceImpl extends ServiceImpl<HeroMapper, Hero> implements IHeroService {

}
