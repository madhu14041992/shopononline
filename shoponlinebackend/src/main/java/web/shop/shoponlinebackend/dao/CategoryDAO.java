package web.shop.shoponlinebackend.dao;

import java.util.List;

import web.shop.shoponlinebackend.dto.Category;

public interface CategoryDAO {
	
	boolean addCategory(Category category);

	List<Category> listOfCategory();

	Category getCategoryById(int id);
}
