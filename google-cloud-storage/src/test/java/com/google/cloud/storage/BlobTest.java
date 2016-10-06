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

import com.google.cloud.ReadChannel;
import com.google.cloud.storage.Acl.Project;
import com.google.cloud.storage.Acl.Project.ProjectRole;
import com.google.cloud.storage.Acl.Role;
import com.google.cloud.storage.Acl.User;
import com.google.cloud.storage.Blob.BlobSourceOption;
import com.google.cloud.storage.Storage.BlobWriteOption;
import com.google.cloud.storage.Storage.CopyRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.io.BaseEncoding;

import org.easymock.Capture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.URL;
import java.security.Key;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.crypto.spec.SecretKeySpec;

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
  private static final Long CREATE_TIME = UPDATE_TIME - 1L;
  private static final String ENCRYPTION_ALGORITHM = "AES256";
  private static final String KEY_SHA256 = "keySha";
  private static final BlobInfo.CustomerEncryption CUSTOMER_ENCRYPTION =
      new BlobInfo.CustomerEncryption(ENCRYPTION_ALGORITHM, KEY_SHA256);
  private static final BlobInfo FULL_BLOB_INFO = BlobInfo.newBuilder("b", "n", GENERATION)
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
      .setCustomerEncryption(CUSTOMER_ENCRYPTION)
      .build();
  private static final BlobInfo BLOB_INFO = BlobInfo.newBuilder("b", "n")
      .setMetageneration(42L)
      .build();
  private static final BlobInfo DIRECTORY_INFO = BlobInfo.newBuilder("b", "n/")
      .setSize(0L)
      .setIsDirectory(true)
      .build();
  private static final String BASE64_KEY = "JVzfVl8NLD9FjedFuStegjRfES5ll5zc59CIXw572OA=";
  private static final Key KEY =
      new SecretKeySpec(BaseEncoding.base64().decode(BASE64_KEY), "AES256");

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
    expect(storage.get(expectedBlob.getBlobId(), expectedOptions)).andReturn(expectedBlob);
    replay(storage);
    initializeBlob();
    assertTrue(blob.exists());
  }

  @Test
  public void testExists_False() throws Exception {
    Storage.BlobGetOption[] expectedOptions = {Storage.BlobGetOption.fields()};
    expect(storage.options()).andReturn(null);
    expect(storage.get(BLOB_INFO.getBlobId(), expectedOptions)).andReturn(null);
    replay(storage);
    initializeBlob();
    assertFalse(blob.exists());
  }

  @Test
  public void testContent() throws Exception {
    initializeExpectedBlob(2);
    byte[] content = {1, 2};
    expect(storage.options()).andReturn(mockOptions);
    expect(storage.readAllBytes(BLOB_INFO.getBlobId())).andReturn(content);
    replay(storage);
    initializeBlob();
    assertArrayEquals(content, blob.getContent());
  }

  @Test
  public void testContentWithDecryptionKey() throws Exception {
    initializeExpectedBlob(2);
    byte[] content = {1, 2};
    expect(storage.options()).andReturn(mockOptions);
    expect(storage.readAllBytes(BLOB_INFO.getBlobId(),
        Storage.BlobSourceOption.decryptionKey(BASE64_KEY)))
        .andReturn(content).times(2);
    replay(storage);
    initializeBlob();
    assertArrayEquals(content, blob.getContent(BlobSourceOption.decryptionKey(BASE64_KEY)));
    assertArrayEquals(content, blob.getContent(BlobSourceOption.decryptionKey(KEY)));
  }

  @Test
  public void testReload() throws Exception {
    initializeExpectedBlob(2);
    Blob expectedReloadedBlob = expectedBlob.toBuilder().setCacheControl("c").build();
    expect(storage.options()).andReturn(mockOptions);
    expect(storage.get(BLOB_INFO.getBlobId(), new Storage.BlobGetOption[0]))
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
    expect(storage.get(BLOB_INFO.getBlobId(), new Storage.BlobGetOption[0])).andReturn(null);
    replay(storage);
    initializeBlob();
    Blob reloadedBlob = blob.reload();
    assertNull(reloadedBlob);
  }

  @Test
  public void testReloadWithOptions() throws Exception {
    initializeExpectedBlob(2);
    Blob expectedReloadedBlob = expectedBlob.toBuilder().setCacheControl("c").build();
    Storage.BlobGetOption[] options = {Storage.BlobGetOption.metagenerationMatch(42L)};
    expect(storage.options()).andReturn(mockOptions);
    expect(storage.get(BLOB_INFO.getBlobId(), options)).andReturn(expectedReloadedBlob);
    replay(storage);
    initializeBlob();
    Blob updatedBlob = blob.reload(BlobSourceOption.metagenerationMatch());
    assertEquals(expectedReloadedBlob, updatedBlob);
  }

  @Test
  public void testUpdate() throws Exception {
    initializeExpectedBlob(2);
    Blob expectedUpdatedBlob = expectedBlob.toBuilder().setCacheControl("c").build();
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
    expect(storage.delete(BLOB_INFO.getBlobId(), new Storage.BlobSourceOption[0])).andReturn(true);
    replay(storage);
    initializeBlob();
    assertTrue(blob.delete());
  }

  @Test
  public void testCopyToBucket() throws Exception {
    initializeExpectedBlob(2);
    BlobInfo target = BlobInfo.newBuilder(BlobId.of("bt", "n")).build();
    CopyWriter copyWriter = createMock(CopyWriter.class);
    Capture<CopyRequest> capturedCopyRequest = Capture.newInstance();
    expect(storage.options()).andReturn(mockOptions);
    expect(storage.copy(capture(capturedCopyRequest))).andReturn(copyWriter);
    replay(storage);
    initializeBlob();
    CopyWriter returnedCopyWriter = blob.copyTo("bt");
    assertEquals(copyWriter, returnedCopyWriter);
    assertEquals(capturedCopyRequest.getValue().getSource(), blob.getBlobId());
    assertEquals(capturedCopyRequest.getValue().getTarget(), target);
    assertFalse(capturedCopyRequest.getValue().overrideInfo());
    assertTrue(capturedCopyRequest.getValue().getSourceOptions().isEmpty());
    assertTrue(capturedCopyRequest.getValue().getTargetOptions().isEmpty());
  }

  @Test
  public void testCopyTo() throws Exception {
    initializeExpectedBlob(2);
    BlobInfo target = BlobInfo.newBuilder(BlobId.of("bt", "nt")).build();
    CopyWriter copyWriter = createMock(CopyWriter.class);
    Capture<CopyRequest> capturedCopyRequest = Capture.newInstance();
    expect(storage.options()).andReturn(mockOptions);
    expect(storage.copy(capture(capturedCopyRequest))).andReturn(copyWriter);
    replay(storage);
    initializeBlob();
    CopyWriter returnedCopyWriter = blob.copyTo("bt", "nt");
    assertEquals(copyWriter, returnedCopyWriter);
    assertEquals(capturedCopyRequest.getValue().getSource(), blob.getBlobId());
    assertEquals(capturedCopyRequest.getValue().getTarget(), target);
    assertFalse(capturedCopyRequest.getValue().overrideInfo());
    assertTrue(capturedCopyRequest.getValue().getSourceOptions().isEmpty());
    assertTrue(capturedCopyRequest.getValue().getTargetOptions().isEmpty());
  }

  @Test
  public void testCopyToBlobId() throws Exception {
    initializeExpectedBlob(2);
    BlobInfo target = BlobInfo.newBuilder(BlobId.of("bt", "nt")).build();
    BlobId targetId = BlobId.of("bt", "nt");
    CopyWriter copyWriter = createMock(CopyWriter.class);
    Capture<CopyRequest> capturedCopyRequest = Capture.newInstance();
    expect(storage.options()).andReturn(mockOptions);
    expect(storage.copy(capture(capturedCopyRequest))).andReturn(copyWriter);
    replay(storage);
    initializeBlob();
    CopyWriter returnedCopyWriter = blob.copyTo(targetId);
    assertEquals(copyWriter, returnedCopyWriter);
    assertEquals(capturedCopyRequest.getValue().getSource(), blob.getBlobId());
    assertEquals(capturedCopyRequest.getValue().getTarget(), target);
    assertFalse(capturedCopyRequest.getValue().overrideInfo());
    assertTrue(capturedCopyRequest.getValue().getSourceOptions().isEmpty());
    assertTrue(capturedCopyRequest.getValue().getTargetOptions().isEmpty());
  }

  @Test
  public void testReader() throws Exception {
    initializeExpectedBlob(2);
    ReadChannel channel = createMock(ReadChannel.class);
    expect(storage.options()).andReturn(mockOptions);
    expect(storage.reader(BLOB_INFO.getBlobId())).andReturn(channel);
    replay(storage);
    initializeBlob();
    assertSame(channel, blob.reader());
  }

  @Test
  public void testReaderWithDecryptionKey() throws Exception {
    initializeExpectedBlob(2);
    ReadChannel channel = createMock(ReadChannel.class);
    expect(storage.options()).andReturn(mockOptions);
    expect(storage.reader(BLOB_INFO.getBlobId(), Storage.BlobSourceOption.decryptionKey(BASE64_KEY)))
        .andReturn(channel).times(2);
    replay(storage);
    initializeBlob();
    assertSame(channel, blob.reader(BlobSourceOption.decryptionKey(BASE64_KEY)));
    assertSame(channel, blob.reader(BlobSourceOption.decryptionKey(KEY)));
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
  public void testWriterWithEncryptionKey() throws Exception {
    initializeExpectedBlob(2);
    BlobWriteChannel channel = createMock(BlobWriteChannel.class);
    expect(storage.options()).andReturn(mockOptions);
    expect(storage.writer(eq(expectedBlob), eq(BlobWriteOption.encryptionKey(BASE64_KEY))))
        .andReturn(channel).times(2);
    replay(storage);
    initializeBlob();
    assertSame(channel, blob.writer(BlobWriteOption.encryptionKey(BASE64_KEY)));
    assertSame(channel, blob.writer(BlobWriteOption.encryptionKey(KEY)));
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
  public void testGetAcl() throws Exception {
    initializeExpectedBlob(1);
    expect(storage.options()).andReturn(mockOptions);
    expect(storage.getAcl(BLOB_INFO.getBlobId(), User.ofAllAuthenticatedUsers())).andReturn(ACL);
    replay(storage);
    initializeBlob();
    assertEquals(ACL, blob.getAcl(User.ofAllAuthenticatedUsers()));
  }

  @Test
  public void testDeleteAcl() throws Exception {
    initializeExpectedBlob(1);
    expect(storage.options()).andReturn(mockOptions);
    expect(storage.deleteAcl(BLOB_INFO.getBlobId(), User.ofAllAuthenticatedUsers())).andReturn(true);
    replay(storage);
    initializeBlob();
    assertTrue(blob.deleteAcl(User.ofAllAuthenticatedUsers()));
  }

  @Test
  public void testCreateAcl() throws Exception {
    initializeExpectedBlob(1);
    expect(storage.options()).andReturn(mockOptions);
    Acl returnedAcl = ACL.toBuilder().setEtag("ETAG").setId("ID").build();
    expect(storage.createAcl(BLOB_INFO.getBlobId(), ACL)).andReturn(returnedAcl);
    replay(storage);
    initializeBlob();
    assertEquals(returnedAcl, blob.createAcl(ACL));
  }

  @Test
  public void testUpdateAcl() throws Exception {
    initializeExpectedBlob(1);
    expect(storage.options()).andReturn(mockOptions);
    Acl returnedAcl = ACL.toBuilder().setEtag("ETAG").setId("ID").build();
    expect(storage.updateAcl(BLOB_INFO.getBlobId(), ACL)).andReturn(returnedAcl);
    replay(storage);
    initializeBlob();
    assertEquals(returnedAcl, blob.updateAcl(ACL));
  }

  @Test
  public void testListAcls() throws Exception {
    initializeExpectedBlob(1);
    expect(storage.options()).andReturn(mockOptions);
    expect(storage.listAcls(BLOB_INFO.getBlobId())).andReturn(ACLS);
    replay(storage);
    initializeBlob();
    assertEquals(ACLS, blob.listAcls());
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
    expect(storage.options()).andReturn(mockOptions).times(6);
    replay(storage);
    Blob.Builder builder = new Blob.Builder(new Blob(storage, new BlobInfo.BuilderImpl(BLOB_INFO)));
    Blob blob = builder.setAcl(ACLS)
        .setComponentCount(COMPONENT_COUNT)
        .setContentType(CONTENT_TYPE)
        .setCacheControl(CACHE_CONTROL)
        .setContentDisposition(CONTENT_DISPOSITION)
        .setContentEncoding(CONTENT_ENCODING)
        .setContentLanguage(CONTENT_LANGUAGE)
        .setCrc32c(CRC32)
        .setCreateTime(CREATE_TIME)
        .setCustomerEncryption(CUSTOMER_ENCRYPTION)
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
    assertEquals(CREATE_TIME, blob.getCreateTime());
    assertEquals(CUSTOMER_ENCRYPTION, blob.getCustomerEncryption());
    assertEquals(DELETE_TIME, blob.getDeleteTime());
    assertEquals(ETAG, blob.getEtag());
    assertEquals(GENERATED_ID, blob.getGeneratedId());
    assertEquals(MD5, blob.getMd5());
    assertEquals(MEDIA_LINK, blob.getMediaLink());
    assertEquals(METADATA, blob.getMetadata());
    assertEquals(META_GENERATION, blob.getMetageneration());
    assertEquals(OWNER, blob.getOwner());
    assertEquals(SELF_LINK, blob.getSelfLink());
    assertEquals(SIZE, blob.getSize());
    assertEquals(UPDATE_TIME, blob.getUpdateTime());
    assertEquals(storage.options(), blob.getStorage().options());
    assertFalse(blob.isDirectory());
    builder = new Blob.Builder(new Blob(storage, new BlobInfo.BuilderImpl(DIRECTORY_INFO)));
    blob = builder.setBlobId(BlobId.of("b", "n/"))
        .setIsDirectory(true)
        .setSize(0L)
        .build();
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
    assertNull(blob.getCreateTime());
    assertNull(blob.getCustomerEncryption());
    assertNull(blob.getDeleteTime());
    assertNull(blob.getEtag());
    assertNull(blob.getGeneratedId());
    assertNull(blob.getMd5());
    assertNull(blob.getMediaLink());
    assertNull(blob.getMetadata());
    assertNull(blob.getMetageneration());
    assertNull(blob.getOwner());
    assertNull(blob.getSelfLink());
    assertEquals(0L, (long) blob.getSize());
    assertNull(blob.getUpdateTime());
    assertTrue(blob.isDirectory());
  }

  @Test
  public void testBuilderDeprecated() {
    initializeExpectedBlob(4);
    expect(storage.options()).andReturn(mockOptions).times(6);
    replay(storage);
    Blob.Builder builder = new Blob.Builder(new Blob(storage, new BlobInfo.BuilderImpl(BLOB_INFO)));
    Blob blob = builder.acl(ACLS)
        .setComponentCount(COMPONENT_COUNT)
        .contentType(CONTENT_TYPE)
        .cacheControl(CACHE_CONTROL)
        .contentDisposition(CONTENT_DISPOSITION)
        .contentEncoding(CONTENT_ENCODING)
        .contentLanguage(CONTENT_LANGUAGE)
        .crc32c(CRC32)
        .setCreateTime(CREATE_TIME)
        .setCustomerEncryption(CUSTOMER_ENCRYPTION)
        .setDeleteTime(DELETE_TIME)
        .setEtag(ETAG)
        .setGeneratedId(GENERATED_ID)
        .md5(MD5)
        .setMediaLink(MEDIA_LINK)
        .metadata(METADATA)
        .setMetageneration(META_GENERATION)
        .setOwner(OWNER)
        .setSelfLink(SELF_LINK)
        .setSize(SIZE)
        .setUpdateTime(UPDATE_TIME)
        .build();
    assertEquals("b", blob.bucket());
    assertEquals("n", blob.name());
    assertEquals(ACLS, blob.acl());
    assertEquals(COMPONENT_COUNT, blob.componentCount());
    assertEquals(CONTENT_TYPE, blob.contentType());
    assertEquals(CACHE_CONTROL, blob.cacheControl());
    assertEquals(CONTENT_DISPOSITION, blob.contentDisposition());
    assertEquals(CONTENT_ENCODING, blob.contentEncoding());
    assertEquals(CONTENT_LANGUAGE, blob.contentLanguage());
    assertEquals(CRC32, blob.crc32c());
    assertEquals(CREATE_TIME, blob.createTime());
    assertEquals(CUSTOMER_ENCRYPTION, blob.customerEncryption());
    assertEquals(DELETE_TIME, blob.deleteTime());
    assertEquals(ETAG, blob.etag());
    assertEquals(GENERATED_ID, blob.generatedId());
    assertEquals(MD5, blob.md5());
    assertEquals(MEDIA_LINK, blob.mediaLink());
    assertEquals(METADATA, blob.metadata());
    assertEquals(META_GENERATION, blob.metageneration());
    assertEquals(OWNER, blob.owner());
    assertEquals(SELF_LINK, blob.selfLink());
    assertEquals(SIZE, blob.size());
    assertEquals(UPDATE_TIME, blob.updateTime());
    assertEquals(storage.options(), blob.storage().options());
    assertFalse(blob.isDirectory());
    builder = new Blob.Builder(new Blob(storage, new BlobInfo.BuilderImpl(DIRECTORY_INFO)));
    blob = builder.blobId(BlobId.of("b", "n/"))
        .setIsDirectory(true)
        .setSize(0L)
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
    assertNull(blob.createTime());
    assertNull(blob.customerEncryption());
    assertNull(blob.deleteTime());
    assertNull(blob.etag());
    assertNull(blob.generatedId());
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
