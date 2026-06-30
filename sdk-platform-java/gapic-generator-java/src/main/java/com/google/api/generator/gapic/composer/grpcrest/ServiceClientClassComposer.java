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

import com.google.api.generator.engine.ast.CommentStatement;
import com.google.api.generator.engine.ast.TypeNode;
import com.google.api.generator.gapic.composer.comment.ServiceClientCommentComposer;
import com.google.api.generator.gapic.composer.common.AbstractServiceClientClassComposer;
import com.google.api.generator.gapic.composer.samplecode.SampleCodeWriter;
import com.google.api.generator.gapic.composer.samplecode.ServiceClientHeaderSampleComposer;
import com.google.api.generator.gapic.composer.store.TypeStore;
import com.google.api.generator.gapic.composer.utils.ClassNames;
import com.google.api.generator.gapic.model.Message;
import com.google.api.generator.gapic.model.ResourceName;
import com.google.api.generator.gapic.model.Sample;
import com.google.api.generator.gapic.model.Service;
import com.google.api.generator.gapic.model.Transport;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ServiceClientClassComposer extends AbstractServiceClientClassComposer {
  private static final ServiceClientClassComposer INSTANCE = new ServiceClientClassComposer();

  protected ServiceClientClassComposer() {
    super(GrpcRestContext.instance());
  }

  public static ServiceClientClassComposer instance() {
    return INSTANCE;
  }

  @Override
  protected List<CommentStatement> createClassHeaderComments(
      Map<String, List<String>> grpcRpcsToJavaMethodNames,
      Service service,
      TypeStore typeStore,
      Map<String, ResourceName> resourceNames,
      Map<String, Message> messageTypes,
      List<Sample> samples) {
    if (!service.hasAnyEnabledMethodsForTransport(Transport.REST)) {
      return super.createClassHeaderComments(
          grpcRpcsToJavaMethodNames, service, typeStore, resourceNames, messageTypes, samples);
    }
    TypeNode clientType = typeStore.get(ClassNames.getServiceClientClassName(service));
    TypeNode settingsType = typeStore.get(ClassNames.getServiceSettingsClassName(service));
    Sample classMethodSampleCode =
        ServiceClientHeaderSampleComposer.composeClassHeaderSample(
            service, clientType, resourceNames, messageTypes);
    Sample credentialsSampleCode =
        ServiceClientHeaderSampleComposer.composeSetCredentialsSample(
            clientType, settingsType, service);
    Sample endpointSampleCode =
        ServiceClientHeaderSampleComposer.composeSetEndpointSample(
            clientType, settingsType, service);
    Sample transportSampleCode =
        ServiceClientHeaderSampleComposer.composeTransportSample(
            clientType, settingsType, "newHttpJsonBuilder", service);
    samples.addAll(
        Arrays.asList(
            classMethodSampleCode, credentialsSampleCode, endpointSampleCode, transportSampleCode));

    return ServiceClientCommentComposer.createClassHeaderComments(
        grpcRpcsToJavaMethodNames,
        service,
        SampleCodeWriter.writeInlineSample(classMethodSampleCode.body()),
        SampleCodeWriter.writeInlineSample(credentialsSampleCode.body()),
        SampleCodeWriter.writeInlineSample(endpointSampleCode.body()),
        SampleCodeWriter.writeInlineSample(transportSampleCode.body()),
        "gRPC",
        "REST (HTTP1.1/JSON)");
  }
}
