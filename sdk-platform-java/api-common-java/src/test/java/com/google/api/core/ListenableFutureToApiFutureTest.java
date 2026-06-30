/*
 * Copyright 2017, Google Inc.
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
 *     * Neither the name of Google Inc. nor the names of its
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
package com.google.api.core;

import com.google.common.truth.Truth;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import org.junit.jupiter.api.Test;

class ListenableFutureToApiFutureTest {

  @Test
  void testGet() throws Exception {
    SettableFuture<Integer> future = SettableFuture.create();
    ListenableFutureToApiFuture<Integer> apiFuture = new ListenableFutureToApiFuture<>(future);
    future.set(3);
    Truth.assertThat(apiFuture.get()).isEqualTo(3);
  }

  @Test
  void testToStringShowsUnderlyingFutureToString() {
    String customInnerFutureDesc = "my-custom-toString-impl";
    ListenableFuture<String> listenableFuture =
        new AbstractFuture<String>() {
          @Override
          public String toString() {
            return customInnerFutureDesc;
          }
        };

    ListenableFutureToApiFuture<String> apiFuture =
        new ListenableFutureToApiFuture<>(listenableFuture);
    Truth.assertThat(apiFuture.toString()).contains(customInnerFutureDesc);
  }
}
