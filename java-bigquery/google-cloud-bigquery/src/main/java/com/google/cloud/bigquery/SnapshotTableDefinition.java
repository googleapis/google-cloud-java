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

import com.google.api.client.util.DateTime;
import com.google.api.core.BetaApi;
import com.google.api.services.bigquery.model.Table;
import com.google.auto.value.AutoValue;
import com.google.common.annotations.VisibleForTesting;
import javax.annotation.Nullable;

@AutoValue
@BetaApi
public abstract class SnapshotTableDefinition extends TableDefinition {

  private static final long serialVersionUID = 2113445776046717526L;

  @AutoValue.Builder
  public abstract static class Builder
      extends TableDefinition.Builder<SnapshotTableDefinition, Builder> {

    /** Reference describing the ID of the table that was snapshot. * */
    public abstract Builder setBaseTableId(TableId baseTableId);

    /**
     * The time at which the base table was snapshot. This value is reported in the JSON response
     * using RFC3339 format. *
     */
    public abstract Builder setSnapshotTime(String dateTime);

    public abstract Builder setTimePartitioning(TimePartitioning timePartitioning);

    public abstract Builder setRangePartitioning(RangePartitioning rangePartitioning);

    public abstract Builder setClustering(Clustering clustering);

    /** Creates a {@code SnapshotTableDefinition} object. */
    public abstract SnapshotTableDefinition build();
  }

  @Nullable
  public abstract TableId getBaseTableId();

  @Nullable
  public abstract String getSnapshotTime();

  @Nullable
  public abstract TimePartitioning getTimePartitioning();

  @Nullable
  public abstract RangePartitioning getRangePartitioning();

  @Nullable
  public abstract Clustering getClustering();

  /** Returns a builder for a snapshot table definition. */
  public static SnapshotTableDefinition.Builder newBuilder() {
    return new AutoValue_SnapshotTableDefinition.Builder().setType(Type.SNAPSHOT);
  }

  @VisibleForTesting
  public abstract SnapshotTableDefinition.Builder toBuilder();

  @Override
  Table toPb() {
    Table tablePb = super.toPb();
    com.google.api.services.bigquery.model.SnapshotDefinition snapshotDefinition =
        new com.google.api.services.bigquery.model.SnapshotDefinition();
    snapshotDefinition.setBaseTableReference(getBaseTableId().toPb());
    snapshotDefinition.setSnapshotTime(DateTime.parseRfc3339(getSnapshotTime()));
    tablePb.setSnapshotDefinition(snapshotDefinition);
    if (getTimePartitioning() != null) {
      tablePb.setTimePartitioning(getTimePartitioning().toPb());
    }
    if (getRangePartitioning() != null) {
      tablePb.setRangePartitioning(getRangePartitioning().toPb());
    }
    if (getClustering() != null) {
      tablePb.setClustering(getClustering().toPb());
    }
    return tablePb;
  }

  static SnapshotTableDefinition fromPb(Table tablePb) {
    Builder builder = newBuilder().table(tablePb);
    com.google.api.services.bigquery.model.SnapshotDefinition snapshotDefinition =
        tablePb.getSnapshotDefinition();
    if (snapshotDefinition != null) {
      if (snapshotDefinition.getBaseTableReference() != null) {
        builder.setBaseTableId(TableId.fromPb(snapshotDefinition.getBaseTableReference()));
      }
      if (snapshotDefinition.getSnapshotTime() != null) {
        builder.setSnapshotTime(snapshotDefinition.getSnapshotTime().toStringRfc3339());
      }
    }
    return builder.build();
  }
}
