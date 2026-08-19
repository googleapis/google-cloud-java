/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.storage.it.runner.registry;

import static org.junit.Assume.assumeTrue;

import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageException;
import com.google.cloud.storage.it.BucketCleaner;
import com.google.cloud.storage.it.runner.annotations.LocationType;
import com.google.protobuf.Duration;
import com.google.storage.control.v2.BucketName;
import com.google.storage.control.v2.RapidCache;
import com.google.storage.control.v2.StorageControlClient;
import java.util.Locale;

/** Shim to lift a BucketInfo to be a managed bucket instance */
final class BucketInfoShim implements ManagedLifecycle {

  private final BucketInfo bucketInfo;
  private final LocationType locationType;
  private final String targetZone;
  private final Storage s;
  private final StorageControlClient ctrl;

  private BucketInfo createdBucket;

  BucketInfoShim(BucketInfo bucketInfo, Storage s, StorageControlClient ctrl) {
    this(bucketInfo, LocationType.REGIONAL_STANDARD, null, s, ctrl);
  }

  BucketInfoShim(
      BucketInfo bucketInfo,
      LocationType locationType,
      String targetZone,
      Storage s,
      StorageControlClient ctrl) {
    this.bucketInfo = bucketInfo;
    this.locationType = locationType;
    this.targetZone = targetZone;
    this.s = s;
    this.ctrl = ctrl;
  }

  public BucketInfo getBucketInfo() {
    return createdBucket;
  }

  @Override
  public Object get() {
    return bucketInfo;
  }

  @Override
  public void start() {
    try {
      createdBucket = s.create(bucketInfo).asBucketInfo();
      if (locationType == LocationType.REGIONAL_RAPID) {
        if (ctrl == null) {
          throw new IllegalStateException(
              "StorageControlClient is required for REGIONAL_RAPID but was not provided");
        }
        String cacheName =
            String.format(
                Locale.US,
                "projects/_/buckets/%s/rapidCaches/%s",
                createdBucket.getName(),
                targetZone);
        RapidCache rapidCache =
            RapidCache.newBuilder()
                .setName(cacheName)
                .setZone(targetZone)
                .setCacheType("rapid-cache-ultra")
                .setTtl(Duration.newBuilder().setSeconds(86400).build()) // 24 hours
                .build();
        try {
          ctrl.createRapidCacheAsync(BucketName.format("_", createdBucket.getName()), rapidCache)
              .get();
        } catch (Exception e) {
          throw new RuntimeException("Failed to create Rapid Cache: " + e.getMessage(), e);
        }
      }
    } catch (StorageException se) {
      String msg = se.getMessage().toLowerCase(Locale.US);
      if (se.getCode() == 400 && (msg.contains("not a valid zone in location"))
          || msg.contains("custom placement config")
          || msg.contains("zonal")) {
        assumeTrue(
            "Skipping test due to bucket setup unavailable in current zone. (" + msg + ")", false);
      }
      throw se;
    }
  }

  @Override
  public void stop() {
    BucketCleaner.doCleanup(bucketInfo.getName(), s /*, ctrl*/);
  }
}
