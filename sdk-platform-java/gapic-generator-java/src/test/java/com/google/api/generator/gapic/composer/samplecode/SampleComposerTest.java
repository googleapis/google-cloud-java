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

import com.google.api.generator.engine.ast.AssignmentExpr;
import com.google.api.generator.engine.ast.ClassDefinition;
import com.google.api.generator.engine.ast.Expr;
import com.google.api.generator.engine.ast.ExprStatement;
import com.google.api.generator.engine.ast.MethodInvocationExpr;
import com.google.api.generator.engine.ast.NewObjectExpr;
import com.google.api.generator.engine.ast.PrimitiveValue;
import com.google.api.generator.engine.ast.Statement;
import com.google.api.generator.engine.ast.StringObjectValue;
import com.google.api.generator.engine.ast.TypeNode;
import com.google.api.generator.engine.ast.ValueExpr;
import com.google.api.generator.engine.ast.VaporReference;
import com.google.api.generator.engine.ast.Variable;
import com.google.api.generator.engine.ast.VariableExpr;
import com.google.api.generator.gapic.model.RegionTag;
import com.google.api.generator.gapic.model.Sample;
import com.google.api.generator.test.utils.LineFormatter;
import com.google.common.collect.ImmutableList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class SampleComposerTest {
  private final String packageName = "com.google.example";
  private final RegionTag.Builder regionTag =
      RegionTag.builder().setApiShortName("apiName").setServiceName("echo");

  @Test
  void createInlineSample() {
    List<Statement> sampleBody = Arrays.asList(ExprStatement.withExpr(systemOutPrint("testing")));
    String sampleResult = writeSample(SampleComposer.composeInlineSample(sampleBody));
    String expected =
        LineFormatter.lines(
            "// This snippet has been automatically generated and should be regarded as a code template only.\n",
            "// It will require modifications to work:\n",
            "// - It may require correct/in-range values for request initialization.\n",
            "// - It may require specifying regional endpoints when creating the service client as shown in\n",
            "// https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library\n",
            "System.out.println(\"testing\");");

    assertEquals(expected, sampleResult);
  }

  @Test
  void createExecutableSampleEmptyStatementSample() {
    Sample sample =
        Sample.builder()
            .setRegionTag(
                regionTag
                    .setRpcName("createExecutableSample")
                    .setOverloadDisambiguation("EmptyStatementSample")
                    .build())
            .build();

    String sampleResult = writeSample(SampleComposer.composeExecutableSample(sample, packageName));
    String expected =
        LineFormatter.lines(
            "package com.google.example;\n",
            "\n",
            "// [START apiname_generated_Echo_CreateExecutableSample_EmptyStatementSample_sync]\n",
            "public class SyncCreateExecutableSampleEmptyStatementSample {\n",
            "\n",
            "  public static void main(String[] args) throws Exception {\n",
            "    syncCreateExecutableSampleEmptyStatementSample();\n",
            "  }\n",
            "\n",
            "  public static void syncCreateExecutableSampleEmptyStatementSample() throws Exception {\n",
            "    // This snippet has been automatically generated and should be regarded as a code template only.\n",
            "    // It will require modifications to work:\n",
            "    // - It may require correct/in-range values for request initialization.\n",
            "    // - It may require specifying regional endpoints when creating the service client as shown in\n",
            "    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library\n",
            "  }\n",
            "}\n",
            "// [END apiname_generated_Echo_CreateExecutableSample_EmptyStatementSample_sync]\n");

    assertEquals(expected, sampleResult);
  }

  @Test
  void createExecutableSampleMethodArgsNoVar() {
    Statement sampleBody =
        ExprStatement.withExpr(systemOutPrint("Testing CreateExecutableSampleMethodArgsNoVar"));
    Sample sample =
        Sample.builder()
            .setBody(ImmutableList.of(sampleBody))
            .setRegionTag(
                regionTag
                    .setRpcName("createExecutableSample")
                    .setOverloadDisambiguation("MethodArgsNoVar")
                    .build())
            .build();

    String sampleResult = writeSample(SampleComposer.composeExecutableSample(sample, packageName));
    String expected =
        LineFormatter.lines(
            "package com.google.example;\n",
            "\n",
            "// [START apiname_generated_Echo_CreateExecutableSample_MethodArgsNoVar_sync]\n",
            "public class SyncCreateExecutableSampleMethodArgsNoVar {\n",
            "\n",
            "  public static void main(String[] args) throws Exception {\n",
            "    syncCreateExecutableSampleMethodArgsNoVar();\n",
            "  }\n",
            "\n",
            "  public static void syncCreateExecutableSampleMethodArgsNoVar() throws Exception {\n",
            "    // This snippet has been automatically generated and should be regarded as a code template only.\n",
            "    // It will require modifications to work:\n",
            "    // - It may require correct/in-range values for request initialization.\n",
            "    // - It may require specifying regional endpoints when creating the service client as shown in\n",
            "    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library\n",
            "    System.out.println(\"Testing CreateExecutableSampleMethodArgsNoVar\");\n",
            "  }\n",
            "}\n",
            "// [END apiname_generated_Echo_CreateExecutableSample_MethodArgsNoVar_sync]\n");

    assertEquals(expected, sampleResult);
  }

  @Test
  void createExecutableSampleMethod() {
    VariableExpr variableExpr =
        VariableExpr.builder()
            .setVariable(Variable.builder().setType(TypeNode.STRING).setName("content").build())
            .setIsDecl(true)
            .build();
    AssignmentExpr varAssignment =
        AssignmentExpr.builder()
            .setVariableExpr(variableExpr)
            .setValueExpr(
                ValueExpr.withValue(
                    StringObjectValue.withValue("Testing CreateExecutableSampleMethod")))
            .build();
    Statement sampleBody = ExprStatement.withExpr(systemOutPrint(variableExpr));
    Sample sample =
        Sample.builder()
            .setBody(ImmutableList.of(sampleBody))
            .setVariableAssignments(ImmutableList.of(varAssignment))
            .setRegionTag(regionTag.setRpcName("createExecutableSample").build())
            .build();

    String sampleResult = writeSample(SampleComposer.composeExecutableSample(sample, packageName));
    String expected =
        LineFormatter.lines(
            "package com.google.example;\n",
            "\n",
            "// [START apiname_generated_Echo_CreateExecutableSample_sync]\n",
            "public class SyncCreateExecutableSample {\n",
            "\n",
            "  public static void main(String[] args) throws Exception {\n",
            "    String content = \"Testing CreateExecutableSampleMethod\";\n",
            "    syncCreateExecutableSample(content);\n",
            "  }\n",
            "\n",
            "  public static void syncCreateExecutableSample(String content) throws Exception {\n",
            "    // This snippet has been automatically generated and should be regarded as a code template only.\n",
            "    // It will require modifications to work:\n",
            "    // - It may require correct/in-range values for request initialization.\n",
            "    // - It may require specifying regional endpoints when creating the service client as shown in\n",
            "    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library\n",
            "    System.out.println(content);\n",
            "  }\n",
            "}\n",
            "// [END apiname_generated_Echo_CreateExecutableSample_sync]\n");

    assertEquals(expected, sampleResult);
  }

  @Test
  void createExecutableSampleMethodMultipleStatements() {
    VariableExpr strVariableExpr =
        VariableExpr.builder()
            .setVariable(Variable.builder().setType(TypeNode.STRING).setName("content").build())
            .setIsDecl(true)
            .build();
    VariableExpr intVariableExpr =
        VariableExpr.builder()
            .setVariable(Variable.builder().setType(TypeNode.INT).setName("num").build())
            .setIsDecl(true)
            .build();
    VariableExpr objVariableExpr =
        VariableExpr.builder()
            .setVariable(Variable.builder().setType(TypeNode.OBJECT).setName("thing").build())
            .setIsDecl(true)
            .build();
    AssignmentExpr strVarAssignment =
        AssignmentExpr.builder()
            .setVariableExpr(strVariableExpr)
            .setValueExpr(
                ValueExpr.withValue(
                    StringObjectValue.withValue(
                        "Testing CreateExecutableSampleMethodMultipleStatements")))
            .build();
    AssignmentExpr intVarAssignment =
        AssignmentExpr.builder()
            .setVariableExpr(intVariableExpr)
            .setValueExpr(
                ValueExpr.withValue(
                    PrimitiveValue.builder().setType(TypeNode.INT).setValue("2").build()))
            .build();
    AssignmentExpr objVarAssignment =
        AssignmentExpr.builder()
            .setVariableExpr(objVariableExpr)
            .setValueExpr(NewObjectExpr.builder().setType(TypeNode.OBJECT).build())
            .build();

    Statement strBodyStatement = ExprStatement.withExpr(systemOutPrint(strVariableExpr));
    Statement intBodyStatement = ExprStatement.withExpr(systemOutPrint(intVariableExpr));
    Statement objBodyStatement =
        ExprStatement.withExpr(
            systemOutPrint(
                MethodInvocationExpr.builder()
                    .setExprReferenceExpr(objVariableExpr.toBuilder().setIsDecl(false).build())
                    .setMethodName("response")
                    .build()));
    Sample sample =
        Sample.builder()
            .setBody(ImmutableList.of(strBodyStatement, intBodyStatement, objBodyStatement))
            .setVariableAssignments(
                ImmutableList.of(strVarAssignment, intVarAssignment, objVarAssignment))
            .setRegionTag(
                regionTag
                    .setRpcName("createExecutableSample")
                    .setOverloadDisambiguation("MethodMultipleStatements")
                    .build())
            .build();

    String sampleResult = writeSample(SampleComposer.composeExecutableSample(sample, packageName));
    String expected =
        LineFormatter.lines(
            "package com.google.example;\n",
            "\n",
            "// [START apiname_generated_Echo_CreateExecutableSample_MethodMultipleStatements_sync]\n",
            "public class SyncCreateExecutableSampleMethodMultipleStatements {\n",
            "\n",
            "  public static void main(String[] args) throws Exception {\n",
            "    String content = \"Testing CreateExecutableSampleMethodMultipleStatements\";\n",
            "    int num = 2;\n",
            "    Object thing = new Object();\n",
            "    syncCreateExecutableSampleMethodMultipleStatements(content, num, thing);\n",
            "  }\n",
            "\n",
            "  public static void syncCreateExecutableSampleMethodMultipleStatements(\n",
            "      String content, int num, Object thing) throws Exception {\n",
            "    // This snippet has been automatically generated and should be regarded as a code template only.\n",
            "    // It will require modifications to work:\n",
            "    // - It may require correct/in-range values for request initialization.\n",
            "    // - It may require specifying regional endpoints when creating the service client as shown in\n",
            "    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library\n",
            "    System.out.println(content);\n",
            "    System.out.println(num);\n",
            "    System.out.println(thing.response());\n",
            "  }\n",
            "}\n",
            "// [END apiname_generated_Echo_CreateExecutableSample_MethodMultipleStatements_sync]\n");
    assertEquals(expected, sampleResult);
  }

  private Expr systemOutPrint(MethodInvocationExpr response) {
    return composeSystemOutPrint(response);
  }

  private static MethodInvocationExpr systemOutPrint(String content) {
    return composeSystemOutPrint(ValueExpr.withValue(StringObjectValue.withValue(content)));
  }

  private static MethodInvocationExpr systemOutPrint(VariableExpr variableExpr) {
    return composeSystemOutPrint(variableExpr.toBuilder().setIsDecl(false).build());
  }

  private static MethodInvocationExpr composeSystemOutPrint(Expr content) {
    VaporReference out =
        VaporReference.builder()
            .setEnclosingClassNames("System")
            .setName("out")
            .setPakkage("java.lang")
            .build();
    return MethodInvocationExpr.builder()
        .setStaticReferenceType(TypeNode.withReference(out))
        .setMethodName("println")
        .setArguments(content)
        .build();
  }

  private static String writeSample(ClassDefinition sample) {
    return SampleCodeWriter.write(sample);
  }

  private static String writeSample(List<Statement> sample) {
    return SampleCodeWriter.write(sample);
  }
}
