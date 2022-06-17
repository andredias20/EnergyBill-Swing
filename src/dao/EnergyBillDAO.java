/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import jdbc.DBConnection;
import model.EnergyBill;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author andre
 */
public class EnergyBillDAO {

    public EnergyBillDAO() {
    }

    // CREATE - READ - UPDATE - DELETE
    public static void add(EnergyBill bill) {
        Connection conn = new DBConnection().getConnection();

        String sql = "INSERT INTO cliente(nome,data_nascimento,cpf,email,endereco,cep,sexo,unidade_consumidora,data_vencimento,kwh,valor_kw,valor_total) VALUES(?,?,?,?,?,?,?,?,?,?,?,?);";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, bill.getNome());
            ps.setDate(2, new java.sql.Date(bill.getData_nascimento().getTime()));
            ps.setString(3, bill.getCpf());
            ps.setString(4, bill.getEmail());
            ps.setString(5, bill.getEndereco());
            ps.setString(6, bill.getCep());
            ps.setString(7, bill.getSexo());
            ps.setInt(8, bill.getUnidade_consumidora());
            ps.setDate(9, new java.sql.Date(bill.getData_vencimento().getTime()));
            ps.setDouble(10, bill.getConsumo_kv());
            ps.setDouble(11, bill.getCusto_kv());
            ps.setDouble(12, bill.getValor_total());

            if(!ps.execute()){
                JOptionPane.showMessageDialog(null, "A conta de luz foi cadastrada com sucesso", "Sucesso", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao gravar os dados no banco","Ocorreu um erro", JOptionPane.ERROR_MESSAGE);
            }

            conn.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("\n--- START Throw---\n" + e.getMessage() + "\n--- END Throw---\n");
        }
    }

    public List<EnergyBill> searchForDescription(String txt) {
        List<EnergyBill> bills = new ArrayList<>();
        Connection conection = new DBConnection().getConnection();

        String sql = "SELECT * FROM cliente WHERE nome LIKE ?";
        try {
            PreparedStatement ps = conection.prepareStatement(sql);
            ps.setString(1, "%" + txt + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                EnergyBill bill = populateBill(rs);
                bills.add(bill);
            }
        } catch (SQLException e) {
            System.out.println("\n--- START ---\n" + e.getMessage() + "\n--- END ---\n");
        }
        return bills;
    }

    public static void update(EnergyBill bill) {

        Connection conn = new DBConnection().getConnection();

        String sql = "UPDATE cliente SET "
                + "nome = ?,"
                + "data_nascimento = ?,"
                + "cpf = ?,"
                + "email = ?,"
                + "endereco = ?,"
                + "cep = ?,"
                + "sexo = ?,"
                + "unidade_consumidora = ?,"
                + "data_vencimento = ?,"
                + "kwh = ?, "
                + "valor_kw  = ?, "
                + "valor_total = ? WHERE id = ?;";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, bill.getNome());
            ps.setDate(2, new java.sql.Date(bill.getData_nascimento().getTime()));
            ps.setString(3, bill.getCpf());
            ps.setString(4, bill.getEmail());
            ps.setString(5, bill.getEndereco());
            ps.setString(6, bill.getCep());
            ps.setString(7, bill.getSexo());
            ps.setInt(8, bill.getUnidade_consumidora());
            ps.setDate(9, new java.sql.Date(bill.getData_vencimento().getTime()));
            ps.setDouble(10, bill.getConsumo_kv());
            ps.setDouble(11, bill.getCusto_kv());
            ps.setDouble(12, bill.getValor_total());
            ps.setInt(13, bill.getId());

            if (!ps.execute()) {
                JOptionPane.showMessageDialog(null,"A conta de luz foi atualizada com sucesso" ,"Sucesso", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao gravar os dados no banco" , "Ocorreu um erro" , JOptionPane.ERROR_MESSAGE);
            }

            conn.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("\n--- START Throw---\n" + e.getMessage() + "\n--- END Throw---\n");
        }

    }

    public static void delete(int id) {

        Connection conn = new DBConnection().getConnection();

        String sql = "DELETE FROM cliente WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.execute();
            conn.close();
        } catch (SQLException sqlEx) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar executar a Query para apagar. \n " + sqlEx.getMessage(), "Erro na Query", JOptionPane.ERROR_MESSAGE);
        }
    }

    private EnergyBill populateBill(ResultSet rs) {
        EnergyBill bill = null;
        try {
            bill = new EnergyBill(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getDate("data_nascimento"),
                    rs.getString("cpf"),
                    rs.getString("email"),
                    rs.getString("endereco"),
                    rs.getString("cep"),
                    rs.getString("Sexo"),
                    rs.getInt("unidade_consumidora"),
                    rs.getDate("data_vencimento"),
                    rs.getDouble("kwh"),
                    rs.getDouble("valor_kw")
            );

        } catch (SQLException e) {
            System.out.println("\n--- START ---\n" + e.getMessage() + "\n--- END ---\n");
        }

        return bill;
    }

    public EnergyBill selectID(int id) {
        Connection conn = new DBConnection().getConnection();
        String sql = "SELECT * FROM cliente WHERE id = ?";
        ResultSet rs;
        EnergyBill bill = null;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            rs = ps.executeQuery();
            bill = this.populateBill(rs);
        } catch (SQLException e) {
            System.out.println("\n--- START ---\n" + e.getMessage() + "\n--- END ---\n");
        }
        return bill;

    }
}
