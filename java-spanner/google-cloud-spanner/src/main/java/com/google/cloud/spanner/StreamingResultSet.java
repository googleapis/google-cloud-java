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

/** Streaming implementation of ResultSet that supports streaming of chunks */
interface StreamingResultSet extends ResultSet {

  /**
   * Returns the {@link boolean} for this {@link ResultSet}. This method will be used by
   * AsyncResultSet internally to initiate gRPC streaming. This method should not be called by the
   * users.
   */
  @InternalApi
  boolean initiateStreaming(AsyncResultSet.StreamMessageListener streamMessageListener);
}
