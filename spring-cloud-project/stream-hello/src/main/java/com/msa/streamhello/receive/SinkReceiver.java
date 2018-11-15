package com.msa.streamhello.receive;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import com.msa.streamhello.send.SinkSender;

/**
 * @author anquan li
 */
@EnableBinding(value = {Sink.class, SinkSender.class})
public class SinkReceiver {

  private static Logger logger= LoggerFactory.getLogger(SinkReceiver.class);

  @StreamListener(Sink.INPUT)
  public void receive(Object payload){
    logger.info("Received: "+payload);
  }
}
