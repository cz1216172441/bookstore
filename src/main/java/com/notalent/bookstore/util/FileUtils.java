package com.notalent.bookstore.util;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.apache.commons.lang3.StringUtils;
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

    // 服务器路径
    public static final String ROOT_URL = "http://localhost:4000";

    // 文件访问路径
    public static final String USER_VISIT_URL = "/static/upload/user/";
    public static final String BOOK_VISIT_URL = "/static/upload/book/";
    public static final String ADVERTISEMENT_VISIT_URL = "/static/upload/advertisement/";

    // 文件上传路径
    public static final String UPLOAD_URL = "/src/main/resources/static/upload/";
    public static final String USER_UPLOAD_URL = "/src/main/resources/static/upload/user/";
    public static final String BOOK_UPLOAD_URL = "/src/main/resources/static/upload/book/";
    public static final String ADVERTISEMENT_UPLOAD_URL = "/src/main/resources/static/upload/advertisement/";

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
     * 多文件上传
     * @param files
     * @param rootPath
     * @return
     * @throws IOException
     */
    public static String uploadFiles(MultipartFile[] files, String rootPath) throws IOException {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];
            String fileName = FileUtils.uploadFile(file, rootPath);
            if (i == 0) {
                builder.append(fileName);
            } else {
                builder.append(";" + fileName);
            }
        }
        return builder.toString();
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

    /**
     * 删除多个文件
     * @param filenames 文件名
     * @param deleteUrl 删除路径
     */
    public static void deleteFiles(String filenames, String deleteUrl) {
        if (StringUtils.isNotEmpty(filenames)) {
            if (filenames.contains(";")) {
                String[] fileNames = filenames.split(";");
                for (String fileName : fileNames) {
                    FileUtils.deleteFile(fileName, deleteUrl);
                }
            } else {
                FileUtils.deleteFile(filenames, deleteUrl);
            }
        }
    }

    // 图片路径处理
    public static String imgUrlHandling(String img, String root) {
        StringBuilder builder = new StringBuilder();
        if (StringUtils.isEmpty(img)) return builder.toString();
        if (img.contains(";")) {
            String[] imgs = img.split(";");
            for (int i = 0; i < imgs.length; i++) {
                if (i == 0) {
                    builder.append(root + imgs[i]);
                } else {
                    builder.append(";" + root + imgs[i]);
                }
            }
        } else {
            builder.append(root + img);
        }
        return builder.toString();
    }

}
