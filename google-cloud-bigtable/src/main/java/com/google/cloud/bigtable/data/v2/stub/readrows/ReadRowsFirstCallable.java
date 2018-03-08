/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.bigtable.data.v2.stub.readrows;

import com.google.api.core.ApiFuture;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.bigtable.data.v2.models.Query;

/**
 * Enhancement for `readRowsCallable().first()` to gracefully limit the row count instead of
 * cancelling the RPC
 */
class ReadRowsFirstCallable<RowT> extends UnaryCallable<Query, RowT> {
  private final UnaryCallable<Query, RowT> inner;

  ReadRowsFirstCallable(UnaryCallable<Query, RowT> inner) {
    this.inner = inner;
  }

  @Override
  public ApiFuture<RowT> futureCall(Query query, ApiCallContext context) {
    return inner.futureCall(query.limit(1), context);
  }
}
