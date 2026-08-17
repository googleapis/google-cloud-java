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
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.google.protobuf.TypeRegistry;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringHttpResponseParserTest {

  private StringHttpResponseParser parser;

  @BeforeEach
  void setUp() {
    parser = StringHttpResponseParser.create();
  }

  @Test
  void parse_inputStream_returnsString() {
    String expected = "Hello, world! \u4e16\u754c";
    InputStream inputStream = new ByteArrayInputStream(expected.getBytes(StandardCharsets.UTF_8));

    String result = parser.parse(inputStream);

    assertThat(result).isEqualTo(expected);
  }

  @Test
  void parse_inputStream_empty_returnsEmptyString() {
    InputStream inputStream = new ByteArrayInputStream(new byte[0]);

    String result = parser.parse(inputStream);

    assertThat(result).isEmpty();
  }

  @Test
  void parse_inputStream_withTypeRegistry_returnsString() {
    String expected = "response content";
    InputStream inputStream = new ByteArrayInputStream(expected.getBytes(StandardCharsets.UTF_8));

    String result = parser.parse(inputStream, TypeRegistry.getEmptyTypeRegistry());

    assertThat(result).isEqualTo(expected);
  }

  @Test
  void parse_inputStream_ioException_throwsRestSerializationException() {
    InputStream failingInputStream =
        new InputStream() {
          @Override
          public int read() throws IOException {
            throw new IOException("Simulated read failure");
          }
        };

    RestSerializationException thrown =
        assertThrows(RestSerializationException.class, () -> parser.parse(failingInputStream));
    assertThat(thrown).hasCauseThat().isInstanceOf(IOException.class);
  }

  @Test
  void parse_reader_returnsString() {
    String expected = "Hello from Reader!";
    Reader reader = new StringReader(expected);

    String result = parser.parse(reader, TypeRegistry.getEmptyTypeRegistry());

    assertThat(result).isEqualTo(expected);
  }

  @Test
  void parse_reader_empty_returnsEmptyString() {
    Reader reader = new StringReader("");

    String result = parser.parse(reader, TypeRegistry.getEmptyTypeRegistry());

    assertThat(result).isEmpty();
  }

  @Test
  void parse_reader_ioException_throwsRestSerializationException() {
    Reader failingReader =
        new Reader() {
          @Override
          public int read(char[] cbuf, int off, int len) throws IOException {
            throw new IOException("Simulated reader failure");
          }

          @Override
          public void close() throws IOException {}
        };

    RestSerializationException thrown =
        assertThrows(
            RestSerializationException.class,
            () -> parser.parse(failingReader, TypeRegistry.getEmptyTypeRegistry()));
    assertThat(thrown).hasCauseThat().isInstanceOf(IOException.class);
  }

  @Test
  void serialize_returnsInputString() {
    assertThat(parser.serialize("hello")).isEqualTo("hello");
  }
}
