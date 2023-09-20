/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import java.util.ArrayList;

import DAL.PunishDAL;

import DTO.PunishDTO;

/**
 *
 * @author hoangtuan
 */
public class PunishBUS {

    PunishDTO phatDAL = new PunishDTO();

    public ArrayList<PunishDTO> getListPunishs() {

        return PunishDAL.getListPunish();
    }

    public int addPunish(PunishDTO punish) {
        return PunishDAL.addPunish(punish);
    }

    public int editPunish(PunishDTO punish) {
        return PunishDAL.editPunish(punish);
    }

    public int deletePunish(PunishDTO punish) {
        return PunishDAL.deletePunish(punish);
    }

    public static PunishBUS gI() {
        return new PunishBUS();
    }
}
