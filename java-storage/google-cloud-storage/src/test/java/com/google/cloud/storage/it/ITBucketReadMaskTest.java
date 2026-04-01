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

import com.google.api.gax.paging.Page;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BucketField;
import com.google.cloud.storage.Storage.BucketGetOption;
import com.google.cloud.storage.Storage.BucketListOption;
import com.google.cloud.storage.TestUtils;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.it.ITBucketReadMaskTest.BucketReadMaskTestParameters;
import com.google.cloud.storage.it.ReadMaskTestUtils.Args;
import com.google.cloud.storage.it.ReadMaskTestUtils.LazyAssertion;
import com.google.cloud.storage.it.runner.StorageITRunner;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.Inject;
import com.google.cloud.storage.it.runner.annotations.ParallelFriendly;
import com.google.cloud.storage.it.runner.annotations.Parameterized;
import com.google.cloud.storage.it.runner.annotations.Parameterized.Parameter;
import com.google.cloud.storage.it.runner.annotations.Parameterized.ParametersProvider;
import com.google.cloud.storage.it.runner.annotations.SingleBackend;
import com.google.cloud.storage.it.runner.annotations.StorageFixture;
import com.google.common.collect.ImmutableList;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(StorageITRunner.class)
@Parameterized(BucketReadMaskTestParameters.class)
@SingleBackend(value = Backend.PROD)
@ParallelFriendly
public final class ITBucketReadMaskTest {

  @Inject
  @StorageFixture(Transport.HTTP)
  public Storage sh;

  @Inject
  @StorageFixture(Transport.GRPC)
  public Storage sg;

  @Inject public BucketInfo bucket;

  @Parameter public Args<BucketField, BucketInfo> args;

  private BucketField field;
  private LazyAssertion<BucketInfo> assertion;

  @Before
  public void setUp() throws Exception {
    field = args.getField();
    assertion = args.getAssertion();
  }

  @Test
  public void get() {
    BucketInfo bucketJson = getBucket(sh);
    BucketInfo bucketGrpc = getBucket(sg);

    assertion.validate(bucketJson, bucketGrpc);
  }

  @Test
  public void list() {
    List<BucketInfo> bucketsJson = listBuckets(sh);
    List<BucketInfo> bucketsGrpc = listBuckets(sg);

    assertion.pairwiseList().validate(bucketsJson, bucketsGrpc);
  }

  public static final class BucketReadMaskTestParameters implements ParametersProvider {

    @Override
    public ImmutableList<?> parameters() {
      ImmutableList<Args<BucketField, BucketInfo>> args =
          ImmutableList.of(
              new Args<>(BucketField.PROJECT, LazyAssertion.equal()),
              new Args<>(BucketField.ACL, LazyAssertion.equal()),
              new Args<>(BucketField.AUTOCLASS, LazyAssertion.equal()),
              new Args<>(BucketField.BILLING, LazyAssertion.equal()),
              new Args<>(BucketField.CORS, LazyAssertion.equal()),
              new Args<>(BucketField.CUSTOM_PLACEMENT_CONFIG, LazyAssertion.equal()),
              new Args<>(
                  BucketField.DEFAULT_EVENT_BASED_HOLD,
                  (jsonT, grpcT) -> {
                    assertThat(jsonT.getDefaultEventBasedHold()).isNull();
                    assertThat(grpcT.getDefaultEventBasedHold()).isFalse();
                  }),
              new Args<>(BucketField.DEFAULT_OBJECT_ACL, LazyAssertion.equal()),
              new Args<>(BucketField.ENCRYPTION, LazyAssertion.equal()),
              new Args<>(BucketField.ETAG, LazyAssertion.equal()),
              new Args<>(BucketField.IAMCONFIGURATION, LazyAssertion.equal()),
              new Args<>(BucketField.ID, LazyAssertion.equal()),
              new Args<>(BucketField.IP_FILTER, LazyAssertion.equal()),
              new Args<>(BucketField.LABELS, LazyAssertion.equal()),
              new Args<>(BucketField.LIFECYCLE, LazyAssertion.equal()),
              new Args<>(BucketField.LOCATION, LazyAssertion.equal()),
              new Args<>(BucketField.LOCATION_TYPE, LazyAssertion.equal()),
              new Args<>(BucketField.LOGGING, LazyAssertion.equal()),
              new Args<>(BucketField.METAGENERATION, LazyAssertion.equal()),
              new Args<>(BucketField.NAME, LazyAssertion.equal()),
              new Args<>(BucketField.OWNER, LazyAssertion.equal()),
              new Args<>(BucketField.RETENTION_POLICY, LazyAssertion.equal()),
              new Args<>(BucketField.RPO, LazyAssertion.equal()),
              new Args<>(
                  BucketField.SELF_LINK,
                  (jsonT, grpcT) -> {
                    assertThat(jsonT.getSelfLink()).isNotEmpty();
                    assertThat(grpcT.getSelfLink()).isNull();
                  }),
              new Args<>(BucketField.STORAGE_CLASS, LazyAssertion.equal()),
              new Args<>(BucketField.TIME_CREATED, LazyAssertion.equal()),
              new Args<>(BucketField.UPDATED, LazyAssertion.equal()),
              new Args<>(BucketField.VERSIONING, LazyAssertion.equal()),
              new Args<>(BucketField.WEBSITE, LazyAssertion.equal()),
              new Args<>(
                  BucketField.SOFT_DELETE_POLICY,
                  (jsonT, grpcT) -> {
                    assertThat(
                        jsonT
                            .getSoftDeletePolicy()
                            .getRetentionDuration()
                            .equals(grpcT.getSoftDeletePolicy().getRetentionDuration()));
                    assertThat(
                        jsonT
                            .getSoftDeletePolicy()
                            .getEffectiveTime()
                            .truncatedTo(ChronoUnit.SECONDS)
                            .equals(
                                grpcT
                                    .getSoftDeletePolicy()
                                    .getEffectiveTime()
                                    .truncatedTo(ChronoUnit.SECONDS)));
                  }),
              new Args<>(BucketField.HIERARCHICAL_NAMESPACE, LazyAssertion.equal()));

      List<String> argsDefined =
          args.stream().map(Args::getField).map(Enum::name).sorted().collect(Collectors.toList());

      List<String> definedFields =
          Arrays.stream(TestUtils.filterOutHttpOnlyBucketFields(BucketField.values()))
              .map(Enum::name)
              .sorted()
              .collect(Collectors.toList());

      assertThat(argsDefined).containsExactlyElementsIn(definedFields);
      return args;
    }
  }

  private BucketInfo getBucket(Storage s) {
    return s.get(bucket.getName(), BucketGetOption.fields(field)).asBucketInfo();
  }

  private List<BucketInfo> listBuckets(Storage s) {
    Page<Bucket> p =
        s.list(BucketListOption.prefix(bucket.getName()), BucketListOption.fields(field));
    return StreamSupport.stream(p.iterateAll().spliterator(), false)
        .map(Bucket::asBucketInfo)
        .collect(Collectors.toList());
  }
}
