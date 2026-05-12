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

package com.google.maps.mapmanagement.v2beta.stub;

import static com.google.maps.mapmanagement.v2beta.MapManagementClient.ListMapConfigsPagedResponse;
import static com.google.maps.mapmanagement.v2beta.MapManagementClient.ListMapContextConfigsPagedResponse;
import static com.google.maps.mapmanagement.v2beta.MapManagementClient.ListStyleConfigsPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.maps.mapmanagement.v2beta.CreateMapConfigRequest;
import com.google.maps.mapmanagement.v2beta.CreateMapContextConfigRequest;
import com.google.maps.mapmanagement.v2beta.CreateStyleConfigRequest;
import com.google.maps.mapmanagement.v2beta.DeleteMapConfigRequest;
import com.google.maps.mapmanagement.v2beta.DeleteMapContextConfigRequest;
import com.google.maps.mapmanagement.v2beta.DeleteStyleConfigRequest;
import com.google.maps.mapmanagement.v2beta.GetMapConfigRequest;
import com.google.maps.mapmanagement.v2beta.GetMapContextConfigRequest;
import com.google.maps.mapmanagement.v2beta.GetStyleConfigRequest;
import com.google.maps.mapmanagement.v2beta.ListMapConfigsRequest;
import com.google.maps.mapmanagement.v2beta.ListMapConfigsResponse;
import com.google.maps.mapmanagement.v2beta.ListMapContextConfigsRequest;
import com.google.maps.mapmanagement.v2beta.ListMapContextConfigsResponse;
import com.google.maps.mapmanagement.v2beta.ListStyleConfigsRequest;
import com.google.maps.mapmanagement.v2beta.ListStyleConfigsResponse;
import com.google.maps.mapmanagement.v2beta.MapConfig;
import com.google.maps.mapmanagement.v2beta.MapContextConfig;
import com.google.maps.mapmanagement.v2beta.StyleConfig;
import com.google.maps.mapmanagement.v2beta.UpdateMapConfigRequest;
import com.google.maps.mapmanagement.v2beta.UpdateMapContextConfigRequest;
import com.google.maps.mapmanagement.v2beta.UpdateStyleConfigRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the MapManagement service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public abstract class MapManagementStub implements BackgroundResource {

  public UnaryCallable<CreateMapConfigRequest, MapConfig> createMapConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: createMapConfigCallable()");
  }

  public UnaryCallable<GetMapConfigRequest, MapConfig> getMapConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: getMapConfigCallable()");
  }

  public UnaryCallable<ListMapConfigsRequest, ListMapConfigsPagedResponse>
      listMapConfigsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listMapConfigsPagedCallable()");
  }

  public UnaryCallable<ListMapConfigsRequest, ListMapConfigsResponse> listMapConfigsCallable() {
    throw new UnsupportedOperationException("Not implemented: listMapConfigsCallable()");
  }

  public UnaryCallable<UpdateMapConfigRequest, MapConfig> updateMapConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: updateMapConfigCallable()");
  }

  public UnaryCallable<DeleteMapConfigRequest, Empty> deleteMapConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteMapConfigCallable()");
  }

  public UnaryCallable<CreateStyleConfigRequest, StyleConfig> createStyleConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: createStyleConfigCallable()");
  }

  public UnaryCallable<GetStyleConfigRequest, StyleConfig> getStyleConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: getStyleConfigCallable()");
  }

  public UnaryCallable<ListStyleConfigsRequest, ListStyleConfigsPagedResponse>
      listStyleConfigsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listStyleConfigsPagedCallable()");
  }

  public UnaryCallable<ListStyleConfigsRequest, ListStyleConfigsResponse>
      listStyleConfigsCallable() {
    throw new UnsupportedOperationException("Not implemented: listStyleConfigsCallable()");
  }

  public UnaryCallable<UpdateStyleConfigRequest, StyleConfig> updateStyleConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: updateStyleConfigCallable()");
  }

  public UnaryCallable<DeleteStyleConfigRequest, Empty> deleteStyleConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteStyleConfigCallable()");
  }

  public UnaryCallable<CreateMapContextConfigRequest, MapContextConfig>
      createMapContextConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: createMapContextConfigCallable()");
  }

  public UnaryCallable<GetMapContextConfigRequest, MapContextConfig> getMapContextConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: getMapContextConfigCallable()");
  }

  public UnaryCallable<ListMapContextConfigsRequest, ListMapContextConfigsPagedResponse>
      listMapContextConfigsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listMapContextConfigsPagedCallable()");
  }

  public UnaryCallable<ListMapContextConfigsRequest, ListMapContextConfigsResponse>
      listMapContextConfigsCallable() {
    throw new UnsupportedOperationException("Not implemented: listMapContextConfigsCallable()");
  }

  public UnaryCallable<UpdateMapContextConfigRequest, MapContextConfig>
      updateMapContextConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: updateMapContextConfigCallable()");
  }

  public UnaryCallable<DeleteMapContextConfigRequest, Empty> deleteMapContextConfigCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteMapContextConfigCallable()");
  }

  @Override
  public abstract void close();
}
