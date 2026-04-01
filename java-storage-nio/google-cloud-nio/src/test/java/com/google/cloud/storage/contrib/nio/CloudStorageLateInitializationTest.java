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

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.google.cloud.testing.junit4.MultipleAttemptsRule;
import java.net.URI;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

/** Unit tests for {@link CloudStorageFileSystemProvider} late initialization. */
@RunWith(MockitoJUnitRunner.class)
public class CloudStorageLateInitializationTest {
  @Rule public final MultipleAttemptsRule multipleAttemptsRule = new MultipleAttemptsRule(3);

  @Spy private final CloudStorageFileSystemProvider provider = new CloudStorageFileSystemProvider();

  @Test
  public void ctorDoesNotCreateStorage() {
    verify(provider, never()).doInitStorage();
  }

  @Test
  public void getPathCreatesStorageOnce() {
    provider.getPath(URI.create("gs://bucket1/wat"));
    provider.getPath(URI.create("gs://bucket2/wat"));
    verify(provider, times(1)).doInitStorage();
  }

  @Test
  public void getFileSystemCreatesStorageOnce() {
    provider.getFileSystem(URI.create("gs://bucket1"));
    provider.getFileSystem(URI.create("gs://bucket2"));
    verify(provider, times(1)).doInitStorage();
  }
}
