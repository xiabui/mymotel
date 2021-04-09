package me.monla.mymotel.models;

import android.graphics.drawable.Drawable;

public class RoomModel {
    int id;
    String name;
    int lastElectricNumber;
    int lastWaterNumber;
    boolean isRented;
    Drawable color;

    public RoomModel(int id, String name, int lastElectricNumber, int lastWaterNumber, boolean isRented) {
        this.id = id;
        this.name = name;
        this.lastElectricNumber = lastElectricNumber;
        this.lastWaterNumber = lastWaterNumber;
        this.isRented = isRented;
    }

    public RoomModel(int id, String name, int lastElectricNumber, int lastWaterNumber, Drawable color) {
        this.id = id;
        this.name = name;
        this.lastElectricNumber = lastElectricNumber;
        this.lastWaterNumber = lastWaterNumber;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLastElectricNumber() {
        return lastElectricNumber;
    }

    public void setLastElectricNumber(int lastElectricNumber) {
        this.lastElectricNumber = lastElectricNumber;
    }

    public int getLastWaterNumber() {
        return lastWaterNumber;
    }

    public void setLastWaterNumber(int lastWaterNumber) {
        this.lastWaterNumber = lastWaterNumber;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Drawable getColor() {
        return color;
    }

    public void setColor(Drawable color) {
        this.color = color;
    }
}
