package com.sct.dao;

import java.util.List;
import java.util.Map;

import com.sct.vo.StaticVO;

public interface StaticDAO {

	public List<StaticVO> getScoreMap(Map<String, Object> requestData);

}
