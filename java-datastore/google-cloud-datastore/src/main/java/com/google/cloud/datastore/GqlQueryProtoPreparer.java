/*
 * Copyright 2022 Google LLC
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
package com.google.cloud.datastore;

import com.google.api.core.InternalApi;
import com.google.cloud.datastore.GqlQuery.Binding;
import com.google.cloud.datastore.execution.request.ProtoPreparer;
import java.util.Map;

@InternalApi
public class GqlQueryProtoPreparer
    implements ProtoPreparer<GqlQuery<?>, com.google.datastore.v1.GqlQuery> {

  @Override
  public com.google.datastore.v1.GqlQuery prepare(GqlQuery<?> gqlQuery) {
    com.google.datastore.v1.GqlQuery.Builder queryPb =
        com.google.datastore.v1.GqlQuery.newBuilder();

    queryPb.setQueryString(gqlQuery.getQueryString());
    queryPb.setAllowLiterals(gqlQuery.allowLiteral());
    for (Map.Entry<String, Binding> entry : gqlQuery.getNamedBindingsMap().entrySet()) {
      queryPb.putNamedBindings(entry.getKey(), entry.getValue().toPb());
    }
    for (Binding argument : gqlQuery.getPositionalBindingsMap()) {
      queryPb.addPositionalBindings(argument.toPb());
    }

    return queryPb.build();
  }
}
