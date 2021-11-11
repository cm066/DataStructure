package com.cm.netty.protocol;

/**
 * @author cm
 * @create 2021/11/11-11:06 下午
 */

/**
 *协议包
 */
public class MessageProtocol {
    private int len;
    private byte[] content;

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
