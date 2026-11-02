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

package com.example.storage.control.v2;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assume.assumeTrue;

import com.example.storage.TestBase;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.BucketInfo.HierarchicalNamespace;
import com.google.cloud.storage.BucketInfo.IamConfiguration;
import com.google.cloud.storage.StorageException;
import com.google.cloud.storage.it.runner.registry.Zone;
import com.google.cloud.storage.testing.RemoteStorageHelper;
import com.google.common.base.MoreObjects;
import com.google.common.base.Strings;
import com.google.storage.control.v2.RapidCacheName;
import com.google.storage.control.v2.StorageControlClient;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public final class ITRapidCacheTest extends TestBase {

  private static final String CACHE_TYPE = "rapid-cache-ultra";
  // Wait for the bucket metadata to propagate before creating the Rapid Cache.
  private static final long BUCKET_PROPAGATION_SECONDS = 20;
  // The disable operation only completes once the cache has been fully removed, which can take
  // more than an hour. The cache moves to the "disabled" state within seconds, so the test bounds
  // the wait and then checks the state instead.
  private static final long DISABLE_TIMEOUT_MINUTES = 10;
  // Bucket deletion is rejected while the Rapid Cache is still being removed.
  private static final long BUCKET_DELETE_TIMEOUT_SECONDS = 120;
  private static final long BUCKET_DELETE_INTERVAL_SECONDS = 15;

  // The zone in which to create the Rapid Cache. Override with the RAPID_CACHE_ZONE environment
  // variable.
  private static final Zone ZONE =
      Zone.parse(
          MoreObjects.firstNonNull(
              Strings.emptyToNull(System.getenv("RAPID_CACHE_ZONE")), "us-central1-a"));

  private String bucketName;
  // The Rapid Cache ID must be the same as the zone.
  private final String cacheId = ZONE.getZone();
  private boolean cacheDisabled;
  private int outputOffset;

  @Before
  public void setUp() throws InterruptedException {
    assumeTrue(
        "RapidCache sample tests skipped in CI due to very long operation times.",
        Strings.isNullOrEmpty(System.getenv("JOB_TYPE")));
    // Rapid Cache Ultra requires a regional bucket with hierarchical namespace enabled, located in
    // the same region as the cache zone.
    String name = RemoteStorageHelper.generateBucketName();
    storage.create(
        BucketInfo.newBuilder(name)
            .setLocation(ZONE.getRegion())
            .setIamConfiguration(
                // Hierarchical namespace buckets must use uniform bucket-level access.
                IamConfiguration.newBuilder().setIsUniformBucketLevelAccessEnabled(true).build())
            .setHierarchicalNamespace(HierarchicalNamespace.newBuilder().setEnabled(true).build())
            .build());
    bucketName = name;
    TimeUnit.SECONDS.sleep(BUCKET_PROPAGATION_SECONDS);
  }

  @After
  public void tearDown() throws InterruptedException {
    if (bucketName == null) {
      return;
    }
    if (!cacheDisabled) {
      disableQuietly();
    }
    // Best-effort cleanup. A bucket with a Rapid Cache cannot be deleted until the cache has been
    // fully removed, which can take a long time after it is disabled. Any leftover bucket is
    // removed by the stale bucket cleanup.
    long deadline = System.nanoTime() + TimeUnit.SECONDS.toNanos(BUCKET_DELETE_TIMEOUT_SECONDS);
    while (true) {
      try {
        storage.delete(bucketName);
        return;
      } catch (StorageException e) {
        if (e.getCode() != 409 || System.nanoTime() > deadline) {
          System.err.printf("Leaving bucket %s for cleanup: %s%n", bucketName, e.getMessage());
          return;
        }
        TimeUnit.SECONDS.sleep(BUCKET_DELETE_INTERVAL_SECONDS);
      }
    }
  }

  @Test
  public void createGetListUpdateDisable() throws Exception {
    String cacheName = RapidCacheName.format("_", bucketName, cacheId);

    // Test create Rapid Cache
    RapidCacheCreate.rapidCacheCreate(bucketName, ZONE.getZone());
    String out = newOutput();
    assertThat(out).contains("Created Rapid Cache: " + cacheName);
    assertThat(out).contains("Cache type: " + CACHE_TYPE);

    // Test get Rapid Cache
    RapidCacheGet.rapidCacheGet(bucketName, cacheId);
    out = newOutput();
    assertThat(out).contains("Got Rapid Cache: " + cacheName);
    assertThat(out).contains("Zone: " + ZONE.getZone());
    assertThat(out).contains("Cache type: " + CACHE_TYPE);
    assertThat(out).contains("State: running");

    // Test list Rapid Caches
    RapidCacheList.rapidCacheList(bucketName);
    assertThat(newOutput()).contains(cacheName);

    // Test update Rapid Cache
    RapidCacheUpdate.rapidCacheUpdate(bucketName, cacheId, 172800);
    out = newOutput();
    assertThat(out).contains("Updated Rapid Cache: " + cacheName);
    assertThat(out).contains("TTL: 172800 seconds");

    // Test disable Rapid Cache. The sample waits for the operation to complete, so run it with a
    // bounded wait.
    ExecutorService executor = Executors.newSingleThreadExecutor();
    try {
      Future<?> disable =
          executor.submit(
              () -> {
                RapidCacheDisable.rapidCacheDisable(bucketName, cacheId);
                return null;
              });
      try {
        disable.get(DISABLE_TIMEOUT_MINUTES, TimeUnit.MINUTES);
        cacheDisabled = true;
        assertThat(newOutput()).contains("Disabled Rapid Cache: " + cacheName);
      } catch (TimeoutException | ExecutionException e) {
        // A TimeoutException means our wait expired. A CancellationException means the client
        // stopped polling the operation (the default LRO polling timeout is 5 minutes). In both
        // cases the operation is still running on the server, and the cache must already be in
        // the "disabled" state. Any other error fails the test.
        if (e instanceof ExecutionException && !(e.getCause() instanceof CancellationException)) {
          throw e;
        }
        // Cancelling the local wait does not cancel the operation on the server.
        disable.cancel(true);
        cacheDisabled = true;
        newOutput();
        RapidCacheGet.rapidCacheGet(bucketName, cacheId);
        assertThat(newOutput()).contains("State: disabled");
      }
    } finally {
      executor.shutdownNow();
    }
  }

  /**
   * Used in teardown: starts disabling the Rapid Cache without waiting for the operation, ignoring
   * errors (for example, if the cache was never created).
   */
  private void disableQuietly() {
    try (StorageControlClient storageControl = StorageControlClient.create()) {
      storageControl
          .disableRapidCacheAsync(RapidCacheName.format("_", bucketName, cacheId))
          .getInitialFuture()
          .get(1, TimeUnit.MINUTES);
    } catch (Exception e) {
      System.err.printf("Failed to disable Rapid Cache in bucket %s: %s%n", bucketName, e);
    }
  }

  /** Returns the output captured since the previous call. */
  private String newOutput() {
    String all = stdOut.getCapturedOutputAsUtf8String();
    String out = all.substring(outputOffset);
    outputOffset = all.length();
    return out;
  }
}
