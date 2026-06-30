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

import com.google.cloud.storage.it.runner.annotations.Inject;
import com.google.common.base.MoreObjects;
import java.util.Comparator;

/**
 * Entry tuple for an instance registered with the {@link Registry}.
 *
 * <p>Binds together the target injection type, shutdown priority, extended applicability predicate
 * and the instance.
 */
final class RegistryEntry<T extends ManagedLifecycle> implements Comparable<RegistryEntry<?>> {

  private static final Comparator<RegistryEntry<?>> comparator =
      Comparator.<RegistryEntry<?>>comparingInt(RegistryEntry::getShutdownPriority).reversed();

  private final Class<?> type;

  /** Higher will be shutdown earlier */
  private final int shutdownPriority;

  private final RegistryApplicabilityPredicate predicate;
  private final TestRunScopedInstance<T> instance;

  private RegistryEntry(
      int shutdownPriority,
      Class<?> type,
      TestRunScopedInstance<T> instance,
      RegistryApplicabilityPredicate predicate) {
    this.shutdownPriority = shutdownPriority;
    this.type = type;
    this.predicate = predicate;
    this.instance = instance;
  }

  public Class<?> getType() {
    return type;
  }

  public int getShutdownPriority() {
    return shutdownPriority;
  }

  public RegistryApplicabilityPredicate getPredicate() {
    return predicate;
  }

  public TestRunScopedInstance<T> getInstance() {
    return instance;
  }

  @Override
  public int compareTo(RegistryEntry<?> o) {
    return comparator.compare(this, o);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("type", type)
        .add("shutdownPriority", shutdownPriority)
        .add("instance", instance)
        .add("predicate", predicate)
        .toString();
  }

  static <T extends ManagedLifecycle> RegistryEntry<T> of(
      int shutdownPriority, Class<?> c, TestRunScopedInstance<T> instance) {
    return of(shutdownPriority, c, instance, RegistryApplicabilityPredicate.alwaysTrue());
  }

  static <T extends ManagedLifecycle> RegistryEntry<T> of(
      int shutdownPriority,
      Class<?> c,
      TestRunScopedInstance<T> instance,
      RegistryApplicabilityPredicate predicate) {
    return new RegistryEntry<>(
        shutdownPriority,
        c,
        instance,
        RegistryApplicabilityPredicate.annotatedWith(Inject.class)
            .and(RegistryApplicabilityPredicate.assignableFrom(c))
            .and(predicate));
  }
}
