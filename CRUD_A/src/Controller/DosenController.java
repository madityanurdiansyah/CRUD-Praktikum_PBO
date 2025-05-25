/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Dosen;
import Model.DosenModel;
import java.util.List;

public class DosenController {
    private DosenModel model = new DosenModel();

    public List<Dosen> getAllDosen() {
        return model.getAll();
    }

    public void addDosen(String nama, String nidn) {
        Dosen dosen = new Dosen();
        dosen.setNama(nama);
        dosen.setNidn(nidn);
        model.insert(dosen);
    }

    public void updateDosen(int id, String nama, String nidn) {
        Dosen dosen = new Dosen();
        dosen.setId(id);
        dosen.setNama(nama);
        dosen.setNidn(nidn);
        model.update(dosen);
    }

    public void deleteDosen(int id) {
        model.delete(id);
    }
}
