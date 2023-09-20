/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import DTO.AccountDTO;

/**
 *
 * @author hoangtuan
 */

public class AccountDAL {

    public static ArrayList<AccountDTO> getdanhsachTK() {
        Connection conn =null;
        try {
            conn = Data.getconnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from taikhoan");

            ArrayList<AccountDTO> taiKhoans = new ArrayList<>();
            while (rs.next()) {
                AccountDTO tk = new AccountDTO();
                tk.setAccount_id(rs.getInt(1));
                tk.setUsername(rs.getString(2));
                tk.setPassword(rs.getString(3));
                tk.setPermission_id(rs.getInt(4));
                taiKhoans.add(tk);
            }
            return taiKhoans;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        } finally {
            Data.closeconection(conn);
        }
    }
}
