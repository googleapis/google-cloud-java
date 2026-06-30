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
import com.google.cloud.datastore.Query.ResultType;

/** An internal marker interface to represent {@link Query} that returns the entity records. */
@InternalApi
public interface RecordQuery<V> {

  @InternalApi
  ResultType<V> getType();

  @InternalApi
  void populatePb(com.google.datastore.v1.RunQueryRequest.Builder requestPb);

  @InternalApi
  RecordQuery<V> nextQuery(com.google.datastore.v1.RunQueryResponse responsePb);
}
