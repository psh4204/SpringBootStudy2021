package com.example.study.controller;


import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostController {

    //html <Form>
    //ajax 검색
    // 검색에 사용된다 이말임
    // http post body -> 데이터
    // 데이터 방식마다 Post매핑 에 값 넣어줘야함.

    
    @PostMapping("/postMethod")
    public SearchParam postMethod(@RequestBody SearchParam serachParam){
        return serachParam;
    }
}
