package org.sebsy.grasps;

import org.sebsy.grasps.beans.Client;
import org.sebsy.grasps.beans.Reservation;
import org.sebsy.grasps.beans.TypeReservation;
import org.sebsy.grasps.daos.ClientDao;
import org.sebsy.grasps.daos.TypeReservationDao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;

/**
 * Controlleur qui prend en charge la gestion des réservations client
 */
public class ReservationController {

    private static final String DATE_PATTERN = "dd/MM/yyyy HH:mm:ss";

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_PATTERN);

    /**
     * DAO permettant d'accéder à la table des clients
     */
    private ClientDao clientDao = new ClientDao();

    /**
     * DAO permettant d'accéder à la table des types de réservation
     */
    private TypeReservationDao typeReservationDao = new TypeReservationDao();

    /**
     * Méthode qui créée une réservation pour un client à partir des informations transmises
     *
     * @param params contient toutes les infos permettant de créer une réservation
     * @return Reservation
     */
    public Reservation creerReservation(Params params) {
        Objects.requireNonNull(params, "params must not be null");

        String identifiantClient = params.getIdentifiantClient();
        String dateReservationStr = params.getDateReservation();
        String typeReservation = params.getTypeReservation();
        int nbPlaces = params.getNbPlaces();

        if (identifiantClient == null || identifiantClient.isBlank()) {
            throw new IllegalArgumentException("Identifiant client requis");
        }
        if (dateReservationStr == null || dateReservationStr.isBlank()) {
            throw new IllegalArgumentException("Date de réservation requise");
        }
        if (typeReservation == null || typeReservation.isBlank()) {
            throw new IllegalArgumentException("Type de réservation requis");
        }
        if (nbPlaces <= 0) {
            throw new IllegalArgumentException("Le nombre de places doit être positif");
        }

        LocalDateTime dateReservation = toDate(dateReservationStr);

        Client client = clientDao.extraireClient(identifiantClient);
        if (client == null) {
            throw new IllegalArgumentException("Client introuvable : " + identifiantClient);
        }

        TypeReservation type = typeReservationDao.extraireTypeReservation(typeReservation);
        if (type == null) {
            throw new IllegalArgumentException("Type de réservation introuvable : " + typeReservation);
        }

        Reservation reservation = new Reservation(dateReservation);
        reservation.setNbPlaces(nbPlaces);
        reservation.setClient(client);

        client.getReservations().add(reservation);

        reservation.setTotal(calculateTotal(type, nbPlaces, client.isPremium()));
        return reservation;
    }

    private double calculateTotal(TypeReservation type, int nbPlaces, boolean premium) {
        double total = type.getMontant() * nbPlaces;
        return premium ? total * (1 - type.getReductionPourcent() / 100.0) : total;
    }

    /**
     * Transforme une date au format String en {@link LocalDateTime}
     *
     * @param dateStr date au format String
     * @return LocalDateTime
     */
    private LocalDateTime toDate(String dateStr) {
        try {
            return LocalDateTime.parse(dateStr, formatter);
        } catch (DateTimeParseException ex) {
            throw new IllegalArgumentException("Format de date invalide : " + dateStr, ex);
        }
    }
}
