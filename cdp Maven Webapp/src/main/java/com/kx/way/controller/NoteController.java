package com.kx.way.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;
import com.kx.metadata.controller.CommResult;
import com.kx.way.model.Note;
import com.kx.way.service.INoteService;

@Controller
@RequestMapping("note")
public class NoteController extends CommResult{
	@Autowired
	INoteService noteService;
	@RequestMapping(value="add",method=RequestMethod.POST)
	public void add(HttpServletRequest request,HttpServletResponse response){
		Note note =new Note();
		note.setNoteTitle(request.getParameter("note_title"));
		note.setNoteContent(request.getParameter("note_content"));
		note.setNoteType(request.getParameter("note_type"));
		
		responseOutWithJson(response, noteService.add(note));
	}
	@RequestMapping(value="list",method=RequestMethod.POST)
	public void list(HttpServletRequest request,HttpServletResponse response,@RequestParam("data") String data){
		responseOutWithJson(response, noteService.list(JSONObject.parseObject(data)));
	}
	@RequestMapping(value="delete", method=RequestMethod.POST)
	public void delete(HttpServletRequest request,HttpServletResponse response,@RequestParam("data") String data){
		responseOutWithJson(response, noteService.delete(JSONObject.parseObject(data)));
	}
	@RequestMapping(value="update",method=RequestMethod.POST)
	public void update(HttpServletRequest request,HttpServletResponse response,@RequestParam("data") String data){
		responseOutWithJson(response, noteService.update(JSONObject.parseObject(data)));
	}
	@RequestMapping(value="/view/{id}", method=RequestMethod.GET)
	public void view(HttpServletRequest request,HttpServletResponse response,@PathVariable("id") String id){
		responseOutWithJson(response, noteService.view(id));
	}
}
