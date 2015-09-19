package rms.po;

import java.math.BigDecimal;

/**
 * 
* @ClassName: dishcotent 
* @Description: 自定义菜品关系表，方便存储菜品关系 
* @author random  
* @date 2015年7月27日 上午11:42:15 
*
 */
public class dishcotent {
	private Integer dishid;
	private Integer materialsid;
	private BigDecimal materialsquantity;
	private Integer subdishid;
	private Integer subdishquantity;
	public Integer getDishid() {
		return dishid;
	}
	public void setDishid(Integer dishid) {
		this.dishid = dishid;
	}
	public Integer getMaterialsid() {
		return materialsid;
	}
	public void setMaterialsid(Integer materialsid) {
		this.materialsid = materialsid;
	}
	public BigDecimal getMaterialsquantity() {
		return materialsquantity;
	}
	public void setMaterialsquantity(BigDecimal materialsquantity) {
		this.materialsquantity = materialsquantity;
	}
	public Integer getSubdishid() {
		return subdishid;
	}
	public void setSubdishid(Integer subdishid) {
		this.subdishid = subdishid;
	}
	public Integer getSubdishquantity() {
		return subdishquantity;
	}
	public void setSubdishquantity(Integer subdishquantity) {
		this.subdishquantity = subdishquantity;
	}
	
	
}