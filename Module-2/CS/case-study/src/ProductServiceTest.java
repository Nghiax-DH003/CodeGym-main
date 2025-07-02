// File: test/java/ProductServiceTest.java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {

    private ProductService productService;

    @BeforeEach
    void setUp() {
        productService = ProductService.getInstance();
    }

    @Test
    void testAddAndFindById() {
        Product product = new Product(101L, "Sản phẩm Test", 99.99, 10);

        productService.add(product);

        Product foundProduct = productService.findById(101L);

        assertNotNull(foundProduct);
        assertEquals("Sản phẩm Test", foundProduct.getName());
        assertEquals(99.99, foundProduct.getPrice());
    }
}