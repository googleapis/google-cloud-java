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

package com.google.cloud.biglake.hive.v1beta.stub;

import static com.google.cloud.biglake.hive.v1beta.HiveMetastoreServiceClient.ListHiveCatalogsPagedResponse;
import static com.google.cloud.biglake.hive.v1beta.HiveMetastoreServiceClient.ListHiveDatabasesPagedResponse;
import static com.google.cloud.biglake.hive.v1beta.HiveMetastoreServiceClient.ListHiveTablesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.biglake.hive.v1beta.BatchCreatePartitionsRequest;
import com.google.cloud.biglake.hive.v1beta.BatchCreatePartitionsResponse;
import com.google.cloud.biglake.hive.v1beta.BatchDeletePartitionsRequest;
import com.google.cloud.biglake.hive.v1beta.BatchUpdatePartitionsRequest;
import com.google.cloud.biglake.hive.v1beta.BatchUpdatePartitionsResponse;
import com.google.cloud.biglake.hive.v1beta.CreateHiveCatalogRequest;
import com.google.cloud.biglake.hive.v1beta.CreateHiveDatabaseRequest;
import com.google.cloud.biglake.hive.v1beta.CreateHiveTableRequest;
import com.google.cloud.biglake.hive.v1beta.DeleteHiveCatalogRequest;
import com.google.cloud.biglake.hive.v1beta.DeleteHiveDatabaseRequest;
import com.google.cloud.biglake.hive.v1beta.DeleteHiveTableRequest;
import com.google.cloud.biglake.hive.v1beta.GetHiveCatalogRequest;
import com.google.cloud.biglake.hive.v1beta.GetHiveDatabaseRequest;
import com.google.cloud.biglake.hive.v1beta.GetHiveTableRequest;
import com.google.cloud.biglake.hive.v1beta.HiveCatalog;
import com.google.cloud.biglake.hive.v1beta.HiveDatabase;
import com.google.cloud.biglake.hive.v1beta.HiveTable;
import com.google.cloud.biglake.hive.v1beta.ListHiveCatalogsRequest;
import com.google.cloud.biglake.hive.v1beta.ListHiveCatalogsResponse;
import com.google.cloud.biglake.hive.v1beta.ListHiveDatabasesRequest;
import com.google.cloud.biglake.hive.v1beta.ListHiveDatabasesResponse;
import com.google.cloud.biglake.hive.v1beta.ListHiveTablesRequest;
import com.google.cloud.biglake.hive.v1beta.ListHiveTablesResponse;
import com.google.cloud.biglake.hive.v1beta.ListPartitionsRequest;
import com.google.cloud.biglake.hive.v1beta.ListPartitionsResponse;
import com.google.cloud.biglake.hive.v1beta.UpdateHiveCatalogRequest;
import com.google.cloud.biglake.hive.v1beta.UpdateHiveDatabaseRequest;
import com.google.cloud.biglake.hive.v1beta.UpdateHiveTableRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the HiveMetastoreService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class HiveMetastoreServiceStub implements BackgroundResource {

  public UnaryCallable<CreateHiveCatalogRequest, HiveCatalog> createHiveCatalogCallable() {
    throw new UnsupportedOperationException("Not implemented: createHiveCatalogCallable()");
  }

  public UnaryCallable<GetHiveCatalogRequest, HiveCatalog> getHiveCatalogCallable() {
    throw new UnsupportedOperationException("Not implemented: getHiveCatalogCallable()");
  }

  public UnaryCallable<ListHiveCatalogsRequest, ListHiveCatalogsPagedResponse>
      listHiveCatalogsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listHiveCatalogsPagedCallable()");
  }

  public UnaryCallable<ListHiveCatalogsRequest, ListHiveCatalogsResponse>
      listHiveCatalogsCallable() {
    throw new UnsupportedOperationException("Not implemented: listHiveCatalogsCallable()");
  }

  public UnaryCallable<UpdateHiveCatalogRequest, HiveCatalog> updateHiveCatalogCallable() {
    throw new UnsupportedOperationException("Not implemented: updateHiveCatalogCallable()");
  }

  public UnaryCallable<DeleteHiveCatalogRequest, Empty> deleteHiveCatalogCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteHiveCatalogCallable()");
  }

  public UnaryCallable<CreateHiveDatabaseRequest, HiveDatabase> createHiveDatabaseCallable() {
    throw new UnsupportedOperationException("Not implemented: createHiveDatabaseCallable()");
  }

  public UnaryCallable<GetHiveDatabaseRequest, HiveDatabase> getHiveDatabaseCallable() {
    throw new UnsupportedOperationException("Not implemented: getHiveDatabaseCallable()");
  }

  public UnaryCallable<ListHiveDatabasesRequest, ListHiveDatabasesPagedResponse>
      listHiveDatabasesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listHiveDatabasesPagedCallable()");
  }

  public UnaryCallable<ListHiveDatabasesRequest, ListHiveDatabasesResponse>
      listHiveDatabasesCallable() {
    throw new UnsupportedOperationException("Not implemented: listHiveDatabasesCallable()");
  }

  public UnaryCallable<UpdateHiveDatabaseRequest, HiveDatabase> updateHiveDatabaseCallable() {
    throw new UnsupportedOperationException("Not implemented: updateHiveDatabaseCallable()");
  }

  public UnaryCallable<DeleteHiveDatabaseRequest, Empty> deleteHiveDatabaseCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteHiveDatabaseCallable()");
  }

  public UnaryCallable<CreateHiveTableRequest, HiveTable> createHiveTableCallable() {
    throw new UnsupportedOperationException("Not implemented: createHiveTableCallable()");
  }

  public UnaryCallable<GetHiveTableRequest, HiveTable> getHiveTableCallable() {
    throw new UnsupportedOperationException("Not implemented: getHiveTableCallable()");
  }

  public UnaryCallable<ListHiveTablesRequest, ListHiveTablesPagedResponse>
      listHiveTablesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listHiveTablesPagedCallable()");
  }

  public UnaryCallable<ListHiveTablesRequest, ListHiveTablesResponse> listHiveTablesCallable() {
    throw new UnsupportedOperationException("Not implemented: listHiveTablesCallable()");
  }

  public UnaryCallable<UpdateHiveTableRequest, HiveTable> updateHiveTableCallable() {
    throw new UnsupportedOperationException("Not implemented: updateHiveTableCallable()");
  }

  public UnaryCallable<DeleteHiveTableRequest, Empty> deleteHiveTableCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteHiveTableCallable()");
  }

  public UnaryCallable<BatchCreatePartitionsRequest, BatchCreatePartitionsResponse>
      batchCreatePartitionsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchCreatePartitionsCallable()");
  }

  public UnaryCallable<BatchDeletePartitionsRequest, Empty> batchDeletePartitionsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchDeletePartitionsCallable()");
  }

  public UnaryCallable<BatchUpdatePartitionsRequest, BatchUpdatePartitionsResponse>
      batchUpdatePartitionsCallable() {
    throw new UnsupportedOperationException("Not implemented: batchUpdatePartitionsCallable()");
  }

  public ServerStreamingCallable<ListPartitionsRequest, ListPartitionsResponse>
      listPartitionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listPartitionsCallable()");
  }

  @Override
  public abstract void close();
}
