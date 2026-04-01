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

package com.google.cloud.storage;

import com.google.common.base.Preconditions;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

final class AutoClosableFixture<@NonNull T extends AutoCloseable> implements TestRule {
  private final ThrowingSupplier<T> supplier;

  @Nullable private T instance;

  private AutoClosableFixture(ThrowingSupplier<T> supplier) {
    this.supplier = supplier;
  }

  @NonNull
  public T getInstance() {
    Preconditions.checkState(instance != null, "getInstance() called outside active lifecycle.");
    return instance;
  }

  @Override
  public Statement apply(Statement base, Description description) {
    return new Statement() {
      @Override
      public void evaluate() throws Throwable {
        try (T t = supplier.get()) {
          instance = t;
          base.evaluate();
        } finally {
          instance = null;
        }
      }
    };
  }

  static <@NonNull T extends AutoCloseable> AutoClosableFixture<T> of(
      ThrowingSupplier<T> supplier) {
    return new AutoClosableFixture<>(supplier);
  }

  @FunctionalInterface
  interface ThrowingSupplier<@NonNull T> {
    T get() throws Exception;
  }
}
