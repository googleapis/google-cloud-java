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

package com.google.cloud.biglake.hive.v1beta;

import com.google.api.core.BetaApi;
import com.google.cloud.biglake.hive.v1beta.HiveMetastoreServiceGrpc.HiveMetastoreServiceImplBase;
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
public class MockHiveMetastoreServiceImpl extends HiveMetastoreServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockHiveMetastoreServiceImpl() {
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
  public void createHiveCatalog(
      CreateHiveCatalogRequest request, StreamObserver<HiveCatalog> responseObserver) {
    Object response = responses.poll();
    if (response instanceof HiveCatalog) {
      requests.add(request);
      responseObserver.onNext(((HiveCatalog) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateHiveCatalog, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  HiveCatalog.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getHiveCatalog(
      GetHiveCatalogRequest request, StreamObserver<HiveCatalog> responseObserver) {
    Object response = responses.poll();
    if (response instanceof HiveCatalog) {
      requests.add(request);
      responseObserver.onNext(((HiveCatalog) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetHiveCatalog, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  HiveCatalog.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listHiveCatalogs(
      ListHiveCatalogsRequest request, StreamObserver<ListHiveCatalogsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListHiveCatalogsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListHiveCatalogsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListHiveCatalogs, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListHiveCatalogsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateHiveCatalog(
      UpdateHiveCatalogRequest request, StreamObserver<HiveCatalog> responseObserver) {
    Object response = responses.poll();
    if (response instanceof HiveCatalog) {
      requests.add(request);
      responseObserver.onNext(((HiveCatalog) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateHiveCatalog, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  HiveCatalog.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteHiveCatalog(
      DeleteHiveCatalogRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteHiveCatalog, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createHiveDatabase(
      CreateHiveDatabaseRequest request, StreamObserver<HiveDatabase> responseObserver) {
    Object response = responses.poll();
    if (response instanceof HiveDatabase) {
      requests.add(request);
      responseObserver.onNext(((HiveDatabase) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateHiveDatabase, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  HiveDatabase.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getHiveDatabase(
      GetHiveDatabaseRequest request, StreamObserver<HiveDatabase> responseObserver) {
    Object response = responses.poll();
    if (response instanceof HiveDatabase) {
      requests.add(request);
      responseObserver.onNext(((HiveDatabase) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetHiveDatabase, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  HiveDatabase.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listHiveDatabases(
      ListHiveDatabasesRequest request,
      StreamObserver<ListHiveDatabasesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListHiveDatabasesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListHiveDatabasesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListHiveDatabases, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListHiveDatabasesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateHiveDatabase(
      UpdateHiveDatabaseRequest request, StreamObserver<HiveDatabase> responseObserver) {
    Object response = responses.poll();
    if (response instanceof HiveDatabase) {
      requests.add(request);
      responseObserver.onNext(((HiveDatabase) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateHiveDatabase, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  HiveDatabase.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteHiveDatabase(
      DeleteHiveDatabaseRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteHiveDatabase, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createHiveTable(
      CreateHiveTableRequest request, StreamObserver<HiveTable> responseObserver) {
    Object response = responses.poll();
    if (response instanceof HiveTable) {
      requests.add(request);
      responseObserver.onNext(((HiveTable) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateHiveTable, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  HiveTable.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getHiveTable(
      GetHiveTableRequest request, StreamObserver<HiveTable> responseObserver) {
    Object response = responses.poll();
    if (response instanceof HiveTable) {
      requests.add(request);
      responseObserver.onNext(((HiveTable) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetHiveTable, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  HiveTable.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listHiveTables(
      ListHiveTablesRequest request, StreamObserver<ListHiveTablesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListHiveTablesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListHiveTablesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListHiveTables, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListHiveTablesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateHiveTable(
      UpdateHiveTableRequest request, StreamObserver<HiveTable> responseObserver) {
    Object response = responses.poll();
    if (response instanceof HiveTable) {
      requests.add(request);
      responseObserver.onNext(((HiveTable) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateHiveTable, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  HiveTable.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteHiveTable(
      DeleteHiveTableRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteHiveTable, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void batchCreatePartitions(
      BatchCreatePartitionsRequest request,
      StreamObserver<BatchCreatePartitionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof BatchCreatePartitionsResponse) {
      requests.add(request);
      responseObserver.onNext(((BatchCreatePartitionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method BatchCreatePartitions, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  BatchCreatePartitionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void batchDeletePartitions(
      BatchDeletePartitionsRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method BatchDeletePartitions, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void batchUpdatePartitions(
      BatchUpdatePartitionsRequest request,
      StreamObserver<BatchUpdatePartitionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof BatchUpdatePartitionsResponse) {
      requests.add(request);
      responseObserver.onNext(((BatchUpdatePartitionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method BatchUpdatePartitions, expected %s or"
                      + " %s",
                  response == null ? "null" : response.getClass().getName(),
                  BatchUpdatePartitionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listPartitions(
      ListPartitionsRequest request, StreamObserver<ListPartitionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListPartitionsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListPartitionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListPartitions, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListPartitionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
