/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Region;
import tools.Koneksi;

/**
 *
 * @author Laila
 */
public class RegionDAO {

    private Connection connection;

    public RegionDAO() {
        this.connection = new Koneksi().getConnection();

    }

    public List<Region> getRegions() {
        List<Region> regions = new ArrayList<>();
        String query = "SELECT * FROM Region";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Region region = new Region(resultSet.getInt(1), resultSet.getString(2));
//                region.setId (resultSet.getString(1));
//                region.setName(resultSet.getString(2));
                regions.add(region);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

        return regions;
    }

    /*
    
     */
    public boolean rdao_insert(Region region) {
        boolean result = true;

        String query = "INSERT INTO Region (id, name) VALUES (?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, region.getId());
            statement.setString(2, region.getName());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return result;
    }

    public boolean rdao_delete(int id) {
        boolean result = true;

        String query = "DELETE FROM `mccoc2`.`region` WHERE (id = ?);";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
//            statement.setString(2, region.getName());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
//        
        }
        return result;
    }

    public boolean rdao_update(Region region) {
        boolean result = true;

        String query = "UPDATE `mccoc2`.`Region` SET name = ? WHERE (id = ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(2, region.getId());
            statement.setString(1, region.getName());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
//        
        }
        return result;
    }

    public List<Region> rdao_search(String keyword) {
        List<Region> regions = new ArrayList<>();
        String query = "SELECT * FROM Region WHERE id like ? OR name LIKE ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "%" + keyword + "%");
            statement.setString(2, "%" + keyword + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Region region = new Region(resultSet.getInt(1), resultSet.getString(2));
//                region.setId (resultSet.getString(1));
//                region.setName(resultSet.getString(2));
                regions.add(region);
            }
        } catch (Exception e) {
            e.printStackTrace();
//        
        }
        return regions;
    }

    public Region rdao_getById(int id) {
        Region region = null;
        String query = "SELECT * FROM Region WHERE id =?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
//            statement.setString(2, "%"+keyword+"%");
ResultSet resultSet = statement.executeQuery();
             while (resultSet.next()) {
                region = new Region(resultSet.getInt(1), resultSet.getString(2));
//                region.setId (resultSet.getString(1));
//                region.setName(resultSet.getString(2));
//                regions.add(region);
            }
        } catch (Exception e) {
        }
        return region;
    }

}
