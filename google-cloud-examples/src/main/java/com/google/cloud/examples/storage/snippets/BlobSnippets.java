/*
 * Copyright 2016 Google LLC
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

/*
 * EDITING INSTRUCTIONS
 * This file is referenced in Blob's javadoc. Any change to this file should be reflected in Blob's
 * javadoc.
 */

package com.google.cloud.examples.storage.snippets;

import static java.nio.charset.StandardCharsets.UTF_8;

import com.google.auth.ServiceAccountSigner;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.ReadChannel;
import com.google.cloud.WriteChannel;
import com.google.cloud.storage.Acl;
import com.google.cloud.storage.Acl.User;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Blob.BlobSourceOption;
import com.google.cloud.storage.Storage.SignUrlOption;
import com.google.cloud.storage.StorageException;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.TimeUnit;

/** This class contains a number of snippets for the {@link Blob} class. */
public class BlobSnippets {

  private final Blob blob;

  public BlobSnippets(Blob blob) {
    this.blob = blob;
  }

  /** Example of checking if the blob exists. */
  // [TARGET exists(BlobSourceOption...)]
  public boolean exists() {
    // [START exists]
    boolean exists = blob.exists();
    if (exists) {
      // the blob exists
    } else {
      // the blob was not found
    }
    // [END exists]
    return exists;
  }

  /**
   * Example of reading all bytes of the blob, if its generation matches the {@link
   * Blob#getGeneration()} value, otherwise a {@link StorageException} is thrown.
   */
  // [TARGET getContent(BlobSourceOption...)]
  public byte[] getContent() {
    // [START getContent]
    byte[] content = blob.getContent(BlobSourceOption.generationMatch());
    // [END getContent]
    return content;
  }

  /**
   * Example of getting the blob's latest information, if its generation does not match the {@link
   * Blob#getGeneration()} value, otherwise a {@link StorageException} is thrown.
   */
  // [TARGET reload(BlobSourceOption...)]
  public Blob reload() {
    // [START reload]
    Blob latestBlob = blob.reload(BlobSourceOption.generationNotMatch());
    if (latestBlob == null) {
      // the blob was not found
    }
    // [END reload]
    return latestBlob;
  }

  /** Example of reading the blob's content through a reader. */
  // [TARGET reader(BlobSourceOption...)]
  public void reader() throws IOException {
    // [START reader]
    try (ReadChannel reader = blob.reader()) {
      ByteBuffer bytes = ByteBuffer.allocate(64 * 1024);
      while (reader.read(bytes) > 0) {
        bytes.flip();
        // do something with bytes
        bytes.clear();
      }
    }
    // [END reader]
  }

  /** Example of reading just a portion of the blob's content. */
  // [TARGET reader(BlobSourceOption...)]
  // [VARIABLE 1]
  // [VARIABLE 8]
  public byte[] readContentRange(int start, int end) throws IOException {
    // [START readContentRange]
    try (ReadChannel reader = blob.reader()) {
      reader.seek(start);
      ByteBuffer bytes = ByteBuffer.allocate(end - start);
      reader.read(bytes);
      return bytes.array();
    }
    // [END readContentRange]
  }

  /** Example of writing the blob's content through a writer. */
  // [TARGET writer(BlobWriteOption...)]
  public void writer() throws IOException {
    // [START writer]
    byte[] content = "Hello, World!".getBytes(UTF_8);
    try (WriteChannel writer = blob.writer()) {
      try {
        writer.write(ByteBuffer.wrap(content, 0, content.length));
      } catch (Exception ex) {
        // handle exception
      }
    }
    // [END writer]
  }

  /**
   * Example of creating a signed URL for the blob that is valid for 2 weeks, using the default
   * credentials for signing the URL.
   */
  // [TARGET signUrl(long, TimeUnit, SignUrlOption...)]
  public URL signUrl() {
    // [START signUrl]
    URL signedUrl = blob.signUrl(14, TimeUnit.DAYS);
    // [END signUrl]
    return signedUrl;
  }

  /**
   * Example of creating a signed URL for the blob passing the {@link
   * SignUrlOption#signWith(ServiceAccountSigner)} option, that will be used to sign the URL.
   */
  // [TARGET signUrl(long, TimeUnit, SignUrlOption...)]
  // [VARIABLE "/path/to/key.json"]
  public URL signUrlWithSigner(String keyPath) throws IOException {
    // [START signUrlWithSigner]
    URL signedUrl =
        blob.signUrl(
            14,
            TimeUnit.DAYS,
            SignUrlOption.signWith(
                ServiceAccountCredentials.fromStream(new FileInputStream(keyPath))));
    // [END signUrlWithSigner]
    return signedUrl;
  }

  /** Example of getting the ACL entry for an entity. */
  // [TARGET getAcl(Entity)]
  public Acl getAcl() {
    // [START getAcl]
    Acl acl = blob.getAcl(User.ofAllAuthenticatedUsers());
    // [END getAcl]
    return acl;
  }

  /** Example of deleting the ACL entry for an entity. */
  // [TARGET deleteAcl(Entity)]
  public boolean deleteAcl() {
    // [START deleteAcl]
    boolean deleted = blob.deleteAcl(User.ofAllAuthenticatedUsers());
    if (deleted) {
      // the acl entry was deleted
    } else {
      // the acl entry was not found
    }
    // [END deleteAcl]
    return deleted;
  }

  /** Example of creating a new ACL entry. */
  // [TARGET createAcl(Acl)]
  public Acl createAcl() {
    // [START createAcl]
    Acl acl = blob.createAcl(Acl.of(User.ofAllAuthenticatedUsers(), Acl.Role.READER));
    // [END createAcl]
    return acl;
  }

  /** Example of updating a new ACL entry. */
  // [TARGET updateAcl(Acl)]
  public Acl updateAcl() {
    // [START updateAcl]
    Acl acl = blob.updateAcl(Acl.of(User.ofAllAuthenticatedUsers(), Acl.Role.OWNER));
    // [END updateAcl]
    return acl;
  }

  /** Example of listing the ACL entries. */
  // [TARGET listAcls()]
  public List<Acl> listAcls() {
    // [START listAcls]
    List<Acl> acls = blob.listAcls();
    for (Acl acl : acls) {
      // do something with ACL entry
    }
    // [END listAcls]
    return acls;
  }
}
