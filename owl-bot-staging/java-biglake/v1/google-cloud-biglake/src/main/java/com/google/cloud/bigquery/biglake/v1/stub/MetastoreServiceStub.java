/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.bigquery.biglake.v1.stub;

import static com.google.cloud.bigquery.biglake.v1.MetastoreServiceClient.ListCatalogsPagedResponse;
import static com.google.cloud.bigquery.biglake.v1.MetastoreServiceClient.ListDatabasesPagedResponse;
import static com.google.cloud.bigquery.biglake.v1.MetastoreServiceClient.ListTablesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.bigquery.biglake.v1.Catalog;
import com.google.cloud.bigquery.biglake.v1.CreateCatalogRequest;
import com.google.cloud.bigquery.biglake.v1.CreateDatabaseRequest;
import com.google.cloud.bigquery.biglake.v1.CreateTableRequest;
import com.google.cloud.bigquery.biglake.v1.Database;
import com.google.cloud.bigquery.biglake.v1.DeleteCatalogRequest;
import com.google.cloud.bigquery.biglake.v1.DeleteDatabaseRequest;
import com.google.cloud.bigquery.biglake.v1.DeleteTableRequest;
import com.google.cloud.bigquery.biglake.v1.GetCatalogRequest;
import com.google.cloud.bigquery.biglake.v1.GetDatabaseRequest;
import com.google.cloud.bigquery.biglake.v1.GetTableRequest;
import com.google.cloud.bigquery.biglake.v1.ListCatalogsRequest;
import com.google.cloud.bigquery.biglake.v1.ListCatalogsResponse;
import com.google.cloud.bigquery.biglake.v1.ListDatabasesRequest;
import com.google.cloud.bigquery.biglake.v1.ListDatabasesResponse;
import com.google.cloud.bigquery.biglake.v1.ListTablesRequest;
import com.google.cloud.bigquery.biglake.v1.ListTablesResponse;
import com.google.cloud.bigquery.biglake.v1.RenameTableRequest;
import com.google.cloud.bigquery.biglake.v1.Table;
import com.google.cloud.bigquery.biglake.v1.UpdateDatabaseRequest;
import com.google.cloud.bigquery.biglake.v1.UpdateTableRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the MetastoreService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class MetastoreServiceStub implements BackgroundResource {

  public UnaryCallable<CreateCatalogRequest, Catalog> createCatalogCallable() {
    throw new UnsupportedOperationException("Not implemented: createCatalogCallable()");
  }

  public UnaryCallable<DeleteCatalogRequest, Catalog> deleteCatalogCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCatalogCallable()");
  }

  public UnaryCallable<GetCatalogRequest, Catalog> getCatalogCallable() {
    throw new UnsupportedOperationException("Not implemented: getCatalogCallable()");
  }

  public UnaryCallable<ListCatalogsRequest, ListCatalogsPagedResponse> listCatalogsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listCatalogsPagedCallable()");
  }

  public UnaryCallable<ListCatalogsRequest, ListCatalogsResponse> listCatalogsCallable() {
    throw new UnsupportedOperationException("Not implemented: listCatalogsCallable()");
  }

  public UnaryCallable<CreateDatabaseRequest, Database> createDatabaseCallable() {
    throw new UnsupportedOperationException("Not implemented: createDatabaseCallable()");
  }

  public UnaryCallable<DeleteDatabaseRequest, Database> deleteDatabaseCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteDatabaseCallable()");
  }

  public UnaryCallable<UpdateDatabaseRequest, Database> updateDatabaseCallable() {
    throw new UnsupportedOperationException("Not implemented: updateDatabaseCallable()");
  }

  public UnaryCallable<GetDatabaseRequest, Database> getDatabaseCallable() {
    throw new UnsupportedOperationException("Not implemented: getDatabaseCallable()");
  }

  public UnaryCallable<ListDatabasesRequest, ListDatabasesPagedResponse>
      listDatabasesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listDatabasesPagedCallable()");
  }

  public UnaryCallable<ListDatabasesRequest, ListDatabasesResponse> listDatabasesCallable() {
    throw new UnsupportedOperationException("Not implemented: listDatabasesCallable()");
  }

  public UnaryCallable<CreateTableRequest, Table> createTableCallable() {
    throw new UnsupportedOperationException("Not implemented: createTableCallable()");
  }

  public UnaryCallable<DeleteTableRequest, Table> deleteTableCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteTableCallable()");
  }

  public UnaryCallable<UpdateTableRequest, Table> updateTableCallable() {
    throw new UnsupportedOperationException("Not implemented: updateTableCallable()");
  }

  public UnaryCallable<RenameTableRequest, Table> renameTableCallable() {
    throw new UnsupportedOperationException("Not implemented: renameTableCallable()");
  }

  public UnaryCallable<GetTableRequest, Table> getTableCallable() {
    throw new UnsupportedOperationException("Not implemented: getTableCallable()");
  }

  public UnaryCallable<ListTablesRequest, ListTablesPagedResponse> listTablesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listTablesPagedCallable()");
  }

  public UnaryCallable<ListTablesRequest, ListTablesResponse> listTablesCallable() {
    throw new UnsupportedOperationException("Not implemented: listTablesCallable()");
  }

  @Override
  public abstract void close();
}
