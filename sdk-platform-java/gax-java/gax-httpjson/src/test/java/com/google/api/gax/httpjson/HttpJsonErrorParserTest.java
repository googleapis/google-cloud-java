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
package com.google.api.gax.httpjson;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.rpc.ErrorDetails;
import com.google.rpc.ErrorInfo;
import org.junit.jupiter.api.Test;

/** Tests for {@link HttpJsonErrorParser}. */
class HttpJsonErrorParserTest {

  @Test
  void parseStatus_success() {
    String payload =
        "{\n"
            + "  \"error\": {\n"
            + "    \"code\": 401,\n"
            + "    \"message\": \"Request is missing required authentication credential.\",\n"
            + "    \"status\": \"UNAUTHENTICATED\",\n"
            + "    \"details\": [\n"
            + "      {\n"
            + "        \"@type\": \"type.googleapis.com/google.rpc.ErrorInfo\",\n"
            + "        \"reason\": \"SERVICE_DISABLED\",\n"
            + "        \"domain\": \"googleapis.com\",\n"
            + "        \"metadata\": {\n"
            + "          \"service\": \"pubsub.googleapis.com\"\n"
            + "        }\n"
            + "      }\n"
            + "    ]\n"
            + "  }\n"
            + "}";

    com.google.rpc.Status status = HttpJsonErrorParser.parseStatus(payload);
    assertThat(status).isNotNull();
    assertThat(status.getCode()).isEqualTo(401);
    assertThat(status.getMessage())
        .isEqualTo("Request is missing required authentication credential.");

    ErrorDetails errorDetails =
        ErrorDetails.builder().setRawErrorMessages(status.getDetailsList()).build();
    ErrorInfo errorInfo = errorDetails.getErrorInfo();
    assertThat(errorInfo).isNotNull();
    assertThat(errorInfo.getReason()).isEqualTo("SERVICE_DISABLED");
    assertThat(errorInfo.getDomain()).isEqualTo("googleapis.com");
    assertThat(errorInfo.getMetadataMap().get("service")).isEqualTo("pubsub.googleapis.com");
  }

  @Test
  void parseStatus_noErrorInfo() {
    String payload =
        "{\n"
            + "  \"error\": {\n"
            + "    \"details\": [\n"
            + "      {\n"
            + "        \"@type\": \"type.googleapis.com/google.rpc.RetryInfo\"\n"
            + "      }\n"
            + "    ]\n"
            + "  }\n"
            + "}";

    com.google.rpc.Status status = HttpJsonErrorParser.parseStatus(payload);
    assertThat(status).isNotNull();
    ErrorDetails errorDetails =
        ErrorDetails.builder().setRawErrorMessages(status.getDetailsList()).build();
    assertThat(errorDetails.getRetryInfo()).isNotNull();
  }

  @Test
  void parseStatus_emptyPayload() {
    assertThat(HttpJsonErrorParser.parseStatus(""))
        .isEqualTo(com.google.rpc.Status.getDefaultInstance());
    assertThat(HttpJsonErrorParser.parseStatus(null))
        .isEqualTo(com.google.rpc.Status.getDefaultInstance());
  }

  @Test
  void parseStatus_invalidJson() {
    assertThat(HttpJsonErrorParser.parseStatus("{invalid"))
        .isEqualTo(com.google.rpc.Status.getDefaultInstance());
  }

  @Test
  void parseStatus_noErrorObject() {
    String payload = "{\"foo\": \"bar\"}";
    assertThat(HttpJsonErrorParser.parseStatus(payload))
        .isEqualTo(com.google.rpc.Status.getDefaultInstance());
  }

  @Test
  void parseStatus_noDetails() {
    String payload = "{\"error\": {}}";
    assertThat(HttpJsonErrorParser.parseStatus(payload))
        .isEqualTo(com.google.rpc.Status.getDefaultInstance());
  }

  @Test
  void parseStatus_garbageInError() {
    String payload = "{\"error\": \"not-an-object\"}";
    assertThat(HttpJsonErrorParser.parseStatus(payload))
        .isEqualTo(com.google.rpc.Status.getDefaultInstance());
  }

  @Test
  void parseStatus_arrayInError() {
    String payload = "{\"error\": []}";
    assertThat(HttpJsonErrorParser.parseStatus(payload))
        .isEqualTo(com.google.rpc.Status.getDefaultInstance());
  }
}
