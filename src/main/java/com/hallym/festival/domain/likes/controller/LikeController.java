package com.hallym.festival.domain.likes.controller;

import com.hallym.festival.domain.booth.dto.PageRequestDTO;
import com.hallym.festival.domain.booth.dto.PageResponseDTO;
import com.hallym.festival.domain.likes.dto.LikesResponseTopDTO;
import com.hallym.festival.domain.likes.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping("/api/like")
@RequiredArgsConstructor
public class LikeController {
    private final LikeService likeService;

    @GetMapping("{bno}")
    public Map<String, Integer> getLikeCnt(@PathVariable Long bno) {
        int cnt = likeService.getCount(bno);
        return Map.of("result" , cnt);
    }

    @PostMapping("{bno}")
    public Map<String, String> like(@PathVariable Long bno, HttpServletRequest request, HttpServletResponse response) {
        String result = likeService.likeTrigger(bno, request, response);
        return Map.of("result", result);
    }

    @GetMapping("/top-count-list")
    public PageResponseDTO<LikesResponseTopDTO> getTopLikeBoothList(PageRequestDTO pageRequestDTO) {
        PageResponseDTO<LikesResponseTopDTO> responseDTO = likeService.getTopLikeBoothList(pageRequestDTO);
        return responseDTO;
    }
}
