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
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public final class ITRapidCacheTest extends TestBase {

  private static final String CREATED_PREFIX = "Created Rapid Cache: ";
  // Poll for up to 2 minutes for the cache to reach the "disabled" state.
  private static final int DISABLE_POLL_ATTEMPTS = 12;
  private static final long DISABLE_POLL_INTERVAL_SECONDS = 10;
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
  private int outputOffset;

  @Before
  public void setUp() {
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
  }

  @After
  public void tearDown() throws InterruptedException {
    if (bucketName == null) {
      return;
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
    // Test create Rapid Cache
    RapidCacheCreate.rapidCacheCreate(bucketName, ZONE.getZone());
    String out = newOutput();
    assertThat(out).contains(CREATED_PREFIX);
    String cacheName =
        out.substring(out.indexOf(CREATED_PREFIX) + CREATED_PREFIX.length()).trim().split("\\s")[0];
    String cacheId = RapidCacheName.parse(cacheName).getRapidCache();
    assertThat(cacheId).isNotEmpty();

    Throwable failure = null;
    try {
      // Test get Rapid Cache
      RapidCacheGet.rapidCacheGet(bucketName, cacheId);
      out = newOutput();
      assertThat(out).contains(cacheName);
      assertThat(out).contains("Zone: " + ZONE.getZone());
      assertThat(out).contains("State: ");

      // Test list Rapid Caches
      RapidCacheList.rapidCacheList(bucketName);
      assertThat(newOutput()).contains(cacheName);

      // Test update Rapid Cache
      RapidCacheUpdate.rapidCacheUpdate(bucketName, cacheId, 172800);
      out = newOutput();
      assertThat(out).contains("Updated Rapid Cache: " + cacheName);
      assertThat(out).contains("TTL: 172800 seconds");
    } catch (Throwable t) {
      failure = t;
      throw t;
    } finally {
      // Disable the Rapid Cache. This also cleans up the cache so that the bucket can be deleted
      // once the cache has been fully removed.
      newOutput();
      try {
        RapidCacheDisable.rapidCacheDisable(bucketName, cacheId);
      } catch (Exception e) {
        if (failure == null) {
          throw e;
        }
        // Keep the original test failure as the primary error.
        failure.addSuppressed(e);
      }
    }

    // Test disable Rapid Cache
    String disableOut = newOutput();
    assertThat(disableOut).contains("Disabling Rapid Cache: " + cacheName);
    assertThat(disableOut).contains("Operation: ");

    // The cache moves to the "disabled" state shortly after the request.
    for (int i = 0; i < DISABLE_POLL_ATTEMPTS; i++) {
      RapidCacheGet.rapidCacheGet(bucketName, cacheId);
      out = newOutput();
      if (out.contains("State: disabled")) {
        break;
      }
      TimeUnit.SECONDS.sleep(DISABLE_POLL_INTERVAL_SECONDS);
    }
    assertThat(out).contains("State: disabled");
  }

  /** Returns the output captured since the previous call. */
  private String newOutput() {
    String all = stdOut.getCapturedOutputAsUtf8String();
    String out = all.substring(outputOffset);
    outputOffset = all.length();
    return out;
  }
}
