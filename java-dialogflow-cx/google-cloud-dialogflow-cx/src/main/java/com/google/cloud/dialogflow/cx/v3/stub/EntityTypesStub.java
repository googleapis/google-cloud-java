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

package com.google.cloud.dialogflow.cx.v3.stub;

import static com.google.cloud.dialogflow.cx.v3.EntityTypesClient.ListEntityTypesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.cx.v3.CreateEntityTypeRequest;
import com.google.cloud.dialogflow.cx.v3.DeleteEntityTypeRequest;
import com.google.cloud.dialogflow.cx.v3.EntityType;
import com.google.cloud.dialogflow.cx.v3.GetEntityTypeRequest;
import com.google.cloud.dialogflow.cx.v3.ListEntityTypesRequest;
import com.google.cloud.dialogflow.cx.v3.ListEntityTypesResponse;
import com.google.cloud.dialogflow.cx.v3.UpdateEntityTypeRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the EntityTypes service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
public abstract class EntityTypesStub implements BackgroundResource {

  public UnaryCallable<ListEntityTypesRequest, ListEntityTypesPagedResponse>
      listEntityTypesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listEntityTypesPagedCallable()");
  }

  public UnaryCallable<ListEntityTypesRequest, ListEntityTypesResponse> listEntityTypesCallable() {
    throw new UnsupportedOperationException("Not implemented: listEntityTypesCallable()");
  }

  public UnaryCallable<GetEntityTypeRequest, EntityType> getEntityTypeCallable() {
    throw new UnsupportedOperationException("Not implemented: getEntityTypeCallable()");
  }

  public UnaryCallable<CreateEntityTypeRequest, EntityType> createEntityTypeCallable() {
    throw new UnsupportedOperationException("Not implemented: createEntityTypeCallable()");
  }

  public UnaryCallable<UpdateEntityTypeRequest, EntityType> updateEntityTypeCallable() {
    throw new UnsupportedOperationException("Not implemented: updateEntityTypeCallable()");
  }

  public UnaryCallable<DeleteEntityTypeRequest, Empty> deleteEntityTypeCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteEntityTypeCallable()");
  }

  @Override
  public abstract void close();
}
