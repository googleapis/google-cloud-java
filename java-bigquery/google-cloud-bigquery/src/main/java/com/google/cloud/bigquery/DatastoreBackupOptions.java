/*
 * Copyright 2017 Google LLC
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

import com.google.common.base.MoreObjects;
import java.util.List;
import java.util.Objects;

/** Google BigQuery options for Cloud Datastore backup. */
public final class DatastoreBackupOptions extends FormatOptions {

  private final List<String> projectionFields;

  private static final long serialVersionUID = -5302774763661451947L;

  public static final class Builder {
    private List<String> projectionFields;

    private Builder() {}

    private Builder(DatastoreBackupOptions options) {
      projectionFields = options.projectionFields;
    }

    /**
     * Sets which entity properties to load into BigQuery from a Cloud Datastore backup. Property
     * names are case sensitive and must be top-level properties. If no properties are specified,
     * BigQuery loads all properties. If any named property isn't found in the Cloud Datastore
     * backup, an invalid error is returned in the job result.
     */
    public Builder setProjectionFields(List<String> projectionFields) {
      this.projectionFields = projectionFields;
      return this;
    }

    /** Creates a {@code DatastoreBackupOptions} object. */
    public DatastoreBackupOptions build() {
      return new DatastoreBackupOptions(this);
    }
  }

  private DatastoreBackupOptions(Builder builder) {
    super(FormatOptions.DATASTORE_BACKUP);
    this.projectionFields = builder.projectionFields;
  }

  /**
   * Returns the value of which entity properties to load into BigQuery from a Cloud Datastore
   * backup.
   */
  public List<String> getProjectionFields() {
    return projectionFields;
  }

  /** Returns a builder for the {@code DatastoreBackupOptions} object. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  /** Returns a builder for a {@code DatastoreBackupOptions} object. */
  public static Builder newBuilder() {
    return new Builder();
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("projectionFields", projectionFields).toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getType(), projectionFields);
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this
        || obj instanceof DatastoreBackupOptions
            && Objects.equals(
                projectionFields, ((DatastoreBackupOptions) obj).getProjectionFields());
  }
}
