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

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.core.ApiClock;
import com.google.api.gax.retrying.RetrySettings;
import com.google.cloud.ReadChannel;
import com.google.cloud.storage.Acl.Project;
import com.google.cloud.storage.Acl.Project.ProjectRole;
import com.google.cloud.storage.Acl.Role;
import com.google.cloud.storage.Acl.User;
import com.google.cloud.storage.Blob.BlobSourceOption;
import com.google.cloud.storage.BlobInfo.BuilderImpl;
import com.google.cloud.storage.BlobInfo.ObjectContexts;
import com.google.cloud.storage.BlobInfo.ObjectCustomContextPayload;
import com.google.cloud.storage.Storage.CopyRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.io.BaseEncoding;
import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.security.Key;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.crypto.spec.SecretKeySpec;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

public class BlobTest {

  private static final Acl ACL = Acl.of(User.ofAllAuthenticatedUsers(), Role.OWNER);
  private static final Acl OTHER_ACL = Acl.of(new Project(ProjectRole.OWNERS, "p"), Role.READER);
  private static final List<Acl> ACLS = ImmutableList.of(ACL, OTHER_ACL);
  private static final Integer COMPONENT_COUNT = 2;
  private static final String CONTENT_TYPE = "text/html";
  private static final String CACHE_CONTROL = "cache";
  private static final String CONTENT_DISPOSITION = "content-disposition";
  private static final String CONTENT_ENCODING = "UTF-8";
  private static final String CONTENT_LANGUAGE = "En";
  private static final String CRC32 = "FF00";
  private static final String CRC32_HEX_STRING = "145d34";
  private static final Long DELETE_TIME = System.currentTimeMillis();
  private static final String ETAG = "0xFF00";
  private static final Long GENERATION = 1L;
  private static final String GENERATED_ID = "B/N:1";
  private static final String MD5 = "FF00";
  private static final String MD5_HEX_STRING = "145d34";
  private static final String MEDIA_LINK = "http://media/b/n";
  private static final Map<String, String> METADATA = ImmutableMap.of("n1", "v1", "n2", "v2");
  private static final Long META_GENERATION = 10L;
  private static final User OWNER = new User("user@gmail.com");
  private static final String SELF_LINK = "http://storage/b/n";
  private static final Long SIZE = 1024L;
  private static final Long UPDATE_TIME = DELETE_TIME - 1L;
  private static final Long CREATE_TIME = UPDATE_TIME - 1L;
  private static final Long CUSTOM_TIME = CREATE_TIME - 1L;
  private static final StorageClass STORAGE_CLASS = StorageClass.COLDLINE;
  private static final Long TIME_STORAGE_CLASS_UPDATED = CREATE_TIME;
  private static final String ENCRYPTION_ALGORITHM = "AES256";
  private static final String KEY_SHA256 = "keySha";
  private static final BlobInfo.CustomerEncryption CUSTOMER_ENCRYPTION =
      new BlobInfo.CustomerEncryption(ENCRYPTION_ALGORITHM, KEY_SHA256);
  private static final String KMS_KEY_NAME =
      "projects/p/locations/kr-loc/keyRings/kr/cryptoKeys/key";
  private static final Boolean EVENT_BASED_HOLD = true;
  private static final Boolean TEMPORARY_HOLD = true;
  private static final Long RETENTION_EXPIRATION_TIME = 10L;
  private static final ObjectCustomContextPayload payload =
      ObjectCustomContextPayload.newBuilder().setValue("contextValue").build();
  private static final Map<String, ObjectCustomContextPayload> customContexts =
      Collections.singletonMap("contextKey", payload);
  private static final ObjectContexts OBJECT_CONTEXTS =
      ObjectContexts.newBuilder().setCustom(customContexts).build();
  private static final BlobInfo FULL_BLOB_INFO =
      BlobInfo.newBuilder("b", "n", GENERATION)
          .setAcl(ACLS)
          .setComponentCount(COMPONENT_COUNT)
          .setContentType(CONTENT_TYPE)
          .setCacheControl(CACHE_CONTROL)
          .setContentDisposition(CONTENT_DISPOSITION)
          .setContentEncoding(CONTENT_ENCODING)
          .setContentLanguage(CONTENT_LANGUAGE)
          .setCrc32c(CRC32)
          .setDeleteTime(DELETE_TIME)
          .setEtag(ETAG)
          .setGeneratedId(GENERATED_ID)
          .setMd5(MD5)
          .setMediaLink(MEDIA_LINK)
          .setMetadata(METADATA)
          .setMetageneration(META_GENERATION)
          .setOwner(OWNER)
          .setSelfLink(SELF_LINK)
          .setSize(SIZE)
          .setUpdateTime(UPDATE_TIME)
          .setCreateTime(CREATE_TIME)
          .setCustomTime(CUSTOM_TIME)
          .setStorageClass(STORAGE_CLASS)
          .setTimeStorageClassUpdated(TIME_STORAGE_CLASS_UPDATED)
          .setCustomerEncryption(CUSTOMER_ENCRYPTION)
          .setKmsKeyName(KMS_KEY_NAME)
          .setEventBasedHold(EVENT_BASED_HOLD)
          .setTemporaryHold(TEMPORARY_HOLD)
          .setRetentionExpirationTime(RETENTION_EXPIRATION_TIME)
          .setContexts(OBJECT_CONTEXTS)
          .build();
  private static final BlobInfo BLOB_INFO =
      BlobInfo.newBuilder("b", "n", 12345678L).setMetageneration(42L).build();
  private static final BlobInfo BLOB_INFO_NO_GENERATION =
      BlobInfo.newBuilder(BLOB_INFO.getBucket(), BLOB_INFO.getName())
          .setMetageneration(42L)
          .build();
  private static final BlobInfo DIRECTORY_INFO =
      BlobInfo.newBuilder("b", "n/").setSize(0L).setIsDirectory(true).build();
  private static final String BASE64_KEY = "JVzfVl8NLD9FjedFuStegjRfES5ll5zc59CIXw572OA=";
  private static final Key KEY =
      new SecretKeySpec(BaseEncoding.base64().decode(BASE64_KEY), "AES256");

  // This retrying setting is used by test testDownloadWithRetries. This unit test is setup
  // to write one byte and then throw retryable exception, it then writes another bytes on
  // second call succeeds.
  private static final RetrySettings RETRY_SETTINGS =
      RetrySettings.newBuilder().setMaxAttempts(2).build();
  private static final ApiClock API_CLOCK =
      new ApiClock() {
        @Override
        public long nanoTime() {
          return 42_000_000_000L;
        }

        @Override
        public long millisTime() {
          return 42_000L;
        }
      };

  private Storage storage;
  private Blob blob;
  private Blob expectedBlob;
  private Storage serviceMockReturnsOptions = Mockito.mock(Storage.class);
  private HttpStorageOptions mockOptions = Mockito.mock(HttpStorageOptions.class);
  private final HttpRetryAlgorithmManager retryAlgorithmManager =
      HttpStorageOptions.getDefaultInstance().getRetryAlgorithmManager();

  @Before
  public void setUp() {
    storage = Mockito.mock(Storage.class);
  }

  private void initializeExpectedBlob() {
    when(serviceMockReturnsOptions.getOptions()).thenReturn(mockOptions);
    when(mockOptions.getRetryAlgorithmManager()).thenReturn(retryAlgorithmManager);
    expectedBlob = new Blob(serviceMockReturnsOptions, new BlobInfo.BuilderImpl(BLOB_INFO));
  }

  private void initializeBlob() {
    blob = new Blob(storage, new BlobInfo.BuilderImpl(BLOB_INFO));
  }

  @Test
  public void testExists_True() throws Exception {
    initializeExpectedBlob();
    Storage.BlobGetOption[] expectedOptions = {Storage.BlobGetOption.fields()};
    when(storage.getOptions()).thenReturn(mockOptions);
    when(storage.get(expectedBlob.getBlobId(), expectedOptions)).thenReturn(expectedBlob);
    initializeBlob();
    assertTrue(blob.exists());

    verify(storage).getOptions();
    verify(storage).get(expectedBlob.getBlobId(), expectedOptions);
  }

  @Test
  public void testExists_False() throws Exception {
    Storage.BlobGetOption[] expectedOptions = {Storage.BlobGetOption.fields()};
    when(storage.getOptions()).thenReturn(mockOptions);
    when(storage.get(BLOB_INFO.getBlobId(), expectedOptions)).thenReturn(null);
    initializeBlob();
    assertFalse(blob.exists());

    verify(storage).getOptions();
    verify(storage).get(BLOB_INFO.getBlobId(), expectedOptions);
  }

  @Test
  public void testContent() throws Exception {
    initializeExpectedBlob();
    byte[] content = {1, 2};
    when(storage.getOptions()).thenReturn(mockOptions);
    when(storage.readAllBytes(BLOB_INFO.getBlobId())).thenReturn(content);
    initializeBlob();
    assertArrayEquals(content, blob.getContent());

    verify(storage).getOptions();
    verify(storage).readAllBytes(BLOB_INFO.getBlobId());
  }

  @Test
  public void testContentWithDecryptionKey() throws Exception {
    initializeExpectedBlob();
    byte[] content = {1, 2};
    when(storage.getOptions()).thenReturn(mockOptions);
    when(storage.readAllBytes(
            BLOB_INFO.getBlobId(), Storage.BlobSourceOption.decryptionKey(BASE64_KEY)))
        .thenReturn(content);
    initializeBlob();
    assertArrayEquals(content, blob.getContent(BlobSourceOption.decryptionKey(BASE64_KEY)));
    assertArrayEquals(content, blob.getContent(BlobSourceOption.decryptionKey(KEY)));

    verify(storage).getOptions();
    verify(storage, times(2))
        .readAllBytes(BLOB_INFO.getBlobId(), Storage.BlobSourceOption.decryptionKey(BASE64_KEY));
  }

  @Test
  public void testReload() throws Exception {
    initializeExpectedBlob();
    Blob expectedReloadedBlob = expectedBlob.toBuilder().setCacheControl("c").build();
    when(storage.getOptions()).thenReturn(mockOptions);
    when(storage.get(BLOB_INFO_NO_GENERATION.getBlobId(), new Storage.BlobGetOption[0]))
        .thenReturn(expectedReloadedBlob);
    initializeBlob();
    Blob updatedBlob = blob.reload();
    assertEquals(expectedReloadedBlob, updatedBlob);

    verify(storage).getOptions();
    verify(storage).get(BLOB_INFO_NO_GENERATION.getBlobId(), new Storage.BlobGetOption[0]);
  }

  @Test
  public void testReloadNull() throws Exception {
    initializeExpectedBlob();
    when(storage.getOptions()).thenReturn(mockOptions);
    when(storage.get(BLOB_INFO_NO_GENERATION.getBlobId(), new Storage.BlobGetOption[0]))
        .thenReturn(null);
    initializeBlob();
    Blob reloadedBlob = blob.reload();
    assertNull(reloadedBlob);

    verify(storage).getOptions();
    verify(storage).get(BLOB_INFO_NO_GENERATION.getBlobId(), new Storage.BlobGetOption[0]);
  }

  @Test
  public void testReloadWithOptions() throws Exception {
    initializeExpectedBlob();
    Blob expectedReloadedBlob = expectedBlob.toBuilder().setCacheControl("c").build();
    Storage.BlobGetOption[] options = {Storage.BlobGetOption.metagenerationMatch(42L)};
    when(storage.getOptions()).thenReturn(mockOptions);
    when(storage.get(BLOB_INFO_NO_GENERATION.getBlobId(), options))
        .thenReturn(expectedReloadedBlob);
    initializeBlob();
    Blob updatedBlob = blob.reload(BlobSourceOption.metagenerationMatch());
    assertEquals(expectedReloadedBlob, updatedBlob);

    verify(storage).getOptions();
    verify(storage).get(BLOB_INFO_NO_GENERATION.getBlobId(), options);
  }

  @Test
  public void testUpdate() throws Exception {
    initializeExpectedBlob();
    Blob expectedUpdatedBlob = expectedBlob.toBuilder().setCacheControl("c").build();
    when(storage.getOptions()).thenReturn(mockOptions);
    when(storage.update(eq(expectedUpdatedBlob), new Storage.BlobTargetOption[0]))
        .thenReturn(expectedUpdatedBlob);
    initializeBlob();
    Blob updatedBlob = new Blob(storage, new BlobInfo.BuilderImpl(expectedUpdatedBlob));
    Blob actualUpdatedBlob = updatedBlob.update();
    assertEquals(expectedUpdatedBlob, actualUpdatedBlob);

    verify(storage, times(2)).getOptions();
    verify(storage).update(eq(expectedUpdatedBlob), new Storage.BlobTargetOption[0]);
  }

  @Test
  public void testDelete() throws Exception {
    initializeExpectedBlob();
    when(storage.getOptions()).thenReturn(mockOptions);
    when(storage.delete(BLOB_INFO.getBlobId(), new Storage.BlobSourceOption[0])).thenReturn(true);
    initializeBlob();
    assertTrue(blob.delete());

    verify(storage).getOptions();
    verify(storage).delete(BLOB_INFO.getBlobId(), new Storage.BlobSourceOption[0]);
  }

  @Test
  public void testCopyToBucket() throws Exception {
    initializeExpectedBlob();
    BlobInfo target = BlobInfo.newBuilder(BlobId.of("bt", "n")).build();
    CopyWriter copyWriter = Mockito.mock(CopyWriter.class);
    ArgumentCaptor<CopyRequest> capturedCopyRequest = ArgumentCaptor.forClass(CopyRequest.class);
    when(storage.getOptions()).thenReturn(mockOptions);
    when(storage.copy(capturedCopyRequest.capture())).thenReturn(copyWriter);
    initializeBlob();
    CopyWriter returnedCopyWriter = blob.copyTo("bt");
    assertEquals(copyWriter, returnedCopyWriter);
    assertEquals(BLOB_INFO_NO_GENERATION.getBlobId(), capturedCopyRequest.getValue().getSource());
    assertEquals(target, capturedCopyRequest.getValue().getTarget());
    assertFalse(capturedCopyRequest.getValue().overrideInfo());
    assertTrue(capturedCopyRequest.getValue().getSourceOptions().isEmpty());
    assertTrue(capturedCopyRequest.getValue().getTargetOptions().isEmpty());

    verify(storage).getOptions();
    verify(storage).copy(capturedCopyRequest.capture());
  }

  @Test
  public void testCopyTo() throws Exception {
    initializeExpectedBlob();
    BlobInfo target = BlobInfo.newBuilder(BlobId.of("bt", "nt")).build();
    CopyWriter copyWriter = Mockito.mock(CopyWriter.class);
    ArgumentCaptor<CopyRequest> capturedCopyRequest = ArgumentCaptor.forClass(CopyRequest.class);
    when(storage.getOptions()).thenReturn(mockOptions);
    when(storage.copy(capturedCopyRequest.capture())).thenReturn(copyWriter);
    initializeBlob();
    CopyWriter returnedCopyWriter = blob.copyTo("bt", "nt");
    assertEquals(copyWriter, returnedCopyWriter);
    assertEquals(BLOB_INFO_NO_GENERATION.getBlobId(), capturedCopyRequest.getValue().getSource());
    assertEquals(target, capturedCopyRequest.getValue().getTarget());
    assertFalse(capturedCopyRequest.getValue().overrideInfo());
    assertTrue(capturedCopyRequest.getValue().getSourceOptions().isEmpty());
    assertTrue(capturedCopyRequest.getValue().getTargetOptions().isEmpty());

    verify(storage).getOptions();
    verify(storage).copy(capturedCopyRequest.capture());
  }

  @Test
  public void testCopyToBlobId() throws Exception {
    initializeExpectedBlob();
    BlobInfo target = BlobInfo.newBuilder(BlobId.of("bt", "nt")).build();
    BlobId targetId = BlobId.of("bt", "nt");
    CopyWriter copyWriter = Mockito.mock(CopyWriter.class);
    ArgumentCaptor<CopyRequest> capturedCopyRequest = ArgumentCaptor.forClass(CopyRequest.class);
    when(storage.getOptions()).thenReturn(mockOptions);
    when(storage.copy(capturedCopyRequest.capture())).thenReturn(copyWriter);
    initializeBlob();
    CopyWriter returnedCopyWriter = blob.copyTo(targetId);
    assertEquals(copyWriter, returnedCopyWriter);
    assertEquals(BLOB_INFO_NO_GENERATION.getBlobId(), capturedCopyRequest.getValue().getSource());
    assertEquals(target, capturedCopyRequest.getValue().getTarget());
    assertFalse(capturedCopyRequest.getValue().overrideInfo());
    assertTrue(capturedCopyRequest.getValue().getSourceOptions().isEmpty());
    assertTrue(capturedCopyRequest.getValue().getTargetOptions().isEmpty());

    verify(storage).getOptions();
    verify(storage).copy(capturedCopyRequest.capture());
  }

  @Test
  public void testReader() throws Exception {
    initializeExpectedBlob();
    ReadChannel channel = Mockito.mock(ReadChannel.class);
    when(storage.getOptions()).thenReturn(mockOptions);
    when(storage.reader(BLOB_INFO.getBlobId())).thenReturn(channel);
    initializeBlob();
    assertSame(channel, blob.reader());

    verify(storage).getOptions();
    verify(storage).reader(BLOB_INFO.getBlobId());
  }

  @Test
  public void testReaderWithDecryptionKey() throws Exception {
    initializeExpectedBlob();
    ReadChannel channel = Mockito.mock(ReadChannel.class);
    when(storage.getOptions()).thenReturn(mockOptions);
    when(storage.reader(BLOB_INFO.getBlobId(), Storage.BlobSourceOption.decryptionKey(BASE64_KEY)))
        .thenReturn(channel);
    initializeBlob();
    assertSame(channel, blob.reader(BlobSourceOption.decryptionKey(BASE64_KEY)));
    assertSame(channel, blob.reader(BlobSourceOption.decryptionKey(KEY)));

    verify(storage).getOptions();
    verify(storage, times(2))
        .reader(BLOB_INFO.getBlobId(), Storage.BlobSourceOption.decryptionKey(BASE64_KEY));
  }

  @Test
  public void testSignUrl() throws Exception {
    initializeExpectedBlob();
    URL url = new URL("http://localhost:123/bla");
    when(storage.getOptions()).thenReturn(mockOptions);
    when(storage.signUrl(expectedBlob, 100, TimeUnit.SECONDS)).thenReturn(url);
    initializeBlob();
    assertEquals(url, blob.signUrl(100, TimeUnit.SECONDS));

    verify(storage).getOptions();
    verify(storage).signUrl(expectedBlob, 100, TimeUnit.SECONDS);
  }

  @Test
  public void testGetAcl() throws Exception {
    initializeExpectedBlob();
    when(storage.getOptions()).thenReturn(mockOptions);
    when(storage.getAcl(BLOB_INFO.getBlobId(), User.ofAllAuthenticatedUsers())).thenReturn(ACL);
    initializeBlob();
    assertEquals(ACL, blob.getAcl(User.ofAllAuthenticatedUsers()));

    verify(storage).getOptions();
    verify(storage).getAcl(BLOB_INFO.getBlobId(), User.ofAllAuthenticatedUsers());
  }

  @Test
  public void testDeleteAcl() throws Exception {
    initializeExpectedBlob();
    when(storage.getOptions()).thenReturn(mockOptions);
    when(storage.deleteAcl(BLOB_INFO.getBlobId(), User.ofAllAuthenticatedUsers())).thenReturn(true);
    initializeBlob();
    assertTrue(blob.deleteAcl(User.ofAllAuthenticatedUsers()));

    verify(storage).getOptions();
    verify(storage).deleteAcl(BLOB_INFO.getBlobId(), User.ofAllAuthenticatedUsers());
  }

  @Test
  public void testCreateAcl() throws Exception {
    initializeExpectedBlob();
    when(storage.getOptions()).thenReturn(mockOptions);
    Acl returnedAcl = ACL.toBuilder().setEtag("ETAG").setId("ID").build();
    when(storage.createAcl(BLOB_INFO.getBlobId(), ACL)).thenReturn(returnedAcl);
    initializeBlob();
    assertEquals(returnedAcl, blob.createAcl(ACL));

    verify(storage).getOptions();
    verify(storage).createAcl(BLOB_INFO.getBlobId(), ACL);
  }

  @Test
  public void testUpdateAcl() throws Exception {
    initializeExpectedBlob();
    when(storage.getOptions()).thenReturn(mockOptions);
    Acl returnedAcl = ACL.toBuilder().setEtag("ETAG").setId("ID").build();
    when(storage.updateAcl(BLOB_INFO.getBlobId(), ACL)).thenReturn(returnedAcl);
    initializeBlob();
    assertEquals(returnedAcl, blob.updateAcl(ACL));

    verify(storage).getOptions();
    verify(storage).updateAcl(BLOB_INFO.getBlobId(), ACL);
  }

  @Test
  public void testListAcls() throws Exception {
    initializeExpectedBlob();
    when(storage.getOptions()).thenReturn(mockOptions);
    when(storage.listAcls(BLOB_INFO.getBlobId())).thenReturn(ACLS);
    initializeBlob();
    assertEquals(ACLS, blob.listAcls());

    verify(storage).getOptions();
    verify(storage).listAcls(BLOB_INFO.getBlobId());
  }

  @Test
  public void testToBuilder() {
    when(storage.getOptions()).thenReturn(mockOptions);
    Blob fullBlob = new Blob(storage, new BlobInfo.BuilderImpl(FULL_BLOB_INFO));
    assertEquals(fullBlob, fullBlob.toBuilder().build());
    Blob simpleBlob = new Blob(storage, new BlobInfo.BuilderImpl(BLOB_INFO));
    assertEquals(simpleBlob, simpleBlob.toBuilder().build());
    Blob directory = new Blob(storage, new BlobInfo.BuilderImpl(DIRECTORY_INFO));
    assertEquals(directory, directory.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    initializeExpectedBlob();
    when(storage.getOptions()).thenReturn(mockOptions);
    Blob.Builder builder = new Blob.Builder(new Blob(storage, new BlobInfo.BuilderImpl(BLOB_INFO)));
    Blob blob =
        builder
            .setAcl(ACLS)
            .setComponentCount(COMPONENT_COUNT)
            .setContentType(CONTENT_TYPE)
            .setCacheControl(CACHE_CONTROL)
            .setContentDisposition(CONTENT_DISPOSITION)
            .setContentEncoding(CONTENT_ENCODING)
            .setContentLanguage(CONTENT_LANGUAGE)
            .setCrc32c(CRC32)
            .setCreateTime(CREATE_TIME)
            .setCustomTime(CUSTOM_TIME)
            .setStorageClass(STORAGE_CLASS)
            .setTimeStorageClassUpdated(TIME_STORAGE_CLASS_UPDATED)
            .setCustomerEncryption(CUSTOMER_ENCRYPTION)
            .setKmsKeyName(KMS_KEY_NAME)
            .setEventBasedHold(EVENT_BASED_HOLD)
            .setTemporaryHold(TEMPORARY_HOLD)
            .setRetentionExpirationTime(RETENTION_EXPIRATION_TIME)
            .setDeleteTime(DELETE_TIME)
            .setEtag(ETAG)
            .setGeneratedId(GENERATED_ID)
            .setMd5(MD5)
            .setMediaLink(MEDIA_LINK)
            .setMetadata(METADATA)
            .setMetageneration(META_GENERATION)
            .setOwner(OWNER)
            .setSelfLink(SELF_LINK)
            .setSize(SIZE)
            .setUpdateTime(UPDATE_TIME)
            .build();
    assertEquals("b", blob.getBucket());
    assertEquals("n", blob.getName());
    assertEquals(ACLS, blob.getAcl());
    assertEquals(COMPONENT_COUNT, blob.getComponentCount());
    assertEquals(CONTENT_TYPE, blob.getContentType());
    assertEquals(CACHE_CONTROL, blob.getCacheControl());
    assertEquals(CONTENT_DISPOSITION, blob.getContentDisposition());
    assertEquals(CONTENT_ENCODING, blob.getContentEncoding());
    assertEquals(CONTENT_LANGUAGE, blob.getContentLanguage());
    assertEquals(CRC32, blob.getCrc32c());
    assertEquals(CRC32_HEX_STRING, blob.getCrc32cToHexString());
    assertEquals(CREATE_TIME, blob.getCreateTime());
    assertEquals(CUSTOM_TIME, blob.getCustomTime());
    assertEquals(STORAGE_CLASS, blob.getStorageClass());
    assertEquals(TIME_STORAGE_CLASS_UPDATED, blob.getTimeStorageClassUpdated());
    assertEquals(CUSTOMER_ENCRYPTION, blob.getCustomerEncryption());
    assertEquals(KMS_KEY_NAME, blob.getKmsKeyName());
    assertEquals(EVENT_BASED_HOLD, blob.getEventBasedHold());
    assertEquals(TEMPORARY_HOLD, blob.getTemporaryHold());
    assertEquals(RETENTION_EXPIRATION_TIME, blob.getRetentionExpirationTime());
    assertEquals(DELETE_TIME, blob.getDeleteTime());
    assertEquals(ETAG, blob.getEtag());
    assertEquals(GENERATED_ID, blob.getGeneratedId());
    assertEquals(MD5, blob.getMd5());
    assertEquals(MD5_HEX_STRING, blob.getMd5ToHexString());
    assertEquals(MEDIA_LINK, blob.getMediaLink());
    assertEquals(METADATA, blob.getMetadata());
    assertEquals(META_GENERATION, blob.getMetageneration());
    assertEquals(OWNER, blob.getOwner());
    assertEquals(SELF_LINK, blob.getSelfLink());
    assertEquals(SIZE, blob.getSize());
    assertEquals(UPDATE_TIME, blob.getUpdateTime());
    assertEquals(storage.getOptions(), blob.getStorage().getOptions());
    assertFalse(blob.isDirectory());
    builder = new Blob.Builder(new Blob(storage, new BlobInfo.BuilderImpl(DIRECTORY_INFO)));
    blob = builder.setBlobId(BlobId.of("b", "n/")).setIsDirectory(true).setSize(0L).build();
    assertEquals("b", blob.getBucket());
    assertEquals("n/", blob.getName());
    assertNull(blob.getAcl());
    assertNull(blob.getComponentCount());
    assertNull(blob.getContentType());
    assertNull(blob.getCacheControl());
    assertNull(blob.getContentDisposition());
    assertNull(blob.getContentEncoding());
    assertNull(blob.getContentLanguage());
    assertNull(blob.getCrc32c());
    assertNull(blob.getCrc32cToHexString());
    assertNull(blob.getCreateTime());
    assertNull(blob.getStorageClass());
    assertNull(blob.getTimeStorageClassUpdated());
    assertNull(blob.getCustomerEncryption());
    assertNull(blob.getKmsKeyName());
    assertNull(blob.getEventBasedHold());
    assertNull(blob.getTemporaryHold());
    assertNull(blob.getRetentionExpirationTime());
    assertNull(blob.getDeleteTime());
    assertNull(blob.getEtag());
    assertNull(blob.getGeneratedId());
    assertNull(blob.getMd5());
    assertNull(blob.getMd5ToHexString());
    assertNull(blob.getMediaLink());
    assertNull(blob.getMetadata());
    assertNull(blob.getMetageneration());
    assertNull(blob.getOwner());
    assertNull(blob.getSelfLink());
    assertEquals(0L, (long) blob.getSize());
    assertNull(blob.getUpdateTime());
    assertNull(blob.getCustomTime());
    assertTrue(blob.isDirectory());
  }

  @Test
  public void testDownloadTo() throws Exception {
    File file = File.createTempFile("blob", ".tmp");
    Path path = file.toPath();

    Storage s = Mockito.mock(Storage.class);
    Blob blob = new Blob(s, new BuilderImpl(BlobInfo.newBuilder("buck", "obj").build()));

    Mockito.doNothing().when(s).downloadTo(blob.getBlobId(), path);
    blob.downloadTo(path);
  }
}
