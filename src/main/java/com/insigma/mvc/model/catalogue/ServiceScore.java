package com.insigma.mvc.model.catalogue;

/**
 * 服务评分记录表
 */
public class ServiceScore {

    private String score_id;
    private String cata_id;
    private String score_level;
    private String userId;
    private String createTime;
    private String status;
    private String score_desc;
    private String score_feedback_desc;
    private String score_feedback_userid;
    private String score_feedback_time;

    public String getScore_id() {
        return score_id;
    }

    public void setScore_id(String score_id) {
        this.score_id = score_id;
    }

    public String getCata_id() {
        return cata_id;
    }

    public void setCata_id(String cata_id) {
        this.cata_id = cata_id;
    }

    public String getScore_level() {
        return score_level;
    }

    public void setScore_level(String score_level) {
        this.score_level = score_level;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getScore_desc() {
        return score_desc;
    }

    public void setScore_desc(String score_desc) {
        this.score_desc = score_desc;
    }

    public String getScore_feedback_desc() {
        return score_feedback_desc;
    }

    public void setScore_feedback_desc(String score_feedback_desc) {
        this.score_feedback_desc = score_feedback_desc;
    }

    public String getScore_feedback_userid() {
        return score_feedback_userid;
    }

    public void setScore_feedback_userid(String score_feedback_userid) {
        this.score_feedback_userid = score_feedback_userid;
    }

    public String getScore_feedback_time() {
        return score_feedback_time;
    }

    public void setScore_feedback_time(String score_feedback_time) {
        this.score_feedback_time = score_feedback_time;
    }
}
