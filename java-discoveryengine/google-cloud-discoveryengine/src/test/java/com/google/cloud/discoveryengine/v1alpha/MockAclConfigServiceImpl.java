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

package com.google.cloud.discoveryengine.v1alpha;

import com.google.api.core.BetaApi;
import com.google.cloud.discoveryengine.v1alpha.AclConfigServiceGrpc.AclConfigServiceImplBase;
import com.google.protobuf.AbstractMessage;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Generated;

@BetaApi
@Generated("by gapic-generator-java")
public class MockAclConfigServiceImpl extends AclConfigServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockAclConfigServiceImpl() {
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
  public void updateAclConfig(
      UpdateAclConfigRequest request, StreamObserver<AclConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AclConfig) {
      requests.add(request);
      responseObserver.onNext(((AclConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateAclConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AclConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getAclConfig(
      GetAclConfigRequest request, StreamObserver<AclConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AclConfig) {
      requests.add(request);
      responseObserver.onNext(((AclConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetAclConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AclConfig.class.getName(),
                  Exception.class.getName())));
    }
  }
}
