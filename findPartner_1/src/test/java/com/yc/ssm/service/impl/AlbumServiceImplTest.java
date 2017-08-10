package com.yc.ssm.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.ssm.entity.Album;
import com.yc.ssm.service.AlbumService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class AlbumServiceImplTest {

	@Autowired
	private AlbumService albumService;

	@Test
	public void testAddAlbum() {
		Album album = new Album();
		album.setAaid("a10055");
		album.setAbname("我是一个新相册");
		album.setAlcontent("我是对新相册的描述..");
		System.out.println(albumService.addAlbum(album));
	}
	
	@Test
	public void testfpByabid() {
		System.out.println(albumService.fpByabid("ab10000"));
	}

}
