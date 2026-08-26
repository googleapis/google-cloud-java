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

import com.google.common.util.concurrent.ListenableFuture;
import io.grpc.ManagedChannel;

/** Primes a newly built delegate channel before a dynamic pool publishes it for request picking. */
@FunctionalInterface
public interface GcpChannelPrimer {

  /**
   * Issues a cheap end-to-end RPC on {@code channel} so its connection is warm before real traffic.
   * For example, a Cloud Spanner implementation can execute {@code SELECT 1}. Return a failed
   * future to reject and close the channel.
   */
  ListenableFuture<Void> prime(ManagedChannel channel);
}
