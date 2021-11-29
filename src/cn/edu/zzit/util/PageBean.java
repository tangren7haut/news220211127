package cn.edu.zzit.util;

import java.util.List;

public class PageBean<T>{
    private int totalCount;   //总记录数
    private int totalPage;     //总页码
    private int rows;       //每页显示的记录数
    private int currentPage;    //当前页码
    private List<T> list; //每页的数据

    public PageBean() {
    }

    public PageBean(int totalCount, int totalPage, int rows, int currentPage, List<T> list) {
        this.totalCount = totalCount;
        this.totalPage = totalPage;
        this.rows = rows;
        this.currentPage = currentPage;
        this.list = list;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", rows=" + rows +
                ", currentPage=" + currentPage +
                ", list=" + list +
                '}';
    }
}