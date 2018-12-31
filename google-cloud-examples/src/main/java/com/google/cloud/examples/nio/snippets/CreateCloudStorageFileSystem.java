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

package com.google.cloud.examples.nio.snippets;

import com.google.cloud.storage.contrib.nio.CloudStorageFileSystem;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * A snippet for Google Cloud Storage NIO that shows how to create a {@link CloudStorageFileSystem}
 * for a bucket. The snippet also shows how to create a file, given the file system.
 */
public class CreateCloudStorageFileSystem {

  public static void main(String... args) throws IOException {
    // Create a file system for the bucket
    CloudStorageFileSystem fs = CloudStorageFileSystem.forBucket("bucket");
    byte[] data = "hello world".getBytes(StandardCharsets.UTF_8);
    Path path = fs.getPath("/object");
    // Write a file in the bucket
    Files.write(path, data);
    // Read a file from the bucket
    data = Files.readAllBytes(path);
  }
}
