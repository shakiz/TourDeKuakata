package com.shakil.tourdekuakata.models;

public class Place {
    private int Icon;
    private String Description;

    public Place(int icon, String description) {
        Icon = icon;
        Description = description;
    }

    public int getIcon() {
        return Icon;
    }

    public void setIcon(int icon) {
        Icon = icon;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
