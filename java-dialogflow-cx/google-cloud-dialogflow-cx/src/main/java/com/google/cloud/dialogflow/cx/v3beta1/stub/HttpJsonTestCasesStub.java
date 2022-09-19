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

package com.google.cloud.dialogflow.cx.v3beta1.stub;

import static com.google.cloud.dialogflow.cx.v3beta1.TestCasesClient.ListLocationsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3beta1.TestCasesClient.ListTestCaseResultsPagedResponse;
import static com.google.cloud.dialogflow.cx.v3beta1.TestCasesClient.ListTestCasesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonOperationSnapshot;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.httpjson.longrunning.stub.HttpJsonOperationsStub;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.cx.v3beta1.BatchDeleteTestCasesRequest;
import com.google.cloud.dialogflow.cx.v3beta1.BatchRunTestCasesMetadata;
import com.google.cloud.dialogflow.cx.v3beta1.BatchRunTestCasesRequest;
import com.google.cloud.dialogflow.cx.v3beta1.BatchRunTestCasesResponse;
import com.google.cloud.dialogflow.cx.v3beta1.CalculateCoverageRequest;
import com.google.cloud.dialogflow.cx.v3beta1.CalculateCoverageResponse;
import com.google.cloud.dialogflow.cx.v3beta1.CreateTestCaseRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ExportTestCasesMetadata;
import com.google.cloud.dialogflow.cx.v3beta1.ExportTestCasesRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ExportTestCasesResponse;
import com.google.cloud.dialogflow.cx.v3beta1.GetTestCaseRequest;
import com.google.cloud.dialogflow.cx.v3beta1.GetTestCaseResultRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ImportTestCasesMetadata;
import com.google.cloud.dialogflow.cx.v3beta1.ImportTestCasesRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ImportTestCasesResponse;
import com.google.cloud.dialogflow.cx.v3beta1.ListTestCaseResultsRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListTestCaseResultsResponse;
import com.google.cloud.dialogflow.cx.v3beta1.ListTestCasesRequest;
import com.google.cloud.dialogflow.cx.v3beta1.ListTestCasesResponse;
import com.google.cloud.dialogflow.cx.v3beta1.RunTestCaseMetadata;
import com.google.cloud.dialogflow.cx.v3beta1.RunTestCaseRequest;
import com.google.cloud.dialogflow.cx.v3beta1.RunTestCaseResponse;
import com.google.cloud.dialogflow.cx.v3beta1.TestCase;
import com.google.cloud.dialogflow.cx.v3beta1.TestCaseResult;
import com.google.cloud.dialogflow.cx.v3beta1.UpdateTestCaseRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.TypeRegistry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the TestCases service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonTestCasesStub extends TestCasesStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(RunTestCaseResponse.getDescriptor())
          .add(ImportTestCasesMetadata.getDescriptor())
          .add(BatchRunTestCasesResponse.getDescriptor())
          .add(ImportTestCasesResponse.getDescriptor())
          .add(ExportTestCasesMetadata.getDescriptor())
          .add(RunTestCaseMetadata.getDescriptor())
          .add(BatchRunTestCasesMetadata.getDescriptor())
          .add(ExportTestCasesResponse.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<ListTestCasesRequest, ListTestCasesResponse>
      listTestCasesMethodDescriptor =
          ApiMethodDescriptor.<ListTestCasesRequest, ListTestCasesResponse>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.TestCases/ListTestCases")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListTestCasesRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{parent=projects/*/locations/*/agents/*}/testCases",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListTestCasesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListTestCasesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "view", request.getView());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListTestCasesResponse>newBuilder()
                      .setDefaultInstance(ListTestCasesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<BatchDeleteTestCasesRequest, Empty>
      batchDeleteTestCasesMethodDescriptor =
          ApiMethodDescriptor.<BatchDeleteTestCasesRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.dialogflow.cx.v3beta1.TestCases/BatchDeleteTestCases")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchDeleteTestCasesRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{parent=projects/*/locations/*/agents/*}/testCases:batchDelete",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDeleteTestCasesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchDeleteTestCasesRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetTestCaseRequest, TestCase>
      getTestCaseMethodDescriptor =
          ApiMethodDescriptor.<GetTestCaseRequest, TestCase>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.TestCases/GetTestCase")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetTestCaseRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{name=projects/*/locations/*/agents/*/testCases/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetTestCaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetTestCaseRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TestCase>newBuilder()
                      .setDefaultInstance(TestCase.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateTestCaseRequest, TestCase>
      createTestCaseMethodDescriptor =
          ApiMethodDescriptor.<CreateTestCaseRequest, TestCase>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.TestCases/CreateTestCase")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateTestCaseRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{parent=projects/*/locations/*/agents/*}/testCases",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateTestCaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateTestCaseRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("testCase", request.getTestCase(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TestCase>newBuilder()
                      .setDefaultInstance(TestCase.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateTestCaseRequest, TestCase>
      updateTestCaseMethodDescriptor =
          ApiMethodDescriptor.<UpdateTestCaseRequest, TestCase>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.TestCases/UpdateTestCase")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateTestCaseRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{testCase.name=projects/*/locations/*/agents/*/testCases/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateTestCaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "testCase.name", request.getTestCase().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateTestCaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("testCase", request.getTestCase(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TestCase>newBuilder()
                      .setDefaultInstance(TestCase.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RunTestCaseRequest, Operation>
      runTestCaseMethodDescriptor =
          ApiMethodDescriptor.<RunTestCaseRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.TestCases/RunTestCase")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RunTestCaseRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{name=projects/*/locations/*/agents/*/testCases/*}:run",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RunTestCaseRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RunTestCaseRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearName().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (RunTestCaseRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<BatchRunTestCasesRequest, Operation>
      batchRunTestCasesMethodDescriptor =
          ApiMethodDescriptor.<BatchRunTestCasesRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.TestCases/BatchRunTestCases")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchRunTestCasesRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{parent=projects/*/locations/*/agents/*}/testCases:batchRun",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchRunTestCasesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchRunTestCasesRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (BatchRunTestCasesRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CalculateCoverageRequest, CalculateCoverageResponse>
      calculateCoverageMethodDescriptor =
          ApiMethodDescriptor.<CalculateCoverageRequest, CalculateCoverageResponse>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.TestCases/CalculateCoverage")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CalculateCoverageRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{agent=projects/*/locations/*/agents/*}/testCases:calculateCoverage",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CalculateCoverageRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "agent", request.getAgent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CalculateCoverageRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "type", request.getType());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CalculateCoverageResponse>newBuilder()
                      .setDefaultInstance(CalculateCoverageResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ImportTestCasesRequest, Operation>
      importTestCasesMethodDescriptor =
          ApiMethodDescriptor.<ImportTestCasesRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.TestCases/ImportTestCases")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ImportTestCasesRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{parent=projects/*/locations/*/agents/*}/testCases:import",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ImportTestCasesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ImportTestCasesRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ImportTestCasesRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ExportTestCasesRequest, Operation>
      exportTestCasesMethodDescriptor =
          ApiMethodDescriptor.<ExportTestCasesRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.TestCases/ExportTestCases")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ExportTestCasesRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{parent=projects/*/locations/*/agents/*}/testCases:export",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ExportTestCasesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ExportTestCasesRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (ExportTestCasesRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<ListTestCaseResultsRequest, ListTestCaseResultsResponse>
      listTestCaseResultsMethodDescriptor =
          ApiMethodDescriptor.<ListTestCaseResultsRequest, ListTestCaseResultsResponse>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.TestCases/ListTestCaseResults")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListTestCaseResultsRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{parent=projects/*/locations/*/agents/*/testCases/*}/results",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListTestCaseResultsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListTestCaseResultsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListTestCaseResultsResponse>newBuilder()
                      .setDefaultInstance(ListTestCaseResultsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetTestCaseResultRequest, TestCaseResult>
      getTestCaseResultMethodDescriptor =
          ApiMethodDescriptor.<GetTestCaseResultRequest, TestCaseResult>newBuilder()
              .setFullMethodName("google.cloud.dialogflow.cx.v3beta1.TestCases/GetTestCaseResult")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetTestCaseResultRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{name=projects/*/locations/*/agents/*/testCases/*/results/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetTestCaseResultRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetTestCaseResultRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TestCaseResult>newBuilder()
                      .setDefaultInstance(TestCaseResult.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListLocationsRequest, ListLocationsResponse>
      listLocationsMethodDescriptor =
          ApiMethodDescriptor.<ListLocationsRequest, ListLocationsResponse>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/ListLocations")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLocationsRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{name=projects/*}/locations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListLocationsResponse>newBuilder()
                      .setDefaultInstance(ListLocationsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetLocationRequest, Location>
      getLocationMethodDescriptor =
          ApiMethodDescriptor.<GetLocationRequest, Location>newBuilder()
              .setFullMethodName("google.cloud.location.Locations/GetLocation")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetLocationRequest>newBuilder()
                      .setPath(
                          "/v3beta1/{name=projects/*/locations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Location>newBuilder()
                      .setDefaultInstance(Location.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<ListTestCasesRequest, ListTestCasesResponse> listTestCasesCallable;
  private final UnaryCallable<ListTestCasesRequest, ListTestCasesPagedResponse>
      listTestCasesPagedCallable;
  private final UnaryCallable<BatchDeleteTestCasesRequest, Empty> batchDeleteTestCasesCallable;
  private final UnaryCallable<GetTestCaseRequest, TestCase> getTestCaseCallable;
  private final UnaryCallable<CreateTestCaseRequest, TestCase> createTestCaseCallable;
  private final UnaryCallable<UpdateTestCaseRequest, TestCase> updateTestCaseCallable;
  private final UnaryCallable<RunTestCaseRequest, Operation> runTestCaseCallable;
  private final OperationCallable<RunTestCaseRequest, RunTestCaseResponse, RunTestCaseMetadata>
      runTestCaseOperationCallable;
  private final UnaryCallable<BatchRunTestCasesRequest, Operation> batchRunTestCasesCallable;
  private final OperationCallable<
          BatchRunTestCasesRequest, BatchRunTestCasesResponse, BatchRunTestCasesMetadata>
      batchRunTestCasesOperationCallable;
  private final UnaryCallable<CalculateCoverageRequest, CalculateCoverageResponse>
      calculateCoverageCallable;
  private final UnaryCallable<ImportTestCasesRequest, Operation> importTestCasesCallable;
  private final OperationCallable<
          ImportTestCasesRequest, ImportTestCasesResponse, ImportTestCasesMetadata>
      importTestCasesOperationCallable;
  private final UnaryCallable<ExportTestCasesRequest, Operation> exportTestCasesCallable;
  private final OperationCallable<
          ExportTestCasesRequest, ExportTestCasesResponse, ExportTestCasesMetadata>
      exportTestCasesOperationCallable;
  private final UnaryCallable<ListTestCaseResultsRequest, ListTestCaseResultsResponse>
      listTestCaseResultsCallable;
  private final UnaryCallable<ListTestCaseResultsRequest, ListTestCaseResultsPagedResponse>
      listTestCaseResultsPagedCallable;
  private final UnaryCallable<GetTestCaseResultRequest, TestCaseResult> getTestCaseResultCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonTestCasesStub create(TestCasesStubSettings settings)
      throws IOException {
    return new HttpJsonTestCasesStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonTestCasesStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonTestCasesStub(
        TestCasesStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonTestCasesStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonTestCasesStub(
        TestCasesStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonTestCasesStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonTestCasesStub(TestCasesStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonTestCasesCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonTestCasesStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonTestCasesStub(
      TestCasesStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(clientContext, callableFactory, typeRegistry);

    HttpJsonCallSettings<ListTestCasesRequest, ListTestCasesResponse>
        listTestCasesTransportSettings =
            HttpJsonCallSettings.<ListTestCasesRequest, ListTestCasesResponse>newBuilder()
                .setMethodDescriptor(listTestCasesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<BatchDeleteTestCasesRequest, Empty> batchDeleteTestCasesTransportSettings =
        HttpJsonCallSettings.<BatchDeleteTestCasesRequest, Empty>newBuilder()
            .setMethodDescriptor(batchDeleteTestCasesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<GetTestCaseRequest, TestCase> getTestCaseTransportSettings =
        HttpJsonCallSettings.<GetTestCaseRequest, TestCase>newBuilder()
            .setMethodDescriptor(getTestCaseMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CreateTestCaseRequest, TestCase> createTestCaseTransportSettings =
        HttpJsonCallSettings.<CreateTestCaseRequest, TestCase>newBuilder()
            .setMethodDescriptor(createTestCaseMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<UpdateTestCaseRequest, TestCase> updateTestCaseTransportSettings =
        HttpJsonCallSettings.<UpdateTestCaseRequest, TestCase>newBuilder()
            .setMethodDescriptor(updateTestCaseMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<RunTestCaseRequest, Operation> runTestCaseTransportSettings =
        HttpJsonCallSettings.<RunTestCaseRequest, Operation>newBuilder()
            .setMethodDescriptor(runTestCaseMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<BatchRunTestCasesRequest, Operation> batchRunTestCasesTransportSettings =
        HttpJsonCallSettings.<BatchRunTestCasesRequest, Operation>newBuilder()
            .setMethodDescriptor(batchRunTestCasesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<CalculateCoverageRequest, CalculateCoverageResponse>
        calculateCoverageTransportSettings =
            HttpJsonCallSettings.<CalculateCoverageRequest, CalculateCoverageResponse>newBuilder()
                .setMethodDescriptor(calculateCoverageMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ImportTestCasesRequest, Operation> importTestCasesTransportSettings =
        HttpJsonCallSettings.<ImportTestCasesRequest, Operation>newBuilder()
            .setMethodDescriptor(importTestCasesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ExportTestCasesRequest, Operation> exportTestCasesTransportSettings =
        HttpJsonCallSettings.<ExportTestCasesRequest, Operation>newBuilder()
            .setMethodDescriptor(exportTestCasesMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<ListTestCaseResultsRequest, ListTestCaseResultsResponse>
        listTestCaseResultsTransportSettings =
            HttpJsonCallSettings
                .<ListTestCaseResultsRequest, ListTestCaseResultsResponse>newBuilder()
                .setMethodDescriptor(listTestCaseResultsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetTestCaseResultRequest, TestCaseResult>
        getTestCaseResultTransportSettings =
            HttpJsonCallSettings.<GetTestCaseResultRequest, TestCaseResult>newBuilder()
                .setMethodDescriptor(getTestCaseResultMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<ListLocationsRequest, ListLocationsResponse>
        listLocationsTransportSettings =
            HttpJsonCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
                .setMethodDescriptor(listLocationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .build();
    HttpJsonCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        HttpJsonCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();

    this.listTestCasesCallable =
        callableFactory.createUnaryCallable(
            listTestCasesTransportSettings, settings.listTestCasesSettings(), clientContext);
    this.listTestCasesPagedCallable =
        callableFactory.createPagedCallable(
            listTestCasesTransportSettings, settings.listTestCasesSettings(), clientContext);
    this.batchDeleteTestCasesCallable =
        callableFactory.createUnaryCallable(
            batchDeleteTestCasesTransportSettings,
            settings.batchDeleteTestCasesSettings(),
            clientContext);
    this.getTestCaseCallable =
        callableFactory.createUnaryCallable(
            getTestCaseTransportSettings, settings.getTestCaseSettings(), clientContext);
    this.createTestCaseCallable =
        callableFactory.createUnaryCallable(
            createTestCaseTransportSettings, settings.createTestCaseSettings(), clientContext);
    this.updateTestCaseCallable =
        callableFactory.createUnaryCallable(
            updateTestCaseTransportSettings, settings.updateTestCaseSettings(), clientContext);
    this.runTestCaseCallable =
        callableFactory.createUnaryCallable(
            runTestCaseTransportSettings, settings.runTestCaseSettings(), clientContext);
    this.runTestCaseOperationCallable =
        callableFactory.createOperationCallable(
            runTestCaseTransportSettings,
            settings.runTestCaseOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.batchRunTestCasesCallable =
        callableFactory.createUnaryCallable(
            batchRunTestCasesTransportSettings,
            settings.batchRunTestCasesSettings(),
            clientContext);
    this.batchRunTestCasesOperationCallable =
        callableFactory.createOperationCallable(
            batchRunTestCasesTransportSettings,
            settings.batchRunTestCasesOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.calculateCoverageCallable =
        callableFactory.createUnaryCallable(
            calculateCoverageTransportSettings,
            settings.calculateCoverageSettings(),
            clientContext);
    this.importTestCasesCallable =
        callableFactory.createUnaryCallable(
            importTestCasesTransportSettings, settings.importTestCasesSettings(), clientContext);
    this.importTestCasesOperationCallable =
        callableFactory.createOperationCallable(
            importTestCasesTransportSettings,
            settings.importTestCasesOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.exportTestCasesCallable =
        callableFactory.createUnaryCallable(
            exportTestCasesTransportSettings, settings.exportTestCasesSettings(), clientContext);
    this.exportTestCasesOperationCallable =
        callableFactory.createOperationCallable(
            exportTestCasesTransportSettings,
            settings.exportTestCasesOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.listTestCaseResultsCallable =
        callableFactory.createUnaryCallable(
            listTestCaseResultsTransportSettings,
            settings.listTestCaseResultsSettings(),
            clientContext);
    this.listTestCaseResultsPagedCallable =
        callableFactory.createPagedCallable(
            listTestCaseResultsTransportSettings,
            settings.listTestCaseResultsSettings(),
            clientContext);
    this.getTestCaseResultCallable =
        callableFactory.createUnaryCallable(
            getTestCaseResultTransportSettings,
            settings.getTestCaseResultSettings(),
            clientContext);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(listTestCasesMethodDescriptor);
    methodDescriptors.add(batchDeleteTestCasesMethodDescriptor);
    methodDescriptors.add(getTestCaseMethodDescriptor);
    methodDescriptors.add(createTestCaseMethodDescriptor);
    methodDescriptors.add(updateTestCaseMethodDescriptor);
    methodDescriptors.add(runTestCaseMethodDescriptor);
    methodDescriptors.add(batchRunTestCasesMethodDescriptor);
    methodDescriptors.add(calculateCoverageMethodDescriptor);
    methodDescriptors.add(importTestCasesMethodDescriptor);
    methodDescriptors.add(exportTestCasesMethodDescriptor);
    methodDescriptors.add(listTestCaseResultsMethodDescriptor);
    methodDescriptors.add(getTestCaseResultMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<ListTestCasesRequest, ListTestCasesResponse> listTestCasesCallable() {
    return listTestCasesCallable;
  }

  @Override
  public UnaryCallable<ListTestCasesRequest, ListTestCasesPagedResponse>
      listTestCasesPagedCallable() {
    return listTestCasesPagedCallable;
  }

  @Override
  public UnaryCallable<BatchDeleteTestCasesRequest, Empty> batchDeleteTestCasesCallable() {
    return batchDeleteTestCasesCallable;
  }

  @Override
  public UnaryCallable<GetTestCaseRequest, TestCase> getTestCaseCallable() {
    return getTestCaseCallable;
  }

  @Override
  public UnaryCallable<CreateTestCaseRequest, TestCase> createTestCaseCallable() {
    return createTestCaseCallable;
  }

  @Override
  public UnaryCallable<UpdateTestCaseRequest, TestCase> updateTestCaseCallable() {
    return updateTestCaseCallable;
  }

  @Override
  public UnaryCallable<RunTestCaseRequest, Operation> runTestCaseCallable() {
    return runTestCaseCallable;
  }

  @Override
  public OperationCallable<RunTestCaseRequest, RunTestCaseResponse, RunTestCaseMetadata>
      runTestCaseOperationCallable() {
    return runTestCaseOperationCallable;
  }

  @Override
  public UnaryCallable<BatchRunTestCasesRequest, Operation> batchRunTestCasesCallable() {
    return batchRunTestCasesCallable;
  }

  @Override
  public OperationCallable<
          BatchRunTestCasesRequest, BatchRunTestCasesResponse, BatchRunTestCasesMetadata>
      batchRunTestCasesOperationCallable() {
    return batchRunTestCasesOperationCallable;
  }

  @Override
  public UnaryCallable<CalculateCoverageRequest, CalculateCoverageResponse>
      calculateCoverageCallable() {
    return calculateCoverageCallable;
  }

  @Override
  public UnaryCallable<ImportTestCasesRequest, Operation> importTestCasesCallable() {
    return importTestCasesCallable;
  }

  @Override
  public OperationCallable<ImportTestCasesRequest, ImportTestCasesResponse, ImportTestCasesMetadata>
      importTestCasesOperationCallable() {
    return importTestCasesOperationCallable;
  }

  @Override
  public UnaryCallable<ExportTestCasesRequest, Operation> exportTestCasesCallable() {
    return exportTestCasesCallable;
  }

  @Override
  public OperationCallable<ExportTestCasesRequest, ExportTestCasesResponse, ExportTestCasesMetadata>
      exportTestCasesOperationCallable() {
    return exportTestCasesOperationCallable;
  }

  @Override
  public UnaryCallable<ListTestCaseResultsRequest, ListTestCaseResultsResponse>
      listTestCaseResultsCallable() {
    return listTestCaseResultsCallable;
  }

  @Override
  public UnaryCallable<ListTestCaseResultsRequest, ListTestCaseResultsPagedResponse>
      listTestCaseResultsPagedCallable() {
    return listTestCaseResultsPagedCallable;
  }

  @Override
  public UnaryCallable<GetTestCaseResultRequest, TestCaseResult> getTestCaseResultCallable() {
    return getTestCaseResultCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return listLocationsCallable;
  }

  @Override
  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return listLocationsPagedCallable;
  }

  @Override
  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return getLocationCallable;
  }

  @Override
  public final void close() {
    try {
      backgroundResources.close();
    } catch (RuntimeException e) {
      throw e;
    } catch (Exception e) {
      throw new IllegalStateException("Failed to close resource", e);
    }
  }

  @Override
  public void shutdown() {
    backgroundResources.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return backgroundResources.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return backgroundResources.isTerminated();
  }

  @Override
  public void shutdownNow() {
    backgroundResources.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return backgroundResources.awaitTermination(duration, unit);
  }
}
