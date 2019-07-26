/*
 * Copyright 2019 Google LLC
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

package com.google.cloud.spanner.jdbc;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;

/** Service class for getting credentials from key files stored locally or on cloud storage. */
class CredentialsService {
  private static final String GOOGLE_CLOUD_STORAGE_PREFIX = "gs://";
  private static final String INVALID_GCS_PREFIX_MSG =
      String.format("Storage URL must start with %s", GOOGLE_CLOUD_STORAGE_PREFIX);

  static final CredentialsService INSTANCE = new CredentialsService();

  CredentialsService() {}

  /**
   * Create credentials from the given URL pointing to a credentials json file. This may be a local
   * file or a file on Google Cloud Storage. Credentials on Google Cloud Storage can only be used if
   * the application is running in an environment where application default credentials have been
   * set.
   *
   * @param credentialsUrl The URL of the credentials file to read. If <code>null</code>, then this
   *     method will return the application default credentials of the environment.
   * @return the {@link GoogleCredentials} object pointed to by the URL.
   * @throws SpannerException If the URL does not point to a valid credentials file, or if the file
   *     cannot be accessed.
   */
  GoogleCredentials createCredentials(String credentialsUrl) {
    try {
      if (credentialsUrl == null) {
        return internalGetApplicationDefault();
      } else {
        return getCredentialsFromUrl(credentialsUrl);
      }
    } catch (IOException e) {
      throw SpannerExceptionFactory.newSpannerException(
          ErrorCode.INVALID_ARGUMENT, "Invalid credentials path specified", e);
    }
  }

  @VisibleForTesting
  GoogleCredentials internalGetApplicationDefault() throws IOException {
    return GoogleCredentials.getApplicationDefault();
  }

  private GoogleCredentials getCredentialsFromUrl(String credentialsUrl) throws IOException {
    Preconditions.checkNotNull(credentialsUrl);
    Preconditions.checkArgument(
        credentialsUrl.length() > 0, "credentialsUrl may not be an empty string");
    if (credentialsUrl.startsWith(GOOGLE_CLOUD_STORAGE_PREFIX)) {
      return getCredentialsFromCloudStorage(credentialsUrl);
    } else {
      return getCredentialsFromLocalFile(credentialsUrl);
    }
  }

  private GoogleCredentials getCredentialsFromLocalFile(String filePath) throws IOException {
    File credentialsFile = new File(filePath);
    if (!credentialsFile.isFile()) {
      throw new IOException(
          String.format("Error reading credential file %s: File does not exist", filePath));
    }
    try (InputStream credentialsStream = new FileInputStream(credentialsFile)) {
      return GoogleCredentials.fromStream(credentialsStream);
    }
  }

  private GoogleCredentials getCredentialsFromCloudStorage(String credentialsUrl)
      throws IOException {
    Preconditions.checkArgument(credentialsUrl.startsWith(GOOGLE_CLOUD_STORAGE_PREFIX));
    try {
      Storage storage = internalCreateStorage();
      String bucketName = internalGetBucket(credentialsUrl);
      String blobName = internalGetBlob(credentialsUrl);
      Blob blob = storage.get(bucketName, blobName);
      return GoogleCredentials.fromStream(internalCreateInputStream(blob));
    } catch (Exception e) {
      throw new IOException(
          String.format(
              "Could not retrieve credentials from %s. "
                  + "Credentials on Google Cloud Storage can only be used when the application is running "
                  + "in an environment that already has default credentials to access Google Cloud Storage",
              credentialsUrl),
          e);
    }
  }

  @VisibleForTesting
  Storage internalCreateStorage() {
    return StorageOptions.newBuilder().build().getService();
  }

  @VisibleForTesting
  InputStream internalCreateInputStream(Blob blob) {
    return Channels.newInputStream(blob.reader());
  }

  @VisibleForTesting
  String internalGetBucket(String storageUrl) {
    Preconditions.checkArgument(
        storageUrl.startsWith(GOOGLE_CLOUD_STORAGE_PREFIX), INVALID_GCS_PREFIX_MSG);
    Preconditions.checkArgument(
        storageUrl.substring(5).contains("/"), "Storage URL must contain a blob name");
    return storageUrl.substring(5, storageUrl.indexOf('/', 5));
  }

  @VisibleForTesting
  String internalGetBlob(String storageUrl) {
    Preconditions.checkArgument(
        storageUrl.startsWith(GOOGLE_CLOUD_STORAGE_PREFIX),
        String.format("Storage URL must start with %s", GOOGLE_CLOUD_STORAGE_PREFIX));
    Preconditions.checkArgument(
        storageUrl.substring(5).contains("/"), "Storage URL must contain a blob name");
    return storageUrl.substring(storageUrl.indexOf('/', 5) + 1);
  }
}
