package com.benefitj.spring.websocket;

import javax.websocket.*;
import java.nio.ByteBuffer;

/**
 * WebSocket Server 端的接口(标识)
 */
public abstract class JavaxWebSocketServer {

  /**
   * WebSocket Open
   *
   * @param session Session
   */
  public abstract void onOpen(Session session);

  /**
   * WebSocket Open
   *
   * @param session Session
   */
  @OnOpen
  public final void onOpen0(Session session) {
    this.onOpen(session);
  }

  /**
   * 接收到消息
   *
   * @param session Session
   * @param text    文本数据
   * @param isLast  是否为最后的数据
   */
  public abstract void onTextMessage(Session session, String text, boolean isLast);

  /**
   * 接收到消息
   *
   * @param session Session
   * @param text    文本数据
   * @param isLast  是否为最后的数据
   */
  @OnMessage
  public final void onTextMessage0(Session session, String text, boolean isLast) {
    this.onTextMessage(session, text, isLast);
  }

  /**
   * 接收到二进制数据
   *
   * @param session Session
   * @param buffer  数据
   * @param isLast  是否为最后的数据
   */
  public abstract void onBinaryMessage(Session session, ByteBuffer buffer, boolean isLast);

  /**
   * 接收到二进制数据
   *
   * @param session Session
   * @param buffer  数据
   * @param isLast  是否为最后的数据
   */
  @OnMessage
  public final void onBinaryMessage0(Session session, ByteBuffer buffer, boolean isLast) {
    this.onBinaryMessage(session, buffer, isLast);
  }

  /**
   * 连接关闭调用的方法
   *
   * @param session Session
   */
  public abstract void onClose(Session session, CloseReason reason);

  /**
   * 连接关闭调用的方法
   *
   * @param session Session
   */
  @OnClose
  public final void onClose0(Session session, CloseReason reason) {
    this.onClose(session, reason);
  }

  /**
   * 发生错误时调用
   *
   * @param session Session
   * @param e       异常
   */
  public abstract void onError(Session session, Throwable e);

  /**
   * 发生错误时调用
   *
   * @param session Session
   * @param e       异常
   */
  @OnError
  public final void onError0(Session session, Throwable e) {
    this.onError(session, e);
  }

}
