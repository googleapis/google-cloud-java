/*
 * Copyright 2025 Google LLC
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

import com.google.api.gax.paging.Page;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BucketListOption;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.it.runner.StorageITRunner;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.BucketFixture;
import com.google.cloud.storage.it.runner.annotations.BucketType;
import com.google.cloud.storage.it.runner.annotations.CrossRun;
import com.google.cloud.storage.it.runner.annotations.Inject;
import com.google.cloud.storage.it.runner.registry.Generator;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(StorageITRunner.class)
@CrossRun(
    backends = {Backend.TEST_BENCH},
    transports = {Transport.HTTP, Transport.GRPC})
public class ITListBucketTest {
  @Inject public Storage storage;

  @Inject public BucketInfo defaultBucket;

  @Inject public Generator generator;

  @Inject
  @BucketFixture(BucketType.HNS)
  public BucketInfo hnsBucket;

  private static final String UNREACHABLE_BUCKET_SUFFIX = ".unreachable";

  @Test
  public void testListBucketWithPartialSuccess() throws Exception {
    doTest(Reachability.Unreachable, BucketListOption.returnPartialSuccess(true));
  }

  @Test
  public void testListBucketWithoutPartialSuccess() throws Exception {
    doTest(Reachability.Reachable);
  }

  private void doTest(
      Reachability expectedReachabilityOfUnreachableBucket, BucketListOption... bucketListOption)
      throws Exception {
    // TESTBENCH considers a bucket to be unreachable if the bucket name contains "unreachable"
    String name = generator.randomBucketName() + UNREACHABLE_BUCKET_SUFFIX;
    BucketInfo info = BucketInfo.of(name);
    try (TemporaryBucket tmpBucket =
        TemporaryBucket.newBuilder().setBucketInfo(info).setStorage(storage).build()) {
      Map<String, Reachability> expected =
          ImmutableMap.of(
              defaultBucket.getName(), Reachability.Reachable,
              hnsBucket.getName(), Reachability.Reachable,
              tmpBucket.getBucket().getName(), expectedReachabilityOfUnreachableBucket);

      Page<Bucket> page = storage.list(bucketListOption);

      Map<String, Reachability> actual =
          page.streamAll().collect(Collectors.toMap(BucketInfo::getName, Reachability::forBucket));

      assertThat(actual).containsAtLeastEntriesIn(expected);
    }
  }

  private enum Reachability {
    Reachable,
    Unreachable;

    static Reachability forBucket(BucketInfo b) {
      if (b.isUnreachable() != null && b.isUnreachable()) {
        return Unreachable;
      } else {
        return Reachable;
      }
    }
  }
}
