package com.notalent.bookstore.mapper;

import com.notalent.bookstore.pojo.book.BookCategory;
import com.notalent.bookstore.pojo.book.BookDetail;
import com.notalent.bookstore.pojo.book.BookInfo;
import com.notalent.bookstore.pojo.book.BookSku;
import org.apache.ibatis.annotations.Mapper;

/**
 * 图书mapper层
 * @author noTalent
 * @version 1.0
 * 2019.05.12
 */
@Mapper
public interface BookMapper {

    // 添加图书信息
    Integer addBookInfo(BookInfo bookInfo);

    // 添加图书详情
    Integer addBookDetail(BookDetail bookDetail);

    // 添加图书分类
    Integer addBookCategory(BookCategory bookCategory);

    // 添加图书库存
    Integer addBookSku(BookSku bookSku);

    // 获取图书
    BookInfo getBookById(Integer bookInfoId);

    // 获取图书分类
    BookCategory getCategoryById(Integer categoryId);

    // 更新图书信息
    Integer updateBookInfo(BookInfo bookInfo);

    // 更新图书详情
    Integer updateBookDetail(BookDetail bookDetail);

    // 更新图书分类
    Integer updateBookCategory(BookCategory bookCategory);

    // 更新图书库存
    Integer updateBookSku(BookSku bookSku);

}
