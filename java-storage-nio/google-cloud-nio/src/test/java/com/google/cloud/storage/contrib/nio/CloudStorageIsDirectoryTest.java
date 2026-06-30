/*
 * Copyright 2021 Google LLC
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

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.gax.paging.Page;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.testing.junit4.MultipleAttemptsRule;
import com.google.common.collect.Lists;
import java.nio.file.Files;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Unit tests for {@code Files.isDirectory()}. */
@RunWith(JUnit4.class)
public class CloudStorageIsDirectoryTest {
  @Rule public final MultipleAttemptsRule multipleAttemptsRule = new MultipleAttemptsRule(3);

  @Rule public final TestName testName = new TestName();

  private StorageOptions mockOptions;
  private Storage mockStorage;

  @Before
  public void before() {
    mockOptions =
        mock(
            StorageOptions.class,
            String.format("storage-options-mock_%s", testName.getMethodName()));
    mockStorage = mock(Storage.class);
    when(mockOptions.getService()).thenReturn(mockStorage);
    CloudStorageFileSystemProvider.setStorageOptions(mockOptions);
  }

  @After
  public void after() {
    CloudStorageFileSystemProvider.setStorageOptions(StorageOptionsUtil.getDefaultInstance());
  }

  @Test
  public void testIsDirectoryNoUserProject() {
    CloudStorageFileSystem fs =
        CloudStorageFileSystem.forBucket("bucket", CloudStorageConfiguration.DEFAULT, mockOptions);
    when(mockStorage.get(BlobId.of("bucket", "test", null)))
        .thenThrow(new IllegalArgumentException());
    Page<Blob> pages = mock(Page.class);
    Blob blob = mock(Blob.class);
    when(blob.getBlobId()).thenReturn(BlobId.of("bucket", "test/hello.txt"));
    when(pages.getValues()).thenReturn(Lists.newArrayList(blob));
    when(mockStorage.list(
            "bucket", Storage.BlobListOption.prefix("test/"), Storage.BlobListOption.pageSize(1)))
        .thenReturn(pages);

    Files.isDirectory(fs.getPath("test"));
    verify(mockStorage, times(1))
        .list("bucket", Storage.BlobListOption.prefix("test/"), Storage.BlobListOption.pageSize(1));
  }

  @Test
  public void testIsDirectoryWithUserProject() {
    CloudStorageFileSystem fs =
        CloudStorageFileSystem.forBucket(
            "bucket",
            CloudStorageConfiguration.builder().userProject("project-id").build(),
            mockOptions);
    when(mockStorage.get(BlobId.of("bucket", "test", null)))
        .thenThrow(new IllegalArgumentException());
    Page<Blob> pages = mock(Page.class);
    Blob blob = mock(Blob.class);
    when(blob.getBlobId()).thenReturn(BlobId.of("bucket", "test/hello.txt"));
    when(pages.getValues()).thenReturn(Lists.newArrayList(blob));
    when(mockStorage.list(
            "bucket",
            Storage.BlobListOption.prefix("test/"),
            Storage.BlobListOption.pageSize(1),
            Storage.BlobListOption.userProject("project-id")))
        .thenReturn(pages);
    Files.isDirectory(fs.getPath("test"));
    verify(mockStorage, times(1))
        .list(
            "bucket",
            Storage.BlobListOption.prefix("test/"),
            Storage.BlobListOption.pageSize(1),
            Storage.BlobListOption.userProject("project-id"));
  }
}
