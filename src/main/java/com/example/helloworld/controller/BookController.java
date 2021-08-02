package com.example.helloworld.controller;

import com.example.helloworld.dao.Employee;
import com.example.helloworld.dao.EmployeeMapper;
import com.example.helloworld.entity.Book;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@MapperScan("com.example.helloworld.dao")
public class BookController {

    private List<Book> books = new ArrayList<>();
    @Value("${wuhan2020}")
    String wuhan;

    @Autowired
    private EmployeeMapper employeeMapper;

    @PostMapping("/book")
    public ResponseEntity<List<Book>> addBook(@RequestBody Book book) {
        books.add(book);
        return ResponseEntity.ok(books);
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity deleteBookById(@PathVariable("id") int id) {
        books.remove(id);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/book")
    public ResponseEntity getBookByName(@RequestParam("name") String name) {
        List<Book> results = books.stream().filter(book -> book.getName().equals(name)).collect(Collectors.toList());
        List<Employee> employees = employeeMapper.selectList(null);
        List<Employee> list = employeeMapper.findEmployee();
        list.forEach(System.out::println);
        System.out.println("==============================");
        employees.forEach(System.out::println);
        System.out.println(wuhan);
        System.out.println("==============================");
        /*增加*/
        Employee newEmployee=new Employee(4L,"王芳","wangfang@qq.com",25);
        employeeMapper.addEmployee(newEmployee);
        list=employeeMapper.findEmployee();
        list.forEach(System.out::println);
        System.out.println("========================");
        /*删除*/
        employeeMapper.deleteEmployee(2L);
        list=employeeMapper.findEmployee();
        list.forEach(System.out::println);
        System.out.println("==============================");
        /*改*/
        Employee changeEmployee=new Employee(1L,"王芳","wangfang@qq.com",25);
        employeeMapper.changeEmployee(changeEmployee);
        list=employeeMapper.findEmployee();
        list.forEach(System.out::println);
        System.out.println("==============================");
        /*查*/
        Employee find=employeeMapper.find(1L);
        System.out.println(find);


        return ResponseEntity.ok(results);

    }





    }
