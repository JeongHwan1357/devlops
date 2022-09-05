import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MiniProjectConnectMysql { //진행할 프로젝트 이름 
    public static void main(String[] args){  
        // connection method, hostname : localhost, port, username, password, default schema(원하는 database 이름) 항목 입력확인
        //hostname: localhost post: 3306
        //username: root
        //default schema: world
        //password: tbrs00002b
        //access to 'world' DB
        final String USER = "root";
        final String PASS = "tbrs00002b";
        final String DB_URL = "jdbc:mysql://localhost/world";
        String Query ="select ID, Name, Population " + "from city " + "where 1 = 1 " + "and Population >= 9230000 ";
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(Query);
        // 새로운 query 생성, select 명령문 입력 후 test 해보기
        // result grid, action output 확인
        while (rs.next()){
            System.out.print("ID: " + rs.getInt("ID"));
            System.out.print(", Name: " + rs.getString("Name"));
            System.out.println(", Population: " + rs.getInt("Population"));
        }
        } catch (SQLException e) {
           
            e.printStackTrace();
        } //연결한다. 클래스.메소드()
        

        return; // return 시켜주면 에러표시(빨간줄) 안남

    }
    
}
