// Copyright 2022 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.api.generator.gapic.model;

import com.google.auto.value.AutoValue;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import java.util.List;

/**
 * This model represents routing rules configured in rpc services. It will be used for generating
 * the logic to match-and-extract field values from request, the extracted values will be
 * concatenated to a request header that is used for routing purposes.
 */
@AutoValue
public abstract class RoutingHeaderRule {

  public abstract ImmutableList<RoutingHeaderParam> routingHeaderParams();

  public static Builder builder() {
    return new AutoValue_RoutingHeaderRule.Builder().setRoutingHeaderParams(ImmutableList.of());
  }

  @AutoValue
  public abstract static class RoutingHeaderParam {

    public abstract String fieldName();

    public abstract String key();

    public abstract String pattern();

    public static RoutingHeaderParam create(String field, String key, String pattern) {
      return new AutoValue_RoutingHeaderRule_RoutingHeaderParam(field, key, pattern);
    }

    public List<String> getDescendantFieldNames() {
      return Splitter.on(".").splitToList(fieldName());
    }
  }

  @AutoValue.Builder
  public abstract static class Builder {
    abstract ImmutableList.Builder<RoutingHeaderParam> routingHeaderParamsBuilder();

    public final Builder addParam(RoutingHeaderParam routingHeaderParam) {
      routingHeaderParamsBuilder().add(routingHeaderParam);
      return this;
    }

    public abstract Builder setRoutingHeaderParams(
        ImmutableList<RoutingHeaderParam> routingHeaderParams);

    public abstract RoutingHeaderRule build();
  }
}
