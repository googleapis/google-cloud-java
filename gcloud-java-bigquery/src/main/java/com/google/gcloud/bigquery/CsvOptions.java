/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.gcloud.bigquery;

import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.Objects;

/**
 * Google BigQuery CSV options. This class wraps some properties of CSV files used by BigQuery to
 * parse external data.
 */
public class CsvOptions implements Serializable {

  private static final long serialVersionUID = 2193570529308612708L;

  private final Boolean allowJaggedRows;
  private final Boolean allowQuotedNewLines;
  private final String encoding;
  private final String fieldDelimiter;
  private final String quote;
  private final Integer skipLeadingRows;

  public static final class Builder {

    private Boolean allowJaggedRows;
    private Boolean allowQuotedNewLines;
    private String encoding;
    private String fieldDelimiter;
    private String quote;
    private Integer skipLeadingRows;

    private Builder() {}

    /**
     * Set whether BigQuery should accept rows that are missing trailing optional columns. If
     * {@code true}, BigQuery treats missing trailing columns as null values. If {@code false},
     * records with missing trailing columns are treated as bad records, and if there are too many
     * bad records, an invalid error is returned in the job result. By default, rows with missing
     * trailing columns are considered bad records.
     */
    public Builder allowJaggedRows(Boolean allowJaggedRows) {
      this.allowJaggedRows = allowJaggedRows;
      return this;
    }

    /**
     * Sets whether BigQuery should allow quoted data sections that contain newline characters in a
     * CSV file. By default quoted newline are not allowed.
     */
    public Builder allowQuotedNewLines(Boolean allowQuotedNewLines) {
      this.allowQuotedNewLines = allowQuotedNewLines;
      return this;
    }

    /**
     * Sets the character encoding of the data. The supported values are UTF-8 or ISO-8859-1. The
     * default value is UTF-8. BigQuery decodes the data after the raw, binary data has been split
     * using the values set in {@link #quote(String)} and {@link #fieldDelimiter(String)}.
     */
    public Builder encoding(String encoding) {
      this.encoding = encoding;
      return this;
    }

    /**
     * Sets the separator for fields in a CSV file. BigQuery converts the string to ISO-8859-1
     * encoding, and then uses the first byte of the encoded string to split the data in its raw,
     * binary state. BigQuery also supports the escape sequence "\t" to specify a tab separator.
     * The default value is a comma (',').
     */
    public Builder fieldDelimiter(String fieldDelimiter) {
      this.fieldDelimiter = fieldDelimiter;
      return this;
    }

    /**
     * Sets the value that is used to quote data sections in a CSV file. BigQuery converts the
     * string to ISO-8859-1 encoding, and then uses the first byte of the encoded string to split
     * the data in its raw, binary state. The default value is a double-quote ('"'). If your data
     * does not contain quoted sections, set the property value to an empty string. If your data
     * contains quoted newline characters, you must also set {@link #allowQuotedNewLines(Boolean)}
     * property to {@code true}.
     */
    public Builder quote(String quote) {
      this.quote = quote;
      return this;
    }

    /**
     * Sets the number of rows at the top of a CSV file that BigQuery will skip when reading the
     * data. The default value is 0. This property is useful if you have header rows in the file
     * that should be skipped.
     */
    public Builder skipLeadingRows(Integer skipLeadingRows) {
      this.skipLeadingRows = skipLeadingRows;
      return this;
    }

    /**
     * Creates an {@code ExternalDataConfiguration} object.
     */
    public CsvOptions build() {
      return new CsvOptions(this);
    }
  }

  private CsvOptions(Builder builder) {
    this.allowJaggedRows = builder.allowJaggedRows;
    this.allowQuotedNewLines = builder.allowQuotedNewLines;
    this.encoding = builder.encoding;
    this.fieldDelimiter = builder.fieldDelimiter;
    this.quote = builder.quote;
    this.skipLeadingRows = builder.skipLeadingRows;
  }

  /**
   * Returns whether BigQuery should accept rows that are missing trailing optional columns. If
   * {@code true}, BigQuery treats missing trailing columns as null values. If {@code false},
   * records with missing trailing columns are treated as bad records, and if there are too many
   * bad records, an invalid error is returned in the job result.
   */
  public Boolean allowJaggedRows() {
    return allowJaggedRows;
  }

  /**
   * Returns whether BigQuery should allow quoted data sections that contain newline characters in a
   * CSV file.
   */
  public Boolean allowQuotedNewLines() {
    return allowQuotedNewLines;
  }

  /**
   * Returns the character encoding of the data. The supported values are UTF-8 or ISO-8859-1. The
   * default value is UTF-8. BigQuery decodes the data after the raw, binary data has been split
   * using the values set in {@link #quote()} and {@link #fieldDelimiter()}.
   */
  public String encoding() {
    return encoding;
  }

  /**
   * Returns the separator for fields in a CSV file.
   */
  public String fieldDelimiter() {
    return fieldDelimiter;
  }

  /**
   * Returns the value that is used to quote data sections in a CSV file.
   */
  public String quote() {
    return quote;
  }

  /**
   * Returns the number of rows at the top of a CSV file that BigQuery will skip when reading the
   * data.
   */
  public Integer skipLeadingRows() {
    return skipLeadingRows;
  }

  public Builder toBuilder() {
    return new Builder()
        .allowJaggedRows(allowJaggedRows)
        .allowQuotedNewLines(allowQuotedNewLines)
        .encoding(encoding)
        .fieldDelimiter(fieldDelimiter)
        .quote(quote)
        .skipLeadingRows(skipLeadingRows);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("allowJaggedRows", allowJaggedRows)
        .add("allowQuotedNewLines", allowQuotedNewLines)
        .add("encoding", encoding)
        .add("fieldDelimiter", fieldDelimiter)
        .add("quote", quote)
        .add("skipLeadingRows", skipLeadingRows)
        .toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(allowJaggedRows, allowQuotedNewLines, encoding, fieldDelimiter, quote,
        skipLeadingRows);
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof CsvOptions && Objects.equals(toPb(), ((CsvOptions) obj).toPb());
  }

  com.google.api.services.bigquery.model.CsvOptions toPb() {
    com.google.api.services.bigquery.model.CsvOptions csvOptions =
        new com.google.api.services.bigquery.model.CsvOptions();
    if (allowJaggedRows != null) {
      csvOptions.setAllowJaggedRows(allowJaggedRows);
    }
    if (allowQuotedNewLines != null) {
      csvOptions.setAllowQuotedNewlines(allowQuotedNewLines);
    }
    if (encoding != null) {
      csvOptions.setEncoding(encoding);
    }
    if (fieldDelimiter != null) {
      csvOptions.setFieldDelimiter(fieldDelimiter);
    }
    if (quote != null) {
      csvOptions.setQuote(quote);
    }
    if (skipLeadingRows != null) {
      csvOptions.setSkipLeadingRows(skipLeadingRows);
    }
    return csvOptions;
  }

  /**
   * Returns a builder for a CsvOptions object.
   */
  public static Builder builder() {
    return new Builder();
  }

  static CsvOptions fromPb(com.google.api.services.bigquery.model.CsvOptions csvOptions) {
    Builder builder = builder();
    if (csvOptions.getAllowJaggedRows() != null) {
      builder.allowJaggedRows(csvOptions.getAllowJaggedRows());
    }
    if (csvOptions.getAllowQuotedNewlines() != null) {
      builder.allowQuotedNewLines(csvOptions.getAllowQuotedNewlines());
    }
    if (csvOptions.getEncoding() != null) {
      builder.encoding(csvOptions.getEncoding());
    }
    if (csvOptions.getFieldDelimiter() != null) {
      builder.fieldDelimiter(csvOptions.getFieldDelimiter());
    }
    if (csvOptions.getQuote() != null) {
      builder.quote(csvOptions.getQuote());
    }
    if (csvOptions.getSkipLeadingRows() != null) {
      builder.skipLeadingRows(csvOptions.getSkipLeadingRows());
    }
    return builder.build();
  }
}
