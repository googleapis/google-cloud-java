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

import com.google.api.core.InternalApi;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import javax.annotation.Nullable;

/** Utility class for creating a thread factory for daemon or virtual threads. */
@InternalApi
public class ThreadFactoryUtil {

  /**
   * Tries to create a thread factory for virtual threads, and otherwise falls back to creating a
   * platform thread factory that creates daemon threads. Virtual threads are supported from JDK21.
   *
   * @param baseNameFormat the base name format for the threads, '-%d' will be appended to the
   *     actual thread name format
   * @param tryVirtualThreads whether to try to use virtual threads if available or not
   * @return a {@link ThreadFactory} that produces virtual threads (Java 21 or higher) or platform
   *     daemon threads
   */
  @InternalApi
  public static ThreadFactory createVirtualOrPlatformDaemonThreadFactory(
      String baseNameFormat, boolean tryVirtualThreads) {
    ThreadFactory virtualThreadFactory =
        tryVirtualThreads ? tryCreateVirtualThreadFactory(baseNameFormat) : null;
    if (virtualThreadFactory != null) {
      return virtualThreadFactory;
    }

    return new ThreadFactoryBuilder().setDaemon(true).setNameFormat(baseNameFormat + "-%d").build();
  }

  /**
   * Tries to create a {@link ThreadFactory} that creates virtual threads. Returns null if virtual
   * threads are not supported on this JVM.
   */
  @InternalApi
  @Nullable
  public static ThreadFactory tryCreateVirtualThreadFactory(String baseNameFormat) {
    try {
      Class<?> threadBuilderClass = Class.forName("java.lang.Thread$Builder");
      Method ofVirtualMethod = Thread.class.getDeclaredMethod("ofVirtual");
      Object virtualBuilder = ofVirtualMethod.invoke(null);
      Method nameMethod = threadBuilderClass.getDeclaredMethod("name", String.class, long.class);
      virtualBuilder = nameMethod.invoke(virtualBuilder, baseNameFormat + "-", 0);
      Method factoryMethod = threadBuilderClass.getDeclaredMethod("factory");
      return (ThreadFactory) factoryMethod.invoke(virtualBuilder);
    } catch (ClassNotFoundException | NoSuchMethodException ignore) {
      return null;
    } catch (InvocationTargetException | IllegalAccessException e) {
      // Java 20 supports virtual threads as an experimental feature. It will throw an
      // UnsupportedOperationException if experimental features have not been enabled.
      if (e.getCause() instanceof UnsupportedOperationException) {
        return null;
      }
      throw new RuntimeException(e);
    }
  }

  /**
   * Tries to create an {@link ExecutorService} that creates a new virtual thread for each task that
   * it runs. Creating a new virtual thread is the recommended way to create executors using virtual
   * threads, instead of creating a pool of virtual threads. Returns null if virtual threads are not
   * supported on this JVM.
   */
  @InternalApi
  @Nullable
  public static ExecutorService tryCreateVirtualThreadPerTaskExecutor(String baseNameFormat) {
    ThreadFactory factory = tryCreateVirtualThreadFactory(baseNameFormat);
    if (factory != null) {
      try {
        Method newThreadPerTaskExecutorMethod =
            Executors.class.getDeclaredMethod("newThreadPerTaskExecutor", ThreadFactory.class);
        return (ExecutorService) newThreadPerTaskExecutorMethod.invoke(null, factory);
      } catch (NoSuchMethodException ignore) {
        return null;
      } catch (InvocationTargetException | IllegalAccessException e) {
        // Java 20 supports virtual threads as an experimental feature. It will throw an
        // UnsupportedOperationException if experimental features have not been enabled.
        if (e.getCause() instanceof UnsupportedOperationException) {
          return null;
        }
        throw new RuntimeException(e);
      }
    }
    return null;
  }
}
