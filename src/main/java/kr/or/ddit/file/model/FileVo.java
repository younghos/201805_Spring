package kr.or.ddit.file.model;

public class FileVo {
	private int id;
	private String s_file_name;
	private String s_org_file_name;
	private String s_file_path;
	private String s_file_ext;
	
	public FileVo() {
		
	}
	
	public FileVo(int id, String s_file_name, String s_org_file_name, String s_file_path, String s_file_ext) {
		this.id = id;
		this.s_file_name = s_file_name;
		this.s_org_file_name = s_org_file_name;
		this.s_file_path = s_file_path;
		this.s_file_ext = s_file_ext;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getS_file_name() {
		return s_file_name;
	}
	public void setS_file_name(String s_file_name) {
		this.s_file_name = s_file_name;
	}
	public String getS_org_file_name() {
		return s_org_file_name;
	}
	public void setS_org_file_name(String s_org_file_name) {
		this.s_org_file_name = s_org_file_name;
	}
	public String getS_file_path() {
		return s_file_path;
	}
	public void setS_file_path(String s_file_path) {
		this.s_file_path = s_file_path;
	}
	public String getS_file_ext() {
		return s_file_ext;
	}
	public void setS_file_ext(String s_file_ext) {
		this.s_file_ext = s_file_ext;
	}
	
	@Override
	public String toString() {
		return "FileVo [id=" + id + ", s_file_name=" + s_file_name + ", s_org_file_name=" + s_org_file_name
				+ ", s_file_path=" + s_file_path + ", s_file_ext=" + s_file_ext + "]";
	}
	
	
}
