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

import static com.google.cloud.resourcemanager.v3.TagKeysClient.ListTagKeysPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.resourcemanager.v3.CreateTagKeyMetadata;
import com.google.cloud.resourcemanager.v3.CreateTagKeyRequest;
import com.google.cloud.resourcemanager.v3.DeleteTagKeyMetadata;
import com.google.cloud.resourcemanager.v3.DeleteTagKeyRequest;
import com.google.cloud.resourcemanager.v3.GetTagKeyRequest;
import com.google.cloud.resourcemanager.v3.ListTagKeysRequest;
import com.google.cloud.resourcemanager.v3.ListTagKeysResponse;
import com.google.cloud.resourcemanager.v3.TagKey;
import com.google.cloud.resourcemanager.v3.UpdateTagKeyMetadata;
import com.google.cloud.resourcemanager.v3.UpdateTagKeyRequest;
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
 * Base stub class for the TagKeys service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class TagKeysStub implements BackgroundResource {

  public OperationsStub getOperationsStub() {
    return null;
  }

  public com.google.api.gax.httpjson.longrunning.stub.OperationsStub getHttpJsonOperationsStub() {
    return null;
  }

  public UnaryCallable<ListTagKeysRequest, ListTagKeysPagedResponse> listTagKeysPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listTagKeysPagedCallable()");
  }

  public UnaryCallable<ListTagKeysRequest, ListTagKeysResponse> listTagKeysCallable() {
    throw new UnsupportedOperationException("Not implemented: listTagKeysCallable()");
  }

  public UnaryCallable<GetTagKeyRequest, TagKey> getTagKeyCallable() {
    throw new UnsupportedOperationException("Not implemented: getTagKeyCallable()");
  }

  public OperationCallable<CreateTagKeyRequest, TagKey, CreateTagKeyMetadata>
      createTagKeyOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: createTagKeyOperationCallable()");
  }

  public UnaryCallable<CreateTagKeyRequest, Operation> createTagKeyCallable() {
    throw new UnsupportedOperationException("Not implemented: createTagKeyCallable()");
  }

  public OperationCallable<UpdateTagKeyRequest, TagKey, UpdateTagKeyMetadata>
      updateTagKeyOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: updateTagKeyOperationCallable()");
  }

  public UnaryCallable<UpdateTagKeyRequest, Operation> updateTagKeyCallable() {
    throw new UnsupportedOperationException("Not implemented: updateTagKeyCallable()");
  }

  public OperationCallable<DeleteTagKeyRequest, TagKey, DeleteTagKeyMetadata>
      deleteTagKeyOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteTagKeyOperationCallable()");
  }

  public UnaryCallable<DeleteTagKeyRequest, Operation> deleteTagKeyCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteTagKeyCallable()");
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
