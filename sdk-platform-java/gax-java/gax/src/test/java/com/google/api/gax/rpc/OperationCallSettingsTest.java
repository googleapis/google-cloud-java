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

import com.google.api.core.ApiFunction;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.retrying.TimedRetryAlgorithm;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.common.truth.Truth;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class OperationCallSettingsTest {

  @Test
  void testEmptyBuilder() {
    OperationCallSettings.Builder builder = OperationCallSettings.newBuilder();

    Truth.assertThat(builder.getResponseTransformer()).isNull();
    Truth.assertThat(builder.getMetadataTransformer()).isNull();
    Truth.assertThat(builder.getInitialCallSettings()).isNull();
    Truth.assertThat(builder.getPollingAlgorithm()).isNull();
  }

  @Test
  void testBuilder() {
    OperationCallSettings.Builder<Integer, String, Long> builder =
        OperationCallSettings.newBuilder();

    UnaryCallSettings<Integer, OperationSnapshot> initialCallSettings =
        UnaryCallSettings.<Integer, OperationSnapshot>newUnaryCallSettingsBuilder()
            .setRetryableCodes(Code.UNAVAILABLE)
            .build();
    TimedRetryAlgorithm pollingAlgorithm = Mockito.mock(TimedRetryAlgorithm.class);
    ResponseTransformer responseTransformer = new ResponseTransformer();
    MetadataTransformer metadataTransformer = new MetadataTransformer();

    builder.setPollingAlgorithm(pollingAlgorithm);
    builder.setResponseTransformer(responseTransformer);
    builder.setMetadataTransformer(metadataTransformer);
    builder.setInitialCallSettings(initialCallSettings);

    Truth.assertThat(builder.getInitialCallSettings()).isSameInstanceAs(initialCallSettings);

    OperationCallSettings settings = builder.build();

    Truth.assertThat(settings.getPollingAlgorithm()).isSameInstanceAs(pollingAlgorithm);
    Truth.assertThat(settings.getResponseTransformer()).isSameInstanceAs(responseTransformer);
    Truth.assertThat(settings.getMetadataTransformer()).isSameInstanceAs(metadataTransformer);
    Truth.assertThat(settings.getInitialCallSettings()).isNotNull();
    Truth.assertThat(settings.getInitialCallSettings().getRetryableCodes().size()).isEqualTo(1);
  }

  @Test
  void testBuilderFromSettings() throws Exception {
    OperationCallSettings.Builder<Integer, String, Long> builder =
        OperationCallSettings.newBuilder();

    UnaryCallSettings<Integer, OperationSnapshot> initialCallSettings =
        UnaryCallSettings.<Integer, OperationSnapshot>newUnaryCallSettingsBuilder()
            .setRetryableCodes(Code.UNAVAILABLE)
            .build();
    TimedRetryAlgorithm pollingAlgorithm = Mockito.mock(TimedRetryAlgorithm.class);
    ResponseTransformer responseTransformer = new ResponseTransformer();
    MetadataTransformer metadataTransformer = new MetadataTransformer();

    builder.setPollingAlgorithm(pollingAlgorithm);
    builder.setResponseTransformer(responseTransformer);
    builder.setMetadataTransformer(metadataTransformer);
    builder.setInitialCallSettings(initialCallSettings);

    Truth.assertThat(builder.getInitialCallSettings()).isSameInstanceAs(initialCallSettings);

    OperationCallSettings settings = builder.build();
    OperationCallSettings.Builder newBuilder = settings.toBuilder();

    Truth.assertThat(newBuilder.getPollingAlgorithm()).isSameInstanceAs(pollingAlgorithm);
    Truth.assertThat(newBuilder.getResponseTransformer()).isSameInstanceAs(responseTransformer);
    Truth.assertThat(newBuilder.getMetadataTransformer()).isSameInstanceAs(metadataTransformer);
    Truth.assertThat(newBuilder.getInitialCallSettings()).isNotNull();
    Truth.assertThat(newBuilder.getInitialCallSettings().getRetryableCodes().size()).isEqualTo(1);
  }

  private static class ResponseTransformer implements ApiFunction<OperationSnapshot, String> {
    @Override
    public String apply(OperationSnapshot operationSnapshot) {
      return (String) operationSnapshot.getResponse();
    }
  }

  private static class MetadataTransformer implements ApiFunction<OperationSnapshot, Long> {
    @Override
    public Long apply(OperationSnapshot operationSnapshot) {
      return (Long) operationSnapshot.getMetadata();
    }
  }
}
