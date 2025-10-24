package Jar.repository;

import Jar.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    @Query("SELECT r FROM Reservation r WHERE r.reservationId = :id AND r.guestName = :guestName")
    Optional<Reservation> findByIdAndGuestName(@Param("id") Integer id, @Param("guestName") String guestName);

    boolean existsByRoomNumber(Integer roomNumber);
}
