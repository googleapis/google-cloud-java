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

package com.google.cloud.billing.v1.stub;

import static com.google.cloud.billing.v1.CloudCatalogClient.ListServicesPagedResponse;
import static com.google.cloud.billing.v1.CloudCatalogClient.ListSkusPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.billing.v1.ListServicesRequest;
import com.google.cloud.billing.v1.ListServicesResponse;
import com.google.cloud.billing.v1.ListSkusRequest;
import com.google.cloud.billing.v1.ListSkusResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the CloudCatalog service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class CloudCatalogStub implements BackgroundResource {

  public UnaryCallable<ListServicesRequest, ListServicesPagedResponse> listServicesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listServicesPagedCallable()");
  }

  public UnaryCallable<ListServicesRequest, ListServicesResponse> listServicesCallable() {
    throw new UnsupportedOperationException("Not implemented: listServicesCallable()");
  }

  public UnaryCallable<ListSkusRequest, ListSkusPagedResponse> listSkusPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSkusPagedCallable()");
  }

  public UnaryCallable<ListSkusRequest, ListSkusResponse> listSkusCallable() {
    throw new UnsupportedOperationException("Not implemented: listSkusCallable()");
  }

  @Override
  public abstract void close();
}
