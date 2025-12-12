package Jar.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private Integer reservationId;

    @Column(name = "guest_name", nullable = false)
    private String guestName;

    @Column(name = "room_number", nullable = false)
    private Integer roomNumber;

    @Column(name = "contact_number", nullable = false)
    private String contactNumber;

    @Column(name = "reservation_date")
    private LocalDateTime reservationDate;

    public Reservation() {
    }

    public Reservation(String guestName, Integer roomNumber, String contactNumber) {
        this.guestName = guestName;
        this.roomNumber = roomNumber;
        this.contactNumber = contactNumber;
        this.reservationDate = LocalDateTime.now();
    }
    public Integer getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDateTime reservationDate) {
        this.reservationDate = reservationDate;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId=" + reservationId +
                ", guestName='" + guestName + '\'' +
                ", roomNumber=" + roomNumber +
                ", contactNumber='" + contactNumber + '\'' +
                ", reservationDate=" + reservationDate +
                '}';
    }
}
