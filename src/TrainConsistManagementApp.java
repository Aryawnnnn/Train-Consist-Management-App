class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

class GoodsBogie {
    String shape;
    String cargo;

    public GoodsBogie(String shape) {
        this.shape = shape;
    }

    public void assignCargo(String cargo) {
        try {
            // Safety rule: Petroleum only allowed in Cylindrical bogies
            if (cargo.equalsIgnoreCase("Petroleum") && !shape.equalsIgnoreCase("Cylindrical")) {
                throw new CargoSafetyException(
                        "Unsafe cargo assignment: Petroleum cannot be assigned to " + shape + " bogie");
            }
            this.cargo = cargo;
            System.out.println("Cargo " + cargo + " assigned to " + shape + " bogie successfully.");
        } catch (CargoSafetyException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Cargo assignment validation completed for " + shape + " bogie.\n");
        }
    }

    @Override
    public String toString() {
        return shape + " bogie carrying: " + (cargo != null ? cargo : "No cargo");
    }
}

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        GoodsBogie b1 = new GoodsBogie("Cylindrical");
        GoodsBogie b2 = new GoodsBogie("Rectangular");

        // Safe assignment
        b1.assignCargo("Petroleum");

        // Unsafe assignment
        b2.assignCargo("Petroleum");

        // Another safe assignment
        b2.assignCargo("Coal");

        // Display final status
        System.out.println(b1);
        System.out.println(b2);
    }
}