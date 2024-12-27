package com.cershy.linyuminiserver.vo.chatList;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateVo {
    @NotBlank(message = "目标不能为空~")
    private String targetId;
}
