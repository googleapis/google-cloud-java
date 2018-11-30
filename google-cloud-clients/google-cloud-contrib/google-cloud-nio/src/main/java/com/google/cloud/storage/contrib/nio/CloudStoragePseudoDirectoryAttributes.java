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

/** Metadata for a Cloud Storage pseudo-directory. */
final class CloudStoragePseudoDirectoryAttributes implements CloudStorageFileAttributes {

  private final String id;

  CloudStoragePseudoDirectoryAttributes(CloudStoragePath path) {
    this.id = path.toUri().toString();
  }

  @Override
  public boolean isDirectory() {
    return true;
  }

  @Override
  public boolean isOther() {
    return false;
  }

  @Override
  public boolean isRegularFile() {
    return false;
  }

  @Override
  public boolean isSymbolicLink() {
    return false;
  }

  @Override
  public Object fileKey() {
    return id;
  }

  @Override
  public long size() {
    return 1; // Allow I/O to happen before we fail.
  }

  @Override
  public FileTime lastModifiedTime() {
    return CloudStorageFileSystem.FILE_TIME_UNKNOWN;
  }

  @Override
  public FileTime creationTime() {
    return CloudStorageFileSystem.FILE_TIME_UNKNOWN;
  }

  @Override
  public FileTime lastAccessTime() {
    return CloudStorageFileSystem.FILE_TIME_UNKNOWN;
  }

  @Override
  public Optional<String> etag() {
    return Optional.absent();
  }

  @Override
  public Optional<String> mimeType() {
    return Optional.absent();
  }

  @Override
  public Optional<List<Acl>> acl() {
    return Optional.absent();
  }

  @Override
  public Optional<String> cacheControl() {
    return Optional.absent();
  }

  @Override
  public Optional<String> contentEncoding() {
    return Optional.absent();
  }

  @Override
  public Optional<String> contentDisposition() {
    return Optional.absent();
  }

  @Override
  public ImmutableMap<String, String> userMetadata() {
    return ImmutableMap.of();
  }
}
