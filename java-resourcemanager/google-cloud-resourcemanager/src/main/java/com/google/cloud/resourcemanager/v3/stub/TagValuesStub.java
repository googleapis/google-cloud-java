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

import static com.google.cloud.resourcemanager.v3.TagValuesClient.ListTagValuesPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.resourcemanager.v3.CreateTagValueMetadata;
import com.google.cloud.resourcemanager.v3.CreateTagValueRequest;
import com.google.cloud.resourcemanager.v3.DeleteTagValueMetadata;
import com.google.cloud.resourcemanager.v3.DeleteTagValueRequest;
import com.google.cloud.resourcemanager.v3.GetTagValueRequest;
import com.google.cloud.resourcemanager.v3.ListTagValuesRequest;
import com.google.cloud.resourcemanager.v3.ListTagValuesResponse;
import com.google.cloud.resourcemanager.v3.TagValue;
import com.google.cloud.resourcemanager.v3.UpdateTagValueMetadata;
import com.google.cloud.resourcemanager.v3.UpdateTagValueRequest;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.stub.OperationsStub;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the TagValues service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class TagValuesStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<ListTagValuesRequest, ListTagValuesPagedResponse>
      listTagValuesPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listTagValuesPagedCallable()");
  }

  public UnaryCallable<ListTagValuesRequest, ListTagValuesResponse> listTagValuesCallable() {
    throw new UnsupportedOperationException("Not implemented: listTagValuesCallable()");
  }

  public UnaryCallable<GetTagValueRequest, TagValue> getTagValueCallable() {
    throw new UnsupportedOperationException("Not implemented: getTagValueCallable()");
  }

  public OperationCallable<CreateTagValueRequest, TagValue, CreateTagValueMetadata>
      createTagValueOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createTagValueOperationCallable()");
  }

  public UnaryCallable<CreateTagValueRequest, Operation> createTagValueCallable() {
    throw new UnsupportedOperationException("Not implemented: createTagValueCallable()");
  }

  public OperationCallable<UpdateTagValueRequest, TagValue, UpdateTagValueMetadata>
      updateTagValueOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateTagValueOperationCallable()");
  }

  public UnaryCallable<UpdateTagValueRequest, Operation> updateTagValueCallable() {
    throw new UnsupportedOperationException("Not implemented: updateTagValueCallable()");
  }

  public OperationCallable<DeleteTagValueRequest, TagValue, DeleteTagValueMetadata>
      deleteTagValueOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteTagValueOperationCallable()");
  }

  public UnaryCallable<DeleteTagValueRequest, Operation> deleteTagValueCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteTagValueCallable()");
  }

  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyCallable()");
  }

  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyCallable()");
  }

  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  @Override
  public abstract void close();
}
