/*
 * Copyright 2025 Google LLC
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

package com.google.shopping.merchant.datasources.v1.stub;

import static com.google.shopping.merchant.datasources.v1.DataSourcesServiceClient.ListDataSourcesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.protobuf.Empty;
import com.google.shopping.merchant.datasources.v1.CreateDataSourceRequest;
import com.google.shopping.merchant.datasources.v1.DataSource;
import com.google.shopping.merchant.datasources.v1.DeleteDataSourceRequest;
import com.google.shopping.merchant.datasources.v1.FetchDataSourceRequest;
import com.google.shopping.merchant.datasources.v1.GetDataSourceRequest;
import com.google.shopping.merchant.datasources.v1.ListDataSourcesRequest;
import com.google.shopping.merchant.datasources.v1.ListDataSourcesResponse;
import com.google.shopping.merchant.datasources.v1.UpdateDataSourceRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the DataSourcesService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class DataSourcesServiceStub implements BackgroundResource {

  public UnaryCallable<GetDataSourceRequest, DataSource> getDataSourceCallable() {
    throw new UnsupportedOperationException("Not implemented: getDataSourceCallable()");
  }

  public UnaryCallable<ListDataSourcesRequest, ListDataSourcesPagedResponse>
      listDataSourcesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listDataSourcesPagedCallable()");
  }

  public UnaryCallable<ListDataSourcesRequest, ListDataSourcesResponse> listDataSourcesCallable() {
    throw new UnsupportedOperationException("Not implemented: listDataSourcesCallable()");
  }

  public UnaryCallable<CreateDataSourceRequest, DataSource> createDataSourceCallable() {
    throw new UnsupportedOperationException("Not implemented: createDataSourceCallable()");
  }

  public UnaryCallable<UpdateDataSourceRequest, DataSource> updateDataSourceCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDataSourceCallable()");
  }

  public UnaryCallable<DeleteDataSourceRequest, Empty> deleteDataSourceCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteDataSourceCallable()");
  }

  public UnaryCallable<FetchDataSourceRequest, Empty> fetchDataSourceCallable() {
    throw new UnsupportedOperationException("Not implemented: fetchDataSourceCallable()");
  }

  @Override
  public abstract void close();
}
