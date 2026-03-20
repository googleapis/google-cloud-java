/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.cloudsecuritycompliance.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.cloudsecuritycompliance.v1.AuditGrpc.AuditImplBase;
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
public class MockAuditImpl extends AuditImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockAuditImpl() {
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
  public void generateFrameworkAuditScopeReport(
      GenerateFrameworkAuditScopeReportRequest request,
      StreamObserver<GenerateFrameworkAuditScopeReportResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof GenerateFrameworkAuditScopeReportResponse) {
      requests.add(request);
      responseObserver.onNext(((GenerateFrameworkAuditScopeReportResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GenerateFrameworkAuditScopeReport,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  GenerateFrameworkAuditScopeReportResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createFrameworkAudit(
      CreateFrameworkAuditRequest request, StreamObserver<Operation> responseObserver) {
    Object response = responses.poll();
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
                  "Unrecognized response type %s for method CreateFrameworkAudit, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listFrameworkAudits(
      ListFrameworkAuditsRequest request,
      StreamObserver<ListFrameworkAuditsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListFrameworkAuditsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListFrameworkAuditsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListFrameworkAudits, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListFrameworkAuditsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getFrameworkAudit(
      GetFrameworkAuditRequest request, StreamObserver<FrameworkAudit> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FrameworkAudit) {
      requests.add(request);
      responseObserver.onNext(((FrameworkAudit) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetFrameworkAudit, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FrameworkAudit.class.getName(),
                  Exception.class.getName())));
    }
  }
}
