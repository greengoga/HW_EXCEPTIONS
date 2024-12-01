package ru.netology.hw_exeptions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Period;


public class ProductTest {

    @Test
    public void shouldThrowException() {
        ShopRepository rep = new ShopRepository();
        Product product = new Product(1, "sum product", 1_000);
        Product product2 = new Product(2, "sum product", 10_000);
        Product product3 = new Product(3, "sum product", 100_000);


        rep.add(product);
        rep.add(product2);
        rep.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            rep.removeById(5);
        });
    }

    @Test
    public void shouldRemoveExistingElement() {
        ShopRepository rep = new ShopRepository();
        Product product = new Product(1, "sum product", 1_000);
        Product product2 = new Product(2, "sum product", 10_000);
        Product product3 = new Product(3, "sum product", 100_000);

        rep.add(product);
        rep.add(product2);
        rep.add(product3);
        rep.removeById(1);

        Product[] expected = {product2, product3};
        Product[] actual = rep.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowAlreadyExistsException() {
        ShopRepository rep = new ShopRepository();
        Product product = new Product(1, "sum product", 1_000);
        Product product2 = new Product(2, "sum product", 10_000);
        Product product3 = new Product(3, "sum product", 100_000);

        rep.add(product);
        rep.add(product2);
        rep.add(product3);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            rep.add(product);
        });
    }

    @Test
    public void shouldAddSuccessfully() {
        ShopRepository rep = new ShopRepository();
        Product product = new Product(1, "sum product", 1_000);
        Product product2 = new Product(2, "sum product", 10_000);
        Product product3 = new Product(3, "sum product", 100_000);

        rep.add(product);
        Product[] expected = {product};
        Product[] actual = rep.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

}
