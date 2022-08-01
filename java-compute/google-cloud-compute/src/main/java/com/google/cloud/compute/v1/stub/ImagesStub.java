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

package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.ImagesClient.ListPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.DeleteImageRequest;
import com.google.cloud.compute.v1.DeprecateImageRequest;
import com.google.cloud.compute.v1.GetFromFamilyImageRequest;
import com.google.cloud.compute.v1.GetIamPolicyImageRequest;
import com.google.cloud.compute.v1.GetImageRequest;
import com.google.cloud.compute.v1.Image;
import com.google.cloud.compute.v1.ImageList;
import com.google.cloud.compute.v1.InsertImageRequest;
import com.google.cloud.compute.v1.ListImagesRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.PatchImageRequest;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.SetIamPolicyImageRequest;
import com.google.cloud.compute.v1.SetLabelsImageRequest;
import com.google.cloud.compute.v1.TestIamPermissionsImageRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Images service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class ImagesStub implements BackgroundResource {

  public OperationCallable<DeleteImageRequest, Operation, Operation> deleteOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteOperationCallable()");
  }

  public UnaryCallable<DeleteImageRequest, Operation> deleteCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteCallable()");
  }

  public OperationCallable<DeprecateImageRequest, Operation, Operation>
      deprecateOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: deprecateOperationCallable()");
  }

  public UnaryCallable<DeprecateImageRequest, Operation> deprecateCallable() {
    throw new UnsupportedOperationException("Not implemented: deprecateCallable()");
  }

  public UnaryCallable<GetImageRequest, Image> getCallable() {
    throw new UnsupportedOperationException("Not implemented: getCallable()");
  }

  public UnaryCallable<GetFromFamilyImageRequest, Image> getFromFamilyCallable() {
    throw new UnsupportedOperationException("Not implemented: getFromFamilyCallable()");
  }

  public UnaryCallable<GetIamPolicyImageRequest, Policy> getIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyCallable()");
  }

  public OperationCallable<InsertImageRequest, Operation, Operation> insertOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: insertOperationCallable()");
  }

  public UnaryCallable<InsertImageRequest, Operation> insertCallable() {
    throw new UnsupportedOperationException("Not implemented: insertCallable()");
  }

  public UnaryCallable<ListImagesRequest, ListPagedResponse> listPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listPagedCallable()");
  }

  public UnaryCallable<ListImagesRequest, ImageList> listCallable() {
    throw new UnsupportedOperationException("Not implemented: listCallable()");
  }

  public OperationCallable<PatchImageRequest, Operation, Operation> patchOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: patchOperationCallable()");
  }

  public UnaryCallable<PatchImageRequest, Operation> patchCallable() {
    throw new UnsupportedOperationException("Not implemented: patchCallable()");
  }

  public UnaryCallable<SetIamPolicyImageRequest, Policy> setIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyCallable()");
  }

  public OperationCallable<SetLabelsImageRequest, Operation, Operation>
      setLabelsOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: setLabelsOperationCallable()");
  }

  public UnaryCallable<SetLabelsImageRequest, Operation> setLabelsCallable() {
    throw new UnsupportedOperationException("Not implemented: setLabelsCallable()");
  }

  public UnaryCallable<TestIamPermissionsImageRequest, TestPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  @Override
  public abstract void close();
}
