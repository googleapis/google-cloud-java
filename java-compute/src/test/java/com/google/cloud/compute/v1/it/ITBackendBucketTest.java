/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1.it;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertFalse;

import com.google.cloud.compute.v1.BackendBucket;
import com.google.cloud.compute.v1.BackendBucketClient;
import com.google.cloud.compute.v1.BackendBucketSettings;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.ProjectGlobalBackendBucketName;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.testing.RemoteStorageHelper;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITBackendBucketTest extends BaseTest {
  private static final Logger LOGGER = Logger.getLogger(ITBackendBucketTest.class.getName());

  private static final String BUCKET = RemoteStorageHelper.generateBucketName();
  private static final String BACKEND_BUCKET_NAME = TestHelper.getTestUniqueName("backend-bucket");
  private static final ProjectGlobalBackendBucketName PROJECT_BACKEND_BUCKET_NAME =
      ProjectGlobalBackendBucketName.of(BACKEND_BUCKET_NAME, DEFAULT_PROJECT);
  private static final String BACKEND_BUCKET_TARGET_LINK =
      String.format("%s/global/backendBuckets/%s", PROJECT_LINK, BACKEND_BUCKET_NAME);

  private static BackendBucketClient backendBucketClient;
  private static Storage storage;

  private static ListMultimap<String, String> resourcesToCleanUp = ArrayListMultimap.create();

  @BeforeClass
  public static void setUp() throws IOException {
    BackendBucketSettings backendBucketSettings =
        BackendBucketSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
    backendBucketClient = BackendBucketClient.create(backendBucketSettings);
    RemoteStorageHelper storageHelper = RemoteStorageHelper.create();

    storage = storageHelper.getOptions().getService();
    storage.create(BucketInfo.of(BUCKET));
    BackendBucket backendBucketResource =
        BackendBucket.newBuilder().setName(BACKEND_BUCKET_NAME).setBucketName(BUCKET).build();
    Operation completedOperation =
        waitForOperation(
            backendBucketClient.insertBackendBucket(PROJECT_NAME, backendBucketResource));
    resourcesToCleanUp.put("backend-bucket", completedOperation.getTargetLink());
  }

  @AfterClass
  public static void tearDown() throws ExecutionException, InterruptedException {
    for (String backendBucket : resourcesToCleanUp.get("backend-bucket")) {
      waitForOperation(backendBucketClient.deleteBackendBucket(backendBucket));
    }
    backendBucketClient.close();
    if (storage != null) {
      boolean wasDeleted = RemoteStorageHelper.forceDelete(storage, BUCKET, 10, TimeUnit.SECONDS);
      if (!wasDeleted && LOGGER.isLoggable(Level.WARNING)) {
        LOGGER.log(Level.WARNING, "Deletion of bucket {0} timed out, bucket is not empty", BUCKET);
      }
    }
  }

  @Test
  public void getBackendBucketTest() {
    BackendBucket backendBucket = backendBucketClient.getBackendBucket(PROJECT_BACKEND_BUCKET_NAME);
    assertThat(backendBucket).isNotNull();
    assertThat(backendBucket.getName()).isEqualTo(BACKEND_BUCKET_NAME);
    assertThat(backendBucket.getBucketName()).isEqualTo(BUCKET);
    assertThat(backendBucket.getSelfLink()).isEqualTo(BACKEND_BUCKET_TARGET_LINK);
    assertThat(backendBucket.getEnableCdn()).isFalse();
  }

  @Test
  public void listBackendBucketsTest() {
    List<BackendBucket> backendBuckets =
        Lists.newArrayList(backendBucketClient.listBackendBuckets(PROJECT_NAME).iterateAll());
    assertThat(backendBuckets).isNotNull();
    assertThat(backendBuckets.size()).isGreaterThan(0);
    assertFalse(backendBuckets.contains(null));
    for (BackendBucket backendBucket : backendBuckets) {
      if (BUCKET.equals(backendBucket.getBucketName())) {
        assertThat(backendBucket.getName()).isEqualTo(BACKEND_BUCKET_NAME);
        assertThat(backendBucket.getBucketName()).isEqualTo(BUCKET);
        assertThat(backendBucket.getSelfLink()).isEqualTo(BACKEND_BUCKET_TARGET_LINK);
        assertThat(backendBucket.getEnableCdn()).isFalse();
      }
    }
  }
}
