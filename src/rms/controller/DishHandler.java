package rms.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import rms.po.Customcategory;
import rms.po.Customdish;
import rms.po.Custommaterials;
import rms.po.category;
import rms.po.dishImage;
import rms.po.materials;
import rms.service.CategoryService;
import rms.service.DishService;
import rms.service.MaterialsService;
import rms.untils.FileUtils;
import rms.untils.StringUtils;

/**
 * 
* @ClassName: DishHandler 
* @Description: 菜品信息处理器
* @author random  
* @date 2015年7月20日 下午3:32:15 
*
 */
@Controller
@RequestMapping("dish")
public class DishHandler {
	
	@Resource
	private DishService dishService;
	@Resource
	private CategoryService categoryService;
	@Resource
	private MaterialsService materialsService;
	
	/**
	 * @throws Exception 
	 * 
	* @Title: findAllDish 
	* @Description: 查询所有菜品基础信息
	* @param @return    设定文件 
	* @return ModelAndView    返回类型 
	* @throws
	 */
	@RequestMapping("findAllDish")
	public ModelAndView findAllDish() throws Exception{
		List<Customdish> dishs=dishService.findAllDish();
		List<Customcategory> categorys=categoryService.findAllCategory();
		ModelAndView mav=new ModelAndView();
		mav.addObject("dishs", dishs);
		mav.addObject("categorys", categorys);
		mav.setViewName("dish/dishList");
		return mav;
	}
	/**
	 * 
	* @Title: findDishdetails 
	* @Description: 根据id查询详细信息
	* @param @param id
	* @param @return    设定文件 
	* @return ModelAndView    返回类型 
	* @throws
	 */
	@RequestMapping("findDishdetails")
	public ModelAndView findDishdetails(Integer id) throws Exception{
		
		ModelAndView mav=new ModelAndView();
		
		Customdish customdish=dishService.findDishWithImageById(id);
		
		category category=categoryService.findCategoryById(customdish.getRcategoryid());
		
//		List<materials> materialslist=materialsService.findMaterialsByIds(customdish.getRmaterialsid());
//		
//		List<Customdish> Auxiliarydishes=dishService.findDishByIds(customdish.getAuxiliarydishes());
		
//		mav.addObject("auxiliarydishes", Auxiliarydishes);
//		mav.addObject("materialslist", materialslist);
		
		mav.addObject("auxiliarydishes", customdish.getSub_customdish());
		mav.addObject("materialslist", customdish.getCustommaterials());
		
		mav.addObject("categoryName", category.getName());
		mav.addObject("dish", customdish);
		mav.setViewName("dish/dishdetailsList");
		return mav;
	}
	/**
	 * 
	* @Title: saveDish 
	* @Description: 跳转到保存页面
	* @param @return
	* @param @throws Exception    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	@RequestMapping("addDish")
	public ModelAndView addDish() throws Exception{
		
		List<Customcategory> categorys=categoryService.findAllCategory();
		
		List<Custommaterials> Materials=materialsService.findAllMaterials();
		
		List<Customdish> dishs=dishService.findAllDish();
		
		ModelAndView mav=new ModelAndView();
		
		mav.addObject("categorys", categorys);
		mav.addObject("Materials", Materials);
		mav.addObject("Dishes", dishs);
		
		mav.setViewName("dish/saveOrEditdish");
		
		return mav;
	}
	/**
	 * 
	* @Title: addDishSubmit 
	* @Description: 添加菜品信息
	* @param @param customdish
	* @param @param dishImages
	* @param @return
	* @param @throws Exception    设定文件 
	* @return ModelAndView    返回类型 
	* @throws
	 */
	@RequestMapping("addDishSubmit")
	public String addDishSubmit(@Validated Customdish customdish,BindingResult bindingResult
			,Model model,@RequestParam("dishImages") MultipartFile[] dishImages,String[] MaterialsId,String[] MaterialsQuantity,String[] auxiliaryDish,String[] subDishQuantity) throws Exception{
		ModelAndView mav=new ModelAndView();
		if(bindingResult.hasErrors()){
			model.addAttribute("errors", bindingResult.getAllErrors());
			// return "redirect:";
			return "dish/saveOrEditdish";
		}
		if(dishImages!=null && dishImages.length>0){
		List<dishImage> images=dishService.uploadImage(dishImages);
		customdish.setDishImagesList(images);
		}
		
//		String MaterialsIds=StringUtils.Array2String(MaterialsId);
//		String auxiliaryDishes=StringUtils.Array2String(auxiliaryDish);
		
		//对数量数组进行处理
		MaterialsQuantity=StringUtils.TrimNullcharacter(MaterialsQuantity);
		subDishQuantity=StringUtils.TrimNullcharacter(subDishQuantity);
		
		List custommaterials=new ArrayList<>();
		List sub_customdish=new ArrayList<>();
		if(MaterialsId!=null && MaterialsId.length>0&&MaterialsQuantity!=null){
			for(int i=0;i<MaterialsId.length;i++){
				Custommaterials cm=new Custommaterials();
				cm.setQuantity(BigDecimal.valueOf(Double.valueOf(MaterialsQuantity[i])));
				cm.setId(Integer.parseInt(MaterialsId[i]));
				custommaterials.add(cm);
			}
		}
		if(auxiliaryDish!=null && auxiliaryDish.length>0&&subDishQuantity!=null){
			for(int i=0;i<auxiliaryDish.length&&i<subDishQuantity.length;i++){
				Customdish cd=new Customdish();
				
				cd.setId(Integer.parseInt(auxiliaryDish[i]));
				
				cd.setSub_customdish_quantity(Integer.parseInt(subDishQuantity[i]));
				
				sub_customdish.add(cd);
				
			}
		}
		
		customdish.setCustommaterials(custommaterials);
		customdish.setSub_customdish(sub_customdish);
		
//		customdish.setAuxiliarydishes(auxiliaryDishes);
//		customdish.setRmaterialsid(MaterialsIds);
		
		dishService.saveDish(customdish);
		
		return "redirect:findAllDish.action";	
	}
	/**
	 * 
	* @Title: editDish 
	* @Description: 为修改菜品页面准备数据
	* @param @param id
	* @param @return
	* @param @throws Exception    设定文件 
	* @return ModelAndView    返回类型 
	* @throws
	 */
	@RequestMapping("editDish")
	public ModelAndView editDish(Integer id) throws Exception{
		ModelAndView mav=new ModelAndView();
		
		List<Customcategory> categorys=categoryService.findAllCategory();
		
		List<Custommaterials> Materials=materialsService.findAllMaterials();
		
		List<Customdish> dishs=dishService.findAllDish();
		
		//查询菜品所有信息
		Customdish customdish=dishService.findDishWithImageById(id);
		
		
//		String[] hasAuxiliarydishes=StringUtils.String2Array(customdish.getAuxiliarydishes());
//		
//		String[] hasMaterialsid=StringUtils.String2Array(customdish.getRmaterialsid());
		
		mav.addObject("hasAuxiliarydishesid",StringUtils.Array2String(getdishesOfString(customdish)));
		mav.addObject("hasAuxiliarydishesQuantitys", StringUtils.Array2String(getdishesQuantitysOfString(customdish)));
		mav.addObject("hasMaterialsid", StringUtils.Array2String(getMaterialsidOfString(customdish)));
		mav.addObject("hasMaterialsQuantitys", StringUtils.Array2String(getMaterialsQuantitysOfString(customdish)));
		/*mav.addObject("hasAuxiliarydishesid",getdishesOfString(customdish));
		mav.addObject("hasAuxiliarydishesQuantitys",getdishesQuantitysOfString(customdish));
		mav.addObject("hasMaterialsid",getMaterialsidOfString(customdish));
		mav.addObject("hasMaterialsQuantitys", getMaterialsQuantitysOfString(customdish));*/
		mav.addObject("dish", customdish);
		mav.addObject("categorys", categorys);
		mav.addObject("Materials", Materials);
		mav.addObject("Dishes", dishs);
		
		mav.setViewName("dish/saveOrEditdish");
		return mav;	
	}
	/**
	 * 
	* @Title: editDishSubmit 
	* @Description: 修改菜品基础信息
	* @param @param id
	* @param @param customdish
	* @param @param bindingResult
	* @param @param MaterialsId
	* @param @param auxiliaryDish
	* @param @return
	* @param @throws Exception    设定文件 
	* @return ModelAndView    返回类型 
	* @throws
	 */
	@RequestMapping("editDishSubmit")
	public ModelAndView editDishSubmit(Integer id,@Validated Customdish customdish,BindingResult bindingResult
			,String[] MaterialsId,String[] MaterialsQuantity,String[] auxiliaryDish,String[] subDishQuantity) throws Exception{
		ModelAndView mav=new ModelAndView();
		
		if(bindingResult.hasErrors()){
			mav.addObject("errors", bindingResult.getAllErrors());
			mav.setViewName("dish/saveOrEditdish");
			return mav;
		}
		
//		String MaterialsIds=StringUtils.Array2String(MaterialsId);
//		String auxiliaryDishes=StringUtils.Array2String(auxiliaryDish);
		
//		customdish.setAuxiliarydishes(auxiliaryDishes);
//		customdish.setRmaterialsid(MaterialsIds);
		
		//对数量数组进行处理
		MaterialsQuantity=StringUtils.TrimNullcharacter(MaterialsQuantity);
		subDishQuantity=StringUtils.TrimNullcharacter(subDishQuantity);
		
		List custommaterials=new ArrayList<>();
		List sub_customdish=new ArrayList<>();
		if(MaterialsId!=null && MaterialsId.length>0&&MaterialsQuantity!=null){
			for(int i=0;i<MaterialsId.length;i++){
				Custommaterials cm=new Custommaterials();
				cm.setQuantity(BigDecimal.valueOf(Double.valueOf(MaterialsQuantity[i])));
				cm.setId(Integer.parseInt(MaterialsId[i]));
				custommaterials.add(cm);
			}
		}
		if(auxiliaryDish!=null && auxiliaryDish.length>0&&subDishQuantity!=null){
			for(int i=0;i<auxiliaryDish.length&&i<subDishQuantity.length;i++){
				Customdish cd=new Customdish();
				
				cd.setId(Integer.parseInt(auxiliaryDish[i]));
				
				cd.setSub_customdish_quantity(Integer.parseInt(subDishQuantity[i]));
				
				sub_customdish.add(cd);
				
			}
		}
		
		customdish.setCustommaterials(custommaterials);
		customdish.setSub_customdish(sub_customdish);
		
		
		dishService.updateDish(id, customdish);
		
		mav.setViewName("redirect:findAllDish.action");
		
		return mav;	
	}
	/**
	 * 
	* @Title: deleteDish 
	* @Description: 根据id删除菜品
	* @param @param id
	* @param @return
	* @param @throws Exception    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	@RequestMapping("deleteDish")
	public String deleteDish(Integer id) throws Exception{
		dishService.deleteDish(id);
		return "redirect:findAllDish.action";
	}
	
	/**
	 * @throws Exception 
	 * 
	* @Title: getAllImageOfdish 
	* @Description: 根据菜品id查询菜品下所有图片，并进行操作
	* @param @param id
	* @param @return    设定文件 
	* @return ModelAndView    返回类型 
	* @throws
	 */
	@RequestMapping("getAllImageOfdish")
	public ModelAndView getAllImageOfdish(Integer id) throws Exception{
		
		ModelAndView mav=new ModelAndView();
		
		//查询菜品及图片集合
		Customdish dish=dishService.findDishWithImageById(id);
		
		mav.addObject("dish", dish);
		mav.setViewName("dish/dishImages");
		
		return mav;
	}
	/**
	 * 
	* @Title: deleteDishImage 
	* @Description: 根据图片id删除图片
	* @param @param dishid
	* @param @param imageid
	* @param @return
	* @param @throws Exception    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	@RequestMapping("deleteDishImage")
	public String deleteDishImage(Integer dishid,Integer imageid) throws Exception{
		
		dishService.deleteDishImageByImageid(imageid);
		
		return "redirect:getAllImageOfdish.action?id="+dishid;
	}
	/**
	 * 
	* @Title: addDishImage 
	* @Description: 为添加新图片准备数据
	* @param @param id
	* @param @return
	* @param @throws Exception    设定文件 
	* @return ModelAndView    返回类型 
	* @throws
	 */
	@RequestMapping("addDishImage")
	public ModelAndView addDishImage(Integer id) throws Exception{
		
		ModelAndView mav =new ModelAndView();
		Customdish dish=dishService.findDishWithImageById(id);
		mav.addObject("dish",dish);
		mav.setViewName("dish/adddishImage");
		
		return mav;
	}
	/**
	 * 
	* @Title: addDishImageSubmit 
	* @Description: 根据菜品id为菜品添加新图片
	* @param @param dishid
	* @param @param dishImages
	* @param @return
	* @param @throws Exception    设定文件 
	* @return ModelAndView    返回类型 
	* @throws
	 */
	@RequestMapping("addDishImageSubmit")
	public ModelAndView addDishImageSubmit(Integer dishid,@RequestParam("dishImages") MultipartFile [] dishImages ) throws Exception{
		
		ModelAndView mav=new ModelAndView();
		
		if(dishImages!=null && dishImages.length>=0){
			
			 List<dishImage> dishImageList=dishService.uploadImage(dishImages);
			 
			 dishService.saveDishImage(dishImageList,dishid);
		}
		
		String uri="redirect:getAllImageOfdish.action?id="+dishid;
		mav.setViewName(uri);
		
		return mav;
	}
	/**
	 * 
	* @Title: findDishsByType 
	* @Description: 根据分类id查询分类下的菜品
	* @param @param categoryId
	* @param @return
	* @param @throws Exception    设定文件 
	* @return ModelAndView    返回类型 
	* @throws
	 */
	@RequestMapping("findDishsByType")
	public ModelAndView findDishsByType(Integer categoryId) throws Exception{
		
		ModelAndView mav=new ModelAndView();
		
		List<Customdish> customdishs=dishService.findAllDishByType(categoryId);
		List<Customcategory> categorys=categoryService.findAllCategory();
		
		mav.addObject("categorys", categorys);
		mav.addObject("dishs", customdishs);
		mav.setViewName("dish/dishList");
		return mav;
		
	}
	/**
	 * 
	* @Title: getMaterialsQuantitysOfString 
	* @Description: 将菜品中的原料数量数组返回
	* @param @param customdish
	* @param @return    设定文件 
	* @return String[]    返回类型 
	* @throws
	 */
	private String[] getMaterialsQuantitysOfString(Customdish customdish) {
		String[] quantitys=new String[customdish.getCustommaterials().size()];
		ArrayList<String> temp=new ArrayList<String>();
		for(Custommaterials m:customdish.getCustommaterials()){
			temp.add(String.valueOf(m.getQuantity()));
		}
		quantitys=temp.toArray(quantitys);
		return quantitys;
	}
	/**
	 * 
	* @Title: getMaterialsidOfString 
	* @Description: 将菜品中的原料id数组返回
	* @param @param customdish
	* @param @return    设定文件 
	* @return String[]    返回类型 
	* @throws
	 */
	private String[] getMaterialsidOfString(Customdish customdish) {
		String[] id=new String[customdish.getCustommaterials().size()];
		ArrayList<String> temp=new ArrayList<String>();
		for(Custommaterials m:customdish.getCustommaterials()){
			temp.add(String.valueOf(m.getId()));
		}
		id=temp.toArray(id);
		return id;
	}
	/**
	 * 
	* @Title: getdishesQuantitysOfString 
	* @Description: 将菜品中的子菜品数量数组返回
	* @param @param customdish
	* @param @return    设定文件 
	* @return String[]    返回类型 
	* @throws
	 */
	private String[] getdishesQuantitysOfString(Customdish customdish) {
		String[] quantitys=new String[customdish.getSub_customdish().size()];
		ArrayList<String> temp=new ArrayList<String>();
		for(Customdish dish:customdish.getSub_customdish()){
			temp.add(String.valueOf(dish.getSub_customdish_quantity()));
		}
		quantitys=temp.toArray(quantitys);
		return quantitys;
	}
	/**
	 * 
	* @Title: getdishesOfString 
	* @Description: 将菜品中的菜品id返回
	* @param @param customdish
	* @param @return    设定文件 
	* @return String[]    返回类型 
	* @throws
	 */
	private String[] getdishesOfString(Customdish customdish) {
		String[] id=new String[customdish.getSub_customdish().size()];
		ArrayList<String> temp=new ArrayList<String>();
		for(Customdish dish:customdish.getSub_customdish()){
			temp.add(String.valueOf(dish.getId()));
		}
		id=temp.toArray(id);
		return id;
	}
	
	
	
	
	
	/**
	 * 
	 * 
	 * 
	 * json_ajax
	 * 
	 * 
	 * 
	 */
	/**
	 * 
	* @Title: findDishsByType 
	* @Description: 根据分类id查询分类下的菜品 返回json菜品信息 
	* @param @param categoryId
	* @param @return
	* @param @throws Exception    设定文件 
	* @return ModelAndView    返回类型 
	* @throws
	 */
	@RequestMapping("findDishsByTypeRetrunJson")
	public @ResponseBody List<Customdish> findDishsByTypeRetrunJson(Integer categoryId) throws Exception{
		List<Customdish> customdishs=dishService.findAllDishByType(categoryId);
		return customdishs;
	}
	/**
	 * 
	* @Title: findAllDishRetrunJson 
	* @Description: 查询所有菜品基础信息) 返回json菜品信息
	* @param @return
	* @param @throws Exception    设定文件 
	* @return ModelAndView    返回类型 
	* @throws
	 */
	@RequestMapping("findAllDishRetrunJson")
	public @ResponseBody List<Customdish> findAllDishRetrunJson() throws Exception{
		List<Customdish> dishs=dishService.findAllDish();
		return dishs;
	}
	/**
	 * 
	* @Title: finddishBysetMealIdRetrunJson 
	* @Description: 
	* @param @return
	* @param @throws Exception    
	* @return Customdish   
	* @throws
	 */
	@RequestMapping("finddishBysetMealIdRetrunJson")
	public @ResponseBody Customdish finddishBysetMealIdRetrunJson(Integer setMealId) throws Exception{
		Customdish setMeal= dishService.findDishWithImageById(setMealId);
		return setMeal;
	}
	
	
}
