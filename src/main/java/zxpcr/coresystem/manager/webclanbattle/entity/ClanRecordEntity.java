package zxpcr.coresystem.manager.webclanbattle.entity;

public class ClanRecordEntity {
    private String recordId;
    private String clanUserId;
    private Integer damage;
    private String damageType;
    private String clanId;
    private String handleTime;
    private Integer clanLoop;
    private Integer clanOrder;

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getClanUserId() {
        return clanUserId;
    }

    public void setClanUserId(String clanUserId) {
        this.clanUserId = clanUserId;
    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public String getDamageType() {
        return damageType;
    }

    public void setDamageType(String damageType) {
        this.damageType = damageType;
    }

    public String getClanId() {
        return clanId;
    }

    public void setClanId(String clanId) {
        this.clanId = clanId;
    }

    public String getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(String handleTime) {
        this.handleTime = handleTime;
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
}
