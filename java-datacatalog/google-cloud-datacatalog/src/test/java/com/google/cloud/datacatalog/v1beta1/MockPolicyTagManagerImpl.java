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

package com.google.cloud.datacatalog.v1beta1;

import com.google.api.core.BetaApi;
import com.google.cloud.datacatalog.v1beta1.PolicyTagManagerGrpc.PolicyTagManagerImplBase;
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
public class MockPolicyTagManagerImpl extends PolicyTagManagerImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockPolicyTagManagerImpl() {
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
  public void createTaxonomy(
      CreateTaxonomyRequest request, StreamObserver<Taxonomy> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Taxonomy) {
      requests.add(request);
      responseObserver.onNext(((Taxonomy) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateTaxonomy, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Taxonomy.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteTaxonomy(
      DeleteTaxonomyRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteTaxonomy, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateTaxonomy(
      UpdateTaxonomyRequest request, StreamObserver<Taxonomy> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Taxonomy) {
      requests.add(request);
      responseObserver.onNext(((Taxonomy) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateTaxonomy, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Taxonomy.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listTaxonomies(
      ListTaxonomiesRequest request, StreamObserver<ListTaxonomiesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListTaxonomiesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListTaxonomiesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListTaxonomies, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListTaxonomiesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getTaxonomy(GetTaxonomyRequest request, StreamObserver<Taxonomy> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Taxonomy) {
      requests.add(request);
      responseObserver.onNext(((Taxonomy) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetTaxonomy, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Taxonomy.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createPolicyTag(
      CreatePolicyTagRequest request, StreamObserver<PolicyTag> responseObserver) {
    Object response = responses.poll();
    if (response instanceof PolicyTag) {
      requests.add(request);
      responseObserver.onNext(((PolicyTag) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreatePolicyTag, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  PolicyTag.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deletePolicyTag(
      DeletePolicyTagRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeletePolicyTag, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updatePolicyTag(
      UpdatePolicyTagRequest request, StreamObserver<PolicyTag> responseObserver) {
    Object response = responses.poll();
    if (response instanceof PolicyTag) {
      requests.add(request);
      responseObserver.onNext(((PolicyTag) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdatePolicyTag, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  PolicyTag.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listPolicyTags(
      ListPolicyTagsRequest request, StreamObserver<ListPolicyTagsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListPolicyTagsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListPolicyTagsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListPolicyTags, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListPolicyTagsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getPolicyTag(
      GetPolicyTagRequest request, StreamObserver<PolicyTag> responseObserver) {
    Object response = responses.poll();
    if (response instanceof PolicyTag) {
      requests.add(request);
      responseObserver.onNext(((PolicyTag) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetPolicyTag, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  PolicyTag.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getIamPolicy(GetIamPolicyRequest request, StreamObserver<Policy> responseObserver) {
    Object response = responses.poll();
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
  public void setIamPolicy(SetIamPolicyRequest request, StreamObserver<Policy> responseObserver) {
    Object response = responses.poll();
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
    Object response = responses.poll();
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
}
