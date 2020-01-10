/*
 * Copyright 2017 Google LLC
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

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;
import static java.nio.charset.StandardCharsets.UTF_8;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import com.google.cloud.storage.contrib.nio.testing.LocalStorageHelper;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Unit tests for {@link CloudStorageFileSystemProvider}.
 *  Makes sure the NIO system picks it up properly. */
@RunWith(JUnit4.class)
public class NIOTest {

  /** We can create a Path object from a gs:// URI. **/
  @Test
  public void testCreatePath() {
    URI uriToCloudStorage = URI.create("gs://bucket/file.txt");
    // Return value ignored on purpose, we just want to check
    // no exception is thrown.
    Paths.get(uriToCloudStorage);
  }

  /** The created Path object has the correct scheme. **/
  @Test
  public void testCreatedPathIsGS() {
    URI uriToCloudStorage = URI.create("gs://bucket/file.txt");
    Path path = Paths.get(uriToCloudStorage);
    assertThat(path.getFileSystem().provider().getScheme()).isEqualTo("gs");
  }

  /** The created Path object has the correct provider class. **/
  @Test
  public void testCreatedPathIsCorrectInstance() {
    URI uriToCloudStorage = URI.create("gs://bucket/file.txt");
    Path path = Paths.get(uriToCloudStorage);
    assertThat(path.getFileSystem().provider())
        .isInstanceOf(CloudStorageFileSystemProvider.class);
  }
}