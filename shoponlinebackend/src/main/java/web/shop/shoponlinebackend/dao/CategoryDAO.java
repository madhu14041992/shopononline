package web.shop.shoponlinebackend.dao;

import java.util.List;

import web.shop.shoponlinebackend.dto.Category;

public interface CategoryDAO {
	
	

	List<Category> listOfCategory();

	Category getCategoryById(int id);
	boolean addCategory(Category category);
	boolean updateCategory(Category category);
	boolean deleteCategory(Category category);
}
