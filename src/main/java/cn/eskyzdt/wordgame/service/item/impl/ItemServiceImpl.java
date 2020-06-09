package cn.eskyzdt.wordgame.service.item.impl;

import cn.eskyzdt.wordgame.entity.item.Item;
import cn.eskyzdt.wordgame.mapper.item.ItemMapper;
import cn.eskyzdt.wordgame.service.item.IItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 物品表 服务实现类
 * </p>
 *
 * @author timber
 * @since 2020-06-09
 */
@Service
public class ItemServiceImpl extends ServiceImpl<ItemMapper, Item> implements IItemService {

}
