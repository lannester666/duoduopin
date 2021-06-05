package com.duoduopin.controller;


import com.duoduopin.annotation.CurrentUser;
import com.duoduopin.bean.User;
import com.duoduopin.model.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.duoduopin.service.ShareBillService;

import java.math.BigDecimal;

@RestController
@Slf4j
@RequestMapping(value = "Recommend", produces = "application/json;charset=UTF-8")
public class RecommendController {
    @Autowired
    private ShareBillService shareBillService;
    @PostMapping("/{longitude}/{latitude}")
    public ResponseEntity<ResultModel> car_recommend(@PathVariable("longitude") double longitude, @PathVariable("latitude") double latitude)
    {
        return new ResponseEntity<>(ResultModel.ok(shareBillService.car_recommend(longitude,latitude)), HttpStatus.OK);
    }
    @PostMapping("/{price}")
    public ResponseEntity<ResultModel> price_recommend(@PathVariable("price")BigDecimal price)
    {
        return new ResponseEntity<>(ResultModel.ok(shareBillService.price_recommend(price)),HttpStatus.OK);
    }

}
