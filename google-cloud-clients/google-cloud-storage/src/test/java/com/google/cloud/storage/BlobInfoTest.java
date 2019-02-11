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

import static com.google.cloud.storage.Acl.Project.ProjectRole.VIEWERS;
import static com.google.cloud.storage.Acl.Role.READER;
import static com.google.cloud.storage.Acl.Role.WRITER;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.api.services.storage.model.StorageObject;
import com.google.cloud.storage.Acl.Project;
import com.google.cloud.storage.Acl.User;
import com.google.cloud.storage.BlobInfo.CustomerEncryption;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class BlobInfoTest {

  private static final List<Acl> ACL =
      ImmutableList.of(
          Acl.of(User.ofAllAuthenticatedUsers(), READER),
          Acl.of(new Project(VIEWERS, "p1"), WRITER));
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
  private static final String ENCRYPTION_ALGORITHM = "AES256";
  private static final String KEY_SHA256 = "keySha";
  private static final CustomerEncryption CUSTOMER_ENCRYPTION =
      new CustomerEncryption(ENCRYPTION_ALGORITHM, KEY_SHA256);
  private static final String KMS_KEY_NAME =
      "projects/p/locations/kr-loc/keyRings/kr/cryptoKeys/key";
  private static final StorageClass STORAGE_CLASS = StorageClass.COLDLINE;
  private static final Boolean EVENT_BASED_HOLD = true;
  private static final Boolean TEMPORARY_HOLD = true;
  private static final Long RETENTION_EXPIRATION_TIME = 10L;

  private static final BlobInfo BLOB_INFO =
      BlobInfo.newBuilder("b", "n", GENERATION)
          .setAcl(ACL)
          .setComponentCount(COMPONENT_COUNT)
          .setContentType(CONTENT_TYPE)
          .setCacheControl(CACHE_CONTROL)
          .setContentDisposition(CONTENT_DISPOSITION)
          .setContentEncoding(CONTENT_ENCODING)
          .setContentLanguage(CONTENT_LANGUAGE)
          .setCustomerEncryption(CUSTOMER_ENCRYPTION)
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
          .setStorageClass(STORAGE_CLASS)
          .setKmsKeyName(KMS_KEY_NAME)
          .setEventBasedHold(EVENT_BASED_HOLD)
          .setTemporaryHold(TEMPORARY_HOLD)
          .setRetentionExpirationTime(RETENTION_EXPIRATION_TIME)
          .build();
  private static final BlobInfo DIRECTORY_INFO =
      BlobInfo.newBuilder("b", "n/").setSize(0L).setIsDirectory(true).build();

  @Test
  public void testCustomerEncryption() {
    assertEquals(ENCRYPTION_ALGORITHM, CUSTOMER_ENCRYPTION.getEncryptionAlgorithm());
    assertEquals(KEY_SHA256, CUSTOMER_ENCRYPTION.getKeySha256());
  }

  @Test
  public void testToBuilder() {
    compareBlobs(BLOB_INFO, BLOB_INFO.toBuilder().build());
    BlobInfo blobInfo =
        BLOB_INFO.toBuilder().setBlobId(BlobId.of("b2", "n2")).setSize(200L).build();
    assertEquals("n2", blobInfo.getName());
    assertEquals("b2", blobInfo.getBucket());
    assertEquals(Long.valueOf(200), blobInfo.getSize());
    blobInfo =
        blobInfo.toBuilder().setBlobId(BlobId.of("b", "n", GENERATION)).setSize(SIZE).build();
    compareBlobs(BLOB_INFO, blobInfo);
  }

  @Test
  public void testToBuilderSetMd5FromHexString() {
    BlobInfo blobInfo =
        BlobInfo.newBuilder(BlobId.of("b2", "n2")).setMd5FromHexString(MD5_HEX_STRING).build();
    assertEquals(MD5, blobInfo.getMd5());
  }

  @Test
  public void testToBuilderSetCrc32cFromHexString() {
    BlobInfo blobInfo =
        BlobInfo.newBuilder(BlobId.of("b2", "n2")).setCrc32cFromHexString(CRC32_HEX_STRING).build();
    assertEquals(CRC32, blobInfo.getCrc32c());
  }

  @Test
  public void testToBuilderIncomplete() {
    BlobInfo incompleteBlobInfo = BlobInfo.newBuilder(BlobId.of("b2", "n2")).build();
    compareBlobs(incompleteBlobInfo, incompleteBlobInfo.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertEquals("b", BLOB_INFO.getBucket());
    assertEquals("n", BLOB_INFO.getName());
    assertEquals(ACL, BLOB_INFO.getAcl());
    assertEquals(COMPONENT_COUNT, BLOB_INFO.getComponentCount());
    assertEquals(CONTENT_TYPE, BLOB_INFO.getContentType());
    assertEquals(CACHE_CONTROL, BLOB_INFO.getCacheControl());
    assertEquals(CONTENT_DISPOSITION, BLOB_INFO.getContentDisposition());
    assertEquals(CONTENT_ENCODING, BLOB_INFO.getContentEncoding());
    assertEquals(CONTENT_LANGUAGE, BLOB_INFO.getContentLanguage());
    assertEquals(CUSTOMER_ENCRYPTION, BLOB_INFO.getCustomerEncryption());
    assertEquals(CRC32, BLOB_INFO.getCrc32c());
    assertEquals(CRC32_HEX_STRING, BLOB_INFO.getCrc32cToHexString());
    assertEquals(DELETE_TIME, BLOB_INFO.getDeleteTime());
    assertEquals(ETAG, BLOB_INFO.getEtag());
    assertEquals(GENERATION, BLOB_INFO.getGeneration());
    assertEquals(GENERATED_ID, BLOB_INFO.getGeneratedId());
    assertEquals(MD5, BLOB_INFO.getMd5());
    assertEquals(MD5_HEX_STRING, BLOB_INFO.getMd5ToHexString());
    assertEquals(MEDIA_LINK, BLOB_INFO.getMediaLink());
    assertEquals(METADATA, BLOB_INFO.getMetadata());
    assertEquals(META_GENERATION, BLOB_INFO.getMetageneration());
    assertEquals(OWNER, BLOB_INFO.getOwner());
    assertEquals(SELF_LINK, BLOB_INFO.getSelfLink());
    assertEquals(SIZE, BLOB_INFO.getSize());
    assertEquals(UPDATE_TIME, BLOB_INFO.getUpdateTime());
    assertEquals(CREATE_TIME, BLOB_INFO.getCreateTime());
    assertEquals(STORAGE_CLASS, BLOB_INFO.getStorageClass());
    assertEquals(KMS_KEY_NAME, BLOB_INFO.getKmsKeyName());
    assertEquals(EVENT_BASED_HOLD, BLOB_INFO.getEventBasedHold());
    assertEquals(TEMPORARY_HOLD, BLOB_INFO.getTemporaryHold());
    assertEquals(RETENTION_EXPIRATION_TIME, BLOB_INFO.getRetentionExpirationTime());
    assertFalse(BLOB_INFO.isDirectory());
    assertEquals("b", DIRECTORY_INFO.getBucket());
    assertEquals("n/", DIRECTORY_INFO.getName());
    assertNull(DIRECTORY_INFO.getAcl());
    assertNull(DIRECTORY_INFO.getComponentCount());
    assertNull(DIRECTORY_INFO.getContentType());
    assertNull(DIRECTORY_INFO.getCacheControl());
    assertNull(DIRECTORY_INFO.getContentDisposition());
    assertNull(DIRECTORY_INFO.getContentEncoding());
    assertNull(DIRECTORY_INFO.getContentLanguage());
    assertNull(DIRECTORY_INFO.getCustomerEncryption());
    assertNull(DIRECTORY_INFO.getCrc32c());
    assertNull(DIRECTORY_INFO.getCrc32cToHexString());
    assertNull(DIRECTORY_INFO.getCreateTime());
    assertNull(DIRECTORY_INFO.getDeleteTime());
    assertNull(DIRECTORY_INFO.getEtag());
    assertNull(DIRECTORY_INFO.getGeneration());
    assertNull(DIRECTORY_INFO.getGeneratedId());
    assertNull(DIRECTORY_INFO.getMd5());
    assertNull(DIRECTORY_INFO.getMd5ToHexString());
    assertNull(DIRECTORY_INFO.getMediaLink());
    assertNull(DIRECTORY_INFO.getMetadata());
    assertNull(DIRECTORY_INFO.getMetageneration());
    assertNull(DIRECTORY_INFO.getOwner());
    assertNull(DIRECTORY_INFO.getSelfLink());
    assertEquals(0L, (long) DIRECTORY_INFO.getSize());
    assertNull(DIRECTORY_INFO.getUpdateTime());
    assertTrue(DIRECTORY_INFO.isDirectory());
  }

  private void compareBlobs(BlobInfo expected, BlobInfo value) {
    assertEquals(expected, value);
    assertEquals(expected.getBucket(), value.getBucket());
    assertEquals(expected.getName(), value.getName());
    assertEquals(expected.getAcl(), value.getAcl());
    assertEquals(expected.getComponentCount(), value.getComponentCount());
    assertEquals(expected.getContentType(), value.getContentType());
    assertEquals(expected.getCacheControl(), value.getCacheControl());
    assertEquals(expected.getContentDisposition(), value.getContentDisposition());
    assertEquals(expected.getContentEncoding(), value.getContentEncoding());
    assertEquals(expected.getContentLanguage(), value.getContentLanguage());
    assertEquals(expected.getCustomerEncryption(), value.getCustomerEncryption());
    assertEquals(expected.getCrc32c(), value.getCrc32c());
    assertEquals(expected.getCrc32cToHexString(), value.getCrc32cToHexString());
    assertEquals(expected.getCreateTime(), value.getCreateTime());
    assertEquals(expected.getDeleteTime(), value.getDeleteTime());
    assertEquals(expected.getEtag(), value.getEtag());
    assertEquals(expected.getGeneration(), value.getGeneration());
    assertEquals(expected.getGeneratedId(), value.getGeneratedId());
    assertEquals(expected.getMd5(), value.getMd5());
    assertEquals(expected.getMd5ToHexString(), value.getMd5ToHexString());
    assertEquals(expected.getMediaLink(), value.getMediaLink());
    assertEquals(expected.getMetadata(), value.getMetadata());
    assertEquals(expected.getMetageneration(), value.getMetageneration());
    assertEquals(expected.getOwner(), value.getOwner());
    assertEquals(expected.getSelfLink(), value.getSelfLink());
    assertEquals(expected.getSize(), value.getSize());
    assertEquals(expected.getUpdateTime(), value.getUpdateTime());
    assertEquals(expected.getStorageClass(), value.getStorageClass());
    assertEquals(expected.getKmsKeyName(), value.getKmsKeyName());
    assertEquals(expected.getEventBasedHold(), value.getEventBasedHold());
    assertEquals(expected.getTemporaryHold(), value.getTemporaryHold());
    assertEquals(expected.getRetentionExpirationTime(), value.getRetentionExpirationTime());
  }

  private void compareCustomerEncryptions(CustomerEncryption expected, CustomerEncryption value) {
    assertEquals(expected, value);
    assertEquals(expected.getEncryptionAlgorithm(), value.getEncryptionAlgorithm());
    assertEquals(expected.getKeySha256(), value.getKeySha256());
    assertEquals(expected.hashCode(), value.hashCode());
  }

  @Test
  public void testToPbAndFromPb() {
    compareCustomerEncryptions(
        CUSTOMER_ENCRYPTION, CustomerEncryption.fromPb(CUSTOMER_ENCRYPTION.toPb()));
    compareBlobs(BLOB_INFO, BlobInfo.fromPb(BLOB_INFO.toPb()));
    BlobInfo blobInfo = BlobInfo.newBuilder(BlobId.of("b", "n")).build();
    compareBlobs(blobInfo, BlobInfo.fromPb(blobInfo.toPb()));
    StorageObject object =
        new StorageObject()
            .setName("n/")
            .setBucket("b")
            .setSize(BigInteger.ZERO)
            .set("isDirectory", true);
    blobInfo = BlobInfo.fromPb(object);
    assertEquals("b", blobInfo.getBucket());
    assertEquals("n/", blobInfo.getName());
    assertNull(blobInfo.getAcl());
    assertNull(blobInfo.getComponentCount());
    assertNull(blobInfo.getContentType());
    assertNull(blobInfo.getCacheControl());
    assertNull(blobInfo.getContentDisposition());
    assertNull(blobInfo.getContentEncoding());
    assertNull(blobInfo.getContentLanguage());
    assertNull(blobInfo.getCustomerEncryption());
    assertNull(blobInfo.getCrc32c());
    assertNull(blobInfo.getCrc32cToHexString());
    assertNull(blobInfo.getCreateTime());
    assertNull(blobInfo.getDeleteTime());
    assertNull(blobInfo.getEtag());
    assertNull(blobInfo.getGeneration());
    assertNull(blobInfo.getGeneratedId());
    assertNull(blobInfo.getMd5());
    assertNull(blobInfo.getMd5ToHexString());
    assertNull(blobInfo.getMediaLink());
    assertNull(blobInfo.getMetadata());
    assertNull(blobInfo.getMetageneration());
    assertNull(blobInfo.getOwner());
    assertNull(blobInfo.getSelfLink());
    assertEquals(0L, (long) blobInfo.getSize());
    assertNull(blobInfo.getUpdateTime());
    assertNull(blobInfo.getStorageClass());
    assertNull(blobInfo.getKmsKeyName());
    assertNull(blobInfo.getEventBasedHold());
    assertNull(blobInfo.getTemporaryHold());
    assertNull(blobInfo.getRetentionExpirationTime());
    assertTrue(blobInfo.isDirectory());
  }

  @Test
  public void testBlobId() {
    assertEquals(BlobId.of("b", "n", GENERATION), BLOB_INFO.getBlobId());
  }
}
