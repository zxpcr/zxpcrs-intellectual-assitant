package zxpcr.coresystem.manager.webclanbattle.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zxpcr.coresystem.manager.webclanbattle.controller.ClanBattleController;
import zxpcr.coresystem.manager.webclanbattle.entity.ClanInfoEntity;
import zxpcr.coresystem.manager.webclanbattle.mapper.ClanBattleManagerDao;
import zxpcr.coresystem.manager.webclanbattle.mapper.ClanBattleUserDao;

import java.util.List;
import java.util.Map;

@Service
public class ClanBattleManagerService {

    private Logger logger = LoggerFactory.getLogger(ClanBattleController.class);
    @Autowired
    private ClanBattleUserDao clanBattlerDao;

    @Autowired
    private ClanBattleManagerDao clanManagerDao;


    public List<ClanInfoEntity> getClanProfile(String clanCode) {
        return clanManagerDao.getClanInfo(clanCode);
    }


}
