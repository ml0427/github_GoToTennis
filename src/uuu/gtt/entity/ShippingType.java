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
public enum ShippingType {
	
    SELF("自取"),  HOME(100,"送貨到府");
    
    private final double fee;
    private final String description;

    private ShippingType(String description) {
        this(0, description);
    }

    private ShippingType(double fee, String description) {
        this.fee = fee;
        this.description = description;
    }

    public double getFee() {
        return fee;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description + (fee == 0 ? "" : "-" + fee + '元');
    }
    
}
