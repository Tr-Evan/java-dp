package org.sebsy.grasps.daos;

import org.sebsy.grasps.beans.Reservation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class ReservationDao {

    private final List<Reservation> reservations = new ArrayList<>();
    private final AtomicLong ID_SEQUENCE = new AtomicLong(1);

    public Reservation save(Reservation reservation) {
        if (reservation == null) {
            throw new IllegalArgumentException("Reservation doit être fournie");
        }
        if (reservation.getId() == null) {
            reservation.setId(ID_SEQUENCE.getAndIncrement());
        }
        reservations.add(reservation);
        return reservation;
    }

    public List<Reservation> findAll() {
        return Collections.unmodifiableList(reservations);
    }

    public List<Reservation> findByClientId(String clientId) {
        if (clientId == null || clientId.trim().isEmpty()) {
            return Collections.emptyList();
        }
        return reservations.stream()
                .filter(r -> r.getClient() != null && clientId.equals(r.getClient().getIdentifiantClient()))
                .collect(Collectors.toList());
    }
}
