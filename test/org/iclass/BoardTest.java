package org.iclass;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.iclass.dao.CommunityCommentsDao;
import org.iclass.dao.CommunityDao;
import org.iclass.vo.Community;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(value=MethodOrderer.OrderAnnotation.class)
class BoardTest 
{
	CommunityDao communitydao = CommunityDao.getInstance();
	CommunityCommentsDao commentsdao = CommunityCommentsDao.getInstance();
	
	@Order(1)
	@DisplayName("메인글 insert의 idx = max+1")
	@Test
	void insertMain()
	{
		Community vo = Community.builder()
								.writer("홍용치")
								.title("자바의 정석")
								.content("자바 정석으로 공부")
								.build();
		
		int result = communitydao.maxOf();
		communitydao.insert(vo);
		assertEquals(vo.getIdx(), result+1);
	}	// test end
	
	@Order(2)
	@DisplayName("메인글 목록 : list 크기 = count")
	@Test
	void mainList()
	{
		List<Community> list = communitydao.list();
		
		int count = communitydao.count();
		
		assertEquals(list.size(), count);
	}	// test end
	
	//@Order(3)
	//@DisplayName("메인글 update - ")
}	// Class end
