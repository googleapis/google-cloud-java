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

package com.google.cloud.vertexai.v1beta1.stub;

import static com.google.cloud.vertexai.v1beta1.PredictionServiceClient.ListLocationsPagedResponse;

import com.google.api.HttpBody;
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
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.RequestParamsBuilder;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.vertexai.v1beta1.CountTokensRequest;
import com.google.cloud.vertexai.v1beta1.CountTokensResponse;
import com.google.cloud.vertexai.v1beta1.DirectPredictRequest;
import com.google.cloud.vertexai.v1beta1.DirectPredictResponse;
import com.google.cloud.vertexai.v1beta1.DirectRawPredictRequest;
import com.google.cloud.vertexai.v1beta1.DirectRawPredictResponse;
import com.google.cloud.vertexai.v1beta1.ExplainRequest;
import com.google.cloud.vertexai.v1beta1.ExplainResponse;
import com.google.cloud.vertexai.v1beta1.GenerateContentRequest;
import com.google.cloud.vertexai.v1beta1.GenerateContentResponse;
import com.google.cloud.vertexai.v1beta1.PredictRequest;
import com.google.cloud.vertexai.v1beta1.PredictResponse;
import com.google.cloud.vertexai.v1beta1.RawPredictRequest;
import com.google.cloud.vertexai.v1beta1.StreamingPredictRequest;
import com.google.cloud.vertexai.v1beta1.StreamingPredictResponse;
import com.google.cloud.vertexai.v1beta1.StreamingRawPredictRequest;
import com.google.cloud.vertexai.v1beta1.StreamingRawPredictResponse;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
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
 * REST stub implementation for the PredictionService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HttpJsonPredictionServiceStub extends PredictionServiceStub {
  private static final TypeRegistry typeRegistry = TypeRegistry.newBuilder().build();

  private static final ApiMethodDescriptor<PredictRequest, PredictResponse>
      predictMethodDescriptor =
          ApiMethodDescriptor.<PredictRequest, PredictResponse>newBuilder()
              .setFullMethodName("google.cloud.aiplatform.v1beta1.PredictionService/Predict")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<PredictRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{endpoint=projects/*/locations/*/endpoints/*}:predict",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<PredictRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "endpoint", request.getEndpoint());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1beta1/{endpoint=projects/*/locations/*/publishers/*/models/*}:predict")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<PredictRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearEndpoint().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<PredictResponse>newBuilder()
                      .setDefaultInstance(PredictResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<RawPredictRequest, HttpBody> rawPredictMethodDescriptor =
      ApiMethodDescriptor.<RawPredictRequest, HttpBody>newBuilder()
          .setFullMethodName("google.cloud.aiplatform.v1beta1.PredictionService/RawPredict")
          .setHttpMethod("POST")
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<RawPredictRequest>newBuilder()
                  .setPath(
                      "/v1beta1/{endpoint=projects/*/locations/*/endpoints/*}:rawPredict",
                      request -> {
                        Map<String, String> fields = new HashMap<>();
                        ProtoRestSerializer<RawPredictRequest> serializer =
                            ProtoRestSerializer.create();
                        serializer.putPathParam(fields, "endpoint", request.getEndpoint());
                        return fields;
                      })
                  .setAdditionalPaths(
                      "/v1beta1/{endpoint=projects/*/locations/*/publishers/*/models/*}:rawPredict")
                  .setQueryParamsExtractor(
                      request -> {
                        Map<String, List<String>> fields = new HashMap<>();
                        ProtoRestSerializer<RawPredictRequest> serializer =
                            ProtoRestSerializer.create();
                        return fields;
                      })
                  .setRequestBodyExtractor(
                      request ->
                          ProtoRestSerializer.create()
                              .toBody("*", request.toBuilder().clearEndpoint().build(), false))
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<HttpBody>newBuilder()
                  .setDefaultInstance(HttpBody.getDefaultInstance())
                  .setDefaultTypeRegistry(typeRegistry)
                  .build())
          .build();

  private static final ApiMethodDescriptor<DirectPredictRequest, DirectPredictResponse>
      directPredictMethodDescriptor =
          ApiMethodDescriptor.<DirectPredictRequest, DirectPredictResponse>newBuilder()
              .setFullMethodName("google.cloud.aiplatform.v1beta1.PredictionService/DirectPredict")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DirectPredictRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{endpoint=projects/*/locations/*/endpoints/*}:directPredict",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DirectPredictRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "endpoint", request.getEndpoint());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DirectPredictRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearEndpoint().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DirectPredictResponse>newBuilder()
                      .setDefaultInstance(DirectPredictResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<DirectRawPredictRequest, DirectRawPredictResponse>
      directRawPredictMethodDescriptor =
          ApiMethodDescriptor.<DirectRawPredictRequest, DirectRawPredictResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.PredictionService/DirectRawPredict")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DirectRawPredictRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{endpoint=projects/*/locations/*/endpoints/*}:directRawPredict",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<DirectRawPredictRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "endpoint", request.getEndpoint());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<DirectRawPredictRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearEndpoint().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<DirectRawPredictResponse>newBuilder()
                      .setDefaultInstance(DirectRawPredictResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<StreamingPredictRequest, StreamingPredictResponse>
      serverStreamingPredictMethodDescriptor =
          ApiMethodDescriptor.<StreamingPredictRequest, StreamingPredictResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.PredictionService/ServerStreamingPredict")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.SERVER_STREAMING)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<StreamingPredictRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{endpoint=projects/*/locations/*/endpoints/*}:serverStreamingPredict",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<StreamingPredictRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "endpoint", request.getEndpoint());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1beta1/{endpoint=projects/*/locations/*/publishers/*/models/*}:serverStreamingPredict")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<StreamingPredictRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearEndpoint().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<StreamingPredictResponse>newBuilder()
                      .setDefaultInstance(StreamingPredictResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<ExplainRequest, ExplainResponse>
      explainMethodDescriptor =
          ApiMethodDescriptor.<ExplainRequest, ExplainResponse>newBuilder()
              .setFullMethodName("google.cloud.aiplatform.v1beta1.PredictionService/Explain")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ExplainRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{endpoint=projects/*/locations/*/endpoints/*}:explain",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ExplainRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "endpoint", request.getEndpoint());
                            return fields;
                          })
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<ExplainRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearEndpoint().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<ExplainResponse>newBuilder()
                      .setDefaultInstance(ExplainResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<CountTokensRequest, CountTokensResponse>
      countTokensMethodDescriptor =
          ApiMethodDescriptor.<CountTokensRequest, CountTokensResponse>newBuilder()
              .setFullMethodName("google.cloud.aiplatform.v1beta1.PredictionService/CountTokens")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CountTokensRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{endpoint=projects/*/locations/*/endpoints/*}:countTokens",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<CountTokensRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "endpoint", request.getEndpoint());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1beta1/{endpoint=projects/*/locations/*/publishers/*/models/*}:countTokens")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<CountTokensRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearEndpoint().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<CountTokensResponse>newBuilder()
                      .setDefaultInstance(CountTokensResponse.getDefaultInstance())
                      .setDefaultTypeRegistry(typeRegistry)
                      .build())
              .build();

  private static final ApiMethodDescriptor<GenerateContentRequest, GenerateContentResponse>
      streamGenerateContentMethodDescriptor =
          ApiMethodDescriptor.<GenerateContentRequest, GenerateContentResponse>newBuilder()
              .setFullMethodName(
                  "google.cloud.aiplatform.v1beta1.PredictionService/StreamGenerateContent")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.SERVER_STREAMING)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GenerateContentRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{model=projects/*/locations/*/endpoints/*}:streamGenerateContent",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateContentRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "model", request.getModel());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1beta1/{model=projects/*/locations/*/publishers/*/models/*}:streamGenerateContent")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GenerateContentRequest> serializer =
                                ProtoRestSerializer.create();
                            return fields;
                          })
                      .setRequestBodyExtractor(
                          request ->
                              ProtoRestSerializer.create()
                                  .toBody("*", request.toBuilder().clearModel().build(), false))
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<GenerateContentResponse>newBuilder()
                      .setDefaultInstance(GenerateContentResponse.getDefaultInstance())
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
                          "/ui/{name=projects/*}/locations",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<ListLocationsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths("/v1beta1/{name=projects/*}/locations")
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
                          "/ui/{name=projects/*/locations/*}",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetLocationRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "name", request.getName());
                            return fields;
                          })
                      .setAdditionalPaths("/v1beta1/{name=projects/*/locations/*}")
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
                          "/v1beta1/{resource=projects/*/locations/*/featurestores/*}:setIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<SetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1beta1/{resource=projects/*/locations/*/featurestores/*/entityTypes/*}:setIamPolicy",
                          "/v1beta1/{resource=projects/*/locations/*/models/*}:setIamPolicy",
                          "/v1beta1/{resource=projects/*/locations/*/endpoints/*}:setIamPolicy",
                          "/v1beta1/{resource=projects/*/locations/*/notebookRuntimeTemplates/*}:setIamPolicy",
                          "/ui/{resource=projects/*/locations/*/featurestores/*}:setIamPolicy",
                          "/ui/{resource=projects/*/locations/*/featurestores/*/entityTypes/*}:setIamPolicy",
                          "/ui/{resource=projects/*/locations/*/models/*}:setIamPolicy",
                          "/ui/{resource=projects/*/locations/*/endpoints/*}:setIamPolicy",
                          "/ui/{resource=projects/*/locations/*/notebookRuntimeTemplates/*}:setIamPolicy")
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
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIamPolicyRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{resource=projects/*/locations/*/featurestores/*}:getIamPolicy",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1beta1/{resource=projects/*/locations/*/featurestores/*/entityTypes/*}:getIamPolicy",
                          "/v1beta1/{resource=projects/*/locations/*/models/*}:getIamPolicy",
                          "/v1beta1/{resource=projects/*/locations/*/endpoints/*}:getIamPolicy",
                          "/v1beta1/{resource=projects/*/locations/*/notebookRuntimeTemplates/*}:getIamPolicy",
                          "/ui/{resource=projects/*/locations/*/featurestores/*}:getIamPolicy",
                          "/ui/{resource=projects/*/locations/*/featurestores/*/entityTypes/*}:getIamPolicy",
                          "/ui/{resource=projects/*/locations/*/models/*}:getIamPolicy",
                          "/ui/{resource=projects/*/locations/*/endpoints/*}:getIamPolicy",
                          "/ui/{resource=projects/*/locations/*/notebookRuntimeTemplates/*}:getIamPolicy")
                      .setQueryParamsExtractor(
                          request -> {
                            Map<String, List<String>> fields = new HashMap<>();
                            ProtoRestSerializer<GetIamPolicyRequest> serializer =
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

  private static final ApiMethodDescriptor<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          ApiMethodDescriptor.<TestIamPermissionsRequest, TestIamPermissionsResponse>newBuilder()
              .setFullMethodName("google.iam.v1.IAMPolicy/TestIamPermissions")
              .setHttpMethod("POST")
              .setType(ApiMethodDescriptor.MethodType.UNARY)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TestIamPermissionsRequest>newBuilder()
                      .setPath(
                          "/v1beta1/{resource=projects/*/locations/*/featurestores/*}:testIamPermissions",
                          request -> {
                            Map<String, String> fields = new HashMap<>();
                            ProtoRestSerializer<TestIamPermissionsRequest> serializer =
                                ProtoRestSerializer.create();
                            serializer.putPathParam(fields, "resource", request.getResource());
                            return fields;
                          })
                      .setAdditionalPaths(
                          "/v1beta1/{resource=projects/*/locations/*/featurestores/*/entityTypes/*}:testIamPermissions",
                          "/v1beta1/{resource=projects/*/locations/*/models/*}:testIamPermissions",
                          "/v1beta1/{resource=projects/*/locations/*/endpoints/*}:testIamPermissions",
                          "/v1beta1/{resource=projects/*/locations/*/notebookRuntimeTemplates/*}:testIamPermissions",
                          "/ui/{resource=projects/*/locations/*/featurestores/*}:testIamPermissions",
                          "/ui/{resource=projects/*/locations/*/featurestores/*/entityTypes/*}:testIamPermissions",
                          "/ui/{resource=projects/*/locations/*/models/*}:testIamPermissions",
                          "/ui/{resource=projects/*/locations/*/endpoints/*}:testIamPermissions",
                          "/ui/{resource=projects/*/locations/*/notebookRuntimeTemplates/*}:testIamPermissions")
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

  private final UnaryCallable<PredictRequest, PredictResponse> predictCallable;
  private final UnaryCallable<RawPredictRequest, HttpBody> rawPredictCallable;
  private final UnaryCallable<DirectPredictRequest, DirectPredictResponse> directPredictCallable;
  private final UnaryCallable<DirectRawPredictRequest, DirectRawPredictResponse>
      directRawPredictCallable;
  private final ServerStreamingCallable<StreamingPredictRequest, StreamingPredictResponse>
      serverStreamingPredictCallable;
  private final UnaryCallable<ExplainRequest, ExplainResponse> explainCallable;
  private final UnaryCallable<CountTokensRequest, CountTokensResponse> countTokensCallable;
  private final ServerStreamingCallable<GenerateContentRequest, GenerateContentResponse>
      streamGenerateContentCallable;
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

  public static final HttpJsonPredictionServiceStub create(PredictionServiceStubSettings settings)
      throws IOException {
    return new HttpJsonPredictionServiceStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonPredictionServiceStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonPredictionServiceStub(
        PredictionServiceStubSettings.newHttpJsonBuilder().build(), clientContext);
  }

  public static final HttpJsonPredictionServiceStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonPredictionServiceStub(
        PredictionServiceStubSettings.newHttpJsonBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonPredictionServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonPredictionServiceStub(
      PredictionServiceStubSettings settings, ClientContext clientContext) throws IOException {
    this(settings, clientContext, new HttpJsonPredictionServiceCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonPredictionServiceStub, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HttpJsonPredictionServiceStub(
      PredictionServiceStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<PredictRequest, PredictResponse> predictTransportSettings =
        HttpJsonCallSettings.<PredictRequest, PredictResponse>newBuilder()
            .setMethodDescriptor(predictMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("endpoint", String.valueOf(request.getEndpoint()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<RawPredictRequest, HttpBody> rawPredictTransportSettings =
        HttpJsonCallSettings.<RawPredictRequest, HttpBody>newBuilder()
            .setMethodDescriptor(rawPredictMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("endpoint", String.valueOf(request.getEndpoint()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<DirectPredictRequest, DirectPredictResponse>
        directPredictTransportSettings =
            HttpJsonCallSettings.<DirectPredictRequest, DirectPredictResponse>newBuilder()
                .setMethodDescriptor(directPredictMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("endpoint", String.valueOf(request.getEndpoint()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<DirectRawPredictRequest, DirectRawPredictResponse>
        directRawPredictTransportSettings =
            HttpJsonCallSettings.<DirectRawPredictRequest, DirectRawPredictResponse>newBuilder()
                .setMethodDescriptor(directRawPredictMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("endpoint", String.valueOf(request.getEndpoint()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<StreamingPredictRequest, StreamingPredictResponse>
        serverStreamingPredictTransportSettings =
            HttpJsonCallSettings.<StreamingPredictRequest, StreamingPredictResponse>newBuilder()
                .setMethodDescriptor(serverStreamingPredictMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("endpoint", String.valueOf(request.getEndpoint()));
                      return builder.build();
                    })
                .build();
    HttpJsonCallSettings<ExplainRequest, ExplainResponse> explainTransportSettings =
        HttpJsonCallSettings.<ExplainRequest, ExplainResponse>newBuilder()
            .setMethodDescriptor(explainMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("endpoint", String.valueOf(request.getEndpoint()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<CountTokensRequest, CountTokensResponse> countTokensTransportSettings =
        HttpJsonCallSettings.<CountTokensRequest, CountTokensResponse>newBuilder()
            .setMethodDescriptor(countTokensMethodDescriptor)
            .setTypeRegistry(typeRegistry)
            .setParamsExtractor(
                request -> {
                  RequestParamsBuilder builder = RequestParamsBuilder.create();
                  builder.add("endpoint", String.valueOf(request.getEndpoint()));
                  return builder.build();
                })
            .build();
    HttpJsonCallSettings<GenerateContentRequest, GenerateContentResponse>
        streamGenerateContentTransportSettings =
            HttpJsonCallSettings.<GenerateContentRequest, GenerateContentResponse>newBuilder()
                .setMethodDescriptor(streamGenerateContentMethodDescriptor)
                .setTypeRegistry(typeRegistry)
                .setParamsExtractor(
                    request -> {
                      RequestParamsBuilder builder = RequestParamsBuilder.create();
                      builder.add("model", String.valueOf(request.getModel()));
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

    this.predictCallable =
        callableFactory.createUnaryCallable(
            predictTransportSettings, settings.predictSettings(), clientContext);
    this.rawPredictCallable =
        callableFactory.createUnaryCallable(
            rawPredictTransportSettings, settings.rawPredictSettings(), clientContext);
    this.directPredictCallable =
        callableFactory.createUnaryCallable(
            directPredictTransportSettings, settings.directPredictSettings(), clientContext);
    this.directRawPredictCallable =
        callableFactory.createUnaryCallable(
            directRawPredictTransportSettings, settings.directRawPredictSettings(), clientContext);
    this.serverStreamingPredictCallable =
        callableFactory.createServerStreamingCallable(
            serverStreamingPredictTransportSettings,
            settings.serverStreamingPredictSettings(),
            clientContext);
    this.explainCallable =
        callableFactory.createUnaryCallable(
            explainTransportSettings, settings.explainSettings(), clientContext);
    this.countTokensCallable =
        callableFactory.createUnaryCallable(
            countTokensTransportSettings, settings.countTokensSettings(), clientContext);
    this.streamGenerateContentCallable =
        callableFactory.createServerStreamingCallable(
            streamGenerateContentTransportSettings,
            settings.streamGenerateContentSettings(),
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
    methodDescriptors.add(predictMethodDescriptor);
    methodDescriptors.add(rawPredictMethodDescriptor);
    methodDescriptors.add(directPredictMethodDescriptor);
    methodDescriptors.add(directRawPredictMethodDescriptor);
    methodDescriptors.add(serverStreamingPredictMethodDescriptor);
    methodDescriptors.add(explainMethodDescriptor);
    methodDescriptors.add(countTokensMethodDescriptor);
    methodDescriptors.add(streamGenerateContentMethodDescriptor);
    methodDescriptors.add(listLocationsMethodDescriptor);
    methodDescriptors.add(getLocationMethodDescriptor);
    methodDescriptors.add(setIamPolicyMethodDescriptor);
    methodDescriptors.add(getIamPolicyMethodDescriptor);
    methodDescriptors.add(testIamPermissionsMethodDescriptor);
    return methodDescriptors;
  }

  @Override
  public UnaryCallable<PredictRequest, PredictResponse> predictCallable() {
    return predictCallable;
  }

  @Override
  public UnaryCallable<RawPredictRequest, HttpBody> rawPredictCallable() {
    return rawPredictCallable;
  }

  @Override
  public UnaryCallable<DirectPredictRequest, DirectPredictResponse> directPredictCallable() {
    return directPredictCallable;
  }

  @Override
  public UnaryCallable<DirectRawPredictRequest, DirectRawPredictResponse>
      directRawPredictCallable() {
    return directRawPredictCallable;
  }

  @Override
  public ServerStreamingCallable<StreamingPredictRequest, StreamingPredictResponse>
      serverStreamingPredictCallable() {
    return serverStreamingPredictCallable;
  }

  @Override
  public UnaryCallable<ExplainRequest, ExplainResponse> explainCallable() {
    return explainCallable;
  }

  @Override
  public UnaryCallable<CountTokensRequest, CountTokensResponse> countTokensCallable() {
    return countTokensCallable;
  }

  @Override
  public ServerStreamingCallable<GenerateContentRequest, GenerateContentResponse>
      streamGenerateContentCallable() {
    return streamGenerateContentCallable;
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
  public BidiStreamingCallable<StreamingPredictRequest, StreamingPredictResponse>
      streamingPredictCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: streamingPredictCallable(). REST transport is not implemented for this method yet.");
  }

  @Override
  public BidiStreamingCallable<StreamingRawPredictRequest, StreamingRawPredictResponse>
      streamingRawPredictCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: streamingRawPredictCallable(). REST transport is not implemented for this method yet.");
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
