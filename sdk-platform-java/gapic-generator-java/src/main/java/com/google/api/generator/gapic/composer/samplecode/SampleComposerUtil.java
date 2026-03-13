// Copyright 2022 Google LLC
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

package com.google.api.generator.gapic.composer.samplecode;

import com.google.api.generator.engine.ast.AssignmentExpr;
import com.google.api.generator.engine.ast.MethodInvocationExpr;
import com.google.api.generator.engine.ast.TypeNode;
import com.google.api.generator.engine.ast.VariableExpr;
import com.google.api.generator.gapic.model.MethodArgument;
import com.google.api.generator.gapic.model.ResourceName;
import com.google.api.generator.gapic.model.Sample;
import com.google.api.generator.gapic.utils.JavaStyle;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SampleComposerUtil {
  // Assign client variable expr with create client.
  // e.g EchoClient echoClient = EchoClient.create()
  static AssignmentExpr assignClientVariableWithCreateMethodExpr(VariableExpr clientVarExpr) {
    return AssignmentExpr.builder()
        .setVariableExpr(clientVarExpr.toBuilder().setIsDecl(true).build())
        .setValueExpr(
            MethodInvocationExpr.builder()
                .setStaticReferenceType(clientVarExpr.variable().type())
                .setReturnType(clientVarExpr.variable().type())
                .setMethodName("create")
                .build())
        .build();
  }

  static boolean isStringTypedResourceName(
      MethodArgument arg, Map<String, ResourceName> resourceNames) {
    return arg.type().equals(TypeNode.STRING)
        && arg.field().hasResourceReference()
        && resourceNames.containsKey(arg.field().resourceReference().resourceTypeString());
  }

  static String createOverloadDisambiguation(List<VariableExpr> methodArgVarExprs) {
    if (methodArgVarExprs.isEmpty()) {
      return "Noargs";
    }
    return methodArgVarExprs.stream()
        .map(
            arg ->
                JavaStyle.toUpperCamelCase(
                    arg.variable().type().reference() == null
                        ? arg.variable().type().typeKind().name().toLowerCase()
                        : arg.variable().type().reference().name().toLowerCase()))
        .collect(Collectors.joining());
  }

  public static List<Sample> handleDuplicateSamples(List<Sample> samples) {
    //  grab all distinct samples and group by sample name
    //  ie: { "echo", ["echo(request"],
    //        "echoString", ["echo(parent)", "echo(child)", "echo(context)"],
    //        "echoDelete", ["echo.delete(request)"] }
    Map<String, List<Sample>> distinctSamplesGroupedByName =
        samples.stream().distinct().collect(Collectors.groupingBy(s -> s.name()));

    // collect samples that don't have duplicates
    // ie: ["echo", "echoDelete"]
    List<Sample> uniqueSamples =
        distinctSamplesGroupedByName.entrySet().stream()
            .filter(entry -> entry.getValue().size() < 2)
            .map(entry -> entry.getValue().get(0))
            .collect(Collectors.toList());

    if (uniqueSamples.size() == distinctSamplesGroupedByName.size()) {
      return uniqueSamples;
    }

    // collect samples that do have duplicates
    // ie: ["echoString"]
    List<Map.Entry<String, List<Sample>>> duplicateDistinctSamples =
        distinctSamplesGroupedByName.entrySet().stream()
            .filter(entry -> entry.getValue().size() > 1)
            .collect(Collectors.toList());

    // update similar samples regionTag/name so filesname/regiontag are unique
    // ie: ["echo", "echoDelete", "echoString", "echoString1"]
    for (Map.Entry<String, List<Sample>> entry : duplicateDistinctSamples) {
      int sampleNum = 0;
      for (Sample sample : entry.getValue()) {
        Sample uniqueSample = sample;
        //  first sample will be "canonical", not updating name
        if (sampleNum != 0) {
          uniqueSample =
              sample.withRegionTag(
                  sample
                      .regionTag()
                      .withOverloadDisambiguation(
                          sample.regionTag().overloadDisambiguation() + sampleNum));
        }
        uniqueSamples.add(uniqueSample);
        sampleNum++;
      }
    }
    return uniqueSamples;
  }
}
