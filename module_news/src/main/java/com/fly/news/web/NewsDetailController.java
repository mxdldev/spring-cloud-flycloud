package com.fly.news.web;

import com.fly.common.annotation.SysLogger;
import com.fly.common.dto.RespDTO;
import com.fly.news.entity.NewsDetail;
import com.fly.news.service.NewsDetailService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Description: <><br>
 * Author:    门心叼龙<br>
 * Date:      2019/2/19<br>
 * Version:    V1.0.0<br>
 * Update:     <br>
 */
@RestController
@RequestMapping("/newsdetail")
public class NewsDetailController {

    @Autowired
    NewsDetailService newsDetailService;

    @ApiOperation(value = "添加新闻详情", notes = "添加新闻详情")
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/save")
    @SysLogger("addNewsDetail")
    public RespDTO saveNewsDetail(@RequestBody NewsDetail newsDetail){
        NewsDetail newsDetail1 = newsDetailService.saveNewsDetail(newsDetail);
        return RespDTO.onSuc(newsDetail1);
    }

    @ApiOperation(value = "获取指定类型的新闻详情", notes = "获取指定类型的新闻详情")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    @PostMapping("/query/all")
    @SysLogger("getListNewsDetail")
    public RespDTO getListNewsDetail(int typid){
        List<NewsDetail> newsDetails = newsDetailService.findListByTypeid(typid);
        return RespDTO.onSuc(newsDetails);
    }

    @ApiOperation(value = "根据id删除新闻详情", notes = "根据id删除新闻详情")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/{id}/delete")
    @SysLogger("deleteNewsDetail")
    public RespDTO deleteNewsDetail(@PathVariable Long id){
        RespDTO respDTO = new RespDTO();
        try {
            newsDetailService.deleteNewsDetail(id);
            respDTO.setError("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            respDTO.setCode(1);
            respDTO.setError("删除失败");
        }
        return respDTO;
    }
}
