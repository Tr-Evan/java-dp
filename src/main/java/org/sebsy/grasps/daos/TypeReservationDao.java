package org.sebsy.grasps.daos;

import org.sebsy.grasps.beans.TypeReservation;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TypeReservationDao {

    private static TypeReservation[] types = {
            new TypeReservation(1L, "TH", 150.0, 15.0),
            new TypeReservation(2L, "CI", 10.9, 0.0)
    };

    public TypeReservation extraireTypeReservation(String type) {
        Optional<TypeReservation> opt = Arrays.asList(types).stream().filter(t -> t.getType().equals(type)).findAny();
        return opt.orElse(null);
    }
}
