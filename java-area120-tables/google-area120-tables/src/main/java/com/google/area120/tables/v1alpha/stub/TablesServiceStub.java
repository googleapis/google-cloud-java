/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.area120.tables.v1alpha.stub;

import static com.google.area120.tables.v1alpha.TablesServiceClient.ListRowsPagedResponse;
import static com.google.area120.tables.v1alpha.TablesServiceClient.ListTablesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.area120.tables.v1alpha1.BatchCreateRowsRequest;
import com.google.area120.tables.v1alpha1.BatchCreateRowsResponse;
import com.google.area120.tables.v1alpha1.BatchUpdateRowsRequest;
import com.google.area120.tables.v1alpha1.BatchUpdateRowsResponse;
import com.google.area120.tables.v1alpha1.CreateRowRequest;
import com.google.area120.tables.v1alpha1.DeleteRowRequest;
import com.google.area120.tables.v1alpha1.GetRowRequest;
import com.google.area120.tables.v1alpha1.GetTableRequest;
import com.google.area120.tables.v1alpha1.ListRowsRequest;
import com.google.area120.tables.v1alpha1.ListRowsResponse;
import com.google.area120.tables.v1alpha1.ListTablesRequest;
import com.google.area120.tables.v1alpha1.ListTablesResponse;
import com.google.area120.tables.v1alpha1.Row;
import com.google.area120.tables.v1alpha1.Table;
import com.google.area120.tables.v1alpha1.UpdateRowRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the TablesService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class TablesServiceStub implements BackgroundResource {

  public UnaryCallable<GetTableRequest, Table> getTableCallable() {
    throw new UnsupportedOperationException("Not implemented: getTableCallable()");
  }

  public UnaryCallable<ListTablesRequest, ListTablesPagedResponse> listTablesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listTablesPagedCallable()");
  }

  public UnaryCallable<ListTablesRequest, ListTablesResponse> listTablesCallable() {
    throw new UnsupportedOperationException("Not implemented: listTablesCallable()");
  }

  public UnaryCallable<GetRowRequest, Row> getRowCallable() {
    throw new UnsupportedOperationException("Not implemented: getRowCallable()");
  }

  public UnaryCallable<ListRowsRequest, ListRowsPagedResponse> listRowsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listRowsPagedCallable()");
  }

  public UnaryCallable<ListRowsRequest, ListRowsResponse> listRowsCallable() {
    throw new UnsupportedOperationException("Not implemented: listRowsCallable()");
  }

  public UnaryCallable<CreateRowRequest, Row> createRowCallable() {
    throw new UnsupportedOperationException("Not implemented: createRowCallable()");
  }

  public UnaryCallable<BatchCreateRowsRequest, BatchCreateRowsResponse> batchCreateRowsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchCreateRowsCallable()");
  }

  public UnaryCallable<UpdateRowRequest, Row> updateRowCallable() {
    throw new UnsupportedOperationException("Not implemented: updateRowCallable()");
  }

  public UnaryCallable<BatchUpdateRowsRequest, BatchUpdateRowsResponse> batchUpdateRowsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchUpdateRowsCallable()");
  }

  public UnaryCallable<DeleteRowRequest, Empty> deleteRowCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteRowCallable()");
  }

  @Override
  public abstract void close();
}
