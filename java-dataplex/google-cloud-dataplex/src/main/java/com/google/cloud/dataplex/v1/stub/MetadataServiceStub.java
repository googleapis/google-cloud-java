/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.dataplex.v1.stub;

import static com.google.cloud.dataplex.v1.MetadataServiceClient.ListEntitiesPagedResponse;
import static com.google.cloud.dataplex.v1.MetadataServiceClient.ListPartitionsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dataplex.v1.Entity;
import com.google.cloud.dataplex.v1.GetEntityRequest;
import com.google.cloud.dataplex.v1.GetPartitionRequest;
import com.google.cloud.dataplex.v1.ListEntitiesRequest;
import com.google.cloud.dataplex.v1.ListEntitiesResponse;
import com.google.cloud.dataplex.v1.ListPartitionsRequest;
import com.google.cloud.dataplex.v1.ListPartitionsResponse;
import com.google.cloud.dataplex.v1.Partition;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the MetadataService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class MetadataServiceStub implements BackgroundResource {

  public UnaryCallable<GetEntityRequest, Entity> getEntityCallable() {
    throw new UnsupportedOperationException("Not implemented: getEntityCallable()");
  }

  public UnaryCallable<ListEntitiesRequest, ListEntitiesPagedResponse> listEntitiesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listEntitiesPagedCallable()");
  }

  public UnaryCallable<ListEntitiesRequest, ListEntitiesResponse> listEntitiesCallable() {
    throw new UnsupportedOperationException("Not implemented: listEntitiesCallable()");
  }

  public UnaryCallable<GetPartitionRequest, Partition> getPartitionCallable() {
    throw new UnsupportedOperationException("Not implemented: getPartitionCallable()");
  }

  public UnaryCallable<ListPartitionsRequest, ListPartitionsPagedResponse>
      listPartitionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPartitionsPagedCallable()");
  }

  public UnaryCallable<ListPartitionsRequest, ListPartitionsResponse> listPartitionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listPartitionsCallable()");
  }

  @Override
  public abstract void close();
}
