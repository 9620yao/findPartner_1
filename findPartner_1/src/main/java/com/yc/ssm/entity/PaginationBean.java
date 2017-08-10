package com.yc.ssm.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 工具类 分页bean
 * 
 * @author Teacher姜
 *
 * @param <T>
 */
public class PaginationBean<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	// 请求参数
	private Integer currPage = 1;// 当前页
	private Integer pageSize = 5;// 每页显示数据的条数

	// 响应的数据
	private Integer totalPage;// 总页数
	private Integer total;// 总数据条数
	private List<T> rows;// 要显示的数据集合

	// private String userid;// 用户编号

	public PaginationBean() {
	}

	public PaginationBean(Integer totalPage, Integer total, List<T> rows) {
		this.totalPage = totalPage;
		this.total = total;
		this.rows = rows;
	}

	public PaginationBean(Integer currPage, Integer pageSize, Integer totalPage, Integer total, List<T> rows) {
		this(totalPage, total, rows);
		this.currPage = currPage;
		this.pageSize = pageSize;
	}

	public Integer getCurrPage() {
		return currPage;
	}

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "PaginationBean [currPage=" + currPage + ", pageSize=" + pageSize + ", totalPage=" + totalPage
				+ ", total=" + total + ", rows=" + rows + "]";
	}
}
