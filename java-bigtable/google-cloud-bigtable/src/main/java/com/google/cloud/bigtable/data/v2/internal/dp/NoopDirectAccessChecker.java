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
package com.google.cloud.bigtable.data.v2.internal.dp;

import com.google.api.core.InternalApi;
import io.grpc.Channel;
import io.grpc.ManagedChannel;
import javax.annotation.Nullable;

@InternalApi
public class NoopDirectAccessChecker implements DirectAccessChecker {
  public static final NoopDirectAccessChecker INSTANCE = new NoopDirectAccessChecker();

  private NoopDirectAccessChecker() {}

  @Override
  public boolean check(Channel channel) {
    // We must shut down the temporary probe channel to prevent gRPC resource leaks!
    if (channel instanceof ManagedChannel) {
      ((ManagedChannel) channel).shutdownNow();
    }
    // If it's disabled, it is never eligible.
    return false;
  }

  @Override
  public void investigateFailure(@Nullable Throwable originalError) {
    // Do nothing. We don't investigate failures if the feature is disabled.
  }
}
