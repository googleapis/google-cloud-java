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

package com.google.cloud.storage.contrib.nio;

import com.google.cloud.storage.Acl;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableMap;

import java.nio.file.attribute.FileTime;
import java.util.List;

/** Metadata for a Cloud Storage pseudo-directory that is also a file. */
final class CloudStorageFileAndDirectoryAttributes implements CloudStorageFileAttributes {

  private final String id;
  // attributes of the underlying file
  private final CloudStorageObjectAttributes attrib;

  CloudStorageFileAndDirectoryAttributes(CloudStorageObjectAttributes attrib, CloudStoragePath path) {
    this.id = path.toUri().toString();
    this.attrib = attrib;
  }

  @Override
  public boolean isDirectory() {
    return true;
  }

  @Override
  public boolean isOther() {
    return attrib.isOther();
  }

  @Override
  public boolean isRegularFile() {
    return attrib.isRegularFile();
  }

  @Override
  public boolean isSymbolicLink() {
    return attrib.isSymbolicLink();
  }

  @Override
  public Object fileKey() {
    return id;
  }

  @Override
  public long size() {
    return attrib.size();
  }

  @Override
  public FileTime lastModifiedTime() {
    return attrib.lastModifiedTime();
  }

  @Override
  public FileTime creationTime() {
    return attrib.creationTime();
  }

  @Override
  public FileTime lastAccessTime() {
    return attrib.lastAccessTime();
  }

  @Override
  public Optional<String> etag() {
    return attrib.etag();
  }

  @Override
  public Optional<String> mimeType() {
    return attrib.mimeType();
  }

  @Override
  public Optional<List<Acl>> acl() {
    return attrib.acl();
  }

  @Override
  public Optional<String> cacheControl() {
    return attrib.cacheControl();
  }

  @Override
  public Optional<String> contentEncoding() {
    return attrib.contentEncoding();
  }

  @Override
  public Optional<String> contentDisposition() {
    return attrib.contentDisposition();
  }

  @Override
  public ImmutableMap<String, String> userMetadata() {
    return attrib.userMetadata();
  }
}
