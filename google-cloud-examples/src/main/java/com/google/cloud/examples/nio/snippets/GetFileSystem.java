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

import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * A snippet showing how to get a {@link FileSystem} instance for a Google Cloud Storage bucket.
 * This snippet also shows how to create a file and read its lines.
 */
public class GetFileSystem {

  public static void main(String... args) throws IOException {
    FileSystem fs = FileSystems.getFileSystem(URI.create("gs://bucket"));
    byte[] data = "hello world".getBytes(StandardCharsets.UTF_8);
    Path path = fs.getPath("/object");
    Files.write(path, data);
    List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
  }
}
