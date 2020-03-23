package com.mxdl.controller;

import com.mxdl.model.NewsDetail;
import com.mxdl.model.RespDTO;
import com.mxdl.service.NewsDetailService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Description: <><br>
 * Author:    mxdl<br>
 * Date:      2020/3/18<br>
 * Version:    V1.0.0<br>
 * Update:     <br>
 */
@RestController
@RequestMapping("/newsapi/newsdetail")
public class NewsDetailController {

    @Autowired
    NewsDetailService newsDetailService;

    @ApiOperation(value = "添加新闻详情", notes = "添加新闻详情")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/save")
    public RespDTO saveNewsDetail(@RequestBody NewsDetail newsDetail){
        NewsDetail newsDetail1 = newsDetailService.saveNewsDetail(newsDetail);
        return RespDTO.onSuc(newsDetail1);
    }

    @ApiOperation(value = "获取指定类型的新闻列表", notes = "获取指定类型的新闻列表")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/query/all")
    public RespDTO getListNewsDetail(int typid){
        List<NewsDetail> newsDetails = newsDetailService.findListByTypeid(typid);
        return RespDTO.onSuc(newsDetails);
    }

    @ApiOperation(value = "根据id查询新闻详情", notes = "根据id查询新闻详情")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/{id}/detail")
    public RespDTO getNewsDetail(@PathVariable Long id){
        return RespDTO.onSuc(newsDetailService.findNewsDetailById(id));
    }

    @ApiOperation(value = "根据id删除新闻详情", notes = "根据id删除新闻详情")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/{id}/delete")
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
