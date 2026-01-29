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

package com.google.cloud.auditmanager.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.auditmanager.v1.AuditManagerGrpc.AuditManagerImplBase;
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
public class MockAuditManagerImpl extends AuditManagerImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockAuditManagerImpl() {
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
  public void enrollResource(
      EnrollResourceRequest request, StreamObserver<Enrollment> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Enrollment) {
      requests.add(request);
      responseObserver.onNext(((Enrollment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method EnrollResource, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Enrollment.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void generateAuditScopeReport(
      GenerateAuditScopeReportRequest request, StreamObserver<AuditScopeReport> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AuditScopeReport) {
      requests.add(request);
      responseObserver.onNext(((AuditScopeReport) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GenerateAuditScopeReport, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AuditScopeReport.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void generateAuditReport(
      GenerateAuditReportRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method GenerateAuditReport, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listAuditReports(
      ListAuditReportsRequest request, StreamObserver<ListAuditReportsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListAuditReportsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAuditReportsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListAuditReports, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListAuditReportsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getAuditReport(
      GetAuditReportRequest request, StreamObserver<AuditReport> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AuditReport) {
      requests.add(request);
      responseObserver.onNext(((AuditReport) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetAuditReport, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AuditReport.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getResourceEnrollmentStatus(
      GetResourceEnrollmentStatusRequest request,
      StreamObserver<ResourceEnrollmentStatus> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ResourceEnrollmentStatus) {
      requests.add(request);
      responseObserver.onNext(((ResourceEnrollmentStatus) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetResourceEnrollmentStatus, expected"
                      + " %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ResourceEnrollmentStatus.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listResourceEnrollmentStatuses(
      ListResourceEnrollmentStatusesRequest request,
      StreamObserver<ListResourceEnrollmentStatusesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListResourceEnrollmentStatusesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListResourceEnrollmentStatusesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListResourceEnrollmentStatuses,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListResourceEnrollmentStatusesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listControls(
      ListControlsRequest request, StreamObserver<ListControlsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListControlsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListControlsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListControls, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListControlsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
