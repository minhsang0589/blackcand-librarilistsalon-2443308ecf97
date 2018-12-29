package com.example.b202_26.listsalon.ItemList;

import com.example.b202_26.listsalon.ContentItem.Relationships;

import java.util.ArrayList;

public class ItemListActivity1 {

    public String _id;
    public String user_salon;
    public String name_salon;
    public String phone;
    public String address;
    public String city;
    public String description;
    public String opening_hours;
    public String location_lat;
    public String location_lon;
    public Relationships relationships;
    public ArrayList<String> image_salon = null;

    public ItemListActivity1(String _id, String user_salon, String name_salon, String phone, String address, String city, String description,
                             String opening_hours, String location_lat, String location_lon, Relationships relationships, ArrayList<String> image_salon) {
        this._id = _id;
        this.user_salon = user_salon;
        this.name_salon = name_salon;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.description = description;
        this.opening_hours = opening_hours;
        this.location_lat = location_lat;
        this.location_lon = location_lon;
        this.relationships = relationships;
        this.image_salon = image_salon;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUser_salon() {
        return user_salon;
    }

    public void setUser_salon(String user_salon) {
        this.user_salon = user_salon;
    }

    public String getName_salon() {
        return name_salon;
    }

    public void setName_salon(String name_salon) {
        this.name_salon = name_salon;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOpening_hours() {
        return opening_hours;
    }

    public void setOpening_hours(String opening_hours) {
        this.opening_hours = opening_hours;
    }

    public String getLocation_lat() {
        return location_lat;
    }

    public void setLocation_lat(String location_lat) {
        this.location_lat = location_lat;
    }

    public String getLocation_lon() {
        return location_lon;
    }

    public void setLocation_lon(String location_lon) {
        this.location_lon = location_lon;
    }

    public Relationships getRelationships() {
        return relationships;
    }

    public void setRelationships(Relationships relationships) {
        this.relationships = relationships;
    }

    public ArrayList<String> getImage_salon() {
        return image_salon;
    }

    public void setImage_salon(ArrayList<String> image_salon) {
        this.image_salon = image_salon;
    }
}
