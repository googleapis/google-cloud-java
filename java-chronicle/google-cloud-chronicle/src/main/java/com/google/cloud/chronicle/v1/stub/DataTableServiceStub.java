/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.chronicle.v1.stub;

import static com.google.cloud.chronicle.v1.DataTableServiceClient.ListDataTableRowsPagedResponse;
import static com.google.cloud.chronicle.v1.DataTableServiceClient.ListDataTablesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.chronicle.v1.BulkCreateDataTableRowsRequest;
import com.google.cloud.chronicle.v1.BulkCreateDataTableRowsResponse;
import com.google.cloud.chronicle.v1.BulkGetDataTableRowsRequest;
import com.google.cloud.chronicle.v1.BulkGetDataTableRowsResponse;
import com.google.cloud.chronicle.v1.BulkReplaceDataTableRowsRequest;
import com.google.cloud.chronicle.v1.BulkReplaceDataTableRowsResponse;
import com.google.cloud.chronicle.v1.BulkUpdateDataTableRowsRequest;
import com.google.cloud.chronicle.v1.BulkUpdateDataTableRowsResponse;
import com.google.cloud.chronicle.v1.CreateDataTableRequest;
import com.google.cloud.chronicle.v1.CreateDataTableRowRequest;
import com.google.cloud.chronicle.v1.DataTable;
import com.google.cloud.chronicle.v1.DataTableOperationErrors;
import com.google.cloud.chronicle.v1.DataTableRow;
import com.google.cloud.chronicle.v1.DeleteDataTableRequest;
import com.google.cloud.chronicle.v1.DeleteDataTableRowRequest;
import com.google.cloud.chronicle.v1.GetDataTableOperationErrorsRequest;
import com.google.cloud.chronicle.v1.GetDataTableRequest;
import com.google.cloud.chronicle.v1.GetDataTableRowRequest;
import com.google.cloud.chronicle.v1.ListDataTableRowsRequest;
import com.google.cloud.chronicle.v1.ListDataTableRowsResponse;
import com.google.cloud.chronicle.v1.ListDataTablesRequest;
import com.google.cloud.chronicle.v1.ListDataTablesResponse;
import com.google.cloud.chronicle.v1.UpdateDataTableRequest;
import com.google.cloud.chronicle.v1.UpdateDataTableRowRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the DataTableService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class DataTableServiceStub implements BackgroundResource {

  public UnaryCallable<CreateDataTableRequest, DataTable> createDataTableCallable() {
    throw new UnsupportedOperationException("Not implemented: createDataTableCallable()");
  }

  public UnaryCallable<ListDataTablesRequest, ListDataTablesPagedResponse>
      listDataTablesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listDataTablesPagedCallable()");
  }

  public UnaryCallable<ListDataTablesRequest, ListDataTablesResponse> listDataTablesCallable() {
    throw new UnsupportedOperationException("Not implemented: listDataTablesCallable()");
  }

  public UnaryCallable<GetDataTableRequest, DataTable> getDataTableCallable() {
    throw new UnsupportedOperationException("Not implemented: getDataTableCallable()");
  }

  public UnaryCallable<UpdateDataTableRequest, DataTable> updateDataTableCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDataTableCallable()");
  }

  public UnaryCallable<DeleteDataTableRequest, Empty> deleteDataTableCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteDataTableCallable()");
  }

  public UnaryCallable<CreateDataTableRowRequest, DataTableRow> createDataTableRowCallable() {
    throw new UnsupportedOperationException("Not implemented: createDataTableRowCallable()");
  }

  public UnaryCallable<UpdateDataTableRowRequest, DataTableRow> updateDataTableRowCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDataTableRowCallable()");
  }

  public UnaryCallable<ListDataTableRowsRequest, ListDataTableRowsPagedResponse>
      listDataTableRowsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listDataTableRowsPagedCallable()");
  }

  public UnaryCallable<ListDataTableRowsRequest, ListDataTableRowsResponse>
      listDataTableRowsCallable() {
    throw new UnsupportedOperationException("Not implemented: listDataTableRowsCallable()");
  }

  public UnaryCallable<GetDataTableRowRequest, DataTableRow> getDataTableRowCallable() {
    throw new UnsupportedOperationException("Not implemented: getDataTableRowCallable()");
  }

  public UnaryCallable<DeleteDataTableRowRequest, Empty> deleteDataTableRowCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteDataTableRowCallable()");
  }

  public UnaryCallable<BulkCreateDataTableRowsRequest, BulkCreateDataTableRowsResponse>
      bulkCreateDataTableRowsCallable() {
    throw new UnsupportedOperationException("Not implemented: bulkCreateDataTableRowsCallable()");
  }

  public UnaryCallable<BulkGetDataTableRowsRequest, BulkGetDataTableRowsResponse>
      bulkGetDataTableRowsCallable() {
    throw new UnsupportedOperationException("Not implemented: bulkGetDataTableRowsCallable()");
  }

  public UnaryCallable<BulkReplaceDataTableRowsRequest, BulkReplaceDataTableRowsResponse>
      bulkReplaceDataTableRowsCallable() {
    throw new UnsupportedOperationException("Not implemented: bulkReplaceDataTableRowsCallable()");
  }

  public UnaryCallable<BulkUpdateDataTableRowsRequest, BulkUpdateDataTableRowsResponse>
      bulkUpdateDataTableRowsCallable() {
    throw new UnsupportedOperationException("Not implemented: bulkUpdateDataTableRowsCallable()");
  }

  public UnaryCallable<GetDataTableOperationErrorsRequest, DataTableOperationErrors>
      getDataTableOperationErrorsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getDataTableOperationErrorsCallable()");
  }

  @Override
  public abstract void close();
}
