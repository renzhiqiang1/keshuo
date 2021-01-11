package com.ks.keshuoservice.utils.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.TypeUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class ControllerUtils {

	public static ModelAndView returnJson(Object result)
			throws IOException {
		HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Origin", "*");
		TypeUtils.compatibleWithJavaBean=true;

		RemoteResult jr = new RemoteResult(result);
		try {
			PrintWriter pw = response.getWriter();
//			pw.write(JSON.toJSONString(jr, new PascalNameFilter()));
			pw.write(JSON.toJSONString(jr));
			pw.flush();
		} catch (IOException e) {
			throw e;
		}
		return null;
	}
	
	public static ModelAndView returnJsonError(HttpServletRequest request, HttpServletResponse response,Object result,String message)
			throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
//		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		response.setHeader("Access-Control-Allow-Credentials","true"); //是否支持cookie跨域
		TypeUtils.compatibleWithJavaBean=true;

		RemoteResult jr = new RemoteResult(false, -1, message, result);
		try {
			PrintWriter pw = response.getWriter();
//			pw.write(JSON.toJSONString(jr, new PascalNameFilter()));
			pw.write(JSON.toJSONString(jr));
			pw.flush();
		} catch (IOException e) {
			throw e;
		}
		return null;
	}
	public static ModelAndView returnJsonError(HttpServletRequest request, HttpServletResponse response,Object result,String message,String errExportByte)
			throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
//		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		response.setHeader("Access-Control-Allow-Credentials","true"); //是否支持cookie跨域
		TypeUtils.compatibleWithJavaBean=true;

		RemoteResult jr = new RemoteResult(false, -1, message, result,errExportByte);
		try {
			PrintWriter pw = response.getWriter();
			pw.write(JSON.toJSONString(jr));
			pw.flush();
		} catch (IOException e) {
			throw e;
		}
		return null;
	}
	public static ModelAndView returnJsonError(HttpServletRequest request, HttpServletResponse response, Object result,Integer code)
			throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
//		response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		response.setHeader("Access-Control-Allow-Credentials","true"); //是否支持cookie跨域
		TypeUtils.compatibleWithJavaBean=true;

		RemoteResult jr = new RemoteResult(false,code,result.toString());
		try {
			PrintWriter pw = response.getWriter();
//			pw.write(JSON.toJSONString(jr, new PascalNameFilter()));
			pw.write(JSON.toJSONString(jr));
			pw.flush();
		} catch (IOException e) {
			throw e;
		}
		return null;
	}
	public static ModelAndView returnJsonSuccess(HttpServletRequest request, HttpServletResponse response, Object result,Integer code)
			throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
//		response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		response.setHeader("Access-Control-Allow-Credentials","true"); //是否支持cookie跨域
		TypeUtils.compatibleWithJavaBean=true;

		RemoteResult jr = new RemoteResult(true,code,result.toString());
		try {
			PrintWriter pw = response.getWriter();
//			pw.write(JSON.toJSONString(jr, new PascalNameFilter()));
			pw.write(JSON.toJSONString(jr));
			pw.flush();
		} catch (IOException e) {
			throw e;
		}
		return null;
	}
	public static ModelAndView returnJson(HttpServletRequest request, HttpServletResponse response, Object result)
			throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
//		response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		response.setHeader("Access-Control-Allow-Credentials","true"); //是否支持cookie跨域
		TypeUtils.compatibleWithJavaBean=true;

		RemoteResult jr = new RemoteResult(result);
		try {
			PrintWriter pw = response.getWriter();
//			pw.write(JSON.toJSONString(jr, new PascalNameFilter()));
			pw.write(JSON.toJSONString(jr));
			pw.flush();
		} catch (IOException e) {
			throw e;
		}
		return null;
	}
	
	/**返回值中带有$ref*/
	public static ModelAndView returnJsonRef(HttpServletRequest request, HttpServletResponse response, Object result)
			throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		response.setHeader("Access-Control-Allow-Credentials","true"); //是否支持cookie跨域
		TypeUtils.compatibleWithJavaBean=true;

		RemoteResult jr = new RemoteResult(result);
		try {
			PrintWriter pw = response.getWriter();
			pw.write(JSON.toJSONString(jr, SerializerFeature.DisableCircularReferenceDetect));
			pw.flush();
		} catch (IOException e) {
			throw e;
		}
		return null;
	}
	
	public static ModelAndView returnJsonToString(HttpServletRequest request, HttpServletResponse response, Object result)
			throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
//		response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		response.setHeader("Access-Control-Allow-Credentials","true"); //是否支持cookie跨域

//		RemoteResult jr = new RemoteResult(result);
		try {
			PrintWriter pw = response.getWriter();
//			pw.write(JSON.toJSONString(jr, new PascalNameFilter()));
			pw.write(result.toString());
			pw.flush();
		} catch (IOException e) {
			throw e;
		}
		return null;
	}
	
	
	
	
	public static ModelAndView returnSimpleJson(HttpServletRequest request, HttpServletResponse response, Object result)
			throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
//		response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		response.setHeader("Access-Control-Allow-Credentials","true"); //是否支持cookie跨域
		TypeUtils.compatibleWithJavaBean=true;

		if (result != null) {
			PrintWriter pw = response.getWriter();
//			pw.write(JSON.toJSONString(result, new PascalNameFilter()));
			pw.write(JSON.toJSONString(result));
			pw.flush();
		}

		return null;
	}

	public static ModelAndView returnOriginalJson(HttpServletRequest request, HttpServletResponse response,
			Object result) throws IOException {
		TypeUtils.compatibleWithJavaBean=true;
		if (result != null) {
			try {
				PrintWriter pw = response.getWriter();
				pw.write(JSON.toJSONString(result));
				pw.flush();

			} catch (IOException e) {
				throw e;
			}
		}

		return null;
	}

	public static ModelAndView returnText(HttpServletRequest request, HttpServletResponse response, String text)
			throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");

		if (text != null) {
			try {
				PrintWriter pw = response.getWriter();
				pw.write(text);
				pw.flush();

			} catch (IOException e) {
				throw e;
			}
		}

		return null;
	}

	public static ModelAndView returnOriginalText(HttpServletRequest request, HttpServletResponse response, String text)
			throws IOException {

		if (text != null) {
			try {
				PrintWriter pw = response.getWriter();
				pw.write(text);
				pw.flush();

			} catch (IOException e) {
				throw e;
			}
		}

		return null;
	}

	public static String[] splitStringPattern(String strPattern) {
		if (strPattern.indexOf(";") > 0) {
			return strPattern.split("[;]");
		}
		return new String[] { strPattern };
	}
	
	public static ModelAndView returnJsonError(HttpServletRequest request, HttpServletResponse response,boolean success,Object result,String message,String errExportByte)
			throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
//		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		response.setHeader("Access-Control-Allow-Credentials","true"); //是否支持cookie跨域
		TypeUtils.compatibleWithJavaBean=true;

		RemoteResult jr = new RemoteResult(success, -1, message, result,errExportByte);
		try {
			PrintWriter pw = response.getWriter();
			pw.write(JSON.toJSONString(jr));
			pw.flush();
		} catch (IOException e) {
			throw e;
		}
		return null;
	}
}