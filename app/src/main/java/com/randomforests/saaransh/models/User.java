package com.randomforests.saaransh.models;

public class User {
    private String name,clubId,interests;

    public User(String name) {
        this.name = name;
    }

    public String getClubId() {
        return clubId;
    }

    public void setClubId(String clubId) {
        this.clubId = clubId;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
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
