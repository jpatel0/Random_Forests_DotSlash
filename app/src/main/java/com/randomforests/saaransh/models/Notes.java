package com.randomforests.saaransh.models;

public class Notes {
    private String title,desc,uploadedBy,topics;
    private long timestamp;

    public Notes(){}

    public Notes(String title, String desc, String uploadedBy, long timestamp,String topics) {
        this.title = title;
        this.desc = desc;
        this.uploadedBy = uploadedBy;
        this.timestamp = timestamp;
        this.topics = topics;
    }

    public String getTopics() {
        return topics;
    }

    public void setTopics(String topics) {
        this.topics = topics;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(String uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
