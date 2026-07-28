/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.data.v2.internal;

import com.google.api.core.InternalApi;
import com.google.auto.value.AutoValue;
import com.google.bigtable.v2.Type;
import com.google.cloud.bigtable.data.v2.models.sql.SqlType;
import java.util.HashMap;
import java.util.Map;

/**
 * Internal representation of PrepareQueryRequest that handles conversion from user-facing types to
 * proto.
 *
 * <p>This is considered an internal implementation detail and should not be used by applications.
 */
@InternalApi("For internal use only")
@AutoValue
public abstract class PrepareQueryRequest {

  public abstract String query();

  public abstract Map<String, SqlType<?>> paramTypes();

  public static PrepareQueryRequest create(String query, Map<String, SqlType<?>> paramTypes) {
    return new AutoValue_PrepareQueryRequest(query, paramTypes);
  }

  public com.google.bigtable.v2.PrepareQueryRequest toProto(RequestContext requestContext) {
    HashMap<String, Type> protoParamTypes = new HashMap<>(paramTypes().size());
    for (Map.Entry<String, SqlType<?>> entry : paramTypes().entrySet()) {
      Type proto = QueryParamUtil.convertToQueryParamProto(entry.getValue());
      protoParamTypes.put(entry.getKey(), proto);
    }

    return com.google.bigtable.v2.PrepareQueryRequest.newBuilder()
        .setInstanceName(
            NameUtil.formatInstanceName(
                requestContext.getProjectId(), requestContext.getInstanceId()))
        .setAppProfileId(requestContext.getAppProfileId())
        .setQuery(query())
        .putAllParamTypes(protoParamTypes)
        .build();
  }
}
