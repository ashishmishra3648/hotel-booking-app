package Jar.service;

import Jar.model.Reservation;
import Jar.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation createReservation(Reservation reservation) {
        reservation.setReservationDate(LocalDateTime.now());
        return reservationRepository.save(reservation);
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> getReservationById(Integer id) {
        return reservationRepository.findById(id);
    }

    public Optional<Integer> getRoomNumber(Integer reservationId, String guestName) {
        Optional<Reservation> reservation = reservationRepository.findByIdAndGuestName(reservationId, guestName);
        return reservation.map(Reservation::getRoomNumber);
    }

    public Reservation updateReservation(Integer id, Reservation updatedReservation) {
        return reservationRepository.findById(id)
                .map(reservation -> {
                    reservation.setGuestName(updatedReservation.getGuestName());
                    reservation.setRoomNumber(updatedReservation.getRoomNumber());
                    reservation.setContactNumber(updatedReservation.getContactNumber());
                    return reservationRepository.save(reservation);
                })
                .orElseThrow(() -> new RuntimeException("Reservation not found with id: " + id));
    }

    public boolean deleteReservation(Integer id) {
        if (reservationRepository.existsById(id)) {
            reservationRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean reservationExists(Integer id) {
        return reservationRepository.existsById(id);
    }
}
