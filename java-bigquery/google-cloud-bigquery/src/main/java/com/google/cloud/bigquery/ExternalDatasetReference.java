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

package com.google.cloud.bigquery;

import com.google.auto.value.AutoValue;
import com.google.common.annotations.VisibleForTesting;
import java.io.Serializable;
import javax.annotation.Nullable;

/** Configures the access a dataset defined in an external metadata storage. */
@AutoValue
public abstract class ExternalDatasetReference implements Serializable {

  public static ExternalDatasetReference.Builder newBuilder() {
    return new AutoValue_ExternalDatasetReference.Builder();
  }

  static ExternalDatasetReference fromPb(
      com.google.api.services.bigquery.model.ExternalDatasetReference externalDatasetReference) {
    ExternalDatasetReference.Builder builder = newBuilder();

    if (externalDatasetReference.getConnection() != null) {
      builder.setConnection(externalDatasetReference.getConnection());
    }
    if (externalDatasetReference.getExternalSource() != null) {
      builder.setExternalSource(externalDatasetReference.getExternalSource());
    }

    return builder.build();
  }

  public com.google.api.services.bigquery.model.ExternalDatasetReference toPb() {
    com.google.api.services.bigquery.model.ExternalDatasetReference externalDatasetReference =
        new com.google.api.services.bigquery.model.ExternalDatasetReference();

    externalDatasetReference.setConnection(getConnection());
    externalDatasetReference.setExternalSource(getExternalSource());
    return externalDatasetReference;
  }

  @Nullable
  public abstract String getConnection();

  @Nullable
  public abstract String getExternalSource();

  /** Returns a builder for an ExternalDatasetReference. */
  @VisibleForTesting
  public abstract ExternalDatasetReference.Builder toBuilder();

  @AutoValue.Builder
  public abstract static class Builder {
    /**
     * The connection id that is used to access the external_source. Format:
     * projects/{project_id}/locations/{location_id}/connections/{connection_id} *
     */
    public abstract ExternalDatasetReference.Builder setConnection(String connection);

    /** External source that backs this dataset * */
    public abstract ExternalDatasetReference.Builder setExternalSource(String externalSource);

    /** Creates a {@code ExternalDatasetReference} object. */
    public abstract ExternalDatasetReference build();
  }
}
