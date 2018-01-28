package org.zerock.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.zerock.domain.MemberVO;

public interface MemberMapper {

	@Insert("insert into tbl_member(userid,userpw,username,email) values("
			+ "#{userid},#{userpw},#{username},#{email})")
	public void create(MemberVO vo)throws Exception;
		
	@Select("select * from tbl_member where userid = #{userid}")
	public MemberVO read(String userid)throws Exception;
	
	@Update("update tbl_member set "
			+ "userpw=#{userpw},username=#{username},email=#{email}"
			+ "where userid = #{userid}")
	public void update(MemberVO vo)throws Exception;
	
	@Delete("delete from tbl_member where userid = #{userid}")
	public void delete(String userid)throws Exception;
}
