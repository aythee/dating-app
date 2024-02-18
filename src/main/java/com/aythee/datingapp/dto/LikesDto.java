package com.aythee.datingapp.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LikesDto {

    private Long likeId;
    private Long userId;
    private Long likedUserId;
    private LocalDateTime createdDt;

}
