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

/** Helper class for specifying options when opening and copying Cloud Storage files. */
public final class CloudStorageOptions {

  /** Sets the mime type header on an object, e.g. {@code "text/plain"}. */
  public static CloudStorageOption.OpenCopy withMimeType(String mimeType) {
    return OptionMimeType.create(mimeType);
  }

  /** Disables caching on an object. Same as: {@code withCacheControl("no-cache")}. */
  public static CloudStorageOption.OpenCopy withoutCaching() {
    return withCacheControl("no-cache");
  }

  /**
   * Sets the {@code Cache-Control} HTTP header on an object.
   *
   * @see "https://developers.google.com/storage/docs/reference-headers#cachecontrol"
   */
  public static CloudStorageOption.OpenCopy withCacheControl(String cacheControl) {
    return OptionCacheControl.create(cacheControl);
  }

  /**
   * Sets the {@code Content-Disposition} HTTP header on an object.
   *
   * @see "https://developers.google.com/storage/docs/reference-headers#contentdisposition"
   */
  public static CloudStorageOption.OpenCopy withContentDisposition(String contentDisposition) {
    return OptionContentDisposition.create(contentDisposition);
  }

  /**
   * Sets the {@code Content-Encoding} HTTP header on an object.
   *
   * @see "https://developers.google.com/storage/docs/reference-headers#contentencoding"
   */
  public static CloudStorageOption.OpenCopy withContentEncoding(String contentEncoding) {
    return OptionContentEncoding.create(contentEncoding);
  }

  /**
   * Sets the ACL value on a Cloud Storage object.
   *
   * @see "https://developers.google.com/storage/docs/reference-headers#acl"
   */
  public static CloudStorageOption.OpenCopy withAcl(Acl acl) {
    return OptionAcl.create(acl);
  }

  /**
   * Sets an unmodifiable piece of user metadata on a Cloud Storage object.
   *
   * @see "https://developers.google.com/storage/docs/reference-headers#xgoogmeta"
   */
  public static CloudStorageOption.OpenCopy withUserMetadata(String key, String value) {
    return OptionUserMetadata.create(key, value);
  }

  /**
   * Sets the block size (in bytes) when talking to the Google Cloud Storage server.
   *
   * <p>The default is {@value CloudStorageFileSystem#BLOCK_SIZE_DEFAULT}.
   */
  public static CloudStorageOption.OpenCopy withBlockSize(int size) {
    return OptionBlockSize.create(size);
  }

  /**
   * Sets the max number of times that the channel can be reopened if reading fails because the
   * channel unexpectedly closes.
   *
   * <p>The default is 0.
   */
  public static CloudStorageOption.OpenCopy withChannelReopen(int count) {
    return OptionMaxChannelReopens.create(count);
  }

  private CloudStorageOptions() {}
}
