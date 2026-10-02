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
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeTrue;

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
import io.grpc.StatusException;
import io.grpc.StatusRuntimeException;
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
  private static RapidCache sharedCache;

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

    RapidCache rapidCache =
        RapidCache.newBuilder()
            .setName(cacheName)
            .setZone(cacheId)
            .setCacheType("rapid-cache-ultra")
            .setTtl(Duration.newBuilder().setSeconds(86400).build()) // 24 hours
            .build();
    sharedCache =
        controlClient.createRapidCacheAsync(BucketName.format("_", bucketName), rapidCache).get();
  }

  @AfterClass
  public static void tearDownClass() {
    if (controlClient != null && cacheName != null) {
      try {
        controlClient.disableRapidCacheAsync(cacheName).get();
      } catch (Exception e) {
        if (isUnimplemented(e)) {
          LOGGER.log(
              Level.WARNING,
              "DisableRapidCache is not yet supported over gRPC by the service (UNIMPLEMENTED)."
                  + " Skipping cleanup of cache: "
                  + cacheName);
        } else {
          LOGGER.log(Level.WARNING, "Failed to clean up rapid cache: " + e.getMessage());
        }
      }
    }
    if (storageClient != null && bucketName != null) {
      try {
        storageClient.delete(bucketName);
      } catch (Exception e) {
        LOGGER.log(
            Level.WARNING,
            "Failed to clean up bucket (expected if cache is still active): " + e.getMessage());
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

  // --- Independent CRUD and Negative Test Cases ---

  @Test
  public void createRapidCache() {
    assertThat(sharedCache).isNotNull();
    assertThat(sharedCache.getName()).isEqualTo(cacheName);
    assertThat(sharedCache.getZone()).isEqualTo(cacheId);
    assertThat(sharedCache.getCacheType()).isEqualTo("rapid-cache-ultra");
    assertThat(sharedCache.getState().toLowerCase()).isAnyOf("running", "active");
    assertThat(sharedCache.getTtl().getSeconds()).isEqualTo(86400);
  }

  @Test
  public void createDuplicateRapidCache() {
    RapidCache duplicateCache =
        RapidCache.newBuilder()
            .setName(cacheName)
            .setZone(cacheId)
            .setCacheType("rapid-cache-ultra")
            .setTtl(Duration.newBuilder().setSeconds(86400).build())
            .build();

    ExecutionException duplicateEx =
        assertThrows(
            ExecutionException.class,
            () ->
                controlClient
                    .createRapidCacheAsync(BucketName.format("_", bucketName), duplicateCache)
                    .get());
    assertThat(duplicateEx.getCause()).isInstanceOf(ApiException.class);
    ApiException duplicateApiException = (ApiException) duplicateEx.getCause();
    assertThat(duplicateApiException.getStatusCode().getCode())
        .isEqualTo(StatusCode.Code.ALREADY_EXISTS);
  }

  @Test
  public void getRapidCache() {
    RapidCache retrieved = controlClient.getRapidCache(cacheName);
    assertThat(retrieved).isNotNull();
    assertThat(retrieved.getName()).isEqualTo(cacheName);
    assertThat(retrieved.getZone()).isEqualTo(cacheId);
    assertThat(retrieved.getCacheType()).isEqualTo("rapid-cache-ultra");
    assertThat(retrieved.getState().toLowerCase()).isAnyOf("running", "active");
  }

  @Test
  public void listRapidCaches() {
    StorageControlClient.ListRapidCachesPagedResponse listResponse =
        controlClient.listRapidCaches(BucketName.format("_", bucketName));
    List<String> names = new ArrayList<>();
    for (RapidCache rc : listResponse.iterateAll()) {
      names.add(rc.getName());
    }
    assertThat(names).contains(cacheName);
  }

  @Test
  public void updateRapidCache() throws Exception {
    RapidCache toUpdate =
        RapidCache.newBuilder()
            .setName(cacheName)
            .setZone(cacheId)
            .setCacheType("rapid-cache-ultra")
            .setTtl(Duration.newBuilder().setSeconds(172800).build()) // 48h
            .build();
    FieldMask updateMask = FieldMask.newBuilder().addPaths("ttl").build();
    RapidCache updated = controlClient.updateRapidCacheAsync(toUpdate, updateMask).get();
    assertThat(updated).isNotNull();
    assertThat(updated.getTtl().getSeconds()).isEqualTo(172800);
  }

  @Test
  public void createAndDisableRapidCache() throws Exception {
    String isolatedBucket = "java-storage-rapid-" + UUID.randomUUID().toString().substring(0, 8);
    BucketInfo bucketInfo =
        BucketInfo.newBuilder(isolatedBucket)
            .setLocation("europe-west1")
            .setHierarchicalNamespace(HierarchicalNamespace.newBuilder().setEnabled(true).build())
            .setIamConfiguration(
                IamConfiguration.newBuilder().setIsUniformBucketLevelAccessEnabled(true).build())
            .build();
    storageClient.create(bucketInfo);

    try {
      Thread.sleep(20000);
      String isolatedCacheName =
          String.format("projects/_/buckets/%s/rapidCaches/%s", isolatedBucket, cacheId);
      RapidCache rapidCache =
          RapidCache.newBuilder()
              .setName(isolatedCacheName)
              .setZone(cacheId)
              .setCacheType("rapid-cache-ultra")
              .setTtl(Duration.newBuilder().setSeconds(86400).build())
              .build();

      RapidCache created =
          controlClient
              .createRapidCacheAsync(BucketName.format("_", isolatedBucket), rapidCache)
              .get();
      assertThat(created).isNotNull();
      assertThat(created.getName()).isEqualTo(isolatedCacheName);

      try {
        RapidCache disabled = controlClient.disableRapidCacheAsync(isolatedCacheName).get();
        assertThat(disabled).isNotNull();
        assertThat(disabled.getName()).isEqualTo(isolatedCacheName);
        assertThat(disabled.getState().toLowerCase()).isEqualTo("disabled");
      } catch (Exception e) {
        if (isUnimplemented(e)) {
          LOGGER.warning(
              "DisableRapidCache is not yet supported over gRPC by the service (UNIMPLEMENTED)."
                  + " Skipping assertion.");
          assumeTrue(
              "DisableRapidCache is not yet supported over gRPC by the service (UNIMPLEMENTED)",
              false);
        }
        throw e;
      }
    } finally {
      try {
        storageClient.delete(isolatedBucket);
      } catch (Exception e) {
        LOGGER.log(
            Level.WARNING,
            "Failed to clean up isolated bucket (expected if cache is still active): "
                + e.getMessage());
      }
    }
  }

  @Test
  public void disableRapidCache_nonExistent() throws Exception {
    String nonExistentCacheName =
        String.format("projects/_/buckets/%s/rapidCaches/non-existent-12345", bucketName);
    try {
      controlClient.disableRapidCacheAsync(nonExistentCacheName).get();
      fail("Expected ExecutionException");
    } catch (ExecutionException e) {
      if (isUnimplemented(e)) {
        LOGGER.warning(
            "DisableRapidCache is not yet supported over gRPC by the service (UNIMPLEMENTED)."
                + " Skipping assertion.");
        assumeTrue(
            "DisableRapidCache is not yet supported over gRPC by the service (UNIMPLEMENTED)",
            false);
      }
      assertThat(e.getCause()).isInstanceOf(ApiException.class);
      ApiException apiException = (ApiException) e.getCause();
      assertThat(apiException.getStatusCode().getCode()).isEqualTo(StatusCode.Code.NOT_FOUND);
    } catch (Exception e) {
      if (isUnimplemented(e)) {
        LOGGER.warning(
            "DisableRapidCache is not yet supported over gRPC by the service (UNIMPLEMENTED)."
                + " Skipping assertion.");
        assumeTrue(
            "DisableRapidCache is not yet supported over gRPC by the service (UNIMPLEMENTED)",
            false);
      }
      throw e;
    }
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
    assertThat(apiException.getStatusCode().getCode()).isEqualTo(StatusCode.Code.INVALID_ARGUMENT);
  }

  @Test
  public void getRapidCache_nonExistent() {
    String nonExistentCacheName =
        String.format("projects/_/buckets/%s/rapidCaches/non-existent-cache", bucketName);

    ApiException thrown =
        assertThrows(ApiException.class, () -> controlClient.getRapidCache(nonExistentCacheName));
    assertThat(thrown.getStatusCode().getCode()).isEqualTo(StatusCode.Code.NOT_FOUND);
  }

  private static boolean isUnimplemented(Throwable t) {
    if (t == null) {
      return false;
    }
    if (t instanceof ApiException) {
      return ((ApiException) t).getStatusCode().getCode() == StatusCode.Code.UNIMPLEMENTED;
    }
    if (t instanceof StatusRuntimeException) {
      return ((StatusRuntimeException) t).getStatus().getCode()
          == io.grpc.Status.Code.UNIMPLEMENTED;
    }
    if (t instanceof StatusException) {
      return ((StatusException) t).getStatus().getCode() == io.grpc.Status.Code.UNIMPLEMENTED;
    }
    if (t.getCause() != null && t.getCause() != t) {
      return isUnimplemented(t.getCause());
    }
    return false;
  }
}
