package com.notalent.bookstore.mapper;

import com.notalent.bookstore.BookstoreApplication;
import com.notalent.bookstore.pojo.book.BookCategory;
import com.notalent.bookstore.pojo.book.BookDetail;
import com.notalent.bookstore.pojo.book.BookInfo;
import com.notalent.bookstore.pojo.book.BookSku;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.awt.print.Book;
import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {BookstoreApplication.class})
public class BookMapperTest {

    @Resource
    private BookMapper bookMapper;

    @Test
    public void addBookInfo() {
        BookInfo bi = new BookInfo();
        bi.setBookName("人生海海");
        bi.setBookAuthor("麦家");
        bi.setBookActualPrice(new BigDecimal(53.9));
        bi.setBookOriginalPrice(new BigDecimal(55));
        bi.setCategoryId(2);
        bi.setBookInfoImg("");
        bi.setBookStatus(false);
        int res = bookMapper.addBookInfo(bi);
        Assert.assertEquals(1, res);
    }

    @Test
    public void addBookDetail() {
        BookDetail bd = new BookDetail();
        bd.setBookDetailImg("");
        bd.setBookInfoId(1);
        bd.setBookIsbn("9787530219218");
        bd.setPublishingHouse("北京十月文艺出版社");
        bd.setPublishingTime(new Date());
        bd.setBookIntro("人生海海，何必在意一时沉浮！《风声》作家、茅盾文学奖得主麦家2019强力之作，挑战常人不敢落笔之处，解密人性的荒唐与高尚。");
        int res = bookMapper.addBookDetail(bd);
        Assert.assertEquals(1, res);
    }

    @Test
    public void addBookCategory() {
        BookCategory bc = new BookCategory();
        bc.setCategoryName("中国当代小说");
        bc.setSuperCategoryId(1);
        int res = bookMapper.addBookCategory(bc);
        Assert.assertEquals(1, res);
    }

    @Test
    public void addBookSku() {
        BookSku bs = new BookSku();
        bs.setBookInfoId(1);
        bs.setBookStock(1000);
        int res = bookMapper.addBookSku(bs);
        Assert.assertEquals(1, res);
    }

    @Test
    public void getBookById() {
        System.err.println(bookMapper.getBookById(1).toString());
    }

    @Test
    public void updateBookInfo() {
    }

    @Test
    public void updateBookDetail() {
    }

    @Test
    public void updateBookCategory() {
    }

    @Test
    public void updateBookSku() {
    }
}