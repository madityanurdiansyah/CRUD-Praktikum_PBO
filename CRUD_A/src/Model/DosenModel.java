/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import Config.DatabaseConnection;
import java.sql.*;
import java.util.*;

public class DosenModel {
    public List<Dosen> getAll() {
        List<Dosen> list = new ArrayList<>();
        String query = "SELECT * FROM dosen";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Dosen dosen = new Dosen();
                dosen.setId(rs.getInt("id"));
                dosen.setNama(rs.getString("nama"));
                dosen.setNidn(rs.getString("nidn"));
                list.add(dosen);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void insert(Dosen dosen) {
        String sql = "INSERT INTO dosen (nama, nidn) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, dosen.getNama());
            ps.setString(2, dosen.getNidn());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Dosen dosen) {
        String sql = "UPDATE dosen SET nama = ?, nidn = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, dosen.getNama());
            ps.setString(2, dosen.getNidn());
            ps.setInt(3, dosen.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM dosen WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
