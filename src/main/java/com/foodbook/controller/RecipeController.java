package com.foodbook.controller;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.foodbook.model.Recipe;
import com.foodbook.model.RecipeService;
import com.foodbook.model.User;
import com.foodbook.repository.CategoryRepository;
import com.foodbook.repository.RecipeRepository;

@Controller
public class RecipeController {
	
	@Autowired
	RecipeService rRep;
	
	@Autowired
	CategoryRepository cRep;
	
	@RequestMapping(value="/auth/new/Recipe", method=RequestMethod.POST, name="new_recipe")
	public ModelAndView recipeRegister(Recipe recipe, HttpServletRequest request){
		ModelAndView mv = new ModelAndView("/auth/recipeRegister");
		
		try{
			User currentUser = (User) SecurityContextHolder.getContext()
				    .getAuthentication()
					.getPrincipal();

			
			recipe.setPublishedBy(currentUser);
			recipe.setPublicationDate(new Date());
			//I think we can put some status
			
			rRep.saveRecipe(recipe);
			
			
						
			
		}catch(Exception e){
			e.printStackTrace();
			//We can insert something here, like a message
		}				
		return mv;
	}
}
