/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.gtt.entity;

/**
 *
 * @author Administrator
 */
public class VIP extends Customer{
	
    private int discount=10; //10% off

    public VIP() {
    }

    public VIP(String id1, String name1, String password1) {
        super(id1, name1, password1);
    }

    public VIP(String id2, String name2, String password2, char gender, String email) {
        super(id2, name2, password2, gender, email);
    }

    public VIP(String id1, String name1, String password1, int discount){
        super(id1, name1, password1);
        this.discount = discount;
    }

    public int getDiscount(){
        return discount;
    }
    
    public void setDiscount(int discount) throws VGBException{
        if(discount>=0 && discount<=100){
            this.discount = discount;
        }else{
            throw new VGBException("折扣必須在0~100之間");
        }
    }
    
    public String getDiscountString(){
        int mod = (100-discount)%10;
        String rtn = (mod==0?(100-discount)/10:(100-discount)) + "折";
        
        return rtn;
    }

    @Override
    public String toString() {
        return super.toString() + ",享有折扣=" + this.getDiscountString();
    }    
    
}
