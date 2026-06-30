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

package com.google.cloud.storage.it;

import static java.util.Objects.requireNonNull;

import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.conformance.retry.CleanupStrategy;
import com.google.common.base.Preconditions;
import com.google.storage.control.v2.StorageControlClient;
import java.time.Duration;
import org.checkerframework.checker.nullness.qual.Nullable;

public final class TemporaryBucket implements AutoCloseable {

  private final BucketInfo bucket;
  private final Storage storage;
  @Nullable private final StorageControlClient ctrl;
  private final Duration cleanupTimeout;
  private final CleanupStrategy cleanupStrategy;

  private TemporaryBucket(
      BucketInfo bucket,
      Storage storage,
      @Nullable StorageControlClient ctrl,
      Duration cleanupTimeout,
      CleanupStrategy cleanupStrategy) {
    this.bucket = bucket;
    this.storage = storage;
    this.ctrl = ctrl;
    this.cleanupTimeout = cleanupTimeout;
    this.cleanupStrategy = cleanupStrategy;
  }

  /** Return the BucketInfo from the created temporary bucket. */
  public BucketInfo getBucket() {
    return bucket;
  }

  @Override
  public void close() throws Exception {
    if (cleanupStrategy == CleanupStrategy.ALWAYS) {
      if (ctrl != null) {
        BucketCleaner.doCleanup(bucket.getName(), storage, ctrl);
      } else {
        BucketCleaner.doCleanup(bucket.getName(), storage);
      }
    }
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static final class Builder {

    private CleanupStrategy cleanupStrategy;
    private Duration cleanupTimeoutDuration;
    private BucketInfo bucketInfo;
    private Storage storage;
    private StorageControlClient ctrl;

    private Builder() {
      this.cleanupStrategy = CleanupStrategy.ALWAYS;
      this.cleanupTimeoutDuration = Duration.ofMinutes(1);
    }

    public Builder setCleanupStrategy(CleanupStrategy cleanupStrategy) {
      this.cleanupStrategy = cleanupStrategy;
      return this;
    }

    public Builder setCleanupTimeoutDuration(Duration cleanupTimeoutDuration) {
      this.cleanupTimeoutDuration = cleanupTimeoutDuration;
      return this;
    }

    public Builder setBucketInfo(BucketInfo bucketInfo) {
      this.bucketInfo = bucketInfo;
      return this;
    }

    public Builder setStorage(Storage storage) {
      this.storage = storage;
      return this;
    }

    public Builder setStorageControlClient(StorageControlClient ctrl) {
      this.ctrl = ctrl;
      return this;
    }

    public TemporaryBucket build() {
      Preconditions.checkArgument(
          cleanupStrategy != CleanupStrategy.ONLY_ON_SUCCESS, "Unable to detect success.");
      Storage s = requireNonNull(storage, "storage must be non null");
      Bucket b = s.create(requireNonNull(bucketInfo, "bucketInfo must be non null"));

      // intentionally drop from Bucket to BucketInfo to ensure not leaking the Storage instance
      return new TemporaryBucket(
          b.asBucketInfo(), s, ctrl, cleanupTimeoutDuration, cleanupStrategy);
    }
  }
}
