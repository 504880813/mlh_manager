package rms.po;

import java.util.List;

/**
 * 
* @ClassName: Customdish 
* @Description: 自定义菜品扩充类
* @author random  
* @date 2015年7月16日 下午4:21:51 
*
 */
public class Customdish extends dish{
    
	/**
	 * 保存多组该菜品的图片
	 */
	private List<dishImage> dishImagesList;
	/**
	 * 菜品类包含的所有原料
	 */
	private List<Custommaterials> custommaterials;
	/**
	 * 拼盘内包含的子菜品
	 */
	private List<Customdish> sub_customdish;
	/**
	 * 拼盘类子菜品类的，各个菜品的数量
	 */
	private Integer sub_customdish_quantity;
	
//	private String[] 

	public List<dishImage> getDishImagesList() {
		return dishImagesList;
	}

	public void setDishImagesList(List<dishImage> dishImagesList) {
		this.dishImagesList = dishImagesList;
	}

	public List<Custommaterials> getCustommaterials() {
		return custommaterials;
	}

	public void setCustommaterials(List<Custommaterials> custommaterials) {
		this.custommaterials = custommaterials;
	}

	public List<Customdish> getSub_customdish() {
		return sub_customdish;
	}

	public void setSub_customdish(List<Customdish> sub_customdish) {
		this.sub_customdish = sub_customdish;
	}

	public Integer getSub_customdish_quantity() {
		return sub_customdish_quantity;
	}

	public void setSub_customdish_quantity(Integer sub_customdish_quantity) {
		this.sub_customdish_quantity = sub_customdish_quantity;
	}

	
	

	
	
}