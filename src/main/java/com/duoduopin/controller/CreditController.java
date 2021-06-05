package com.duoduopin.controller;

import com.duoduopin.annotation.CurrentUser;
import com.duoduopin.bean.PointCarrier;
import com.duoduopin.bean.User;
import com.duoduopin.model.ResultModel;
import com.duoduopin.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "Credit", produces = "application/json;charset=UTF-8")
public class CreditController {
    @Autowired
    CreditService creditService;
    @PostMapping("/{id}/{point}")
    public ResponseEntity<ResultModel> give_point(@CurrentUser User user, @PathVariable("id")long UserId, @PathVariable("point")int point)
    {

        return new ResponseEntity<>(ResultModel.ok(creditService.update(user.getUserId(), UserId,point)), HttpStatus.OK);
    }

}
