/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

import com.google.common.collect.ImmutableList;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FieldValues extends AbstractList<FieldValue> implements Serializable {

  private static final long serialVersionUID = 2103346761764976902L;

  private final Fields schema;
  private final List<FieldValue> row;

  private FieldValues(List<FieldValue> row, Fields schema) {
    if (schema != null && row.size() != schema.size()) {
      throw new IllegalArgumentException("Row size and fields schema sizes should match");
    }
    this.row = ImmutableList.copyOf(row);
    this.schema = schema;
  }

  @Override
  public FieldValue get(int index) {
    return row.get(index);
  }

  public FieldValue get(String name) {
    if (schema == null) {
      throw new UnsupportedOperationException(
          "Retrieving field value by name is not supported when there is no fields schema provided");
    }
    return get(schema.getIndex(name));
  }

  @Override
  public int size() {
    return row.size();
  }

  static FieldValues of(List<FieldValue> row, Fields schema) {
    return new FieldValues(row, schema);
  }

  static FieldValues of(List<FieldValue> row, Field... schema) {
    return of(row, schema.length > 0 ? Fields.of(schema) : null);
  }

  static FieldValues fromPb(List<?> rowPb, Fields schema) {
    List<FieldValue> row = new ArrayList<>(rowPb.size());
    if (schema != null) {
      if (schema.size() != rowPb.size()) {
        throw new IllegalArgumentException("Row size and fields schema sizes should match");
      }
      Iterator<Field> schemaIter = schema.iterator();
      Iterator<?> rowPbIter = rowPb.iterator();
      while (rowPbIter.hasNext() && schemaIter.hasNext()) {
        row.add(FieldValue.fromPb(rowPbIter.next(), schemaIter.next()));
      }
    } else {
      for (Object cellPb : rowPb) {
        row.add(FieldValue.fromPb(cellPb, null));
      }
    }

    return FieldValues.of(row, schema);
  }
}
