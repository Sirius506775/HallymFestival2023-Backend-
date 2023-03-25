package com.hallym.festival.service;

import com.hallym.festival.domain.comment.dto.CommentPasswordDto;
import com.hallym.festival.domain.comment.dto.CommentRequestDto;
import com.hallym.festival.domain.comment.dto.CommentResponseDto;
import com.hallym.festival.domain.comment.service.CommentServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
class CommentServiceTest {

    @Autowired
    CommentServiceImpl commentServiceImpl;

    @Test
    public void create() {
        //when
        MockHttpServletRequest request = new MockHttpServletRequest();
        Long boothId = 1L;
        IntStream.rangeClosed(1,30).forEach(i -> {
            CommentRequestDto commentRequestDto =
                    CommentRequestDto.builder()
                            .password("jyp1234")
                            .content("댓글입니다."+i).build();

            commentServiceImpl.create(boothId, commentRequestDto, request);
        });
    }

    @Test
    public void delete() {
        IntStream.rangeClosed(1, 30).forEach(i -> {
            if(i%2 == 0) {
                Long boothId = (long) i;
                CommentPasswordDto pDto = CommentPasswordDto.builder().password("jyp1234").build();
                commentServiceImpl.delete(boothId, pDto);
            }
        });
    }

    @Test
    public void getAll() throws Exception {
        Long boothId = 1L;
        List<CommentResponseDto> commentList = commentServiceImpl.getAll(boothId);
        log.info(commentList.size());

        for (CommentResponseDto comment : commentList) {
            log.info(comment);
        }
    }

}