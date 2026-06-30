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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.google.api.generator.engine.ast.ExprStatement;
import com.google.api.generator.engine.ast.TypeNode;
import com.google.api.generator.engine.ast.VaporReference;
import com.google.api.generator.engine.ast.Variable;
import com.google.api.generator.engine.ast.VariableExpr;
import com.google.api.generator.gapic.model.RegionTag;
import com.google.api.generator.gapic.model.Sample;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class SampleComposerUtilTest {
  private static final String SHOWCASE_PACKAGE_NAME = "com.google.showcase.v1beta1";
  TypeNode clientType =
      TypeNode.withReference(
          VaporReference.builder().setName("EchoClient").setPakkage(SHOWCASE_PACKAGE_NAME).build());
  VariableExpr echoClientVariableExpr =
      VariableExpr.withVariable(
          Variable.builder().setName("echoClient").setType(clientType).build());
  VariableExpr stringVariableExpr =
      VariableExpr.withVariable(
          Variable.builder().setName("String").setType(TypeNode.STRING).build());
  VariableExpr intVariableExpr =
      VariableExpr.withVariable(Variable.builder().setName("INT").setType(TypeNode.INT).build());
  Sample echoClientSample =
      Sample.builder()
          .setRegionTag(
              RegionTag.builder().setServiceName("echoClient").setRpcName("create").build())
          .setBody(
              Arrays.asList(
                  ExprStatement.withExpr(
                      SampleComposerUtil.assignClientVariableWithCreateMethodExpr(
                          echoClientVariableExpr))))
          .build();

  @Test
  void assignClientVariableWithCreateMethodExpr() {
    String result =
        SampleCodeWriter.write(
            SampleComposerUtil.assignClientVariableWithCreateMethodExpr(echoClientVariableExpr));

    String expected = "EchoClient echoClient = EchoClient.create();";
    assertEquals(expected, result);
  }

  @Test
  void createOverloadDisambiguation_noargs() {
    String result = SampleComposerUtil.createOverloadDisambiguation(new ArrayList<>());
    String expected = "Noargs";
    assertEquals(expected, result);
  }

  @Test
  void createOverloadDisambiguation_sameargs() {
    List<VariableExpr> methodArgVarExprs = Collections.nCopies(5, stringVariableExpr);

    String result = SampleComposerUtil.createOverloadDisambiguation(methodArgVarExprs);
    String expected = "StringStringStringStringString";
    assertEquals(expected, result);
  }

  @Test
  void createOverloadDisambiguation_containsInt() {
    List<VariableExpr> methodArgVarExprs =
        Arrays.asList(echoClientVariableExpr, stringVariableExpr, intVariableExpr);

    String result = SampleComposerUtil.createOverloadDisambiguation(methodArgVarExprs);
    String expected = "EchoclientStringInt";
    assertEquals(expected, result);
  }

  @Test
  void handleDuplicateSamples_actualDuplicates() {
    List<Sample> samples = Collections.nCopies(5, echoClientSample);
    assertEquals(samples.size(), 5);

    List<Sample> result = SampleComposerUtil.handleDuplicateSamples(samples);
    assertEquals(result.size(), 1);
    assertEquals(result.get(0), echoClientSample);
  }

  @Test
  void handleDuplicateSamples_distinctDuplicates() {
    VariableExpr echoClientVariableExprDiffVarName =
        VariableExpr.withVariable(
            Variable.builder().setName("echoClient2").setType(clientType).build());
    Sample echoClientSampleDiffVarName =
        echoClientSample.toBuilder()
            .setBody(
                Arrays.asList(
                    ExprStatement.withExpr(
                        SampleComposerUtil.assignClientVariableWithCreateMethodExpr(
                            echoClientVariableExprDiffVarName))))
            .build();
    List<Sample> samples =
        Arrays.asList(echoClientSample, echoClientSample, echoClientSampleDiffVarName);
    assertEquals(samples.size(), 3);
    assertEquals(samples.get(0).name(), "SyncCreate");
    assertEquals(samples.get(1).name(), "SyncCreate");
    assertEquals(samples.get(2).name(), "SyncCreate");

    List<Sample> result = SampleComposerUtil.handleDuplicateSamples(samples);
    assertEquals(result.size(), 2);
    assertTrue(result.contains(echoClientSample));
    assertTrue(result.stream().filter(s -> s.name().equals("SyncCreate1")).findFirst().isPresent());
  }

  @Test
  void handleDuplicateSamples_notDuplicateName() {
    Sample echoClientSampleDiffRpcName =
        echoClientSample.withRegionTag(
            echoClientSample.regionTag().toBuilder().setRpcName("createB").build());

    List<Sample> samples =
        Arrays.asList(echoClientSample, echoClientSample, echoClientSampleDiffRpcName);
    assertEquals(samples.size(), 3);
    assertEquals(samples.get(0).name(), "SyncCreate");
    assertEquals(samples.get(1).name(), "SyncCreate");
    assertEquals(samples.get(2).name(), "SyncCreateB");

    List<Sample> result = SampleComposerUtil.handleDuplicateSamples(samples);
    assertEquals(result.size(), 2);
    assertTrue(result.contains(echoClientSample));
    assertTrue(result.contains(echoClientSampleDiffRpcName));
  }
}
