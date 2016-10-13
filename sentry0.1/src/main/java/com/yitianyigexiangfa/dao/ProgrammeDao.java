package com.yitianyigexiangfa.dao;

import java.util.List;

import com.yitianyigexiangfa.model.Programme;

public interface ProgrammeDao {
	
	void insertProgramme(Programme pro);
	
	List<Programme> getProgrammeByPrimaryKey(int vol);
}
