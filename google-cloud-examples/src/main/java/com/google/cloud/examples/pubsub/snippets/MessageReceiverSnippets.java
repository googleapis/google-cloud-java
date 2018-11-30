/*
 * Copyright 2017 Google LLC
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

/*
 * EDITING INSTRUCTIONS
 * This file is referenced in MessageReceiver's javadoc.
 * Any change to this file should be reflected in MessageReceiver's javadoc.
 */

package com.google.cloud.examples.pubsub.snippets;

import com.google.cloud.pubsub.v1.AckReplyConsumer;
import com.google.cloud.pubsub.v1.MessageReceiver;
import com.google.pubsub.v1.PubsubMessage;
import java.util.concurrent.BlockingQueue;

/** This class contains snippets for the {@link MessageReceiver} interface. */
public class MessageReceiverSnippets {
  private final BlockingQueue<PubsubMessage> blockingQueue;

  public MessageReceiverSnippets(BlockingQueue<PubsubMessage> blockingQueue) {
    this.blockingQueue = blockingQueue;
  }

  public MessageReceiver messageReceiver() {
    // SNIPPET receiveMessage
    // This {@code MessageReceiver} passes all messages to a {@link BlockingQueue}. This method can
    // be called concurrently from multiple threads, so it is important that the queue be
    // thread-safe.
    //
    // This example is for illustration. Implementations may directly process messages instead of
    // sending them to queues.
    MessageReceiver receiver =
        new MessageReceiver() {
          public void receiveMessage(final PubsubMessage message, final AckReplyConsumer consumer) {
            if (blockingQueue.offer(message)) {
              consumer.ack();
            } else {
              consumer.nack();
            }
          }
        };
    // SNIPPET receiveMessage
    return receiver;
  }
}
