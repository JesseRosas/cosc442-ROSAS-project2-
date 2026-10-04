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

}