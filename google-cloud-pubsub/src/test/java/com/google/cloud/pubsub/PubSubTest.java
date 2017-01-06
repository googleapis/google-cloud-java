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

import org.easymock.EasyMock;
import org.junit.Test;

public class PubSubTest {

  private static final int PAGE_SIZE = 42;
  private static final String PAGE_TOKEN = "page token";
  private static final int MAX_QUEUED_CALLBACKS = 42;

  @Test
  public void testListOption() {
    // page token
    ListOption listOption = ListOption.pageToken(PAGE_TOKEN);
    assertEquals(PAGE_TOKEN, listOption.getValue());
    assertEquals(ListOption.OptionType.PAGE_TOKEN, listOption.getOptionType());
    // page size
    listOption = ListOption.pageSize(PAGE_SIZE);
    assertEquals(PAGE_SIZE, listOption.getValue());
    assertEquals(ListOption.OptionType.PAGE_SIZE, listOption.getOptionType());
  }
}
