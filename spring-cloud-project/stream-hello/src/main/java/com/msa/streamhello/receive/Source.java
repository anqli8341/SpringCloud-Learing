package com.msa.streamhello.receive;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author anquan li
 */
public interface Source {

  String OUTPUT="output";

  @Output(Source.OUTPUT)
  MessageChannel output();
}
