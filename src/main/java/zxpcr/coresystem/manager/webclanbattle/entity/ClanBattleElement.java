package zxpcr.coresystem.manager.webclanbattle.entity;

import java.util.List;

public class ClanBattleElement {
    private String clanUserId;
    private String clanUserName;
    private String clanUserQQ;
    private List<String> clanRecord;

    public String getClanUserId() {
        return clanUserId;
    }

    public void setClanUserId(String clanUserId) {
        this.clanUserId = clanUserId;
    }

    public String getClanUserName() {
        return clanUserName;
    }

    public void setClanUserName(String clanUserName) {
        this.clanUserName = clanUserName;
    }

    public String getClanUserQQ() {
        return clanUserQQ;
    }

    public void setClanUserQQ(String clanUserQQ) {
        this.clanUserQQ = clanUserQQ;
    }

    public List<String> getClanRecord() {
        return clanRecord;
    }

    public void setClanRecord(List<String> clanRecord) {
        this.clanRecord = clanRecord;
    }
}
