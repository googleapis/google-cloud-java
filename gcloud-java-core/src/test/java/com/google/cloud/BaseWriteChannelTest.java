/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.google.cloud.spi.ServiceRpcFactory;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.util.Arrays;
import java.util.Random;

public class BaseWriteChannelTest {

  private abstract static class CustomService implements Service<CustomServiceOptions> {}
  private abstract static class CustomServiceOptions
      extends ServiceOptions<CustomService, Object, CustomServiceOptions> {

    private static final long serialVersionUID = 3302358029307467197L;

    protected CustomServiceOptions(
        Class<? extends ServiceFactory<CustomService, CustomServiceOptions>> serviceFactoryClass,
        Class<? extends ServiceRpcFactory<Object, CustomServiceOptions>> rpcFactoryClass,
        Builder<CustomService, Object, CustomServiceOptions, ?> builder) {
      super(serviceFactoryClass, rpcFactoryClass, builder);
    }
  }

  private static final Serializable ENTITY = 42L;
  private static final String UPLOAD_ID = "uploadId";
  private static final byte[] CONTENT = {0xD, 0xE, 0xA, 0xD};
  private static final int MIN_CHUNK_SIZE = 256 * 1024;
  private static final int DEFAULT_CHUNK_SIZE = 8 * MIN_CHUNK_SIZE;
  private static final Random RANDOM = new Random();
  private static BaseWriteChannel channel;

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Before
  public void setUp() {
    channel = new BaseWriteChannel<CustomServiceOptions, Serializable>(null, ENTITY, UPLOAD_ID) {
      @Override
      public RestorableState<WriteChannel> capture() {
        return null;
      }

      @Override
      protected void flushBuffer(int length, boolean last) {}

      @Override
      protected BaseState.Builder<CustomServiceOptions, Serializable> stateBuilder() {
        return null;
      }
    };
  }

  @Test
  public void testConstructor() {
    assertEquals(null, channel.options());
    assertEquals(ENTITY, channel.entity());
    assertEquals(0, channel.position());
    assertEquals(UPLOAD_ID, channel.uploadId());
    assertEquals(0, channel.limit());
    assertTrue(channel.isOpen());
    assertArrayEquals(new byte[0], channel.buffer());
    assertEquals(DEFAULT_CHUNK_SIZE, channel.chunkSize());
  }

  @Test
  public void testClose() throws IOException {
    channel.close();
    assertFalse(channel.isOpen());
    assertNull(channel.buffer());
  }

  @Test
  public void testValidateOpen() throws IOException {
    channel.close();
    thrown.expect(ClosedChannelException.class);
    channel.write(ByteBuffer.allocate(42));
  }

  @Test
  public void testChunkSize() {
    channel.chunkSize(42);
    assertEquals(MIN_CHUNK_SIZE, channel.chunkSize());
    channel.chunkSize(2 * MIN_CHUNK_SIZE);
    assertEquals(2 * MIN_CHUNK_SIZE, channel.chunkSize());
    channel.chunkSize(512 * 1025);
    assertEquals(2 * MIN_CHUNK_SIZE, channel.chunkSize());
  }

  @Test
  public void testWrite() throws IOException {
    channel.write(ByteBuffer.wrap(CONTENT));
    assertEquals(CONTENT.length, channel.limit());
    assertEquals(DEFAULT_CHUNK_SIZE, channel.buffer().length);
    assertArrayEquals(Arrays.copyOf(CONTENT, DEFAULT_CHUNK_SIZE), channel.buffer());
  }

  @Test
  public void testWriteAndFlush() throws IOException {
    ByteBuffer content = randomBuffer(DEFAULT_CHUNK_SIZE + 1);
    channel.write(content);
    assertEquals(DEFAULT_CHUNK_SIZE, channel.position());
    assertEquals(1, channel.limit());
    byte[] newContent = new byte[DEFAULT_CHUNK_SIZE];
    newContent[0] = content.get(DEFAULT_CHUNK_SIZE);
    assertArrayEquals(newContent, channel.buffer());
  }

  private static ByteBuffer randomBuffer(int size) {
    byte[] byteArray = new byte[size];
    RANDOM.nextBytes(byteArray);
    return ByteBuffer.wrap(byteArray);
  }
}
