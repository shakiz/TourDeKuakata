package com.shakil.tourdekuakata.adapters;

public class Hotel {
    private int Icon;
    private String MobileNumber;
    private String HotelName;

    public Hotel(int icon, String mobileNumber, String hotelName) {
        Icon = icon;
        MobileNumber = mobileNumber;
        HotelName = hotelName;
    }

    public int getIcon() {
        return Icon;
    }

    public void setIcon(int icon) {
        Icon = icon;
    }

    public String getMobileNumber() {
        return MobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        MobileNumber = mobileNumber;
    }

    public String getHotelName() {
        return HotelName;
    }

    public void setHotelName(String hotelName) {
        HotelName = hotelName;
    }
}
