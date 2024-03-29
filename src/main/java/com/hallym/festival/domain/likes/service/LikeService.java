package com.hallym.festival.domain.likes.service;

import com.hallym.festival.domain.booth.dto.PageRequestDTO;
import com.hallym.festival.domain.booth.dto.PageResponseDTO;
import com.hallym.festival.domain.likes.dto.LikesResponseTopDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface LikeService {
    String likeTrigger(Long bno, HttpServletRequest request, HttpServletResponse response);
    PageResponseDTO<LikesResponseTopDTO> getTopLikeBoothList(PageRequestDTO pageRequestDTO);
    int getCount(Long boothId);

}
