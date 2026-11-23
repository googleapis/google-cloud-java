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

package com.google.cloud.storage;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.cloud.storage.BucketInfo.LifecycleRule;
import com.google.cloud.storage.BucketInfo.LifecycleRule.LifecycleAction;
import com.google.cloud.storage.BucketInfo.LifecycleRule.LifecycleCondition;
import com.google.cloud.storage.BucketInfo.LifecycleRule.SetStorageClassLifecycleAction;
import com.google.common.collect.ImmutableList;
import java.util.Arrays;
import org.junit.Test;

public class StorageClassTest {

  private static final ImmutableList<StorageClass> ENTERPRISE_STORAGE_CLASSES =
      ImmutableList.of(
          StorageClass.STANDARD_ENTERPRISE,
          StorageClass.LR_STANDARD_ENTERPRISE,
          StorageClass.STANDARD_FLEXBACKUP_ENTERPRISE);

  @Test
  public void testEnumInstances() {
    assertThat(StorageClass.STANDARD.toString()).isEqualTo("STANDARD");
    assertThat(StorageClass.NEARLINE.toString()).isEqualTo("NEARLINE");
    assertThat(StorageClass.COLDLINE.toString()).isEqualTo("COLDLINE");
    assertThat(StorageClass.ARCHIVE.toString()).isEqualTo("ARCHIVE");
    assertThat(StorageClass.REGIONAL.toString()).isEqualTo("REGIONAL");
    assertThat(StorageClass.MULTI_REGIONAL.toString()).isEqualTo("MULTI_REGIONAL");
    assertThat(StorageClass.DURABLE_REDUCED_AVAILABILITY.toString())
        .isEqualTo("DURABLE_REDUCED_AVAILABILITY");
    assertThat(StorageClass.STANDARD_ENTERPRISE.toString()).isEqualTo("STANDARD_ENTERPRISE");
    assertThat(StorageClass.LR_STANDARD_ENTERPRISE.toString()).isEqualTo("LR_STANDARD_ENTERPRISE");
    assertThat(StorageClass.STANDARD_FLEXBACKUP_ENTERPRISE.toString())
        .isEqualTo("STANDARD_FLEXBACKUP_ENTERPRISE");
  }

  @Test
  public void testValueOf() {
    assertThat(StorageClass.valueOf("STANDARD")).isSameInstanceAs(StorageClass.STANDARD);
    assertThat(StorageClass.valueOf("NEARLINE")).isSameInstanceAs(StorageClass.NEARLINE);
    assertThat(StorageClass.valueOf("COLDLINE")).isSameInstanceAs(StorageClass.COLDLINE);
    assertThat(StorageClass.valueOf("ARCHIVE")).isSameInstanceAs(StorageClass.ARCHIVE);
    assertThat(StorageClass.valueOf("REGIONAL")).isSameInstanceAs(StorageClass.REGIONAL);
    assertThat(StorageClass.valueOf("MULTI_REGIONAL"))
        .isSameInstanceAs(StorageClass.MULTI_REGIONAL);
    assertThat(StorageClass.valueOf("DURABLE_REDUCED_AVAILABILITY"))
        .isSameInstanceAs(StorageClass.DURABLE_REDUCED_AVAILABILITY);
    assertThat(StorageClass.valueOf("STANDARD_ENTERPRISE"))
        .isSameInstanceAs(StorageClass.STANDARD_ENTERPRISE);
    assertThat(StorageClass.valueOf("LR_STANDARD_ENTERPRISE"))
        .isSameInstanceAs(StorageClass.LR_STANDARD_ENTERPRISE);
    assertThat(StorageClass.valueOf("STANDARD_FLEXBACKUP_ENTERPRISE"))
        .isSameInstanceAs(StorageClass.STANDARD_FLEXBACKUP_ENTERPRISE);
    assertThat(StorageClass.valueOf("NonExistentStorageClass").toString())
        .isEqualTo("NonExistentStorageClass");
  }

  @Test
  public void testValueOfStrict() {
    assertThat(StorageClass.valueOfStrict("STANDARD")).isSameInstanceAs(StorageClass.STANDARD);
    assertThat(StorageClass.valueOfStrict("NEARLINE")).isSameInstanceAs(StorageClass.NEARLINE);
    assertThat(StorageClass.valueOfStrict("COLDLINE")).isSameInstanceAs(StorageClass.COLDLINE);
    assertThat(StorageClass.valueOfStrict("ARCHIVE")).isSameInstanceAs(StorageClass.ARCHIVE);
    assertThat(StorageClass.valueOfStrict("REGIONAL")).isSameInstanceAs(StorageClass.REGIONAL);
    assertThat(StorageClass.valueOfStrict("MULTI_REGIONAL"))
        .isSameInstanceAs(StorageClass.MULTI_REGIONAL);
    assertThat(StorageClass.valueOfStrict("DURABLE_REDUCED_AVAILABILITY"))
        .isSameInstanceAs(StorageClass.DURABLE_REDUCED_AVAILABILITY);
    assertThat(StorageClass.valueOfStrict("STANDARD_ENTERPRISE"))
        .isSameInstanceAs(StorageClass.STANDARD_ENTERPRISE);
    assertThat(StorageClass.valueOfStrict("LR_STANDARD_ENTERPRISE"))
        .isSameInstanceAs(StorageClass.LR_STANDARD_ENTERPRISE);
    assertThat(StorageClass.valueOfStrict("STANDARD_FLEXBACKUP_ENTERPRISE"))
        .isSameInstanceAs(StorageClass.STANDARD_FLEXBACKUP_ENTERPRISE);
  }

  @Test
  public void testValueOfStrict_invalid() {
    IllegalArgumentException ex =
        assertThrows(
            IllegalArgumentException.class,
            () -> StorageClass.valueOfStrict("NonExistentStorageClass"));
    assertThat(ex.getMessage()).isNotNull();
  }

  @Test
  public void testValues() {
    assertThat(Arrays.asList(StorageClass.values()))
        .containsAtLeast(
            StorageClass.STANDARD,
            StorageClass.NEARLINE,
            StorageClass.COLDLINE,
            StorageClass.ARCHIVE,
            StorageClass.REGIONAL,
            StorageClass.MULTI_REGIONAL,
            StorageClass.DURABLE_REDUCED_AVAILABILITY,
            StorageClass.STANDARD_ENTERPRISE,
            StorageClass.LR_STANDARD_ENTERPRISE,
            StorageClass.STANDARD_FLEXBACKUP_ENTERPRISE);
  }

  @Test
  public void testEnterpriseStorageClassJsonAndGrpcRoundTrip() {
    for (StorageClass storageClass : ENTERPRISE_STORAGE_CLASSES) {
      BucketInfo bucketInfo =
          BucketInfo.newBuilder("enterprise-bucket")
              .setStorageClass(storageClass)
              .setLifecycleRules(
                  ImmutableList.of(
                      new LifecycleRule(
                          LifecycleAction.newSetStorageClassAction(storageClass),
                          LifecycleCondition.newBuilder()
                              .setAge(10)
                              .setMatchesStorageClass(
                                  ImmutableList.of(StorageClass.STANDARD, storageClass))
                              .build())))
              .build();

      com.google.api.services.storage.model.Bucket jsonBucket =
          Conversions.json().bucketInfo().encode(bucketInfo);
      assertThat(jsonBucket.getStorageClass()).isEqualTo(storageClass.toString());
      BucketInfo decodedJsonBucket = Conversions.json().bucketInfo().decode(jsonBucket);
      assertThat(decodedJsonBucket.getStorageClass()).isSameInstanceAs(storageClass);
      LifecycleRule jsonRule = decodedJsonBucket.getLifecycleRules().get(0);
      assertThat(((SetStorageClassLifecycleAction) jsonRule.getAction()).getStorageClass())
          .isSameInstanceAs(storageClass);
      assertThat(jsonRule.getCondition().getMatchesStorageClass())
          .containsExactly(StorageClass.STANDARD, storageClass)
          .inOrder();

      com.google.storage.v2.Bucket grpcBucket = Conversions.grpc().bucketInfo().encode(bucketInfo);
      assertThat(grpcBucket.getStorageClass()).isEqualTo(storageClass.toString());
      BucketInfo decodedGrpcBucket = Conversions.grpc().bucketInfo().decode(grpcBucket);
      assertThat(decodedGrpcBucket.getStorageClass()).isSameInstanceAs(storageClass);
      LifecycleRule grpcRule = decodedGrpcBucket.getLifecycleRules().get(0);
      assertThat(((SetStorageClassLifecycleAction) grpcRule.getAction()).getStorageClass())
          .isSameInstanceAs(storageClass);
      assertThat(grpcRule.getCondition().getMatchesStorageClass())
          .containsExactly(StorageClass.STANDARD, storageClass)
          .inOrder();

      BlobInfo blobInfo =
          BlobInfo.newBuilder(BlobId.of("enterprise-bucket", "enterprise-object"))
              .setStorageClass(storageClass)
              .build();

      com.google.api.services.storage.model.StorageObject jsonBlob =
          Conversions.json().blobInfo().encode(blobInfo);
      assertThat(jsonBlob.getStorageClass()).isEqualTo(storageClass.toString());
      BlobInfo decodedJsonBlob = Conversions.json().blobInfo().decode(jsonBlob);
      assertThat(decodedJsonBlob.getStorageClass()).isSameInstanceAs(storageClass);

      com.google.storage.v2.Object grpcBlob = Conversions.grpc().blobInfo().encode(blobInfo);
      assertThat(grpcBlob.getStorageClass()).isEqualTo(storageClass.toString());
      BlobInfo decodedGrpcBlob = Conversions.grpc().blobInfo().decode(grpcBlob);
      assertThat(decodedGrpcBlob.getStorageClass()).isSameInstanceAs(storageClass);
    }
  }
}
