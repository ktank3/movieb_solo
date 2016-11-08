package manager.web.dao.model;

import manager.web.dao.entity.Review;

public class ReviewModel extends Review {
	
	private int cmtCnt;

	public int getCmtCnt() {
		return cmtCnt;
	}

	public void setCmtCnt(int cmtCnt) {
		this.cmtCnt = cmtCnt;
	}
}
