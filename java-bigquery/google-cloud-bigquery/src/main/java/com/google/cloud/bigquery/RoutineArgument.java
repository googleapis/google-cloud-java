/*
 * Copyright 2019 Google LLC
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

import com.google.api.services.bigquery.model.Argument;
import com.google.auto.value.AutoValue;
import com.google.common.base.Function;
import javax.annotation.Nullable;

/** An argument for a BigQuery Routine. */
@AutoValue
public abstract class RoutineArgument {

  static final Function<Argument, RoutineArgument> FROM_PB_FUNCTION =
      new Function<Argument, RoutineArgument>() {
        @Override
        public RoutineArgument apply(Argument pb) {
          return RoutineArgument.fromPb(pb);
        }
      };
  static final Function<RoutineArgument, Argument> TO_PB_FUNCTION =
      new Function<RoutineArgument, Argument>() {
        @Override
        public Argument apply(RoutineArgument argument) {
          return argument.toPb();
        }
      };

  @AutoValue.Builder
  public abstract static class Builder {
    /** Sets the argument name. */
    public abstract Builder setName(String name);

    /**
     * Sets the kind of argument.
     *
     * <p>A FIXED_TYPE argument is a fully specified type. It can be a struct or an array, but not a
     * table.
     *
     * <p>An ANY_TYPE argument is any type. It can be a struct or an array, but not a table.
     */
    public abstract Builder setKind(String kind);

    /**
     * Optionally specifies the input/output mode of the argument.
     *
     * <p>An IN mode argument is input-only. An OUT mode argument is output-only. An INOUT mode
     * argument is both an input and output.
     */
    public abstract Builder setMode(String mode);

    /**
     * Sets the data type specification for the argument. It is required except for ANY_TYPE
     * argument kinds.
     */
    public abstract Builder setDataType(StandardSQLDataType dataType);

    /** Creates a {@code RoutineArgument} object. */
    public abstract RoutineArgument build();
  }

  /** Returns the name of the argument. */
  @Nullable
  public abstract String getName();

  /** Returns the kind of the argument. */
  @Nullable
  public abstract String getKind();

  /** Returns the mode of the argument. */
  @Nullable
  public abstract String getMode();

  @Nullable
  public abstract StandardSQLDataType getDataType();

  /** Returns a builder pre-populated using the current values of this {@code RoutineArgument}. */
  public abstract Builder toBuilder();

  /** Returns a builder for a {@code RoutineArgument} object. */
  public static Builder newBuilder() {
    return new AutoValue_RoutineArgument.Builder();
  }

  Argument toPb() {
    Argument argumentPb =
        new Argument().setName(getName()).setArgumentKind(getKind()).setMode(getMode());
    if (getDataType() != null) {
      argumentPb.setDataType(getDataType().toPb());
    }
    return argumentPb;
  }

  static RoutineArgument fromPb(Argument argumentPb) {
    Builder builder = newBuilder();
    builder.setName(argumentPb.getName());
    builder.setKind(argumentPb.getArgumentKind());
    builder.setMode(argumentPb.getMode());
    if (argumentPb.getDataType() != null) {
      builder.setDataType(StandardSQLDataType.fromPb(argumentPb.getDataType()));
    }
    return builder.build();
  }
}
