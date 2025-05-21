/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;
import View.MahasiswaView;
import View.DosenView;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== MENU UTAMA ===");
            System.out.println("1. Kelola Mahasiswa");
            System.out.println("2. Kelola Dosen");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            int pilih = sc.nextInt();
            sc.nextLine();

            switch (pilih) {
                case 1 -> new MahasiswaView().showMenu();
                case 2 -> new DosenView().showMenu();
                case 0 -> {
                    System.out.println("Terima kasih.");
                    return;
                }
                default -> System.out.println("Pilihan salah.");
            }
        }
    }
}