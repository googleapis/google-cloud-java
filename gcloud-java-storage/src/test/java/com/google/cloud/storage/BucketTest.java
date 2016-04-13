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

import static com.google.cloud.storage.Acl.Project.ProjectRole.VIEWERS;
import static com.google.cloud.storage.Acl.Role.READER;
import static com.google.cloud.storage.Acl.Role.WRITER;
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
import com.google.cloud.Page;
import com.google.cloud.PageImpl;
import com.google.cloud.storage.Acl.Project;
import com.google.cloud.storage.Acl.User;
import com.google.cloud.storage.BatchResponse.Result;
import com.google.cloud.storage.BucketInfo.AgeDeleteRule;
import com.google.cloud.storage.BucketInfo.DeleteRule;

import org.easymock.Capture;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class BucketTest {

  private static final List<Acl> ACL = ImmutableList.of(
      Acl.of(User.ofAllAuthenticatedUsers(), READER), Acl.of(new Project(VIEWERS, "p1"), WRITER));
  private static final String ETAG = "0xFF00";
  private static final String GENERATED_ID = "B/N:1";
  private static final Long META_GENERATION = 10L;
  private static final User OWNER = new User("user@gmail.com");
  private static final String SELF_LINK = "http://storage/b/n";
  private static final Long CREATE_TIME = System.currentTimeMillis();
  private static final List<Cors> CORS = Collections.singletonList(Cors.builder().build());
  private static final List<Acl> DEFAULT_ACL =
      Collections.singletonList(Acl.of(User.ofAllAuthenticatedUsers(), WRITER));
  private static final List<? extends DeleteRule> DELETE_RULES =
      Collections.singletonList(new AgeDeleteRule(5));
  private static final String INDEX_PAGE = "index.html";
  private static final String NOT_FOUND_PAGE = "error.html";
  private static final String LOCATION = "ASIA";
  private static final String STORAGE_CLASS = "STANDARD";
  private static final Boolean VERSIONING_ENABLED = true;
  private static final BucketInfo FULL_BUCKET_INFO = BucketInfo.builder("b")
      .acl(ACL)
      .etag(ETAG)
      .generatedId(GENERATED_ID)
      .metageneration(META_GENERATION)
      .owner(OWNER)
      .selfLink(SELF_LINK)
      .cors(CORS)
      .createTime(CREATE_TIME)
      .defaultAcl(DEFAULT_ACL)
      .deleteRules(DELETE_RULES)
      .indexPage(INDEX_PAGE)
      .notFoundPage(NOT_FOUND_PAGE)
      .location(LOCATION)
      .storageClass(STORAGE_CLASS)
      .versioningEnabled(VERSIONING_ENABLED)
      .build();
  private static final BucketInfo BUCKET_INFO = BucketInfo.builder("b").metageneration(42L).build();
  private static final String CONTENT_TYPE = "text/plain";

  private Storage storage;
  private Storage serviceMockReturnsOptions = createMock(Storage.class);
  private StorageOptions mockOptions = createMock(StorageOptions.class);
  private Bucket bucket;
  private Bucket expectedBucket;
  private Iterable<Blob> blobResults;

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Before
  public void setUp() {
    storage = createStrictMock(Storage.class);
  }

  @After
  public void tearDown() throws Exception {
    verify(storage);
  }

  private void initializeExpectedBucket(int optionsCalls) {
    expect(serviceMockReturnsOptions.options()).andReturn(mockOptions).times(optionsCalls);
    replay(serviceMockReturnsOptions);
    expectedBucket = new Bucket(serviceMockReturnsOptions, new BucketInfo.BuilderImpl(BUCKET_INFO));
    blobResults = ImmutableList.of(
        new Blob(serviceMockReturnsOptions,
            new BlobInfo.BuilderImpl(BlobInfo.builder("b", "n1").build())),
        new Blob(serviceMockReturnsOptions,
            new BlobInfo.BuilderImpl(BlobInfo.builder("b", "n2").build())),
        new Blob(serviceMockReturnsOptions,
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
  public void testCreateNoContentType() throws Exception {
    initializeExpectedBucket(5);
    BlobInfo info = BlobInfo.builder("b", "n").build();
    Blob expectedBlob = new Blob(serviceMockReturnsOptions, new BlobInfo.BuilderImpl(info));
    byte[] content = {0xD, 0xE, 0xA, 0xD};
    expect(storage.options()).andReturn(mockOptions);
    expect(storage.create(info, content)).andReturn(expectedBlob);
    replay(storage);
    initializeBucket();
    Blob blob = bucket.create("n", content);
    assertEquals(expectedBlob, blob);
  }

  @Test
  public void testCreateWithOptions() throws Exception {
    initializeExpectedBucket(5);
    BlobInfo info = BlobInfo.builder(BlobId.of("b", "n", 42L))
        .contentType(CONTENT_TYPE)
        .metageneration(24L)
        .build();
    Blob expectedBlob = new Blob(serviceMockReturnsOptions, new BlobInfo.BuilderImpl(info));
    byte[] content = {0xD, 0xE, 0xA, 0xD};
    Storage.PredefinedAcl acl = Storage.PredefinedAcl.ALL_AUTHENTICATED_USERS;
    expect(storage.options()).andReturn(mockOptions);
    expect(storage.create(info, content, Storage.BlobTargetOption.generationMatch(),
        Storage.BlobTargetOption.metagenerationMatch(),
        Storage.BlobTargetOption.predefinedAcl(acl))).andReturn(expectedBlob);
    replay(storage);
    initializeBucket();
    Blob blob = bucket.create("n", content, CONTENT_TYPE,
        Bucket.BlobTargetOption.generationMatch(42L),
        Bucket.BlobTargetOption.metagenerationMatch(24L),
        Bucket.BlobTargetOption.predefinedAcl(acl));
    assertEquals(expectedBlob, blob);
  }

  @Test
  public void testCreateNotExists() throws Exception {
    initializeExpectedBucket(5);
    BlobInfo info = BlobInfo.builder(BlobId.of("b", "n", 0L)).contentType(CONTENT_TYPE).build();
    Blob expectedBlob = new Blob(serviceMockReturnsOptions, new BlobInfo.BuilderImpl(info));
    byte[] content = {0xD, 0xE, 0xA, 0xD};
    expect(storage.options()).andReturn(mockOptions);
    expect(storage.create(info, content, Storage.BlobTargetOption.generationMatch()))
        .andReturn(expectedBlob);
    replay(storage);
    initializeBucket();
    Blob blob = bucket.create("n", content, CONTENT_TYPE, Bucket.BlobTargetOption.doesNotExist());
    assertEquals(expectedBlob, blob);
  }

  @Test
  public void testCreateWithWrongGenerationOptions() throws Exception {
    initializeExpectedBucket(4);
    expect(storage.options()).andReturn(mockOptions);
    replay(storage);
    initializeBucket();
    byte[] content = {0xD, 0xE, 0xA, 0xD};
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage(
        "Only one option of generationMatch, doesNotExist or generationNotMatch can be provided");
    bucket.create("n", content, CONTENT_TYPE, Bucket.BlobTargetOption.generationMatch(42L),
        Bucket.BlobTargetOption.generationNotMatch(24L));
  }

  @Test
  public void testCreateWithWrongMetagenerationOptions() throws Exception {
    initializeExpectedBucket(4);
    expect(storage.options()).andReturn(mockOptions);
    replay(storage);
    initializeBucket();
    byte[] content = {0xD, 0xE, 0xA, 0xD};
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage(
        "metagenerationMatch and metagenerationNotMatch options can not be both provided");
    bucket.create("n", content, CONTENT_TYPE, Bucket.BlobTargetOption.metagenerationMatch(42L),
        Bucket.BlobTargetOption.metagenerationNotMatch(24L));
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
  public void testCreateFromStreamNoContentType() throws Exception {
    initializeExpectedBucket(5);
    BlobInfo info = BlobInfo.builder("b", "n").build();
    Blob expectedBlob = new Blob(serviceMockReturnsOptions, new BlobInfo.BuilderImpl(info));
    byte[] content = {0xD, 0xE, 0xA, 0xD};
    InputStream streamContent = new ByteArrayInputStream(content);
    expect(storage.options()).andReturn(mockOptions);
    expect(storage.create(info, streamContent)).andReturn(expectedBlob);
    replay(storage);
    initializeBucket();
    Blob blob = bucket.create("n", streamContent);
    assertEquals(expectedBlob, blob);
  }

  @Test
  public void testCreateFromStreamWithOptions() throws Exception {
    initializeExpectedBucket(5);
    BlobInfo info = BlobInfo.builder(BlobId.of("b", "n", 42L))
        .contentType(CONTENT_TYPE)
        .metageneration(24L)
        .crc32c("crc")
        .md5("md5")
        .build();
    Blob expectedBlob = new Blob(serviceMockReturnsOptions, new BlobInfo.BuilderImpl(info));
    byte[] content = {0xD, 0xE, 0xA, 0xD};
    Storage.PredefinedAcl acl = Storage.PredefinedAcl.ALL_AUTHENTICATED_USERS;
    InputStream streamContent = new ByteArrayInputStream(content);
    expect(storage.options()).andReturn(mockOptions);
    expect(storage.create(info, streamContent, Storage.BlobWriteOption.generationMatch(),
        Storage.BlobWriteOption.metagenerationMatch(), Storage.BlobWriteOption.predefinedAcl(acl),
        Storage.BlobWriteOption.crc32cMatch(), Storage.BlobWriteOption.md5Match()))
        .andReturn(expectedBlob);
    replay(storage);
    initializeBucket();
    Blob blob = bucket.create("n", streamContent, CONTENT_TYPE,
        Bucket.BlobWriteOption.generationMatch(42L),
        Bucket.BlobWriteOption.metagenerationMatch(24L), Bucket.BlobWriteOption.predefinedAcl(acl),
        Bucket.BlobWriteOption.crc32cMatch("crc"), Bucket.BlobWriteOption.md5Match("md5"));
    assertEquals(expectedBlob, blob);
  }

  @Test
  public void testCreateFromStreamNotExists() throws Exception {
    initializeExpectedBucket(5);
    BlobInfo info = BlobInfo.builder(BlobId.of("b", "n", 0L)).contentType(CONTENT_TYPE).build();
    Blob expectedBlob = new Blob(serviceMockReturnsOptions, new BlobInfo.BuilderImpl(info));
    byte[] content = {0xD, 0xE, 0xA, 0xD};
    InputStream streamContent = new ByteArrayInputStream(content);
    expect(storage.options()).andReturn(mockOptions);
    expect(storage.create(info, streamContent, Storage.BlobWriteOption.generationMatch()))
        .andReturn(expectedBlob);
    replay(storage);
    initializeBucket();
    Blob blob =
        bucket.create("n", streamContent, CONTENT_TYPE, Bucket.BlobWriteOption.doesNotExist());
    assertEquals(expectedBlob, blob);
  }

  @Test
  public void testCreateFromStreamWithWrongGenerationOptions() throws Exception {
    initializeExpectedBucket(4);
    expect(storage.options()).andReturn(mockOptions);
    replay(storage);
    initializeBucket();
    byte[] content = {0xD, 0xE, 0xA, 0xD};
    InputStream streamContent = new ByteArrayInputStream(content);
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage(
        "Only one option of generationMatch, doesNotExist or generationNotMatch can be provided");
    bucket.create("n", streamContent, CONTENT_TYPE, Bucket.BlobWriteOption.generationMatch(42L),
        Bucket.BlobWriteOption.generationNotMatch(24L));
  }

  @Test
  public void testCreateFromStreamWithWrongMetagenerationOptions() throws Exception {
    initializeExpectedBucket(4);
    expect(storage.options()).andReturn(mockOptions);
    replay(storage);
    initializeBucket();
    byte[] content = {0xD, 0xE, 0xA, 0xD};
    InputStream streamContent = new ByteArrayInputStream(content);
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage(
        "metagenerationMatch and metagenerationNotMatch options can not be both provided");
    bucket.create("n", streamContent, CONTENT_TYPE, Bucket.BlobWriteOption.metagenerationMatch(42L),
        Bucket.BlobWriteOption.metagenerationNotMatch(24L));
  }

  @Test
  public void testToBuilder() {
    expect(storage.options()).andReturn(mockOptions).times(4);
    replay(storage);
    Bucket fullBucket = new Bucket(storage, new BucketInfo.BuilderImpl(FULL_BUCKET_INFO));
    assertEquals(fullBucket, fullBucket.toBuilder().build());
    Bucket simpleBlob = new Bucket(storage, new BucketInfo.BuilderImpl(BUCKET_INFO));
    assertEquals(simpleBlob, simpleBlob.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    initializeExpectedBucket(4);
    expect(storage.options()).andReturn(mockOptions).times(4);
    replay(storage);
    Bucket.Builder builder =
        new Bucket.Builder(new Bucket(storage, new BucketInfo.BuilderImpl(BUCKET_INFO)));
    Bucket bucket = builder.acl(ACL)
        .etag(ETAG)
        .generatedId(GENERATED_ID)
        .metageneration(META_GENERATION)
        .owner(OWNER)
        .selfLink(SELF_LINK)
        .cors(CORS)
        .createTime(CREATE_TIME)
        .defaultAcl(DEFAULT_ACL)
        .deleteRules(DELETE_RULES)
        .indexPage(INDEX_PAGE)
        .notFoundPage(NOT_FOUND_PAGE)
        .location(LOCATION)
        .storageClass(STORAGE_CLASS)
        .versioningEnabled(VERSIONING_ENABLED)
        .build();
    assertEquals("b", bucket.name());
    assertEquals(ACL, bucket.acl());
    assertEquals(ETAG, bucket.etag());
    assertEquals(GENERATED_ID, bucket.generatedId());
    assertEquals(META_GENERATION, bucket.metageneration());
    assertEquals(OWNER, bucket.owner());
    assertEquals(SELF_LINK, bucket.selfLink());
    assertEquals(CREATE_TIME, bucket.createTime());
    assertEquals(CORS, bucket.cors());
    assertEquals(DEFAULT_ACL, bucket.defaultAcl());
    assertEquals(DELETE_RULES, bucket.deleteRules());
    assertEquals(INDEX_PAGE, bucket.indexPage());
    assertEquals(NOT_FOUND_PAGE, bucket.notFoundPage());
    assertEquals(LOCATION, bucket.location());
    assertEquals(STORAGE_CLASS, bucket.storageClass());
    assertEquals(VERSIONING_ENABLED, bucket.versioningEnabled());
    assertEquals(storage.options(), bucket.storage().options());
  }
}
