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
import java.io.Serializable;
import java.util.Objects;

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
        public abstract Builder setName(String name);
        public abstract Builder setKind(String kind);
        public abstract Builder setMode(String mode);
        public abstract Builder setDataType(StandardSQLDataType dataType);
        public abstract RoutineArgument build();
    }

    @Nullable
    public abstract String getName();

    @Nullable
    public abstract String getKind();

    @Nullable
    public abstract String getMode();

    @Nullable
    public abstract StandardSQLDataType getDataType();

    public abstract Builder toBuilder();

    public static Builder newBuilder() { return new AutoValue_RoutineArgument.Builder(); }

    Argument toPb() {
        Argument argumentPb = new Argument()
                .setName(getName())
                .setArgumentKind(getKind())
                .setMode(getMode());
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
