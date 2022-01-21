package pl.jkanclerz.uekstock.sales;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryReservationStorage {
    Map<String, Reservation> reservations;

    public InMemoryReservationStorage() {
        this.reservations = new HashMap<>();
    }

    public Optional<Reservation> load(String reservationId) {
        return Optional.ofNullable(reservations.get(reservationId));
    }

    public void save(Reservation reservation) {
        reservations.put(reservation.getId(), reservation);
    }
}
