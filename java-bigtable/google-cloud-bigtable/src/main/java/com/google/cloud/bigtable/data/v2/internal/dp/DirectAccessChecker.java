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

@InternalApi
/* Evaluates whether a given channel supports Direct Access. */
public interface DirectAccessChecker {
  /**
   * Evaluates if Direct Access is available by sending request via provided channel.
   *
   * @param channel A channel to probe direct access connectivity
   * @return true if the channel is eligible for Direct Access
   */
  boolean check(Channel channel);

  /**
   * Triggers a investigation into why Direct Access routing failed.
   *
   * @param originalError An optional exception that caused the failure.
   */
  void investigateFailure(Throwable originalError);
}
