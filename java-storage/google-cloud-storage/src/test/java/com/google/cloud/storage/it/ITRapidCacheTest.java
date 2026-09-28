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

package com.google.cloud.storage.it;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.StatusCode;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.BucketInfo.HierarchicalNamespace;
import com.google.cloud.storage.BucketInfo.IamConfiguration;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.protobuf.Duration;
import com.google.protobuf.FieldMask;
import com.google.storage.control.v2.BucketName;
import com.google.storage.control.v2.RapidCache;
import com.google.storage.control.v2.StorageControlClient;
import com.google.storage.control.v2.StorageControlSettings;
import com.google.storage.control.v2.stub.StorageControlStubSettings;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Integration tests for Storage Control RapidCache CRUD operations.
 *
 * <p>RapidCache requires a regional bucket with Hierarchical Namespace (HNS) enabled. The cache ID
 * is required by the backend to match the zone name where it is provisioned (e.g. europe-west1-c).
 */
public class ITRapidCacheTest {

  private static final Logger LOGGER = Logger.getLogger(ITRapidCacheTest.class.getName());

  private static StorageControlClient controlClient;
  private static Storage storageClient;
  private static String bucketName;

  // Shared Cache Details
  private static String cacheId;
  private static String cacheName;
  private static boolean cacheDisabled = false;

  @BeforeClass
  public static void setUpClass() throws Exception {
    // Initialize standard Storage client for prod (gRPC)
    storageClient =
        StorageOptions.grpc()
            .setAttemptDirectPath(false)
            .setGrpcInterceptorProvider(GrpcPlainRequestLoggingInterceptor.getInterceptorProvider())
            .setEnableGrpcClientMetrics(false)
            .build()
            .getService();

    // Initialize StorageControl client for prod (gRPC)
    StorageControlSettings controlSettings =
        StorageControlSettings.newBuilder()
            .setTransportChannelProvider(
                StorageControlStubSettings.defaultGrpcTransportProviderBuilder()
                    .setInterceptorProvider(
                        GrpcPlainRequestLoggingInterceptor.getInterceptorProvider())
                    .build())
            .build();
    controlClient = StorageControlClient.create(controlSettings);

    // Create HNS enabled regional bucket in europe-west1
    bucketName = "java-storage-rapid-" + UUID.randomUUID().toString().substring(0, 8);
    BucketInfo bucketInfo =
        BucketInfo.newBuilder(bucketName)
            .setLocation("europe-west1")
            .setHierarchicalNamespace(HierarchicalNamespace.newBuilder().setEnabled(true).build())
            .setIamConfiguration(
                IamConfiguration.newBuilder().setIsUniformBucketLevelAccessEnabled(true).build())
            .build();
    storageClient.create(bucketInfo);
    // Wait for bucket metadata to propagate in GCS Control plane
    Thread.sleep(20000);

    // Define shared cache ID (forced to be the zone name by the backend)
    cacheId = "europe-west1-c";
    cacheName = String.format("projects/_/buckets/%s/rapidCaches/%s", bucketName, cacheId);
  }

  @AfterClass
  public static void tearDownClass() {
    if (controlClient != null && cacheName != null && !cacheDisabled) {
      try {
        controlClient.disableRapidCacheAsync(cacheName).get();
      } catch (Exception e) {
        LOGGER.log(Level.WARNING, "Failed to clean up rapid cache: " + e.getMessage());
      }
    }
    if (storageClient != null && bucketName != null) {
      try {
        storageClient.delete(bucketName);
      } catch (Exception e) {
        LOGGER.log(Level.WARNING, "Failed to clean up bucket: " + e.getMessage());
      }
    }
    if (controlClient != null) {
      try {
        controlClient.close();
      } catch (Exception e) {
        LOGGER.log(Level.WARNING, "Failed to close controlClient", e);
      }
    }
    if (storageClient != null) {
      try {
        storageClient.close();
      } catch (Exception e) {
        LOGGER.log(Level.WARNING, "Failed to close storageClient", e);
      }
    }
  }

  // --- CRUD Lifecycle and Negative Test Cases ---

  @Test
  public void rapidCache_crudLifecycle() throws Exception {
    RapidCache rapidCache =
        RapidCache.newBuilder()
            .setName(cacheName)
            .setZone("europe-west1-c")
            .setCacheType("rapid-cache-ultra")
            .setTtl(Duration.newBuilder().setSeconds(86400).build()) // 24 hours
            .build();

    // 1. Create RapidCache
    // Workaround for b/564257939: CreateRapidCache via gRPC in Prod returns UNAVAILABLE
    // even when the backend asynchronously creates the cache instance.
    RapidCache created = null;
    ExecutionException lastException = null;
    for (int i = 0; i < 5; i++) {
      try {
        created =
            controlClient
                .createRapidCacheAsync(BucketName.format("_", bucketName), rapidCache)
                .get();
        break;
      } catch (ExecutionException e) {
        lastException = e;
        if (e.getCause() instanceof ApiException) {
          ApiException apiEx = (ApiException) e.getCause();
          if (apiEx.getStatusCode().getCode() == StatusCode.Code.UNAVAILABLE
              || apiEx.getStatusCode().getCode() == StatusCode.Code.ALREADY_EXISTS) {
            try {
              Thread.sleep(3000);
              created = controlClient.getRapidCache(cacheName);
              if (created != null) {
                break;
              }
            } catch (Exception ignored) {
              // Cache not yet ready via getRapidCache
            }
            continue;
          }
        }
        throw e;
      }
    }
    if (created == null && lastException != null) {
      throw lastException;
    }

    assertThat(created).isNotNull();
    assertThat(created.getName()).isEqualTo(cacheName);
    assertThat(created.getState()).isEqualTo("running");

    // 2. Duplicate Create Attempt (should fail while cache is active)
    ApiException duplicateApiException = null;
    for (int i = 0; i < 3; i++) {
      ExecutionException thrown =
          assertThrows(
              ExecutionException.class,
              () ->
                  controlClient
                      .createRapidCacheAsync(BucketName.format("_", bucketName), rapidCache)
                      .get());
      if (thrown.getCause() instanceof ApiException) {
        duplicateApiException = (ApiException) thrown.getCause();
        if (duplicateApiException.getStatusCode().getCode() == StatusCode.Code.UNAVAILABLE) {
          Thread.sleep(2000);
          continue;
        }
      }
      break;
    }
    assertThat(duplicateApiException).isNotNull();
    // b/564257939: CreateRapidCache in Prod returns UNAVAILABLE instead of ALREADY_EXISTS
    assertThat(duplicateApiException.getStatusCode().getCode())
        .isAnyOf(StatusCode.Code.ALREADY_EXISTS, StatusCode.Code.UNAVAILABLE);

    // 3. Get RapidCache
    RapidCache retrieved = controlClient.getRapidCache(cacheName);
    assertThat(retrieved).isNotNull();
    assertThat(retrieved.getName()).isEqualTo(cacheName);
    assertThat(retrieved.getState()).isEqualTo("running");

    // 4. List RapidCaches
    StorageControlClient.ListRapidCachesPagedResponse listResponse =
        controlClient.listRapidCaches(BucketName.format("_", bucketName));
    List<String> names = new ArrayList<>();
    for (RapidCache rc : listResponse.iterateAll()) {
      names.add(rc.getName());
    }
    assertThat(names).contains(cacheName);

    // 5. Update RapidCache
    RapidCache toUpdate =
        RapidCache.newBuilder()
            .setName(cacheName)
            .setZone("europe-west1-c")
            .setCacheType("rapid-cache-ultra")
            .setTtl(Duration.newBuilder().setSeconds(172800).build()) // 48h
            .build();
    FieldMask updateMask = FieldMask.newBuilder().addPaths("ttl").build();
    RapidCache updated = controlClient.updateRapidCacheAsync(toUpdate, updateMask).get();
    assertThat(updated.getTtl().getSeconds()).isEqualTo(172800);

    // 6. Disable RapidCache
    RapidCache disabled = controlClient.disableRapidCacheAsync(cacheName).get();
    assertThat(disabled).isNotNull();
    assertThat(disabled.getName()).isEqualTo(cacheName);
    cacheDisabled = true;
  }

  @Test
  public void createRapidCache_invalidConfig() {
    String invalidCacheId = "invalid-cache-" + UUID.randomUUID().toString().substring(0, 8);
    String invalidCacheName =
        String.format("projects/_/buckets/%s/rapidCaches/%s", bucketName, invalidCacheId);

    RapidCache rapidCache =
        RapidCache.newBuilder()
            .setName(invalidCacheName)
            .setZone("invalid-zone")
            .setCacheType("rapid-cache-ultra")
            .build();

    ExecutionException thrown =
        assertThrows(
            ExecutionException.class,
            () ->
                controlClient
                    .createRapidCacheAsync(BucketName.format("_", bucketName), rapidCache)
                    .get());
    assertThat(thrown.getCause()).isInstanceOf(ApiException.class);
    ApiException apiException = (ApiException) thrown.getCause();
    // b/564257939: CreateRapidCache in Prod returns UNAVAILABLE instead of INVALID_ARGUMENT
    assertThat(apiException.getStatusCode().getCode())
        .isAnyOf(StatusCode.Code.INVALID_ARGUMENT, StatusCode.Code.UNAVAILABLE);
  }

  @Test
  public void getRapidCache_nonExistent() {
    String nonExistentCacheName =
        String.format("projects/_/buckets/%s/rapidCaches/non-existent-cache", bucketName);

    ApiException thrown =
        assertThrows(ApiException.class, () -> controlClient.getRapidCache(nonExistentCacheName));
    assertThat(thrown.getStatusCode().getCode()).isEqualTo(StatusCode.Code.NOT_FOUND);
  }
}
