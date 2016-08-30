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

package com.google.cloud.pubsub.it;

import com.google.cloud.pubsub.BaseSystemTest;
import com.google.cloud.pubsub.PubSub;
import com.google.cloud.pubsub.PubSubOptions;

import org.junit.Rule;
import org.junit.rules.Timeout;

import java.util.UUID;

public class ITPubSubTest extends BaseSystemTest {

  private static final PubSub PUB_SUB = PubSubOptions.defaultInstance().service();
  private static final String NAME_SUFFIX = UUID.randomUUID().toString();

  @Rule
  public Timeout globalTimeout = Timeout.seconds(300);

  @Override
  protected PubSub pubsub() {
    return PUB_SUB;
  }

  @Override
  protected String formatForTest(String resourceName) {
    return resourceName + "-" + NAME_SUFFIX;
  }
}
