/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package 備份用;

/**
 *
 * @author Administrator
 */
public enum BloodType {
    O, A, B, AB;

            public static BloodType values(String bType) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

    private BloodType(){
        
    }
    
    @Override
    public String toString() {
        return super.toString() + '型';
    }

    
}
