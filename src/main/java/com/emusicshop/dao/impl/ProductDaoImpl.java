package com.emusicshop.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.emusicshop.dao.ProductDao;
import com.emusicshop.model.Product;


@Repository("jdbctemplate")
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Product> getProductList() {
		String sql = "SELECT * FROM products";
		  return jdbcTemplate.query(sql, new RowMapper() {		  
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setProductName(rs.getString("productname"));
				product.setProductCategory(rs.getString("productcategory"));
				product.setProductDecription(rs.getString("productdecription"));
				product.setProductPrice(rs.getDouble("productprice"));
				product.setProductCondition(rs.getString("productcondition"));
				product.setProductStatus(rs.getString("productstatus"));
				product.setUnitInStock(rs.getString("unitInstock"));
				product.setProductManufacturer("productmanufacturer");
				
			    return product;
			}
		 
		  });
	}

	public Product getProductById(int id) {
		String sql = "SELECT * FROM products WHERE id = ?";
		return jdbcTemplate.query(sql , new Object[]{ id }, new ResultSetExtractor<Product>() {

		   public Product extractData(ResultSet rs) throws SQLException, DataAccessException {
			   if(rs.next()) {
				   Product product = new Product();
				   product.setId(rs.getInt("id"));
				   product.setProductName(rs.getString("productname"));
				   product.setProductCategory(rs.getString("productcategory"));
				   product.setProductDecription(rs.getString("productdecription"));
				   product.setProductPrice(rs.getDouble("productprice"));
				   product.setProductCondition(rs.getString("productcondition"));
				   product.setProductStatus(rs.getString("productstatus"));
				   product.setUnitInStock(rs.getString("unitInstock"));
				   product.setProductManufacturer("productmanufacturer");
				   return product;
		    }
			   return null;
		   }
		  });
	}

	
	public void addProduct(Product product) {
		String sql = "INSERT INTO products"
				+ "(productname, productcategory, productdecription, productprice, productcondition, productstatus, unitinstock,productmanufacturer) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql , new Object[]
					{product.getProductName(), product.getProductCategory(), product.getProductDecription(), product.getProductPrice(),
					product.getProductCondition(), product.getProductStatus(), product.getUnitInStock(), product.getProductManufacturer()});
		
	}

	public void editProduct(Product product) {
		// TODO Auto-generated method stub
		
	}

	
	public void deleteProduct(int id) {
		String sql = "DELETE FROM products WHERE id=?";
		 jdbcTemplate.update(sql , new Object[]{ id });
	}

}
