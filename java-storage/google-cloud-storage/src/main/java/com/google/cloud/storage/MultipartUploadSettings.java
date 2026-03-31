/*
 * Copyright 2025 Google LLC
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
package com.google.cloud.storage;

/**
 * Settings for configuring the {@link MultipartUploadClient}.
 *
 * <p>This class is for internal use only and is not intended for public consumption.
 */
public final class MultipartUploadSettings {
  private final HttpStorageOptions options;

  private MultipartUploadSettings(HttpStorageOptions options) {
    this.options = options;
  }

  /**
   * Returns the {@link HttpStorageOptions} configured for multipart uploads.
   *
   * @return The {@link HttpStorageOptions}.
   */
  public HttpStorageOptions getOptions() {
    return options;
  }

  /**
   * Creates a new {@code MultipartUploadSettings} instance with the specified {@link
   * HttpStorageOptions}.
   *
   * @param options The {@link HttpStorageOptions} to use.
   * @return A new {@code MultipartUploadSettings} instance.
   */
  public static MultipartUploadSettings of(HttpStorageOptions options) {
    return new MultipartUploadSettings(options);
  }
}
