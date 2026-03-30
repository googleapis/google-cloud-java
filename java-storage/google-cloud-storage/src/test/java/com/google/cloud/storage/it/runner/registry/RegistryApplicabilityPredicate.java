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

import static java.util.Objects.requireNonNull;

import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.it.runner.CrossRunIntersection;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.BucketFixture;
import com.google.cloud.storage.it.runner.annotations.BucketType;
import java.lang.annotation.Annotation;
import java.util.function.Function;
import org.junit.runners.model.FrameworkField;

/**
 * In order to register an instance with the {@link Registry} a Predicate must be provided which
 * will determine if it is applicable to a specific {@link FrameworkField} and {@link
 * CrossRunIntersection}.
 *
 * <p>Includes various utility method to create predicates
 */
@FunctionalInterface
interface RegistryApplicabilityPredicate {

  boolean test(FrameworkField ff, CrossRunIntersection crossRunIntersection);

  default RegistryApplicabilityPredicate and(RegistryApplicabilityPredicate next) {
    requireNonNull(next, "next must be non null");
    return (ff, intersection) -> this.test(ff, intersection) && next.test(ff, intersection);
  }

  default RegistryApplicabilityPredicate or(RegistryApplicabilityPredicate next) {
    requireNonNull(next, "next must be non null");
    return (ff, intersection) -> this.test(ff, intersection) || next.test(ff, intersection);
  }

  static RegistryApplicabilityPredicate alwaysTrue() {
    return (ff, intersection) -> true;
  }

  static <A extends Annotation> RegistryApplicabilityPredicate annotatedWith(Class<A> ac) {
    return (ff, intersection) -> ff.getAnnotation(ac) != null;
  }

  static <T> RegistryApplicabilityPredicate assignableFrom(Class<T> c) {
    return (ff, intersection) -> ff.getType().isAssignableFrom(c);
  }

  static RegistryApplicabilityPredicate backendIs(Backend b) {
    return (ff, intersection) -> intersection != null && intersection.getBackend() == b;
  }

  static RegistryApplicabilityPredicate transportIs(Transport t) {
    return (ff, intersection) -> intersection != null && intersection.getTransport() == t;
  }

  static RegistryApplicabilityPredicate transportAndBackendAre(Transport t, Backend b) {
    return transportIs(t).and(backendIs(b));
  }

  static <T> RegistryApplicabilityPredicate cellWith(Function<CrossRunIntersection, T> f) {
    return (ff, intersection) -> intersection != null && f.apply(intersection) != null;
  }

  static RegistryApplicabilityPredicate isDefaultBucket() {
    return (ff, intersection) -> {
      BucketFixture annotation = ff.getAnnotation(BucketFixture.class);
      if (annotation == null) {
        return true;
      } else {
        return annotation.value() == BucketType.DEFAULT;
      }
    };
  }

  static RegistryApplicabilityPredicate bucketTypeIs(BucketType bucketType) {
    return annotatedWith(BucketFixture.class)
        .and((ff, intersection) -> ff.getAnnotation(BucketFixture.class).value() == bucketType);
  }
}
