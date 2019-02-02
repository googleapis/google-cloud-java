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
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.ByteString;
import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Default representation of a logical row.
 *
 * <p>The cells contained within, will be sorted by the native order. Please see {@link
 * RowCell#compareByNative()} for details.
 */
@InternalExtensionOnly
@AutoValue
public abstract class Row implements Serializable {
  /**
   * Returns a comparator that compares two Row objects by comparing the result of {@link
   * #getKey()}} for each.
   */
  public static Comparator<Row> compareByKey() {
    return new Comparator<Row>() {
      @Override
      public int compare(Row r1, Row r2) {
        return ByteStringComparator.INSTANCE.compare(r1.getKey(), r2.getKey());
      }
    };
  }

  /** Creates a new instance of the {@link Row}. */
  @InternalApi
  public static Row create(ByteString key, List<RowCell> cells) {
    return new AutoValue_Row(key, cells);
  }

  /** Returns the row key */
  @Nonnull
  public abstract ByteString getKey();

  /**
   * Returns a sorted list of cells. The cells will be sorted natively.
   *
   * @see RowCell#compareByNative() For details about the ordering.
   */
  public abstract List<RowCell> getCells();

  /**
   * Returns a sublist of the cells that belong to the specified family.
   *
   * @see RowCell#compareByNative() For details about the ordering.
   */
  public List<RowCell> getCells(@Nonnull String family) {
    Preconditions.checkNotNull(family, "family");

    int start = getFirst(family, null);
    if (start < 0) {
      return ImmutableList.of();
    }

    int end = getLast(family, null, start);

    return getCells().subList(start, end + 1);
  }

  /**
   * Returns a sublist of the cells that belong to the specified family and qualifier.
   *
   * @see RowCell#compareByNative() For details about the ordering.
   */
  public List<RowCell> getCells(@Nonnull String family, @Nonnull String qualifier) {
    Preconditions.checkNotNull(family, "family");
    Preconditions.checkNotNull(qualifier, "qualifier");

    return getCells(family, ByteString.copyFromUtf8(qualifier));
  }

  /**
   * Returns a sublist of the cells that belong to the specified family and qualifier.
   *
   * @see RowCell#compareByNative() For details about the ordering.
   */
  public List<RowCell> getCells(@Nonnull String family, @Nonnull ByteString qualifier) {
    Preconditions.checkNotNull(family, "family");
    Preconditions.checkNotNull(qualifier, "qualifier");

    int start = getFirst(family, qualifier);
    if (start < 0) {
      return ImmutableList.of();
    }

    int end = getLast(family, qualifier, start);

    return getCells().subList(start, end + 1);
  }

  private int getFirst(@Nonnull String family, @Nullable ByteString qualifier) {
    int low = 0;
    int high = getCells().size();
    int index = -1;

    while (low < high) {
      int mid = (high + low) / 2;
      RowCell midCell = getCells().get(mid);

      int c = midCell.getFamily().compareTo(family);
      if (c == 0 && qualifier != null) {
        c = ByteStringComparator.INSTANCE.compare(midCell.getQualifier(), qualifier);
      }

      if (c < 0) {
        low = mid + 1;
      } else if (c == 0) {
        index = mid;
        high = mid;
      } else {
        high = mid;
      }
    }
    return index;
  }

  private int getLast(@Nonnull String family, @Nullable ByteString qualifier, int startIndex) {
    int low = startIndex;
    int high = getCells().size();
    int index = -1;

    while (low < high) {
      int mid = (high + low) / 2;
      RowCell midCell = getCells().get(mid);

      int c = midCell.getFamily().compareTo(family);
      if (c == 0 && qualifier != null) {
        c = ByteStringComparator.INSTANCE.compare(midCell.getQualifier(), qualifier);
      }

      if (c < 0) {
        low = mid + 1;
      } else if (c == 0) {
        index = mid;
        low = mid + 1;
      } else {
        high = mid;
      }
    }
    return index;
  }
}
