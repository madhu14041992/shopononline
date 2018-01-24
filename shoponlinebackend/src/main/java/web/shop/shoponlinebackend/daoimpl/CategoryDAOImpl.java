package web.shop.shoponlinebackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import web.shop.shoponlinebackend.dao.CategoryDAO;
import web.shop.shoponlinebackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Category> listOfCategory() {
String selectActiveCategory = "FROM Category WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
				
		query.setParameter("active", true);
						
		return query.getResultList();
	
	}
	/*
	 * Getting Single Category Based on Id
	 * */
	@Override
	public Category getCategoryById(int id) {
		
		return sessionFactory.getCurrentSession().get(Category.class,Integer.valueOf(id));
		 
	}
	@Override
	public boolean addCategory(Category category) {
		try {
			//add the  category to the database table
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean updateCategory(Category category) {
		try {
			//update the  category to the database table
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean deleteCategory(Category category) {
		return false;
	}

}
