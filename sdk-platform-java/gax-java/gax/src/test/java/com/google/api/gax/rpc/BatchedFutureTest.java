/*
 * Copyright 2016 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.google.api.gax.rpc;

import static com.google.common.util.concurrent.MoreExecutors.directExecutor;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.common.truth.Truth;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;

class BatchedFutureTest {
  @Test
  void testSet() throws Exception {
    BatchedFuture<Integer> future = BatchedFuture.create();
    Truth.assertThat(future.isDone()).isFalse();
    future.set(42);
    Truth.assertThat(future.get()).isEqualTo(42);
    Truth.assertThat(future.get(1, TimeUnit.HOURS)).isEqualTo(42);
    Truth.assertThat(future.isDone()).isTrue();
  }

  @Test
  void testTransform() throws Exception {
    BatchedFuture<Integer> inputFuture = BatchedFuture.<Integer>create();
    ApiFuture<String> transformedFuture =
        ApiFutures.transform(
            inputFuture,
            new ApiFunction<Integer, String>() {
              @Override
              public String apply(Integer input) {
                return input.toString();
              }
            },
            directExecutor());
    inputFuture.set(6);
    Truth.assertThat(transformedFuture.get()).isEqualTo("6");
  }
}
