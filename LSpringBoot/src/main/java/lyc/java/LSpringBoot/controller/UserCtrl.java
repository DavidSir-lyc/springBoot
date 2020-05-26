package lyc.java.LSpringBoot.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lyc.java.LSpringBoot.dao.UserMapper;
import lyc.java.LSpringBoot.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserCtrl {
    @Autowired
    private UserMapper userMapper;

    /**查询全部用户*/
    @GetMapping("/getAllUser")
    public Object getAllUser(@RequestParam(value = "pageNo",required = false,defaultValue = "1") Integer pageNo, @RequestParam(value = "pageSize",required = false,defaultValue = "3") Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<User> getAllUser = userMapper.selectAll(pageNo, pageSize);
        PageInfo<User> pageInfo = new PageInfo<>(getAllUser);
        return pageInfo;
    }
    @PostMapping("/postAllUser1")
    public Object postAllUser1(@RequestParam(value = "pageNo",required = false,defaultValue = "1") Integer pageNo, @RequestParam(value = "pageSize",required = false,defaultValue = "3") Integer pageSize){
        PageHelper.startPage(pageNo, pageSize);
        List<User> postAllUser = userMapper.selectAll(pageNo, pageSize);
        PageInfo<User> pageInfo = new PageInfo<>(postAllUser);
        return pageInfo;
    }
    @PostMapping("/postAllUser2")
    public Object postAllUser2(@RequestBody String requestParams){
        System.out.println(requestParams);
        System.out.println(JSON.parseObject(requestParams).get("pageNo"));
        Integer pageNo = (Integer) JSON.parseObject(requestParams).get("pageNo");
        Integer pageSize = (Integer) JSON.parseObject(requestParams).get("pageSize");
        PageHelper.startPage(pageNo, pageSize);
        List<User> postAllUser = userMapper.selectAll(pageNo, pageSize);
        PageInfo<User> pageInfo = new PageInfo<>(postAllUser);
        return pageInfo;
    }

    /**根据ID查询用户*/
    @GetMapping("/getUserById")
    public Object selectUser(@RequestParam(value = "id",required = false,defaultValue = "1") String id) {
        return userMapper.selectUser(id);
    }

    /**新增用户*/
    @GetMapping("/insertUser")
    public String insertUser(@RequestParam(value = "name") String name, @RequestParam(value = "age") Integer age, @RequestParam(value = "score") Double score) {
        userMapper.insertUser(name, age, score);
        return "插入成功！";
    }

    /**删除用户*/
    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam(value = "id") String id) {
        userMapper.deleteUser(id);
        return "删除成功！";
    }

/*
//通过RequestMethod.GET表示请求需要时GET方式
    @RequestMapping(value = "/getReq", method = RequestMethod.GET)
    public String getReqFun(@RequestParam(value = "umName") String umName){
        return "hello:" + umName;
    }


    //通过RequestMethod.POST表示请求需要时POST方式
    @RequestMapping(value = "/postReq", method = RequestMethod.POST)
    public String postReqFun(@RequestParam(value = "umName") String userName){
        return "Hello " + userName;
    }


    //在入参设置@RequestBody注解表示接收整个报文体，这里主要用在接收整个POST请求中的json报文体，
    //目前主流的请求报文也都是JSON格式了，使用该注解就能够获取整个JSON报文体作为入参，使用JSON解析工具解析后获取具体参数
    @RequestMapping(value = "/postReqByJson",method = RequestMethod.POST)
    public String postReqByJsonFun(@RequestBody String data){
        return "Json is " + data;
    }

    // 异常捕获
    @RequestMapping(value = "/error",method = RequestMethod.GET)
    public String errorFun() {
        int num = 1/0;
        return "捕获到异常！";
    }

    // 集成mybatis--->select
    @RequestMapping(value = "/getUserById", method = RequestMethod.GET)
    public Object selectUser(Integer id) {
        return userMapper.selectUser(id);
    }

    // 集成mybatis--->insert
    @RequestMapping(value = "/insertUser", method = RequestMethod.GET)
    public Object insertUser(Integer id, String name,Integer age, double score) {
        userMapper.insertUser(id, name, age, score);
        return "插入成功！";
    }

    // 集成mybatis--->update
    @RequestMapping(value = "/updateUser", method = RequestMethod.GET)
    public Object updateUser(Integer id, String name,Integer age, double score) {
        userMapper.updateUser(id, name, age, score);
        return "修改成功！";
    }

    // 集成mybatis--->delete
    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public Object deleteUser(Integer id) {
        userMapper.deleteUser(id);
        return "删除成功！";
    }

    // 集成mybatis--->事务
    @Transactional
    @RequestMapping(value = "/commitUser", method = RequestMethod.GET)
    public Object commitUser(Integer id, String name,Integer age, double score) {
        userMapper.insertUser(id, name, age, score);
        // int num = 2/0;
        userMapper.deleteUser(id);
        return "事务成功！";
    }*/
}
