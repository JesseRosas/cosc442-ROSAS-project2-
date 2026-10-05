import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @Test
    void slotInvalidCodeThrows() {
        // Cannot add an item to an invalid slot.
        // This tests that adding an item with an invalid slot code throws an exception.

        // Arrange
        VendingMachineItem item =
                new VendingMachineItem("Chips", 1.50);

        // Act & Assert
        assertThrows(VendingMachineException.class, () -> {
            machine.addItem(item, "E");
        });
    }

    @Test
    void getItemReturnsItem() {
        // Tests that getItem() returns the item stored in the requested slot.

        // Arrange
        VendingMachineItem item =
                new VendingMachineItem("Chips", 1.50);

        machine.addItem(item, "B");

        // Act
        VendingMachineItem result = machine.getItem("B");

        // Assert
        assertEquals(item, result);
    }

    @Test
    void getItemEmptyReturnsNull() {
        // Tests that getItem() returns null for an empty valid slot.

        // Act
        VendingMachineItem result = machine.getItem("C");

        // Assert
        assertNull(result);
    }

    @Test
    void getItemSlotInvalidCodeThrows() {
        // Tests that getItem() throws an exception when 
        // trying to get an item from an invalid slot code.

        // Act & Assert
        assertThrows(VendingMachineException.class, () -> {
            machine.getItem("E");
        });
    }

    @Test
    void removeItemReturnsItem() {
        // Tests that removeItem() returns and removes an item from a valid slot.
        // valid occupied slot.

        // Arrange
        VendingMachineItem item =
                new VendingMachineItem("Chips", 1.50);

        machine.addItem(item, "A");

        // Act
        VendingMachineItem removedItem = machine.removeItem("A");

        // Assert
        assertEquals(item, removedItem);
        assertNull(machine.getItem("A"));
    }

    @Test
    void removeItemEmptyThrows() {
        // Tests that removing an item from an empty slot throws an exception.
        // valid but empty slot.

        // Act & Assert
        assertThrows(VendingMachineException.class, () -> {
            machine.removeItem("C");
        });
    }

    @Test
    void removeItemInvalidCodeThrows() {
        // Tests that removeItem() throws an exception for an invalid slot code.
        // invalid slot code.

        // Act & Assert
        assertThrows(VendingMachineException.class, () -> {
            machine.removeItem("E");
        });
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.00, 0.01, 0.99, 1.00, 1.01, 25.00})
    void insertMoneyValidAmounts(double amount) {
        // Tests several valid amounts, including values around important boundaries.

        // Act
        machine.insertMoney(amount);

        // Assert
        assertEquals(amount, machine.getBalance(), 0.001);
    }
}