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

import com.google.api.services.bigquery.model.TableFieldSchema;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Google BigQuery Table schema fields (columns). Each field has a unique name and index. Fields
 * with duplicate names are not allowed in BigQuery schema.
 */
public final class FieldList extends AbstractList<Field> implements Serializable {

  private static final long serialVersionUID = 8736258375638733316L;

  private final List<Field> fields;
  private final Map<String, Integer> nameIndex;

  private FieldList(Iterable<Field> fields) {
    this.fields = ImmutableList.copyOf(fields);
    int size = this.fields.size();
    // Pre-store both exact-case (e.g., "UserName") and lowercase ("username") keys once when
    // building the schema. getIndex(name) runs on every row cell access, so probing a single map
    // first avoids allocating a lowercased String or scanning characters on each lookup.
    // Iterates materialized this.fields (by index) so lazy Iterable inputs run only once.
    Map<String, Integer> indexMap = Maps.newHashMapWithExpectedSize(size * 2);
    boolean hasCaseCollision = false;
    for (int i = 0; i < size; i++) {
      String name = this.fields.get(i).getName();
      String lowerName = name.toLowerCase(Locale.ROOT);
      if (indexMap.put(lowerName, i) != null) {
        hasCaseCollision = true;
      }
      if (!name.equals(lowerName)) {
        indexMap.put(name, i);
      }
    }
    if (hasCaseCollision) {
      // Previously, nameIndex only stored lowercase keys, so a duplicate case-insensitive field
      // (e.g., "FOO" at index 0 followed by "foo" at index 1) caused both names to resolve to 1.
      // Because exact-case keys are stored separately above, rewrite them to match that
      // last-writer-wins behavior whenever a collision occurs.
      for (int i = 0; i < size; i++) {
        String name = this.fields.get(i).getName();
        String lowerName = name.toLowerCase(Locale.ROOT);
        if (!name.equals(lowerName)) {
          indexMap.put(name, indexMap.get(lowerName));
        }
      }
    }

    this.nameIndex = indexMap;
  }

  /**
   * Get schema field by index.
   *
   * @param index field (column) index
   */
  @Override
  public Field get(int index) {
    return fields.get(index);
  }

  /**
   * Get schema field by name.
   *
   * @param name field (column) name
   */
  public Field get(String name) {
    return get(getIndex(name));
  }

  /**
   * Get schema field's index by name.
   *
   * @param name field (column) name
   */
  public int getIndex(String name) {
    Integer index = nameIndex.get(name);
    if (index == null) {
      // Exact schema names and all-lowercase names hit above without allocation; only callers
      // passing another casing (e.g., "uSeRnAmE") or an unknown column fall back here.
      index = nameIndex.get(name.toLowerCase(Locale.ROOT));
      if (index == null) {
        throw new IllegalArgumentException("Field with name '" + name + "' was not found");
      }
    }
    return index;
  }

  /** Total number of fields (columns) in the schema. */
  @Override
  public int size() {
    return fields.size();
  }

  /**
   * Returns a new {@code FieldList} object, which contains a collection of {@code Field} objects in
   * preserved order and represent schema columns.
   *
   * @param fields the schema fields
   */
  public static FieldList of(Field... fields) {
    return new FieldList(ImmutableList.copyOf(fields));
  }

  /**
   * Returns a new {@code FieldList} object, which contains a collection of {@code Field} objects in
   * preserved order and represent schema columns.
   *
   * @param fields the schema fields
   */
  public static FieldList of(Iterable<Field> fields) {
    // FieldList is immutable, so reuse it directly (e.g., when Schema.fromPb passes
    // FieldList.fromPb(fields) into Schema.of) instead of rebuilding this.fields and nameIndex.
    if (fields instanceof FieldList) {
      return (FieldList) fields;
    }
    return new FieldList(fields);
  }

  List<TableFieldSchema> toPb() {
    return Lists.transform(fields, Field.TO_PB_FUNCTION);
  }

  static FieldList fromPb(List<TableFieldSchema> fields) {
    // Eagerly convert each field instead of wrapping in Lists.transform so every field and
    // nested RECORD subtree is deserialized once with pre-sized storage.
    ImmutableList.Builder<Field> builder = ImmutableList.builderWithExpectedSize(fields.size());
    for (TableFieldSchema fieldPb : fields) {
      builder.add(Field.fromPb(fieldPb));
    }
    return new FieldList(builder.build());
  }
}
