package com.randomforests.saaransh.models;

public class Notes {
    String title,desc,uploadedBy,timestamp;

    public Notes(String title, String desc, String uploadedBy, String timestamp) {
        this.title = title;
        this.desc = desc;
        this.uploadedBy = uploadedBy;
        this.timestamp = timestamp;
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

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
