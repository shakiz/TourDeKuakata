package com.shakil.tourdekuakata.models;

public class HomeMenu {
    private int Icon;
    private String Title;
    private int Total;

    public HomeMenu(int icon, String title, int total) {
        Icon = icon;
        Title = title;
        Total = total;
    }

    public int getIcon() {
        return Icon;
    }

    public void setIcon(int icon) {
        Icon = icon;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int total) {
        Total = total;
    }
}
