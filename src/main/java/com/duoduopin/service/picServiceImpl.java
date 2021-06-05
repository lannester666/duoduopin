package com.duoduopin.service;

import com.duoduopin.pojo.picPOJO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.duoduopin.dao.PicMapper;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
@Transactional
public class picServiceImpl implements picService {
    @Autowired
    private PicMapper picMapper;
    @Override
    public String UploadPic(long userid,String path){
        String name = UUID.randomUUID().toString();
//           String oldname = picFile.getOriginalFilename();
//           String exeName = oldname.substring(oldname.lastIndexOf("."));
//           File pic = new File("C:/Java/idea_files/DuoDuoPinDemo/src/main/resources/pic/" + name + exeName);
//           picFile.transferTo(pic);
        picMapper.add(new picPOJO(userid,name, path));
        return path;
    }
    @Override
    public void updatePic(long userid,String path)
    {
        picMapper.update(userid, path);
    }
    @Override
    public String get_pic(long userid)
    {
        return picMapper.search(userid);
    }
}
