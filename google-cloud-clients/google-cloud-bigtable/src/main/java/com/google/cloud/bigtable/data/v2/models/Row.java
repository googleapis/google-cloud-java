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
import com.google.protobuf.ByteString;
import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import javax.annotation.Nonnull;

/**
 * Default representation of a logical row.
 *
 * <p>The cells contained within, will be sorted by the native order. Please see
 * {@link RowCell#compareByNative()} for details.
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
   * Returns the list of cells. The cells will be clustered by their family and sorted by their
   * qualifier.
   */
  public abstract List<RowCell> getCells();
}
