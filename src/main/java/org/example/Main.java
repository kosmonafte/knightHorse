package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        int[][] field = new int[8][8];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = 0;
            }
        }
        System.out.println(KnightHorse.showField(field));
        KnightHorse.goHorse(field, 4, 3, 0);
        System.out.println(KnightHorse.showField(field));
    }
}