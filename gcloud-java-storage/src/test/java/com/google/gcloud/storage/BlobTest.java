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
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.google.api.client.util.Lists;
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
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BlobTest {

  private static final List<Acl> ACL = ImmutableList.of(
      new Acl(User.ofAllAuthenticatedUsers(), READER), new Acl(new Project(VIEWERS, "p1"), WRITER));
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
  private static final BlobId[] BLOB_ID_ARRAY = {BlobId.of("b1", "n1"),
      BlobId.of("b2", "n2"), BlobId.of("b3", "n3")};
  private static final StorageOptions STORAGE_OPTIONS = createMock(StorageOptions.class);

  private Blob[] blobArray;
  private Blob[] expectedBlobArray;
  private Storage storage;
  private Storage simpleStorageMock;
  private Blob fullBlob;
  private Blob simpleBlob;
  private Blob expectedSimpleBlob;

  @Before
  public void setUp() throws Exception {
    storage = createStrictMock(Storage.class);
    expect(storage.options()).andReturn(STORAGE_OPTIONS).anyTimes();
    simpleStorageMock = createStrictMock(Storage.class);
    expect(simpleStorageMock.options()).andReturn(STORAGE_OPTIONS).anyTimes();
    replay(simpleStorageMock);
    expectedSimpleBlob = Blob.builder(simpleStorageMock, "b", "n").metageneration(42L).build();
    expectedBlobArray = new Blob[] {
        Blob.builder(simpleStorageMock, "b1", "n1").build(),
        Blob.builder(simpleStorageMock, "b2", "n2").build(),
        Blob.builder(simpleStorageMock, "b3", "n3").build()};
  }

  @After
  public void tearDown() throws Exception {
    verify(storage);
  }

  private void initializeBlobs() {
    fullBlob =
        Blob.builder(storage, "b", "n", GENERATION)
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
    simpleBlob = Blob.builder(storage, "b", "n").metageneration(42L).build();
    blobArray = new Blob[] {Blob.builder(storage, "b1", "n1").build(),
        Blob.builder(storage, "b2", "n2").build(), Blob.builder(storage, "b3", "n3").build()};
  }

  @Test
  public void testToBuilder() {
    replay(storage);
    initializeBlobs();
    compareBlobs(fullBlob, fullBlob.toBuilder().build());
    Blob blob = fullBlob.toBuilder().blobId(BlobId.of("b2", "n2")).size(200L).build();
    assertEquals("n2", blob.name());
    assertEquals("b2", blob.bucket());
    assertEquals(Long.valueOf(200), blob.size());
    blob = blob.toBuilder().blobId(BlobId.of("b", "n", GENERATION)).size(SIZE).build();
    compareBlobs(fullBlob, blob);
  }

  @Test
  public void testToBuilderIncomplete() {
    replay(storage);
    initializeBlobs();
    Blob incompleteBlob = Blob.builder(storage, BlobId.of("b2", "n2")).build();
    compareBlobs(incompleteBlob, incompleteBlob.toBuilder().build());
  }

  @Test
  public void testBuilder() {
    replay(storage);
    initializeBlobs();
    assertEquals("b", fullBlob.bucket());
    assertEquals("n", fullBlob.name());
    assertEquals(ACL, fullBlob.acl());
    assertEquals(COMPONENT_COUNT, fullBlob.componentCount());
    assertEquals(CONTENT_TYPE, fullBlob.contentType());
    assertEquals(CACHE_CONTROL, fullBlob.cacheControl());
    assertEquals(CONTENT_DISPOSITION, fullBlob.contentDisposition());
    assertEquals(CONTENT_ENCODING, fullBlob.contentEncoding());
    assertEquals(CONTENT_LANGUAGE, fullBlob.contentLanguage());
    assertEquals(CRC32, fullBlob.crc32c());
    assertEquals(DELETE_TIME, fullBlob.deleteTime());
    assertEquals(ETAG, fullBlob.etag());
    assertEquals(GENERATION, fullBlob.generation());
    assertEquals(ID, fullBlob.id());
    assertEquals(MD5, fullBlob.md5());
    assertEquals(MEDIA_LINK, fullBlob.mediaLink());
    assertEquals(METADATA, fullBlob.metadata());
    assertEquals(META_GENERATION, fullBlob.metageneration());
    assertEquals(OWNER, fullBlob.owner());
    assertEquals(SELF_LINK, fullBlob.selfLink());
    assertEquals(SIZE, fullBlob.size());
    assertEquals(UPDATE_TIME, fullBlob.updateTime());
    assertEquals(STORAGE_OPTIONS, fullBlob.storage().options());
  }

  @Test
  public void testToPbAndFromPb() {
    replay(storage);
    initializeBlobs();
    compareBlobs(fullBlob, Blob.fromPb(storage, fullBlob.toPb()));
    Blob blob = Blob.builder(storage, BlobId.of("b", "n")).build();
    compareBlobs(blob, Blob.fromPb(storage, blob.toPb()));
  }

  @Test
  public void testBlobId() {
    replay(storage);
    initializeBlobs();
    assertEquals(BlobId.of("b", "n", GENERATION), fullBlob.blobId());
  }

  @Test
  public void testExists_True() throws Exception {
    Storage.BlobGetOption[] expectedOptions = {Storage.BlobGetOption.fields()};
    expect(storage.get(expectedSimpleBlob.blobId(), expectedOptions)).andReturn(expectedSimpleBlob);
    replay(storage);
    initializeBlobs();
    assertTrue(simpleBlob.exists());
  }

  @Test
  public void testExists_False() throws Exception {
    Storage.BlobGetOption[] expectedOptions = {Storage.BlobGetOption.fields()};
    expect(storage.get(expectedSimpleBlob.blobId(), expectedOptions)).andReturn(null);
    replay(storage);
    initializeBlobs();
    assertFalse(simpleBlob.exists());
  }

  @Test
  public void testContent() throws Exception {
    byte[] content = {1, 2};
    expect(storage.readAllBytes(expectedSimpleBlob.blobId())).andReturn(content);
    replay(storage);
    initializeBlobs();
    assertArrayEquals(content, simpleBlob.content());
  }

  @Test
  public void testReload() throws Exception {
    Blob expected = expectedSimpleBlob.toBuilder().cacheControl("c").build();
    expect(storage.get(expectedSimpleBlob.blobId(), new Storage.BlobGetOption[0]))
        .andReturn(expected);
    replay(storage);
    initializeBlobs();
    Blob updatedBlob = simpleBlob.reload();
    assertSame(simpleStorageMock, updatedBlob.storage());
    assertEquals(expected, updatedBlob);
  }

  @Test
  public void testReloadNull() throws Exception {
    expect(storage.get(expectedSimpleBlob.blobId(), new Storage.BlobGetOption[0])).andReturn(null);
    replay(storage);
    initializeBlobs();
    assertNull(simpleBlob.reload());
  }

  @Test
  public void testReloadWithOptions() throws Exception {
    Blob expected = expectedSimpleBlob.toBuilder().cacheControl("c").build();
    Storage.BlobGetOption[] options = {Storage.BlobGetOption.metagenerationMatch(42L)};
    expect(storage.get(expectedSimpleBlob.blobId(), options)).andReturn(expected);
    replay(storage);
    initializeBlobs();
    Blob updatedBlob = simpleBlob.reload(Blob.BlobSourceOption.metagenerationMatch());
    assertSame(simpleStorageMock, updatedBlob.storage());
    assertEquals(expected, updatedBlob);
  }

  @Test
  public void testUpdate() throws Exception {
    Blob expected = expectedSimpleBlob.toBuilder().cacheControl("c").build();
    expect(storage.update(expected, new Storage.BlobTargetOption[0])).andReturn(expected);
    replay(storage);
    initializeBlobs();
    Blob updatedBlob = simpleBlob.update(expected);
    assertSame(storage, simpleBlob.storage());
    assertEquals(expected, updatedBlob);
  }

  @Test
  public void testDelete() throws Exception {
    expect(storage.delete(expectedSimpleBlob.blobId(), new Storage.BlobSourceOption[0]))
        .andReturn(true);
    replay(storage);
    initializeBlobs();
    assertTrue(simpleBlob.delete());
  }

  @Test
  public void testCopyToBucket() throws Exception {
    CopyWriter copyWriter = createMock(CopyWriter.class);
    Capture<CopyRequest> capturedCopyRequest = Capture.newInstance();
    expect(storage.copy(capture(capturedCopyRequest))).andReturn(copyWriter);
    replay(storage);
    initializeBlobs();
    Blob target = Blob.builder(storage, BlobId.of("bt", "n")).build();
    CopyWriter returnedCopyWriter = simpleBlob.copyTo("bt");
    assertEquals(copyWriter, returnedCopyWriter);
    assertEquals(capturedCopyRequest.getValue().source(), simpleBlob.blobId());
    assertEquals(capturedCopyRequest.getValue().target(), target);
    assertTrue(capturedCopyRequest.getValue().sourceOptions().isEmpty());
    assertTrue(capturedCopyRequest.getValue().targetOptions().isEmpty());
  }

  @Test
  public void testCopyTo() throws Exception {
    CopyWriter copyWriter = createMock(CopyWriter.class);
    Capture<CopyRequest> capturedCopyRequest = Capture.newInstance();
    expect(storage.copy(capture(capturedCopyRequest))).andReturn(copyWriter);
    replay(storage);
    initializeBlobs();
    Blob target = Blob.builder(storage, BlobId.of("bt", "nt")).build();
    CopyWriter returnedCopyWriter = simpleBlob.copyTo("bt", "nt");
    assertEquals(copyWriter, returnedCopyWriter);
    assertEquals(capturedCopyRequest.getValue().source(), simpleBlob.blobId());
    assertEquals(capturedCopyRequest.getValue().target(), target);
    assertTrue(capturedCopyRequest.getValue().sourceOptions().isEmpty());
    assertTrue(capturedCopyRequest.getValue().targetOptions().isEmpty());
  }

  @Test
  public void testCopyToBlobId() throws Exception {
    BlobId targetId = BlobId.of("bt", "nt");
    CopyWriter copyWriter = createMock(CopyWriter.class);
    Capture<CopyRequest> capturedCopyRequest = Capture.newInstance();
    expect(storage.copy(capture(capturedCopyRequest))).andReturn(copyWriter);
    replay(storage);
    initializeBlobs();
    Blob target = Blob.builder(storage, targetId).build();
    CopyWriter returnedCopyWriter = simpleBlob.copyTo(targetId);
    assertEquals(copyWriter, returnedCopyWriter);
    assertEquals(capturedCopyRequest.getValue().source(), simpleBlob.blobId());
    assertEquals(capturedCopyRequest.getValue().target(), target);
    assertTrue(capturedCopyRequest.getValue().sourceOptions().isEmpty());
    assertTrue(capturedCopyRequest.getValue().targetOptions().isEmpty());
  }

  @Test
  public void testReader() throws Exception {
    ReadChannel channel = createMock(BlobReadChannel.class);
    expect(storage.reader(expectedSimpleBlob.blobId())).andReturn(channel);
    replay(storage);
    initializeBlobs();
    assertSame(channel, simpleBlob.reader());
  }

  @Test
  public void testWriter() throws Exception {
    BlobWriteChannel channel = createMock(BlobWriteChannel.class);
    expect(storage.writer(expectedSimpleBlob)).andReturn(channel);
    replay(storage);
    initializeBlobs();
    assertSame(channel, simpleBlob.writer());
  }

  @Test
  public void testSignUrl() throws Exception {
    URL url = new URL("http://localhost:123/bla");
    expect(storage.signUrl(expectedSimpleBlob, 100, TimeUnit.SECONDS)).andReturn(url);
    replay(storage);
    initializeBlobs();
    assertEquals(url, simpleBlob.signUrl(100, TimeUnit.SECONDS));
  }

  @Test
  public void testGetSome() throws Exception {
    List<Blob> blobList = Arrays.asList(expectedBlobArray);
    expect(storage.get(BLOB_ID_ARRAY)).andReturn(blobList);
    replay(storage);
    initializeBlobs();
    List<Blob> result = Blob.get(storage, BLOB_ID_ARRAY[0], BLOB_ID_ARRAY[1], BLOB_ID_ARRAY[2]);
    assertEquals(blobList.size(), result.size());
    for (int i = 0; i < blobList.size(); i++) {
      assertEquals(blobList.get(i), result.get(i));
    }
  }

  @Test
  public void testGetSomeList() throws Exception {
    List<Blob> blobList = Arrays.asList(expectedBlobArray);
    expect(storage.get(BLOB_ID_ARRAY)).andReturn(blobList);
    replay(storage);
    initializeBlobs();
    List<Blob> result = Blob.get(storage, Arrays.asList(BLOB_ID_ARRAY));
    assertEquals(blobList.size(), result.size());
    for (int i = 0; i < blobList.size(); i++) {
      assertEquals(blobList.get(i), result.get(i));
    }
  }

  @Test
  public void testGetSomeNull() throws Exception {
    List<Blob> blobList =
        Arrays.asList(expectedBlobArray[0], null, expectedBlobArray[2]);
    expect(storage.get(BLOB_ID_ARRAY)).andReturn(blobList);
    replay(storage);
    initializeBlobs();
    List<Blob> result = Blob.get(storage, BLOB_ID_ARRAY[0], BLOB_ID_ARRAY[1], BLOB_ID_ARRAY[2]);
    assertEquals(blobList.size(), result.size());
    for (int i = 0; i < blobList.size(); i++) {
      if (blobList.get(i) != null) {
        assertEquals(blobList.get(i), result.get(i));
      } else {
        assertNull(result.get(i));
      }
    }
  }

  @Test
  public void testUpdateNone() throws Exception {
    replay(storage);
    assertTrue(Blob.update(storage).isEmpty());
  }

  @Test
  public void testUpdateSome() throws Exception {
    List<Blob> blobList = Lists.newArrayListWithCapacity(BLOB_ID_ARRAY.length);
    for (Blob blob : expectedBlobArray) {
      blobList.add(blob.toBuilder().contentType("content").build());
    }
    expect(storage.update(expectedBlobArray)).andReturn(blobList);
    replay(storage);
    initializeBlobs();
    List<Blob> result = Blob.update(storage, blobArray);
    assertEquals(blobList.size(), result.size());
    for (int i = 0; i < blobList.size(); i++) {
      assertEquals(blobList.get(i), result.get(i));
    }
  }

  @Test
  public void testUpdateSomeNull() throws Exception {
    List<Blob> blobList =
        Arrays.asList(expectedBlobArray[0].toBuilder().contentType("content").build(), null,
            expectedBlobArray[2].toBuilder().contentType("content").build());
    expect(storage.update(expectedBlobArray)).andReturn(blobList);
    replay(storage);
    initializeBlobs();
    List<Blob> result = Blob.update(storage, blobArray);
    assertEquals(blobList.size(), result.size());
    for (int i = 0; i < blobList.size(); i++) {
      if (blobList.get(i) != null) {
        assertEquals(blobList.get(i), result.get(i));
      } else {
        assertNull(result.get(i));
      }
    }
  }

  @Test
  public void testDeleteNone() throws Exception {
    replay(storage);
    initializeBlobs();
    assertTrue(Blob.delete(storage).isEmpty());
  }

  @Test
  public void testDeleteSome() throws Exception {
    List<Boolean> deleteResult = Arrays.asList(true, true, true);
    expect(storage.delete(BLOB_ID_ARRAY)).andReturn(deleteResult);
    replay(storage);
    initializeBlobs();
    List<Boolean> result = Blob.delete(storage, BLOB_ID_ARRAY);
    assertEquals(deleteResult.size(), result.size());
    for (int i = 0; i < deleteResult.size(); i++) {
      assertEquals(deleteResult.get(i), result.get(i));
    }
  }

  @Test
  public void testGetFromString() throws Exception {
    expect(storage.get(expectedSimpleBlob.blobId(), new Storage.BlobGetOption[0]))
        .andReturn(expectedSimpleBlob);
    replay(storage);
    initializeBlobs();
    Blob loadedBlob = Blob.get(storage, simpleBlob.bucket(), simpleBlob.name());
    assertEquals(simpleBlob, loadedBlob);
  }

  @Test
  public void testGetFromId() throws Exception {
    expect(storage.get(expectedSimpleBlob.blobId(), new Storage.BlobGetOption[0]))
        .andReturn(expectedSimpleBlob);
    replay(storage);
    initializeBlobs();
    Blob loadedBlob = Blob.get(storage, simpleBlob.blobId());
    assertNotNull(loadedBlob);
    assertEquals(simpleBlob, loadedBlob);
  }

  @Test
  public void testGetFromStringNull() throws Exception {
    expect(storage.get(expectedSimpleBlob.blobId(), new Storage.BlobGetOption[0])).andReturn(null);
    replay(storage);
    initializeBlobs();
    assertNull(Blob.get(storage, simpleBlob.bucket(), simpleBlob.name()));
  }

  @Test
  public void testGetFromIdNull() throws Exception {
    expect(storage.get(expectedSimpleBlob.blobId(), new Storage.BlobGetOption[0])).andReturn(null);
    replay(storage);
    initializeBlobs();
    assertNull(Blob.get(storage, simpleBlob.blobId()));
  }

  @Test
  public void testGetFromStringWithOptions() throws Exception {
    expect(storage.get(expectedSimpleBlob.blobId(), Storage.BlobGetOption.generationMatch(42L)))
        .andReturn(expectedSimpleBlob);
    replay(storage);
    initializeBlobs();
    Blob loadedBlob = Blob.get(storage, simpleBlob.bucket(), simpleBlob.name(),
        Storage.BlobGetOption.generationMatch(42L));
    assertEquals(simpleBlob, loadedBlob);
  }

  @Test
  public void testGetFromIdWithOptions() throws Exception {
    expect(storage.get(expectedSimpleBlob.blobId(), Storage.BlobGetOption.generationMatch(42L)))
        .andReturn(expectedSimpleBlob);
    replay(storage);
    initializeBlobs();
    Blob loadedBlob =
        Blob.get(storage, simpleBlob.blobId(), Storage.BlobGetOption.generationMatch(42L));
    assertNotNull(loadedBlob);
    assertEquals(simpleBlob, loadedBlob);
  }

  private void compareBlobs(Blob expected, Blob value) {
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
    assertEquals(expected.id(), value.id());
    assertEquals(expected.md5(), value.md5());
    assertEquals(expected.mediaLink(), value.mediaLink());
    assertEquals(expected.metadata(), value.metadata());
    assertEquals(expected.metageneration(), value.metageneration());
    assertEquals(expected.owner(), value.owner());
    assertEquals(expected.selfLink(), value.selfLink());
    assertEquals(expected.size(), value.size());
    assertEquals(expected.updateTime(), value.updateTime());
    assertEquals(expected.storage().options(), value.storage().options());
  }
}
