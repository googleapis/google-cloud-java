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

import com.google.cloud.pubsub.testing.LocalPubsubHelper;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import java.io.IOException;

public class LocalSystemTest extends BaseSystemTest {

  private static LocalPubsubHelper pubsubHelper;
  private static PubSub pubsub;

  @Override
  protected PubSub pubsub() {
    return pubsub;
  }

  @Override
  protected String formatForTest(String resourceName) {
    return resourceName;
  }

  @BeforeClass
  public static void startServer() throws IOException, InterruptedException {
    pubsubHelper = LocalPubsubHelper.create();
    pubsubHelper.start();
    pubsub = pubsubHelper.options().service();
  }

  @AfterClass
  public static void stopServer() throws Exception {
    pubsub.close();
    pubsubHelper.reset();
    pubsubHelper.stop();
  }
}
