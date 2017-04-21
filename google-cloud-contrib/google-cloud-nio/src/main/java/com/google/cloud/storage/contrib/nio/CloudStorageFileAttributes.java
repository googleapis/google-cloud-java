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

import com.google.cloud.storage.Acl;
import com.google.common.base.Optional;

import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.Map;

/**
 * Interface for attributes on a Cloud Storage file or pseudo-directory.
 */
public interface CloudStorageFileAttributes extends BasicFileAttributes {

  /**
   * Returns HTTP etag hash of object contents.
   *
   * @see "https://developers.google.com/storage/docs/hashes-etags"
   */
  Optional<String> etag();

  /**
   * Returns mime type (e.g. text/plain), if set.
   *
   * @see "http://en.wikipedia.org/wiki/Internet_media_type#List_of_common_media_types"
   */
  Optional<String> mimeType();

  /**
   * Returns access control list.
   *
   * @see "https://developers.google.com/storage/docs/reference-headers#acl"
   */
  Optional<List<Acl>> acl();

  /**
   * Returns {@code Cache-Control} HTTP header value, if set.
   *
   * @see "https://developers.google.com/storage/docs/reference-headers#cachecontrol"
   */
  Optional<String> cacheControl();

  /**
   * Returns {@code Content-Encoding} HTTP header value, if set.
   *
   * @see "https://developers.google.com/storage/docs/reference-headers#contentencoding"
   */
  Optional<String> contentEncoding();

  /**
   * Returns {@code Content-Disposition} HTTP header value, if set.
   *
   * @see "https://developers.google.com/storage/docs/reference-headers#contentdisposition"
   */
  Optional<String> contentDisposition();

  /**
   * Returns user-specified metadata.
   *
   * @see "https://developers.google.com/storage/docs/reference-headers#contentdisposition"
   */
  Map<String, String> userMetadata();
}
