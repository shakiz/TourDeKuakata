package com.shakil.tourdekuakata.models;

public class Place {
    private String Title;
    private int Icon;
    private String Description;

    public Place(String title, int icon, String description) {
        Title = title;
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

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
