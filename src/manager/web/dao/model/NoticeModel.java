package manager.web.dao.model;

import manager.web.dao.entity.Notice;

public class NoticeModel extends Notice {
	
	private int cmtCnt;

	public int getCmtCnt() {
		return cmtCnt;
	}

	public void setCmtCnt(int cmtCnt) {
		this.cmtCnt = cmtCnt;
	}
}
