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
   * Issues a cheap, read-only end-to-end RPC on {@code channel} so its transport, TLS session, and
   * server-side connection are established before the channel serves live traffic. Scale-up batches
   * invoke this method concurrently across channels and publish each channel as soon as its own
   * future succeeds. For example, a Cloud Spanner implementation can execute {@code SELECT 1}.
   * Return a failed future to reject the attempt; the pool retries up to the configured attempt
   * count and closes the channel when they are exhausted.
   *
   * <p>Implementations must observe the following:
   *
   * <ul>
   *   <li><b>Return promptly and do the work inside the future.</b> Do not block in this method (no
   *       blocking stub, {@code ResultSet.next()}, {@code Future.get()}, or waiting on other
   *       threads). The configured prime timeout bounds each attempt as a whole: a future still
   *       pending at the timeout is cancelled and the attempt retried, while a call that is still
   *       blocked inside this method at the timeout fails the channel with no retry, because
   *       nothing can stop it. Such a call keeps occupying its primer thread and a scale-up slot
   *       until it returns.
   *   <li><b>Set an explicit, short deadline on the RPC</b>, for example {@code
   *       stub.withDeadlineAfter(5, SECONDS)}. Do not rely on the default deadline: many Google
   *       Cloud APIs default to very long ones, such as one hour for Cloud Spanner's {@code
   *       ExecuteStreamingSql}, so an unresponsive backend would leave the call lingering on the
   *       server long after the pool has given up on it.
   *   <li><b>Propagate cancellation to the gRPC call.</b> The pool calls {@code
   *       future.cancel(true)} on the returned future when the attempt times out or the pool shuts
   *       down. Cancelling the future must cancel the underlying {@link io.grpc.ClientCall} or
   *       {@link io.grpc.Context.CancellableContext} so the stream and its server-side resources
   *       are released promptly.
   *   <li><b>Expect the channel to be shut down under a running call.</b> The pool may call {@code
   *       shutdownNow()} on {@code channel} while this method is still running: when the call is
   *       still blocked at the timeout, or when the pool shuts down. A channel-shutdown status from
   *       an RPC on {@code channel} is then expected and is not a backend outage.
   *   <li><b>Tolerate concurrent calls for one channel.</b> A retry may overlap work from a
   *       cancelled future if that work does not promptly honor cancellation, so the implementation
   *       must be safe for multiple invocations on the same channel at once.
   *   <li><b>Keep the RPC trivial and side-effect free.</b> It should be strictly read-only and
   *       need minimal server work, such as {@code SELECT 1} or a lightweight ping.
   * </ul>
   *
   * @param channel the newly built, not yet published delegate channel to prime
   * @return a future that succeeds when the priming RPC succeeds, or fails to reject the attempt
   */
  ListenableFuture<Void> prime(ManagedChannel channel);
}
