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

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.cloud.storage.BlobId;
import com.google.common.collect.UnmodifiableIterator;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchEvent.Modifier;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;
import java.util.regex.Pattern;

import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/**
 * Google Cloud Storage {@link Path}.
 *
 * @see UnixPath
 */
@Immutable
public final class CloudStoragePath implements Path {

  private static final Pattern EXTRA_SLASHES_OR_DOT_DIRS_PATTERN =
      Pattern.compile("^\\.\\.?/|//|/\\.\\.?/|/\\.\\.?$");

  private final CloudStorageFileSystem fileSystem;
  private final UnixPath path;

  private CloudStoragePath(CloudStorageFileSystem fileSystem, UnixPath path) {
    this.fileSystem = fileSystem;
    this.path = path;
  }

  static CloudStoragePath getPath(CloudStorageFileSystem fileSystem, String path, String... more) {
    return new CloudStoragePath(
        fileSystem, UnixPath.getPath(fileSystem.config().permitEmptyPathComponents(), path, more));
  }

  /**
   * Returns the Cloud Storage bucket name being served by this file system.
   */
  public String bucket() {
    return fileSystem.bucket();
  }

  /**
   * Returns path converted to a {@link BlobId} so I/O can be performed.
   */
  BlobId getBlobId() {
    checkArgument(!path.toString().isEmpty(), 
      "Object names cannot be empty.");
    return BlobId.of(bucket(), toRealPath().path.toString());
  }

  boolean seemsLikeADirectory() {
    return path.seemsLikeADirectory();
  }

  boolean seemsLikeADirectoryAndUsePseudoDirectories() {
    return path.seemsLikeADirectory() && fileSystem.config().usePseudoDirectories();
  }

  @Override
  public CloudStorageFileSystem getFileSystem() {
    return fileSystem;
  }

  @Nullable
  @Override
  public CloudStoragePath getRoot() {
    return newPath(path.getRoot());
  }

  @Override
  public boolean isAbsolute() {
    return path.isAbsolute();
  }

  /**
   * Changes relative path to be absolute, using
   * {@link CloudStorageConfiguration#workingDirectory() workingDirectory} as current dir.
   */
  @Override
  public CloudStoragePath toAbsolutePath() {
    return newPath(path.toAbsolutePath(getWorkingDirectory()));
  }

  /**
   * Returns this path rewritten to the Cloud Storage object name that'd be used to perform i/o.
   *
   * <p>This method makes path {@link #toAbsolutePath() absolute} and removes the prefix slash from
   * the absolute path when {@link CloudStorageConfiguration#stripPrefixSlash() stripPrefixSlash}
   * is {@code true}.
   *
   * @throws IllegalArgumentException if path contains extra slashes or dot-dirs when
   *     {@link CloudStorageConfiguration#permitEmptyPathComponents() permitEmptyPathComponents}
   *     is {@code false}, or if the resulting path is empty.
   */
  @Override
  public CloudStoragePath toRealPath(LinkOption... options) {
    CloudStorageUtil.checkNotNullArray(options);
    return newPath(toRealPathInternal(true));
  }

  private UnixPath toRealPathInternal(boolean errorCheck) {
    UnixPath objectName = path.toAbsolutePath(getWorkingDirectory());
    if (errorCheck && !fileSystem.config().permitEmptyPathComponents()) {
      checkArgument(
          !EXTRA_SLASHES_OR_DOT_DIRS_PATTERN.matcher(objectName).find(),
          "I/O not allowed on dot-dirs or extra slashes when !permitEmptyPathComponents: %s",
          objectName);
    }
    if (fileSystem.config().stripPrefixSlash()) {
      objectName = objectName.removeBeginningSeparator();
    }
    return objectName;
  }

  /**
   * Returns path without extra slashes or {@code .} and {@code ..} and preserves trailing slash.
   */
  @Override
  public CloudStoragePath normalize() {
    return newPath(path.normalize());
  }

  @Override
  public CloudStoragePath resolve(Path object) {
    return newPath(path.resolve(CloudStorageUtil.checkPath(object).path));
  }

  @Override
  public CloudStoragePath resolve(String other) {
    return newPath(path.resolve(getUnixPath(other)));
  }

  @Override
  public CloudStoragePath resolveSibling(Path other) {
    return newPath(path.resolveSibling(CloudStorageUtil.checkPath(other).path));
  }

  @Override
  public CloudStoragePath resolveSibling(String other) {
    return newPath(path.resolveSibling(getUnixPath(other)));
  }

  @Override
  public CloudStoragePath relativize(Path object) {
    return newPath(path.relativize(CloudStorageUtil.checkPath(object).path));
  }

  @Nullable
  @Override
  public CloudStoragePath getParent() {
    return newPath(path.getParent());
  }

  @Nullable
  @Override
  public CloudStoragePath getFileName() {
    return newPath(path.getFileName());
  }

  @Override
  public CloudStoragePath subpath(int beginIndex, int endIndex) {
    return newPath(path.subpath(beginIndex, endIndex));
  }

  @Override
  public int getNameCount() {
    return path.getNameCount();
  }

  @Override
  public CloudStoragePath getName(int index) {
    return newPath(path.getName(index));
  }

  @Override
  public boolean startsWith(Path other) {
    if (!(checkNotNull(other) instanceof CloudStoragePath)) {
      return false;
    }
    CloudStoragePath that = (CloudStoragePath) other;
    if (!bucket().equals(that.bucket())) {
      return false;
    }
    return path.startsWith(that.path);
  }

  @Override
  public boolean startsWith(String other) {
    return path.startsWith(getUnixPath(other));
  }

  @Override
  public boolean endsWith(Path other) {
    if (!(checkNotNull(other) instanceof CloudStoragePath)) {
      return false;
    }
    CloudStoragePath that = (CloudStoragePath) other;
    if (!bucket().equals(that.bucket())) {
      return false;
    }
    return path.endsWith(that.path);
  }

  @Override
  public boolean endsWith(String other) {
    return path.endsWith(getUnixPath(other));
  }

  /**
   * Throws {@link UnsupportedOperationException} because this feature hasn't been implemented yet.
   */
  @Override
  public WatchKey register(WatchService watcher, Kind<?>[] events, Modifier... modifiers) {
    // TODO: Implement me.
    throw new UnsupportedOperationException();
  }

  /**
   * Throws {@link UnsupportedOperationException} because this feature hasn't been implemented yet.
   */
  @Override
  public WatchKey register(WatchService watcher, Kind<?>... events) {
    // TODO: Implement me.
    throw new UnsupportedOperationException();
  }

  /**
   * Throws {@link UnsupportedOperationException} because Google Cloud Storage files are not backed
   * by the local file system.
   */
  @Override
  public File toFile() {
    throw new UnsupportedOperationException("GCS objects aren't available locally");
  }

  @Override
  public Iterator<Path> iterator() {
    if (path.isEmpty()) {
      return Collections.<Path>singleton(this).iterator();
    } else if (path.isRoot()) {
      return Collections.emptyIterator();
    } else {
      return new PathIterator();
    }
  }

  @Override
  public int compareTo(Path other) {
    // Documented to throw CCE if other is associated with a different FileSystemProvider.
    CloudStoragePath that = (CloudStoragePath) other;
    int res = bucket().compareTo(that.bucket());
    if (res != 0) {
      return res;
    }
    return toRealPathInternal(false).compareTo(that.toRealPathInternal(false));
  }

  @Override
  public boolean equals(Object other) {
    return this == other
        || other instanceof CloudStoragePath
            && Objects.equals(bucket(), ((CloudStoragePath) other).bucket())
            && Objects.equals(
                toRealPathInternal(false), ((CloudStoragePath) other).toRealPathInternal(false));
  }

  @Override
  public int hashCode() {
    return Objects.hash(bucket(), toRealPathInternal(false));
  }

  @Override
  public String toString() {
    return path.toString();
  }

  @Override
  public URI toUri() {
    try {
      return new URI(
          CloudStorageFileSystem.URI_SCHEME, bucket(), path.toAbsolutePath().toString(), null);
    } catch (URISyntaxException e) {
      throw new AssertionError(e);
    }
  }

  @Nullable
  private CloudStoragePath newPath(@Nullable UnixPath newPath) {
    if (newPath == path) { // Nonuse of equals is intentional.
      return this;
    } else if (newPath != null) {
      return new CloudStoragePath(fileSystem, newPath);
    } else {
      return null;
    }
  }

  private UnixPath getUnixPath(String newPath) {
    return UnixPath.getPath(fileSystem.config().permitEmptyPathComponents(), newPath);
  }

  private UnixPath getWorkingDirectory() {
    return getUnixPath(fileSystem.config().workingDirectory());
  }

  /**
   * Transform iterator providing a slight performance boost over {@code FluentIterable}.
   */
  private final class PathIterator extends UnmodifiableIterator<Path> {
    private final Iterator<String> delegate = path.split();

    @Override
    public Path next() {
      return newPath(getUnixPath(delegate.next()));
    }

    @Override
    public boolean hasNext() {
      return delegate.hasNext();
    }
  }
}
