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

package com.google.cloud.securitycenter.v1beta1;

import com.google.api.core.BetaApi;
import com.google.cloud.securitycenter.v1beta1.SecurityCenterGrpc.SecurityCenterImplBase;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockSecurityCenterImpl extends SecurityCenterImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockSecurityCenterImpl() {
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
  public void createSource(CreateSourceRequest request, StreamObserver<Source> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Source) {
      requests.add(request);
      responseObserver.onNext(((Source) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void createFinding(
      CreateFindingRequest request, StreamObserver<Finding> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Finding) {
      requests.add(request);
      responseObserver.onNext(((Finding) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
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
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void getOrganizationSettings(
      GetOrganizationSettingsRequest request,
      StreamObserver<OrganizationSettings> responseObserver) {
    Object response = responses.remove();
    if (response instanceof OrganizationSettings) {
      requests.add(request);
      responseObserver.onNext(((OrganizationSettings) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void getSource(GetSourceRequest request, StreamObserver<Source> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Source) {
      requests.add(request);
      responseObserver.onNext(((Source) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void groupAssets(
      GroupAssetsRequest request, StreamObserver<GroupAssetsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof GroupAssetsResponse) {
      requests.add(request);
      responseObserver.onNext(((GroupAssetsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void groupFindings(
      GroupFindingsRequest request, StreamObserver<GroupFindingsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof GroupFindingsResponse) {
      requests.add(request);
      responseObserver.onNext(((GroupFindingsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void listAssets(
      ListAssetsRequest request, StreamObserver<ListAssetsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListAssetsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAssetsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void listFindings(
      ListFindingsRequest request, StreamObserver<ListFindingsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListFindingsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListFindingsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void listSources(
      ListSourcesRequest request, StreamObserver<ListSourcesResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListSourcesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListSourcesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void runAssetDiscovery(
      RunAssetDiscoveryRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Operation) {
      requests.add(request);
      responseObserver.onNext(((Operation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void setFindingState(
      SetFindingStateRequest request, StreamObserver<Finding> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Finding) {
      requests.add(request);
      responseObserver.onNext(((Finding) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
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
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
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
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void updateFinding(
      UpdateFindingRequest request, StreamObserver<Finding> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Finding) {
      requests.add(request);
      responseObserver.onNext(((Finding) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void updateOrganizationSettings(
      UpdateOrganizationSettingsRequest request,
      StreamObserver<OrganizationSettings> responseObserver) {
    Object response = responses.remove();
    if (response instanceof OrganizationSettings) {
      requests.add(request);
      responseObserver.onNext(((OrganizationSettings) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void updateSource(UpdateSourceRequest request, StreamObserver<Source> responseObserver) {
    Object response = responses.remove();
    if (response instanceof Source) {
      requests.add(request);
      responseObserver.onNext(((Source) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void updateSecurityMarks(
      UpdateSecurityMarksRequest request, StreamObserver<SecurityMarks> responseObserver) {
    Object response = responses.remove();
    if (response instanceof SecurityMarks) {
      requests.add(request);
      responseObserver.onNext(((SecurityMarks) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }
}
