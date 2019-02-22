package com.andy.goods.controller;

import com.andy.common.beans.goods.GoodsVO;
import com.andy.goods.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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

    @Resource
    private GoodsService goodsService;

    @GetMapping("/list")
    public List<GoodsVO> list(@RequestHeader HttpHeaders headers) {
        return goodsService.findAll();
    }

    @GetMapping("/{goodsId}")
    public GoodsVO findOne(@PathVariable("goodsId") Long goodsId, @RequestHeader HttpHeaders headers) {
        return goodsService.findOne(goodsId);
    }

    @DeleteMapping
    public void delete(@RequestParam("goodsId") Long goodsId) {
        log.info("user service delete");
    }


}
