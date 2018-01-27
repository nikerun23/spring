package org.zerock.persistence;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

public interface SampleMapper {

	@Select("select now()")
	public String getTime();
	
	@Select("select email from tbl_member where userid = #{id} and userpw = #{pw}")
	public String getEmail(@Param("id") String id, @Param("pw") String pw);
	
	public String getUserName(@Param("id") String id, @Param("pw") String pw);
	
	@SelectProvider(type=SampleProvider.class, method="searchUserName")
	public String search(@Param("type") String type, @Param("keyword") String keyword);
}
