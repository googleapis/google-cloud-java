/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery;

import com.google.api.services.bigquery.model.DmlStatistics;
import com.google.auto.value.AutoValue;
import java.io.Serializable;
import javax.annotation.Nullable;

/** Represents DML statistics information. */
@AutoValue
public abstract class DmlStats implements Serializable {

  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * Number of deleted Rows. populated by DML DELETE, MERGE and TRUNCATE statements.
     *
     * @param deletedRowCount deletedRowCount or {@code null} for none
     */
    public abstract Builder setDeletedRowCount(Long deletedRowCount);

    /**
     * Number of inserted Rows. Populated by DML INSERT and MERGE statements.
     *
     * @param insertedRowCount insertedRowCount or {@code null} for none
     */
    public abstract Builder setInsertedRowCount(Long insertedRowCount);

    /**
     * Number of updated Rows. Populated by DML UPDATE and MERGE statements.
     *
     * @param updatedRowCount updatedRowCount or {@code null} for none
     */
    public abstract Builder setUpdatedRowCount(Long updatedRowCount);

    /** Creates a {@code DmlStats} object. */
    public abstract DmlStats build();
  }

  /**
   * Returns number of deleted Rows. populated by DML DELETE, MERGE and TRUNCATE statements.
   *
   * @return value or {@code null} for none
   */
  @Nullable
  public abstract Long getDeletedRowCount();

  /**
   * Returns number of inserted Rows. Populated by DML INSERT and MERGE statements.
   *
   * @return value or {@code null} for none
   */
  @Nullable
  public abstract Long getInsertedRowCount();

  /**
   * Returns number of updated Rows. Populated by DML UPDATE and MERGE statements.
   *
   * @return value or {@code null} for none
   */
  @Nullable
  public abstract Long getUpdatedRowCount();

  public abstract Builder toBuilder();

  public static Builder newBuilder() {
    return new AutoValue_DmlStats.Builder();
  }

  DmlStatistics toPb() {
    DmlStatistics dmlStatisticsPb = new DmlStatistics();
    if (getDeletedRowCount() != null) {
      dmlStatisticsPb.setDeletedRowCount(getDeletedRowCount());
    }
    if (getInsertedRowCount() != null) {
      dmlStatisticsPb.setInsertedRowCount(getInsertedRowCount());
    }
    if (getUpdatedRowCount() != null) {
      dmlStatisticsPb.setUpdatedRowCount(getUpdatedRowCount());
    }
    return dmlStatisticsPb;
  }

  static DmlStats fromPb(DmlStatistics dmlStatisticsPb) {
    Builder builder = newBuilder();
    if (dmlStatisticsPb.getDeletedRowCount() != null) {
      builder.setDeletedRowCount(dmlStatisticsPb.getDeletedRowCount());
    }
    if (dmlStatisticsPb.getInsertedRowCount() != null) {
      builder.setInsertedRowCount(dmlStatisticsPb.getInsertedRowCount());
    }
    if (dmlStatisticsPb.getUpdatedRowCount() != null) {
      builder.setUpdatedRowCount(dmlStatisticsPb.getUpdatedRowCount());
    }
    return builder.build();
  }
}
