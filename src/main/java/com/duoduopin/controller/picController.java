package com.duoduopin.controller;
import com.duoduopin.annotation.CurrentUser;
import com.duoduopin.bean.User;
import com.duoduopin.service.picService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.duoduopin.config.ResultStatus;
import com.duoduopin.model.ResultModel;
@RestController
@RequestMapping(value = "pic")
public class picController {
    @Autowired
    private picService picService;
    @PostMapping("/upload/{path}")
    public ResponseEntity<ResultModel> uploadPic(@CurrentUser User user,@PathVariable("path") String path) throws Exception
    {
        String picUrl = picService.UploadPic(user.getUserId(), path);
        return new ResponseEntity<>(ResultModel.ok(), HttpStatus.OK);
    }
    @PostMapping("/update/{path}")
    public ResponseEntity<ResultModel> updatePic(@CurrentUser User user, @PathVariable("path") String path)
    {
        picService.updatePic(user.getUserId(),path);
        return new ResponseEntity<>(ResultModel.ok(),HttpStatus.OK);
    }
    @PostMapping("/getpic")
    public ResponseEntity<ResultModel> get_pic(@CurrentUser User user)
    {
        String picUrl = picService.get_pic(user.getUserId());
        return new ResponseEntity<>(ResultModel.ok(picUrl),HttpStatus.OK);
    }
}
