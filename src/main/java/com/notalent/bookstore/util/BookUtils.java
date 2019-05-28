package com.notalent.bookstore.util;

import com.notalent.bookstore.pojo.book.BookCategory;
import com.notalent.bookstore.pojo.book.BookDetail;
import com.notalent.bookstore.pojo.book.BookInfo;
import com.notalent.bookstore.service.BookService;
import com.notalent.bookstore.vo.BookCategoryVO;
import com.notalent.bookstore.vo.BookVO;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 图书工具类
 * @author noTalent
 * @version 1.0
 * 2019.05.21
 */
public class BookUtils {

    /**
     * 图书分类列表转图书分类展示对象列表
     * @param bookCategories
     * @return
     */
    public static List<BookCategoryVO> getBookCategoryVOList(List<BookCategory> bookCategories) {
        List<BookCategoryVO> bookCategoryVOS = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(bookCategories)) {
            Iterator<BookCategory> iterator = bookCategories.iterator();
            while (iterator.hasNext()) {
                bookCategoryVOS.add(new BookCategoryVO(iterator.next()));
            }
        }
        return bookCategoryVOS;
    }


    /**
     * 图书列表转换为图书展示对象列表
     * @param bookInfos
     * @return
     */
    public static List<BookVO> getBookVOList(List<BookInfo> bookInfos) {
        List<BookVO> bookVOS = new ArrayList<>();
        String root = FileUtils.ROOT_URL + FileUtils.BOOK_VISIT_URL;
        if (CollectionUtils.isNotEmpty(bookInfos)) {
            Iterator<BookInfo> iterator = bookInfos.iterator();
            while (iterator.hasNext()) {
                BookInfo bookInfo = iterator.next();
                bookInfo.setBookInfoImg(FileUtils.imgUrlHandling(bookInfo.getBookInfoImg(), root));
                BookDetail bookDetail = bookInfo.getBookDetail();
                bookInfo.getBookDetail().setBookDetailImg(FileUtils.imgUrlHandling(bookDetail.getBookDetailImg(), root));
                bookVOS.add(new BookVO(bookInfo, bookInfo.getBookCategory().getCategoryName()));
            }
        }
        return bookVOS;
    }

}
