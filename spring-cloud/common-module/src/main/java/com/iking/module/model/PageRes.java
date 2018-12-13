package com.iking.module.model;

import java.io.Serializable;
import java.util.List;

/**
 * 分页对象
 * 
 * @author tjw
 * @date 2018年2月3日 下午12:00:04
 */
public class PageRes<T> implements Serializable{

	private static final long serialVersionUID = -485281064667946990L;

	private int pageCurrent;	// 当前页
	
	private int itemTotal;		// 总条数
	
	private int pageSize;		// 分页大小
	
	private int pageCount;		// 总页数
	
	private int startIndex;		// 起始行
	
	private List<T> items;		// 查询数据

    public PageRes(){
        super();
    }

    public PageRes(int pageCurrent, int pageSize, int itemTotal, List<T> items) {
        setPageCurrent(pageCurrent);
        setPageSize(pageSize);
        setItemTotal(itemTotal);
        this.items = items;
    }

	public int getPageCurrent() {
		return pageCurrent;
	}



    public void setPageCurrent(int pageCurrent) {
		this.pageCurrent = pageCurrent;
		setStartIndex();
	}

	public int getItemTotal() {
		return itemTotal;
	}

	public void setItemTotal(int itemTotal) {
		this.itemTotal = itemTotal;
		this.pageCount = this.itemTotal % this.pageSize == 0 ? this.itemTotal / this.pageSize
				: this.itemTotal / this.pageSize + 1;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		setStartIndex();
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public List<T> getItems() {
		return items;
	}

	public void setItems(List<T> items) {
		this.items = items;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex() {
		if (this.pageCurrent != 0 && this.pageSize != 0) {
			this.startIndex = (this.pageCurrent - 1) * this.pageSize;
		} else {
			this.startIndex = 0;
		}
	}

	@Override
	public String toString() {
		return "PageRes [pageCurrent=" + pageCurrent + ", itemTotal=" + itemTotal + ", pageSize=" + pageSize
				+ ", pageCount=" + pageCount + ", startIndex=" + startIndex + ", items=" + items + "]";
	}

}
