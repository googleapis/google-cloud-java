/*
 * Copyright 2023 Google LLC
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
import com.google.auto.value.AutoValue;
import com.google.common.annotations.VisibleForTesting;
import java.io.Serializable;
import javax.annotation.Nullable;

@AutoValue
@BetaApi
public abstract class CloneDefinition implements Serializable {

  private static final long serialVersionUID = 1460853787400450649L;

  public static Builder newBuilder() {
    return new AutoValue_CloneDefinition.Builder();
  }

  static CloneDefinition fromPb(
      com.google.api.services.bigquery.model.CloneDefinition cloneDefinition) {
    Builder builder = newBuilder();

    if (cloneDefinition.getCloneTime() != null) {
      builder.setCloneTime(cloneDefinition.getCloneTime().toString());
    }
    if (cloneDefinition.getBaseTableReference() != null) {
      builder.setBaseTableId(TableId.fromPb(cloneDefinition.getBaseTableReference()));
    }

    return builder.build();
  }

  @Nullable
  public abstract TableId getBaseTableId();

  @Nullable
  public abstract String getCloneTime();

  /** Returns a builder for a Clone table definition. */
  @VisibleForTesting
  public abstract Builder toBuilder();

  com.google.api.services.bigquery.model.CloneDefinition toPb() {

    com.google.api.services.bigquery.model.CloneDefinition cloneDefinition =
        new com.google.api.services.bigquery.model.CloneDefinition();
    cloneDefinition.setBaseTableReference(getBaseTableId().toPb());
    cloneDefinition.setCloneTime(DateTime.parseRfc3339(getCloneTime()));

    return cloneDefinition;
  }

  @AutoValue.Builder
  public abstract static class Builder {

    /** Reference describing the ID of the table that was Cloned. * */
    public abstract Builder setBaseTableId(TableId baseTableId);

    /**
     * The time at which the base table was Cloned. This value is reported in the JSON response
     * using RFC3339 format. *
     */
    public abstract Builder setCloneTime(String dateTime);

    /** Creates a {@code CloneDefinition} object. */
    public abstract CloneDefinition build();
  }
}
