package com.notalent.bookstore.api.admin;

import com.notalent.bookstore.jwt.CrossTokenValidation;
import com.notalent.bookstore.service.BookService;
import com.notalent.bookstore.util.IntegerUtils;
import com.notalent.bookstore.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController("bookAdminController")
@RequestMapping("/book-admin/api")
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * 图书封面上传
     * @param files 封面
     * @param bookInfoId 图书id
     * @return result
     * @throws IOException
     */
    @PostMapping("/v1/bookInfoImg/upload")
    @CrossTokenValidation
    public Result uploadBookInfoImg(@RequestParam("files") MultipartFile[] files,
                                    @RequestParam("bookInfoId") Integer bookInfoId) throws IOException {
        if (IntegerUtils.isNotError(bookService.uploadBookInfoImg(files, bookInfoId))) {
            return Result.success();
        }
        return Result.error();
    }

    /**
     * 图书详情上传
     * @param files 详情图片
     * @param bookInfoId 图书id
     * @return result
     * @throws IOException
     */
    @PostMapping("/v1/bookDetailImg/upload")
    @CrossTokenValidation
    public Result uploadBookDetailImd(@RequestParam("files") MultipartFile[] files,
                                      @RequestParam("bookInfoId") Integer bookInfoId) throws IOException {
        if (IntegerUtils.isNotError(bookService.uploadBookDetailImg(files, bookInfoId))) {
            return Result.success();
        }
        return Result.error();
    }
}
