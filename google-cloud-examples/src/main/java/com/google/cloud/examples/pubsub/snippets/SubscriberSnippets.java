/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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
 * This file is referenced in Subscriber's javadoc. Any change to this file should be reflected in
 * PubSub's javadoc.
 */

package com.google.cloud.examples.pubsub.snippets;

import com.google.cloud.pubsub.spi.v1.AckReply;
import com.google.cloud.pubsub.spi.v1.AckReplyConsumer;
import com.google.cloud.pubsub.spi.v1.MessageReceiver;
import com.google.cloud.pubsub.spi.v1.Subscriber;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.SubscriptionName;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SubscriberSnippets {
  /**
   * Example of receiving a specific number of messages.
   */
  // [TARGET startAsync()]
  // [VARIABLE "my_project_name"]
  // [VARIABLE "my_subscription_name"]
  // [VARIABLE 3]
  public void startAsync(String projectName, String subscriptionName, int receiveNum) throws Exception {
    // [START startAsync]
    SubscriptionName subscription = SubscriptionName.create(projectName, subscriptionName);
    final Lock lock = new ReentrantLock();
    final Condition doneCondition = lock.newCondition();
    final AtomicInteger pendingReceives = new AtomicInteger(receiveNum);
    final AtomicBoolean done = new AtomicBoolean();

    MessageReceiver receiver = new MessageReceiver() {
      public void receiveMessage(final PubsubMessage message, final AckReplyConsumer consumer) {
        System.out.println("got message: " + message);
        consumer.accept(AckReply.ACK, null);
        if (pendingReceives.decrementAndGet() != 0) {
          return;
        }
        lock.lock();
        try {
          done.set(true);
          doneCondition.signal();
        } finally {
          lock.unlock();
        }
      }
    };

    Subscriber subscriber = Subscriber.newBuilder(subscription, receiver).build();
    subscriber.addListener(new Subscriber.SubscriberListener() {
      public void failed(Subscriber.State from, Throwable failure) {
        System.err.println(failure);
        lock.lock();
        try {
          done.set(true);
          doneCondition.signal();
        } finally {
          lock.unlock();
        }
      }
    }, new Executor() {
      public void execute(Runnable command) {
        command.run();
      }
    });
    subscriber.startAsync();
    lock.lock();
    try {
      while (!done.get()) {
        doneCondition.await();
      }
    } finally {
      lock.unlock();
    }
    subscriber.stopAsync().awaitTerminated();
    // [END startAsync]
  }
}
