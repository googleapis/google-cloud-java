/*
 * Copyright 2015 Google LLC
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

import static com.google.cloud.storage.Acl.Role.WRITER;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.api.gax.paging.Page;
import com.google.cloud.PageImpl;
import com.google.cloud.storage.Acl.Project;
import com.google.cloud.storage.Acl.Project.ProjectRole;
import com.google.cloud.storage.Acl.Role;
import com.google.cloud.storage.Acl.User;
import com.google.cloud.storage.BucketInfo.AgeDeleteRule;
import com.google.cloud.storage.BucketInfo.DeleteRule;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.io.BaseEncoding;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.Key;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.crypto.spec.SecretKeySpec;

public class BucketTest {

  private static final Acl ACL = Acl.of(User.ofAllAuthenticatedUsers(), Role.OWNER);
  private static final Acl OTHER_ACL = Acl.of(new Project(ProjectRole.OWNERS, "p"), Role.READER);
  private static final List<Acl> ACLS = ImmutableList.of(ACL, OTHER_ACL);
  private static final String ETAG = "0xFF00";
  private static final String GENERATED_ID = "B/N:1";
  private static final Long META_GENERATION = 10L;
  private static final User OWNER = new User("user@gmail.com");
  private static final String SELF_LINK = "http://storage/b/n";
  private static final Long CREATE_TIME = System.currentTimeMillis();
  private static final List<Cors> CORS = Collections.singletonList(Cors.newBuilder().build());
  private static final List<Acl> DEFAULT_ACL =
      Collections.singletonList(Acl.of(User.ofAllAuthenticatedUsers(), WRITER));
  private static final List<? extends DeleteRule> DELETE_RULES =
      Collections.singletonList(new AgeDeleteRule(5));
  private static final String INDEX_PAGE = "index.html";
  private static final String NOT_FOUND_PAGE = "error.html";
  private static final String LOCATION = "ASIA";
  private static final StorageClass STORAGE_CLASS = StorageClass.STANDARD;
  private static final String DEFAULT_KMS_KEY_NAME = "projects/p/locations/kr-loc/keyRings/kr/cryptoKeys/key";
  private static final Boolean VERSIONING_ENABLED = true;
  private static final Map<String, String> BUCKET_LABELS = ImmutableMap.of("label1", "value1");
  private static final Boolean REQUESTER_PAYS = true;
  private static final String USER_PROJECT = "test-project";
  private static final BucketInfo FULL_BUCKET_INFO = BucketInfo.newBuilder("b")
      .setAcl(ACLS)
      .setEtag(ETAG)
      .setGeneratedId(GENERATED_ID)
      .setMetageneration(META_GENERATION)
      .setOwner(OWNER)
      .setSelfLink(SELF_LINK)
      .setCors(CORS)
      .setCreateTime(CREATE_TIME)
      .setDefaultAcl(DEFAULT_ACL)
      .setDeleteRules(DELETE_RULES)
      .setIndexPage(INDEX_PAGE)
      .setNotFoundPage(NOT_FOUND_PAGE)
      .setLocation(LOCATION)
      .setStorageClass(STORAGE_CLASS)
      .setVersioningEnabled(VERSIONING_ENABLED)
      .setLabels(BUCKET_LABELS)
      .setRequesterPays(REQUESTER_PAYS)
      .setDefaultKmsKeyName(DEFAULT_KMS_KEY_NAME)
      .build();
  private static final BucketInfo BUCKET_INFO =
      BucketInfo.newBuilder("b").setMetageneration(42L).build();
  private static final String CONTENT_TYPE = "text/plain";
  private static final String BASE64_KEY = "JVzfVl8NLD9FjedFuStegjRfES5ll5zc59CIXw572OA=";
  private static final Key KEY =
      new SecretKeySpec(BaseEncoding.base64().decode(BASE64_KEY), "AES256");

  private Storage storage;
  private Storage serviceMockReturnsOptions = createMock(Storage.class);
  private StorageOptions mockOptions = createMock(StorageOptions.class);
  private Bucket bucket;
  private Bucket expectedBucket;
  private List<Blob> blobResults;

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
    expect(serviceMockReturnsOptions.getOptions()).andReturn(mockOptions).times(optionsCalls);
    replay(serviceMockReturnsOptions);
    expectedBucket = new Bucket(serviceMockReturnsOptions, new BucketInfo.BuilderImpl(BUCKET_INFO));
    blobResults = ImmutableList.of(
        new Blob(serviceMockReturnsOptions,
            new BlobInfo.BuilderImpl(BlobInfo.newBuilder("b", "n1").build())),
        new Blob(serviceMockReturnsOptions,
            new BlobInfo.BuilderImpl(BlobInfo.newBuilder("b", "n2").build())),
        new Blob(serviceMockReturnsOptions,
            new BlobInfo.BuilderImpl(BlobInfo.newBuilder("b", "n3").build())));
  }

  private void initializeBucket() {
    bucket = new Bucket(storage, new BucketInfo.BuilderImpl(BUCKET_INFO));
  }

  @Test
  public void testExists_True() throws Exception {
    initializeExpectedBucket(4);
    Storage.BucketGetOption[] expectedOptions = {Storage.BucketGetOption.fields()};
    expect(storage.getOptions()).andReturn(mockOptions);
    expect(storage.get(BUCKET_INFO.getName(), expectedOptions)).andReturn(expectedBucket);
    replay(storage);
    initializeBucket();
    assertTrue(bucket.exists());
  }

  @Test
  public void testExists_False() throws Exception {
    initializeExpectedBucket(4);
    Storage.BucketGetOption[] expectedOptions = {Storage.BucketGetOption.fields()};
    expect(storage.getOptions()).andReturn(mockOptions);
    expect(storage.get(BUCKET_INFO.getName(), expectedOptions)).andReturn(null);
    replay(storage);
    initializeBucket();
    assertFalse(bucket.exists());
  }

  @Test
  public void testReload() throws Exception {
    initializeExpectedBucket(5);
    BucketInfo updatedInfo = BUCKET_INFO.toBuilder().setNotFoundPage("p").build();
    Bucket expectedUpdatedBucket =
        new Bucket(serviceMockReturnsOptions, new BucketInfo.BuilderImpl(updatedInfo));
    expect(storage.getOptions()).andReturn(mockOptions);
    expect(storage.get(updatedInfo.getName())).andReturn(expectedUpdatedBucket);
    replay(storage);
    initializeBucket();
    Bucket updatedBucket = bucket.reload();
    assertEquals(expectedUpdatedBucket, updatedBucket);
  }

  @Test
  public void testReloadNull() throws Exception {
    initializeExpectedBucket(4);
    expect(storage.getOptions()).andReturn(mockOptions);
    expect(storage.get(BUCKET_INFO.getName())).andReturn(null);
    replay(storage);
    initializeBucket();
    assertNull(bucket.reload());
  }

  @Test
  public void testReloadWithOptions() throws Exception {
    initializeExpectedBucket(5);
    BucketInfo updatedInfo = BUCKET_INFO.toBuilder().setNotFoundPage("p").build();
    Bucket expectedUpdatedBucket =
        new Bucket(serviceMockReturnsOptions, new BucketInfo.BuilderImpl(updatedInfo));
    expect(storage.getOptions()).andReturn(mockOptions);
    expect(storage.get(updatedInfo.getName(), Storage.BucketGetOption.metagenerationMatch(42L)))
        .andReturn(expectedUpdatedBucket);
    replay(storage);
    initializeBucket();
    Bucket updatedBucket = bucket.reload(Bucket.BucketSourceOption.metagenerationMatch());
    assertEquals(expectedUpdatedBucket, updatedBucket);
  }

  @Test
  public void testUpdate() throws Exception {
    initializeExpectedBucket(5);
    Bucket expectedUpdatedBucket = expectedBucket.toBuilder().setNotFoundPage("p").build();
    expect(storage.getOptions()).andReturn(mockOptions).times(2);
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
    expect(storage.getOptions()).andReturn(mockOptions);
    expect(storage.delete(BUCKET_INFO.getName())).andReturn(true);
    replay(storage);
    initializeBucket();
    assertTrue(bucket.delete());
  }

  @Test
  public void testList() throws Exception {
    initializeExpectedBucket(4);
    PageImpl<Blob> expectedBlobPage = new PageImpl<>(null, "c", blobResults);
    expect(storage.getOptions()).andReturn(mockOptions);
    expect(storage.list(BUCKET_INFO.getName())).andReturn(expectedBlobPage);
    replay(storage);
    initializeBucket();
    Page<Blob> blobPage = bucket.list();
    Iterator<Blob> blobInfoIterator = blobPage.getValues().iterator();
    Iterator<Blob> blobIterator = blobPage.getValues().iterator();
    while (blobInfoIterator.hasNext() && blobIterator.hasNext()) {
      assertEquals(blobInfoIterator.next(), blobIterator.next());
    }
    assertFalse(blobInfoIterator.hasNext());
    assertFalse(blobIterator.hasNext());
    assertEquals(expectedBlobPage.getNextPageToken(), blobPage.getNextPageToken());
  }

  @Test
  public void testGet() throws Exception {
    initializeExpectedBucket(5);
    Blob expectedBlob = new Blob(
        serviceMockReturnsOptions, new BlobInfo.BuilderImpl(BlobInfo.newBuilder("b", "n").build()));
    expect(storage.getOptions()).andReturn(mockOptions);
    expect(storage.get(BlobId.of(expectedBucket.getName(), "n"), new Storage.BlobGetOption[0]))
        .andReturn(expectedBlob);
    replay(storage);
    initializeBucket();
    Blob blob = bucket.get("n");
    assertEquals(expectedBlob, blob);
  }

  @Test
  public void testGetAllArray() throws Exception {
    initializeExpectedBucket(4);
    expect(storage.getOptions()).andReturn(mockOptions);
    List<BlobId> blobIds = Lists.transform(blobResults, new Function<Blob, BlobId>() {
      @Override
      public BlobId apply(Blob blob) {
        return blob.getBlobId();
      }
    });
    expect(storage.get(blobIds)).andReturn(blobResults);
    replay(storage);
    initializeBucket();
    assertEquals(blobResults, bucket.get("n1", "n2", "n3"));
  }

  @Test
  public void testGetAllIterable() throws Exception {
    initializeExpectedBucket(4);
    expect(storage.getOptions()).andReturn(mockOptions);
    List<BlobId> blobIds = Lists.transform(blobResults, new Function<Blob, BlobId>() {
      @Override
      public BlobId apply(Blob blob) {
        return blob.getBlobId();
      }
    });
    expect(storage.get(blobIds)).andReturn(blobResults);
    replay(storage);
    initializeBucket();
    assertEquals(blobResults, bucket.get(ImmutableList.of("n1", "n2", "n3")));
  }

  @Test
  public void testCreate() throws Exception {
    initializeExpectedBucket(5);
    BlobInfo info = BlobInfo.newBuilder("b", "n").setContentType(CONTENT_TYPE).build();
    Blob expectedBlob = new Blob(serviceMockReturnsOptions, new BlobInfo.BuilderImpl(info));
    byte[] content = {0xD, 0xE, 0xA, 0xD};
    expect(storage.getOptions()).andReturn(mockOptions);
    expect(storage.create(info, content)).andReturn(expectedBlob);
    replay(storage);
    initializeBucket();
    Blob blob = bucket.create("n", content, CONTENT_TYPE);
    assertEquals(expectedBlob, blob);
  }

  @Test
  public void testCreateNoContentType() throws Exception {
    initializeExpectedBucket(5);
    BlobInfo info = BlobInfo.newBuilder("b", "n").build();
    Blob expectedBlob = new Blob(serviceMockReturnsOptions, new BlobInfo.BuilderImpl(info));
    byte[] content = {0xD, 0xE, 0xA, 0xD};
    expect(storage.getOptions()).andReturn(mockOptions);
    expect(storage.create(info, content)).andReturn(expectedBlob);
    replay(storage);
    initializeBucket();
    Blob blob = bucket.create("n", content);
    assertEquals(expectedBlob, blob);
  }

  @Test
  public void testCreateWithOptions() throws Exception {
    initializeExpectedBucket(5);
    BlobInfo info = BlobInfo.newBuilder(BlobId.of("b", "n", 42L))
        .setContentType(CONTENT_TYPE)
        .setMetageneration(24L)
        .build();
    Blob expectedBlob = new Blob(serviceMockReturnsOptions, new BlobInfo.BuilderImpl(info));
    byte[] content = {0xD, 0xE, 0xA, 0xD};
    Storage.PredefinedAcl acl = Storage.PredefinedAcl.ALL_AUTHENTICATED_USERS;
    expect(storage.getOptions()).andReturn(mockOptions);
    expect(storage.create(info, content, Storage.BlobTargetOption.generationMatch(),
        Storage.BlobTargetOption.metagenerationMatch(),
        Storage.BlobTargetOption.predefinedAcl(acl),
        Storage.BlobTargetOption.encryptionKey(BASE64_KEY),
        Storage.BlobTargetOption.userProject(USER_PROJECT))).andReturn(expectedBlob);
    replay(storage);
    initializeBucket();
    Blob blob = bucket.create("n", content, CONTENT_TYPE,
        Bucket.BlobTargetOption.generationMatch(42L),
        Bucket.BlobTargetOption.metagenerationMatch(24L),
        Bucket.BlobTargetOption.predefinedAcl(acl),
        Bucket.BlobTargetOption.encryptionKey(BASE64_KEY),
        Bucket.BlobTargetOption.userProject(USER_PROJECT));
    assertEquals(expectedBlob, blob);
  }

  @Test
  public void testCreateWithEncryptionKey() throws Exception {
    initializeExpectedBucket(5);
    BlobInfo info = BlobInfo.newBuilder(BlobId.of("b", "n")).setContentType(CONTENT_TYPE).build();
    Blob expectedBlob = new Blob(serviceMockReturnsOptions, new BlobInfo.BuilderImpl(info));
    byte[] content = {0xD, 0xE, 0xA, 0xD};
    expect(storage.getOptions()).andReturn(mockOptions);
    expect(storage.create(info, content, Storage.BlobTargetOption.encryptionKey(KEY)))
        .andReturn(expectedBlob);
    replay(storage);
    initializeBucket();
    Blob blob =
        bucket.create("n", content, CONTENT_TYPE, Bucket.BlobTargetOption.encryptionKey(KEY));
    assertEquals(expectedBlob, blob);
  }

  @Test
  public void testCreateNotExists() throws Exception {
    initializeExpectedBucket(5);
    BlobInfo info =
        BlobInfo.newBuilder(BlobId.of("b", "n", 0L)).setContentType(CONTENT_TYPE).build();
    Blob expectedBlob = new Blob(serviceMockReturnsOptions, new BlobInfo.BuilderImpl(info));
    byte[] content = {0xD, 0xE, 0xA, 0xD};
    expect(storage.getOptions()).andReturn(mockOptions);
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
    expect(storage.getOptions()).andReturn(mockOptions);
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
    expect(storage.getOptions()).andReturn(mockOptions);
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
    BlobInfo info = BlobInfo.newBuilder("b", "n").setContentType(CONTENT_TYPE).build();
    Blob expectedBlob = new Blob(serviceMockReturnsOptions, new BlobInfo.BuilderImpl(info));
    byte[] content = {0xD, 0xE, 0xA, 0xD};
    InputStream streamContent = new ByteArrayInputStream(content);
    expect(storage.getOptions()).andReturn(mockOptions);
    expect(storage.create(info, streamContent)).andReturn(expectedBlob);
    replay(storage);
    initializeBucket();
    Blob blob = bucket.create("n", streamContent, CONTENT_TYPE);
    assertEquals(expectedBlob, blob);
  }

  @Test
  public void testCreateFromStreamNoContentType() throws Exception {
    initializeExpectedBucket(5);
    BlobInfo info = BlobInfo.newBuilder("b", "n").build();
    Blob expectedBlob = new Blob(serviceMockReturnsOptions, new BlobInfo.BuilderImpl(info));
    byte[] content = {0xD, 0xE, 0xA, 0xD};
    InputStream streamContent = new ByteArrayInputStream(content);
    expect(storage.getOptions()).andReturn(mockOptions);
    expect(storage.create(info, streamContent)).andReturn(expectedBlob);
    replay(storage);
    initializeBucket();
    Blob blob = bucket.create("n", streamContent);
    assertEquals(expectedBlob, blob);
  }

  @Test
  public void testCreateFromStreamWithOptions() throws Exception {
    initializeExpectedBucket(5);
    BlobInfo info = BlobInfo.newBuilder(BlobId.of("b", "n", 42L))
        .setContentType(CONTENT_TYPE)
        .setMetageneration(24L)
        .setCrc32c("crc")
        .setMd5("md5")
        .build();
    Blob expectedBlob = new Blob(serviceMockReturnsOptions, new BlobInfo.BuilderImpl(info));
    byte[] content = {0xD, 0xE, 0xA, 0xD};
    Storage.PredefinedAcl acl = Storage.PredefinedAcl.ALL_AUTHENTICATED_USERS;
    InputStream streamContent = new ByteArrayInputStream(content);
    expect(storage.getOptions()).andReturn(mockOptions);
    expect(storage.create(info, streamContent, Storage.BlobWriteOption.generationMatch(),
        Storage.BlobWriteOption.metagenerationMatch(), Storage.BlobWriteOption.predefinedAcl(acl),
        Storage.BlobWriteOption.crc32cMatch(), Storage.BlobWriteOption.md5Match(),
        Storage.BlobWriteOption.encryptionKey(BASE64_KEY),
        Storage.BlobWriteOption.userProject(USER_PROJECT)))
        .andReturn(expectedBlob);
    replay(storage);
    initializeBucket();
    Blob blob = bucket.create("n", streamContent, CONTENT_TYPE,
        Bucket.BlobWriteOption.generationMatch(42L),
        Bucket.BlobWriteOption.metagenerationMatch(24L), Bucket.BlobWriteOption.predefinedAcl(acl),
        Bucket.BlobWriteOption.crc32cMatch("crc"), Bucket.BlobWriteOption.md5Match("md5"),
        Bucket.BlobWriteOption.encryptionKey(BASE64_KEY),
        Bucket.BlobWriteOption.userProject(USER_PROJECT));
    assertEquals(expectedBlob, blob);
  }

  @Test
  public void testCreateFromStreamWithEncryptionKey() throws Exception {
    initializeExpectedBucket(5);
    BlobInfo info = BlobInfo.newBuilder(BlobId.of("b", "n")).setContentType(CONTENT_TYPE).build();
    Blob expectedBlob = new Blob(serviceMockReturnsOptions, new BlobInfo.BuilderImpl(info));
    byte[] content = {0xD, 0xE, 0xA, 0xD};
    InputStream streamContent = new ByteArrayInputStream(content);
    expect(storage.getOptions()).andReturn(mockOptions);
    expect(storage.create(info, streamContent, Storage.BlobWriteOption.encryptionKey(KEY)))
        .andReturn(expectedBlob);
    replay(storage);
    initializeBucket();
    Blob blob =
        bucket.create("n", streamContent, CONTENT_TYPE, Bucket.BlobWriteOption.encryptionKey(KEY));
    assertEquals(expectedBlob, blob);
  }

  @Test
  public void testCreateFromStreamNotExists() throws Exception {
    initializeExpectedBucket(5);
    BlobInfo info =
        BlobInfo.newBuilder(BlobId.of("b", "n", 0L)).setContentType(CONTENT_TYPE).build();
    Blob expectedBlob = new Blob(serviceMockReturnsOptions, new BlobInfo.BuilderImpl(info));
    byte[] content = {0xD, 0xE, 0xA, 0xD};
    InputStream streamContent = new ByteArrayInputStream(content);
    expect(storage.getOptions()).andReturn(mockOptions);
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
    expect(storage.getOptions()).andReturn(mockOptions);
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
    expect(storage.getOptions()).andReturn(mockOptions);
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
  public void testGetAcl() throws Exception {
    initializeExpectedBucket(4);
    expect(storage.getOptions()).andReturn(mockOptions);
    expect(storage.getAcl(BUCKET_INFO.getName(), User.ofAllAuthenticatedUsers())).andReturn(ACL);
    replay(storage);
    initializeBucket();
    assertEquals(ACL, bucket.getAcl(User.ofAllAuthenticatedUsers()));
  }

  @Test
  public void testDeleteAcl() throws Exception {
    initializeExpectedBucket(4);
    expect(storage.getOptions()).andReturn(mockOptions);
    expect(storage.deleteAcl(BUCKET_INFO.getName(),
        User.ofAllAuthenticatedUsers())).andReturn(true);
    replay(storage);
    initializeBucket();
    assertTrue(bucket.deleteAcl(User.ofAllAuthenticatedUsers()));
  }

  @Test
  public void testCreateAcl() throws Exception {
    initializeExpectedBucket(4);
    expect(storage.getOptions()).andReturn(mockOptions);
    Acl returnedAcl = ACL.toBuilder().setEtag("ETAG").setId("ID").build();
    expect(storage.createAcl(BUCKET_INFO.getName(), ACL)).andReturn(returnedAcl);
    replay(storage);
    initializeBucket();
    assertEquals(returnedAcl, bucket.createAcl(ACL));
  }

  @Test
  public void testUpdateAcl() throws Exception {
    initializeExpectedBucket(4);
    expect(storage.getOptions()).andReturn(mockOptions);
    Acl returnedAcl = ACL.toBuilder().setEtag("ETAG").setId("ID").build();
    expect(storage.updateAcl(BUCKET_INFO.getName(), ACL)).andReturn(returnedAcl);
    replay(storage);
    initializeBucket();
    assertEquals(returnedAcl, bucket.updateAcl(ACL));
  }

  @Test
  public void testListAcls() throws Exception {
    initializeExpectedBucket(4);
    expect(storage.getOptions()).andReturn(mockOptions);
    expect(storage.listAcls(BUCKET_INFO.getName())).andReturn(ACLS);
    replay(storage);
    initializeBucket();
    assertEquals(ACLS, bucket.listAcls());
  }

  @Test
  public void testGetDefaultAcl() throws Exception {
    initializeExpectedBucket(4);
    expect(storage.getOptions()).andReturn(mockOptions);
    expect(storage.getDefaultAcl(BUCKET_INFO.getName(), User.ofAllAuthenticatedUsers()))
        .andReturn(ACL);
    replay(storage);
    initializeBucket();
    assertEquals(ACL, bucket.getDefaultAcl(User.ofAllAuthenticatedUsers()));
  }

  @Test
  public void testDeleteDefaultAcl() throws Exception {
    initializeExpectedBucket(4);
    expect(storage.getOptions()).andReturn(mockOptions);
    expect(storage.deleteDefaultAcl(BUCKET_INFO.getName(), User.ofAllAuthenticatedUsers()))
        .andReturn(true);
    replay(storage);
    initializeBucket();
    assertTrue(bucket.deleteDefaultAcl(User.ofAllAuthenticatedUsers()));
  }

  @Test
  public void testCreateDefaultAcl() throws Exception {
    initializeExpectedBucket(4);
    expect(storage.getOptions()).andReturn(mockOptions);
    Acl returnedAcl = ACL.toBuilder().setEtag("ETAG").setId("ID").build();
    expect(storage.createDefaultAcl(BUCKET_INFO.getName(), ACL)).andReturn(returnedAcl);
    replay(storage);
    initializeBucket();
    assertEquals(returnedAcl, bucket.createDefaultAcl(ACL));
  }

  @Test
  public void testUpdateDefaultAcl() throws Exception {
    initializeExpectedBucket(4);
    expect(storage.getOptions()).andReturn(mockOptions);
    Acl returnedAcl = ACL.toBuilder().setEtag("ETAG").setId("ID").build();
    expect(storage.updateDefaultAcl(BUCKET_INFO.getName(), ACL)).andReturn(returnedAcl);
    replay(storage);
    initializeBucket();
    assertEquals(returnedAcl, bucket.updateDefaultAcl(ACL));
  }

  @Test
  public void testListDefaultAcls() throws Exception {
    initializeExpectedBucket(4);
    expect(storage.getOptions()).andReturn(mockOptions);
    expect(storage.listDefaultAcls(BUCKET_INFO.getName())).andReturn(ACLS);
    replay(storage);
    initializeBucket();
    assertEquals(ACLS, bucket.listDefaultAcls());
  }

  @Test
  public void testToBuilder() {
    expect(storage.getOptions()).andReturn(mockOptions).times(4);
    replay(storage);
    Bucket fullBucket = new Bucket(storage, new BucketInfo.BuilderImpl(FULL_BUCKET_INFO));
    assertEquals(fullBucket, fullBucket.toBuilder().build());
    Bucket simpleBlob = new Bucket(storage, new BucketInfo.BuilderImpl(BUCKET_INFO));
    assertEquals(simpleBlob, simpleBlob.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    initializeExpectedBucket(4);
    expect(storage.getOptions()).andReturn(mockOptions).times(4);
    replay(storage);
    Bucket.Builder builder =
        new Bucket.Builder(new Bucket(storage, new BucketInfo.BuilderImpl(BUCKET_INFO)));
    Bucket bucket = builder.setAcl(ACLS)
        .setEtag(ETAG)
        .setGeneratedId(GENERATED_ID)
        .setMetageneration(META_GENERATION)
        .setOwner(OWNER)
        .setSelfLink(SELF_LINK)
        .setCors(CORS)
        .setCreateTime(CREATE_TIME)
        .setDefaultAcl(DEFAULT_ACL)
        .setDeleteRules(DELETE_RULES)
        .setIndexPage(INDEX_PAGE)
        .setNotFoundPage(NOT_FOUND_PAGE)
        .setLocation(LOCATION)
        .setStorageClass(STORAGE_CLASS)
        .setVersioningEnabled(VERSIONING_ENABLED)
        .setLabels(BUCKET_LABELS)
        .setRequesterPays(REQUESTER_PAYS)
        .setDefaultKmsKeyName(DEFAULT_KMS_KEY_NAME)
        .build();
    assertEquals("b", bucket.getName());
    assertEquals(ACLS, bucket.getAcl());
    assertEquals(ETAG, bucket.getEtag());
    assertEquals(GENERATED_ID, bucket.getGeneratedId());
    assertEquals(META_GENERATION, bucket.getMetageneration());
    assertEquals(OWNER, bucket.getOwner());
    assertEquals(SELF_LINK, bucket.getSelfLink());
    assertEquals(CREATE_TIME, bucket.getCreateTime());
    assertEquals(CORS, bucket.getCors());
    assertEquals(DEFAULT_ACL, bucket.getDefaultAcl());
    assertEquals(DELETE_RULES, bucket.getDeleteRules());
    assertEquals(INDEX_PAGE, bucket.getIndexPage());
    assertEquals(NOT_FOUND_PAGE, bucket.getNotFoundPage());
    assertEquals(LOCATION, bucket.getLocation());
    assertEquals(STORAGE_CLASS, bucket.getStorageClass());
    assertEquals(VERSIONING_ENABLED, bucket.versioningEnabled());
    assertEquals(BUCKET_LABELS, bucket.getLabels());
    assertEquals(REQUESTER_PAYS, bucket.requesterPays());
    assertEquals(DEFAULT_KMS_KEY_NAME, bucket.getDefaultKmsKeyName());
    assertEquals(storage.getOptions(), bucket.getStorage().getOptions());
  }
}
