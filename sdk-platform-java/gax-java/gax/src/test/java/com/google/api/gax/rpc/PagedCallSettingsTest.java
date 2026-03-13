/*
 * Copyright 2017 Google LLC
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

import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.common.collect.Sets;
import com.google.common.truth.Truth;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PagedCallSettingsTest {

  @Test
  void testEmptyBuilder() {
    @SuppressWarnings("unchecked")
    PagedListResponseFactory<Integer, String, Long> pagedListResponseFactory =
        Mockito.mock(PagedListResponseFactory.class);
    PagedCallSettings.Builder<Integer, String, Long> builder =
        PagedCallSettings.newBuilder(pagedListResponseFactory);

    Truth.assertThat(builder.getPagedListResponseFactory())
        .isSameInstanceAs(pagedListResponseFactory);
    Truth.assertThat(builder.getRetryableCodes().size()).isEqualTo(0);
    Truth.assertThat(builder.getRetrySettings()).isNotNull();

    PagedCallSettings settings = builder.build();

    Truth.assertThat(settings.getPagedListResponseFactory())
        .isSameInstanceAs(pagedListResponseFactory);
    Truth.assertThat(settings.getRetryableCodes().size()).isEqualTo(0);
    Truth.assertThat(settings.getRetrySettings()).isNotNull();
  }

  @Test
  void testBuilder() {
    @SuppressWarnings("unchecked")
    PagedListResponseFactory<Integer, String, Long> pagedListResponseFactory =
        Mockito.mock(PagedListResponseFactory.class);
    PagedCallSettings.Builder<Integer, String, Long> builder =
        PagedCallSettings.newBuilder(pagedListResponseFactory);

    Set<StatusCode.Code> retryCodes = Sets.newHashSet(Code.UNAVAILABLE);
    RetrySettings retrySettings =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(java.time.Duration.ofMillis(5))
            .setMaxRetryDelayDuration(java.time.Duration.ofSeconds(1))
            .setRetryDelayMultiplier(2)
            .setInitialRpcTimeoutDuration(java.time.Duration.ofMillis(100))
            .setMaxRpcTimeoutDuration(java.time.Duration.ofMillis(200))
            .setRpcTimeoutMultiplier(1.1)
            .setJittered(true)
            .setMaxAttempts(10)
            .build();

    builder.setRetryableCodes(retryCodes);
    builder.setRetrySettings(retrySettings);

    Truth.assertThat(builder.getRetryableCodes().size()).isEqualTo(1);
    Truth.assertThat(builder.getRetrySettings()).isEqualTo(retrySettings);

    PagedCallSettings settings = builder.build();

    Truth.assertThat(settings.getRetryableCodes().size()).isEqualTo(1);
    Truth.assertThat(settings.getRetrySettings()).isEqualTo(retrySettings);
  }

  @Test
  void testBuilderFromSettings() throws Exception {
    @SuppressWarnings("unchecked")
    PagedListResponseFactory<Integer, String, Long> pagedListResponseFactory =
        Mockito.mock(PagedListResponseFactory.class);
    PagedCallSettings.Builder<Integer, String, Long> builder =
        PagedCallSettings.newBuilder(pagedListResponseFactory);

    Set<StatusCode.Code> retryCodes = Sets.newHashSet(Code.UNAVAILABLE);
    RetrySettings retrySettings =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(java.time.Duration.ofMillis(5))
            .setMaxRetryDelayDuration(java.time.Duration.ofSeconds(1))
            .setRetryDelayMultiplier(2)
            .setInitialRpcTimeoutDuration(java.time.Duration.ofMillis(100))
            .setMaxRpcTimeoutDuration(java.time.Duration.ofMillis(200))
            .setRpcTimeoutMultiplier(1.1)
            .setJittered(true)
            .setMaxAttempts(10)
            .build();

    builder.setRetryableCodes(retryCodes);
    builder.setRetrySettings(retrySettings);

    Truth.assertThat(builder.getRetryableCodes().size()).isEqualTo(1);
    Truth.assertThat(builder.getRetrySettings()).isEqualTo(retrySettings);

    PagedCallSettings settings = builder.build();
    PagedCallSettings.Builder newBuilder = settings.toBuilder();

    Truth.assertThat(newBuilder.getRetryableCodes().size()).isEqualTo(1);
    Truth.assertThat(newBuilder.getRetrySettings()).isEqualTo(retrySettings);
  }
}
