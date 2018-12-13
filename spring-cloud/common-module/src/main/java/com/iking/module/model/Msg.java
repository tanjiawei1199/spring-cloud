package com.iking.module.model;

import java.io.Serializable;

/**
 * 响应类
 * 
 * @author hufx
 * @version 1.0
 * @date 2018年1月10日下午5:39:40
 */
public class Msg<E> implements Serializable{

	private static final long serialVersionUID = -6888051142661096743L;

	private boolean success; // 是否成功

	private String msg; // 提示信息

	private Object obj; // 返回对象

	private String number;// 返回代码

	public Msg() {
		this.success = true;
		this.msg = "成功!";
	}

	public static Msg sucess() {
		return new Msg();
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public final String getNumber() {
		return number;
	}

	public final void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Msg [success=" + success + ", msg=" + msg + ", obj=" + obj + ", number=" + number + "]";
	}
	public static Msg fail(String message){
		Msg msg = new Msg();
		msg.setSuccess(false);
		msg.setMsg(message);
		return msg;
	}
	public static <E> Msg<E> sucess(E e) {
		return sucess("成功",e);
	}

	public static <E> Msg<E> sucess(String m,E e) {
		Msg<E> msg = new Msg<E>();
		msg.setObj(e);
		msg.setMsg(m);
		msg.setSuccess(true);
		return msg;
	}
}
