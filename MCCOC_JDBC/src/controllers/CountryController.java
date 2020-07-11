/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.CountryDAO;
import java.util.List;
import models.Country;

/**
 *
 * @author Laila
 */
public class CountryController {
 private CountryDAO cdao;
 public CountryController(){
     this.cdao = new CountryDAO();
     
 }
 public List<Country> binding(){
     return this.cdao.getCountry();
     
 }
 public String controller_save (String id, String name, String region){
     String result ="Simpan data Country gagal";
     int region1 = Integer.parseInt(region);
     Country country =new Country(id,name,region1);
     if (this.cdao.insert(country)) result ="Simpan data berhasil";
     return result;
 }
 public String controller_delete (String id){
    String result = "Simpan data gagal";
    
//kaarena di DB auto increment, untuk id boleh diskip
//    int idRegion = String.(id);
//    Region region = new Region (id, name);
Country country = new Country (id);    
if(this.cdao.cdao_delete(id)) result = "Delete data berhasil";
return result;
    

}

public String controller_update (String id, String name, String region){
    String result = "Update data gagal";
    
//kaarena di DB auto increment, untuk id boleh diskip
    int region1 = Integer.parseInt(region);
//    Region region = new Region (id, name);
Country country1 = new Country(id, name, region1);      
if(this.cdao.cdao_update(country1)) result = "Update data berhasil";
return result;
}

public List<Country> controller_search (String keyword){
//    String result = "Update data gagal";
//    
////kaarena di DB auto increment, untuk id boleh diskip
//    int idRegion = Integer.parseInt(id);
////    Region region = new Region (id, name);
//Region region1 = new Region (idRegion, name);      
return this.cdao.cdao_search(keyword);

    

}
  public Country controller_getById(String id){
return this.cdao.getById(id); 
}

 
}
