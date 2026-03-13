/*
 * Copyright 2024 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.google.api.generator.gapic.composer.common;

import static com.google.api.generator.gapic.composer.common.AbstractTransportServiceStubClassComposer.shouldGenerateRequestMutator;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.google.api.FieldInfo.Format;
import com.google.api.generator.engine.ast.LambdaExpr;
import com.google.api.generator.engine.ast.Reference;
import com.google.api.generator.engine.ast.Statement;
import com.google.api.generator.engine.ast.TypeNode;
import com.google.api.generator.engine.ast.VaporReference;
import com.google.api.generator.engine.ast.Variable;
import com.google.api.generator.engine.ast.VariableExpr;
import com.google.api.generator.engine.writer.JavaWriterVisitor;
import com.google.api.generator.gapic.model.Field;
import com.google.api.generator.gapic.model.Message;
import com.google.api.generator.gapic.model.Method;
import com.google.api.generator.test.utils.LineFormatter;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AbstractTransportServiceStubClassComposerTest {
  private JavaWriterVisitor writerVisitor;

  @BeforeEach
  void setUp() {
    writerVisitor = new JavaWriterVisitor();
  }

  @Test
  void shouldGenerateRequestMutator_fieldConfiguredCorrectly() {
    String ECHO_PACKAGE = "com.google.showcase.v1beta1";
    List<String> autoPopulatedFieldList = new ArrayList<>();
    autoPopulatedFieldList.add("TestField");

    Method METHOD =
        Method.builder()
            .setName("TestMethod")
            .setInputType(
                TypeNode.withReference(
                    VaporReference.builder()
                        .setName("SampleRequest")
                        .setPakkage(ECHO_PACKAGE)
                        .build()))
            .setOutputType(TypeNode.STRING)
            .setAutoPopulatedFields(autoPopulatedFieldList)
            .build();

    Field FIELD =
        Field.builder()
            .setName("TestField")
            .setFieldInfoFormat(Format.UUID4)
            .setType(TypeNode.STRING)
            .build();
    List<Field> fieldList = new ArrayList<>();
    fieldList.add(FIELD);

    Message MESSAGE =
        Message.builder()
            .setFullProtoName("com.google.showcase.v1beta1.SampleRequest")
            .setName("SampleRequest")
            .setType(TypeNode.STRING)
            .setFields(fieldList)
            .build();

    ImmutableMap<String, Message> messageTypes =
        ImmutableMap.of("com.google.showcase.v1beta1.SampleRequest", MESSAGE);

    assertTrue(shouldGenerateRequestMutator(METHOD, messageTypes));
  }

  @Test
  void shouldNotGenerateRequestMutator_fieldConfiguredIncorrectly() {
    String ECHO_PACKAGE = "com.google.showcase.v1beta1";
    List<String> autoPopulatedFieldList = new ArrayList<>();
    autoPopulatedFieldList.add("TestField");

    Method METHOD =
        Method.builder()
            .setName("TestMethod")
            .setInputType(
                TypeNode.withReference(
                    VaporReference.builder()
                        .setName("SampleRequest")
                        .setPakkage(ECHO_PACKAGE)
                        .build()))
            .setOutputType(TypeNode.STRING)
            .setAutoPopulatedFields(autoPopulatedFieldList)
            .build();

    Field FIELD =
        Field.builder()
            .setName("TestField")
            .setFieldInfoFormat(Format.IPV6)
            .setType(TypeNode.STRING)
            .build();
    List<Field> fieldList = new ArrayList<>();
    fieldList.add(FIELD);

    Message MESSAGE =
        Message.builder()
            .setFullProtoName("com.google.showcase.v1beta1.SampleRequest")
            .setName("SampleRequest")
            .setType(TypeNode.STRING)
            .setFields(fieldList)
            .build();

    ImmutableMap<String, Message> messageTypes =
        ImmutableMap.of("com.google.showcase.v1beta1.SampleRequest", MESSAGE);

    assertFalse(shouldGenerateRequestMutator(METHOD, messageTypes));
  }

  // TODO: add unit tests where the field is not found in the messageTypes map
  @Test
  void createAutoPopulatedRequestStatement_sampleField() {
    Reference RequestBuilderRef =
        VaporReference.builder()
            .setName("EchoRequest")
            .setPakkage("com.google.example.examples.library.v1")
            .build();

    TypeNode testType = TypeNode.withReference(RequestBuilderRef);

    Method METHOD =
        Method.builder()
            .setName("TestMethod")
            .setInputType(testType)
            .setOutputType(TypeNode.STRING)
            .build();

    Reference RequestVarBuilderRef =
        VaporReference.builder()
            .setEnclosingClassNames(METHOD.inputType().reference().name())
            .setName("Builder")
            .setPakkage(METHOD.inputType().reference().pakkage())
            .build();

    TypeNode requestBuilderType = TypeNode.withReference(RequestVarBuilderRef);

    VariableExpr requestBuilderVarExpr =
        VariableExpr.builder()
            .setVariable(
                Variable.builder().setName("requestBuilder").setType(requestBuilderType).build())
            .setIsDecl(false)
            .build();

    Statement autoPopulatedFieldStatement =
        AbstractTransportServiceStubClassComposer.createAutoPopulatedRequestStatement(
            METHOD, "sampleField", requestBuilderVarExpr);

    autoPopulatedFieldStatement.accept(writerVisitor);
    String expected =
        LineFormatter.lines(
            "if (Strings.isNullOrEmpty(request.getSampleField())) {\n",
            "requestBuilder.setSampleField(UUID.randomUUID().toString());\n",
            "}\n");
    assertEquals(expected, writerVisitor.write());
  }

  @Test
  void createRequestMutatorBody_TestField() {
    List<Statement> bodyStatements = new ArrayList<>();
    String ECHO_PACKAGE = "com.google.showcase.v1beta1";
    List<String> autoPopulatedFieldList = new ArrayList<>();
    autoPopulatedFieldList.add("TestField");

    Method METHOD =
        Method.builder()
            .setName("TestMethod")
            .setInputType(
                TypeNode.withReference(
                    VaporReference.builder()
                        .setName("SampleRequest")
                        .setPakkage(ECHO_PACKAGE)
                        .build()))
            .setOutputType(TypeNode.STRING)
            .setAutoPopulatedFields(autoPopulatedFieldList)
            .build();

    Field FIELD =
        Field.builder()
            .setName("TestField")
            .setFieldInfoFormat(Format.UUID4)
            .setType(TypeNode.STRING)
            .build();
    List<Field> fieldList = new ArrayList<>();
    fieldList.add(FIELD);

    Message MESSAGE =
        Message.builder()
            .setFullProtoName("com.google.showcase.v1beta1.SampleRequest")
            .setName("SampleRequest")
            .setType(TypeNode.STRING)
            .setFields(fieldList)
            .build();

    Reference RequestBuilderRef =
        VaporReference.builder()
            .setEnclosingClassNames(METHOD.inputType().reference().name())
            .setName("Builder")
            .setPakkage(METHOD.inputType().reference().pakkage())
            .build();

    TypeNode requestBuilderType = TypeNode.withReference(RequestBuilderRef);

    VariableExpr requestBuilderVarExpr =
        VariableExpr.builder()
            .setVariable(
                Variable.builder().setName("requestBuilder").setType(requestBuilderType).build())
            .setIsDecl(false)
            .build();

    ImmutableMap<String, Message> messageTypes =
        ImmutableMap.of("com.google.showcase.v1beta1.SampleRequest", MESSAGE);

    List<Statement> listOfAutoPopulatedStatements =
        AbstractTransportServiceStubClassComposer.createRequestMutatorBody(
            METHOD, messageTypes, bodyStatements, requestBuilderVarExpr);

    for (Statement statement : listOfAutoPopulatedStatements) {
      statement.accept(writerVisitor);
    }

    String expected =
        LineFormatter.lines(
            "if (Strings.isNullOrEmpty(request.getTestField())) {\n",
            "requestBuilder.setTestField(UUID.randomUUID().toString());\n",
            "}\n");
    assertEquals(expected, writerVisitor.write());
  }

  @Test
  void createRequestMutatorBody_TestFieldNotString_shouldReturnNull() {
    List<Statement> bodyStatements = new ArrayList<>();

    String ECHO_PACKAGE = "com.google.showcase.v1beta1";
    List<String> autoPopulatedFieldList = new ArrayList<>();
    autoPopulatedFieldList.add("TestField");

    Method METHOD =
        Method.builder()
            .setName("TestMethod")
            .setInputType(
                TypeNode.withReference(
                    VaporReference.builder()
                        .setName("SampleRequest")
                        .setPakkage(ECHO_PACKAGE)
                        .build()))
            .setOutputType(TypeNode.STRING)
            .setAutoPopulatedFields(autoPopulatedFieldList)
            .build();

    Field FIELD =
        Field.builder()
            .setName("TestField")
            .setFieldInfoFormat(Format.UUID4)
            .setType(TypeNode.BOOLEAN)
            .build();
    List<Field> fieldList = new ArrayList<>();
    fieldList.add(FIELD);

    Message MESSAGE =
        Message.builder()
            .setFullProtoName("com.google.showcase.v1beta1.SampleRequest")
            .setName("SampleRequest")
            .setType(TypeNode.STRING)
            .setFields(fieldList)
            .build();

    Reference RequestBuilderRef =
        VaporReference.builder()
            .setEnclosingClassNames(METHOD.inputType().reference().name())
            .setName("Builder")
            .setPakkage(METHOD.inputType().reference().pakkage())
            .build();

    TypeNode requestBuilderType = TypeNode.withReference(RequestBuilderRef);

    VariableExpr requestBuilderVarExpr =
        VariableExpr.builder()
            .setVariable(
                Variable.builder().setName("requestBuilder").setType(requestBuilderType).build())
            .setIsDecl(false)
            .build();

    ImmutableMap<String, Message> messageTypes =
        ImmutableMap.of("com.google.showcase.v1beta1.SampleRequest", MESSAGE);

    List<Statement> listOfAutoPopulatedStatements =
        AbstractTransportServiceStubClassComposer.createRequestMutatorBody(
            METHOD, messageTypes, bodyStatements, requestBuilderVarExpr);

    for (Statement statement : listOfAutoPopulatedStatements) {
      statement.accept(writerVisitor);
    }

    String expected = LineFormatter.lines("");
    assertEquals(expected, writerVisitor.write());
  }

  @Test
  void createRequestMutatorBody_TestFieldFormatNotUUID_shouldReturnNull() {
    List<Statement> bodyStatements = new ArrayList<>();
    String ECHO_PACKAGE = "com.google.showcase.v1beta1";
    List<String> autoPopulatedFieldList = new ArrayList<>();
    autoPopulatedFieldList.add("TestField");

    Method METHOD =
        Method.builder()
            .setName("TestMethod")
            .setInputType(
                TypeNode.withReference(
                    VaporReference.builder()
                        .setName("SampleRequest")
                        .setPakkage(ECHO_PACKAGE)
                        .build()))
            .setOutputType(TypeNode.STRING)
            .setAutoPopulatedFields(autoPopulatedFieldList)
            .build();

    Field FIELD =
        Field.builder()
            .setName("TestField")
            .setFieldInfoFormat(Format.IPV4_OR_IPV6)
            .setType(TypeNode.STRING)
            .build();
    List<Field> fieldList = new ArrayList<>();
    fieldList.add(FIELD);

    Message MESSAGE =
        Message.builder()
            .setFullProtoName("com.google.showcase.v1beta1.SampleRequest")
            .setName("SampleRequest")
            .setType(TypeNode.STRING)
            .setFields(fieldList)
            .build();

    Reference RequestBuilderRef =
        VaporReference.builder()
            .setEnclosingClassNames(METHOD.inputType().reference().name())
            .setName("Builder")
            .setPakkage(METHOD.inputType().reference().pakkage())
            .build();

    TypeNode requestBuilderType = TypeNode.withReference(RequestBuilderRef);

    VariableExpr requestBuilderVarExpr =
        VariableExpr.builder()
            .setVariable(
                Variable.builder().setName("requestBuilder").setType(requestBuilderType).build())
            .setIsDecl(false)
            .build();

    ImmutableMap<String, Message> messageTypes =
        ImmutableMap.of("com.google.showcase.v1beta1.SampleRequest", MESSAGE);

    List<Statement> listOfAutoPopulatedStatements =
        AbstractTransportServiceStubClassComposer.createRequestMutatorBody(
            METHOD, messageTypes, bodyStatements, requestBuilderVarExpr);

    for (Statement statement : listOfAutoPopulatedStatements) {
      statement.accept(writerVisitor);
    }

    String expected = LineFormatter.lines("");
    assertEquals(expected, writerVisitor.write());
  }

  @Test
  void createRequestMutatorBody_TestFieldIncorrectName_shouldReturnNull() {
    List<Statement> bodyStatements = new ArrayList<>();
    String ECHO_PACKAGE = "com.google.showcase.v1beta1";
    List<String> autoPopulatedFieldList = new ArrayList<>();
    autoPopulatedFieldList.add("TestField");

    Method METHOD =
        Method.builder()
            .setName("TestMethod")
            .setInputType(
                TypeNode.withReference(
                    VaporReference.builder()
                        .setName("SampleRequest")
                        .setPakkage(ECHO_PACKAGE)
                        .build()))
            .setOutputType(TypeNode.STRING)
            .setAutoPopulatedFields(autoPopulatedFieldList)
            .build();

    Field FIELD =
        Field.builder()
            .setName("TestIncorrectField")
            .setFieldInfoFormat(Format.UUID4)
            .setType(TypeNode.STRING)
            .build();
    List<Field> fieldList = new ArrayList<>();
    fieldList.add(FIELD);

    Message MESSAGE =
        Message.builder()
            .setFullProtoName("com.google.showcase.v1beta1.SampleRequest")
            .setName("SampleRequest")
            .setType(TypeNode.STRING)
            .setFields(fieldList)
            .build();

    Reference RequestBuilderRef =
        VaporReference.builder()
            .setEnclosingClassNames(METHOD.inputType().reference().name())
            .setName("Builder")
            .setPakkage(METHOD.inputType().reference().pakkage())
            .build();

    TypeNode requestBuilderType = TypeNode.withReference(RequestBuilderRef);

    VariableExpr requestBuilderVarExpr =
        VariableExpr.builder()
            .setVariable(
                Variable.builder().setName("requestBuilder").setType(requestBuilderType).build())
            .setIsDecl(false)
            .build();

    ImmutableMap<String, Message> messageTypes =
        ImmutableMap.of("com.google.showcase.v1beta1.SampleRequest", MESSAGE);

    List<Statement> listOfAutoPopulatedStatements =
        AbstractTransportServiceStubClassComposer.createRequestMutatorBody(
            METHOD, messageTypes, bodyStatements, requestBuilderVarExpr);

    for (Statement statement : listOfAutoPopulatedStatements) {
      statement.accept(writerVisitor);
    }

    String expected = LineFormatter.lines("");
    assertEquals(expected, writerVisitor.write());
  }

  @Test
  void createRequestMutator_TestField() {
    String ECHO_PACKAGE = "com.google.showcase.v1beta1";
    List<String> autoPopulatedFieldList = new ArrayList<>();
    autoPopulatedFieldList.add("TestField");

    Method METHOD =
        Method.builder()
            .setName("TestMethod")
            .setInputType(
                TypeNode.withReference(
                    VaporReference.builder()
                        .setName("SampleRequest")
                        .setPakkage(ECHO_PACKAGE)
                        .build()))
            .setOutputType(TypeNode.STRING)
            .setAutoPopulatedFields(autoPopulatedFieldList)
            .build();

    Field FIELD =
        Field.builder()
            .setName("TestField")
            .setFieldInfoFormat(Format.UUID4)
            .setType(TypeNode.STRING)
            .build();
    List<Field> fieldList = new ArrayList<>();
    fieldList.add(FIELD);

    Message MESSAGE =
        Message.builder()
            .setFullProtoName("com.google.showcase.v1beta1.SampleRequest")
            .setName("SampleRequest")
            .setType(TypeNode.STRING)
            .setFields(fieldList)
            .build();

    ImmutableMap<String, Message> messageTypes =
        ImmutableMap.of("com.google.showcase.v1beta1.SampleRequest", MESSAGE);

    LambdaExpr requestMutator =
        AbstractTransportServiceStubClassComposer.createRequestMutatorClassInstance(
            METHOD, messageTypes);

    requestMutator.accept(writerVisitor);

    String expected =
        LineFormatter.lines(
            "request -> {\n",
            "SampleRequest.Builder requestBuilder = request.toBuilder();\n",
            "if (Strings.isNullOrEmpty(request.getTestField())) {\n",
            "requestBuilder.setTestField(UUID.randomUUID().toString());\n",
            "}\n",
            "return requestBuilder.build();\n",
            "}");
    assertEquals(expected, writerVisitor.write());
  }
}
