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

import com.google.common.collect.ImmutableSet;
import javax.annotation.concurrent.ThreadSafe;

/**
 * Threadsafe class to track protected bucket names.
 *
 * <p>We are tracking that tests do not mutate the global buckets which are shared across tests,
 * this class tracks the names of the buckets.
 */
@ThreadSafe
final class ProtectedBucketNames implements ManagedLifecycle {

  private ImmutableSet<String> protectedNames;

  ProtectedBucketNames() {
    this.protectedNames = ImmutableSet.of();
  }

  @Override
  public Object get() {
    return this;
  }

  @Override
  public synchronized void start() {
    protectedNames = ImmutableSet.of();
  }

  @Override
  public synchronized void stop() {
    protectedNames = ImmutableSet.of();
  }

  public synchronized void add(String name) {
    ImmutableSet<String> tmp = protectedNames;
    protectedNames = ImmutableSet.<String>builder().addAll(tmp).add(name).build();
  }

  public synchronized void remove(String name) {
    ImmutableSet<String> tmp = protectedNames;
    protectedNames =
        tmp.stream().filter(n -> !n.equals(name)).collect(ImmutableSet.toImmutableSet());
  }

  public boolean isProtected(String name) {
    ImmutableSet<String> tmp = protectedNames;
    return tmp.contains(name);
  }
}
