/*
 * Copyright 2020 Google LLC
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

package com.google.area120.tables.v1alpha1;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** AUTO-GENERATED DOCUMENTATION AND CLASS */
@javax.annotation.Generated("by GAPIC protoc plugin")
public class RowName implements ResourceName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("tables/{table}/rows/{row}");

  private volatile Map<String, String> fieldValuesMap;

  private final String table;
  private final String row;

  public String getTable() {
    return table;
  }

  public String getRow() {
    return row;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private RowName(Builder builder) {
    table = Preconditions.checkNotNull(builder.getTable());
    row = Preconditions.checkNotNull(builder.getRow());
  }

  public static RowName of(String table, String row) {
    return newBuilder().setTable(table).setRow(row).build();
  }

  public static String format(String table, String row) {
    return newBuilder().setTable(table).setRow(row).build().toString();
  }

  public static RowName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString, "RowName.parse: formattedString not in valid format");
    return of(matchMap.get("table"), matchMap.get("row"));
  }

  public static List<RowName> parseList(List<String> formattedStrings) {
    List<RowName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<RowName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (RowName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PATH_TEMPLATE.matches(formattedString);
  }

  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          fieldMapBuilder.put("table", table);
          fieldMapBuilder.put("row", row);
          fieldValuesMap = fieldMapBuilder.build();
        }
      }
    }
    return fieldValuesMap;
  }

  public String getFieldValue(String fieldName) {
    return getFieldValuesMap().get(fieldName);
  }

  @Override
  public String toString() {
    return PATH_TEMPLATE.instantiate("table", table, "row", row);
  }

  /** Builder for RowName. */
  public static class Builder {

    private String table;
    private String row;

    public String getTable() {
      return table;
    }

    public String getRow() {
      return row;
    }

    public Builder setTable(String table) {
      this.table = table;
      return this;
    }

    public Builder setRow(String row) {
      this.row = row;
      return this;
    }

    private Builder() {}

    private Builder(RowName rowName) {
      table = rowName.table;
      row = rowName.row;
    }

    public RowName build() {
      return new RowName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof RowName) {
      RowName that = (RowName) o;
      return (this.table.equals(that.table)) && (this.row.equals(that.row));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= table.hashCode();
    h *= 1000003;
    h ^= row.hashCode();
    return h;
  }
}
