package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        task1();
        // task2();
        //task3();
    }
    public static void task1() {
        //        Дан массив записей: наименование товара, цена, сорт.
        //        Найти наибольшую цену товаров 1го или 2го сорта среди
        //        товаров, название которых содержит «высший».
        Goods tov1 = new Goods("хлеб", "первый", 50.0);
        Goods tov2 = new Goods(" мука", "второй", 80.0);
        Goods tov3 = new Goods("высший 2", "второй", 96.0);
        Goods tov4 = new Goods("высший 3", "третий", 70.0);
        List<Goods> listGoods = new ArrayList<>();
        listGoods.add(tov1);
        listGoods.add(tov2);
        listGoods.add(tov3);
        listGoods.add(tov4);

        Double maxPrice = 0.0;
        for (Goods t : listGoods) {
            if ((t.getName().contains("высший")) && ((t.getBrand().equals("первый")) || (t.getBrand().equals("второй")))) {
                if (t.getPrice() > maxPrice) {
                    maxPrice = t.getPrice();
                }

            }
        }
        if (maxPrice!=0.0) {
            System.out.println("наибольшая цена товаров 1го или 2го сорта среди\n" +
                    "товаров, название которых содержит «высший» " + maxPrice);
        }else{
            System.out.println("товаров 1го или 2го сорта среди\n" +
                    "товаров, название которых содержит «высший» - НЕТ");
        }
    }
    public static void task2() {
//        Сведения о товаре состоят из наименования, страны-производителя, сорта, веса, цены.
//        Получить наименования товаров заданного сорта с наименьшей ценой.

        PriceG tov1 = new PriceG("высший 1", "rus", "первый", 45.5, 70.0);
        PriceG tov2 = new PriceG(" мука", "evr",  "второй", 5.5, 80.0);
        PriceG tov3 = new PriceG("высший 2", "azi",  "первый", 4.5, 70.0);
        PriceG tov4 = new PriceG("высший 3", "vos",  "третий", 12.4, 60.0);
        List<PriceG> listPriceG = new ArrayList<>();
        listPriceG.add(tov1);
        listPriceG.add(tov2);
        listPriceG.add(tov3);
        listPriceG.add(tov4);
        Set<String> setName = new HashSet();

        Double minPrice = Double.MAX_VALUE;
        for (PriceG t : listPriceG) {
            if (t.getBrand().equals("первый")) {
                if (t.getPrice() < minPrice) {
                    minPrice = t.getPrice();
                }
            }
        }
        for (PriceG t : listPriceG) {
            if ((t.getBrand().equals("первый")) && (t.getPrice().equals(minPrice))) {
                setName.add(t.getName());
            }
        }

        if (minPrice!=0.0) {
            System.out.println("наименования товаров заданного сорта с наименьшей ценой " + setName.toString());
        }else{
            System.out.println("товаров 1го или 2го сорта среди\n" +
                    "товаров, название которых содержит «высший» - НЕТ");
        }
    }
    public static void task3() {
//    Сведения о книге состоят из названия, фамилии автора,
//    года издания и количества страниц, цены. Найти названия книг, в которых
//    простое количество страниц, фамилия автора содержит «А» и год издания не позднее 2010 г.

        Books tov1 = new Books("123", "Ad", 2019, 11, 70.0);
        Books tov2 = new Books("234", "Af", 2014, 7, 50.0);
        Books tov3 = new Books("345", "rus", 2001, 45, 80.0);
        Books tov4 = new Books("456", "rus", 2016, 45, 90.0);
        List<Books> listBooks = new ArrayList<>();
        listBooks.add(tov1);
        listBooks.add(tov2);
        listBooks.add(tov3);
        listBooks.add(tov4);
        Set<String> setName = new HashSet();


        for (Books t : listBooks) {
            if ((t.getSurname().contains("A"))&&(t.getYear()>2010)&&(isPrime(t.getPage())==true)) {
//                System.out.println(t);
                setName.add(t.getName());
            }
        }

        System.out.println("названия книг, в которых\n" +
                "простое количество страниц, фамилия автора содержит «А»\n" +
                "и год издания не позднее 2010 г" + setName.toString());
    }
    static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;

        if (n % 2 == 0 || n % 3 == 0)
            return false;

        for (int i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;

        return true;
    }

}