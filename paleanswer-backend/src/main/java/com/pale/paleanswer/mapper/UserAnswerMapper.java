package com.pale.paleanswer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pale.paleanswer.model.dto.statistic.AppAnswerCountDTO;
import com.pale.paleanswer.model.dto.statistic.AppAnswerResultCountDTO;
import com.pale.paleanswer.model.entity.UserAnswer;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author 10379
* @description 针对表【user_answer(用户答题记录)】的数据库操作Mapper
* @createDate 2024-06-03 12:44:09
* @Entity com.pale.paleanswer.model.entity.UserAnswer
*/
public interface UserAnswerMapper extends BaseMapper<UserAnswer> {
    @Select("select appId, appName, count(userId) as answerCount\n" +
            "from user_answer\n" +
            "group by appId, appName\n" +
            "order by answerCount desc limit 10;")
    List<AppAnswerCountDTO> doAppAnswerCount();

    @Select("select resultName, count(resultName) as resultCount from user_answer\n" +
            "    where appId = #{appId}\n" +
            "    group by resultName order by resultCount desc;")
    List<AppAnswerResultCountDTO> doAppAnswerResultCount(Long appId);
}




