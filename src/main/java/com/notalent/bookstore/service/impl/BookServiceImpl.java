package com.notalent.bookstore.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.notalent.bookstore.mapper.BookMapper;
import com.notalent.bookstore.pojo.book.BookCategory;
import com.notalent.bookstore.pojo.book.BookDetail;
import com.notalent.bookstore.pojo.book.BookInfo;
import com.notalent.bookstore.pojo.book.BookSku;
import com.notalent.bookstore.service.BookService;
import com.notalent.bookstore.util.FileUtils;
import com.notalent.bookstore.util.IntegerUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 图书服务层实现
 * @author noTalent
 * @version 1.0
 * 2019.05.20
 */
@Service("bookService")
public class BookServiceImpl implements BookService {

    @Resource
    private BookMapper bookMapper;

    @Override
    @Transactional
    public Integer addBook(BookInfo bookInfo) {
        if (IntegerUtils.isNotError(bookMapper.addBookInfo(bookInfo))) {
            Integer bookInfoId = bookInfo.getBookInfoId();
            if (IntegerUtils.isNotEmpty(bookInfoId)) {
                if (bookInfo.getBookDetail() == null) {
                    bookInfo.setBookDetail(new BookDetail(bookInfoId));
                }
                if (bookInfo.getBookSku() == null) {
                    bookInfo.setBookSku(new BookSku(bookInfoId));
                }
                if (IntegerUtils.isNotError(bookMapper.addBookDetail(bookInfo.getBookDetail()))) {
                    return bookMapper.addBookSku(bookInfo.getBookSku());
                }
            }
        }
        return IntegerUtils.ZERO;
    }

    @Override
    public BookInfo getBookById(Integer bookInfoId) {
        return bookMapper.getBookById(bookInfoId);
    }

    @Override
    public String getCategoryName(Integer categoryId) {
        BookCategory category = bookMapper.getCategoryById(categoryId);
        String res = category.getCategoryName();
        while (category.getSuperCategoryId() != IntegerUtils.ZERO) {
            category = bookMapper.getCategoryById(category.getSuperCategoryId());
            res = category.getCategoryName() + "/" + res;
        }
        return res;
    }

    @Override
    @Transactional
    public Integer uploadBookInfoImg(MultipartFile[] files, Integer bookInfoId) throws IOException {
        // 删除原来的图片
        BookInfo bookInfo = bookMapper.getBookById(bookInfoId);
        String bookInfoImg = bookInfo.getBookInfoImg();
        String root = FileUtils.FILE_URL + FileUtils.BOOK_UPLOAD_URL;
        FileUtils.deleteFiles(bookInfoImg,root);
        // 存储新的图片
        BookInfo bi = new BookInfo(bookInfoId, FileUtils.uploadFiles(files, root));
        return bookMapper.updateBookInfo(bi);
    }

    @Override
    @Transactional
    public Integer uploadBookDetailImg(MultipartFile[] files, Integer bookInfoId) throws IOException {
        BookDetail bookDetail = bookMapper.getBookById(bookInfoId).getBookDetail();
        String bookDetailImg = bookDetail.getBookDetailImg();
        String root = FileUtils.FILE_URL + FileUtils.BOOK_UPLOAD_URL;
        FileUtils.deleteFiles(bookDetailImg,root);
        BookDetail bd = new BookDetail(bookDetail.getBookDetailId(), FileUtils.uploadFiles(files, root));
        return bookMapper.updateBookDetail(bd);
    }

    @Override
    public List<BookCategory> getFirClassCategory() {
        return bookMapper.getFirClassCategory();
    }

    @Override
    public List<BookCategory> getSecClassCategory(Integer superCategoryId) {
        return bookMapper.getSecClassCategory(superCategoryId);
    }

    @Override
    public List<BookInfo> listBook() {
        return bookMapper.listBook();
    }

    @Override
    public List<BookInfo> listBook(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return bookMapper.listBook();
    }

    @Override
    public List<BookInfo> listBookByCategory(Integer categoryId) {
        return bookMapper.listBookByCategory(categoryId);
    }

    @Override
    public List<BookInfo> listBookByCategory(Integer categoryId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return bookMapper.listBookByCategory(categoryId);
    }

    @Override
    public List<BookInfo> listBookBySuperCategory(Integer superCategoryId) {
        return bookMapper.listBookBySuperCategory(superCategoryId);
    }

    @Override
    public List<BookInfo> listBookBySuperCategory(Integer superCategoryId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return bookMapper.listBookBySuperCategory(superCategoryId);
    }
}
