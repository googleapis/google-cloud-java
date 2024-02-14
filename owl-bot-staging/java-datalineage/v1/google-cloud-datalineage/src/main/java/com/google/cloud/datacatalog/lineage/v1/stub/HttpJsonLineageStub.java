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

package com.google.cloud.datacatalog.lineage.v1.stub;

import static com.google.cloud.datacatalog.lineage.v1.LineageClient.BatchSearchLinkProcessesPagedResponse;
import static com.google.cloud.datacatalog.lineage.v1.LineageClient.ListLineageEventsPagedResponse;
import static com.google.cloud.datacatalog.lineage.v1.LineageClient.ListProcessesPagedResponse;
import static com.google.cloud.datacatalog.lineage.v1.LineageClient.ListRunsPagedResponse;
import static com.google.cloud.datacatalog.lineage.v1.LineageClient.SearchLinksPagedResponse;

import com.google.api.HttpRule;
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
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.datacatalog.lineage.v1.BatchSearchLinkProcessesRequest;
import com.google.cloud.datacatalog.lineage.v1.BatchSearchLinkProcessesResponse;
import com.google.cloud.datacatalog.lineage.v1.CreateLineageEventRequest;
import com.google.cloud.datacatalog.lineage.v1.CreateProcessRequest;
import com.google.cloud.datacatalog.lineage.v1.CreateRunRequest;
import com.google.cloud.datacatalog.lineage.v1.DeleteLineageEventRequest;
import com.google.cloud.datacatalog.lineage.v1.DeleteProcessRequest;
import com.google.cloud.datacatalog.lineage.v1.DeleteRunRequest;
import com.google.cloud.datacatalog.lineage.v1.GetLineageEventRequest;
import com.google.cloud.datacatalog.lineage.v1.GetProcessRequest;
import com.google.cloud.datacatalog.lineage.v1.GetRunRequest;
import com.google.cloud.datacatalog.lineage.v1.LineageEvent;
import com.google.cloud.datacatalog.lineage.v1.ListLineageEventsRequest;
import com.google.cloud.datacatalog.lineage.v1.ListLineageEventsResponse;
import com.google.cloud.datacatalog.lineage.v1.ListProcessesRequest;
import com.google.cloud.datacatalog.lineage.v1.ListProcessesResponse;
import com.google.cloud.datacatalog.lineage.v1.ListRunsRequest;
import com.google.cloud.datacatalog.lineage.v1.ListRunsResponse;
import com.google.cloud.datacatalog.lineage.v1.OperationMetadata;
import com.google.cloud.datacatalog.lineage.v1.Process;
import com.google.cloud.datacatalog.lineage.v1.ProcessOpenLineageRunEventRequest;
import com.google.cloud.datacatalog.lineage.v1.ProcessOpenLineageRunEventResponse;
import com.google.cloud.datacatalog.lineage.v1.Run;
import com.google.cloud.datacatalog.lineage.v1.SearchLinksRequest;
import com.google.cloud.datacatalog.lineage.v1.SearchLinksResponse;
import com.google.cloud.datacatalog.lineage.v1.UpdateProcessRequest;
import com.google.cloud.datacatalog.lineage.v1.UpdateRunRequest;
import com.google.common.collect.ImmutableMap;
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
 * REST stub implementation for the Lineage service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
@BetaApi
public class HttpJsonLineageStub extends LineageStub {
  private static final TypeRegistry typeRegistry =
      TypeRegistry.newBuilder()
          .add(OperationMetadata.getDescriptor())
          .add(Empty.getDescriptor())
          .build();

  private static final ApiMethodDescriptor<
          ProcessOpenLineageRunEventRequest, ProcessOpenLineageRunEventResponse>
      processOpenLineageRunEventMethodDescriptor =
          ApiMethodDescriptor
              .<ProcessOpenLineageRunEventRequest, ProcessOpenLineageRunEventResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.datacatalog.lineage.v1.Lineage/ProcessOpenLineageRunEvent")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ProcessOpenLineageRunEventRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}:processOpenLineageRunEvent",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ProcessOpenLineageRunEventRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ProcessOpenLineageRunEventRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("openLineage", request.getOpenLineage(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ProcessOpenLineageRunEventResponse>newBuilder()
                      .setDefaultInstance(ProcessOpenLineageRunEventResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CreateProcessRequest, Process>
      createProcessMethodDescriptor =
          ApiMethodDescriptor.<CreateProcessRequest, Process>newBuilder()
              .setFullMethodName("google.cloud.datacatalog.lineage.v1.Lineage/CreateProcess")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateProcessRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/processes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateProcessRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateProcessRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("process", request.getProcess(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Process>newBuilder()
                      .setDefaultInstance(Process.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<UpdateProcessRequest, Process>
      updateProcessMethodDescriptor =
          ApiMethodDescriptor.<UpdateProcessRequest, Process>newBuilder()
              .setFullMethodName("google.cloud.datacatalog.lineage.v1.Lineage/UpdateProcess")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<UpdateProcessRequest>newBuilder()
                      .setPath(
                          "/v1/{process.name=projects/*/locations/*/processes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateProcessRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "process.name", request.getProcess().getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateProcessRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "allowMissing", request.getAllowMissing());
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("process", request.getProcess(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Process>newBuilder()
                      .setDefaultInstance(Process.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetProcessRequest, Process> getProcessMethodDescriptor =
      ApiMethodDescriptor.<GetProcessRequest, Process>newBuilder()
          .setFullMethodName("google.cloud.datacatalog.lineage.v1.Lineage/GetProcess")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetProcessRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/processes/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetProcessRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetProcessRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Process>newBuilder()
                  .setDefaultInstance(Process.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListProcessesRequest, ListProcessesResponse>
      listProcessesMethodDescriptor =
          ApiMethodDescriptor.<ListProcessesRequest, ListProcessesResponse>newBuilder()
              .setFullMethodName("google.cloud.datacatalog.lineage.v1.Lineage/ListProcesses")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListProcessesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/processes",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListProcessesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListProcessesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListProcessesResponse>newBuilder()
                      .setDefaultInstance(ListProcessesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteProcessRequest, Operation>
      deleteProcessMethodDescriptor =
          ApiMethodDescriptor.<DeleteProcessRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.datacatalog.lineage.v1.Lineage/DeleteProcess")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteProcessRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/processes/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteProcessRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteProcessRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "allowMissing", request.getAllowMissing());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .setOperationSnapshotFactory(
                  (DeleteProcessRequest request, Operation response) ->
                      HttpJsonOperationSnapshot.create(response))
              .build();

  private static final ApiMethodDescriptor<CreateRunRequest, Run> createRunMethodDescriptor =
      ApiMethodDescriptor.<CreateRunRequest, Run>newBuilder()
          .setFullMethodName("google.cloud.datacatalog.lineage.v1.Lineage/CreateRun")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<CreateRunRequest>newBuilder()
                  .setPath(
                      "/v1/{parent=projects/*/locations/*/processes/*}/runs",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<CreateRunRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "parent", request.getParent());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<CreateRunRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "requestId", request.getRequestId());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request -> ProtoRestSerializer.create().toBody("run", request.getRun(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Run>newBuilder()
                  .setDefaultInstance(Run.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<UpdateRunRequest, Run> updateRunMethodDescriptor =
      ApiMethodDescriptor.<UpdateRunRequest, Run>newBuilder()
          .setFullMethodName("google.cloud.datacatalog.lineage.v1.Lineage/UpdateRun")
          .setHttpMethod("PATCH")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<UpdateRunRequest>newBuilder()
                  .setPath(
                      "/v1/{run.name=projects/*/locations/*/processes/*/runs/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateRunRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "run.name", request.getRun().getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<UpdateRunRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "allowMissing", request.getAllowMissing());
                        serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request -> ProtoRestSerializer.create().toBody("run", request.getRun(), true))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Run>newBuilder()
                  .setDefaultInstance(Run.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<GetRunRequest, Run> getRunMethodDescriptor =
      ApiMethodDescriptor.<GetRunRequest, Run>newBuilder()
          .setFullMethodName("google.cloud.datacatalog.lineage.v1.Lineage/GetRun")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetRunRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/processes/*/runs/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<GetRunRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<GetRunRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Run>newBuilder()
                  .setDefaultInstance(Run.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<ListRunsRequest, ListRunsResponse>
      listRunsMethodDescriptor =
          ApiMethodDescriptor.<ListRunsRequest, ListRunsResponse>newBuilder()
              .setFullMethodName("google.cloud.datacatalog.lineage.v1.Lineage/ListRuns")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListRunsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/processes/*}/runs",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListRunsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListRunsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListRunsResponse>newBuilder()
                      .setDefaultInstance(ListRunsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteRunRequest, Operation> deleteRunMethodDescriptor =
      ApiMethodDescriptor.<DeleteRunRequest, Operation>newBuilder()
          .setFullMethodName("google.cloud.datacatalog.lineage.v1.Lineage/DeleteRun")
          .setHttpMethod("DELETE")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<DeleteRunRequest>newBuilder()
                  .setPath(
                      "/v1/{name=projects/*/locations/*/processes/*/runs/*}",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteRunRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "name", request.getName());
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<DeleteRunRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "allowMissing", request.getAllowMissing());
                        serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Operation>newBuilder()
                  .setDefaultInstance(Operation.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .setOperationSnapshotFactory(
              (DeleteRunRequest request, Operation response) ->
                  HttpJsonOperationSnapshot.create(response))
          .build();

  private static final ApiMethodDescriptor<CreateLineageEventRequest, LineageEvent>
      createLineageEventMethodDescriptor =
          ApiMethodDescriptor.<CreateLineageEventRequest, LineageEvent>newBuilder()
              .setFullMethodName("google.cloud.datacatalog.lineage.v1.Lineage/CreateLineageEvent")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateLineageEventRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/processes/*/runs/*}/lineageEvents",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateLineageEventRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateLineageEventRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "requestId", request.getRequestId());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("lineageEvent", request.getLineageEvent(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<LineageEvent>newBuilder()
                      .setDefaultInstance(LineageEvent.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetLineageEventRequest, LineageEvent>
      getLineageEventMethodDescriptor =
          ApiMethodDescriptor.<GetLineageEventRequest, LineageEvent>newBuilder()
              .setFullMethodName("google.cloud.datacatalog.lineage.v1.Lineage/GetLineageEvent")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetLineageEventRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/processes/*/runs/*/lineageEvents/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetLineageEventRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetLineageEventRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<LineageEvent>newBuilder()
                      .setDefaultInstance(LineageEvent.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ListLineageEventsRequest, ListLineageEventsResponse>
      listLineageEventsMethodDescriptor =
          ApiMethodDescriptor.<ListLineageEventsRequest, ListLineageEventsResponse>newBuilder()
              .setFullMethodName("google.cloud.datacatalog.lineage.v1.Lineage/ListLineageEvents")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ListLineageEventsRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*/processes/*/runs/*}/lineageEvents",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLineageEventsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListLineageEventsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ListLineageEventsResponse>newBuilder()
                      .setDefaultInstance(ListLineageEventsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteLineageEventRequest, Empty>
      deleteLineageEventMethodDescriptor =
          ApiMethodDescriptor.<DeleteLineageEventRequest, Empty>newBuilder()
              .setFullMethodName("google.cloud.datacatalog.lineage.v1.Lineage/DeleteLineageEvent")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteLineageEventRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/processes/*/runs/*/lineageEvents/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteLineageEventRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteLineageEventRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "allowMissing", request.getAllowMissing());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Empty>newBuilder()
                      .setDefaultInstance(Empty.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<SearchLinksRequest, SearchLinksResponse>
      searchLinksMethodDescriptor =
          ApiMethodDescriptor.<SearchLinksRequest, SearchLinksResponse>newBuilder()
              .setFullMethodName("google.cloud.datacatalog.lineage.v1.Lineage/SearchLinks")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SearchLinksRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}:searchLinks",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SearchLinksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SearchLinksRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SearchLinksResponse>newBuilder()
                      .setDefaultInstance(SearchLinksResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          BatchSearchLinkProcessesRequest, BatchSearchLinkProcessesResponse>
      batchSearchLinkProcessesMethodDescriptor =
          ApiMethodDescriptor
              .<BatchSearchLinkProcessesRequest, BatchSearchLinkProcessesResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.datacatalog.lineage.v1.Lineage/BatchSearchLinkProcesses")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<BatchSearchLinkProcessesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}:batchSearchLinkProcesses",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<BatchSearchLinkProcessesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<BatchSearchLinkProcessesRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<BatchSearchLinkProcessesResponse>newBuilder()
                      .setDefaultInstance(BatchSearchLinkProcessesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<ProcessOpenLineageRunEventRequest, ProcessOpenLineageRunEventResponse>
      processOpenLineageRunEventCallable;
  private final UnaryCallable<CreateProcessRequest, Process> createProcessCallable;
  private final UnaryCallable<UpdateProcessRequest, Process> updateProcessCallable;
  private final UnaryCallable<GetProcessRequest, Process> getProcessCallable;
  private final UnaryCallable<ListProcessesRequest, ListProcessesResponse> listProcessesCallable;
  private final UnaryCallable<ListProcessesRequest, ListProcessesPagedResponse>
      listProcessesPagedCallable;
  private final UnaryCallable<DeleteProcessRequest, Operation> deleteProcessCallable;
  private final OperationCallable<DeleteProcessRequest, Empty, OperationMetadata>
      deleteProcessOperationCallable;
  private final UnaryCallable<CreateRunRequest, Run> createRunCallable;
  private final UnaryCallable<UpdateRunRequest, Run> updateRunCallable;
  private final UnaryCallable<GetRunRequest, Run> getRunCallable;
  private final UnaryCallable<ListRunsRequest, ListRunsResponse> listRunsCallable;
  private final UnaryCallable<ListRunsRequest, ListRunsPagedResponse> listRunsPagedCallable;
  private final UnaryCallable<DeleteRunRequest, Operation> deleteRunCallable;
  private final OperationCallable<DeleteRunRequest, Empty, OperationMetadata>
      deleteRunOperationCallable;
  private final UnaryCallable<CreateLineageEventRequest, LineageEvent> createLineageEventCallable;
  private final UnaryCallable<GetLineageEventRequest, LineageEvent> getLineageEventCallable;
  private final UnaryCallable<ListLineageEventsRequest, ListLineageEventsResponse>
      listLineageEventsCallable;
  private final UnaryCallable<ListLineageEventsRequest, ListLineageEventsPagedResponse>
      listLineageEventsPagedCallable;
  private final UnaryCallable<DeleteLineageEventRequest, Empty> deleteLineageEventCallable;
  private final UnaryCallable<SearchLinksRequest, SearchLinksResponse> searchLinksCallable;
  private final UnaryCallable<SearchLinksRequest, SearchLinksPagedResponse>
      searchLinksPagedCallable;
  private final UnaryCallable<BatchSearchLinkProcessesRequest, BatchSearchLinkProcessesResponse>
      batchSearchLinkProcessesCallable;
  private final UnaryCallable<
          BatchSearchLinkProcessesRequest, BatchSearchLinkProcessesPagedResponse>
      batchSearchLinkProcessesPagedCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonOperationsStub httpJsonOperationsStub;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonLineageStub create(LineageStubSettings settings) throws IOException {
    return new HttpJsonLineageStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonLineageStub create(ClientContext clientContext) throws IOException {
    return new HttpJsonLineageStub(LineageStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonLineageStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonLineageStub(
        LineageStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonLineageStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonLineageStub(LineageStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonLineageCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonLineageStub, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonLineageStub(
      LineageStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;
    this.httpJsonOperationsStub =
        HttpJsonOperationsStub.create(
            clientContext,
            callableFactory,
            typeRegistry,
            ImmutableMap.<String, HttpRule>builder()
                .put(
                    "google.longrunning.Operations.CancelOperation",
                    HttpRule.newBuilder()
                        .setPost("/v1/{name=projects/*/locations/*/operations/*}:cancel")
                        .build())
                .put(
                    "google.longrunning.Operations.DeleteOperation",
                    HttpRule.newBuilder()
                        .setDelete("/v1/{name=projects/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.GetOperation",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/locations/*/operations/*}")
                        .build())
                .put(
                    "google.longrunning.Operations.ListOperations",
                    HttpRule.newBuilder()
                        .setGet("/v1/{name=projects/*/locations/*}/operations")
                        .build())
                .build());

    HttpJsonCallSettings<ProcessOpenLineageRunEventRequest, ProcessOpenLineageRunEventResponse>
        processOpenLineageRunEventTransportSettings =
            HttpJsonCallSettings
                .<ProcessOpenLineageRunEventRequest, ProcessOpenLineageRunEventResponse>newBuilder()
                .setMethodDescriptor(processOpenLineageRunEventMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<CreateProcessRequest, Process> createProcessTransportSettings =
        HttpJsonCallSettings.<CreateProcessRequest, Process>newBuilder()
            .setMethodDescriptor(createProcessMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateProcessRequest, Process> updateProcessTransportSettings =
        HttpJsonCallSettings.<UpdateProcessRequest, Process>newBuilder()
            .setMethodDescriptor(updateProcessMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("process.name", String.valueOf(request.getProcess().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetProcessRequest, Process> getProcessTransportSettings =
        HttpJsonCallSettings.<GetProcessRequest, Process>newBuilder()
            .setMethodDescriptor(getProcessMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListProcessesRequest, ListProcessesResponse>
        listProcessesTransportSettings =
            HttpJsonCallSettings.<ListProcessesRequest, ListProcessesResponse>newBuilder()
                .setMethodDescriptor(listProcessesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteProcessRequest, Operation> deleteProcessTransportSettings =
        HttpJsonCallSettings.<DeleteProcessRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteProcessMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateRunRequest, Run> createRunTransportSettings =
        HttpJsonCallSettings.<CreateRunRequest, Run>newBuilder()
            .setMethodDescriptor(createRunMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<UpdateRunRequest, Run> updateRunTransportSettings =
        HttpJsonCallSettings.<UpdateRunRequest, Run>newBuilder()
            .setMethodDescriptor(updateRunMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("run.name", String.valueOf(request.getRun().getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetRunRequest, Run> getRunTransportSettings =
        HttpJsonCallSettings.<GetRunRequest, Run>newBuilder()
            .setMethodDescriptor(getRunMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListRunsRequest, ListRunsResponse> listRunsTransportSettings =
        HttpJsonCallSettings.<ListRunsRequest, ListRunsResponse>newBuilder()
            .setMethodDescriptor(listRunsMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DeleteRunRequest, Operation> deleteRunTransportSettings =
        HttpJsonCallSettings.<DeleteRunRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteRunMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CreateLineageEventRequest, LineageEvent>
        createLineageEventTransportSettings =
            HttpJsonCallSettings.<CreateLineageEventRequest, LineageEvent>newBuilder()
                .setMethodDescriptor(createLineageEventMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetLineageEventRequest, LineageEvent> getLineageEventTransportSettings =
        HttpJsonCallSettings.<GetLineageEventRequest, LineageEvent>newBuilder()
            .setMethodDescriptor(getLineageEventMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<ListLineageEventsRequest, ListLineageEventsResponse>
        listLineageEventsTransportSettings =
            HttpJsonCallSettings.<ListLineageEventsRequest, ListLineageEventsResponse>newBuilder()
                .setMethodDescriptor(listLineageEventsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteLineageEventRequest, Empty> deleteLineageEventTransportSettings =
        HttpJsonCallSettings.<DeleteLineageEventRequest, Empty>newBuilder()
            .setMethodDescriptor(deleteLineageEventMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<SearchLinksRequest, SearchLinksResponse> searchLinksTransportSettings =
        HttpJsonCallSettings.<SearchLinksRequest, SearchLinksResponse>newBuilder()
            .setMethodDescriptor(searchLinksMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("parent", String.valueOf(request.getParent()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<BatchSearchLinkProcessesRequest, BatchSearchLinkProcessesResponse>
        batchSearchLinkProcessesTransportSettings =
            HttpJsonCallSettings
                .<BatchSearchLinkProcessesRequest, BatchSearchLinkProcessesResponse>newBuilder()
                .setMethodDescriptor(batchSearchLinkProcessesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();

    this.processOpenLineageRunEventCallable =
        callableFactory.createUnaryCallable(
            processOpenLineageRunEventTransportSettings,
            settings.processOpenLineageRunEventSettings(),
            clientContext);
    this.createProcessCallable =
        callableFactory.createUnaryCallable(
            createProcessTransportSettings, settings.createProcessSettings(), clientContext);
    this.updateProcessCallable =
        callableFactory.createUnaryCallable(
            updateProcessTransportSettings, settings.updateProcessSettings(), clientContext);
    this.getProcessCallable =
        callableFactory.createUnaryCallable(
            getProcessTransportSettings, settings.getProcessSettings(), clientContext);
    this.listProcessesCallable =
        callableFactory.createUnaryCallable(
            listProcessesTransportSettings, settings.listProcessesSettings(), clientContext);
    this.listProcessesPagedCallable =
        callableFactory.createPagedCallable(
            listProcessesTransportSettings, settings.listProcessesSettings(), clientContext);
    this.deleteProcessCallable =
        callableFactory.createUnaryCallable(
            deleteProcessTransportSettings, settings.deleteProcessSettings(), clientContext);
    this.deleteProcessOperationCallable =
        callableFactory.createOperationCallable(
            deleteProcessTransportSettings,
            settings.deleteProcessOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.createRunCallable =
        callableFactory.createUnaryCallable(
            createRunTransportSettings, settings.createRunSettings(), clientContext);
    this.updateRunCallable =
        callableFactory.createUnaryCallable(
            updateRunTransportSettings, settings.updateRunSettings(), clientContext);
    this.getRunCallable =
        callableFactory.createUnaryCallable(
            getRunTransportSettings, settings.getRunSettings(), clientContext);
    this.listRunsCallable =
        callableFactory.createUnaryCallable(
            listRunsTransportSettings, settings.listRunsSettings(), clientContext);
    this.listRunsPagedCallable =
        callableFactory.createPagedCallable(
            listRunsTransportSettings, settings.listRunsSettings(), clientContext);
    this.deleteRunCallable =
        callableFactory.createUnaryCallable(
            deleteRunTransportSettings, settings.deleteRunSettings(), clientContext);
    this.deleteRunOperationCallable =
        callableFactory.createOperationCallable(
            deleteRunTransportSettings,
            settings.deleteRunOperationSettings(),
            clientContext,
            httpJsonOperationsStub);
    this.createLineageEventCallable =
        callableFactory.createUnaryCallable(
            createLineageEventTransportSettings,
            settings.createLineageEventSettings(),
            clientContext);
    this.getLineageEventCallable =
        callableFactory.createUnaryCallable(
            getLineageEventTransportSettings, settings.getLineageEventSettings(), clientContext);
    this.listLineageEventsCallable =
        callableFactory.createUnaryCallable(
            listLineageEventsTransportSettings,
            settings.listLineageEventsSettings(),
            clientContext);
    this.listLineageEventsPagedCallable =
        callableFactory.createPagedCallable(
            listLineageEventsTransportSettings,
            settings.listLineageEventsSettings(),
            clientContext);
    this.deleteLineageEventCallable =
        callableFactory.createUnaryCallable(
            deleteLineageEventTransportSettings,
            settings.deleteLineageEventSettings(),
            clientContext);
    this.searchLinksCallable =
        callableFactory.createUnaryCallable(
            searchLinksTransportSettings, settings.searchLinksSettings(), clientContext);
    this.searchLinksPagedCallable =
        callableFactory.createPagedCallable(
            searchLinksTransportSettings, settings.searchLinksSettings(), clientContext);
    this.batchSearchLinkProcessesCallable =
        callableFactory.createUnaryCallable(
            batchSearchLinkProcessesTransportSettings,
            settings.batchSearchLinkProcessesSettings(),
            clientContext);
    this.batchSearchLinkProcessesPagedCallable =
        callableFactory.createPagedCallable(
            batchSearchLinkProcessesTransportSettings,
            settings.batchSearchLinkProcessesSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(processOpenLineageRunEventMethodDescriptor);
    methodDescriptors.add(createProcessMethodDescriptor);
    methodDescriptors.add(updateProcessMethodDescriptor);
    methodDescriptors.add(getProcessMethodDescriptor);
    methodDescriptors.add(listProcessesMethodDescriptor);
    methodDescriptors.add(deleteProcessMethodDescriptor);
    methodDescriptors.add(createRunMethodDescriptor);
    methodDescriptors.add(updateRunMethodDescriptor);
    methodDescriptors.add(getRunMethodDescriptor);
    methodDescriptors.add(listRunsMethodDescriptor);
    methodDescriptors.add(deleteRunMethodDescriptor);
    methodDescriptors.add(createLineageEventMethodDescriptor);
    methodDescriptors.add(getLineageEventMethodDescriptor);
    methodDescriptors.add(listLineageEventsMethodDescriptor);
    methodDescriptors.add(deleteLineageEventMethodDescriptor);
    methodDescriptors.add(searchLinksMethodDescriptor);
    methodDescriptors.add(batchSearchLinkProcessesMethodDescriptor);
    return methodDescriptors;
  }

  public HttpJsonOperationsStub getHttpJsonOperationsStub() {
    return httpJsonOperationsStub;
  }

  @Override
  public UnaryCallable<ProcessOpenLineageRunEventRequest, ProcessOpenLineageRunEventResponse>
      processOpenLineageRunEventCallable() {
    return processOpenLineageRunEventCallable;
  }

  @Override
  public UnaryCallable<CreateProcessRequest, Process> createProcessCallable() {
    return createProcessCallable;
  }

  @Override
  public UnaryCallable<UpdateProcessRequest, Process> updateProcessCallable() {
    return updateProcessCallable;
  }

  @Override
  public UnaryCallable<GetProcessRequest, Process> getProcessCallable() {
    return getProcessCallable;
  }

  @Override
  public UnaryCallable<ListProcessesRequest, ListProcessesResponse> listProcessesCallable() {
    return listProcessesCallable;
  }

  @Override
  public UnaryCallable<ListProcessesRequest, ListProcessesPagedResponse>
      listProcessesPagedCallable() {
    return listProcessesPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteProcessRequest, Operation> deleteProcessCallable() {
    return deleteProcessCallable;
  }

  @Override
  public OperationCallable<DeleteProcessRequest, Empty, OperationMetadata>
      deleteProcessOperationCallable() {
    return deleteProcessOperationCallable;
  }

  @Override
  public UnaryCallable<CreateRunRequest, Run> createRunCallable() {
    return createRunCallable;
  }

  @Override
  public UnaryCallable<UpdateRunRequest, Run> updateRunCallable() {
    return updateRunCallable;
  }

  @Override
  public UnaryCallable<GetRunRequest, Run> getRunCallable() {
    return getRunCallable;
  }

  @Override
  public UnaryCallable<ListRunsRequest, ListRunsResponse> listRunsCallable() {
    return listRunsCallable;
  }

  @Override
  public UnaryCallable<ListRunsRequest, ListRunsPagedResponse> listRunsPagedCallable() {
    return listRunsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteRunRequest, Operation> deleteRunCallable() {
    return deleteRunCallable;
  }

  @Override
  public OperationCallable<DeleteRunRequest, Empty, OperationMetadata>
      deleteRunOperationCallable() {
    return deleteRunOperationCallable;
  }

  @Override
  public UnaryCallable<CreateLineageEventRequest, LineageEvent> createLineageEventCallable() {
    return createLineageEventCallable;
  }

  @Override
  public UnaryCallable<GetLineageEventRequest, LineageEvent> getLineageEventCallable() {
    return getLineageEventCallable;
  }

  @Override
  public UnaryCallable<ListLineageEventsRequest, ListLineageEventsResponse>
      listLineageEventsCallable() {
    return listLineageEventsCallable;
  }

  @Override
  public UnaryCallable<ListLineageEventsRequest, ListLineageEventsPagedResponse>
      listLineageEventsPagedCallable() {
    return listLineageEventsPagedCallable;
  }

  @Override
  public UnaryCallable<DeleteLineageEventRequest, Empty> deleteLineageEventCallable() {
    return deleteLineageEventCallable;
  }

  @Override
  public UnaryCallable<SearchLinksRequest, SearchLinksResponse> searchLinksCallable() {
    return searchLinksCallable;
  }

  @Override
  public UnaryCallable<SearchLinksRequest, SearchLinksPagedResponse> searchLinksPagedCallable() {
    return searchLinksPagedCallable;
  }

  @Override
  public UnaryCallable<BatchSearchLinkProcessesRequest, BatchSearchLinkProcessesResponse>
      batchSearchLinkProcessesCallable() {
    return batchSearchLinkProcessesCallable;
  }

  @Override
  public UnaryCallable<BatchSearchLinkProcessesRequest, BatchSearchLinkProcessesPagedResponse>
      batchSearchLinkProcessesPagedCallable() {
    return batchSearchLinkProcessesPagedCallable;
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
