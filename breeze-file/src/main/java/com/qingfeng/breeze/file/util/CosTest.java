package com.qingfeng.breeze.file.util;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;

import java.io.File;
import java.net.URL;
import java.util.Date;
import java.util.UUID;

/**
 * @author qingfeng
 * @description: TODO
 * @date 2019/6/28 15:23
 */
public class CosTest {


    public static String cosUpload (File file,String prefix) {
        String secretId = "AKIDjXDjDcQzukS2UWLBlBYntsPqkYDknMdr";
        String secretKey = "HOKUVN8mIhvxZ2MW8f3HJRSPFvUwHTBm";
        String bucketName = "qingfeng-1253915794";
        String key = "images/"+ UUID.randomUUID().toString() + prefix;
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
        // 2 设置 bucket 的区域, COS 地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        // clientConfig 中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者常见问题 Java SDK 部分。
        Region region = new Region("ap-guangzhou");
        ClientConfig clientConfig = new ClientConfig(region);
        // 3 生成 cos 客户端。
        COSClient cosClient = new COSClient(cred, clientConfig);
        try {
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, file);
            PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
            Date expiration = new Date(new Date().getTime() + 5 * 60 * 10000);
            URL oldurl = cosClient.generatePresignedUrl(bucketName, key, expiration);
            String url = oldurl.toString();
            return url.substring(0, url.indexOf("?"));
        } catch (CosServiceException serverException) {
            serverException.printStackTrace();
            return null;
        } catch (CosClientException clientException) {
            clientException.printStackTrace();
            return null;
        }finally {
            cosClient.shutdown();
        }
    }

    /**
     * 上传文件到腾讯云存储
     * @return
     */
    public static String cosUpload () {
        String secretId = "AKIDjXDjDcQzukS2UWLBlBYntsPqkYDknMdr";
        String secretKey = "HOKUVN8mIhvxZ2MW8f3HJRSPFvUwHTBm";
        String bucketName = "qingfeng-1253915794";
        String key = "images/"+new Date().getTime() + ".jpg";
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
        // 2 设置 bucket 的区域, COS 地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        // clientConfig 中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者常见问题 Java SDK 部分。
        Region region = new Region("ap-guangzhou");
        ClientConfig clientConfig = new ClientConfig(region);
        // 3 生成 cos 客户端。
        COSClient cosClient = new COSClient(cred, clientConfig);
        try {
            // 指定要上传的文件
            File localFile = new File("C:\\Users\\jkw\\Desktop\\云音乐头像\\1azyboy.jpg");
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
            PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
            Date expiration = new Date(new Date().getTime() + 5 * 60 * 10000);
            URL oldurl = cosClient.generatePresignedUrl(bucketName, key, expiration);
            String url = oldurl.toString();
            return url.substring(0, url.indexOf("?"));
        } catch (CosServiceException serverException) {
            serverException.printStackTrace();
            return null;
        } catch (CosClientException clientException) {
            clientException.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(CosTest.cosUpload());
    }
}
