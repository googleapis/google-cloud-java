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

import com.google.api.generator.engine.ast.AnnotationNode;
import com.google.api.generator.engine.ast.CommentStatement;
import com.google.api.generator.engine.ast.MethodDefinition;
import com.google.api.generator.gapic.composer.comment.SettingsCommentComposer;
import com.google.api.generator.gapic.composer.common.AbstractServiceSettingsClassComposer;
import com.google.api.generator.gapic.composer.store.TypeStore;
import com.google.api.generator.gapic.model.Service;
import com.google.api.generator.gapic.model.Transport;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ServiceSettingsClassComposer extends AbstractServiceSettingsClassComposer {
  private static final ServiceSettingsClassComposer INSTANCE = new ServiceSettingsClassComposer();

  protected ServiceSettingsClassComposer() {
    super(GrpcRestContext.instance());
  }

  public static ServiceSettingsClassComposer instance() {
    return INSTANCE;
  }

  @Override
  protected List<MethodDefinition> createNestedBuilderCreatorMethods(
      Service service,
      TypeStore typeStore,
      String newBuilderMethodName,
      String createDefaultMethodName,
      List<AnnotationNode> annotations) {

    List<MethodDefinition> methods = new ArrayList<>();
    methods.addAll(
        super.createNestedBuilderCreatorMethods(
            service, typeStore, "newBuilder", "createDefault", annotations));
    if (service.hasAnyEnabledMethodsForTransport(Transport.REST)) {
      methods.addAll(
          super.createNestedBuilderCreatorMethods(
              service,
              typeStore,
              "newHttpJsonBuilder",
              "createHttpJsonDefault",
              ImmutableList.<AnnotationNode>builder().addAll(annotations).build()));
    }
    return methods;
  }

  @Override
  protected List<MethodDefinition> createNewBuilderMethods(
      Service service,
      TypeStore typeStore,
      String newBuilderMethodName,
      String createDefaultMethodName,
      List<AnnotationNode> annotations,
      CommentStatement comment) {
    List<MethodDefinition> methods = new ArrayList<>();

    Iterator<String> transportNames = getTransportContext().transportNames().iterator();

    methods.addAll(
        super.createNewBuilderMethods(
            service,
            typeStore,
            "newBuilder",
            "createDefault",
            annotations,
            new SettingsCommentComposer(transportNames.next())
                .getNewTransportBuilderMethodComment()));
    if (service.hasAnyEnabledMethodsForTransport(Transport.REST)) {
      methods.addAll(
          super.createNewBuilderMethods(
              service,
              typeStore,
              "newHttpJsonBuilder",
              "createHttpJsonDefault",
              ImmutableList.<AnnotationNode>builder().addAll(annotations).build(),
              new SettingsCommentComposer(transportNames.next())
                  .getNewTransportBuilderMethodComment()));
    }
    return methods;
  }
}
