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

package com.google.cloud.biglake.v1.stub;

import static com.google.cloud.biglake.v1.IcebergCatalogServiceClient.ListIcebergCatalogsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.biglake.v1.CreateIcebergCatalogRequest;
import com.google.cloud.biglake.v1.FailoverIcebergCatalogRequest;
import com.google.cloud.biglake.v1.FailoverIcebergCatalogResponse;
import com.google.cloud.biglake.v1.GetIcebergCatalogRequest;
import com.google.cloud.biglake.v1.IcebergCatalog;
import com.google.cloud.biglake.v1.ListIcebergCatalogsRequest;
import com.google.cloud.biglake.v1.ListIcebergCatalogsResponse;
import com.google.cloud.biglake.v1.UpdateIcebergCatalogRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the IcebergCatalogService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class IcebergCatalogServiceStub implements BackgroundResource {

  public UnaryCallable<GetIcebergCatalogRequest, IcebergCatalog> getIcebergCatalogCallable() {
    throw new UnsupportedOperationException("Not implemented: getIcebergCatalogCallable()");
  }

  public UnaryCallable<ListIcebergCatalogsRequest, ListIcebergCatalogsPagedResponse>
      listIcebergCatalogsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listIcebergCatalogsPagedCallable()");
  }

  public UnaryCallable<ListIcebergCatalogsRequest, ListIcebergCatalogsResponse>
      listIcebergCatalogsCallable() {
    throw new UnsupportedOperationException("Not implemented: listIcebergCatalogsCallable()");
  }

  public UnaryCallable<UpdateIcebergCatalogRequest, IcebergCatalog> updateIcebergCatalogCallable() {
    throw new UnsupportedOperationException("Not implemented: updateIcebergCatalogCallable()");
  }

  public UnaryCallable<CreateIcebergCatalogRequest, IcebergCatalog> createIcebergCatalogCallable() {
    throw new UnsupportedOperationException("Not implemented: createIcebergCatalogCallable()");
  }

  public UnaryCallable<FailoverIcebergCatalogRequest, FailoverIcebergCatalogResponse>
      failoverIcebergCatalogCallable() {
    throw new UnsupportedOperationException("Not implemented: failoverIcebergCatalogCallable()");
  }

  @Override
  public abstract void close();
}
