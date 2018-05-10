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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.common.base.MoreObjects;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.FileTime;
import java.util.Objects;

import javax.annotation.concurrent.Immutable;

/**
 * Metadata view for a Google Cloud Storage object.
 */
@Immutable
public final class CloudStorageFileAttributeView implements BasicFileAttributeView {

  private final Storage storage;
  private final CloudStoragePath path;

  CloudStorageFileAttributeView(Storage storage, CloudStoragePath path) {
    this.storage = checkNotNull(storage);
    this.path = checkNotNull(path);
  }

  /**
   * Returns {@value CloudStorageFileSystem#GCS_VIEW}.
   */
  @Override
  public String name() {
    return CloudStorageFileSystem.GCS_VIEW;
  }

  @Override
  public CloudStorageFileAttributes readAttributes() throws IOException {
    if (path.seemsLikeADirectory() && path.getFileSystem().config().usePseudoDirectories()) {
      return new CloudStoragePseudoDirectoryAttributes(path);
    }
    BlobInfo blobInfo = storage.get(path.getBlobId());
    if (blobInfo == null) {
      throw new NoSuchFileException(path.toUri().toString());
    }

    return new CloudStorageObjectAttributes(blobInfo);
  }

  /**
   * This feature is not supported, since Cloud Storage objects are immutable.
   */
  @Override
  public void setTimes(FileTime lastModifiedTime, FileTime lastAccessTime, FileTime createTime) {
    throw new CloudStorageObjectImmutableException();
  }

  @Override
  public boolean equals(Object other) {
    return this == other
        || other instanceof CloudStorageFileAttributeView
            && Objects.equals(storage, ((CloudStorageFileAttributeView) other).storage)
            && Objects.equals(path, ((CloudStorageFileAttributeView) other).path);
  }

  @Override
  public int hashCode() {
    return Objects.hash(storage, path);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("storage", storage).add("path", path).toString();
  }
}
