package com.notalent.bookstore.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 文件工具类
 * @author noTalent
 * @version 1.0
 * 2019.05.19
 */
public class FileUtils {

    public static final String FILE_URL = System.getProperty("user.dir");

    public static final String UPLOAD_URL = "/src/main/resources/static/upload/";

    public static final String USER_UPLOAD_URL = "/src/main/resources/static/upload/user/";

    public static final String BOOK_UPLOAD_URL = "/src/main/resources/static/upload/book/";

    /**
     * 获取文件名后缀
     * @param filename
     * @return suffix
     */
    public static String getSuffix(String filename) {
        if (filename.contains(".")) {
            return filename.substring(filename.lastIndexOf("."));
        } else {
            return ".mp3";
        }
    }

    /**
     * uuid生成随机文件名
     * @param originFilename
     * @return newFilename
     */
    public static String getFilename(String originFilename) {
        return UUID.randomUUID().toString().replace("-", "") + getSuffix(originFilename);
    }

    /**
     * 上传文件
     * @param file 上传的文件
     * @param rootPath 上传路径
     * @return 最终文件名
     */
    public static String uploadFile(MultipartFile file, String rootPath) throws IOException {
        String originFilename = file.getOriginalFilename();
        String newFilename = getFilename(originFilename);
        File newFile = new File(rootPath + newFilename);
        if (!newFile.getParentFile().exists()) {
            newFile.getParentFile().mkdirs();
        }
        if (!newFile.exists()) {
            file.transferTo(newFile);
        }
        return newFilename;
    }

    /**
     * 删除文件
     * @param filename
     * @return true 删除成功 false 删除失败
     */
    public static boolean deleteFile(String filename, String deleteUrl) {
        File file = new File(deleteUrl + filename);
        if (file.exists()) {
            return file.delete();
        } else {
            return false;
        }
    }

}
