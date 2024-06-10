package com.pale.paleanswer.model.dto.userAnswer;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 创建用户答案请求
 *
 * @author <a href="https://github.com/PALE13">pale</a>
 *
 */
@Data
public class UserAnswerAddRequest implements Serializable {

    /**
     * 用户答题记录 id(用于保证幂等性)
     */
    private Long id;

    /**
     * 应用 id
     */
    private Long appId;

    /**
     * 应用名称
     */
    private String appName;

    /**
     * 用户答案（JSON 数组）
     */
    private List<String> choices;


    private static final long serialVersionUID = 1L;
}