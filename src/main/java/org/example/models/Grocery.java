package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {


    public static ArrayList<String> groceryList = new ArrayList<>();

    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n0 - Çıkış");
            System.out.println("1 - Ürün Ekle");
            System.out.println("2 - Ürün Çıkar");
            System.out.print("Seçimin: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    running = false;
                    System.out.println("Uygulama kapandı 📴");
                    break;

                case 1:
                    System.out.print("Eklenmesini istediğiniz elemanları giriniz: ");
                    String addInput = scanner.nextLine();
                    addItems(addInput);
                    break;

                case 2:
                    System.out.print("Cıkarılmasını istediğiniz elemanları giriniz: ");
                    String removeInput = scanner.nextLine();
                    removeItems(removeInput);
                    break;

                default:
                    System.out.println("Geçersiz seçim ❌");
            }
        }
    }
    public static void addItems(String input) {
        String[] items = input.split(",");

        for (String item : items) {
            String trimmed = item.trim().toLowerCase();

            if (!checkItemIsInList(trimmed)) {
                groceryList.add(trimmed);
                System.out.println(trimmed + " eklendi ✅");
            } else {
                System.out.println(trimmed + " zaten listede ⚠️");
            }
        }

        printSorted();
    }

    public static void removeItems(String input) {
        String[] items = input.split(",");

        for (String item : items) {
            String trimmed = item.trim().toLowerCase();

            if (checkItemIsInList(trimmed)) {
                groceryList.remove(trimmed);
                System.out.println(trimmed + " çıkarıldı");
            } else {
                System.out.println(trimmed + " listede yok");
            }
        }

        printSorted();
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    public static void printSorted() {
        Collections.sort(groceryList);
        System.out.println("\n🛒 Güncel Liste:");
        for (int i = 0; i < groceryList.size(); i++) {
            System.out.println((i + 1) + ". " + groceryList.get(i));
        }
    }

}
