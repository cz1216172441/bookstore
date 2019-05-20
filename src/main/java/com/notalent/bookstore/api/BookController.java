package com.notalent.bookstore.api;

import com.notalent.bookstore.jwt.CrossTokenValidation;
import com.notalent.bookstore.pojo.book.BookDetail;
import com.notalent.bookstore.pojo.book.BookInfo;
import com.notalent.bookstore.service.BookService;
import com.notalent.bookstore.util.BookUtils;
import com.notalent.bookstore.util.FileUtils;
import com.notalent.bookstore.util.Result;
import com.notalent.bookstore.vo.BookVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 图书api
 * @author noTalent
 * @version 1.0
 * 2019.05.20
 */
@RestController
@RequestMapping("/book/api")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/v1/book/get")
    @CrossTokenValidation
    public Result getBookById(@RequestParam("bookInfoId") Integer bookInfoId) {
        BookInfo bookInfo = bookService.getBookById(bookInfoId);
        if (bookInfo != null) {
            // 图片访问路径处理
            String root = FileUtils.ROOT_URL + FileUtils.BOOK_VISIT_URL;
            bookInfo.setBookInfoImg(BookUtils.imgUrlHandling(bookInfo.getBookInfoImg(), root));
            BookDetail bookDetail = bookInfo.getBookDetail();
            bookDetail.setBookDetailImg(BookUtils.imgUrlHandling(bookDetail.getBookDetailImg(), root));
            Integer categoryId = bookInfo.getCategoryId();
            return Result.success(new BookVO(bookInfo, bookService.getCategoryName(categoryId)));
        }
        return Result.error();
    }

}
