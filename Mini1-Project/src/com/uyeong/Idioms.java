package com.uyeong;

import java.io.*;

public class Idioms implements Serializable{
	private int pno;		// 단어 개수
	private String idioms;	// 사자성어
	private String meaning;	// 뜻
	private String re;	// 수정
	private String del;	// 삭제
	private String idiomslist;	// 목록
	public int getPno() {
		return pno;
	
}
	public String getIdioms() {
		return idioms;
	}
	public void setIdioms(String idioms) {
		this.idioms = idioms;
	}
	public String getMeaning() {
		return meaning;
	}
	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}
	public String getre() {
		return re;
	}
	public void setre(String re) {
		this.re = re;
	}
	public String getdel() {
		return del;
	}
	public void setdel(String del) {
		this.del = del;
	}
	public String getIdiomslist() {
		return idiomslist;
	}
	public void setIdiomslist(String idiomslist) {
		this.idiomslist = idiomslist;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
}