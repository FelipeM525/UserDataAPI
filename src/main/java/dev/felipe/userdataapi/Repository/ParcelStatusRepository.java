package dev.felipe.userdataapi.Repository;

import dev.felipe.userdataapi.Domain.ParcelStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParcelStatusRepository extends JpaRepository<ParcelStatus, Long> {
}
