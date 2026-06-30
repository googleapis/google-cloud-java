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

import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpResponseException;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ErrorDetails;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.common.collect.ImmutableSet;
import org.junit.jupiter.api.Test;

class HttpJsonApiExceptionFactoryTest {

  @Test
  void testCreate_withAllFieldsPresent() {
    String payload =
        "{\n"
            + "  \"error\": {\n"
            + "    \"code\": 7,\n"
            + "    \"message\": \"The caller does not have permission\",\n"
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

    HttpResponseException exception =
        new HttpResponseException.Builder(403, "Forbidden", new HttpHeaders())
            .setContent(payload)
            .build();

    HttpJsonApiExceptionFactory factory =
        new HttpJsonApiExceptionFactory(ImmutableSet.of(Code.UNAVAILABLE));
    ApiException apiException = factory.create(exception);

    // The status code should be derived from the JSON code (7), ignoring HTTP code (403).
    assertThat(apiException.getStatusCode().getCode()).isEqualTo(Code.PERMISSION_DENIED);
    assertThat(apiException.isRetryable()).isFalse();
    // The message should be overridden by the JSON message
    assertThat(apiException.getMessage()).contains("The caller does not have permission");

    ErrorDetails details = apiException.getErrorDetails();
    assertThat(details).isNotNull();
    assertThat(details.getErrorInfo()).isNotNull();
    assertThat(details.getErrorInfo().getReason()).isEqualTo("SERVICE_DISABLED");
    assertThat(details.getErrorInfo().getDomain()).isEqualTo("googleapis.com");
    assertThat(details.getErrorInfo().getMetadataMap().get("service"))
        .isEqualTo("pubsub.googleapis.com");
  }

  @Test
  void testCreate_withOkStatusNoMessageNoDetails() {
    String payload = "{\n  \"error\": {\n    \"code\": 0\n  }\n}";

    HttpResponseException exception =
        new HttpResponseException.Builder(403, "Forbidden", new HttpHeaders())
            .setContent(payload)
            .build();

    HttpJsonApiExceptionFactory factory =
        new HttpJsonApiExceptionFactory(ImmutableSet.of(Code.UNAVAILABLE));
    ApiException apiException = factory.create(exception);

    // Because code is 0 (OK), it falls back to the HTTP status code (403 -> PERMISSION_DENIED).
    assertThat(apiException.getStatusCode().getCode()).isEqualTo(Code.PERMISSION_DENIED);
    assertThat(apiException.isRetryable()).isFalse();
    // Because there is no message in the payload, it falls back to the HTTP status message.
    assertThat(apiException.getMessage()).contains("Forbidden");
    // Details are unconditionally built, but empty.
    assertThat(apiException.getErrorDetails()).isNotNull();
    assertThat(apiException.getErrorDetails().getErrorInfo()).isNull();
  }

  @Test
  void testCreate_withMessageOverridesHttpStatusMessage() {
    String payload =
        "{\n"
            + "  \"error\": {\n"
            + "    \"message\": \"Custom detailed error message from server\"\n"
            + "  }\n"
            + "}";

    // Transport layer returned generic "Bad Request" phrase
    HttpResponseException exception =
        new HttpResponseException.Builder(400, "Bad Request", new HttpHeaders())
            .setContent(payload)
            .build();

    HttpJsonApiExceptionFactory factory =
        new HttpJsonApiExceptionFactory(ImmutableSet.of(Code.UNAVAILABLE));
    ApiException apiException = factory.create(exception);

    assertThat(apiException.getMessage()).contains("Custom detailed error message from server");
    assertThat(apiException.getMessage()).doesNotContain("Bad Request");
  }

  @Test
  void testCreate_withoutErrorDetails() {
    HttpResponseException exception =
        new HttpResponseException.Builder(503, "Service Unavailable", new HttpHeaders())
            .setContent("plain text error")
            .build();

    HttpJsonApiExceptionFactory factory =
        new HttpJsonApiExceptionFactory(ImmutableSet.of(Code.UNAVAILABLE));
    ApiException apiException = factory.create(exception);

    assertThat(apiException.getStatusCode().getCode()).isEqualTo(Code.UNAVAILABLE);
    assertThat(apiException.isRetryable()).isTrue();
    // Plain text error parsing will still generate an empty ErrorDetails
    assertThat(apiException.getErrorDetails()).isNotNull();
    assertThat(apiException.getErrorDetails().getErrorInfo()).isNull();
  }
}
