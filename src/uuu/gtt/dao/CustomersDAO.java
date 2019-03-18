package uuu.gtt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

import uuu.gtt.connection.RDBConnection;
import uuu.gtt.entity.Customer;
import uuu.gtt.entity.VGBException;
import uuu.gtt.repository.CustomersRepository;

public class CustomersDAO {

	/**
	 * 單元測試
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			CustomersDAO dao = new CustomersDAO();
			Customer c = dao.selectByEmail("ml0000@gmail.com");

			System.out.println("C>>>" + c.getName());
			// c.setName("蔡沛戎");
			// c.setAddress("台北市復興北路99號12F");
			// dao.update(c);
		} catch (VGBException ex) {
			Logger.getLogger(CustomersDAO.class.getName()).log(Level.SEVERE, null, ex);
			if (ex.getCause() instanceof SQLException) {
				System.out.println(((SQLException) ex.getCause()).getErrorCode());
			}
		}
	}

	public void update(Customer c) throws VGBException {

		try (Connection connection = RDBConnection.getConnection(); PreparedStatement pstmt = connection.prepareStatement(CustomersRepository.UPDATE_CUSTOMER_SQL);) {
			pstmt.setString(1, c.getName());
			pstmt.setString(2, c.getPassword());
			pstmt.setString(3, String.valueOf(c.getGender()));
			pstmt.setString(4, c.getBirthday().toString());
			pstmt.setString(5, c.getId());
			pstmt.setString(6, c.getPhone());
			pstmt.setString(7, c.getAddress());
			pstmt.setString(8, c.getClass().getSimpleName());
			pstmt.setString(9, c.getEmail());
			pstmt.executeUpdate();

		} catch (SQLException ex) {
			throw new VGBException("修改客戶失敗", ex);
		}
	}

	/**
	 * 新增客戶資料
	 * 
	 * @param c
	 * @throws VGBException
	 */
	public void insert(Customer c) throws VGBException {

		try (Connection connection = RDBConnection.getConnection(); PreparedStatement pstmt = connection.prepareStatement(CustomersRepository.INSERT_CUSTOMER_SQL);) {
			pstmt.setString(1, c.getId());
			pstmt.setString(2, c.getName());
			pstmt.setString(3, c.getPassword());
			pstmt.setString(4, String.valueOf(c.getGender()));
			pstmt.setString(5, c.getBirthday().toString());
			pstmt.setString(6, c.getEmail());
			pstmt.setString(7, c.getPhone());
			pstmt.setString(8, c.getAddress());
			pstmt.executeUpdate();

		} catch (SQLException ex) {
			if (ex.getErrorCode() == 1062) {
				throw new VGBException("新增客戶失敗:身分證或信箱已重複註冊", ex);
			} else {
				throw new VGBException("新增客戶失敗", ex);
			}
		}
	}

	/**
	 * 查詢資料 查詢條件為Email (pk)
	 * 
	 * @param email
	 * @return Customer c
	 * @throws VGBException
	 */
	public Customer selectByEmail(String dataEmail) throws VGBException {

		try (Connection connection = RDBConnection.getConnection(); PreparedStatement pstmt = connection.prepareStatement(CustomersRepository.SELECT_CUSTOMER_BY_ID_SQL);) {
			pstmt.setString(1, dataEmail);
			try (ResultSet rs = pstmt.executeQuery();) {
				Customer c = null;
				while (rs.next()) {
					String classStr = rs.getString("class");
					String id = rs.getString("id");
					String name = rs.getString("name");
					String password = rs.getString("password");
					char gender = rs.getString("gender").charAt(0);
					String email = rs.getString("email");
					String birthday = rs.getString("birthday");
					String phone = rs.getString("phone");
					String address = rs.getString("address");

					c = this.createCustomerObject(classStr);

					c.setId(id);
					c.setName(name);
					c.setPassword(password);
					c.setGender(gender);
					c.setEmail(email);
					c.setBirthday(LocalDate.parse(birthday));
					c.setPhone(phone);
					c.setAddress(address);
				}
				return c;
			}
		} catch (SQLException ex) {
			throw new VGBException("查詢客戶失敗", ex);
		}
	}

	/**
	 * createCustomerObject
	 * 
	 * @param classStr
	 * @return
	 */
	private Customer createCustomerObject(String classStr) {

		// 取得Customer的class Name
		String className = Customer.class.getName();
		if (classStr != null) {
			className = className.replace("Customer", classStr);
		}
		Customer c;
		try {
			c = (Customer) Class.forName(className).newInstance();
		} catch (Exception ex) {
			c = new Customer();
		}
		return c;
	}

}
