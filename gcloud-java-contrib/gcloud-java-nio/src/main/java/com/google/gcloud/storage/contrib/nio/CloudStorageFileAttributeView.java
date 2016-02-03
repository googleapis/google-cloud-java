package com.google.gcloud.storage.contrib.nio;

import static com.google.common.base.Verify.verifyNotNull;

import com.google.appengine.tools.cloudstorage.GcsFileMetadata;
import com.google.common.base.MoreObjects;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.FileTime;
import java.util.Objects;

import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/** Metadata view for a Google Cloud Storage object. */
@Immutable
public final class CloudStorageFileAttributeView implements BasicFileAttributeView {

  private final CloudStorageFileSystemProvider provider;
  private final CloudStoragePath path;

  CloudStorageFileAttributeView(CloudStorageFileSystemProvider provider, CloudStoragePath path) {
    this.provider = verifyNotNull(provider);
    this.path = verifyNotNull(path);
  }

  /** Returns {@value CloudStorageFileSystem#GCS_VIEW} */
  @Override
  public String name() {
    return CloudStorageFileSystem.GCS_VIEW;
  }

  @Override
  public CloudStorageFileAttributes readAttributes() throws IOException {
    if (path.seemsLikeADirectory()
        && path.getFileSystem().config().usePseudoDirectories()) {
      return CloudStoragePseudoDirectoryAttributes.SINGLETON_INSTANCE;
    }
    GcsFileMetadata metadata = provider.getGcsService().getMetadata(path.getGcsFilename());
    if (metadata == null) {
      throw new NoSuchFileException(path.toUri().toString());
    }
    return new CloudStorageObjectAttributes(metadata);
  }

  /**
   * This feature is not supported, since Cloud Storage objects are immutable.
   *
   * @throws UnsupportedOperationException
   */
  @Override
  public void setTimes(FileTime lastModifiedTime, FileTime lastAccessTime, FileTime createTime) {
    throw new CloudStorageObjectImmutableException();
  }

  @Override
  public boolean equals(@Nullable Object other) {
    return this == other
        || other instanceof CloudStorageFileAttributeView
        && Objects.equals(provider, ((CloudStorageFileAttributeView) other).provider)
        && Objects.equals(path, ((CloudStorageFileAttributeView) other).path);
  }

  @Override
  public int hashCode() {
    return Objects.hash(provider, path);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("provider", provider)
        .add("path", path)
        .toString();
  }
}
