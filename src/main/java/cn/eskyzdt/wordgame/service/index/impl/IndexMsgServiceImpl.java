package cn.eskyzdt.wordgame.service.index.impl;

import cn.eskyzdt.wordgame.entity.index.IndexMsg;
import cn.eskyzdt.wordgame.mapper.index.IndexMsgMapper;
import cn.eskyzdt.wordgame.service.index.IIndexMsgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 首页留言表 服务实现类
 * </p>
 *
 * @author timber
 * @since 2020-06-09
 */
@Service
public class IndexMsgServiceImpl extends ServiceImpl<IndexMsgMapper, IndexMsg> implements IIndexMsgService {

}
