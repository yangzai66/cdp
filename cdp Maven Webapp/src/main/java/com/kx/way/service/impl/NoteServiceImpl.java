package com.kx.way.service.impl;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.sql.dialect.postgresql.ast.stmt.PGSelectQueryBlock.IntoOption;
import com.alibaba.druid.sql.visitor.functions.Insert;
import com.alibaba.fastjson.JSONObject;
import com.kx.metadata.service.IMetadataService;
import com.kx.util.DateTimeUtil;
import com.kx.util.JsonUtil;
import com.kx.way.model.Note;
import com.kx.way.service.INoteService;
@Service("noteService")
public class NoteServiceImpl implements INoteService{
	@Autowired
	IMetadataService metadataService;
	@Override
	public JSONObject add(Note note) {
		JSONObject resultJson = JsonUtil.resultData();
//		dataJson.put("CREATETIME", DateTimeUtil.getCurDate(DateTimeUtil.DEFAULT_DATETIME_FORMAT_SEC));
//		dataJson.put("UPDATETIME", DateTimeUtil.getCurDate(DateTimeUtil.DEFAULT_DATETIME_FORMAT_SEC));
//		System.out.println();
		if(StringUtils.isNotEmpty(note.getNoteContent()) && note.getNoteContent().contains("'")){
			note.setNoteContent(note.getNoteContent().replaceAll("'", "''"));
		}
		resultJson.put("result", metadataService.execute("INSERT INTO NOTE_RECORD(NOTE_TITLE,NOTE_CONTENT,NOTE_TYPE,CREATETIME) VALUES('"+note.getNoteTitle()+"','"+note.getNoteContent()+"','"+note.getNoteType()+"','"+DateTimeUtil.getCurDate(DateTimeUtil.DEFAULT_DATETIME_FORMAT_SEC)+"')"));
		return resultJson;
	}

	@Override
	public JSONObject update(JSONObject dataJson) {
		JSONObject resultJson = JsonUtil.resultData();
//		dataJson.put("CREATETIME", DateTimeUtil.getCurDate(DateTimeUtil.DEFAULT_DATETIME_FORMAT_SEC));
		dataJson.put("UPDATETIME", DateTimeUtil.getCurDate(DateTimeUtil.DEFAULT_DATETIME_FORMAT_SEC));
		resultJson.put("result", metadataService.execute(metadataService.getsql(dataJson, "note_record","NOTE_ID",dataJson.getString("NOTE_ID"))));
		return resultJson;
	}

	@Override
	public JSONObject list(JSONObject dataJson) {
		JSONObject resultJson = JsonUtil.resultData();
		String sql= "SELECT * FROM NOTE_RECORD WHERE 1=1";
		String sql_count = "SELECT COUNT(*) FROM NOTE_RECORD WHERE 1=1";
		String condition ="";
		String limit = "";
		if(dataJson.containsKey("note_title")&& StringUtils.isNotEmpty(dataJson.getString("note_title"))){
			condition+=" and note_title like '%"+dataJson.getString("note_title")+"%'";
		}
		if(dataJson.containsKey("note_starttime")&& StringUtils.isNotEmpty(dataJson.getString("note_starttime"))){
			condition+=" and createtime >'"+dataJson.getString("note_starttime")+"'";
		}
		limit+=" limit "+((dataJson.getIntValue("page_no")-1)*dataJson.getIntValue("page_size"))+","+(dataJson.getIntValue("page_no")*dataJson.getIntValue("page_size"));
		System.out.println(sql+condition+limit);
		resultJson.put("data", metadataService.queryForList(sql+condition+limit));
		int total_page = metadataService.queryForInt(sql_count+condition)/dataJson.getIntValue("page_size");
		resultJson.put("count", metadataService.queryForInt(sql_count+condition)%dataJson.getIntValue("page_size")==0?total_page:total_page+1);
		resultJson.put("page_no", dataJson.getIntValue("page_no"));
		resultJson.put("page_size", dataJson.getIntValue("page_size"));
		return resultJson;
	}

	@Override
	public JSONObject delete(JSONObject paramsJson) {
		JSONObject resultJson = JsonUtil.resultData();
				String sql = "DELETE FROM NOTE_RECORD WHERE NOTE_ID='"+paramsJson.getString("note_id")+"'";
				metadataService.execute(sql);
		return resultJson;
	
	}

	@Override
	public JSONObject view(String id) {
		JSONObject resultJson = JsonUtil.resultData();
		Map<String, Object> noteView = metadataService.queryForMap("SELECT * FROM NOTE_RECORD WHERE NOTE_ID='"+id+"'");
		if(noteView == null){
			resultJson.put("result", false);
			resultJson.put("msg", "δ���ִ��������");
			return resultJson;
		}
		resultJson.put("data", noteView);
		return resultJson;
	}

}
