package com.duoduopin.controller;

import com.duoduopin.model.ResultModel;
import com.duoduopin.service.ShareBillPicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "ShareBillPic", produces = "application/json;charset=UTF-8")
public class ShareBillPicController {
    @Autowired
    ShareBillPicService shareBillPicService;
    @PostMapping("/add/{id}/{url}")
    public ResponseEntity<ResultModel> add(@PathVariable("id") long id,@PathVariable("url") String url)
    {
        shareBillPicService.add_share_bill_pic(id,url);
        return new ResponseEntity<>(ResultModel.ok(), HttpStatus.OK);
    }
    @PostMapping("/update/{id}/{url}")
    public ResponseEntity<ResultModel> update(@PathVariable("id") long id,@PathVariable("url") String url)
    {
        shareBillPicService.update_share_bill_pic(id,url);
        return new ResponseEntity<>(ResultModel.ok(),HttpStatus.OK);
    }
    @PostMapping("/get/{id}")
    public ResponseEntity<ResultModel> get(@PathVariable("id") long id)
    {
        return new ResponseEntity<>(ResultModel.ok(shareBillPicService.get_share_bill_pic(id)),HttpStatus.OK);
    }
}
