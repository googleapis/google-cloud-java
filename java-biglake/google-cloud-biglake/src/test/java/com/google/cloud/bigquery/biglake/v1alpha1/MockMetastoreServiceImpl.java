/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.bigquery.biglake.v1alpha1;

import com.google.api.core.BetaApi;
import com.google.cloud.bigquery.biglake.v1alpha1.MetastoreServiceGrpc.MetastoreServiceImplBase;
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
public class MockMetastoreServiceImpl extends MetastoreServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockMetastoreServiceImpl() {
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
  public void deleteCatalog(
      DeleteCatalogRequest request, StreamObserver<Catalog> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteCatalog, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Catalog.class.getName(),
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
  public void createDatabase(
      CreateDatabaseRequest request, StreamObserver<Database> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Database) {
      requests.add(request);
      responseObserver.onNext(((Database) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateDatabase, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Database.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteDatabase(
      DeleteDatabaseRequest request, StreamObserver<Database> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Database) {
      requests.add(request);
      responseObserver.onNext(((Database) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteDatabase, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Database.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateDatabase(
      UpdateDatabaseRequest request, StreamObserver<Database> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Database) {
      requests.add(request);
      responseObserver.onNext(((Database) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateDatabase, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Database.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getDatabase(GetDatabaseRequest request, StreamObserver<Database> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Database) {
      requests.add(request);
      responseObserver.onNext(((Database) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetDatabase, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Database.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listDatabases(
      ListDatabasesRequest request, StreamObserver<ListDatabasesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListDatabasesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListDatabasesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListDatabases, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListDatabasesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createTable(CreateTableRequest request, StreamObserver<Table> responseObserver) {
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
                  "Unrecognized response type %s for method CreateTable, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Table.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteTable(DeleteTableRequest request, StreamObserver<Table> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteTable, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Table.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateTable(UpdateTableRequest request, StreamObserver<Table> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateTable, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Table.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void renameTable(RenameTableRequest request, StreamObserver<Table> responseObserver) {
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
                  "Unrecognized response type %s for method RenameTable, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Table.class.getName(),
                  Exception.class.getName())));
    }
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
  public void createLock(CreateLockRequest request, StreamObserver<Lock> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Lock) {
      requests.add(request);
      responseObserver.onNext(((Lock) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateLock, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Lock.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteLock(DeleteLockRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteLock, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void checkLock(CheckLockRequest request, StreamObserver<Lock> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Lock) {
      requests.add(request);
      responseObserver.onNext(((Lock) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CheckLock, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Lock.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listLocks(
      ListLocksRequest request, StreamObserver<ListLocksResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListLocksResponse) {
      requests.add(request);
      responseObserver.onNext(((ListLocksResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListLocks, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListLocksResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
