package ru.netology.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {

    Product book1 = new Book(1, "Алые паруса", 300, "А.Грин");
    Product book2 = new Book(10, "Вий", 320, "Н.Гоголь");
    Product book3 = new Book(15, "Муму", 155, "И.Тургенев");
    Product smartphone1 = new Smartphone(41, "IPhone 11", 56000, "Apple");
    Product smartphone2 = new Smartphone(322, "IPhone 13", 98000, "Apple");
    Product smartphone3 = new Smartphone(151, "Umidigi 1605", 56000, "Umi");

    @Test
    public void saveAllProduct() {
        ProductRepository repo = new ProductRepository();

        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);

        Product[] expected = {book1, book2, book3, smartphone1, smartphone2, smartphone3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void getArrayWithoutRemoveId() {
        ProductRepository repo = new ProductRepository();

        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);
        repo.removeById(book1.getId());

        Product[] expected = {book2, book3, smartphone1, smartphone2, smartphone3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }


}
