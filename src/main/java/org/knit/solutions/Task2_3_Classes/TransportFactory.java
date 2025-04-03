package org.knit.solutions.Task2_3_Classes;

public class TransportFactory {
    public static Transport createTransport(String tripType){
        return switch (tripType) {
            case "business" -> new BusinessCar();
            case "family" -> new FamilyCar();
            case "delivery" -> new Motorbike();
            default -> {
                System.out.println("not a valid trip type");
                yield null;
            }
        };
    }
}
