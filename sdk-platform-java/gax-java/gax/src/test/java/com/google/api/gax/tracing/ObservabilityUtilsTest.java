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
package com.google.api.gax.tracing;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.common.collect.ImmutableMap;
import com.google.common.truth.Truth;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import java.util.Map;
import org.junit.jupiter.api.Test;

class ObservabilityUtilsTest {
  @Test
  void testExtractStatus_errorConversion_apiExceptions() {
    ApiException error =
        new ApiException(
            "fake_error", null, new FakeStatusCode(StatusCode.Code.INVALID_ARGUMENT), false);
    String errorCode = ObservabilityUtils.extractStatus(error);
    assertThat(errorCode).isEqualTo(StatusCode.Code.INVALID_ARGUMENT.toString());
  }

  @Test
  void testExtractStatus_errorConversion_noError() {
    // test "OK", which corresponds to a "null" error.
    String successCode = ObservabilityUtils.extractStatus(null);
    assertThat(successCode).isEqualTo(StatusCode.Code.OK.toString());
  }

  @Test
  void testExtractStatus_errorConversion_unknownException() {
    // test "UNKNOWN"
    Throwable unknownException = new RuntimeException();
    String errorCode2 = ObservabilityUtils.extractStatus(unknownException);
    assertThat(errorCode2).isEqualTo(StatusCode.Code.UNKNOWN.toString());
  }

  @Test
  void testToOtelAttributes_shouldMapStringAttributes() {
    String attribute1 = "attribute_1";
    String attribute2 = "attribute_2";
    String attribute1Value = "Today is a good day";
    String attribute2Value = "Does not matter";
    Map<String, Object> attributes =
        ImmutableMap.of(attribute1, attribute1Value, attribute2, attribute2Value);

    Attributes otelAttributes = ObservabilityUtils.toOtelAttributes(attributes);

    Truth.assertThat(otelAttributes.get(AttributeKey.stringKey(attribute1)))
        .isEqualTo(attribute1Value);
    Truth.assertThat(otelAttributes.get(AttributeKey.stringKey(attribute2)))
        .isEqualTo(attribute2Value);
  }

  @Test
  void testToOtelAttributes_urlTemplateAttribute() {
    String urlTemplateValue = "/blogs/{blog}/posts/{post}";
    Map<String, Object> attributes =
        ImmutableMap.of(ObservabilityAttributes.HTTP_URL_TEMPLATE_ATTRIBUTE, urlTemplateValue);

    Attributes otelAttributes = ObservabilityUtils.toOtelAttributes(attributes);

    Truth.assertThat(
            otelAttributes.get(
                AttributeKey.stringKey(ObservabilityAttributes.HTTP_URL_TEMPLATE_ATTRIBUTE)))
        .isEqualTo(urlTemplateValue);
  }

  @Test
  void testToOtelAttributes_shouldMapIntAttributes() {
    String attribute1 = "attribute_1";
    String attribute2 = "attribute_2";
    int attribute1Value = 23;
    int attribute2Value = 81;
    Map<String, Object> attributes =
        ImmutableMap.of(attribute1, attribute1Value, attribute2, attribute2Value);

    Attributes otelAttributes = ObservabilityUtils.toOtelAttributes(attributes);

    Truth.assertThat(otelAttributes.get(AttributeKey.longKey(attribute1)))
        .isEqualTo((long) attribute1Value);
    Truth.assertThat(otelAttributes.get(AttributeKey.longKey(attribute2)))
        .isEqualTo((long) attribute2Value);
  }

  @Test
  void testToOtelAttributes_shouldReturnEmptyAttributes_nullInput() {
    assertThat(ObservabilityUtils.toOtelAttributes(null)).isEqualTo(Attributes.empty());
  }
}
