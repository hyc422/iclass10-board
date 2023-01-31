package org.iclass.dao;

import org.apache.ibatis.session.SqlSession;
import org.iclass.vo.Community;

import mybatis.SqlSessionBean;

public class CommunityDao 
{
	// Singleton Pattern
	private static final CommunityDao dao = new CommunityDao();
	private CommunityDao() {};
	public static CommunityDao getInstance()
	{return dao;}
	
	public long insert(Community vo)
	{
		SqlSession mapper = SqlSessionBean.getSession();
		long result = mapper.insert("community.insert",vo);
		
		mapper.commit();
		mapper.close();
		
		return result;
	}	// method end;
	
	public int update(Community vo)
	{
		SqlSession mapper = SqlSessionBean.getSession();
		int result = mapper.update("community.update", "vo");
		
		mapper.commit();
		mapper.close();
		
		return result;
	}	// method end
	
	public int delete(int idx)
	{
		SqlSession mapper = SqlSessionBean.getSession();
		int result = mapper.delete("community.delete", idx);
		
		mapper.commit();
		mapper.close();
		
		return result;
	}	// method end
	
	public Community selectByIdx(int idx)
	{
		SqlSession mapper = SqlSessionBean.getSession();
		Community vo = mapper.selectOne("community.selectByIdx", idx);
		
		mapper.close();
		
		return vo;
	}	// method end
}	// Class end
