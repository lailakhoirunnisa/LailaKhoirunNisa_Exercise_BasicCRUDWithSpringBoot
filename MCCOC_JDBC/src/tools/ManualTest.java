/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import controllers.CountryController;
import controllers.RegionController;
import java.util.List;
import models.Country;
import models.Region;

/**
 *
 * @author Laila
 */

public class ManualTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
//        System.out.println(new Koneksi());
        // TODO code application logic here
        RegionController controller = new RegionController();
//       insert data region
//System.out.println(controller.savedelete("6"));
//System.out.println(controller.getById(2));
//Region region = controller.getById(2);
//        System.out.println(region.getId());
//        System.out.println(region.getName());
//List<Region> daftarRegions= controller.updategetById(1);
        List<Region> daftarRegions= controller.binding();
        for (Region region : daftarRegions){
            System.out.println("id : "+ region.getId()+ ", name : "+region.getName());
//            
        }
//            
            CountryController ccontroller = new CountryController();
//            //       insert data country
//System.out.println(ccontroller.save("IN","India",1));
//System.out.println(ccontroller.controller_delete("IN"));
//System.out.println(ccontroller.controller_update("ID", "Indonesia", 1));
//List<Country> daftarCountrys= ccontroller.controller_getById("ID");
//Country ccountry = ccontroller.controller_getById("ID");
//List<Country> daftarCountrys= ccontroller.controller_getById();
Country country = ccontroller.controller_getById("ID");
//        System.out.println(country.getId());
//        System.out.println(country.getName());
//        System.out.println(country.getRegion());

//            List<Country> daftarCountrys= ccontroller.binding();
//        for (Country country : daftarCountrys){
            System.out.println("id : "+ country.getId()+ ", name : "+country.getName()+" region : "+country.getRegion());
//            
////            
//        }
    }
    
//}
}
