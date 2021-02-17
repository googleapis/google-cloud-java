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

package com.google.cloud.securitycenter.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.securitycenter.v1.SecurityCenterGrpc.SecurityCenterImplBase;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
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
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateSource, expected %s or %s",
                  response.getClass().getName(),
                  Source.class.getName(),
                  Exception.class.getName())));
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
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateFinding, expected %s or %s",
                  response.getClass().getName(),
                  Finding.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createNotificationConfig(
      CreateNotificationConfigRequest request,
      StreamObserver<NotificationConfig> responseObserver) {
    Object response = responses.remove();
    if (response instanceof NotificationConfig) {
      requests.add(request);
      responseObserver.onNext(((NotificationConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateNotificationConfig, expected %s or %s",
                  response.getClass().getName(),
                  NotificationConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteNotificationConfig(
      DeleteNotificationConfigRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteNotificationConfig, expected %s or %s",
                  response.getClass().getName(),
                  Empty.class.getName(),
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
  public void getNotificationConfig(
      GetNotificationConfigRequest request, StreamObserver<NotificationConfig> responseObserver) {
    Object response = responses.remove();
    if (response instanceof NotificationConfig) {
      requests.add(request);
      responseObserver.onNext(((NotificationConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetNotificationConfig, expected %s or %s",
                  response.getClass().getName(),
                  NotificationConfig.class.getName(),
                  Exception.class.getName())));
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
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetOrganizationSettings, expected %s or %s",
                  response.getClass().getName(),
                  OrganizationSettings.class.getName(),
                  Exception.class.getName())));
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
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetSource, expected %s or %s",
                  response.getClass().getName(),
                  Source.class.getName(),
                  Exception.class.getName())));
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
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GroupAssets, expected %s or %s",
                  response.getClass().getName(),
                  GroupAssetsResponse.class.getName(),
                  Exception.class.getName())));
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
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GroupFindings, expected %s or %s",
                  response.getClass().getName(),
                  GroupFindingsResponse.class.getName(),
                  Exception.class.getName())));
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
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListAssets, expected %s or %s",
                  response.getClass().getName(),
                  ListAssetsResponse.class.getName(),
                  Exception.class.getName())));
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
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListFindings, expected %s or %s",
                  response.getClass().getName(),
                  ListFindingsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listNotificationConfigs(
      ListNotificationConfigsRequest request,
      StreamObserver<ListNotificationConfigsResponse> responseObserver) {
    Object response = responses.remove();
    if (response instanceof ListNotificationConfigsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListNotificationConfigsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListNotificationConfigs, expected %s or %s",
                  response.getClass().getName(),
                  ListNotificationConfigsResponse.class.getName(),
                  Exception.class.getName())));
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
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListSources, expected %s or %s",
                  response.getClass().getName(),
                  ListSourcesResponse.class.getName(),
                  Exception.class.getName())));
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
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RunAssetDiscovery, expected %s or %s",
                  response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
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
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SetFindingState, expected %s or %s",
                  response.getClass().getName(),
                  Finding.class.getName(),
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
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateFinding, expected %s or %s",
                  response.getClass().getName(),
                  Finding.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateNotificationConfig(
      UpdateNotificationConfigRequest request,
      StreamObserver<NotificationConfig> responseObserver) {
    Object response = responses.remove();
    if (response instanceof NotificationConfig) {
      requests.add(request);
      responseObserver.onNext(((NotificationConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateNotificationConfig, expected %s or %s",
                  response.getClass().getName(),
                  NotificationConfig.class.getName(),
                  Exception.class.getName())));
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
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateOrganizationSettings, expected %s or %s",
                  response.getClass().getName(),
                  OrganizationSettings.class.getName(),
                  Exception.class.getName())));
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
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateSource, expected %s or %s",
                  response.getClass().getName(),
                  Source.class.getName(),
                  Exception.class.getName())));
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
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateSecurityMarks, expected %s or %s",
                  response.getClass().getName(),
                  SecurityMarks.class.getName(),
                  Exception.class.getName())));
    }
  }
}
