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

import static com.google.cloud.storage.contrib.nio.CloudStorageOptions.withMimeType;
import static com.google.cloud.storage.contrib.nio.CloudStorageOptions.withoutCaching;

import com.google.cloud.storage.contrib.nio.CloudStorageOptions;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * A snippet showing how to write a file to Google Cloud Storage using NIO. This example also shows
 * how to set file attributes, using {@link CloudStorageOptions} static helpers.
 */
public class WriteFileWithAttributes {

  private static final String[] LINES = {"value1,", "value"};

  public static void main(String... args) throws IOException {
    List<String> csvLines = Arrays.asList(LINES);
    Path path = Paths.get(URI.create("gs://bucket/lolcat.csv"));
    Files.write(
        path,
        csvLines,
        StandardCharsets.UTF_8,
        withMimeType("text/csv; charset=UTF-8"),
        withoutCaching());
  }
}
