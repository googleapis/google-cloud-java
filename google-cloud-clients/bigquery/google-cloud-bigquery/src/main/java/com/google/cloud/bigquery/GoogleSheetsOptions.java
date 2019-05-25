/*
 * Copyright 2018 Google LLC
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
import java.util.Objects;

/** Google BigQuery options for the Google Sheets format. */
public final class GoogleSheetsOptions extends FormatOptions {

  private static final long serialVersionUID = 1837436979033106123L;

  private final Long skipLeadingRows;

  public static final class Builder {

    private Long skipLeadingRows;

    private Builder() {}

    private Builder(GoogleSheetsOptions options) {
      this.skipLeadingRows = options.skipLeadingRows;
    }

    /**
     * Sets the number of rows at the top of a sheet that BigQuery will skip when reading the data.
     * The default value is 0. This property is useful if you have header rows that should be
     * skipped.
     */
    public Builder setSkipLeadingRows(long skipLeadingRows) {
      this.skipLeadingRows = skipLeadingRows;
      return this;
    }

    /** Creates a {@link GoogleSheetsOptions} object. */
    public GoogleSheetsOptions build() {
      return new GoogleSheetsOptions(this);
    }
  }

  private GoogleSheetsOptions(Builder builder) {
    super(FormatOptions.GOOGLE_SHEETS);
    this.skipLeadingRows = builder.skipLeadingRows;
  }

  /**
   * Returns the number of rows at the top of a sheet that BigQuery will skip when reading the data.
   */
  public Long getSkipLeadingRows() {
    return skipLeadingRows;
  }

  /** Returns a builder for the {@link GoogleSheetsOptions} object. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("type", getType())
        .add("skipLeadingRows", skipLeadingRows)
        .toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getType(), skipLeadingRows);
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this
        || obj instanceof GoogleSheetsOptions
            && Objects.equals(toPb(), ((GoogleSheetsOptions) obj).toPb());
  }

  com.google.api.services.bigquery.model.GoogleSheetsOptions toPb() {
    com.google.api.services.bigquery.model.GoogleSheetsOptions options =
        new com.google.api.services.bigquery.model.GoogleSheetsOptions();
    options.setSkipLeadingRows(skipLeadingRows);
    return options;
  }

  /** Returns a builder for a {@link GoogleSheetsOptions} object. */
  public static Builder newBuilder() {
    return new Builder();
  }

  static GoogleSheetsOptions fromPb(
      com.google.api.services.bigquery.model.GoogleSheetsOptions options) {
    Builder builder = newBuilder();
    if (options.getSkipLeadingRows() != null) {
      builder.setSkipLeadingRows(options.getSkipLeadingRows());
    }
    return builder.build();
  }
}
