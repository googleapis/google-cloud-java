// Copyright 2020 Google LLC
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

package com.google.api.generator.gapic.protoparser;

import com.google.api.RoutingParameter;
import com.google.api.RoutingProto;
import com.google.api.RoutingRule;
import com.google.api.generator.engine.ast.TypeNode;
import com.google.api.generator.gapic.model.Message;
import com.google.api.generator.gapic.model.RoutingHeaderRule;
import com.google.api.generator.gapic.model.RoutingHeaderRule.RoutingHeaderParam;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.protobuf.DescriptorProtos.MethodOptions;
import com.google.protobuf.Descriptors.MethodDescriptor;
import java.util.Map;
import java.util.Set;

public class RoutingRuleParser {

  public static RoutingHeaderRule parse(
      MethodDescriptor protoMethod, Message inputMessage, Map<String, Message> messageTypes) {
    MethodOptions methodOptions = protoMethod.getOptions();
    if (!methodOptions.hasExtension(RoutingProto.routing)) {
      return null;
    }

    RoutingHeaderRule.Builder routingHeaderRuleBuilder = RoutingHeaderRule.builder();
    RoutingRule routingRule = methodOptions.getExtension(RoutingProto.routing);
    for (RoutingParameter routingParameter : routingRule.getRoutingParametersList()) {
      String pathTemplate = routingParameter.getPathTemplate();
      String fieldName = routingParameter.getField();
      // validate if field exist in Message or nested Messages and the type of leaf level field
      inputMessage.validateField(fieldName, messageTypes, TypeNode.STRING);
      String key;
      if (Strings.isNullOrEmpty(pathTemplate)) {
        key = fieldName;
        pathTemplate = String.format("{%s=**}", key);
      } else {
        Set<String> namedSegments = PatternParser.getPatternBindings(pathTemplate);
        Preconditions.checkArgument(
            namedSegments.size() == 1,
            String.format(
                "There needs to be one and only one named segment in path template %s",
                pathTemplate));
        key = namedSegments.iterator().next();
      }
      RoutingHeaderParam routingHeaderParam =
          RoutingHeaderParam.create(fieldName, key, pathTemplate);
      routingHeaderRuleBuilder.addParam(routingHeaderParam);
    }
    return routingHeaderRuleBuilder.build();
  }
}
