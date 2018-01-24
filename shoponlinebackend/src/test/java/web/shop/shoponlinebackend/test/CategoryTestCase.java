package web.shop.shoponlinebackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import web.shop.shoponlinebackend.dao.CategoryDAO;
import web.shop.shoponlinebackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	@BeforeClass
	public static void init(){ 
		context =new AnnotationConfigApplicationContext();
		context.scan("web.shop.shoponlinebackend");
		context.refresh();
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	}
	
	/*@Test
	public void testAddCategory(){
		
		category=new Category();
		category.setName("Laptop");
		category.setDescription("This is some description for Laptop!");
		category.setImageUrl("CAT10_png");
		category.setActive(true);
		categoryDAO.addCategory(category);
		assertEquals("Successfully added a category inside the table!",true,categoryDAO.addCategory(category));
	}*/
	
	/*@Test
	public void testGetCategory(){
		category=categoryDAO.getCategoryById(3);
		System.out.println(category.getName());
		assertEquals("Successfully fetched a single category from the table!","Television",category.getName());
	}*/
	@Test
	public void testCRUDCategory() {
		
		// add operation
		category = new Category();
		
		category.setName("Laptop");
		category.setDescription("This is some description for laptop!");
		category.setImageUrl("CAT_1.png");
		
		
		
		category = new Category();
		
		category.setName("Television");
		category.setDescription("This is some description for television!");
		category.setImageUrl("CAT_2.png");
		
		assertEquals("Successfully added a category inside the table!",true,categoryDAO.addCategory(category));

		
		// fetching and updating the category
		category = categoryDAO.getCategoryById(2);
		
		category.setName("TV");
		
		assertEquals("Successfully updated a single category in the table!",true,categoryDAO.updateCategory(category));
		
		
		// delete the category
		assertEquals("Successfully deleted a single category in the table!",true,categoryDAO.deleteCategory(category));
		
		
		//fetching the list
		assertEquals("Successfully fetched the list of categories from the table!",1,categoryDAO.listOfCategory().size());		
				
		
	}
}
