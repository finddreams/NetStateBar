package com.finddreams.netstate;


/**
 * @Description:用于网络的事件
 * @author http://blog.csdn.net/finddreams
 */ 
public class NetEvent {
	public boolean isNet;

	public NetEvent(boolean isNet) {

		this.isNet = isNet;
	}

	public boolean isNet() {
		return isNet;
	}
}
