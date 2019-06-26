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

import com.google.api.services.bigquery.model.StandardSqlField;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.Objects;

public class StandardSQLField implements Serializable {

    static final Function<StandardSqlField, StandardSQLField> FROM_PB_FUNCTION =
            new Function<StandardSqlField, StandardSQLField>() {
                @Override
                public StandardSQLField apply(StandardSqlField pb) {
                    return StandardSQLField.fromPb(pb);
                }
            };
    static final Function<StandardSQLField, StandardSqlField> TO_PB_FUNCTION =
            new Function<StandardSQLField, StandardSqlField>() {
                @Override
                public StandardSqlField apply(StandardSQLField field) {
                    return field.toPb();
                }
            };

    private final String name;
    private final StandardSQLDataType dataType;

    public abstract static class Builder {

        public abstract Builder setName(String name);

        public abstract Builder setDataType(StandardSQLDataType dataType);

        public abstract StandardSQLField build();
    }

    static class BuilderImpl extends Builder {

        private String name;
        private StandardSQLDataType dataType;

        BuilderImpl() {}

        BuilderImpl(StandardSQLField field) {
            this.name = field.name;
            this.dataType = field.dataType;
        }

        BuilderImpl(StandardSqlField fieldPb) {
            this.name = fieldPb.getName();
            this.dataType = StandardSQLDataType.fromPb(fieldPb.getType());
        }

        @Override
        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        @Override
        public Builder setDataType(StandardSQLDataType dataType) {
            this.dataType = dataType;
            return this;
        }

        @Override
        public StandardSQLField build() {
            return new StandardSQLField(this);
        }
    }

    StandardSQLField(BuilderImpl builder) {
        this.name = builder.name;
        this.dataType = builder.dataType;
    }

    public String getName() { return name; }

    public StandardSQLDataType getDataType() { return dataType; }

    public Builder toBuilder() { return new BuilderImpl(this); }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", name)
                .add("dataType", dataType)
                .toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                name,
                dataType
        );
    }

    @Override
    public boolean equals(Object obj) {
        return obj == this
                || obj != null
                && obj.getClass().equals(StandardSQLField.class)
                && Objects.equals(toPb(), ((StandardSQLField) obj).toPb());
    }

    public static Builder newBuilder(String name, StandardSQLDataType dataType) {
        return new BuilderImpl().setDataType(dataType).setName(name);
    }

    public static Builder newBuilder(StandardSQLDataType dataType) {
        return new BuilderImpl().setDataType(dataType);
    }

    public StandardSqlField toPb() {
        StandardSqlField fieldPb = new StandardSqlField();
        fieldPb.setName(name);
        if (dataType != null) {
            fieldPb.setType(dataType.toPb());
        }
        return fieldPb;
    }

    static StandardSQLField fromPb(StandardSqlField fieldPb) {
        return new BuilderImpl(fieldPb).build();
    }


}
