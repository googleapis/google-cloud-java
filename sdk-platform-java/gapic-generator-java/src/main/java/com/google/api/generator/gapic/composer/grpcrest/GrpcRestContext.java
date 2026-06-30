// Copyright 2021 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.api.generator.gapic.composer.grpcrest;

import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.grpc.ProtoOperationTransformers;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.httpjson.longrunning.stub.HttpJsonOperationsStub;
import com.google.api.generator.gapic.composer.common.TransportContext;
import com.google.api.generator.gapic.composer.utils.ClassNames;
import com.google.api.generator.gapic.model.Transport;
import com.google.common.collect.ImmutableList;
import com.google.longrunning.OperationsClient;
import com.google.longrunning.stub.GrpcOperationsStub;
import com.google.longrunning.stub.OperationsStub;

public abstract class GrpcRestContext extends TransportContext {
  private static final TransportContext INSTANCE =
      GrpcRestContext.builder()
          .setClassNames(new ClassNames("Grpc", "HttpJson"))
          .setTransport(Transport.GRPC_REST)
          .setTransportNames(ImmutableList.of("gRPC", "REST"))
          // For grpcrest.GrpcServiceStubClassComposer
          .setCallSettingsClass(null)
          .setStubCallableFactoryType(null)
          .setMethodDescriptorClass(null)
          .setTransportOperationsStubTypes(
              ImmutableList.of(
                  classToType(GrpcOperationsStub.class), classToType(HttpJsonOperationsStub.class)))
          .setTransportOperationsStubNames(
              ImmutableList.of("operationsStub", "httpJsonOperationsStub"))
          // For grpcrest.ServiceSettingsClassComposer
          .setInstantiatingChannelProviderClasses(
              ImmutableList.of(
                  InstantiatingGrpcChannelProvider.class,
                  InstantiatingHttpJsonChannelProvider.class))
          .setInstantiatingChannelProviderBuilderClasses(
              ImmutableList.of(
                  InstantiatingGrpcChannelProvider.Builder.class,
                  InstantiatingHttpJsonChannelProvider.Builder.class))
          .setDefaultTransportProviderBuilderNames(
              ImmutableList.of(
                  "defaultGrpcTransportProviderBuilder", "defaultHttpJsonTransportProviderBuilder"))
          .setTransportApiClientHeaderProviderBuilderNames(
              ImmutableList.of(
                  "defaultGrpcApiClientHeaderProviderBuilder",
                  "defaultHttpJsonApiClientHeaderProviderBuilder"))
          // For grpcrest.ServiceStubSettingsClassComposer
          .setTransportChannelTypes(
              ImmutableList.of(
                  classToType(GrpcTransportChannel.class),
                  classToType(HttpJsonTransportChannel.class)))
          .setTransportGetterNames(
              ImmutableList.of("getGrpcTransportName", "getHttpJsonTransportName"))
          // For grpcrest.GrpcServiceCallableFactoryClassComposer
          .setTransportCallSettingsType(null)
          .setTransportCallableFactoryType(null)
          .setOperationsStubTypes(
              ImmutableList.of(
                  classToType(OperationsStub.class),
                  classToType(com.google.api.gax.httpjson.longrunning.stub.OperationsStub.class)))
          .setTransportCallSettingsName(null)
          // For RetrySettingsComposer
          // TODO: fix when LRO for REST RE FIXED
          .setOperationResponseTransformerType(
              classToType(ProtoOperationTransformers.ResponseTransformer.class))
          .setOperationMetadataTransformerType(
              classToType(ProtoOperationTransformers.MetadataTransformer.class))
          // For ServiceClientClassComposer
          .setOperationsClientTypes(
              ImmutableList.of(
                  classToType(OperationsClient.class),
                  classToType(com.google.api.gax.httpjson.longrunning.OperationsClient.class)))
          .setOperationsClientNames(
              ImmutableList.of("operationsClient", "httpJsonOperationsClient"))
          .setUseValuePatterns(true)
          .build();

  public static TransportContext instance() {
    return INSTANCE;
  }
}
