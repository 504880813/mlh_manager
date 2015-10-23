package rms.wechat.untils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @ClassName: CheckUtils
 * @Description: 校验工具类
 * @author 邹家兴
 * @date 2015年8月11日 下午3:58:38
 * 
 */
public class CheckUtils {
    /**
     * 
     * @Title: VerificationAccess
     * @Description: 将字符串数组进行字典排序sha1加密后与第二个参数进行对比
     * @param @param eqList
     * @param @param eq
     * @param @return
     * @return boolean
     * @throws
     */
    public static boolean VerificationAccess(List<String> eqList, String eq) {

	Collections.sort(eqList);
	StringBuffer sb = new StringBuffer();
	for (int i = 0; i < eqList.size(); i++) {
	    sb.append(eqList.get(i));
	}
	String temp = ComputeUtils.getSha1(sb.toString());

	return temp.equals(eq);

    }

    /**
     * 判断字符串有效性
     */
    public static boolean isValid(String str) {
	if (str == null || "".equals(str.trim())) {
	    return false;
	}
	return true;
    }

    /**
     * 判断集合的有效性
     */
    @SuppressWarnings("rawtypes")
    public static boolean isValid(Collection col) {
	if (col == null || col.isEmpty()) {
	    return false;
	}
	return true;
    }

    /**
     * 判断数组是否有效
     */
    public static boolean isValid(Object[] arr) {
	if (arr == null || arr.length == 0) {
	    return false;
	}
	return true;
    }

    /**
     * 判断是否有权限
     */
//    @SuppressWarnings("unchecked")
   /* public static boolean hasRight(String ns, String actionName,
	    HttpServletRequest req,BaseAction action) {
	if (!CheckUtils.isValid(ns) || "/".equals(ns)) {
	    ns = "";
	}

	// 处理?参数
	if (actionName.contains("?")) {
	    actionName = actionName.substring(0, actionName.indexOf("?"));
	}

	String url = ns + "/" + actionName;
	HttpSession s = req.getSession();
	ServletContext sc = s.getServletContext();
	Map<String, Right> map = (Map<String, Right>) sc
		.getAttribute("all_rights_map");
	Right r = map.get(url);
	// 公共资源
	if (r == null || r.isCommon()) {
	    return true;
	} else {
	    User user = (User) s.getAttribute("user");
	    // 登录?
	    if (user == null) {
		return false;
	    } else {
		// userAware
		if (action != null && action instanceof UserAware) {
		    ((UserAware) action).setUser(user);
		}
		// 超级管理员?
		if (user.isSuperAdmin()) {
		    return true;
		} else {
		    // 有权限?
		    if (user.hasRight(r)) {
			return true;
		    } else {
			return false;
		    }
		}
	    }

	}
    }*/

}
