package com.example.proto2;

public class UserData {
    private String Location;
    private String RoomType;
    private float RoomPrice;
    private String RoomDescription;

    public UserData() {

    }

    public String getLocation() {
        return Location;
    }

    public String getRoomType() {
        return RoomType;
    }

    public float getRoomPrice() {
        return RoomPrice;
    }

    public String getRoomDescription() {
        return RoomDescription;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public void setRoomType(String roomType) {
        RoomType = roomType;
    }

    public void setRoomPrice(float roomPrice) {
        RoomPrice = roomPrice;
    }

    public void setRoomDescription(String roomDescription) {
        RoomDescription = roomDescription;
    }
}

