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

package com.google.cloud;

import com.google.api.core.InternalApi;
import com.google.common.base.MoreObjects;

import java.util.Objects;

public class Condition {
    private String title;
    private String description;
    private String expression;

    public static class Builder {
        private String title;
        private String description;
        private String expression;


        @InternalApi("This class should only be extended within google-cloud-java")
        protected Builder() {}

        @InternalApi("This class should only be extended within google-cloud-java")
        protected Builder(Condition condition) {
            this.title = condition.title;
            this.description = condition.description;
            this.expression = condition.expression;
        }

        public final Condition.Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public final Condition.Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public final Condition.Builder setExpression(String expression) {
            this.expression = expression;
            return this;
        }


        /** Creates a {@code Condition} object. */
        public final Condition build() {
            return new Condition(this);
        }
    }

    private Condition(Condition.Builder builder) {
        this.title = builder.title;
        this.description = builder.description;
        this.expression = builder.expression;
    }

    public Condition.Builder toBuilder() {
        return new Condition.Builder(this);
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("title", title)
                .add("description", description)
                .add("expression", expression)
                .toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass(), title, description, expression);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Condition)) {
            return false;
        }
        Condition other = (Condition) obj;
        return Objects.equals(title, other.getTitle())
                && Objects.equals(description, other.getDescription())
                && Objects.equals(expression, other.getExpression());
    }

    /** Returns a builder for {@code Policy} objects. */
    public static Condition.Builder newBuilder() {
        return new Condition.Builder();
    }
}
