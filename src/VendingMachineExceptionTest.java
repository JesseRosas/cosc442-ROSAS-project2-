import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class VendingMachineExceptionTest {

    @Test
    void exceptionStoresMessage() {
        // Tests that the exception stores the message passed to its constructor.

        // Arrange
        String message = "Test error";

        // Act
        VendingMachineException exception =
                new VendingMachineException(message);

        // Assert
        assertEquals(message, exception.getMessage());
    }

    @Test
    void defaultExceptionHasNoMessage() {
        // Tests that the default constructor creates an exception with no message.

        // Arrange & Act
        VendingMachineException exception =
                new VendingMachineException();

        // Assert
        assertNull(exception.getMessage());
    }

}