package com.example.demo.controller;

import com.example.demo.FileUpload;
import com.example.demo.entities.Library;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
//本示例程序未使用数据库，将数据保存在session中
@SessionAttributes("books")
public class IndexController{

    @RequestMapping("/index")
    public  String index(Model model){
        model.addAttribute("message", "Hello Spring MVC!");
        return "index";
    }

    //book和add需要实现拦截

    @GetMapping("/add")
    String addForm() {
        return "add";
    }

    @PostMapping("/add")
    String add(Model model, @SessionAttribute List<Library> books, @RequestParam String bookname,@RequestParam String author,
               @RequestParam String publisher, @RequestParam String publishDate, @RequestParam String num,@RequestParam("bookPic") MultipartFile image_file){
        Library lib = new Library();
        lib.setBookname("图书名称: " + bookname);
        lib.setAuthor("作者: " + author);
        lib.setPublisher("出版社: " + publisher);
        lib.setPublishDate("出版日期: " + publishDate);
        lib.setLeftNumber("库存数量: " +num);
        //lib.fileName = FileUpload.upload_file(bookPic,"D:/upload");
        FileUpload fileUpload = new FileUpload();
        lib.fileName = fileUpload.upload_file(bookPic,"D:/upload");
        books.add(lib);
        return "book";
    }

    @GetMapping("/login")
    String loginForm() {
        return "log_in";
    }


    @PostMapping("/login")
    String loginCheck(Model model, @RequestParam String user, @RequestParam String password, ServletRequest servletRequest, ServletResponse servletResponse) {
        if(password.equals("123")){
            HttpServletRequest req = (HttpServletRequest) servletRequest;
            HttpSession session = req.getSession();
            session.setAttribute("login_state","logged");
            return "book";
        }
        else {
            return "log_in";
        }
    }

    @GetMapping("/book")
    String bookForm(Model model, @SessionAttribute(required=false) List<Library> books) {
        if(books == null) {
            books = new ArrayList<>();
        }
        model.addAttribute("books", books);
        return "book";
    }
}
