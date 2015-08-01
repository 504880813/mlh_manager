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

import rms.po.Custommaterials;
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
		materialsService.updateMaterials(id, custommaterials);
		return "redirect:findAllmaterials.action";
	}

}
