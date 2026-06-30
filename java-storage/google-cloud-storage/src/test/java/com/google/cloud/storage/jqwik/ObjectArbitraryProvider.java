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

import com.google.storage.v2.BucketName;
import com.google.storage.v2.Object;
import java.util.Collections;
import java.util.Set;
import javax.annotation.ParametersAreNonnullByDefault;
import net.jqwik.api.Arbitraries;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.Combinators;
import net.jqwik.api.Tuple;
import net.jqwik.api.providers.ArbitraryProvider;
import net.jqwik.api.providers.TypeUsage;
import org.checkerframework.checker.nullness.qual.NonNull;

@ParametersAreNonnullByDefault
public final class ObjectArbitraryProvider implements ArbitraryProvider {

  @Override
  public boolean canProvideFor(TypeUsage targetType) {
    return targetType.isOfType(Object.class);
  }

  @NonNull
  @Override
  public Set<Arbitrary<?>> provideFor(TypeUsage targetType, SubtypeProvider subtypeProvider) {
    Arbitrary<Long> size = Arbitraries.longs().greaterOrEqual(0);
    Arbitrary<Object> objectArbitrary =
        Combinators.combine(
                Combinators.combine(
                        StorageArbitraries.objects().name(),
                        StorageArbitraries.buckets().name(),
                        StorageArbitraries.generation(),
                        StorageArbitraries.metageneration(),
                        StorageArbitraries.storageClass(),
                        size,
                        StorageArbitraries.httpHeaders().contentEncoding(),
                        StorageArbitraries.httpHeaders().contentDisposition())
                    .as(Tuple::of),
                Combinators.combine(
                        StorageArbitraries.httpHeaders().cacheControl(),
                        StorageArbitraries.httpHeaders().contentLanguage(),
                        StorageArbitraries.timestamp().injectNull(0.25), // dtime
                        StorageArbitraries.httpHeaders().contentType(),
                        StorageArbitraries.timestamp().injectNull(0.25), // ctime
                        // componentCount is populated if the object is made from compose
                        Arbitraries.integers().greaterOrEqual(0).injectNull(0.85),
                        StorageArbitraries.objects().objectChecksums().injectNull(0.25))
                    .as(Tuple::of),
                Combinators.combine(
                        StorageArbitraries.timestamp().injectNull(0.25), // utime
                        StorageArbitraries.kmsKey(),
                        StorageArbitraries.timestamp().injectNull(0.25), // UpdateStorageClassTime
                        StorageArbitraries.bool().injectNull(0.25),
                        StorageArbitraries.timestamp().injectNull(0.25), // RetentionExpireTime
                        StorageArbitraries.bool().injectNull(0.25),
                        StorageArbitraries.objects().customerEncryption().injectNull(0.90),
                        StorageArbitraries.httpHeaders().customTime())
                    .as(Tuple::of),
                Combinators.combine(
                        StorageArbitraries.objects().customMetadata(),
                        StorageArbitraries.owner().injectNull(0.1),
                        StorageArbitraries.objects().objectAccessControl().injectNull(0.5),
                        StorageArbitraries.etag(),
                        StorageArbitraries.objects().objectContexts())
                    .as(Tuple::of))
            .as(
                (t1, t2, t3, t4) -> {
                  Object.Builder b = Object.newBuilder();
                  ifNonNull(t1.get1(), b::setName);
                  ifNonNull(t1.get2(), BucketName::toString, b::setBucket);
                  ifNonNull(t1.get3(), b::setGeneration);
                  ifNonNull(t1.get4(), b::setMetageneration);
                  ifNonNull(t1.get5(), b::setStorageClass);
                  ifNonNull(t1.get6(), b::setSize);
                  ifNonNull(t1.get7(), b::setContentEncoding);
                  ifNonNull(t1.get8(), b::setContentDisposition);
                  ifNonNull(t2.get1(), b::setCacheControl);
                  ifNonNull(t4.get3(), b::addAllAcl);
                  ifNonNull(t2.get2(), b::setContentLanguage);
                  ifNonNull(t2.get3(), b::setDeleteTime);
                  ifNonNull(t2.get4(), b::setContentType);
                  ifNonNull(t2.get5(), b::setCreateTime);
                  ifNonNull(t2.get6(), b::setComponentCount);
                  ifNonNull(t2.get7(), b::setChecksums);
                  ifNonNull(t3.get1(), b::setUpdateTime);
                  ifNonNull(t3.get2(), b::setKmsKey);
                  ifNonNull(t3.get3(), b::setUpdateStorageClassTime);
                  ifNonNull(t3.get4(), b::setTemporaryHold);
                  ifNonNull(t3.get5(), b::setRetentionExpireTime);
                  ifNonNull(t4.get1(), b::putAllMetadata);
                  ifNonNull(t3.get6(), b::setEventBasedHold);
                  ifNonNull(t4.get2(), b::setOwner);
                  ifNonNull(t3.get7(), b::setCustomerEncryption);
                  ifNonNull(t3.get8(), b::setCustomTime);
                  ifNonNull(t4.get4(), b::setEtag);
                  ifNonNull(t4.get5(), b::setContexts);
                  return b.build();
                });
    return Collections.singleton(objectArbitrary);
  }
}
