package com.qingfeng.breeze.file.controller;

import com.qingfeng.breeze.api.constants.ResponseConsts;
import com.qingfeng.breeze.api.util.R;
import com.qingfeng.breeze.file.util.CosTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

/**
 * @author qingfeng
 * @description: TODO
 * @date 2019/6/28 15:50
 */
@RestController
@RequestMapping(value = "/file")
public class FileController {

    private final static Logger logger = LoggerFactory.getLogger(FileController.class);

    @PostMapping("/upload")
    public R<String> uploadFile (@RequestParam("file") MultipartFile multfile) {
        if (multfile.isEmpty()) {
            return R.fail(ResponseConsts.ERROR,"文件为空");
        }
        // 获取文件名
        String fileName = multfile.getOriginalFilename();
        // 获取文件后缀
        String prefix=fileName.substring(fileName.lastIndexOf("."));
        try {
            // 用uuid作为文件名，防止生成的临时文件重复
            final File file = File.createTempFile(UUID.randomUUID().toString(), prefix);
            // MultipartFile to File
            multfile.transferTo(file);
            //你的业务逻辑
            String url = CosTest.cosUpload(file,prefix);
            deleteFile(file);
            if (url != null) {
                return R.success(ResponseConsts.SUCCESS,"上传文件成功",url);
            }
            return R.fail(ResponseConsts.ERROR,"上传文件失败");
        }catch (Exception e) {
            logger.error("上传文件失败,原因:{}",e.getMessage());
            return R.fail(ResponseConsts.ERROR,"上传文件失败");
        }
    }

    /**
     * 删除
     *
     * @param files
     */
    private void deleteFile(File... files) {
        for (File file : files) {
            if (file.exists()) {
                file.delete();
            }
        }
    }
}
