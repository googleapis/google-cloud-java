/*
 * Copyright 2016 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import com.google.common.io.ByteStreams;
import com.google.protobuf.ByteString;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import org.junit.BeforeClass;
import org.junit.Test;

public class ByteArrayTest {

  private static final String STRING_CONTENT = "Hello, ByteArray!";
  private static final byte[] BYTES_CONTENT = STRING_CONTENT.getBytes(StandardCharsets.UTF_8);
  private static final ByteBuffer BYTE_BUFFER_CONTENT = ByteBuffer.wrap(BYTES_CONTENT);
  private static final InputStream STREAM_CONTENT = new ByteArrayInputStream(BYTES_CONTENT);
  private static final ByteArray STRING_ARRAY = ByteArray.copyFrom(STRING_CONTENT);
  private static final ByteArray BYTES_ARRAY = ByteArray.copyFrom(BYTES_CONTENT);
  private static final ByteArray BYTE_BUFFER_ARRAY = ByteArray.copyFrom(BYTE_BUFFER_CONTENT);
  private static final ByteArray ARRAY = new ByteArray(ByteString.copyFrom(BYTES_CONTENT));

  private static ByteArray streamArray;

  @BeforeClass
  public static void beforeClass() throws IOException {
    streamArray = ByteArray.copyFrom(STREAM_CONTENT);
    BYTE_BUFFER_CONTENT.flip();
  }

  @Test
  public void testCopyFromString() throws IOException {
    assertEquals(STRING_CONTENT, STRING_ARRAY.toStringUtf8());
    assertArrayEquals(BYTES_CONTENT, STRING_ARRAY.toByteArray());
    assertEquals(BYTE_BUFFER_CONTENT.asReadOnlyBuffer(), STRING_ARRAY.asReadOnlyByteBuffer());
    assertArrayEquals(BYTES_CONTENT, ByteStreams.toByteArray(STRING_ARRAY.asInputStream()));
  }

  @Test
  public void testCopyFromByteArray() throws IOException {
    assertEquals(STRING_CONTENT, BYTES_ARRAY.toStringUtf8());
    assertArrayEquals(BYTES_CONTENT, BYTES_ARRAY.toByteArray());
    assertEquals(BYTE_BUFFER_CONTENT.asReadOnlyBuffer(), BYTES_ARRAY.asReadOnlyByteBuffer());
    assertArrayEquals(BYTES_CONTENT, ByteStreams.toByteArray(BYTES_ARRAY.asInputStream()));
  }

  @Test
  public void testCopyFromByteBuffer() throws IOException {
    assertEquals(STRING_CONTENT, BYTE_BUFFER_ARRAY.toStringUtf8());
    assertArrayEquals(BYTES_CONTENT, BYTE_BUFFER_ARRAY.toByteArray());
    assertEquals(BYTE_BUFFER_CONTENT.asReadOnlyBuffer(), BYTE_BUFFER_ARRAY.asReadOnlyByteBuffer());
    assertArrayEquals(BYTES_CONTENT, ByteStreams.toByteArray(BYTE_BUFFER_ARRAY.asInputStream()));
  }

  @Test
  public void testCopyFromStream() throws IOException {
    assertEquals(STRING_CONTENT, streamArray.toStringUtf8());
    assertArrayEquals(BYTES_CONTENT, streamArray.toByteArray());
    assertEquals(BYTE_BUFFER_CONTENT.asReadOnlyBuffer(), streamArray.asReadOnlyByteBuffer());
    assertArrayEquals(BYTES_CONTENT, ByteStreams.toByteArray(streamArray.asInputStream()));
  }

  @Test
  public void testLength() {
    assertEquals(BYTES_CONTENT.length, ARRAY.length());
  }

  @Test
  public void testToStringUtf8() {
    assertEquals(STRING_CONTENT, ARRAY.toStringUtf8());
  }

  @Test
  public void testToByteArray() {
    assertArrayEquals(BYTES_CONTENT, ARRAY.toByteArray());
  }

  @Test
  public void testAsReadOnlyByteBuffer() {
    assertEquals(BYTE_BUFFER_CONTENT.asReadOnlyBuffer(), ARRAY.asReadOnlyByteBuffer());
  }

  @Test
  public void testAsInputStream() throws IOException {
    assertArrayEquals(BYTES_CONTENT, ByteStreams.toByteArray(ARRAY.asInputStream()));
  }

  @Test
  public void testHashCode() {
    assertEquals(STRING_ARRAY.hashCode(), BYTES_ARRAY.hashCode());
    assertEquals(BYTES_ARRAY.hashCode(), BYTE_BUFFER_ARRAY.hashCode());
    assertEquals(BYTE_BUFFER_ARRAY.hashCode(), streamArray.hashCode());
  }
}
