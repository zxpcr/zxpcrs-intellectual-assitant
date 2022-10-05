package zxpcr.coresystem.manager.webclanbattle.entity;


import org.springframework.boot.autoconfigure.domain.EntityScan;

public class QueryGroupEntity {
    private String groupId;
    private String queryType;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getQueryType() {
        return queryType;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }
}
