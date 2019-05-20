package com.notalent.bookstore.util;

/**
 * 图书工具类
 * @author noTalent
 * @version 1.0
 * 2019.05.21
 */
public class BookUtils {

    // 图片路径处理
    public static String imgUrlHandling(String bookImg, String root) {
        StringBuilder builder = new StringBuilder();
        if (bookImg.contains(";")) {
            String[] bookImgs = bookImg.split(";");
            for (int i = 0; i < bookImgs.length; i++) {
                if (i == 0) {
                    builder.append(root + bookImgs[i]);
                } else {
                    builder.append(";" + root + bookImgs[i]);
                }
            }
        } else {
            builder.append(root + bookImg);
        }
        return builder.toString();
    }

}
