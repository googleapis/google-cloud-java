/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner;

import com.google.api.core.InternalApi;

/**
 * Simple helper class to get access to a package-private method in the {@link
 * com.google.cloud.spanner.SessionPoolOptions}.
 */
@InternalApi
public class SessionPoolOptionsHelper {

  // TODO: Remove when Builder.setUseMultiplexedSession(..) has been made public.
  public static SessionPoolOptions.Builder setUseMultiplexedSession(
      SessionPoolOptions.Builder sessionPoolOptionsBuilder, boolean useMultiplexedSession) {
    return sessionPoolOptionsBuilder.setUseMultiplexedSession(useMultiplexedSession);
  }

  // TODO: Remove when multiplexed session for read write is released.
  public static SessionPoolOptions.Builder setUseMultiplexedSessionForRW(
      SessionPoolOptions.Builder sessionPoolOptionsBuilder, boolean useMultiplexedSessionForRW) {
    return sessionPoolOptionsBuilder.setUseMultiplexedSessionForRW(useMultiplexedSessionForRW);
  }

  // TODO: Remove when multiplexed session for partitioned operations are released.
  public static SessionPoolOptions.Builder setUseMultiplexedSessionForPartitionedOperations(
      SessionPoolOptions.Builder sessionPoolOptionsBuilder,
      boolean useMultiplexedSessionForPartitionedOps) {
    return sessionPoolOptionsBuilder.setUseMultiplexedSessionPartitionedOps(
        useMultiplexedSessionForPartitionedOps);
  }
}
