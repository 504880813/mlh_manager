package rms.po;

import java.math.BigDecimal;


/**
 * 
* @ClassName: Custommaterials 
* @Description: 自定义原料扩展类 
* @author random  
* @date 2015年7月16日 下午1:47:20 
*
 */
public class Custommaterials extends materials{
	/**
	 * 当前菜品所需数量
	 */
    private BigDecimal quantity;

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
   
}