package rms.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import rms.po.Custommaterials;
import rms.po.materials;
import rms.po.materialsRecord;
import rms.service.MaterialsService;

/**
 * 
 * @ClassName: MaterialsHandler
 * @Description: 原料处理器
 * @author random
 * @date 2015年7月16日 下午4:01:19
 * 
 */
@Controller
@RequestMapping("materials")
public class MaterialsHandler {
	@Resource
	private MaterialsService materialsService;

	/**
	 * 
	 * @Title: findAllmaterials
	 * @Description: 查询所有原料
	 * @param @return
	 * @param @throws Exception 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping("findAllmaterials")
	public ModelAndView findAllmaterials() throws Exception {

		List<Custommaterials> materials = materialsService.findAllMaterials();

		ModelAndView mav = new ModelAndView();
		mav.addObject("materials", materials);
		mav.setViewName("materials/materialsList");
		return mav;
	}
	/**
	 * 
	* @Title: addmaterials 
	* @Description: 为添加原料准备数据
	* @param @return
	* @param @throws Exception    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	@RequestMapping("addmaterials")
	public String addmaterials() throws Exception {
		return "materials/saveOrEditmaterials";
	}
	/**
	 * 
	* @Title: editmaterials 
	* @Description: 为修改原料准备数据
	* @param @param id
	* @param @return
	* @param @throws Exception    设定文件 
	* @return ModelAndView    返回类型 
	* @throws
	 */
	@RequestMapping("editmaterials")
	public ModelAndView editmaterials(Integer id) throws Exception {
		Custommaterials materials = materialsService.findMaterialsById(id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("materials", materials);
		mav.setViewName("materials/saveOrEditmaterials");
		return mav;
	}
	/**
	 * 
	* @Title: deletematerials 
	* @Description: 删除原料
	* @param @param id
	* @param @return
	* @param @throws Exception    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	@RequestMapping("deletematerials")
	public String deletematerials(Integer id) throws Exception {
		materialsService.deleteMaterials(id);
		return "redirect:findAllmaterials.action";
	}
	/**
	 * 
	* @Title: addmaterialsSubmit 
	* @Description: 添加原料
	* @param @param custommaterials
	* @param @param bindingResult
	* @param @param model
	* @param @return
	* @param @throws Exception    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	@RequestMapping("addmaterialsSubmit")
	public String addmaterialsSubmit(
			@Validated Custommaterials custommaterials,
			BindingResult bindingResult, Model model) throws Exception {

		if (bindingResult.hasErrors()) {
			List<ObjectError> errors = bindingResult.getAllErrors();
			model.addAttribute("materials", custommaterials);
			model.addAttribute("errors", errors);
			return "forward:addmaterials.action";
		}
		materialsService.saveMaterials(custommaterials);
		return "redirect:findAllmaterials.action";
	}
	/**
	 * 
	* @Title: editmaterialsSubmit 
	* @Description: 修改原料
	* @param @param id
	* @param @param custommaterials
	* @param @param bindingResult
	* @param @param model
	* @param @return
	* @param @throws Exception    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	@RequestMapping("editmaterialsSubmit")
	public String editmaterialsSubmit(Integer id,
			@Validated Custommaterials custommaterials,
			BindingResult bindingResult, Model model) throws Exception {
		if (bindingResult.hasErrors()) {
			List<ObjectError> errors = bindingResult.getAllErrors();
			model.addAttribute("materials", custommaterials);
			model.addAttribute("errors", errors);
			return "forward:editmaterials.action";
		}
		materialsService.updateMaterials(id, custommaterials,null);
		return "redirect:findAllmaterials.action";
	}
	
	
	/**
	 * 进货相关
	 */
	/**
	 * 
	* @Title: Purchase 
	* @Description: 跳转到进货页面
	* @param @return
	* @param @throws Exception    
	* @return ModelAndView    
	* @throws
	 */
	@RequestMapping("purchase")
	public ModelAndView Purchase() throws Exception{
	    
	    ModelAndView mav=new ModelAndView();
	    
	    List<Custommaterials> custommaterialsList=materialsService.findAllMaterials();
	    
	    mav.addObject("custommaterialsList", custommaterialsList);
	    
	    mav.setViewName("materials/purchase");

	    return mav;
	}
	/**
	 * 
	* @Title: PurchaseSubMit 
	* @Description: 进货
	* @param @return
	* @param @throws Exception    
	* @return String    
	* @throws
	 */
	@RequestMapping("purchaseSubMit")
	public String PurchaseSubMit(materials record) throws Exception{
	    materialsService.saveMaterials(record);
	    return "redirect:findAllmaterials.action";
	}
	
	@RequestMapping("findmaterialsRecordPage")
	public ModelAndView findmaterialsRecordPage() throws Exception{
	    
	    List<Custommaterials> custommaterialsList=materialsService.findAllMaterials();
	    
	    
	    ModelAndView mav=new ModelAndView();
	    
	    mav.addObject("custommaterialsList", custommaterialsList);
	    
	    mav.setViewName("materials/materialsRecordList");
	    
	    return mav;
	}
	
	
	/**
	 * 
	* @Title: findmaterialsRecord 
	* @Description: 查询原料的存取记录
	* @param @param name
	* @param @return
	* @param @throws Exception    
	* @return ModelAndView    
	* @throws
	 */
	@RequestMapping("findmaterialsRecord")
	public ModelAndView findmaterialsRecord(Integer id) throws Exception{
	    List<materialsRecord> materialsRecords=materialsService.findMaterialsRecordByMaterialName(materialsService.findMaterialsById(id).getName());
	    List<Custommaterials> materialsList=materialsService.findAllMaterials();
	    ModelAndView mav=new ModelAndView();
	    mav.addObject("materialsRecords", materialsRecords);
	    mav.addObject("materialsList", materialsList);
	    mav.setViewName("materials/materialsRecordList");
	    return mav;
	}
	/**
	 * 
	* @Title: findmaterialsRecordofNameAndTime 
	* @Description: 根据原料名称查询一段时间的存取记录 
	* @param @param name
	* @param @param startTime
	* @param @param endTime
	* @param @return
	* @param @throws Exception    
	* @return ModelAndView    
	* @throws
	 */
	@RequestMapping("findmaterialsRecordofNameAndTime")
	public ModelAndView findmaterialsRecordofNameAndTime(String name,Date startTime,Date endTime) throws Exception{
	    
	    
	    List<materialsRecord> materialsRecords=materialsService.findMaterialsRecordByMaterialNameAndTime(name, startTime, endTime);
	   
	    List<Custommaterials> materialsList=materialsService.findAllMaterials();
	    
	    ModelAndView mav=new ModelAndView();
	    
	    mav.addObject("materialsRecords", materialsRecords);
	    mav.addObject("materialsList", materialsList);
	    
	    mav.setViewName("materials/materialsRecordList");
	    
	    return mav;
	}
	
	/**
	 * 
	* @Title: findmaterialsRecordofNameAndTimeofJson 
	* @Description: 根据名称和时间来查询存取记录返回json
	* @param @param name
	* @param @param startTime
	* @param @param endTime
	* @param @throws Exception    
	* @return List<materialsRecord>     
	* @throws
	 */
	@RequestMapping("findmaterialsRecordofNameAndTimeofJson")
	public @ResponseBody List<materialsRecord> findmaterialsRecordofNameAndTimeofJson(String name,Date startTime,Date endTime) throws Exception{
	    
	    List<materialsRecord> materialsRecords=materialsService.findMaterialsRecordByMaterialNameAndTime(name, startTime, endTime);
	    
	    return materialsRecords;
	}
	
	

}
