package org.sebsy.grasps.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "RESERVATION")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "DATE")
    private LocalDateTime date;

    @Column(name = "NB_PLACES")
    private int nbPlaces;

    @Column(name = "TOTAL")
    private double total;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENT")
    private Client client;

    public Reservation() {

    }

    public Reservation(LocalDateTime date) {
        super();
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter
     *
     * @return the date
     */
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * Setter
     *
     * @param date the date to set
     */
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    /**
     * Getter
     *
     * @return the nbPlaces
     */
    public int getNbPlaces() {
        return nbPlaces;
    }

    /**
     * Setter
     *
     * @param nbPlaces the nbPlaces to set
     */
    public void setNbPlaces(int nbPlaces) {
        this.nbPlaces = nbPlaces;
    }

    /**
     * Getter
     *
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * Setter
     *
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * Getter
     *
     * @return the client
     */
    public Client getClient() {
        return client;
    }

    /**
     * Setter
     *
     * @param client the client to set
     */
    public void setClient(Client client) {
        this.client = client;
    }
}
