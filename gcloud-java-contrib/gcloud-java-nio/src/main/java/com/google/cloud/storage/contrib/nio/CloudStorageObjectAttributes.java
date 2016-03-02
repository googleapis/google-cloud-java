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
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/**
 * Metadata for a Google Cloud Storage object.
 */
@Immutable
final class CloudStorageObjectAttributes implements CloudStorageFileAttributes {

  @Nonnull
  private final BlobInfo info;

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

  /**
   * Returns the HTTP etag hash for this object.
   */
  @Override
  public Optional<String> etag() {
    return Optional.fromNullable(info.etag());
  }

  /**
   * Returns the mime type (e.g. text/plain) if it was set for this object.
   */
  @Override
  public Optional<String> mimeType() {
    return Optional.fromNullable(info.contentType());
  }

  /**
   * Returns the ACL value on this Cloud Storage object.
   *
   * @see "https://developers.google.com/storage/docs/reference-headers#acl"
   */
  @Override
  public Optional<List<Acl>> acl() {
    return Optional.fromNullable(info.acl());
  }

  /**
   * Returns the {@code Cache-Control} HTTP header value, if set on this object.
   *
   * @see "https://developers.google.com/storage/docs/reference-headers#cachecontrol"
   */
  @Override
  public Optional<String> cacheControl() {
    return Optional.fromNullable(info.cacheControl());
  }

  /**
   * Returns the {@code Content-Encoding} HTTP header value, if set on this object.
   *
   * @see "https://developers.google.com/storage/docs/reference-headers#contentencoding"
   */
  @Override
  public Optional<String> contentEncoding() {
    return Optional.fromNullable(info.contentEncoding());
  }

  /**
   * Returns the {@code Content-Disposition} HTTP header value, if set on this object.
   *
   * @see "https://developers.google.com/storage/docs/reference-headers#contentdisposition"
   */
  @Override
  public Optional<String> contentDisposition() {
    return Optional.fromNullable(info.contentDisposition());
  }

  /**
   * Returns user-specified metadata associated with this object.
   *
   * @see "https://developers.google.com/storage/docs/reference-headers#contentdisposition"
   */
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
  public boolean equals(@Nullable Object other) {
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
    return MoreObjects.toStringHelper(this)
        .add("info", info)
        .toString();
  }
}
