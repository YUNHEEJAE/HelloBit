package org.kb141.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kb141.domain.NoticeVO;
import org.kb141.persistence.NoticeDAO;
import org.kb141.service.NoticeService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class NoticeTest {

	@Inject
	NoticeDAO noticedao;

	@Inject
	NoticeService service;
	
	@Test
	public void createTest() throws Exception {
		NoticeVO vo = new NoticeVO();
		vo.setNwriter("김용");
		vo.setNtitle("공지사항1");
		vo.setNcontent("공지사항내용1");
		noticedao.create(vo);
	}

	@Test
	public void readTest() throws Exception {
		System.out.println(noticedao.read(2));
	}

	@Test
	public void updateTest() throws Exception {
		NoticeVO vo = new NoticeVO();
		vo.setNno(2);
		vo.setNcontent("수정공지사항내용1");
		vo.setNtitle("수정공지사항1");
		noticedao.update(vo);
	}

	@Test
	public void deleteTest() throws Exception {
		noticedao.delete(2);

	}
	
	@Test
	public void allListTest() throws Exception {
		System.out.println(noticedao.allList());
	}
	
	//===================SERVICE TEST===================
	
	@Test
	public void RegisterTest() throws Exception{
		NoticeVO vo = new NoticeVO();
		vo.setNwriter("김용");
		vo.setNcontent("공지사항2");
		vo.setNtitle("공지사항2");
		service.register(vo);
	}
	
	@Test
	public void ViewTest() throws Exception{
		System.out.println(service.view(4));
	}
	
	@Test
	public void ModifyTest() throws Exception{
		NoticeVO vo = new NoticeVO();
		vo.setNtitle("수정공지사항2");
		vo.setNcontent("수정공지사항2");
		vo.setNno(4);
		service.modify(vo);
		
	}
	
	@Test
	public void GetNoticeListTest() throws Exception{
	
		System.out.println(service.getNoticeList());
		
	}
	
	@Test
	public void RemoveTest() throws Exception{
		
		service.remove(4);
	}

}
