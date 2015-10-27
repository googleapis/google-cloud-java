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
import static org.easymock.EasyMock.createMock;
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
import com.google.gcloud.spi.StorageRpc;
import com.google.gcloud.spi.StorageRpcFactory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Map;
import java.util.Random;

public class BlobReadChannelImplTest {

  private static final String BUCKET_NAME = "b";
  private static final String BLOB_NAME = "n";
  private static final BlobId BLOB_ID = BlobId.of(BUCKET_NAME, BLOB_NAME);
  private static final Map<StorageRpc.Option, ?> EMPTY_RPC_OPTIONS = ImmutableMap.of();
  private static final int DEFAULT_CHUNK_SIZE = 2 * 1024 * 1024;
  private static final int CUSTOM_CHUNK_SIZE = 2 * 1024 * 1024;
  private static final Random RANDOM = new Random();

  private StorageOptions options;
  private StorageRpcFactory rpcFactoryMock;
  private StorageRpc storageRpcMock;
  private BlobReadChannelImpl reader;

  @Before
  public void setUp() throws IOException, InterruptedException {
    rpcFactoryMock = createMock(StorageRpcFactory.class);
    storageRpcMock = createMock(StorageRpc.class);
    expect(rpcFactoryMock.create(anyObject(StorageOptions.class))).andReturn(storageRpcMock);
    replay(rpcFactoryMock);
    options = StorageOptions.builder()
        .projectId("projectId")
        .serviceRpcFactory(rpcFactoryMock)
        .build();
  }

  @After
  public void tearDown() throws Exception {
    verify(rpcFactoryMock, storageRpcMock);
  }

  @Test
  public void testCreate() {
    replay(storageRpcMock);
    reader = new BlobReadChannelImpl(options, BLOB_ID, EMPTY_RPC_OPTIONS);
    assertTrue(reader.isOpen());
  }

  @Test
  public void testReadBuffered() throws IOException {
    reader = new BlobReadChannelImpl(options, BLOB_ID, EMPTY_RPC_OPTIONS);
    byte[] result = randomByteArray(DEFAULT_CHUNK_SIZE);
    ByteBuffer firstReadBuffer = ByteBuffer.allocate(42);
    ByteBuffer secondReadBuffer = ByteBuffer.allocate(42);
    expect(storageRpcMock.read(BLOB_ID.toPb(), EMPTY_RPC_OPTIONS, 0, DEFAULT_CHUNK_SIZE))
        .andReturn(result);
    replay(storageRpcMock);
    reader.read(firstReadBuffer);
    reader.read(secondReadBuffer);
    assertArrayEquals(Arrays.copyOf(result, firstReadBuffer.capacity()), firstReadBuffer.array());
    assertArrayEquals(
        Arrays.copyOfRange(result, firstReadBuffer.capacity(), firstReadBuffer.capacity()
            + secondReadBuffer.capacity()),
        secondReadBuffer.array());
  }

  @Test
  public void testReadBig() throws IOException {
    reader = new BlobReadChannelImpl(options, BLOB_ID, EMPTY_RPC_OPTIONS);
    reader.chunkSize(CUSTOM_CHUNK_SIZE);
    byte[] firstResult = randomByteArray(DEFAULT_CHUNK_SIZE);
    byte[] secondResult = randomByteArray(DEFAULT_CHUNK_SIZE);
    ByteBuffer firstReadBuffer = ByteBuffer.allocate(DEFAULT_CHUNK_SIZE);
    ByteBuffer secondReadBuffer = ByteBuffer.allocate(42);
    storageRpcMock.read(BLOB_ID.toPb(), EMPTY_RPC_OPTIONS, 0, DEFAULT_CHUNK_SIZE);
    expectLastCall().andReturn(firstResult);
    storageRpcMock.read(BLOB_ID.toPb(), EMPTY_RPC_OPTIONS, DEFAULT_CHUNK_SIZE, CUSTOM_CHUNK_SIZE);
    expectLastCall().andReturn(secondResult);
    replay(storageRpcMock);
    reader.read(firstReadBuffer);
    reader.read(secondReadBuffer);
    assertArrayEquals(firstResult, firstReadBuffer.array());
    assertArrayEquals(Arrays.copyOf(secondResult, secondReadBuffer.capacity()),
        secondReadBuffer.array());
  }

  @Test
  public void testReadFinish() throws IOException {
    reader = new BlobReadChannelImpl(options, BLOB_ID, EMPTY_RPC_OPTIONS);
    byte[] result = {};
    ByteBuffer readBuffer = ByteBuffer.allocate(DEFAULT_CHUNK_SIZE);
    expect(storageRpcMock.read(BLOB_ID.toPb(), EMPTY_RPC_OPTIONS, 0, DEFAULT_CHUNK_SIZE))
        .andReturn(result);
    replay(storageRpcMock);
    assertEquals(-1, reader.read(readBuffer));
  }

  @Test
  public void testSeek() throws IOException {
    reader = new BlobReadChannelImpl(options, BLOB_ID, EMPTY_RPC_OPTIONS);
    reader.seek(42);
    byte[] result = randomByteArray(DEFAULT_CHUNK_SIZE);
    ByteBuffer readBuffer = ByteBuffer.allocate(DEFAULT_CHUNK_SIZE);
    expect(storageRpcMock.read(BLOB_ID.toPb(), EMPTY_RPC_OPTIONS, 42, DEFAULT_CHUNK_SIZE))
        .andReturn(result);
    replay(storageRpcMock);
    reader.read(readBuffer);
    assertArrayEquals(result, readBuffer.array());
  }

  @Test
  public void testClose() throws IOException {
    replay(storageRpcMock);
    reader = new BlobReadChannelImpl(options, BLOB_ID, EMPTY_RPC_OPTIONS);
    assertTrue(reader.isOpen());
    reader.close();
    assertTrue(!reader.isOpen());
  }

  @Test
  public void testReadClosed() {
    replay(storageRpcMock);
    reader = new BlobReadChannelImpl(options, BLOB_ID, EMPTY_RPC_OPTIONS);
    reader.close();
    try {
      ByteBuffer readBuffer = ByteBuffer.allocate(DEFAULT_CHUNK_SIZE);
      reader.read(readBuffer);
      fail("Expected BlobReadChannel read to throw IOException");
    } catch (IOException ex) {
      // expected
    }
  }

  @Test
  public void testSaveAndRestore() throws IOException, ClassNotFoundException {
    byte[] firstResult = randomByteArray(DEFAULT_CHUNK_SIZE);
    byte[] secondResult = randomByteArray(DEFAULT_CHUNK_SIZE);
    ByteBuffer firstReadBuffer = ByteBuffer.allocate(42);
    ByteBuffer secondReadBuffer = ByteBuffer.allocate(DEFAULT_CHUNK_SIZE);
    expect(storageRpcMock.read(BLOB_ID.toPb(), EMPTY_RPC_OPTIONS, 0, DEFAULT_CHUNK_SIZE))
        .andReturn(firstResult);
    expect(storageRpcMock.read(BLOB_ID.toPb(), EMPTY_RPC_OPTIONS, 42, DEFAULT_CHUNK_SIZE))
        .andReturn(secondResult);
    replay(storageRpcMock);
    reader = new BlobReadChannelImpl(options, BLOB_ID, EMPTY_RPC_OPTIONS);
    reader.read(firstReadBuffer);
    RestorableState<BlobReadChannel> readerState = reader.capture();
    BlobReadChannel restoredReader = readerState.restore();
    restoredReader.read(secondReadBuffer);
    assertArrayEquals(Arrays.copyOf(firstResult, firstReadBuffer.capacity()),
        firstReadBuffer.array());
    assertArrayEquals(secondResult, secondReadBuffer.array());
  }

  @Test
  public void testStateEquals() {
    replay(storageRpcMock);
    reader = new BlobReadChannelImpl(options, BLOB_ID, EMPTY_RPC_OPTIONS);
    BlobReadChannel secondReader = new BlobReadChannelImpl(options, BLOB_ID, EMPTY_RPC_OPTIONS);
    RestorableState<BlobReadChannel> state = reader.capture();
    RestorableState<BlobReadChannel> secondState = secondReader.capture();
    assertEquals(state, secondState);
    assertEquals(state.hashCode(), secondState.hashCode());
    assertEquals(state.toString(), secondState.toString());
  }

  private static byte[] randomByteArray(int size) {
    byte[] byteArray = new byte[size];
    RANDOM.nextBytes(byteArray);
    return byteArray;
  }
}
