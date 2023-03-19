package com.hallym.festival.repository;

import com.hallym.festival.domain.booth.entity.Booth;
import com.hallym.festival.domain.booth.repository.BoothRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class BoothRepositoryTests {

	@Autowired
	private BoothRepository boothRepository;

//	@AfterEach
//	public void cleanup(){
//		boothRepository.deleteAll();
//	}

	@Test
	public void testInsert() {
		IntStream.rangeClosed(1,30).forEach(i -> {

			Booth result = boothRepository.save(Booth.builder()
					.booth_title("부스명..." + i)
					.booth_content("동아리 소개..." + i)
					.booth_type("부스타입"+(i % 3))
					.writer("부스담당매니저"+(i % 5))
					.build());

			log.info("-------------------save-----------");
			log.info(result);
		});
	}

	@Test
	public void testSelect() {
		Long bno = 20L;

		Optional<Booth> result = boothRepository.findById(bno);

		Booth booth = result.orElseThrow();

		log.info("----------------");
		log.info(booth);

	}


	@Test
	public void testUpdate() {

		Long bno = 2L;

		Optional<Booth> result = boothRepository.findById(bno);

		Booth booth = result.orElseThrow();

		booth.change("농구 동아리", "3점 슛의 황태자는 누구?", true);

		boothRepository.save(booth);

	}

	@Test
	public void testDelete() {
		Long bno = 10L;

		boothRepository.deleteById(bno);
	}



}
