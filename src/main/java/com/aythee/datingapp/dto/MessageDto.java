package com.aythee.datingapp.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MessageDto {

    private Long messageId;
    private Long senderId;
    private Long receiverId;
    private String messageText;
    private LocalDateTime createdDt;
}
