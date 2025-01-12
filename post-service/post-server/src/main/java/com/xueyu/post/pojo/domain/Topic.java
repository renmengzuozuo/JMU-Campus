package com.xueyu.post.pojo.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("topic")
public class Topic {
    /**
     * 自增id
     */
    @TableId
    Integer id;

    String name;

    /**
     *
     *  话题创建时间
     */
    Timestamp createTime;
}
