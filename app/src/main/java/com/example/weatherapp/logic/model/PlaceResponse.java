package com.example.weatherapp.logic.model;

import java.util.ArrayList;
import java.util.List;

public class PlaceResponse {

    private String status = new String();
    private List<Place> places = new ArrayList<>();
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public List<Place> getPlaces() {
        return places;
    }
    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    public class Place {
        private String name;
        private String formatted_address;
        private Location location;

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

        public String getFormatted_address() {
            return formatted_address;
        }
        public void setFormatted_address(String formatted_address) {
            this.formatted_address = formatted_address;
        }

        public Location getLocation() {
            return location;
        }
        public void setLocation(Location location) {
            this.location = location;
        }
    }

    public static class Location {
        private String lat;
        private String lng;
        public Location(String lng, String lat) {
            this.lat = lat;
            this.lng = lng;
        }
        public String getLat() {
            return lat;
        }
        public void setLat(String lat) {
            this.lat = lat;
        }
        public String getLng() {
            return lng;
        }
        public void setLng(String lng) {
            this.lng = lng;
        }
    }
}
