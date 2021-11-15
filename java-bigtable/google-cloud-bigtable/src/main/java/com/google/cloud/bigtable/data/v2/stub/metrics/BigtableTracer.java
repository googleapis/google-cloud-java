/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.bigtable.data.v2.stub.metrics;

import com.google.api.core.BetaApi;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.tracing.ApiTracer;
import com.google.api.gax.tracing.BaseApiTracer;
import javax.annotation.Nullable;

/** A Bigtable specific {@link ApiTracer} that includes additional contexts. */
@BetaApi("This surface is stable yet it might be removed in the future.")
public abstract class BigtableTracer extends BaseApiTracer {

  /**
   * Get the attempt number of the current call. Attempt number for the current call is passed in
   * and should be recorded in {@link #attemptStarted(int)}. With the getter we can access it from
   * {@link ApiCallContext}. Attempt number starts from 0.
   */
  public abstract int getAttempt();

  /**
   * Record the latency between Google's network receives the RPC and reads back the first byte of
   * the response from server-timing header. If server-timing header is missing, increment the
   * missing header count.
   */
  public abstract void recordGfeMetadata(@Nullable Long latency);
}
