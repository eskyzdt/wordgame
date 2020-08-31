package cn.eskyzdt.wordgame.controller.index;


import cn.eskyzdt.wordgame.entity.index.IndexMsg;
import cn.eskyzdt.wordgame.service.index.IIndexMsgService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 首页留言表 前端控制器
 * </p>
 *
 * @author timber
 * @since 2020-06-09
 */
@RestController
@RequestMapping("/wordgame/index-msg")
public class IndexMsgController  {

    @Resource
    private IIndexMsgService indexMsgService;

    @RequestMapping("/query")
    public List<IndexMsg> queryMsg() {
        List<IndexMsg> result = indexMsgService.query().orderByDesc("time").list();
        return result;
    }
}
