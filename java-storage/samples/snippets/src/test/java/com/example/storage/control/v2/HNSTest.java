/*
 * Copyright 2024 Google LLC
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

package com.example.storage.control.v2;

import static com.google.common.truth.Truth.assertThat;

import com.example.storage.TestBase;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.testing.RemoteStorageHelper;
import org.junit.Test;

public final class HNSTest extends TestBase {

  @Test
  public void createHierarchicalNamespaceBucket() throws Exception {
    String newBucketName = RemoteStorageHelper.generateBucketName();
    String projectId = storage.getOptions().getProjectId();
    CreateHierarchicalNamespaceBucket.createHierarchicalNamespaceBucket(projectId, newBucketName);
    try {
      Bucket remoteBucket = storage.get(newBucketName);
      assertThat(remoteBucket).isNotNull();
      assertThat(remoteBucket.getHierarchicalNamespace().getEnabled()).isTrue();
      assertThat(stdOut.getCapturedOutputAsUtf8String()).contains(newBucketName);
    } finally {
      storage.delete(newBucketName);
    }
  }
}
