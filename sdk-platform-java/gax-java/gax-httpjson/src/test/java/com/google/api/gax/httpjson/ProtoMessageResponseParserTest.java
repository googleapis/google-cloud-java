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
import com.google.protobuf.TypeRegistry;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProtoMessageResponseParserTest {
  private ProtoMessageResponseParser<Field> parser;
  private Field field;
  private String fieldJson;

  @BeforeEach
  void setUp() {
    parser =
        ProtoMessageResponseParser.<Field>newBuilder()
            .setDefaultInstance(Field.getDefaultInstance())
            .build();

    field =
        Field.newBuilder()
            .setNumber(2)
            .setName("field_name1")
            .addOptions(Option.newBuilder().setName("opt_name1").build())
            .addOptions(Option.newBuilder().setName("opt_name2").build())
            .setCardinality(Cardinality.CARDINALITY_OPTIONAL)
            .build();

    fieldJson =
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
  }

  @Test
  void parse() {
    Field actualField =
        parser.parse(new ByteArrayInputStream(fieldJson.getBytes(StandardCharsets.UTF_8)));
    Truth.assertThat(actualField).isEqualTo(field);
  }

  @Test
  void parseWithTypeRegistry() {
    Field actualField =
        parser.parse(
            new ByteArrayInputStream(fieldJson.getBytes(StandardCharsets.UTF_8)),
            TypeRegistry.newBuilder().build());
    Truth.assertThat(actualField).isEqualTo(field);
  }

  @Test
  void parseInvalidJson() {
    try {
      parser.parse(new ByteArrayInputStream("invalid".getBytes(StandardCharsets.UTF_8)));
      Assertions.fail();
    } catch (RestSerializationException e) {
      Truth.assertThat(e.getCause()).isInstanceOf(IOException.class);
    }
  }

  @Test
  void serialize() {
    String actualFieldJson = parser.serialize(field);
    Truth.assertThat(actualFieldJson).isEqualTo(fieldJson);
  }
}
