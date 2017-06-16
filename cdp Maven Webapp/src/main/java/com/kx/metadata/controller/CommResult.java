package com.kx.metadata.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

public class CommResult {
	/**
	 * ��JSON��ʽ���
	 * @param response
	 */
	protected void responseOutWithJson(HttpServletResponse response,
			JSONObject jsonObject) {
		//��ʵ�����ת��ΪJSON Objectת��
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
		//��ʵ�����ת��ΪJSON Objectת��
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
