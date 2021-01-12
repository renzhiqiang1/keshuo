package com.ks.keshuoservice.utils.common;

import java.util.List;
import org.apache.commons.lang.StringUtils;

public class PageHelperData {

    private int pageNum; //页码
    private int pageSize; //当前页条数
    private PageData pd = new PageData();//条件
    private String direction;//0降序，1升序
    private String order;//排序字段

    private String menu_name;//菜单名称
    private String btn_name;//按钮名称

    private Object user;

    public Object getUser() {
        return user;
    }

    public void setUser(Object user) {
        this.user = user;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public String getBtn_name() {
        return btn_name;
    }

    public void setBtn_name(String btn_name) {
        this.btn_name = btn_name;
    }

    private String orderBy; //排序  格式如：ID desc
    
    private List<PageData> resultList;//分页查询返回值

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public PageData getPd() {
        return pd;
    }

    public void setPd(PageData pd) {
        this.pd = pd;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        if(StringUtils.isNotBlank(direction)){
            this.orderBy = getOrder()+" "+ direction;
            this.direction = direction;
        }else {
            this.direction = direction;
        }
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
    
    public void setResultList(List<PageData> resultList) {
		this.resultList = resultList;
	}

	public List<PageData> getResultList() {
		return resultList;
	}
    
    
}
