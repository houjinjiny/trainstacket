package com.itdr.pojo;

public class Train {
    private Integer id;
    private String train_number;
    private String train_type;
    private String start_station;
    private String last_station;
    private String start_time;
    private String last_time;
    private String seat_type;
    private double price;
    private Integer inventory;
    public Train(){}

    public Train(Integer id, String train_number, String train_type, String start_station, String last_station, String start_time, String last_time, String seat_type, double price, Integer inventory) {
        this.id = id;
        this.train_number = train_number;
        this.train_type = train_type;
        this.start_station = start_station;
        this.last_station = last_station;
        this.start_time = start_time;
        this.last_time = last_time;
        this.seat_type = seat_type;
        this.price = price;
        this.inventory = inventory;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTrain_number() {
        return train_number;
    }

    public void setTrain_number(String train_number) {
        this.train_number = train_number;
    }

    public String getTrain_type() {
        return train_type;
    }

    public void setTrain_type(String train_type) {
        this.train_type = train_type;
    }

    public String getStart_station() {
        return start_station;
    }

    public void setStart_station(String start_station) {
        this.start_station = start_station;
    }

    public String getLast_station() {
        return last_station;
    }

    public void setLast_station(String last_station) {
        this.last_station = last_station;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getLast_time() {
        return last_time;
    }

    public void setLast_time(String last_time) {
        this.last_time = last_time;
    }

    public String getSeat_type() {
        return seat_type;
    }

    public void setSeat_type(String seat_type) {
        this.seat_type = seat_type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }
}
