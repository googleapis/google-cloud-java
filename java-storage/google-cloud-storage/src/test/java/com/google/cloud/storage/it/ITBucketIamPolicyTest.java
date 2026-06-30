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

import com.google.cloud.Binding;
import com.google.cloud.Condition;
import com.google.cloud.Identity;
import com.google.cloud.Policy;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BucketSourceOption;
import com.google.cloud.storage.StorageRoles;
import com.google.cloud.storage.TestUtils;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.it.runner.StorageITRunner;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.CrossRun;
import com.google.cloud.storage.it.runner.annotations.Inject;
import com.google.cloud.storage.it.runner.annotations.ParallelFriendly;
import com.google.cloud.storage.it.runner.registry.Generator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(StorageITRunner.class)
@CrossRun(
    transports = {Transport.HTTP, Transport.GRPC},
    backends = {Backend.PROD})
@ParallelFriendly
public final class ITBucketIamPolicyTest {
  @Inject public Storage storage;

  @Inject public BucketInfo bucketInfo;

  @Inject public Generator generator;

  private Identity projectOwner;
  private Identity projectEditor;
  private Identity projectViewer;

  @Before
  public void setUp() throws Exception {
    String projectId = storage.getOptions().getProjectId();
    projectOwner = Identity.projectOwner(projectId);
    projectEditor = Identity.projectEditor(projectId);
    projectViewer = Identity.projectViewer(projectId);
  }

  /**
   * In order to define an IAM Condition, policy version 3 and Uniform Bucket Level Access must both
   * be used.
   *
   * <p>Define a policy with a condition and verify it can be read back and decoded equivalently.
   */
  @Test
  public void iamPolicyWithCondition() throws Exception {
    BucketSourceOption opt = BucketSourceOption.requestedPolicyVersion(3);
    Policy policy =
        Policy.newBuilder()
            .setVersion(3)
            .setBindings(
                ImmutableList.of(
                    Binding.newBuilder()
                        .setRole(StorageRoles.legacyBucketReader().toString())
                        .setMembers(ImmutableList.of(projectViewer.strValue()))
                        .build(),
                    Binding.newBuilder()
                        .setRole(StorageRoles.legacyBucketOwner().toString())
                        .setMembers(
                            ImmutableList.of(projectEditor.strValue(), projectOwner.strValue()))
                        .build(),
                    Binding.newBuilder()
                        .setRole(StorageRoles.legacyObjectReader().toString())
                        .setMembers(
                            ImmutableList.of(
                                "serviceAccount:storage-python@spec-test-ruby-samples.iam.gserviceaccount.com"))
                        .setCondition(
                            Condition.newBuilder()
                                .setTitle("Title")
                                .setDescription("Description")
                                .setExpression(
                                    "resource.name.startsWith(\"projects/_/buckets/bucket-name/objects/prefix-a-\")")
                                .build())
                        .build()))
            .build();

    try (TemporaryBucket tempB =
        TemporaryBucket.newBuilder()
            .setBucketInfo(
                // create a bucket with UBLA set to true
                BucketInfo.newBuilder(generator.randomBucketName())
                    .setIamConfiguration(
                        BucketInfo.IamConfiguration.newBuilder()
                            .setIsUniformBucketLevelAccessEnabled(true)
                            .build())
                    .build())
            .setStorage(storage)
            .build()) {
      BucketInfo bucket = tempB.getBucket();
      String bucketName = bucket.getName();

      // Set the policy on the bucket
      Policy setResult =
          storage.setIamPolicy(
              bucketName,
              policy,
              BucketSourceOption.metagenerationMatch(bucket.getMetageneration()),
              opt);
      assertPolicyEqual(policy, setResult);

      Policy actual = storage.getIamPolicy(bucketName, opt);
      assertPolicyEqual(policy, actual);
    }
  }

  @Test
  public void iamPolicyWithoutCondition() throws Exception {
    BucketSourceOption opt = BucketSourceOption.requestedPolicyVersion(1);
    Policy policy =
        Policy.newBuilder()
            .setVersion(1)
            .setBindings(
                ImmutableMap.of(
                    StorageRoles.legacyBucketOwner(),
                    ImmutableSet.of(projectOwner, projectEditor),
                    StorageRoles.legacyBucketReader(),
                    ImmutableSet.of(projectViewer)))
            .build();

    try (TemporaryBucket tempB =
        TemporaryBucket.newBuilder()
            .setBucketInfo(
                // create a bucket without UBLA
                BucketInfo.newBuilder(generator.randomBucketName())
                    .setIamConfiguration(
                        BucketInfo.IamConfiguration.newBuilder()
                            .setIsUniformBucketLevelAccessEnabled(false)
                            .build())
                    .build())
            .setStorage(storage)
            .build()) {
      BucketInfo bucket = tempB.getBucket();
      String bucketName = bucket.getName();

      // Set the policy on the bucket
      Policy setResult =
          storage.setIamPolicy(
              bucketName,
              policy,
              BucketSourceOption.metagenerationMatch(bucket.getMetageneration()),
              opt);
      assertPolicyEqual(policy, setResult);

      Policy actual = storage.getIamPolicy(bucketName, opt);
      assertPolicyEqual(policy, actual);
    }
  }

  @Test
  public void testIamPermissions() {
    List<Boolean> expectedResult = ImmutableList.of(true, true);
    ImmutableList<String> permissions =
        ImmutableList.of("storage.buckets.getIamPolicy", "storage.buckets.setIamPolicy");
    List<Boolean> actual = storage.testIamPermissions(bucketInfo.getName(), permissions);
    assertThat(actual).isEqualTo(expectedResult);
  }

  private static void assertPolicyEqual(Policy expected, Policy actual) throws Exception {
    TestUtils.assertAll(
        () -> assertThat(actual.getVersion()).isEqualTo(expected.getVersion()),
        () -> assertBindingsEqual(expected.getBindingsList(), actual.getBindingsList()));
  }

  private static void assertBindingsEqual(List<Binding> expected, List<Binding> actual) {

    // pre-stringify the value to be compared to make it easier to diff if there is a failure
    // ordering is not necessarily maintained across RPCs, after stringification sort before
    // comparison
    String e = stringifyBindings(expected);
    String a = stringifyBindings(actual);

    assertThat(a).isEqualTo(e);
  }

  private static String stringifyBindings(List<Binding> bindings) {
    Collector<CharSequence, ?, String> joining = Collectors.joining(",\n\t", "[\n\t", "\n]");
    // ordering is not necessarily maintained across RPCs
    // Sort any lists before stringification
    return bindings.stream()
        .map(
            b -> {
              Binding.Builder builder = b.toBuilder();
              builder.setRole(b.getRole());
              builder.setCondition(b.getCondition());
              builder.setMembers(
                  b.getMembers().stream().sorted().collect(ImmutableList.toImmutableList()));
              return builder.build();
            })
        .map(Object::toString)
        .sorted()
        .collect(joining);
  }
}
