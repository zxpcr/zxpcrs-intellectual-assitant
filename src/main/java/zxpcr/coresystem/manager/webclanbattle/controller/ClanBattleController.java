package zxpcr.coresystem.manager.webclanbattle.controller;


import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import zxpcr.coresystem.manager.webclanbattle.entity.ClanInfoEntity;
import zxpcr.coresystem.manager.webclanbattle.service.ClanBattleManagerService;
import zxpcr.coresystem.manager.webclanbattle.service.ClanBattlerService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("clanbattle")
public class ClanBattleController {

    private Logger logger = LoggerFactory.getLogger(ClanBattleController.class);

    @Autowired
    private ClanBattlerService clanBattlerService;
    @Autowired
    private ClanBattleManagerService clanManagerService;

    @PostMapping("viewMember")
    @ResponseBody
    public Map viewClanMember(Model model, @RequestBody String jsonParam) {
        Map preQueryGroup = (Map) JSON.parse(jsonParam);
        logger.info("HI!");
        logger.info(clanBattlerService.getClanBattlerInfo(preQueryGroup).size() + "");
        //model.addAttribute("result", clanBattlerService.getClanBattlerInfo(preQueryGroup));
        Map result = new HashMap();
        result.put("result", clanBattlerService.getClanBattlerInfo(preQueryGroup));
        return result;
    }

    @PostMapping("deleteMember")
    @ResponseBody
    public Map deleteClanMember(Model model, @RequestBody String jsonParam) {
        Map preQueryGroup = (Map) JSON.parse(jsonParam);
        logger.info("HI!Bye!");
        Map result = new HashMap();
        result.put("result", clanBattlerService.deleteClanBattler((String) preQueryGroup.get("clan_user_id")));
        return result;
    }


    @PostMapping("reviewList")
    @ResponseBody
    public Map reviewClanBattle(Model model, @RequestBody String jsonParam) {
        Map preQueryGroup = (Map) JSON.parse(jsonParam);
        String account = (String) preQueryGroup.get("userId");
        String groupId = (String) preQueryGroup.get("groupId");
        return null;
    }

    @PostMapping("reviewProfile")
    @ResponseBody
    public List<ClanInfoEntity> reviewClanProfile(@RequestBody String jsonParam) {
        Map preQueryGroup = (Map) JSON.parse(jsonParam);
        String clanCode = (String) preQueryGroup.get("clanCode");
        if ("".equals(clanCode)) {
            clanCode = "-1";
        }
        logger.info(clanCode);
        return clanManagerService.getClanProfile(clanCode);
    }






    @PostMapping("login")
    @ResponseBody
    public Map login(Model model, @RequestBody String jsonParam) {
        Map preQueryGroup = (Map) JSON.parse(jsonParam);
        logger.info("HI!Bye!");

        String res = clanBattlerService.login((String) preQueryGroup.get("user_name"),(String) preQueryGroup.get("password"));
        if (res == null || "".equals(res)) {
            return null;
        }
        Map result = new HashMap();
        result.put("result", res);
        return result;
    }





}
