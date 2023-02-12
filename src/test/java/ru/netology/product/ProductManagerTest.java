package ru.netology.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {

    @Test
    public void addProduct() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        Product book1 = new Book(1, "Harry Potter", 300, "Rowling");
        Product book2 = new Book(10, "Вий", 320, "Н.Гоголь");
        Product book3 = new Book(15, "Муму", 155, "И.Тургенев");
        Product smartphone1 = new Smartphone(41, "IPhone 11", 56000, "Apple");
        Product smartphone2 = new Smartphone(322, "IPhone 13", 98000, "Apple");
        Product smartphone3 = new Smartphone(151, "Umidigi 1605", 56000, "Umi");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] expected = {book1, book2, book3, smartphone1, smartphone2, smartphone3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void toFindProductIfBeOneProduct() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        Product book1 = new Book(1, "Harry Potter", 300, "Rowling");
        Product book2 = new Book(10, "Вий", 320, "Н.Гоголь");
        Product book3 = new Book(15, "Муму", 155, "И.Тургенев");
        Product smartphone1 = new Smartphone(41, "IPhone 11", 56000, "Apple");
        Product smartphone2 = new Smartphone(322, "IPhone 13", 98000, "Apple");
        Product smartphone3 = new Smartphone(151, "Umidigi 1605", 56000, "Umi");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] expected = {book1};
        Product[] actual = manager.searchBy("Potter");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void toFindProductIfBeTwoProduct() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        Product book1 = new Book(1, "Harry Potter", 300, "Rowling");
        Product book2 = new Book(10, "Вий", 320, "Н.Гоголь");
        Product book3 = new Book(15, "Муму", 155, "И.Тургенев");
        Product smartphone1 = new Smartphone(41, "IPhone 11", 56000, "Apple");
        Product smartphone2 = new Smartphone(322, "IPhone 13", 98000, "Apple");
        Product smartphone3 = new Smartphone(151, "Umidigi 1605", 56000, "Umi");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] expected = {smartphone1, smartphone2};
        Product[] actual = manager.searchBy("IPhone");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void toFindProductIfBeLastProduct() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        Product book1 = new Book(1, "Harry Potter", 300, "Rowling");
        Product book2 = new Book(10, "Вий", 320, "Н.Гоголь");
        Product book3 = new Book(15, "Муму", 155, "И.Тургенев");
        Product smartphone1 = new Smartphone(41, "IPhone 11", 56000, "Apple");
        Product smartphone2 = new Smartphone(322, "IPhone 13", 98000, "Apple");
        Product smartphone3 = new Smartphone(151, "Umidigi 1605", 56000, "Umi");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] expected = {smartphone3};
        Product[] actual = manager.searchBy("Umidigi");

        Assertions.assertArrayEquals(expected, actual);
    }

}
