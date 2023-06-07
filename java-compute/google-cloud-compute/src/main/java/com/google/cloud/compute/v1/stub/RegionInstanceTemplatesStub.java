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

package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.RegionInstanceTemplatesClient.ListPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.DeleteRegionInstanceTemplateRequest;
import com.google.cloud.compute.v1.GetRegionInstanceTemplateRequest;
import com.google.cloud.compute.v1.InsertRegionInstanceTemplateRequest;
import com.google.cloud.compute.v1.InstanceTemplate;
import com.google.cloud.compute.v1.InstanceTemplateList;
import com.google.cloud.compute.v1.ListRegionInstanceTemplatesRequest;
import com.google.cloud.compute.v1.Operation;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the RegionInstanceTemplates service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class RegionInstanceTemplatesStub implements BackgroundResource {

  public OperationCallable<DeleteRegionInstanceTemplateRequest, Operation, Operation>
      deleteOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteOperationCallable()");
  }

  public UnaryCallable<DeleteRegionInstanceTemplateRequest, Operation> deleteCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCallable()");
  }

  public UnaryCallable<GetRegionInstanceTemplateRequest, InstanceTemplate> getCallable() {
    throw new UnsupportedOperationException("Not implemented: getCallable()");
  }

  public OperationCallable<InsertRegionInstanceTemplateRequest, Operation, Operation>
      insertOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: insertOperationCallable()");
  }

  public UnaryCallable<InsertRegionInstanceTemplateRequest, Operation> insertCallable() {
    throw new UnsupportedOperationException("Not implemented: insertCallable()");
  }

  public UnaryCallable<ListRegionInstanceTemplatesRequest, ListPagedResponse> listPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPagedCallable()");
  }

  public UnaryCallable<ListRegionInstanceTemplatesRequest, InstanceTemplateList> listCallable() {
    throw new UnsupportedOperationException("Not implemented: listCallable()");
  }

  @Override
  public abstract void close();
}
