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
import com.google.cloud.datastore.StructuredQuery.OrderBy;
import com.google.cloud.datastore.execution.request.ProtoPreparer;
import com.google.datastore.v1.Query;
import com.google.protobuf.Int32Value;

@InternalApi
public class StructuredQueryProtoPreparer implements ProtoPreparer<StructuredQuery<?>, Query> {

  @Override
  public Query prepare(StructuredQuery<?> query) {
    com.google.datastore.v1.Query.Builder queryPb = com.google.datastore.v1.Query.newBuilder();
    if (query.getKind() != null) {
      queryPb.addKindBuilder().setName(query.getKind());
    }
    if (query.getStartCursor() != null) {
      queryPb.setStartCursor(query.getStartCursor().getByteString());
    }
    if (query.getEndCursor() != null) {
      queryPb.setEndCursor(query.getEndCursor().getByteString());
    }
    if (query.getOffset() > 0) {
      queryPb.setOffset(query.getOffset());
    }
    if (query.getLimit() != null) {
      queryPb.setLimit(Int32Value.of(query.getLimit()));
    }
    if (query.getFilter() != null) {
      queryPb.setFilter(query.getFilter().toPb());
    }
    for (OrderBy value : query.getOrderBy()) {
      queryPb.addOrder(value.toPb());
    }
    for (String value : query.getDistinctOn()) {
      queryPb.addDistinctOn(
          com.google.datastore.v1.PropertyReference.newBuilder().setName(value).build());
    }
    for (String value : query.getProjection()) {
      com.google.datastore.v1.Projection expressionPb =
          com.google.datastore.v1.Projection.newBuilder()
              .setProperty(
                  com.google.datastore.v1.PropertyReference.newBuilder().setName(value).build())
              .build();
      queryPb.addProjection(expressionPb);
    }

    return queryPb.build();
  }
}
