package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.RequestScope;

import com.example.demo.domain.Item;

@Repository
@RequestScope
public interface IItemRepository extends JpaRepository<Item,Integer> {
	
	@Query(
			  value = "SELECT * FROM item i WHERE i.IsDiscounted = 1", 
			  nativeQuery = true)
	public List<Item> getDiscountedItems();
	
	@Query(
			  value = "SELECT * FROM item i WHERE i.IsDiscounted = 0", 
			  nativeQuery = true)
	public List<Item> getItemsWithoutDiscount();
	
	
	@Query(
			value="SELECT\r\n"
					+ "	i.ItemId,i.CategoryId,i.SizeId,i.Name,i.UnitPrice,i.Description,i.IsDiscounted,i.DiscountRate\r\n"
					+ "FROM\r\n"
					+ "	Item i inner join Category c\r\n"
					+ "		on i.CategoryId=c.CategoryId\r\n"
					+ "WHERE c.CategoryId=?1", 
			  nativeQuery = true)
	public List<Item> getItemsByCategory(int CategoryId);
	
	
	@Query(
			value="SELECT\r\n"
					+ "	i.ItemId,i.CategoryId,i.SizeId,i.Name,i.UnitPrice,i.Description,i.IsDiscounted,i.DiscountRate\r\n"
					+ "FROM\r\n"
					+ "	Item i inner join Category c\r\n"
					+ "		on i.CategoryId=c.CategoryId\r\n"
					+ "WHERE c.CategoryId=?1 AND c.Gender=?2", 
			  nativeQuery = true)
	public List<Item> getItemsByGenderAndCategory(String Gender,int CategoryId);
	

}
