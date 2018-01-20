package com.weiyuedu.core.utils;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.storage.model.FileListing;
import com.qiniu.util.Auth;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 描述: 七牛操作工具类
 * 创建人: w349037273@163.com
 * 日期: 2017-11-08
 * 时间: 22:30
 */
public class QniuUtill {
    //七牛云公钥
    private static final String ACCESS_KEY = "NS57zK6qvFybgmSSeDuWxukxNyrrKvEmTmlDuj-a";
    //七牛云密钥
    private static final String SECRET_KEY = "3fj0PPiooV5ZYd5GUenmtAJgl7vVRf1-USsDqn35";
    //默认上传空间
    private static final String BUCKET_NAME = "wydimage";
    //默认空间域名
    private static final String BUCKEY_HOST_NAME = "http://oz3mimyvs.bkt.clouddn.com";
    //"http://oz3mimyvs.bkt.clouddn.com



    //限制数量
    private static int LIMIT_SIZE = 1000;

    /**
     * 返回七牛账号下面所有的存储空间
     * @return
     */
    public static String[] listBucket() throws QiniuException {

        //获得访问凭证
        Auth auth = Auth.create(ACCESS_KEY,SECRET_KEY);
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone0());
        //创建存储空间管理类
        BucketManager bm = new BucketManager(auth,cfg);
        //返回所有存储空间
        return bm.buckets();
    }

    /**
     * 获取指定空间下的指定前缀（文件夹）的文件列表
     * @param bucketName 指定的空间名称
     * @param prefix    文件名前缀
     * @param limit 每次获取文件列表的数量
     * @return
     */
    public static List<FileInfo> listFilesOfBucket(String bucketName,String prefix,int limit){

        //获取访问凭证
        Auth auth = Auth.create(ACCESS_KEY,SECRET_KEY);
        //构造一个带指定Zone对象的配置类,zone0代表华东地区
        Configuration cfg = new Configuration(Zone.zone0());
        //创建空间管理类
        BucketManager bm = new BucketManager(auth,cfg);
        //获取指定空间文件列表迭代器
        BucketManager.FileListIterator it = bm.createFileListIterator(bucketName, prefix, limit, null);

        List list = new ArrayList<FileInfo>();
        //遍历迭代器
        while (it.hasNext()){
            FileInfo[] items = it.next();
            if (items != null && items.length>0){
                list.addAll(Arrays.asList(items));
            }
        }
        return list;
    }


    /**
     * 获取默认空间下的指定前缀（文件夹）的文件列表
     * @param prefix
     * @param limit
     * @return
     */
    public static List<FileInfo> listFilesOfBucket(String prefix,int limit){

        //获取访问凭证
        Auth auth = Auth.create(ACCESS_KEY,SECRET_KEY);
        //构造一个带指定Zone对象的配置类,zone0代表华东地区
        Configuration cfg = new Configuration(Zone.zone0());
        //创建空间管理类
        BucketManager bm = new BucketManager(auth,cfg);
        //获取指定空间文件列表迭代器
        BucketManager.FileListIterator it = bm.createFileListIterator(BUCKET_NAME, prefix, limit, null);

        List list = new ArrayList<FileInfo>();
        //遍历迭代器
        while (it.hasNext()){
            FileInfo[] items = it.next();
            if (items != null && items.length>0){
                list.addAll(Arrays.asList(items));
            }
        }
        return list;
    }

    /**
     * 返回指定空间指定目录下的文件信息
     * @param bucketName
     * @param prefix
     * @param limit
     * @return
     * @throws QiniuException
     */
    public static FileInfo[] findFiles(String bucketName,String prefix,int limit) throws QiniuException {
        Auth auth = Auth.create(ACCESS_KEY,SECRET_KEY);
        Configuration cfg = new Configuration(Zone.zone0());
        BucketManager bm = new BucketManager(auth,cfg);
        FileListing fileListing = bm.listFiles(bucketName, prefix, null, limit, null);
        if (fileListing == null || fileListing.items == null || fileListing.items.length <= 0){
            return null;
        }
        return fileListing.items;
    }

    /**
     * 返回默认空间指定目录下的文件信息
     * @param prefix
     * @param limit
     * @return
     * @throws QiniuException
     */
    public static FileInfo[] findFiles(String prefix,int limit) throws QiniuException {
        Auth auth = Auth.create(ACCESS_KEY,SECRET_KEY);
        Configuration cfg = new Configuration(Zone.zone0());
        BucketManager bm = new BucketManager(auth,cfg);
        FileListing fileListing = bm.listFiles(BUCKET_NAME, prefix, null, limit, null);
        if (fileListing == null || fileListing.items == null || fileListing.items.length <= 0){
            return null;
        }
        return fileListing.items;
    }


    /**
     * 返回指定空间下所有的文件
     * @param bucketName
     * @return
     * @throws QiniuException
     */
    public static FileInfo[] findFiles(String bucketName) throws QiniuException {
        Auth auth = Auth.create(ACCESS_KEY,SECRET_KEY);
        Configuration cfg = new Configuration(Zone.zone0());
        BucketManager bm = new BucketManager(auth,cfg);
        FileListing listing = bm.listFiles(bucketName, null, null, LIMIT_SIZE, null);
        if (listing == null || listing.items == null || listing.items.length <= 0){
            return null;
        }
        return listing.items;
    }

    /**
     * 返回默认空间下所有的文件
     * @return
     * @throws QiniuException
     */
    public static FileInfo[] findFiles() throws QiniuException {
        Auth auth = Auth.create(ACCESS_KEY,SECRET_KEY);
        Configuration cfg = new Configuration(Zone.zone0());
        BucketManager bm = new BucketManager(auth,cfg);
        FileListing listing = bm.listFiles(BUCKET_NAME, null, null, LIMIT_SIZE, null);
        if (listing == null || listing.items == null || listing.items.length <= 0){
            return null;
        }
        return listing.items;
    }





    /**
     * 返回指定空间下的某个文件
     * @param bucketName
     * @param key
     * @param limit
     * @return
     * @throws QiniuException
     */
    public static FileInfo findOneFile(String bucketName,String key,int limit) throws QiniuException {
        Auth auth = Auth.create(ACCESS_KEY,SECRET_KEY);
        Configuration cfg = new Configuration(Zone.zone0());
        BucketManager bm = new BucketManager(auth,cfg);
        FileListing fileListing = bm.listFiles(bucketName, key, null, limit, null);
        if (fileListing == null || fileListing.items == null || fileListing.items.length <= 0){
            return null;
        }
        return fileListing.items[0];
    }

    /**
     * 返回默认空间下的某个文件
     * @param key
     * @param limit
     * @return
     * @throws QiniuException
     */
    public static FileInfo findOneFile(String key,int limit) throws QiniuException {
        Auth auth = Auth.create(ACCESS_KEY,SECRET_KEY);
        Configuration cfg = new Configuration(Zone.zone0());
        BucketManager bm = new BucketManager(auth,cfg);
        FileListing fileListing = bm.listFiles(BUCKET_NAME, key, null, limit, null);
        if (fileListing == null || fileListing.items == null || fileListing.items.length <= 0){
            return null;
        }
        return fileListing.items[0];
    }





    /**
     * 返回指定空间下某个文件(重载)
     * @param bucketName
     * @param key
     * @return
     * @throws QiniuException
     */
    public static FileInfo findOneFile(String bucketName,String key) throws QiniuException {
        Auth auth = Auth.create(ACCESS_KEY,SECRET_KEY);
        Configuration cfg = new Configuration(Zone.zone0());
        BucketManager bm = new BucketManager(auth,cfg);
        FileListing fileListing = bm.listFiles(bucketName, key, null, LIMIT_SIZE, null);
        if (fileListing == null || fileListing.items == null || fileListing.items.length <= 0){
            return null;
        }
        return fileListing.items[0];
    }

    /**
     * 返回指定空间下某个文件(重载)
     * @param key
     * @return
     * @throws QiniuException
     */
    public static FileInfo findOneFile(String key) throws QiniuException {
        Auth auth = Auth.create(ACCESS_KEY,SECRET_KEY);
        Configuration cfg = new Configuration(Zone.zone0());
        BucketManager bm = new BucketManager(auth,cfg);
        FileListing fileListing = bm.listFiles(BUCKET_NAME, key, null, LIMIT_SIZE, null);
        if (fileListing == null || fileListing.items == null || fileListing.items.length <= 0){
            return null;
        }
        return fileListing.items[0];
    }





    /**
     * 生成默认空间指定文件的访问url
     * @param fileName
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String fileURL(String fileName) throws UnsupportedEncodingException {

        if (StringUtils.isBlank(fileName)){
            return null;
        }
        String encoderFileName = URLEncoder.encode(fileName,"utf-8");
        String publicUrl = String.format("%s/%s",BUCKEY_HOST_NAME,encoderFileName);
        Auth auth = Auth.create(ACCESS_KEY,SECRET_KEY);
        long expireInSeconds = 180;
        String finalUrl = auth.privateDownloadUrl(publicUrl,expireInSeconds);
        return finalUrl;
    }

    /**
     *  以输入流的形式上传文件
     * @param inputStream
     * @param bucketName
     * @param key
     * @param mimeType
     * @return
     * @throws IOException
     */
    public static String uploadFile(InputStream inputStream,String bucketName,String key,String mimeType) throws IOException {

        Configuration cfg = new Configuration(Zone.zone0());
        UploadManager uploadManager = new UploadManager(cfg);
        Auth auth = Auth.create(ACCESS_KEY,SECRET_KEY);
        String upToken = auth.uploadToken(bucketName);
        byte[] bytes = IOUtils.toByteArray(inputStream);
        Response response = uploadManager.put(bytes, key, upToken, null, mimeType, false);
        //解析上传结果
        DefaultPutRet putRet = new Gson().fromJson(response.bodyString(),DefaultPutRet.class);
        inputStream.close();
        return response.bodyString();
    }

    /**
     *  以输入流的形式上传文件
     * @param inputStream
     * @param key
     * @param mimeType
     * @return
     * @throws IOException
     */
    public static String uploadFile(InputStream inputStream,String key,String mimeType) throws IOException {

        Configuration cfg = new Configuration(Zone.zone0());
        UploadManager uploadManager = new UploadManager(cfg);
        Auth auth = Auth.create(ACCESS_KEY,SECRET_KEY);
        String upToken = auth.uploadToken(BUCKET_NAME);
        byte[] bytes = IOUtils.toByteArray(inputStream);
        Response response = uploadManager.put(bytes, key, upToken, null, mimeType, false);
        //解析上传结果
        DefaultPutRet putRet = new Gson().fromJson(response.bodyString(),DefaultPutRet.class);
        inputStream.close();
        return response.bodyString();
    }

    /**
     * 以输入流的形式上传文件,不指定mime类型
     * @param inputStream
     * @param key
     * @return
     * @throws IOException
     */
    public static String uploadFile(InputStream inputStream,String key) throws IOException {

        Configuration cfg = new Configuration(Zone.zone0());
        UploadManager uploadManager = new UploadManager(cfg);
        Auth auth = Auth.create(ACCESS_KEY,SECRET_KEY);
        String upToken = auth.uploadToken(BUCKET_NAME);
        byte[] bytes = IOUtils.toByteArray(inputStream);
        Response response = uploadManager.put(bytes, key, upToken, null, null, false);
        //解析上传结果
        DefaultPutRet putRet = new Gson().fromJson(response.bodyString(),DefaultPutRet.class);
        inputStream.close();
        return response.bodyString();
    }


    /**
     * 上传硬盘的文件
     * @param filePath
     * @param fileName
     * @param bucketName
     * @param key
     * @return
     * @throws IOException
     */
    public static String uploadFile(String filePath,String fileName,String bucketName,String key) throws IOException {

        Configuration cfg = new Configuration(Zone.zone0());
        UploadManager uploadManager = new UploadManager(cfg);
        Auth auth = Auth.create(ACCESS_KEY,SECRET_KEY);
        String upToken = auth.uploadToken(bucketName);
        File file = new File(filePath+fileName);
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bytes = IOUtils.toByteArray(fileInputStream);
        Response response = uploadManager.put(bytes, (key == null || "".equals(key))? fileName : key, upToken);
        //解析上传结果
        DefaultPutRet putRet = new Gson().fromJson(response.bodyString(),DefaultPutRet.class);
        fileInputStream.close();
        return response.bodyString();
    }

    /**
     * 上传硬盘的文件
     * @param filePath
     * @param fileName
     * @param key
     * @return
     * @throws IOException
     */
    public static String uploadFile(String filePath,String fileName,String key) throws IOException {

        Configuration cfg = new Configuration(Zone.zone0());
        UploadManager uploadManager = new UploadManager(cfg);
        Auth auth = Auth.create(ACCESS_KEY,SECRET_KEY);
        String upToken = auth.uploadToken(BUCKET_NAME);
        File file = new File(filePath+fileName);
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bytes = IOUtils.toByteArray(fileInputStream);
        Response response = uploadManager.put(bytes, (key == null || "".equals(key))? fileName : key, upToken);
        //解析上传结果
        DefaultPutRet putRet = new Gson().fromJson(response.bodyString(),DefaultPutRet.class);
        fileInputStream.close();
        return response.bodyString();
    }

    /**
     * 七牛图片上传[若没有指定文件的key,则默认将fileName参数作为文件的key]
     * @param filePath
     * @param fileName
     * @return
     * @throws IOException
     */
    public static String uploadFile(String filePath,String fileName ) throws IOException {

        Configuration cfg = new Configuration(Zone.zone0());
        UploadManager uploadManager = new UploadManager(cfg);
        Auth auth = Auth.create(ACCESS_KEY,SECRET_KEY);
        String upToken = auth.uploadToken(BUCKET_NAME);
        File file = new File(filePath+fileName);
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bytes = IOUtils.toByteArray(fileInputStream);
        Response response = uploadManager.put(bytes,fileName,upToken);
        //解析上传结果
        DefaultPutRet putRet = new Gson().fromJson(response.bodyString(),DefaultPutRet.class);
        fileInputStream.close();
        return response.bodyString();
    }

    /**
     * 删除指定空间的文件
     * @param bucket
     * @param key
     * @throws QiniuException
     */
    public static void deleteFile(String bucket, String key) throws QiniuException {

        Configuration cfg = new Configuration(Zone.zone0());
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        BucketManager bucketManager = new BucketManager(auth,cfg);
        bucketManager.delete(bucket, key);
    }

    /**
     * 删除默认空间的文件
     * @param key
     * @throws QiniuException
     */
    public static void deleteFile(String key) throws QiniuException {

        Configuration cfg = new Configuration(Zone.zone0());
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        BucketManager bucketManager = new BucketManager(auth,cfg);
        bucketManager.delete(BUCKET_NAME, key);
    }
}
