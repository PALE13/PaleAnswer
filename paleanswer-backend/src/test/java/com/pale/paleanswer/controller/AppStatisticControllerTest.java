package com.pale.paleanswer.controller;

import com.pale.paleanswer.common.BaseResponse;
import com.pale.paleanswer.model.dto.statistic.AppAnswerCountDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AppStatisticControllerTest {

    @Resource
    private AppStatisticController appStatisticController;

    @Test
    void getAppAnswerCount() {
        BaseResponse<List<AppAnswerCountDTO>> appAnswerCount = appStatisticController.getAppAnswerCount();
        for (AppAnswerCountDTO datum : appAnswerCount.getData()) {
            System.out.println(datum);
        }


    }

    @Test
    void getAppAnswerResultCount() {
    }
}