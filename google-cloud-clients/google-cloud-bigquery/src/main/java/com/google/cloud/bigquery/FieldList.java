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
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.List;
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
    ImmutableMap.Builder<String, Integer> nameIndexBuilder = ImmutableMap.builder();
    int index = 0;
    for (Field field : fields) {
      nameIndexBuilder.put(field.getName(), index);
      index++;
    }

    this.nameIndex = nameIndexBuilder.build();
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
      throw new IllegalArgumentException("Field with name '" + name + "' was not found");
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
    return new FieldList(fields);
  }

  List<TableFieldSchema> toPb() {
    return Lists.transform(fields, Field.TO_PB_FUNCTION);
  }

  static FieldList fromPb(List<TableFieldSchema> fields) {
    return FieldList.of(Lists.transform(fields, Field.FROM_PB_FUNCTION));
  }
}
