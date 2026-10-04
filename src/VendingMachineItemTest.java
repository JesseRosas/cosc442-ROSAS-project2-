import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class VendingMachineItemTest {

    @Test
    void itemStoresValues() {
        // Tests that a normal item stores its name and price correctly.

        // Arrange & Act
        VendingMachineItem item = new VendingMachineItem("Chips", 1.50);

        // Assert
        assertEquals("Chips", item.getName());
        assertEquals(1.50, item.getPrice(), 0.001);
    }

    @Test
    void itemZeroPriceAllowed() {
        // Tests the boundary value of $0.00, which should be a valid price.

        // Arrange & Act
        VendingMachineItem item = new VendingMachineItem("Free Item", 0.00);

        // Assert
        assertEquals(0.00, item.getPrice(), 0.001);
    }

    @Test
    void itemNegativePriceThrows() {
        // Tests that a negative price causes a VendingMachineException.

        // Arrange
        double price = -0.01;

        // Act & Assert
        assertThrows(VendingMachineException.class, () -> {
            new VendingMachineItem("Chips", price);
        });
    }
}