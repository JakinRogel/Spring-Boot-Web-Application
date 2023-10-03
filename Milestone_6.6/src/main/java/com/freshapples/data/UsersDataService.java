package com.freshapples.data;

import java.util.List;
import java.util.ArrayList;
import javax.sql.DataSource;
import org.springframework.stereotype.Service;
import com.freshapples.model.UserModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;



@Service
public class UsersDataService implements DataAccessInterface<UserModel> {

	private JdbcTemplate jdbcTemplateObject;
	
	public UsersDataService(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<UserModel> findAll() {
		String sql = "SELECT * FROM USERS";
		List<UserModel> users = new ArrayList<UserModel>();
		try {
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);
			while(srs.next()) {
				users.add(new UserModel(srs.getInt("user_id"), 
						srs.getString("username"),
						srs.getString("password"),
						srs.getString("role"),
						srs.getInt("enabled")));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return users;
	}


	@Override
	public boolean create(UserModel user) {
		String sql = "INSERT INTO USERS(user_id, username, password, role, enabled) VALUES(?, ?, ?, ?, ?)";
		try {
			int rows = jdbcTemplateObject.update(sql,
					user.getUser_id(),
					user.getUsername(),
					user.getPassword(),
					user.getRole(),
					user.getEnabled()
					);
			
			return rows == 1 ? true : false;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(UserModel t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(UserModel t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserModel findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
