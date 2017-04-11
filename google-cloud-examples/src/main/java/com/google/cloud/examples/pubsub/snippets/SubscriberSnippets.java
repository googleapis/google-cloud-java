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
 * Subscriber's javadoc.
 */

package com.google.cloud.examples.pubsub.snippets;

import com.google.api.gax.core.ApiFuture;
import com.google.cloud.pubsub.spi.v1.MessageReceiver;
import com.google.cloud.pubsub.spi.v1.Subscriber;
import com.google.pubsub.v1.SubscriptionName;
import java.util.concurrent.Executor;

/** This class contains snippets for the {@link Subscriber} interface. */
public class SubscriberSnippets {

  private final SubscriptionName subscription;
  private final MessageReceiver receiver;
  private final ApiFuture<Void> done;
  private final Executor executor;

  public SubscriberSnippets(
      SubscriptionName subscription,
      MessageReceiver receiver,
      ApiFuture<Void> done,
      Executor executor) {
    this.subscription = subscription;
    this.receiver = receiver;
    this.done = done;
    this.executor = executor;
  }

  /**
   * Example of receiving a specific number of messages.
   */
  // [TARGET startAsync()]
  public void startAndWait() throws Exception {
    // [START startAsync]
    Subscriber subscriber = Subscriber.defaultBuilder(subscription, receiver).build();
    subscriber.addListener(new Subscriber.Listener() {
      public void failed(Subscriber.State from, Throwable failure) {
        // Handle error.
      }
    }, executor);
    subscriber.startAsync();

    // Wait for a stop signal.
    done.get();
    subscriber.stopAsync().awaitTerminated();
    // [END startAsync]
  }
}
