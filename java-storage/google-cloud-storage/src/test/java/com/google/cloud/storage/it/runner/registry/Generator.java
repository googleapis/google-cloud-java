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

import java.util.Locale;
import java.util.UUID;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.junit.runner.Description;

/** Scoped instance of a class which generates common things for tests. */
public final class Generator implements ManagedLifecycle {

  private final WeakHashMap<Description, AtomicInteger> counters;

  Generator() {
    counters = new WeakHashMap<>();
  }

  /** Generate a new random bucket name */
  @NonNull
  public String randomBucketName() {
    // TODO: track their creation and detect if the bucket is "leaked" and fail the test
    return "java-storage-grpc-rand-" + UUID.randomUUID();
  }

  @NonNull
  public String randomObjectName() {
    Description currentTest = Registry.getInstance().getCurrentTest();
    if (currentTest == null) {
      throw new IllegalStateException("No actively running test in registry.");
    }
    AtomicInteger counter = counters.computeIfAbsent(currentTest, (d) -> new AtomicInteger(1));
    return String.format(
        Locale.US,
        "%s.%s-%04d",
        currentTest.getClassName(),
        currentTest.getMethodName(),
        counter.getAndIncrement());
  }

  @Override
  public Object get() {
    return this;
  }

  @Override
  public void start() {}

  @Override
  public void stop() {}
}
