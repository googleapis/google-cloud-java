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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.api.services.storage.model.StorageObject;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.cloud.storage.Acl.Project;
import com.google.cloud.storage.Acl.User;

import org.junit.Test;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public class BlobInfoTest {

  private static final List<Acl> ACL = ImmutableList.of(
      Acl.of(User.ofAllAuthenticatedUsers(), READER),
      Acl.of(new Project(VIEWERS, "p1"), WRITER));
  private static final Integer COMPONENT_COUNT = 2;
  private static final String CONTENT_TYPE = "text/html";
  private static final String CACHE_CONTROL = "cache";
  private static final String CONTENT_DISPOSITION = "content-disposition";
  private static final String CONTENT_ENCODING = "UTF-8";
  private static final String CONTENT_LANGUAGE = "En";
  private static final String CRC32 = "0xFF00";
  private static final Long DELETE_TIME = System.currentTimeMillis();
  private static final String ETAG = "0xFF00";
  private static final Long GENERATION = 1L;
  private static final String GENERATED_ID = "B/N:1";
  private static final String MD5 = "0xFF00";
  private static final String MEDIA_LINK = "http://media/b/n";
  private static final Map<String, String> METADATA = ImmutableMap.of("n1", "v1", "n2", "v2");
  private static final Long META_GENERATION = 10L;
  private static final User OWNER = new User("user@gmail.com");
  private static final String SELF_LINK = "http://storage/b/n";
  private static final Long SIZE = 1024L;
  private static final Long UPDATE_TIME = DELETE_TIME - 1L;
  private static final BlobInfo BLOB_INFO = BlobInfo.builder("b", "n", GENERATION)
      .acl(ACL)
      .componentCount(COMPONENT_COUNT)
      .contentType(CONTENT_TYPE)
      .cacheControl(CACHE_CONTROL)
      .contentDisposition(CONTENT_DISPOSITION)
      .contentEncoding(CONTENT_ENCODING)
      .contentLanguage(CONTENT_LANGUAGE)
      .crc32c(CRC32)
      .deleteTime(DELETE_TIME)
      .etag(ETAG)
      .generatedId(GENERATED_ID)
      .md5(MD5)
      .mediaLink(MEDIA_LINK)
      .metadata(METADATA)
      .metageneration(META_GENERATION)
      .owner(OWNER)
      .selfLink(SELF_LINK)
      .size(SIZE)
      .updateTime(UPDATE_TIME)
      .build();
  private static final BlobInfo DIRECTORY_INFO = BlobInfo.builder("b", "n/")
      .size(0L)
      .isDirectory(true)
      .build();

  @Test
  public void testToBuilder() {
    compareBlobs(BLOB_INFO, BLOB_INFO.toBuilder().build());
    BlobInfo blobInfo = BLOB_INFO.toBuilder().blobId(BlobId.of("b2", "n2")).size(200L).build();
    assertEquals("n2", blobInfo.name());
    assertEquals("b2", blobInfo.bucket());
    assertEquals(Long.valueOf(200), blobInfo.size());
    blobInfo = blobInfo.toBuilder().blobId(BlobId.of("b", "n", GENERATION)).size(SIZE).build();
    compareBlobs(BLOB_INFO, blobInfo);
  }

  @Test
  public void testToBuilderIncomplete() {
    BlobInfo incompleteBlobInfo = BlobInfo.builder(BlobId.of("b2", "n2")).build();
    compareBlobs(incompleteBlobInfo, incompleteBlobInfo.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    assertEquals("b", BLOB_INFO.bucket());
    assertEquals("n", BLOB_INFO.name());
    assertEquals(ACL, BLOB_INFO.acl());
    assertEquals(COMPONENT_COUNT, BLOB_INFO.componentCount());
    assertEquals(CONTENT_TYPE, BLOB_INFO.contentType());
    assertEquals(CACHE_CONTROL, BLOB_INFO.cacheControl());
    assertEquals(CONTENT_DISPOSITION, BLOB_INFO.contentDisposition());
    assertEquals(CONTENT_ENCODING, BLOB_INFO.contentEncoding());
    assertEquals(CONTENT_LANGUAGE, BLOB_INFO.contentLanguage());
    assertEquals(CRC32, BLOB_INFO.crc32c());
    assertEquals(DELETE_TIME, BLOB_INFO.deleteTime());
    assertEquals(ETAG, BLOB_INFO.etag());
    assertEquals(GENERATION, BLOB_INFO.generation());
    assertEquals(GENERATED_ID, BLOB_INFO.generatedId());
    assertEquals(MD5, BLOB_INFO.md5());
    assertEquals(MEDIA_LINK, BLOB_INFO.mediaLink());
    assertEquals(METADATA, BLOB_INFO.metadata());
    assertEquals(META_GENERATION, BLOB_INFO.metageneration());
    assertEquals(OWNER, BLOB_INFO.owner());
    assertEquals(SELF_LINK, BLOB_INFO.selfLink());
    assertEquals(SIZE, BLOB_INFO.size());
    assertEquals(UPDATE_TIME, BLOB_INFO.updateTime());
    assertFalse(BLOB_INFO.isDirectory());
    assertEquals("b", DIRECTORY_INFO.bucket());
    assertEquals("n/", DIRECTORY_INFO.name());
    assertNull(DIRECTORY_INFO.acl());
    assertNull(DIRECTORY_INFO.componentCount());
    assertNull(DIRECTORY_INFO.contentType());
    assertNull(DIRECTORY_INFO.cacheControl());
    assertNull(DIRECTORY_INFO.contentDisposition());
    assertNull(DIRECTORY_INFO.contentEncoding());
    assertNull(DIRECTORY_INFO.contentLanguage());
    assertNull(DIRECTORY_INFO.crc32c());
    assertNull(DIRECTORY_INFO.deleteTime());
    assertNull(DIRECTORY_INFO.etag());
    assertNull(DIRECTORY_INFO.generation());
    assertNull(DIRECTORY_INFO.generatedId());
    assertNull(DIRECTORY_INFO.md5());
    assertNull(DIRECTORY_INFO.mediaLink());
    assertNull(DIRECTORY_INFO.metadata());
    assertNull(DIRECTORY_INFO.metageneration());
    assertNull(DIRECTORY_INFO.owner());
    assertNull(DIRECTORY_INFO.selfLink());
    assertEquals(0L, (long) DIRECTORY_INFO.size());
    assertNull(DIRECTORY_INFO.updateTime());
    assertTrue(DIRECTORY_INFO.isDirectory());
  }

  private void compareBlobs(BlobInfo expected, BlobInfo value) {
    assertEquals(expected, value);
    assertEquals(expected.bucket(), value.bucket());
    assertEquals(expected.name(), value.name());
    assertEquals(expected.acl(), value.acl());
    assertEquals(expected.componentCount(), value.componentCount());
    assertEquals(expected.contentType(), value.contentType());
    assertEquals(expected.cacheControl(), value.cacheControl());
    assertEquals(expected.contentDisposition(), value.contentDisposition());
    assertEquals(expected.contentEncoding(), value.contentEncoding());
    assertEquals(expected.contentLanguage(), value.contentLanguage());
    assertEquals(expected.crc32c(), value.crc32c());
    assertEquals(expected.deleteTime(), value.deleteTime());
    assertEquals(expected.etag(), value.etag());
    assertEquals(expected.generation(), value.generation());
    assertEquals(expected.generatedId(), value.generatedId());
    assertEquals(expected.md5(), value.md5());
    assertEquals(expected.mediaLink(), value.mediaLink());
    assertEquals(expected.metadata(), value.metadata());
    assertEquals(expected.metageneration(), value.metageneration());
    assertEquals(expected.owner(), value.owner());
    assertEquals(expected.selfLink(), value.selfLink());
    assertEquals(expected.size(), value.size());
    assertEquals(expected.updateTime(), value.updateTime());
  }

  @Test
  public void testToPbAndFromPb() {
    compareBlobs(BLOB_INFO, BlobInfo.fromPb(BLOB_INFO.toPb()));
    BlobInfo blobInfo = BlobInfo.builder(BlobId.of("b", "n")).build();
    compareBlobs(blobInfo, BlobInfo.fromPb(blobInfo.toPb()));
    StorageObject object = new StorageObject()
        .setName("n/")
        .setBucket("b")
        .setSize(BigInteger.ZERO)
        .set("isDirectory", true);
    blobInfo = BlobInfo.fromPb(object);
    assertEquals("b", blobInfo.bucket());
    assertEquals("n/", blobInfo.name());
    assertNull(blobInfo.acl());
    assertNull(blobInfo.componentCount());
    assertNull(blobInfo.contentType());
    assertNull(blobInfo.cacheControl());
    assertNull(blobInfo.contentDisposition());
    assertNull(blobInfo.contentEncoding());
    assertNull(blobInfo.contentLanguage());
    assertNull(blobInfo.crc32c());
    assertNull(blobInfo.deleteTime());
    assertNull(blobInfo.etag());
    assertNull(blobInfo.generation());
    assertNull(blobInfo.generatedId());
    assertNull(blobInfo.md5());
    assertNull(blobInfo.mediaLink());
    assertNull(blobInfo.metadata());
    assertNull(blobInfo.metageneration());
    assertNull(blobInfo.owner());
    assertNull(blobInfo.selfLink());
    assertEquals(0L, (long) blobInfo.size());
    assertNull(blobInfo.updateTime());
    assertTrue(blobInfo.isDirectory());
  }

  @Test
  public void testBlobId() {
    assertEquals(BlobId.of("b", "n", GENERATION), BLOB_INFO.blobId());
  }
}
