/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jdbc.DBConnection;

/**
 *
 * @author andre
 */
public class UserDAO {

    public User login(String login, String senha) throws SQLException {
        User user = null;
        try (Connection conexao = new DBConnection().getConnection()) {
            String sql = "SELECT  * FROM usuarios WHERE login = ? AND senha = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, login);
            ps.setString(2, senha);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                user = new User(rs.getInt("id"), rs.getString("nome"), rs.getString("login"), rs.getString("senha"), rs.getString("nivel"));
            }
            ps.close();
            rs.close();
        }
        return user;
    }
}
