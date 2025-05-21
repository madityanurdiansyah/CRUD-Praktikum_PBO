/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;
import Controller.MahasiswaController;
import Model.Mahasiswa;
import java.util.*;

public class MahasiswaView {
    private MahasiswaController controller = new MahasiswaController();
    private Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        while (true) {
            System.out.println("\n== Menu Mahasiswa ==");
            System.out.println("1. Tampilkan Semua");
            System.out.println("2. Tambah");
            System.out.println("3. Update");
            System.out.println("4. Hapus");
            System.out.println("0. Keluar");
            System.out.print("Pilihan: ");
            int pilih = scanner.nextInt();
            scanner.nextLine();

            switch (pilih) {
                case 1 -> tampilkanSemua();
                case 2 -> tambahMahasiswa();
                case 3 -> updateMahasiswa();
                case 4 -> hapusMahasiswa();
                case 0 -> { return; }
                default -> System.out.println("Pilihan salah!");
            }
        }
    }

    private void tampilkanSemua() {
        List<Mahasiswa> list = controller.getAllMahasiswa();
        for (Mahasiswa m : list) {
            System.out.println(m.getId() + " - " + m.getNama() + " (" + m.getNim() + ")");
        }
    }

    private void tambahMahasiswa() {
        System.out.print("Nama: ");
        String nama = scanner.nextLine();
        System.out.print("NIM: ");
        String nim = scanner.nextLine();
        controller.addMahasiswa(nama, nim);
        System.out.println("Data berhasil ditambah.");
    }

    private void updateMahasiswa() {
        System.out.print("ID: ");
        int id = scanner.nextInt(); scanner.nextLine();
        System.out.print("Nama Baru: ");
        String nama = scanner.nextLine();
        System.out.print("NIM Baru: ");
        String nim = scanner.nextLine();
        controller.updateMahasiswa(id, nama, nim);
        System.out.println("Data berhasil diupdate.");
    }

    private void hapusMahasiswa() {
        System.out.print("ID: ");
        int id = scanner.nextInt(); scanner.nextLine();
        controller.deleteMahasiswa(id);
        System.out.println("Data berhasil dihapus.");
    }
}
