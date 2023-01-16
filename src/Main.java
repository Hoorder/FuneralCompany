import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Connection conn = mysqlConnect.connect();

        //      Update i reszta
        queryExecutor.executeQuery("UPDATE services SET price ='5000' WHERE name = 'Pogrzeb tradycyjny'");


        //      Selekt do bd
        try {
            ResultSet result = queryExecutor.executeSelect("SELECT * FROM `services`");

            while (result.next()) {
                String name1 = result.getString("name");
                String name2 = result.getString("price");
                System.out.println(name1 + " " + name2);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

        mysqlConnect.close(conn);


    }
}