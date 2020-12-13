package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bean.Employee;

public class EmployeeDAO {

	private JdbcTemplate jdbctemp;

	public void setJdbctemp(JdbcTemplate jdbctemp) {
		this.jdbctemp = jdbctemp;
	}

	public List<Employee> getEmployee() {
		return jdbctemp.query("select * from Employee", new RowMapper<Employee>() {
			public Employee mapRow(ResultSet rs, int row) throws SQLException {
				Employee e = new Employee();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setSalary(rs.getInt(3));
				e.setDepartment(rs.getString(4));
				e.setTimestamp(rs.getTimestamp(5));
				return e;
			}
		});
	}
	
	public List<Employee> getEmployeeById(int id) {
		return jdbctemp.query("select * from Employee where id = '"+id+"'", new RowMapper<Employee>() {
			public Employee mapRow(ResultSet rs, int row) throws SQLException {
				Employee e = new Employee();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setSalary(rs.getInt(3));
				e.setDepartment(rs.getString(4));
				e.setTimestamp(rs.getTimestamp(5));
				return e;
			}
		});
	}
	
	public List<Employee> getEmployeeFirst() {
		return jdbctemp.query("select * from Employee order by id   LIMIT 5", new RowMapper<Employee>() {
			public Employee mapRow(ResultSet rs, int row) throws SQLException {
				Employee e = new Employee();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setSalary(rs.getInt(3));
				e.setDepartment(rs.getString(4));
				e.setTimestamp(rs.getTimestamp(5));
				return e;
			}
		});
	}
	
	public List<Employee> getEmployeeLast() {
		return jdbctemp.query("select * from Employee where id > ( (select COUNT(*) from employee) - 5)", new RowMapper<Employee>() {
			public Employee mapRow(ResultSet rs, int row) throws SQLException {
				Employee e = new Employee();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setSalary(rs.getInt(3));
				e.setDepartment(rs.getString(4));
				e.setTimestamp(rs.getTimestamp(5));
				return e;
			}
		});
	}

	public int getMaxId() {
		String query = "select max(id) from employee"; 
        int maxId = jdbctemp.queryForInt(query);
        return maxId;
	}
	
	// pagination
    public List<Employee> getEmployeesByPage(int pageid, int total) {
		String sql = "select * from Employee limit " + (pageid - 1) + "," + total;
		return jdbctemp.query(sql, new RowMapper<Employee>() {
			public Employee mapRow(ResultSet rs, int row) throws SQLException {
				Employee e = new Employee();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setSalary(rs.getInt(3));
				e.setDepartment(rs.getString(4));
				e.setTimestamp(rs.getTimestamp(5));
				return e;
			}
		});
	}

    
    
    public List<Employee> getEmployeesByPageLast(int pageid, int total) {
    	
		String sql = "select * from Employee limit " + (pageid - 1) + "," + total;
		return jdbctemp.query(sql, new RowMapper<Employee>() {
			public Employee mapRow(ResultSet rs, int row) throws SQLException {
				Employee e = new Employee();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setSalary(rs.getInt(3));
				e.setDepartment(rs.getString(4));
				e.setTimestamp(rs.getTimestamp(5));
				return e;
			}
		});
	}
}
