/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.resourcemanager.v3.stub;

import static com.google.cloud.resourcemanager.v3.TagBindingsClient.ListTagBindingsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.resourcemanager.v3.CreateTagBindingMetadata;
import com.google.cloud.resourcemanager.v3.CreateTagBindingRequest;
import com.google.cloud.resourcemanager.v3.DeleteTagBindingMetadata;
import com.google.cloud.resourcemanager.v3.DeleteTagBindingRequest;
import com.google.cloud.resourcemanager.v3.ListTagBindingsRequest;
import com.google.cloud.resourcemanager.v3.ListTagBindingsResponse;
import com.google.cloud.resourcemanager.v3.TagBinding;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the TagBindings service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class TagBindingsStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<ListTagBindingsRequest, ListTagBindingsPagedResponse>
      listTagBindingsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listTagBindingsPagedCallable()");
  }

  public UnaryCallable<ListTagBindingsRequest, ListTagBindingsResponse> listTagBindingsCallable() {
    throw new UnsupportedOperationException("Not implemented: listTagBindingsCallable()");
  }

  public OperationCallable<CreateTagBindingRequest, TagBinding, CreateTagBindingMetadata>
      createTagBindingOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createTagBindingOperationCallable()");
  }

  public UnaryCallable<CreateTagBindingRequest, Operation> createTagBindingCallable() {
    throw new UnsupportedOperationException("Not implemented: createTagBindingCallable()");
  }

  public OperationCallable<DeleteTagBindingRequest, Empty, DeleteTagBindingMetadata>
      deleteTagBindingOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteTagBindingOperationCallable()");
  }

  public UnaryCallable<DeleteTagBindingRequest, Operation> deleteTagBindingCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteTagBindingCallable()");
  }

  @Override
  public abstract void close();
}
