package rms.controller.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class HandlerException implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest req,
			HttpServletResponse res, Object o, Exception ex) {
		
		CustomException customException=null;
		if(ex instanceof CustomException){
			customException=(CustomException)ex;
		}else{
			customException=new CustomException("未知错误,请于管理员联系");
		}
		String message=customException.getMessage();
		ModelAndView mav=new ModelAndView();
		mav.addObject("message",message);
		mav.setViewName("error");
		return mav;
	}

}
