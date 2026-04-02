/*
 * Copyright 2024 Google LLC
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
package com.google.cloud.spanner;

import static com.google.cloud.spanner.ThreadFactoryUtil.createVirtualOrPlatformDaemonThreadFactory;
import static com.google.cloud.spanner.ThreadFactoryUtil.tryCreateVirtualThreadFactory;
import static com.google.cloud.spanner.ThreadFactoryUtil.tryCreateVirtualThreadPerTaskExecutor;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.common.util.concurrent.SettableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ThreadFactoryUtilTest {

  @Test
  public void testCreateThreadFactory() throws Exception {
    ThreadFactory threadFactory = createVirtualOrPlatformDaemonThreadFactory("test-thread", true);
    assertNotNull(threadFactory);
    SettableFuture<Boolean> future = SettableFuture.create();
    Thread thread = threadFactory.newThread(() -> future.set(true));
    assertNotNull(thread);
    // Virtual threads are by definition always daemon threads.
    assertTrue(thread.isDaemon());
    thread.start();
    assertTrue(future.get(1L, TimeUnit.SECONDS));

    if (isJava21OrHigher()) {
      ThreadFactory virtualFactory = tryCreateVirtualThreadFactory("test-thread");
      assertNotNull(virtualFactory);
      assertEquals(virtualFactory.getClass(), threadFactory.getClass());
    } else {
      assertNull(tryCreateVirtualThreadFactory("test-thread"));
    }
  }

  @Test
  public void testTryCreateVirtualThreadPerTaskExecutor() {
    if (isJava21OrHigher()) {
      assertNotNull(tryCreateVirtualThreadPerTaskExecutor("test-virtual-thread"));
    } else {
      assertNull(tryCreateVirtualThreadPerTaskExecutor("test-virtual-thread"));
    }
  }

  private static boolean isJava21OrHigher() {
    String[] versionElements = System.getProperty("java.version").split("\\.");
    int majorVersion = Integer.parseInt(versionElements[0]);
    // Java 1.8 (Java 8) and lower used the format 1.8 etc.
    // Java 9 and higher use the format 9.x
    if (majorVersion == 1) {
      majorVersion = Integer.parseInt(versionElements[1]);
    }
    return majorVersion >= 21;
  }
}
