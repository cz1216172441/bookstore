package com.notalent.bookstore.service;

import com.notalent.bookstore.pojo.book.BookInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 图书服务层
 * @author noTalent
 * @version 1.0
 * 2019.05.20
 */
public interface BookService {

    // 添加图书
    Integer addBook(BookInfo bookInfo);

    // 获取图书
    BookInfo getBookById(Integer bookInfoId);

    // 获取图书总分类名
    String getCategoryName(Integer categoryId);

    // 上传图书封面
    Integer uploadBookInfoImg(MultipartFile[] files, Integer bookInfoId) throws IOException;

    // 上传图书详情
    Integer uploadBookDetailImg(MultipartFile[] files, Integer bookInfoId) throws IOException;

}
