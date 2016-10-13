package com.yitianyigexiangfa.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.yitianyigexiangfa.dao.ProgrammeDao;
import com.yitianyigexiangfa.model.Programme;

@Repository
public class ProgrammeDaoImpl implements ProgrammeDao {

	private NamedParameterJdbcTemplate template;
		
	@Autowired
	public ProgrammeDaoImpl(DataSource ds) {
		template = new NamedParameterJdbcTemplate(ds);
	}

	@Override
	public void insertProgramme(Programme pro) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("vol", pro.getVol());
		params.put("title", pro.getTitle());
		params.put("url", pro.getUrl());
		params.put("sdate", pro.getSdate());
		
		String sql = "INSERT INTO programme (vol, title, url, sdate) values (:vol, :title, :url, :sdate)";
		template.update(sql, params);
	}

	@Override
	public List<Programme> getProgrammeByPrimaryKey(int vol) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("vol", vol);
		String sql = "SELECT * FROM programme WHERE vol = :vol";
		List<Programme> result = template.query(sql, params, programmeMapper);
		return result;
	}

	private RowMapper<Programme> programmeMapper = (rs, rowNum) -> {
		Programme pro = new Programme();
		pro.setVol(rs.getInt("vol"));
		pro.setTitle(rs.getString("title"));
		pro.setUrl(rs.getString("url"));
		pro.setSdate(rs.getDate("sdate"));
		return pro;
	};
}
