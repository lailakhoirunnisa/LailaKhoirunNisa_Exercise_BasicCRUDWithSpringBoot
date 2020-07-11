/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Country;
import tools.Koneksi;

/**
 *
 * @author Laila
 */
public class CountryDAO {
    private Connection connection;
   public CountryDAO(){
       this.connection = new Koneksi().getConnection();
   }
    
   public List<Country> getCountry(){
  List<Country> countrys = new ArrayList<>();
  String query = "SELECT * FROM Country";
       try {
           PreparedStatement statement =connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Country region = new Country(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3));
    countrys.add(region);
            }
            } 
            
            catch (Exception e) {
                e.printStackTrace();
               }
       return countrys;
       }
   public boolean insert (Country country){
       boolean result = true;
       String query = "INSERT INTO Country (id, name, region) VALUES (?,?,?)";
       try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, country.getId());
            statement.setString(2, country.getName());
            statement.setInt(3, country.getRegion());
            statement.executeUpdate();
        } catch (Exception e) {
        e.printStackTrace();
        
        }
        return result;
   }
   public boolean cdao_delete(String id) {
        boolean result = true;

        String query = "DELETE FROM `mccoc2`.`Country` WHERE (id = ?);";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, id);
//            statement.setString(2, region.getName());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
//        
        }
        return result;
    }

    public boolean cdao_update(Country country) {
        boolean result = true;

        String query = "UPDATE `mccoc2`.`Country` SET name = ?, region =? WHERE (id = ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(3, country.getId());
            statement.setInt(2, country.getRegion());
            statement.setString(1, country.getName());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
//        
        }
        return result;
    }

    public List<Country> cdao_search(String keyword) {
        List<Country> countrys = new ArrayList<>();
        String query = "SELECT * FROM country WHERE id like ? OR name LIKE ? OR region LIKE ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "%" + keyword + "%");
            statement.setString(2, "%" + keyword + "%");
            statement.setString(3, "%" + keyword + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Country country = new Country(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3));
//                region.setId (resultSet.getString(1));
//                region.setName(resultSet.getString(2));
                countrys.add(country);
            }
        } catch (Exception e) {
            e.printStackTrace();
//        
        }
        return countrys;
    }

    public Country getById(String id) {
        Country country = null;
        String query = "SELECT * FROM country WHERE id =?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, id);
//            statement.setString(2, "%"+keyword+"%");
ResultSet resultSet = statement.executeQuery();
             while (resultSet.next()) {
                country = new Country(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3));
//                region.setId (resultSet.getString(1));
//                region.setName(resultSet.getString(2));
//                regions.add(region);
            }
        } catch (Exception e) {
        }
        return country;
    }
   }
 /* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

