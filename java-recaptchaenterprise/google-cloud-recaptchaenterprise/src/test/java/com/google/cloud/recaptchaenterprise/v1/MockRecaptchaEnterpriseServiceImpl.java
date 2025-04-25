/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.recaptchaenterprise.v1;

import com.google.api.core.BetaApi;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import com.google.recaptchaenterprise.v1.AddIpOverrideRequest;
import com.google.recaptchaenterprise.v1.AddIpOverrideResponse;
import com.google.recaptchaenterprise.v1.AnnotateAssessmentRequest;
import com.google.recaptchaenterprise.v1.AnnotateAssessmentResponse;
import com.google.recaptchaenterprise.v1.Assessment;
import com.google.recaptchaenterprise.v1.CreateAssessmentRequest;
import com.google.recaptchaenterprise.v1.CreateFirewallPolicyRequest;
import com.google.recaptchaenterprise.v1.CreateKeyRequest;
import com.google.recaptchaenterprise.v1.DeleteFirewallPolicyRequest;
import com.google.recaptchaenterprise.v1.DeleteKeyRequest;
import com.google.recaptchaenterprise.v1.FirewallPolicy;
import com.google.recaptchaenterprise.v1.GetFirewallPolicyRequest;
import com.google.recaptchaenterprise.v1.GetKeyRequest;
import com.google.recaptchaenterprise.v1.GetMetricsRequest;
import com.google.recaptchaenterprise.v1.Key;
import com.google.recaptchaenterprise.v1.ListFirewallPoliciesRequest;
import com.google.recaptchaenterprise.v1.ListFirewallPoliciesResponse;
import com.google.recaptchaenterprise.v1.ListIpOverridesRequest;
import com.google.recaptchaenterprise.v1.ListIpOverridesResponse;
import com.google.recaptchaenterprise.v1.ListKeysRequest;
import com.google.recaptchaenterprise.v1.ListKeysResponse;
import com.google.recaptchaenterprise.v1.ListRelatedAccountGroupMembershipsRequest;
import com.google.recaptchaenterprise.v1.ListRelatedAccountGroupMembershipsResponse;
import com.google.recaptchaenterprise.v1.ListRelatedAccountGroupsRequest;
import com.google.recaptchaenterprise.v1.ListRelatedAccountGroupsResponse;
import com.google.recaptchaenterprise.v1.Metrics;
import com.google.recaptchaenterprise.v1.MigrateKeyRequest;
import com.google.recaptchaenterprise.v1.RecaptchaEnterpriseServiceGrpc.RecaptchaEnterpriseServiceImplBase;
import com.google.recaptchaenterprise.v1.RemoveIpOverrideRequest;
import com.google.recaptchaenterprise.v1.RemoveIpOverrideResponse;
import com.google.recaptchaenterprise.v1.ReorderFirewallPoliciesRequest;
import com.google.recaptchaenterprise.v1.ReorderFirewallPoliciesResponse;
import com.google.recaptchaenterprise.v1.RetrieveLegacySecretKeyRequest;
import com.google.recaptchaenterprise.v1.RetrieveLegacySecretKeyResponse;
import com.google.recaptchaenterprise.v1.SearchRelatedAccountGroupMembershipsRequest;
import com.google.recaptchaenterprise.v1.SearchRelatedAccountGroupMembershipsResponse;
import com.google.recaptchaenterprise.v1.UpdateFirewallPolicyRequest;
import com.google.recaptchaenterprise.v1.UpdateKeyRequest;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockRecaptchaEnterpriseServiceImpl extends RecaptchaEnterpriseServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockRecaptchaEnterpriseServiceImpl() {
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
  public void createAssessment(
      CreateAssessmentRequest request, StreamObserver<Assessment> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Assessment) {
      requests.add(request);
      responseObserver.onNext(((Assessment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateAssessment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Assessment.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void annotateAssessment(
      AnnotateAssessmentRequest request,
      StreamObserver<AnnotateAssessmentResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AnnotateAssessmentResponse) {
      requests.add(request);
      responseObserver.onNext(((AnnotateAssessmentResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method AnnotateAssessment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AnnotateAssessmentResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createKey(CreateKeyRequest request, StreamObserver<Key> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Key) {
      requests.add(request);
      responseObserver.onNext(((Key) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateKey, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Key.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listKeys(ListKeysRequest request, StreamObserver<ListKeysResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListKeysResponse) {
      requests.add(request);
      responseObserver.onNext(((ListKeysResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListKeys, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListKeysResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void retrieveLegacySecretKey(
      RetrieveLegacySecretKeyRequest request,
      StreamObserver<RetrieveLegacySecretKeyResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RetrieveLegacySecretKeyResponse) {
      requests.add(request);
      responseObserver.onNext(((RetrieveLegacySecretKeyResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RetrieveLegacySecretKey, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RetrieveLegacySecretKeyResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getKey(GetKeyRequest request, StreamObserver<Key> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Key) {
      requests.add(request);
      responseObserver.onNext(((Key) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetKey, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Key.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateKey(UpdateKeyRequest request, StreamObserver<Key> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Key) {
      requests.add(request);
      responseObserver.onNext(((Key) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateKey, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Key.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteKey(DeleteKeyRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.poll();
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
                  "Unrecognized response type %s for method DeleteKey, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void migrateKey(MigrateKeyRequest request, StreamObserver<Key> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Key) {
      requests.add(request);
      responseObserver.onNext(((Key) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method MigrateKey, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Key.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void addIpOverride(
      AddIpOverrideRequest request, StreamObserver<AddIpOverrideResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AddIpOverrideResponse) {
      requests.add(request);
      responseObserver.onNext(((AddIpOverrideResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method AddIpOverride, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AddIpOverrideResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void removeIpOverride(
      RemoveIpOverrideRequest request, StreamObserver<RemoveIpOverrideResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RemoveIpOverrideResponse) {
      requests.add(request);
      responseObserver.onNext(((RemoveIpOverrideResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RemoveIpOverride, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RemoveIpOverrideResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listIpOverrides(
      ListIpOverridesRequest request, StreamObserver<ListIpOverridesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListIpOverridesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListIpOverridesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListIpOverrides, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListIpOverridesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getMetrics(GetMetricsRequest request, StreamObserver<Metrics> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Metrics) {
      requests.add(request);
      responseObserver.onNext(((Metrics) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetMetrics, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Metrics.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createFirewallPolicy(
      CreateFirewallPolicyRequest request, StreamObserver<FirewallPolicy> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FirewallPolicy) {
      requests.add(request);
      responseObserver.onNext(((FirewallPolicy) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateFirewallPolicy, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FirewallPolicy.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listFirewallPolicies(
      ListFirewallPoliciesRequest request,
      StreamObserver<ListFirewallPoliciesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListFirewallPoliciesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListFirewallPoliciesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListFirewallPolicies, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListFirewallPoliciesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getFirewallPolicy(
      GetFirewallPolicyRequest request, StreamObserver<FirewallPolicy> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FirewallPolicy) {
      requests.add(request);
      responseObserver.onNext(((FirewallPolicy) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetFirewallPolicy, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FirewallPolicy.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateFirewallPolicy(
      UpdateFirewallPolicyRequest request, StreamObserver<FirewallPolicy> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FirewallPolicy) {
      requests.add(request);
      responseObserver.onNext(((FirewallPolicy) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateFirewallPolicy, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FirewallPolicy.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteFirewallPolicy(
      DeleteFirewallPolicyRequest request, StreamObserver<Empty> responseObserver) {
    Object response = responses.poll();
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
                  "Unrecognized response type %s for method DeleteFirewallPolicy, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void reorderFirewallPolicies(
      ReorderFirewallPoliciesRequest request,
      StreamObserver<ReorderFirewallPoliciesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ReorderFirewallPoliciesResponse) {
      requests.add(request);
      responseObserver.onNext(((ReorderFirewallPoliciesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ReorderFirewallPolicies, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ReorderFirewallPoliciesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listRelatedAccountGroups(
      ListRelatedAccountGroupsRequest request,
      StreamObserver<ListRelatedAccountGroupsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListRelatedAccountGroupsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListRelatedAccountGroupsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListRelatedAccountGroups, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListRelatedAccountGroupsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listRelatedAccountGroupMemberships(
      ListRelatedAccountGroupMembershipsRequest request,
      StreamObserver<ListRelatedAccountGroupMembershipsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListRelatedAccountGroupMembershipsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListRelatedAccountGroupMembershipsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListRelatedAccountGroupMemberships, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListRelatedAccountGroupMembershipsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void searchRelatedAccountGroupMemberships(
      SearchRelatedAccountGroupMembershipsRequest request,
      StreamObserver<SearchRelatedAccountGroupMembershipsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SearchRelatedAccountGroupMembershipsResponse) {
      requests.add(request);
      responseObserver.onNext(((SearchRelatedAccountGroupMembershipsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SearchRelatedAccountGroupMemberships, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SearchRelatedAccountGroupMembershipsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
