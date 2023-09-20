/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author hoangtuan
 */
public class AccountDTO {
    private int account_id;
    private String username;
    private String password;
    private int permission_id;

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPermission_id() {
        return permission_id;
    }

    public void setPermission_id(int permission_id) {
        this.permission_id = permission_id;
    }

    @Override
    public String toString() {
        return "Account{" + "account_id=" + account_id + ", username=" + username + ", password=" + password + ", permission_id=" + permission_id + '}';
    }

    public AccountDTO(int account_id, String username, String password, int permission_id) {
        this.account_id = account_id;
        this.username = username;
        this.password = password;
        this.permission_id = permission_id;
    }
    public AccountDTO(){
        super();
    }
}
