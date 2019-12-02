package com.shakil.tourdekuakata.models;

public class GalleyItem {
    private int Icon;
    private String PlaceName;

    public GalleyItem(int icon, String placeName) {
        Icon = icon;
        PlaceName = placeName;
    }

    public int getIcon() {
        return Icon;
    }

    public void setIcon(int icon) {
        Icon = icon;
    }

    public String getPlaceName() {
        return PlaceName;
    }

    public void setPlaceName(String placeName) {
        PlaceName = placeName;
    }
}
