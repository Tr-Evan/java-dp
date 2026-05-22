package org.sebsy.grasps;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.sebsy.grasps.beans.Reservation;

public class ReservationControllerTest {

    /**
     * DELTA
     */
    private static final double DELTA = 0.0000001;

    @Test
    public void testCreerReservationTheatrePremium() {

        Params params = new Params();
        params.setDateReservation("20/11/2020 19:55:00");
        params.setNbPlaces(3);
        params.setIdentifiantClient("1");
        params.setTypeReservation("TH"); // Théâtre

        ReservationController controller = new ReservationController();
        Reservation reservation = controller.creerReservation(params);

        assertEquals(382.5, reservation.getTotal(), DELTA);
    }

    @Test
    public void testCreerReservationTheatreNonPremium() {

        Params params = new Params();
        params.setDateReservation("20/11/2020 19:55:00");
        params.setNbPlaces(3);
        params.setIdentifiantClient("3");
        params.setTypeReservation("TH"); // Théâtre

        ReservationController controller = new ReservationController();
        Reservation reservation = controller.creerReservation(params);

        assertEquals(450.0, reservation.getTotal(), DELTA);
    }

    @Test
    public void testCreerReservationCinemaPremium() {

        Params params = new Params();
        params.setDateReservation("21/11/2020 20:30:00");
        params.setNbPlaces(4);
        params.setIdentifiantClient("2");
        params.setTypeReservation("CI"); // Théâtre

        ReservationController controller = new ReservationController();
        Reservation reservation = controller.creerReservation(params);

        assertEquals(43.6, reservation.getTotal(), DELTA);
    }

    @Test
    public void testCreerReservationCinemaNonPremium() {

        Params params = new Params();
        params.setDateReservation("21/11/2020 20:30:00");
        params.setNbPlaces(4);
        params.setIdentifiantClient("3");
        params.setTypeReservation("CI"); // Théâtre

        ReservationController controller = new ReservationController();
        Reservation reservation = controller.creerReservation(params);

        assertEquals(43.6, reservation.getTotal(), DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreerReservationClientInexistant() {
        Params params = new Params();
        params.setDateReservation("20/11/2020 19:55:00");
        params.setNbPlaces(1);
        params.setIdentifiantClient("999");
        params.setTypeReservation("TH");

        ReservationController controller = new ReservationController();
        controller.creerReservation(params);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreerReservationTypeInconnu() {
        Params params = new Params();
        params.setDateReservation("20/11/2020 19:55:00");
        params.setNbPlaces(1);
        params.setIdentifiantClient("1");
        params.setTypeReservation("XX");

        ReservationController controller = new ReservationController();
        controller.creerReservation(params);
    }
}