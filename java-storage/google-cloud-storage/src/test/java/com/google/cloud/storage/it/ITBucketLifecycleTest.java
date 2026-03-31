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

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.BucketInfo.LifecycleRule;
import com.google.cloud.storage.BucketInfo.LifecycleRule.AbortIncompleteMPUAction;
import com.google.cloud.storage.BucketInfo.LifecycleRule.LifecycleAction;
import com.google.cloud.storage.BucketInfo.LifecycleRule.LifecycleCondition;
import com.google.cloud.storage.BucketInfo.LifecycleRule.SetStorageClassLifecycleAction;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageClass;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.it.runner.StorageITRunner;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.CrossRun;
import com.google.cloud.storage.it.runner.annotations.Inject;
import com.google.cloud.storage.it.runner.registry.Generator;
import com.google.common.collect.ImmutableList;
import java.time.OffsetDateTime;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(StorageITRunner.class)
@CrossRun(
    transports = {Transport.HTTP, Transport.GRPC},
    backends = {Backend.PROD})
public class ITBucketLifecycleTest {

  private static final LifecycleRule LIFECYCLE_RULE_1 =
      new LifecycleRule(
          LifecycleAction.newSetStorageClassAction(StorageClass.COLDLINE),
          LifecycleCondition.newBuilder()
              .setAge(1)
              .setNumberOfNewerVersions(3)
              .setIsLive(false)
              .setMatchesStorageClass(ImmutableList.of(StorageClass.COLDLINE))
              .build());
  private static final LifecycleRule LIFECYCLE_RULE_2 =
      new LifecycleRule(
          LifecycleAction.newDeleteAction(), LifecycleCondition.newBuilder().setAge(1).build());
  private static final ImmutableList<LifecycleRule> LIFECYCLE_RULES =
      ImmutableList.of(LIFECYCLE_RULE_1, LIFECYCLE_RULE_2);

  @Inject public Storage storage;
  @Inject public Generator generator;

  @Test
  public void testGetBucketLifecycleRules() throws Exception {
    String lifecycleTestBucketName = generator.randomBucketName();
    BucketInfo bucketInfo =
        BucketInfo.newBuilder(lifecycleTestBucketName)
            .setLocation("us")
            .setLifecycleRules(
                ImmutableList.of(
                    new LifecycleRule(
                        LifecycleAction.newSetStorageClassAction(StorageClass.COLDLINE),
                        LifecycleCondition.newBuilder()
                            .setAge(1)
                            .setNumberOfNewerVersions(3)
                            .setIsLive(false)
                            .setCreatedBeforeOffsetDateTime(OffsetDateTime.now())
                            .setMatchesStorageClass(ImmutableList.of(StorageClass.COLDLINE))
                            .setDaysSinceNoncurrentTime(30)
                            .setNoncurrentTimeBeforeOffsetDateTime(OffsetDateTime.now())
                            .setCustomTimeBeforeOffsetDateTime(OffsetDateTime.now())
                            .setDaysSinceCustomTime(30)
                            .build())))
            .build();
    try (TemporaryBucket tempB =
        TemporaryBucket.newBuilder().setBucketInfo(bucketInfo).setStorage(storage).build()) {
      BucketInfo remoteBucket = tempB.getBucket();
      LifecycleRule lifecycleRule = remoteBucket.getLifecycleRules().get(0);
      assertThat(lifecycleRule.getAction().getActionType())
          .isEqualTo(SetStorageClassLifecycleAction.TYPE);
      assertEquals(3, lifecycleRule.getCondition().getNumberOfNewerVersions().intValue());
      assertNotNull(lifecycleRule.getCondition().getCreatedBeforeOffsetDateTime());
      assertFalse(lifecycleRule.getCondition().getIsLive());
      assertEquals(1, lifecycleRule.getCondition().getAge().intValue());
      assertEquals(1, lifecycleRule.getCondition().getMatchesStorageClass().size());
      assertEquals(30, lifecycleRule.getCondition().getDaysSinceNoncurrentTime().intValue());
      assertNotNull(lifecycleRule.getCondition().getNoncurrentTimeBeforeOffsetDateTime());
      assertEquals(30, lifecycleRule.getCondition().getDaysSinceCustomTime().intValue());
      assertNotNull(lifecycleRule.getCondition().getCustomTimeBeforeOffsetDateTime());
    }
  }

  @Test
  public void testGetBucketAbortMPULifecycle() throws Exception {
    String lifecycleTestBucketName = generator.randomBucketName();
    BucketInfo bucketInfo =
        BucketInfo.newBuilder(lifecycleTestBucketName)
            .setLocation("us")
            .setLifecycleRules(
                ImmutableList.of(
                    new LifecycleRule(
                        LifecycleAction.newAbortIncompleteMPUploadAction(),
                        LifecycleCondition.newBuilder().setAge(1).build())))
            .build();
    try (TemporaryBucket tempB =
        TemporaryBucket.newBuilder().setBucketInfo(bucketInfo).setStorage(storage).build()) {
      BucketInfo remoteBucket = tempB.getBucket();
      LifecycleRule lifecycleRule = remoteBucket.getLifecycleRules().get(0);
      assertEquals(AbortIncompleteMPUAction.TYPE, lifecycleRule.getAction().getActionType());
      assertEquals(1, lifecycleRule.getCondition().getAge().intValue());
    }
  }

  @Test
  public void testDeleteLifecycleRules() throws Exception {
    String bucketName = generator.randomBucketName();
    BucketInfo bucketInfo =
        BucketInfo.newBuilder(bucketName)
            .setLocation("us")
            .setLifecycleRules(LIFECYCLE_RULES)
            .build();
    try (TemporaryBucket tempB =
        TemporaryBucket.newBuilder().setBucketInfo(bucketInfo).setStorage(storage).build()) {
      BucketInfo bucket = tempB.getBucket();
      assertThat(bucket.getLifecycleRules()).isNotNull();
      assertThat(bucket.getLifecycleRules()).hasSize(2);
      BucketInfo updatedBucket = bucket.toBuilder().deleteLifecycleRules().build();
      storage.update(updatedBucket);
      assertThat(updatedBucket.getLifecycleRules()).hasSize(0);
    }
  }
}
