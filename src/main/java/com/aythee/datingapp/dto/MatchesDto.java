package com.aythee.datingapp.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MatchesDto {

    Long matchId;
    Long firstUserId;
    Long secondUserId;
    LocalDateTime matchDate;
}
