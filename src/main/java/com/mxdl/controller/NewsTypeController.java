package com.mxdl.controller;

import com.mxdl.model.NewsType;
import com.mxdl.model.RespDTO;
import com.mxdl.service.NewsTypeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Description: <><br>
 * Author:    mxdl<br>
 * Date:      2019/2/19<br>
 * Version:    V1.0.0<br>
 * Update:     <br>
 */
@RestController
@RequestMapping("/newsapi/newstype")
public class NewsTypeController {

    @Autowired
    NewsTypeService newsTypeService;

    @ApiOperation(value = "添加新闻类型", notes = "添加新闻类型")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/save")
    public RespDTO saveNewsType(@RequestBody NewsType newsType){
       NewsType newsType1 = newsTypeService.saveNewsType(newsType);
       return RespDTO.onSuc(newsType1);
    }

    @ApiOperation(value = "获取所有的新闻类型", notes = "获取所有的新闻类型")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/query/all")
    public RespDTO getListNewsType(){
        List<NewsType> newsTypes = newsTypeService.findListNewsType();
        return RespDTO.onSuc(newsTypes);
    }

    @ApiOperation(value = "根据id删除新闻类型", notes = "根据id删除新闻类型")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/{id}/delete")
    public RespDTO deleteNewsType(@PathVariable Long id){
        RespDTO respDTO = new RespDTO();
        try {
            newsTypeService.deleteBlog(id);
            respDTO.setError("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            respDTO.setCode(1);
            respDTO.setError("删除失败");
        }
        return respDTO;
    }
}
