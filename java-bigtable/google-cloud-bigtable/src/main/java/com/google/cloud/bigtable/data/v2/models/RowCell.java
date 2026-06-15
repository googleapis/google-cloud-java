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

import com.google.api.core.InternalApi;
import com.google.api.core.InternalExtensionOnly;
import com.google.auto.value.AutoValue;
import com.google.cloud.bigtable.data.v2.internal.ByteStringComparator;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.ByteString;
import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import javax.annotation.Nonnull;

/** Default representation of a cell in a {@link Row}. */
@InternalExtensionOnly
@AutoValue
public abstract class RowCell implements Serializable {
  /**
   * A comparator that compares the cells by Bigtable native ordering:
   *
   * <ul>
   *   <li>Family lexicographically ascending
   *   <li>Qualifier lexicographically ascending
   *   <li>Timestamp in reverse chronological order
   * </ul>
   *
   * <p>Labels and values are not included in the comparison.
   */
  public static Comparator<RowCell> compareByNative() {
    return new Comparator<RowCell>() {
      @Override
      public int compare(RowCell c1, RowCell c2) {
        return ComparisonChain.start()
            .compare(c1.getFamily(), c2.getFamily())
            .compare(c1.getQualifier(), c2.getQualifier(), ByteStringComparator.INSTANCE)
            .compare(c2.getTimestamp(), c1.getTimestamp())
            .result();
      }
    };
  }

  /** Creates a new instance of the {@link RowCell}. */
  @InternalApi
  public static RowCell create(
      @Nonnull String family,
      @Nonnull ByteString qualifier,
      long timestamp,
      @Nonnull List<String> labels,
      @Nonnull ByteString value) {
    // Ensure that the list is serializable and optimize for the common case
    if (labels.isEmpty()) {
      labels = ImmutableList.of();
    } else {
      labels = ImmutableList.copyOf(labels);
    }
    return new AutoValue_RowCell(family, qualifier, timestamp, value, ImmutableList.copyOf(labels));
  }

  /** The cell's family */
  @Nonnull
  public abstract String getFamily();

  /** The cell's qualifier (column name) */
  @Nonnull
  public abstract ByteString getQualifier();

  /** The timestamp of the cell */
  public abstract long getTimestamp();

  /** The value of the cell */
  @Nonnull
  public abstract ByteString getValue();

  /**
   * The labels assigned to the cell
   *
   * @see Filters#label(String)
   */
  @Nonnull
  public abstract List<String> getLabels();
}
