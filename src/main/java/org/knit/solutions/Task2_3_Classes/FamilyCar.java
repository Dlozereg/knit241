package org.knit.solutions.Task2_3_Classes;

import java.util.HashMap;

public class FamilyCar implements Transport {
    static final String seatsAmount = "6";

    @Override
    public HashMap<String, String> getSpecifications() {
        HashMap<String, String> specification = new HashMap<>();
        specification.put("seatsAmount", seatsAmount);
        return specification;
    }
}
