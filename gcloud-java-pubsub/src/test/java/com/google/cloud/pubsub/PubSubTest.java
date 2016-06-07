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
import com.google.cloud.pubsub.PubSub.PullOption;

import org.easymock.EasyMock;
import org.junit.Test;

import java.util.concurrent.ExecutorService;

public class PubSubTest {

  private static final int PAGE_SIZE = 42;
  private static final String PAGE_TOKEN = "page token";
  private static final int MAX_QUEUED_CALLBACKS = 42;

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
  @SuppressWarnings("unchecked")
  public void testPullOptions() {
    // max queued callbacks
    PullOption pullOption = PullOption.maxQueuedCallbacks(MAX_QUEUED_CALLBACKS);
    assertEquals(MAX_QUEUED_CALLBACKS, pullOption.value());
    assertEquals(PullOption.OptionType.MAX_QUEUED_CALLBACKS, pullOption.optionType());
    // auto-closing executor
    ExecutorService executor = EasyMock.createNiceMock(ExecutorService.class);
    pullOption = PullOption.executor(executor, true);
    ExecutorFactory<ExecutorService> factory = (ExecutorFactory) pullOption.value();
    assertSame(executor, factory.get());
    executor.shutdown();
    EasyMock.expectLastCall();
    EasyMock.replay(executor);
    factory.release(executor);
    EasyMock.verify(executor);
    assertEquals(PullOption.OptionType.EXECUTOR, pullOption.optionType());
    // auto-closing executor
    EasyMock.reset(executor);
    pullOption = PullOption.executor(executor, false);
    factory = (ExecutorFactory) pullOption.value();
    assertSame(executor, factory.get());
    EasyMock.replay(executor);
    factory.release(executor);
    EasyMock.verify(executor);
  }
}
