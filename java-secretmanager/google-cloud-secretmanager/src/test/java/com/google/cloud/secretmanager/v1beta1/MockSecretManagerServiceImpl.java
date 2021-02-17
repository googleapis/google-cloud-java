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

package com.google.cloud.secretmanager.v1beta1;

import com.google.api.core.BetaApi;
import com.google.cloud.secretmanager.v1beta1.SecretManagerServiceGrpc.SecretManagerServiceImplBase;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockSecretManagerServiceImpl extends SecretManagerServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockSecretManagerServiceImpl() {
    requests = new ArrayList<>();
    responses = new LinkedList<>();
  }

  public List<AbstractMessage> getRequests() {
    return requests;
  }

  public void addResponse(AbstractMessage response) {
    responses.add(response);
  }

  public void setResponses(List<AbstractMessage> responses) {
    this.responses = new LinkedList<Object>(responses);
  }

  public void addException(Exception exception) {
    responses.add(exception);
  }

  public void reset() {
    requests = new ArrayList<>();
    responses = new LinkedList<>();
  }

  @Override
  public void listSecrets(
      ListSecretsRequest request, StreamObserver<ListSecretsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListSecretsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListSecretsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListSecrets, expected %s or %s",
                  response.getClass().getName(),
                  ListSecretsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createSecret(CreateSecretRequest request, StreamObserver<Secret> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Secret) {
      requests.add(request);
      responseObserver.onNext(((Secret) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateSecret, expected %s or %s",
                  response.getClass().getName(),
                  Secret.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void addSecretVersion(
      AddSecretVersionRequest request, StreamObserver<SecretVersion> responseObserver) {
    Object response = responses.remove();
    if (response instanceof SecretVersion) {
      requests.add(request);
      responseObserver.onNext(((SecretVersion) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method AddSecretVersion, expected %s or %s",
                  response.getClass().getName(),
                  SecretVersion.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getSecret(GetSecretRequest request, StreamObserver<Secret> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Secret) {
      requests.add(request);
      responseObserver.onNext(((Secret) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetSecret, expected %s or %s",
                  response.getClass().getName(),
                  Secret.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateSecret(UpdateSecretRequest request, StreamObserver<Secret> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Secret) {
      requests.add(request);
      responseObserver.onNext(((Secret) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateSecret, expected %s or %s",
                  response.getClass().getName(),
                  Secret.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteSecret(DeleteSecretRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Empty) {
      requests.add(request);
      responseObserver.onNext(((Empty) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteSecret, expected %s or %s",
                  response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listSecretVersions(
      ListSecretVersionsRequest request,
      StreamObserver<ListSecretVersionsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListSecretVersionsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListSecretVersionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListSecretVersions, expected %s or %s",
                  response.getClass().getName(),
                  ListSecretVersionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getSecretVersion(
      GetSecretVersionRequest request, StreamObserver<SecretVersion> responseObserver) {
    Object response = responses.remove();
    if (response instanceof SecretVersion) {
      requests.add(request);
      responseObserver.onNext(((SecretVersion) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetSecretVersion, expected %s or %s",
                  response.getClass().getName(),
                  SecretVersion.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void accessSecretVersion(
      AccessSecretVersionRequest request,
      StreamObserver<AccessSecretVersionResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof AccessSecretVersionResponse) {
      requests.add(request);
      responseObserver.onNext(((AccessSecretVersionResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method AccessSecretVersion, expected %s or %s",
                  response.getClass().getName(),
                  AccessSecretVersionResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void disableSecretVersion(
      DisableSecretVersionRequest request, StreamObserver<SecretVersion> responseObserver) {
    Object response = responses.remove();
    if (response instanceof SecretVersion) {
      requests.add(request);
      responseObserver.onNext(((SecretVersion) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DisableSecretVersion, expected %s or %s",
                  response.getClass().getName(),
                  SecretVersion.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void enableSecretVersion(
      EnableSecretVersionRequest request, StreamObserver<SecretVersion> responseObserver) {
    Object response = responses.remove();
    if (response instanceof SecretVersion) {
      requests.add(request);
      responseObserver.onNext(((SecretVersion) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method EnableSecretVersion, expected %s or %s",
                  response.getClass().getName(),
                  SecretVersion.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void destroySecretVersion(
      DestroySecretVersionRequest request, StreamObserver<SecretVersion> responseObserver) {
    Object response = responses.remove();
    if (response instanceof SecretVersion) {
      requests.add(request);
      responseObserver.onNext(((SecretVersion) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DestroySecretVersion, expected %s or %s",
                  response.getClass().getName(),
                  SecretVersion.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void setIamPolicy(SetIamPolicyRequest request, StreamObserver<Policy> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Policy) {
      requests.add(request);
      responseObserver.onNext(((Policy) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SetIamPolicy, expected %s or %s",
                  response.getClass().getName(),
                  Policy.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getIamPolicy(GetIamPolicyRequest request, StreamObserver<Policy> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Policy) {
      requests.add(request);
      responseObserver.onNext(((Policy) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetIamPolicy, expected %s or %s",
                  response.getClass().getName(),
                  Policy.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void testIamPermissions(
      TestIamPermissionsRequest request,
      StreamObserver<TestIamPermissionsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof TestIamPermissionsResponse) {
      requests.add(request);
      responseObserver.onNext(((TestIamPermissionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method TestIamPermissions, expected %s or %s",
                  response.getClass().getName(),
                  TestIamPermissionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
