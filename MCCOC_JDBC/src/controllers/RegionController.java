/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.RegionDAO;
import java.util.List;
import models.Region;

/**
 *
 * @author Laila
 */
public class RegionController {
    private RegionDAO rdao;
  
    public RegionController(){
        this.rdao = new RegionDAO();
        
    }
public List<Region> binding(){
//    List<Region> regions = new ArrayList<>();
//regions= this.rdao.getRegions();
//return regions;
return this.rdao.getRegions();
}
public String ctr_controller_save (String id, String name){
    String result = "Simpan data gagal";
    
//kaarena di DB auto increment, untuk id boleh diskip
    int idRegion = Integer.parseInt(id);
//    Region region = new Region (idRegion, name);
Region region1 = new Region (idRegion,name);    
if(this.rdao.rdao_insert(region1)) result = "Simpan data berhasil";
return result;
    

}
public String ctr_controller_delete (String id){
    String result = "Simpan data gagal";
    
//kaarena di DB auto increment, untuk id boleh diskip
    int idRegion = Integer.parseInt(id);
//    Region region = new Region (id, name);
Region region = new Region (idRegion);    
if(this.rdao.rdao_delete(idRegion)) result = "Delete data berhasil";
return result;
    

}

public String ctr_controller_update (String id, String name){
    String result = "Update data gagal";
    
//kaarena di DB auto increment, untuk id boleh diskip
    int idRegion = Integer.parseInt(id);
//    Region region = new Region (id, name);
Region region1 = new Region (idRegion, name);      
if(this.rdao.rdao_update(region1)) result = "Update data berhasil";
return result;
}

public List<Region> ctr_controller_search (String keyword){
//    String result = "Update data gagal";
//    
////kaarena di DB auto increment, untuk id boleh diskip
//    int idRegion = Integer.parseInt(id);
////    Region region = new Region (id, name);
//Region region1 = new Region (idRegion, name);      
return this.rdao.rdao_search(keyword);

    

}
   public Region ctr_controller_getById(int id){
return this.rdao.rdao_getById(id); 
}

    
    
}

