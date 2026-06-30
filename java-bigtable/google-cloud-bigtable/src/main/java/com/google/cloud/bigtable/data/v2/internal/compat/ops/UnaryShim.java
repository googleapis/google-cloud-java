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
package com.google.cloud.bigtable.data.v2.internal.compat.ops;

import io.grpc.Deadline;
import java.io.Closeable;
import java.util.concurrent.CompletableFuture;

/**
 * Wrapper interface for session operations. It will own a set of {@link
 * com.google.cloud.bigtable.data.v2.internal.session.SessionPool}s and wil dispatch vRPCs. It's
 * responsible for creating these {@link
 * com.google.cloud.bigtable.data.v2.internal.session.SessionPool}s on the fly and garbage
 * collecting them when they are no longer used. Each logical operation will implement this
 * interface.
 */
public interface UnaryShim<ReqT, RespT> extends Closeable {
  CompletableFuture<RespT> call(ReqT request, Deadline deadline);

  default boolean supports(ReqT request) {
    return true;
  }
}
