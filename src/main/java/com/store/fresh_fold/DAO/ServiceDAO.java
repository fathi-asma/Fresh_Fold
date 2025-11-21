package com.store.fresh_fold.DAO;

import com.store.fresh_fold.Model.Service;
import com.store.fresh_fold.util.DBConnect;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ServiceDAO {
    public List<Service> getAllServices() {
        List<Service> services = new ArrayList<>();
        String sql = "SELECT * FROM services";

        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Service s = new Service();
                s.setService_id(rs.getInt("service_id"));
                s.setService_name(rs.getString("service_name"));
                s.setService_type(rs.getString("service_type"));
                s.setPrice(rs.getDouble("price"));
                s.setUnit(rs.getString("unit"));
                s.setImage(rs.getString("image"));
                services.add(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return services;
    }
}
