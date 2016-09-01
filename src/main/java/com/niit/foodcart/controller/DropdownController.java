package com.niit.foodcart.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.foodcart.dao.impl.FoodproductsDao;
import com.niit.foodcart.model.Foodproducts;
import com.niit.foodcart.service.impl.FoodproductsService;

@Controller
public class DropdownController {

	@Autowired
	private FoodproductsService foodproductsservice;
	@Autowired
	private FoodproductsDao foodproductsDao;
	
	@RequestMapping(value="/veg")
	public String getCategory(Map<String, Object>map)
	{
		Foodproducts foodproducts = new Foodproducts();
		String category="vegetarian";
		map.put("foodproducts", foodproducts);
		map.put("foodproductsList", foodproductsservice.getAllvegetarianproducts(category));
		return "viewall";
	}
	
	@RequestMapping(value="/nonveg")
	public String getCategory1(Map<String, Object>map)
	{
		Foodproducts foodproducts = new Foodproducts();
		String category="non-vegetarian";
		map.put("foodproducts", foodproducts);
		map.put("foodproductsList", foodproductsservice.getAllvegetarianproducts(category));
		return "viewall";
	}
	@RequestMapping(value="/snack")
	public String getCategory2(Map<String, Object>map)
	{
		Foodproducts foodproducts = new Foodproducts();
		String category="snacks";
		map.put("foodproducts", foodproducts);
		map.put("foodproductsList", foodproductsservice.getAllvegetarianproducts(category));
		return "viewall";
	}
	@RequestMapping(value="/bev")
	public String getCategory3(Map<String, Object>map)
	{
		Foodproducts foodproducts = new Foodproducts();
		String category="beverages";
		map.put("foodproducts", foodproducts);
		map.put("foodproductsList", foodproductsservice.getAllvegetarianproducts(category));
		return "viewall";
	}
	
	@RequestMapping(value="edit/{productId}")
	public String edit(@PathVariable("productId")int productId,@ModelAttribute Foodproducts foodproducts,BindingResult result,Map<String, Object>map)
	{
		foodproducts=foodproductsservice.getFoodproducts(productId);
		map.put("foodproducts",foodproducts);
		map.put("foodproductsList", foodproductsservice.getAllFoodproducts());
		//System.out.println(foodproductsservice.getAllFoodproducts());
		return "frontcrud";
	}
	
	@RequestMapping(value="delete/{productId}")
	public String delete(@PathVariable("productId")int productId,@ModelAttribute Foodproducts foodproducts,BindingResult result,Map<String, Object>map)
	{
		foodproductsservice.delete(productId);
		map.put("foodproducts",foodproducts);
		map.put("foodproductsList", foodproductsservice.getAllFoodproducts());
		return "viewall";
	}
	@RequestMapping(value="/category")
	public String getcategory(Map<String, Object>map)
	{
		Foodproducts foodproducts = new Foodproducts();
		map.put("foodproducts", foodproducts);
		System.out.println(foodproductsDao.getAllcategory());
		map.put("category",foodproductsDao.getAllcategory());
		return "foodproducts" ;
	}
	
	@RequestMapping(value="view/{productId}")
	public String view(@PathVariable("productId")int productId,@ModelAttribute Foodproducts foodproducts,BindingResult result,Map<String, Object>map)
	{
		foodproducts=foodproductsservice.getFoodproducts(productId);
		map.put("foodproducts",foodproducts);
		map.put("foodproductsList", foodproductsservice.getAllFoodproducts());
		//System.out.println(foodproductsservice.getAllFoodproducts());
		return "view";
	}
}


