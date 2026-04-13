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

package com.google.cloud.chronicle.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.chronicle.v1.DataTableServiceGrpc.DataTableServiceImplBase;
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
public class MockDataTableServiceImpl extends DataTableServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockDataTableServiceImpl() {
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
  public void createDataTable(
      CreateDataTableRequest request, StreamObserver<DataTable> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DataTable) {
      requests.add(request);
      responseObserver.onNext(((DataTable) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateDataTable, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DataTable.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listDataTables(
      ListDataTablesRequest request, StreamObserver<ListDataTablesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListDataTablesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListDataTablesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListDataTables, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListDataTablesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getDataTable(
      GetDataTableRequest request, StreamObserver<DataTable> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DataTable) {
      requests.add(request);
      responseObserver.onNext(((DataTable) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetDataTable, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DataTable.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateDataTable(
      UpdateDataTableRequest request, StreamObserver<DataTable> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DataTable) {
      requests.add(request);
      responseObserver.onNext(((DataTable) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateDataTable, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DataTable.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteDataTable(
      DeleteDataTableRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteDataTable, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createDataTableRow(
      CreateDataTableRowRequest request, StreamObserver<DataTableRow> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DataTableRow) {
      requests.add(request);
      responseObserver.onNext(((DataTableRow) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateDataTableRow, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DataTableRow.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateDataTableRow(
      UpdateDataTableRowRequest request, StreamObserver<DataTableRow> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DataTableRow) {
      requests.add(request);
      responseObserver.onNext(((DataTableRow) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateDataTableRow, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DataTableRow.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listDataTableRows(
      ListDataTableRowsRequest request,
      StreamObserver<ListDataTableRowsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListDataTableRowsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListDataTableRowsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListDataTableRows, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListDataTableRowsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getDataTableRow(
      GetDataTableRowRequest request, StreamObserver<DataTableRow> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DataTableRow) {
      requests.add(request);
      responseObserver.onNext(((DataTableRow) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetDataTableRow, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DataTableRow.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteDataTableRow(
      DeleteDataTableRowRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteDataTableRow, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void bulkCreateDataTableRows(
      BulkCreateDataTableRowsRequest request,
      StreamObserver<BulkCreateDataTableRowsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof BulkCreateDataTableRowsResponse) {
      requests.add(request);
      responseObserver.onNext(((BulkCreateDataTableRowsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method BulkCreateDataTableRows, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  BulkCreateDataTableRowsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void bulkGetDataTableRows(
      BulkGetDataTableRowsRequest request,
      StreamObserver<BulkGetDataTableRowsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof BulkGetDataTableRowsResponse) {
      requests.add(request);
      responseObserver.onNext(((BulkGetDataTableRowsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method BulkGetDataTableRows, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  BulkGetDataTableRowsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void bulkReplaceDataTableRows(
      BulkReplaceDataTableRowsRequest request,
      StreamObserver<BulkReplaceDataTableRowsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof BulkReplaceDataTableRowsResponse) {
      requests.add(request);
      responseObserver.onNext(((BulkReplaceDataTableRowsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method BulkReplaceDataTableRows, expected %s"
                      + " or %s",
                  response == null ? "null" : response.getClass().getName(),
                  BulkReplaceDataTableRowsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void bulkUpdateDataTableRows(
      BulkUpdateDataTableRowsRequest request,
      StreamObserver<BulkUpdateDataTableRowsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof BulkUpdateDataTableRowsResponse) {
      requests.add(request);
      responseObserver.onNext(((BulkUpdateDataTableRowsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method BulkUpdateDataTableRows, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  BulkUpdateDataTableRowsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getDataTableOperationErrors(
      GetDataTableOperationErrorsRequest request,
      StreamObserver<DataTableOperationErrors> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DataTableOperationErrors) {
      requests.add(request);
      responseObserver.onNext(((DataTableOperationErrors) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetDataTableOperationErrors, expected"
                      + " %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DataTableOperationErrors.class.getName(),
                  Exception.class.getName())));
    }
  }
}
