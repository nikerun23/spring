package org.zerock.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {

	@Inject
	SqlSession session;
	
	private final String namespace = "org.zerock.mapper.ReplyMapper";
	
	@Override
	public List<ReplyVO> list(Integer bno) throws Exception {
		return session.selectList(namespace+".list");
	}

	@Override
	public void create(ReplyVO vo) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(ReplyVO vo) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer rno) throws Exception {
		// TODO Auto-generated method stub

	}

}
