/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.firestore.it;

import static org.junit.Assert.fail;
import static org.junit.Assume.assumeFalse;

import com.google.api.core.SettableApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.firestore.ListenerRegistration;
import com.google.cloud.firestore.LocalFirestoreHelper;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ITShutdownTest extends ITBaseTest {
  @Rule public final Timeout timeout = new Timeout(5, TimeUnit.SECONDS);
  @Rule public TestName testName = new TestName();

  @Test
  public void closeSuccess_withListenerRemove() throws Exception {
    Firestore fs = FirestoreOptions.getDefaultInstance().getService();
    ListenerRegistration listener = attachListener(fs);
    listener.remove();
    fs.close();
  }

  @Test
  public void closeFailure_withoutListenerRemove() throws Exception {
    // TODO(pipeline): This test fails against emulator, suggesting the test setup probably depends
    // on timing.
    // We should fix it.
    assumeFalse(
        "Skip this test when running against the emulator because it depends on timing.",
        TestHelper.isRunningAgainstFirestoreEmulator(firestore));

    final Firestore fs = FirestoreOptions.getDefaultInstance().getService();
    attachListener(fs);

    ExecutorService testExecutorService = Executors.newSingleThreadExecutor();
    final SettableApiFuture<Void> result = SettableApiFuture.create();
    testExecutorService.submit(
        () -> {
          try {
            fs.close();
            result.set(null);
          } catch (Throwable throwable) {
            result.setException(throwable);
          }
        });

    try {
      result.get(1, TimeUnit.SECONDS);
      fail();
    } catch (TimeoutException e) {
      // Expected
    } finally {
      testExecutorService.shutdown();
    }
  }

  @Test
  public void shutdownNowSuccess_withoutListenerRemove() throws Exception {
    Firestore fs = FirestoreOptions.getDefaultInstance().getService();
    attachListener(fs);
    fs.shutdownNow();
  }

  @Test
  public void shutdownSuccess_withoutListenerRemove() throws Exception {
    Firestore fs = FirestoreOptions.getDefaultInstance().getService();
    attachListener(fs);
    fs.shutdown();
  }

  @Test
  public void closeAndShutdown() throws Exception {
    Firestore fs = FirestoreOptions.getDefaultInstance().getService();
    attachListener(fs);
    fs.shutdown();
    fs.shutdownNow();
    fs.close();
  }

  private ListenerRegistration attachListener(Firestore fs) throws InterruptedException {
    final CountDownLatch cdl = new CountDownLatch(1);
    ListenerRegistration listenerRegistration =
        fs.collection(
                String.format(
                    "java-%s-%s", testName.getMethodName(), LocalFirestoreHelper.autoId()))
            .addSnapshotListener((value, error) -> cdl.countDown());
    cdl.await();
    return listenerRegistration;
  }
}
