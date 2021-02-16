package com.example.study.controller;


import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController     // 컨트롤러로 활용한다는 표시를 하는 어노테이션
@RequestMapping("/api") // API주소를 받아오는 용도의 어노테이션(localhost : 8080)
public class GetController {
    //localhost:8080/api/getMethod
    @RequestMapping(method = RequestMethod.GET, path = "/getMethod")
    public String getRequest(){

        return "Hi getMethod";
    }

    //localhost:8080/api/getParameter?id=1234&password=abcd
    @GetMapping("/getParameter")   //RequestMapping과 다르게 GetMapping은 주소만 지정하면 사용가능.
    public String getParameter(@RequestParam String id, @RequestParam String password){
        System.out.println("id : " + id);
        System.out.println("password : " + password);

        return id+password;
    }

    //localhost:8080/api/multiParameter?account=abcd&email=study@gamil.com&page=10
    @GetMapping("/getMultiParameter")
    public SearchParam getMultiParameter(SearchParam searchParam){
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());

        //제이슨 방식으로 데이터통신을 받길 원함
        /*
            @GetMapping("/getMultiParameter")
        public String getMultiParameter(SearchParam searchParam){
            System.out.println(searchParam.getAccount());
            System.out.println(searchParam.getEmail());
            System.out.println(searchParam.getPage());

            return "OK";
         */
        // 저기에서 String을 클래스이름(SearchParam) 으로 바꿔주면됨. 리턴은 searchParam
        // 자동으로 데이터가 JSON으로 형변환 됨
        return searchParam;
    }
}
