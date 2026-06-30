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

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.ProviderMismatchException;
import java.util.regex.Pattern;

final class CloudStorageUtil {

  private static final Pattern BUCKET_PATTERN = Pattern.compile("[a-z0-9][-._a-z0-9]+[a-z0-9]");

  static void checkBucket(String bucket) {
    // TODO: The true check is actually more complicated. Consider implementing it.
    checkArgument(
        BUCKET_PATTERN.matcher(bucket).matches(),
        "Invalid bucket name: '"
            + bucket
            + "'. "
            + "Google Cloud Storage bucket names must contain only lowercase letters, numbers, "
            + "dashes (-), underscores (_), and dots (.). Bucket names must start and end with a "
            + "number or a letter. See the following page for more details: "
            + "https://developers.google.com/storage/docs/bucketnaming");
  }

  static CloudStoragePath checkPath(Path path) {
    if (!(checkNotNull(path) instanceof CloudStoragePath)) {
      throw new ProviderMismatchException(
          String.format(
              "Not a Cloud Storage path: %s (%s)", path, path.getClass().getSimpleName()));
    }
    return (CloudStoragePath) path;
  }

  static URI stripPathFromUri(URI uri) {
    try {
      return new URI(
          uri.getScheme(),
          uri.getUserInfo(),
          uri.getHost(),
          uri.getPort(),
          null,
          uri.getQuery(),
          uri.getFragment());
    } catch (URISyntaxException e) {
      try {
        // Store GCS bucket name in the URI authority, see
        // https://github.com/googleapis/java-storage-nio/issues/1218
        return new URI(
            uri.getScheme(), uri.getAuthority(), null, uri.getQuery(), uri.getFragment());
      } catch (URISyntaxException unused) {
        throw new IllegalArgumentException(e.getMessage());
      }
    }
  }

  /** Makes {@code NullPointerTester} happy. */
  @SafeVarargs
  static <T> void checkNotNullArray(T... values) {
    for (T value : values) {
      checkNotNull(value);
    }
  }

  static int getMaxChannelReopensFromPath(Path path) {
    return ((CloudStorageFileSystem) path.getFileSystem()).config().maxChannelReopens();
  }

  private CloudStorageUtil() {}
}
