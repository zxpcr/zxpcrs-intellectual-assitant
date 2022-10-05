package zxpcr.coresystem.manager.webclanbattle.entity;


public class ClanBattlerEntity {
    private String clanUserId;
    private String clanId;
    private String userQQ;
    private String userName;
    private String clanGroup;
    private String inClanStatus;

    public String getClanUserId() {
        return clanUserId;
    }

    public void setClanUserId(String clanUserId) {
        this.clanUserId = clanUserId;
    }

    public String getClanId() {
        return clanId;
    }

    public void setClanId(String clanId) {
        this.clanId = clanId;
    }

    public String getUserQQ() {
        return userQQ;
    }

    public void setUserQQ(String userQQ) {
        this.userQQ = userQQ;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getClanGroup() {
        return clanGroup;
    }

    public void setClanGroup(String clanGroup) {
        this.clanGroup = clanGroup;
    }

    public String getInClanStatus() {
        return inClanStatus;
    }

    public void setInClanStatus(String inClanStatus) {
        this.inClanStatus = inClanStatus;
    }
}
