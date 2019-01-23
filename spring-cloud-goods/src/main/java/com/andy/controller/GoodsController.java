package com.andy.controller;

import com.andy.common.beans.user.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
/**
 * <p>
 *
 * @author Leone
 * @since 2018-03-10
 **/
@Slf4j
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @GetMapping("/list")
    public List<UserVO> list(@RequestHeader HttpHeaders headers) {
        return Collections.emptyList();
    }

    @GetMapping("/{goodsId}")
    public UserVO findOne(@PathVariable("userId") Long userId, @RequestHeader HttpHeaders headers) {
        return new UserVO();
    }

    @DeleteMapping
    public void delete(@RequestParam("goodsId") Long userId) {
        log.info("user service delete");
    }


}
