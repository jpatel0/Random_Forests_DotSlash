package com.randomforests.saaransh.models;

public class User {
    private String name,clubId;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroupId() {
        return clubId;
    }

    public void setGroupId(String groupId) {
        this.clubId = groupId;
    }
}
