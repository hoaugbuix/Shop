package com.hoangbui.shopping.controller.admin;

import java.util.List;

import com.hoangbui.shopping.entity.CategoryEntity;
import com.hoangbui.shopping.exception.DuplicateRecordException;
import com.hoangbui.shopping.model.req.create.CreateCategoryReq;
import com.hoangbui.shopping.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/v1/admin/category")
@CrossOrigin(origins = "*")
public class ManagementCategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create")
    private ResponseEntity<?> create(@RequestBody CreateCategoryReq req) {
        CategoryEntity cate;
        CategoryEntity code = categoryService.findByCode(req.getCategoryCode());
        if (code != null) {
            throw new DuplicateRecordException("Category exist");
        } else {
            cate = categoryService.save(req);
        }
        return new ResponseEntity<>(cate, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<?> delete(@PathVariable int id){
        try {
            categoryService.delete(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Delete category success!", HttpStatus.OK);
    }

    @GetMapping("/findAll")
    private ResponseEntity<?> findAll() {
        List<CategoryEntity> cate = categoryService.findAll();
        return new ResponseEntity<>(cate.isEmpty() ? null : cate, HttpStatus.OK);
    }

}
