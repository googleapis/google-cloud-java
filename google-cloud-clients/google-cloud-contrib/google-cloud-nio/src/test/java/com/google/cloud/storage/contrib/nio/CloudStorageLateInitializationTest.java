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

package com.google.cloud.storage.contrib.nio;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import java.net.URI;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Unit tests for {@link CloudStorageFileSystemProvider} late initialization. */
@RunWith(JUnit4.class)
public class CloudStorageLateInitializationTest {

  @Rule public final ExpectedException thrown = ExpectedException.none();

  private StorageOptions mockOptions;

  @Before
  public void before() {
    mockOptions = mock(StorageOptions.class);
    Storage mockStorage = mock(Storage.class);
    when(mockOptions.getService()).thenReturn(mockStorage);
    CloudStorageFileSystemProvider.setStorageOptions(mockOptions);
  }

  @Test
  public void ctorDoesNotCreateStorage() {
    new CloudStorageFileSystemProvider();
    verify(mockOptions, never()).getService();
  }

  @Test
  public void getPathCreatesStorageOnce() {
    CloudStorageFileSystemProvider provider = new CloudStorageFileSystemProvider();
    provider.getPath(URI.create("gs://bucket1/wat"));
    provider.getPath(URI.create("gs://bucket2/wat"));
    verify(mockOptions, times(1)).getService();
  }

  @Test
  public void getFileSystemCreatesStorageOnce() {
    CloudStorageFileSystemProvider provider = new CloudStorageFileSystemProvider();
    provider.getFileSystem(URI.create("gs://bucket1"));
    provider.getFileSystem(URI.create("gs://bucket2"));
    verify(mockOptions, times(1)).getService();
  }
}
