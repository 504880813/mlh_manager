package rms.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import rms.po.Customcategory;
import rms.service.CategoryService;
/**
 * 
* @ClassName: CategoryHandler 
* @Description: 分类信息处理器
* @author random  
* @date 2015年7月16日 上午9:34:57 
*
 */
@Controller
@RequestMapping("category")
public class CategoryHandler {
	
	@Resource
	private CategoryService categoryService;
	/**
	 * 
	* @Title: findAllcategory 
	* @Description: 查询所有分类
	* @param @return
	* @param @throws Exception    设定文件 
	* @return ModelAndView    返回类型 
	* @throws
	 */
	@RequestMapping("findAllcategory")
	public ModelAndView findAllcategory() throws Exception{
		
		List<Customcategory> categorys=categoryService.findAllCategory();
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("categorys", categorys);
		mav.setViewName("category/categoryList");
		return mav;
	}
	/**
	 * 
	* @Title: addCategory 
	* @Description: 添加分类
	* @param @return
	* @param @throws Exception    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	@RequestMapping("addCategory")
	public String addCategory() throws Exception{ 
		return "category/saveOrEditcategory";
	}
	/**
	 * 
	* @Title: editCategory 
	* @Description: 为修改分类页面准备数据
	* @param @param id
	* @param @return
	* @param @throws Exception    设定文件 
	* @return ModelAndView    返回类型 
	* @throws
	 */
	@RequestMapping("editCategory")
	public ModelAndView editCategory(Integer id) throws Exception{
		Customcategory category=categoryService.findCategoryById(id);
		ModelAndView mav=new ModelAndView();
		mav.addObject("category", category);
		mav.setViewName("category/saveOrEditcategory");
		return mav;
	}
	/**
	 * 
	* @Title: deleteCategory 
	* @Description: 根据id删除分类
	* @param @param id
	* @param @return
	* @param @throws Exception    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	@RequestMapping("deleteCategory")
	public String deleteCategory(Integer id) throws Exception{
		categoryService.deleteCategory(id);
		return "redirect:findAllcategory.action";
	}
	/**
	 * 
	* @Title: addCategorySubmit 
	* @Description: 添加分类
	* @param @param customcategory
	* @param @param bindingResult
	* @param @param model
	* @param @return
	* @param @throws Exception    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	@RequestMapping("addCategorySubmit")
	public String addCategorySubmit(@Validated Customcategory customcategory,BindingResult bindingResult,Model model) throws Exception{
		
		if(bindingResult.hasErrors()){
			List<ObjectError> errors = bindingResult.getAllErrors();
			model.addAttribute("category", customcategory);
			model.addAttribute("errors", errors);
			return "forward:addCategory.action";
		}
		
		categoryService.saveCategory(customcategory);
		return "redirect:findAllcategory.action";
	}
	/**
	 * 
	* @Title: editCategorySubmit 
	* @Description: 更新分类 
	* @param @param id
	* @param @param customcategory
	* @param @param bindingResult
	* @param @param model
	* @param @return
	* @param @throws Exception    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	@RequestMapping("editCategorySubmit")
	public String editCategorySubmit(Integer id,@Validated Customcategory customcategory,BindingResult bindingResult,Model model) throws Exception{
		if(bindingResult.hasErrors()){
			List<ObjectError> errors = bindingResult.getAllErrors();
			model.addAttribute("category", customcategory);
			model.addAttribute("errors", errors);
			return "forward:editCategory.action";
		}
		categoryService.updateCategory(id, customcategory);
		return "redirect:findAllcategory.action";
	}
	
	
}
