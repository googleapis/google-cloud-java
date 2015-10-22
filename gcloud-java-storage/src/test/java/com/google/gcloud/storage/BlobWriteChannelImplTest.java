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

import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.common.collect.ImmutableMap;
import com.google.gcloud.RestorableState;
import com.google.gcloud.RetryParams;
import com.google.gcloud.spi.StorageRpc;

import org.easymock.Capture;
import org.easymock.CaptureType;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Test;
import org.junit.Before;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Map;
import java.util.Random;

public class BlobWriteChannelImplTest {

  private static final String BUCKET_NAME = "b";
  private static final String BLOB_NAME = "n";
  private static final String UPLOAD_ID = "uploadid";
  private static final BlobInfo BLOB_INFO = BlobInfo.builder(BUCKET_NAME, BLOB_NAME).build();
  private static final Map<StorageRpc.Option, ?> EMPTY_RPC_OPTIONS = ImmutableMap.of();
  private static final int MIN_CHUNK_SIZE = 256 * 1024;
  private static final int DEFAULT_CHUNK_SIZE = 8 * MIN_CHUNK_SIZE;
  private static final int CUSTOM_CHUNK_SIZE = 4 * MIN_CHUNK_SIZE;
  private static final Random RANDOM = new Random();

  private StorageOptions optionsMock;
  private StorageRpc storageRpcMock;
  private BlobWriteChannelImpl writer;

  @Before
  public void setUp() throws IOException, InterruptedException {
    optionsMock = EasyMock.createMock(StorageOptions.class);
    storageRpcMock = EasyMock.createMock(StorageRpc.class);
  }

  @After
  public void tearDown() throws Exception {
    verify(optionsMock);
    verify(storageRpcMock);
  }

  @Test
  public void testCreate() {
    EasyMock.expect(optionsMock.storageRpc()).andReturn(storageRpcMock);
    EasyMock.replay(optionsMock);
    EasyMock.expect(storageRpcMock.open(BLOB_INFO.toPb(), EMPTY_RPC_OPTIONS)).andReturn(UPLOAD_ID);
    EasyMock.replay(storageRpcMock);
    writer = new BlobWriteChannelImpl(optionsMock, BLOB_INFO, EMPTY_RPC_OPTIONS);
    assertTrue(writer.isOpen());
  }

  @Test
  public void testWriteWithoutFlush() throws IOException {
    EasyMock.expect(optionsMock.storageRpc()).andReturn(storageRpcMock);
    EasyMock.replay(optionsMock);
    EasyMock.expect(storageRpcMock.open(BLOB_INFO.toPb(), EMPTY_RPC_OPTIONS)).andReturn(UPLOAD_ID);
    EasyMock.replay(storageRpcMock);
    writer = new BlobWriteChannelImpl(optionsMock, BLOB_INFO, EMPTY_RPC_OPTIONS);
    assertEquals(MIN_CHUNK_SIZE, writer.write(ByteBuffer.allocate(MIN_CHUNK_SIZE)));
  }

  @Test
  public void testWriteWithFlush() throws IOException {
    EasyMock.expect(optionsMock.storageRpc()).andReturn(storageRpcMock);
    EasyMock.expect(optionsMock.retryParams()).andReturn(RetryParams.noRetries());
    EasyMock.replay(optionsMock);
    EasyMock.expect(storageRpcMock.open(BLOB_INFO.toPb(), EMPTY_RPC_OPTIONS)).andReturn(UPLOAD_ID);
    Capture<byte[]> capturedBuffer = Capture.newInstance();
    storageRpcMock.write(EasyMock.eq(UPLOAD_ID), EasyMock.capture(capturedBuffer), EasyMock.eq(0),
        EasyMock.eq(BLOB_INFO.toPb()), EasyMock.eq(0L), EasyMock.eq(CUSTOM_CHUNK_SIZE),
        EasyMock.eq(false));
    EasyMock.expectLastCall();
    EasyMock.replay(storageRpcMock);
    writer = new BlobWriteChannelImpl(optionsMock, BLOB_INFO, EMPTY_RPC_OPTIONS);
    writer.chunkSize(CUSTOM_CHUNK_SIZE);
    ByteBuffer buffer = randomBuffer(CUSTOM_CHUNK_SIZE);
    assertEquals(CUSTOM_CHUNK_SIZE, writer.write(buffer));
    assertArrayEquals(buffer.array(), capturedBuffer.getValue());
  }

  @Test
  public void testWritesAndFlush() throws IOException {
    EasyMock.expect(optionsMock.storageRpc()).andReturn(storageRpcMock);
    EasyMock.expect(optionsMock.retryParams()).andReturn(RetryParams.noRetries());
    EasyMock.replay(optionsMock);
    EasyMock.expect(storageRpcMock.open(BLOB_INFO.toPb(), EMPTY_RPC_OPTIONS)).andReturn(UPLOAD_ID);
    Capture<byte[]> capturedBuffer = Capture.newInstance();
    storageRpcMock.write(EasyMock.eq(UPLOAD_ID), EasyMock.capture(capturedBuffer), EasyMock.eq(0),
        EasyMock.eq(BLOB_INFO.toPb()), EasyMock.eq(0L), EasyMock.eq(DEFAULT_CHUNK_SIZE),
        EasyMock.eq(false));
    EasyMock.expectLastCall();
    EasyMock.replay(storageRpcMock);
    writer = new BlobWriteChannelImpl(optionsMock, BLOB_INFO, EMPTY_RPC_OPTIONS);
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
    EasyMock.expect(optionsMock.storageRpc()).andReturn(storageRpcMock);
    EasyMock.expect(optionsMock.retryParams()).andReturn(RetryParams.noRetries());
    EasyMock.replay(optionsMock);
    EasyMock.expect(storageRpcMock.open(BLOB_INFO.toPb(), EMPTY_RPC_OPTIONS)).andReturn(UPLOAD_ID);
    Capture<byte[]> capturedBuffer = Capture.newInstance();
    storageRpcMock.write(EasyMock.eq(UPLOAD_ID), EasyMock.capture(capturedBuffer), EasyMock.eq(0),
        EasyMock.eq(BLOB_INFO.toPb()), EasyMock.eq(0L), EasyMock.eq(0), EasyMock.eq(true));
    EasyMock.expectLastCall();
    EasyMock.replay(storageRpcMock);
    writer = new BlobWriteChannelImpl(optionsMock, BLOB_INFO, EMPTY_RPC_OPTIONS);
    assertTrue(writer.isOpen());
    writer.close();
    assertArrayEquals(new byte[0], capturedBuffer.getValue());
    assertTrue(!writer.isOpen());
  }

  @Test
  public void testCloseWithFlush() throws IOException {
    EasyMock.expect(optionsMock.storageRpc()).andReturn(storageRpcMock);
    EasyMock.expect(optionsMock.retryParams()).andReturn(RetryParams.noRetries());
    EasyMock.replay(optionsMock);
    EasyMock.expect(storageRpcMock.open(BLOB_INFO.toPb(), EMPTY_RPC_OPTIONS)).andReturn(UPLOAD_ID);
    Capture<byte[]> capturedBuffer = Capture.newInstance();
    ByteBuffer buffer = randomBuffer(MIN_CHUNK_SIZE);
    storageRpcMock.write(EasyMock.eq(UPLOAD_ID), EasyMock.capture(capturedBuffer), EasyMock.eq(0),
        EasyMock.eq(BLOB_INFO.toPb()), EasyMock.eq(0L), EasyMock.eq(MIN_CHUNK_SIZE),
        EasyMock.eq(true));
    EasyMock.expectLastCall();
    EasyMock.replay(storageRpcMock);
    writer = new BlobWriteChannelImpl(optionsMock, BLOB_INFO, EMPTY_RPC_OPTIONS);
    assertTrue(writer.isOpen());
    writer.write(buffer);
    writer.close();
    assertEquals(DEFAULT_CHUNK_SIZE, capturedBuffer.getValue().length);
    assertArrayEquals(buffer.array(), Arrays.copyOf(capturedBuffer.getValue(), MIN_CHUNK_SIZE));
    assertTrue(!writer.isOpen());
  }

  @Test
  public void testWriteClosed() throws IOException {
    EasyMock.expect(optionsMock.storageRpc()).andReturn(storageRpcMock);
    EasyMock.expect(optionsMock.retryParams()).andReturn(RetryParams.noRetries());
    EasyMock.replay(optionsMock);
    EasyMock.expect(storageRpcMock.open(BLOB_INFO.toPb(), EMPTY_RPC_OPTIONS)).andReturn(UPLOAD_ID);
    Capture<byte[]> capturedBuffer = Capture.newInstance();
    storageRpcMock.write(EasyMock.eq(UPLOAD_ID), EasyMock.capture(capturedBuffer), EasyMock.eq(0),
        EasyMock.eq(BLOB_INFO.toPb()), EasyMock.eq(0L), EasyMock.eq(0), EasyMock.eq(true));
    EasyMock.expectLastCall();
    EasyMock.replay(storageRpcMock);
    writer = new BlobWriteChannelImpl(optionsMock, BLOB_INFO, EMPTY_RPC_OPTIONS);
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
    EasyMock.expect(optionsMock.storageRpc()).andReturn(storageRpcMock).times(2);
    EasyMock.expect(optionsMock.retryParams()).andReturn(RetryParams.noRetries()).times(2);
    EasyMock.replay(optionsMock);
    EasyMock.expect(storageRpcMock.open(BLOB_INFO.toPb(), EMPTY_RPC_OPTIONS)).andReturn(UPLOAD_ID);
    Capture<byte[]> capturedBuffer = Capture.newInstance(CaptureType.ALL);
    Capture<Long> capturedPosition = Capture.newInstance(CaptureType.ALL);
    storageRpcMock.write(EasyMock.eq(UPLOAD_ID), EasyMock.capture(capturedBuffer), EasyMock.eq(0),
        EasyMock.eq(BLOB_INFO.toPb()), EasyMock.captureLong(capturedPosition),
        EasyMock.eq(DEFAULT_CHUNK_SIZE), EasyMock.eq(false));
    EasyMock.expectLastCall().times(2);
    EasyMock.replay(storageRpcMock);
    ByteBuffer buffer1 = randomBuffer(DEFAULT_CHUNK_SIZE);
    ByteBuffer buffer2 = randomBuffer(DEFAULT_CHUNK_SIZE);
    writer = new BlobWriteChannelImpl(optionsMock, BLOB_INFO, EMPTY_RPC_OPTIONS);
    assertEquals(DEFAULT_CHUNK_SIZE, writer.write(buffer1));
    assertArrayEquals(buffer1.array(), capturedBuffer.getValues().get(0));
    assertEquals(new Long(0L), capturedPosition.getValues().get(0));
    RestorableState<BlobWriteChannel> writerState = writer.save();
    BlobWriteChannel restoredWriter = writerState.restore();
    assertEquals(DEFAULT_CHUNK_SIZE, restoredWriter.write(buffer2));
    assertArrayEquals(buffer2.array(), capturedBuffer.getValues().get(1));
    assertEquals(new Long(DEFAULT_CHUNK_SIZE), capturedPosition.getValues().get(1));
  }

  @Test
  public void testSaveAndRestoreClosed() throws IOException {
    EasyMock.expect(optionsMock.storageRpc()).andReturn(storageRpcMock).times(2);
    EasyMock.expect(optionsMock.retryParams()).andReturn(RetryParams.noRetries());
    EasyMock.replay(optionsMock);
    EasyMock.expect(storageRpcMock.open(BLOB_INFO.toPb(), EMPTY_RPC_OPTIONS)).andReturn(UPLOAD_ID);
    Capture<byte[]> capturedBuffer = Capture.newInstance();
    storageRpcMock.write(EasyMock.eq(UPLOAD_ID), EasyMock.capture(capturedBuffer), EasyMock.eq(0),
        EasyMock.eq(BLOB_INFO.toPb()), EasyMock.eq(0L), EasyMock.eq(0), EasyMock.eq(true));
    EasyMock.expectLastCall();
    EasyMock.replay(storageRpcMock);
    writer = new BlobWriteChannelImpl(optionsMock, BLOB_INFO, EMPTY_RPC_OPTIONS);
    writer.close();
    RestorableState<BlobWriteChannel> writerState = writer.save();
    RestorableState<BlobWriteChannel> expectedWriterState =
        BlobWriteChannelImpl.StateImpl.builder(optionsMock, BLOB_INFO, UPLOAD_ID)
            .buffer(null)
            .chunkSize(DEFAULT_CHUNK_SIZE)
            .isOpen(false)
            .position(0)
            .build();
    BlobWriteChannel restoredWriter = writerState.restore();
    assertArrayEquals(new byte[0], capturedBuffer.getValue());
    assertEquals(expectedWriterState, restoredWriter.save());
  }

  @Test
  public void testStateEquals() {
    EasyMock.expect(optionsMock.storageRpc()).andReturn(storageRpcMock).times(2);
    EasyMock.replay(optionsMock);
    EasyMock.expect(storageRpcMock.open(BLOB_INFO.toPb(), EMPTY_RPC_OPTIONS)).andReturn(UPLOAD_ID)
        .times(2);
    EasyMock.replay(storageRpcMock);
    writer = new BlobWriteChannelImpl(optionsMock, BLOB_INFO, EMPTY_RPC_OPTIONS);
    BlobWriteChannel writer2 = new BlobWriteChannelImpl(optionsMock, BLOB_INFO, EMPTY_RPC_OPTIONS);
    RestorableState<BlobWriteChannel> state = writer.save();
    RestorableState<BlobWriteChannel> state2 = writer2.save();
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
