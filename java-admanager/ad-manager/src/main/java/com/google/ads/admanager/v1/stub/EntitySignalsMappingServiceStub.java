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

package com.google.ads.admanager.v1.stub;

import static com.google.ads.admanager.v1.EntitySignalsMappingServiceClient.ListEntitySignalsMappingsPagedResponse;

import com.google.ads.admanager.v1.BatchCreateEntitySignalsMappingsRequest;
import com.google.ads.admanager.v1.BatchCreateEntitySignalsMappingsResponse;
import com.google.ads.admanager.v1.BatchUpdateEntitySignalsMappingsRequest;
import com.google.ads.admanager.v1.BatchUpdateEntitySignalsMappingsResponse;
import com.google.ads.admanager.v1.CreateEntitySignalsMappingRequest;
import com.google.ads.admanager.v1.EntitySignalsMapping;
import com.google.ads.admanager.v1.GetEntitySignalsMappingRequest;
import com.google.ads.admanager.v1.ListEntitySignalsMappingsRequest;
import com.google.ads.admanager.v1.ListEntitySignalsMappingsResponse;
import com.google.ads.admanager.v1.UpdateEntitySignalsMappingRequest;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the EntitySignalsMappingService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class EntitySignalsMappingServiceStub implements BackgroundResource {

  public UnaryCallable<GetEntitySignalsMappingRequest, EntitySignalsMapping>
      getEntitySignalsMappingCallable() {
    throw new UnsupportedOperationException("Not implemented: getEntitySignalsMappingCallable()");
  }

  public UnaryCallable<ListEntitySignalsMappingsRequest, ListEntitySignalsMappingsPagedResponse>
      listEntitySignalsMappingsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listEntitySignalsMappingsPagedCallable()");
  }

  public UnaryCallable<ListEntitySignalsMappingsRequest, ListEntitySignalsMappingsResponse>
      listEntitySignalsMappingsCallable() {
    throw new UnsupportedOperationException("Not implemented: listEntitySignalsMappingsCallable()");
  }

  public UnaryCallable<CreateEntitySignalsMappingRequest, EntitySignalsMapping>
      createEntitySignalsMappingCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createEntitySignalsMappingCallable()");
  }

  public UnaryCallable<UpdateEntitySignalsMappingRequest, EntitySignalsMapping>
      updateEntitySignalsMappingCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: updateEntitySignalsMappingCallable()");
  }

  public UnaryCallable<
          BatchCreateEntitySignalsMappingsRequest, BatchCreateEntitySignalsMappingsResponse>
      batchCreateEntitySignalsMappingsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchCreateEntitySignalsMappingsCallable()");
  }

  public UnaryCallable<
          BatchUpdateEntitySignalsMappingsRequest, BatchUpdateEntitySignalsMappingsResponse>
      batchUpdateEntitySignalsMappingsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: batchUpdateEntitySignalsMappingsCallable()");
  }

  @Override
  public abstract void close();
}
