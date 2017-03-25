package com.xy9860.shop.model;

import java.io.Serializable;

public class BackData implements Serializable {

	private String r0_Cmd;
	private String p1_MerId;
	private String r1_Code;
	private String r2_TrxId;
	private String r3_Amt;
	private String r4_Cur;
	private String r5_Pid;
	private String r6_Order;
	private String r7_Uid;
	private String r8_MP;
	private String r9_BType;
	private String hmac;
	 
	public String getHmac() {
		return hmac;
	}
	public void setHmac(String hmac) {
		this.hmac = hmac;
	}
	public String getR0_Cmd() {
		return r0_Cmd;
	}
	public void setR0_Cmd(String r0_Cmd) {
		this.r0_Cmd = r0_Cmd;
	}
	public String getP1_MerId() {
		return p1_MerId;
	}
	public void setP1_MerId(String p1_MerId) {
		this.p1_MerId = p1_MerId;
	}
	public String getR1_Code() {
		return r1_Code;
	}
	public void setR1_Code(String r1_Code) {
		this.r1_Code = r1_Code;
	}
	public String getR2_TrxId() {
		return r2_TrxId;
	}
	public void setR2_TrxId(String r2_TrxId) {
		this.r2_TrxId = r2_TrxId;
	}
	public String getR3_Amt() {
		return r3_Amt;
	}
	public void setR3_Amt(String r3_Amt) {
		this.r3_Amt = r3_Amt;
	}
	public String getR4_Cur() {
		return r4_Cur;
	}
	public void setR4_Cur(String r4_Cur) {
		this.r4_Cur = r4_Cur;
	}
	public String getR5_Pid() {
		return r5_Pid;
	}
	public void setR5_Pid(String r5_Pid) {
		this.r5_Pid = r5_Pid;
	}
	public String getR6_Order() {
		return r6_Order;
	}
	public void setR6_Order(String r6_Order) {
		this.r6_Order = r6_Order;
	}
	public String getR7_Uid() {
		return r7_Uid;
	}
	public void setR7_Uid(String r7_Uid) {
		this.r7_Uid = r7_Uid;
	}
	public String getR8_MP() {
		return r8_MP;
	}
	public void setR8_MP(String r8_MP) {
		this.r8_MP = r8_MP;
	}
	public String getR9_BType() {
		return r9_BType;
	}
	public void setR9_BType(String r9_BType) {
		this.r9_BType = r9_BType;
	}
	
}
