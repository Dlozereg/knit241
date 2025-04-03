package org.knit.solutions.Task2_3_Classes;

import java.util.HashMap;

public class BusinessCar implements Transport {
    static final String interiorComfortableLevel = "high";
    static final String seatsMaterial = "leather";

    @Override
    public HashMap<String, String> getSpecifications() {
        HashMap<String, String> specification = new HashMap<>();
        specification.put("interiorComfortableLevel", interiorComfortableLevel);
        specification.put("seatsMaterial", seatsMaterial);
        return specification;
    }
}
