/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.storage.spi.v1;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.NoCredentials;
import com.google.cloud.storage.StorageOptions;
import org.junit.Test;

public final class HttpStorageRpcUriTest {

  @Test
  public void defaultHost_setsDefaultServicePath() {
    StorageOptions options =
        StorageOptions.http()
            .setCredentials(NoCredentials.getInstance())
            .setProjectId("test-project")
            .build();
    HttpStorageRpc rpc = (HttpStorageRpc) options.getRpc();
    assertThat(rpc.getStorage().getRootUrl()).isEqualTo("https://storage.googleapis.com/");
    assertThat(rpc.getStorage().getServicePath()).isEqualTo("storage/v1/");
  }

  @Test
  public void customHostWithTrailingSlash_setsDefaultServicePath() {
    StorageOptions options =
        StorageOptions.http()
            .setCredentials(NoCredentials.getInstance())
            .setProjectId("test-project")
            .setHost("https://storage.googleapis.com/")
            .build();
    HttpStorageRpc rpc = (HttpStorageRpc) options.getRpc();
    assertThat(rpc.getStorage().getRootUrl()).isEqualTo("https://storage.googleapis.com/");
    assertThat(rpc.getStorage().getServicePath()).isEqualTo("storage/v1/");
  }

  @Test
  public void customHostWithSubpath_splitsRootUrlAndServicePath() {
    StorageOptions options =
        StorageOptions.http()
            .setCredentials(NoCredentials.getInstance())
            .setProjectId("test-project")
            .setHost(
                "https://storage-preprod-test-unified.googleusercontent.com/storage/v1_preprod/")
            .build();
    HttpStorageRpc rpc = (HttpStorageRpc) options.getRpc();
    assertThat(rpc.getStorage().getRootUrl())
        .isEqualTo("https://storage-preprod-test-unified.googleusercontent.com/");
    assertThat(rpc.getStorage().getServicePath()).isEqualTo("storage/v1_preprod/");
  }

  @Test
  public void customHostWithSubpathNoTrailingSlash_appendsSlashToServicePath() {
    StorageOptions options =
        StorageOptions.http()
            .setCredentials(NoCredentials.getInstance())
            .setProjectId("test-project")
            .setHost(
                "https://storage-preprod-test-unified.googleusercontent.com/storage/v1_preprod")
            .build();
    HttpStorageRpc rpc = (HttpStorageRpc) options.getRpc();
    assertThat(rpc.getStorage().getRootUrl())
        .isEqualTo("https://storage-preprod-test-unified.googleusercontent.com/");
    assertThat(rpc.getStorage().getServicePath()).isEqualTo("storage/v1_preprod/");
  }
}
