package com.yunji.swagger.controller;

import com.yunji.swagger.dto.UserRequest;
import com.yunji.swagger.dto.UserResponse;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"API 정보를 제공하는 controller"})
@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name="x", value = "x값", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name="y", value = "y값", required = true, dataType = "int", paramType = "query")
    })
    @GetMapping("/plus/{x}")
    public int plus(
            @PathVariable int x,
            @RequestParam int y){
        return x+y;
    }


    @ApiResponse(code = 502, message = "사용자의 나이가 10살 이하일 때")
    @ApiOperation(value = "사용자의 이름과 나이를 리턴하는 method")
    @GetMapping("/user")
    public UserResponse user(UserRequest user){
        return new UserResponse(user.getAge(), user.getName());
    }

    @PostMapping("/user")
    public UserResponse userPost(@RequestBody UserRequest user){
        return new UserResponse(user.getAge(), user.getName());
    }


}
