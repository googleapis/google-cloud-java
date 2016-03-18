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

package com.google.gcloud.storage;

import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.capture;
import static org.easymock.EasyMock.captureLong;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.eq;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.common.collect.ImmutableMap;
import com.google.gcloud.RestorableState;
import com.google.gcloud.RetryParams;
import com.google.gcloud.WriteChannel;
import com.google.gcloud.spi.StorageRpc;
import com.google.gcloud.spi.StorageRpcFactory;

import org.easymock.Capture;
import org.easymock.CaptureType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Map;
import java.util.Random;

public class BlobWriteChannelTest {

  private static final String BUCKET_NAME = "b";
  private static final String BLOB_NAME = "n";
  private static final String UPLOAD_ID = "uploadid";
  private static final BlobInfo BLOB_INFO = BlobInfo.builder(BUCKET_NAME, BLOB_NAME).build();
  private static final Map<StorageRpc.Option, ?> EMPTY_RPC_OPTIONS = ImmutableMap.of();
  private static final int MIN_CHUNK_SIZE = 256 * 1024;
  private static final int DEFAULT_CHUNK_SIZE = 8 * MIN_CHUNK_SIZE;
  private static final int CUSTOM_CHUNK_SIZE = 4 * MIN_CHUNK_SIZE;
  private static final Random RANDOM = new Random();

  private StorageOptions options;
  private StorageRpcFactory rpcFactoryMock;
  private StorageRpc storageRpcMock;
  private BlobWriteChannel writer;

  @Before
  public void setUp() {
    rpcFactoryMock = createMock(StorageRpcFactory.class);
    storageRpcMock = createMock(StorageRpc.class);
    expect(rpcFactoryMock.create(anyObject(StorageOptions.class)))
        .andReturn(storageRpcMock);
    replay(rpcFactoryMock);
    options = StorageOptions.builder()
        .projectId("projectid")
        .serviceRpcFactory(rpcFactoryMock)
        .retryParams(RetryParams.noRetries())
        .build();
  }

  @After
  public void tearDown() throws Exception {
    verify(rpcFactoryMock, storageRpcMock);
  }

  @Test
  public void testCreate() {
    expect(storageRpcMock.open(BLOB_INFO.toPb(), EMPTY_RPC_OPTIONS)).andReturn(UPLOAD_ID);
    replay(storageRpcMock);
    writer = new BlobWriteChannel(options, BLOB_INFO, EMPTY_RPC_OPTIONS);
    assertTrue(writer.isOpen());
  }

  @Test
  public void testWriteWithoutFlush() throws IOException {
    expect(storageRpcMock.open(BLOB_INFO.toPb(), EMPTY_RPC_OPTIONS)).andReturn(UPLOAD_ID);
    replay(storageRpcMock);
    writer = new BlobWriteChannel(options, BLOB_INFO, EMPTY_RPC_OPTIONS);
    assertEquals(MIN_CHUNK_SIZE, writer.write(ByteBuffer.allocate(MIN_CHUNK_SIZE)));
  }

  @Test
  public void testWriteWithFlush() throws IOException {
    expect(storageRpcMock.open(BLOB_INFO.toPb(), EMPTY_RPC_OPTIONS)).andReturn(UPLOAD_ID);
    Capture<byte[]> capturedBuffer = Capture.newInstance();
    storageRpcMock.write(eq(UPLOAD_ID), capture(capturedBuffer), eq(0), eq(0L),
        eq(CUSTOM_CHUNK_SIZE), eq(false));
    replay(storageRpcMock);
    writer = new BlobWriteChannel(options, BLOB_INFO, EMPTY_RPC_OPTIONS);
    writer.chunkSize(CUSTOM_CHUNK_SIZE);
    ByteBuffer buffer = randomBuffer(CUSTOM_CHUNK_SIZE);
    assertEquals(CUSTOM_CHUNK_SIZE, writer.write(buffer));
    assertArrayEquals(buffer.array(), capturedBuffer.getValue());
  }

  @Test
  public void testWritesAndFlush() throws IOException {
    expect(storageRpcMock.open(BLOB_INFO.toPb(), EMPTY_RPC_OPTIONS)).andReturn(UPLOAD_ID);
    Capture<byte[]> capturedBuffer = Capture.newInstance();
    storageRpcMock.write(eq(UPLOAD_ID), capture(capturedBuffer), eq(0), eq(0L),
        eq(DEFAULT_CHUNK_SIZE), eq(false));
    replay(storageRpcMock);
    writer = new BlobWriteChannel(options, BLOB_INFO, EMPTY_RPC_OPTIONS);
    ByteBuffer[] buffers = new ByteBuffer[DEFAULT_CHUNK_SIZE / MIN_CHUNK_SIZE];
    for (int i = 0; i < buffers.length; i++) {
      buffers[i] = randomBuffer(MIN_CHUNK_SIZE);
      assertEquals(MIN_CHUNK_SIZE, writer.write(buffers[i]));
    }
    for (int i = 0; i < buffers.length; i++) {
      assertArrayEquals(
          buffers[i].array(),
          Arrays.copyOfRange(
              capturedBuffer.getValue(), MIN_CHUNK_SIZE * i, MIN_CHUNK_SIZE * (i + 1)));
    }
  }

  @Test
  public void testCloseWithoutFlush() throws IOException {
    expect(storageRpcMock.open(BLOB_INFO.toPb(), EMPTY_RPC_OPTIONS)).andReturn(UPLOAD_ID);
    Capture<byte[]> capturedBuffer = Capture.newInstance();
    storageRpcMock.write(eq(UPLOAD_ID), capture(capturedBuffer), eq(0), eq(0L), eq(0), eq(true));
    replay(storageRpcMock);
    writer = new BlobWriteChannel(options, BLOB_INFO, EMPTY_RPC_OPTIONS);
    assertTrue(writer.isOpen());
    writer.close();
    assertArrayEquals(new byte[0], capturedBuffer.getValue());
    assertTrue(!writer.isOpen());
  }

  @Test
  public void testCloseWithFlush() throws IOException {
    expect(storageRpcMock.open(BLOB_INFO.toPb(), EMPTY_RPC_OPTIONS)).andReturn(UPLOAD_ID);
    Capture<byte[]> capturedBuffer = Capture.newInstance();
    ByteBuffer buffer = randomBuffer(MIN_CHUNK_SIZE);
    storageRpcMock.write(eq(UPLOAD_ID), capture(capturedBuffer), eq(0), eq(0L), eq(MIN_CHUNK_SIZE),
        eq(true));
    replay(storageRpcMock);
    writer = new BlobWriteChannel(options, BLOB_INFO, EMPTY_RPC_OPTIONS);
    assertTrue(writer.isOpen());
    writer.write(buffer);
    writer.close();
    assertEquals(DEFAULT_CHUNK_SIZE, capturedBuffer.getValue().length);
    assertArrayEquals(buffer.array(), Arrays.copyOf(capturedBuffer.getValue(), MIN_CHUNK_SIZE));
    assertTrue(!writer.isOpen());
  }

  @Test
  public void testWriteClosed() throws IOException {
    expect(storageRpcMock.open(BLOB_INFO.toPb(), EMPTY_RPC_OPTIONS)).andReturn(UPLOAD_ID);
    Capture<byte[]> capturedBuffer = Capture.newInstance();
    storageRpcMock.write(eq(UPLOAD_ID), capture(capturedBuffer), eq(0), eq(0L), eq(0), eq(true));
    replay(storageRpcMock);
    writer = new BlobWriteChannel(options, BLOB_INFO, EMPTY_RPC_OPTIONS);
    writer.close();
    try {
      writer.write(ByteBuffer.allocate(MIN_CHUNK_SIZE));
      fail("Expected BlobWriteChannel write to throw IOException");
    } catch (IOException ex) {
      // expected
    }
  }

  @Test
  public void testSaveAndRestore() throws IOException {
    expect(storageRpcMock.open(BLOB_INFO.toPb(), EMPTY_RPC_OPTIONS)).andReturn(UPLOAD_ID);
    Capture<byte[]> capturedBuffer = Capture.newInstance(CaptureType.ALL);
    Capture<Long> capturedPosition = Capture.newInstance(CaptureType.ALL);
    storageRpcMock.write(eq(UPLOAD_ID), capture(capturedBuffer), eq(0),
        captureLong(capturedPosition), eq(DEFAULT_CHUNK_SIZE), eq(false));
    expectLastCall().times(2);
    replay(storageRpcMock);
    ByteBuffer buffer1 = randomBuffer(DEFAULT_CHUNK_SIZE);
    ByteBuffer buffer2 = randomBuffer(DEFAULT_CHUNK_SIZE);
    writer = new BlobWriteChannel(options, BLOB_INFO, EMPTY_RPC_OPTIONS);
    assertEquals(DEFAULT_CHUNK_SIZE, writer.write(buffer1));
    assertArrayEquals(buffer1.array(), capturedBuffer.getValues().get(0));
    assertEquals(new Long(0L), capturedPosition.getValues().get(0));
    RestorableState<WriteChannel> writerState = writer.capture();
    WriteChannel restoredWriter = writerState.restore();
    assertEquals(DEFAULT_CHUNK_SIZE, restoredWriter.write(buffer2));
    assertArrayEquals(buffer2.array(), capturedBuffer.getValues().get(1));
    assertEquals(new Long(DEFAULT_CHUNK_SIZE), capturedPosition.getValues().get(1));
  }

  @Test
  public void testSaveAndRestoreClosed() throws IOException {
    expect(storageRpcMock.open(BLOB_INFO.toPb(), EMPTY_RPC_OPTIONS)).andReturn(UPLOAD_ID);
    Capture<byte[]> capturedBuffer = Capture.newInstance();
    storageRpcMock.write(eq(UPLOAD_ID), capture(capturedBuffer), eq(0), eq(0L), eq(0), eq(true));
    replay(storageRpcMock);
    writer = new BlobWriteChannel(options, BLOB_INFO, EMPTY_RPC_OPTIONS);
    writer.close();
    RestorableState<WriteChannel> writerState = writer.capture();
    RestorableState<WriteChannel> expectedWriterState =
        BlobWriteChannel.StateImpl.builder(options, BLOB_INFO, UPLOAD_ID)
            .buffer(null)
            .chunkSize(DEFAULT_CHUNK_SIZE)
            .isOpen(false)
            .position(0)
            .build();
    WriteChannel restoredWriter = writerState.restore();
    assertArrayEquals(new byte[0], capturedBuffer.getValue());
    assertEquals(expectedWriterState, restoredWriter.capture());
  }

  @Test
  public void testStateEquals() {
    expect(storageRpcMock.open(BLOB_INFO.toPb(), EMPTY_RPC_OPTIONS)).andReturn(UPLOAD_ID).times(2);
    replay(storageRpcMock);
    writer = new BlobWriteChannel(options, BLOB_INFO, EMPTY_RPC_OPTIONS);
    // avoid closing when you don't want partial writes to GCS upon failure
    @SuppressWarnings("resource")
    WriteChannel writer2 = new BlobWriteChannel(options, BLOB_INFO, EMPTY_RPC_OPTIONS);
    RestorableState<WriteChannel> state = writer.capture();
    RestorableState<WriteChannel> state2 = writer2.capture();
    assertEquals(state, state2);
    assertEquals(state.hashCode(), state2.hashCode());
    assertEquals(state.toString(), state2.toString());
  }

  private static ByteBuffer randomBuffer(int size) {
    byte[] byteArray = new byte[size];
    RANDOM.nextBytes(byteArray);
    return ByteBuffer.wrap(byteArray);
  }
}
