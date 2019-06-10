package com.notalent.bookstore.api;

import com.notalent.bookstore.jwt.CrossTokenValidation;
import com.notalent.bookstore.pojo.book.BookCategory;
import com.notalent.bookstore.pojo.book.BookDetail;
import com.notalent.bookstore.pojo.book.BookInfo;
import com.notalent.bookstore.service.BookService;
import com.notalent.bookstore.util.BookUtils;
import com.notalent.bookstore.util.FileUtils;
import com.notalent.bookstore.util.IntegerUtils;
import com.notalent.bookstore.util.Result;
import com.notalent.bookstore.vo.BookCategoryVO;
import com.notalent.bookstore.vo.BookVO;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 图书api
 * @author noTalent
 * @version 1.0
 * 2019.05.20
 */
@RestController
@RequestMapping("/book/api")
@CrossOrigin("*")
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * 获取图书详细信息
     * @param bookInfoId 图书信息id
     * @return result
     */
    @GetMapping("/v1/book/get")
    @CrossTokenValidation
    public Result getBookById(@RequestParam("bookInfoId") Integer bookInfoId) {
        BookInfo bookInfo = bookService.getBookById(bookInfoId);
        if (bookInfo != null) {
            // 图片访问路径处理
            String root = FileUtils.ROOT_URL + FileUtils.BOOK_VISIT_URL;
            bookInfo.setBookInfoImg(FileUtils.imgUrlHandling(bookInfo.getBookInfoImg(), root));
            BookDetail bookDetail = bookInfo.getBookDetail();
            bookDetail.setBookDetailImg(FileUtils.imgUrlHandling(bookDetail.getBookDetailImg(), root));
            Integer categoryId = bookInfo.getCategoryId();
            return Result.success(new BookVO(bookInfo, bookService.getCategoryName(categoryId)));
        }
        return Result.error();
    }

    /**
     * 图书列表
     * @param pageNum 页码
     * @param pageSize 数目
     * @return result
     */
    @GetMapping("/v1/book/list")
    @CrossTokenValidation
    public Result listBook(Integer pageNum, Integer pageSize) {
        List<BookInfo> bookInfos = bookService.listBook(pageNum, pageSize);
        if (CollectionUtils.isNotEmpty(bookInfos)) {
            List<BookVO> bookVOS = BookUtils.getBookVOList(bookInfos);
            return Result.success(bookVOS);
        }
        return Result.success();
    }

    /**
     * 根据图书分类id获取图书列表
     * @param categoryId 分类id
     * @param pageNum 页码
     * @param pageSize 数目
     * @return result
     */
    @GetMapping("/v1/book-categoryId/list")
    @CrossTokenValidation
    public Result listBookByCategory(Integer categoryId, Integer pageNum,
                                     Integer pageSize) {
        long count = bookService.getFirClassCategory()
                .stream()
                .filter(bookCategory -> bookCategory.getCategoryId() == categoryId)
                .count();
        if (count > IntegerUtils.ZERO) {
            List<BookInfo> bookInfos = bookService.listBookBySuperCategory(categoryId, pageNum, pageSize);
            if (CollectionUtils.isNotEmpty(bookInfos)) {
                List<BookVO> list = BookUtils.getBookVOList(bookInfos);
                return Result.success(list);
            }
            return Result.success();
        }
        List<BookInfo> bookInfos = bookService.listBookByCategory(categoryId, pageNum, pageSize);
        if (CollectionUtils.isNotEmpty(bookInfos)) {
            List<BookVO> list = BookUtils.getBookVOList(bookInfos);
            return Result.success(list);
        }
        return Result.success();
    }

    /**
     * 获取图书一级分类列表
     * @return result
     */
    @GetMapping("/v1/fir-category/list")
    @CrossTokenValidation
    public Result getFirClassCategory() {
        List<BookCategory> bookCategoryList = bookService.getFirClassCategory();
        return Result.success(BookUtils.getBookCategoryVOList(bookCategoryList));
    }

    /**
     * 获取图书二级分类列表
     * @param superCategoryId
     * @return
     */
    @GetMapping("/v1/sec-category/list")
    @CrossTokenValidation
    public Result getSecClassCategory(@RequestParam("superCategoryId") Integer superCategoryId) {
        List<BookCategory> bookCategories = bookService.getSecClassCategory(superCategoryId);
        return Result.success(BookUtils.getBookCategoryVOList(bookCategories));
    }

    /**
     * 获取图书分类名
     * @param categoryId
     * @return result
     */
    @GetMapping("/v1/category-name/get")
    @CrossTokenValidation
    public Result getCategoryName(Integer categoryId) {
        String categoryName = bookService.getCategoryName(categoryId);
        BookCategory category = new BookCategory();
        category.setCategoryName(categoryName);
        return Result.success(new BookCategoryVO(category));
    }

}
