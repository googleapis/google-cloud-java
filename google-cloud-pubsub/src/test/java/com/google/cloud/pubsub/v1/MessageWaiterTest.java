/*
 * Copyright 2016 Google LLC
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

package com.google.cloud.pubsub.v1;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Tests for {@link MessageWaiter}.
 */
@RunWith(JUnit4.class)
public class MessageWaiterTest {

  @Test
  public void test() throws Exception {
    final MessageWaiter waiter = new MessageWaiter();
    waiter.incrementPendingMessages(1);

    final AtomicBoolean waitReached = new AtomicBoolean();

    Thread t = new Thread(new Runnable(){
      @Override
      public void run() {
        while (!waitReached.get()) {
          Thread.yield();
        }
        waiter.incrementPendingMessages(-1);
      }
    });
    t.start();

    waiter.waitNoMessages(waitReached);
    t.join();

    assertEquals(0, waiter.pendingMessages());
  }
}
