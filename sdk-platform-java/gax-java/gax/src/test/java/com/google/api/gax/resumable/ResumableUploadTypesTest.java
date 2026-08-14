/*
 * Copyright 2026 Google LLC
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
package com.google.api.gax.resumable;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class ResumableUploadTypesTest {

  private static final String UPLOAD_URL = "https://storage.googleapis.com/upload/session/12345";

  @Test
  void session_normalizesInvalidChunkGranularityToDefault() {
    assertThat(ResumableUploadSession.create(UPLOAD_URL).getChunkGranularity()).isEqualTo(1L);
    assertThat(ResumableUploadSession.create(UPLOAD_URL, 0).getChunkGranularity()).isEqualTo(1L);
    assertThat(ResumableUploadSession.create(UPLOAD_URL, -100L).getChunkGranularity())
        .isEqualTo(1L);
    assertThat(ResumableUploadSession.create(UPLOAD_URL, 256 * 1024L).getChunkGranularity())
        .isEqualTo(256 * 1024L);
  }

  @Test
  void startUploadRequest_guaranteesImmutabilityAndBuilderSupport() {
    StartUploadRequest requestWithLeadingSlash = StartUploadRequest.create("/v1/upload");
    assertThat(requestWithLeadingSlash.getPath()).isEqualTo("v1/upload");
    assertThat(requestWithLeadingSlash.getJsonPayload()).isNull();

    Map<String, List<String>> mutableParams = new HashMap<>();
    List<String> mutableList = new ArrayList<>();
    mutableList.add("value1");
    mutableParams.put("key1", mutableList);

    StartUploadRequest request =
        StartUploadRequest.builder()
            .setPath("/v1/upload")
            .setJsonPayload("{}")
            .setQueryParams(mutableParams)
            .build();
    assertThat(request.getPath()).isEqualTo("v1/upload");

    // Mutate source map and list after construction
    mutableParams.put("key2", Collections.singletonList("value2"));
    mutableList.add("value2");

    Map<String, List<String>> queryParams = request.getQueryParams();
    List<String> extraValue = Collections.singletonList("value3");
    assertThrows(UnsupportedOperationException.class, () -> queryParams.put("key3", extraValue));

    StartUploadRequest mutatedFromBuilder =
        request.toBuilder().setPath("/v2/upload").setJsonPayload("{\"updated\":true}").build();
    assertThat(mutatedFromBuilder.getPath()).isEqualTo("v2/upload");
    assertThat(mutatedFromBuilder.getJsonPayload()).isEqualTo("{\"updated\":true}");
    assertThat(mutatedFromBuilder.getQueryParams()).hasSize(1);
  }
}
