package dev.felipe.userdataapi.Request;

import dev.felipe.userdataapi.Domain.Parcel;

import java.time.LocalDateTime;
import java.util.List;

public class OrderRequest {
    private String owner;
    private LocalDateTime orderDate;
    private List<Parcel> parcels;


    public String getOwner() {
        return owner;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public List<Parcel> getParcels() {
        return parcels;
    }

}
