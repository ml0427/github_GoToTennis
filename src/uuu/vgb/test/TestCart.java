/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uuu.vgb.test;

import uuu.gtt.entity.Cart;
import uuu.gtt.entity.Customer;
import uuu.gtt.entity.Product;
import uuu.gtt.service.CustomerService;
import uuu.gtt.service.ProductService;

/**
 *
 * @author Administrator
 */
public class TestCart {
	public static void main(String[] args) throws Exception {
		CustomerService service = new CustomerService();
		Customer c = service.login("A123456789", "123456");
		Customer vip = service.login("A223456781", "123456");

		ProductService pService = new ProductService();
		Product p1 = pService.selectProductById(1);
		Product p2 = pService.selectProductById(15);
		Product p3 = pService.selectProductById(1);
		// Product pNull = pService.findProductById(551);

		Cart cart1 = new Cart();
		cart1.setMember(c);
		cart1.add(p1);
		cart1.add(p2, 1);
		cart1.update(p3, 2);
		// System.out.println("cart1共買了"+cart1.getSize() + "項");
		// System.out.println("cart1共買了"+cart1.getTotalQuantity() + "件");
		// System.out.println("cart1共買了"+cart1.getTotalAmount() + "元");
		// System.out.println("cart1共買了"+cart1.getTotalDiscountedAmount() + "元(折扣後)");
		// System.out.println("cart1購買者:" + cart1.getMember());
		System.out.println("cart1" + cart1);

		Cart cart2 = new Cart();
		cart2.setMember(vip);
		cart2.add(p1);
		cart2.add(p2, 1);
		cart2.update(p3, 2);
		// System.out.println("cart2共買了"+cart2.getSize() + "項");
		// System.out.println("cart2共買了"+cart2.getTotalQuantity() + "件");
		// System.out.println("cart2共買了"+cart2.getTotalAmount() + "元");
		// System.out.println("cart2共買了"+cart2.getTotalDiscountedAmount() + "元(折扣後)");
		// System.out.println("cart2購買者:" + cart2.getMember());
		System.out.println("cart2: " + cart2);

	}
}
