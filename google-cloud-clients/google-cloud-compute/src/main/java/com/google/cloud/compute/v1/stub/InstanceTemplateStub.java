/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.InstanceTemplateClient.ListInstanceTemplatesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.DeleteInstanceTemplateHttpRequest;
import com.google.cloud.compute.v1.GetInstanceTemplateHttpRequest;
import com.google.cloud.compute.v1.InsertInstanceTemplateHttpRequest;
import com.google.cloud.compute.v1.InstanceTemplate;
import com.google.cloud.compute.v1.InstanceTemplateList;
import com.google.cloud.compute.v1.ListInstanceTemplatesHttpRequest;
import com.google.cloud.compute.v1.Operation;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Base stub class for compute.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public abstract class InstanceTemplateStub implements BackgroundResource {

  @BetaApi
  public UnaryCallable<DeleteInstanceTemplateHttpRequest, Operation>
      deleteInstanceTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteInstanceTemplateCallable()");
  }

  @BetaApi
  public UnaryCallable<GetInstanceTemplateHttpRequest, InstanceTemplate>
      getInstanceTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: getInstanceTemplateCallable()");
  }

  @BetaApi
  public UnaryCallable<InsertInstanceTemplateHttpRequest, Operation>
      insertInstanceTemplateCallable() {
    throw new UnsupportedOperationException("Not implemented: insertInstanceTemplateCallable()");
  }

  @BetaApi
  public UnaryCallable<ListInstanceTemplatesHttpRequest, ListInstanceTemplatesPagedResponse>
      listInstanceTemplatesPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listInstanceTemplatesPagedCallable()");
  }

  @BetaApi
  public UnaryCallable<ListInstanceTemplatesHttpRequest, InstanceTemplateList>
      listInstanceTemplatesCallable() {
    throw new UnsupportedOperationException("Not implemented: listInstanceTemplatesCallable()");
  }

  @Override
  public abstract void close();
}
