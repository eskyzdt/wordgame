package cn.eskyzdt.wordgame.controller.pet;


import cn.eskyzdt.wordgame.controller.BaseMapper;
import cn.eskyzdt.wordgame.entity.pet.Pet;
import cn.eskyzdt.wordgame.entity.pet.PetDto;
import cn.eskyzdt.wordgame.entity.pet.PetType;
import cn.eskyzdt.wordgame.module.result.Result;
import cn.eskyzdt.wordgame.service.pet.IPetService;
import cn.eskyzdt.wordgame.service.pet.IPetTypeService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * <p>
 * 宠物表 前端控制器
 * </p>
 *
 * @author timber
 * @since 2020-06-18
 */
@RestController
@RequestMapping("/pet")
public class PetController extends BaseMapper {

    @Resource
    private IPetService petService;

    @Resource
    private IPetTypeService petTypeService;

    /**
     * 查询宠物详情的功能
     * @param request
     * @return
     */
    @RequestMapping("/myPet")
    public Result myPet(HttpServletRequest request) {
        Long userId = getAuth(request);
       // Pet pet = petService.query().eq("user_id", userId).one();
        HashMap<String, Object> param = new HashMap<>();
        param.put("userId", userId);
        PetDto pet = petService.queryMyPet(param);
        if (pet == null) {
            return Result.error("您还没有宠物,砸个蛋试试吧");
        }
        return Result.ok().putResult(pet);
    }

    /**
     * 砸蛋功能
     * @param request
     * @return
     */
    @RequestMapping("/draw")
    public Result drawPet(HttpServletRequest request) {
        Long userId = getAuth(request);
        // 砸蛋
        Random random = new Random();
        // 查出宠物总数量
        int count = petTypeService.queryCount();
        //  一个随机的宠物
        int i = 0;
        while (i == 0) {
            i = random.nextInt(count);
        }
        // 查出这个宠物
        PetType petModel = petTypeService.query().eq("id", i).one();
        Pet pet = petModel.toPet();
        // 一个随机的品质
        int quality = random.nextInt(6);
        pet.setQuality(quality);
        // 宠物与用户关联
        pet.setUserId(userId);
        // 最多只能有一个宠物
        synchronized (this) {
            List<Pet> pets = petService.query().eq("user_id", userId).list();
            if (CollectionUtils.isEmpty(pets)) {
                petService.save(pet);
            } else {
                return Result.error("您已经有一个宠物了");
            }
        }
        return getResult(petModel.getName(), quality);
    }

    /**
     * 根据name和quality输出一个返回值
     * @param name
     * @param quality
     * @return
     */
    private static Result getResult(String name, Integer quality) {
        String qua;
        switch (quality) {
            case 1:
                qua = "普通";
                break;
            case 2:
                qua = "精品";
                break;
            case 3:
                qua = "稀有";
                break;
            case 4:
                qua = "传说";
                break;
            case 5:
                qua = "史诗";
                break;
            case 6:
                qua = "神话";
                break;
            default:
                qua = "";
        }
        return Result.ok("恭喜您抽到一个" + qua + "品质的" + name);
    }

    /**
     * 放生宠物
     * @param request
     * @return
     */
    @RequestMapping("/discard")
    public Result discardPet(HttpServletRequest request) {
        Long userId = getAuth(request);
        QueryWrapper<Pet> eq = new QueryWrapper<Pet>().eq("user_id", userId);
        boolean remove = petService.remove(eq);
        if (remove) {
            return Result.ok("放生成功");
        } else {
            return Result.error("您还没有宠物,砸个蛋试试吧");
        }
    }

}
