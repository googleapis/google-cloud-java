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

package com.google.cloud.secretmanager.v1.stub;

import static com.google.cloud.secretmanager.v1.SecretManagerServiceClient.ListSecretVersionsPagedResponse;
import static com.google.cloud.secretmanager.v1.SecretManagerServiceClient.ListSecretsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.secretmanager.v1.AccessSecretVersionRequest;
import com.google.cloud.secretmanager.v1.AccessSecretVersionResponse;
import com.google.cloud.secretmanager.v1.AddSecretVersionRequest;
import com.google.cloud.secretmanager.v1.CreateSecretRequest;
import com.google.cloud.secretmanager.v1.DeleteSecretRequest;
import com.google.cloud.secretmanager.v1.DestroySecretVersionRequest;
import com.google.cloud.secretmanager.v1.DisableSecretVersionRequest;
import com.google.cloud.secretmanager.v1.EnableSecretVersionRequest;
import com.google.cloud.secretmanager.v1.GetSecretRequest;
import com.google.cloud.secretmanager.v1.GetSecretVersionRequest;
import com.google.cloud.secretmanager.v1.ListSecretVersionsRequest;
import com.google.cloud.secretmanager.v1.ListSecretVersionsResponse;
import com.google.cloud.secretmanager.v1.ListSecretsRequest;
import com.google.cloud.secretmanager.v1.ListSecretsResponse;
import com.google.cloud.secretmanager.v1.Secret;
import com.google.cloud.secretmanager.v1.SecretVersion;
import com.google.cloud.secretmanager.v1.UpdateSecretRequest;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the SecretManagerService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
public abstract class SecretManagerServiceStub implements BackgroundResource {

  public UnaryCallable<ListSecretsRequest, ListSecretsPagedResponse> listSecretsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSecretsPagedCallable()");
  }

  public UnaryCallable<ListSecretsRequest, ListSecretsResponse> listSecretsCallable() {
    throw new UnsupportedOperationException("Not implemented: listSecretsCallable()");
  }

  public UnaryCallable<CreateSecretRequest, Secret> createSecretCallable() {
    throw new UnsupportedOperationException("Not implemented: createSecretCallable()");
  }

  public UnaryCallable<AddSecretVersionRequest, SecretVersion> addSecretVersionCallable() {
    throw new UnsupportedOperationException("Not implemented: addSecretVersionCallable()");
  }

  public UnaryCallable<GetSecretRequest, Secret> getSecretCallable() {
    throw new UnsupportedOperationException("Not implemented: getSecretCallable()");
  }

  public UnaryCallable<UpdateSecretRequest, Secret> updateSecretCallable() {
    throw new UnsupportedOperationException("Not implemented: updateSecretCallable()");
  }

  public UnaryCallable<DeleteSecretRequest, Empty> deleteSecretCallable() {
    throw new UnsupportedOperationException("Not implemented: deleteSecretCallable()");
  }

  public UnaryCallable<ListSecretVersionsRequest, ListSecretVersionsPagedResponse>
      listSecretVersionsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listSecretVersionsPagedCallable()");
  }

  public UnaryCallable<ListSecretVersionsRequest, ListSecretVersionsResponse>
      listSecretVersionsCallable() {
    throw new UnsupportedOperationException("Not implemented: listSecretVersionsCallable()");
  }

  public UnaryCallable<GetSecretVersionRequest, SecretVersion> getSecretVersionCallable() {
    throw new UnsupportedOperationException("Not implemented: getSecretVersionCallable()");
  }

  public UnaryCallable<AccessSecretVersionRequest, AccessSecretVersionResponse>
      accessSecretVersionCallable() {
    throw new UnsupportedOperationException("Not implemented: accessSecretVersionCallable()");
  }

  public UnaryCallable<DisableSecretVersionRequest, SecretVersion> disableSecretVersionCallable() {
    throw new UnsupportedOperationException("Not implemented: disableSecretVersionCallable()");
  }

  public UnaryCallable<EnableSecretVersionRequest, SecretVersion> enableSecretVersionCallable() {
    throw new UnsupportedOperationException("Not implemented: enableSecretVersionCallable()");
  }

  public UnaryCallable<DestroySecretVersionRequest, SecretVersion> destroySecretVersionCallable() {
    throw new UnsupportedOperationException("Not implemented: destroySecretVersionCallable()");
  }

  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: setIamPolicyCallable()");
  }

  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    throw new UnsupportedOperationException("Not implemented: getIamPolicyCallable()");
  }

  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    throw new UnsupportedOperationException("Not implemented: testIamPermissionsCallable()");
  }

  @Override
  public abstract void close();
}
