/*
 * Copyright 2015 Google LLC
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

package com.google.cloud.datastore;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

import com.google.common.testing.EqualsTester;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Random;
import org.junit.Before;
import org.junit.Test;

public class BlobTest {

  private static final byte[] bytes1 = new byte[10];
  private static final byte[] bytes2 = new byte[11];
  private Blob blob1;
  private Blob blob2;

  @Before
  public void setUp() {
    Random rnd = new Random();
    rnd.nextBytes(bytes1);
    rnd.nextBytes(bytes2);
    blob1 = Blob.copyFrom(bytes1);
    blob2 = Blob.copyFrom(bytes2);
  }

  @Test
  public void testEquals() {
    EqualsTester equalsTester = new EqualsTester();
    equalsTester.addEqualityGroup(blob1, blob1).testEquals();
    assertEquals(blob1, Blob.copyFrom(bytes1));
    assertNotEquals(blob1, blob2);
  }

  @Test
  public void testLength() {
    assertEquals(bytes1.length, blob1.getLength());
    assertEquals(bytes2.length, blob2.getLength());
  }

  @Test
  public void testToByteArray() {
    assertArrayEquals(bytes1, blob1.toByteArray());
    assertArrayEquals(bytes2, blob2.toByteArray());
  }

  @Test
  public void testAsReadOnlyByteBuffer() {
    ByteBuffer buffer = blob1.asReadOnlyByteBuffer();
    byte[] bytes = new byte[bytes1.length];
    buffer.get(bytes);
    assertFalse(buffer.hasRemaining());
    assertArrayEquals(bytes1, bytes);
  }

  @Test
  public void testAsInputStream() throws Exception {
    byte[] bytes = new byte[bytes1.length];
    InputStream in = blob1.asInputStream();
    assertEquals(bytes1.length, in.read(bytes));
    assertEquals(-1, in.read());
    assertArrayEquals(bytes1, bytes);
  }

  @Test
  public void testCopyTo() {
    byte[] bytes = new byte[bytes1.length];
    blob1.copyTo(bytes);
    assertArrayEquals(bytes1, bytes);

    ByteBuffer buffer = ByteBuffer.allocate(bytes1.length);
    blob1.copyTo(buffer);
    buffer.flip();
    bytes = new byte[bytes1.length];
    buffer.get(bytes);
    assertFalse(buffer.hasRemaining());
    assertArrayEquals(bytes1, bytes);
  }

  @Test
  public void testCopyFrom() throws Exception {
    Blob blob = Blob.copyFrom(ByteBuffer.wrap(bytes1));
    assertEquals(blob1, blob);
    assertArrayEquals(bytes1, blob.toByteArray());

    blob = Blob.copyFrom(new ByteArrayInputStream(bytes2));
    assertEquals(blob2, blob);
    assertArrayEquals(bytes2, blob.toByteArray());
  }
}
