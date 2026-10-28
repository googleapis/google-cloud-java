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

package com.google.cloud.designcenter.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.designcenter.v1.DesignCenterGrpc.DesignCenterImplBase;
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
public class MockDesignCenterImpl extends DesignCenterImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockDesignCenterImpl() {
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
  public void getSpace(GetSpaceRequest request, StreamObserver<Space> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Space) {
      requests.add(request);
      responseObserver.onNext(((Space) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetSpace, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Space.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listSpaces(
      ListSpacesRequest request, StreamObserver<ListSpacesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListSpacesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListSpacesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListSpaces, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListSpacesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createSpace(CreateSpaceRequest request, StreamObserver<Space> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Space) {
      requests.add(request);
      responseObserver.onNext(((Space) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateSpace, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Space.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateSpace(UpdateSpaceRequest request, StreamObserver<Space> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Space) {
      requests.add(request);
      responseObserver.onNext(((Space) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateSpace, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Space.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteSpace(DeleteSpaceRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteSpace, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getApplicationTemplate(
      GetApplicationTemplateRequest request, StreamObserver<ApplicationTemplate> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ApplicationTemplate) {
      requests.add(request);
      responseObserver.onNext(((ApplicationTemplate) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetApplicationTemplate, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  ApplicationTemplate.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listApplicationTemplates(
      ListApplicationTemplatesRequest request,
      StreamObserver<ListApplicationTemplatesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListApplicationTemplatesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListApplicationTemplatesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListApplicationTemplates, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListApplicationTemplatesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createApplicationTemplate(
      CreateApplicationTemplateRequest request,
      StreamObserver<ApplicationTemplate> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ApplicationTemplate) {
      requests.add(request);
      responseObserver.onNext(((ApplicationTemplate) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateApplicationTemplate, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ApplicationTemplate.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateApplicationTemplate(
      UpdateApplicationTemplateRequest request,
      StreamObserver<ApplicationTemplate> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ApplicationTemplate) {
      requests.add(request);
      responseObserver.onNext(((ApplicationTemplate) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateApplicationTemplate, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ApplicationTemplate.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void importApplicationTemplate(
      ImportApplicationTemplateRequest request,
      StreamObserver<ApplicationTemplate> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ApplicationTemplate) {
      requests.add(request);
      responseObserver.onNext(((ApplicationTemplate) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ImportApplicationTemplate, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ApplicationTemplate.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteApplicationTemplate(
      DeleteApplicationTemplateRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteApplicationTemplate, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void commitApplicationTemplate(
      CommitApplicationTemplateRequest request,
      StreamObserver<ApplicationTemplateRevision> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ApplicationTemplateRevision) {
      requests.add(request);
      responseObserver.onNext(((ApplicationTemplateRevision) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CommitApplicationTemplate, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ApplicationTemplateRevision.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void snapshotApplicationTemplate(
      SnapshotApplicationTemplateRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method SnapshotApplicationTemplate, expected"
                      + " %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void generateApplicationTemplateIaC(
      GenerateApplicationTemplateIaCRequest request,
      StreamObserver<GenerateApplicationTemplateIaCResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof GenerateApplicationTemplateIaCResponse) {
      requests.add(request);
      responseObserver.onNext(((GenerateApplicationTemplateIaCResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GenerateApplicationTemplateIaC,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  GenerateApplicationTemplateIaCResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void exportApplicationTemplateIaC(
      ExportApplicationTemplateIaCRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method ExportApplicationTemplateIaC, expected"
                      + " %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void generateApplicationTemplateRevisionIaC(
      GenerateApplicationTemplateRevisionIaCRequest request,
      StreamObserver<GenerateApplicationTemplateRevisionIaCResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof GenerateApplicationTemplateRevisionIaCResponse) {
      requests.add(request);
      responseObserver.onNext(((GenerateApplicationTemplateRevisionIaCResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GenerateApplicationTemplateRevisionIaC,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  GenerateApplicationTemplateRevisionIaCResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void exportApplicationTemplateRevisionIaC(
      ExportApplicationTemplateRevisionIaCRequest request,
      StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method ExportApplicationTemplateRevisionIaC,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getComponent(
      GetComponentRequest request, StreamObserver<Component> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Component) {
      requests.add(request);
      responseObserver.onNext(((Component) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetComponent, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Component.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listComponents(
      ListComponentsRequest request, StreamObserver<ListComponentsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListComponentsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListComponentsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListComponents, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListComponentsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createComponent(
      CreateComponentRequest request, StreamObserver<Component> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Component) {
      requests.add(request);
      responseObserver.onNext(((Component) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateComponent, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Component.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateComponent(
      UpdateComponentRequest request, StreamObserver<Component> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Component) {
      requests.add(request);
      responseObserver.onNext(((Component) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateComponent, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Component.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteComponent(
      DeleteComponentRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteComponent, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getConnection(
      GetConnectionRequest request, StreamObserver<Connection> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Connection) {
      requests.add(request);
      responseObserver.onNext(((Connection) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetConnection, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Connection.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listConnections(
      ListConnectionsRequest request, StreamObserver<ListConnectionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListConnectionsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListConnectionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListConnections, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListConnectionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createConnection(
      CreateConnectionRequest request, StreamObserver<Connection> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Connection) {
      requests.add(request);
      responseObserver.onNext(((Connection) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateConnection, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Connection.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateConnection(
      UpdateConnectionRequest request, StreamObserver<Connection> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Connection) {
      requests.add(request);
      responseObserver.onNext(((Connection) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateConnection, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Connection.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteConnection(
      DeleteConnectionRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteConnection, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getApplicationTemplateRevision(
      GetApplicationTemplateRevisionRequest request,
      StreamObserver<ApplicationTemplateRevision> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ApplicationTemplateRevision) {
      requests.add(request);
      responseObserver.onNext(((ApplicationTemplateRevision) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetApplicationTemplateRevision,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ApplicationTemplateRevision.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listApplicationTemplateRevisions(
      ListApplicationTemplateRevisionsRequest request,
      StreamObserver<ListApplicationTemplateRevisionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListApplicationTemplateRevisionsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListApplicationTemplateRevisionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListApplicationTemplateRevisions,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListApplicationTemplateRevisionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteApplicationTemplateRevision(
      DeleteApplicationTemplateRevisionRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteApplicationTemplateRevision,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getCatalog(GetCatalogRequest request, StreamObserver<Catalog> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Catalog) {
      requests.add(request);
      responseObserver.onNext(((Catalog) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetCatalog, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Catalog.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listCatalogs(
      ListCatalogsRequest request, StreamObserver<ListCatalogsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListCatalogsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListCatalogsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListCatalogs, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListCatalogsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createCatalog(
      CreateCatalogRequest request, StreamObserver<Catalog> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Catalog) {
      requests.add(request);
      responseObserver.onNext(((Catalog) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateCatalog, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Catalog.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateCatalog(
      UpdateCatalogRequest request, StreamObserver<Catalog> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Catalog) {
      requests.add(request);
      responseObserver.onNext(((Catalog) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateCatalog, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Catalog.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteCatalog(
      DeleteCatalogRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteCatalog, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createCatalogTemplate(
      CreateCatalogTemplateRequest request, StreamObserver<CatalogTemplate> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CatalogTemplate) {
      requests.add(request);
      responseObserver.onNext(((CatalogTemplate) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateCatalogTemplate, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  CatalogTemplate.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getCatalogTemplate(
      GetCatalogTemplateRequest request, StreamObserver<CatalogTemplate> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CatalogTemplate) {
      requests.add(request);
      responseObserver.onNext(((CatalogTemplate) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetCatalogTemplate, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CatalogTemplate.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listCatalogTemplates(
      ListCatalogTemplatesRequest request,
      StreamObserver<ListCatalogTemplatesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListCatalogTemplatesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListCatalogTemplatesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListCatalogTemplates, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListCatalogTemplatesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateCatalogTemplate(
      UpdateCatalogTemplateRequest request, StreamObserver<CatalogTemplate> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CatalogTemplate) {
      requests.add(request);
      responseObserver.onNext(((CatalogTemplate) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateCatalogTemplate, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  CatalogTemplate.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteCatalogTemplate(
      DeleteCatalogTemplateRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteCatalogTemplate, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createShare(CreateShareRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateShare, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listShares(
      ListSharesRequest request, StreamObserver<ListSharesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListSharesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListSharesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListShares, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListSharesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getShare(GetShareRequest request, StreamObserver<Share> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Share) {
      requests.add(request);
      responseObserver.onNext(((Share) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetShare, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Share.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteShare(DeleteShareRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteShare, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void syncShare(SyncShareRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method SyncShare, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getSharedTemplate(
      GetSharedTemplateRequest request, StreamObserver<SharedTemplate> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SharedTemplate) {
      requests.add(request);
      responseObserver.onNext(((SharedTemplate) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetSharedTemplate, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SharedTemplate.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listSharedTemplates(
      ListSharedTemplatesRequest request,
      StreamObserver<ListSharedTemplatesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListSharedTemplatesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListSharedTemplatesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListSharedTemplates, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListSharedTemplatesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getSharedTemplateRevision(
      GetSharedTemplateRevisionRequest request,
      StreamObserver<SharedTemplateRevision> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SharedTemplateRevision) {
      requests.add(request);
      responseObserver.onNext(((SharedTemplateRevision) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetSharedTemplateRevision, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SharedTemplateRevision.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listSharedTemplateRevisions(
      ListSharedTemplateRevisionsRequest request,
      StreamObserver<ListSharedTemplateRevisionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListSharedTemplateRevisionsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListSharedTemplateRevisionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListSharedTemplateRevisions, expected"
                      + " %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListSharedTemplateRevisionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createCatalogTemplateRevision(
      CreateCatalogTemplateRevisionRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateCatalogTemplateRevision, expected"
                      + " %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getCatalogTemplateRevision(
      GetCatalogTemplateRevisionRequest request,
      StreamObserver<CatalogTemplateRevision> responseObserver) {
    Object response = responses.poll();
    if (response instanceof CatalogTemplateRevision) {
      requests.add(request);
      responseObserver.onNext(((CatalogTemplateRevision) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetCatalogTemplateRevision, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  CatalogTemplateRevision.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listCatalogTemplateRevisions(
      ListCatalogTemplateRevisionsRequest request,
      StreamObserver<ListCatalogTemplateRevisionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListCatalogTemplateRevisionsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListCatalogTemplateRevisionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListCatalogTemplateRevisions, expected"
                      + " %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListCatalogTemplateRevisionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteCatalogTemplateRevision(
      DeleteCatalogTemplateRevisionRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteCatalogTemplateRevision, expected"
                      + " %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createApplication(
      CreateApplicationRequest request, StreamObserver<Application> responseObserver) {
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
                  "Unrecognized response type %s for method CreateApplication, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Application.class.getName(),
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
  public void updateApplication(
      UpdateApplicationRequest request, StreamObserver<Application> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateApplication, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Application.class.getName(),
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

  @Override
  public void deployApplication(
      DeployApplicationRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeployApplication, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void previewApplication(
      PreviewApplicationRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method PreviewApplication, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void fetchApplicationAssessmentReport(
      FetchApplicationAssessmentReportRequest request,
      StreamObserver<FetchApplicationAssessmentReportResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FetchApplicationAssessmentReportResponse) {
      requests.add(request);
      responseObserver.onNext(((FetchApplicationAssessmentReportResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method FetchApplicationAssessmentReport,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FetchApplicationAssessmentReportResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void generateApplicationAssessmentReport(
      GenerateApplicationAssessmentReportRequest request,
      StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method GenerateApplicationAssessmentReport,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void generateApplicationTemplateAssessmentReport(
      GenerateApplicationTemplateAssessmentReportRequest request,
      StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method"
                      + " GenerateApplicationTemplateAssessmentReport, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void generateAssessmentReport(
      GenerateAssessmentReportRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method GenerateAssessmentReport, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void generateTerraformPlanAssessmentReport(
      GenerateTerraformPlanAssessmentReportRequest request,
      StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method GenerateTerraformPlanAssessmentReport,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getPolicy(GetPolicyRequest request, StreamObserver<Policy> responseObserver) {
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
                  "Unrecognized response type %s for method GetPolicy, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Policy.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listPolicies(
      ListPoliciesRequest request, StreamObserver<ListPoliciesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListPoliciesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListPoliciesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListPolicies, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListPoliciesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createPolicy(CreatePolicyRequest request, StreamObserver<Policy> responseObserver) {
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
                  "Unrecognized response type %s for method CreatePolicy, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Policy.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updatePolicy(UpdatePolicyRequest request, StreamObserver<Policy> responseObserver) {
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
                  "Unrecognized response type %s for method UpdatePolicy, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Policy.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deletePolicy(DeletePolicyRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeletePolicy, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void fetchFrameworks(
      FetchFrameworksRequest request, StreamObserver<FetchFrameworksResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof FetchFrameworksResponse) {
      requests.add(request);
      responseObserver.onNext(((FetchFrameworksResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method FetchFrameworks, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  FetchFrameworksResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void generateApplicationIaC(
      GenerateApplicationIaCRequest request,
      StreamObserver<GenerateApplicationIaCResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof GenerateApplicationIaCResponse) {
      requests.add(request);
      responseObserver.onNext(((GenerateApplicationIaCResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GenerateApplicationIaC, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  GenerateApplicationIaCResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void exportApplicationIaC(
      ExportApplicationIaCRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method ExportApplicationIaC, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void importApplicationTemplateIaC(
      ImportApplicationTemplateIaCRequest request,
      StreamObserver<ImportApplicationTemplateIaCResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ImportApplicationTemplateIaCResponse) {
      requests.add(request);
      responseObserver.onNext(((ImportApplicationTemplateIaCResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ImportApplicationTemplateIaC, expected"
                      + " %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ImportApplicationTemplateIaCResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void ingestApplicationTemplateIaC(
      IngestApplicationTemplateIaCRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method IngestApplicationTemplateIaC, expected"
                      + " %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void importApplicationIaC(
      ImportApplicationIaCRequest request,
      StreamObserver<ImportApplicationIaCResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ImportApplicationIaCResponse) {
      requests.add(request);
      responseObserver.onNext(((ImportApplicationIaCResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ImportApplicationIaC, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  ImportApplicationIaCResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void registerAppHubApplicationResources(
      RegisterAppHubApplicationResourcesRequest request,
      StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method RegisterAppHubApplicationResources,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listApplicationTemplateSystemRevisions(
      ListApplicationTemplateSystemRevisionsRequest request,
      StreamObserver<ListApplicationTemplateSystemRevisionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListApplicationTemplateSystemRevisionsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListApplicationTemplateSystemRevisionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListApplicationTemplateSystemRevisions,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListApplicationTemplateSystemRevisionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getApplicationTemplateSystemRevision(
      GetApplicationTemplateSystemRevisionRequest request,
      StreamObserver<ApplicationTemplateSystemRevision> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ApplicationTemplateSystemRevision) {
      requests.add(request);
      responseObserver.onNext(((ApplicationTemplateSystemRevision) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetApplicationTemplateSystemRevision,"
                      + " expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ApplicationTemplateSystemRevision.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void recommendIAMRoles(
      RecommendIAMRolesRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method RecommendIAMRoles, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }
}
