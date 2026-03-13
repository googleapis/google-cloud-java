/*
 * Copyright 2018 Google LLC
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
import static com.google.common.truth.Truth.assertWithMessage;

import com.google.api.client.http.HttpMethods;
import com.google.api.gax.tracing.SpanName;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class HttpJsonCallableFactoryTest {
  @Test
  void testGetSpanName() {
    Map<String, SpanName> validNames =
        ImmutableMap.of(
            "google.cloud.service.v1.CoolService/CoolRPC", SpanName.of("CoolService", "CoolRPC"),
            "CoolService/CoolRPC", SpanName.of("CoolService", "CoolRPC"));

    for (Entry<String, SpanName> entry : validNames.entrySet()) {
      @SuppressWarnings("unchecked")
      ApiMethodDescriptor<?, ?> descriptor =
          ApiMethodDescriptor.newBuilder()
              .setFullMethodName(entry.getKey())
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(Mockito.mock(HttpRequestFormatter.class))
              .setResponseParser(Mockito.mock(HttpResponseParser.class))
              .build();

      SpanName actualSpanName = HttpJsonCallableFactory.getSpanName(descriptor);
      assertThat(actualSpanName).isEqualTo(entry.getValue());
    }
  }

  @Test
  void testGetSpanNameInvalid() {
    List<String> invalidNames = ImmutableList.of("no_split", ".no_client");

    for (String invalidName : invalidNames) {
      @SuppressWarnings("unchecked")
      ApiMethodDescriptor<?, ?> descriptor =
          ApiMethodDescriptor.newBuilder()
              .setFullMethodName(invalidName)
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(Mockito.mock(HttpRequestFormatter.class))
              .setResponseParser(Mockito.mock(HttpResponseParser.class))
              .build();

      IllegalArgumentException actualError = null;
      try {
        SpanName spanName = HttpJsonCallableFactory.getSpanName(descriptor);
        assertWithMessage(
                "Invalid method descriptor should not have a valid span name: %s should not generate the spanName: %s",
                invalidName, spanName)
            .fail();
      } catch (IllegalArgumentException e) {
        actualError = e;
      }
      assertThat(actualError).isNotNull();
    }
  }
}
