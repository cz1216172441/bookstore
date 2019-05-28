package com.notalent.bookstore.service;

import com.notalent.bookstore.pojo.book.BookCategory;
import com.notalent.bookstore.pojo.book.BookInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

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

    // 图书列表
    List<BookInfo> listBook();

    List<BookInfo> listBook(Integer pageNum, Integer pageSize);

    // 图书列表（按分类）
    List<BookInfo> listBookByCategory(Integer categoryId);

    List<BookInfo> listBookByCategory(Integer categoryId, Integer pageNum, Integer pageSize);

    // 获取图书一级分类
    List<BookCategory> getFirClassCategory();

    // 获取图书二级分类
    List<BookCategory> getSecClassCategory(Integer superCategoryId);

    // 上传图书封面
    Integer uploadBookInfoImg(MultipartFile[] files, Integer bookInfoId) throws IOException;

    // 上传图书详情
    Integer uploadBookDetailImg(MultipartFile[] files, Integer bookInfoId) throws IOException;

}
