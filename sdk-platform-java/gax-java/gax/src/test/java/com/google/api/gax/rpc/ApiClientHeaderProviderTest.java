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

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

class ApiClientHeaderProviderTest {

  private static final String X_GOOG_API_CLIENT = "x-goog-api-client";
  private static final String CLOUD_RESOURCE_PREFIX = "google-cloud-resource-prefix";

  @Test
  void testServiceHeaderDefault() {
    ApiClientHeaderProvider provider = ApiClientHeaderProvider.newBuilder().build();
    assertThat(provider.getHeaders().size()).isEqualTo(1);
    assertThat(provider.getHeaders().get(X_GOOG_API_CLIENT))
        .matches("^gl-java/.* gax/.* protobuf/.*");
  }

  @Test
  void testServiceHeaderManual() {
    ApiClientHeaderProvider provider =
        ApiClientHeaderProvider.newBuilder().setClientLibToken("gccl", "1.2.3").build();
    assertThat(provider.getHeaders().size()).isEqualTo(1);
    assertThat(provider.getHeaders().get(X_GOOG_API_CLIENT))
        .matches("^gl-java/.* gccl/1\\.2\\.3--protobuf-.* gax/.* protobuf/.*");
  }

  @Test
  void testServiceHeaderManualGapic() {
    ApiClientHeaderProvider provider =
        ApiClientHeaderProvider.newBuilder()
            .setTransportToken("grpc", "1.2.3")
            .setClientLibToken("gccl", "4.5.6")
            .setGeneratedLibToken("gapic", "7.8.9")
            .build();
    assertThat(provider.getHeaders().size()).isEqualTo(1);
    assertThat(provider.getHeaders().get(X_GOOG_API_CLIENT))
        .matches(
            "^gl-java/.* gccl/4\\.5\\.6--protobuf-.* gapic/7\\.8\\.9 gax/.* grpc/1\\.2\\.3 protobuf/.*");
  }

  @Test
  void testServiceHeaderManualGrpc() {
    ApiClientHeaderProvider provider =
        ApiClientHeaderProvider.newBuilder()
            .setTransportToken("grpc", "1.2.3")
            .setClientLibToken("gccl", "4.5.6")
            .build();
    assertThat(provider.getHeaders().size()).isEqualTo(1);
    assertThat(provider.getHeaders().get(X_GOOG_API_CLIENT))
        .matches("^gl-java/.* gccl/4\\.5\\.6--protobuf-.* gax/.* grpc/1\\.2\\.3 protobuf/.*");
  }

  @Test
  void testServiceHeaderGapic() {
    ApiClientHeaderProvider provider =
        ApiClientHeaderProvider.newBuilder()
            .setTransportToken("grpc", "1.2.3")
            .setGeneratedLibToken("gapic", "4.5.6")
            .build();
    assertThat(provider.getHeaders().size()).isEqualTo(1);
    assertThat(provider.getHeaders().get(X_GOOG_API_CLIENT))
        .matches("^gl-java/.* gapic/4\\.5\\.6--protobuf-.* gax/.* grpc/1\\.2\\.3 protobuf/.*");
  }

  @Test
  void testCloudResourcePrefixHeader() {
    ApiClientHeaderProvider provider =
        ApiClientHeaderProvider.newBuilder()
            .setTransportToken("grpc", "1.2.3")
            .setGeneratedLibToken("gapic", "4.5.6")
            .setResourceToken("test-prefix")
            .build();
    assertThat(provider.getHeaders().size()).isEqualTo(2);
    assertThat(provider.getHeaders().get(X_GOOG_API_CLIENT))
        .matches("^gl-java/.* gapic/4\\.5\\.6--protobuf-.* gax/.* grpc/1\\.2\\.3 protobuf/.*");
    assertThat(provider.getHeaders().get(CLOUD_RESOURCE_PREFIX)).isEqualTo("test-prefix");
  }

  @Test
  void testCustomHeaderKeys() {
    ApiClientHeaderProvider provider =
        ApiClientHeaderProvider.newBuilder()
            .setTransportToken("grpc", "1.2.3")
            .setGeneratedLibToken("gapic", "4.5.6")
            .setResourceToken("test-prefix")
            .setApiClientHeaderKey("custom-header1")
            .setResourceHeaderKey("custom-header2")
            .build();
    assertThat(provider.getHeaders().size()).isEqualTo(2);
    assertThat(provider.getHeaders().get("custom-header1"))
        .matches("^gl-java/.* gapic/4\\.5\\.6--protobuf-.* gax/.* grpc/1\\.2\\.3 protobuf/.*");
    assertThat(provider.getHeaders().get("custom-header2")).isEqualTo("test-prefix");
  }

  @Test
  void testQuotaProjectHeader() {
    String quotaProjectHeaderValue = "quota-project-id-value";
    ApiClientHeaderProvider provider =
        ApiClientHeaderProvider.newBuilder()
            .setClientLibToken("gccl", "1.2.3")
            .setQuotaProjectIdToken(quotaProjectHeaderValue)
            .build();
    assertThat(provider.getHeaders().size()).isEqualTo(2);
    assertThat(provider.getHeaders().get(X_GOOG_API_CLIENT))
        .matches("^gl-java/.* gccl/1\\.2\\.3--protobuf-.* gax/.* protobuf/.*");
    assertThat(provider.getHeaders().get(ApiClientHeaderProvider.QUOTA_PROJECT_ID_HEADER_KEY))
        .matches(quotaProjectHeaderValue);
  }

  @Test
  void testApiVersionHeader() {
    ApiClientHeaderProvider provider =
        ApiClientHeaderProvider.newBuilder().setApiVersionToken("fake-version-string").build();
    assertThat(provider.getHeaders().size()).isEqualTo(2);
    assertThat(provider.getHeaders().get(ApiClientHeaderProvider.API_VERSION_HEADER_KEY))
        .matches("fake-version-string");

    ApiClientHeaderProvider emptyProvider =
        ApiClientHeaderProvider.newBuilder().setApiVersionToken("").build();
    assertThat(
        emptyProvider.getHeaders().get(ApiClientHeaderProvider.API_VERSION_HEADER_KEY).isEmpty());
  }

  @Test
  void testNonGapicGeneratedLibToken_doesNotAppendProtobufVersion() {
    ApiClientHeaderProvider provider =
        ApiClientHeaderProvider.newBuilder().setGeneratedLibToken("other-token", "1.2.3").build();

    assertThat(provider.getHeaders().get(X_GOOG_API_CLIENT))
        .matches("^gl-java/.* other-token/1.2.3 gax/.* protobuf/.*");
  }

  @Test
  void testNonGcclGeneratedLibToken_doesNotAppendProtobufVersion() {
    ApiClientHeaderProvider provider =
        ApiClientHeaderProvider.newBuilder().setClientLibToken("other-token", "1.2.3").build();

    assertThat(provider.getHeaders().get(X_GOOG_API_CLIENT))
        .matches("^gl-java/.* other-token/1.2.3 gax/.* protobuf/.*");
  }
}
