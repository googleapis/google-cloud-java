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

import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.storage.Storage;
import com.google.cloud.NoCredentials;
import com.google.cloud.http.HttpTransportOptions;
import com.google.cloud.storage.StorageOptions;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
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
  public void customHostWithProxyPath_preservesRootUrlAndDefaultServicePath() {
    StorageOptions options =
        StorageOptions.http()
            .setCredentials(NoCredentials.getInstance())
            .setProjectId("test-project")
            .setHost("https://proxy.example.com/gcs/")
            .build();
    HttpStorageRpc rpc = (HttpStorageRpc) options.getRpc();
    assertThat(rpc.getStorage().getRootUrl()).isEqualTo("https://proxy.example.com/gcs/");
    assertThat(rpc.getStorage().getServicePath()).isEqualTo("storage/v1/");
    assertThat(rpc.getStorage().getBaseUrl())
        .isEqualTo("https://proxy.example.com/gcs/storage/v1/");
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
    assertThat(rpc.getStorage().getBaseUrl())
        .isEqualTo(
            "https://storage-preprod-test-unified.googleusercontent.com/storage/v1_preprod/");
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

  @Test
  public void customHostWithMirrorPath_preservesRootUrlAndDefaultServicePath() {
    StorageOptions options =
        StorageOptions.http()
            .setCredentials(NoCredentials.getInstance())
            .setProjectId("test-project")
            .setHost("https://proxy.example.com/storage/v1-mirror/")
            .build();
    HttpStorageRpc rpc = (HttpStorageRpc) options.getRpc();
    assertThat(rpc.getStorage().getRootUrl())
        .isEqualTo("https://proxy.example.com/storage/v1-mirror/");
    assertThat(rpc.getStorage().getServicePath()).isEqualTo("storage/v1/");
    assertThat(rpc.getStorage().getBaseUrl())
        .isEqualTo("https://proxy.example.com/storage/v1-mirror/storage/v1/");
  }

  @Test
  public void customHostWithV1BetaPath_preservesRootUrlAndDefaultServicePath() {
    StorageOptions options =
        StorageOptions.http()
            .setCredentials(NoCredentials.getInstance())
            .setProjectId("test-project")
            .setHost("https://proxy.example.com/storage/v1beta/")
            .build();
    HttpStorageRpc rpc = (HttpStorageRpc) options.getRpc();
    assertThat(rpc.getStorage().getRootUrl())
        .isEqualTo("https://proxy.example.com/storage/v1beta/");
    assertThat(rpc.getStorage().getServicePath()).isEqualTo("storage/v1/");
    assertThat(rpc.getStorage().getBaseUrl())
        .isEqualTo("https://proxy.example.com/storage/v1beta/storage/v1/");
  }

  @Test
  public void nonPreprodHosts_matchMainBaselineExactly() throws IOException {
    ImmutableList<StorageOptions> nonPreprodConfigs =
        ImmutableList.of(
            StorageOptions.http()
                .setCredentials(NoCredentials.getInstance())
                .setProjectId("test-project")
                .build(),
            StorageOptions.http()
                .setCredentials(NoCredentials.getInstance())
                .setProjectId("test-project")
                .setHost(null)
                .build(),
            StorageOptions.http()
                .setCredentials(NoCredentials.getInstance())
                .setProjectId("test-project")
                .setUniverseDomain("my-universe-domain.com")
                .build(),
            StorageOptions.http()
                .setCredentials(NoCredentials.getInstance())
                .setProjectId("test-project")
                .setHost("http://127.0.0.1:9000")
                .build(),
            StorageOptions.http()
                .setCredentials(NoCredentials.getInstance())
                .setProjectId("test-project")
                .setHost("http://localhost:8080/")
                .build(),
            StorageOptions.http()
                .setCredentials(NoCredentials.getInstance())
                .setProjectId("test-project")
                .setHost("http://[::1]")
                .build(),
            StorageOptions.http()
                .setCredentials(NoCredentials.getInstance())
                .setProjectId("test-project")
                .setHost("https://proxy.example.com/gcs/")
                .build(),
            StorageOptions.http()
                .setCredentials(NoCredentials.getInstance())
                .setProjectId("test-project")
                .setHost("https://proxy.example.com/storage/v1/")
                .build(),
            StorageOptions.http()
                .setCredentials(NoCredentials.getInstance())
                .setProjectId("test-project")
                .setHost("https://proxy.example.com/storage/v1-mirror/")
                .build(),
            StorageOptions.http()
                .setCredentials(NoCredentials.getInstance())
                .setProjectId("test-project")
                .setHost("https://proxy.example.com/storage/v1beta/")
                .build());

    JsonFactory jsonFactory = GsonFactory.getDefaultInstance();
    for (StorageOptions options : nonPreprodConfigs) {
      HttpTransport transport =
          ((HttpTransportOptions) options.getTransportOptions()).getHttpTransportFactory().create();
      Storage baseline =
          new Storage.Builder(transport, jsonFactory, null)
              .setRootUrl(options.getHost())
              .setApplicationName(options.getApplicationName())
              .build();
      Storage actual = ((HttpStorageRpc) options.getRpc()).getStorage();

      assertThat(actual.getRootUrl()).isEqualTo(baseline.getRootUrl());
      assertThat(actual.getServicePath()).isEqualTo(baseline.getServicePath());
      assertThat(actual.getBaseUrl()).isEqualTo(baseline.getBaseUrl());
      assertThat(actual.objects().get("b", "o").buildHttpRequestUrl())
          .isEqualTo(baseline.objects().get("b", "o").buildHttpRequestUrl());
    }
  }
}
