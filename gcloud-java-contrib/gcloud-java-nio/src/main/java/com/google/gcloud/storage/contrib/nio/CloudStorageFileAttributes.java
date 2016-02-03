package com.google.gcloud.storage.contrib.nio;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableMap;

import java.nio.file.attribute.BasicFileAttributes;

/** Interface for attributes on a cloud storage file or pseudo-directory. */
public interface CloudStorageFileAttributes extends BasicFileAttributes {

  /**
   * Returns the HTTP etag hash for this object.
   *
   * @see "https://developers.google.com/storage/docs/hashes-etags"
   */
  Optional<String> etag();

  /**
   * Returns the mime type (e.g. text/plain) if it was set for this object.
   *
   * @see "http://en.wikipedia.org/wiki/Internet_media_type#List_of_common_media_types"
   */
  Optional<String> mimeType();

  /**
   * Returns the ACL value on this Cloud Storage object.
   *
   * @see "https://developers.google.com/storage/docs/reference-headers#acl"
   */
  Optional<String> acl();

  /**
   * Returns the {@code Cache-Control} HTTP header value, if set on this object.
   *
   * @see "https://developers.google.com/storage/docs/reference-headers#cachecontrol"
   */
  Optional<String> cacheControl();

  /**
   * Returns the {@code Content-Encoding} HTTP header value, if set on this object.
   *
   * @see "https://developers.google.com/storage/docs/reference-headers#contentencoding"
   */
  Optional<String> contentEncoding();

  /**
   * Returns the {@code Content-Disposition} HTTP header value, if set on this object.
   *
   * @see "https://developers.google.com/storage/docs/reference-headers#contentdisposition"
   */
  Optional<String> contentDisposition();

  /**
   * Returns user-specified metadata associated with this object.
   *
   * @see "https://developers.google.com/storage/docs/reference-headers#contentdisposition"
   */
  ImmutableMap<String, String> userMetadata();
}
