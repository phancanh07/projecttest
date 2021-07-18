package com.example.projecttest.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Principal {

    @SerializedName("billing")
    @Expose
    private Integer billing;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("characters")
    @Expose
    private List<String> characters = null;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("legacyNameText")
    @Expose
    private String legacyNameText;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("roles")
    @Expose
    private List<Role> roles = null;
    @SerializedName("disambiguation")
    @Expose
    private String disambiguation;

    public Integer getBilling() {
        return billing;
    }

    public void setBilling(Integer billing) {
        this.billing = billing;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getCharacters() {
        return characters;
    }

    public void setCharacters(List<String> characters) {
        this.characters = characters;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLegacyNameText() {
        return legacyNameText;
    }

    public void setLegacyNameText(String legacyNameText) {
        this.legacyNameText = legacyNameText;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getDisambiguation() {
        return disambiguation;
    }

    public void setDisambiguation(String disambiguation) {
        this.disambiguation = disambiguation;
    }

}