package org.iclass.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.iclass.vo.CommunityComments;

import mybatis.SqlSessionBean;

public class CommunityCommentsDao 
{
	private static final CommunityCommentsDao dao = new CommunityCommentsDao();
	private CommunityCommentsDao () {};
	public static CommunityCommentsDao getInstance()
	{return dao;}
	
	public int insert(CommunityComments vo)
	{
		SqlSession mapper = SqlSessionBean.getSession();
		int result = mapper.insert("communityComments.insert", vo);
		
		mapper.commit();
		mapper.close();
		
		return result;
	}	// method end
	
	public int delete(int idx)
	{
		SqlSession mapper = SqlSessionBean.getSession();
		int result = mapper.delete("communityComments.delete",idx);
		
		mapper.commit();
		mapper.close();
		
		return result;
	}	// method end
	
	public List<CommunityComments> comments(int mref)
	{
		SqlSession mapper = SqlSessionBean.getSession();
		List<CommunityComments> commentList = mapper.selectList("communityComments.comments", mref);
		
		mapper.close();
		
		return commentList;
	}	// method end
	
	public int commentsCount(int mref)
	{
		SqlSession mapper = SqlSessionBean.getSession();
		int result = mapper.selectOne("communityComments.commentsCount", mref);
		
		mapper.close();
		
		return result;
	}	// method end
	
	public int maxOf() 
	{
		SqlSession mapper = SqlSessionBean.getSession();
		int result = mapper.selectOne("communityComments.maxOf");
		
		mapper.close();
		
		return result;
	}	// method end
}	// Class end
