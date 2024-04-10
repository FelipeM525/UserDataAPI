package dev.felipe.userdataapi.Repository;

import dev.felipe.userdataapi.Domain.Parcel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParcelRepository extends JpaRepository<Parcel, Long>{
}
