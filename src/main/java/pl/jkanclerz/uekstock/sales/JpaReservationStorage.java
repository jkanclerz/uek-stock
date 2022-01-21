package pl.jkanclerz.uekstock.sales;

import pl.jkanclerz.uekstock.sales.ordering.Reservation;
import pl.jkanclerz.uekstock.sales.ordering.ReservationRepository;
import pl.jkanclerz.uekstock.sales.ordering.ReservationStorage;

import java.util.Optional;

public class JpaReservationStorage implements ReservationStorage {

    private ReservationRepository reservationRepository;

    public JpaReservationStorage(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Optional<Reservation> load(String reservationId) {
        return reservationRepository.findById(reservationId);
    }

    @Override
    public void save(Reservation reservation) {
        reservationRepository.save(reservation);
    }
}
