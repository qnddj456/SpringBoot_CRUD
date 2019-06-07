package com.n2014758030.main;

import com.n2014758030.main.domain.Basic;
import com.n2014758030.main.service.BasicService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MainApplicationTests {

    @Autowired
    private BasicService basicService;

    @Before
    public void init() {
        basicService.save(Basic.builder()
                .name("홍길동")
                .label("CEO")
                .email("hong@gmail.com")
                .phone("012-3456-789")
                .build());

        basicService.save(Basic.builder()
                .name("장길산")
                .label("CFO")
                .email("jang@gmail.com")
                .phone("123-456-7890")
                .build());

        basicService.save(Basic.builder()
                .name("춘향이")
                .label("CTO")
                .email("chun@gmail.com")
                .phone("234-567-8901")
                .build());
    }

    @Test
    public void updateTest(){
        Basic update = basicService.findBasicByIdx(2L);
        update.setPhone("test");
        update.setlabel("test");


        Basic save = basicService.findBasicByIdx(update.getIdx());

        save.setPhone(update.getPhone());
        save.setlabel(update.getLabel());

        basicService.updateBasic(save);

        assertThat(update.getLabel()).isEqualTo(save.getLabel());

    }

}
