package com.pale.paleanswer.mapper;

import com.pale.paleanswer.model.dto.statistic.AppAnswerCountDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class UserAnswerMapperTest {
    @Resource
    private UserAnswerMapper userAnswerMapper;

    @Test
    public void test(){
        List<AppAnswerCountDTO> appAnswerCountDTOS = userAnswerMapper.doAppAnswerCount();
        System.out.println(appAnswerCountDTOS);

    }

}