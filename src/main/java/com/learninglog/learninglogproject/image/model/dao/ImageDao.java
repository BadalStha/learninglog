package com.learninglog.learninglogproject.image.model.dao;

import com.learninglog.learninglogproject.utils.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ImageDao {

    public static boolean insertimageDetails(String name, String imagePath) throws SQLException {
        String query = "INSERT INTO image_upload(name, image_path) VALUES(?, ?)";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement st = conn.prepareStatement(query)
        ){
            st.setString(1, name);
            st.setString(2, imagePath);

            int effectedRows = st.executeUpdate();
            if (effectedRows > 0){
                return true;
            } else {
                return false;
            }
        }
    }
}
