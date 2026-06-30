/*
 * Copyright 2023 Google LLC
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

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public final class TestHelper {
  /** Make constructor private to prevent creating instances. */
  private TestHelper() {}

  /** Returns whether the tests are running against the Firestore emulator. */
  static boolean isRunningAgainstFirestoreEmulator(Firestore firestore) {
    return firestore.getOptions().getEmulatorHost() != null;
  }

  /**
   * Blocks the calling thread until the given future completes. Note that this method does not
   * check the success or failure of the future; it returns regardless of its success or failure.
   */
  public static void await(ApiFuture<?> future) throws InterruptedException {
    AtomicBoolean done = new AtomicBoolean(false);
    ExecutorService executor = Executors.newSingleThreadExecutor();
    future.addListener(
        () -> {
          synchronized (done) {
            done.set(true);
            done.notifyAll();
          }
        },
        executor);

    synchronized (done) {
      while (!done.get()) {
        done.wait();
      }
    }

    executor.shutdown();
  }
}
