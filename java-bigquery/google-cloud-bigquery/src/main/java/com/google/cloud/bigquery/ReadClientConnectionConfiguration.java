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

import com.google.auto.value.AutoValue;
import java.io.Serializable;
import javax.annotation.Nullable;

/** Represents BigQueryStorage Read client connection information. */
@AutoValue
public abstract class ReadClientConnectionConfiguration implements Serializable {

  @AutoValue.Builder
  public abstract static class Builder {

    /**
     * Sets the total row count to page row count ratio used to determine whether to us the
     * BigQueryStorage Read client to fetch result sets after the first page.
     */
    public abstract Builder setTotalToPageRowCountRatio(Long ratio);

    /**
     * Sets the minimum number of table rows in the query results used to determine whether to us
     * the BigQueryStorage Read client to fetch result sets after the first page.
     */
    public abstract Builder setMinResultSize(Long numRows);

    /**
     * Sets the maximum number of table rows allowed in buffer before streaming them to the
     * BigQueryResult.
     */
    public abstract Builder setBufferSize(Long bufferSize);

    /** Creates a {@code ReadClientConnectionConfiguration} object. */
    public abstract ReadClientConnectionConfiguration build();
  }

  /** Returns the totalToPageRowCountRatio in this configuration. */
  @Nullable
  public abstract Long getTotalToPageRowCountRatio();

  /** Returns the minResultSize in this configuration. */
  @Nullable
  public abstract Long getMinResultSize();

  /** Returns the bufferSize in this configuration. */
  @Nullable
  public abstract Long getBufferSize();

  public abstract Builder toBuilder();

  /** Returns a builder for a {@code ReadClientConnectionConfiguration} object. */
  public static Builder newBuilder() {
    return new AutoValue_ReadClientConnectionConfiguration.Builder();
  }
}
