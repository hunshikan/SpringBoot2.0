package com.demo.gyb.memory;

import io.netty.channel.ChannelHandlerContext;

public class SocketChannelInit {
    private ChannelHandlerContext channel;
    private Long connectionTime;
	public ChannelHandlerContext getChannel() {
		return channel;
	}
	public void setChannel(ChannelHandlerContext channel) {
		this.channel = channel;
	}
	public Long getConnectionTime() {
		return connectionTime;
	}
	public void setConnectionTime(Long connectionTime) {
		this.connectionTime = connectionTime;
	}   
}
