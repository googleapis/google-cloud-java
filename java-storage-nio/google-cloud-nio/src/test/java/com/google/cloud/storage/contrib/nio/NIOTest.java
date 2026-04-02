/*
 * Copyright 2020 Google LLC
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

import com.google.cloud.storage.contrib.nio.testing.LocalStorageHelper;
import com.google.cloud.testing.junit4.MultipleAttemptsRule;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Unit tests for {@link CloudStorageFileSystemProvider}. Makes sure the NIO system picks it up
 * properly.
 */
@RunWith(JUnit4.class)
public class NIOTest {
  @Rule public final MultipleAttemptsRule multipleAttemptsRule = new MultipleAttemptsRule(3);

  private URI uriToCloudStorage;

  @Before
  public void setUp() {
    CloudStorageFileSystemProvider.setStorageOptions(LocalStorageHelper.getOptions());
    uriToCloudStorage = URI.create("gs://bucket/file.txt");
  }

  @After
  public void after() {
    CloudStorageFileSystemProvider.setStorageOptions(StorageOptionsUtil.getDefaultInstance());
  }

  /** We can create a Path object from a gs:// URI. * */
  @Test
  public void testCreatePath() {
    // Return value ignored on purpose, we just want to check
    // no exception is thrown.
    Path path = Paths.get(uriToCloudStorage);
    // Truth bug workaround, see https://github.com/google/truth/issues/285
    assertThat((Object) path).isNotNull();
  }

  /** The created Path object has the correct scheme. * */
  @Test
  public void testCreatedPathIsGS() {
    Path path = Paths.get(uriToCloudStorage);
    assertThat(path.getFileSystem().provider().getScheme()).isEqualTo("gs");
  }
}
