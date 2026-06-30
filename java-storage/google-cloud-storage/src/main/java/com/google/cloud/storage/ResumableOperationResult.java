/*
 * Copyright 2023 Google LLC
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

import com.google.common.base.MoreObjects;
import org.checkerframework.checker.nullness.qual.Nullable;

abstract class ResumableOperationResult<@Nullable T> {

  private ResumableOperationResult() {}

  abstract @Nullable T getObject();

  abstract long getPersistedSize();

  static <T> ResumableOperationResult<T> complete(T t, long persistedSize) {
    return new CompletedResult<>(t, persistedSize);
  }

  static <@Nullable T> ResumableOperationResult<T> incremental(long persistedSize) {
    return new IncrementalResult<>(persistedSize);
  }

  private static final class CompletedResult<T> extends ResumableOperationResult<T> {

    private final long persistedSize;
    private final T entity;

    private CompletedResult(T entity, long persistedSize) {
      this.entity = entity;
      this.persistedSize = persistedSize;
    }

    @Override
    public @Nullable T getObject() {
      return entity;
    }

    @Override
    public long getPersistedSize() {
      return persistedSize;
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("persistedSize", persistedSize)
          .add("entity", entity)
          .toString();
    }
  }

  private static final class IncrementalResult<@Nullable T> extends ResumableOperationResult<T> {

    private final long persistedSize;

    private IncrementalResult(long persistedSize) {
      this.persistedSize = persistedSize;
    }

    @Override
    public @Nullable T getObject() {
      return null;
    }

    @Override
    public long getPersistedSize() {
      return persistedSize;
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this).add("persistedSize", persistedSize).toString();
    }
  }
}
