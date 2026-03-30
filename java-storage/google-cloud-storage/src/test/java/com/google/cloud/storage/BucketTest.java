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

import static com.google.cloud.storage.Acl.Role.WRITER;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.gax.paging.Page;
import com.google.cloud.PageImpl;
import com.google.cloud.storage.Acl.Project;
import com.google.cloud.storage.Acl.Project.ProjectRole;
import com.google.cloud.storage.Acl.Role;
import com.google.cloud.storage.Acl.User;
import com.google.cloud.storage.BucketInfo.AgeDeleteRule;
import com.google.cloud.storage.BucketInfo.DeleteRule;
import com.google.cloud.storage.BucketInfo.LifecycleRule;
import com.google.cloud.storage.BucketInfo.LifecycleRule.LifecycleAction;
import com.google.cloud.storage.BucketInfo.LifecycleRule.LifecycleCondition;
import com.google.cloud.storage.Storage.BlobTargetOption;
import com.google.cloud.storage.Storage.BlobWriteOption;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.hash.Hashing;
import com.google.common.io.BaseEncoding;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.Key;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.crypto.spec.SecretKeySpec;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

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
  private static final Long UPDATE_TIME = CREATE_TIME - 1L;
  private static final List<Cors> CORS = Collections.singletonList(Cors.newBuilder().build());
  private static final List<Acl> DEFAULT_ACL =
      Collections.singletonList(Acl.of(User.ofAllAuthenticatedUsers(), WRITER));

  @SuppressWarnings({"unchecked", "deprecation"})
  private static final List<? extends DeleteRule> DELETE_RULES =
      Collections.singletonList(new AgeDeleteRule(5));

  private static final List<? extends BucketInfo.LifecycleRule> LIFECYCLE_RULES =
      Collections.singletonList(
          new LifecycleRule(
              LifecycleAction.newDeleteAction(),
              LifecycleCondition.newBuilder().setAge(5).build()));
  private static final String INDEX_PAGE = "index.html";
  private static final String NOT_FOUND_PAGE = "error.html";
  private static final String LOCATION = "ASIA";
  private static final StorageClass STORAGE_CLASS = StorageClass.STANDARD;
  private static final String DEFAULT_KMS_KEY_NAME =
      "projects/p/locations/kr-loc/keyRings/kr/cryptoKeys/key";
  private static final Boolean VERSIONING_ENABLED = true;
  private static final Map<String, String> BUCKET_LABELS = ImmutableMap.of("label1", "value1");
  private static final Boolean REQUESTER_PAYS = true;
  private static final String USER_PROJECT = "test-project";
  private static final Boolean DEFAULT_EVENT_BASED_HOLD = true;
  private static final Long RETENTION_EFFECTIVE_TIME = 10L;
  private static final Long RETENTION_PERIOD = 10L;
  private static final Boolean RETENTION_POLICY_IS_LOCKED = false;
  private static final List<String> LOCATION_TYPES =
      ImmutableList.of("multi-region", "region", "dual-region");
  private static final String LOCATION_TYPE = "multi-region";

  @SuppressWarnings({"unchecked", "deprecation"})
  private static final BucketInfo FULL_BUCKET_INFO =
      BucketInfo.newBuilder("b")
          .setAcl(ACLS)
          .setEtag(ETAG)
          .setGeneratedId(GENERATED_ID)
          .setMetageneration(META_GENERATION)
          .setOwner(OWNER)
          .setSelfLink(SELF_LINK)
          .setCors(CORS)
          .setCreateTime(CREATE_TIME)
          .setUpdateTime(UPDATE_TIME)
          .setDefaultAcl(DEFAULT_ACL)
          .setDeleteRules(DELETE_RULES)
          .setLifecycleRules(LIFECYCLE_RULES)
          .setIndexPage(INDEX_PAGE)
          .setNotFoundPage(NOT_FOUND_PAGE)
          .setLocation(LOCATION)
          .setStorageClass(STORAGE_CLASS)
          .setVersioningEnabled(VERSIONING_ENABLED)
          .setLabels(BUCKET_LABELS)
          .setRequesterPays(REQUESTER_PAYS)
          .setDefaultKmsKeyName(DEFAULT_KMS_KEY_NAME)
          .setDefaultEventBasedHold(DEFAULT_EVENT_BASED_HOLD)
          .setRetentionEffectiveTime(RETENTION_EFFECTIVE_TIME)
          .setRetentionPeriod(RETENTION_PERIOD)
          .setRetentionPolicyIsLocked(RETENTION_POLICY_IS_LOCKED)
          .build();

  private static final BucketInfo BUCKET_INFO =
      BucketInfo.newBuilder("b").setMetageneration(42L).build();
  private static final String CONTENT_TYPE = "text/plain";
  private static final String BASE64_KEY = "JVzfVl8NLD9FjedFuStegjRfES5ll5zc59CIXw572OA=";
  private static final Key KEY =
      new SecretKeySpec(BaseEncoding.base64().decode(BASE64_KEY), "AES256");
  private final HttpRetryAlgorithmManager retryAlgorithmManager =
      HttpStorageOptions.getDefaultInstance().getRetryAlgorithmManager();

  private Storage storage;
  private Storage serviceMockReturnsOptions = Mockito.mock(Storage.class);
  private HttpStorageOptions mockOptions = Mockito.mock(HttpStorageOptions.class);
  private Bucket bucket;
  private Bucket expectedBucket;
  private List<Blob> blobResults;

  @Before
  public void setUp() {
    storage = Mockito.mock(Storage.class);
  }

  private void initializeExpectedBucket() {
    when(serviceMockReturnsOptions.getOptions()).thenReturn(mockOptions);
    when(mockOptions.getRetryAlgorithmManager()).thenReturn(retryAlgorithmManager);
    expectedBucket = new Bucket(serviceMockReturnsOptions, new BucketInfo.BuilderImpl(BUCKET_INFO));
    blobResults =
        ImmutableList.of(
            new Blob(
                serviceMockReturnsOptions,
                new BlobInfo.BuilderImpl(BlobInfo.newBuilder("b", "n1").build())),
            new Blob(
                serviceMockReturnsOptions,
                new BlobInfo.BuilderImpl(BlobInfo.newBuilder("b", "n2").build())),
            new Blob(
                serviceMockReturnsOptions,
                new BlobInfo.BuilderImpl(BlobInfo.newBuilder("b", "n3").build())));
  }

  private void initializeBucket() {
    bucket = new Bucket(storage, new BucketInfo.BuilderImpl(BUCKET_INFO));
  }

  @Test
  public void testExists_True() throws Exception {
    initializeExpectedBucket();
    Storage.BucketGetOption[] expectedOptions = {Storage.BucketGetOption.fields()};
    when(storage.getOptions()).thenReturn(mockOptions);
    when(storage.get(BUCKET_INFO.getName(), expectedOptions)).thenReturn(expectedBucket);
    initializeBucket();
    assertTrue(bucket.exists());

    verify(storage).getOptions();
    verify(storage).get(BUCKET_INFO.getName(), expectedOptions);
  }

  @Test
  public void testExists_False() throws Exception {
    initializeExpectedBucket();
    Storage.BucketGetOption[] expectedOptions = {Storage.BucketGetOption.fields()};
    when(storage.getOptions()).thenReturn(mockOptions);
    when(storage.get(BUCKET_INFO.getName(), expectedOptions)).thenReturn(null);
    initializeBucket();
    assertFalse(bucket.exists());

    verify(storage).getOptions();
    verify(storage).get(BUCKET_INFO.getName(), expectedOptions);
  }

  @Test
  public void testReload() throws Exception {
    initializeExpectedBucket();
    BucketInfo updatedInfo = BUCKET_INFO.toBuilder().setNotFoundPage("p").build();
    Bucket expectedUpdatedBucket =
        new Bucket(serviceMockReturnsOptions, new BucketInfo.BuilderImpl(updatedInfo));
    when(storage.getOptions()).thenReturn(mockOptions);
    when(storage.get(updatedInfo.getName())).thenReturn(expectedUpdatedBucket);
    initializeBucket();
    Bucket updatedBucket = bucket.reload();
    assertEquals(expectedUpdatedBucket, updatedBucket);

    verify(storage).getOptions();
    verify(storage).get(updatedInfo.getName());
  }

  @Test
  public void testReloadNull() throws Exception {
    initializeExpectedBucket();
    when(storage.getOptions()).thenReturn(mockOptions);
    when(storage.get(BUCKET_INFO.getName())).thenReturn(null);
    initializeBucket();
    assertNull(bucket.reload());

    verify(storage).getOptions();
    verify(storage).get(BUCKET_INFO.getName());
  }

  @Test
  public void testReloadWithOptions() throws Exception {
    initializeExpectedBucket();
    BucketInfo updatedInfo = BUCKET_INFO.toBuilder().setNotFoundPage("p").build();
    Bucket expectedUpdatedBucket =
        new Bucket(serviceMockReturnsOptions, new BucketInfo.BuilderImpl(updatedInfo));
    when(storage.getOptions()).thenReturn(mockOptions);
    when(storage.get(updatedInfo.getName(), Storage.BucketGetOption.metagenerationMatch(42L)))
        .thenReturn(expectedUpdatedBucket);
    initializeBucket();
    Bucket updatedBucket = bucket.reload(Bucket.BucketSourceOption.metagenerationMatch());
    assertEquals(expectedUpdatedBucket, updatedBucket);

    verify(storage).getOptions();
    verify(storage).get(updatedInfo.getName(), Storage.BucketGetOption.metagenerationMatch(42L));
  }

  @Test
  public void testUpdate() throws Exception {
    initializeExpectedBucket();
    Bucket expectedUpdatedBucket = expectedBucket.toBuilder().setNotFoundPage("p").build();
    when(storage.getOptions()).thenReturn(mockOptions);
    when(storage.update(expectedUpdatedBucket)).thenReturn(expectedUpdatedBucket);
    initializeBucket();
    Bucket updatedBucket = new Bucket(storage, new BucketInfo.BuilderImpl(expectedUpdatedBucket));
    Bucket actualUpdatedBucket = updatedBucket.update();
    assertEquals(expectedUpdatedBucket, actualUpdatedBucket);

    verify(storage, times(2)).getOptions();
    verify(storage).update(expectedUpdatedBucket);
  }

  @Test
  public void testDelete() throws Exception {
    initializeExpectedBucket();
    when(storage.getOptions()).thenReturn(mockOptions);
    when(storage.delete(BUCKET_INFO.getName())).thenReturn(true);
    initializeBucket();
    assertTrue(bucket.delete());

    verify(storage).getOptions();
    verify(storage).delete(BUCKET_INFO.getName());
  }

  @Test
  public void testList() throws Exception {
    initializeExpectedBucket();
    PageImpl<Blob> expectedBlobPage = new PageImpl<>(null, "c", blobResults);
    when(storage.getOptions()).thenReturn(mockOptions);
    when(storage.list(BUCKET_INFO.getName())).thenReturn(expectedBlobPage);
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

    verify(storage).getOptions();
    verify(storage).list(BUCKET_INFO.getName());
  }

  @Test
  public void testGet() throws Exception {
    initializeExpectedBucket();
    Blob expectedBlob =
        new Blob(
            serviceMockReturnsOptions,
            new BlobInfo.BuilderImpl(BlobInfo.newBuilder("b", "n").build()));
    when(storage.getOptions()).thenReturn(mockOptions);
    when(storage.get(BlobId.of(expectedBucket.getName(), "n"), new Storage.BlobGetOption[0]))
        .thenReturn(expectedBlob);
    initializeBucket();
    Blob blob = bucket.get("n");
    assertEquals(expectedBlob, blob);

    verify(storage).getOptions();
    verify(storage).get(BlobId.of(expectedBucket.getName(), "n"), new Storage.BlobGetOption[0]);
  }

  @Test
  public void testGetAllArray() throws Exception {
    initializeExpectedBucket();
    when(storage.getOptions()).thenReturn(mockOptions);
    List<BlobId> blobIds =
        Lists.transform(
            blobResults,
            new Function<Blob, BlobId>() {
              @Override
              public BlobId apply(Blob blob) {
                return blob.getBlobId();
              }
            });
    when(storage.get(blobIds)).thenReturn(blobResults);
    initializeBucket();
    assertEquals(blobResults, bucket.get("n1", "n2", "n3"));

    verify(storage).getOptions();
    verify(storage).get(blobIds);
  }

  @Test
  public void testGetAllIterable() throws Exception {
    initializeExpectedBucket();
    when(storage.getOptions()).thenReturn(mockOptions);
    List<BlobId> blobIds =
        Lists.transform(
            blobResults,
            new Function<Blob, BlobId>() {
              @Override
              public BlobId apply(Blob blob) {
                return blob.getBlobId();
              }
            });
    when(storage.get(blobIds)).thenReturn(blobResults);
    initializeBucket();
    assertEquals(blobResults, bucket.get(ImmutableList.of("n1", "n2", "n3")));

    verify(storage).getOptions();
    verify(storage).get(blobIds);
  }

  @Test
  public void testCreate() throws Exception {
    initializeExpectedBucket();
    BlobInfo info = BlobInfo.newBuilder("b", "n").setContentType(CONTENT_TYPE).build();
    Blob expectedBlob = new Blob(serviceMockReturnsOptions, new BlobInfo.BuilderImpl(info));
    byte[] content = {0xD, 0xE, 0xA, 0xD};
    when(storage.getOptions()).thenReturn(mockOptions);
    when(storage.create(info, content)).thenReturn(expectedBlob);
    initializeBucket();
    Blob blob = bucket.create("n", content, CONTENT_TYPE);
    assertEquals(expectedBlob, blob);

    verify(storage).getOptions();
    verify(storage).create(info, content);
  }

  @Test
  public void testCreateNoContentType() throws Exception {
    initializeExpectedBucket();
    BlobInfo info = BlobInfo.newBuilder("b", "n").build();
    Blob expectedBlob = new Blob(serviceMockReturnsOptions, new BlobInfo.BuilderImpl(info));
    byte[] content = {0xD, 0xE, 0xA, 0xD};
    when(storage.getOptions()).thenReturn(mockOptions);
    when(storage.create(info, content)).thenReturn(expectedBlob);
    initializeBucket();
    Blob blob = bucket.create("n", content);
    assertEquals(expectedBlob, blob);

    verify(storage).getOptions();
    verify(storage).create(info, content);
  }

  @Test
  public void testCreateWithOptions() throws Exception {
    initializeExpectedBucket();
    BlobInfo info = BlobInfo.newBuilder(BlobId.of("b", "n")).setContentType(CONTENT_TYPE).build();
    Blob expectedBlob = new Blob(serviceMockReturnsOptions, new BlobInfo.BuilderImpl(info));
    byte[] content = {0xD, 0xE, 0xA, 0xD};
    Storage.PredefinedAcl acl = Storage.PredefinedAcl.ALL_AUTHENTICATED_USERS;
    when(storage.getOptions()).thenReturn(mockOptions);
    when(storage.create(
            info,
            content,
            new BlobTargetOption(UnifiedOpts.generationMatch(42L)),
            new BlobTargetOption(UnifiedOpts.metagenerationMatch(24L)),
            Storage.BlobTargetOption.predefinedAcl(acl),
            Storage.BlobTargetOption.encryptionKey(BASE64_KEY),
            Storage.BlobTargetOption.userProject(USER_PROJECT)))
        .thenReturn(expectedBlob);
    initializeBucket();
    Blob blob =
        bucket.create(
            "n",
            content,
            CONTENT_TYPE,
            Bucket.BlobTargetOption.generationMatch(42L),
            Bucket.BlobTargetOption.metagenerationMatch(24L),
            Bucket.BlobTargetOption.predefinedAcl(acl),
            Bucket.BlobTargetOption.encryptionKey(BASE64_KEY),
            Bucket.BlobTargetOption.userProject(USER_PROJECT));
    assertEquals(expectedBlob, blob);

    verify(storage).getOptions();
    verify(storage)
        .create(
            info,
            content,
            new BlobTargetOption(UnifiedOpts.generationMatch(42L)),
            new BlobTargetOption(UnifiedOpts.metagenerationMatch(24L)),
            Storage.BlobTargetOption.predefinedAcl(acl),
            Storage.BlobTargetOption.encryptionKey(BASE64_KEY),
            Storage.BlobTargetOption.userProject(USER_PROJECT));
  }

  @Test
  public void testCreateWithEncryptionKey() throws Exception {
    initializeExpectedBucket();
    BlobInfo info = BlobInfo.newBuilder(BlobId.of("b", "n")).setContentType(CONTENT_TYPE).build();
    Blob expectedBlob = new Blob(serviceMockReturnsOptions, new BlobInfo.BuilderImpl(info));
    byte[] content = {0xD, 0xE, 0xA, 0xD};
    when(storage.getOptions()).thenReturn(mockOptions);
    when(storage.create(info, content, Storage.BlobTargetOption.encryptionKey(KEY)))
        .thenReturn(expectedBlob);
    initializeBucket();
    Blob blob =
        bucket.create("n", content, CONTENT_TYPE, Bucket.BlobTargetOption.encryptionKey(KEY));
    assertEquals(expectedBlob, blob);

    verify(storage).getOptions();
    verify(storage).create(info, content, Storage.BlobTargetOption.encryptionKey(KEY));
  }

  @Test
  public void testCreateWithKmsKeyName() throws Exception {
    initializeExpectedBucket();
    BlobInfo info = BlobInfo.newBuilder(BlobId.of("b", "n")).setContentType(CONTENT_TYPE).build();
    Blob expectedBlob = new Blob(serviceMockReturnsOptions, new BlobInfo.BuilderImpl(info));
    byte[] content = {0xD, 0xE, 0xA, 0xD};
    when(storage.getOptions()).thenReturn(mockOptions);
    when(storage.create(info, content, Storage.BlobTargetOption.kmsKeyName(DEFAULT_KMS_KEY_NAME)))
        .thenReturn(expectedBlob);
    initializeBucket();
    Blob blob =
        bucket.create(
            "n", content, CONTENT_TYPE, Bucket.BlobTargetOption.kmsKeyName(DEFAULT_KMS_KEY_NAME));
    assertEquals(expectedBlob, blob);

    verify(storage).getOptions();
    verify(storage)
        .create(info, content, Storage.BlobTargetOption.kmsKeyName(DEFAULT_KMS_KEY_NAME));
  }

  @Test
  public void testCreateNotExists() throws Exception {
    initializeExpectedBucket();
    BlobInfo info = BlobInfo.newBuilder(BlobId.of("b", "n")).setContentType(CONTENT_TYPE).build();
    Blob expectedBlob = new Blob(serviceMockReturnsOptions, new BlobInfo.BuilderImpl(info));
    byte[] content = {0xD, 0xE, 0xA, 0xD};
    when(storage.getOptions()).thenReturn(mockOptions);
    when(storage.create(info, content, new BlobTargetOption(UnifiedOpts.doesNotExist())))
        .thenReturn(expectedBlob);
    initializeBucket();
    Blob blob = bucket.create("n", content, CONTENT_TYPE, Bucket.BlobTargetOption.doesNotExist());
    assertEquals(expectedBlob, blob);

    verify(storage).getOptions();
    verify(storage).create(info, content, new BlobTargetOption(UnifiedOpts.doesNotExist()));
  }

  @Test
  @SuppressWarnings({"unchecked", "deprecation"})
  public void testCreateFromStream() throws Exception {
    initializeExpectedBucket();
    BlobInfo info = BlobInfo.newBuilder("b", "n").setContentType(CONTENT_TYPE).build();
    Blob expectedBlob = new Blob(serviceMockReturnsOptions, new BlobInfo.BuilderImpl(info));
    byte[] content = {0xD, 0xE, 0xA, 0xD};
    InputStream streamContent = new ByteArrayInputStream(content);
    when(storage.getOptions()).thenReturn(mockOptions);
    when(storage.create(info, streamContent)).thenReturn(expectedBlob);
    initializeBucket();
    Blob blob = bucket.create("n", streamContent, CONTENT_TYPE);
    assertEquals(expectedBlob, blob);

    verify(storage).getOptions();
    verify(storage).create(info, streamContent);
  }

  @Test
  @SuppressWarnings({"unchecked", "deprecation"})
  public void testCreateFromStreamNoContentType() throws Exception {
    initializeExpectedBucket();
    BlobInfo info = BlobInfo.newBuilder("b", "n").build();
    Blob expectedBlob = new Blob(serviceMockReturnsOptions, new BlobInfo.BuilderImpl(info));
    byte[] content = {0xD, 0xE, 0xA, 0xD};
    InputStream streamContent = new ByteArrayInputStream(content);
    when(storage.getOptions()).thenReturn(mockOptions);
    when(storage.create(info, streamContent)).thenReturn(expectedBlob);
    initializeBucket();
    Blob blob = bucket.create("n", streamContent);
    assertEquals(expectedBlob, blob);

    verify(storage).getOptions();
    verify(storage).create(info, streamContent);
  }

  @Test
  @SuppressWarnings({"unchecked", "deprecation"})
  public void testCreateFromStreamWithOptions() throws Exception {
    initializeExpectedBucket();
    BlobInfo info = BlobInfo.newBuilder(BlobId.of("b", "n")).setContentType(CONTENT_TYPE).build();
    Blob expectedBlob = info.asBlob(serviceMockReturnsOptions);
    byte[] content = {0xD, 0xE, 0xA, 0xD};
    String crc32c = Utils.crc32cCodec.encode(Hashing.crc32c().hashBytes(content).asInt());
    Storage.PredefinedAcl acl = Storage.PredefinedAcl.ALL_AUTHENTICATED_USERS;
    InputStream streamContent = new ByteArrayInputStream(content);
    when(storage.getOptions()).thenReturn(mockOptions);
    when(storage.create(
            info,
            streamContent,
            new BlobWriteOption(UnifiedOpts.generationMatch(42L)),
            new BlobWriteOption(UnifiedOpts.metagenerationMatch(24L)),
            Storage.BlobWriteOption.predefinedAcl(acl),
            new BlobWriteOption(UnifiedOpts.crc32cMatch(crc32c)),
            new BlobWriteOption(UnifiedOpts.md5Match("md5")),
            Storage.BlobWriteOption.encryptionKey(BASE64_KEY),
            Storage.BlobWriteOption.userProject(USER_PROJECT)))
        .thenReturn(expectedBlob);
    initializeBucket();
    Blob blob =
        bucket.create(
            "n",
            streamContent,
            CONTENT_TYPE,
            Bucket.BlobWriteOption.generationMatch(42L),
            Bucket.BlobWriteOption.metagenerationMatch(24L),
            Bucket.BlobWriteOption.predefinedAcl(acl),
            Bucket.BlobWriteOption.crc32cMatch(crc32c),
            Bucket.BlobWriteOption.md5Match("md5"),
            Bucket.BlobWriteOption.encryptionKey(BASE64_KEY),
            Bucket.BlobWriteOption.userProject(USER_PROJECT));
    assertEquals(expectedBlob, blob);

    verify(storage).getOptions();
    verify(storage)
        .create(
            info,
            streamContent,
            new BlobWriteOption(UnifiedOpts.generationMatch(42L)),
            new BlobWriteOption(UnifiedOpts.metagenerationMatch(24L)),
            Storage.BlobWriteOption.predefinedAcl(acl),
            new BlobWriteOption(UnifiedOpts.crc32cMatch(crc32c)),
            new BlobWriteOption(UnifiedOpts.md5Match("md5")),
            Storage.BlobWriteOption.encryptionKey(BASE64_KEY),
            Storage.BlobWriteOption.userProject(USER_PROJECT));
  }

  @Test
  @SuppressWarnings({"unchecked", "deprecation"})
  public void testCreateFromStreamWithEncryptionKey() throws Exception {
    initializeExpectedBucket();
    BlobInfo info = BlobInfo.newBuilder(BlobId.of("b", "n")).setContentType(CONTENT_TYPE).build();
    Blob expectedBlob = new Blob(serviceMockReturnsOptions, new BlobInfo.BuilderImpl(info));
    byte[] content = {0xD, 0xE, 0xA, 0xD};
    InputStream streamContent = new ByteArrayInputStream(content);
    when(storage.getOptions()).thenReturn(mockOptions);
    when(storage.create(info, streamContent, Storage.BlobWriteOption.encryptionKey(KEY)))
        .thenReturn(expectedBlob);
    initializeBucket();
    Blob blob =
        bucket.create("n", streamContent, CONTENT_TYPE, Bucket.BlobWriteOption.encryptionKey(KEY));
    assertEquals(expectedBlob, blob);

    verify(storage).getOptions();
    verify(storage).create(info, streamContent, Storage.BlobWriteOption.encryptionKey(KEY));
  }

  @Test
  @SuppressWarnings({"unchecked", "deprecation"})
  public void testCreateFromStreamNotExists() throws Exception {
    initializeExpectedBucket();
    BlobInfo info = BlobInfo.newBuilder(BlobId.of("b", "n")).setContentType(CONTENT_TYPE).build();
    Blob expectedBlob = info.asBlob(serviceMockReturnsOptions);
    byte[] content = {0xD, 0xE, 0xA, 0xD};
    InputStream streamContent = new ByteArrayInputStream(content);
    when(storage.getOptions()).thenReturn(mockOptions);
    when(storage.create(info, streamContent, new BlobWriteOption(UnifiedOpts.doesNotExist())))
        .thenReturn(expectedBlob);
    initializeBucket();
    Blob blob =
        bucket.create("n", streamContent, CONTENT_TYPE, Bucket.BlobWriteOption.doesNotExist());
    assertEquals(expectedBlob, blob);

    verify(storage).getOptions();
    verify(storage).create(info, streamContent, new BlobWriteOption(UnifiedOpts.doesNotExist()));
  }

  @Test
  public void testGetAcl() throws Exception {
    initializeExpectedBucket();
    when(storage.getOptions()).thenReturn(mockOptions);
    when(storage.getAcl(BUCKET_INFO.getName(), User.ofAllAuthenticatedUsers())).thenReturn(ACL);
    initializeBucket();
    assertEquals(ACL, bucket.getAcl(User.ofAllAuthenticatedUsers()));

    verify(storage).getOptions();
    verify(storage).getAcl(BUCKET_INFO.getName(), User.ofAllAuthenticatedUsers());
  }

  @Test
  public void testDeleteAcl() throws Exception {
    initializeExpectedBucket();
    when(storage.getOptions()).thenReturn(mockOptions);
    when(storage.deleteAcl(BUCKET_INFO.getName(), User.ofAllAuthenticatedUsers())).thenReturn(true);
    initializeBucket();
    assertTrue(bucket.deleteAcl(User.ofAllAuthenticatedUsers()));

    verify(storage).getOptions();
    verify(storage).deleteAcl(BUCKET_INFO.getName(), User.ofAllAuthenticatedUsers());
  }

  @Test
  public void testCreateAcl() throws Exception {
    initializeExpectedBucket();
    when(storage.getOptions()).thenReturn(mockOptions);
    Acl returnedAcl = ACL.toBuilder().setEtag("ETAG").setId("ID").build();
    when(storage.createAcl(BUCKET_INFO.getName(), ACL)).thenReturn(returnedAcl);
    initializeBucket();
    assertEquals(returnedAcl, bucket.createAcl(ACL));

    verify(storage).getOptions();
    verify(storage).createAcl(BUCKET_INFO.getName(), ACL);
  }

  @Test
  public void testUpdateAcl() throws Exception {
    initializeExpectedBucket();
    when(storage.getOptions()).thenReturn(mockOptions);
    Acl returnedAcl = ACL.toBuilder().setEtag("ETAG").setId("ID").build();
    when(storage.updateAcl(BUCKET_INFO.getName(), ACL)).thenReturn(returnedAcl);
    initializeBucket();
    assertEquals(returnedAcl, bucket.updateAcl(ACL));
    verify(storage).getOptions();
    verify(storage).updateAcl(BUCKET_INFO.getName(), ACL);
  }

  @Test
  public void testListAcls() throws Exception {
    initializeExpectedBucket();
    when(storage.getOptions()).thenReturn(mockOptions);
    when(storage.listAcls(BUCKET_INFO.getName())).thenReturn(ACLS);
    initializeBucket();
    assertEquals(ACLS, bucket.listAcls());

    verify(storage).getOptions();
    verify(storage).listAcls(BUCKET_INFO.getName());
  }

  @Test
  public void testGetDefaultAcl() throws Exception {
    initializeExpectedBucket();
    when(storage.getOptions()).thenReturn(mockOptions);
    when(storage.getDefaultAcl(BUCKET_INFO.getName(), User.ofAllAuthenticatedUsers()))
        .thenReturn(ACL);
    initializeBucket();
    assertEquals(ACL, bucket.getDefaultAcl(User.ofAllAuthenticatedUsers()));

    verify(storage).getOptions();
    verify(storage).getDefaultAcl(BUCKET_INFO.getName(), User.ofAllAuthenticatedUsers());
  }

  @Test
  public void testDeleteDefaultAcl() throws Exception {
    initializeExpectedBucket();
    when(storage.getOptions()).thenReturn(mockOptions);
    when(storage.deleteDefaultAcl(BUCKET_INFO.getName(), User.ofAllAuthenticatedUsers()))
        .thenReturn(true);
    initializeBucket();
    assertTrue(bucket.deleteDefaultAcl(User.ofAllAuthenticatedUsers()));

    verify(storage).getOptions();
    verify(storage).deleteDefaultAcl(BUCKET_INFO.getName(), User.ofAllAuthenticatedUsers());
  }

  @Test
  public void testCreateDefaultAcl() throws Exception {
    initializeExpectedBucket();
    when(storage.getOptions()).thenReturn(mockOptions);
    Acl returnedAcl = ACL.toBuilder().setEtag("ETAG").setId("ID").build();
    when(storage.createDefaultAcl(BUCKET_INFO.getName(), ACL)).thenReturn(returnedAcl);
    initializeBucket();
    assertEquals(returnedAcl, bucket.createDefaultAcl(ACL));

    verify(storage).getOptions();
    verify(storage).createDefaultAcl(BUCKET_INFO.getName(), ACL);
  }

  @Test
  public void testUpdateDefaultAcl() throws Exception {
    initializeExpectedBucket();
    when(storage.getOptions()).thenReturn(mockOptions);
    Acl returnedAcl = ACL.toBuilder().setEtag("ETAG").setId("ID").build();
    when(storage.updateDefaultAcl(BUCKET_INFO.getName(), ACL)).thenReturn(returnedAcl);
    initializeBucket();
    assertEquals(returnedAcl, bucket.updateDefaultAcl(ACL));

    verify(storage).getOptions();
    verify(storage).updateDefaultAcl(BUCKET_INFO.getName(), ACL);
  }

  @Test
  public void testListDefaultAcls() throws Exception {
    initializeExpectedBucket();
    when(storage.getOptions()).thenReturn(mockOptions);
    when(storage.listDefaultAcls(BUCKET_INFO.getName())).thenReturn(ACLS);
    initializeBucket();
    assertEquals(ACLS, bucket.listDefaultAcls());

    verify(storage).getOptions();
    verify(storage).listDefaultAcls(BUCKET_INFO.getName());
  }

  @Test
  public void testLockRetention() throws Exception {
    initializeExpectedBucket();
    Bucket expectedRetentionLockedBucket =
        expectedBucket.toBuilder()
            .setRetentionPeriod(RETENTION_PERIOD)
            .setRetentionPolicyIsLocked(true)
            .build();
    when(storage.getOptions()).thenReturn(mockOptions);
    when(storage.lockRetentionPolicy(
            expectedRetentionLockedBucket,
            Storage.BucketTargetOption.metagenerationMatch(),
            Storage.BucketTargetOption.userProject(USER_PROJECT)))
        .thenReturn(expectedRetentionLockedBucket);
    initializeBucket();
    Bucket lockedRetentionPolicyBucket =
        new Bucket(storage, new BucketInfo.BuilderImpl(expectedRetentionLockedBucket));
    Bucket actualRetentionLockedBucket =
        lockedRetentionPolicyBucket.lockRetentionPolicy(
            Storage.BucketTargetOption.metagenerationMatch(),
            Storage.BucketTargetOption.userProject(USER_PROJECT));
    assertEquals(expectedRetentionLockedBucket, actualRetentionLockedBucket);

    verify(storage, times(2)).getOptions();
    verify(storage)
        .lockRetentionPolicy(
            expectedRetentionLockedBucket,
            Storage.BucketTargetOption.metagenerationMatch(),
            Storage.BucketTargetOption.userProject(USER_PROJECT));
  }

  @Test
  @SuppressWarnings({"unchecked", "deprecation"})
  public void testToBuilder() {
    when(storage.getOptions()).thenReturn(mockOptions);
    Bucket fullBucket = new Bucket(storage, new BucketInfo.BuilderImpl(FULL_BUCKET_INFO));
    assertEquals(fullBucket, fullBucket.toBuilder().build());
    Bucket simpleBlob = new Bucket(storage, new BucketInfo.BuilderImpl(BUCKET_INFO));
    assertEquals(simpleBlob, simpleBlob.toBuilder().build());
  }

  @Test
  @SuppressWarnings({"unchecked", "deprecation"})
  public void testBuilder() {
    initializeExpectedBucket();
    when(storage.getOptions()).thenReturn(mockOptions);
    Bucket.Builder builder =
        new Bucket.Builder(new Bucket(storage, new BucketInfo.BuilderImpl(BUCKET_INFO)));
    Bucket bucket =
        builder
            .setAcl(ACLS)
            .setEtag(ETAG)
            .setGeneratedId(GENERATED_ID)
            .setMetageneration(META_GENERATION)
            .setOwner(OWNER)
            .setSelfLink(SELF_LINK)
            .setCors(CORS)
            .setCreateTime(CREATE_TIME)
            .setUpdateTime(UPDATE_TIME)
            .setDefaultAcl(DEFAULT_ACL)
            .setDeleteRules(DELETE_RULES)
            .setLifecycleRules(LIFECYCLE_RULES)
            .setIndexPage(INDEX_PAGE)
            .setNotFoundPage(NOT_FOUND_PAGE)
            .setLocation(LOCATION)
            .setLocationType(LOCATION_TYPE)
            .setStorageClass(STORAGE_CLASS)
            .setVersioningEnabled(VERSIONING_ENABLED)
            .setLabels(BUCKET_LABELS)
            .setRequesterPays(REQUESTER_PAYS)
            .setDefaultKmsKeyName(DEFAULT_KMS_KEY_NAME)
            .setDefaultEventBasedHold(DEFAULT_EVENT_BASED_HOLD)
            .setRetentionEffectiveTime(RETENTION_EFFECTIVE_TIME)
            .setRetentionPeriod(RETENTION_PERIOD)
            .setRetentionPolicyIsLocked(RETENTION_POLICY_IS_LOCKED)
            .build();
    assertEquals("b", bucket.getName());
    assertEquals(ACLS, bucket.getAcl());
    assertEquals(ETAG, bucket.getEtag());
    assertEquals(GENERATED_ID, bucket.getGeneratedId());
    assertEquals(META_GENERATION, bucket.getMetageneration());
    assertEquals(OWNER, bucket.getOwner());
    assertEquals(SELF_LINK, bucket.getSelfLink());
    assertEquals(CREATE_TIME, bucket.getCreateTime());
    assertEquals(UPDATE_TIME, bucket.getUpdateTime());
    assertEquals(CORS, bucket.getCors());
    assertEquals(DEFAULT_ACL, bucket.getDefaultAcl());
    assertEquals(DELETE_RULES, bucket.getDeleteRules());
    assertEquals(LIFECYCLE_RULES, bucket.getLifecycleRules());
    assertEquals(INDEX_PAGE, bucket.getIndexPage());
    assertEquals(NOT_FOUND_PAGE, bucket.getNotFoundPage());
    assertEquals(LOCATION, bucket.getLocation());
    assertEquals(STORAGE_CLASS, bucket.getStorageClass());
    assertEquals(VERSIONING_ENABLED, bucket.versioningEnabled());
    assertEquals(BUCKET_LABELS, bucket.getLabels());
    assertEquals(REQUESTER_PAYS, bucket.requesterPays());
    assertEquals(DEFAULT_KMS_KEY_NAME, bucket.getDefaultKmsKeyName());
    assertEquals(DEFAULT_EVENT_BASED_HOLD, bucket.getDefaultEventBasedHold());
    assertEquals(RETENTION_EFFECTIVE_TIME, bucket.getRetentionEffectiveTime());
    assertEquals(RETENTION_PERIOD, bucket.getRetentionPeriod());
    assertEquals(RETENTION_POLICY_IS_LOCKED, bucket.retentionPolicyIsLocked());
    assertEquals(storage.getOptions(), bucket.getStorage().getOptions());
    assertTrue(LOCATION_TYPES.contains(LOCATION_TYPE));
  }

  @Test
  public void testDeleteLifecycleRules() {
    initializeExpectedBucket();
    Bucket bucket =
        new Bucket(serviceMockReturnsOptions, new BucketInfo.BuilderImpl(FULL_BUCKET_INFO));
    assertThat(bucket.getLifecycleRules()).hasSize(1);
    Bucket expectedUpdatedBucket = bucket.toBuilder().deleteLifecycleRules().build();
    when(storage.getOptions()).thenReturn(mockOptions);
    when(storage.update(expectedUpdatedBucket)).thenReturn(expectedUpdatedBucket);
    initializeBucket();
    Bucket updatedBucket = new Bucket(storage, new BucketInfo.BuilderImpl(expectedUpdatedBucket));
    Bucket actualUpdatedBucket = updatedBucket.update();
    assertThat(actualUpdatedBucket.getLifecycleRules()).hasSize(0);

    verify(storage, times(2)).getOptions();
    verify(storage).update(expectedUpdatedBucket);
  }

  @Test
  public void testUpdateBucketLogging() {
    initializeExpectedBucket();
    BucketInfo.Logging logging =
        BucketInfo.Logging.newBuilder()
            .setLogBucket("logs-bucket")
            .setLogObjectPrefix("test-logs")
            .build();
    BucketInfo bucketInfo = BucketInfo.newBuilder("b").setLogging(logging).build();
    Bucket bucket = new Bucket(serviceMockReturnsOptions, new BucketInfo.BuilderImpl(bucketInfo));
    assertThat(bucket.getLogging().getLogBucket()).isEqualTo("logs-bucket");
    assertThat(bucket.getLogging().getLogObjectPrefix()).isEqualTo("test-logs");
    Bucket expectedUpdatedBucket = bucket.toBuilder().setLogging(null).build();
    when(storage.getOptions()).thenReturn(mockOptions);
    when(storage.update(expectedUpdatedBucket)).thenReturn(expectedUpdatedBucket);
    initializeBucket();
    Bucket updatedBucket = new Bucket(storage, new BucketInfo.BuilderImpl(expectedUpdatedBucket));
    Bucket actualUpdatedBucket = updatedBucket.update();
    assertThat(actualUpdatedBucket.getLogging().getLogBucket()).isNull();
    assertThat(actualUpdatedBucket.getLogging().getLogObjectPrefix()).isNull();

    verify(storage, times(2)).getOptions();
    verify(storage).update(expectedUpdatedBucket);
  }

  @Test
  public void testRemoveBucketCORS() {
    initializeExpectedBucket();
    List<Cors.Origin> origins = ImmutableList.of(Cors.Origin.of("http://cloud.google.com"));
    List<HttpMethod> httpMethods = ImmutableList.of(HttpMethod.GET);
    List<String> responseHeaders = ImmutableList.of("Content-Type");
    Cors cors =
        Cors.newBuilder()
            .setOrigins(origins)
            .setMethods(httpMethods)
            .setResponseHeaders(responseHeaders)
            .setMaxAgeSeconds(100)
            .build();
    BucketInfo bucketInfo = BucketInfo.newBuilder("b").setCors(ImmutableList.of(cors)).build();
    Bucket bucket = new Bucket(serviceMockReturnsOptions, new BucketInfo.BuilderImpl(bucketInfo));
    assertThat(bucket.getCors()).isNotNull();
    assertThat(bucket.getCors().get(0).getMaxAgeSeconds()).isEqualTo(100);
    assertThat(bucket.getCors().get(0).getMethods()).isEqualTo(httpMethods);
    assertThat(bucket.getCors().get(0).getOrigins()).isEqualTo(origins);
    assertThat(bucket.getCors().get(0).getResponseHeaders()).isEqualTo(responseHeaders);

    // Remove bucket CORS configuration.
    Bucket expectedUpdatedBucket = bucket.toBuilder().setCors(null).build();
    when(storage.getOptions()).thenReturn(mockOptions);
    when(storage.update(expectedUpdatedBucket)).thenReturn(expectedUpdatedBucket);
    initializeBucket();
    Bucket updatedBucket = new Bucket(storage, new BucketInfo.BuilderImpl(expectedUpdatedBucket));
    Bucket actualUpdatedBucket = updatedBucket.update();
    assertThat(actualUpdatedBucket.getCors()).isEmpty();

    verify(storage, times(2)).getOptions();
    verify(storage).update(expectedUpdatedBucket);
  }
}
