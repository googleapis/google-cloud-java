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

package com.google.api.generator.engine.writer;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import com.google.api.generator.engine.ast.AnnotationNode;
import com.google.api.generator.engine.ast.AnonymousClassExpr;
import com.google.api.generator.engine.ast.ArithmeticOperationExpr;
import com.google.api.generator.engine.ast.ArrayExpr;
import com.google.api.generator.engine.ast.AssignmentExpr;
import com.google.api.generator.engine.ast.AssignmentOperationExpr;
import com.google.api.generator.engine.ast.BlockComment;
import com.google.api.generator.engine.ast.BlockStatement;
import com.google.api.generator.engine.ast.BreakStatement;
import com.google.api.generator.engine.ast.CastExpr;
import com.google.api.generator.engine.ast.ClassDefinition;
import com.google.api.generator.engine.ast.CommentStatement;
import com.google.api.generator.engine.ast.ConcreteReference;
import com.google.api.generator.engine.ast.EmptyLineStatement;
import com.google.api.generator.engine.ast.EnumRefExpr;
import com.google.api.generator.engine.ast.Expr;
import com.google.api.generator.engine.ast.ExprStatement;
import com.google.api.generator.engine.ast.ForStatement;
import com.google.api.generator.engine.ast.GeneralForStatement;
import com.google.api.generator.engine.ast.IdentifierNode;
import com.google.api.generator.engine.ast.IfStatement;
import com.google.api.generator.engine.ast.InstanceofExpr;
import com.google.api.generator.engine.ast.JavaDocComment;
import com.google.api.generator.engine.ast.LambdaExpr;
import com.google.api.generator.engine.ast.LineComment;
import com.google.api.generator.engine.ast.LogicalOperationExpr;
import com.google.api.generator.engine.ast.MethodDefinition;
import com.google.api.generator.engine.ast.MethodInvocationExpr;
import com.google.api.generator.engine.ast.NewObjectExpr;
import com.google.api.generator.engine.ast.NullObjectValue;
import com.google.api.generator.engine.ast.PackageInfoDefinition;
import com.google.api.generator.engine.ast.PrimitiveValue;
import com.google.api.generator.engine.ast.Reference;
import com.google.api.generator.engine.ast.ReferenceConstructorExpr;
import com.google.api.generator.engine.ast.RelationalOperationExpr;
import com.google.api.generator.engine.ast.ReturnExpr;
import com.google.api.generator.engine.ast.ScopeNode;
import com.google.api.generator.engine.ast.Statement;
import com.google.api.generator.engine.ast.StringObjectValue;
import com.google.api.generator.engine.ast.SuperObjectValue;
import com.google.api.generator.engine.ast.SynchronizedStatement;
import com.google.api.generator.engine.ast.TernaryExpr;
import com.google.api.generator.engine.ast.ThisObjectValue;
import com.google.api.generator.engine.ast.ThrowExpr;
import com.google.api.generator.engine.ast.TryCatchStatement;
import com.google.api.generator.engine.ast.TypeNode;
import com.google.api.generator.engine.ast.UnaryOperationExpr;
import com.google.api.generator.engine.ast.Value;
import com.google.api.generator.engine.ast.ValueExpr;
import com.google.api.generator.engine.ast.VaporReference;
import com.google.api.generator.engine.ast.Variable;
import com.google.api.generator.engine.ast.VariableExpr;
import com.google.api.generator.engine.ast.WhileStatement;
import com.google.api.generator.engine.writer.JavaFormatter.FormatException;
import com.google.api.generator.gapic.composer.grpc.ServiceClientClassComposer;
import com.google.api.generator.gapic.model.GapicClass;
import com.google.api.generator.gapic.model.GapicContext;
import com.google.api.generator.gapic.model.Service;
import com.google.api.generator.test.framework.Assert;
import com.google.api.generator.test.protoloader.TestProtoLoader;
import com.google.api.generator.test.utils.LineFormatter;
import com.google.api.generator.test.utils.TestExprBuilder;
import com.google.common.base.Function;
import com.google.testgapic.v1beta1.Outer;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;
import javax.annotation.Generated;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JavaWriterVisitorTest {
  private JavaWriterVisitor writerVisitor;

  @BeforeEach
  void setUp() {
    writerVisitor = new JavaWriterVisitor();
  }

  @Test
  void writeIdentifier() {
    String idName = "foobar";
    IdentifierNode.builder().setName(idName).build().accept(writerVisitor);
    assertEquals(idName, writerVisitor.write());
  }

  @Test
  void writePrimitiveType() {
    TypeNode intType = TypeNode.INT;
    assertThat(intType).isNotNull();
    intType.accept(writerVisitor);
    assertEquals("int", writerVisitor.write());
  }

  @Test
  void writePrimitiveArrayType() {
    TypeNode byteArrayType =
        TypeNode.builder().setTypeKind(TypeNode.TypeKind.BYTE).setIsArray(true).build();
    assertThat(byteArrayType).isNotNull();
    byteArrayType.accept(writerVisitor);
    assertEquals("byte[]", writerVisitor.write());
  }

  @Test
  void writeReferenceType_basic() {
    TypeNode.withReference(ConcreteReference.withClazz(List.class)).accept(writerVisitor);
    assertEquals("List", writerVisitor.write());

    writerVisitor.clear();
    TypeNode.withReference(
            VaporReference.builder().setName("FooBar").setPakkage("com.foo.bar").build())
        .accept(writerVisitor);
    assertEquals("FooBar", writerVisitor.write());
  }

  @Test
  void writeVaporReferenceType_nestedClasses() {
    VaporReference nestedVaporReference =
        VaporReference.builder()
            .setName("Inner")
            .setEnclosingClassNames(Arrays.asList("Outer", "Middle"))
            .setPakkage("com.google.testgapic.v1beta1")
            .build();
    TypeNode.withReference(nestedVaporReference).accept(writerVisitor);
    assertEquals("Outer.Middle.Inner", writerVisitor.write());
  }

  @Test
  void writeConcreteReferenceType_nestedClasses() {
    ConcreteReference nestedConcreteReference =
        ConcreteReference.withClazz(Outer.Middle.Inner.class);
    TypeNode.withReference(nestedConcreteReference).accept(writerVisitor);
    assertEquals("Outer.Middle.Inner", writerVisitor.write());
  }

  @Test
  void writeReferenceType_useFullName() {
    TypeNode.withReference(
            ConcreteReference.builder().setClazz(List.class).setUseFullName(true).build())
        .accept(writerVisitor);
    assertEquals("java.util.List", writerVisitor.write());

    writerVisitor.clear();
    TypeNode.withReference(
            VaporReference.builder()
                .setName("FooBar")
                .setPakkage("com.foo.bar")
                .setUseFullName(true)
                .build())
        .accept(writerVisitor);
    assertEquals("com.foo.bar.FooBar", writerVisitor.write());
  }

  @Test
  void writeAnnotation_simple() {
    AnnotationNode annotation = AnnotationNode.OVERRIDE;
    annotation.accept(writerVisitor);
    assertEquals("@Override\n", writerVisitor.write());
  }

  @Test
  void writeAnnotation_withStringDescription() {
    AnnotationNode annotation = AnnotationNode.withSuppressWarnings("all");
    annotation.accept(writerVisitor);
    assertEquals("@SuppressWarnings(\"all\")\n", writerVisitor.write());
  }

  @Test
  void writeAnnotation_withValueDescription() {
    TypeNode fakeAnnotationType =
        TypeNode.withReference(
            VaporReference.builder().setName("FakeAnnotation").setPakkage("com.foo.bar").build());
    AnnotationNode annotation =
        AnnotationNode.builder()
            .setType(fakeAnnotationType)
            .setDescription(
                ValueExpr.withValue(
                    PrimitiveValue.builder().setValue("12").setType(TypeNode.INT).build()))
            .build();
    annotation.accept(writerVisitor);
    assertEquals("@FakeAnnotation(12)\n", writerVisitor.write());
  }

  @Test
  void writeAnnotation_withVariableExprDescription() {
    TypeNode conditionalOnPropertyType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("ConditionalOnClass")
                .setPakkage("org.springframework.boot.autoconfigure.condition")
                .build());
    TypeNode clazzType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("VisionServiceClient")
                .setPakkage("com.foo.bar")
                .build());

    AnnotationNode annotation =
        AnnotationNode.builder()
            .setType(conditionalOnPropertyType)
            .setDescription(
                VariableExpr.builder()
                    .setVariable(
                        Variable.builder().setType(TypeNode.CLASS_OBJECT).setName("class").build())
                    .setStaticReferenceType(clazzType)
                    .build())
            .build();
    annotation.accept(writerVisitor);
    assertEquals("@ConditionalOnClass(VisionServiceClient.class)\n", writerVisitor.write());
  }

  @Test
  void writeAnnotation_withMultipleNamedDescriptions() {
    TypeNode conditionalOnPropertyType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("ConditionalOnProperty")
                .setPakkage("org.springframework.boot.autoconfigure.condition")
                .build());

    AssignmentExpr matchIfMissing =
        AssignmentExpr.builder()
            .setVariableExpr(
                VariableExpr.withVariable(
                    Variable.builder().setName("matchIfMissing").setType(TypeNode.BOOLEAN).build()))
            .setValueExpr(
                ValueExpr.withValue(
                    PrimitiveValue.builder().setValue("false").setType(TypeNode.BOOLEAN).build()))
            .build();
    AssignmentExpr valueString =
        AssignmentExpr.builder()
            .setVariableExpr(
                VariableExpr.withVariable(
                    Variable.builder().setName("value").setType(TypeNode.STRING).build()))
            .setValueExpr(
                ValueExpr.withValue(
                    StringObjectValue.withValue("spring.cloud.gcp.language.enabled")))
            .build();
    AnnotationNode annotation =
        AnnotationNode.builder()
            .setType(conditionalOnPropertyType)
            .addDescription(valueString)
            .addDescription(matchIfMissing)
            .build();
    annotation.accept(writerVisitor);
    assertEquals(
        "@ConditionalOnProperty(value = \"spring.cloud.gcp.language.enabled\", matchIfMissing = false)\n",
        writerVisitor.write());
  }

  @Test
  void writeAnnotation_withInvalidDescriptions() {
    TypeNode fakeAnnotationType =
        TypeNode.withReference(
            VaporReference.builder().setName("FakeAnnotation").setPakkage("com.foo.bar").build());
    String stringA = "a string";
    String stringB = "another string";
    ValueExpr valueExpr =
        ValueExpr.withValue(PrimitiveValue.builder().setValue("12").setType(TypeNode.INT).build());

    VariableExpr clazzVariableExpr =
        VariableExpr.builder()
            .setVariable(Variable.builder().setType(TypeNode.CLASS_OBJECT).setName("class").build())
            .setExprReferenceExpr(
                MethodInvocationExpr.builder()
                    .setMethodName("foobar")
                    .setReturnType(TypeNode.INT_OBJECT)
                    .build())
            .build();
    AssignmentExpr valueStringAssignmentExpr =
        AssignmentExpr.builder()
            .setVariableExpr(
                VariableExpr.withVariable(
                    Variable.builder().setName("value").setType(TypeNode.STRING).build()))
            .setValueExpr(
                ValueExpr.withValue(
                    StringObjectValue.withValue("spring.cloud.gcp.language.enabled")))
            .build();

    AnnotationNode.Builder annotationBuilder =
        AnnotationNode.builder().setType(fakeAnnotationType).setDescription(stringA);

    IllegalStateException exceptionForSetDescription =
        assertThrows(
            IllegalStateException.class,
            () -> {
              annotationBuilder.setDescription(valueExpr);
            });
    assertThat(exceptionForSetDescription)
        .hasMessageThat()
        .contains("Single parameter with no name cannot be set multiple times");

    assertThrows(
        IllegalStateException.class,
        () -> {
          annotationBuilder.setDescription(stringB);
        });

    assertThrows(
        IllegalStateException.class,
        () -> {
          annotationBuilder.setDescription(clazzVariableExpr);
        });

    IllegalStateException exceptionForAddDescription =
        assertThrows(
            IllegalStateException.class,
            () -> {
              annotationBuilder.addDescription(valueStringAssignmentExpr);
            });
    assertThat(exceptionForAddDescription)
        .hasMessageThat()
        .contains("Multiple parameters must have names");
  }

  @Test
  void writeAnnotation_withArrayExpr() {
    TypeNode fakeAnnotationType =
        TypeNode.withReference(
            VaporReference.builder().setName("FakeAnnotation").setPakkage("com.foo.bar").build());
    AnnotationNode annotation =
        AnnotationNode.builder()
            .setType(fakeAnnotationType)
            .setDescription(
                ArrayExpr.builder()
                    .setType(TypeNode.createArrayTypeOf(TypeNode.CLASS_OBJECT))
                    .addExpr(TestExprBuilder.generateClassValueExpr("Class1"))
                    .addExpr(TestExprBuilder.generateClassValueExpr("Class2"))
                    .build())
            .build();
    annotation.accept(writerVisitor);
    assertEquals("@FakeAnnotation({Class1.class, Class2.class})\n", writerVisitor.write());
  }

  @Test
  void writeAnnotation_withArrayExprAssignment() {
    TypeNode fakeAnnotationType =
        TypeNode.withReference(
            VaporReference.builder().setName("FakeAnnotation").setPakkage("com.foo.bar").build());
    ArrayExpr arrayExpr =
        ArrayExpr.builder()
            .setType(TypeNode.createArrayTypeOf(TypeNode.CLASS_OBJECT))
            .addExpr(TestExprBuilder.generateClassValueExpr("Class1"))
            .addExpr(TestExprBuilder.generateClassValueExpr("Class2"))
            .build();
    AssignmentExpr clazz1AssignExpr =
        AssignmentExpr.builder()
            .setVariableExpr(
                VariableExpr.builder()
                    .setVariable(
                        Variable.builder()
                            .setName("value1")
                            .setType(TypeNode.createArrayTypeOf(TypeNode.CLASS_OBJECT))
                            .build())
                    .build())
            .setValueExpr(arrayExpr)
            .build();
    AssignmentExpr clazz2AssignExpr =
        AssignmentExpr.builder()
            .setVariableExpr(
                VariableExpr.withVariable(
                    Variable.builder()
                        .setName("value2")
                        .setType(TypeNode.createArrayTypeOf(TypeNode.CLASS_OBJECT))
                        .build()))
            .setValueExpr(arrayExpr)
            .build();
    AnnotationNode annotation =
        AnnotationNode.builder()
            .setType(fakeAnnotationType)
            .addDescription(clazz1AssignExpr)
            .addDescription(clazz2AssignExpr)
            .build();
    annotation.accept(writerVisitor);
    assertEquals(
        "@FakeAnnotation(value1 = {Class1.class, Class2.class}, "
            + "value2 = {Class1.class, Class2.class})\n",
        writerVisitor.write());
  }

  @Test
  void writeArrayExpr_add1StringExpr() {
    ArrayExpr expr =
        ArrayExpr.builder()
            .setType(TypeNode.createArrayTypeOf(TypeNode.STRING))
            .addExpr(ValueExpr.builder().setValue(StringObjectValue.withValue("test1")).build())
            .build();
    expr.accept(writerVisitor);
    assertEquals("{\"test1\"}", writerVisitor.write());
  }

  @Test
  void writeArrayExpr_addManyStrExpr() {
    ArrayExpr expr =
        ArrayExpr.builder()
            .setType(TypeNode.createArrayTypeOf(TypeNode.STRING))
            .addExpr(TestExprBuilder.generateStringValueExpr("test1"))
            .addExpr(TestExprBuilder.generateStringValueExpr("test2"))
            .addExpr(TestExprBuilder.generateStringValueExpr("test3"))
            .build();
    expr.accept(writerVisitor);
    assertEquals("{\"test1\", \"test2\", \"test3\"}", writerVisitor.write());
  }

  @Test
  void writeArrayExpr_addManyClassExpr() {
    ArrayExpr expr =
        ArrayExpr.builder()
            .setType(TypeNode.createArrayTypeOf(TypeNode.CLASS_OBJECT))
            .addExpr(TestExprBuilder.generateClassValueExpr("Class1"))
            .addExpr(TestExprBuilder.generateClassValueExpr("Class2"))
            .addExpr(TestExprBuilder.generateClassValueExpr("Class3"))
            .build();
    expr.accept(writerVisitor);
    assertEquals("{Class1.class, Class2.class, Class3.class}", writerVisitor.write());
  }

  @Test
  void writeArrayExpr_mixedVariablesStaticAndNormalReference() {
    VariableExpr clazzVar =
        VariableExpr.builder()
            .setVariable(
                Variable.builder().setName("clazz1Var").setType(TypeNode.CLASS_OBJECT).build())
            .build();
    ArrayExpr expr =
        ArrayExpr.builder()
            .setType(TypeNode.createArrayTypeOf(TypeNode.CLASS_OBJECT))
            .addExpr(clazzVar)
            .addExpr(TestExprBuilder.generateClassValueExpr("Class2"))
            .build();
    expr.accept(writerVisitor);
    assertEquals("{clazz1Var, Class2.class}", writerVisitor.write());
  }

  @Test
  void writeArrayExpr_assignemntWithDeclaration() {
    VariableExpr varExpr =
        VariableExpr.builder()
            .setVariable(
                Variable.builder()
                    .setName("varExpr")
                    .setType(TypeNode.createArrayTypeOf(TypeNode.STRING))
                    .build())
            .setIsDecl(true)
            .build();
    ArrayExpr expr =
        ArrayExpr.builder()
            .setType(TypeNode.createArrayTypeOf(TypeNode.STRING))
            .addExpr(TestExprBuilder.generateStringValueExpr("str1"))
            .addExpr(TestExprBuilder.generateStringValueExpr("str2"))
            .build();
    AssignmentExpr assignmentExpr =
        AssignmentExpr.builder().setVariableExpr(varExpr).setValueExpr(expr).build();
    assignmentExpr.accept(writerVisitor);
    assertEquals("String[] varExpr = {\"str1\", \"str2\"}", writerVisitor.write());
  }

  @Test
  void writeNewObjectExpr_basic() {
    // isGeneric() is true, but generics() is empty.
    ConcreteReference ref = ConcreteReference.withClazz(List.class);
    TypeNode type = TypeNode.withReference(ref);
    NewObjectExpr newObjectExpr = NewObjectExpr.builder().setIsGeneric(true).setType(type).build();
    newObjectExpr.accept(writerVisitor);
    assertEquals("new List<>()", writerVisitor.write());
  }

  @Test
  void writeNewObjectExpr_withMethodExprArgs() {
    // isGeneric() is false, and generics() is empty.
    // [Constructing] `new IOException(message, cause())` and `cause()` is a method invocation.
    TypeNode type = TypeNode.withReference(ConcreteReference.withClazz(IOException.class));
    Variable message = Variable.builder().setName("message").setType(TypeNode.STRING).build();
    VariableExpr msgExpr = VariableExpr.builder().setVariable(message).build();
    MethodInvocationExpr causeExpr =
        MethodInvocationExpr.builder()
            .setMethodName("cause")
            .setReturnType(TypeNode.withReference(ConcreteReference.withClazz(Throwable.class)))
            .build();
    NewObjectExpr newObjectExpr =
        NewObjectExpr.builder()
            .setType(type)
            .setArguments(Arrays.asList(msgExpr, causeExpr))
            .build();
    newObjectExpr.accept(writerVisitor);
    assertEquals("new IOException(message, cause())", writerVisitor.write());
  }

  @Test
  void writeNewObjectExpr_withGenericsAndArgs() {
    // isGeneric() is true and generics() is not empty.
    ConcreteReference listRef =
        ConcreteReference.builder()
            .setClazz(List.class)
            .setGenerics(Arrays.asList(ConcreteReference.withClazz(Integer.class)))
            .build();
    ConcreteReference mapRef =
        ConcreteReference.builder()
            .setClazz(HashMap.class)
            .setGenerics(Arrays.asList(ConcreteReference.withClazz(String.class), listRef))
            .build();
    TypeNode type = TypeNode.withReference(mapRef);

    TypeNode someType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("SomeClass")
                .setPakkage("com.google.api.generator.engine")
                .build());
    MethodInvocationExpr methodExpr =
        MethodInvocationExpr.builder()
            .setMethodName("foobar")
            .setReturnType(TypeNode.INT)
            .setStaticReferenceType(someType)
            .build();
    Variable num = Variable.builder().setName("num").setType(TypeNode.FLOAT).build();
    VariableExpr numExpr = VariableExpr.builder().setVariable(num).build();
    NewObjectExpr newObjectExpr =
        NewObjectExpr.builder()
            .setIsGeneric(true)
            .setType(type)
            .setArguments(Arrays.asList(methodExpr, numExpr))
            .build();
    newObjectExpr.accept(writerVisitor);
    assertEquals(
        "new HashMap<String, List<Integer>>(SomeClass.foobar(), num)", writerVisitor.write());
  }

  /** =============================== EXPRESSIONS =============================== */
  @Test
  void writeValueExpr() {
    Value value = PrimitiveValue.builder().setType(TypeNode.INT).setValue("3").build();
    ValueExpr valueExpr = ValueExpr.builder().setValue(value).build();
    valueExpr.accept(writerVisitor);
    assertEquals("3", writerVisitor.write());
  }

  @Test
  void writeVariableExpr_basic() {
    Variable variable = Variable.builder().setName("x").setType(TypeNode.INT).build();
    VariableExpr variableExpr = VariableExpr.builder().setVariable(variable).build();

    variableExpr.accept(writerVisitor);
    assertEquals("x", writerVisitor.write());
  }

  @Test
  void writeVariableExpr_wildcardType() {
    TypeNode wildcardListType =
        TypeNode.withReference(
            ConcreteReference.builder()
                .setClazz(List.class)
                .setGenerics(Arrays.asList(TypeNode.WILDCARD_REFERENCE))
                .build());

    Variable variable = Variable.builder().setName("x").setType(wildcardListType).build();
    VariableExpr variableExpr =
        VariableExpr.builder().setIsDecl(true).setVariable(variable).build();

    variableExpr.accept(writerVisitor);
    assertEquals("List<?> x", writerVisitor.write());
  }

  @Test
  void writeVariableExpr_wildcardTypeWithUpperBound() {
    TypeNode wildcardListType =
        TypeNode.withReference(
            ConcreteReference.builder()
                .setClazz(List.class)
                .setGenerics(
                    Arrays.asList(
                        ConcreteReference.wildcardWithUpperBound(
                            ConcreteReference.withClazz(Expr.class))))
                .build());

    Variable variable = Variable.builder().setName("x").setType(wildcardListType).build();
    VariableExpr variableExpr =
        VariableExpr.builder().setIsDecl(true).setVariable(variable).build();

    variableExpr.accept(writerVisitor);
    assertEquals("List<? extends Expr> x", writerVisitor.write());
  }

  @Test
  void writeVariableExpr_staticReference() {
    VariableExpr variableExpr =
        VariableExpr.builder()
            .setVariable(
                Variable.builder().setType(TypeNode.INT_OBJECT).setName("MAX_VALUE").build())
            .setStaticReferenceType(TypeNode.INT_OBJECT)
            .build();

    variableExpr.accept(writerVisitor);
    assertEquals("Integer.MAX_VALUE", writerVisitor.write());
  }

  @Test
  void writeVariableExpr_nonDeclIgnoresModifiers() {
    Variable variable = Variable.builder().setName("x").setType(TypeNode.BOOLEAN).build();
    VariableExpr expr =
        VariableExpr.builder()
            .setVariable(variable)
            .setScope(ScopeNode.PUBLIC)
            .setIsStatic(true)
            .setIsFinal(true)
            .build();

    expr.accept(writerVisitor);
    assertEquals("x", writerVisitor.write());
  }

  @Test
  void writeVariableExpr_basicLocalDecl() {
    Variable variable = Variable.builder().setName("x").setType(TypeNode.INT).build();
    VariableExpr expr = VariableExpr.builder().setVariable(variable).setIsDecl(true).build();

    expr.accept(writerVisitor);
    assertEquals("int x", writerVisitor.write());
  }

  @Test
  void writeVariableExpr_localFinalDecl() {
    Variable variable = Variable.builder().setName("x").setType(TypeNode.BOOLEAN).build();

    VariableExpr expr =
        VariableExpr.builder().setVariable(variable).setIsFinal(true).setIsDecl(true).build();

    expr.accept(writerVisitor);
    assertEquals("final boolean x", writerVisitor.write());
  }

  @Test
  void writeVariableExpr_scopedDecl() {
    Variable variable = Variable.builder().setName("x").setType(TypeNode.INT).build();
    VariableExpr expr =
        VariableExpr.builder()
            .setVariable(variable)
            .setScope(ScopeNode.PRIVATE)
            .setIsDecl(true)
            .build();

    expr.accept(writerVisitor);
    assertEquals("private int x", writerVisitor.write());
  }

  @Test
  void writeVariableExpr_scopedStaticFinalDecl() {
    Variable variable = Variable.builder().setName("x").setType(TypeNode.BOOLEAN).build();
    VariableExpr expr =
        VariableExpr.builder()
            .setVariable(variable)
            .setIsDecl(true)
            .setScope(ScopeNode.PUBLIC)
            .setIsStatic(true)
            .setIsFinal(true)
            .build();

    expr.accept(writerVisitor);
    assertEquals("public static final boolean x", writerVisitor.write());
  }

  @Test
  void writeVariableExpr_scopedStaticFinalVolatileDecl() {
    Variable variable = Variable.builder().setName("x").setType(TypeNode.BOOLEAN).build();
    VariableExpr expr =
        VariableExpr.builder()
            .setVariable(variable)
            .setIsDecl(true)
            .setScope(ScopeNode.PRIVATE)
            .setIsStatic(true)
            .setIsFinal(true)
            .setIsVolatile(true)
            .build();

    expr.accept(writerVisitor);
    assertEquals("private static final volatile boolean x", writerVisitor.write());
  }

  @Test
  void writeVariableExpr_basicReference() {
    Variable variable = Variable.builder().setName("x").setType(TypeNode.STRING_ARRAY).build();
    VariableExpr variableExpr = VariableExpr.builder().setVariable(variable).build();

    Variable subVariable = Variable.builder().setName("length").setType(TypeNode.INT).build();
    variableExpr =
        VariableExpr.builder().setVariable(subVariable).setExprReferenceExpr(variableExpr).build();
    variableExpr.accept(writerVisitor);
    assertEquals("x.length", writerVisitor.write());
  }

  @Test
  void writeVariableExpr_basicReferenceWithModifiersSet() {
    Variable variable = Variable.builder().setName("x").setType(TypeNode.STRING_ARRAY).build();
    VariableExpr variableExpr = VariableExpr.builder().setVariable(variable).build();

    Variable subVariable = Variable.builder().setName("length").setType(TypeNode.INT).build();
    variableExpr =
        VariableExpr.builder()
            .setVariable(subVariable)
            .setExprReferenceExpr(variableExpr)
            .setScope(ScopeNode.PUBLIC)
            .setIsFinal(true)
            .setIsStatic(true)
            .build();
    variableExpr.accept(writerVisitor);
    assertEquals("x.length", writerVisitor.write());
  }

  @Test
  void writeVariableExpr_nestedReference() {
    Variable variable = Variable.builder().setName("x").setType(TypeNode.STRING_ARRAY).build();
    VariableExpr variableExpr = VariableExpr.builder().setVariable(variable).build();

    Variable subVariable =
        Variable.builder().setName("someStringField").setType(TypeNode.STRING).build();
    variableExpr =
        VariableExpr.builder().setVariable(subVariable).setExprReferenceExpr(variableExpr).build();
    subVariable = Variable.builder().setName("anotherStringField").setType(TypeNode.STRING).build();
    variableExpr =
        VariableExpr.builder().setVariable(subVariable).setExprReferenceExpr(variableExpr).build();
    subVariable = Variable.builder().setName("lengthField").setType(TypeNode.INT).build();
    variableExpr =
        VariableExpr.builder().setVariable(subVariable).setExprReferenceExpr(variableExpr).build();
    variableExpr.accept(writerVisitor);
    assertEquals("x.someStringField.anotherStringField.lengthField", writerVisitor.write());
  }

  @Test
  void writeArithmeticOperationExpr_concatStringWithMethod() {
    ValueExpr lhsExpr = ValueExpr.withValue(StringObjectValue.withValue("someWord"));
    MethodInvocationExpr methodInvocationExpr =
        MethodInvocationExpr.builder().setMethodName("getMethod").build();
    MethodInvocationExpr rhsExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(methodInvocationExpr)
            .setMethodName("getString")
            .setReturnType(TypeNode.STRING)
            .build();
    ArithmeticOperationExpr arithmeticOperationExpr =
        ArithmeticOperationExpr.concatWithExprs(lhsExpr, rhsExpr);
    arithmeticOperationExpr.accept(writerVisitor);
    assertThat(writerVisitor.write()).isEqualTo("\"someWord\" + getMethod().getString()");
  }

  @Test
  void writeArithmeticOperationExpr_concatStringWithNumber() {
    ValueExpr rhsExpr =
        ValueExpr.withValue(PrimitiveValue.builder().setType(TypeNode.INT).setValue("5").build());
    ValueExpr lhsExpr = ValueExpr.withValue(StringObjectValue.withValue("someWord"));
    ArithmeticOperationExpr arithmeticOperationExpr =
        ArithmeticOperationExpr.concatWithExprs(lhsExpr, rhsExpr);
    arithmeticOperationExpr.accept(writerVisitor);
    assertThat(writerVisitor.write()).isEqualTo("\"someWord\" + 5");
  }

  /** =============================== COMMENT =============================== */
  @Test
  void writeBlockCommentStatement_basic() {
    String content = "this is a test comment";
    BlockComment blockComment = BlockComment.builder().setComment(content).build();
    CommentStatement commentStatement = CommentStatement.withComment(blockComment);
    String expected = LineFormatter.lines("/*\n", "* this is a test comment\n", "*/\n");
    commentStatement.accept(writerVisitor);
    assertEquals(expected, writerVisitor.write());
  }

  @Test
  void writeLineCommentStatement_basic() {
    String content = "this is a test comment";
    LineComment lineComment = LineComment.builder().setComment(content).build();
    CommentStatement commentStatement = CommentStatement.withComment(lineComment);
    String expected = "// this is a test comment\n";
    commentStatement.accept(writerVisitor);
    assertEquals(expected, writerVisitor.write());
  }

  @Test
  void writeJavaDocCommentStatement_allComponents() {
    String content = "this is a test comment";
    String deprecatedText = "Use the {@link ArchivedBookName} class instead.";
    String paramName = "shelfName";
    String paramDescription = "The name of the shelf where books are published to.";
    String paragraph1 =
        "This class provides the ability to make remote calls to the backing service through"
            + " method calls that map to API methods. Sample code to get started:";
    String paragraph2 =
        "The surface of this class includes several types of Java methods for each of the API's"
            + " methods:";
    String sampleCode = createSampleCode();
    List<String> orderedlList =
        Arrays.asList("A flattened method.", " A request object method.", "A callable method.");
    String throwsType = "com.google.api.gax.rpc.ApiException";
    String throwsDescription = "if the remote call fails.";
    JavaDocComment javaDocComment =
        JavaDocComment.builder()
            .addComment(content)
            .addParagraph(paragraph1)
            .addSampleCode(sampleCode)
            .addParagraph(paragraph2)
            .addOrderedList(orderedlList)
            .addSampleCode(sampleCode)
            .addParam(paramName, paramDescription)
            .setThrows(throwsType, throwsDescription)
            .setDeprecated(deprecatedText)
            .build();
    CommentStatement commentStatement = CommentStatement.withComment(javaDocComment);
    String expected =
        LineFormatter.lines(
            "/**\n",
            "* this is a test comment\n",
            "* <p> This class provides the ability to make remote calls to the backing service"
                + " through method calls that map to API methods. Sample code to get started:\n",
            "* <pre>{@code\n",
            "* try (boolean condition = false) {\n",
            "* int x = 3;\n",
            "* }\n",
            "* }</pre>\n",
            "* <p> The surface of this class includes several types of Java methods for each of"
                + " the API's methods:\n",
            "* <ol>\n",
            "* <li> A flattened method.\n",
            "* <li>  A request object method.\n",
            "* <li> A callable method.\n",
            "* </ol>\n",
            "* <pre>{@code\n",
            "* try (boolean condition = false) {\n",
            "* int x = 3;\n",
            "* }\n",
            "* }</pre>\n",
            "* @param shelfName The name of the shelf where books are published to.\n",
            "* @throws com.google.api.gax.rpc.ApiException if the remote call fails.\n",
            "* @deprecated Use the {@link ArchivedBookName} class instead.\n",
            "*/\n");
    commentStatement.accept(writerVisitor);
    assertEquals(expected, writerVisitor.write());
  }

  @Test
  void writeBlockComment_shortLines() {
    String content = "Apache License \nThis is a test file header";
    BlockComment blockComment = BlockComment.builder().setComment(content).build();
    String expected =
        LineFormatter.lines("/*\n", "* Apache License\n", "* This is a test file header\n", "*/\n");
    blockComment.accept(writerVisitor);
    assertEquals(expected, writerVisitor.write());
  }

  @Test
  void writeBlockComment_newLineInBetween() {
    String content =
        "Apache License \n"
            + "Licensed under the Apache License, Version 2.0 (the \"License\");\n\n"
            + "you may not use this file except in compliance with the License.";
    BlockComment blockComment = BlockComment.builder().setComment(content).build();
    String expected =
        LineFormatter.lines(
            "/*\n",
            "* Apache License\n",
            "* Licensed under the Apache License, Version 2.0 (the \"License\");\n",
            "*\n",
            "* you may not use this file except in compliance with the License.\n",
            "*/\n");
    blockComment.accept(writerVisitor);
    assertEquals(expected, writerVisitor.write());
  }

  @Test
  void writeLineComment_longLine() {
    String content =
        "this is a long test comment with so many words, hello world, hello again, hello for 3"
            + " times, blah, blah!";
    LineComment lineComment = LineComment.builder().setComment(content).build();
    String expected =
        LineFormatter.lines(
            "// this is a long test comment with so many words, hello world, hello again, hello"
                + " for 3 times,\n",
            "// blah, blah!\n");
    lineComment.accept(writerVisitor);
    assertEquals(expected, writerVisitor.write());
  }

  @Test
  void writeLineComment_specialChar() {
    String content =
        "usage: gradle run -PmainClass=com.google.example.examples.library.v1.Hopper"
            + " [--args='[--shelf \"Novel\\\"`\b\t\n\r"
            + "\"]']";
    LineComment lineComment = LineComment.withComment(content);
    String expected =
        LineFormatter.lines(
            "// usage: gradle run -PmainClass=com.google.example.examples.library.v1.Hopper"
                + " [--args='[--shelf\n",
            "// \"Novel\\\\\"`\\b\\t\n",
            "// \\r",
            "\"]']\n");
    lineComment.accept(writerVisitor);
    assertEquals(expected, writerVisitor.write());
  }

  @Test
  void writeJavaDocComment_specialChar() {
    // Only comments and sample codes in JavaDocComment need this escaper.
    // <p> <ol> <li> <ul> are hard-coded in monolith generator, which do not need escaping.
    JavaDocComment javaDocComment =
        JavaDocComment.builder()
            .addComment(
                "The API has a collection of [Shelf][google.example.library.v1.Shelf] resources")
            .addComment("named `bookShelves/*`")
            .addSampleCode(
                "ApiFuture<Shelf> future ="
                    + " libraryClient.createShelfCallable().futureCall(request);")
            .addOrderedList(
                Arrays.asList(
                    "A \"flattened\" method.",
                    "A \"request object\" method.",
                    "A \"callable\" method."))
            .addComment("RPC method comment may include special characters: <>&\"`'@.")
            .build();
    String expected =
        LineFormatter.lines(
            "/**\n",
            "* The API has a collection of [Shelf][google.example.library.v1.Shelf] resources\n",
            "* named `bookShelves/&#42;`\n",
            "* <pre>{@code\n",
            "* ApiFuture<Shelf> future ="
                + " libraryClient.createShelfCallable().futureCall(request);\n",
            "* }</pre>\n",
            "* <ol>\n",
            "* <li> A \"flattened\" method.\n",
            "* <li> A \"request object\" method.\n",
            "* <li> A \"callable\" method.\n",
            "* </ol>\n",
            "* RPC method comment may include special characters: &lt;&gt;&amp;\"`'{@literal @}.\n",
            "*/\n");
    javaDocComment.accept(writerVisitor);
    assertEquals(expected, writerVisitor.write());
  }

  @Test
  void writeFailingComment_specialChar() {
    JavaDocComment javaDocComment =
        JavaDocComment.builder()
            .addUnescapedComment(
                "This resource reference needs to be CommentFormatted or it will fail: `bookShelves/*/`")
            .build();

    FormatException exceptionForIncorrectlyFormattedComment =
        assertThrows(
            FormatException.class,
            () -> {
              javaDocComment.accept(writerVisitor);
            });
    assertThat(exceptionForIncorrectlyFormattedComment)
        .hasMessageThat()
        .contains("The input resource can not be parsed");
  }

  @Test
  void writeTernaryExpr_basic() {
    Variable conditionVariable =
        Variable.builder().setName("condition").setType(TypeNode.BOOLEAN).build();
    VariableExpr conditionExpr = VariableExpr.builder().setVariable(conditionVariable).build();

    Value value1 = PrimitiveValue.builder().setType(TypeNode.INT).setValue("3").build();
    Expr thenExpr = ValueExpr.builder().setValue(value1).build();
    Value value2 = PrimitiveValue.builder().setType(TypeNode.INT).setValue("4").build();
    Expr elseExpr = ValueExpr.builder().setValue(value2).build();

    TernaryExpr ternaryExpr =
        TernaryExpr.builder()
            .setConditionExpr(conditionExpr)
            .setThenExpr(thenExpr)
            .setElseExpr(elseExpr)
            .build();
    ternaryExpr.accept(writerVisitor);
    assertEquals("condition ? 3 : 4", writerVisitor.write());
  }

  @Test
  void writeAssignmentExpr_basicValue() {
    Variable variable = Variable.builder().setName("x").setType(TypeNode.INT).build();
    VariableExpr variableExpr =
        VariableExpr.builder().setVariable(variable).setIsDecl(true).build();

    Value value = PrimitiveValue.builder().setType(TypeNode.INT).setValue("3").build();
    Expr valueExpr = ValueExpr.builder().setValue(value).build();

    AssignmentExpr assignExpr =
        AssignmentExpr.builder().setVariableExpr(variableExpr).setValueExpr(valueExpr).build();

    assignExpr.accept(writerVisitor);
    assertEquals("int x = 3", writerVisitor.write());
  }

  @Test
  void writeAssignmentExpr_varToVar() {
    Variable variable = Variable.builder().setName("foobar").setType(TypeNode.INT).build();
    VariableExpr variableExpr =
        VariableExpr.builder()
            .setVariable(variable)
            .setIsStatic(true)
            .setIsFinal(true)
            .setScope(ScopeNode.PRIVATE)
            .setIsDecl(true)
            .build();

    Variable anotherVariable = Variable.builder().setName("y").setType(TypeNode.INT).build();
    Expr valueExpr = VariableExpr.builder().setVariable(anotherVariable).build();

    AssignmentExpr assignExpr =
        AssignmentExpr.builder().setVariableExpr(variableExpr).setValueExpr(valueExpr).build();

    assignExpr.accept(writerVisitor);
    assertEquals("private static final int foobar = y", writerVisitor.write());
  }

  @Test
  void writeAssignmentExpr_nullObjectValueReferenceType() {
    Variable variable = Variable.builder().setName("x").setType(TypeNode.STRING).build();
    VariableExpr variableExpr =
        VariableExpr.builder().setVariable(variable).setIsDecl(true).build();

    Value value = NullObjectValue.create();
    Expr valueExpr = ValueExpr.builder().setValue(value).build();

    AssignmentExpr assignExpr =
        AssignmentExpr.builder().setVariableExpr(variableExpr).setValueExpr(valueExpr).build();

    assignExpr.accept(writerVisitor);
    assertEquals("String x = null", writerVisitor.write());
  }

  @Test
  void writeStringObjectValue_basic() {
    Value value = StringObjectValue.withValue("test");
    Expr valueExpr = ValueExpr.builder().setValue(value).build();
    valueExpr.accept(writerVisitor);
    assertThat(writerVisitor.write()).isEqualTo("\"test\"");
  }

  @Test
  void writeAssignmentExpr_stringObjectValue() {
    Variable variable = Variable.builder().setName("x").setType(TypeNode.STRING).build();
    VariableExpr variableExpr =
        VariableExpr.builder().setVariable(variable).setIsDecl(true).build();

    Value value = StringObjectValue.withValue("Hi! World. \n");
    Expr valueExpr = ValueExpr.builder().setValue(value).build();
    AssignmentExpr assignExpr =
        AssignmentExpr.builder().setVariableExpr(variableExpr).setValueExpr(valueExpr).build();

    assignExpr.accept(writerVisitor);
    assertThat(writerVisitor.write()).isEqualTo("String x = \"Hi! World. \\n\"");
  }

  @Test
  void writeAssignmentExpr_variableDeclarationWithAnnotation() {
    Variable variable = Variable.builder().setName("x").setType(TypeNode.STRING).build();
    VariableExpr variableExpr =
        VariableExpr.builder()
            .setVariable(variable)
            .setIsDecl(true)
            .setAnnotations(Arrays.asList(AnnotationNode.DEPRECATED, AnnotationNode.DEPRECATED))
            .build();

    Value value = StringObjectValue.withValue("Hi! World. \n");
    Expr valueExpr = ValueExpr.builder().setValue(value).build();
    AssignmentExpr assignExpr =
        AssignmentExpr.builder().setVariableExpr(variableExpr).setValueExpr(valueExpr).build();

    assignExpr.accept(writerVisitor);
    assertThat(writerVisitor.write()).isEqualTo("@Deprecated\nString x = \"Hi! World. \\n\"");
  }

  @Test
  void writeMethodInvocationExpr_basic() {
    MethodInvocationExpr methodExpr =
        MethodInvocationExpr.builder().setMethodName("foobar").build();

    methodExpr.accept(writerVisitor);
    assertEquals("foobar()", writerVisitor.write());
  }

  @Test
  void writeMethodInvocationExpr_staticRef() {
    TypeNode someType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("SomeClass")
                .setPakkage("com.google.api.some.pakkage")
                .build());

    MethodInvocationExpr methodExpr =
        MethodInvocationExpr.builder()
            .setMethodName("foobar")
            .setStaticReferenceType(someType)
            .build();

    methodExpr.accept(writerVisitor);
    assertEquals("SomeClass.foobar()", writerVisitor.write());
  }

  @Test
  void writeMethodInvocationExpr_genericWithArgs() {
    Reference mapReference =
        ConcreteReference.builder()
            .setClazz(HashMap.class)
            .setGenerics(
                Arrays.asList(
                    ConcreteReference.withClazz(String.class),
                    ConcreteReference.withClazz(Integer.class)))
            .build();
    Reference outerMapReference =
        ConcreteReference.builder()
            .setClazz(HashMap.class)
            .setGenerics(Arrays.asList(mapReference, mapReference))
            .build();

    Variable variable = Variable.builder().setType(TypeNode.INT).setName("anArg").build();
    VariableExpr varExpr = VariableExpr.builder().setVariable(variable).build();

    MethodInvocationExpr methodExpr =
        MethodInvocationExpr.builder()
            .setMethodName("foobar")
            .setGenerics(
                Arrays.asList(
                    ConcreteReference.withClazz(String.class),
                    ConcreteReference.withClazz(Double.class),
                    TypeNode.WILDCARD_REFERENCE,
                    outerMapReference))
            .setArguments(Arrays.asList(varExpr, varExpr, varExpr))
            .setExprReferenceExpr(varExpr)
            .setReturnType(TypeNode.STRING)
            .build();

    Variable lhsVariable = Variable.builder().setType(TypeNode.STRING).setName("someStr").build();
    VariableExpr lhsVarExpr =
        VariableExpr.builder().setVariable(lhsVariable).setIsDecl(true).setIsFinal(true).build();

    AssignmentExpr assignExpr =
        AssignmentExpr.builder().setVariableExpr(lhsVarExpr).setValueExpr(methodExpr).build();

    assignExpr.accept(writerVisitor);
    assertEquals(
        "final String someStr = anArg.<String, Double, ?, HashMap<HashMap<String, Integer>,"
            + " HashMap<String, Integer>>>foobar(anArg, anArg, anArg)",
        writerVisitor.write());
  }

  @Test
  void writeMethodInvocationExpr_chained() {
    Variable variable = Variable.builder().setType(TypeNode.INT).setName("libraryClient").build();
    VariableExpr varExpr = VariableExpr.builder().setVariable(variable).build();

    MethodInvocationExpr firstMethodExpr =
        MethodInvocationExpr.builder()
            .setMethodName("streamBooksCallable")
            .setExprReferenceExpr(varExpr)
            .build();
    MethodInvocationExpr secondMethodExpr =
        MethodInvocationExpr.builder()
            .setMethodName("doAnotherThing")
            .setExprReferenceExpr(firstMethodExpr)
            .build();
    MethodInvocationExpr methodExpr =
        MethodInvocationExpr.builder()
            .setMethodName("call")
            .setExprReferenceExpr(secondMethodExpr)
            .build();

    methodExpr.accept(writerVisitor);
    assertEquals(
        "libraryClient.streamBooksCallable().doAnotherThing().call()", writerVisitor.write());
  }

  @Test
  void writeCastExpr_basic() {
    Variable variable = Variable.builder().setType(TypeNode.STRING).setName("str").build();
    VariableExpr varExpr = VariableExpr.builder().setVariable(variable).build();
    CastExpr castExpr =
        CastExpr.builder()
            .setType(TypeNode.withReference(ConcreteReference.withClazz(Object.class)))
            .setExpr(varExpr)
            .build();
    castExpr.accept(writerVisitor);
    assertEquals("((Object) str)", writerVisitor.write());
  }

  @Test
  void writeCastExpr_methodInvocation() {
    TypeNode someType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("SomeClass")
                .setPakkage("com.google.api.some.pakkage")
                .build());

    MethodInvocationExpr methodExpr =
        MethodInvocationExpr.builder()
            .setMethodName("foobar")
            .setStaticReferenceType(someType)
            .setReturnType(TypeNode.STRING)
            .build();
    CastExpr castExpr =
        CastExpr.builder()
            .setType(TypeNode.withReference(ConcreteReference.withClazz(Object.class)))
            .setExpr(methodExpr)
            .build();
    castExpr.accept(writerVisitor);
    assertEquals("((Object) SomeClass.foobar())", writerVisitor.write());
  }

  @Test
  void writeCastExpr_nested() {
    Variable variable = Variable.builder().setType(TypeNode.STRING).setName("str").build();
    VariableExpr varExpr = VariableExpr.builder().setVariable(variable).build();
    CastExpr castExpr =
        CastExpr.builder()
            .setType(TypeNode.withReference(ConcreteReference.withClazz(Object.class)))
            .setExpr(varExpr)
            .build();
    castExpr = CastExpr.builder().setType(TypeNode.STRING).setExpr(castExpr).build();
    castExpr.accept(writerVisitor);
    assertEquals("((String) ((Object) str))", writerVisitor.write());
  }

  @Test
  void writeAnonymousClassExpr_basic() {
    ConcreteReference ref = ConcreteReference.withClazz(Runnable.class);
    TypeNode type = TypeNode.withReference(ref);
    AssignmentExpr assignmentExpr = createAssignmentExpr("foobar", "false", TypeNode.BOOLEAN);
    ExprStatement statement = ExprStatement.withExpr(assignmentExpr);
    MethodDefinition method =
        MethodDefinition.builder()
            .setScope(ScopeNode.PUBLIC)
            .setReturnType(TypeNode.VOID)
            .setName("run")
            .setIsOverride(true)
            .setBody(Arrays.asList(statement))
            .build();

    AnonymousClassExpr anonymousClassExpr =
        AnonymousClassExpr.builder().setType(type).setMethods(Arrays.asList(method)).build();
    anonymousClassExpr.accept(writerVisitor);
    assertEquals(
        LineFormatter.lines(
            "new Runnable() {\n",
            "@Override\n",
            "public void run() {\n",
            "boolean foobar = false;\n}\n\n}"),
        writerVisitor.write());
  }

  @Test
  void writeAnonymousClassExpr_withStatementsMethods() {
    ConcreteReference ref = ConcreteReference.withClazz(Runnable.class);
    TypeNode type = TypeNode.withReference(ref);
    // [Constructing] private static final String s = "foo";
    Variable variable = createVariable("s", TypeNode.STRING);
    VariableExpr variableExpr =
        VariableExpr.builder()
            .setScope(ScopeNode.PRIVATE)
            .setIsDecl(true)
            .setIsFinal(true)
            .setIsStatic(true)
            .setVariable(variable)
            .build();
    ValueExpr valueExpr = ValueExpr.builder().setValue(StringObjectValue.withValue("foo")).build();
    AssignmentExpr assignmentExpr =
        AssignmentExpr.builder().setVariableExpr(variableExpr).setValueExpr(valueExpr).build();
    ExprStatement exprStatement = ExprStatement.withExpr(assignmentExpr);

    MethodDefinition methodDefinition =
        MethodDefinition.builder()
            .setName("run")
            .setIsOverride(true)
            .setScope(ScopeNode.PUBLIC)
            .setReturnType(TypeNode.VOID)
            .setBody(
                Arrays.asList(ExprStatement.withExpr(createAssignmentExpr("x", "3", TypeNode.INT))))
            .build();
    AnonymousClassExpr anonymousClassExpr =
        AnonymousClassExpr.builder()
            .setType(type)
            .setStatements(Arrays.asList(exprStatement))
            .setMethods(Arrays.asList(methodDefinition))
            .build();
    anonymousClassExpr.accept(writerVisitor);
    String expected =
        LineFormatter.lines(
            "new Runnable() {\n",
            "private static final String s = \"foo\";\n",
            "@Override\n",
            "public void run() {\n",
            "int x = 3;\n}\n\n}");
    assertEquals(expected, writerVisitor.write());
  }

  @Test
  void writeAnonymousClassExpr_generics() {
    // [Constructing] Function<List<IOException>, MethodDefinition>
    ConcreteReference exceptionListRef =
        ConcreteReference.builder()
            .setClazz(List.class)
            .setGenerics(Arrays.asList(ConcreteReference.withClazz(IOException.class)))
            .build();
    ConcreteReference methodDefinitionRef = ConcreteReference.withClazz(MethodDefinition.class);
    ConcreteReference ref =
        ConcreteReference.builder()
            .setClazz(Function.class)
            .setGenerics(Arrays.asList(exceptionListRef, methodDefinitionRef))
            .build();
    TypeNode type = TypeNode.withReference(ref);
    // [Constructing] an input argument whose type is `List<IOException>`
    VariableExpr arg =
        VariableExpr.builder()
            .setVariable(
                Variable.builder()
                    .setName("arg")
                    .setType(TypeNode.withReference(exceptionListRef))
                    .build())
            .setIsDecl(true)
            .build();
    // [Constructing] a return variable expression whose type is `MethodDefinition`
    VariableExpr returnArg =
        VariableExpr.builder()
            .setVariable(
                Variable.builder()
                    .setName("returnArg")
                    .setType(TypeNode.withReference(methodDefinitionRef))
                    .build())
            .build();
    MethodDefinition method =
        MethodDefinition.builder()
            .setScope(ScopeNode.PUBLIC)
            .setReturnType(TypeNode.withReference(methodDefinitionRef))
            .setArguments(Arrays.asList(arg))
            .setIsOverride(true)
            .setReturnExpr(returnArg)
            .setName("apply")
            .build();
    AnonymousClassExpr anonymousClassExpr =
        AnonymousClassExpr.builder().setType(type).setMethods(Arrays.asList(method)).build();
    anonymousClassExpr.accept(writerVisitor);
    String expected =
        LineFormatter.lines(
            "new Function<List<IOException>, MethodDefinition>() {\n",
            "@Override\n",
            "public MethodDefinition apply(List<IOException> arg) {\n",
            "return returnArg;\n",
            "}\n\n}");
    assertEquals(expected, writerVisitor.write());
  }

  @Test
  void writeThrowExpr_basic() {
    TypeNode npeType =
        TypeNode.withReference(ConcreteReference.withClazz(NullPointerException.class));
    ThrowExpr throwExpr = ThrowExpr.builder().setType(npeType).build();
    throwExpr.accept(writerVisitor);
    assertEquals("throw new NullPointerException()", writerVisitor.write());
  }

  @Test
  void writeThrowExpr_basicThrowExpr() {
    Expr exprToThrow =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(
                TypeNode.withReference(ConcreteReference.withClazz(Statement.class)))
            .setMethodName("createException")
            .setReturnType(TypeNode.withExceptionClazz(Exception.class))
            .build();

    ThrowExpr throwExpr = ThrowExpr.builder().setThrowExpr(exprToThrow).build();
    throwExpr.accept(writerVisitor);
    assertEquals("throw Statement.createException()", writerVisitor.write());
  }

  @Test
  void writeThrowExpr_basicWithMessage() {
    TypeNode npeType =
        TypeNode.withReference(ConcreteReference.withClazz(NullPointerException.class));
    String message = "Some message asdf";
    ThrowExpr throwExpr = ThrowExpr.builder().setType(npeType).setMessageExpr(message).build();
    throwExpr.accept(writerVisitor);
    assertEquals("throw new NullPointerException(\"Some message asdf\")", writerVisitor.write());
  }

  @Test
  void writeThrowExpr_basicWithCause() {
    TypeNode npeType =
        TypeNode.withReference(ConcreteReference.withClazz(NullPointerException.class));
    ThrowExpr throwExpr =
        ThrowExpr.builder()
            .setType(npeType)
            .setCauseExpr(
                NewObjectExpr.builder()
                    .setType(TypeNode.withReference(ConcreteReference.withClazz(Throwable.class)))
                    .build())
            .build();
    throwExpr.accept(writerVisitor);
    assertEquals("throw new NullPointerException(new Throwable())", writerVisitor.write());
  }

  @Test
  void writeThrowExpr_messageExpr() {
    TypeNode npeType = TypeNode.withExceptionClazz(NullPointerException.class);
    Expr messageExpr =
        MethodInvocationExpr.builder()
            .setMethodName("foobar")
            .setReturnType(TypeNode.STRING)
            .build();
    ThrowExpr throwExpr = ThrowExpr.builder().setType(npeType).setMessageExpr(messageExpr).build();

    throwExpr.accept(writerVisitor);
    assertEquals("throw new NullPointerException(foobar())", writerVisitor.write());
  }

  @Test
  void writeThrowExpr_messageAndCauseExpr() {
    TypeNode npeType = TypeNode.withExceptionClazz(NullPointerException.class);
    Expr messageExpr =
        MethodInvocationExpr.builder()
            .setMethodName("foobar")
            .setReturnType(TypeNode.STRING)
            .build();
    ThrowExpr throwExpr =
        ThrowExpr.builder()
            .setType(npeType)
            .setMessageExpr(messageExpr)
            .setCauseExpr(
                NewObjectExpr.builder()
                    .setType(TypeNode.withReference(ConcreteReference.withClazz(Throwable.class)))
                    .build())
            .build();

    throwExpr.accept(writerVisitor);
    assertEquals(
        "throw new NullPointerException(foobar(), new Throwable())", writerVisitor.write());
  }

  @Test
  void writeInstanceofExpr() {
    Variable variable = Variable.builder().setName("x").setType(TypeNode.STRING).build();
    VariableExpr variableExpr = VariableExpr.builder().setVariable(variable).build();
    InstanceofExpr instanceofExpr =
        InstanceofExpr.builder().setCheckType(TypeNode.STRING).setExpr(variableExpr).build();
    instanceofExpr.accept(writerVisitor);
    assertEquals("x instanceof String", writerVisitor.write());
  }

  @Test
  void writeEnumRefExpr_basic() {
    TypeNode enumType =
        TypeNode.withReference(
            ConcreteReference.builder()
                .setClazz(TypeNode.TypeKind.class)
                .setIsStaticImport(true)
                .build());
    EnumRefExpr enumRefExpr = EnumRefExpr.builder().setName("VOID").setType(enumType).build();

    enumRefExpr.accept(writerVisitor);
    assertEquals("TypeKind.VOID", writerVisitor.write());
  }

  @Test
  void writeEnumRefExpr_nested() {
    TypeNode enumType =
        TypeNode.withReference(ConcreteReference.withClazz(TypeNode.TypeKind.class));
    EnumRefExpr enumRefExpr = EnumRefExpr.builder().setName("VOID").setType(enumType).build();
    enumRefExpr.accept(writerVisitor);
    assertEquals("TypeNode.TypeKind.VOID", writerVisitor.write());
  }

  @Test
  void writeReturnExpr_basic() {
    ReturnExpr returnExpr =
        ReturnExpr.withExpr(ValueExpr.withValue(StringObjectValue.withValue("asdf")));
    returnExpr.accept(writerVisitor);
    assertEquals("return \"asdf\"", writerVisitor.write());
  }

  /** =============================== STATEMENTS =============================== */
  @Test
  void writeExprStatement() {
    TypeNode someType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("SomeClass")
                .setPakkage("com.google.api.some.pakkage")
                .build());

    MethodInvocationExpr methodExpr =
        MethodInvocationExpr.builder()
            .setMethodName("foobar")
            .setStaticReferenceType(someType)
            .build();
    ExprStatement exprStatement = ExprStatement.withExpr(methodExpr);

    exprStatement.accept(writerVisitor);
    assertEquals("SomeClass.foobar();\n", writerVisitor.write());
  }

  @Test
  void writeBlockStatement_empty() {
    BlockStatement blockStatement = BlockStatement.builder().build();
    blockStatement.accept(writerVisitor);
    assertEquals("{\n}\n", writerVisitor.write());
  }

  @Test
  void writeBlockStatement_simple() {
    TypeNode someType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("SomeClass")
                .setPakkage("com.google.api.some.pakkage")
                .build());

    MethodInvocationExpr methodExpr =
        MethodInvocationExpr.builder()
            .setMethodName("foobar")
            .setStaticReferenceType(someType)
            .build();
    BlockStatement blockStatement =
        BlockStatement.builder().setBody(Arrays.asList(ExprStatement.withExpr(methodExpr))).build();

    blockStatement.accept(writerVisitor);
    assertEquals("{\nSomeClass.foobar();\n}\n", writerVisitor.write());
  }

  @Test
  void writeBlockStatement_static() {
    TypeNode someType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("SomeClass")
                .setPakkage("com.google.api.some.pakkage")
                .build());

    MethodInvocationExpr methodExpr =
        MethodInvocationExpr.builder()
            .setMethodName("foobar")
            .setStaticReferenceType(someType)
            .build();
    BlockStatement blockStatement =
        BlockStatement.builder()
            .setIsStatic(true)
            .setBody(
                Arrays.asList(
                    ExprStatement.withExpr(methodExpr), ExprStatement.withExpr(methodExpr)))
            .build();

    blockStatement.accept(writerVisitor);
    assertEquals("static {\nSomeClass.foobar();\nSomeClass.foobar();\n}\n", writerVisitor.write());
  }

  @Test
  void writeIfStatement_simple() {
    AssignmentExpr assignExpr = createAssignmentExpr("x", "3", TypeNode.INT);
    Statement assignExprStatement = ExprStatement.withExpr(assignExpr);
    List<Statement> ifBody = Arrays.asList(assignExprStatement, assignExprStatement);
    VariableExpr condExpr = createVariableExpr("condition", TypeNode.BOOLEAN);

    IfStatement ifStatement =
        IfStatement.builder().setConditionExpr(condExpr).setBody(ifBody).build();

    ifStatement.accept(writerVisitor);
    assertEquals(
        LineFormatter.lines("if (condition) {\n", "int x = 3;\n", "int x = 3;\n", "}\n"),
        writerVisitor.write());
  }

  @Test
  void writeIfStatement_withElse() {
    AssignmentExpr assignExpr = createAssignmentExpr("x", "3", TypeNode.INT);
    Statement assignExprStatement = ExprStatement.withExpr(assignExpr);
    List<Statement> ifBody = Arrays.asList(assignExprStatement, assignExprStatement);
    VariableExpr condExpr = createVariableExpr("condition", TypeNode.BOOLEAN);

    IfStatement ifStatement =
        IfStatement.builder()
            .setConditionExpr(condExpr)
            .setBody(ifBody)
            .setElseBody(ifBody)
            .build();

    ifStatement.accept(writerVisitor);
    assertEquals(
        String.format(
            "%s%s%s" + "%s%s%s%s",
            "if (condition) {\n",
            "int x = 3;\n",
            "int x = 3;\n",
            "} else {\n",
            "int x = 3;\n",
            "int x = 3;\n",
            "}\n"),
        writerVisitor.write());
  }

  @Test
  void writeIfStatement_elseIfs() {
    List<Statement> ifBody =
        Arrays.asList(
            ExprStatement.withExpr(createAssignmentExpr("x", "3", TypeNode.INT)),
            ExprStatement.withExpr(createAssignmentExpr("fooBar", "true", TypeNode.BOOLEAN)));

    VariableExpr condExprOne = createVariableExpr("condition", TypeNode.BOOLEAN);
    VariableExpr condExprTwo = createVariableExpr("fooBarCheck", TypeNode.BOOLEAN);
    VariableExpr condExprThree = createVariableExpr("anotherCondition", TypeNode.BOOLEAN);
    VariableExpr condExprFour = createVariableExpr("lookAtMe", TypeNode.BOOLEAN);

    IfStatement ifStatement =
        IfStatement.builder()
            .setConditionExpr(condExprOne)
            .setBody(ifBody)
            .addElseIf(condExprTwo, ifBody)
            .addElseIf(condExprThree, ifBody)
            .addElseIf(condExprFour, ifBody)
            .build();

    ifStatement.accept(writerVisitor);
    String expected =
        LineFormatter.lines(
            "if (condition) {\n",
            "int x = 3;\n",
            "boolean fooBar = true;\n",
            "} else if (fooBarCheck) {\n",
            "int x = 3;\n",
            "boolean fooBar = true;\n",
            "} else if (anotherCondition) {\n",
            "int x = 3;\n",
            "boolean fooBar = true;\n",
            "} else if (lookAtMe) {\n",
            "int x = 3;\n",
            "boolean fooBar = true;\n",
            "}\n");

    assertEquals(expected, writerVisitor.write());
  }

  @Test
  void writeIfStatement_nested() {
    List<Statement> ifBody =
        Arrays.asList(
            ExprStatement.withExpr(createAssignmentExpr("x", "3", TypeNode.INT)),
            ExprStatement.withExpr(createAssignmentExpr("fooBar", "true", TypeNode.BOOLEAN)));

    VariableExpr condExprOne = createVariableExpr("condition", TypeNode.BOOLEAN);
    VariableExpr condExprTwo = createVariableExpr("fooBarCheck", TypeNode.BOOLEAN);
    VariableExpr condExprThree = createVariableExpr("anotherCondition", TypeNode.BOOLEAN);
    VariableExpr condExprFour = createVariableExpr("lookAtMe", TypeNode.BOOLEAN);

    IfStatement nestedTwoIfStatement =
        IfStatement.builder()
            .setConditionExpr(condExprThree)
            .setBody(ifBody)
            .setElseBody(ifBody)
            .build();
    IfStatement nestedOneIfStatement =
        IfStatement.builder()
            .setConditionExpr(condExprTwo)
            .setBody(
                Arrays.asList(
                    ExprStatement.withExpr(createAssignmentExpr("anInt", "10", TypeNode.INT)),
                    nestedTwoIfStatement))
            .build();
    IfStatement nestedZeroIfStatement =
        IfStatement.builder()
            .setConditionExpr(condExprOne)
            .setBody(Arrays.asList(nestedOneIfStatement))
            .addElseIf(condExprFour, ifBody)
            .build();

    IfStatement ifStatement =
        IfStatement.builder()
            .setConditionExpr(condExprOne)
            .setBody(Arrays.asList(nestedZeroIfStatement))
            .build();

    ifStatement.accept(writerVisitor);

    String expected =
        LineFormatter.lines(
            "if (condition) {\n",
            "if (condition) {\n",
            "if (fooBarCheck) {\n",
            "int anInt = 10;\n",
            "if (anotherCondition) {\n",
            "int x = 3;\n",
            "boolean fooBar = true;\n",
            "} else {\n",
            "int x = 3;\n",
            "boolean fooBar = true;\n",
            "}\n",
            "}\n",
            "} else if (lookAtMe) {\n",
            "int x = 3;\n",
            "boolean fooBar = true;\n",
            "}\n",
            "}\n");
    assertEquals(expected, writerVisitor.write());
  }

  @Test
  void writeWhileStatement_simple() {
    AssignmentExpr assignExpr = createAssignmentExpr("x", "3", TypeNode.INT);
    Statement assignExprStatement = ExprStatement.withExpr(assignExpr);
    List<Statement> whileBody = Arrays.asList(assignExprStatement, assignExprStatement);
    VariableExpr condExpr = createVariableExpr("condition", TypeNode.BOOLEAN);

    WhileStatement whileStatement =
        WhileStatement.builder().setConditionExpr(condExpr).setBody(whileBody).build();

    whileStatement.accept(writerVisitor);
    assertEquals(
        LineFormatter.lines("while (condition) {\n", "int x = 3;\n", "int x = 3;\n", "}\n"),
        writerVisitor.write());
  }

  @Test
  void writeForStatement() {
    AssignmentExpr assignExpr = createAssignmentExpr("x", "3", TypeNode.INT);
    Statement assignExprStatement = ExprStatement.withExpr(assignExpr);
    List<Statement> body = Arrays.asList(assignExprStatement, assignExprStatement);

    VariableExpr varDeclExpr = createVariableDeclExpr("str", TypeNode.STRING);
    Expr collectionExpr = MethodInvocationExpr.builder().setMethodName("getSomeStrings").build();

    ForStatement forStatement =
        ForStatement.builder()
            .setLocalVariableExpr(varDeclExpr)
            .setCollectionExpr(collectionExpr)
            .setBody(body)
            .build();

    forStatement.accept(writerVisitor);
    assertEquals(
        String.format(
            "%s%s%s%s",
            "for (String str : getSomeStrings()) {\n", "int x = 3;\n", "int x = 3;\n", "}\n"),
        writerVisitor.write());
  }

  @Test
  void writeGeneralForStatement_basicIsDecl() {
    AssignmentExpr assignExpr = createAssignmentExpr("x", "3", TypeNode.INT);
    Statement assignExprStatement = ExprStatement.withExpr(assignExpr);
    List<Statement> body = Arrays.asList(assignExprStatement, assignExprStatement);

    VariableExpr localVarExpr = createVariableDeclExpr("i", TypeNode.INT);
    ValueExpr initValueExpr =
        ValueExpr.withValue(PrimitiveValue.builder().setValue("0").setType(TypeNode.INT).build());
    Expr maxSizeExpr =
        MethodInvocationExpr.builder().setMethodName("maxSize").setReturnType(TypeNode.INT).build();

    GeneralForStatement forStatement =
        GeneralForStatement.incrementWith(localVarExpr, initValueExpr, maxSizeExpr, body);

    forStatement.accept(writerVisitor);
    assertEquals(
        String.format(
            "%s%s%s%s",
            "for (int i = 0; i < maxSize(); i++) {\n", "int x = 3;\n", "int x = 3;\n", "}\n"),
        writerVisitor.write());
  }

  @Test
  void writeGeneralForStatement_basicIsNotDecl() {
    AssignmentExpr assignExpr = createAssignmentExpr("x", "3", TypeNode.INT);
    Statement assignExprStatement = ExprStatement.withExpr(assignExpr);
    List<Statement> body = Arrays.asList(assignExprStatement, assignExprStatement);

    VariableExpr localVarExpr = createVariableExpr("i", TypeNode.INT);
    ValueExpr initValueExpr =
        ValueExpr.withValue(PrimitiveValue.builder().setValue("1").setType(TypeNode.INT).build());
    ValueExpr maxValueExpr =
        ValueExpr.withValue(PrimitiveValue.builder().setValue("10").setType(TypeNode.INT).build());

    GeneralForStatement forStatement =
        GeneralForStatement.incrementWith(localVarExpr, initValueExpr, maxValueExpr, body);

    forStatement.accept(writerVisitor);
    assertEquals(
        String.format(
            "%s%s%s%s", "for (i = 1; i < 10; i++) {\n", "int x = 3;\n", "int x = 3;\n", "}\n"),
        writerVisitor.write());
  }

  @Test
  void writeTryCatchStatement_simple() {
    Reference exceptionReference = ConcreteReference.withClazz(IllegalArgumentException.class);
    TypeNode type = TypeNode.withReference(exceptionReference);
    VariableExpr variableExpr =
        VariableExpr.builder().setVariable(createVariable("e", type)).setIsDecl(true).build();

    TryCatchStatement tryCatch =
        TryCatchStatement.builder()
            .setTryBody(
                Arrays.asList(ExprStatement.withExpr(createAssignmentExpr("x", "3", TypeNode.INT))))
            .addCatch(variableExpr, Collections.emptyList())
            .build();

    tryCatch.accept(writerVisitor);
    assertEquals(
        String.format(
            "%s%s%s%s",
            "try {\n", "int x = 3;\n", "} catch (IllegalArgumentException e) {\n", "}\n"),
        writerVisitor.write());
  }

  @Test
  void writeTryCatchStatement_simpleMultiCatch() {
    VariableExpr firstCatchVarExpr =
        VariableExpr.builder()
            .setVariable(
                createVariable("e", TypeNode.withExceptionClazz(IllegalArgumentException.class)))
            .build();
    VariableExpr secondCatchVarExpr =
        VariableExpr.builder()
            .setVariable(createVariable("e", TypeNode.withExceptionClazz(RuntimeException.class)))
            .build();

    TryCatchStatement tryCatch =
        TryCatchStatement.builder()
            .setTryBody(
                Arrays.asList(ExprStatement.withExpr(createAssignmentExpr("x", "3", TypeNode.INT))))
            .addCatch(
                firstCatchVarExpr.toBuilder().setIsDecl(true).build(), Collections.emptyList())
            .addCatch(
                secondCatchVarExpr.toBuilder().setIsDecl(true).build(), Collections.emptyList())
            .build();

    tryCatch.accept(writerVisitor);
    assertEquals(
        LineFormatter.lines(
            "try {\n",
            "int x = 3;\n",
            "} catch (IllegalArgumentException e) {\n",
            "} catch (RuntimeException e) {\n",
            "}\n"),
        writerVisitor.write());
  }

  @Test
  void writeTryCatchStatement_simpleMultiCatchOrderMatters() {
    VariableExpr firstCatchVarExpr =
        VariableExpr.builder()
            .setVariable(
                createVariable("e", TypeNode.withExceptionClazz(IllegalArgumentException.class)))
            .build();
    VariableExpr secondCatchVarExpr =
        VariableExpr.builder()
            .setVariable(createVariable("e", TypeNode.withExceptionClazz(RuntimeException.class)))
            .build();

    TryCatchStatement tryCatch =
        TryCatchStatement.builder()
            .setTryBody(
                Arrays.asList(ExprStatement.withExpr(createAssignmentExpr("x", "3", TypeNode.INT))))
            .addCatch(
                secondCatchVarExpr.toBuilder().setIsDecl(true).build(), Collections.emptyList())
            .addCatch(
                firstCatchVarExpr.toBuilder().setIsDecl(true).build(), Collections.emptyList())
            .build();

    tryCatch.accept(writerVisitor);
    assertEquals(
        LineFormatter.lines(
            "try {\n",
            "int x = 3;\n",
            "} catch (RuntimeException e) {\n",
            "} catch (IllegalArgumentException e) {\n",
            "}\n"),
        writerVisitor.write());
  }

  @Test
  void writeTryCatchStatement_withResources() {
    Reference exceptionReference = ConcreteReference.withClazz(IllegalArgumentException.class);
    TypeNode type = TypeNode.withReference(exceptionReference);
    VariableExpr variableExpr =
        VariableExpr.builder().setVariable(createVariable("e", type)).setIsDecl(true).build();

    TryCatchStatement tryCatch =
        TryCatchStatement.builder()
            .setTryResourceExpr(createAssignmentExpr("aBool", "false", TypeNode.BOOLEAN))
            .setTryBody(
                Arrays.asList(ExprStatement.withExpr(createAssignmentExpr("y", "4", TypeNode.INT))))
            .addCatch(
                variableExpr,
                Arrays.asList(
                    ExprStatement.withExpr(createAssignmentExpr("foobar", "123", TypeNode.INT))))
            .build();

    tryCatch.accept(writerVisitor);
    assertEquals(
        String.format(
            "%s%s%s%s%s",
            "try (boolean aBool = false) {\n",
            "int y = 4;\n",
            "} catch (IllegalArgumentException e) {\n",
            "int foobar = 123;\n",
            "}\n"),
        writerVisitor.write());
  }

  @Test
  void writeTryCatchStatement_sampleCodeNoCatch() {
    TryCatchStatement tryCatch =
        TryCatchStatement.builder()
            .setTryBody(
                Arrays.asList(ExprStatement.withExpr(createAssignmentExpr("x", "3", TypeNode.INT))))
            .setIsSampleCode(true)
            .build();

    tryCatch.accept(writerVisitor);
    assertEquals(LineFormatter.lines("try {\n", "int x = 3;\n", "}\n"), writerVisitor.write());
  }

  @Test
  void writeTryCatchStatement_sampleCodeWithCatch() {
    Reference exceptionReference = ConcreteReference.withClazz(IllegalArgumentException.class);
    TypeNode type = TypeNode.withReference(exceptionReference);
    VariableExpr variableExpr =
        VariableExpr.builder().setVariable(createVariable("e", type)).setIsDecl(true).build();

    TryCatchStatement tryCatch =
        TryCatchStatement.builder()
            .setIsSampleCode(true)
            .setTryResourceExpr(createAssignmentExpr("aBool", "false", TypeNode.BOOLEAN))
            .setTryBody(
                Arrays.asList(ExprStatement.withExpr(createAssignmentExpr("y", "4", TypeNode.INT))))
            .addCatch(
                variableExpr,
                Arrays.asList(
                    ExprStatement.withExpr(createAssignmentExpr("foobar", "123", TypeNode.INT))))
            .build();

    tryCatch.accept(writerVisitor);
    assertEquals(
        String.format(
            "%s%s%s%s%s",
            "try (boolean aBool = false) {\n",
            "int y = 4;\n",
            "} catch (IllegalArgumentException e) {\n",
            "int foobar = 123;\n",
            "}\n"),
        writerVisitor.write());
  }

  @Test
  void writeSynchronizedStatement_basicThis() {
    SynchronizedStatement synchronizedStatement =
        SynchronizedStatement.builder()
            .setLock(
                ThisObjectValue.withType(
                    TypeNode.withReference(ConcreteReference.withClazz(Expr.class))))
            .setBody(
                ExprStatement.withExpr(
                    MethodInvocationExpr.builder().setMethodName("doStuff").build()))
            .build();
    synchronizedStatement.accept(writerVisitor);
    assertEquals(
        LineFormatter.lines("synchronized (this) {\n", "doStuff();\n", "}\n"),
        writerVisitor.write());
  }

  @Test
  void writeSynchronizedStatement_basicVariableExpr() {
    VariableExpr strVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setName("str").setType(TypeNode.STRING).build());

    SynchronizedStatement synchronizedStatement =
        SynchronizedStatement.builder()
            .setLock(strVarExpr)
            .setBody(
                ExprStatement.withExpr(
                    MethodInvocationExpr.builder().setMethodName("doStuff").build()))
            .build();
    synchronizedStatement.accept(writerVisitor);
    assertEquals(
        LineFormatter.lines("synchronized (str) {\n", "doStuff();\n", "}\n"),
        writerVisitor.write());
  }

  @Test
  void writeMethodDefinition_basic() {
    MethodDefinition methodDefinition =
        MethodDefinition.builder()
            .setName("close")
            .setScope(ScopeNode.PUBLIC)
            .setReturnType(TypeNode.VOID)
            .setBody(
                Arrays.asList(ExprStatement.withExpr(createAssignmentExpr("x", "3", TypeNode.INT))))
            .build();

    methodDefinition.accept(writerVisitor);
    assertEquals(
        LineFormatter.lines("public void close() {\n", "int x = 3;\n", "}\n\n"),
        writerVisitor.write());
  }

  @Test
  void writeMethodDefinition_constructor() {
    TypeNode returnType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("LibrarySettings")
                .setPakkage("com.google.example.library.v1")
                .build());
    MethodDefinition methodDefinition =
        MethodDefinition.constructorBuilder()
            .setScope(ScopeNode.PUBLIC)
            .setReturnType(returnType)
            .build();

    methodDefinition.accept(writerVisitor);
    assertEquals("public LibrarySettings() {\n}\n\n", writerVisitor.write());
  }

  @Test
  void writeMethodDefinition_basicEmptyBody() {
    MethodDefinition methodDefinition =
        MethodDefinition.builder()
            .setName("close")
            .setScope(ScopeNode.PUBLIC)
            .setReturnType(TypeNode.VOID)
            .build();

    methodDefinition.accept(writerVisitor);
    assertEquals("public void close() {\n}\n\n", writerVisitor.write());
  }

  @Test
  void writeMethodDefinition_basicAbstract() {
    MethodDefinition methodDefinition =
        MethodDefinition.builder()
            .setName("close")
            .setIsAbstract(true)
            .setScope(ScopeNode.PUBLIC)
            .setReturnType(TypeNode.VOID)
            .setBody(
                Arrays.asList(ExprStatement.withExpr(createAssignmentExpr("x", "3", TypeNode.INT))))
            .build();

    methodDefinition.accept(writerVisitor);
    assertEquals(
        LineFormatter.lines("public abstract void close() {\n", "int x = 3;\n", "}\n\n"),
        writerVisitor.write());
  }

  @Test
  void writeMethodDefinition_basicAbstractEmptyBody() {
    MethodDefinition methodDefinition =
        MethodDefinition.builder()
            .setName("close")
            .setIsAbstract(true)
            .setScope(ScopeNode.PUBLIC)
            .setReturnType(TypeNode.VOID)
            .build();

    methodDefinition.accept(writerVisitor);
    assertEquals("public abstract void close();\n", writerVisitor.write());
  }

  @Test
  void writeMethodDefinition_withArgumentsAndReturnExpr() {
    ValueExpr returnExpr =
        ValueExpr.builder()
            .setValue(PrimitiveValue.builder().setType(TypeNode.INT).setValue("3").build())
            .build();
    List<VariableExpr> arguments =
        Arrays.asList(
            VariableExpr.builder()
                .setVariable(createVariable("x", TypeNode.INT))
                .setIsDecl(true)
                .build(),
            VariableExpr.builder()
                .setVariable(createVariable("y", TypeNode.INT))
                .setIsDecl(true)
                .build());
    MethodDefinition methodDefinition =
        MethodDefinition.builder()
            .setName("close")
            .setScope(ScopeNode.PUBLIC)
            .setReturnType(TypeNode.INT)
            .setArguments(arguments)
            .setReturnExpr(returnExpr)
            .setBody(
                Arrays.asList(
                    ExprStatement.withExpr(
                        createAssignmentExpr("foobar", "false", TypeNode.BOOLEAN))))
            .build();

    methodDefinition.accept(writerVisitor);
    assertEquals(
        LineFormatter.lines(
            "public int close(int x, int y) {\n",
            "boolean foobar = false;\n",
            "return 3;\n",
            "}\n\n"),
        writerVisitor.write());
  }

  @Test
  void writeMethodDefinition_withCommentsAnnotationsAndThrows() {
    LineComment lineComment = LineComment.withComment("AUTO-GENERATED DOCUMENTATION AND METHOD");
    JavaDocComment javaDocComment =
        JavaDocComment.builder()
            .addComment("This is an override method called `close()`")
            .addParam("valOne", "string type")
            .addParam("valTwo", "boolean type")
            .addComment("The return value is int 3.")
            .build();
    ValueExpr returnExpr =
        ValueExpr.builder()
            .setValue(PrimitiveValue.builder().setType(TypeNode.INT).setValue("3").build())
            .build();
    List<VariableExpr> arguments =
        Arrays.asList(
            VariableExpr.builder()
                .setVariable(createVariable("valOne", TypeNode.STRING))
                .setIsDecl(true)
                .build(),
            VariableExpr.builder()
                .setVariable(createVariable("valTwo", TypeNode.BOOLEAN))
                .setIsDecl(true)
                .build());
    MethodDefinition methodDefinition =
        MethodDefinition.builder()
            .setName("close")
            .setIsOverride(true)
            .setIsFinal(true)
            .setIsStatic(true)
            .setScope(ScopeNode.PROTECTED)
            .setReturnType(TypeNode.INT)
            .setThrowsExceptions(
                Arrays.asList(
                    TypeNode.withExceptionClazz(IOException.class),
                    TypeNode.withExceptionClazz(TimeoutException.class),
                    TypeNode.withExceptionClazz(InterruptedException.class)))
            .setArguments(arguments)
            .setReturnExpr(returnExpr)
            .setHeaderCommentStatements(
                Arrays.asList(
                    CommentStatement.withComment(lineComment),
                    CommentStatement.withComment(javaDocComment)))
            .setAnnotations(
                Arrays.asList(
                    AnnotationNode.withSuppressWarnings("all"), AnnotationNode.DEPRECATED))
            .setBody(
                Arrays.asList(
                    createForStatement(),
                    ExprStatement.withExpr(
                        createAssignmentExpr("foobar", "false", TypeNode.BOOLEAN))))
            .build();

    methodDefinition.accept(writerVisitor);
    String expected =
        LineFormatter.lines(
            "// AUTO-GENERATED DOCUMENTATION AND METHOD\n",
            "/**\n",
            "* This is an override method called `close()`\n",
            "* The return value is int 3.\n",
            "* @param valOne string type\n",
            "* @param valTwo boolean type\n",
            "*/\n",
            "@SuppressWarnings(\"all\")\n",
            "@Deprecated\n",
            "@Override\n",
            "protected static final int close(String valOne, boolean valTwo) throws"
                + " IOException, TimeoutException, InterruptedException {\n",
            "for (String str : getSomeStrings()) {\n",
            "boolean aBool = false;\n",
            "}\n",
            "boolean foobar = false;\n",
            "return 3;\n",
            "}\n\n");
    assertEquals(expected, writerVisitor.write());
  }

  @Test
  void writeMethodDefinition_templatedReturnTypeAndArguments() {
    Reference mapRef = ConcreteReference.withClazz(Map.class);
    List<VariableExpr> arguments =
        Arrays.asList(
            VariableExpr.builder()
                .setVariable(createVariable("x", TypeNode.withReference(mapRef)))
                .setIsDecl(true)
                .setTemplateObjects(Arrays.asList("K", TypeNode.STRING))
                .build(),
            VariableExpr.builder()
                .setVariable(createVariable("y", TypeNode.withReference(mapRef)))
                .setIsDecl(true)
                .setTemplateObjects(Arrays.asList("T", "V"))
                .build());

    TypeNode returnType = TypeNode.withReference(mapRef);
    MethodDefinition methodDefinition =
        MethodDefinition.builder()
            .setName("close")
            .setScope(ScopeNode.PUBLIC)
            .setReturnType(returnType)
            .setTemplateNames(Arrays.asList("T", "K", "V"))
            .setReturnTemplateNames(Arrays.asList("K", "V"))
            .setArguments(arguments)
            .setReturnExpr(
                MethodInvocationExpr.builder()
                    .setMethodName("foobar")
                    .setReturnType(returnType)
                    .build())
            .build();

    methodDefinition.accept(writerVisitor);
    assertEquals(
        LineFormatter.lines(
            "public <T, K, V> Map<K, V> close(Map<K, String> x, Map<T, V> y) {\n",
            "return foobar();\n",
            "}\n\n"),
        writerVisitor.write());
  }

  @Test
  void writeClassDefinition_basicWithFileHeader() {
    List<CommentStatement> fileHeader =
        Arrays.asList(CommentStatement.withComment(BlockComment.withComment("Apache License")));
    ClassDefinition classDef =
        ClassDefinition.builder()
            .setFileHeader(fileHeader)
            .setPackageString("com.google.example.library.v1.stub")
            .setName("LibraryServiceStub")
            .setScope(ScopeNode.PUBLIC)
            .build();

    classDef.accept(writerVisitor);
    assertEquals(
        LineFormatter.lines(
            "/*\n",
            " * Apache License\n",
            " */\n\n",
            "package com.google.example.library.v1.stub;\n",
            "\n",
            "public class LibraryServiceStub {}\n"),
        writerVisitor.write());
  }

  @Test
  void writeClassDefinition_withAnnotationsExtendsAndImplements() {
    ClassDefinition classDef =
        ClassDefinition.builder()
            .setPackageString("com.google.example.library.v1.stub")
            .setName("LibraryServiceStub")
            .setScope(ScopeNode.PUBLIC)
            .setIsFinal(true)
            .setAnnotations(
                Arrays.asList(
                    AnnotationNode.DEPRECATED, AnnotationNode.withSuppressWarnings("all")))
            .setExtendsType(TypeNode.STRING)
            .setImplementsTypes(
                Arrays.asList(
                    TypeNode.withReference(ConcreteReference.withClazz(Appendable.class)),
                    TypeNode.withReference(ConcreteReference.withClazz(Cloneable.class)),
                    TypeNode.withReference(ConcreteReference.withClazz(Readable.class))))
            .build();

    classDef.accept(writerVisitor);
    assertEquals(
        LineFormatter.lines(
            "package com.google.example.library.v1.stub;\n",
            "\n",
            "@Deprecated\n",
            "@SuppressWarnings(\"all\")\n",
            "public final class LibraryServiceStub extends String implements Appendable,"
                + " Cloneable, Readable {}\n"),
        writerVisitor.write());
  }

  @Test
  void writeClassDefinition_commentsStatementsAndMethods() {
    LineComment lineComment = LineComment.withComment("AUTO-GENERATED DOCUMENTATION AND CLASS");
    JavaDocComment javaDocComment =
        JavaDocComment.builder()
            .addComment("Class to configure an instance of {@link LibraryServiceStub}.")
            .addParagraph("The default instance has everything set to sensible defaults:")
            .addUnorderedList(
                Arrays.asList(
                    "The default service address (library-example.googleapis.com) and default port"
                        + " (1234) are used.",
                    "Credentials are acquired automatically through Application Default"
                        + " Credentials.",
                    "Retries are configured for idempotent methods but not for non-idempotent"
                        + " methods."))
            .build();
    List<Reference> subGenerics =
        Arrays.asList(
            ConcreteReference.withClazz(String.class),
            ConcreteReference.withClazz(MethodDefinition.class));
    Reference mapEntryReference =
        ConcreteReference.builder().setClazz(Map.Entry.class).setGenerics(subGenerics).build();
    List<Reference> generics =
        Arrays.asList(ConcreteReference.withClazz(ClassDefinition.class), mapEntryReference);
    Reference mapReference =
        ConcreteReference.builder().setClazz(Map.class).setGenerics(generics).build();

    List<Statement> statements =
        Arrays.asList(
            ExprStatement.withExpr(
                VariableExpr.builder()
                    .setVariable(
                        createVariable(
                            "x",
                            TypeNode.withReference(
                                ConcreteReference.withClazz(AssignmentExpr.class))))
                    .setIsDecl(true)
                    .setScope(ScopeNode.PRIVATE)
                    .build()),
            ExprStatement.withExpr(
                VariableExpr.builder()
                    .setVariable(createVariable("y", TypeNode.withReference(mapReference)))
                    .setIsDecl(true)
                    .setScope(ScopeNode.PROTECTED)
                    .build()));

    MethodDefinition methodOne =
        MethodDefinition.builder()
            .setName("open")
            .setScope(ScopeNode.PUBLIC)
            .setReturnType(TypeNode.BOOLEAN)
            .setReturnExpr(
                ValueExpr.builder()
                    .setValue(
                        PrimitiveValue.builder().setType(TypeNode.BOOLEAN).setValue("true").build())
                    .build())
            .build();

    MethodDefinition methodTwo =
        MethodDefinition.builder()
            .setName("close")
            .setScope(ScopeNode.PUBLIC)
            .setReturnType(TypeNode.VOID)
            .setBody(
                Arrays.asList(
                    ExprStatement.withExpr(
                        createAssignmentExpr("foobar", "false", TypeNode.BOOLEAN))))
            .build();

    List<MethodDefinition> methods = Arrays.asList(methodOne, methodTwo);

    ClassDefinition nestedClassDef =
        ClassDefinition.builder()
            .setName("IAmANestedClass")
            .setIsNested(true)
            .setScope(ScopeNode.PRIVATE)
            .setIsStatic(true)
            .setMethods(Arrays.asList(methodOne))
            .build();

    ClassDefinition classDef =
        ClassDefinition.builder()
            .setPackageString("com.google.example.library.v1.stub")
            .setHeaderCommentStatements(
                Arrays.asList(
                    CommentStatement.withComment(lineComment),
                    CommentStatement.withComment(javaDocComment)))
            .setName("LibraryServiceStub")
            .setScope(ScopeNode.PUBLIC)
            .setStatements(statements)
            .setMethods(methods)
            .setNestedClasses(Arrays.asList(nestedClassDef))
            .build();

    classDef.accept(writerVisitor);
    String expected =
        LineFormatter.lines(
            "package com.google.example.library.v1.stub;\n",
            "\n",
            "import com.google.api.generator.engine.ast.AssignmentExpr;\n",
            "import com.google.api.generator.engine.ast.ClassDefinition;\n",
            "import com.google.api.generator.engine.ast.MethodDefinition;\n",
            "import java.util.Map;\n",
            "\n",
            "// AUTO-GENERATED DOCUMENTATION AND CLASS\n",
            "/**\n",
            " * Class to configure an instance of {{@literal @}link LibraryServiceStub}.\n",
            " *\n",
            " * <p>The default instance has everything set to sensible defaults:\n",
            " *\n",
            " * <ul>\n",
            " *   <li>The default service address (library-example.googleapis.com) and default"
                + " port (1234) are\n",
            " *       used.\n",
            " *   <li>Credentials are acquired automatically through Application Default"
                + " Credentials.\n",
            " *   <li>Retries are configured for idempotent methods but not for non-idempotent"
                + " methods.\n",
            " * </ul>\n",
            " */\n",
            "public class LibraryServiceStub {\n",
            "  private AssignmentExpr x;\n",
            "  protected Map<ClassDefinition, Map.Entry<String, MethodDefinition>> y;\n\n",
            "  public boolean open() {\n",
            "    return true;\n",
            "  }\n\n",
            "  public void close() {\n",
            "    boolean foobar = false;\n",
            "  }\n",
            "\n",
            "  private static class IAmANestedClass {\n\n",
            "    public boolean open() {\n",
            "      return true;\n",
            "    }\n",
            "  }\n",
            "}\n");
    assertEquals(expected, writerVisitor.write());
  }

  @Test
  void writeClassDefinition_withImportCollision() {

    VaporReference firstType =
        VaporReference.builder()
            .setName("Service")
            .setPakkage("com.google.api.generator.gapic.model")
            .build();

    VaporReference secondType =
        VaporReference.builder().setName("Service").setPakkage("com.google.api").build();

    Variable secondTypeVar =
        Variable.builder()
            .setName("anotherServiceVar")
            .setType(TypeNode.withReference(secondType))
            .build();

    MethodInvocationExpr genericMethodInvocation =
        MethodInvocationExpr.builder()
            .setMethodName("barMethod")
            .setStaticReferenceType(TypeNode.withReference(firstType))
            .setGenerics(Arrays.asList(secondType))
            .setArguments(VariableExpr.withVariable(secondTypeVar))
            .setReturnType(TypeNode.STRING)
            .build();

    List<Statement> statements = Arrays.asList(ExprStatement.withExpr(genericMethodInvocation));

    MethodDefinition methodOne =
        MethodDefinition.builder()
            .setName("doSomething")
            .setScope(ScopeNode.PRIVATE)
            .setBody(statements)
            .setReturnType(TypeNode.VOID)
            .build();

    List<MethodDefinition> methods = Arrays.asList(methodOne);

    ClassDefinition classDef =
        ClassDefinition.builder()
            .setPackageString("com.google.example")
            .setName("FooService")
            .setScope(ScopeNode.PUBLIC)
            .setMethods(methods)
            .build();

    classDef.accept(writerVisitor);

    String expected =
        LineFormatter.lines(
            "package com.google.example;\n"
                + "\n"
                + "import com.google.api.generator.gapic.model.Service;\n"
                + "\n"
                + "public class FooService {\n"
                + "\n"
                + "  private void doSomething() {\n"
                + "    Service.<com.google.api.Service>barMethod(anotherServiceVar);\n"
                + "  }\n"
                + "}\n");

    assertThat(writerVisitor.write()).isEqualTo(expected);
  }

  @Test
  void writeReferenceConstructorExpr_thisConstructorWithArguments() {
    VaporReference ref =
        VaporReference.builder().setName("Student").setPakkage("com.google.example.v1").build();
    TypeNode classType = TypeNode.withReference(ref);
    VariableExpr idVarExpr =
        VariableExpr.builder()
            .setVariable(Variable.builder().setName("id").setType(TypeNode.STRING).build())
            .build();
    VariableExpr nameVarExpr =
        VariableExpr.builder()
            .setVariable(Variable.builder().setName("name").setType(TypeNode.STRING).build())
            .build();
    ReferenceConstructorExpr referenceConstructorExpr =
        ReferenceConstructorExpr.thisBuilder()
            .setArguments(Arrays.asList(idVarExpr, nameVarExpr))
            .setType(classType)
            .build();
    referenceConstructorExpr.accept(writerVisitor);
    assertThat(writerVisitor.write()).isEqualTo("this(id, name)");
  }

  @Test
  void writeReferenceConstructorExpr_superConstructorWithNoArguments() {
    VaporReference ref =
        VaporReference.builder().setName("Parent").setPakkage("com.google.example.v1").build();
    TypeNode classType = TypeNode.withReference(ref);
    ReferenceConstructorExpr referenceConstructorExpr =
        ReferenceConstructorExpr.superBuilder().setType(classType).build();
    referenceConstructorExpr.accept(writerVisitor);
    assertThat(writerVisitor.write()).isEqualTo("super()");
  }

  @Test
  void writeThisObjectValue_methodReturn() {
    VaporReference ref =
        VaporReference.builder().setName("Student").setPakkage("com.google.example.v1").build();
    TypeNode classType = TypeNode.withReference(ref);
    MethodDefinition methodDefinition =
        MethodDefinition.builder()
            .setName("apply")
            .setScope(ScopeNode.PUBLIC)
            .setReturnType(TypeNode.withReference(ref))
            .setReturnExpr(
                ValueExpr.builder().setValue(ThisObjectValue.withType(classType)).build())
            .build();
    methodDefinition.accept(writerVisitor);
    assertEquals(
        LineFormatter.lines("public Student apply() {\n", "return this;\n", "}\n\n"),
        writerVisitor.write());
  }

  @Test
  void writeThisObjectValue_accessFieldAndInvokeMethod() {
    VaporReference ref =
        VaporReference.builder().setName("Student").setPakkage("com.google.example.v1").build();
    TypeNode classType = TypeNode.withReference(ref);
    ThisObjectValue thisObjectValue = ThisObjectValue.withType(classType);
    ValueExpr thisValueExpr = ValueExpr.withValue(thisObjectValue);
    VariableExpr varExpr =
        VariableExpr.builder()
            .setVariable(Variable.builder().setName("id").setType(TypeNode.STRING).build())
            .build();
    Variable subVariable = Variable.builder().setName("name").setType(TypeNode.STRING).build();
    VariableExpr thisVariableExpr =
        VariableExpr.builder().setVariable(subVariable).setExprReferenceExpr(thisValueExpr).build();

    MethodInvocationExpr methodExpr =
        MethodInvocationExpr.builder()
            .setMethodName("getName")
            .setExprReferenceExpr(ValueExpr.withValue(thisObjectValue))
            .setArguments(Arrays.asList(varExpr))
            .setReturnType(TypeNode.STRING)
            .build();
    AssignmentExpr assignmentExpr =
        AssignmentExpr.builder().setVariableExpr(thisVariableExpr).setValueExpr(methodExpr).build();

    assignmentExpr.accept(writerVisitor);
    assertThat(writerVisitor.write()).isEqualTo("this.name = this.getName(id)");
  }

  @Test
  void writeSuperObjectValue_accessFieldAndInvokeMethod() {
    VaporReference ref =
        VaporReference.builder().setName("Student").setPakkage("com.google.example.v1").build();
    TypeNode classType = TypeNode.withReference(ref);
    SuperObjectValue superObjectValue = SuperObjectValue.withType(classType);
    ValueExpr superValueExpr = ValueExpr.withValue(superObjectValue);
    Variable subVariable = Variable.builder().setName("name").setType(TypeNode.STRING).build();
    VariableExpr superVariableExpr =
        VariableExpr.builder()
            .setVariable(subVariable)
            .setExprReferenceExpr(superValueExpr)
            .build();

    MethodInvocationExpr methodExpr =
        MethodInvocationExpr.builder()
            .setMethodName("getName")
            .setExprReferenceExpr(ValueExpr.withValue(superObjectValue))
            .setReturnType(TypeNode.STRING)
            .build();
    AssignmentExpr assignmentExpr =
        AssignmentExpr.builder()
            .setVariableExpr(superVariableExpr)
            .setValueExpr(methodExpr)
            .build();

    assignmentExpr.accept(writerVisitor);
    assertThat(writerVisitor.write()).isEqualTo("super.name = super.getName()");
  }

  @Test
  void writeUnaryOperationExpr_postfixIncrement() {
    VariableExpr variableExpr =
        VariableExpr.withVariable(Variable.builder().setType(TypeNode.INT).setName("i").build());
    UnaryOperationExpr postIncrementOperationExpr =
        UnaryOperationExpr.postfixIncrementWithExpr(variableExpr);
    postIncrementOperationExpr.accept(writerVisitor);
    assertThat(writerVisitor.write()).isEqualTo("i++");
  }

  @Test
  void writeUnaryOperationExpr_logicalNot() {
    MethodInvocationExpr methodInvocationExpr =
        MethodInvocationExpr.builder()
            .setMethodName("isEmpty")
            .setReturnType(TypeNode.BOOLEAN)
            .build();
    UnaryOperationExpr logicalNotOperationExpr =
        UnaryOperationExpr.logicalNotWithExpr(methodInvocationExpr);
    logicalNotOperationExpr.accept(writerVisitor);
    assertThat(writerVisitor.write()).isEqualTo("!isEmpty()");
  }

  @Test
  void writeRelationalOperationExpr_equalTo() {
    VariableExpr variableExprLHS =
        VariableExpr.withVariable(
            Variable.builder().setType(TypeNode.BOOLEAN_OBJECT).setName("isGood").build());
    MethodInvocationExpr methodInvocationExpr =
        MethodInvocationExpr.builder()
            .setMethodName("isBad")
            .setReturnType(TypeNode.BOOLEAN)
            .build();

    RelationalOperationExpr equalToOperationExpr =
        RelationalOperationExpr.equalToWithExprs(variableExprLHS, methodInvocationExpr);
    equalToOperationExpr.accept(writerVisitor);
    assertThat(writerVisitor.write()).isEqualTo("isGood == isBad()");
  }

  @Test
  void writeRelationOperationExpr_notEqualTo() {
    TypeNode someType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("SomeClass")
                .setPakkage("com.google.api.generator.engine")
                .build());
    MethodInvocationExpr lhsExpr =
        MethodInvocationExpr.builder()
            .setMethodName("getName")
            .setStaticReferenceType(someType)
            .setReturnType(TypeNode.STRING)
            .build();
    ValueExpr rhsExpr = ValueExpr.createNullExpr();

    RelationalOperationExpr notEqualToOperationExpr =
        RelationalOperationExpr.notEqualToWithExprs(lhsExpr, rhsExpr);
    notEqualToOperationExpr.accept(writerVisitor);
    assertThat(writerVisitor.write()).isEqualTo("SomeClass.getName() != null");
  }

  @Test
  void writeRelationalOperationExpr_lessThan() {
    VariableExpr lhsExpr = VariableExpr.withVariable(createVariable("i", TypeNode.INT));
    MethodInvocationExpr rhsExpr =
        MethodInvocationExpr.builder()
            .setMethodName("getMaxNumber")
            .setReturnType(TypeNode.INT)
            .build();

    RelationalOperationExpr lessThanWithExprs =
        RelationalOperationExpr.lessThanWithExprs(lhsExpr, rhsExpr);
    lessThanWithExprs.accept(writerVisitor);
    assertThat(writerVisitor.write()).isEqualTo("i < getMaxNumber()");
  }

  @Test
  void writeLogicalOperationExpr_logicalAnd() {
    VariableExpr lhsExpr = VariableExpr.withVariable(createVariable("isEmpty", TypeNode.BOOLEAN));
    VaporReference ref =
        VaporReference.builder().setName("Student").setPakkage("com.google.example.v1").build();
    TypeNode classType = TypeNode.withReference(ref);
    MethodInvocationExpr rhsExpr =
        MethodInvocationExpr.builder()
            .setMethodName("isValid")
            .setExprReferenceExpr(ValueExpr.withValue(ThisObjectValue.withType(classType)))
            .setReturnType(TypeNode.BOOLEAN)
            .build();
    LogicalOperationExpr logicalOperationExpr =
        LogicalOperationExpr.logicalAndWithExprs(lhsExpr, rhsExpr);
    logicalOperationExpr.accept(writerVisitor);
    assertThat(writerVisitor.write()).isEqualTo("isEmpty && this.isValid()");
  }

  @Test
  void writeLogicalOperationExpr_logicalOr() {
    VariableExpr lhsExpr = VariableExpr.withVariable(createVariable("isGood", TypeNode.BOOLEAN));
    MethodInvocationExpr rhsExpr =
        MethodInvocationExpr.builder()
            .setMethodName("isValid")
            .setReturnType(TypeNode.BOOLEAN)
            .build();
    LogicalOperationExpr logicalOperationExpr =
        LogicalOperationExpr.logicalOrWithExprs(lhsExpr, rhsExpr);
    logicalOperationExpr.accept(writerVisitor);
    assertThat(writerVisitor.write()).isEqualTo("isGood || isValid()");
  }

  @Test
  void writeAssignmentOperationExpr_multiplyAssignment() {
    VariableExpr lhsExpr = createVariableExpr("h", TypeNode.INT);
    ValueExpr rhsExpr =
        ValueExpr.withValue(
            PrimitiveValue.builder().setType(TypeNode.INT).setValue("1000003").build());
    AssignmentOperationExpr assignmentOperationExpr =
        AssignmentOperationExpr.multiplyAssignmentWithExprs(lhsExpr, rhsExpr);
    assignmentOperationExpr.accept(writerVisitor);
    assertThat(writerVisitor.write()).isEqualTo("h *= 1000003");
  }

  @Test
  void writeAssignmentOperationExpr_xorAssignment() {
    VariableExpr lhsExpr = createVariableExpr("h", TypeNode.INT);
    TypeNode objectType =
        TypeNode.withReference(
            VaporReference.builder().setName("Objects").setPakkage("java.lang.Object").build());
    MethodInvocationExpr rhsExpr =
        MethodInvocationExpr.builder()
            .setReturnType(TypeNode.INT)
            .setMethodName("hashCode")
            .setStaticReferenceType(objectType)
            .setArguments(
                Arrays.asList(
                    VariableExpr.withVariable(createVariable("fixedValue", TypeNode.OBJECT))))
            .build();
    AssignmentOperationExpr assignmentOperationExpr =
        AssignmentOperationExpr.xorAssignmentWithExprs(lhsExpr, rhsExpr);
    assignmentOperationExpr.accept(writerVisitor);
    assertThat(writerVisitor.write()).isEqualTo("h ^= Objects.hashCode(fixedValue)");
  }

  @Test
  void writeLambdaExpr_noParameters() {
    LambdaExpr lambdaExpr =
        LambdaExpr.builder()
            .setReturnExpr(ValueExpr.withValue(StringObjectValue.withValue("foo")))
            .build();
    lambdaExpr.accept(writerVisitor);
    assertEquals("() -> \"foo\"", writerVisitor.write());
  }

  @Test
  void writeLambdaExpr_assignToVariable() {
    LambdaExpr lambdaExpr =
        LambdaExpr.builder()
            .setReturnExpr(ValueExpr.withValue(StringObjectValue.withValue("foo")))
            .build();
    AssignmentExpr assignmentExpr =
        AssignmentExpr.builder()
            .setVariableExpr(
                VariableExpr.withVariable(
                    Variable.builder().setName("word").setType(TypeNode.STRING).build()))
            .setValueExpr(lambdaExpr)
            .build();
    assignmentExpr.accept(writerVisitor);
    assertEquals("word = () -> \"foo\"", writerVisitor.write());
  }

  @Test
  void writeLambdaExpr_oneParameter() {
    VariableExpr argVarExpr =
        VariableExpr.builder()
            .setVariable(Variable.builder().setName("arg").setType(TypeNode.INT).build())
            .setIsDecl(true)
            .build();

    LambdaExpr lambdaExpr =
        LambdaExpr.builder()
            .setArguments(argVarExpr)
            .setReturnExpr(ValueExpr.withValue(StringObjectValue.withValue("foo")))
            .build();
    lambdaExpr.accept(writerVisitor);
    assertEquals("arg -> \"foo\"", writerVisitor.write());
  }

  @Test
  void writeLambdaExpr_severalParameters() {
    VariableExpr argOneVarExpr =
        VariableExpr.builder()
            .setVariable(Variable.builder().setName("arg").setType(TypeNode.INT).build())
            .setIsDecl(true)
            .build();
    VariableExpr argTwoVarExpr =
        VariableExpr.builder()
            .setVariable(Variable.builder().setName("arg2").setType(TypeNode.STRING).build())
            .setIsDecl(true)
            .build();
    VariableExpr argThreeVarExpr =
        VariableExpr.builder()
            .setVariable(Variable.builder().setName("arg3").setType(TypeNode.BOOLEAN).build())
            .setIsDecl(true)
            .build();

    LambdaExpr lambdaExpr =
        LambdaExpr.builder()
            .setArguments(argOneVarExpr, argTwoVarExpr, argThreeVarExpr)
            .setReturnExpr(ValueExpr.withValue(StringObjectValue.withValue("foo")))
            .build();
    lambdaExpr.accept(writerVisitor);
    assertEquals("(int arg, String arg2, boolean arg3) -> \"foo\"", writerVisitor.write());
  }

  @Test
  void writeLambdaExpr_body() {
    VariableExpr argVarExpr =
        VariableExpr.builder()
            .setVariable(Variable.builder().setName("arg").setType(TypeNode.INT).build())
            .build();
    VariableExpr fooVarExpr =
        VariableExpr.builder()
            .setVariable(Variable.builder().setName("foo").setType(TypeNode.INT).build())
            .build();

    ExprStatement statement =
        ExprStatement.withExpr(
            AssignmentExpr.builder()
                .setVariableExpr(fooVarExpr.toBuilder().setIsDecl(true).build())
                .setValueExpr(
                    ValueExpr.builder()
                        .setValue(
                            PrimitiveValue.builder().setType(TypeNode.INT).setValue("1").build())
                        .build())
                .build());

    LambdaExpr lambdaExpr =
        LambdaExpr.builder()
            .setArguments(argVarExpr.toBuilder().setIsDecl(true).build())
            .setReturnExpr(ValueExpr.withValue(StringObjectValue.withValue("foo")))
            .setBody(Arrays.asList(statement))
            .build();
    lambdaExpr.accept(writerVisitor);
    assertEquals("arg -> {\nint foo = 1;\nreturn \"foo\";\n}", writerVisitor.write());
  }

  @Test
  void writeEmptyLineStatement() {
    EmptyLineStatement statement = EmptyLineStatement.create();
    statement.accept(writerVisitor);
    assertEquals("\n", writerVisitor.write());
  }

  @Test
  void writeBreakStatement() {
    BreakStatement statement = BreakStatement.create();
    statement.accept(writerVisitor);
    assertEquals("break;", writerVisitor.write());
  }

  @Test
  void writePackageInfoDefinition() {
    PackageInfoDefinition packageInfo =
        PackageInfoDefinition.builder()
            .setPakkage("com.google.example.library.v1")
            .setAnnotations(
                AnnotationNode.withType(
                    TypeNode.withReference(ConcreteReference.withClazz(Generated.class))))
            .setFileHeader(
                CommentStatement.withComment(
                    BlockComment.withComment("Lorum ipsum dolor sit amet")))
            .setHeaderCommentStatements(
                CommentStatement.withComment(
                    JavaDocComment.withComment("Consecteteur adipisping elit")))
            .build();

    packageInfo.accept(writerVisitor);
    assertEquals(
        LineFormatter.lines(
            "/*\n",
            " * Lorum ipsum dolor sit amet\n",
            " */\n",
            "\n",
            "/** Consecteteur adipisping elit */\n",
            "@Generated\n",
            "package com.google.example.library.v1;\n",
            "\n",
            "import javax.annotation.Generated;\n"),
        writerVisitor.write());
  }

  /** =============================== GOLDEN TESTS =============================== */
  @Test
  void writeSGrpcServiceClientWithNestedClassImport() {
    GapicContext context = TestProtoLoader.instance().parseNestedMessage();
    Service nestedService = context.services().get(0);
    GapicClass clazz = ServiceClientClassComposer.instance().generate(context, nestedService);

    Assert.assertGoldenClass(
        this.getClass(), clazz, "GrpcServiceClientWithNestedClassImport.golden");
  }

  /** =============================== HELPERS =============================== */
  private static AssignmentExpr createAssignmentExpr(
      String variableName, String value, TypeNode type) {
    VariableExpr variableExpr = createVariableDeclExpr(variableName, type);
    Value val = PrimitiveValue.builder().setType(type).setValue(value).build();
    Expr valueExpr = ValueExpr.builder().setValue(val).build();
    return AssignmentExpr.builder().setVariableExpr(variableExpr).setValueExpr(valueExpr).build();
  }

  private static VariableExpr createVariableExpr(String variableName, TypeNode type) {
    return createVariableExpr(variableName, type, false);
  }

  private static VariableExpr createVariableDeclExpr(String variableName, TypeNode type) {
    return createVariableExpr(variableName, type, true);
  }

  private static VariableExpr createVariableExpr(
      String variableName, TypeNode type, boolean isDecl) {
    return VariableExpr.builder()
        .setVariable(createVariable(variableName, type))
        .setIsDecl(isDecl)
        .build();
  }

  private static Variable createVariable(String variableName, TypeNode type) {
    return Variable.builder().setName(variableName).setType(type).build();
  }

  private static ForStatement createForStatement() {
    Expr collectionExpr = MethodInvocationExpr.builder().setMethodName("getSomeStrings").build();
    ExprStatement assignExprStatement =
        ExprStatement.withExpr(createAssignmentExpr("aBool", "false", TypeNode.BOOLEAN));
    List<Statement> body = Arrays.asList(assignExprStatement);
    return ForStatement.builder()
        .setLocalVariableExpr(createVariableDeclExpr("str", TypeNode.STRING))
        .setCollectionExpr(collectionExpr)
        .setBody(body)
        .build();
  }

  private static String createSampleCode() {
    JavaWriterVisitor writerVisitor = new JavaWriterVisitor();
    TryCatchStatement tryCatch =
        TryCatchStatement.builder()
            .setTryResourceExpr(createAssignmentExpr("condition", "false", TypeNode.BOOLEAN))
            .setTryBody(
                Arrays.asList(ExprStatement.withExpr(createAssignmentExpr("x", "3", TypeNode.INT))))
            .setIsSampleCode(true)
            .build();

    tryCatch.accept(writerVisitor);
    return writerVisitor.write();
  }
}
