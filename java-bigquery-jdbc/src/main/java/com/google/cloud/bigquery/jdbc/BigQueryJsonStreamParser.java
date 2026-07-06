/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc;

import static com.google.cloud.bigquery.jdbc.BigQueryBaseArray.isArray;
import static com.google.cloud.bigquery.jdbc.BigQueryBaseStruct.isStruct;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.api.core.InternalApi;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.FieldList;
import com.google.cloud.bigquery.FieldValue;
import com.google.cloud.bigquery.FieldValue.Attribute;
import com.google.cloud.bigquery.FieldValueList;
import com.google.cloud.bigquery.Schema;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Package-private streaming parser for BigQuery REST JSON responses.
 *
 * <p>This class extracts cell data into compact primitive row arrays ({@code Object[]}), bypassing
 * intermediate {@link FieldValueList} / {@link FieldValue} POJO allocations for primitive scalar
 * columns to drastically reduce JVM heap overhead and GC pause times.
 */
@InternalApi
class BigQueryJsonStreamParser {
  private static final JsonFactory JSON_FACTORY = new JsonFactory();

  private final FieldList fieldList;
  private final boolean[] isComplexColumn;

  BigQueryJsonStreamParser(Schema schema) {
    this.fieldList = schema == null ? null : schema.getFields();
    if (this.fieldList != null) {
      int size = this.fieldList.size();
      this.isComplexColumn = new boolean[size];
      for (int i = 0; i < size; i++) {
        Field field = this.fieldList.get(i);
        this.isComplexColumn[i] = isArray(field) || isStruct(field);
      }
    } else {
      this.isComplexColumn = new boolean[0];
    }
  }

  BigQueryJsonStreamParser(FieldList fieldList) {
    this.fieldList = fieldList;
    if (this.fieldList != null) {
      int size = this.fieldList.size();
      this.isComplexColumn = new boolean[size];
      for (int i = 0; i < size; i++) {
        Field field = this.fieldList.get(i);
        this.isComplexColumn[i] = isArray(field) || isStruct(field);
      }
    } else {
      this.isComplexColumn = new boolean[0];
    }
  }

  /**
   * Unpacks a {@link FieldValueList} row into a lightweight {@code Object[]} array, extracting raw
   * string/primitive values and immediately discarding {@link FieldValueList} references to reduce
   * heap memory pressure.
   */
  public Object[] unpackRow(FieldValueList fieldValueList) {
    if (fieldValueList == null) {
      return null;
    }
    int size = fieldValueList.size();
    Object[] row = new Object[size];
    for (int i = 0; i < size; i++) {
      FieldValue fv = fieldValueList.get(i);
      if (fv == null || fv.isNull()) {
        row[i] = null;
      } else if (i < isComplexColumn.length && isComplexColumn[i]) {
        // Retain FieldValue wrapper for complex ARRAY / STRUCT types
        row[i] = fv;
      } else {
        // Extract raw scalar string representation for primitives
        Object val = fv.getValue();
        row[i] = val == null ? null : val.toString();
      }
    }
    return row;
  }

  /** Parses a raw JSON InputStream returning a list of row arrays ({@code Object[]}). */
  public List<Object[]> parseStream(InputStream inputStream) throws IOException {
    List<Object[]> rows = new ArrayList<>();
    if (inputStream == null || fieldList == null) {
      return rows;
    }

    try (JsonParser parser = JSON_FACTORY.createParser(inputStream)) {
      while (!parser.isClosed()) {
        JsonToken token = parser.nextToken();
        if (token == JsonToken.FIELD_NAME && "rows".equals(parser.currentName())) {
          // Found "rows" array
          if (parser.nextToken() == JsonToken.START_ARRAY) {
            while (parser.nextToken() != JsonToken.END_ARRAY && !parser.isClosed()) {
              Object[] row = parseSingleRow(parser);
              if (row != null) {
                rows.add(row);
              }
            }
          }
          break;
        }
      }
    }
    return rows;
  }

  private Object[] parseSingleRow(JsonParser parser) throws IOException {
    // Expecting START_OBJECT for row: { "f": [...] }
    if (parser.currentToken() != JsonToken.START_OBJECT) {
      return null;
    }

    int colCount = fieldList.size();
    Object[] row = new Object[colCount];

    while (parser.nextToken() != JsonToken.END_OBJECT && !parser.isClosed()) {
      String fieldName = parser.currentName();
      if ("f".equals(fieldName)) {
        if (parser.nextToken() == JsonToken.START_ARRAY) {
          int colIdx = 0;
          while (parser.nextToken() != JsonToken.END_ARRAY && !parser.isClosed()) {
            if (colIdx < colCount) {
              row[colIdx] = parseCell(parser, colIdx);
            } else {
              skipValue(parser);
            }
            colIdx++;
          }
        }
      } else {
        skipValue(parser);
      }
    }
    return row;
  }

  private Object parseCell(JsonParser parser, int colIdx) throws IOException {
    // Cell structure: { "v": ... }
    if (parser.currentToken() != JsonToken.START_OBJECT) {
      return null;
    }

    Object cellValue = null;
    while (parser.nextToken() != JsonToken.END_OBJECT && !parser.isClosed()) {
      String name = parser.currentName();
      if ("v".equals(name)) {
        parser.nextToken(); // move to value token
        if (parser.currentToken() == JsonToken.VALUE_NULL) {
          cellValue = null;
        } else if (isComplexColumn[colIdx]) {
          // Complex type (ARRAY or STRUCT) fallback to FieldValue
          cellValue = parseComplexFieldValue(parser, fieldList.get(colIdx));
        } else {
          // Primitive scalar token
          cellValue = parser.getText();
        }
      } else {
        skipValue(parser);
      }
    }
    return cellValue;
  }

  private FieldValue parseComplexFieldValue(JsonParser parser, Field field) throws IOException {
    if (parser.currentToken() == JsonToken.VALUE_NULL) {
      return FieldValue.of(Attribute.PRIMITIVE, null);
    }
    if (isArray(field)) {
      List<FieldValue> elements = new ArrayList<>();
      if (parser.currentToken() == JsonToken.START_ARRAY) {
        Field elementField = field.toBuilder().setMode(Field.Mode.REQUIRED).build();
        while (parser.nextToken() != JsonToken.END_ARRAY && !parser.isClosed()) {
          // element is { "v": ... }
          elements.add(parseComplexFieldValue(parser, elementField));
        }
      }
      return FieldValue.of(Attribute.REPEATED, elements);
    } else if (isStruct(field)) {
      List<FieldValue> fields = new ArrayList<>();
      if (parser.currentToken() == JsonToken.START_OBJECT) {
        FieldList subFields = field.getSubFields();
        int subIdx = 0;
        while (parser.nextToken() != JsonToken.END_OBJECT && !parser.isClosed()) {
          if ("f".equals(parser.currentName()) && parser.nextToken() == JsonToken.START_ARRAY) {
            while (parser.nextToken() != JsonToken.END_ARRAY && !parser.isClosed()) {
              Field subField =
                  subFields != null && subIdx < subFields.size() ? subFields.get(subIdx) : null;
              fields.add(
                  subField != null
                      ? parseComplexFieldValue(parser, subField)
                      : FieldValue.of(Attribute.PRIMITIVE, null));
              subIdx++;
            }
          }
        }
      }
      return FieldValue.of(Attribute.RECORD, FieldValueList.of(fields, field.getSubFields()));
    } else {
      if (parser.currentToken() == JsonToken.START_OBJECT) {
        String val = null;
        while (parser.nextToken() != JsonToken.END_OBJECT && !parser.isClosed()) {
          if ("v".equals(parser.currentName())) {
            parser.nextToken();
            val = parser.currentToken() == JsonToken.VALUE_NULL ? null : parser.getText();
          } else {
            skipValue(parser);
          }
        }
        return FieldValue.of(Attribute.PRIMITIVE, val);
      } else {
        return FieldValue.of(Attribute.PRIMITIVE, parser.getText());
      }
    }
  }

  private void skipValue(JsonParser parser) throws IOException {
    JsonToken token = parser.currentToken();
    if (token == JsonToken.START_OBJECT || token == JsonToken.START_ARRAY) {
      parser.skipChildren();
    }
  }
}
