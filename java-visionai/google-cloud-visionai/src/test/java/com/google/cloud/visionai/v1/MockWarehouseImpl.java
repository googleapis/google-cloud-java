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

package com.google.cloud.visionai.v1;

import com.google.api.core.BetaApi;
import com.google.cloud.visionai.v1.WarehouseGrpc.WarehouseImplBase;
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
public class MockWarehouseImpl extends WarehouseImplBase {
  private List<AbstractMessage> requests;
  private Queue<Object> responses;

  public MockWarehouseImpl() {
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
  public void createAsset(CreateAssetRequest request, StreamObserver<Asset> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Asset) {
      requests.add(request);
      responseObserver.onNext(((Asset) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateAsset, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Asset.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateAsset(UpdateAssetRequest request, StreamObserver<Asset> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Asset) {
      requests.add(request);
      responseObserver.onNext(((Asset) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateAsset, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Asset.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getAsset(GetAssetRequest request, StreamObserver<Asset> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Asset) {
      requests.add(request);
      responseObserver.onNext(((Asset) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetAsset, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Asset.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listAssets(
      ListAssetsRequest request, StreamObserver<ListAssetsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListAssetsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAssetsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListAssets, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListAssetsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteAsset(DeleteAssetRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteAsset, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void uploadAsset(UploadAssetRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UploadAsset, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void generateRetrievalUrl(
      GenerateRetrievalUrlRequest request,
      StreamObserver<GenerateRetrievalUrlResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof GenerateRetrievalUrlResponse) {
      requests.add(request);
      responseObserver.onNext(((GenerateRetrievalUrlResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GenerateRetrievalUrl, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  GenerateRetrievalUrlResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void analyzeAsset(
      AnalyzeAssetRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method AnalyzeAsset, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void indexAsset(IndexAssetRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method IndexAsset, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void removeIndexAsset(
      RemoveIndexAssetRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method RemoveIndexAsset, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void viewIndexedAssets(
      ViewIndexedAssetsRequest request,
      StreamObserver<ViewIndexedAssetsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ViewIndexedAssetsResponse) {
      requests.add(request);
      responseObserver.onNext(((ViewIndexedAssetsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ViewIndexedAssets, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ViewIndexedAssetsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createIndex(CreateIndexRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateIndex, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateIndex(UpdateIndexRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateIndex, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getIndex(GetIndexRequest request, StreamObserver<Index> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Index) {
      requests.add(request);
      responseObserver.onNext(((Index) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetIndex, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Index.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listIndexes(
      ListIndexesRequest request, StreamObserver<ListIndexesResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListIndexesResponse) {
      requests.add(request);
      responseObserver.onNext(((ListIndexesResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListIndexes, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListIndexesResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteIndex(DeleteIndexRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteIndex, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createCorpus(
      CreateCorpusRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateCorpus, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getCorpus(GetCorpusRequest request, StreamObserver<Corpus> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Corpus) {
      requests.add(request);
      responseObserver.onNext(((Corpus) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetCorpus, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Corpus.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateCorpus(UpdateCorpusRequest request, StreamObserver<Corpus> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Corpus) {
      requests.add(request);
      responseObserver.onNext(((Corpus) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateCorpus, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Corpus.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listCorpora(
      ListCorporaRequest request, StreamObserver<ListCorporaResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListCorporaResponse) {
      requests.add(request);
      responseObserver.onNext(((ListCorporaResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListCorpora, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListCorporaResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteCorpus(DeleteCorpusRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteCorpus, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void analyzeCorpus(
      AnalyzeCorpusRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method AnalyzeCorpus, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createDataSchema(
      CreateDataSchemaRequest request, StreamObserver<DataSchema> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DataSchema) {
      requests.add(request);
      responseObserver.onNext(((DataSchema) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateDataSchema, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DataSchema.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateDataSchema(
      UpdateDataSchemaRequest request, StreamObserver<DataSchema> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DataSchema) {
      requests.add(request);
      responseObserver.onNext(((DataSchema) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateDataSchema, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DataSchema.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getDataSchema(
      GetDataSchemaRequest request, StreamObserver<DataSchema> responseObserver) {
    Object response = responses.poll();
    if (response instanceof DataSchema) {
      requests.add(request);
      responseObserver.onNext(((DataSchema) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetDataSchema, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  DataSchema.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteDataSchema(
      DeleteDataSchemaRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteDataSchema, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listDataSchemas(
      ListDataSchemasRequest request, StreamObserver<ListDataSchemasResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListDataSchemasResponse) {
      requests.add(request);
      responseObserver.onNext(((ListDataSchemasResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListDataSchemas, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListDataSchemasResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createAnnotation(
      CreateAnnotationRequest request, StreamObserver<Annotation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Annotation) {
      requests.add(request);
      responseObserver.onNext(((Annotation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateAnnotation, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Annotation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getAnnotation(
      GetAnnotationRequest request, StreamObserver<Annotation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Annotation) {
      requests.add(request);
      responseObserver.onNext(((Annotation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetAnnotation, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Annotation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listAnnotations(
      ListAnnotationsRequest request, StreamObserver<ListAnnotationsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListAnnotationsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListAnnotationsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListAnnotations, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListAnnotationsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateAnnotation(
      UpdateAnnotationRequest request, StreamObserver<Annotation> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Annotation) {
      requests.add(request);
      responseObserver.onNext(((Annotation) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateAnnotation, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Annotation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteAnnotation(
      DeleteAnnotationRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteAnnotation, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public StreamObserver<IngestAssetRequest> ingestAsset(
      final StreamObserver<IngestAssetResponse> responseObserver) {
    StreamObserver<IngestAssetRequest> requestObserver =
        new StreamObserver<IngestAssetRequest>() {
          @Override
          public void onNext(IngestAssetRequest value) {
            requests.add(value);
            final Object response = responses.remove();
            if (response instanceof IngestAssetResponse) {
              responseObserver.onNext(((IngestAssetResponse) response));
            } else if (response instanceof Exception) {
              responseObserver.onError(((Exception) response));
            } else {
              responseObserver.onError(
                  new IllegalArgumentException(
                      String.format(
                          "Unrecognized response type %s for method IngestAsset, expected %s or %s",
                          response == null ? "null" : response.getClass().getName(),
                          IngestAssetResponse.class.getName(),
                          Exception.class.getName())));
            }
          }

          @Override
          public void onError(Throwable t) {
            responseObserver.onError(t);
          }

          @Override
          public void onCompleted() {
            responseObserver.onCompleted();
          }
        };
    return requestObserver;
  }

  @Override
  public void clipAsset(
      ClipAssetRequest request, StreamObserver<ClipAssetResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ClipAssetResponse) {
      requests.add(request);
      responseObserver.onNext(((ClipAssetResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ClipAsset, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ClipAssetResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void generateHlsUri(
      GenerateHlsUriRequest request, StreamObserver<GenerateHlsUriResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof GenerateHlsUriResponse) {
      requests.add(request);
      responseObserver.onNext(((GenerateHlsUriResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GenerateHlsUri, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  GenerateHlsUriResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void importAssets(
      ImportAssetsRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method ImportAssets, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createSearchConfig(
      CreateSearchConfigRequest request, StreamObserver<SearchConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SearchConfig) {
      requests.add(request);
      responseObserver.onNext(((SearchConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateSearchConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SearchConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateSearchConfig(
      UpdateSearchConfigRequest request, StreamObserver<SearchConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SearchConfig) {
      requests.add(request);
      responseObserver.onNext(((SearchConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateSearchConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SearchConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getSearchConfig(
      GetSearchConfigRequest request, StreamObserver<SearchConfig> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SearchConfig) {
      requests.add(request);
      responseObserver.onNext(((SearchConfig) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetSearchConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SearchConfig.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteSearchConfig(
      DeleteSearchConfigRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteSearchConfig, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listSearchConfigs(
      ListSearchConfigsRequest request,
      StreamObserver<ListSearchConfigsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListSearchConfigsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListSearchConfigsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListSearchConfigs, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListSearchConfigsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createSearchHypernym(
      CreateSearchHypernymRequest request, StreamObserver<SearchHypernym> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SearchHypernym) {
      requests.add(request);
      responseObserver.onNext(((SearchHypernym) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method CreateSearchHypernym, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SearchHypernym.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateSearchHypernym(
      UpdateSearchHypernymRequest request, StreamObserver<SearchHypernym> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SearchHypernym) {
      requests.add(request);
      responseObserver.onNext(((SearchHypernym) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateSearchHypernym, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SearchHypernym.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getSearchHypernym(
      GetSearchHypernymRequest request, StreamObserver<SearchHypernym> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SearchHypernym) {
      requests.add(request);
      responseObserver.onNext(((SearchHypernym) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetSearchHypernym, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SearchHypernym.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteSearchHypernym(
      DeleteSearchHypernymRequest request, StreamObserver<Empty> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteSearchHypernym, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Empty.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listSearchHypernyms(
      ListSearchHypernymsRequest request,
      StreamObserver<ListSearchHypernymsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListSearchHypernymsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListSearchHypernymsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListSearchHypernyms, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListSearchHypernymsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void searchAssets(
      SearchAssetsRequest request, StreamObserver<SearchAssetsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SearchAssetsResponse) {
      requests.add(request);
      responseObserver.onNext(((SearchAssetsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SearchAssets, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SearchAssetsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void searchIndexEndpoint(
      SearchIndexEndpointRequest request,
      StreamObserver<SearchIndexEndpointResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof SearchIndexEndpointResponse) {
      requests.add(request);
      responseObserver.onNext(((SearchIndexEndpointResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method SearchIndexEndpoint, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  SearchIndexEndpointResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createIndexEndpoint(
      CreateIndexEndpointRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateIndexEndpoint, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getIndexEndpoint(
      GetIndexEndpointRequest request, StreamObserver<IndexEndpoint> responseObserver) {
    Object response = responses.poll();
    if (response instanceof IndexEndpoint) {
      requests.add(request);
      responseObserver.onNext(((IndexEndpoint) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetIndexEndpoint, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  IndexEndpoint.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listIndexEndpoints(
      ListIndexEndpointsRequest request,
      StreamObserver<ListIndexEndpointsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListIndexEndpointsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListIndexEndpointsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListIndexEndpoints, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListIndexEndpointsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateIndexEndpoint(
      UpdateIndexEndpointRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UpdateIndexEndpoint, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteIndexEndpoint(
      DeleteIndexEndpointRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteIndexEndpoint, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deployIndex(DeployIndexRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeployIndex, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void undeployIndex(
      UndeployIndexRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method UndeployIndex, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void createCollection(
      CreateCollectionRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method CreateCollection, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void deleteCollection(
      DeleteCollectionRequest request, StreamObserver<Operation> responseObserver) {
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
                  "Unrecognized response type %s for method DeleteCollection, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Operation.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void getCollection(
      GetCollectionRequest request, StreamObserver<Collection> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Collection) {
      requests.add(request);
      responseObserver.onNext(((Collection) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method GetCollection, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Collection.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void updateCollection(
      UpdateCollectionRequest request, StreamObserver<Collection> responseObserver) {
    Object response = responses.poll();
    if (response instanceof Collection) {
      requests.add(request);
      responseObserver.onNext(((Collection) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method UpdateCollection, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  Collection.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void listCollections(
      ListCollectionsRequest request, StreamObserver<ListCollectionsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ListCollectionsResponse) {
      requests.add(request);
      responseObserver.onNext(((ListCollectionsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ListCollections, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ListCollectionsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void addCollectionItem(
      AddCollectionItemRequest request,
      StreamObserver<AddCollectionItemResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof AddCollectionItemResponse) {
      requests.add(request);
      responseObserver.onNext(((AddCollectionItemResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method AddCollectionItem, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  AddCollectionItemResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void removeCollectionItem(
      RemoveCollectionItemRequest request,
      StreamObserver<RemoveCollectionItemResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof RemoveCollectionItemResponse) {
      requests.add(request);
      responseObserver.onNext(((RemoveCollectionItemResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method RemoveCollectionItem, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  RemoveCollectionItemResponse.class.getName(),
                  Exception.class.getName())));
    }
  }

  @Override
  public void viewCollectionItems(
      ViewCollectionItemsRequest request,
      StreamObserver<ViewCollectionItemsResponse> responseObserver) {
    Object response = responses.poll();
    if (response instanceof ViewCollectionItemsResponse) {
      requests.add(request);
      responseObserver.onNext(((ViewCollectionItemsResponse) response));
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError(((Exception) response));
    } else {
      responseObserver.onError(
          new IllegalArgumentException(
              String.format(
                  "Unrecognized response type %s for method ViewCollectionItems, expected %s or %s",
                  response == null ? "null" : response.getClass().getName(),
                  ViewCollectionItemsResponse.class.getName(),
                  Exception.class.getName())));
    }
  }
}
