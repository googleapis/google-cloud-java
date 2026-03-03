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

package com.google.showcase.v1beta1.stub;

import static com.google.showcase.v1beta1.ComplianceClient.ListLocationsPagedResponse;

import com.google.api.core.BetaApi;
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
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.TypeRegistry;
import com.google.showcase.v1beta1.EnumRequest;
import com.google.showcase.v1beta1.EnumResponse;
import com.google.showcase.v1beta1.RepeatRequest;
import com.google.showcase.v1beta1.RepeatResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * REST stub implementation for the Compliance service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonComplianceStub extends ComplianceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<RepeatRequest, RepeatResponse>
      repeatDataBodyMethodDescriptor =
          ApiMethodDescriptor.<RepeatRequest, RepeatResponse>newBuilder()
              .setFullMethodName("google.showcase.v1beta1.Compliance/RepeatDataBody")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RepeatRequest>newBuilder()
                      .setPath(
                          "/v1beta1/repeat:body",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RepeatRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RepeatRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RepeatResponse>newBuilder()
                      .setDefaultInstance(RepeatResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RepeatRequest, RepeatResponse>
      repeatDataBodyInfoMethodDescriptor =
          ApiMethodDescriptor.<RepeatRequest, RepeatResponse>newBuilder()
              .setFullMethodName("google.showcase.v1beta1.Compliance/RepeatDataBodyInfo")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RepeatRequest>newBuilder()
                      .setPath(
                          "/v1beta1/repeat:bodyinfo",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RepeatRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RepeatRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "fDouble", request.getFDouble());
                            serializer.putQueryParam(fields, "fInt32", request.getFInt32());
                            serializer.putQueryParam(fields, "fInt64", request.getFInt64());
                            if (request.hasIntendedBindingUri()) {
                              serializer.putQueryParam(
                                  fields, "intendedBindingUri", request.getIntendedBindingUri());
                            }
                            serializer.putQueryParam(fields, "name", request.getName());
                            if (request.hasPDouble()) {
                              serializer.putQueryParam(fields, "pDouble", request.getPDouble());
                            }
                            if (request.hasPInt32()) {
                              serializer.putQueryParam(fields, "pInt32", request.getPInt32());
                            }
                            if (request.hasPInt64()) {
                              serializer.putQueryParam(fields, "pInt64", request.getPInt64());
                            }
                            serializer.putQueryParam(
                                fields, "serverVerify", request.getServerVerify());
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create().toBody("info", request.getInfo(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RepeatResponse>newBuilder()
                      .setDefaultInstance(RepeatResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RepeatRequest, RepeatResponse>
      repeatDataQueryMethodDescriptor =
          ApiMethodDescriptor.<RepeatRequest, RepeatResponse>newBuilder()
              .setFullMethodName("google.showcase.v1beta1.Compliance/RepeatDataQuery")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RepeatRequest>newBuilder()
                      .setPath(
                          "/v1beta1/repeat:query",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RepeatRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RepeatRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "fDouble", request.getFDouble());
                            serializer.putQueryParam(fields, "fInt32", request.getFInt32());
                            serializer.putQueryParam(fields, "fInt64", request.getFInt64());
                            serializer.putQueryParam(fields, "info", request.getInfo());
                            if (request.hasIntendedBindingUri()) {
                              serializer.putQueryParam(
                                  fields, "intendedBindingUri", request.getIntendedBindingUri());
                            }
                            serializer.putQueryParam(fields, "name", request.getName());
                            if (request.hasPDouble()) {
                              serializer.putQueryParam(fields, "pDouble", request.getPDouble());
                            }
                            if (request.hasPInt32()) {
                              serializer.putQueryParam(fields, "pInt32", request.getPInt32());
                            }
                            if (request.hasPInt64()) {
                              serializer.putQueryParam(fields, "pInt64", request.getPInt64());
                            }
                            serializer.putQueryParam(
                                fields, "serverVerify", request.getServerVerify());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RepeatResponse>newBuilder()
                      .setDefaultInstance(RepeatResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RepeatRequest, RepeatResponse>
      repeatDataSimplePathMethodDescriptor =
          ApiMethodDescriptor.<RepeatRequest, RepeatResponse>newBuilder()
              .setFullMethodName("google.showcase.v1beta1.Compliance/RepeatDataSimplePath")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RepeatRequest>newBuilder()
                      .setPath(
                          "/v1beta1/repeat/{info.fString}/{info.fInt32}/{info.fDouble}/{info.fBool}/{info.fKingdom}:simplepath",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RepeatRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "info.fBool", request.getInfo().getFBool());
                            serializer.putPathParam(
                                fields, "info.fDouble", request.getInfo().getFDouble());
                            serializer.putPathParam(
                                fields, "info.fInt32", request.getInfo().getFInt32());
                            serializer.putPathParam(
                                fields, "info.fKingdom", request.getInfo().getFKingdomValue());
                            serializer.putPathParam(
                                fields, "info.fString", request.getInfo().getFString());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RepeatRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "fDouble", request.getFDouble());
                            serializer.putQueryParam(fields, "fInt32", request.getFInt32());
                            serializer.putQueryParam(fields, "fInt64", request.getFInt64());
                            serializer.putQueryParam(fields, "info", request.getInfo());
                            if (request.hasIntendedBindingUri()) {
                              serializer.putQueryParam(
                                  fields, "intendedBindingUri", request.getIntendedBindingUri());
                            }
                            serializer.putQueryParam(fields, "name", request.getName());
                            if (request.hasPDouble()) {
                              serializer.putQueryParam(fields, "pDouble", request.getPDouble());
                            }
                            if (request.hasPInt32()) {
                              serializer.putQueryParam(fields, "pInt32", request.getPInt32());
                            }
                            if (request.hasPInt64()) {
                              serializer.putQueryParam(fields, "pInt64", request.getPInt64());
                            }
                            serializer.putQueryParam(
                                fields, "serverVerify", request.getServerVerify());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RepeatResponse>newBuilder()
                      .setDefaultInstance(RepeatResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RepeatRequest, RepeatResponse>
      repeatDataPathResourceMethodDescriptor =
          ApiMethodDescriptor.<RepeatRequest, RepeatResponse>newBuilder()
              .setFullMethodName("google.showcase.v1beta1.Compliance/RepeatDataPathResource")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RepeatRequest>newBuilder()
                      .setPath(
                          "/v1beta1/repeat/{info.fString=first/*}/{info.fChild.fString=second/*}/bool/{info.fBool}:pathresource",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RepeatRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields, "info.fBool", request.getInfo().getFBool());
                            serializer.putPathParam(
                                fields,
                                "info.fChild.fString",
                                request.getInfo().getFChild().getFString());
                            serializer.putPathParam(
                                fields, "info.fString", request.getInfo().getFString());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1beta1/repeat/{info.fChild.fString=first/*}/{info.fString=second/*}/bool/{info.fBool}:childfirstpathresource")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RepeatRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "fDouble", request.getFDouble());
                            serializer.putQueryParam(fields, "fInt32", request.getFInt32());
                            serializer.putQueryParam(fields, "fInt64", request.getFInt64());
                            serializer.putQueryParam(fields, "info", request.getInfo());
                            if (request.hasIntendedBindingUri()) {
                              serializer.putQueryParam(
                                  fields, "intendedBindingUri", request.getIntendedBindingUri());
                            }
                            serializer.putQueryParam(fields, "name", request.getName());
                            if (request.hasPDouble()) {
                              serializer.putQueryParam(fields, "pDouble", request.getPDouble());
                            }
                            if (request.hasPInt32()) {
                              serializer.putQueryParam(fields, "pInt32", request.getPInt32());
                            }
                            if (request.hasPInt64()) {
                              serializer.putQueryParam(fields, "pInt64", request.getPInt64());
                            }
                            serializer.putQueryParam(
                                fields, "serverVerify", request.getServerVerify());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RepeatResponse>newBuilder()
                      .setDefaultInstance(RepeatResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RepeatRequest, RepeatResponse>
      repeatDataPathTrailingResourceMethodDescriptor =
          ApiMethodDescriptor.<RepeatRequest, RepeatResponse>newBuilder()
              .setFullMethodName(
                  "google.showcase.v1beta1.Compliance/RepeatDataPathTrailingResource")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RepeatRequest>newBuilder()
                      .setPath(
                          "/v1beta1/repeat/{info.fString=first/*}/{info.fChild.fString=second/**}:pathtrailingresource",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RepeatRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(
                                fields,
                                "info.fChild.fString",
                                request.getInfo().getFChild().getFString());
                            serializer.putPathParam(
                                fields, "info.fString", request.getInfo().getFString());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RepeatRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putQueryParam(fields, "fDouble", request.getFDouble());
                            serializer.putQueryParam(fields, "fInt32", request.getFInt32());
                            serializer.putQueryParam(fields, "fInt64", request.getFInt64());
                            serializer.putQueryParam(fields, "info", request.getInfo());
                            if (request.hasIntendedBindingUri()) {
                              serializer.putQueryParam(
                                  fields, "intendedBindingUri", request.getIntendedBindingUri());
                            }
                            serializer.putQueryParam(fields, "name", request.getName());
                            if (request.hasPDouble()) {
                              serializer.putQueryParam(fields, "pDouble", request.getPDouble());
                            }
                            if (request.hasPInt32()) {
                              serializer.putQueryParam(fields, "pInt32", request.getPInt32());
                            }
                            if (request.hasPInt64()) {
                              serializer.putQueryParam(fields, "pInt64", request.getPInt64());
                            }
                            serializer.putQueryParam(
                                fields, "serverVerify", request.getServerVerify());
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RepeatResponse>newBuilder()
                      .setDefaultInstance(RepeatResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RepeatRequest, RepeatResponse>
      repeatDataBodyPutMethodDescriptor =
          ApiMethodDescriptor.<RepeatRequest, RepeatResponse>newBuilder()
              .setFullMethodName("google.showcase.v1beta1.Compliance/RepeatDataBodyPut")
              .setHttpMethod("PUT")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RepeatRequest>newBuilder()
                      .setPath(
                          "/v1beta1/repeat:bodyput",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RepeatRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RepeatRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RepeatResponse>newBuilder()
                      .setDefaultInstance(RepeatResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RepeatRequest, RepeatResponse>
      repeatDataBodyPatchMethodDescriptor =
          ApiMethodDescriptor.<RepeatRequest, RepeatResponse>newBuilder()
              .setFullMethodName("google.showcase.v1beta1.Compliance/RepeatDataBodyPatch")
              .setHttpMethod("PATCH")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RepeatRequest>newBuilder()
                      .setPath(
                          "/v1beta1/repeat:bodypatch",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<RepeatRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<RepeatRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<RepeatResponse>newBuilder()
                      .setDefaultInstance(RepeatResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<EnumRequest, EnumResponse> getEnumMethodDescriptor =
      ApiMethodDescriptor.<EnumRequest, EnumResponse>newBuilder()
          .setFullMethodName("google.showcase.v1beta1.Compliance/GetEnum")
          .setHttpMethod("GET")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<EnumRequest>newBuilder()
                  .setPath(
                      "/v1beta1/compliance/enum",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<EnumRequest> serializer = ProtoRestSerializer.create();
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<EnumRequest> serializer = ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "unknownEnum", request.getUnknownEnum());
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<EnumResponse>newBuilder()
                  .setDefaultInstance(EnumResponse.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<EnumResponse, EnumResponse> verifyEnumMethodDescriptor =
      ApiMethodDescriptor.<EnumResponse, EnumResponse>newBuilder()
          .setFullMethodName("google.showcase.v1beta1.Compliance/VerifyEnum")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<EnumResponse>newBuilder()
                  .setPath(
                      "/v1beta1/compliance/enum",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<EnumResponse> serializer = ProtoRestSerializer.create();
                        return fields;
                      })
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<EnumResponse> serializer = ProtoRestSerializer.create();
                        serializer.putQueryParam(fields, "continent", request.getContinentValue());
                        serializer.putQueryParam(fields, "request", request.getRequest());
                        return fields;
                      })
                  .setRequestBodyExtractor(request -> null)
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<EnumResponse>newBuilder()
                  .setDefaultInstance(EnumResponse.getDefaultInstance())
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
                          "/v1beta1/{name=projects/*}/locations",
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
                          "/v1beta1/{name=projects/*/locations/*}",
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

  private static final ApiMethodDescriptor<SetIamPolicyRequest, Policy>
      setIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.iam.v1.IAMPolicy/SetIamPolicy")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{resource=users/*}:setIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1beta1/{resource=rooms/*}:setIamPolicy",
                          "/v1beta1/{resource=rooms/*/blurbs/*}:setIamPolicy",
                          "/v1beta1/{resource=sequences/*}:setIamPolicy")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GetIamPolicyRequest, Policy>
      getIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicyRequest, Policy>newBuilder()
              .setFullMethodName("google.iam.v1.IAMPolicy/GetIamPolicy")
              .setHttpMethod("GET")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{resource=users/*}:getIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1beta1/{resource=rooms/*}:getIamPolicy",
                          "/v1beta1/{resource=rooms/*/blurbs/*}:getIamPolicy",
                          "/v1beta1/{resource=sequences/*}:getIamPolicy")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(request -> null)
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          ApiMethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setFullMethodName("google.iam.v1.IAMPolicy/TestIamPermissions")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TestIamPermissionsRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{resource=users/*}:testIamPermissions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1beta1/{resource=rooms/*}:testIamPermissions",
                          "/v1beta1/{resource=rooms/*/blurbs/*}:testIamPermissions",
                          "/v1beta1/{resource=sequences/*}:testIamPermissions")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearResource().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TestIamPermissionsResponse>newBuilder()
                      .setDefaultInstance(TestIamPermissionsResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private final UnaryCallable<RepeatRequest, RepeatResponse> repeatDataBodyCallable;
  private final UnaryCallable<RepeatRequest, RepeatResponse> repeatDataBodyInfoCallable;
  private final UnaryCallable<RepeatRequest, RepeatResponse> repeatDataQueryCallable;
  private final UnaryCallable<RepeatRequest, RepeatResponse> repeatDataSimplePathCallable;
  private final UnaryCallable<RepeatRequest, RepeatResponse> repeatDataPathResourceCallable;
  private final UnaryCallable<RepeatRequest, RepeatResponse> repeatDataPathTrailingResourceCallable;
  private final UnaryCallable<RepeatRequest, RepeatResponse> repeatDataBodyPutCallable;
  private final UnaryCallable<RepeatRequest, RepeatResponse> repeatDataBodyPatchCallable;
  private final UnaryCallable<EnumRequest, EnumResponse> getEnumCallable;
  private final UnaryCallable<EnumResponse, EnumResponse> verifyEnumCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable;
  private final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable;
  private final UnaryCallable<GetLocationRequest, Location> getLocationCallable;
  private final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable;

  private final BackgroundResource backgroundResources;
  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonComplianceStub create(ComplianceStubSettings settings)
      throws IOException {
    return new HttpJsonComplianceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonComplianceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonComplianceStub(
        ComplianceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonComplianceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonComplianceStub(
        ComplianceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonComplianceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonComplianceStub(ComplianceStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonComplianceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonComplianceStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonComplianceStub(
      ComplianceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<RepeatRequest, RepeatResponse> repeatDataBodyTransportSettings =
        HttpJsonCallSettings.<RepeatRequest, RepeatResponse>newBuilder()
            .setMethodDescriptor(repeatDataBodyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<RepeatRequest, RepeatResponse> repeatDataBodyInfoTransportSettings =
        HttpJsonCallSettings.<RepeatRequest, RepeatResponse>newBuilder()
            .setMethodDescriptor(repeatDataBodyInfoMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<RepeatRequest, RepeatResponse> repeatDataQueryTransportSettings =
        HttpJsonCallSettings.<RepeatRequest, RepeatResponse>newBuilder()
            .setMethodDescriptor(repeatDataQueryMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<RepeatRequest, RepeatResponse> repeatDataSimplePathTransportSettings =
        HttpJsonCallSettings.<RepeatRequest, RepeatResponse>newBuilder()
            .setMethodDescriptor(repeatDataSimplePathMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("info.f_bool", String.valueOf(request.getInfo().getFBool()));
                  builder.add("info.f_double", String.valueOf(request.getInfo().getFDouble()));
                  builder.add("info.f_int32", String.valueOf(request.getInfo().getFInt32()));
                  builder.add(
                      "info.f_kingdom", String.valueOf(request.getInfo().getFKingdomValue()));
                  builder.add("info.f_string", String.valueOf(request.getInfo().getFString()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<RepeatRequest, RepeatResponse> repeatDataPathResourceTransportSettings =
        HttpJsonCallSettings.<RepeatRequest, RepeatResponse>newBuilder()
            .setMethodDescriptor(repeatDataPathResourceMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("info.f_bool", String.valueOf(request.getInfo().getFBool()));
                  builder.add(
                      "info.f_child.f_string",
                      String.valueOf(request.getInfo().getFChild().getFString()));
                  builder.add("info.f_string", String.valueOf(request.getInfo().getFString()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<RepeatRequest, RepeatResponse>
        repeatDataPathTrailingResourceTransportSettings =
            HttpJsonCallSettings.<RepeatRequest, RepeatResponse>newBuilder()
                .setMethodDescriptor(repeatDataPathTrailingResourceMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add(
                          "info.f_child.f_string",
                          String.valueOf(request.getInfo().getFChild().getFString()));
                      builder.add("info.f_string", String.valueOf(request.getInfo().getFString()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<RepeatRequest, RepeatResponse> repeatDataBodyPutTransportSettings =
        HttpJsonCallSettings.<RepeatRequest, RepeatResponse>newBuilder()
            .setMethodDescriptor(repeatDataBodyPutMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<RepeatRequest, RepeatResponse> repeatDataBodyPatchTransportSettings =
        HttpJsonCallSettings.<RepeatRequest, RepeatResponse>newBuilder()
            .setMethodDescriptor(repeatDataBodyPatchMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<EnumRequest, EnumResponse> getEnumTransportSettings =
        HttpJsonCallSettings.<EnumRequest, EnumResponse>newBuilder()
            .setMethodDescriptor(getEnumMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .build();
    HttpJsonCallSettings<EnumResponse, EnumResponse> verifyEnumTransportSettings =
        HttpJsonCallSettings.<EnumResponse, EnumResponse>newBuilder()
            .setMethodDescriptor(verifyEnumMethodDescriptor)
            .setTypeRegistry(typeRegistry)
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
    HttpJsonCallSettings<SetIamPolicyRequest, Policy> setIamPolicyTransportSettings =
        HttpJsonCallSettings.<SetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GetIamPolicyRequest, Policy> getIamPolicyTransportSettings =
        HttpJsonCallSettings.<GetIamPolicyRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("resource", String.valueOf(request.getResource()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("resource", String.valueOf(request.getResource()));
                      return builder.build();
                    })
                .build();

    this.repeatDataBodyCallable =
        callableFactory.createUnaryCallable(
            repeatDataBodyTransportSettings, settings.repeatDataBodySettings(), clientContext);
    this.repeatDataBodyInfoCallable =
        callableFactory.createUnaryCallable(
            repeatDataBodyInfoTransportSettings,
            settings.repeatDataBodyInfoSettings(),
            clientContext);
    this.repeatDataQueryCallable =
        callableFactory.createUnaryCallable(
            repeatDataQueryTransportSettings, settings.repeatDataQuerySettings(), clientContext);
    this.repeatDataSimplePathCallable =
        callableFactory.createUnaryCallable(
            repeatDataSimplePathTransportSettings,
            settings.repeatDataSimplePathSettings(),
            clientContext);
    this.repeatDataPathResourceCallable =
        callableFactory.createUnaryCallable(
            repeatDataPathResourceTransportSettings,
            settings.repeatDataPathResourceSettings(),
            clientContext);
    this.repeatDataPathTrailingResourceCallable =
        callableFactory.createUnaryCallable(
            repeatDataPathTrailingResourceTransportSettings,
            settings.repeatDataPathTrailingResourceSettings(),
            clientContext);
    this.repeatDataBodyPutCallable =
        callableFactory.createUnaryCallable(
            repeatDataBodyPutTransportSettings,
            settings.repeatDataBodyPutSettings(),
            clientContext);
    this.repeatDataBodyPatchCallable =
        callableFactory.createUnaryCallable(
            repeatDataBodyPatchTransportSettings,
            settings.repeatDataBodyPatchSettings(),
            clientContext);
    this.getEnumCallable =
        callableFactory.createUnaryCallable(
            getEnumTransportSettings, settings.getEnumSettings(), clientContext);
    this.verifyEnumCallable =
        callableFactory.createUnaryCallable(
            verifyEnumTransportSettings, settings.verifyEnumSettings(), clientContext);
    this.listLocationsCallable =
        callableFactory.createUnaryCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.listLocationsPagedCallable =
        callableFactory.createPagedCallable(
            listLocationsTransportSettings, settings.listLocationsSettings(), clientContext);
    this.getLocationCallable =
        callableFactory.createUnaryCallable(
            getLocationTransportSettings, settings.getLocationSettings(), clientContext);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
            clientContext);

    this.backgroundResources =
        new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  @InternalApi
  public static List<ApiMethodDescriptor> getMethodDescriptors() {
    List<ApiMethodDescriptor> methodDescriptors = new ArrayList<>();
    methodDescriptors.add(repeatDataBodyMethodDescriptor);
    methodDescriptors.add(repeatDataBodyInfoMethodDescriptor);
    methodDescriptors.add(repeatDataQueryMethodDescriptor);
    methodDescriptors.add(repeatDataSimplePathMethodDescriptor);
    methodDescriptors.add(repeatDataPathResourceMethodDescriptor);
    methodDescriptors.add(repeatDataPathTrailingResourceMethodDescriptor);
    methodDescriptors.add(repeatDataBodyPutMethodDescriptor);
    methodDescriptors.add(repeatDataBodyPatchMethodDescriptor);
    methodDescriptors.add(getEnumMethodDescriptor);
    methodDescriptors.add(verifyEnumMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    methodDescriptors.add(setIamPolicyMethodDescriptor);
    methodDescriptors.add(getIamPolicyMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<RepeatRequest, RepeatResponse> repeatDataBodyCallable() {
    return repeatDataBodyCallable;
  }

  @Override
  public UnaryCallable<RepeatRequest, RepeatResponse> repeatDataBodyInfoCallable() {
    return repeatDataBodyInfoCallable;
  }

  @Override
  public UnaryCallable<RepeatRequest, RepeatResponse> repeatDataQueryCallable() {
    return repeatDataQueryCallable;
  }

  @Override
  public UnaryCallable<RepeatRequest, RepeatResponse> repeatDataSimplePathCallable() {
    return repeatDataSimplePathCallable;
  }

  @Override
  public UnaryCallable<RepeatRequest, RepeatResponse> repeatDataPathResourceCallable() {
    return repeatDataPathResourceCallable;
  }

  @Override
  public UnaryCallable<RepeatRequest, RepeatResponse> repeatDataPathTrailingResourceCallable() {
    return repeatDataPathTrailingResourceCallable;
  }

  @Override
  public UnaryCallable<RepeatRequest, RepeatResponse> repeatDataBodyPutCallable() {
    return repeatDataBodyPutCallable;
  }

  @Override
  public UnaryCallable<RepeatRequest, RepeatResponse> repeatDataBodyPatchCallable() {
    return repeatDataBodyPatchCallable;
  }

  @Override
  public UnaryCallable<EnumRequest, EnumResponse> getEnumCallable() {
    return getEnumCallable;
  }

  @Override
  public UnaryCallable<EnumResponse, EnumResponse> verifyEnumCallable() {
    return verifyEnumCallable;
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
  public UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  @Override
  public UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  @Override
  public UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
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
