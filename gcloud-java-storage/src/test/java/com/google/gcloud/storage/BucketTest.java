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

import static org.easymock.EasyMock.capture;
import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.google.common.collect.ImmutableList;
import com.google.gcloud.storage.BatchResponse.Result;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.easymock.Capture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BucketTest {

  private static final BucketInfo BUCKET_INFO = BucketInfo.of("b");
  private static final Iterable<BlobInfo> BLOB_INFO_RESULTS = ImmutableList.of(
      BlobInfo.builder("b", "n1").build(),
      BlobInfo.builder("b", "n2").build(),
      BlobInfo.builder("b", "n3").build());

  private Storage storage;
  private Bucket bucket;

  @Before
  public void setUp() throws Exception {
    storage = createStrictMock(Storage.class);
    bucket = new Bucket(storage, BUCKET_INFO);
  }

  @After
  public void tearDown() throws Exception {
    verify(storage);
  }

  @Test
  public void testInfo() throws Exception {
    assertEquals(BUCKET_INFO, bucket.info());
    replay(storage);
  }

  @Test
  public void testExists_True() throws Exception {
    expect(storage.get(BUCKET_INFO.name())).andReturn(BUCKET_INFO);
    replay(storage);
    assertTrue(bucket.exists());
  }

  @Test
  public void testExists_False() throws Exception {
    expect(storage.get(BUCKET_INFO.name())).andReturn(null);
    replay(storage);
    assertFalse(bucket.exists());
  }

  @Test
  public void testReload() throws Exception {
    BucketInfo updatedInfo = BUCKET_INFO.toBuilder().notFoundPage("p").build();
    expect(storage.get(updatedInfo.name())).andReturn(updatedInfo);
    replay(storage);
    Bucket updatedBucket = bucket.reload();
    assertSame(storage, bucket.storage());
    assertEquals(updatedInfo, updatedBucket.info());
  }

  @Test
  public void testUpdate() throws Exception {
    BucketInfo updatedInfo = BUCKET_INFO.toBuilder().notFoundPage("p").build();
    expect(storage.update(updatedInfo)).andReturn(updatedInfo);
    replay(storage);
    Bucket updatedBucket = bucket.update(updatedInfo);
    assertSame(storage, bucket.storage());
    assertEquals(updatedInfo, updatedBucket.info());
  }

  @Test
  public void testDelete() throws Exception {
    expect(storage.delete(BUCKET_INFO.name())).andReturn(true);
    replay(storage);
    assertTrue(bucket.delete());
  }

  @Test
  public void testList() throws Exception {
    BaseListResult<BlobInfo> blobInfoResult = new BaseListResult<>(null, "c", BLOB_INFO_RESULTS);
    expect(storage.list(BUCKET_INFO.name())).andReturn(blobInfoResult);
    replay(storage);
    ListResult<Blob> blobResult = bucket.list();
    Iterator<BlobInfo> blobInfoIterator = blobInfoResult.iterator();
    Iterator<Blob> blobIterator = blobResult.iterator();
    while (blobInfoIterator.hasNext() && blobIterator.hasNext()) {
      assertEquals(blobInfoIterator.next(), blobIterator.next().info());
    }
    assertFalse(blobInfoIterator.hasNext());
    assertFalse(blobIterator.hasNext());
    assertEquals(blobInfoResult.nextPageCursor(), blobResult.nextPageCursor());
  }

  @Test
  public void testGet() throws Exception {
    BlobInfo info = BlobInfo.builder("b", "n").build();
    expect(storage.get(BlobId.of(bucket.info().name(), "n"), new Storage.BlobSourceOption[0]))
        .andReturn(info);
    replay(storage);
    Blob blob = bucket.get("n");
    assertEquals(info, blob.info());
  }

  @Test
  public void testGetAll() throws Exception {
    Capture<BatchRequest> capturedBatchRequest = Capture.newInstance();
    List<Result<BlobInfo>> batchResultList = new LinkedList<>();
    for (BlobInfo info : BLOB_INFO_RESULTS) {
      batchResultList.add(new Result<>(info));
    }
    BatchResponse response =
        new BatchResponse(Collections.EMPTY_LIST, Collections.EMPTY_LIST, batchResultList);
    expect(storage.apply(capture(capturedBatchRequest))).andReturn(response);
    replay(storage);
    List<Blob> blobs = bucket.get("n1", "n2", "n3");
    Set<BlobId> blobInfoSet = capturedBatchRequest.getValue().toGet().keySet();
    assertEquals(batchResultList.size(), blobInfoSet.size());
    for (BlobInfo info : BLOB_INFO_RESULTS) {
      assertTrue(blobInfoSet.contains(info.blobId()));
    }
    Iterator<Blob> blobIterator = blobs.iterator();
    Iterator<Result<BlobInfo>> batchResultIterator = response.gets().iterator();
    while (batchResultIterator.hasNext() && blobIterator.hasNext()) {
      assertEquals(batchResultIterator.next().get(), blobIterator.next().info());
    }
    assertFalse(batchResultIterator.hasNext());
    assertFalse(blobIterator.hasNext());
  }

  @Test
  public void testCreate() throws Exception {
    BlobInfo info = BlobInfo.builder("b", "n").build();
    byte[] content = {0xD, 0xE, 0xA, 0xD};
    expect(storage.create(info, content)).andReturn(info);
    replay(storage);
    Blob blob = bucket.create("n", content);
    assertEquals(info, blob.info());
  }

  @Test
  public void testLoad() throws Exception {
    expect(storage.get(BUCKET_INFO.name())).andReturn(BUCKET_INFO);
    replay(storage);
    Bucket loadedBucket = Bucket.load(storage, BUCKET_INFO.name());
    assertEquals(BUCKET_INFO, loadedBucket.info());
  }
}
