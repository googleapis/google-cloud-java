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

import com.google.api.services.bigquery.model.StandardSqlStructType;
import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkNotNull;

public final class StandardSQLStructType implements Serializable {

    private final List<StandardSQLField> fieldList;

    private StandardSQLStructType(BuilderImpl builder) {
        this.fieldList = builder.fieldList;
    }

    static StandardSQLStructType fromPb(com.google.api.services.bigquery.model.StandardSqlStructType structTypePb) {
        Builder builder = new StandardSQLStructType.BuilderImpl();
        if (structTypePb.getFields() == null) {
            builder.setFields(Collections.<StandardSQLField>emptyList());
        } else {
            builder.setFields(Lists.transform(structTypePb.getFields(), StandardSQLField.FROM_PB_FUNCTION));
        }
        return builder.build();
    }

    public List<StandardSQLField> getFields() {
        return fieldList;
    }

    @Override
    public boolean equals(Object obj) {
        return obj == this || obj instanceof StandardSQLStructType && Objects.equals(toPb(), ((StandardSQLStructType) obj).toPb());
    }

    @Override
    public int hashCode() {
        return Objects.hash(fieldList);
    }

    /**
     * Returns a builder for the StandardSQLStructType object.
     */
    public Builder toBuilder() {
        return new BuilderImpl(this);
    }

    @Override
    public String toString() {
        return toPb().toString();
    }

    public static Builder newBuilder(List<StandardSQLField> fieldList) {
        return new BuilderImpl().setFields(fieldList);
    }

    StandardSqlStructType toPb() {
        StandardSqlStructType structTypePb = new StandardSqlStructType();
        if (fieldList != null) {
            structTypePb.setFields(Lists.transform(fieldList, StandardSQLField.TO_PB_FUNCTION));
        }
        return structTypePb;
    }

    public abstract static class Builder {

        public abstract Builder setFields(List<StandardSQLField> fields);

        public abstract StandardSQLStructType build();

    }

    static class BuilderImpl extends Builder {

        private List<StandardSQLField> fieldList;

        BuilderImpl() {
        }

        BuilderImpl(StandardSQLStructType structType) {
            this.fieldList = structType.fieldList;
        }

        BuilderImpl(StandardSqlStructType structTypePb) {
            if (structTypePb.getFields() == null) {
                this.fieldList = Collections.emptyList();
            }
            this.fieldList = Lists.transform(structTypePb.getFields(), StandardSQLField.FROM_PB_FUNCTION);
        }

        @Override
        public Builder setFields(List<StandardSQLField> fieldList) {
            this.fieldList = checkNotNull(fieldList);
            return this;
        }

        @Override
        public StandardSQLStructType build() {
            return new StandardSQLStructType(this);
        }

    }

}
