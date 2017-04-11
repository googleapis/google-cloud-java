/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.pubsub.spi.v1;

import com.google.pubsub.v1.PubsubMessage;

/** This interface can be implemented by users of {@link Subscriber} to receive messages. */
public interface MessageReceiver {
  /**
   * Called when a message is received by the subscriber. The implementation must arrange for {@link
   * AckReplyConsumer#ack()} or {@link
   * AckReplyConsumer#nack()} to be called after processing the {@code message}.
   *
   * <p>This {@code MessageReceiver} passes all messages to a {@code BlockingQueue}.
   * This method can be called concurrently from multiple threads,
   * so it is important that the queue be thread-safe.
   *
   * This example is for illustration. Implementations may directly process messages
   * instead of sending them to queues.
   * <pre> {@code
   * MessageReceiver receiver = new MessageReceiver() {
   *   public void receiveMessage(final PubsubMessage message, final AckReplyConsumer consumer) {
   *     if (blockingQueue.offer(message)) {
   *       consumer.ack();
   *     } else {
   *       consumer.nack();
   *     }
   *   }
   * };
   * }</pre>
   *
   */
  void receiveMessage(final PubsubMessage message, final AckReplyConsumer consumer);
}
