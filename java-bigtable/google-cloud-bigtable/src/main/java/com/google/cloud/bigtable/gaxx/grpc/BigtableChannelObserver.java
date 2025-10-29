/*
 * Copyright 2025 Google LLC
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
package com.google.cloud.bigtable.gaxx.grpc;

import com.google.api.core.InternalApi;

/** Provides observability about a single channel in the channel pool. */
@InternalApi
public interface BigtableChannelObserver {
  /** Gets the current number of outstanding Unary RPCs on this channel. */
  int getOutstandingUnaryRpcs();

  /** Gets the current number of outstanding Streaming RPCs on this channel. */
  int getOutstandingStreamingRpcs();

  /** Get the current number of errors request count since the last observed period */
  long getAndResetErrorCount();

  /** Get the current number of successful requests since the last observed period */
  long getAndResetSuccessCount();

  boolean isAltsChannel();
}
