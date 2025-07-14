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

package com.google.cloud.chronicle.v1.stub;

import static com.google.cloud.chronicle.v1.ReferenceListServiceClient.ListReferenceListsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.chronicle.v1.CreateReferenceListRequest;
import com.google.cloud.chronicle.v1.GetReferenceListRequest;
import com.google.cloud.chronicle.v1.ListReferenceListsRequest;
import com.google.cloud.chronicle.v1.ListReferenceListsResponse;
import com.google.cloud.chronicle.v1.ReferenceList;
import com.google.cloud.chronicle.v1.UpdateReferenceListRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ReferenceListService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class ReferenceListServiceStub implements BackgroundResource {

  public UnaryCallable<GetReferenceListRequest, ReferenceList> getReferenceListCallable() {
    throw new UnsupportedOperationException("Not implemented: getReferenceListCallable()");
  }

  public UnaryCallable<ListReferenceListsRequest, ListReferenceListsPagedResponse>
      listReferenceListsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listReferenceListsPagedCallable()");
  }

  public UnaryCallable<ListReferenceListsRequest, ListReferenceListsResponse>
      listReferenceListsCallable() {
    throw new UnsupportedOperationException("Not implemented: listReferenceListsCallable()");
  }

  public UnaryCallable<CreateReferenceListRequest, ReferenceList> createReferenceListCallable() {
    throw new UnsupportedOperationException("Not implemented: createReferenceListCallable()");
  }

  public UnaryCallable<UpdateReferenceListRequest, ReferenceList> updateReferenceListCallable() {
    throw new UnsupportedOperationException("Not implemented: updateReferenceListCallable()");
  }

  @Override
  public abstract void close();
}
