/*
 * Copyright 2024 Google LLC
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.cloud.RestorableState;
import com.google.cloud.ServiceOptions;
import com.google.cloud.storage.Retrying.Retrier;
import com.google.cloud.storage.spi.StorageRpcFactory;
import com.google.cloud.storage.spi.v1.StorageRpc;
import com.google.cloud.storage.spi.v1.StorageRpc.RewriteRequest;
import com.google.cloud.storage.spi.v1.StorageRpc.RewriteResponse;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class CopyWriterTest {

  private static final String SOURCE_BUCKET_NAME = "b";
  private static final String SOURCE_BLOB_NAME = "n";
  private static final String DESTINATION_BUCKET_NAME = "b1";
  private static final String DESTINATION_BLOB_NAME = "n1";
  private static final BlobId BLOB_ID = BlobId.of(SOURCE_BUCKET_NAME, SOURCE_BLOB_NAME);
  private static final BlobInfo BLOB_INFO =
      BlobInfo.newBuilder(DESTINATION_BUCKET_NAME, DESTINATION_BLOB_NAME).build();
  private static final BlobInfo RESULT_INFO =
      BlobInfo.newBuilder(DESTINATION_BUCKET_NAME, DESTINATION_BLOB_NAME)
          .setContentType("type")
          .build();
  private static final Map<StorageRpc.Option, ?> EMPTY_OPTIONS = ImmutableMap.of();
  private static final RewriteRequest REQUEST_WITH_OBJECT =
      new StorageRpc.RewriteRequest(
          Conversions.json().blobId().encode(BLOB_ID),
          EMPTY_OPTIONS,
          true,
          Conversions.json().blobInfo().encode(BLOB_INFO),
          EMPTY_OPTIONS,
          null);
  private static final RewriteRequest REQUEST_WITHOUT_OBJECT =
      new StorageRpc.RewriteRequest(
          Conversions.json().blobId().encode(BLOB_ID),
          EMPTY_OPTIONS,
          false,
          Conversions.json().blobInfo().encode(BLOB_INFO),
          EMPTY_OPTIONS,
          null);
  private static final RewriteResponse RESPONSE_WITH_OBJECT =
      new RewriteResponse(REQUEST_WITH_OBJECT, null, 42L, false, "token", 21L);
  private static final RewriteResponse RESPONSE_WITHOUT_OBJECT =
      new RewriteResponse(REQUEST_WITHOUT_OBJECT, null, 42L, false, "token", 21L);
  private static final RewriteResponse RESPONSE_WITH_OBJECT_DONE =
      new RewriteResponse(
          REQUEST_WITH_OBJECT,
          Conversions.json().blobInfo().encode(RESULT_INFO),
          42L,
          true,
          "token",
          42L);
  private static final RewriteResponse RESPONSE_WITHOUT_OBJECT_DONE =
      new RewriteResponse(
          REQUEST_WITHOUT_OBJECT,
          Conversions.json().blobInfo().encode(RESULT_INFO),
          42L,
          true,
          "token",
          42L);

  private HttpStorageOptions options;
  private StorageRpcFactory rpcFactoryMock;
  private StorageRpc storageRpcMock;
  private CopyWriter copyWriter;
  private Blob result;

  @Before
  public void setUp() {
    rpcFactoryMock = Mockito.mock(StorageRpcFactory.class);
    storageRpcMock = Mockito.mock(StorageRpc.class);
    when(rpcFactoryMock.create(any(StorageOptions.class))).thenReturn(storageRpcMock);
    options =
        HttpStorageOptions.newBuilder()
            .setProjectId("projectid")
            .setServiceRpcFactory(rpcFactoryMock)
            .setRetrySettings(ServiceOptions.getNoRetrySettings())
            .build();
    result = new Blob(options.getService(), new BlobInfo.BuilderImpl(RESULT_INFO));
    verify(rpcFactoryMock).create(any(StorageOptions.class));
  }

  @Test
  public void testRewriteWithObject() {
    when(storageRpcMock.continueRewrite(RESPONSE_WITH_OBJECT))
        .thenReturn(RESPONSE_WITH_OBJECT_DONE);
    copyWriter = new HttpCopyWriter(options, RESPONSE_WITH_OBJECT, Retrier.attemptOnce());
    assertEquals(result, copyWriter.getResult());
    assertTrue(copyWriter.isDone());
    assertEquals(42L, copyWriter.getTotalBytesCopied());
    assertEquals(42L, copyWriter.getBlobSize());
    verify(storageRpcMock).continueRewrite(RESPONSE_WITH_OBJECT);
  }

  @Test
  public void testRewriteWithoutObject() {
    when(storageRpcMock.continueRewrite(RESPONSE_WITHOUT_OBJECT))
        .thenReturn(RESPONSE_WITHOUT_OBJECT_DONE);
    copyWriter = new HttpCopyWriter(options, RESPONSE_WITHOUT_OBJECT, Retrier.attemptOnce());
    assertEquals(result, copyWriter.getResult());
    assertTrue(copyWriter.isDone());
    assertEquals(42L, copyWriter.getTotalBytesCopied());
    assertEquals(42L, copyWriter.getBlobSize());
    verify(storageRpcMock).continueRewrite(RESPONSE_WITHOUT_OBJECT);
  }

  @Test
  public void testRewriteWithObjectMultipleRequests() {
    when(storageRpcMock.continueRewrite(RESPONSE_WITH_OBJECT))
        .thenReturn(RESPONSE_WITH_OBJECT, RESPONSE_WITHOUT_OBJECT_DONE);
    copyWriter = new HttpCopyWriter(options, RESPONSE_WITH_OBJECT, Retrier.attemptOnce());
    assertEquals(result, copyWriter.getResult());
    assertTrue(copyWriter.isDone());
    assertEquals(42L, copyWriter.getTotalBytesCopied());
    assertEquals(42L, copyWriter.getBlobSize());
    verify(storageRpcMock, times(2)).continueRewrite(RESPONSE_WITH_OBJECT);
  }

  @Test
  public void testRewriteWithoutObjectMultipleRequests() {
    when(storageRpcMock.continueRewrite(RESPONSE_WITHOUT_OBJECT))
        .thenReturn(RESPONSE_WITHOUT_OBJECT, RESPONSE_WITHOUT_OBJECT_DONE);
    copyWriter = new HttpCopyWriter(options, RESPONSE_WITHOUT_OBJECT, Retrier.attemptOnce());
    assertEquals(result, copyWriter.getResult());
    assertTrue(copyWriter.isDone());
    assertEquals(42L, copyWriter.getTotalBytesCopied());
    assertEquals(42L, copyWriter.getBlobSize());
    verify(storageRpcMock, times(2)).continueRewrite(RESPONSE_WITHOUT_OBJECT);
  }

  @Test
  public void testSaveAndRestoreWithObject() {
    when(storageRpcMock.continueRewrite(RESPONSE_WITH_OBJECT))
        .thenReturn(RESPONSE_WITH_OBJECT, RESPONSE_WITH_OBJECT_DONE);
    copyWriter = new HttpCopyWriter(options, RESPONSE_WITH_OBJECT, Retrier.attemptOnce());
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
    verify(storageRpcMock, times(2)).continueRewrite(RESPONSE_WITH_OBJECT);
  }

  @Test
  public void testSaveAndRestoreWithoutObject() {
    when(storageRpcMock.continueRewrite(RESPONSE_WITHOUT_OBJECT))
        .thenReturn(RESPONSE_WITHOUT_OBJECT, RESPONSE_WITHOUT_OBJECT_DONE);
    copyWriter = new HttpCopyWriter(options, RESPONSE_WITHOUT_OBJECT, Retrier.attemptOnce());
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
    verify(storageRpcMock, times(2)).continueRewrite(RESPONSE_WITHOUT_OBJECT);
  }

  @Test
  public void testSaveAndRestoreWithResult() {
    when(storageRpcMock.continueRewrite(RESPONSE_WITH_OBJECT))
        .thenReturn(RESPONSE_WITH_OBJECT_DONE);
    copyWriter = new HttpCopyWriter(options, RESPONSE_WITH_OBJECT, Retrier.attemptOnce());
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
    verify(storageRpcMock).continueRewrite(RESPONSE_WITH_OBJECT);
  }
}
