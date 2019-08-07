package com.jonathan.pruebapracticasunsetswh.modelo;

import com.orm.SugarRecord;

public class Sitios extends SugarRecord {
    public int idSitio;
    public int orderSitio;
    public String name;
    public String address;
    public String description;
    public Double lat;
    public Double lon;
    public String type;
    public int capacity;
    public int bikes;
    public String places;
    public String picture;
    public String bikesState;
    public String placesState;
    public int closed;
    public int cdo;
    public int idZona;

    public Sitios() {
    }

    public Sitios(int idSitio, int orderSitio, String name, String address, String description, Double lat, Double lon, String type, int capacity, int bikes, String places, String picture, String bikesState, String placesState, int closed, int cdo, int idZona) {
        this.idSitio = idSitio;
        this.orderSitio = orderSitio;
        this.name = name;
        this.address = address;
        this.description = description;
        this.lat = lat;
        this.lon = lon;
        this.type = type;
        this.capacity = capacity;
        this.bikes = bikes;
        this.places = places;
        this.picture = picture;
        this.bikesState = bikesState;
        this.placesState = placesState;
        this.closed = closed;
        this.cdo = cdo;
        this.idZona = idZona;
    }

    public int getIdZona() {
        return idZona;
    }

    public void setIdZona(int idZona) {
        this.idZona = idZona;
    }

    public int getIdSitio() {
        return idSitio;
    }

    public void setIdSitio(int idSitio) {
        this.idSitio = idSitio;
    }

    public int getOrderSitio() {
        return orderSitio;
    }

    public void setOrderSitio(int order) {
        this.orderSitio = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getBikes() {
        return bikes;
    }

    public void setBikes(int bikes) {
        this.bikes = bikes;
    }

    public String getPlaces() {
        return places;
    }

    public void setPlaces(String places) {
        this.places = places;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getBikesState() {
        return bikesState;
    }

    public void setBikesState(String bikesState) {
        this.bikesState = bikesState;
    }

    public String getPlacesState() {
        return placesState;
    }

    public void setPlacesState(String placesState) {
        this.placesState = placesState;
    }

    public int getClosed() {
        return closed;
    }

    public void setClosed(int closed) {
        this.closed = closed;
    }

    public int getCdo() {
        return cdo;
    }

    public void setCdo(int cdo) {
        this.cdo = cdo;
    }
}
