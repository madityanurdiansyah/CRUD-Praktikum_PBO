/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;
import Controller.DosenController;
import Model.Dosen;
import java.util.List;
import java.util.Scanner;

public class DosenView {
    private final DosenController controller = new DosenController();
    private final Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        while (true) {
            System.out.println("\n=== MENU DOSEN ===");
            System.out.println("1. Tampilkan Semua Dosen");
            System.out.println("2. Tambah Dosen");
            System.out.println("3. Ubah Dosen");
            System.out.println("4. Hapus Dosen");
            System.out.println("0. Kembali");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // membersihkan newline

            switch (pilihan) {
                case 1 -> tampilkanSemua();
                case 2 -> tambahDosen();
                case 3 -> ubahDosen();
                case 4 -> hapusDosen();
                case 0 -> {
                    return;
                }
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private void tampilkanSemua() {
        List<Dosen> list = controller.getAllDosen();
        System.out.println("\n--- Daftar Dosen ---");
        for (Dosen dosen : list) {
            System.out.printf("ID: %d | Nama: %s | NIDN: %s%n",
                    dosen.getId(), dosen.getNama(), dosen.getNidn());
        }
    }

    private void tambahDosen() {
        System.out.print("Nama Dosen: ");
        String nama = scanner.nextLine();
        System.out.print("NIDN: ");
        String nidn = scanner.nextLine();
        controller.addDosen(nama, nidn);
        System.out.println("Dosen berhasil ditambahkan.");
    }

    private void ubahDosen() {
        System.out.print("ID Dosen yang ingin diubah: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // newline
        System.out.print("Nama Baru: ");
        String nama = scanner.nextLine();
        System.out.print("NIDN Baru: ");
        String nidn = scanner.nextLine();
        controller.updateDosen(id, nama, nidn);
        System.out.println("Dosen berhasil diubah.");
    }

    private void hapusDosen() {
        System.out.print("ID Dosen yang ingin dihapus: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // newline
        controller.deleteDosen(id);
        System.out.println("Dosen berhasil dihapus.");
    }
}
