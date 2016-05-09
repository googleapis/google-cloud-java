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

import com.google.cloud.pubsub.PubSub.ListOption;
import com.google.cloud.pubsub.PubSub.MessageConsumer;
import com.google.cloud.pubsub.PubSub.PullOption;

import org.junit.Test;

public class PubSubTest {

  private static final int PAGE_SIZE = 42;
  private static final String PAGE_TOKEN = "page token";
  private static final int MAX_MESSAGES = 42;
  private static final int MAX_CONCURRENT_CALLBACKS = 42;

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
  public void testPullOptions() {
    PullOption pullOption = PullOption.maxMessages(MAX_MESSAGES);
    assertEquals(MAX_MESSAGES, pullOption.value());
    assertEquals(PullOption.OptionType.MAX_MESSAGES, pullOption.optionType());
  }

  @Test
  public void testMessageConsumerPullOptions() {
    MessageConsumer.PullOption pullOption =
        MessageConsumer.PullOption.maxConcurrentCallbacks(MAX_CONCURRENT_CALLBACKS);
    assertEquals(MAX_CONCURRENT_CALLBACKS, pullOption.value());
    assertEquals(MessageConsumer.PullOption.OptionType.MAX_CONCURRENT_CALLBACKS,
        pullOption.optionType());
  }
}
