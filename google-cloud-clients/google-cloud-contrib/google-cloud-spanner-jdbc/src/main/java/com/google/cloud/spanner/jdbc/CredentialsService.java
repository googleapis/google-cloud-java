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
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/** Service class for getting credentials from key files. */
class CredentialsService {
  static final String GCS_NOT_SUPPORTED_MSG =
      "Credentials that is stored on Google Cloud Storage is no longer supported. Download the credentials to a local file and reference the local file in the connection URL.";
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
    if (credentialsUrl.startsWith("gs://")) {
      throw new IOException(GCS_NOT_SUPPORTED_MSG);
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
}
