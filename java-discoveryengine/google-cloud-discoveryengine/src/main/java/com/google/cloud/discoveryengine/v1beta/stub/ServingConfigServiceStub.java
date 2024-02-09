/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.discoveryengine.v1beta.stub;

import static com.google.cloud.discoveryengine.v1beta.ServingConfigServiceClient.ListServingConfigsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1beta.GetServingConfigRequest;
import com.google.cloud.discoveryengine.v1beta.ListServingConfigsRequest;
import com.google.cloud.discoveryengine.v1beta.ListServingConfigsResponse;
import com.google.cloud.discoveryengine.v1beta.ServingConfig;
import com.google.cloud.discoveryengine.v1beta.UpdateServingConfigRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ServingConfigService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class ServingConfigServiceStub implements BackgroundResource {

  public UnaryCallable<UpdateServingConfigRequest, ServingConfig> updateServingConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: updateServingConfigCallable()");
  }

  public UnaryCallable<GetServingConfigRequest, ServingConfig> getServingConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: getServingConfigCallable()");
  }

  public UnaryCallable<ListServingConfigsRequest, ListServingConfigsPagedResponse>
      listServingConfigsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listServingConfigsPagedCallable()");
  }

  public UnaryCallable<ListServingConfigsRequest, ListServingConfigsResponse>
      listServingConfigsCallable() {
    throw new UnsupportedOperationException("Not implemented: listServingConfigsCallable()");
  }

  @Override
  public abstract void close();
}
