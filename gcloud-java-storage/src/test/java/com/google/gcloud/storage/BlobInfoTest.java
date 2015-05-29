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
import static com.google.gcloud.storage.Acl.Role.READER;
import static com.google.gcloud.storage.Acl.Role.WRITER;
import static org.junit.Assert.assertEquals;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.gcloud.storage.Acl.Project;
import com.google.gcloud.storage.Acl.User;

import org.junit.Test;

import java.util.List;
import java.util.Map;

public class BlobInfoTest {

  private static final List<Acl> ACL = ImmutableList.of(
      new Acl(User.ofAllAuthenticatedUsers(), READER),
      new Acl(new Project(VIEWERS, "p1"), WRITER));
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
  private static final String ID = "B/N:1";
  private static final String MD5 = "0xFF00";
  private static final String MEDIA_LINK = "http://media/b/n";
  private static final Map<String, String> METADATA = ImmutableMap.of("n1", "v1", "n2", "v2");
  private static final Long META_GENERATION = 10L;
  private static final User OWNER = new User("user@gmail.com");
  private static final String SELF_LINK = "http://storage/b/n";
  private static final Long SIZE = 1024L;
  private static final Long UPDATE_TIME = DELETE_TIME - 1L;
  private static final BlobInfo BLOB_INFO = BlobInfo.builder("b", "n")
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
      .generation(GENERATION)
      .id(ID)
      .md5(MD5)
      .mediaLink(MEDIA_LINK)
      .metadata(METADATA)
      .metageneration(META_GENERATION)
      .owner(OWNER)
      .selfLink(SELF_LINK)
      .size(SIZE)
      .updateTime(UPDATE_TIME)
      .build();

  @Test
  public void testToBuilder() {
    compareBlobs(BLOB_INFO, BLOB_INFO.toBuilder().build());
    BlobInfo blobInfo = BLOB_INFO.toBuilder().name("n2").bucket("b2").size(200L).build();
    assertEquals("n2", blobInfo.name());
    assertEquals("b2", blobInfo.bucket());
    assertEquals(Long.valueOf(200), blobInfo.size());
    blobInfo = blobInfo.toBuilder().name("n").bucket("b").size(SIZE).build();
    compareBlobs(BLOB_INFO, blobInfo);
  }

  @Test
  public void testOf() {
    BlobInfo blobInfo = BlobInfo.of("b", "n");
    assertEquals("b", blobInfo.bucket());
    assertEquals("n", blobInfo.name());
  }

  @Test
  public void testBuilder() {
    assertEquals("b", BLOB_INFO.bucket());
    assertEquals("n", BLOB_INFO.name());
    assertEquals(ACL, BLOB_INFO.acl());
    assertEquals(COMPONENT_COUNT, BLOB_INFO.componentCount());
    assertEquals(CONTENT_TYPE, BLOB_INFO.contentType());
    assertEquals(CACHE_CONTROL, BLOB_INFO.cacheControl() );
    assertEquals(CONTENT_DISPOSITION, BLOB_INFO.contentDisposition());
    assertEquals(CONTENT_ENCODING, BLOB_INFO.contentEncoding());
    assertEquals(CONTENT_LANGUAGE, BLOB_INFO.contentLanguage());
    assertEquals(CRC32, BLOB_INFO.crc32c());
    assertEquals(DELETE_TIME, BLOB_INFO.deleteTime());
    assertEquals(ETAG, BLOB_INFO.etag());
    assertEquals(GENERATION, BLOB_INFO.generation());
    assertEquals(ID, BLOB_INFO.id());
    assertEquals(MD5, BLOB_INFO.md5());
    assertEquals(MEDIA_LINK, BLOB_INFO.mediaLink());
    assertEquals(METADATA, BLOB_INFO.metadata());
    assertEquals(META_GENERATION, BLOB_INFO.metageneration());
    assertEquals(OWNER, BLOB_INFO.owner());
    assertEquals(SELF_LINK, BLOB_INFO.selfLink());
    assertEquals(SIZE, BLOB_INFO.size());
    assertEquals(UPDATE_TIME, BLOB_INFO.updateTime());
  }

  private void compareBlobs(BlobInfo expected, BlobInfo value) {
    assertEquals(expected, value);
    assertEquals(expected.bucket(), value.bucket());
    assertEquals(expected.name(), value.name());
    assertEquals(expected.acl(), value.acl());
    assertEquals(expected.componentCount(), value.componentCount());
    assertEquals(expected.contentType(), value.contentType());
    assertEquals(expected.cacheControl(), value.cacheControl() );
    assertEquals(expected.contentDisposition(), value.contentDisposition());
    assertEquals(expected.contentEncoding(), value.contentEncoding());
    assertEquals(expected.contentLanguage(), value.contentLanguage());
    assertEquals(expected.crc32c(), value.crc32c());
    assertEquals(expected.deleteTime(), value.deleteTime());
    assertEquals(expected.etag(), value.etag());
    assertEquals(expected.generation(), value.generation());
    assertEquals(expected.id(), value.id());
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
  }
}
