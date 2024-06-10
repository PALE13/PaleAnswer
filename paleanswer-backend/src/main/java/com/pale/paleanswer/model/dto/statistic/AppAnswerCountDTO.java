package com.pale.paleanswer.model.dto.statistic;

import lombok.Data;

/**
 * App 用户提交答案数统计
 */
@Data
public class AppAnswerCountDTO {

    /**
     * appId
     */
    private Long appId;

    /**
     * app名称
     */
    private String appName;

    /**
     * 用户提交答案数
     */
    private Long answerCount;
}