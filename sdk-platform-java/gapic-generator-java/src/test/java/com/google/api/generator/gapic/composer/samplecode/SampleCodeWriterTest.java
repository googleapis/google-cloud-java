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

package com.google.api.generator.gapic.composer.samplecode;

import com.google.api.gax.rpc.ClientSettings;
import com.google.api.generator.engine.ast.AssignmentExpr;
import com.google.api.generator.engine.ast.BlockComment;
import com.google.api.generator.engine.ast.CommentStatement;
import com.google.api.generator.engine.ast.ConcreteReference;
import com.google.api.generator.engine.ast.ExprStatement;
import com.google.api.generator.engine.ast.MethodInvocationExpr;
import com.google.api.generator.engine.ast.PrimitiveValue;
import com.google.api.generator.engine.ast.Statement;
import com.google.api.generator.engine.ast.TryCatchStatement;
import com.google.api.generator.engine.ast.TypeNode;
import com.google.api.generator.engine.ast.ValueExpr;
import com.google.api.generator.engine.ast.Variable;
import com.google.api.generator.engine.ast.VariableExpr;
import com.google.api.generator.gapic.model.RegionTag;
import com.google.api.generator.gapic.model.Sample;
import com.google.api.generator.test.utils.LineFormatter;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SampleCodeWriterTest {
  private static String packageName = "com.google.samples";
  private static List<Statement> testingSampleStatements;
  private static Sample testingSample;
  private static RegionTag regionTag;

  @BeforeAll
  static void setUp() {
    TypeNode settingType =
        TypeNode.withReference(ConcreteReference.withClazz(ClientSettings.class));
    Variable aVar = Variable.builder().setName("clientSettings").setType(settingType).build();
    VariableExpr aVarExpr = VariableExpr.withVariable(aVar);
    MethodInvocationExpr aValueExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(
                MethodInvocationExpr.builder()
                    .setMethodName("newBuilder")
                    .setStaticReferenceType(settingType)
                    .build())
            .setReturnType(settingType)
            .setMethodName("build")
            .build();
    AssignmentExpr assignmentExpr =
        AssignmentExpr.builder()
            .setVariableExpr(aVarExpr.toBuilder().setIsDecl(true).build())
            .setValueExpr(aValueExpr)
            .build();
    TryCatchStatement sampleStatement =
        TryCatchStatement.builder()
            .setTryResourceExpr(createAssignmentExpr("aBool", "false", TypeNode.BOOLEAN))
            .setTryBody(
                Arrays.asList(ExprStatement.withExpr(createAssignmentExpr("x", "3", TypeNode.INT))))
            .setIsSampleCode(true)
            .build();

    testingSampleStatements =
        Arrays.asList(ExprStatement.withExpr(assignmentExpr), sampleStatement);
    regionTag =
        RegionTag.builder()
            .setApiShortName("testing")
            .setApiVersion("v1")
            .setServiceName("samples")
            .setRpcName("write")
            .build();
    testingSample =
        Sample.builder()
            .setFileHeader(
                Arrays.asList(
                    CommentStatement.withComment(BlockComment.withComment("Apache License"))))
            .setBody(testingSampleStatements)
            .setRegionTag(regionTag)
            .build();
  }

  @Test
  void writeSampleCodeStatements() {
    String result = SampleCodeWriter.write(testingSampleStatements);
    String expected =
        "ClientSettings clientSettings = ClientSettings.newBuilder().build();\n"
            + "try (boolean aBool = false) {\n"
            + "  int x = 3;\n"
            + "}";
    Assert.assertEquals(expected, result);
  }

  @Test
  void writeInlineSample() {
    String result = SampleCodeWriter.writeInlineSample(testingSampleStatements);
    String expected =
        LineFormatter.lines(
            "// This snippet has been automatically generated and should be regarded as a code template only.\n",
            "// It will require modifications to work:\n",
            "// - It may require correct/in-range values for request initialization.\n",
            "// - It may require specifying regional endpoints when creating the service client as shown in\n",
            "// https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library\n",
            "ClientSettings clientSettings = ClientSettings.newBuilder().build();\n",
            "try (boolean aBool = false) {\n",
            "  int x = 3;\n",
            "}");
    Assert.assertEquals(expected, result);
  }

  @Test
  void writeExecutableSample() {
    Sample sample =
        testingSample.withRegionTag(regionTag.withOverloadDisambiguation("ExecutableSample"));
    String result = SampleCodeWriter.writeExecutableSample(sample, packageName);
    String expected =
        LineFormatter.lines(
            "/*\n",
            " * Apache License\n",
            " */\n",
            "\n",
            "package com.google.samples;\n",
            "\n",
            "// [START testing_v1_generated_Samples_Write_ExecutableSample_sync]\n",
            "import com.google.api.gax.rpc.ClientSettings;\n",
            "\n",
            "public class SyncWriteExecutableSample {\n",
            "\n",
            "  public static void main(String[] args) throws Exception {\n",
            "    syncWriteExecutableSample();\n",
            "  }\n",
            "\n",
            "  public static void syncWriteExecutableSample() throws Exception {\n",
            "    // This snippet has been automatically generated and should be regarded as a code template only.\n",
            "    // It will require modifications to work:\n",
            "    // - It may require correct/in-range values for request initialization.\n",
            "    // - It may require specifying regional endpoints when creating the service client as shown in\n",
            "    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library\n",
            "    ClientSettings clientSettings = ClientSettings.newBuilder().build();\n",
            "    try (boolean aBool = false) {\n",
            "      int x = 3;\n",
            "    }\n",
            "  }\n",
            "}\n",
            "// [END testing_v1_generated_Samples_Write_ExecutableSample_sync]\n");
    Assert.assertEquals(expected, result);
  }

  private static AssignmentExpr createAssignmentExpr(
      String varName, String varValue, TypeNode type) {
    Variable variable = Variable.builder().setName(varName).setType(type).build();
    VariableExpr variableExpr =
        VariableExpr.builder().setVariable(variable).setIsDecl(true).build();
    return AssignmentExpr.builder()
        .setVariableExpr(variableExpr)
        .setValueExpr(
            ValueExpr.withValue(PrimitiveValue.builder().setType(type).setValue(varValue).build()))
        .build();
  }
}
