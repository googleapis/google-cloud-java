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
import com.google.protobuf.ByteString;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Nonnull;

/** Default representation of a logical row. */
@InternalExtensionOnly
@AutoValue
public abstract class Row implements Comparable<Row>, Serializable {
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

  /** Lexicographically compares this row's key to another row's key. */
  @Override
  public int compareTo(@Nonnull Row row) {
    int sizeA = getKey().size();
    int sizeB = row.getKey().size();
    int size = Math.min(sizeA, sizeB);

    for (int i = 0; i < size; i++) {
      int byteA = getKey().byteAt(i) & 0xff;
      int byteB = row.getKey().byteAt(i) & 0xff;
      if (byteA == byteB) {
        continue;
      } else {
        return byteA < byteB ? -1 : 1;
      }
    }
    if (sizeA == sizeB) {
      return 0;
    }
    return sizeA < sizeB ? -1 : 1;
  }
}
