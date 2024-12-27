package com.cershy.linyuminiserver.vo.message;

import com.cershy.linyuminiserver.constant.MessageType;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SendMessageVo {
    @NotBlank(message = "目标用户不能为空~")
    private String targetId;
    private String source;
    private String type = MessageType.Text;
    @NotBlank(message = "消息内容不能为空~")
    private String msgContent;
    private String referenceMsgId;
    private String userIp;
}
