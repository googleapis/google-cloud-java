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
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.common.collect.ImmutableList;
import com.google.gcloud.Page;
import com.google.gcloud.PageImpl;
import com.google.gcloud.storage.BatchResponse.Result;

import org.easymock.Capture;
import org.junit.After;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class BucketTest {

  private static final BucketInfo BUCKET_INFO = BucketInfo.builder("b").metageneration(42L).build();
  private static final String CONTENT_TYPE = "text/plain";

  private Storage storage;
  private Storage serviceMockReturnsOptions = createMock(Storage.class);
  private StorageOptions mockOptions = createMock(StorageOptions.class);
  private Bucket bucket;
  private Bucket expectedBucket;
  private Iterable<Blob> blobResults;

  @After
  public void tearDown() throws Exception {
    verify(storage);
  }

  private void initializeExpectedBucket(int optionsCalls) {
    expect(serviceMockReturnsOptions.options()).andReturn(mockOptions).times(optionsCalls);
    replay(serviceMockReturnsOptions);
    storage = createStrictMock(Storage.class);
    expectedBucket = new Bucket(serviceMockReturnsOptions, new BucketInfo.BuilderImpl(BUCKET_INFO));
    blobResults = ImmutableList.of(
        new Blob(
            serviceMockReturnsOptions,
            new BlobInfo.BuilderImpl(BlobInfo.builder("b", "n1").build())),
        new Blob(
            serviceMockReturnsOptions,
            new BlobInfo.BuilderImpl(BlobInfo.builder("b", "n2").build())),
        new Blob(
            serviceMockReturnsOptions,
            new BlobInfo.BuilderImpl(BlobInfo.builder("b", "n3").build())));
  }

  private void initializeBucket() {
    bucket = new Bucket(storage, new BucketInfo.BuilderImpl(BUCKET_INFO));
  }

  @Test
  public void testExists_True() throws Exception {
    initializeExpectedBucket(4);
    Storage.BucketGetOption[] expectedOptions = {Storage.BucketGetOption.fields()};
    expect(storage.options()).andReturn(mockOptions);
    expect(storage.get(BUCKET_INFO.name(), expectedOptions)).andReturn(expectedBucket);
    replay(storage);
    initializeBucket();
    assertTrue(bucket.exists());
  }

  @Test
  public void testExists_False() throws Exception {
    initializeExpectedBucket(4);
    Storage.BucketGetOption[] expectedOptions = {Storage.BucketGetOption.fields()};
    expect(storage.options()).andReturn(mockOptions);
    expect(storage.get(BUCKET_INFO.name(), expectedOptions)).andReturn(null);
    replay(storage);
    initializeBucket();
    assertFalse(bucket.exists());
  }

  @Test
  public void testReload() throws Exception {
    initializeExpectedBucket(5);
    BucketInfo updatedInfo = BUCKET_INFO.toBuilder().notFoundPage("p").build();
    Bucket expectedUpdatedBucket =
        new Bucket(serviceMockReturnsOptions, new BucketInfo.BuilderImpl(updatedInfo));
    expect(storage.options()).andReturn(mockOptions);
    expect(storage.get(updatedInfo.name())).andReturn(expectedUpdatedBucket);
    replay(storage);
    initializeBucket();
    Bucket updatedBucket = bucket.reload();
    assertEquals(expectedUpdatedBucket, updatedBucket);
  }

  @Test
  public void testReloadNull() throws Exception {
    initializeExpectedBucket(4);
    expect(storage.options()).andReturn(mockOptions);
    expect(storage.get(BUCKET_INFO.name())).andReturn(null);
    replay(storage);
    initializeBucket();
    assertNull(bucket.reload());
  }

  @Test
  public void testReloadWithOptions() throws Exception {
    initializeExpectedBucket(5);
    BucketInfo updatedInfo = BUCKET_INFO.toBuilder().notFoundPage("p").build();
    Bucket expectedUpdatedBucket =
        new Bucket(serviceMockReturnsOptions, new BucketInfo.BuilderImpl(updatedInfo));
    expect(storage.options()).andReturn(mockOptions);
    expect(storage.get(updatedInfo.name(), Storage.BucketGetOption.metagenerationMatch(42L)))
        .andReturn(expectedUpdatedBucket);
    replay(storage);
    initializeBucket();
    Bucket updatedBucket = bucket.reload(Bucket.BucketSourceOption.metagenerationMatch());
    assertEquals(expectedUpdatedBucket, updatedBucket);
  }

  @Test
  public void testUpdate() throws Exception {
    initializeExpectedBucket(5);
    Bucket expectedUpdatedBucket = expectedBucket.toBuilder().notFoundPage("p").build();
    expect(storage.options()).andReturn(mockOptions).times(2);
    expect(storage.update(expectedUpdatedBucket)).andReturn(expectedUpdatedBucket);
    replay(storage);
    initializeBucket();
    Bucket updatedBucket = new Bucket(storage, new BucketInfo.BuilderImpl(expectedUpdatedBucket));
    Bucket actualUpdatedBucket = updatedBucket.update();
    assertEquals(expectedUpdatedBucket, actualUpdatedBucket);
  }

  @Test
  public void testDelete() throws Exception {
    initializeExpectedBucket(4);
    expect(storage.options()).andReturn(mockOptions);
    expect(storage.delete(BUCKET_INFO.name())).andReturn(true);
    replay(storage);
    initializeBucket();
    assertTrue(bucket.delete());
  }

  @Test
  public void testList() throws Exception {
    initializeExpectedBucket(4);
    PageImpl<Blob> expectedBlobPage = new PageImpl<>(null, "c", blobResults);
    expect(storage.options()).andReturn(mockOptions);
    expect(storage.list(BUCKET_INFO.name())).andReturn(expectedBlobPage);
    replay(storage);
    initializeBucket();
    Page<Blob> blobPage = bucket.list();
    Iterator<Blob> blobInfoIterator = blobPage.values().iterator();
    Iterator<Blob> blobIterator = blobPage.values().iterator();
    while (blobInfoIterator.hasNext() && blobIterator.hasNext()) {
      assertEquals(blobInfoIterator.next(), blobIterator.next());
    }
    assertFalse(blobInfoIterator.hasNext());
    assertFalse(blobIterator.hasNext());
    assertEquals(expectedBlobPage.nextPageCursor(), blobPage.nextPageCursor());
  }

  @Test
  public void testGet() throws Exception {
    initializeExpectedBucket(5);
    Blob expectedBlob = new Blob(
        serviceMockReturnsOptions, new BlobInfo.BuilderImpl(BlobInfo.builder("b", "n").build()));
    expect(storage.options()).andReturn(mockOptions);
    expect(storage.get(BlobId.of(expectedBucket.name(), "n"), new Storage.BlobGetOption[0]))
        .andReturn(expectedBlob);
    replay(storage);
    initializeBucket();
    Blob blob = bucket.get("n");
    assertEquals(expectedBlob, blob);
  }

  @Test
  public void testGetAll() throws Exception {
    initializeExpectedBucket(4);
    Capture<BatchRequest> capturedBatchRequest = Capture.newInstance();
    List<Result<Blob>> batchResultList = new LinkedList<>();
    for (Blob info : blobResults) {
      batchResultList.add(new Result<>(info));
    }
    BatchResponse response = new BatchResponse(Collections.<Result<Boolean>>emptyList(),
        Collections.<Result<Blob>>emptyList(), batchResultList);
    expect(storage.options()).andReturn(mockOptions);
    expect(storage.submit(capture(capturedBatchRequest))).andReturn(response);
    expect(storage.options()).andReturn(mockOptions).times(3);
    replay(storage);
    initializeBucket();
    List<Blob> blobs = bucket.get("n1", "n2", "n3");
    Set<BlobId> blobInfoSet = capturedBatchRequest.getValue().toGet().keySet();
    assertEquals(batchResultList.size(), blobInfoSet.size());
    for (BlobInfo info : blobResults) {
      assertTrue(blobInfoSet.contains(info.blobId()));
    }
    Iterator<Blob> blobIterator = blobs.iterator();
    Iterator<Result<Blob>> batchResultIterator = response.gets().iterator();
    while (batchResultIterator.hasNext() && blobIterator.hasNext()) {
      assertEquals(batchResultIterator.next().get(), blobIterator.next());
    }
    assertFalse(batchResultIterator.hasNext());
    assertFalse(blobIterator.hasNext());
  }

  @Test
  public void testCreate() throws Exception {
    initializeExpectedBucket(5);
    BlobInfo info = BlobInfo.builder("b", "n").contentType(CONTENT_TYPE).build();
    Blob expectedBlob = new Blob(serviceMockReturnsOptions, new BlobInfo.BuilderImpl(info));
    byte[] content = {0xD, 0xE, 0xA, 0xD};
    expect(storage.options()).andReturn(mockOptions);
    expect(storage.create(info, content)).andReturn(expectedBlob);
    replay(storage);
    initializeBucket();
    Blob blob = bucket.create("n", content, CONTENT_TYPE);
    assertEquals(expectedBlob, blob);
  }

  @Test
  public void testCreateNullContentType() throws Exception {
    initializeExpectedBucket(5);
    BlobInfo info = BlobInfo.builder("b", "n").contentType(Storage.DEFAULT_CONTENT_TYPE).build();
    Blob expectedBlob = new Blob(serviceMockReturnsOptions, new BlobInfo.BuilderImpl(info));
    byte[] content = {0xD, 0xE, 0xA, 0xD};
    expect(storage.options()).andReturn(mockOptions);
    expect(storage.create(info, content)).andReturn(expectedBlob);
    replay(storage);
    initializeBucket();
    Blob blob = bucket.create("n", content, null);
    assertEquals(expectedBlob, blob);
  }

  @Test
  public void testCreateFromStream() throws Exception {
    initializeExpectedBucket(5);
    BlobInfo info = BlobInfo.builder("b", "n").contentType(CONTENT_TYPE).build();
    Blob expectedBlob = new Blob(serviceMockReturnsOptions, new BlobInfo.BuilderImpl(info));
    byte[] content = {0xD, 0xE, 0xA, 0xD};
    InputStream streamContent = new ByteArrayInputStream(content);
    expect(storage.options()).andReturn(mockOptions);
    expect(storage.create(info, streamContent)).andReturn(expectedBlob);
    replay(storage);
    initializeBucket();
    Blob blob = bucket.create("n", streamContent, CONTENT_TYPE);
    assertEquals(expectedBlob, blob);
  }

  @Test
  public void testCreateFromStreamNullContentType() throws Exception {
    initializeExpectedBucket(5);
    BlobInfo info = BlobInfo.builder("b", "n").contentType(Storage.DEFAULT_CONTENT_TYPE).build();
    Blob expectedBlob = new Blob(serviceMockReturnsOptions, new BlobInfo.BuilderImpl(info));
    byte[] content = {0xD, 0xE, 0xA, 0xD};
    InputStream streamContent = new ByteArrayInputStream(content);
    expect(storage.options()).andReturn(mockOptions);
    expect(storage.create(info, streamContent)).andReturn(expectedBlob);
    replay(storage);
    initializeBucket();
    Blob blob = bucket.create("n", streamContent, null);
    assertEquals(expectedBlob, blob);
  }
}
