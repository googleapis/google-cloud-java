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

package com.google.cloud.apphub.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.apphub.v1.AppHubGrpc.AppHubImplBase;
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
public class MockAppHubImpl extends AppHubImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockAppHubImpl() {
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
  public void lookupServiceProjectAttachment(
      LookupServiceProjectAttachmentRequest request,
      StreamObserver<LookupServiceProjectAttachmentResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof LookupServiceProjectAttachmentResponse) {
      requests.add(request);
      responseObserver.onNext(((LookupServiceProjectAttachmentResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method LookupServiceProjectAttachment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  LookupServiceProjectAttachmentResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listServiceProjectAttachments(
      ListServiceProjectAttachmentsRequest request,
      StreamObserver<ListServiceProjectAttachmentsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListServiceProjectAttachmentsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListServiceProjectAttachmentsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListServiceProjectAttachments, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListServiceProjectAttachmentsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createServiceProjectAttachment(
      CreateServiceProjectAttachmentRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateServiceProjectAttachment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getServiceProjectAttachment(
      GetServiceProjectAttachmentRequest request,
      StreamObserver<ServiceProjectAttachment> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ServiceProjectAttachment) {
      requests.add(request);
      responseObserver.onNext(((ServiceProjectAttachment) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetServiceProjectAttachment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ServiceProjectAttachment.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteServiceProjectAttachment(
      DeleteServiceProjectAttachmentRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteServiceProjectAttachment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void detachServiceProjectAttachment(
      DetachServiceProjectAttachmentRequest request,
      StreamObserver<DetachServiceProjectAttachmentResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DetachServiceProjectAttachmentResponse) {
      requests.add(request);
      responseObserver.onNext(((DetachServiceProjectAttachmentResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DetachServiceProjectAttachment, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DetachServiceProjectAttachmentResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listDiscoveredServices(
      ListDiscoveredServicesRequest request,
      StreamObserver<ListDiscoveredServicesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListDiscoveredServicesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListDiscoveredServicesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListDiscoveredServices, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListDiscoveredServicesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getDiscoveredService(
      GetDiscoveredServiceRequest request, StreamObserver<DiscoveredService> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DiscoveredService) {
      requests.add(request);
      responseObserver.onNext(((DiscoveredService) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetDiscoveredService, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DiscoveredService.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void lookupDiscoveredService(
      LookupDiscoveredServiceRequest request,
      StreamObserver<LookupDiscoveredServiceResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof LookupDiscoveredServiceResponse) {
      requests.add(request);
      responseObserver.onNext(((LookupDiscoveredServiceResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method LookupDiscoveredService, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  LookupDiscoveredServiceResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listServices(
      ListServicesRequest request, StreamObserver<ListServicesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListServicesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListServicesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListServices, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListServicesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createService(
      CreateServiceRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateService, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getService(GetServiceRequest request, StreamObserver<Service> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Service) {
      requests.add(request);
      responseObserver.onNext(((Service) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetService, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Service.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateService(
      UpdateServiceRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateService, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteService(
      DeleteServiceRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteService, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listDiscoveredWorkloads(
      ListDiscoveredWorkloadsRequest request,
      StreamObserver<ListDiscoveredWorkloadsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListDiscoveredWorkloadsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListDiscoveredWorkloadsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListDiscoveredWorkloads, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListDiscoveredWorkloadsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getDiscoveredWorkload(
      GetDiscoveredWorkloadRequest request, StreamObserver<DiscoveredWorkload> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DiscoveredWorkload) {
      requests.add(request);
      responseObserver.onNext(((DiscoveredWorkload) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetDiscoveredWorkload, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DiscoveredWorkload.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void lookupDiscoveredWorkload(
      LookupDiscoveredWorkloadRequest request,
      StreamObserver<LookupDiscoveredWorkloadResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof LookupDiscoveredWorkloadResponse) {
      requests.add(request);
      responseObserver.onNext(((LookupDiscoveredWorkloadResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method LookupDiscoveredWorkload, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  LookupDiscoveredWorkloadResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listWorkloads(
      ListWorkloadsRequest request, StreamObserver<ListWorkloadsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListWorkloadsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListWorkloadsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListWorkloads, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListWorkloadsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createWorkload(
      CreateWorkloadRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateWorkload, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getWorkload(GetWorkloadRequest request, StreamObserver<Workload> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Workload) {
      requests.add(request);
      responseObserver.onNext(((Workload) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetWorkload, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Workload.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateWorkload(
      UpdateWorkloadRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateWorkload, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteWorkload(
      DeleteWorkloadRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteWorkload, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listApplications(
      ListApplicationsRequest request, StreamObserver<ListApplicationsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListApplicationsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListApplicationsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListApplications, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListApplicationsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createApplication(
      CreateApplicationRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateApplication, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getApplication(
      GetApplicationRequest request, StreamObserver<Application> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Application) {
      requests.add(request);
      responseObserver.onNext(((Application) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetApplication, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Application.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateApplication(
      UpdateApplicationRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateApplication, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteApplication(
      DeleteApplicationRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteApplication, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }
}
