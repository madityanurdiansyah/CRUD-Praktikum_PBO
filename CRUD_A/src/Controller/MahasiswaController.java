/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.Mahasiswa;
import Model.MahasiswaModel;
import java.util.List;

public class MahasiswaController {
    private MahasiswaModel model = new MahasiswaModel();

    public List<Mahasiswa> getAllMahasiswa() {
        return model.getAll();
    }

    public void addMahasiswa(String nama, String nim) {
        Mahasiswa m = new Mahasiswa();
        m.setNama(nama);
        m.setNim(nim);
        model.insert(m);
    }

    public void updateMahasiswa(int id, String nama, String nim) {
        Mahasiswa m = new Mahasiswa();
        m.setId(id);
        m.setNama(nama);
        m.setNim(nim);
        model.update(m);
    }

    public void deleteMahasiswa(int id) {
        model.delete(id);
    }
}
