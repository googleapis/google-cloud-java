/*
 * Copyright 2022 Google LLC
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
import com.google.protobuf.Int64Value;
import com.google.protobuf.Option;
import com.google.protobuf.util.JsonFormat;
import java.io.IOException;
import java.io.StringReader;
import org.junit.jupiter.api.Test;

class ProtoMessageJsonStreamIteratorTest {

  @Test
  void testEmpty() throws IOException {
    String jsonData = "[]";
    ProtoMessageJsonStreamIterator streamIter =
        new ProtoMessageJsonStreamIterator(new StringReader(jsonData));

    Truth.assertThat(streamIter.hasNext()).isFalse();
    streamIter.close();
  }

  @Test
  void testSingleElement() throws IOException {
    Field[] expectedData =
        new Field[] {
          Field.newBuilder()
              .setName("cat")
              .addOptions(Option.newBuilder().setName("haha").build())
              .addOptions(Option.newBuilder().setName("hoho").build())
              .setNumber(1)
              .setDefaultValue("mew")
              .build()
        };

    String jsonData =
        "[{\n"
            + "  \"number\": 1,\n"
            + "  \"name\": \"cat\",\n"
            + "  \"options\": [{\n"
            + "    \"name\": \"haha\"\n"
            + "  }, {\n"
            + "    \"name\": \"hoho\"\n"
            + "  }],\n"
            + "  \"defaultValue\": \"mew\"\n"
            + "}]";

    ProtoMessageJsonStreamIterator streamIter =
        new ProtoMessageJsonStreamIterator(new StringReader(jsonData));

    Truth.assertThat(streamIter.hasNext()).isTrue();
    Field.Builder builder = Field.newBuilder();
    JsonFormat.parser().merge(streamIter.next(), builder);
    Truth.assertThat(builder.build()).isEqualTo(expectedData[0]);

    Truth.assertThat(streamIter.hasNext()).isFalse();

    streamIter.close();
    // closing a closed iterator should be no-op.
    streamIter.close();
  }

  @Test
  void testProtobufWrapperObjects() throws IOException {
    Int64Value[] expectedData =
        new Int64Value[] {
          Int64Value.newBuilder().setValue(1234567889999977L).build(),
          Int64Value.newBuilder().setValue(2234567889999977L).build(),
          Int64Value.newBuilder().setValue(3234567889999977L).build()
        };

    String jsonData = "[\"1234567889999977\", \t    \"2234567889999977\",\n\"3234567889999977\"]";

    ProtoMessageJsonStreamIterator streamIter =
        new ProtoMessageJsonStreamIterator(new StringReader(jsonData));

    Truth.assertThat(streamIter.hasNext()).isTrue();
    Int64Value.Builder builder = Int64Value.newBuilder();
    JsonFormat.parser().merge(streamIter.next(), builder);
    Truth.assertThat(builder.build()).isEqualTo(expectedData[0]);

    Truth.assertThat(streamIter.hasNext()).isTrue();
    builder = Int64Value.newBuilder();
    JsonFormat.parser().merge(streamIter.next(), builder);
    Truth.assertThat(builder.build()).isEqualTo(expectedData[1]);

    Truth.assertThat(streamIter.hasNext()).isTrue();
    builder = Int64Value.newBuilder();
    JsonFormat.parser().merge(streamIter.next(), builder);
    Truth.assertThat(builder.build()).isEqualTo(expectedData[2]);

    Truth.assertThat(streamIter.hasNext()).isFalse();

    streamIter.close();
  }

  @Test
  void testMultipleElements() throws IOException {
    Field[] expectedData =
        new Field[] {
          Field.newBuilder()
              .setName("cat")
              .addOptions(Option.newBuilder().setName("haha").build())
              .addOptions(Option.newBuilder().setName("hoho").build())
              .setNumber(1)
              .setDefaultValue("mew")
              .build(),
          Field.newBuilder()
              .setName("dog")
              .addOptions(Option.newBuilder().setName("muu").build())
              .setNumber(2)
              .setDefaultValue("woof")
              .build(),
          Field.newBuilder()
              .setName("cow")
              .addOptions(Option.newBuilder().setName("bee").build())
              .setNumber(3)
              .setDefaultValue("muu")
              .build()
        };

    String jsonData =
        "[{\n"
            + "  \"number\": 1,\n"
            + "  \"name\": \"cat\",\n"
            + "  \"options\": [{\n"
            + "    \"name\": \"haha\"\n"
            + "  }, {\n"
            + "    \"name\": \"hoho\"\n"
            + "  }],\n"
            + "  \"defaultValue\": \"mew\"\n"
            + "},\n"
            + "{\n"
            + "  \"number\": 2,\n"
            + "  \"name\": \"dog\",\n"
            + "  \"options\": [{\n"
            + "    \"name\": \"muu\"\n"
            + "  }],\n"
            + "  \"defaultValue\": \"woof\"\n"
            + "},\n"
            + "{\n"
            + "  \"number\": 3,\n"
            + "  \"name\": \"cow\",\n"
            + "  \"options\": [{\n"
            + "    \"name\": \"bee\"\n"
            + "  }],\n"
            + "  \"defaultValue\": \"muu\"\n"
            + "}]";

    ProtoMessageJsonStreamIterator streamIter =
        new ProtoMessageJsonStreamIterator(new StringReader(jsonData));

    Truth.assertThat(streamIter.hasNext()).isTrue();
    Field.Builder builder = Field.newBuilder();
    JsonFormat.parser().merge(streamIter.next(), builder);
    Truth.assertThat(builder.build()).isEqualTo(expectedData[0]);

    Truth.assertThat(streamIter.hasNext()).isTrue();
    builder = Field.newBuilder();
    JsonFormat.parser().merge(streamIter.next(), builder);
    Truth.assertThat(builder.build()).isEqualTo(expectedData[1]);

    Truth.assertThat(streamIter.hasNext()).isTrue();
    builder = Field.newBuilder();
    JsonFormat.parser().merge(streamIter.next(), builder);
    Truth.assertThat(builder.build()).isEqualTo(expectedData[2]);

    Truth.assertThat(streamIter.hasNext()).isFalse();

    streamIter.close();
  }

  @Test
  void testEscapedString() throws IOException {
    Field expectedData =
        Field.newBuilder()
            .setName(
                "[{\n"
                    + "\"fInt32\": 23,\n"
                    + "\"fInt64\": \"1234567889999977\",\n"
                    + "\"fDouble\": 1234.343232226,\n"
                    + "\"fKingdom\": \"ARCHAEBACTERIA\"\n"
                    + "}]")
            .build();

    String jsonData =
        "[{\n"
            + "  \"name\": \"[{\\n"
            + "\\\"fInt32\\\": 23,\\n"
            + "\\\"fInt64\\\": \\\"1234567889999977\\\",\\n"
            + "\\\"fDouble\\\": 1234.343232226,\\n"
            + "\\\"fKingdom\\\": \\\"ARCHAEBACTERIA\\\"\\n"
            + "}]\"\n"
            + "}]";

    ProtoMessageJsonStreamIterator streamIter =
        new ProtoMessageJsonStreamIterator(new StringReader(jsonData));

    Truth.assertThat(streamIter.hasNext()).isTrue();
    Field.Builder builder = Field.newBuilder();
    JsonFormat.parser().merge(streamIter.next(), builder);
    Truth.assertThat(builder.build()).isEqualTo(expectedData);
    Truth.assertThat(streamIter.hasNext()).isFalse();

    streamIter.close();
  }
}
