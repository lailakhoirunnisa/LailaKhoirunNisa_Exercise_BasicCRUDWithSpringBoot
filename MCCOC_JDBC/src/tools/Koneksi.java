/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

//import com.mysql.jdbc.Connection;


import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;

/**
 *
 * @author Laila
 */
public class Koneksi {
    private Connection connection = null;
    
//    ini merupakan method untuk melakukan koneksi ke DB 
//            yang perlu diset: server name, port, dbname, user
//                    dan password yang digunakan dalam aplikasi ini
public Connection getConnection(){
    try{
        
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setServerName("localhost");
        dataSource.setPort(3406);
        dataSource.setDatabaseName("mccoc2");
        dataSource.setUser("root");
        dataSource.setPassword("b0o7c@mp");
        dataSource.setUseSSL(false);
        connection = dataSource.getConnection();
        return connection;
    }
    catch (Exception e){
        System.out.println(e.getMessage());
        e.printStackTrace();
    }
    return connection;
    }
}

