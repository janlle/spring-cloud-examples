package com.andy.goods.service;

import com.andy.common.beans.goods.GoodsVO;
import com.andy.common.entity.Goods;
import com.andy.common.utils.EntityFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *
 * @author leone
 * @since 2019-02-22
 **/
@Service
public class GoodsService {

    /**
     * @param goodsId
     * @return
     */
    public GoodsVO findOne(Long goodsId) {
        Goods goods = EntityFactory.getGoods(goodsId);
        GoodsVO vo = new GoodsVO();
        BeanUtils.copyProperties(goods, vo);
        return vo;
    }


    /**
     * @return
     */
    public List<GoodsVO> findAll() {
        return EntityFactory.getGoodsList().stream().map(e -> {
            GoodsVO vo = new GoodsVO();
            BeanUtils.copyProperties(e, vo);
            return vo;
        }).collect(Collectors.toList());
    }
}
