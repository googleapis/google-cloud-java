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

package com.google.cloud.dataplex.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.dataplex.v1.CatalogServiceGrpc.CatalogServiceImplBase;
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
public class MockCatalogServiceImpl extends CatalogServiceImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockCatalogServiceImpl() {
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
  public void createEntryType(
      CreateEntryTypeRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateEntryType, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateEntryType(
      UpdateEntryTypeRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateEntryType, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteEntryType(
      DeleteEntryTypeRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteEntryType, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listEntryTypes(
      ListEntryTypesRequest request, StreamObserver<ListEntryTypesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListEntryTypesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListEntryTypesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListEntryTypes, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListEntryTypesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getEntryType(
      GetEntryTypeRequest request, StreamObserver<EntryType> responseObserver) {
    Object response = responses.poll();
    if (response instanceof EntryType) {
      requests.add(request);
      responseObserver.onNext(((EntryType) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetEntryType, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  EntryType.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createAspectType(
      CreateAspectTypeRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateAspectType, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateAspectType(
      UpdateAspectTypeRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateAspectType, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteAspectType(
      DeleteAspectTypeRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteAspectType, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listAspectTypes(
      ListAspectTypesRequest request, StreamObserver<ListAspectTypesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListAspectTypesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAspectTypesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListAspectTypes, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListAspectTypesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getAspectType(
      GetAspectTypeRequest request, StreamObserver<AspectType> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AspectType) {
      requests.add(request);
      responseObserver.onNext(((AspectType) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetAspectType, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AspectType.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createEntryGroup(
      CreateEntryGroupRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateEntryGroup, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateEntryGroup(
      UpdateEntryGroupRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateEntryGroup, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteEntryGroup(
      DeleteEntryGroupRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteEntryGroup, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listEntryGroups(
      ListEntryGroupsRequest request, StreamObserver<ListEntryGroupsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListEntryGroupsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListEntryGroupsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListEntryGroups, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListEntryGroupsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getEntryGroup(
      GetEntryGroupRequest request, StreamObserver<EntryGroup> responseObserver) {
    Object response = responses.poll();
    if (response instanceof EntryGroup) {
      requests.add(request);
      responseObserver.onNext(((EntryGroup) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetEntryGroup, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  EntryGroup.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createEntry(CreateEntryRequest request, StreamObserver<Entry> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Entry) {
      requests.add(request);
      responseObserver.onNext(((Entry) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateEntry, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Entry.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateEntry(UpdateEntryRequest request, StreamObserver<Entry> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Entry) {
      requests.add(request);
      responseObserver.onNext(((Entry) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateEntry, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Entry.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteEntry(DeleteEntryRequest request, StreamObserver<Entry> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Entry) {
      requests.add(request);
      responseObserver.onNext(((Entry) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method DeleteEntry, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Entry.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listEntries(
      ListEntriesRequest request, StreamObserver<ListEntriesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListEntriesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListEntriesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListEntries, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListEntriesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getEntry(GetEntryRequest request, StreamObserver<Entry> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Entry) {
      requests.add(request);
      responseObserver.onNext(((Entry) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetEntry, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Entry.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void lookupEntry(LookupEntryRequest request, StreamObserver<Entry> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Entry) {
      requests.add(request);
      responseObserver.onNext(((Entry) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method LookupEntry, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Entry.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void searchEntries(
      SearchEntriesRequest request, StreamObserver<SearchEntriesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SearchEntriesResponse) {
      requests.add(request);
      responseObserver.onNext(((SearchEntriesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SearchEntries, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SearchEntriesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
