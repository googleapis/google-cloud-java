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

package com.google.cloud.storage.contrib.nio;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.cloud.storage.Acl;
import com.google.cloud.storage.BlobInfo;
import com.google.common.base.MoreObjects;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableMap;

import java.nio.file.attribute.FileTime;
import java.util.List;
import java.util.Objects;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;

/**
 * Metadata for a Google Cloud Storage file.
 */
@Immutable
final class CloudStorageObjectAttributes implements CloudStorageFileAttributes {

  @Nonnull private final BlobInfo info;

  CloudStorageObjectAttributes(BlobInfo info) {
    this.info = checkNotNull(info);
  }

  @Override
  public long size() {
    return info.size();
  }

  @Override
  public FileTime creationTime() {
    if (info.updateTime() == null) {
      return CloudStorageFileSystem.FILE_TIME_UNKNOWN;
    }
    return FileTime.fromMillis(info.updateTime());
  }

  @Override
  public FileTime lastModifiedTime() {
    return creationTime();
  }

  @Override
  public Optional<String> etag() {
    return Optional.fromNullable(info.etag());
  }

  @Override
  public Optional<String> mimeType() {
    return Optional.fromNullable(info.contentType());
  }

  @Override
  public Optional<List<Acl>> acl() {
    return Optional.fromNullable(info.acl());
  }

  @Override
  public Optional<String> cacheControl() {
    return Optional.fromNullable(info.cacheControl());
  }

  @Override
  public Optional<String> contentEncoding() {
    return Optional.fromNullable(info.contentEncoding());
  }

  @Override
  public Optional<String> contentDisposition() {
    return Optional.fromNullable(info.contentDisposition());
  }

  @Override
  public ImmutableMap<String, String> userMetadata() {
    if (null == info.metadata()) {
      return ImmutableMap.of();
    }
    return ImmutableMap.copyOf(info.metadata());
  }

  @Override
  public boolean isDirectory() {
    return false;
  }

  @Override
  public boolean isOther() {
    return false;
  }

  @Override
  public boolean isRegularFile() {
    return true;
  }

  @Override
  public boolean isSymbolicLink() {
    return false;
  }

  @Override
  public FileTime lastAccessTime() {
    return CloudStorageFileSystem.FILE_TIME_UNKNOWN;
  }

  @Override
  public Object fileKey() {
    return info.blobId().bucket() + info.blobId().name() + info.blobId().generation();
  }

  @Override
  public boolean equals(Object other) {
    return this == other
        || other instanceof CloudStorageObjectAttributes
            && Objects.equals(info, ((CloudStorageObjectAttributes) other).info);
  }

  @Override
  public int hashCode() {
    return info.hashCode();
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("info", info).toString();
  }
}
