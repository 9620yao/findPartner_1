package com.yc.ssm.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.ssm.entity.Album;
import com.yc.ssm.entity.PaginationBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class AlbumServiceTest {

	@Autowired
	private AlbumService albumService;
	
	@Test
	public void testListAllAlbums() {
		PaginationBean<Album>ss=albumService.listAllAlbums("1", "3");
		System.out.println(ss);
		assertNotNull(ss);
	}
	
	@Test
	public void testCountAlbum() {
		System.out.println(albumService.countAlbum("a30"));
	}

}
