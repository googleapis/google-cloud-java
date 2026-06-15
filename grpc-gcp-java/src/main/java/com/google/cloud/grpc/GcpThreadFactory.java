/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.grpc;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.util.concurrent.ThreadFactory;

/** Thread factory helper for grpc-gcp background executors. */
public final class GcpThreadFactory {
  /** System property to control daemon threads for grpc-gcp background executors. */
  public static final String USE_DAEMON_THREADS_PROPERTY =
      "com.google.cloud.grpc.use_daemon_threads";

  private GcpThreadFactory() {}

  /**
   * Creates a {@link ThreadFactory} that names threads and honors the daemon-thread setting.
   *
   * <p>Defaults to daemon threads to avoid keeping the JVM alive when only background work remains.
   * Set {@code -Dcom.google.cloud.grpc.use_daemon_threads=false} to use non-daemon threads.
   */
  public static ThreadFactory newThreadFactory(String nameFormat) {
    boolean useDaemon = true;
    String prop = System.getProperty(USE_DAEMON_THREADS_PROPERTY);
    if (prop != null) {
      useDaemon = Boolean.parseBoolean(prop);
    }
    return new ThreadFactoryBuilder().setNameFormat(nameFormat).setDaemon(useDaemon).build();
  }
}
