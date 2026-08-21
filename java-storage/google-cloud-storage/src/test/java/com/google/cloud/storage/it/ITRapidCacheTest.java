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
import static org.junit.Assert.fail;

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
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ITRapidCacheTest {

  private static final String PROJECT_ID = "gcs-hyd-connector-benchmarks";
  private static StorageControlClient controlClient;
  private static Storage storageClient;
  private static String bucketName;

  // Shared Cache Details
  private static String cacheId;
  private static String cacheName;

  @BeforeClass
  public static void setUpClass() throws Exception {
    // Initialize standard Storage client for preprod (gRPC)
    storageClient =
        StorageOptions.grpc()
            .setProjectId(PROJECT_ID)
            .setHost("storage-preprod-test-grpc.googleusercontent.com:443")
            .build()
            .getService();

    // Initialize StorageControl client for preprod (gRPC)
    StorageControlSettings controlSettings =
        StorageControlSettings.newBuilder()
            .setEndpoint("storage-preprod-test-grpc.googleusercontent.com:443")
            .build();
    controlClient = StorageControlClient.create(controlSettings);

    // Create HNS enabled regional bucket in preprod us-central1
    bucketName = "java-storage-preprod-rapid-" + UUID.randomUUID().toString().substring(0, 8);
    BucketInfo bucketInfo =
        BucketInfo.newBuilder(bucketName)
            .setLocation("us-central1")
            .setHierarchicalNamespace(HierarchicalNamespace.newBuilder().setEnabled(true).build())
            .setIamConfiguration(
                IamConfiguration.newBuilder().setIsUniformBucketLevelAccessEnabled(true).build())
            .build();
    storageClient.create(bucketInfo);

    // Define shared cache ID (forced to be the zone name by the backend)
    cacheId = "us-central1-a";
    cacheName = String.format("projects/_/buckets/%s/rapidCaches/%s", bucketName, cacheId);
  }

  @AfterClass
  public static void tearDownClass() throws Exception {
    if (storageClient != null && bucketName != null) {
      try {
        storageClient.delete(bucketName);
      } catch (Exception e) {
        System.err.println("Failed to clean up preprod bucket: " + e.getMessage());
      }
    }
    if (controlClient != null) {
      controlClient.close();
    }
  }

  // --- Test Cases (Alphabetical Sort Order matches Logical Lifecycle) ---

  @Test
  public void createRapidCache() throws Exception {
    RapidCache rapidCache =
        RapidCache.newBuilder()
            .setName(cacheName)
            .setZone("us-central1-a")
            .setCacheType("rapid-cache-ultra")
            .setTtl(Duration.newBuilder().setSeconds(86400).build()) // 24 hours
            .build();

    RapidCache created =
        controlClient.createRapidCacheAsync(BucketName.format("_", bucketName), rapidCache).get();

    assertThat(created).isNotNull();
    assertThat(created.getName()).isEqualTo(cacheName);
    assertThat(created.getState()).isEqualTo("running");
  }

  @Test
  public void createRapidCache_duplicate() throws Exception {
    RapidCache rapidCache =
        RapidCache.newBuilder()
            .setName(cacheName) // Use the same name as the shared cache
            .setZone("us-central1-a")
            .setCacheType("rapid-cache-ultra")
            .build();

    try {
      controlClient.createRapidCacheAsync(BucketName.format("_", bucketName), rapidCache).get();
      fail("Expected AlreadyExists exception");
    } catch (ExecutionException e) {
      assertThat(e.getCause()).isInstanceOf(ApiException.class);
      ApiException apiException = (ApiException) e.getCause();
      assertThat(apiException.getStatusCode().getCode()).isEqualTo(StatusCode.Code.ALREADY_EXISTS);
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

    try {
      controlClient.createRapidCacheAsync(BucketName.format("_", bucketName), rapidCache).get();
      fail("Expected InvalidArgument exception");
    } catch (ExecutionException e) {
      assertThat(e.getCause()).isInstanceOf(ApiException.class);
      ApiException apiException = (ApiException) e.getCause();
      assertThat(apiException.getStatusCode().getCode())
          .isEqualTo(StatusCode.Code.INVALID_ARGUMENT);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      fail("Interrupted");
    }
  }

  @Test
  public void getRapidCache() throws Exception {
    RapidCache retrieved = controlClient.getRapidCache(cacheName);
    assertThat(retrieved).isNotNull();
    assertThat(retrieved.getName()).isEqualTo(cacheName);
    assertThat(retrieved.getState()).isEqualTo("running");
  }

  @Test
  public void getRapidCache_nonExistent() {
    String nonExistentCacheName =
        String.format("projects/_/buckets/%s/rapidCaches/non-existent-cache", bucketName);

    try {
      controlClient.getRapidCache(nonExistentCacheName);
      fail("Expected NotFound exception");
    } catch (ApiException e) {
      assertThat(e.getStatusCode().getCode()).isEqualTo(StatusCode.Code.NOT_FOUND);
    }
  }

  @Test
  public void listRapidCaches() throws Exception {
    StorageControlClient.ListRapidCachesPagedResponse response =
        controlClient.listRapidCaches(BucketName.format("_", bucketName));

    List<String> names = new ArrayList<>();
    for (RapidCache rc : response.iterateAll()) {
      names.add(rc.getName());
    }

    assertThat(names).contains(cacheName);
  }

  @Test
  @Ignore("b/483013082: UpdateRapidCache returns 500 Internal error in PreProd")
  public void updateRapidCache() throws Exception {
    RapidCache toUpdate =
        RapidCache.newBuilder()
            .setName(cacheName)
            .setZone("us-central1-a")
            .setCacheType("rapid-cache-ultra")
            .setTtl(Duration.newBuilder().setSeconds(172800).build()) // 48h
            .build();

    FieldMask updateMask = FieldMask.newBuilder().addPaths("ttl").build();

    // No try-catch wrapping of ExecutionException. Let the test fail naturally if update fails.
    RapidCache updated = controlClient.updateRapidCacheAsync(toUpdate, updateMask).get();
    assertThat(updated.getTtl().getSeconds()).isEqualTo(172800);
  }
}
