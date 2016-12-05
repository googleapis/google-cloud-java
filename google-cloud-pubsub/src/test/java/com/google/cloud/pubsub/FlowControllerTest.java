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

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.cloud.pubsub.Publisher.CloudPubsubFlowControlException;
import com.google.cloud.pubsub.Publisher.MaxOutstandingBytesReachedException;
import com.google.cloud.pubsub.Publisher.MaxOutstandingMessagesReachedException;
import com.google.common.base.Optional;
import com.google.common.util.concurrent.SettableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Tests for {@link FlowController}. */
@RunWith(JUnit4.class)
public class FlowControllerTest {

  @Test
  public void testReserveRelease_ok() throws Exception {
    FlowController flowController = new FlowController(Optional.of(10), Optional.of(10), false);

    flowController.reserve(1, 1);
    flowController.release(1, 1);
  }

  @Test
  public void testInvalidArguments() throws Exception {
    FlowController flowController = new FlowController(Optional.of(10), Optional.of(10), false);

    flowController.reserve(1, 0);
    try {
      flowController.reserve(-1, 1);
      fail("Must have thrown an illegal argument error");
    } catch (IllegalArgumentException expected) { }
    try {
      flowController.reserve(1, -1);
      fail("Must have thrown an illegal argument error");
    } catch (IllegalArgumentException expected) { }
    try {
      flowController.reserve(0, 1);
      fail("Must have thrown an illegal argument error");
    } catch (IllegalArgumentException expected) { }
  }

  @Test
  public void testReserveRelease_noLimits_ok() throws Exception {
    FlowController flowController = new FlowController(Optional.absent(), Optional.absent(), false);

    flowController.reserve(1, 1);
    flowController.release(1, 1);
  }

  @Test
  public void testReserveRelease_blockedByNumberOfMessages() throws Exception {
    FlowController flowController = new FlowController(Optional.of(10), Optional.of(100), false);

    testBlockingReserveRelease(flowController, 10, 10);
  }

  @Test
  public void testReserveRelease_blockedByNumberOfMessages_noBytesLimit() throws Exception {
    FlowController flowController = new FlowController(Optional.of(10), Optional.absent(), false);

    testBlockingReserveRelease(flowController, 10, 10);
  }

  @Test
  public void testReserveRelease_blockedByNumberOfBytes() throws Exception {
    FlowController flowController = new FlowController(Optional.of(100), Optional.of(10), false);

    testBlockingReserveRelease(flowController, 10, 10);
  }

  @Test
  public void testReserveRelease_blockedByNumberOfBytes_noMessagesLimit() throws Exception {
    FlowController flowController = new FlowController(Optional.absent(), Optional.of(10), false);

    testBlockingReserveRelease(flowController, 10, 10);
  }

  private void testBlockingReserveRelease(
      FlowController flowController, int maxNumMessages, int maxNumBytes) throws Exception {

    flowController.reserve(1, 1);

    SettableFuture<?> permitsReserved = SettableFuture.create();
    Future<?> finished =
        Executors.newCachedThreadPool()
            .submit(
                new Runnable() {
                  @Override
                  public void run() {
                    try {
                      permitsReserved.set(null);
                      flowController.reserve(maxNumMessages, maxNumBytes);
                    } catch (CloudPubsubFlowControlException e) {
                      throw new RuntimeException(e);
                    }
                  }
                });

    permitsReserved.get();
    flowController.release(1, 1);

    finished.get();
  }

  @Test
  public void testReserveRelease_rejectedByNumberOfMessages() throws Exception {
    FlowController flowController = new FlowController(Optional.of(10), Optional.of(100), true);

    testRejectedReserveRelease(
        flowController, 10, 10, MaxOutstandingMessagesReachedException.class);
  }

  @Test
  public void testReserveRelease_rejectedByNumberOfMessages_noBytesLimit() throws Exception {
    FlowController flowController = new FlowController(Optional.of(10), Optional.absent(), true);

    testRejectedReserveRelease(
        flowController, 10, 10, MaxOutstandingMessagesReachedException.class);
  }

  @Test
  public void testReserveRelease_rejectedByNumberOfBytes() throws Exception {
    FlowController flowController = new FlowController(Optional.of(100), Optional.of(10), true);

    testRejectedReserveRelease(flowController, 10, 10, MaxOutstandingBytesReachedException.class);
  }

  @Test
  public void testReserveRelease_rejectedByNumberOfBytes_noMessagesLimit() throws Exception {
    FlowController flowController = new FlowController(Optional.absent(), Optional.of(10), true);

    testRejectedReserveRelease(flowController, 10, 10, MaxOutstandingBytesReachedException.class);
  }

  private void testRejectedReserveRelease(
      FlowController flowController,
      int maxNumMessages,
      int maxNumBytes,
      Class<? extends CloudPubsubFlowControlException> expectedException)
      throws CloudPubsubFlowControlException {

    flowController.reserve(1, 1);

    try {
      flowController.reserve(maxNumMessages, maxNumBytes);
      fail("Should thrown a CloudPubsubFlowControlException");
    } catch (CloudPubsubFlowControlException e) {
      assertTrue(expectedException.isInstance(e));
    }

    flowController.release(1, 1);

    flowController.reserve(maxNumMessages, maxNumBytes);
  }
}
