package com.cershy.linyuminiserver.vo.message;

import lombok.Data;

@Data
public class RecordVo {
    //目标id
    private String targetId;
    //起始
    private int index;
    //查询条数
    private int num;
}
