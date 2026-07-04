package domain;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter

public class PagingVO {

	//페이징 숫자 1,2,3,4,
	private int pageNo;
	//한 페이지에 나올 게시글 숫자
	private int qty;
	
	public PagingVO() {
		this.pageNo=1;
		this.qty=10;
	}
	
	public PagingVO(int pageNo) {
		this.pageNo=pageNo;
		this.qty=10;
	}
	
	public int getPageIndex() {
		return (this.pageNo-1)*this.qty;
	}
	
}
