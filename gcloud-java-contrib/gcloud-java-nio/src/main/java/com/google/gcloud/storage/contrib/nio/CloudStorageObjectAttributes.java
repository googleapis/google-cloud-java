package com.google.gcloud.storage.contrib.nio;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.gcloud.storage.contrib.nio.CloudStorageFileSystem.FILE_TIME_UNKNOWN;

import com.google.appengine.tools.cloudstorage.GcsFileMetadata;
import com.google.common.base.MoreObjects;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableMap;

import java.nio.file.attribute.FileTime;
import java.util.Objects;

import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/** Metadata for a Google Cloud Storage object. */
@Immutable
final class CloudStorageObjectAttributes implements CloudStorageFileAttributes {

  private final GcsFileMetadata metadata;

  CloudStorageObjectAttributes(GcsFileMetadata metadata) {
    this.metadata = checkNotNull(metadata);
  }

  @Override
  public long size() {
    return metadata.getLength();
  }

  @Override
  public FileTime creationTime() {
    if (metadata.getLastModified() == null) {
      return FILE_TIME_UNKNOWN;
    }
    return FileTime.fromMillis(metadata.getLastModified().getTime());
  }

  @Override
  public FileTime lastModifiedTime() {
    return creationTime();
  }

  /** Returns the HTTP etag hash for this object. */
  @Override
  public Optional<String> etag() {
    return Optional.fromNullable(metadata.getEtag());
  }

  /** Returns the mime type (e.g. text/plain) if it was set for this object. */
  @Override
  public Optional<String> mimeType() {
    return Optional.fromNullable(metadata.getOptions().getMimeType());
  }

  /**
   * Returns the ACL value on this Cloud Storage object.
   *
   * @see "https://developers.google.com/storage/docs/reference-headers#acl"
   */
  @Override
  public Optional<String> acl() {
    return Optional.fromNullable(metadata.getOptions().getAcl());
  }

  /**
   * Returns the {@code Cache-Control} HTTP header value, if set on this object.
   *
   * @see "https://developers.google.com/storage/docs/reference-headers#cachecontrol"
   */
  @Override
  public Optional<String> cacheControl() {
    return Optional.fromNullable(metadata.getOptions().getCacheControl());
  }

  /**
   * Returns the {@code Content-Encoding} HTTP header value, if set on this object.
   *
   * @see "https://developers.google.com/storage/docs/reference-headers#contentencoding"
   */
  @Override
  public Optional<String> contentEncoding() {
    return Optional.fromNullable(metadata.getOptions().getContentEncoding());
  }

  /**
   * Returns the {@code Content-Disposition} HTTP header value, if set on this object.
   *
   * @see "https://developers.google.com/storage/docs/reference-headers#contentdisposition"
   */
  @Override
  public Optional<String> contentDisposition() {
    return Optional.fromNullable(metadata.getOptions().getContentDisposition());
  }

  /**
   * Returns user-specified metadata associated with this object.
   *
   * @see "https://developers.google.com/storage/docs/reference-headers#contentdisposition"
   */
  @Override
  public ImmutableMap<String, String> userMetadata() {
    return ImmutableMap.copyOf(metadata.getOptions().getUserMetadata());
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
    return FILE_TIME_UNKNOWN;
  }

  @Override
  public Object fileKey() {
    return metadata.getFilename();
  }

  @Override
  public boolean equals(@Nullable Object other) {
    return this == other
        || other instanceof CloudStorageObjectAttributes
        && Objects.equals(metadata, ((CloudStorageObjectAttributes) other).metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(metadata);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("metadata", metadata)
        .toString();
  }
}
