/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

package com.google.cloud.examples.storage.snippets;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.cloud.storage.Acl;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageException;
import com.google.cloud.storage.testing.RemoteStorageHelper;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ITBlobSnippets {

  private static final Logger log = Logger.getLogger(ITBlobSnippets.class.getName());
  private static final String BUCKET = RemoteStorageHelper.generateBucketName();
  private static final String BLOB = "blob";
  private static final byte[] EMPTY_CONTENT = new byte[0];
  private static final byte[] CONTENT = "Hello, World!".getBytes(UTF_8);

  private static Storage storage;
  private static Blob blob;

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @BeforeClass
  public static void beforeClass() {
    RemoteStorageHelper helper = RemoteStorageHelper.create();
    storage = helper.getOptions().getService();
    storage.create(BucketInfo.of(BUCKET));
    blob = storage.create(BlobInfo.newBuilder(BUCKET, BLOB).build());
  }

  @AfterClass
  public static void afterClass() throws ExecutionException, InterruptedException {
    if (storage != null) {
      boolean wasDeleted = RemoteStorageHelper.forceDelete(storage, BUCKET, 5, TimeUnit.SECONDS);
      if (!wasDeleted && log.isLoggable(Level.WARNING)) {
        log.log(Level.WARNING, "Deletion of bucket {0} timed out, bucket is not empty", BUCKET);
      }
    }
  }

  @Test
  public void testBlob() throws IOException {
    BlobSnippets blobSnippets = new BlobSnippets(blob);
    assertTrue(blobSnippets.exists());
    assertArrayEquals(EMPTY_CONTENT, blobSnippets.getContent());
    try {
      assertNotNull(blobSnippets.reload());
      fail("Expected StorageException to be thrown");
    } catch (StorageException ex) {
      // expected
    }
    Blob updatedBlob = blobSnippets.update();
    assertEquals(ImmutableMap.of("key", "value"), updatedBlob.getMetadata());
    Blob copiedBlob = blobSnippets.copyToStrings(BUCKET, "copyBlob");
    assertNotNull(copiedBlob);
    copiedBlob.delete();
    copiedBlob = blobSnippets.copyToId(BUCKET, "copyBlob");
    assertNotNull(copiedBlob);
    copiedBlob.delete();
    copiedBlob = blobSnippets.copyToBucket(BUCKET);
    assertNotNull(copiedBlob);
    copiedBlob.delete();
    blobSnippets.reload();
    blobSnippets.writer();
    URL signedUrl = blobSnippets.signUrl();
    URLConnection connection = signedUrl.openConnection();
    byte[] readBytes = new byte[CONTENT.length];
    try (InputStream responseStream = connection.getInputStream()) {
      assertEquals(CONTENT.length, responseStream.read(readBytes));
      assertArrayEquals(CONTENT, readBytes);
    }
    signedUrl = blobSnippets.signUrlWithSigner(System.getenv("GOOGLE_APPLICATION_CREDENTIALS"));
    connection = signedUrl.openConnection();
    try (InputStream responseStream = connection.getInputStream()) {
      assertEquals(CONTENT.length, responseStream.read(readBytes));
      assertArrayEquals(CONTENT, readBytes);
    }
    assertFalse(blobSnippets.delete());
    blobSnippets = new BlobSnippets(storage.get(blob.getBucket(), blob.getName()));

    byte[] subcontent = blobSnippets.readContentRange(1, 8);
    assertArrayEquals("ello, W".getBytes(UTF_8), subcontent);

    assertNull(blobSnippets.getAcl());
    assertNotNull(blobSnippets.createAcl());
    Acl updatedAcl = blobSnippets.updateAcl();
    assertEquals(Acl.Role.OWNER, updatedAcl.getRole());
    Set<Acl> acls = Sets.newHashSet(blobSnippets.listAcls());
    assertTrue(acls.contains(updatedAcl));
    assertTrue(blobSnippets.deleteAcl());
    assertNull(blobSnippets.getAcl());
    storage.delete(BlobId.of(BUCKET, BLOB));
  }
}
