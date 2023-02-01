package org.iclass.dao;

import java.util.List;

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
		mapper.insert("community.insert",vo);
		
		mapper.commit();
		mapper.close();
		
		return vo.getIdx();		// mapper.xml에서 selectkey로 sequence값을 vo Object에 저장
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
	
	public int count()
	{
		SqlSession mapper = SqlSessionBean.getSession();
		int result = mapper.selectOne("community.count");
		
		mapper.close();
		
		return result;
	}	// method end
	
	public int setReadCount(int idx)
	{
		SqlSession mapper = SqlSessionBean.getSession();
		int result = mapper.update("community.setReadCount", idx);
		
		mapper.commit();
		mapper.close();
		
		return result;
	}	// method end
	
	public int setCommentCount(int idx)
	{
		SqlSession mapper = SqlSessionBean.getSession();
		int result = mapper.update("community.setCommentCount", idx);
		
		mapper.commit();
		mapper.close();
		
		return result;
	}	// method end
	
	public int maxOf()
	{
		SqlSession mapper = SqlSessionBean.getSession();
		int result = mapper.selectOne("community.maxOf");
		
		mapper.close();
		
		return result;
	}	// method end
	
	public List<Community> list()
	{
		SqlSession mapper = SqlSessionBean.getSession();
		List<Community> list = mapper.selectList("community.list");
		
		mapper.close();
		
		return list;
	}	// method end
}	// Class end
