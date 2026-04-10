package com.learninglog.learninglogproject.user.model.dao;

import com.learninglog.learninglogproject.user.model.User;
import com.learninglog.learninglogproject.utils.DbConnection;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public  boolean insertUser(String name, String email, String password) throws SQLException {
        String query="INSERT INTO user (name, email, password) VALUES (?,?,?)";
        try(Connection conn = DbConnection.getConnection();
            PreparedStatement st = conn.prepareStatement(query);
        ){
            System.out.println(name+email+ password);
            System.out.println("name+email+password");
            st.setString(1, name);
            st.setString(2, email);
            st.setString(3, password);

            int rowsInserted = st.executeUpdate();
            if (rowsInserted > 0){
                return true;
            }
            else {
                return  false;
            }

        }
    }

    public User loginUser(String email, String password) throws SQLException{
        String query = "SELECT * FROM user WHERE  email = ?";
        try(Connection connection = DbConnection.getConnection();
        PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String storedHashedPassword = rs.getString("password");
                if (BCrypt.checkpw(password, storedHashedPassword)){
                    int id = rs.getInt("id");
                    String name = rs.getString("name");

                    User userObj = new User(id, name, email, storedHashedPassword);
                    return userObj;
                }
            }
            return null;
        }
    }
}