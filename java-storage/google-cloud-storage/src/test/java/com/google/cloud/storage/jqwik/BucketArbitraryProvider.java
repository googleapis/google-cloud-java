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

package com.google.cloud.storage.jqwik;

import static com.google.cloud.storage.PackagePrivateMethodWorkarounds.ifNonNull;

import com.google.cloud.storage.jqwik.StorageArbitraries.ProjectNumber;
import com.google.storage.v2.Bucket;
import com.google.storage.v2.BucketName;
import com.google.storage.v2.ProjectName;
import java.util.Collections;
import java.util.Set;
import javax.annotation.ParametersAreNonnullByDefault;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.Combinators;
import net.jqwik.api.Tuple;
import net.jqwik.api.providers.ArbitraryProvider;
import net.jqwik.api.providers.TypeUsage;
import org.checkerframework.checker.nullness.qual.NonNull;

@ParametersAreNonnullByDefault
public final class BucketArbitraryProvider implements ArbitraryProvider {

  @Override
  public boolean canProvideFor(TypeUsage targetType) {
    return targetType.isOfType(Bucket.class);
  }

  @NonNull
  @Override
  public Set<Arbitrary<?>> provideFor(TypeUsage targetType, SubtypeProvider subtypeProvider) {
    Arbitrary<Bucket> as =
        Combinators.combine(
                Combinators.combine(
                        StorageArbitraries.buckets().name(),
                        StorageArbitraries.buckets().name(),
                        StorageArbitraries.storageClass(),
                        StorageArbitraries.buckets().location(),
                        StorageArbitraries.buckets().locationType(),
                        StorageArbitraries.metageneration(),
                        StorageArbitraries.buckets().versioning().injectNull(0.25),
                        StorageArbitraries.timestamp().injectNull(0.25)) // ctime
                    .as(Tuple::of),
                Combinators.combine(
                        StorageArbitraries.timestamp().injectNull(0.25), // utime
                        StorageArbitraries.buckets().website().injectNull(0.75),
                        StorageArbitraries.bool(),
                        StorageArbitraries.buckets().rpo(),
                        StorageArbitraries.buckets().billing().injectNull(0.01),
                        StorageArbitraries.buckets().encryption(),
                        StorageArbitraries.buckets().retentionPolicy().injectNull(0.5),
                        StorageArbitraries.buckets().lifecycle().injectNull(0.5))
                    .as(Tuple::of),
                Combinators.combine(
                        StorageArbitraries.buckets().logging().injectNull(0.5),
                        StorageArbitraries.buckets().cors(),
                        StorageArbitraries.buckets().objectAccessControl().injectNull(0.5),
                        StorageArbitraries.buckets().bucketAccessControl().injectNull(0.5),
                        StorageArbitraries.owner().injectNull(0.01),
                        StorageArbitraries.buckets().iamConfig().injectNull(0.5),
                        StorageArbitraries.buckets().labels(),
                        StorageArbitraries.etag())
                    .as(Tuple::of),
                Combinators.combine(
                        StorageArbitraries.projectNumber().map(ProjectNumber::toProjectName),
                        StorageArbitraries.buckets().ipFilter().injectNull(0.75))
                    .as(Tuple::of))
            .as(
                (t1, t2, t3, t4) -> {
                  Bucket.Builder b = Bucket.newBuilder();
                  ifNonNull(t1.get1(), BucketName::getBucket, b::setBucketId);
                  ifNonNull(t1.get2(), BucketName::toString, b::setName);
                  ifNonNull(t1.get3(), b::setStorageClass);
                  ifNonNull(t1.get4(), b::setLocation);
                  ifNonNull(t1.get5(), b::setLocationType);
                  ifNonNull(t1.get6(), b::setMetageneration);
                  ifNonNull(t1.get7(), b::setVersioning);
                  ifNonNull(t1.get8(), b::setCreateTime);
                  ifNonNull(t2.get1(), b::setUpdateTime);
                  ifNonNull(t2.get2(), b::setWebsite);
                  ifNonNull(t2.get3(), b::setDefaultEventBasedHold);
                  ifNonNull(t2.get4(), b::setRpo);
                  ifNonNull(t2.get5(), b::setBilling);
                  ifNonNull(t2.get6(), b::setEncryption);
                  ifNonNull(t2.get7(), b::setRetentionPolicy);
                  ifNonNull(t2.get8(), b::setLifecycle);
                  ifNonNull(t3.get1(), b::setLogging);
                  ifNonNull(t3.get2(), b::addAllCors);
                  ifNonNull(t3.get3(), b::addAllDefaultObjectAcl);
                  ifNonNull(t3.get4(), b::addAllAcl);
                  ifNonNull(t3.get5(), b::setOwner);
                  ifNonNull(t3.get6(), b::setIamConfig);
                  ifNonNull(t3.get7(), b::putAllLabels);
                  ifNonNull(t3.get8(), b::setEtag);
                  ifNonNull(t4.get1(), ProjectName::toString, b::setProject);
                  ifNonNull(t4.get2(), b::setIpFilter);
                  // TODO: add CustomPlacementConfig
                  return b.build();
                });
    return Collections.singleton(as);
  }
}
