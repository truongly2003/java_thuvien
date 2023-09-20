/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.PunishDTO;

/**
 *
 * @author hoangtuan
 */
public class PunishDAL {

    public static ArrayList<PunishDTO> getListPunish() {
        Connection conn =null;
        try {
            String sql = "select * from phat";
            conn = Data.getconnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            ArrayList<PunishDTO> dsl = new ArrayList<>();
            while (rs.next()) {
                System.out.println("Db connect");
                PunishDTO ke = new PunishDTO();
                ke.setPunish_id(rs.getInt(1));
                ke.setBorrow_id(rs.getInt(2));
                ke.setReason(rs.getString(3));
                ke.setFine(rs.getString(4));
                dsl.add(ke);
                
            }
            return dsl;
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }finally{
            Data.closeconection(conn);
        }

    }

    //@SuppressWarnings("null")
    public static int addPunish(PunishDTO ke) {
        Connection conn =null;
        int i = -1;
        String sql = "insert into phat (mapm,lydo,tien) values(?,?,?)";
        try {

            conn = Data.getconnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, ke.getBorrow_id());
            pstm.setString(2, ke.getReason());
            pstm.setString(3, ke.getFine());
            i = pstm.executeUpdate();
           

        } catch (Exception e) {
            e.printStackTrace();
            //dreturn null;
        }finally{
            Data.closeconection(conn);
        }

        return i;
    }

    public static int editPunish(PunishDTO ke) {
        Connection conn = null;
        int i = -1;
        String sql = "update phat set mapm = ? , lydo =? , tien = ? where mapp = ?";

        try {
            conn = Data.getconnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, ke.getBorrow_id());
            pstm.setString(2, ke.getReason());
            pstm.setString(3, ke.getFine());
            pstm.setInt(4, ke.getPunish_id());
            //System.out.println(ke.getViTri());
            i = pstm.executeUpdate();
           
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            Data.closeconection(conn);
        }
        return i;
    }

    public static int deletePunish(PunishDTO ke) {
        Connection conn = null;
        int i = -1;
        String sql = "delete from phat where mapp = ?";
        try {
            conn = Data.getconnection();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, ke.getPunish_id());
            i = pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            Data.closeconection(conn);
        }
        return i;
    }
}
