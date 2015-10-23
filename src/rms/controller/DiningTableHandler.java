package rms.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import rms.po.CustomdiningTable;
import rms.service.DiningTableService;

/**
 * 
* @ClassName: DiningTableHandler 
* @Description: 餐桌信息处理器 
* @author random  
* @date 2015年7月16日 上午9:35:06 
*
 */
@Controller
@RequestMapping("diningTable")
public class DiningTableHandler {
	/**
	 * 注入餐桌serivce
	 */
	@Resource
	private DiningTableService diningTableService;

	/**
	 * 
	 * @Title: getAllDiningTableofManager
	 * @Description: 查询所有餐桌信息用于餐桌管理
	 * @param @return
	 * @param @throws Exception 设定文件
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping("getAllDiningTableofManager")
	public ModelAndView getAllDiningTableofManager() throws Exception {

		List<CustomdiningTable> diningTables = diningTableService
				.findAllDiningTable();

		ModelAndView mav = new ModelAndView();
		mav.addObject("diningTables", diningTables);
		mav.setViewName("diningTable/diningTableList");
		return mav;
	}
	
	
	/**
	 * 
	* @Title: getAllDiningTableoforder 
	* @Description: 查询所有餐桌信息用于订单
	* @param @return
	* @param @throws Exception    设定文件 
	* @return ModelAndView    返回类型 
	* @throws
	 */
	@RequestMapping("getAllDiningTableoforder")
	public ModelAndView getAllDiningTableoforder() throws Exception {

		List<CustomdiningTable> diningTables = diningTableService
				.findAllDiningTable();

		ModelAndView mav = new ModelAndView();
		mav.addObject("diningTables", diningTables);
		mav.setViewName("order/diningTableList");
		return mav;
	}
	/**
	 * 
	* @Title: addDiningTable 
	* @Description: 为添加页面准备数据
	* @param @param model
	* @param @return
	* @param @throws Exception    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	@RequestMapping("addDiningTable")
	public String addDiningTable(Model model) throws Exception {

		CustomdiningTable customdiningTable = diningTableService
				.findDiningTableDefultImage();
		model.addAttribute("customdiningTableImage", customdiningTable);
		// return "redirect:";
		return "diningTable/saveOrEditdiningTable";
	}
	/**
	 * 
	* @Title: addDiningTableSubmit 
	* @Description: 添加餐桌,同时保存餐桌图片
	* @param @param request
	* @param @param customdiningTable
	* @param @param freeimageFile
	* @param @param busyimageFile
	* @param @return
	* @param @throws Exception    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	@RequestMapping("addDiningTableSubmit")
	public String addDiningTableSubmit(HttpServletRequest request,
			@Validated CustomdiningTable customdiningTable,BindingResult bindingResult,Model model,
			MultipartFile freeimageFile, MultipartFile busyimageFile)
			throws Exception {
		if(bindingResult.hasErrors()){
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			model.addAttribute("diningTable", customdiningTable);
			model.addAttribute("errors", allErrors);
			return "forward:addDiningTable.action";
		}
		
		if(freeimageFile!=null && busyimageFile!=null){
			diningTableService.uploadImage(freeimageFile,busyimageFile,customdiningTable);
		}
		diningTableService.saveDiningTable(customdiningTable);
		return "redirect:getAllDiningTableofManager.action";
	}
	/**
	 * 
	* @Title: editDiningTable 
	* @Description: 未修改页面准备数据
	* @param @param id
	* @param @return
	* @param @throws Exception    设定文件 
	* @return ModelAndView    返回类型 
	* @throws
	 */
	@RequestMapping("editDiningTable")
	public ModelAndView editDiningTable(Integer id)throws Exception{
		CustomdiningTable customdiningTable=diningTableService.findDiningTableById(id);
		
		CustomdiningTable customdiningTableImage = diningTableService
				.findDiningTableDefultImage();
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("customdiningTableImage", customdiningTableImage);
		mav.addObject("diningTable", customdiningTable);
		mav.setViewName("diningTable/saveOrEditdiningTable");
		return mav;
	}
	/**
	 * 
	* @Title: editDiningTableSubmit 
	* @Description: 修改餐桌数据 
	* @param @param id
	* @param @param customdiningTable
	* @param @return
	* @param @throws Exception    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	@RequestMapping("editDiningTableSubmit")
	public String editDiningTableSubmit(Integer id,@Validated CustomdiningTable customdiningTable
			,BindingResult bindingResult,Model model)throws Exception{
		if(bindingResult.hasErrors()){
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			model.addAttribute("diningTable", customdiningTable);
			model.addAttribute("errors", allErrors);
			return "forward:addDiningTable.action";
		}
		diningTableService.updateDiningTableById(id, customdiningTable);
		
		return "redirect:getAllDiningTableofManager.action";
	}
	/**
	 * 
	* @Title: deleteDiningTable 
	* @Description: 根据id删除餐桌
	* @param @param id
	* @param @return
	* @param @throws Exception    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	@RequestMapping("deleteDiningTable")
	public String deleteDiningTable(Integer id) throws Exception{
		diningTableService.deleteDiningTableByID(id);
		return "redirect:getAllDiningTableofManager.action";
	}

	/**
	 * 
	* @Title: changeDiningTableState 
	* @Description: 修改餐桌信息
	* @param @param id
	* @param @param currtstate
	* @param @return
	* @param @throws Exception    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	@RequestMapping("changeDiningTableState")
	public String changeDiningTableState(Integer id,Boolean currtstate) throws Exception{
		diningTableService.updateStateById(id, !currtstate);;
		return "redirect:getAllDiningTableofManager.action";
	}
	
	/**
	 * 
	* @Title: changeImage 
	* @Description: 
	* @param @param freeimageFile
	* @param @param busyimageFile
	* @param @return
	* @param @throws Exception    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	@RequestMapping("changeImage")
	public String changeImage(MultipartFile freeimageFile, MultipartFile busyimageFile)  throws Exception{
		return "diningTable/changeImage";
	}
	
	/**
	 * 
	* @Title: changeImageSubmit 
	* @Description: 改变桌面背景 
	* @param @param freeimageFile
	* @param @param busyimageFile
	* @param @return
	* @param @throws Exception    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	@RequestMapping("changeImageSubmit")
	public String changeImageSubmit(MultipartFile freeimageFile, MultipartFile busyimageFile) throws Exception{
		
		if(freeimageFile!=null && busyimageFile!=null){
			diningTableService.updateImage(freeimageFile,busyimageFile);
		}
		
		return "redirect:getAllDiningTableofManager.action";
	}
	
	

}
