package dev.felipe.userdataapi.Domain;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "parcel")
public class Parcel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String trackingCode;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User owner;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    private String recipient;
    private String recipientAddress;
    @OneToMany(mappedBy = "parcel")
    private List<ParcelStatus> parcelStats;

    public Parcel() {
    }

    public Long getId() {
        return id;
    }

    public String getTrackingCode() {
        return trackingCode;
    }

    public void setTrackingCode(String trackingCode) {
        this.trackingCode = trackingCode;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getRecipientAddress() {
        return recipientAddress;
    }

    public void setRecipientAddress(String recipientAddress) {
        this.recipientAddress = recipientAddress;
    }

    public List<ParcelStatus> getParcelStats() {
        return parcelStats;
    }

    public void setParcelStats(List<ParcelStatus> parcelStats) {
        this.parcelStats = parcelStats;
    }

    @Override
    public String toString() {
        return "Parcel{" +
                "id=" + id +
                ", trackingCode=" + trackingCode +
                ", owner=" + owner +
                ", order=" + order +
                ", recipient='" + recipient + '\'' +
                ", recipientAddress='" + recipientAddress + '\'' +
                ", parcelStats=" + parcelStats +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parcel parcel = (Parcel) o;
        return Objects.equals(id, parcel.id) && Objects.equals(trackingCode, parcel.trackingCode) && Objects.equals(owner, parcel.owner) && Objects.equals(order, parcel.order) && Objects.equals(recipient, parcel.recipient) && Objects.equals(recipientAddress, parcel.recipientAddress) && Objects.equals(parcelStats, parcel.parcelStats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, trackingCode, owner, order, recipient, recipientAddress, parcelStats);
    }
}
