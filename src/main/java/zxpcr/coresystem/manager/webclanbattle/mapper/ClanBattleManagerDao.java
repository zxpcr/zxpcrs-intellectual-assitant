package zxpcr.coresystem.manager.webclanbattle.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import zxpcr.coresystem.manager.webclanbattle.entity.ClanInfoEntity;
import zxpcr.coresystem.manager.webclanbattle.entity.ClanRecordEntity;

import java.util.List;

@Mapper
public interface ClanBattleManagerDao {
    List<ClanInfoEntity> getClanInfo(@Param("clanCode") String clanCode);
    List<ClanRecordEntity> getClanRecord(@Param("clanCode") String clanCode,
                                         @Param("beginTime") String beginTime,
                                         @Param("endTime") String endTime);
}
