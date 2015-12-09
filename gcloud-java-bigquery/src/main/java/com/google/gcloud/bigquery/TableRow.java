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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.client.util.Lists;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Google BigQuery Table Row class. Objects of this class contain a list of {@link FieldValue}, one
 * for each field in the table.
 */
public class TableRow implements Serializable {

  static final Function<com.google.api.services.bigquery.model.TableRow, TableRow>
      FROM_PB_FUNCTION = new Function<com.google.api.services.bigquery.model.TableRow, TableRow>() {
        @Override
        public TableRow apply(com.google.api.services.bigquery.model.TableRow pb) {
          return TableRow.fromPb(pb);
        }
      };
  private static final long serialVersionUID = 1770751621297868029L;

  private final List<FieldValue> values;

  static final class Builder {

    private List<FieldValue> values;

    Builder() {}

    Builder values(List<FieldValue> values) {
      this.values = Lists.newArrayList(checkNotNull(values));
      return this;
    }

    Builder addValue(FieldValue fieldValue) {
      checkNotNull(fieldValue);
      if (values == null) {
        values = Lists.newArrayList();
      }
      values.add(fieldValue);
      return this;
    }

    TableRow build() {
      return new TableRow(this);
    }
  }

  TableRow(Builder builder) {
    this.values = ImmutableList.copyOf(builder.values);
  }

  /**
   * Returns table row data as a list of {@link FieldValue}.
   */
  public List<FieldValue> values() {
    return values;
  }

  @Override
  public String toString() {
    return values.toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(values);
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof TableRow && Objects.equals(values, ((TableRow) obj).values);
  }

  static TableRow fromPb(com.google.api.services.bigquery.model.TableRow rowPb) {
    Builder builder = new Builder();
    for (com.google.api.services.bigquery.model.TableCell cellPb : rowPb.getF()) {
      builder.addValue(FieldValue.fromPb(cellPb.getV()));
    }
    return builder.build();
  }
}
