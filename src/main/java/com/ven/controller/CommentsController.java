package com.ven.controller;

import com.hiber.model.CommentsEntity;
import com.ven.service.CommentsSelector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
@Controller
@RequestMapping("/query")
public class CommentsController {
    private final CommentsSelector selector;

    @Autowired
    public CommentsController(CommentsSelector selector) {
        this.selector = selector;
    }

    @RequestMapping("/comments")
    @ResponseBody
    public List<CommentsEntity> select_by_id(@RequestParam(value = "id", required = true) int id) {
        List<CommentsEntity> list= selector.selector_by_article_id(id);
        if(list==null)
            return null;
        else
        {
            return list;
        }
    }
    @RequestMapping(value = "/NewComments",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> addComments(@RequestParam(value="username",required = false) String username,
                                     @RequestParam(value="comments",required = false) String comments,
                                     @RequestParam(value="id",required = false) int id_A)
    {

        return selector.add(username,comments,id_A);
    }
}
