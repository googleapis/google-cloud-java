/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.firestore.pipeline.stages;

import static com.google.cloud.firestore.PipelineUtils.encodeValue;

import com.google.api.core.InternalApi;
import com.google.cloud.firestore.pipeline.expressions.AliasedWindowFunction;
import com.google.cloud.firestore.pipeline.expressions.Field;
import com.google.cloud.firestore.pipeline.expressions.WindowSpec;
import com.google.firestore.v1.Value;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@InternalApi
public final class AddWindowFields extends Stage {
  private static final String CREATE_TIME_ALIAS = "__create_time__";
  private static final String UPDATE_TIME_ALIAS = "__update_time__";

  private final WindowSpec window;
  private final AliasedWindowFunction[] fields;

  @InternalApi
  public AddWindowFields(WindowSpec window, AliasedWindowFunction[] fields) {
    this(window, fields, InternalOptions.EMPTY);
  }

  AddWindowFields(WindowSpec window, AliasedWindowFunction[] fields, InternalOptions options) {
    super("add_window_fields", options);
    this.window = window;
    this.fields = fields;

    Set<String> seenAliases = new HashSet<>();
    for (AliasedWindowFunction field : fields) {
      String alias = field.getAlias();
      if (Field.DOCUMENT_ID.equals(alias)) {
        throw new IllegalArgumentException("Alias " + Field.DOCUMENT_ID + " is reserved");
      }
      if (CREATE_TIME_ALIAS.equals(alias)) {
        throw new IllegalArgumentException("Alias " + CREATE_TIME_ALIAS + " is reserved");
      }
      if (UPDATE_TIME_ALIAS.equals(alias)) {
        throw new IllegalArgumentException("Alias " + UPDATE_TIME_ALIAS + " is reserved");
      }
      if (!seenAliases.add(alias)) {
        throw new IllegalArgumentException("Duplicate alias: '" + alias + "'");
      }
    }
  }

  @InternalApi
  public static AddWindowFields of(WindowSpec window, Object field, Object... additionalFields) {
    AliasedWindowFunction[] allFields = new AliasedWindowFunction[additionalFields.length + 1];
    allFields[0] = AliasedWindowFunction.toAliasedWindowFunction(field);
    for (int i = 0; i < additionalFields.length; i++) {
      allFields[i + 1] = AliasedWindowFunction.toAliasedWindowFunction(additionalFields[i]);
    }
    return new AddWindowFields(window, allFields);
  }

  private static Map<String, Value> toFieldMap(AliasedWindowFunction[] fields) {
    Map<String, Value> results = new LinkedHashMap<>();
    for (AliasedWindowFunction field : fields) {
      results.put(field.getAlias(), field.toProto());
    }
    return results;
  }

  @Override
  Iterable<Value> toStageArgs() {
    return Arrays.asList(window.buildInternal(), encodeValue(toFieldMap(fields)));
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (!(other instanceof AddWindowFields)) {
      return false;
    }
    AddWindowFields that = (AddWindowFields) other;
    if (!Objects.equals(window, that.window)) {
      return false;
    }
    if (!Arrays.equals(fields, that.fields)) {
      return false;
    }
    if (!Objects.equals(options, that.options)) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = window.hashCode();
    result = 31 * result + Arrays.hashCode(fields);
    result = 31 * result + options.hashCode();
    return result;
  }
}
