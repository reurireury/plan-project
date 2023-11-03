package com.spring.market_1.product.dto;

import org.springframework.stereotype.Component;

@Component("productDTO")
public class ProductDTO 
{
	private int p_no;
	private String p_name;
	private int p_price;
	private int p_amount;
	private int p_hits;
	private String p_stat;
	private String p_cate1;
	private String p_cate2;
	private int p_like;
	private int p_how;
	private String p_addr;
	public int getP_no() {
		return p_no;
	}
	public void setP_no(int p_no) {
		this.p_no = p_no;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public int getP_price() {
		return p_price;
	}
	public void setP_price(int p_price) {
		this.p_price = p_price;
	}
	public int getP_amount() {
		return p_amount;
	}
	public void setP_amount(int p_amount) {
		this.p_amount = p_amount;
	}
	public int getP_hits() {
		return p_hits;
	}
	public void setP_hits(int p_hits) {
		this.p_hits = p_hits;
	}
	public String getP_stat() {
		return p_stat;
	}
	public void setP_stat(String p_stat) {
		this.p_stat = p_stat;
	}
	public String getP_cate1() {
		return p_cate1;
	}
	public void setP_cate1(String p_cate1) {
		this.p_cate1 = p_cate1;
	}
	public String getP_cate2() {
		return p_cate2;
	}
	public void setP_cate2(String p_cate2) {
		this.p_cate2 = p_cate2;
	}
	public int getP_like() {
		return p_like;
	}
	public void setP_like(int p_like) {
		this.p_like = p_like;
	}
	public int getP_how() {
		return p_how;
	}
	public void setP_how(int p_how) {
		this.p_how = p_how;
	}
	public String getP_addr() {
		return p_addr;
	}
	public void setP_addr(String p_addr) {
		this.p_addr = p_addr;
	}
	
	
}
