import java.util.*;

class OutOfStockException extends Exception {
    int shortfall;

    OutOfStockException(int shortfall) {
        super("Insufficient stock. Shortfall: " + shortfall);
        this.shortfall = shortfall;
    }

    int getShortfall() {
        return shortfall;
    }
}

class InvalidQuantityException extends Exception {
    InvalidQuantityException(String message) {
        super(message);
    }
}

class Warehouse {
    int stock = 10;

    void issue(String item, int qty)
            throws OutOfStockException, InvalidQuantityException {

        if (qty <= 0) {
            throw new InvalidQuantityException(
                    "Quantity must be greater than zero");
        }

        if (qty > stock) {
            throw new OutOfStockException(qty - stock);
        }

        stock -= qty;
        System.out.println("Issued " + qty + " units of " + item);
        System.out.println("Remaining stock: " + stock);
    }
}

public class p8_partA_2 {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();

        String[][] requests = {
            {"Pen", "3"},
            {"Book", "12"},
            {"Pencil", "0"},
            {"Notebook", "4"},
            {"Eraser", "-2"}
        };

        for (String[] request : requests) {
            String item = request[0];
            int qty = Integer.parseInt(request[1]);

            System.out.println("\nRequest: " + item + ", Quantity: " + qty);

            try {
                warehouse.issue(item, qty);
            } catch (OutOfStockException e) {
                System.out.println(e.getMessage());
                System.out.println("Shortfall: " + e.getShortfall());
            } catch (InvalidQuantityException e) {
                System.out.println("Invalid quantity: " + e.getMessage());
            }
        }

        System.out.println("\nAll requests processed.");
    }
}
