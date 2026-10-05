import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VendingMachineTest {

    private VendingMachine machine;

    @BeforeEach
    void setUp() {
        // Creates a fresh vending machine before each test.
        machine = new VendingMachine();
    }

    @Test
    void constructorStartsEmpty() {
        // Tests that a new vending machine starts with no items
        // and a balance of $0.00.

        // Assert
        assertEquals(0.00, machine.getBalance(), 0.001);

        assertNull(machine.getItem("A"));
        assertNull(machine.getItem("B"));
        assertNull(machine.getItem("C"));
        assertNull(machine.getItem("D"));
    }

    @Test
    void addItemStoresItem() {
        // Tests that an item can be added to an empty valid slot.

        // Arrange
        VendingMachineItem item =
                new VendingMachineItem("Chips", 1.50);

        // Act
        machine.addItem(item, "A");

        // Assert
        assertEquals(item, machine.getItem("A"));
    }

    @Test
    void addItemOccupiedThrows() {
        // Tests that adding an item to an occupied slot throws an exception.

        // Arrange
        VendingMachineItem chips =
                new VendingMachineItem("Chips", 1.50);

        VendingMachineItem soda =
                new VendingMachineItem("Soda", 2.00);

        machine.addItem(chips, "A");

        // Act & Assert
        assertThrows(VendingMachineException.class, () -> {
            machine.addItem(soda, "A");
        });
    }
}