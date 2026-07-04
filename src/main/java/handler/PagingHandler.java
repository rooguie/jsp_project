package handler;

import domain.PagingVO;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter

public class PagingHandler {
	
	// 시작 페이징 넘버
	private int startPage;
	// 끝 페이징 넘버
	private int endPage;
	// 진짜 끝 페이징 넘버
	private int realEndPage;
	// 이전버튼 활성여부
	private boolean prev;
	// 다음 버튼 활성여부
	private boolean next;
	
	//전체 게시글 수 가져오기
	private PagingVO pagingVO;
	private int totalCnt;
	
	public PagingHandler(PagingVO pagingVO, int totalCnt ) {
		this.pagingVO=pagingVO;
		this.totalCnt=totalCnt;
		
		this.endPage=(int)Math.ceil((double)pagingVO.getPageNo()/10)*10;
		this.startPage=this.endPage-9;
		
		this.realEndPage=(int)Math.ceil((double)this.totalCnt/pagingVO.getQty());
		
		this.endPage=Math.min(endPage, realEndPage);
		
		this.prev=this.startPage>1; //start페이지는 항상 1, 11 , 21 ...
		this.next=this.realEndPage > this.endPage;
		
	}
	
}
