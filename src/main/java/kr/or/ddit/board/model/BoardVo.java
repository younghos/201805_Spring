package kr.or.ddit.board.model;

public class BoardVo {

	private int boardId;
	private String boardNm;
	private String regId;
	
	// 대부분의 프레임워크에서는 기본생성자가 필요!!
	public BoardVo() {
		
	}

	public BoardVo(int boardId, String boardNm, String regId) {
		this.boardId = boardId;
		this.boardNm = boardNm;
		this.regId = regId;
	}
	
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getBoardNm() {
		return boardNm;
	}
	public void setBoardNm(String boardNm) {
		this.boardNm = boardNm;
	}
	public String getRegId() {
		return regId;
	}
	public void setRegId(String regId) {
		this.regId = regId;
	}
	
	@Override
	public String toString() {
		return "BoardVo [boardId=" + boardId + ", boardNm=" + boardNm + ", regId=" + regId + "]";
	}
	
	
}
