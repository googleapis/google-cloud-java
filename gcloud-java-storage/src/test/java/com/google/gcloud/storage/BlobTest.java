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
import static org.easymock.EasyMock.capture;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.eq;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.gcloud.ReadChannel;
import com.google.gcloud.storage.Acl.Project;
import com.google.gcloud.storage.Acl.User;
import com.google.gcloud.storage.Storage.CopyRequest;

import org.easymock.Capture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BlobTest {

  private static final List<Acl> ACL = ImmutableList.of(
      Acl.of(User.ofAllAuthenticatedUsers(), READER), Acl.of(new Project(VIEWERS, "p1"), WRITER));
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
  private static final BlobInfo FULL_BLOB_INFO = BlobInfo.builder("b", "n", GENERATION)
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
  private static final BlobInfo BLOB_INFO = BlobInfo.builder("b", "n").metageneration(42L).build();
  private static final BlobInfo DIRECTORY_INFO = BlobInfo.builder("b", "n/")
      .size(0L)
      .isDirectory(true)
      .build();

  private Storage storage;
  private Blob blob;
  private Blob expectedBlob;
  private Storage serviceMockReturnsOptions = createMock(Storage.class);
  private StorageOptions mockOptions = createMock(StorageOptions.class);

  @Before
  public void setUp() {
    storage = createStrictMock(Storage.class);
  }

  @After
  public void tearDown() throws Exception {
    verify(storage);
  }

  private void initializeExpectedBlob(int optionsCalls) {
    expect(serviceMockReturnsOptions.options()).andReturn(mockOptions).times(optionsCalls);
    replay(serviceMockReturnsOptions);
    expectedBlob = new Blob(serviceMockReturnsOptions, new BlobInfo.BuilderImpl(BLOB_INFO));
  }

  private void initializeBlob() {
    blob = new Blob(storage, new BlobInfo.BuilderImpl(BLOB_INFO));
  }

  @Test
  public void testExists_True() throws Exception {
    initializeExpectedBlob(1);
    Storage.BlobGetOption[] expectedOptions = {Storage.BlobGetOption.fields()};
    expect(storage.options()).andReturn(mockOptions);
    expect(storage.get(expectedBlob.blobId(), expectedOptions)).andReturn(expectedBlob);
    replay(storage);
    initializeBlob();
    assertTrue(blob.exists());
  }

  @Test
  public void testExists_False() throws Exception {
    Storage.BlobGetOption[] expectedOptions = {Storage.BlobGetOption.fields()};
    expect(storage.options()).andReturn(null);
    expect(storage.get(BLOB_INFO.blobId(), expectedOptions)).andReturn(null);
    replay(storage);
    initializeBlob();
    assertFalse(blob.exists());
  }

  @Test
  public void testContent() throws Exception {
    initializeExpectedBlob(2);
    byte[] content = {1, 2};
    expect(storage.options()).andReturn(mockOptions);
    expect(storage.readAllBytes(BLOB_INFO.blobId())).andReturn(content);
    replay(storage);
    initializeBlob();
    assertArrayEquals(content, blob.content());
  }

  @Test
  public void testReload() throws Exception {
    initializeExpectedBlob(2);
    Blob expectedReloadedBlob = expectedBlob.toBuilder().cacheControl("c").build();
    expect(storage.options()).andReturn(mockOptions);
    expect(storage.get(BLOB_INFO.blobId(), new Storage.BlobGetOption[0]))
        .andReturn(expectedReloadedBlob);
    replay(storage);
    initializeBlob();
    Blob updatedBlob = blob.reload();
    assertEquals(expectedReloadedBlob, updatedBlob);
  }

  @Test
  public void testReloadNull() throws Exception {
    initializeExpectedBlob(1);
    expect(storage.options()).andReturn(mockOptions);
    expect(storage.get(BLOB_INFO.blobId(), new Storage.BlobGetOption[0])).andReturn(null);
    replay(storage);
    initializeBlob();
    Blob reloadedBlob = blob.reload();
    assertNull(reloadedBlob);
  }

  @Test
  public void testReloadWithOptions() throws Exception {
    initializeExpectedBlob(2);
    Blob expectedReloadedBlob = expectedBlob.toBuilder().cacheControl("c").build();
    Storage.BlobGetOption[] options = {Storage.BlobGetOption.metagenerationMatch(42L)};
    expect(storage.options()).andReturn(mockOptions);
    expect(storage.get(BLOB_INFO.blobId(), options)).andReturn(expectedReloadedBlob);
    replay(storage);
    initializeBlob();
    Blob updatedBlob = blob.reload(Blob.BlobSourceOption.metagenerationMatch());
    assertEquals(expectedReloadedBlob, updatedBlob);
  }

  @Test
  public void testUpdate() throws Exception {
    initializeExpectedBlob(2);
    Blob expectedUpdatedBlob = expectedBlob.toBuilder().cacheControl("c").build();
    expect(storage.options()).andReturn(mockOptions).times(2);
    expect(storage.update(eq(expectedUpdatedBlob), new Storage.BlobTargetOption[0]))
        .andReturn(expectedUpdatedBlob);
    replay(storage);
    initializeBlob();
    Blob updatedBlob = new Blob(storage, new BlobInfo.BuilderImpl(expectedUpdatedBlob));
    Blob actualUpdatedBlob = updatedBlob.update();
    assertEquals(expectedUpdatedBlob, actualUpdatedBlob);
  }

  @Test
  public void testDelete() throws Exception {
    initializeExpectedBlob(2);
    expect(storage.options()).andReturn(mockOptions);
    expect(storage.delete(BLOB_INFO.blobId(), new Storage.BlobSourceOption[0])).andReturn(true);
    replay(storage);
    initializeBlob();
    assertTrue(blob.delete());
  }

  @Test
  public void testCopyToBucket() throws Exception {
    initializeExpectedBlob(2);
    BlobInfo target = BlobInfo.builder(BlobId.of("bt", "n")).build();
    CopyWriter copyWriter = createMock(CopyWriter.class);
    Capture<CopyRequest> capturedCopyRequest = Capture.newInstance();
    expect(storage.options()).andReturn(mockOptions);
    expect(storage.copy(capture(capturedCopyRequest))).andReturn(copyWriter);
    replay(storage);
    initializeBlob();
    CopyWriter returnedCopyWriter = blob.copyTo("bt");
    assertEquals(copyWriter, returnedCopyWriter);
    assertEquals(capturedCopyRequest.getValue().source(), blob.blobId());
    assertEquals(capturedCopyRequest.getValue().target(), target);
    assertFalse(capturedCopyRequest.getValue().overrideInfo());
    assertTrue(capturedCopyRequest.getValue().sourceOptions().isEmpty());
    assertTrue(capturedCopyRequest.getValue().targetOptions().isEmpty());
  }

  @Test
  public void testCopyTo() throws Exception {
    initializeExpectedBlob(2);
    BlobInfo target = BlobInfo.builder(BlobId.of("bt", "nt")).build();
    CopyWriter copyWriter = createMock(CopyWriter.class);
    Capture<CopyRequest> capturedCopyRequest = Capture.newInstance();
    expect(storage.options()).andReturn(mockOptions);
    expect(storage.copy(capture(capturedCopyRequest))).andReturn(copyWriter);
    replay(storage);
    initializeBlob();
    CopyWriter returnedCopyWriter = blob.copyTo("bt", "nt");
    assertEquals(copyWriter, returnedCopyWriter);
    assertEquals(capturedCopyRequest.getValue().source(), blob.blobId());
    assertEquals(capturedCopyRequest.getValue().target(), target);
    assertFalse(capturedCopyRequest.getValue().overrideInfo());
    assertTrue(capturedCopyRequest.getValue().sourceOptions().isEmpty());
    assertTrue(capturedCopyRequest.getValue().targetOptions().isEmpty());
  }

  @Test
  public void testCopyToBlobId() throws Exception {
    initializeExpectedBlob(2);
    BlobInfo target = BlobInfo.builder(BlobId.of("bt", "nt")).build();
    BlobId targetId = BlobId.of("bt", "nt");
    CopyWriter copyWriter = createMock(CopyWriter.class);
    Capture<CopyRequest> capturedCopyRequest = Capture.newInstance();
    expect(storage.options()).andReturn(mockOptions);
    expect(storage.copy(capture(capturedCopyRequest))).andReturn(copyWriter);
    replay(storage);
    initializeBlob();
    CopyWriter returnedCopyWriter = blob.copyTo(targetId);
    assertEquals(copyWriter, returnedCopyWriter);
    assertEquals(capturedCopyRequest.getValue().source(), blob.blobId());
    assertEquals(capturedCopyRequest.getValue().target(), target);
    assertFalse(capturedCopyRequest.getValue().overrideInfo());
    assertTrue(capturedCopyRequest.getValue().sourceOptions().isEmpty());
    assertTrue(capturedCopyRequest.getValue().targetOptions().isEmpty());
  }

  @Test
  public void testReader() throws Exception {
    initializeExpectedBlob(2);
    ReadChannel channel = createMock(ReadChannel.class);
    expect(storage.options()).andReturn(mockOptions);
    expect(storage.reader(BLOB_INFO.blobId())).andReturn(channel);
    replay(storage);
    initializeBlob();
    assertSame(channel, blob.reader());
  }

  @Test
  public void testWriter() throws Exception {
    initializeExpectedBlob(2);
    BlobWriteChannel channel = createMock(BlobWriteChannel.class);
    expect(storage.options()).andReturn(mockOptions);
    expect(storage.writer(eq(expectedBlob))).andReturn(channel);
    replay(storage);
    initializeBlob();
    assertSame(channel, blob.writer());
  }

  @Test
  public void testSignUrl() throws Exception {
    initializeExpectedBlob(2);
    URL url = new URL("http://localhost:123/bla");
    expect(storage.options()).andReturn(mockOptions);
    expect(storage.signUrl(expectedBlob, 100, TimeUnit.SECONDS)).andReturn(url);
    replay(storage);
    initializeBlob();
    assertEquals(url, blob.signUrl(100, TimeUnit.SECONDS));
  }

  @Test
  public void testToBuilder() {
    expect(storage.options()).andReturn(mockOptions).times(6);
    replay(storage);
    Blob fullBlob = new Blob(storage, new BlobInfo.BuilderImpl(FULL_BLOB_INFO));
    assertEquals(fullBlob, fullBlob.toBuilder().build());
    Blob simpleBlob = new Blob(storage, new BlobInfo.BuilderImpl(BLOB_INFO));
    assertEquals(simpleBlob, simpleBlob.toBuilder().build());
    Blob directory = new Blob(storage, new BlobInfo.BuilderImpl(DIRECTORY_INFO));
    assertEquals(directory, directory.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    initializeExpectedBlob(4);
    expect(storage.options()).andReturn(mockOptions).times(4);
    replay(storage);
    Blob.Builder builder = new Blob.Builder(new Blob(storage, new BlobInfo.BuilderImpl(BLOB_INFO)));
    Blob blob = builder.acl(ACL)
        .componentCount(COMPONENT_COUNT)
        .contentType(CONTENT_TYPE)
        .cacheControl(CACHE_CONTROL)
        .contentDisposition(CONTENT_DISPOSITION)
        .contentEncoding(CONTENT_ENCODING)
        .contentLanguage(CONTENT_LANGUAGE)
        .crc32c(CRC32)
        .deleteTime(DELETE_TIME)
        .etag(ETAG)
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
    assertEquals("b", blob.bucket());
    assertEquals("n", blob.name());
    assertEquals(ACL, blob.acl());
    assertEquals(COMPONENT_COUNT, blob.componentCount());
    assertEquals(CONTENT_TYPE, blob.contentType());
    assertEquals(CACHE_CONTROL, blob.cacheControl());
    assertEquals(CONTENT_DISPOSITION, blob.contentDisposition());
    assertEquals(CONTENT_ENCODING, blob.contentEncoding());
    assertEquals(CONTENT_LANGUAGE, blob.contentLanguage());
    assertEquals(CRC32, blob.crc32c());
    assertEquals(DELETE_TIME, blob.deleteTime());
    assertEquals(ETAG, blob.etag());
    assertEquals(ID, blob.id());
    assertEquals(MD5, blob.md5());
    assertEquals(MEDIA_LINK, blob.mediaLink());
    assertEquals(METADATA, blob.metadata());
    assertEquals(META_GENERATION, blob.metageneration());
    assertEquals(OWNER, blob.owner());
    assertEquals(SELF_LINK, blob.selfLink());
    assertEquals(SIZE, blob.size());
    assertEquals(UPDATE_TIME, blob.updateTime());
    assertFalse(blob.isDirectory());
    builder = new Blob.Builder(new Blob(storage, new BlobInfo.BuilderImpl(DIRECTORY_INFO)));
    blob = builder.blobId(BlobId.of("b", "n/"))
        .isDirectory(true)
        .size(0L)
        .build();
    assertEquals("b", blob.bucket());
    assertEquals("n/", blob.name());
    assertNull(blob.acl());
    assertNull(blob.componentCount());
    assertNull(blob.contentType());
    assertNull(blob.cacheControl());
    assertNull(blob.contentDisposition());
    assertNull(blob.contentEncoding());
    assertNull(blob.contentLanguage());
    assertNull(blob.crc32c());
    assertNull(blob.deleteTime());
    assertNull(blob.etag());
    assertNull(blob.id());
    assertNull(blob.md5());
    assertNull(blob.mediaLink());
    assertNull(blob.metadata());
    assertNull(blob.metageneration());
    assertNull(blob.owner());
    assertNull(blob.selfLink());
    assertEquals(0L, (long) blob.size());
    assertNull(blob.updateTime());
    assertTrue(blob.isDirectory());
  }
}
