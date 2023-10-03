package com.freshapples.data;

import java.util.List;
import java.util.ArrayList;
import javax.sql.DataSource;
import org.springframework.stereotype.Service;
import com.freshapples.model.OrderModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;



@Service
public class OrdersDataService implements DataAccessInterface<OrderModel> {


	private JdbcTemplate jdbcTemplateObject;
	
	public OrdersDataService(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<OrderModel> findAll() {
		String sql = "SELECT * FROM ORDERS";
		List<OrderModel> orders = new ArrayList<OrderModel>();
		try {
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
			while(srs.next()) {
				orders.add(new OrderModel(srs.getLong("ID"),
						srs.getString("ORDER_NO"),
						srs.getString("PRODUCT_NAME"), 
						srs.getString("GENRE"),
						srs.getFloat("PRICE")));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return orders;
	}

	@Override
	public OrderModel findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(OrderModel order) {
		String sql = "INSERT INTO ORDERS(ORDER_NO, PRODUCT_NAME, GENRE, PRICE) VALUES(?, ?, ?, ?)";
		try {
			int rows = jdbcTemplateObject.update(sql,
					order.getOrderNo(),
					order.getProductName(),
					order.getGenre(),
					order.getPrice());
			
			return rows == 1 ? true : false;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(OrderModel order) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean delete(OrderModel order) {
		// TODO Auto-generated method stub
		return true;
	}

}
