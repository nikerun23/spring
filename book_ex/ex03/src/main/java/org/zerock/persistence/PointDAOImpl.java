package org.zerock.persistence;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class PointDAOImpl implements PointDAO {

	@Inject
	SqlSession session;
	
	final String namespace = "org.zerock.mapper.PointMapper";
	@Override
	public void updatePoint(Integer uid, int point) throws Exception {
		Map<String, Object> paraMap = new HashMap<>();
		paraMap.put("uid", uid);
		paraMap.put("point", point);
		
		session.update(namespace+"updatePoint", paraMap);
	}

}
