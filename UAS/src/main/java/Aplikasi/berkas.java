/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Aplikasi;

/**
 *
 * @author Azhar Nurulhaifa
 */
import java.util.ArrayList;
import java.util.List;

public class berkas {
    private int idBerkas = -1;
    private List<String> skill = new ArrayList<>();
    
    public int getIdBerkas() {
        return idBerkas;
    }
    
    public void setIdBerkas(int idBerkas) {
        this.idBerkas = idBerkas;
    }
    
    public List<String> getSkill() {
        if(skill.isEmpty()){
            return null;
        }else{
            return skill;
        }
    }
    
    public void setSkill(List<String> skill) {
        this.skill = skill;
    }
    
    @Override
    public String toString() {
        return "berkas{" + "idBerkas=" + idBerkas + ", skill=" + skill + '}';
    }
    
    public void addSkill(String s) {
        skill.add(s);
    }
}
