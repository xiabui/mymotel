package me.monla.mymotel.models;

public class MotelModel {
    int id;
    String motelName;
    int numberOfRoom;
    int roomCost;
    int electricCost;
    int waterCost;
    int serviceCost;
    int rentedRoom;
    int paymentRoom;

    public MotelModel(int id, String motelName, int numberOfRoom, int roomCost, int electricCost, int waterCost, int serviceCost, int rentedRoom, int paymentRoom) {
        this.id = id;
        this.motelName = motelName;
        this.numberOfRoom = numberOfRoom;
        this.roomCost = roomCost;
        this.electricCost = electricCost;
        this.waterCost = waterCost;
        this.serviceCost = serviceCost;
        this.rentedRoom = rentedRoom;
        this.paymentRoom = paymentRoom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMotelName() {
        return motelName;
    }

    public void setMotelName(String motelName) {
        this.motelName = motelName;
    }

    public int getNumberOfRoom() {
        return numberOfRoom;
    }

    public void setNumberOfRoom(int numberOfRoom) {
        this.numberOfRoom = numberOfRoom;
    }

    public int getRoomCost() {
        return roomCost;
    }

    public void setRoomCost(int roomCost) {
        this.roomCost = roomCost;
    }

    public int getElectricCost() {
        return electricCost;
    }

    public void setElectricCost(int electricCost) {
        this.electricCost = electricCost;
    }

    public int getWaterCost() {
        return waterCost;
    }

    public void setWaterCost(int waterCost) {
        this.waterCost = waterCost;
    }

    public int getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(int serviceCost) {
        this.serviceCost = serviceCost;
    }

    public int getRentedRoom() {
        return rentedRoom;
    }

    public void setRentedRoom(int rentedRoom) {
        this.rentedRoom = rentedRoom;
    }

    public int getPaymentRoom() {
        return paymentRoom;
    }

    public void setPaymentRoom(int paymentRoom) {
        this.paymentRoom = paymentRoom;
    }
}
