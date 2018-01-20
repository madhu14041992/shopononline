package web.shop.shoponlinebackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import web.shop.shoponlinebackend.dao.CategoryDAO;
import web.shop.shoponlinebackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories=new ArrayList<>();
	
	static{
		Category category=new Category();
		category.setId(1);
		category.setName("Television");
		category.setDescription("Television");
		category.setImageUrl("cat1.png");
		categories.add(category);
		
		category=new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("Mobile");
		category.setImageUrl("cat2.png");
		categories.add(category);
		
		category=new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("Laptop");
		category.setImageUrl("cat3.png");
		categories.add(category);
	}
	@Override
	public List<Category> listOfCategory() {
		
		return categories;
	}
	@Override
	public Category getCategoryById(int id) {
		//enhanched for loop
		for (Category category : categories) {
			if(category.getId() == id){
				return category;
			}
		}
		return null;
	}

}
