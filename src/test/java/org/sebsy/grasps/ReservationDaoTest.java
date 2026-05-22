package org.sebsy.grasps;

import org.junit.Test;
import org.sebsy.grasps.beans.Client;
import org.sebsy.grasps.beans.Reservation;
import org.sebsy.grasps.daos.ReservationDao;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ReservationDaoTest {

    @Test
    public void testSaveAndFindByClientId() {
        ReservationDao dao = new ReservationDao();
        Client client = new Client("10", false);

        Reservation reservation = new Reservation(LocalDateTime.now());
        reservation.setClient(client);
        reservation.setNbPlaces(2);
        reservation.setTotal(300.0);

        Reservation saved = dao.save(reservation);

        assertNotNull(saved.getId());

        List<Reservation> found = dao.findByClientId("10");
        assertEquals(1, found.size());
        assertEquals(saved, found.get(0));
    }
}
