package com.pale.paleanswer.scoring;

import com.pale.paleanswer.model.entity.App;
import com.pale.paleanswer.model.entity.UserAnswer;

import java.util.List;

/**
 * 评分策略
 *
 * @author <a href="https://github.com/PALE13">pale</a>
 */
public interface ScoringStrategy {

    /**
     * 执行评分
     *
     * @param choices
     * @param app
     * @return
     * @throws Exception
     */
    UserAnswer doScore(List<String> choices, App app) throws Exception;
}