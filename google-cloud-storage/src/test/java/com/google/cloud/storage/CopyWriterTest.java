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

package com.google.cloud.storage;

import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.google.cloud.RestorableState;
import com.google.cloud.ServiceOptions;
import com.google.cloud.storage.spi.v1.StorageRpc;
import com.google.cloud.storage.spi.v1.StorageRpc.RewriteRequest;
import com.google.cloud.storage.spi.v1.StorageRpc.RewriteResponse;
import com.google.cloud.storage.spi.StorageRpcFactory;
import com.google.common.collect.ImmutableMap;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class CopyWriterTest {

  private static final String SOURCE_BUCKET_NAME = "b";
  private static final String SOURCE_BLOB_NAME = "n";
  private static final String DESTINATION_BUCKET_NAME = "b1";
  private static final String DESTINATION_BLOB_NAME = "n1";
  private static final BlobId BLOB_ID = BlobId.of(SOURCE_BUCKET_NAME, SOURCE_BLOB_NAME);
  private static final BlobInfo BLOB_INFO =
      BlobInfo.newBuilder(DESTINATION_BUCKET_NAME, DESTINATION_BLOB_NAME).build();
  private static final BlobInfo RESULT_INFO =
      BlobInfo.newBuilder(DESTINATION_BUCKET_NAME, DESTINATION_BLOB_NAME).setContentType("type")
          .build();
  private static final Map<StorageRpc.Option, ?> EMPTY_OPTIONS = ImmutableMap.of();
  private static final RewriteRequest REQUEST_WITH_OBJECT =
      new StorageRpc.RewriteRequest(BLOB_ID.toPb(), EMPTY_OPTIONS, true, BLOB_INFO.toPb(),
          EMPTY_OPTIONS, null);
  private static final RewriteRequest REQUEST_WITHOUT_OBJECT =
      new StorageRpc.RewriteRequest(BLOB_ID.toPb(), EMPTY_OPTIONS, false, BLOB_INFO.toPb(),
          EMPTY_OPTIONS, null);
  private static final RewriteResponse RESPONSE_WITH_OBJECT = new RewriteResponse(
      REQUEST_WITH_OBJECT, null, 42L, false, "token", 21L);
  private static final RewriteResponse RESPONSE_WITHOUT_OBJECT = new RewriteResponse(
      REQUEST_WITHOUT_OBJECT, null, 42L, false, "token", 21L);
  private static final RewriteResponse RESPONSE_WITH_OBJECT_DONE =
      new RewriteResponse(REQUEST_WITH_OBJECT, RESULT_INFO.toPb(), 42L, true, "token", 42L);
  private static final RewriteResponse RESPONSE_WITHOUT_OBJECT_DONE =
      new RewriteResponse(REQUEST_WITHOUT_OBJECT, RESULT_INFO.toPb(), 42L, true, "token", 42L);

  private StorageOptions options;
  private StorageRpcFactory rpcFactoryMock;
  private StorageRpc storageRpcMock;
  private CopyWriter copyWriter;
  private Blob result;

  @Before
  public void setUp() {
    rpcFactoryMock = createMock(StorageRpcFactory.class);
    storageRpcMock = createMock(StorageRpc.class);
    expect(rpcFactoryMock.create(anyObject(StorageOptions.class)))
        .andReturn(storageRpcMock);
    replay(rpcFactoryMock);
    options = StorageOptions.newBuilder()
        .setProjectId("projectid")
        .setServiceRpcFactory(rpcFactoryMock)
        .setRetrySettings(ServiceOptions.getNoRetrySettings())
        .build();
    result = new Blob(options.getService(), new BlobInfo.BuilderImpl(RESULT_INFO));
  }

  @After
  public void tearDown() throws Exception {
    verify(rpcFactoryMock, storageRpcMock);
  }

  @Test
  public void testRewriteWithObject() {
    EasyMock.expect(storageRpcMock.continueRewrite(RESPONSE_WITH_OBJECT))
        .andReturn(RESPONSE_WITH_OBJECT_DONE);
    EasyMock.replay(storageRpcMock);
    copyWriter = new CopyWriter(options, RESPONSE_WITH_OBJECT);
    assertEquals(result, copyWriter.getResult());
    assertTrue(copyWriter.isDone());
    assertEquals(42L, copyWriter.getTotalBytesCopied());
    assertEquals(42L, copyWriter.getBlobSize());
  }

  @Test
  public void testRewriteWithoutObject() {
    EasyMock.expect(storageRpcMock.continueRewrite(RESPONSE_WITHOUT_OBJECT))
        .andReturn(RESPONSE_WITHOUT_OBJECT_DONE);
    EasyMock.replay(storageRpcMock);
    copyWriter = new CopyWriter(options, RESPONSE_WITHOUT_OBJECT);
    assertEquals(result, copyWriter.getResult());
    assertTrue(copyWriter.isDone());
    assertEquals(42L, copyWriter.getTotalBytesCopied());
    assertEquals(42L, copyWriter.getBlobSize());
  }

  @Test
  public void testRewriteWithObjectMultipleRequests() {
    EasyMock.expect(storageRpcMock.continueRewrite(RESPONSE_WITH_OBJECT))
        .andReturn(RESPONSE_WITH_OBJECT);
    EasyMock.expect(storageRpcMock.continueRewrite(RESPONSE_WITH_OBJECT))
        .andReturn(RESPONSE_WITH_OBJECT_DONE);
    EasyMock.replay(storageRpcMock);
    copyWriter = new CopyWriter(options, RESPONSE_WITH_OBJECT);
    assertEquals(result, copyWriter.getResult());
    assertTrue(copyWriter.isDone());
    assertEquals(42L, copyWriter.getTotalBytesCopied());
    assertEquals(42L, copyWriter.getBlobSize());
  }

  @Test
  public void testRewriteWithoutObjectMultipleRequests() {
    EasyMock.expect(storageRpcMock.continueRewrite(RESPONSE_WITHOUT_OBJECT))
        .andReturn(RESPONSE_WITHOUT_OBJECT);
    EasyMock.expect(storageRpcMock.continueRewrite(RESPONSE_WITHOUT_OBJECT))
        .andReturn(RESPONSE_WITHOUT_OBJECT_DONE);
    EasyMock.replay(storageRpcMock);
    copyWriter = new CopyWriter(options, RESPONSE_WITHOUT_OBJECT);
    assertEquals(result, copyWriter.getResult());
    assertTrue(copyWriter.isDone());
    assertEquals(42L, copyWriter.getTotalBytesCopied());
    assertEquals(42L, copyWriter.getBlobSize());
  }

  @Test
  public void testSaveAndRestoreWithObject() {
    EasyMock.expect(storageRpcMock.continueRewrite(RESPONSE_WITH_OBJECT))
        .andReturn(RESPONSE_WITH_OBJECT);
    EasyMock.expect(storageRpcMock.continueRewrite(RESPONSE_WITH_OBJECT))
        .andReturn(RESPONSE_WITH_OBJECT_DONE);
    EasyMock.replay(storageRpcMock);
    copyWriter = new CopyWriter(options, RESPONSE_WITH_OBJECT);
    copyWriter.copyChunk();
    assertTrue(!copyWriter.isDone());
    assertEquals(21L, copyWriter.getTotalBytesCopied());
    assertEquals(42L, copyWriter.getBlobSize());
    RestorableState<CopyWriter> rewriterState = copyWriter.capture();
    CopyWriter restoredRewriter = rewriterState.restore();
    assertEquals(result, restoredRewriter.getResult());
    assertTrue(restoredRewriter.isDone());
    assertEquals(42L, restoredRewriter.getTotalBytesCopied());
    assertEquals(42L, restoredRewriter.getBlobSize());
  }

  @Test
  public void testSaveAndRestoreWithoutObject() {
    EasyMock.expect(storageRpcMock.continueRewrite(RESPONSE_WITHOUT_OBJECT))
        .andReturn(RESPONSE_WITHOUT_OBJECT);
    EasyMock.expect(storageRpcMock.continueRewrite(RESPONSE_WITHOUT_OBJECT))
        .andReturn(RESPONSE_WITHOUT_OBJECT_DONE);
    EasyMock.replay(storageRpcMock);
    copyWriter = new CopyWriter(options, RESPONSE_WITHOUT_OBJECT);
    copyWriter.copyChunk();
    assertTrue(!copyWriter.isDone());
    assertEquals(21L, copyWriter.getTotalBytesCopied());
    assertEquals(42L, copyWriter.getBlobSize());
    RestorableState<CopyWriter> rewriterState = copyWriter.capture();
    CopyWriter restoredRewriter = rewriterState.restore();
    assertEquals(result, restoredRewriter.getResult());
    assertTrue(restoredRewriter.isDone());
    assertEquals(42L, restoredRewriter.getTotalBytesCopied());
    assertEquals(42L, restoredRewriter.getBlobSize());
  }

  @Test
  public void testSaveAndRestoreWithResult() {
    EasyMock.expect(storageRpcMock.continueRewrite(RESPONSE_WITH_OBJECT))
        .andReturn(RESPONSE_WITH_OBJECT_DONE);
    EasyMock.replay(storageRpcMock);
    copyWriter = new CopyWriter(options, RESPONSE_WITH_OBJECT);
    copyWriter.copyChunk();
    assertEquals(result, copyWriter.getResult());
    assertTrue(copyWriter.isDone());
    assertEquals(42L, copyWriter.getTotalBytesCopied());
    assertEquals(42L, copyWriter.getBlobSize());
    RestorableState<CopyWriter> rewriterState = copyWriter.capture();
    CopyWriter restoredRewriter = rewriterState.restore();
    assertEquals(result, restoredRewriter.getResult());
    assertTrue(restoredRewriter.isDone());
    assertEquals(42L, restoredRewriter.getTotalBytesCopied());
    assertEquals(42L, restoredRewriter.getBlobSize());
  }
}
