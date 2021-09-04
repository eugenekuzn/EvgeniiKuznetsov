package ru.training.at.hw9.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Prefs {
    @SerializedName("background")
    @Expose
    private String background;
    @SerializedName("permissionLevel")
    @Expose
    private String permissionLevel;
    @SerializedName("voting")
    @Expose
    private String voting;
    @SerializedName("comments")
    @Expose
    private String comments;

    public String getBackground() {
        return background;
    }

    public String getPermissionLevel() {
        return permissionLevel;
    }

    public String getVoting() {
        return voting;
    }

    public String getComments() {
        return comments;
    }
}
