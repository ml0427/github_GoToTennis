/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.gtt.service;

import java.util.List;

import uuu.gtt.dao.OrdersDAO;
import uuu.gtt.entity.Order;
import uuu.gtt.entity.VGBException;

public class OrderService {

	private OrdersDAO ordersDAO = new OrdersDAO();

	public void insert(Order order) throws VGBException {
		if (order == null || order.getOrderItemSet() == null || order.getOrderItemSet().isEmpty()) {
			throw new IllegalArgumentException("建立訂單時，訂單與訂單明細必須有值");
		}
		ordersDAO.insert(order);
	}

	public List<Order> findOrdersByCustomerEmail(String customerEmail) throws VGBException {
		return ordersDAO.selectOrdersByCustomerEmail(customerEmail);
	}

	public Order findOrderById(int orderId) throws VGBException {
		return ordersDAO.selectOrderById(orderId);
	}

	public void updateOrderStatusToNotify(int orderId, String bank, String account, double amount, String transferDate, String transferTime) throws VGBException {
		String paymentNote = "銀行:" + bank + ", 後5碼: " + account + ", 金額: " + amount + ", 日期時間:" + transferDate + " " + transferTime;
		ordersDAO.updateOrderStatusToNotify(orderId, paymentNote);
	}

}
