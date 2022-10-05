package zxpcr.coresystem.manager.webclanbattle.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zxpcr.coresystem.manager.webclanbattle.controller.ClanBattleController;
import zxpcr.coresystem.manager.webclanbattle.mapper.ClanBattleUserDao;

import java.util.List;
import java.util.Map;

@Service
public class ClanBattlerService {
    private Logger logger = LoggerFactory.getLogger(ClanBattleController.class);


    @Autowired
    private ClanBattleUserDao clanBattlerDao;

    public List getClanBattlerInfo(Map queryMap) {
        String groupId = String.valueOf(queryMap.get("group_id"));
        return clanBattlerDao.getClanBattlerList(groupId);
    }

    public String deleteClanBattler(String clanUserId) {
        clanBattlerDao.deleteClanBattler(clanUserId);
        return "Finish";
    }

    public String login(String userName, String pwd) {
        return clanBattlerDao.login(userName,pwd);
    }




}
