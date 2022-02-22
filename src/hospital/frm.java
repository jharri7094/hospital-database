package hospital;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.time.Clock;
import java.time.ZoneId;


public class frm {

   public static void main(String[] args) {
    try{
        Class.forName("com.mysql.jdbc.Driver");
        
    }catch (ClassNotFoundException e){
        System.out.println(e);
    }
      HomeFrame home = new HomeFrame();
      home.setVisible(true);
    }

}
