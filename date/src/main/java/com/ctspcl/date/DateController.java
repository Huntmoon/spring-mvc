package com.ctspcl.date;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangtao
 * @since 2018/5/28
 */
@RestController
public class DateController {
    @PostMapping("test")
    public DateVO dateVO(@RequestBody DateAO dateAO) {
        System.out.println(dateAO);
        return DateVO.builder()
                .date(dateAO.getDate())
                .localDate(dateAO.getLocalDate())
                .localDateTime(dateAO.getLocalDateTime()).build();
    }
}
