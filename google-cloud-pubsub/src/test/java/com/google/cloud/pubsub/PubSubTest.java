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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import com.google.cloud.GrpcServiceOptions.ExecutorFactory;
import com.google.cloud.pubsub.PubSub.ListOption;
import com.google.cloud.pubsub.PubSub.MessageConsumerOption;
import com.google.cloud.pubsub.PubSub.PullOption;

import org.easymock.EasyMock;
import org.junit.Test;

public class PubSubTest {

  private static final int PAGE_SIZE = 42;
  private static final String PAGE_TOKEN = "page token";
  private static final int MAX_QUEUED_CALLBACKS = 42;
  private static final boolean RETURN_IMMEDIATELY = false;

  @Test
  public void testListOption() {
    // page token
    ListOption listOption = ListOption.pageToken(PAGE_TOKEN);
    assertEquals(PAGE_TOKEN, listOption.value());
    assertEquals(ListOption.OptionType.PAGE_TOKEN, listOption.optionType());
    // page size
    listOption = ListOption.pageSize(PAGE_SIZE);
    assertEquals(PAGE_SIZE, listOption.value());
    assertEquals(ListOption.OptionType.PAGE_SIZE, listOption.optionType());
  }

  @Test
  public void testMessageConsumerOptions() {
    // max queued callbacks
    MessageConsumerOption pullOption =
        MessageConsumerOption.maxQueuedCallbacks(MAX_QUEUED_CALLBACKS);
    assertEquals(MAX_QUEUED_CALLBACKS, pullOption.value());
    assertEquals(MessageConsumerOption.OptionType.MAX_QUEUED_CALLBACKS, pullOption.optionType());
    ExecutorFactory executorFactory = EasyMock.createStrictMock(ExecutorFactory.class);
    // executor factory
    pullOption = MessageConsumerOption.executorFactory(executorFactory);
    assertSame(executorFactory, pullOption.value());
    assertEquals(MessageConsumerOption.OptionType.EXECUTOR_FACTORY, pullOption.optionType());
  }

  @Test
  public void testPullOptions() {
    PullOption pullOption = PullOption.returnImmediately(RETURN_IMMEDIATELY);
    assertEquals(RETURN_IMMEDIATELY, pullOption.value());
    assertEquals(PullOption.OptionType.RETURN_IMMEDIATELY, pullOption.optionType());
  }
}
