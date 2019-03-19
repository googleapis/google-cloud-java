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

package com.google.cloud.examples.nio.snippets;

import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.storage.contrib.nio.CloudStorageConfiguration;
import com.google.cloud.storage.contrib.nio.CloudStorageFileSystem;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * A snippet for Google Cloud Storage NIO that shows how to create a {@link CloudStorageFileSystem}
 * using explicitly-provided credentials instead of the default ones.
 */
public class UseExplicitCredentials {

  public static void main(String... args) throws IOException {
    // Create a file system for the bucket using the service account credentials
    // saved in the file below.
    String myCredentials = "/path/to/my/key.json";
    CloudStorageFileSystem fs =
        CloudStorageFileSystem.forBucket(
            "mybucket",
            CloudStorageConfiguration.DEFAULT,
            StorageOptions.newBuilder()
                .setCredentials(
                    ServiceAccountCredentials.fromStream(new FileInputStream(myCredentials)))
                .build());
    // Can now read and write to the bucket using fs
    // (see e.g. ReadAllLines for an example).
  }
}
