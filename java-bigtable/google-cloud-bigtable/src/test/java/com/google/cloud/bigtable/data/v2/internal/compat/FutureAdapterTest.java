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
package com.google.cloud.bigtable.data.v2.internal.compat;

import static com.google.common.truth.Truth.assertWithMessage;

import io.grpc.Context;
import io.grpc.Context.CancellableContext;
import java.util.concurrent.CompletableFuture;
import org.junit.jupiter.api.Test;

class FutureAdapterTest {
  @Test
  void testCancellation() {
    CompletableFuture<String> inner = new CompletableFuture<>();
    CancellableContext cancellableContext = Context.current().withCancellation();
    FutureAdapter<String> f = new FutureAdapter<>(inner, cancellableContext);
    f.cancel(true);

    assertWithMessage("Inner future should be cancelled").that(inner.isCancelled()).isTrue();

    assertWithMessage("gRPC context is cancelled").that(cancellableContext.isCancelled()).isTrue();
  }
}
