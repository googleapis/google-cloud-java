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

import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StartUploadRequestTest {

  @ParameterizedTest
  @CsvSource({
    "/v1/upload, v1/upload",
    "v1/upload,  v1/upload",
    "/,          ''"
  })
  void build_normalizesLeadingSlashInPath(String inputPath, String expectedPath) {
    StartUploadRequest request = StartUploadRequest.newBuilder().setPath(inputPath).build();

    assertThat(request.getPath()).isEqualTo(expectedPath);
  }

  @Test
  void create_setsPathAndDefaultParameters() {
    StartUploadRequest request = StartUploadRequest.create("/v1/upload");

    assertThat(request.getPath()).isEqualTo("v1/upload");
    assertThat(request.getQueryParams()).isEmpty();
    assertThat(request.getJsonPayload()).isNull();
  }

  @Test
  void newBuilder_defaultsQueryParamsToEmptyMap() {
    StartUploadRequest request = StartUploadRequest.newBuilder().setPath("v1/upload").build();

    assertThat(request.getQueryParams()).isEmpty();
    assertThat(request.getJsonPayload()).isNull();
  }

  @Test
  void newBuilder_defensivelyCopiesInputQueryParams() {
    Map<String, List<String>> mutableParams = new HashMap<>();
    List<String> mutableList = new ArrayList<>();
    mutableList.add("value1");
    mutableParams.put("key1", mutableList);

    StartUploadRequest request =
        StartUploadRequest.newBuilder()
            .setPath("v1/upload")
            .setQueryParams(mutableParams)
            .build();

    // Mutate source collections after build
    mutableParams.put("key2", Collections.singletonList("value2"));
    mutableList.add("value2");

    assertThat(request.getQueryParams())
        .containsExactly("key1", ImmutableList.of("value1"));
  }

  @Test
  void getQueryParams_returnsUnmodifiableMapAndLists() {
    Map<String, List<String>> params = new HashMap<>();
    params.put("key1", new ArrayList<>(Collections.singletonList("value1")));

    StartUploadRequest request =
        StartUploadRequest.newBuilder()
            .setPath("v1/upload")
            .setQueryParams(params)
            .build();

    Map<String, List<String>> queryParams = request.getQueryParams();
    List<String> values = queryParams.get("key1");

    assertThrows(
        UnsupportedOperationException.class,
        () -> queryParams.put("key2", Collections.singletonList("value2")));
    assertThrows(
        UnsupportedOperationException.class,
        () -> values.add("value2"));
  }
}
