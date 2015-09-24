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
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.google.gcloud.storage.Storage.CopyRequest;
import org.easymock.Capture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.net.URL;

public class BlobTest {

  private static final BlobInfo BLOB_INFO = BlobInfo.of("b", "n");

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
    expect(storage.get(BLOB_INFO.bucket(), BLOB_INFO.name())).andReturn(BLOB_INFO);
    replay(storage);
    assertTrue(blob.exists());
  }

  @Test
  public void testExists_False() throws Exception {
    expect(storage.get(BLOB_INFO.bucket(), BLOB_INFO.name())).andReturn(null);
    replay(storage);
    assertFalse(blob.exists());
  }

  @Test
  public void testContent() throws Exception {
    byte[] content = {1, 2};
    expect(storage.readAllBytes(BLOB_INFO.bucket(), BLOB_INFO.name())).andReturn(content);
    replay(storage);
    assertArrayEquals(content, blob.content());
  }

  @Test
  public void testUpdate() throws Exception {
    BlobInfo updatedInfo = BLOB_INFO.toBuilder().cacheControl("c").build();
    expect(storage.update(updatedInfo)).andReturn(updatedInfo);
    replay(storage);
    blob.update(updatedInfo);
    assertSame(storage, blob.storage());
    assertEquals(updatedInfo, blob.info());
  }

  @Test
  public void testDelete() throws Exception {
    expect(storage.delete(BLOB_INFO.bucket(), BLOB_INFO.name())).andReturn(true);
    replay(storage);
    assertTrue(blob.delete());
  }

  @Test
  public void testCopyToBucket() throws Exception {
    BlobInfo target = BLOB_INFO.toBuilder().bucket("bt").build();
    Capture<CopyRequest> capturedCopyRequest = Capture.newInstance();
    expect(storage.copy(capture(capturedCopyRequest))).andReturn(target);
    replay(storage);
    Blob targetBlob = blob.copyTo("bt");
    assertEquals(target, targetBlob.info());
    assertEquals(capturedCopyRequest.getValue().sourceBlob(), blob.info().name());
    assertEquals(capturedCopyRequest.getValue().sourceBucket(), blob.info().bucket());
    assertEquals(capturedCopyRequest.getValue().target(), target);
    assertSame(storage, targetBlob.storage());
  }

  @Test
  public void testCopyTo() throws Exception {
    BlobInfo target = BLOB_INFO.toBuilder().bucket("bt").name("nt").build();
    Capture<CopyRequest> capturedCopyRequest = Capture.newInstance();
    expect(storage.copy(capture(capturedCopyRequest))).andReturn(target);
    replay(storage);
    Blob targetBlob = blob.copyTo("bt", "nt");
    assertEquals(target, targetBlob.info());
    assertEquals(capturedCopyRequest.getValue().sourceBlob(), blob.info().name());
    assertEquals(capturedCopyRequest.getValue().sourceBucket(), blob.info().bucket());
    assertEquals(capturedCopyRequest.getValue().target(), target);
    assertSame(storage, targetBlob.storage());
  }

  @Test
  public void testReader() throws Exception {
    BlobReadChannel channel = createMock(BlobReadChannel.class);
    expect(storage.reader(BLOB_INFO.bucket(), BLOB_INFO.name())).andReturn(channel);
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
    expect(storage.signUrl(BLOB_INFO, 100)).andReturn(url);
    replay(storage);
    assertEquals(url, blob.signUrl(100));
  }
}
