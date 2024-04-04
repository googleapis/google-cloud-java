/*
 * Copyright 2024 Google LLC
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
  private Queue<java.lang.Object> responses;

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
    this.responses = new LinkedList<java.lang.Object>(responses);
  }

  public void addException(Exception exception) {
    responses.add(exception);
  }

  public void reset() {
    requests = new ArrayList<>();
    responses = new LinkedList<>();
  }

  @Override
  public void bulkMuteFindings(
      BulkMuteFindingsRequest request, StreamObserver<Operation> responseObserver) {
    java.lang.Object response = responses.poll();
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
                  "Unrecognized response type %s for method BulkMuteFindings, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createSecurityHealthAnalyticsCustomModule(
      CreateSecurityHealthAnalyticsCustomModuleRequest request,
      StreamObserver<SecurityHealthAnalyticsCustomModule> responseObserver) {
    java.lang.Object response = responses.poll();
    if (response instanceof SecurityHealthAnalyticsCustomModule) {
      requests.add(request);
      responseObserver.onNext(((SecurityHealthAnalyticsCustomModule) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateSecurityHealthAnalyticsCustomModule, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SecurityHealthAnalyticsCustomModule.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createSource(CreateSourceRequest request, StreamObserver<Source> responseObserver) {
    java.lang.Object response = responses.poll();
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
                  response == null ? "null" : response.getClass().getName(),
                  Source.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createFinding(
      CreateFindingRequest request, StreamObserver<Finding> responseObserver) {
    java.lang.Object response = responses.poll();
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
                  response == null ? "null" : response.getClass().getName(),
                  Finding.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createMuteConfig(
      CreateMuteConfigRequest request, StreamObserver<MuteConfig> responseObserver) {
    java.lang.Object response = responses.poll();
    if (response instanceof MuteConfig) {
      requests.add(request);
      responseObserver.onNext(((MuteConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateMuteConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  MuteConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createNotificationConfig(
      CreateNotificationConfigRequest request,
      StreamObserver<NotificationConfig> responseObserver) {
    java.lang.Object response = responses.poll();
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
                  response == null ? "null" : response.getClass().getName(),
                  NotificationConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteMuteConfig(
      DeleteMuteConfigRequest request, StreamObserver<Empty> responseObserver) {
    java.lang.Object response = responses.poll();
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
                  "Unrecognized response type %s for method DeleteMuteConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteNotificationConfig(
      DeleteNotificationConfigRequest request, StreamObserver<Empty> responseObserver) {
    java.lang.Object response = responses.poll();
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
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteSecurityHealthAnalyticsCustomModule(
      DeleteSecurityHealthAnalyticsCustomModuleRequest request,
      StreamObserver<Empty> responseObserver) {
    java.lang.Object response = responses.poll();
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
                  "Unrecognized response type %s for method DeleteSecurityHealthAnalyticsCustomModule, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getBigQueryExport(
      GetBigQueryExportRequest request, StreamObserver<BigQueryExport> responseObserver) {
    java.lang.Object response = responses.poll();
    if (response instanceof BigQueryExport) {
      requests.add(request);
      responseObserver.onNext(((BigQueryExport) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetBigQueryExport, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  BigQueryExport.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getIamPolicy(GetIamPolicyRequest request, StreamObserver<Policy> responseObserver) {
    java.lang.Object response = responses.poll();
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
                  response == null ? "null" : response.getClass().getName(),
                  Policy.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getMuteConfig(
      GetMuteConfigRequest request, StreamObserver<MuteConfig> responseObserver) {
    java.lang.Object response = responses.poll();
    if (response instanceof MuteConfig) {
      requests.add(request);
      responseObserver.onNext(((MuteConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetMuteConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  MuteConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getNotificationConfig(
      GetNotificationConfigRequest request, StreamObserver<NotificationConfig> responseObserver) {
    java.lang.Object response = responses.poll();
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
                  response == null ? "null" : response.getClass().getName(),
                  NotificationConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getOrganizationSettings(
      GetOrganizationSettingsRequest request,
      StreamObserver<OrganizationSettings> responseObserver) {
    java.lang.Object response = responses.poll();
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
                  response == null ? "null" : response.getClass().getName(),
                  OrganizationSettings.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getEffectiveSecurityHealthAnalyticsCustomModule(
      GetEffectiveSecurityHealthAnalyticsCustomModuleRequest request,
      StreamObserver<EffectiveSecurityHealthAnalyticsCustomModule> responseObserver) {
    java.lang.Object response = responses.poll();
    if (response instanceof EffectiveSecurityHealthAnalyticsCustomModule) {
      requests.add(request);
      responseObserver.onNext(((EffectiveSecurityHealthAnalyticsCustomModule) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetEffectiveSecurityHealthAnalyticsCustomModule, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  EffectiveSecurityHealthAnalyticsCustomModule.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getSecurityHealthAnalyticsCustomModule(
      GetSecurityHealthAnalyticsCustomModuleRequest request,
      StreamObserver<SecurityHealthAnalyticsCustomModule> responseObserver) {
    java.lang.Object response = responses.poll();
    if (response instanceof SecurityHealthAnalyticsCustomModule) {
      requests.add(request);
      responseObserver.onNext(((SecurityHealthAnalyticsCustomModule) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetSecurityHealthAnalyticsCustomModule, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SecurityHealthAnalyticsCustomModule.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getSource(GetSourceRequest request, StreamObserver<Source> responseObserver) {
    java.lang.Object response = responses.poll();
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
                  response == null ? "null" : response.getClass().getName(),
                  Source.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void groupAssets(
      GroupAssetsRequest request, StreamObserver<GroupAssetsResponse> responseObserver) {
    java.lang.Object response = responses.poll();
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
                  response == null ? "null" : response.getClass().getName(),
                  GroupAssetsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void groupFindings(
      GroupFindingsRequest request, StreamObserver<GroupFindingsResponse> responseObserver) {
    java.lang.Object response = responses.poll();
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
                  response == null ? "null" : response.getClass().getName(),
                  GroupFindingsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listAssets(
      ListAssetsRequest request, StreamObserver<ListAssetsResponse> responseObserver) {
    java.lang.Object response = responses.poll();
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
                  response == null ? "null" : response.getClass().getName(),
                  ListAssetsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listDescendantSecurityHealthAnalyticsCustomModules(
      ListDescendantSecurityHealthAnalyticsCustomModulesRequest request,
      StreamObserver<ListDescendantSecurityHealthAnalyticsCustomModulesResponse> responseObserver) {
    java.lang.Object response = responses.poll();
    if (response instanceof ListDescendantSecurityHealthAnalyticsCustomModulesResponse) {
      requests.add(request);
      responseObserver.onNext(
          ((ListDescendantSecurityHealthAnalyticsCustomModulesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListDescendantSecurityHealthAnalyticsCustomModules, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListDescendantSecurityHealthAnalyticsCustomModulesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listFindings(
      ListFindingsRequest request, StreamObserver<ListFindingsResponse> responseObserver) {
    java.lang.Object response = responses.poll();
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
                  response == null ? "null" : response.getClass().getName(),
                  ListFindingsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listMuteConfigs(
      ListMuteConfigsRequest request, StreamObserver<ListMuteConfigsResponse> responseObserver) {
    java.lang.Object response = responses.poll();
    if (response instanceof ListMuteConfigsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListMuteConfigsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListMuteConfigs, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListMuteConfigsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listNotificationConfigs(
      ListNotificationConfigsRequest request,
      StreamObserver<ListNotificationConfigsResponse> responseObserver) {
    java.lang.Object response = responses.poll();
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
                  response == null ? "null" : response.getClass().getName(),
                  ListNotificationConfigsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listEffectiveSecurityHealthAnalyticsCustomModules(
      ListEffectiveSecurityHealthAnalyticsCustomModulesRequest request,
      StreamObserver<ListEffectiveSecurityHealthAnalyticsCustomModulesResponse> responseObserver) {
    java.lang.Object response = responses.poll();
    if (response instanceof ListEffectiveSecurityHealthAnalyticsCustomModulesResponse) {
      requests.add(request);
      responseObserver.onNext(
          ((ListEffectiveSecurityHealthAnalyticsCustomModulesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListEffectiveSecurityHealthAnalyticsCustomModules, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListEffectiveSecurityHealthAnalyticsCustomModulesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listSecurityHealthAnalyticsCustomModules(
      ListSecurityHealthAnalyticsCustomModulesRequest request,
      StreamObserver<ListSecurityHealthAnalyticsCustomModulesResponse> responseObserver) {
    java.lang.Object response = responses.poll();
    if (response instanceof ListSecurityHealthAnalyticsCustomModulesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListSecurityHealthAnalyticsCustomModulesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListSecurityHealthAnalyticsCustomModules, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListSecurityHealthAnalyticsCustomModulesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listSources(
      ListSourcesRequest request, StreamObserver<ListSourcesResponse> responseObserver) {
    java.lang.Object response = responses.poll();
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
                  response == null ? "null" : response.getClass().getName(),
                  ListSourcesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void runAssetDiscovery(
      RunAssetDiscoveryRequest request, StreamObserver<Operation> responseObserver) {
    java.lang.Object response = responses.poll();
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
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void setFindingState(
      SetFindingStateRequest request, StreamObserver<Finding> responseObserver) {
    java.lang.Object response = responses.poll();
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
                  response == null ? "null" : response.getClass().getName(),
                  Finding.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void setMute(SetMuteRequest request, StreamObserver<Finding> responseObserver) {
    java.lang.Object response = responses.poll();
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
                  "Unrecognized response type %s for method SetMute, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Finding.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void setIamPolicy(SetIamPolicyRequest request, StreamObserver<Policy> responseObserver) {
    java.lang.Object response = responses.poll();
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
                  response == null ? "null" : response.getClass().getName(),
                  Policy.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void testIamPermissions(
      TestIamPermissionsRequest request,
      StreamObserver<TestIamPermissionsResponse> responseObserver) {
    java.lang.Object response = responses.poll();
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
                  response == null ? "null" : response.getClass().getName(),
                  TestIamPermissionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void simulateSecurityHealthAnalyticsCustomModule(
      SimulateSecurityHealthAnalyticsCustomModuleRequest request,
      StreamObserver<SimulateSecurityHealthAnalyticsCustomModuleResponse> responseObserver) {
    java.lang.Object response = responses.poll();
    if (response instanceof SimulateSecurityHealthAnalyticsCustomModuleResponse) {
      requests.add(request);
      responseObserver.onNext(((SimulateSecurityHealthAnalyticsCustomModuleResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SimulateSecurityHealthAnalyticsCustomModule, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SimulateSecurityHealthAnalyticsCustomModuleResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateExternalSystem(
      UpdateExternalSystemRequest request, StreamObserver<ExternalSystem> responseObserver) {
    java.lang.Object response = responses.poll();
    if (response instanceof ExternalSystem) {
      requests.add(request);
      responseObserver.onNext(((ExternalSystem) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateExternalSystem, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ExternalSystem.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateFinding(
      UpdateFindingRequest request, StreamObserver<Finding> responseObserver) {
    java.lang.Object response = responses.poll();
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
                  response == null ? "null" : response.getClass().getName(),
                  Finding.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateMuteConfig(
      UpdateMuteConfigRequest request, StreamObserver<MuteConfig> responseObserver) {
    java.lang.Object response = responses.poll();
    if (response instanceof MuteConfig) {
      requests.add(request);
      responseObserver.onNext(((MuteConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateMuteConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  MuteConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateNotificationConfig(
      UpdateNotificationConfigRequest request,
      StreamObserver<NotificationConfig> responseObserver) {
    java.lang.Object response = responses.poll();
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
                  response == null ? "null" : response.getClass().getName(),
                  NotificationConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateOrganizationSettings(
      UpdateOrganizationSettingsRequest request,
      StreamObserver<OrganizationSettings> responseObserver) {
    java.lang.Object response = responses.poll();
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
                  response == null ? "null" : response.getClass().getName(),
                  OrganizationSettings.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateSecurityHealthAnalyticsCustomModule(
      UpdateSecurityHealthAnalyticsCustomModuleRequest request,
      StreamObserver<SecurityHealthAnalyticsCustomModule> responseObserver) {
    java.lang.Object response = responses.poll();
    if (response instanceof SecurityHealthAnalyticsCustomModule) {
      requests.add(request);
      responseObserver.onNext(((SecurityHealthAnalyticsCustomModule) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateSecurityHealthAnalyticsCustomModule, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SecurityHealthAnalyticsCustomModule.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateSource(UpdateSourceRequest request, StreamObserver<Source> responseObserver) {
    java.lang.Object response = responses.poll();
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
                  response == null ? "null" : response.getClass().getName(),
                  Source.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateSecurityMarks(
      UpdateSecurityMarksRequest request, StreamObserver<SecurityMarks> responseObserver) {
    java.lang.Object response = responses.poll();
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
                  response == null ? "null" : response.getClass().getName(),
                  SecurityMarks.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createBigQueryExport(
      CreateBigQueryExportRequest request, StreamObserver<BigQueryExport> responseObserver) {
    java.lang.Object response = responses.poll();
    if (response instanceof BigQueryExport) {
      requests.add(request);
      responseObserver.onNext(((BigQueryExport) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateBigQueryExport, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  BigQueryExport.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteBigQueryExport(
      DeleteBigQueryExportRequest request, StreamObserver<Empty> responseObserver) {
    java.lang.Object response = responses.poll();
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
                  "Unrecognized response type %s for method DeleteBigQueryExport, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateBigQueryExport(
      UpdateBigQueryExportRequest request, StreamObserver<BigQueryExport> responseObserver) {
    java.lang.Object response = responses.poll();
    if (response instanceof BigQueryExport) {
      requests.add(request);
      responseObserver.onNext(((BigQueryExport) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateBigQueryExport, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  BigQueryExport.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listBigQueryExports(
      ListBigQueryExportsRequest request,
      StreamObserver<ListBigQueryExportsResponse> responseObserver) {
    java.lang.Object response = responses.poll();
    if (response instanceof ListBigQueryExportsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListBigQueryExportsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListBigQueryExports, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListBigQueryExportsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
