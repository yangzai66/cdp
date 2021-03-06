package com.kx.metadata.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

public class CommResult {
	/**
	 * 以JSON格式输出
	 * @param response
	 */
	protected void responseOutWithJson(HttpServletResponse response,
			JSONObject jsonObject) {
		//将实体对象转换为JSON Object转换
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.append(jsonObject.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
	protected void responseOutWithJson(HttpServletResponse response,
			String jsonObject) {
		//将实体对象转换为JSON Object转换
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.append(jsonObject.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
}
