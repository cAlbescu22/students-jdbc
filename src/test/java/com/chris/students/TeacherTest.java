package com.chris.students;

import org.junit.Assert;
import org.junit.Test;

import java.sql.*;
import java.util.Properties;

import static org.junit.Assert.assertEquals;

public class TeacherTest {
    @Test
    public void testFindAll() {
        Properties props = new Properties();
        props.put("user", "root");
        props.put("password", "root");
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/courses", props);
             Statement st = con.createStatement()) {

            String sqlQuery = "SELECT * FROM teacher";
            ResultSet rs = st.executeQuery(sqlQuery);
            while (rs.next()) {
                System.out.println("id= " + rs.getInt("id"));
                System.out.println("first name= " + rs.getString("first_name"));
                System.out.println("last name= " + rs.getString("last_name"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdateTeacher() {
        Properties props = new Properties();
        props.put("user", "root");
        props.put("password", "root");
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/courses", props);
             Statement st = con.createStatement()) {
            String sqlQuery = "UPDATE teacher SET first_name='Alexandru' WHERE id=1";
            sqlQuery = "UPDATE teacher SET first_name='Alexandru' WHERE id=2";

          int   noRowsUpdated=st.executeUpdate(sqlQuery);
           assertEquals (noRowsUpdated,0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}





