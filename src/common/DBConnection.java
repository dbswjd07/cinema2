package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {
   

   public static Connection getConnection() throws Exception {
      
      Connection con;
      PreparedStatement ps;
      ResultSet rs;
      
         Class.forName("oracle.jdbc.driver.OracleDriver");
         System.out.println("드라이버 로드 성공");
         String id = "cleangggg", pwd = "~!2Cleangg";
         String url = "jdbc:oracle:thin:@cleangggg.ctqdjwzkrjgg.ap-northeast-2.rds.amazonaws.com:1521:orcl";
         con = DriverManager.getConnection(url, id, pwd);
         System.out.println("연결 성공");
         return con;
   

   }
}