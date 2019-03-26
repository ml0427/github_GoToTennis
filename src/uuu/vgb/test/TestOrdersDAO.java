/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uuu.vgb.test;

import java.util.List;

import uuu.gtt.dao.OrdersDAO;
import uuu.gtt.entity.Cart;
import uuu.gtt.entity.Customer;
import uuu.gtt.entity.Order;
import uuu.gtt.entity.PaymentType;
import uuu.gtt.entity.Product;
import uuu.gtt.entity.ShippingType;
import uuu.gtt.service.CustomerService;
import uuu.gtt.service.ProductService;

/**
 *
 * @author Administrator
 */
public class TestOrdersDAO {
	public static void main(String[] args) throws Exception {
		CustomerService service = new CustomerService();
		Customer c = service.login("A123456789", "123456");
		// Customer vip = service.login("A223456781", "123456");

		ProductService pService = new ProductService();
		Product p1 = pService.findProductById(1);
		Product p2 = pService.findProductById(51);
		Product p3 = pService.findProductById(1);
		// Product pNull = pService.findProductById(551);

		Cart cart1 = new Cart();
		cart1.setMember(c);
		cart1.add(p1);
		cart1.add(p2, 1);
		cart1.update(p3, 2);
		System.out.println("cart1" + cart1);

		Order order1 = new Order();
		order1.setMember(c);
		order1.add(cart1);
		order1.setPaymentType(PaymentType.ATM);
		order1.setPaymentFee(PaymentType.ATM.getFee());
		order1.setShippingType(ShippingType.HOME);
		order1.setShippingFee(ShippingType.HOME.getFee());
		order1.setRecipientName(c.getName());
		order1.setRecipientEmail(c.getEmail());
		order1.setRecipientPhone("0987654321");
		order1.setRecipientAddr("台北市復興北路99號14F");
		order1.setId(0);
		System.out.println("order1.member = " + order1.getMember() + "\n");
		System.out.println("order1.orderItems = " + order1.getOrderItemSet() + "\n");
		System.out.println("order1.getTotalAmount() = " + order1.getTotalAmount() + "\n");
		System.out.println("order1.getPaymentType() = " + order1.getPaymentType() + "\n");
		System.out.println("order1.getPaymentFee() = " + order1.getPaymentFee() + "\n");
		System.out.println("order1.getShippingType() = " + order1.getShippingType() + "\n");
		System.out.println("order1.getShippingFee() = " + order1.getShippingFee() + "\n");

		OrdersDAO dao = new OrdersDAO();
		// dao.insert(order1);
		List<Order> list = dao.selectOrdersByEmail(c.getEmail());
		System.out.println("list = " + list);

		// Cart cart2 = new Cart();
		// cart2.setMember(vip);
		// cart2.add(p1);
		// cart2.add(p2, 1);
		// cart2.update(p3, 2);
		// System.out.println("cart2: " + cart2);
		//
		// Order order2 = new Order();
		// order2.setMember(vip);
		// order2.add(cart2);
		// order2.setPaymentType(PaymentType.ATM);
		// order2.setPaymentFee(PaymentType.ATM.getFee());
		// order2.setShippingType(ShippingType.HOME);
		// order2.setShippingFee(ShippingType.HOME.getFee());
		// order2.setRecipientName(c.getName());
		// order2.setRecipientEmail(c.getEmail());
		// order2.setRecipientPhone("0987654321");
		// order2.setRecipientAddr("台北市復興北路99號14F");
		// System.out.println("order2 = " + order2);

	}
}
