package review.web.dao.model;

import review.web.dao.entity.Review;

public class ReviewModel extends Review {
	
	private int cmtCnt;

	public int getCmtCnt() {
		return cmtCnt;
	}

	public void setCmtCnt(int cmtCnt) {
		this.cmtCnt = cmtCnt;
	}
}
