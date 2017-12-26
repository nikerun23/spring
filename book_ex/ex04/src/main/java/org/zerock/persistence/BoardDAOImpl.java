package org.zerock.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.SearchCriteria;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession session;
	
	private static final String namespace = "org.zerock.mapper.BoardMapper";
	
	@Override
	public void create(BoardVO vo) throws Exception {
		session.insert(namespace+".create", vo);
	}

	@Override
	public BoardVO read(Integer bno) throws Exception {
		return session.selectOne(namespace+".read", bno);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		session.update(namespace+".update", vo);
	}

	@Override
	public void delete(Integer bno) throws Exception {
		session.delete(namespace+".delete", bno);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		return session.selectList(namespace+".listAll");
	}

	@Override
	public List<BoardVO> listPage(int page) throws Exception {
		if (page <= 0) {
			page = 1;
		}
		page = (page - 1) * 10;
		return session.selectList(namespace+".listPage", page);
	}

	@Override
	public List<BoardVO> listCriteria(Criteria cri) throws Exception {
		return session.selectList(namespace+".listCriteria", cri);
	}

	@Override
	public int listTotalCount(Criteria cri) throws Exception {
		return session.selectOne(namespace+".listTotalCount", cri);
	}

	@Override
	public List<BoardVO> listSearchCriteria(SearchCriteria cri) throws Exception {
		return session.selectList(namespace+".listSearch", cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return session.selectOne(namespace+".listSearchCount", cri);
	}

	@Override
	public void updateReplyCnt(Integer bno, int amount) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("bno", bno);
		paramMap.put("amount", amount);
		session.update(namespace+".updateReplyCnt", paramMap);
	}

	@Override
	public void updatViewCnt(Integer bno) throws Exception {
		session.update(namespace+".updateViewCnt", bno);
	}

	@Override
	public void addAttach(String fileName) throws Exception {
		session.insert(namespace+".addAttach", fileName);
	}

	@Override
	public List<String> getAttach(Integer bno) throws Exception {
		return session.selectList(namespace+".getAttach", bno);
	}

	@Override
	public void deleteAttach(Integer bno) throws Exception {
		session.delete(namespace+".deleteAttach", bno);
	}

	@Override
	public void replaceAttach(String fullName, Integer bno) throws Exception {
		
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("fullName", fullName);
		paramMap.put("bno", bno);

		session.insert(namespace+".replaceAttach", paramMap);
	}
	
	
}
