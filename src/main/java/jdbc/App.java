package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {

        //Connection to our database
//        Connection conn = new DBConnection2().get();
        Connection conn = DbConnection.getConnection();

        //statement for SQL query placement
        PreparedStatement theStatement1 = conn.prepareStatement(SQLqueries.SQL_SELECT);

        //getting the database data from the resultSet object
        ResultSet resultSet = theStatement1.executeQuery();
        while (resultSet.next()) {
            String line = String.format("id:%d, name=%s, surname=%s, score=%d, supervisor=%d",
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("surname"),
                    resultSet.getInt("score"),
                    resultSet.getInt("supervisor")
            );
            System.out.println(line);
        }

        //statement for a new SQL query placement
        PreparedStatement theStatement2 = conn.prepareStatement(SQLqueries.SQL_INSERT);

        //setting the data into the database
        theStatement2.setInt(1, 6);
        theStatement2.setString(2, "Barbara");
        theStatement2.setString(3, "Weave");
        theStatement2.setInt(4, 12);
        theStatement2.setInt(5, 101);
        theStatement2.execute();
    }
}
