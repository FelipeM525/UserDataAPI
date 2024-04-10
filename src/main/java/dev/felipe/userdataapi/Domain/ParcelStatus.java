package dev.felipe.userdataapi.Domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "parcel_status")
public class ParcelStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "parcel_id")
    private Parcel parcel;
    private LocalDateTime updateTime;
    private String status;

    public ParcelStatus() {
    }

    public Long getId() {
        return id;
    }

    public Parcel getParcel() {
        return parcel;
    }

    public void setParcel(Parcel parcel) {
        this.parcel = parcel;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ParcelStatus{" +
                "id=" + id +
                ", parcel=" + parcel +
                ", updateTime=" + updateTime +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParcelStatus that = (ParcelStatus) o;
        return Objects.equals(id, that.id) && Objects.equals(parcel, that.parcel) && Objects.equals(updateTime, that.updateTime) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, parcel, updateTime, status);
    }
}
