package Jar.controller;

import Jar.model.Reservation;
import Jar.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservations")
@CrossOrigin(origins = "*")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public ResponseEntity<Map<String, Object>> createReservation(@RequestBody Reservation reservation) {
        Map<String, Object> response = new HashMap<>();
        try {
            Reservation savedReservation = reservationService.createReservation(reservation);
            response.put("success", true);
            response.put("message", "Reservation created successfully!");
            response.put("data", savedReservation);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "Failed to create reservation: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations() {
        List<Reservation> reservations = reservationService.getAllReservations();
        return ResponseEntity.ok(reservations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getReservationById(@PathVariable Integer id) {
        Map<String, Object> response = new HashMap<>();
        Optional<Reservation> reservation = reservationService.getReservationById(id);

        if (reservation.isPresent()) {
            response.put("success", true);
            response.put("data", reservation.get());
            return ResponseEntity.ok(response);
        } else {
            response.put("success", false);
            response.put("message", "Reservation not found with id: " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @GetMapping("/room")
    public ResponseEntity<Map<String, Object>> getRoomNumber(
            @RequestParam Integer reservationId,
            @RequestParam String guestName) {

        Map<String, Object> response = new HashMap<>();
        Optional<Integer> roomNumber = reservationService.getRoomNumber(reservationId, guestName);

        if (roomNumber.isPresent()) {
            response.put("success", true);
            response.put("roomNumber", roomNumber.get());
            response.put("message", "Room number found!");
            return ResponseEntity.ok(response);
        } else {
            response.put("success", false);
            response.put("message", "Reservation not found for the given ID and guest name");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateReservation(
            @PathVariable Integer id,
            @RequestBody Reservation reservation) {

        Map<String, Object> response = new HashMap<>();
        try {
            Reservation updatedReservation = reservationService.updateReservation(id, reservation);
            response.put("success", true);
            response.put("message", "Reservation updated successfully!");
            response.put("data", updatedReservation);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            response.put("success", false);
            response.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteReservation(@PathVariable Integer id) {
        Map<String, Object> response = new HashMap<>();
        boolean deleted = reservationService.deleteReservation(id);

        if (deleted) {
            response.put("success", true);
            response.put("message", "Reservation deleted successfully!");
            return ResponseEntity.ok(response);
        } else {
            response.put("success", false);
            response.put("message", "Reservation not found with id: " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}
