package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Page {
    //当前页码-来自于用户输入
    private int currentPage = 1;
    //记录当前页码
    private Integer statNo;

    public Integer getStatNo() {
        return statNo;
    }

    public void setStatNo(Integer statNo) {
        this.statNo = statNo;
    }

    //总数量（表）
    private int startPage = 0;

    //页面容量
    private int visiblePages = 5;

    //总页数-totalCount/pageSize（+1）
    private int totalPages = 1;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        if(currentPage > 0){
            this.currentPage = currentPage;
        }
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        if(startPage > 0){
            this.startPage = startPage;
            //设置总页数
            this.setTotalPageCountByRs();
        }
    }
    public int getVisiblePages() {
        return visiblePages;
    }

    public void setVisiblePages(int visiblePages) {
        if(visiblePages > 0){
            this.visiblePages = visiblePages;
        }
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public void setTotalPageCountByRs(){
        if(this.startPage % this.visiblePages == 0){
            this.totalPages = this.startPage / this.visiblePages;
        }else if(this.startPage % this.visiblePages > 0){
            this.totalPages = this.startPage / this.visiblePages + 1;
        }else{
            this.totalPages = 0;
        }
    }
}
