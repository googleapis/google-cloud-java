/*
 * Copyright 2018 Google LLC
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

import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableList;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Nullable;

@AutoValue
public abstract class Clustering implements Serializable {

  private static final long serialVersionUID = 1L;

  @Nullable
  abstract ImmutableList<String> getFieldsImmut();

  public List<String> getFields() {
    return getFieldsImmut();
  }

  public abstract Builder toBuilder();

  @AutoValue.Builder
  public abstract static class Builder {

    abstract Builder setFieldsImmut(ImmutableList<String> fieldsImmut);

    public Builder setFields(List<String> fields) {
      return setFieldsImmut(ImmutableList.copyOf(fields));
    }

    public abstract Clustering build();
  }

  public static Builder newBuilder() {
    return new AutoValue_Clustering.Builder();
  }

  com.google.api.services.bigquery.model.Clustering toPb() {
    com.google.api.services.bigquery.model.Clustering clusterPb =
        new com.google.api.services.bigquery.model.Clustering();
    clusterPb.setFields(getFields());
    return clusterPb;
  }

  static Clustering fromPb(com.google.api.services.bigquery.model.Clustering clusterPb) {
    return newBuilder().setFields(clusterPb.getFields()).build();
  }
}
