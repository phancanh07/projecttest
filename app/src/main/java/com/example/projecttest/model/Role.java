package com.example.projecttest.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Role {

    @SerializedName("character")
    @Expose
    private String character;
    @SerializedName("characterId")
    @Expose
    private String characterId;

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getCharacterId() {
        return characterId;
    }

    public void setCharacterId(String characterId) {
        this.characterId = characterId;
    }

}