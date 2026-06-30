/*
 * Copyright 2020 Google LLC
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

import com.google.common.truth.Truth;
import com.google.protobuf.Field;
import com.google.protobuf.Field.Cardinality;
import com.google.protobuf.Option;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProtoMessageRequestFormatterTest {
  private Field field;
  private ProtoMessageRequestFormatter<Field> formatter;

  @BeforeEach
  void setUp() {
    field =
        Field.newBuilder()
            .setNumber(2)
            .setName("field_name1")
            .addOptions(Option.newBuilder().setName("opt_name1").build())
            .addOptions(Option.newBuilder().setName("opt_name2").build())
            .setCardinality(Cardinality.CARDINALITY_OPTIONAL)
            .build();

    formatter =
        ProtoMessageRequestFormatter.<Field>newBuilder()
            .setPath(
                "/api/v1/names/{name=field_name1/**}/aggregated",
                request -> {
                  Map<String, String> fields = new HashMap<>();
                  ProtoRestSerializer<Field> serializer = ProtoRestSerializer.create();
                  serializer.putPathParam(fields, "name", request.getName());
                  serializer.putPathParam(fields, "kindValue", request.getKindValue());
                  return fields;
                })
            .setQueryParamsExtractor(
                request -> {
                  Map<String, List<String>> fields = new HashMap<>();
                  ProtoRestSerializer<Field> serializer = ProtoRestSerializer.create();
                  serializer.putQueryParam(fields, "number", request.getNumber());
                  serializer.putQueryParam(fields, "typeUrl", request.getTypeUrl());
                  return fields;
                })
            .setRequestBodyExtractor(
                request -> {
                  ProtoRestSerializer<Field> serializer = ProtoRestSerializer.create();
                  return serializer.toBody("field", request, false);
                })
            .setAdditionalPaths("/api/v1/names/{name=field_name1/**}/hello")
            .build();
  }

  @Test
  void getQueryParamNames() {
    Map<String, List<String>> queryParamNames = formatter.getQueryParamNames(field);
    Map<String, List<String>> expected = new HashMap<>();
    expected.put("number", Arrays.asList("2"));
    expected.put("typeUrl", Arrays.asList(""));
    Truth.assertThat(queryParamNames).isEqualTo(expected);

    // Test toBuilder() case
    queryParamNames = formatter.toBuilder().build().getQueryParamNames(field);
    expected.put("number", Arrays.asList("2"));
    expected.put("typeUrl", Arrays.asList(""));
    Truth.assertThat(queryParamNames).isEqualTo(expected);
  }

  @Test
  void getRequestBody() {
    String bodyJson = formatter.getRequestBody(field);
    String expectedBodyJson =
        "{\n"
            + "  \"cardinality\": \"CARDINALITY_OPTIONAL\",\n"
            + "  \"number\": 2,\n"
            + "  \"name\": \"field_name1\",\n"
            + "  \"options\": [{\n"
            + "    \"name\": \"opt_name1\"\n"
            + "  }, {\n"
            + "    \"name\": \"opt_name2\"\n"
            + "  }]\n"
            + "}";
    Truth.assertThat(bodyJson).isEqualTo(expectedBodyJson);

    // Test toBuilder() case
    formatter.toBuilder().build().getRequestBody(field);
    Truth.assertThat(bodyJson).isEqualTo(expectedBodyJson);
  }

  @Test
  void getPath() {
    String path = formatter.getPath(field);
    Truth.assertThat(path).isEqualTo("api/v1/names/field_name1/aggregated");

    // Test toBuilder() case
    path = formatter.toBuilder().build().getPath(field);
    Truth.assertThat(path).isEqualTo("api/v1/names/field_name1/aggregated");
  }

  @Test
  void getPath_additionalPaths() {
    Field fieldWithLongerName = field.toBuilder().setName("field_name1/random_text").build();
    String path = formatter.getPath(fieldWithLongerName);
    Truth.assertThat(path).isEqualTo("api/v1/names/field_name1/random_text/aggregated");

    Field fieldWithRandomValues =
        field.toBuilder().setName("field_name1/random_text/random_text1").build();
    path = formatter.getPath(fieldWithRandomValues);
    Truth.assertThat(path)
        .isEqualTo("api/v1/names/field_name1/random_text/random_text1/aggregated");
  }

  @Test
  void getPath_noMatches() {
    // If there are no valid matches, it will return with the default path's url
    Field fieldNotMatching = field.toBuilder().setName("name_does_not_match").build();
    String path = formatter.getPath(fieldNotMatching);
    Truth.assertThat(path).isEqualTo("api/v1/names/name_does_not_match/aggregated");
  }

  @Test
  void getPathTemplate() {
    String path =
        formatter.getPathTemplate().instantiate(Collections.singletonMap("name", "field_name1"));
    Truth.assertThat(path).isEqualTo("api/v1/names/field_name1/aggregated");

    // Test toBuilder() case
    path =
        formatter.toBuilder()
            .build()
            .getPathTemplate()
            .instantiate(Collections.singletonMap("name", "field_name1"));
    Truth.assertThat(path).isEqualTo("api/v1/names/field_name1/aggregated");
  }

  @Test
  void getPathTemplates() {
    String path =
        formatter
            .getAdditionalPathTemplates()
            .get(0)
            .instantiate(Collections.singletonMap("name", "field_name1"));
    Truth.assertThat(path).isEqualTo("api/v1/names/field_name1/hello");

    // Test toBuilder() case
    path =
        formatter.toBuilder()
            .build()
            .getAdditionalPathTemplates()
            .get(0)
            .instantiate(Collections.singletonMap("name", "field_name1"));
    Truth.assertThat(path).isEqualTo("api/v1/names/field_name1/hello");
  }

  @Test
  void updateRawPath() {
    String path = formatter.toBuilder().updateRawPath("/v1/", "/v1beta1/").build().getPath(field);
    Truth.assertThat(path).isEqualTo("api/v1beta1/names/field_name1/aggregated");
  }
}
