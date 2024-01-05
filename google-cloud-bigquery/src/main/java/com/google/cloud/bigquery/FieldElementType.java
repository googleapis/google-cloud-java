/*
 * Copyright 2024 Google LLC
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
import com.google.auto.value.AutoValue;
import java.io.Serializable;
import javax.annotation.Nullable;

@AutoValue
public abstract class FieldElementType implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * The subtype of the RANGE, if the field type is RANGE.
   *
   * @return value or {@code null} for none
   */
  @Nullable
  public abstract String getType();

  public abstract FieldElementType.Builder toBuilder();

  @AutoValue.Builder
  public abstract static class Builder {

    public abstract FieldElementType.Builder setType(String type);

    public abstract FieldElementType build();
  }

  public static Builder newBuilder() {
    return new AutoValue_FieldElementType.Builder();
  }

  TableFieldSchema.RangeElementType toPb() {
    TableFieldSchema.RangeElementType rangeElementTypePb = new TableFieldSchema.RangeElementType();
    rangeElementTypePb.setType(getType());
    return rangeElementTypePb;
  }

  static FieldElementType fromPb(TableFieldSchema.RangeElementType rangeElementTypePb) {
    // Treat a FieldElementType message without a Type subfield as invalid.
    if (rangeElementTypePb.getType() != null) {
      return newBuilder().setType(rangeElementTypePb.getType()).build();
    }
    return null;
  }
}
