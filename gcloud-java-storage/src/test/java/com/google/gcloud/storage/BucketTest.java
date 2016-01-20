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

import static com.google.gcloud.storage.Acl.Project.ProjectRole.VIEWERS;
import static org.easymock.EasyMock.capture;
import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.google.api.services.storage.model.Bucket.Lifecycle.Rule;
import com.google.common.collect.ImmutableList;
import com.google.gcloud.Page;
import com.google.gcloud.PageImpl;
import com.google.gcloud.storage.Acl.Project;
import com.google.gcloud.storage.Acl.Role;
import com.google.gcloud.storage.Acl.User;
import com.google.gcloud.storage.BatchResponse.Result;
import com.google.gcloud.storage.Bucket.AgeDeleteRule;
import com.google.gcloud.storage.Bucket.CreatedBeforeDeleteRule;
import com.google.gcloud.storage.Bucket.DeleteRule;
import com.google.gcloud.storage.Bucket.DeleteRule.Type;
import com.google.gcloud.storage.Bucket.IsLiveDeleteRule;
import com.google.gcloud.storage.Bucket.NumNewerVersionsDeleteRule;
import com.google.gcloud.storage.Bucket.RawDeleteRule;

import org.easymock.Capture;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class BucketTest {

private static final List<Acl> ACL = ImmutableList.of(
      new Acl(User.ofAllAuthenticatedUsers(), Role.READER),
      new Acl(new Project(VIEWERS, "p1"), Role.WRITER));
  private static final String ETAG = "0xFF00";
  private static final String ID = "B/N:1";
  private static final Long META_GENERATION = 10L;
  private static final User OWNER = new User("user@gmail.com");
  private static final String SELF_LINK = "http://storage/b/n";
  private static final Long CREATE_TIME = System.currentTimeMillis();
  private static final List<Cors> CORS = Collections.singletonList(Cors.builder().build());
  private static final List<Acl> DEFAULT_ACL =
      Collections.singletonList(new Acl(User.ofAllAuthenticatedUsers(), Role.WRITER));
  private static final List<? extends DeleteRule> DELETE_RULES =
      Collections.singletonList(new AgeDeleteRule(5));
  private static final String INDEX_PAGE = "index.html";
  private static final String NOT_FOUND_PAGE = "error.html";
  private static final String LOCATION = "ASIA";
  private static final String STORAGE_CLASS = "STANDARD";
  private static final Boolean VERSIONING_ENABLED = true;
  private static final String CONTENT_TYPE = "text/plain";
  private static final StorageOptions STORAGE_OPTIONS = EasyMock.createMock(StorageOptions.class);

  private Bucket fullBucket;
  private Bucket simpleBucket;
  private Bucket expectedSimpleBucket;
  private Iterable<Blob> blobResults;
  private Iterable<Blob> expectedBlobResults;
  private Storage storage;
  private Storage simpleStorageMock;

  @Before
  public void setUp() throws Exception {
    storage = createStrictMock(Storage.class);
    expect(storage.options()).andReturn(STORAGE_OPTIONS).anyTimes();
    simpleStorageMock = createStrictMock(Storage.class);
    expect(simpleStorageMock.options()).andReturn(STORAGE_OPTIONS).anyTimes();
    replay(simpleStorageMock);
    expectedSimpleBucket = Bucket.builder(simpleStorageMock, "b").metageneration(42L).build();
    expectedBlobResults = ImmutableList.of(
        Blob.builder(simpleStorageMock, "b", "n1").build(),
        Blob.builder(simpleStorageMock, "b", "n2").build(),
        Blob.builder(simpleStorageMock, "b", "n3").build());
  }

  @After
  public void tearDown() throws Exception {
    verify(storage);
  }

  private void initializeObjectsWithServiceDependencies() {
    fullBucket =
        Bucket.builder(storage, "b")
            .acl(ACL)
            .etag(ETAG)
            .id(ID)
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
    simpleBucket = Bucket.builder(storage, "b").metageneration(42L).build();
    blobResults = ImmutableList.of(Blob.builder(storage, "b", "n1").build(),
        Blob.builder(storage, "b", "n2").build(), Blob.builder(storage, "b", "n3").build());
  }

  @Test
  public void testToBuilder() {
    replay(storage);
    initializeObjectsWithServiceDependencies();
    compareBuckets(fullBucket, fullBucket.toBuilder().build());
    Bucket bucket = fullBucket.toBuilder().name("B").id("id").build();
    assertEquals("B", bucket.name());
    assertEquals("id", bucket.id());
    bucket = bucket.toBuilder().name("b").id(ID).build();
    compareBuckets(fullBucket, bucket);
  }

  @Test
  public void testToBuilderIncomplete() {
    replay(storage);
    initializeObjectsWithServiceDependencies();
    Bucket incompleteBucket = Bucket.builder(storage, "b").build();
    compareBuckets(incompleteBucket, incompleteBucket.toBuilder().build());
  }

  @Test
  public void testOf() {
    replay(storage);
    initializeObjectsWithServiceDependencies();
    Bucket bucket = Bucket.of(storage, "bucket");
    assertEquals("bucket", bucket.name());
  }

  @Test
  public void testBuilder() {
    replay(storage);
    initializeObjectsWithServiceDependencies();
    assertEquals("b", fullBucket.name());
    assertEquals(ACL, fullBucket.acl());
    assertEquals(ETAG, fullBucket.etag());
    assertEquals(ID, fullBucket.id());
    assertEquals(META_GENERATION, fullBucket.metageneration());
    assertEquals(OWNER, fullBucket.owner());
    assertEquals(SELF_LINK, fullBucket.selfLink());
    assertEquals(CREATE_TIME, fullBucket.createTime());
    assertEquals(CORS, fullBucket.cors());
    assertEquals(DEFAULT_ACL, fullBucket.defaultAcl());
    assertEquals(DELETE_RULES, fullBucket.deleteRules());
    assertEquals(INDEX_PAGE, fullBucket.indexPage());
    assertEquals(NOT_FOUND_PAGE, fullBucket.notFoundPage());
    assertEquals(LOCATION, fullBucket.location());
    assertEquals(STORAGE_CLASS, fullBucket.storageClass());
    assertEquals(VERSIONING_ENABLED, fullBucket.versioningEnabled());
  }

  @Test
  public void testToPbAndFromPb() {
    replay(storage);
    initializeObjectsWithServiceDependencies();
    compareBuckets(fullBucket, Bucket.fromPb(storage, fullBucket.toPb()));
    Bucket bucket = Bucket.of(storage, "b");
    compareBuckets(bucket, Bucket.fromPb(storage, bucket.toPb()));
  }

  private void compareBuckets(Bucket expected, Bucket value) {
    assertEquals(expected, value);
    assertEquals(expected.name(), value.name());
    assertEquals(expected.acl(), value.acl());
    assertEquals(expected.etag(), value.etag());
    assertEquals(expected.id(), value.id());
    assertEquals(expected.metageneration(), value.metageneration());
    assertEquals(expected.owner(), value.owner());
    assertEquals(expected.selfLink(), value.selfLink());
    assertEquals(expected.createTime(), value.createTime());
    assertEquals(expected.cors(), value.cors());
    assertEquals(expected.defaultAcl(), value.defaultAcl());
    assertEquals(expected.deleteRules(), value.deleteRules());
    assertEquals(expected.indexPage(), value.indexPage());
    assertEquals(expected.notFoundPage(), value.notFoundPage());
    assertEquals(expected.location(), value.location());
    assertEquals(expected.storageClass(), value.storageClass());
    assertEquals(expected.versioningEnabled(), value.versioningEnabled());
    assertEquals(expected.storage().options(), value.storage().options());
  }

  @Test
  public void testDeleteRules() {
    replay(storage);
    AgeDeleteRule ageRule = new AgeDeleteRule(10);
    assertEquals(10, ageRule.daysToLive());
    assertEquals(Type.AGE, ageRule.type());
    CreatedBeforeDeleteRule createBeforeRule = new CreatedBeforeDeleteRule(1);
    assertEquals(1, createBeforeRule.timeMillis());
    assertEquals(Type.CREATE_BEFORE, createBeforeRule.type());
    NumNewerVersionsDeleteRule versionsRule = new NumNewerVersionsDeleteRule(2);
    assertEquals(2, versionsRule.numNewerVersions());
    assertEquals(Type.NUM_NEWER_VERSIONS, versionsRule.type());
    IsLiveDeleteRule isLiveRule = new IsLiveDeleteRule(true);
    assertTrue(isLiveRule.isLive());
    assertEquals(Type.IS_LIVE, isLiveRule.type());
    Rule rule = new Rule().set("a", "b");
    RawDeleteRule rawRule = new RawDeleteRule(rule);
    assertEquals(Type.UNKNOWN, rawRule.type());
    ImmutableList<DeleteRule> rules =
        ImmutableList.of(ageRule, createBeforeRule, versionsRule, isLiveRule, rawRule);
    for (DeleteRule delRule : rules) {
      assertEquals(delRule, DeleteRule.fromPb(delRule.toPb()));
    }
  }

  @Test
  public void testExists_True() throws Exception {
    Storage.BucketGetOption[] expectedOptions = {Storage.BucketGetOption.fields()};
    expect(storage.get(expectedSimpleBucket.name(), expectedOptions))
        .andReturn(expectedSimpleBucket);
    replay(storage);
    initializeObjectsWithServiceDependencies();
    assertTrue(simpleBucket.exists());
  }

  @Test
  public void testExists_False() throws Exception {
    Storage.BucketGetOption[] expectedOptions = {Storage.BucketGetOption.fields()};
    expect(storage.get(expectedSimpleBucket.name(), expectedOptions)).andReturn(null);
    replay(storage);
    initializeObjectsWithServiceDependencies();
    assertFalse(simpleBucket.exists());
  }

  @Test
  public void testReload() throws Exception {
    Bucket updated = expectedSimpleBucket.toBuilder().notFoundPage("p").build();
    expect(storage.get(updated.name())).andReturn(updated);
    replay(storage);
    initializeObjectsWithServiceDependencies();
    Bucket updatedBucket = simpleBucket.reload();
    assertSame(simpleStorageMock, updatedBucket.storage());
    assertEquals(updated, updatedBucket);
  }

  @Test
  public void testReloadNull() throws Exception {
    expect(storage.get(expectedSimpleBucket.name())).andReturn(null);
    replay(storage);
    initializeObjectsWithServiceDependencies();
    assertNull(simpleBucket.reload());
  }

  @Test
  public void testReloadWithOptions() throws Exception {
    Bucket updated = expectedSimpleBucket.toBuilder().notFoundPage("p").build();
    expect(storage.get(updated.name(), Storage.BucketGetOption.metagenerationMatch(42L)))
        .andReturn(updated);
    replay(storage);
    initializeObjectsWithServiceDependencies();
    Bucket updatedBucket = simpleBucket.reload(Bucket.BucketSourceOption.metagenerationMatch());
    assertSame(simpleStorageMock, updatedBucket.storage());
    assertEquals(updated, updatedBucket);
  }

  @Test
  public void testUpdate() throws Exception {
    Bucket expected = expectedSimpleBucket.toBuilder().notFoundPage("p").build();
    expect(storage.update(expected)).andReturn(expected);
    replay(storage);
    initializeObjectsWithServiceDependencies();
    Bucket updatedBucket = simpleBucket.update(expected);
    assertSame(storage, simpleBucket.storage());
    assertEquals(expected, updatedBucket);
  }

  @Test
  public void testDelete() throws Exception {
    expect(storage.delete(expectedSimpleBucket.name())).andReturn(true);
    replay(storage);
    initializeObjectsWithServiceDependencies();
    assertTrue(simpleBucket.delete());
  }

  @Test
  public void testList() throws Exception {
    StorageOptions storageOptions = createStrictMock(StorageOptions.class);
    PageImpl<Blob> expectedPage = new PageImpl<>(null, "c", expectedBlobResults);
    expect(storage.list(expectedSimpleBucket.name())).andReturn(expectedPage);
    replay(storage, storageOptions);
    initializeObjectsWithServiceDependencies();
    Page<Blob> blobPage = simpleBucket.list();
    Iterator<Blob> expectedBlobIterator = expectedPage.values().iterator();
    Iterator<Blob> blobIterator = blobPage.values().iterator();
    while (expectedBlobIterator.hasNext() && blobIterator.hasNext()) {
      assertEquals(expectedBlobIterator.next(), blobIterator.next());
    }
    assertFalse(expectedBlobIterator.hasNext());
    assertFalse(blobIterator.hasNext());
    assertEquals(expectedPage.nextPageCursor(), blobPage.nextPageCursor());
    verify(storageOptions);
  }

  @Test
  public void testCreateBucket() throws Exception {
    expect(storage.create(expectedSimpleBucket)).andReturn(expectedSimpleBucket);
    replay(storage);
    initializeObjectsWithServiceDependencies();
    Bucket bucket = simpleBucket.create();
    assertEquals(simpleBucket, bucket);
  }

  @Test
  public void testGet() throws Exception {
    Blob expected = Blob.builder(simpleStorageMock, "b", "n").build();
    expect(storage.get(BlobId.of(expectedSimpleBucket.name(), "n"), new Storage.BlobGetOption[0]))
        .andReturn(expected);
    replay(storage);
    initializeObjectsWithServiceDependencies();
    Blob blob = simpleBucket.get("n");
    assertEquals(expected, blob);
  }

  @Test
  public void testGetAll() throws Exception {
    Capture<BatchRequest> capturedBatchRequest = Capture.newInstance();
    List<Result<Blob>> batchResultList = new LinkedList<>();
    for (Blob blob : expectedBlobResults) {
      batchResultList.add(new Result<>(blob));
    }
    BatchResponse response = new BatchResponse(Collections.<Result<Boolean>>emptyList(),
        Collections.<Result<Blob>>emptyList(), batchResultList);
    expect(storage.apply(capture(capturedBatchRequest))).andReturn(response);
    replay(storage);
    initializeObjectsWithServiceDependencies();
    List<Blob> blobs = simpleBucket.get("n1", "n2", "n3");
    Set<BlobId> blobSet = capturedBatchRequest.getValue().toGet().keySet();
    assertEquals(batchResultList.size(), blobSet.size());
    for (Blob blob : blobResults) {
      assertTrue(blobSet.contains(blob.blobId()));
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
  public void testCreateBlob() throws Exception {
    Blob expected = Blob.builder(simpleStorageMock, "b", "n").contentType(CONTENT_TYPE).build();
    byte[] content = {0xD, 0xE, 0xA, 0xD};
    expect(storage.create(expected, content)).andReturn(expected);
    replay(storage);
    initializeObjectsWithServiceDependencies();
    Blob blob = simpleBucket.create("n", content, CONTENT_TYPE);
    assertEquals(expected, blob);
  }

  @Test
  public void testCreateNullContentType() throws Exception {
    Blob expected =
        Blob.builder(simpleStorageMock, "b", "n").contentType(Storage.DEFAULT_CONTENT_TYPE).build();
    byte[] content = {0xD, 0xE, 0xA, 0xD};
    expect(storage.create(expected, content)).andReturn(expected);
    replay(storage);
    initializeObjectsWithServiceDependencies();
    Blob blob = simpleBucket.create("n", content, null);
    assertEquals(expected, blob);
  }

  @Test
  public void testCreateFromStream() throws Exception {
    Blob expected = Blob.builder(simpleStorageMock, "b", "n").contentType(CONTENT_TYPE).build();
    byte[] content = {0xD, 0xE, 0xA, 0xD};
    InputStream streamContent = new ByteArrayInputStream(content);
    expect(storage.create(expected, streamContent)).andReturn(expected);
    replay(storage);
    initializeObjectsWithServiceDependencies();
    Blob blob = simpleBucket.create("n", streamContent, CONTENT_TYPE);
    assertEquals(expected, blob);
  }

  @Test
  public void testCreateFromStreamNullContentType() throws Exception {
    Blob expected =
        Blob.builder(simpleStorageMock, "b", "n").contentType(Storage.DEFAULT_CONTENT_TYPE).build();
    byte[] content = {0xD, 0xE, 0xA, 0xD};
    InputStream streamContent = new ByteArrayInputStream(content);
    expect(storage.create(expected, streamContent)).andReturn(expected);
    replay(storage);
    initializeObjectsWithServiceDependencies();
    Blob blob = simpleBucket.create("n", streamContent, null);
    assertEquals(expected, blob);
  }

  @Test
  public void testStaticGet() throws Exception {
    expect(storage.get(expectedSimpleBucket.name())).andReturn(expectedSimpleBucket);
    replay(storage);
    initializeObjectsWithServiceDependencies();
    Bucket loadedBucket = Bucket.get(storage, simpleBucket.name());
    assertNotNull(loadedBucket);
    assertEquals(simpleBucket, loadedBucket);
  }

  @Test
  public void testStaticGetNull() throws Exception {
    expect(storage.get(expectedSimpleBucket.name())).andReturn(null);
    replay(storage);
    initializeObjectsWithServiceDependencies();
    assertNull(Bucket.get(storage, simpleBucket.name()));
  }

  @Test
  public void testStaticGetWithOptions() throws Exception {
    expect(storage.get(expectedSimpleBucket.name(), Storage.BucketGetOption.fields()))
        .andReturn(expectedSimpleBucket);
    replay(storage);
    initializeObjectsWithServiceDependencies();
    Bucket loadedBucket =
        Bucket.get(storage, simpleBucket.name(), Storage.BucketGetOption.fields());
    assertNotNull(loadedBucket);
    assertEquals(simpleBucket, loadedBucket);
  }
}
