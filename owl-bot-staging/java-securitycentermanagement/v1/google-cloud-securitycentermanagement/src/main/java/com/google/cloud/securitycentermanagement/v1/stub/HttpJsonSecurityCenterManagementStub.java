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

package com.google.cloud.securitycentermanagement.v1.stub;

import static com.google.cloud.securitycentermanagement.v1.SecurityCenterManagementClient.ListDescendantEventThreatDetectionCustomModulesPagedResponse;
import static com.google.cloud.securitycentermanagement.v1.SecurityCenterManagementClient.ListDescendantSecurityHealthAnalyticsCustomModulesPagedResponse;
import static com.google.cloud.securitycentermanagement.v1.SecurityCenterManagementClient.ListEffectiveEventThreatDetectionCustomModulesPagedResponse;
import static com.google.cloud.securitycentermanagement.v1.SecurityCenterManagementClient.ListEffectiveSecurityHealthAnalyticsCustomModulesPagedResponse;
import static com.google.cloud.securitycentermanagement.v1.SecurityCenterManagementClient.ListEventThreatDetectionCustomModulesPagedResponse;
import static com.google.cloud.securitycentermanagement.v1.SecurityCenterManagementClient.ListLocationsPagedResponse;
import static com.google.cloud.securitycentermanagement.v1.SecurityCenterManagementClient.ListSecurityHealthAnalyticsCustomModulesPagedResponse;

import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.securitycentermanagement.v1.CreateEventThreatDetectionCustomModuleRequest;
import com.google.cloud.securitycentermanagement.v1.CreateSecurityHealthAnalyticsCustomModuleRequest;
import com.google.cloud.securitycentermanagement.v1.DeleteEventThreatDetectionCustomModuleRequest;
import com.google.cloud.securitycentermanagement.v1.DeleteSecurityHealthAnalyticsCustomModuleRequest;
import com.google.cloud.securitycentermanagement.v1.EffectiveEventThreatDetectionCustomModule;
import com.google.cloud.securitycentermanagement.v1.EffectiveSecurityHealthAnalyticsCustomModule;
import com.google.cloud.securitycentermanagement.v1.EventThreatDetectionCustomModule;
import com.google.cloud.securitycentermanagement.v1.GetEffectiveEventThreatDetectionCustomModuleRequest;
import com.google.cloud.securitycentermanagement.v1.GetEffectiveSecurityHealthAnalyticsCustomModuleRequest;
import com.google.cloud.securitycentermanagement.v1.GetEventThreatDetectionCustomModuleRequest;
import com.google.cloud.securitycentermanagement.v1.GetSecurityHealthAnalyticsCustomModuleRequest;
import com.google.cloud.securitycentermanagement.v1.ListDescendantEventThreatDetectionCustomModulesRequest;
import com.google.cloud.securitycentermanagement.v1.ListDescendantEventThreatDetectionCustomModulesResponse;
import com.google.cloud.securitycentermanagement.v1.ListDescendantSecurityHealthAnalyticsCustomModulesRequest;
import com.google.cloud.securitycentermanagement.v1.ListDescendantSecurityHealthAnalyticsCustomModulesResponse;
import com.google.cloud.securitycentermanagement.v1.ListEffectiveEventThreatDetectionCustomModulesRequest;
import com.google.cloud.securitycentermanagement.v1.ListEffectiveEventThreatDetectionCustomModulesResponse;
import com.google.cloud.securitycentermanagement.v1.ListEffectiveSecurityHealthAnalyticsCustomModulesRequest;
import com.google.cloud.securitycentermanagement.v1.ListEffectiveSecurityHealthAnalyticsCustomModulesResponse;
import com.google.cloud.securitycentermanagement.v1.ListEventThreatDetectionCustomModulesRequest;
import com.google.cloud.securitycentermanagement.v1.ListEventThreatDetectionCustomModulesResponse;
import com.google.cloud.securitycentermanagement.v1.ListSecurityHealthAnalyticsCustomModulesRequest;
import com.google.cloud.securitycentermanagement.v1.ListSecurityHealthAnalyticsCustomModulesResponse;
import com.google.cloud.securitycentermanagement.v1.SecurityHealthAnalyticsCustomModule;
import com.google.cloud.securitycentermanagement.v1.SimulateSecurityHealthAnalyticsCustomModuleRequest;
import com.google.cloud.securitycentermanagement.v1.SimulateSecurityHealthAnalyticsCustomModuleResponse;
import com.google.cloud.securitycentermanagement.v1.UpdateEventThreatDetectionCustomModuleRequest;
import com.google.cloud.securitycentermanagement.v1.UpdateSecurityHealthAnalyticsCustomModuleRequest;
import com.google.cloud.securitycentermanagement.v1.ValidateEventThreatDetectionCustomModuleRequest;
import com.google.cloud.securitycentermanagement.v1.ValidateEventThreatDetectionCustomModuleResponse;
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
 * REST stub implementation for the SecurityCenterManagement service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public class HttpJsonSecurityCenterManagementStub extends SecurityCenterManagementStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<
          ListEffectiveSecurityHealthAnalyticsCustomModulesRequest,
          ListEffectiveSecurityHealthAnalyticsCustomModulesResponse>
      listEffectiveSecurityHealthAnalyticsCustomModulesMethodDescriptor =
          ApiMethodDescriptor
              .<ListEffectiveSecurityHealthAnalyticsCustomModulesRequest,
                  ListEffectiveSecurityHealthAnalyticsCustomModulesResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.securitycentermanagement.v1.SecurityCenterManagement/ListEffectiveSecurityHealthAnalyticsCustomModules")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<ListEffectiveSecurityHealthAnalyticsCustomModulesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/effectiveSecurityHealthAnalyticsCustomModules",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    ListEffectiveSecurityHealthAnalyticsCustomModulesRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=folders/*/locations/*}/effectiveSecurityHealthAnalyticsCustomModules",
                          "/v1/{parent=organizations/*/locations/*}/effectiveSecurityHealthAnalyticsCustomModules")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    ListEffectiveSecurityHealthAnalyticsCustomModulesRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<ListEffectiveSecurityHealthAnalyticsCustomModulesResponse>newBuilder()
                      .setDefaultInstance(
                          ListEffectiveSecurityHealthAnalyticsCustomModulesResponse
                              .getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          GetEffectiveSecurityHealthAnalyticsCustomModuleRequest,
          EffectiveSecurityHealthAnalyticsCustomModule>
      getEffectiveSecurityHealthAnalyticsCustomModuleMethodDescriptor =
          ApiMethodDescriptor
              .<GetEffectiveSecurityHealthAnalyticsCustomModuleRequest,
                  EffectiveSecurityHealthAnalyticsCustomModule>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.securitycentermanagement.v1.SecurityCenterManagement/GetEffectiveSecurityHealthAnalyticsCustomModule")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<GetEffectiveSecurityHealthAnalyticsCustomModuleRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/effectiveSecurityHealthAnalyticsCustomModules/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    GetEffectiveSecurityHealthAnalyticsCustomModuleRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{name=folders/*/locations/*/effectiveSecurityHealthAnalyticsCustomModules/*}",
                          "/v1/{name=organizations/*/locations/*/effectiveSecurityHealthAnalyticsCustomModules/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    GetEffectiveSecurityHealthAnalyticsCustomModuleRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<EffectiveSecurityHealthAnalyticsCustomModule>newBuilder()
                      .setDefaultInstance(
                          EffectiveSecurityHealthAnalyticsCustomModule.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListSecurityHealthAnalyticsCustomModulesRequest,
          ListSecurityHealthAnalyticsCustomModulesResponse>
      listSecurityHealthAnalyticsCustomModulesMethodDescriptor =
          ApiMethodDescriptor
              .<ListSecurityHealthAnalyticsCustomModulesRequest,
                  ListSecurityHealthAnalyticsCustomModulesResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.securitycentermanagement.v1.SecurityCenterManagement/ListSecurityHealthAnalyticsCustomModules")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<ListSecurityHealthAnalyticsCustomModulesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/securityHealthAnalyticsCustomModules",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListSecurityHealthAnalyticsCustomModulesRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=folders/*/locations/*}/securityHealthAnalyticsCustomModules",
                          "/v1/{parent=organizations/*/locations/*}/securityHealthAnalyticsCustomModules")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListSecurityHealthAnalyticsCustomModulesRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<ListSecurityHealthAnalyticsCustomModulesResponse>newBuilder()
                      .setDefaultInstance(
                          ListSecurityHealthAnalyticsCustomModulesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListDescendantSecurityHealthAnalyticsCustomModulesRequest,
          ListDescendantSecurityHealthAnalyticsCustomModulesResponse>
      listDescendantSecurityHealthAnalyticsCustomModulesMethodDescriptor =
          ApiMethodDescriptor
              .<ListDescendantSecurityHealthAnalyticsCustomModulesRequest,
                  ListDescendantSecurityHealthAnalyticsCustomModulesResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.securitycentermanagement.v1.SecurityCenterManagement/ListDescendantSecurityHealthAnalyticsCustomModules")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<ListDescendantSecurityHealthAnalyticsCustomModulesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/securityHealthAnalyticsCustomModules:listDescendant",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    ListDescendantSecurityHealthAnalyticsCustomModulesRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=folders/*/locations/*}/securityHealthAnalyticsCustomModules:listDescendant",
                          "/v1/{parent=organizations/*/locations/*}/securityHealthAnalyticsCustomModules:listDescendant")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    ListDescendantSecurityHealthAnalyticsCustomModulesRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<ListDescendantSecurityHealthAnalyticsCustomModulesResponse>newBuilder()
                      .setDefaultInstance(
                          ListDescendantSecurityHealthAnalyticsCustomModulesResponse
                              .getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          GetSecurityHealthAnalyticsCustomModuleRequest, SecurityHealthAnalyticsCustomModule>
      getSecurityHealthAnalyticsCustomModuleMethodDescriptor =
          ApiMethodDescriptor
              .<GetSecurityHealthAnalyticsCustomModuleRequest, SecurityHealthAnalyticsCustomModule>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.securitycentermanagement.v1.SecurityCenterManagement/GetSecurityHealthAnalyticsCustomModule")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<GetSecurityHealthAnalyticsCustomModuleRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/securityHealthAnalyticsCustomModules/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetSecurityHealthAnalyticsCustomModuleRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{name=folders/*/locations/*/securityHealthAnalyticsCustomModules/*}",
                          "/v1/{name=organizations/*/locations/*/securityHealthAnalyticsCustomModules/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetSecurityHealthAnalyticsCustomModuleRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SecurityHealthAnalyticsCustomModule>newBuilder()
                      .setDefaultInstance(SecurityHealthAnalyticsCustomModule.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          CreateSecurityHealthAnalyticsCustomModuleRequest, SecurityHealthAnalyticsCustomModule>
      createSecurityHealthAnalyticsCustomModuleMethodDescriptor =
          ApiMethodDescriptor
              .<CreateSecurityHealthAnalyticsCustomModuleRequest,
                  SecurityHealthAnalyticsCustomModule>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.securitycentermanagement.v1.SecurityCenterManagement/CreateSecurityHealthAnalyticsCustomModule")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<CreateSecurityHealthAnalyticsCustomModuleRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/securityHealthAnalyticsCustomModules",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSecurityHealthAnalyticsCustomModuleRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=folders/*/locations/*}/securityHealthAnalyticsCustomModules",
                          "/v1/{parent=organizations/*/locations/*}/securityHealthAnalyticsCustomModules")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateSecurityHealthAnalyticsCustomModuleRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "securityHealthAnalyticsCustomModule",
                                      request.getSecurityHealthAnalyticsCustomModule(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SecurityHealthAnalyticsCustomModule>newBuilder()
                      .setDefaultInstance(SecurityHealthAnalyticsCustomModule.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          UpdateSecurityHealthAnalyticsCustomModuleRequest, SecurityHealthAnalyticsCustomModule>
      updateSecurityHealthAnalyticsCustomModuleMethodDescriptor =
          ApiMethodDescriptor
              .<UpdateSecurityHealthAnalyticsCustomModuleRequest,
                  SecurityHealthAnalyticsCustomModule>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.securitycentermanagement.v1.SecurityCenterManagement/UpdateSecurityHealthAnalyticsCustomModule")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<UpdateSecurityHealthAnalyticsCustomModuleRequest>newBuilder()
                      .setPath(
                          "/v1/{securityHealthAnalyticsCustomModule.name=projects/*/locations/*/securityHealthAnalyticsCustomModules/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSecurityHealthAnalyticsCustomModuleRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "securityHealthAnalyticsCustomModule.name",
                                request.getSecurityHealthAnalyticsCustomModule().getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{securityHealthAnalyticsCustomModule.name=folders/*/locations/*/securityHealthAnalyticsCustomModules/*}",
                          "/v1/{securityHealthAnalyticsCustomModule.name=organizations/*/locations/*/securityHealthAnalyticsCustomModules/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateSecurityHealthAnalyticsCustomModuleRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "securityHealthAnalyticsCustomModule",
                                      request.getSecurityHealthAnalyticsCustomModule(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<SecurityHealthAnalyticsCustomModule>newBuilder()
                      .setDefaultInstance(SecurityHealthAnalyticsCustomModule.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteSecurityHealthAnalyticsCustomModuleRequest, Empty>
      deleteSecurityHealthAnalyticsCustomModuleMethodDescriptor =
          ApiMethodDescriptor.<DeleteSecurityHealthAnalyticsCustomModuleRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.securitycentermanagement.v1.SecurityCenterManagement/DeleteSecurityHealthAnalyticsCustomModule")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<DeleteSecurityHealthAnalyticsCustomModuleRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/securityHealthAnalyticsCustomModules/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSecurityHealthAnalyticsCustomModuleRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{name=folders/*/locations/*/securityHealthAnalyticsCustomModules/*}",
                          "/v1/{name=organizations/*/locations/*/securityHealthAnalyticsCustomModules/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteSecurityHealthAnalyticsCustomModuleRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
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

  private static final ApiMethodDescriptor<
          SimulateSecurityHealthAnalyticsCustomModuleRequest,
          SimulateSecurityHealthAnalyticsCustomModuleResponse>
      simulateSecurityHealthAnalyticsCustomModuleMethodDescriptor =
          ApiMethodDescriptor
              .<SimulateSecurityHealthAnalyticsCustomModuleRequest,
                  SimulateSecurityHealthAnalyticsCustomModuleResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.securitycentermanagement.v1.SecurityCenterManagement/SimulateSecurityHealthAnalyticsCustomModule")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<SimulateSecurityHealthAnalyticsCustomModuleRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/securityHealthAnalyticsCustomModules:simulate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SimulateSecurityHealthAnalyticsCustomModuleRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=folders/*/locations/*}/securityHealthAnalyticsCustomModules:simulate",
                          "/v1/{parent=organizations/*/locations/*}/securityHealthAnalyticsCustomModules:simulate")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SimulateSecurityHealthAnalyticsCustomModuleRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<SimulateSecurityHealthAnalyticsCustomModuleResponse>newBuilder()
                      .setDefaultInstance(
                          SimulateSecurityHealthAnalyticsCustomModuleResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListEffectiveEventThreatDetectionCustomModulesRequest,
          ListEffectiveEventThreatDetectionCustomModulesResponse>
      listEffectiveEventThreatDetectionCustomModulesMethodDescriptor =
          ApiMethodDescriptor
              .<ListEffectiveEventThreatDetectionCustomModulesRequest,
                  ListEffectiveEventThreatDetectionCustomModulesResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.securitycentermanagement.v1.SecurityCenterManagement/ListEffectiveEventThreatDetectionCustomModules")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<ListEffectiveEventThreatDetectionCustomModulesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/effectiveEventThreatDetectionCustomModules",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    ListEffectiveEventThreatDetectionCustomModulesRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=folders/*/locations/*}/effectiveEventThreatDetectionCustomModules",
                          "/v1/{parent=organizations/*/locations/*}/effectiveEventThreatDetectionCustomModules")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    ListEffectiveEventThreatDetectionCustomModulesRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<ListEffectiveEventThreatDetectionCustomModulesResponse>newBuilder()
                      .setDefaultInstance(
                          ListEffectiveEventThreatDetectionCustomModulesResponse
                              .getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          GetEffectiveEventThreatDetectionCustomModuleRequest,
          EffectiveEventThreatDetectionCustomModule>
      getEffectiveEventThreatDetectionCustomModuleMethodDescriptor =
          ApiMethodDescriptor
              .<GetEffectiveEventThreatDetectionCustomModuleRequest,
                  EffectiveEventThreatDetectionCustomModule>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.securitycentermanagement.v1.SecurityCenterManagement/GetEffectiveEventThreatDetectionCustomModule")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<GetEffectiveEventThreatDetectionCustomModuleRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/effectiveEventThreatDetectionCustomModules/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetEffectiveEventThreatDetectionCustomModuleRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{name=folders/*/locations/*/effectiveEventThreatDetectionCustomModules/*}",
                          "/v1/{name=organizations/*/locations/*/effectiveEventThreatDetectionCustomModules/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetEffectiveEventThreatDetectionCustomModuleRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<EffectiveEventThreatDetectionCustomModule>newBuilder()
                      .setDefaultInstance(
                          EffectiveEventThreatDetectionCustomModule.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListEventThreatDetectionCustomModulesRequest,
          ListEventThreatDetectionCustomModulesResponse>
      listEventThreatDetectionCustomModulesMethodDescriptor =
          ApiMethodDescriptor
              .<ListEventThreatDetectionCustomModulesRequest,
                  ListEventThreatDetectionCustomModulesResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.securitycentermanagement.v1.SecurityCenterManagement/ListEventThreatDetectionCustomModules")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<ListEventThreatDetectionCustomModulesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/eventThreatDetectionCustomModules",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListEventThreatDetectionCustomModulesRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=folders/*/locations/*}/eventThreatDetectionCustomModules",
                          "/v1/{parent=organizations/*/locations/*}/eventThreatDetectionCustomModules")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ListEventThreatDetectionCustomModulesRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<ListEventThreatDetectionCustomModulesResponse>newBuilder()
                      .setDefaultInstance(
                          ListEventThreatDetectionCustomModulesResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          ListDescendantEventThreatDetectionCustomModulesRequest,
          ListDescendantEventThreatDetectionCustomModulesResponse>
      listDescendantEventThreatDetectionCustomModulesMethodDescriptor =
          ApiMethodDescriptor
              .<ListDescendantEventThreatDetectionCustomModulesRequest,
                  ListDescendantEventThreatDetectionCustomModulesResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.securitycentermanagement.v1.SecurityCenterManagement/ListDescendantEventThreatDetectionCustomModules")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<ListDescendantEventThreatDetectionCustomModulesRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/eventThreatDetectionCustomModules:listDescendant",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    ListDescendantEventThreatDetectionCustomModulesRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=folders/*/locations/*}/eventThreatDetectionCustomModules:listDescendant",
                          "/v1/{parent=organizations/*/locations/*}/eventThreatDetectionCustomModules:listDescendant")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<
                                    ListDescendantEventThreatDetectionCustomModulesRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "pageSize", request.getPageSize());
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<ListDescendantEventThreatDetectionCustomModulesResponse>newBuilder()
                      .setDefaultInstance(
                          ListDescendantEventThreatDetectionCustomModulesResponse
                              .getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          GetEventThreatDetectionCustomModuleRequest, EventThreatDetectionCustomModule>
      getEventThreatDetectionCustomModuleMethodDescriptor =
          ApiMethodDescriptor
              .<GetEventThreatDetectionCustomModuleRequest, EventThreatDetectionCustomModule>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.securitycentermanagement.v1.SecurityCenterManagement/GetEventThreatDetectionCustomModule")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<GetEventThreatDetectionCustomModuleRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/eventThreatDetectionCustomModules/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetEventThreatDetectionCustomModuleRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{name=folders/*/locations/*/eventThreatDetectionCustomModules/*}",
                          "/v1/{name=organizations/*/locations/*/eventThreatDetectionCustomModules/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetEventThreatDetectionCustomModuleRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<EventThreatDetectionCustomModule>newBuilder()
                      .setDefaultInstance(EventThreatDetectionCustomModule.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          CreateEventThreatDetectionCustomModuleRequest, EventThreatDetectionCustomModule>
      createEventThreatDetectionCustomModuleMethodDescriptor =
          ApiMethodDescriptor
              .<CreateEventThreatDetectionCustomModuleRequest, EventThreatDetectionCustomModule>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.securitycentermanagement.v1.SecurityCenterManagement/CreateEventThreatDetectionCustomModule")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<CreateEventThreatDetectionCustomModuleRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/eventThreatDetectionCustomModules",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CreateEventThreatDetectionCustomModuleRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=folders/*/locations/*}/eventThreatDetectionCustomModules",
                          "/v1/{parent=organizations/*/locations/*}/eventThreatDetectionCustomModules")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CreateEventThreatDetectionCustomModuleRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "eventThreatDetectionCustomModule",
                                      request.getEventThreatDetectionCustomModule(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<EventThreatDetectionCustomModule>newBuilder()
                      .setDefaultInstance(EventThreatDetectionCustomModule.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<
          UpdateEventThreatDetectionCustomModuleRequest, EventThreatDetectionCustomModule>
      updateEventThreatDetectionCustomModuleMethodDescriptor =
          ApiMethodDescriptor
              .<UpdateEventThreatDetectionCustomModuleRequest, EventThreatDetectionCustomModule>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.securitycentermanagement.v1.SecurityCenterManagement/UpdateEventThreatDetectionCustomModule")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<UpdateEventThreatDetectionCustomModuleRequest>newBuilder()
                      .setPath(
                          "/v1/{eventThreatDetectionCustomModule.name=projects/*/locations/*/eventThreatDetectionCustomModules/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateEventThreatDetectionCustomModuleRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "eventThreatDetectionCustomModule.name",
                                request.getEventThreatDetectionCustomModule().getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{eventThreatDetectionCustomModule.name=folders/*/locations/*/eventThreatDetectionCustomModules/*}",
                          "/v1/{eventThreatDetectionCustomModule.name=organizations/*/locations/*/eventThreatDetectionCustomModules/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<UpdateEventThreatDetectionCustomModuleRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "updateMask", request.getUpdateMask());
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody(
                                      "eventThreatDetectionCustomModule",
                                      request.getEventThreatDetectionCustomModule(),
                                      true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<EventThreatDetectionCustomModule>newBuilder()
                      .setDefaultInstance(EventThreatDetectionCustomModule.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DeleteEventThreatDetectionCustomModuleRequest, Empty>
      deleteEventThreatDetectionCustomModuleMethodDescriptor =
          ApiMethodDescriptor.<DeleteEventThreatDetectionCustomModuleRequest, Empty>newBuilder()
              .setFullMethodName(
                  "google.cloud.securitycentermanagement.v1.SecurityCenterManagement/DeleteEventThreatDetectionCustomModule")
              .setHttpMethod("DELETE")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<DeleteEventThreatDetectionCustomModuleRequest>newBuilder()
                      .setPath(
                          "/v1/{name=projects/*/locations/*/eventThreatDetectionCustomModules/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteEventThreatDetectionCustomModuleRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{name=folders/*/locations/*/eventThreatDetectionCustomModules/*}",
                          "/v1/{name=organizations/*/locations/*/eventThreatDetectionCustomModules/*}")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DeleteEventThreatDetectionCustomModuleRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(
                                fields, "validateOnly", request.getValidateOnly());
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

  private static final ApiMethodDescriptor<
          ValidateEventThreatDetectionCustomModuleRequest,
          ValidateEventThreatDetectionCustomModuleResponse>
      validateEventThreatDetectionCustomModuleMethodDescriptor =
          ApiMethodDescriptor
              .<ValidateEventThreatDetectionCustomModuleRequest,
                  ValidateEventThreatDetectionCustomModuleResponse>
                  newBuilder()
              .setFullMethodName(
                  "google.cloud.securitycentermanagement.v1.SecurityCenterManagement/ValidateEventThreatDetectionCustomModule")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter
                      .<ValidateEventThreatDetectionCustomModuleRequest>newBuilder()
                      .setPath(
                          "/v1/{parent=projects/*/locations/*}/eventThreatDetectionCustomModules:validate",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ValidateEventThreatDetectionCustomModuleRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "parent", request.getParent());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1/{parent=folders/*/locations/*}/eventThreatDetectionCustomModules:validate",
                          "/v1/{parent=organizations/*/locations/*}/eventThreatDetectionCustomModules:validate")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ValidateEventThreatDetectionCustomModuleRequest>
                                serializer = ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearParent().build(), true))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser
                      .<ValidateEventThreatDetectionCustomModuleResponse>newBuilder()
                      .setDefaultInstance(
                          ValidateEventThreatDetectionCustomModuleResponse.getDefaultInstance())
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
                          "/v1/{name=projects/*}/locations",
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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
                          "/v1/{name=projects/*/locations/*}",
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
                            serializer.putQueryParam(fields, "$alt", "json;enum-encoding=int");
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

  private final UnaryCallable<
          ListEffectiveSecurityHealthAnalyticsCustomModulesRequest,
          ListEffectiveSecurityHealthAnalyticsCustomModulesResponse>
      listEffectiveSecurityHealthAnalyticsCustomModulesCallable;
  private final UnaryCallable<
          ListEffectiveSecurityHealthAnalyticsCustomModulesRequest,
          ListEffectiveSecurityHealthAnalyticsCustomModulesPagedResponse>
      listEffectiveSecurityHealthAnalyticsCustomModulesPagedCallable;
  private final UnaryCallable<
          GetEffectiveSecurityHealthAnalyticsCustomModuleRequest,
          EffectiveSecurityHealthAnalyticsCustomModule>
      getEffectiveSecurityHealthAnalyticsCustomModuleCallable;
  private final UnaryCallable<
          ListSecurityHealthAnalyticsCustomModulesRequest,
          ListSecurityHealthAnalyticsCustomModulesResponse>
      listSecurityHealthAnalyticsCustomModulesCallable;
  private final UnaryCallable<
          ListSecurityHealthAnalyticsCustomModulesRequest,
          ListSecurityHealthAnalyticsCustomModulesPagedResponse>
      listSecurityHealthAnalyticsCustomModulesPagedCallable;
  private final UnaryCallable<
          ListDescendantSecurityHealthAnalyticsCustomModulesRequest,
          ListDescendantSecurityHealthAnalyticsCustomModulesResponse>
      listDescendantSecurityHealthAnalyticsCustomModulesCallable;
  private final UnaryCallable<
          ListDescendantSecurityHealthAnalyticsCustomModulesRequest,
          ListDescendantSecurityHealthAnalyticsCustomModulesPagedResponse>
      listDescendantSecurityHealthAnalyticsCustomModulesPagedCallable;
  private final UnaryCallable<
          GetSecurityHealthAnalyticsCustomModuleRequest, SecurityHealthAnalyticsCustomModule>
      getSecurityHealthAnalyticsCustomModuleCallable;
  private final UnaryCallable<
          CreateSecurityHealthAnalyticsCustomModuleRequest, SecurityHealthAnalyticsCustomModule>
      createSecurityHealthAnalyticsCustomModuleCallable;
  private final UnaryCallable<
          UpdateSecurityHealthAnalyticsCustomModuleRequest, SecurityHealthAnalyticsCustomModule>
      updateSecurityHealthAnalyticsCustomModuleCallable;
  private final UnaryCallable<DeleteSecurityHealthAnalyticsCustomModuleRequest, Empty>
      deleteSecurityHealthAnalyticsCustomModuleCallable;
  private final UnaryCallable<
          SimulateSecurityHealthAnalyticsCustomModuleRequest,
          SimulateSecurityHealthAnalyticsCustomModuleResponse>
      simulateSecurityHealthAnalyticsCustomModuleCallable;
  private final UnaryCallable<
          ListEffectiveEventThreatDetectionCustomModulesRequest,
          ListEffectiveEventThreatDetectionCustomModulesResponse>
      listEffectiveEventThreatDetectionCustomModulesCallable;
  private final UnaryCallable<
          ListEffectiveEventThreatDetectionCustomModulesRequest,
          ListEffectiveEventThreatDetectionCustomModulesPagedResponse>
      listEffectiveEventThreatDetectionCustomModulesPagedCallable;
  private final UnaryCallable<
          GetEffectiveEventThreatDetectionCustomModuleRequest,
          EffectiveEventThreatDetectionCustomModule>
      getEffectiveEventThreatDetectionCustomModuleCallable;
  private final UnaryCallable<
          ListEventThreatDetectionCustomModulesRequest,
          ListEventThreatDetectionCustomModulesResponse>
      listEventThreatDetectionCustomModulesCallable;
  private final UnaryCallable<
          ListEventThreatDetectionCustomModulesRequest,
          ListEventThreatDetectionCustomModulesPagedResponse>
      listEventThreatDetectionCustomModulesPagedCallable;
  private final UnaryCallable<
          ListDescendantEventThreatDetectionCustomModulesRequest,
          ListDescendantEventThreatDetectionCustomModulesResponse>
      listDescendantEventThreatDetectionCustomModulesCallable;
  private final UnaryCallable<
          ListDescendantEventThreatDetectionCustomModulesRequest,
          ListDescendantEventThreatDetectionCustomModulesPagedResponse>
      listDescendantEventThreatDetectionCustomModulesPagedCallable;
  private final UnaryCallable<
          GetEventThreatDetectionCustomModuleRequest, EventThreatDetectionCustomModule>
      getEventThreatDetectionCustomModuleCallable;
  private final UnaryCallable<
          CreateEventThreatDetectionCustomModuleRequest, EventThreatDetectionCustomModule>
      createEventThreatDetectionCustomModuleCallable;
  private final UnaryCallable<
          UpdateEventThreatDetectionCustomModuleRequest, EventThreatDetectionCustomModule>
      updateEventThreatDetectionCustomModuleCallable;
  private final UnaryCallable<DeleteEventThreatDetectionCustomModuleRequest, Empty>
      deleteEventThreatDetectionCustomModuleCallable;
  private final UnaryCallable<
          ValidateEventThreatDetectionCustomModuleRequest,
          ValidateEventThreatDetectionCustomModuleResponse>
      validateEventThreatDetectionCustomModuleCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonSecurityCenterManagementStub create(
      SecurityCenterManagementStubSettings settings) throws IOException {
    return new HttpJsonSecurityCenterManagementStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonSecurityCenterManagementStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonSecurityCenterManagementStub(
        SecurityCenterManagementStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonSecurityCenterManagementStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonSecurityCenterManagementStub(
        SecurityCenterManagementStubSettings.newHttpJsonBuilder().build(),
        clientContext,
        callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonSecurityCenterManagementStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSecurityCenterManagementStub(
      SecurityCenterManagementStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonSecurityCenterManagementCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonSecurityCenterManagementStub, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonSecurityCenterManagementStub(
      SecurityCenterManagementStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<
            ListEffectiveSecurityHealthAnalyticsCustomModulesRequest,
            ListEffectiveSecurityHealthAnalyticsCustomModulesResponse>
        listEffectiveSecurityHealthAnalyticsCustomModulesTransportSettings =
            HttpJsonCallSettings
                .<ListEffectiveSecurityHealthAnalyticsCustomModulesRequest,
                    ListEffectiveSecurityHealthAnalyticsCustomModulesResponse>
                    newBuilder()
                .setMethodDescriptor(
                    listEffectiveSecurityHealthAnalyticsCustomModulesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            GetEffectiveSecurityHealthAnalyticsCustomModuleRequest,
            EffectiveSecurityHealthAnalyticsCustomModule>
        getEffectiveSecurityHealthAnalyticsCustomModuleTransportSettings =
            HttpJsonCallSettings
                .<GetEffectiveSecurityHealthAnalyticsCustomModuleRequest,
                    EffectiveSecurityHealthAnalyticsCustomModule>
                    newBuilder()
                .setMethodDescriptor(
                    getEffectiveSecurityHealthAnalyticsCustomModuleMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            ListSecurityHealthAnalyticsCustomModulesRequest,
            ListSecurityHealthAnalyticsCustomModulesResponse>
        listSecurityHealthAnalyticsCustomModulesTransportSettings =
            HttpJsonCallSettings
                .<ListSecurityHealthAnalyticsCustomModulesRequest,
                    ListSecurityHealthAnalyticsCustomModulesResponse>
                    newBuilder()
                .setMethodDescriptor(listSecurityHealthAnalyticsCustomModulesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            ListDescendantSecurityHealthAnalyticsCustomModulesRequest,
            ListDescendantSecurityHealthAnalyticsCustomModulesResponse>
        listDescendantSecurityHealthAnalyticsCustomModulesTransportSettings =
            HttpJsonCallSettings
                .<ListDescendantSecurityHealthAnalyticsCustomModulesRequest,
                    ListDescendantSecurityHealthAnalyticsCustomModulesResponse>
                    newBuilder()
                .setMethodDescriptor(
                    listDescendantSecurityHealthAnalyticsCustomModulesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            GetSecurityHealthAnalyticsCustomModuleRequest, SecurityHealthAnalyticsCustomModule>
        getSecurityHealthAnalyticsCustomModuleTransportSettings =
            HttpJsonCallSettings
                .<GetSecurityHealthAnalyticsCustomModuleRequest,
                    SecurityHealthAnalyticsCustomModule>
                    newBuilder()
                .setMethodDescriptor(getSecurityHealthAnalyticsCustomModuleMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            CreateSecurityHealthAnalyticsCustomModuleRequest, SecurityHealthAnalyticsCustomModule>
        createSecurityHealthAnalyticsCustomModuleTransportSettings =
            HttpJsonCallSettings
                .<CreateSecurityHealthAnalyticsCustomModuleRequest,
                    SecurityHealthAnalyticsCustomModule>
                    newBuilder()
                .setMethodDescriptor(createSecurityHealthAnalyticsCustomModuleMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            UpdateSecurityHealthAnalyticsCustomModuleRequest, SecurityHealthAnalyticsCustomModule>
        updateSecurityHealthAnalyticsCustomModuleTransportSettings =
            HttpJsonCallSettings
                .<UpdateSecurityHealthAnalyticsCustomModuleRequest,
                    SecurityHealthAnalyticsCustomModule>
                    newBuilder()
                .setMethodDescriptor(updateSecurityHealthAnalyticsCustomModuleMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "security_health_analytics_custom_module.name",
                          String.valueOf(
                              request.getSecurityHealthAnalyticsCustomModule().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteSecurityHealthAnalyticsCustomModuleRequest, Empty>
        deleteSecurityHealthAnalyticsCustomModuleTransportSettings =
            HttpJsonCallSettings
                .<DeleteSecurityHealthAnalyticsCustomModuleRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteSecurityHealthAnalyticsCustomModuleMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            SimulateSecurityHealthAnalyticsCustomModuleRequest,
            SimulateSecurityHealthAnalyticsCustomModuleResponse>
        simulateSecurityHealthAnalyticsCustomModuleTransportSettings =
            HttpJsonCallSettings
                .<SimulateSecurityHealthAnalyticsCustomModuleRequest,
                    SimulateSecurityHealthAnalyticsCustomModuleResponse>
                    newBuilder()
                .setMethodDescriptor(simulateSecurityHealthAnalyticsCustomModuleMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            ListEffectiveEventThreatDetectionCustomModulesRequest,
            ListEffectiveEventThreatDetectionCustomModulesResponse>
        listEffectiveEventThreatDetectionCustomModulesTransportSettings =
            HttpJsonCallSettings
                .<ListEffectiveEventThreatDetectionCustomModulesRequest,
                    ListEffectiveEventThreatDetectionCustomModulesResponse>
                    newBuilder()
                .setMethodDescriptor(listEffectiveEventThreatDetectionCustomModulesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            GetEffectiveEventThreatDetectionCustomModuleRequest,
            EffectiveEventThreatDetectionCustomModule>
        getEffectiveEventThreatDetectionCustomModuleTransportSettings =
            HttpJsonCallSettings
                .<GetEffectiveEventThreatDetectionCustomModuleRequest,
                    EffectiveEventThreatDetectionCustomModule>
                    newBuilder()
                .setMethodDescriptor(getEffectiveEventThreatDetectionCustomModuleMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            ListEventThreatDetectionCustomModulesRequest,
            ListEventThreatDetectionCustomModulesResponse>
        listEventThreatDetectionCustomModulesTransportSettings =
            HttpJsonCallSettings
                .<ListEventThreatDetectionCustomModulesRequest,
                    ListEventThreatDetectionCustomModulesResponse>
                    newBuilder()
                .setMethodDescriptor(listEventThreatDetectionCustomModulesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            ListDescendantEventThreatDetectionCustomModulesRequest,
            ListDescendantEventThreatDetectionCustomModulesResponse>
        listDescendantEventThreatDetectionCustomModulesTransportSettings =
            HttpJsonCallSettings
                .<ListDescendantEventThreatDetectionCustomModulesRequest,
                    ListDescendantEventThreatDetectionCustomModulesResponse>
                    newBuilder()
                .setMethodDescriptor(
                    listDescendantEventThreatDetectionCustomModulesMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            GetEventThreatDetectionCustomModuleRequest, EventThreatDetectionCustomModule>
        getEventThreatDetectionCustomModuleTransportSettings =
            HttpJsonCallSettings
                .<GetEventThreatDetectionCustomModuleRequest, EventThreatDetectionCustomModule>
                    newBuilder()
                .setMethodDescriptor(getEventThreatDetectionCustomModuleMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            CreateEventThreatDetectionCustomModuleRequest, EventThreatDetectionCustomModule>
        createEventThreatDetectionCustomModuleTransportSettings =
            HttpJsonCallSettings
                .<CreateEventThreatDetectionCustomModuleRequest, EventThreatDetectionCustomModule>
                    newBuilder()
                .setMethodDescriptor(createEventThreatDetectionCustomModuleMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            UpdateEventThreatDetectionCustomModuleRequest, EventThreatDetectionCustomModule>
        updateEventThreatDetectionCustomModuleTransportSettings =
            HttpJsonCallSettings
                .<UpdateEventThreatDetectionCustomModuleRequest, EventThreatDetectionCustomModule>
                    newBuilder()
                .setMethodDescriptor(updateEventThreatDetectionCustomModuleMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "event_threat_detection_custom_module.name",
                          String.valueOf(request.getEventThreatDetectionCustomModule().getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DeleteEventThreatDetectionCustomModuleRequest, Empty>
        deleteEventThreatDetectionCustomModuleTransportSettings =
            HttpJsonCallSettings.<DeleteEventThreatDetectionCustomModuleRequest, Empty>newBuilder()
                .setMethodDescriptor(deleteEventThreatDetectionCustomModuleMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<
            ValidateEventThreatDetectionCustomModuleRequest,
            ValidateEventThreatDetectionCustomModuleResponse>
        validateEventThreatDetectionCustomModuleTransportSettings =
            HttpJsonCallSettings
                .<ValidateEventThreatDetectionCustomModuleRequest,
                    ValidateEventThreatDetectionCustomModuleResponse>
                    newBuilder()
                .setMethodDescriptor(validateEventThreatDetectionCustomModuleMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("parent", String.valueOf(request.getParent()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ListLocationsRequest, ListLocationsResponse>
        listLocationsTransportSettings =
            HttpJsonCallSettings.<ListLocationsRequest, ListLocationsResponse>newBuilder()
                .setMethodDescriptor(listLocationsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("name", String.valueOf(request.getName()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<GetLocationRequest, Location> getLocationTransportSettings =
        HttpJsonCallSettings.<GetLocationRequest, Location>newBuilder()
            .setMethodDescriptor(getLocationMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("name", String.valueOf(request.getName()));
                  return builder.build();
                })
            .build();

    this.listEffectiveSecurityHealthAnalyticsCustomModulesCallable =
        callableFactory.createUnaryCallable(
            listEffectiveSecurityHealthAnalyticsCustomModulesTransportSettings,
            settings.listEffectiveSecurityHealthAnalyticsCustomModulesSettings(),
            clientContext);
    this.listEffectiveSecurityHealthAnalyticsCustomModulesPagedCallable =
        callableFactory.createPagedCallable(
            listEffectiveSecurityHealthAnalyticsCustomModulesTransportSettings,
            settings.listEffectiveSecurityHealthAnalyticsCustomModulesSettings(),
            clientContext);
    this.getEffectiveSecurityHealthAnalyticsCustomModuleCallable =
        callableFactory.createUnaryCallable(
            getEffectiveSecurityHealthAnalyticsCustomModuleTransportSettings,
            settings.getEffectiveSecurityHealthAnalyticsCustomModuleSettings(),
            clientContext);
    this.listSecurityHealthAnalyticsCustomModulesCallable =
        callableFactory.createUnaryCallable(
            listSecurityHealthAnalyticsCustomModulesTransportSettings,
            settings.listSecurityHealthAnalyticsCustomModulesSettings(),
            clientContext);
    this.listSecurityHealthAnalyticsCustomModulesPagedCallable =
        callableFactory.createPagedCallable(
            listSecurityHealthAnalyticsCustomModulesTransportSettings,
            settings.listSecurityHealthAnalyticsCustomModulesSettings(),
            clientContext);
    this.listDescendantSecurityHealthAnalyticsCustomModulesCallable =
        callableFactory.createUnaryCallable(
            listDescendantSecurityHealthAnalyticsCustomModulesTransportSettings,
            settings.listDescendantSecurityHealthAnalyticsCustomModulesSettings(),
            clientContext);
    this.listDescendantSecurityHealthAnalyticsCustomModulesPagedCallable =
        callableFactory.createPagedCallable(
            listDescendantSecurityHealthAnalyticsCustomModulesTransportSettings,
            settings.listDescendantSecurityHealthAnalyticsCustomModulesSettings(),
            clientContext);
    this.getSecurityHealthAnalyticsCustomModuleCallable =
        callableFactory.createUnaryCallable(
            getSecurityHealthAnalyticsCustomModuleTransportSettings,
            settings.getSecurityHealthAnalyticsCustomModuleSettings(),
            clientContext);
    this.createSecurityHealthAnalyticsCustomModuleCallable =
        callableFactory.createUnaryCallable(
            createSecurityHealthAnalyticsCustomModuleTransportSettings,
            settings.createSecurityHealthAnalyticsCustomModuleSettings(),
            clientContext);
    this.updateSecurityHealthAnalyticsCustomModuleCallable =
        callableFactory.createUnaryCallable(
            updateSecurityHealthAnalyticsCustomModuleTransportSettings,
            settings.updateSecurityHealthAnalyticsCustomModuleSettings(),
            clientContext);
    this.deleteSecurityHealthAnalyticsCustomModuleCallable =
        callableFactory.createUnaryCallable(
            deleteSecurityHealthAnalyticsCustomModuleTransportSettings,
            settings.deleteSecurityHealthAnalyticsCustomModuleSettings(),
            clientContext);
    this.simulateSecurityHealthAnalyticsCustomModuleCallable =
        callableFactory.createUnaryCallable(
            simulateSecurityHealthAnalyticsCustomModuleTransportSettings,
            settings.simulateSecurityHealthAnalyticsCustomModuleSettings(),
            clientContext);
    this.listEffectiveEventThreatDetectionCustomModulesCallable =
        callableFactory.createUnaryCallable(
            listEffectiveEventThreatDetectionCustomModulesTransportSettings,
            settings.listEffectiveEventThreatDetectionCustomModulesSettings(),
            clientContext);
    this.listEffectiveEventThreatDetectionCustomModulesPagedCallable =
        callableFactory.createPagedCallable(
            listEffectiveEventThreatDetectionCustomModulesTransportSettings,
            settings.listEffectiveEventThreatDetectionCustomModulesSettings(),
            clientContext);
    this.getEffectiveEventThreatDetectionCustomModuleCallable =
        callableFactory.createUnaryCallable(
            getEffectiveEventThreatDetectionCustomModuleTransportSettings,
            settings.getEffectiveEventThreatDetectionCustomModuleSettings(),
            clientContext);
    this.listEventThreatDetectionCustomModulesCallable =
        callableFactory.createUnaryCallable(
            listEventThreatDetectionCustomModulesTransportSettings,
            settings.listEventThreatDetectionCustomModulesSettings(),
            clientContext);
    this.listEventThreatDetectionCustomModulesPagedCallable =
        callableFactory.createPagedCallable(
            listEventThreatDetectionCustomModulesTransportSettings,
            settings.listEventThreatDetectionCustomModulesSettings(),
            clientContext);
    this.listDescendantEventThreatDetectionCustomModulesCallable =
        callableFactory.createUnaryCallable(
            listDescendantEventThreatDetectionCustomModulesTransportSettings,
            settings.listDescendantEventThreatDetectionCustomModulesSettings(),
            clientContext);
    this.listDescendantEventThreatDetectionCustomModulesPagedCallable =
        callableFactory.createPagedCallable(
            listDescendantEventThreatDetectionCustomModulesTransportSettings,
            settings.listDescendantEventThreatDetectionCustomModulesSettings(),
            clientContext);
    this.getEventThreatDetectionCustomModuleCallable =
        callableFactory.createUnaryCallable(
            getEventThreatDetectionCustomModuleTransportSettings,
            settings.getEventThreatDetectionCustomModuleSettings(),
            clientContext);
    this.createEventThreatDetectionCustomModuleCallable =
        callableFactory.createUnaryCallable(
            createEventThreatDetectionCustomModuleTransportSettings,
            settings.createEventThreatDetectionCustomModuleSettings(),
            clientContext);
    this.updateEventThreatDetectionCustomModuleCallable =
        callableFactory.createUnaryCallable(
            updateEventThreatDetectionCustomModuleTransportSettings,
            settings.updateEventThreatDetectionCustomModuleSettings(),
            clientContext);
    this.deleteEventThreatDetectionCustomModuleCallable =
        callableFactory.createUnaryCallable(
            deleteEventThreatDetectionCustomModuleTransportSettings,
            settings.deleteEventThreatDetectionCustomModuleSettings(),
            clientContext);
    this.validateEventThreatDetectionCustomModuleCallable =
        callableFactory.createUnaryCallable(
            validateEventThreatDetectionCustomModuleTransportSettings,
            settings.validateEventThreatDetectionCustomModuleSettings(),
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
    methodDescriptors.add(listEffectiveSecurityHealthAnalyticsCustomModulesMethodDescriptor);
    methodDescriptors.add(getEffectiveSecurityHealthAnalyticsCustomModuleMethodDescriptor);
    methodDescriptors.add(listSecurityHealthAnalyticsCustomModulesMethodDescriptor);
    methodDescriptors.add(listDescendantSecurityHealthAnalyticsCustomModulesMethodDescriptor);
    methodDescriptors.add(getSecurityHealthAnalyticsCustomModuleMethodDescriptor);
    methodDescriptors.add(createSecurityHealthAnalyticsCustomModuleMethodDescriptor);
    methodDescriptors.add(updateSecurityHealthAnalyticsCustomModuleMethodDescriptor);
    methodDescriptors.add(deleteSecurityHealthAnalyticsCustomModuleMethodDescriptor);
    methodDescriptors.add(simulateSecurityHealthAnalyticsCustomModuleMethodDescriptor);
    methodDescriptors.add(listEffectiveEventThreatDetectionCustomModulesMethodDescriptor);
    methodDescriptors.add(getEffectiveEventThreatDetectionCustomModuleMethodDescriptor);
    methodDescriptors.add(listEventThreatDetectionCustomModulesMethodDescriptor);
    methodDescriptors.add(listDescendantEventThreatDetectionCustomModulesMethodDescriptor);
    methodDescriptors.add(getEventThreatDetectionCustomModuleMethodDescriptor);
    methodDescriptors.add(createEventThreatDetectionCustomModuleMethodDescriptor);
    methodDescriptors.add(updateEventThreatDetectionCustomModuleMethodDescriptor);
    methodDescriptors.add(deleteEventThreatDetectionCustomModuleMethodDescriptor);
    methodDescriptors.add(validateEventThreatDetectionCustomModuleMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<
          ListEffectiveSecurityHealthAnalyticsCustomModulesRequest,
          ListEffectiveSecurityHealthAnalyticsCustomModulesResponse>
      listEffectiveSecurityHealthAnalyticsCustomModulesCallable() {
    return listEffectiveSecurityHealthAnalyticsCustomModulesCallable;
  }

  @Override
  public UnaryCallable<
          ListEffectiveSecurityHealthAnalyticsCustomModulesRequest,
          ListEffectiveSecurityHealthAnalyticsCustomModulesPagedResponse>
      listEffectiveSecurityHealthAnalyticsCustomModulesPagedCallable() {
    return listEffectiveSecurityHealthAnalyticsCustomModulesPagedCallable;
  }

  @Override
  public UnaryCallable<
          GetEffectiveSecurityHealthAnalyticsCustomModuleRequest,
          EffectiveSecurityHealthAnalyticsCustomModule>
      getEffectiveSecurityHealthAnalyticsCustomModuleCallable() {
    return getEffectiveSecurityHealthAnalyticsCustomModuleCallable;
  }

  @Override
  public UnaryCallable<
          ListSecurityHealthAnalyticsCustomModulesRequest,
          ListSecurityHealthAnalyticsCustomModulesResponse>
      listSecurityHealthAnalyticsCustomModulesCallable() {
    return listSecurityHealthAnalyticsCustomModulesCallable;
  }

  @Override
  public UnaryCallable<
          ListSecurityHealthAnalyticsCustomModulesRequest,
          ListSecurityHealthAnalyticsCustomModulesPagedResponse>
      listSecurityHealthAnalyticsCustomModulesPagedCallable() {
    return listSecurityHealthAnalyticsCustomModulesPagedCallable;
  }

  @Override
  public UnaryCallable<
          ListDescendantSecurityHealthAnalyticsCustomModulesRequest,
          ListDescendantSecurityHealthAnalyticsCustomModulesResponse>
      listDescendantSecurityHealthAnalyticsCustomModulesCallable() {
    return listDescendantSecurityHealthAnalyticsCustomModulesCallable;
  }

  @Override
  public UnaryCallable<
          ListDescendantSecurityHealthAnalyticsCustomModulesRequest,
          ListDescendantSecurityHealthAnalyticsCustomModulesPagedResponse>
      listDescendantSecurityHealthAnalyticsCustomModulesPagedCallable() {
    return listDescendantSecurityHealthAnalyticsCustomModulesPagedCallable;
  }

  @Override
  public UnaryCallable<
          GetSecurityHealthAnalyticsCustomModuleRequest, SecurityHealthAnalyticsCustomModule>
      getSecurityHealthAnalyticsCustomModuleCallable() {
    return getSecurityHealthAnalyticsCustomModuleCallable;
  }

  @Override
  public UnaryCallable<
          CreateSecurityHealthAnalyticsCustomModuleRequest, SecurityHealthAnalyticsCustomModule>
      createSecurityHealthAnalyticsCustomModuleCallable() {
    return createSecurityHealthAnalyticsCustomModuleCallable;
  }

  @Override
  public UnaryCallable<
          UpdateSecurityHealthAnalyticsCustomModuleRequest, SecurityHealthAnalyticsCustomModule>
      updateSecurityHealthAnalyticsCustomModuleCallable() {
    return updateSecurityHealthAnalyticsCustomModuleCallable;
  }

  @Override
  public UnaryCallable<DeleteSecurityHealthAnalyticsCustomModuleRequest, Empty>
      deleteSecurityHealthAnalyticsCustomModuleCallable() {
    return deleteSecurityHealthAnalyticsCustomModuleCallable;
  }

  @Override
  public UnaryCallable<
          SimulateSecurityHealthAnalyticsCustomModuleRequest,
          SimulateSecurityHealthAnalyticsCustomModuleResponse>
      simulateSecurityHealthAnalyticsCustomModuleCallable() {
    return simulateSecurityHealthAnalyticsCustomModuleCallable;
  }

  @Override
  public UnaryCallable<
          ListEffectiveEventThreatDetectionCustomModulesRequest,
          ListEffectiveEventThreatDetectionCustomModulesResponse>
      listEffectiveEventThreatDetectionCustomModulesCallable() {
    return listEffectiveEventThreatDetectionCustomModulesCallable;
  }

  @Override
  public UnaryCallable<
          ListEffectiveEventThreatDetectionCustomModulesRequest,
          ListEffectiveEventThreatDetectionCustomModulesPagedResponse>
      listEffectiveEventThreatDetectionCustomModulesPagedCallable() {
    return listEffectiveEventThreatDetectionCustomModulesPagedCallable;
  }

  @Override
  public UnaryCallable<
          GetEffectiveEventThreatDetectionCustomModuleRequest,
          EffectiveEventThreatDetectionCustomModule>
      getEffectiveEventThreatDetectionCustomModuleCallable() {
    return getEffectiveEventThreatDetectionCustomModuleCallable;
  }

  @Override
  public UnaryCallable<
          ListEventThreatDetectionCustomModulesRequest,
          ListEventThreatDetectionCustomModulesResponse>
      listEventThreatDetectionCustomModulesCallable() {
    return listEventThreatDetectionCustomModulesCallable;
  }

  @Override
  public UnaryCallable<
          ListEventThreatDetectionCustomModulesRequest,
          ListEventThreatDetectionCustomModulesPagedResponse>
      listEventThreatDetectionCustomModulesPagedCallable() {
    return listEventThreatDetectionCustomModulesPagedCallable;
  }

  @Override
  public UnaryCallable<
          ListDescendantEventThreatDetectionCustomModulesRequest,
          ListDescendantEventThreatDetectionCustomModulesResponse>
      listDescendantEventThreatDetectionCustomModulesCallable() {
    return listDescendantEventThreatDetectionCustomModulesCallable;
  }

  @Override
  public UnaryCallable<
          ListDescendantEventThreatDetectionCustomModulesRequest,
          ListDescendantEventThreatDetectionCustomModulesPagedResponse>
      listDescendantEventThreatDetectionCustomModulesPagedCallable() {
    return listDescendantEventThreatDetectionCustomModulesPagedCallable;
  }

  @Override
  public UnaryCallable<GetEventThreatDetectionCustomModuleRequest, EventThreatDetectionCustomModule>
      getEventThreatDetectionCustomModuleCallable() {
    return getEventThreatDetectionCustomModuleCallable;
  }

  @Override
  public UnaryCallable<
          CreateEventThreatDetectionCustomModuleRequest, EventThreatDetectionCustomModule>
      createEventThreatDetectionCustomModuleCallable() {
    return createEventThreatDetectionCustomModuleCallable;
  }

  @Override
  public UnaryCallable<
          UpdateEventThreatDetectionCustomModuleRequest, EventThreatDetectionCustomModule>
      updateEventThreatDetectionCustomModuleCallable() {
    return updateEventThreatDetectionCustomModuleCallable;
  }

  @Override
  public UnaryCallable<DeleteEventThreatDetectionCustomModuleRequest, Empty>
      deleteEventThreatDetectionCustomModuleCallable() {
    return deleteEventThreatDetectionCustomModuleCallable;
  }

  @Override
  public UnaryCallable<
          ValidateEventThreatDetectionCustomModuleRequest,
          ValidateEventThreatDetectionCustomModuleResponse>
      validateEventThreatDetectionCustomModuleCallable() {
    return validateEventThreatDetectionCustomModuleCallable;
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
