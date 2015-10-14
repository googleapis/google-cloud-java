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

import static org.easymock.EasyMock.capture;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.google.api.client.util.Lists;
import com.google.gcloud.storage.Storage.CopyRequest;
import org.easymock.Capture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BlobTest {

  private static final BlobInfo BLOB_INFO = BlobInfo.builder("b", "n").build();
  private static final BlobId[] BLOB_ID_ARRAY = {BlobId.of("b1", "n1"),
      BlobId.of("b2", "n2"), BlobId.of("b3", "n3")};
  private static final BlobInfo[] BLOB_INFO_ARRAY = {BlobInfo.builder("b1", "n1").build(),
      BlobInfo.builder("b2", "n2").build(), BlobInfo.builder("b3", "n3").build()};

  private Storage storage;
  private Blob blob;

  @Before
  public void setUp() throws Exception {
    storage = createStrictMock(Storage.class);
    blob = new Blob(storage, BLOB_INFO);
  }

  @After
  public void tearDown() throws Exception {
    verify(storage);
  }

  @Test
  public void testInfo() throws Exception {
    assertEquals(BLOB_INFO, blob.info());
    replay(storage);
  }

  @Test
  public void testExists_True() throws Exception {
    expect(storage.get(BLOB_INFO.blobId())).andReturn(BLOB_INFO);
    replay(storage);
    assertTrue(blob.exists());
  }

  @Test
  public void testExists_False() throws Exception {
    expect(storage.get(BLOB_INFO.blobId())).andReturn(null);
    replay(storage);
    assertFalse(blob.exists());
  }

  @Test
  public void testContent() throws Exception {
    byte[] content = {1, 2};
    expect(storage.readAllBytes(BLOB_INFO.blobId())).andReturn(content);
    replay(storage);
    assertArrayEquals(content, blob.content());
  }

  @Test
  public void testReload() throws Exception {
    BlobInfo updatedInfo = BLOB_INFO.toBuilder().cacheControl("c").build();
    expect(storage.get(BLOB_INFO.blobId(), new Storage.BlobSourceOption[0])).andReturn(updatedInfo);
    replay(storage);
    Blob updatedBlob = blob.reload();
    assertSame(storage, blob.storage());
    assertEquals(updatedInfo, updatedBlob.info());
  }

  @Test
  public void testUpdate() throws Exception {
    BlobInfo updatedInfo = BLOB_INFO.toBuilder().cacheControl("c").build();
    expect(storage.update(updatedInfo, new Storage.BlobTargetOption[0])).andReturn(updatedInfo);
    replay(storage);
    Blob updatedBlob = blob.update(updatedInfo);
    assertSame(storage, blob.storage());
    assertEquals(updatedInfo, updatedBlob.info());
  }

  @Test
  public void testDelete() throws Exception {
    expect(storage.delete(BLOB_INFO.blobId(), new Storage.BlobSourceOption[0])).andReturn(true);
    replay(storage);
    assertTrue(blob.delete());
  }

  @Test
  public void testCopyToBucket() throws Exception {
    BlobInfo target = BLOB_INFO.toBuilder().blobId(BlobId.of("bt", "n")).build();
    Capture<CopyRequest> capturedCopyRequest = Capture.newInstance();
    expect(storage.copy(capture(capturedCopyRequest))).andReturn(target);
    replay(storage);
    Blob targetBlob = blob.copyTo("bt");
    assertEquals(target, targetBlob.info());
    assertEquals(capturedCopyRequest.getValue().source(), blob.id());
    assertEquals(capturedCopyRequest.getValue().target(), target);
    assertSame(storage, targetBlob.storage());
  }

  @Test
  public void testCopyTo() throws Exception {
    BlobInfo target = BLOB_INFO.toBuilder().blobId(BlobId.of("bt", "nt")).build();
    Capture<CopyRequest> capturedCopyRequest = Capture.newInstance();
    expect(storage.copy(capture(capturedCopyRequest))).andReturn(target);
    replay(storage);
    Blob targetBlob = blob.copyTo("bt", "nt");
    assertEquals(target, targetBlob.info());
    assertEquals(capturedCopyRequest.getValue().source(), blob.id());
    assertEquals(capturedCopyRequest.getValue().target(), target);
    assertSame(storage, targetBlob.storage());
  }

  @Test
  public void testReader() throws Exception {
    BlobReadChannel channel = createMock(BlobReadChannel.class);
    expect(storage.reader(BLOB_INFO.blobId())).andReturn(channel);
    replay(storage);
    assertSame(channel, blob.reader());
  }

  @Test
  public void testWriter() throws Exception {
    BlobWriteChannel channel = createMock(BlobWriteChannel.class);
    expect(storage.writer(BLOB_INFO)).andReturn(channel);
    replay(storage);
    assertSame(channel, blob.writer());
  }

  @Test
  public void testSignUrl() throws Exception {
    URL url = new URL("http://localhost:123/bla");
    expect(storage.signUrl(BLOB_INFO, 100, TimeUnit.SECONDS)).andReturn(url);
    replay(storage);
    assertEquals(url, blob.signUrl(100, TimeUnit.SECONDS));
  }

  @Test
  public void testGetNone() throws Exception {
    replay(storage);
    assertTrue(Blob.get(storage).isEmpty());
  }

  @Test
  public void testGetSome() throws Exception {
    List<BlobInfo> blobInfoList = Arrays.asList(BLOB_INFO_ARRAY);
    expect(storage.get(BLOB_ID_ARRAY)).andReturn(blobInfoList);
    replay(storage);
    List<Blob> result = Blob.get(storage, BLOB_ID_ARRAY);
    assertEquals(blobInfoList.size(), result.size());
    for (int i = 0; i < blobInfoList.size(); i++) {
      assertEquals(blobInfoList.get(i), result.get(i).info());
    }
  }

  @Test
  public void testGetSomeNull() throws Exception {
    List<BlobInfo> blobInfoList = Arrays.asList(BLOB_INFO_ARRAY[0], null, BLOB_INFO_ARRAY[2]);
    expect(storage.get(BLOB_ID_ARRAY)).andReturn(blobInfoList);
    replay(storage);
    List<Blob> result = Blob.get(storage, BLOB_ID_ARRAY);
    assertEquals(blobInfoList.size(), result.size());
    for (int i = 0; i < blobInfoList.size(); i++) {
      if (blobInfoList.get(i) != null) {
        assertEquals(blobInfoList.get(i), result.get(i).info());
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
    List<BlobInfo> blobInfoList = Lists.newArrayListWithCapacity(BLOB_ID_ARRAY.length);
    for (BlobInfo info : BLOB_INFO_ARRAY) {
      blobInfoList.add(info.toBuilder().contentType("content").build());
    }
    expect(storage.update(BLOB_INFO_ARRAY)).andReturn(blobInfoList);
    replay(storage);
    List<Blob> result = Blob.update(storage, BLOB_INFO_ARRAY);
    assertEquals(blobInfoList.size(), result.size());
    for (int i = 0; i < blobInfoList.size(); i++) {
      assertEquals(blobInfoList.get(i), result.get(i).info());
    }
  }

  @Test
  public void testUpdateSomeNull() throws Exception {
    List<BlobInfo> blobInfoList = Arrays.asList(
        BLOB_INFO_ARRAY[0].toBuilder().contentType("content").build(), null,
        BLOB_INFO_ARRAY[2].toBuilder().contentType("content").build());
    expect(storage.update(BLOB_INFO_ARRAY)).andReturn(blobInfoList);
    replay(storage);
    List<Blob> result = Blob.update(storage, BLOB_INFO_ARRAY);
    assertEquals(blobInfoList.size(), result.size());
    for (int i = 0; i < blobInfoList.size(); i++) {
      if (blobInfoList.get(i) != null) {
        assertEquals(blobInfoList.get(i), result.get(i).info());
      } else {
        assertNull(result.get(i));
      }
    }
  }

  @Test
  public void testDeleteNone() throws Exception {
    replay(storage);
    assertTrue(Blob.delete(storage).isEmpty());
  }

  @Test
  public void testDeleteSome() throws Exception {
    List<Boolean> deleleResultList = Arrays.asList(true, true, true);
    expect(storage.delete(BLOB_ID_ARRAY)).andReturn(deleleResultList);
    replay(storage);
    List<Boolean> result = Blob.delete(storage, BLOB_ID_ARRAY);
    assertEquals(deleleResultList.size(), result.size());
    for (int i = 0; i < deleleResultList.size(); i++) {
      assertEquals(deleleResultList.get(i), result.get(i));
    }
  }
}
