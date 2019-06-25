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

import com.google.api.services.bigquery.model.StandardSqlDataType;
import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.Objects;

public class StandardSQLDataType implements Serializable {

    private final StandardSQLDataType arrayElementType;
    private final StandardSQLStructType structType;
    private final String typeKind;

    public abstract static class Builder {
        /** Sets the type of an array's elements, when the TypeKind is
         *  ARRAY.
         */
        public abstract Builder setArrayElementType(StandardSQLDataType arrayElementType);

        /** Sets the struct type definition (list of fields) when the
         * TypeKind is STRUCT.
         */
        public abstract Builder setStructType(StandardSQLStructType structType);

        /** Sets the top-level type of this data type.  Can be
         * any standard SQL data type.  For more information, see
         * https://cloud.google.com/bigquery/docs/reference/standard-sql/data-types
         */
        public abstract Builder setTypeKind(String typeKind);

        /** Creates a {@code StandardSQLDataType} object. */
        public abstract StandardSQLDataType build();

    }

    static class BuilderImpl extends Builder {

        private String typeKind;
        private StandardSQLDataType arrayElementType;
        private StandardSQLStructType structType;

        BuilderImpl() {}

        BuilderImpl(StandardSQLDataType dataType) {
            this.arrayElementType = dataType.arrayElementType;
            this.structType = dataType.structType;
            this.typeKind = dataType.typeKind;
        }

        BuilderImpl(StandardSqlDataType dataTypePb) {
            this.arrayElementType = StandardSQLDataType.fromPb(dataTypePb.getArrayElementType());
            this.structType = StandardSQLStructType.fromPb(dataTypePb.getStructType());
            this.typeKind = dataTypePb.getTypeKind();
        }

        @Override
        public Builder setArrayElementType(StandardSQLDataType arrayElementType) {
            this.arrayElementType = arrayElementType;
            return this;
        }

        @Override
        public Builder setStructType(StandardSQLStructType structType) {
            this.structType = structType;
            return this;
        }

        @Override
        public Builder setTypeKind(String typeKind) {
            this.typeKind = typeKind;
            return this;
        }

        @Override
        public StandardSQLDataType build() {
            return new StandardSQLDataType(this);
        }
    }

    StandardSQLDataType(BuilderImpl builder) {
        this.arrayElementType = builder.arrayElementType;
        this.structType = builder.structType;
        this.typeKind = builder.typeKind;
    }

    public Builder toBuilder() {
        return new BuilderImpl(this);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("arrayElementType", arrayElementType)
                .add("structType", structType)
                .add("typeKind", typeKind)
                .toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                typeKind,
                arrayElementType,
                structType
        );
    }

    @Override
    public boolean equals(Object obj) {
        return obj == this
                || obj != null
                && obj.getClass().equals(StandardSQLDataType.class)
                && Objects.equals(toPb(), ((StandardSQLDataType) obj).toPb());
    }

    public static Builder newBuilder(String typeKind) {
        return new BuilderImpl().setTypeKind(typeKind);
    }

    StandardSqlDataType toPb() {
        StandardSqlDataType dataTypePb = new StandardSqlDataType();
        dataTypePb.setArrayElementType(arrayElementType.toPb());
        dataTypePb.setStructType(structType.toPb());
        dataTypePb.setTypeKind(typeKind);
        return dataTypePb;
    }

    static StandardSQLDataType fromPb(StandardSqlDataType dataTypePb) {
        return new BuilderImpl(dataTypePb).build();
    }

}
