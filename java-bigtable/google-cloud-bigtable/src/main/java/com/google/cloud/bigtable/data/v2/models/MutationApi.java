/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.data.v2.models;

import com.google.api.core.InternalExtensionOnly;
import com.google.cloud.bigtable.data.v2.models.Range.TimestampRange;
import com.google.protobuf.ByteString;
import javax.annotation.Nonnull;

/** The API for creating mutations for a single row. */
@InternalExtensionOnly
public interface MutationApi<T extends MutationApi<T>> {
  /**
   * Adds a mutation which sets the value of the specified cell.
   *
   * <p>This a convenience method that converts Strings to ByteStrings and uses microseconds since
   * epoch as the timestamp.
   */
  T setCell(@Nonnull String familyName, @Nonnull String qualifier, @Nonnull String value);

  /**
   * Adds a mutation which sets the value of the specified cell.
   *
   * <p>This is a convenience override that converts Strings to ByteStrings.
   *
   * <p>Note: The timestamp values are in microseconds but must match the granularity of the
   * table(defaults to `MILLIS`). Therefore, the given value must be a multiple of 1000 (millisecond
   * granularity). For example: `1571902339435000`.
   */
  T setCell(
      @Nonnull String familyName, @Nonnull String qualifier, long timestamp, @Nonnull String value);

  /**
   * Adds a mutation which sets the value of the specified cell.
   *
   * <p>Uses microseconds since epoch as the timestamp.
   */
  T setCell(@Nonnull String familyName, @Nonnull ByteString qualifier, @Nonnull ByteString value);

  /**
   * Adds a mutation which sets the value of the specified cell.
   *
   * <p>Note: The timestamp values are in microseconds but must match the granularity of the
   * table(defaults to `MILLIS`). Therefore, the given value must be a multiple of 1000 (millisecond
   * granularity). For example: `1571902339435000`.
   */
  T setCell(
      @Nonnull String familyName,
      @Nonnull ByteString qualifier,
      long timestamp,
      @Nonnull ByteString value);

  /**
   * Adds a mutation which sets the value of the specified cell.
   *
   * <p>This a convenience method that converts Strings to ByteStrings and uses microseconds since
   * epoch as the timestamp. Also it accepts long value.
   */
  T setCell(@Nonnull String familyName, @Nonnull String qualifier, long value);

  /**
   * Adds a mutation which sets the value of the specified cell.
   *
   * <p>This is a convenience override that converts Strings to ByteStrings.
   *
   * <p>Note: The timestamp values are in microseconds but must match the granularity of the
   * table(defaults to `MILLIS`). Therefore, the given value must be a multiple of 1000 (millisecond
   * granularity). For example: `1571902339435000`.
   */
  T setCell(@Nonnull String familyName, @Nonnull String qualifier, long timestamp, long value);

  /**
   * Adds a mutation which sets the value of the specified cell.
   *
   * <p>Uses microseconds since epoch as the timestamp.
   */
  T setCell(@Nonnull String familyName, @Nonnull ByteString qualifier, long value);

  /**
   * Adds a mutation which sets the value of the specified cell.
   *
   * <p>Note: The timestamp values are in microseconds but must match the granularity of the
   * table(defaults to `MILLIS`). Therefore, the given value must be a multiple of 1000 (millisecond
   * granularity). For example: `1571902339435000`.
   */
  T setCell(@Nonnull String familyName, @Nonnull ByteString qualifier, long timestamp, long value);

  /** Adds a mutation which deletes cells from the specified column. */
  T deleteCells(@Nonnull String familyName, @Nonnull String qualifier);

  /** Adds a mutation which deletes cells from the specified column. */
  T deleteCells(@Nonnull String familyName, @Nonnull ByteString qualifier);

  /**
   * Adds a mutation which deletes cells from the specified column, restricted to a given timestamp
   * range.
   *
   * @param familyName The family name.
   * @param qualifier The qualifier.
   * @param timestampRange The timestamp range in microseconds.
   */
  T deleteCells(
      @Nonnull String familyName,
      @Nonnull ByteString qualifier,
      @Nonnull TimestampRange timestampRange);

  /** Adds a mutation which deletes all cells from the specified column family. */
  T deleteFamily(@Nonnull String familyName);

  /** Adds a mutation which deletes all cells from the containing row. */
  T deleteRow();
}
