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

import com.google.api.services.storage.model.RewriteResponse;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import com.google.common.collect.ImmutableMap;
import com.google.gcloud.RetryParams;
import com.google.gcloud.spi.StorageRpc;

import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.Before;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Map;
import org.junit.After;

public class BlobRewriterTest {

  private static final String SOURCE_BUCKET_NAME = "b";
  private static final String SOURCE_BLOB_NAME = "n";
  private static final String DESTINATION_BUCKET_NAME = "b1";
  private static final String DESTINATION_BLOB_NAME = "n1";
  private static final BlobId BLOB_ID = BlobId.of(SOURCE_BUCKET_NAME, SOURCE_BLOB_NAME);
  private static final BlobInfo BLOB_INFO =
      BlobInfo.builder(DESTINATION_BUCKET_NAME, DESTINATION_BLOB_NAME).build();
  private static final Map<StorageRpc.Option, ?> EMPTY_OPTIONS = ImmutableMap.of();

  private StorageOptions optionsMock;
  private StorageRpc storageRpcMock;
  private BlobRewriter rewriter;

  @Before
  public void setUp() throws IOException, InterruptedException {
    optionsMock = EasyMock.createMock(StorageOptions.class);
    storageRpcMock = EasyMock.createMock(StorageRpc.class);
  }

  @After
  public void tearDown() throws Exception {
    verify(optionsMock, storageRpcMock);
  }

  @Test
  public void testRewrite() {
    RewriteResponse response = new RewriteResponse()
        .setDone(true)
        .setResource(BLOB_INFO.toPb())
        .setObjectSize(BigInteger.valueOf(42L))
        .setTotalBytesRewritten(BigInteger.valueOf(42L));
    EasyMock.expect(optionsMock.storageRpc()).andReturn(storageRpcMock);
    EasyMock.expect(optionsMock.retryParams()).andReturn(RetryParams.noRetries());
    EasyMock.expect(storageRpcMock.rewrite(
        BLOB_ID.toPb(), EMPTY_OPTIONS, BLOB_INFO.toPb(), EMPTY_OPTIONS, null, null))
        .andReturn(response);
    EasyMock.replay(optionsMock, storageRpcMock);
    rewriter = BlobRewriter.builder(optionsMock, BLOB_ID, EMPTY_OPTIONS, BLOB_INFO, EMPTY_OPTIONS)
        .isDone(false)
        .build();
    rewriter.copyChunk();
    assertTrue(rewriter.isDone());
    assertEquals(BLOB_INFO, rewriter.target());
    assertEquals(BLOB_ID, rewriter.source());
    assertEquals(BigInteger.valueOf(42L), rewriter.totalBytesRewritten());
    assertEquals(BigInteger.valueOf(42L), rewriter.blobSize());
  }

  @Test
  public void testRewriteCustumSize() {
    RewriteResponse response = new RewriteResponse()
        .setDone(true)
        .setResource(BLOB_INFO.toPb())
        .setObjectSize(BigInteger.valueOf(42L))
        .setTotalBytesRewritten(BigInteger.valueOf(42L));
    EasyMock.expect(optionsMock.storageRpc()).andReturn(storageRpcMock);
    EasyMock.expect(optionsMock.retryParams()).andReturn(RetryParams.noRetries());
    EasyMock.expect(storageRpcMock.rewrite(
        BLOB_ID.toPb(), EMPTY_OPTIONS, BLOB_INFO.toPb(), EMPTY_OPTIONS, null, 1048576L))
        .andReturn(response);
    EasyMock.replay(optionsMock, storageRpcMock);
    rewriter = BlobRewriter.builder(optionsMock, BLOB_ID, EMPTY_OPTIONS, BLOB_INFO, EMPTY_OPTIONS)
        .isDone(false)
        .maxBytesRewrittenPerCall(1048576L)
        .build();
    rewriter.copyChunk();
    assertTrue(rewriter.isDone());
    assertEquals(BLOB_INFO, rewriter.target());
    assertEquals(BLOB_ID, rewriter.source());
    assertEquals(BigInteger.valueOf(42L), rewriter.totalBytesRewritten());
    assertEquals(BigInteger.valueOf(42L), rewriter.blobSize());
  }

  @Test
  public void testRewriteMultipleRequests() {
    RewriteResponse firstResponse = new RewriteResponse()
        .setDone(false)
        .setResource(BLOB_INFO.toPb())
        .setObjectSize(BigInteger.valueOf(42L))
        .setRewriteToken("token")
        .setTotalBytesRewritten(BigInteger.valueOf(21L));
    RewriteResponse secondResponse = new RewriteResponse()
        .setDone(true)
        .setResource(BLOB_INFO.toPb())
        .setObjectSize(BigInteger.valueOf(42L))
        .setTotalBytesRewritten(BigInteger.valueOf(42L));
    EasyMock.expect(optionsMock.storageRpc()).andReturn(storageRpcMock);
    EasyMock.expect(optionsMock.retryParams()).andReturn(RetryParams.noRetries()).times(2);
    EasyMock.expect(storageRpcMock.rewrite(
        BLOB_ID.toPb(), EMPTY_OPTIONS, BLOB_INFO.toPb(), EMPTY_OPTIONS, null, null))
        .andReturn(firstResponse);
    EasyMock.expect(storageRpcMock.rewrite(
        BLOB_ID.toPb(), EMPTY_OPTIONS, BLOB_INFO.toPb(), EMPTY_OPTIONS, "token", null))
        .andReturn(secondResponse);
    EasyMock.replay(optionsMock, storageRpcMock);
    rewriter = BlobRewriter.builder(optionsMock, BLOB_ID, EMPTY_OPTIONS, BLOB_INFO, EMPTY_OPTIONS)
        .isDone(false)
        .build();
    int loopCount = 0;
    while (!rewriter.isDone()) {
      rewriter.copyChunk();
      loopCount++;
    }
    assertTrue(rewriter.isDone());
    assertEquals(BLOB_INFO, rewriter.target());
    assertEquals(BLOB_ID, rewriter.source());
    assertEquals(BigInteger.valueOf(42L), rewriter.totalBytesRewritten());
    assertEquals(BigInteger.valueOf(42L), rewriter.blobSize());
    assertEquals(2, loopCount);
  }
}
