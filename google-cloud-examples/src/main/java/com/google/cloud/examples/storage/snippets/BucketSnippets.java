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
 * This file is referenced in Bucket's javadoc. Any change to this file should be reflected in
 * Bucket's javadoc.
 */

package com.google.cloud.examples.storage.snippets;

import static java.nio.charset.StandardCharsets.UTF_8;

import com.google.cloud.storage.Acl;
import com.google.cloud.storage.Acl.User;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Bucket.BucketSourceOption;
import com.google.cloud.storage.Storage.BlobGetOption;
import com.google.cloud.storage.StorageException;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

/** This class contains a number of snippets for the {@link Bucket} class. */
public class BucketSnippets {

  private final Bucket bucket;

  public BucketSnippets(Bucket bucket) {
    this.bucket = bucket;
  }

  /** Example of checking if the bucket exists. */
  // [TARGET exists(BucketSourceOption...)]
  public boolean exists() {
    // [START exists]
    boolean exists = bucket.exists();
    if (exists) {
      // the bucket exists
    } else {
      // the bucket was not found
    }
    // [END exists]
    return exists;
  }

  /**
   * Example of getting the bucket's latest information, if its generation does not match the {@link
   * Bucket#getMetageneration()} value, otherwise a {@link StorageException} is thrown.
   */
  // [TARGET reload(BucketSourceOption...)]
  public Bucket reload() {
    // [START reload]
    Bucket latestBucket = bucket.reload(BucketSourceOption.metagenerationMatch());
    if (latestBucket == null) {
      // the bucket was not found
    }
    // [END reload]
    return latestBucket;
  }

  /** Example of updating the bucket's information. */
  // [TARGET update(BucketTargetOption...)]
  public Bucket update() {
    // [START update]
    Bucket updatedBucket = bucket.toBuilder().setVersioningEnabled(true).build().update();
    // [END update]
    return updatedBucket;
  }

  /**
   * Example of getting a blob in the bucket, only if its metageneration matches a value, otherwise
   * a {@link StorageException} is thrown.
   */
  // [TARGET get(String, BlobGetOption...)]
  // [VARIABLE "my_blob_name"]
  // [VARIABLE 42]
  public Blob getBlob(String blobName, long generation) {
    // [START getBlob]
    Blob blob = bucket.get(blobName, BlobGetOption.generationMatch(generation));
    // [END getBlob]
    return blob;
  }

  /** Example of getting some blobs in the bucket, using a batch request. */
  // [TARGET get(String, String, String...)]
  // [VARIABLE "my_blob_name1"]
  // [VARIABLE "my_blob_name2"]
  public List<Blob> getBlobFromStrings(String blobName1, String blobName2) {
    // [START getBlobFromStrings]
    List<Blob> blobs = bucket.get(blobName1, blobName2);
    for (Blob blob : blobs) {
      if (blob == null) {
        // the blob was not found
      }
    }
    // [END getBlobFromStrings]
    return blobs;
  }

  /** Example of getting some blobs in the bucket, using a batch request. */
  // [TARGET get(Iterable)]
  // [VARIABLE "my_blob_name1"]
  // [VARIABLE "my_blob_name2"]
  public List<Blob> getBlobFromStringIterable(String blobName1, String blobName2) {
    // [START getBlobFromStringIterable]
    List<String> blobNames = new LinkedList<>();
    blobNames.add(blobName1);
    blobNames.add(blobName2);
    List<Blob> blobs = bucket.get(blobNames);
    for (Blob blob : blobs) {
      if (blob == null) {
        // the blob was not found
      }
    }
    // [END getBlobFromStringIterable]
    return blobs;
  }

  /** Example of creating a blob in the bucket from a byte array. */
  // [TARGET create(String, byte[], BlobTargetOption...)]
  // [VARIABLE "my_blob_name"]
  public Blob createBlobFromByteArray(String blobName) {
    // [START createBlobFromByteArray]
    Blob blob = bucket.create(blobName, "Hello, World!".getBytes(UTF_8));
    // [END createBlobFromByteArray]
    return blob;
  }

  /** Example of creating a blob in the bucket from an input stream. */
  // [TARGET create(String, InputStream, BlobWriteOption...)]
  // [VARIABLE "my_blob_name"]
  public Blob createBlobFromInputStream(String blobName) {
    // [START createBlobFromInputStream]
    InputStream content = new ByteArrayInputStream("Hello, World!".getBytes(UTF_8));
    Blob blob = bucket.create(blobName, content);
    // [END createBlobFromInputStream]
    return blob;
  }

  /** Example of creating a blob in the bucket from a byte array with a content type. */
  // [TARGET create(String, byte[], String, BlobTargetOption...)]
  // [VARIABLE "my_blob_name"]
  public Blob createBlobFromByteArrayWithContentType(String blobName) {
    // [START createBlobFromByteArrayWithContentType]
    Blob blob = bucket.create(blobName, "Hello, World!".getBytes(UTF_8), "text/plain");
    // [END createBlobFromByteArrayWithContentType]
    return blob;
  }

  /** Example of creating a blob in the bucket from an input stream with a content type. */
  // [TARGET create(String, InputStream, String, BlobWriteOption...)]
  // [VARIABLE "my_blob_name"]
  public Blob createBlobFromInputStreamWithContentType(String blobName) {
    // [START createBlobFromInputStreamWithContentType]
    InputStream content = new ByteArrayInputStream("Hello, World!".getBytes(UTF_8));
    Blob blob = bucket.create(blobName, content, "text/plain");
    // [END createBlobFromInputStreamWithContentType]
    return blob;
  }

  /** Example of getting the ACL entry for an entity. */
  // [TARGET getAcl(Entity)]
  public Acl getAcl() {
    // [START getAcl]
    Acl acl = bucket.getAcl(User.ofAllAuthenticatedUsers());
    // [END getAcl]
    return acl;
  }

  /** Example of deleting the ACL entry for an entity. */
  // [TARGET deleteAcl(Entity)]
  public boolean deleteAcl() {
    // [START deleteAcl]
    boolean deleted = bucket.deleteAcl(User.ofAllAuthenticatedUsers());
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
    Acl acl = bucket.createAcl(Acl.of(User.ofAllAuthenticatedUsers(), Acl.Role.READER));
    // [END createAcl]
    return acl;
  }

  /** Example of updating a new ACL entry. */
  // [TARGET updateAcl(Acl)]
  public Acl updateAcl() {
    // [START updateAcl]
    Acl acl = bucket.updateAcl(Acl.of(User.ofAllAuthenticatedUsers(), Acl.Role.OWNER));
    // [END updateAcl]
    return acl;
  }

  /** Example of listing the ACL entries. */
  // [TARGET listAcls()]
  public List<Acl> listAcls() {
    // [START listAcls]
    List<Acl> acls = bucket.listAcls();
    for (Acl acl : acls) {
      // do something with ACL entry
    }
    // [END listAcls]
    return acls;
  }

  /** Example of getting the default ACL entry for an entity. */
  // [TARGET getDefaultAcl(Entity)]
  public Acl getDefaultAcl() {
    // [START getDefaultAcl]
    Acl acl = bucket.getDefaultAcl(User.ofAllAuthenticatedUsers());
    // [END getDefaultAcl]
    return acl;
  }

  /** Example of deleting the default ACL entry for an entity. */
  // [TARGET deleteDefaultAcl(Entity)]
  public boolean deleteDefaultAcl() {
    // [START deleteDefaultAcl]
    boolean deleted = bucket.deleteDefaultAcl(User.ofAllAuthenticatedUsers());
    if (deleted) {
      // the acl entry was deleted
    } else {
      // the acl entry was not found
    }
    // [END deleteDefaultAcl]
    return deleted;
  }

  /** Example of creating a new default ACL entry. */
  // [TARGET createDefaultAcl(Acl)]
  public Acl createDefaultAcl() {
    // [START createDefaultAcl]
    Acl acl = bucket.createDefaultAcl(Acl.of(User.ofAllAuthenticatedUsers(), Acl.Role.READER));
    // [END createDefaultAcl]
    return acl;
  }

  /** Example of updating a new default ACL entry. */
  // [TARGET updateDefaultAcl(Acl)]
  public Acl updateDefaultAcl() {
    // [START updateDefaultAcl]
    Acl acl = bucket.updateDefaultAcl(Acl.of(User.ofAllAuthenticatedUsers(), Acl.Role.OWNER));
    // [END updateDefaultAcl]
    return acl;
  }

  /** Example of listing the default ACL entries. */
  // [TARGET listDefaultAcls()]
  public List<Acl> listDefaultAcls() {
    // [START listDefaultAcls]
    List<Acl> acls = bucket.listDefaultAcls();
    for (Acl acl : acls) {
      // do something with ACL entry
    }
    // [END listDefaultAcls]
    return acls;
  }
}
