package sample;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Vycheslav
 */
public class ShoppingCartTest {

    @Test
    public void testAppendFormatted() {
        StringBuilder sb = new StringBuilder();
        ShoppingCart.appendFormatted(sb, "SomeLine", 0, 14);
        // Метод додає пробіли до і після, а також один пробіл в кінці
        assertEquals("   SomeLine    ", sb.toString());

        sb = new StringBuilder();
        ShoppingCart.appendFormatted(sb, "SomeLine", 0, 15);
        assertEquals("   SomeLine     ", sb.toString());
    }

    @Test
    public void testCalculateDiscount() {
        assertEquals(80, ShoppingCart.calculateDiscount(ShoppingCart.ItemType.SALE, 500));
        assertEquals(73, ShoppingCart.calculateDiscount(ShoppingCart.ItemType.SALE, 30));
        assertEquals(0, ShoppingCart.calculateDiscount(ShoppingCart.ItemType.NEW, 20));
        assertEquals(50, ShoppingCart.calculateDiscount(ShoppingCart.ItemType.SECOND_FREE, 2));
    }
}