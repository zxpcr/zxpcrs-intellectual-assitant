package zxpcr.coresystem.manager.webclanbattle.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import zxpcr.coresystem.manager.webclanbattle.entity.ClanBattlerEntity;

import java.util.List;

@Mapper
public interface ClanBattleUserDao {
    List<ClanBattlerEntity> getClanBattlerList(@Param("group_id") String groupId);
    void deleteClanBattler(@Param("clan_user_id") String clanUserId);
    String login(@Param("user_name") String userName, @Param("password") String pwd);
}
