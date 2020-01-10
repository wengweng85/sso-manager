package com.insigma.mvc.model;

public class PageInfoClModel implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    protected int curpage = 1;
    protected int limit = 10;
    protected int offset;

    protected int page=1;
    protected int size=10;

    public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getCurpage() {
        return curpage;
    }

    public void setCurpage(int curpage) {
        this.curpage = curpage;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
