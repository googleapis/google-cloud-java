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

package com.google.area120.tables.v1alpha;

import com.google.api.core.BetaApi;
import com.google.area120.tables.v1alpha1.BatchCreateRowsRequest;
import com.google.area120.tables.v1alpha1.BatchCreateRowsResponse;
import com.google.area120.tables.v1alpha1.BatchDeleteRowsRequest;
import com.google.area120.tables.v1alpha1.BatchUpdateRowsRequest;
import com.google.area120.tables.v1alpha1.BatchUpdateRowsResponse;
import com.google.area120.tables.v1alpha1.CreateRowRequest;
import com.google.area120.tables.v1alpha1.DeleteRowRequest;
import com.google.area120.tables.v1alpha1.GetRowRequest;
import com.google.area120.tables.v1alpha1.GetTableRequest;
import com.google.area120.tables.v1alpha1.GetWorkspaceRequest;
import com.google.area120.tables.v1alpha1.ListRowsRequest;
import com.google.area120.tables.v1alpha1.ListRowsResponse;
import com.google.area120.tables.v1alpha1.ListTablesRequest;
import com.google.area120.tables.v1alpha1.ListTablesResponse;
import com.google.area120.tables.v1alpha1.ListWorkspacesRequest;
import com.google.area120.tables.v1alpha1.ListWorkspacesResponse;
import com.google.area120.tables.v1alpha1.Row;
import com.google.area120.tables.v1alpha1.Table;
import com.google.area120.tables.v1alpha1.TablesServiceGrpc.TablesServiceImplBase;
import com.google.area120.tables.v1alpha1.UpdateRowRequest;
import com.google.area120.tables.v1alpha1.Workspace;
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
public class MockTablesServiceImpl extends TablesServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockTablesServiceImpl() {
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
  public void getTable(GetTableRequest request, StreamObserver<Table> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Table) {
      requests.add(request);
      responseObserver.onNext(((Table) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetTable, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Table.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listTables(
      ListTablesRequest request, StreamObserver<ListTablesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListTablesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListTablesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListTables, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListTablesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getWorkspace(
      GetWorkspaceRequest request, StreamObserver<Workspace> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Workspace) {
      requests.add(request);
      responseObserver.onNext(((Workspace) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetWorkspace, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Workspace.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listWorkspaces(
      ListWorkspacesRequest request, StreamObserver<ListWorkspacesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListWorkspacesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListWorkspacesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListWorkspaces, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListWorkspacesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getRow(GetRowRequest request, StreamObserver<Row> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Row) {
      requests.add(request);
      responseObserver.onNext(((Row) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetRow, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Row.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listRows(ListRowsRequest request, StreamObserver<ListRowsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListRowsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListRowsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListRows, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListRowsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createRow(CreateRowRequest request, StreamObserver<Row> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Row) {
      requests.add(request);
      responseObserver.onNext(((Row) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateRow, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Row.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void batchCreateRows(
      BatchCreateRowsRequest request, StreamObserver<BatchCreateRowsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof BatchCreateRowsResponse) {
      requests.add(request);
      responseObserver.onNext(((BatchCreateRowsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method BatchCreateRows, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  BatchCreateRowsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateRow(UpdateRowRequest request, StreamObserver<Row> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Row) {
      requests.add(request);
      responseObserver.onNext(((Row) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateRow, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Row.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void batchUpdateRows(
      BatchUpdateRowsRequest request, StreamObserver<BatchUpdateRowsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof BatchUpdateRowsResponse) {
      requests.add(request);
      responseObserver.onNext(((BatchUpdateRowsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method BatchUpdateRows, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  BatchUpdateRowsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteRow(DeleteRowRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteRow, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void batchDeleteRows(
      BatchDeleteRowsRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method BatchDeleteRows, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }
}
