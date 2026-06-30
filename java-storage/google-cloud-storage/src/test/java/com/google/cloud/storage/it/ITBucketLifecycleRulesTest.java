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

import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.BucketInfo.LifecycleRule;
import com.google.cloud.storage.BucketInfo.LifecycleRule.LifecycleAction;
import com.google.cloud.storage.BucketInfo.LifecycleRule.LifecycleCondition;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BucketTargetOption;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.it.runner.StorageITRunner;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.CrossRun;
import com.google.cloud.storage.it.runner.annotations.Inject;
import com.google.cloud.storage.it.runner.registry.Generator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(StorageITRunner.class)
@CrossRun(
    transports = {Transport.HTTP, Transport.GRPC},
    backends = {Backend.PROD})
public final class ITBucketLifecycleRulesTest {

  @Inject public Generator generator;

  @Inject public Storage storage;

  @Test
  public void deleteRule_addingALabelToABucketWithASingleDeleteRuleOnlyModifiesTheLabels()
      throws Exception {
    LifecycleRule d1 =
        new LifecycleRule(
            LifecycleAction.newDeleteAction(),
            LifecycleCondition.newBuilder()
                .setMatchesPrefix(ImmutableList.of("pre"))
                .setMatchesSuffix(ImmutableList.of("suf"))
                .setAge(50)
                .build());
    BucketInfo info = baseInfo().setLifecycleRules(ImmutableList.of(d1)).build();

    try (TemporaryBucket tmp =
        TemporaryBucket.newBuilder().setBucketInfo(info).setStorage(storage).build()) {
      BucketInfo bucket = tmp.getBucket();
      assertThat(bucket.getLabels()).isNull();

      ImmutableMap<String, String> labels = ImmutableMap.of("label1", "val1");
      BucketInfo withLabels = bucket.toBuilder().setLabels(labels).build();
      Bucket update = storage.update(withLabels, BucketTargetOption.metagenerationMatch());
      assertThat(update.getLabels()).isEqualTo(labels);
      assertThat(update.getLifecycleRules()).isEqualTo(ImmutableList.of(d1));
    }
  }

  @Test
  public void condition_ageDays_0_shouldWork() throws Exception {
    LifecycleRule d1 =
        new LifecycleRule(
            LifecycleAction.newAbortIncompleteMPUploadAction(),
            LifecycleCondition.newBuilder().setAge(0).build());
    BucketInfo info = baseInfo().setLifecycleRules(ImmutableList.of(d1)).build();

    try (TemporaryBucket tmp =
        TemporaryBucket.newBuilder().setBucketInfo(info).setStorage(storage).build()) {
      BucketInfo bucket = tmp.getBucket();
      Bucket update = storage.get(bucket.getName());
      assertThat(update.getLifecycleRules()).isEqualTo(ImmutableList.of(d1));
    }
  }

  @Test
  public void deleteRule_modifyingLifecycleRulesMatchesLastOperation() throws Exception {
    BucketInfo info;
    {
      LifecycleRule d1 =
          new LifecycleRule(
              LifecycleAction.newDeleteAction(),
              LifecycleCondition.newBuilder()
                  .setMatchesPrefix(ImmutableList.of("pre"))
                  .setMatchesSuffix(ImmutableList.of("suf"))
                  .setAge(50)
                  .build());
      info = baseInfo().setLifecycleRules(ImmutableList.of(d1)).build();
    }

    try (TemporaryBucket tmp =
        TemporaryBucket.newBuilder().setBucketInfo(info).setStorage(storage).build()) {
      BucketInfo bucket = tmp.getBucket();

      ImmutableList<LifecycleRule> newRules =
          bucket.getLifecycleRules().stream()
              .map(
                  r -> {
                    if (r.getAction().equals(LifecycleAction.newDeleteAction())) {
                      LifecycleCondition condition = r.getCondition();
                      LifecycleCondition.Builder b = condition.toBuilder();
                      b.setMatchesPrefix(
                          ImmutableList.<String>builder()
                              .addAll(condition.getMatchesPrefix())
                              .add("a")
                              .build());
                      b.setMatchesSuffix(
                          ImmutableList.<String>builder()
                              .addAll(condition.getMatchesSuffix())
                              .add("z")
                              .build());
                      return new LifecycleRule(LifecycleAction.newDeleteAction(), b.build());
                    } else {
                      return r;
                    }
                  })
              .collect(ImmutableList.toImmutableList());

      BucketInfo modifiedRules = bucket.toBuilder().setLifecycleRules(newRules).build();
      Bucket update = storage.update(modifiedRules, BucketTargetOption.metagenerationMatch());
      assertThat(update.getLifecycleRules()).isEqualTo(newRules);
    }
  }

  private BucketInfo.Builder baseInfo() {
    return BucketInfo.newBuilder(generator.randomBucketName());
  }
}
