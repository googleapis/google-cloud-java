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

package com.google.cloud.pubsub;

import com.google.cloud.BaseSerializationTest;
import com.google.cloud.GrpcServiceOptions.ExecutorFactory;
import com.google.cloud.NoCredentials;
import com.google.cloud.Restorable;
import com.google.cloud.pubsub.PubSub.ListOption;
import com.google.cloud.pubsub.PubSub.PullOption;
import java.io.Serializable;
import java.util.concurrent.ScheduledExecutorService;

public class SerializationTest extends BaseSerializationTest {

  private static final PubSub PUB_SUB = PubSubOptions.newBuilder()
      .setProjectId("p")
      .setCredentials(NoCredentials.getInstance())
      .setHost("localhost")
      .build().getService();
  private static final SubscriptionInfo SUBSCRIPTION_INFO = SubscriptionInfo.of("topic", "sub");
  private static final Subscription SUBSCRIPTION =
      new Subscription(PUB_SUB, new SubscriptionInfo.BuilderImpl(SUBSCRIPTION_INFO));
  private static final SubscriptionId SUBSCRIPTION_ID = new SubscriptionId("project", "sub");
  private static final TopicInfo TOPIC_INFO = TopicInfo.of("topic");
  private static final Topic TOPIC =
      new Topic(PUB_SUB, new TopicInfo.BuilderImpl(TOPIC_INFO));
  private static final ListOption PAGE_TOKEN_OPTION = ListOption.pageToken("cursor");
  private static final ListOption PAGE_SIZE_OPTION = ListOption.pageSize(42);
  private static final PullOption MAX_QUEUED_CALLBACKS_OPTION = PullOption.maxQueuedCallbacks(42);
  private static final PullOption EXECUTOR_FACTORY_OPTION =
      PullOption.executorFactory(new TestExecutorFactory());

  public static class TestExecutorFactory
      implements ExecutorFactory<ScheduledExecutorService>, Serializable {

    private static final long serialVersionUID = -2154875338174302704L;

    @Override
    public ScheduledExecutorService get() {
      return null;
    }

    @Override
    public void release(ScheduledExecutorService executor) {
      // do nothing
    }

    @Override
    public boolean equals(Object obj) {
      return obj instanceof TestExecutorFactory;
    }

    @Override
    public int hashCode() {
      return 1;
    }
  }

  @Override
  protected Serializable[] serializableObjects() {
    PubSubOptions options = PubSubOptions.newBuilder()
        .setProjectId("p1")
        .setInitialTimeout(1234)
        .build();
    PubSubOptions otherOptions = options.toBuilder()
        .setProjectId("p2")
        .setExecutorFactory(new TestExecutorFactory())
        .build();
    return new Serializable[] {
      options,
      otherOptions,
      SUBSCRIPTION_INFO,
      SUBSCRIPTION,
      SUBSCRIPTION_ID,
      TOPIC_INFO,
      TOPIC,
      PAGE_TOKEN_OPTION,
      PAGE_SIZE_OPTION,
      MAX_QUEUED_CALLBACKS_OPTION,
      EXECUTOR_FACTORY_OPTION
    };
  }

  @Override
  protected Restorable<?>[] restorableObjects() {
    return null;
  }
}
