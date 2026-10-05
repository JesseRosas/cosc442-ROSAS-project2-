import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class VendingMachineTest {

    @Test
    void constructorStartsEmpty() {
        // Tests that a new vending machine starts with no items
        // and a balance of $0.00.

        // Arrange & Act
        VendingMachine machine = new VendingMachine();

        // Assert
        assertEquals(0.00, machine.getBalance(), 0.001);

        assertNull(machine.getItem("A"));
        assertNull(machine.getItem("B"));
        assertNull(machine.getItem("C"));
        assertNull(machine.getItem("D"));
    }
}