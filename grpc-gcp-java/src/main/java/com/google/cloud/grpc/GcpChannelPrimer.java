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

/**
 * Primes delegate channels built by dynamic scale-up before they are published to the pool. The
 * initial pool and non-dynamic growth are not primed.
 */
@FunctionalInterface
public interface GcpChannelPrimer {

  /**
   * Issues a cheap end-to-end RPC on {@code channel} so its connection is warm before real traffic.
   * Scale-up batches invoke this method concurrently across channels and publish each channel as
   * soon as its own future succeeds. For example, a Cloud Spanner implementation can execute {@code
   * SELECT 1}. Return a failed future to reject the attempt; the pool retries up to the configured
   * attempt count and closes the channel when they are exhausted.
   *
   * <p>Return promptly and do the work inside the future. The configured prime timeout bounds each
   * attempt as a whole: a future still pending at the timeout is cancelled and the attempt retried,
   * while a call that is still blocked inside this method at the timeout fails the channel with no
   * retry, because nothing can stop it. A retry may overlap work from a cancelled future if that
   * work does not promptly honor cancellation, so implementations must tolerate concurrent calls
   * for one channel.
   */
  ListenableFuture<Void> prime(ManagedChannel channel);
}
