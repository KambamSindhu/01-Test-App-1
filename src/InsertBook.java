import com.mysql.cj.x.protobuf.MysqlxCrud;

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertBook {

    private static final String cmd = "SELECT * FROM BOOKS";
    public static void main(String[] args) throws Exception  {

        Scanner sc = new Scanner(System.in);
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "bindu123");
        System.out.println(con);

        Statement stmt = con.createStatement();

        System.out.println("PLease enter price!");

        int p = sc.nextInt();

        if(p == 0)
        {
            ResultSet rs = stmt.executeQuery("select * from books");

            while (rs.next()){
                int bookid = rs.getInt("BOOK_ID");
                String name = rs.getString("BOOK_NAME");
                int price = rs.getInt("BOOK_PRICE");

                System.out.println(bookid + " " + name + " " + price);
            }
        }
        else{
            ResultSet rs = stmt.executeQuery("select * from books where BOOK_PRICE <= '" + p + "'");

            while (rs.next()) {
                int bookid = rs.getInt("BOOK_ID");
                String name = rs.getString("BOOK_NAME");
                int price = rs.getInt("BOOK_PRICE");

                System.out.println(bookid + " " + name + " " + price);
            }
        }

        con.close();

    }
}
