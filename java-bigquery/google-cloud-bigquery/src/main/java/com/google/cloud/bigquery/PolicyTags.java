/*
 * Copyright 2020 Google LLC
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
public abstract class PolicyTags implements Serializable {

  private static final long serialVersionUID = 1L;

  @Nullable
  abstract ImmutableList<String> getNamesImmut();

  public List<String> getNames() {
    return getNamesImmut();
  }

  public abstract Builder toBuilder();

  @AutoValue.Builder
  public abstract static class Builder {

    abstract Builder setNamesImmut(ImmutableList<String> namesImmut);

    public Builder setNames(List<String> names) {
      return setNamesImmut(ImmutableList.copyOf(names));
    }

    public abstract PolicyTags build();
  }

  public static Builder newBuilder() {
    return new AutoValue_PolicyTags.Builder();
  }

  com.google.api.services.bigquery.model.TableFieldSchema.PolicyTags toPb() {
    com.google.api.services.bigquery.model.TableFieldSchema.PolicyTags tagPb =
        new com.google.api.services.bigquery.model.TableFieldSchema.PolicyTags();
    tagPb.setNames(getNames());
    return tagPb;
  }

  static PolicyTags fromPb(
      com.google.api.services.bigquery.model.TableFieldSchema.PolicyTags tagPb) {
    // Treat a PolicyTag message without a Names subfield as invalid.
    if (tagPb.getNames() != null) {
      return newBuilder().setNames(tagPb.getNames()).build();
    }
    return null;
  }
}
