package com.msa.streamhello.send;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author anquan li
 */
public interface Sink {

  String INPUT="input";

  @Input(Sink.INPUT)
  SubscribableChannel input();
}
