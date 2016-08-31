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

/*
 * EDITING INSTRUCTIONS
 * This file is referenced in Blob's javadoc. Any change to this file should be reflected in Blob's
 * javadoc.
 */

package com.google.cloud.examples.storage.snippets;

import static java.nio.charset.StandardCharsets.UTF_8;

import com.google.cloud.AuthCredentials;
import com.google.cloud.ReadChannel;
import com.google.cloud.ServiceAccountSigner;
import com.google.cloud.WriteChannel;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Blob.BlobSourceOption;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.CopyWriter;
import com.google.cloud.storage.Storage.SignUrlOption;
import com.google.cloud.storage.StorageException;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * This class contains a number of snippets for the {@link Blob} class.
 */
public class BlobSnippets {

  private final Blob blob;

  public BlobSnippets(Blob blob) {
    this.blob = blob;
  }

  /**
   * Example of checking if the blob exists.
   */
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
   * Example of reading all bytes of the blob, if its generation matches the
   * {@link Blob#generation()} value, otherwise a {@link StorageException} is thrown.
   */
  // [TARGET content(BlobSourceOption...)]
  public byte[] content() {
    // [START content]
    byte[] content = blob.content(BlobSourceOption.generationMatch());
    // [END content]
    return content;
  }

  /**
   * Example of getting the blob's latest information, if its generation does not match the
   * {@link Blob#generation()} value, otherwise a {@link StorageException} is thrown.
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

  /**
   * Example of replacing blob's metadata.
   */
  // [TARGET update(BlobTargetOption...)]
  public Blob update() {
    // [START update]
    Map<String, String> newMetadata = new HashMap<>();
    newMetadata.put("key", "value");
    blob.toBuilder().metadata(null).build().update();
    Blob updatedBlob = blob.toBuilder().metadata(newMetadata).build().update();
    // [END update]
    return updatedBlob;
  }

  /**
   * Example of deleting the blob, if its generation matches the {@link Blob#generation()} value,
   * otherwise a {@link StorageException} is thrown.
   */
  // [TARGET delete(BlobSourceOption...)]
  public boolean delete() {
    // [START delete]
    boolean deleted = blob.delete(BlobSourceOption.generationMatch());
    if (deleted) {
      // the blob was deleted
    } else {
      // the blob was not found
    }
    // [END delete]
    return deleted;
  }

  /**
   * Example of copying the blob to a different bucket with a different name.
   */
  // [TARGET copyTo(BlobId, BlobSourceOption...)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "copy_blob_name"]
  public Blob copyToId(String bucketName, String blobName) {
    // [START copyToId]
    CopyWriter copyWriter = blob.copyTo(BlobId.of(bucketName, blobName));
    Blob copiedBlob = copyWriter.result();
    // [END copyToId]
    return copiedBlob;
  }

  /**
   * Example of copying the blob to a different bucket, keeping the original name.
   */
  // [TARGET copyTo(String, BlobSourceOption...)]
  // [VARIABLE "my_unique_bucket"]
  public Blob copyToBucket(String bucketName) {
    // [START copyToBucket]
    CopyWriter copyWriter = blob.copyTo(bucketName);
    Blob copiedBlob = copyWriter.result();
    // [END copyToBucket]
    return copiedBlob;
  }

  /**
   * Example of copying the blob to a different bucket with a different name.
   */
  // [TARGET copyTo(String, String, BlobSourceOption...)]
  // [VARIABLE "my_unique_bucket"]
  // [VARIABLE "copy_blob_name"]
  public Blob copyToStrings(String bucketName, String blobName) {
    // [START copyToStrings]
    CopyWriter copyWriter = blob.copyTo(bucketName, blobName);
    Blob copiedBlob = copyWriter.result();
    // [END copyToStrings]
    return copiedBlob;
  }

  /**
   * Example of reading the blob's content through a reader.
   */
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

  /**
   * Example of writing the blob's content through a writer.
   */
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
   * Example of creating a signed URL for the blob passing the
   * {@link SignUrlOption#signWith(ServiceAccountSigner)} option, that will be used to sign the URL.
   */
  // [TARGET signUrl(long, TimeUnit, SignUrlOption...)]
  // [VARIABLE "/path/to/key.json"]
  public URL signUrlWithSigner(String keyPath) throws IOException {
    // [START signUrlWithSigner]
    URL signedUrl = blob.signUrl(14, TimeUnit.DAYS, SignUrlOption.signWith(
        AuthCredentials.createForJson(new FileInputStream(keyPath))));
    // [END signUrlWithSigner]
    return signedUrl;
  }
}
