/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.RegionDisksClient.ListPagedResponse;

import com.google.api.client.http.HttpMethods;
import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.httpjson.ApiMethodDescriptor;
import com.google.api.gax.httpjson.FieldsExtractor;
import com.google.api.gax.httpjson.HttpJsonCallSettings;
import com.google.api.gax.httpjson.HttpJsonStubCallableFactory;
import com.google.api.gax.httpjson.ProtoMessageRequestFormatter;
import com.google.api.gax.httpjson.ProtoMessageResponseParser;
import com.google.api.gax.httpjson.ProtoRestSerializer;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AddResourcePoliciesRegionDiskRequest;
import com.google.cloud.compute.v1.CreateSnapshotRegionDiskRequest;
import com.google.cloud.compute.v1.DeleteRegionDiskRequest;
import com.google.cloud.compute.v1.Disk;
import com.google.cloud.compute.v1.DiskList;
import com.google.cloud.compute.v1.GetIamPolicyRegionDiskRequest;
import com.google.cloud.compute.v1.GetRegionDiskRequest;
import com.google.cloud.compute.v1.InsertRegionDiskRequest;
import com.google.cloud.compute.v1.ListRegionDisksRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.RemoveResourcePoliciesRegionDiskRequest;
import com.google.cloud.compute.v1.ResizeRegionDiskRequest;
import com.google.cloud.compute.v1.SetIamPolicyRegionDiskRequest;
import com.google.cloud.compute.v1.SetLabelsRegionDiskRequest;
import com.google.cloud.compute.v1.TestIamPermissionsRegionDiskRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * REST stub implementation for Google Compute Engine API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator")
@BetaApi("A restructuring of stub classes is planned, so this may break in the future")
public class HttpJsonRegionDisksStub extends RegionDisksStub {

  @InternalApi
  public static final ApiMethodDescriptor<AddResourcePoliciesRegionDiskRequest, Operation>
      addResourcePoliciesMethodDescriptor =
          ApiMethodDescriptor.<AddResourcePoliciesRegionDiskRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionDisks.AddResourcePolicies")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<AddResourcePoliciesRegionDiskRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/disks/{disk}/addResourcePolicies",
                          new FieldsExtractor<
                              AddResourcePoliciesRegionDiskRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                AddResourcePoliciesRegionDiskRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<AddResourcePoliciesRegionDiskRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(fields, "disk", request.getDisk());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              AddResourcePoliciesRegionDiskRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                AddResourcePoliciesRegionDiskRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<AddResourcePoliciesRegionDiskRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<AddResourcePoliciesRegionDiskRequest, String>() {
                            @Override
                            public String extract(AddResourcePoliciesRegionDiskRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "regionDisksAddResourcePoliciesRequestResource",
                                      request.getRegionDisksAddResourcePoliciesRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<CreateSnapshotRegionDiskRequest, Operation>
      createSnapshotMethodDescriptor =
          ApiMethodDescriptor.<CreateSnapshotRegionDiskRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionDisks.CreateSnapshot")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<CreateSnapshotRegionDiskRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/disks/{disk}/createSnapshot",
                          new FieldsExtractor<
                              CreateSnapshotRegionDiskRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                CreateSnapshotRegionDiskRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<CreateSnapshotRegionDiskRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(fields, "disk", request.getDisk());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              CreateSnapshotRegionDiskRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                CreateSnapshotRegionDiskRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<CreateSnapshotRegionDiskRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<CreateSnapshotRegionDiskRequest, String>() {
                            @Override
                            public String extract(CreateSnapshotRegionDiskRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody("snapshotResource", request.getSnapshotResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<DeleteRegionDiskRequest, Operation>
      deleteMethodDescriptor =
          ApiMethodDescriptor.<DeleteRegionDiskRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionDisks.Delete")
              .setHttpMethod(HttpMethods.DELETE)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<DeleteRegionDiskRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/disks/{disk}",
                          new FieldsExtractor<DeleteRegionDiskRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(DeleteRegionDiskRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteRegionDiskRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(fields, "disk", request.getDisk());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              DeleteRegionDiskRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                DeleteRegionDiskRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<DeleteRegionDiskRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<DeleteRegionDiskRequest, String>() {
                            @Override
                            public String extract(DeleteRegionDiskRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetRegionDiskRequest, Disk> getMethodDescriptor =
      ApiMethodDescriptor.<GetRegionDiskRequest, Disk>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.RegionDisks.Get")
          .setHttpMethod(HttpMethods.GET)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<GetRegionDiskRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/regions/{region}/disks/{disk}",
                      new FieldsExtractor<GetRegionDiskRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(GetRegionDiskRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<GetRegionDiskRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "project", request.getProject());
                          serializer.putPathParam(fields, "region", request.getRegion());
                          serializer.putPathParam(fields, "disk", request.getDisk());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<GetRegionDiskRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(GetRegionDiskRequest request) {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<GetRegionDiskRequest> serializer =
                              ProtoRestSerializer.create();

                          return fields;
                        }
                      })
                  .setRequestBodyExtractor(
                      new FieldsExtractor<GetRegionDiskRequest, String>() {
                        @Override
                        public String extract(GetRegionDiskRequest request) {
                          return "";
                        }
                      })
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<Disk>newBuilder()
                  .setDefaultInstance(Disk.getDefaultInstance())
                  .build())
          .build();

  @InternalApi
  public static final ApiMethodDescriptor<GetIamPolicyRegionDiskRequest, Policy>
      getIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<GetIamPolicyRegionDiskRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionDisks.GetIamPolicy")
              .setHttpMethod(HttpMethods.GET)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<GetIamPolicyRegionDiskRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/disks/{resource}/getIamPolicy",
                          new FieldsExtractor<
                              GetIamPolicyRegionDiskRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                GetIamPolicyRegionDiskRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<GetIamPolicyRegionDiskRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(fields, "resource", request.getResource());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              GetIamPolicyRegionDiskRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                GetIamPolicyRegionDiskRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<GetIamPolicyRegionDiskRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasOptionsRequestedPolicyVersion()) {
                                serializer.putQueryParam(
                                    fields,
                                    "optionsRequestedPolicyVersion",
                                    request.getOptionsRequestedPolicyVersion());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<GetIamPolicyRegionDiskRequest, String>() {
                            @Override
                            public String extract(GetIamPolicyRegionDiskRequest request) {
                              return "";
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<InsertRegionDiskRequest, Operation>
      insertMethodDescriptor =
          ApiMethodDescriptor.<InsertRegionDiskRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionDisks.Insert")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<InsertRegionDiskRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/disks",
                          new FieldsExtractor<InsertRegionDiskRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(InsertRegionDiskRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<InsertRegionDiskRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              InsertRegionDiskRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                InsertRegionDiskRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<InsertRegionDiskRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              if (request.hasSourceImage()) {
                                serializer.putQueryParam(
                                    fields, "sourceImage", request.getSourceImage());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<InsertRegionDiskRequest, String>() {
                            @Override
                            public String extract(InsertRegionDiskRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody("diskResource", request.getDiskResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<ListRegionDisksRequest, DiskList> listMethodDescriptor =
      ApiMethodDescriptor.<ListRegionDisksRequest, DiskList>newBuilder()
          .setFullMethodName("google.cloud.compute.v1.RegionDisks.List")
          .setHttpMethod(HttpMethods.GET)
          .setRequestFormatter(
              ProtoMessageRequestFormatter.<ListRegionDisksRequest>newBuilder()
                  .setPath(
                      "/compute/v1/projects/{project}/regions/{region}/disks",
                      new FieldsExtractor<ListRegionDisksRequest, Map<String, String>>() {
                        @Override
                        public Map<String, String> extract(ListRegionDisksRequest request) {
                          Map<String, String> fields = new HashMap<>();
                          ProtoRestSerializer<ListRegionDisksRequest> serializer =
                              ProtoRestSerializer.create();
                          serializer.putPathParam(fields, "project", request.getProject());
                          serializer.putPathParam(fields, "region", request.getRegion());
                          return fields;
                        }
                      })
                  .setQueryParamsExtractor(
                      new FieldsExtractor<ListRegionDisksRequest, Map<String, List<String>>>() {
                        @Override
                        public Map<String, List<String>> extract(ListRegionDisksRequest request) {
                          Map<String, List<String>> fields = new HashMap<>();
                          ProtoRestSerializer<ListRegionDisksRequest> serializer =
                              ProtoRestSerializer.create();
                          if (request.hasFilter()) {
                            serializer.putQueryParam(fields, "filter", request.getFilter());
                          }
                          if (request.hasMaxResults()) {
                            serializer.putQueryParam(fields, "maxResults", request.getMaxResults());
                          }
                          if (request.hasOrderBy()) {
                            serializer.putQueryParam(fields, "orderBy", request.getOrderBy());
                          }
                          if (request.hasPageToken()) {
                            serializer.putQueryParam(fields, "pageToken", request.getPageToken());
                          }
                          if (request.hasReturnPartialSuccess()) {
                            serializer.putQueryParam(
                                fields, "returnPartialSuccess", request.getReturnPartialSuccess());
                          }
                          return fields;
                        }
                      })
                  .setRequestBodyExtractor(
                      new FieldsExtractor<ListRegionDisksRequest, String>() {
                        @Override
                        public String extract(ListRegionDisksRequest request) {
                          return "";
                        }
                      })
                  .build())
          .setResponseParser(
              ProtoMessageResponseParser.<DiskList>newBuilder()
                  .setDefaultInstance(DiskList.getDefaultInstance())
                  .build())
          .build();

  @InternalApi
  public static final ApiMethodDescriptor<RemoveResourcePoliciesRegionDiskRequest, Operation>
      removeResourcePoliciesMethodDescriptor =
          ApiMethodDescriptor.<RemoveResourcePoliciesRegionDiskRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionDisks.RemoveResourcePolicies")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<RemoveResourcePoliciesRegionDiskRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/disks/{disk}/removeResourcePolicies",
                          new FieldsExtractor<
                              RemoveResourcePoliciesRegionDiskRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                RemoveResourcePoliciesRegionDiskRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<RemoveResourcePoliciesRegionDiskRequest>
                                  serializer = ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(fields, "disk", request.getDisk());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              RemoveResourcePoliciesRegionDiskRequest,
                              Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                RemoveResourcePoliciesRegionDiskRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<RemoveResourcePoliciesRegionDiskRequest>
                                  serializer = ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<RemoveResourcePoliciesRegionDiskRequest, String>() {
                            @Override
                            public String extract(RemoveResourcePoliciesRegionDiskRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "regionDisksRemoveResourcePoliciesRequestResource",
                                      request
                                          .getRegionDisksRemoveResourcePoliciesRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<ResizeRegionDiskRequest, Operation>
      resizeMethodDescriptor =
          ApiMethodDescriptor.<ResizeRegionDiskRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionDisks.Resize")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<ResizeRegionDiskRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/disks/{disk}/resize",
                          new FieldsExtractor<ResizeRegionDiskRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(ResizeRegionDiskRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<ResizeRegionDiskRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(fields, "disk", request.getDisk());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              ResizeRegionDiskRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                ResizeRegionDiskRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<ResizeRegionDiskRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<ResizeRegionDiskRequest, String>() {
                            @Override
                            public String extract(ResizeRegionDiskRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "regionDisksResizeRequestResource",
                                      request.getRegionDisksResizeRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetIamPolicyRegionDiskRequest, Policy>
      setIamPolicyMethodDescriptor =
          ApiMethodDescriptor.<SetIamPolicyRegionDiskRequest, Policy>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionDisks.SetIamPolicy")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetIamPolicyRegionDiskRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/disks/{resource}/setIamPolicy",
                          new FieldsExtractor<
                              SetIamPolicyRegionDiskRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                SetIamPolicyRegionDiskRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<SetIamPolicyRegionDiskRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(fields, "resource", request.getResource());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              SetIamPolicyRegionDiskRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                SetIamPolicyRegionDiskRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<SetIamPolicyRegionDiskRequest> serializer =
                                  ProtoRestSerializer.create();

                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<SetIamPolicyRegionDiskRequest, String>() {
                            @Override
                            public String extract(SetIamPolicyRegionDiskRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "regionSetPolicyRequestResource",
                                      request.getRegionSetPolicyRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Policy>newBuilder()
                      .setDefaultInstance(Policy.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<SetLabelsRegionDiskRequest, Operation>
      setLabelsMethodDescriptor =
          ApiMethodDescriptor.<SetLabelsRegionDiskRequest, Operation>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionDisks.SetLabels")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<SetLabelsRegionDiskRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/disks/{resource}/setLabels",
                          new FieldsExtractor<SetLabelsRegionDiskRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(SetLabelsRegionDiskRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<SetLabelsRegionDiskRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(fields, "resource", request.getResource());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              SetLabelsRegionDiskRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                SetLabelsRegionDiskRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<SetLabelsRegionDiskRequest> serializer =
                                  ProtoRestSerializer.create();
                              if (request.hasRequestId()) {
                                serializer.putQueryParam(
                                    fields, "requestId", request.getRequestId());
                              }
                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<SetLabelsRegionDiskRequest, String>() {
                            @Override
                            public String extract(SetLabelsRegionDiskRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "regionSetLabelsRequestResource",
                                      request.getRegionSetLabelsRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<Operation>newBuilder()
                      .setDefaultInstance(Operation.getDefaultInstance())
                      .build())
              .build();

  @InternalApi
  public static final ApiMethodDescriptor<
          TestIamPermissionsRegionDiskRequest, TestPermissionsResponse>
      testIamPermissionsMethodDescriptor =
          ApiMethodDescriptor
              .<TestIamPermissionsRegionDiskRequest, TestPermissionsResponse>newBuilder()
              .setFullMethodName("google.cloud.compute.v1.RegionDisks.TestIamPermissions")
              .setHttpMethod(HttpMethods.POST)
              .setRequestFormatter(
                  ProtoMessageRequestFormatter.<TestIamPermissionsRegionDiskRequest>newBuilder()
                      .setPath(
                          "/compute/v1/projects/{project}/regions/{region}/disks/{resource}/testIamPermissions",
                          new FieldsExtractor<
                              TestIamPermissionsRegionDiskRequest, Map<String, String>>() {
                            @Override
                            public Map<String, String> extract(
                                TestIamPermissionsRegionDiskRequest request) {
                              Map<String, String> fields = new HashMap<>();
                              ProtoRestSerializer<TestIamPermissionsRegionDiskRequest> serializer =
                                  ProtoRestSerializer.create();
                              serializer.putPathParam(fields, "project", request.getProject());
                              serializer.putPathParam(fields, "region", request.getRegion());
                              serializer.putPathParam(fields, "resource", request.getResource());
                              return fields;
                            }
                          })
                      .setQueryParamsExtractor(
                          new FieldsExtractor<
                              TestIamPermissionsRegionDiskRequest, Map<String, List<String>>>() {
                            @Override
                            public Map<String, List<String>> extract(
                                TestIamPermissionsRegionDiskRequest request) {
                              Map<String, List<String>> fields = new HashMap<>();
                              ProtoRestSerializer<TestIamPermissionsRegionDiskRequest> serializer =
                                  ProtoRestSerializer.create();

                              return fields;
                            }
                          })
                      .setRequestBodyExtractor(
                          new FieldsExtractor<TestIamPermissionsRegionDiskRequest, String>() {
                            @Override
                            public String extract(TestIamPermissionsRegionDiskRequest request) {
                              return ProtoRestSerializer.create()
                                  .toBody(
                                      "testPermissionsRequestResource",
                                      request.getTestPermissionsRequestResource());
                            }
                          })
                      .build())
              .setResponseParser(
                  ProtoMessageResponseParser.<TestPermissionsResponse>newBuilder()
                      .setDefaultInstance(TestPermissionsResponse.getDefaultInstance())
                      .build())
              .build();

  private final BackgroundResource backgroundResources;

  private final UnaryCallable<AddResourcePoliciesRegionDiskRequest, Operation>
      addResourcePoliciesCallable;
  private final UnaryCallable<CreateSnapshotRegionDiskRequest, Operation> createSnapshotCallable;
  private final UnaryCallable<DeleteRegionDiskRequest, Operation> deleteCallable;
  private final UnaryCallable<GetRegionDiskRequest, Disk> getCallable;
  private final UnaryCallable<GetIamPolicyRegionDiskRequest, Policy> getIamPolicyCallable;
  private final UnaryCallable<InsertRegionDiskRequest, Operation> insertCallable;
  private final UnaryCallable<ListRegionDisksRequest, DiskList> listCallable;
  private final UnaryCallable<ListRegionDisksRequest, ListPagedResponse> listPagedCallable;
  private final UnaryCallable<RemoveResourcePoliciesRegionDiskRequest, Operation>
      removeResourcePoliciesCallable;
  private final UnaryCallable<ResizeRegionDiskRequest, Operation> resizeCallable;
  private final UnaryCallable<SetIamPolicyRegionDiskRequest, Policy> setIamPolicyCallable;
  private final UnaryCallable<SetLabelsRegionDiskRequest, Operation> setLabelsCallable;
  private final UnaryCallable<TestIamPermissionsRegionDiskRequest, TestPermissionsResponse>
      testIamPermissionsCallable;

  private final HttpJsonStubCallableFactory callableFactory;

  public static final HttpJsonRegionDisksStub create(RegionDisksStubSettings settings)
      throws IOException {
    return new HttpJsonRegionDisksStub(settings, ClientContext.create(settings));
  }

  public static final HttpJsonRegionDisksStub create(ClientContext clientContext)
      throws IOException {
    return new HttpJsonRegionDisksStub(RegionDisksStubSettings.newBuilder().build(), clientContext);
  }

  public static final HttpJsonRegionDisksStub create(
      ClientContext clientContext, HttpJsonStubCallableFactory callableFactory) throws IOException {
    return new HttpJsonRegionDisksStub(
        RegionDisksStubSettings.newBuilder().build(), clientContext, callableFactory);
  }

  /**
   * Constructs an instance of HttpJsonRegionDisksStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonRegionDisksStub(RegionDisksStubSettings settings, ClientContext clientContext)
      throws IOException {
    this(settings, clientContext, new HttpJsonRegionDisksCallableFactory());
  }

  /**
   * Constructs an instance of HttpJsonRegionDisksStub, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected HttpJsonRegionDisksStub(
      RegionDisksStubSettings settings,
      ClientContext clientContext,
      HttpJsonStubCallableFactory callableFactory)
      throws IOException {
    this.callableFactory = callableFactory;

    HttpJsonCallSettings<AddResourcePoliciesRegionDiskRequest, Operation>
        addResourcePoliciesTransportSettings =
            HttpJsonCallSettings.<AddResourcePoliciesRegionDiskRequest, Operation>newBuilder()
                .setMethodDescriptor(addResourcePoliciesMethodDescriptor)
                .build();
    HttpJsonCallSettings<CreateSnapshotRegionDiskRequest, Operation>
        createSnapshotTransportSettings =
            HttpJsonCallSettings.<CreateSnapshotRegionDiskRequest, Operation>newBuilder()
                .setMethodDescriptor(createSnapshotMethodDescriptor)
                .build();
    HttpJsonCallSettings<DeleteRegionDiskRequest, Operation> deleteTransportSettings =
        HttpJsonCallSettings.<DeleteRegionDiskRequest, Operation>newBuilder()
            .setMethodDescriptor(deleteMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetRegionDiskRequest, Disk> getTransportSettings =
        HttpJsonCallSettings.<GetRegionDiskRequest, Disk>newBuilder()
            .setMethodDescriptor(getMethodDescriptor)
            .build();
    HttpJsonCallSettings<GetIamPolicyRegionDiskRequest, Policy> getIamPolicyTransportSettings =
        HttpJsonCallSettings.<GetIamPolicyRegionDiskRequest, Policy>newBuilder()
            .setMethodDescriptor(getIamPolicyMethodDescriptor)
            .build();
    HttpJsonCallSettings<InsertRegionDiskRequest, Operation> insertTransportSettings =
        HttpJsonCallSettings.<InsertRegionDiskRequest, Operation>newBuilder()
            .setMethodDescriptor(insertMethodDescriptor)
            .build();
    HttpJsonCallSettings<ListRegionDisksRequest, DiskList> listTransportSettings =
        HttpJsonCallSettings.<ListRegionDisksRequest, DiskList>newBuilder()
            .setMethodDescriptor(listMethodDescriptor)
            .build();
    HttpJsonCallSettings<RemoveResourcePoliciesRegionDiskRequest, Operation>
        removeResourcePoliciesTransportSettings =
            HttpJsonCallSettings.<RemoveResourcePoliciesRegionDiskRequest, Operation>newBuilder()
                .setMethodDescriptor(removeResourcePoliciesMethodDescriptor)
                .build();
    HttpJsonCallSettings<ResizeRegionDiskRequest, Operation> resizeTransportSettings =
        HttpJsonCallSettings.<ResizeRegionDiskRequest, Operation>newBuilder()
            .setMethodDescriptor(resizeMethodDescriptor)
            .build();
    HttpJsonCallSettings<SetIamPolicyRegionDiskRequest, Policy> setIamPolicyTransportSettings =
        HttpJsonCallSettings.<SetIamPolicyRegionDiskRequest, Policy>newBuilder()
            .setMethodDescriptor(setIamPolicyMethodDescriptor)
            .build();
    HttpJsonCallSettings<SetLabelsRegionDiskRequest, Operation> setLabelsTransportSettings =
        HttpJsonCallSettings.<SetLabelsRegionDiskRequest, Operation>newBuilder()
            .setMethodDescriptor(setLabelsMethodDescriptor)
            .build();
    HttpJsonCallSettings<TestIamPermissionsRegionDiskRequest, TestPermissionsResponse>
        testIamPermissionsTransportSettings =
            HttpJsonCallSettings
                .<TestIamPermissionsRegionDiskRequest, TestPermissionsResponse>newBuilder()
                .setMethodDescriptor(testIamPermissionsMethodDescriptor)
                .build();

    this.addResourcePoliciesCallable =
        callableFactory.createUnaryCallable(
            addResourcePoliciesTransportSettings,
            settings.addResourcePoliciesSettings(),
            clientContext);
    this.createSnapshotCallable =
        callableFactory.createUnaryCallable(
            createSnapshotTransportSettings, settings.createSnapshotSettings(), clientContext);
    this.deleteCallable =
        callableFactory.createUnaryCallable(
            deleteTransportSettings, settings.deleteSettings(), clientContext);
    this.getCallable =
        callableFactory.createUnaryCallable(
            getTransportSettings, settings.getSettings(), clientContext);
    this.getIamPolicyCallable =
        callableFactory.createUnaryCallable(
            getIamPolicyTransportSettings, settings.getIamPolicySettings(), clientContext);
    this.insertCallable =
        callableFactory.createUnaryCallable(
            insertTransportSettings, settings.insertSettings(), clientContext);
    this.listCallable =
        callableFactory.createUnaryCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.listPagedCallable =
        callableFactory.createPagedCallable(
            listTransportSettings, settings.listSettings(), clientContext);
    this.removeResourcePoliciesCallable =
        callableFactory.createUnaryCallable(
            removeResourcePoliciesTransportSettings,
            settings.removeResourcePoliciesSettings(),
            clientContext);
    this.resizeCallable =
        callableFactory.createUnaryCallable(
            resizeTransportSettings, settings.resizeSettings(), clientContext);
    this.setIamPolicyCallable =
        callableFactory.createUnaryCallable(
            setIamPolicyTransportSettings, settings.setIamPolicySettings(), clientContext);
    this.setLabelsCallable =
        callableFactory.createUnaryCallable(
            setLabelsTransportSettings, settings.setLabelsSettings(), clientContext);
    this.testIamPermissionsCallable =
        callableFactory.createUnaryCallable(
            testIamPermissionsTransportSettings,
            settings.testIamPermissionsSettings(),
            clientContext);

    backgroundResources = new BackgroundResourceAggregation(clientContext.getBackgroundResources());
  }

  public UnaryCallable<AddResourcePoliciesRegionDiskRequest, Operation>
      addResourcePoliciesCallable() {
    return addResourcePoliciesCallable;
  }

  public UnaryCallable<CreateSnapshotRegionDiskRequest, Operation> createSnapshotCallable() {
    return createSnapshotCallable;
  }

  public UnaryCallable<DeleteRegionDiskRequest, Operation> deleteCallable() {
    return deleteCallable;
  }

  public UnaryCallable<GetRegionDiskRequest, Disk> getCallable() {
    return getCallable;
  }

  public UnaryCallable<GetIamPolicyRegionDiskRequest, Policy> getIamPolicyCallable() {
    return getIamPolicyCallable;
  }

  public UnaryCallable<InsertRegionDiskRequest, Operation> insertCallable() {
    return insertCallable;
  }

  public UnaryCallable<ListRegionDisksRequest, ListPagedResponse> listPagedCallable() {
    return listPagedCallable;
  }

  public UnaryCallable<ListRegionDisksRequest, DiskList> listCallable() {
    return listCallable;
  }

  public UnaryCallable<RemoveResourcePoliciesRegionDiskRequest, Operation>
      removeResourcePoliciesCallable() {
    return removeResourcePoliciesCallable;
  }

  public UnaryCallable<ResizeRegionDiskRequest, Operation> resizeCallable() {
    return resizeCallable;
  }

  public UnaryCallable<SetIamPolicyRegionDiskRequest, Policy> setIamPolicyCallable() {
    return setIamPolicyCallable;
  }

  public UnaryCallable<SetLabelsRegionDiskRequest, Operation> setLabelsCallable() {
    return setLabelsCallable;
  }

  public UnaryCallable<TestIamPermissionsRegionDiskRequest, TestPermissionsResponse>
      testIamPermissionsCallable() {
    return testIamPermissionsCallable;
  }

  @Override
  public final void close() {
    shutdown();
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
