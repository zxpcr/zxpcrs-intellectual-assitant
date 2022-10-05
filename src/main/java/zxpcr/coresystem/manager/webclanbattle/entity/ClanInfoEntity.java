package zxpcr.coresystem.manager.webclanbattle.entity;

public class ClanInfoEntity {

    private String clanId;
    private String serverType;
    private String clanName;
    private Integer clanLoop;
    private Integer clanOrder;
    private Integer remainHp;

    public String getClanId() {
        return clanId;
    }

    public void setClanId(String clanId) {
        this.clanId = clanId;
    }

    public String getServerType() {
        return serverType;
    }

    public void setServerType(String serverType) {
        this.serverType = serverType;
    }

    public String getClanName() {
        return clanName;
    }

    public void setClanName(String clanName) {
        this.clanName = clanName;
    }

    public Integer getClanLoop() {
        return clanLoop;
    }

    public void setClanLoop(Integer clanLoop) {
        this.clanLoop = clanLoop;
    }

    public Integer getClanOrder() {
        return clanOrder;
    }

    public void setClanOrder(Integer clanOrder) {
        this.clanOrder = clanOrder;
    }

    public Integer getRemainHp() {
        return remainHp;
    }

    public void setRemainHp(Integer remainHp) {
        this.remainHp = remainHp;
    }
}
