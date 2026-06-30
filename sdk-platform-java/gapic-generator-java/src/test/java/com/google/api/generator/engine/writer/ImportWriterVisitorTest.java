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

import com.google.api.generator.engine.ast.AnnotationNode;
import com.google.api.generator.engine.ast.AnonymousClassExpr;
import com.google.api.generator.engine.ast.ArithmeticOperationExpr;
import com.google.api.generator.engine.ast.ArrayExpr;
import com.google.api.generator.engine.ast.AssignmentExpr;
import com.google.api.generator.engine.ast.BlockComment;
import com.google.api.generator.engine.ast.CommentStatement;
import com.google.api.generator.engine.ast.ConcreteReference;
import com.google.api.generator.engine.ast.EmptyLineStatement;
import com.google.api.generator.engine.ast.EnumRefExpr;
import com.google.api.generator.engine.ast.Expr;
import com.google.api.generator.engine.ast.ExprStatement;
import com.google.api.generator.engine.ast.IfStatement;
import com.google.api.generator.engine.ast.InstanceofExpr;
import com.google.api.generator.engine.ast.JavaDocComment;
import com.google.api.generator.engine.ast.LambdaExpr;
import com.google.api.generator.engine.ast.LogicalOperationExpr;
import com.google.api.generator.engine.ast.MethodDefinition;
import com.google.api.generator.engine.ast.MethodInvocationExpr;
import com.google.api.generator.engine.ast.NewObjectExpr;
import com.google.api.generator.engine.ast.PackageInfoDefinition;
import com.google.api.generator.engine.ast.Reference;
import com.google.api.generator.engine.ast.ReferenceConstructorExpr;
import com.google.api.generator.engine.ast.RelationalOperationExpr;
import com.google.api.generator.engine.ast.ReturnExpr;
import com.google.api.generator.engine.ast.ScopeNode;
import com.google.api.generator.engine.ast.Statement;
import com.google.api.generator.engine.ast.SuperObjectValue;
import com.google.api.generator.engine.ast.SynchronizedStatement;
import com.google.api.generator.engine.ast.TernaryExpr;
import com.google.api.generator.engine.ast.ThisObjectValue;
import com.google.api.generator.engine.ast.ThrowExpr;
import com.google.api.generator.engine.ast.TypeNode;
import com.google.api.generator.engine.ast.UnaryOperationExpr;
import com.google.api.generator.engine.ast.ValueExpr;
import com.google.api.generator.engine.ast.VaporReference;
import com.google.api.generator.engine.ast.Variable;
import com.google.api.generator.engine.ast.VariableExpr;
import com.google.api.generator.test.utils.LineFormatter;
import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.testgapic.v1beta1.Outer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.annotation.Repeatable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.LongStream;
import javax.annotation.Generated;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ImportWriterVisitorTest {
  private static final String CURRENT_PACKAGE = "com.google.api.generator.engine.foobar";
  private static final String CURRENT_CLASS = "SomeClass";
  private ImportWriterVisitor writerVisitor;

  @BeforeEach
  void setUp() {
    writerVisitor = new ImportWriterVisitor();
    writerVisitor.initialize(CURRENT_PACKAGE, CURRENT_CLASS);
  }

  @Test
  void writeReferenceTypeImports_basic() {
    TypeNode.withReference(ConcreteReference.withClazz(List.class)).accept(writerVisitor);
    assertEquals("import java.util.List;\n\n", writerVisitor.write());

    writerVisitor.clear();
    TypeNode.withReference(
            VaporReference.builder().setName("FooBar").setPakkage("com.foo.bar").build())
        .accept(writerVisitor);
    assertEquals("import com.foo.bar.FooBar;\n\n", writerVisitor.write());
  }

  @Test
  void writeReferenceTypeImports_useFullName() {
    TypeNode.withReference(
            ConcreteReference.builder().setClazz(List.class).setUseFullName(true).build())
        .accept(writerVisitor);
    assertEquals("", writerVisitor.write());

    writerVisitor.clear();
    TypeNode.withReference(
            VaporReference.builder()
                .setName("FooBar")
                .setPakkage("com.foo.bar")
                .setUseFullName(true)
                .build())
        .accept(writerVisitor);
    assertEquals("", writerVisitor.write());
  }

  @Test
  void writeNewObjectExprImports_basic() {
    // [Constructing] `new ArrayList<>()`
    NewObjectExpr newObjectExpr =
        NewObjectExpr.builder()
            .setIsGeneric(true)
            .setType(TypeNode.withReference(ConcreteReference.withClazz(ArrayList.class)))
            .build();
    newObjectExpr.accept(writerVisitor);
    assertEquals("import java.util.ArrayList;\n\n", writerVisitor.write());
  }

  @Test
  void writeNewObjectExprImports_withArgs() {
    // [Constructing] `new FileOutputStream(File file)` and the argument needs to be imported.
    ConcreteReference fileOutputStreamRef = ConcreteReference.withClazz(FileOutputStream.class);
    ConcreteReference fileRef = ConcreteReference.withClazz(File.class);
    Variable fileVar =
        Variable.builder().setName("file").setType(TypeNode.withReference(fileRef)).build();
    VariableExpr fileExpr = VariableExpr.builder().setVariable(fileVar).build();
    NewObjectExpr newObjectExpr =
        NewObjectExpr.builder()
            .setType(TypeNode.withReference(fileOutputStreamRef))
            .setArguments(Arrays.asList(fileExpr))
            .build();
    newObjectExpr.accept(writerVisitor);
    assertEquals(
        LineFormatter.lines("import java.io.File;\n", "import java.io.FileOutputStream;\n\n"),
        writerVisitor.write());
  }

  @Test
  void writeNewObjectExprImports_genericsAndVariableArgs() {
    // [Constructing] `new HashMap<List<String>, Integer>>(int initialCapacity, float loadFactor)`
    ConcreteReference listRef =
        ConcreteReference.builder()
            .setClazz(List.class)
            .setGenerics(Arrays.asList(ConcreteReference.withClazz(String.class)))
            .build();
    ConcreteReference mapRef =
        ConcreteReference.builder()
            .setClazz(HashMap.class)
            .setGenerics(Arrays.asList(listRef, ConcreteReference.withClazz(Integer.class)))
            .build();
    TypeNode type = TypeNode.withReference(mapRef);
    Variable initialCapacity =
        Variable.builder().setName("initialCapacity").setType(TypeNode.INT).build();
    VariableExpr initCapacityExpr = VariableExpr.builder().setVariable(initialCapacity).build();
    Variable loadFactor = Variable.builder().setName("loadFactor").setType(TypeNode.FLOAT).build();
    VariableExpr loadFactorExpr = VariableExpr.builder().setVariable(loadFactor).build();

    NewObjectExpr newObjectExpr =
        NewObjectExpr.builder()
            .setIsGeneric(true)
            .setType(type)
            .setArguments(Arrays.asList(initCapacityExpr, loadFactorExpr))
            .build();
    newObjectExpr.accept(writerVisitor);
    assertEquals(
        LineFormatter.lines("import java.util.HashMap;\n", "import java.util.List;\n\n"),
        writerVisitor.write());
  }

  @Test
  void writeNewObjectExprImports_methodExprArg() {
    // [Constructing] `new IOException(message, cause(mapArg))` and `cause(mapArg)` is a method
    // invocation with a `HashMap` argument.
    TypeNode exceptionType = TypeNode.withReference(ConcreteReference.withClazz(IOException.class));
    Variable message = Variable.builder().setName("message").setType(TypeNode.STRING).build();
    TypeNode mapType = TypeNode.withReference(ConcreteReference.withClazz(HashMap.class));
    VariableExpr mapExpr =
        VariableExpr.builder()
            .setVariable(Variable.builder().setName("mapArg").setType(mapType).build())
            .build();
    VariableExpr msgExpr = VariableExpr.builder().setVariable(message).build();
    MethodInvocationExpr causeExpr =
        MethodInvocationExpr.builder()
            .setMethodName("cause")
            .setArguments(Arrays.asList(mapExpr))
            .setReturnType(TypeNode.withReference(ConcreteReference.withClazz(Throwable.class)))
            .build();
    NewObjectExpr newObjectExpr =
        NewObjectExpr.builder()
            .setType(exceptionType)
            .setArguments(Arrays.asList(msgExpr, causeExpr))
            .build();
    newObjectExpr.accept(writerVisitor);
    assertEquals(
        LineFormatter.lines("import java.io.IOException;\n", "import java.util.HashMap;\n\n"),
        writerVisitor.write());
  }

  @Test
  void writeTernaryExprImports() {
    MethodInvocationExpr conditionExpr =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(TypeNode.withReference(ConcreteReference.withClazz(Expr.class)))
            .setMethodName("isExpr")
            .setReturnType(TypeNode.BOOLEAN)
            .build();
    MethodInvocationExpr thenExpr =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(
                TypeNode.withReference(ConcreteReference.withClazz(Strings.class)))
            .setMethodName("isNullOrEmpty")
            .setReturnType(TypeNode.BOOLEAN)
            .build();
    MethodInvocationExpr elseExpr =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(
                TypeNode.withReference(ConcreteReference.withClazz(TypeNode.class)))
            .setMethodName("isPrimitiveType")
            .setReturnType(TypeNode.BOOLEAN)
            .build();

    TernaryExpr ternaryExpr =
        TernaryExpr.builder()
            .setConditionExpr(conditionExpr)
            .setThenExpr(thenExpr)
            .setElseExpr(elseExpr)
            .build();
    ternaryExpr.accept(writerVisitor);
    assertEquals(
        LineFormatter.lines(
            "import com.google.api.generator.engine.ast.Expr;\n",
            "import com.google.api.generator.engine.ast.TypeNode;\n",
            "import com.google.common.base.Strings;\n\n"),
        writerVisitor.write());
  }

  @Test
  void writeVariableExprImports_staticReference() {
    VariableExpr variableExpr =
        VariableExpr.builder()
            .setVariable(
                Variable.builder()
                    .setType(
                        TypeNode.withReference(ConcreteReference.withClazz(AssignmentExpr.class)))
                    .setName("AN_ASSIGN_EXPR")
                    .build())
            .setStaticReferenceType(
                TypeNode.withReference(ConcreteReference.withClazz(TypeNode.class)))
            .build();

    variableExpr.accept(writerVisitor);
    assertEquals(
        LineFormatter.lines(
            "import com.google.api.generator.engine.ast.AssignmentExpr;\n",
            "import com.google.api.generator.engine.ast.TypeNode;\n\n"),
        writerVisitor.write());
  }

  @Test
  void writeVariableExprImports_wildcardType() {
    TypeNode wildcardListType =
        TypeNode.withReference(
            ConcreteReference.builder()
                .setClazz(List.class)
                .setGenerics(Arrays.asList(TypeNode.WILDCARD_REFERENCE))
                .build());

    // Constructs `List<?> x`.
    Variable variable = Variable.builder().setName("x").setType(wildcardListType).build();
    VariableExpr variableExpr =
        VariableExpr.builder().setIsDecl(true).setVariable(variable).build();

    variableExpr.accept(writerVisitor);
    assertEquals("import java.util.List;\n\n", writerVisitor.write());
  }

  @Test
  void writeVariableExprImport_wildcardTypeWithUpperBound() {
    TypeNode wildcardListType =
        TypeNode.withReference(
            ConcreteReference.builder()
                .setClazz(List.class)
                .setGenerics(
                    Arrays.asList(
                        ConcreteReference.wildcardWithUpperBound(
                            ConcreteReference.withClazz(Expr.class))))
                .build());

    // Constructs `List<? extends Expr> x`.
    Variable variable = Variable.builder().setName("x").setType(wildcardListType).build();
    VariableExpr variableExpr =
        VariableExpr.builder().setIsDecl(true).setVariable(variable).build();

    variableExpr.accept(writerVisitor);
    assertEquals(
        LineFormatter.lines(
            "import com.google.api.generator.engine.ast.Expr;\n", "import java.util.List;\n\n"),
        writerVisitor.write());
  }

  @Test
  void writeVariableExprImports_reference() {
    Variable variable =
        Variable.builder()
            .setName("expr")
            .setType(TypeNode.withReference(ConcreteReference.withClazz(Expr.class)))
            .build();
    VariableExpr variableExpr = VariableExpr.builder().setVariable(variable).build();

    Variable subVariable =
        Variable.builder()
            .setName("assignExpr")
            .setType(TypeNode.withReference(ConcreteReference.withClazz(AssignmentExpr.class)))
            .build();
    variableExpr =
        VariableExpr.builder().setVariable(subVariable).setExprReferenceExpr(variableExpr).build();
    variableExpr.accept(writerVisitor);
    assertEquals(
        LineFormatter.lines(
            "import com.google.api.generator.engine.ast.AssignmentExpr;\n",
            "import com.google.api.generator.engine.ast.Expr;\n\n"),
        writerVisitor.write());
  }

  @Test
  void writeVariableExprImports_nestedReference() {
    Variable variable =
        Variable.builder()
            .setName("expr")
            .setType(TypeNode.withReference(ConcreteReference.withClazz(Expr.class)))
            .build();
    VariableExpr variableExpr = VariableExpr.builder().setVariable(variable).build();

    Variable subVariable =
        Variable.builder()
            .setName("assignExpr")
            .setType(TypeNode.withReference(ConcreteReference.withClazz(AssignmentExpr.class)))
            .build();
    variableExpr =
        VariableExpr.builder().setVariable(subVariable).setExprReferenceExpr(variableExpr).build();
    subVariable =
        Variable.builder()
            .setName("anotherExpr")
            .setType(TypeNode.withReference(ConcreteReference.withClazz(VariableExpr.class)))
            .build();
    variableExpr =
        VariableExpr.builder().setVariable(subVariable).setExprReferenceExpr(variableExpr).build();

    variableExpr.accept(writerVisitor);
    assertEquals(
        LineFormatter.lines(
            "import com.google.api.generator.engine.ast.AssignmentExpr;\n",
            "import com.google.api.generator.engine.ast.Expr;\n",
            "import com.google.api.generator.engine.ast.VariableExpr;\n\n"),
        writerVisitor.write());
  }

  @Test
  void writeVariableExprImports_withAnnotations() {
    Variable variable =
        Variable.builder()
            .setName("expr")
            .setType(TypeNode.withReference(ConcreteReference.withClazz(Expr.class)))
            .build();

    VariableExpr variableExpr =
        VariableExpr.builder()
            .setVariable(variable)
            .setIsDecl(true)
            .setAnnotations(
                Arrays.asList(
                    AnnotationNode.withType(
                        TypeNode.withReference(ConcreteReference.withClazz(Generated.class)))))
            .build();

    variableExpr.accept(writerVisitor);
    assertEquals(
        LineFormatter.lines(
            "import com.google.api.generator.engine.ast.Expr;\n",
            "import javax.annotation.Generated;\n\n"),
        writerVisitor.write());
  }

  @Test
  void writeVariableExprImports_annotationsWithDescription() {
    Variable variable =
        Variable.builder()
            .setName("expr")
            .setType(TypeNode.withReference(ConcreteReference.withClazz(Expr.class)))
            .build();

    VariableExpr annotationDescription =
        VariableExpr.builder()
            .setVariable(Variable.builder().setType(TypeNode.CLASS_OBJECT).setName("class").build())
            .setStaticReferenceType(TypeNode.withReference(ConcreteReference.withClazz(List.class)))
            .build();

    // Constructs with annotation @Repeatable(List.class)
    VariableExpr variableExpr =
        VariableExpr.builder()
            .setVariable(variable)
            .setIsDecl(true)
            .setAnnotations(
                Arrays.asList(
                    AnnotationNode.builder()
                        .setType(
                            TypeNode.withReference(ConcreteReference.withClazz(Repeatable.class)))
                        .setDescription(annotationDescription)
                        .build()))
            .build();

    variableExpr.accept(writerVisitor);
    assertEquals(
        LineFormatter.lines(
            "import com.google.api.generator.engine.ast.Expr;\n",
            "import java.lang.annotation.Repeatable;\n",
            "import java.util.List;\n\n"),
        writerVisitor.write());
  }

  @Test
  void writeVaporReferenceImport_outermostForNestedClass() {
    VaporReference nestedVaporReference =
        VaporReference.builder()
            .setName("Inner")
            .setEnclosingClassNames(Arrays.asList("Outer", "Middle"))
            .setPakkage("com.google.testgapic.v1beta1")
            .build();

    TypeNode.withReference(nestedVaporReference).accept(writerVisitor);
    assertEquals("import com.google.testgapic.v1beta1.Outer;\n\n", writerVisitor.write());
  }

  @Test
  void writeConcreteReferenceImport_outermostForNestedClass() {
    ConcreteReference nestedConcreteReference =
        ConcreteReference.withClazz(Outer.Middle.Inner.class);
    TypeNode.withReference(nestedConcreteReference).accept(writerVisitor);
    assertEquals("import com.google.testgapic.v1beta1.Outer;\n\n", writerVisitor.write());
  }

  @Test
  void writeAnonymousClassExprImports() {
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
    // [Constructing] HashMap<String, Integer> map;
    ConcreteReference mapRef =
        ConcreteReference.builder()
            .setClazz(HashMap.class)
            .setGenerics(
                Arrays.asList(
                    ConcreteReference.withClazz(String.class),
                    ConcreteReference.withClazz(Integer.class)))
            .build();
    VariableExpr mapExpr =
        VariableExpr.builder()
            .setVariable(
                Variable.builder().setName("map").setType(TypeNode.withReference(mapRef)).build())
            .setIsDecl(true)
            .build();
    ExprStatement exprStatement = ExprStatement.withExpr(mapExpr);
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
            .setReturnExpr(returnArg)
            .setName("apply")
            .build();
    AnonymousClassExpr anonymousClassExpr =
        AnonymousClassExpr.builder()
            .setType(type)
            .setMethods(Arrays.asList(method))
            .setStatements(Arrays.asList(exprStatement))
            .build();
    anonymousClassExpr.accept(writerVisitor);
    assertEquals(
        LineFormatter.lines(
            "import com.google.api.generator.engine.ast.MethodDefinition;\n",
            "import com.google.common.base.Function;\n",
            "import java.io.IOException;\n",
            "import java.util.HashMap;\n",
            "import java.util.List;\n\n"),
        writerVisitor.write());
  }

  @Test
  void writeThrowExprImports_basic() {
    TypeNode exceptionTypes =
        TypeNode.withReference(ConcreteReference.withClazz(IOException.class));
    String message = "Some message asdf";
    ThrowExpr throwExpr =
        ThrowExpr.builder().setType(exceptionTypes).setMessageExpr(message).build();
    throwExpr.accept(writerVisitor);
    assertEquals("import java.io.IOException;\n\n", writerVisitor.write());
  }

  @Test
  void writeThrowExprImports_throwExpr() {
    Expr exprToThrow =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(
                TypeNode.withReference(ConcreteReference.withClazz(Statement.class)))
            .setMethodName("createException")
            .setReturnType(TypeNode.withExceptionClazz(Exception.class))
            .build();

    TypeNode ignoredExceptionType =
        TypeNode.withReference(ConcreteReference.withClazz(IOException.class));
    ThrowExpr throwExpr =
        ThrowExpr.builder().setType(ignoredExceptionType).setThrowExpr(exprToThrow).build();
    throwExpr.accept(writerVisitor);
    assertEquals(
        LineFormatter.lines("import com.google.api.generator.engine.ast.Statement;\n\n"),
        writerVisitor.write());
  }

  @Test
  void writeThrowExprImports_messageExpr() {
    TypeNode npeType = TypeNode.withExceptionClazz(NullPointerException.class);
    Expr messageExpr =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(
                TypeNode.withReference(ConcreteReference.withClazz(IfStatement.class)))
            .setMethodName("conditionExpr")
            .setReturnType(TypeNode.withReference(ConcreteReference.withClazz(Expr.class)))
            .build();

    messageExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(messageExpr)
            .setMethodName("foobar")
            .setReturnType(TypeNode.STRING)
            .build();
    ThrowExpr throwExpr = ThrowExpr.builder().setType(npeType).setMessageExpr(messageExpr).build();

    throwExpr.accept(writerVisitor);
    assertEquals(
        LineFormatter.lines(
            "import com.google.api.generator.engine.ast.Expr;\n",
            "import com.google.api.generator.engine.ast.IfStatement;\n\n"),
        writerVisitor.write());
  }

  @Test
  void writeThrowExprImports_messageAndCauseExpr() {
    TypeNode npeType = TypeNode.withExceptionClazz(NullPointerException.class);
    Expr messageExpr =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(
                TypeNode.withReference(ConcreteReference.withClazz(IfStatement.class)))
            .setMethodName("conditionExpr")
            .setReturnType(TypeNode.withReference(ConcreteReference.withClazz(Expr.class)))
            .build();

    messageExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(messageExpr)
            .setMethodName("foobar")
            .setReturnType(TypeNode.STRING)
            .build();
    ThrowExpr throwExpr =
        ThrowExpr.builder()
            .setType(npeType)
            .setMessageExpr(messageExpr)
            .setCauseExpr(
                NewObjectExpr.builder()
                    .setType(TypeNode.withExceptionClazz(FileNotFoundException.class))
                    .build())
            .build();

    throwExpr.accept(writerVisitor);
    assertEquals(
        LineFormatter.lines(
            "import com.google.api.generator.engine.ast.Expr;\n",
            "import com.google.api.generator.engine.ast.IfStatement;\n",
            "import java.io.FileNotFoundException;\n\n"),
        writerVisitor.write());
  }

  @Test
  void writeInstanceofExprImports_basic() {
    TypeNode exprType = TypeNode.withReference(ConcreteReference.withClazz(Expr.class));
    TypeNode assignExprType =
        TypeNode.withReference(ConcreteReference.withClazz(AssignmentExpr.class));

    Variable variable = Variable.builder().setName("x").setType(assignExprType).build();
    VariableExpr variableExpr = VariableExpr.builder().setVariable(variable).build();

    InstanceofExpr expr =
        InstanceofExpr.builder().setExpr(variableExpr).setCheckType(exprType).build();
    expr.accept(writerVisitor);
    assertEquals(
        LineFormatter.lines(
            "import com.google.api.generator.engine.ast.AssignmentExpr;\n",
            "import com.google.api.generator.engine.ast.Expr;\n\n"),
        writerVisitor.write());
  }

  @Test
  void writeEnumRefExprImports_basic() {
    TypeNode enumType =
        TypeNode.withReference(
            ConcreteReference.builder()
                .setClazz(TypeNode.TypeKind.class)
                .setIsStaticImport(true)
                .build());
    EnumRefExpr enumRefExpr = EnumRefExpr.builder().setName("VOID").setType(enumType).build();

    enumRefExpr.accept(writerVisitor);
    assertEquals(
        "import static com.google.api.generator.engine.ast.TypeNode.TypeKind;\n\n",
        writerVisitor.write());
  }

  @Test
  void writeEnumRefExprImports_nested() {
    TypeNode enumType =
        TypeNode.withReference(ConcreteReference.withClazz(TypeNode.TypeKind.class));
    EnumRefExpr enumRefExpr = EnumRefExpr.builder().setName("VOID").setType(enumType).build();
    enumRefExpr.accept(writerVisitor);
    assertEquals("import com.google.api.generator.engine.ast.TypeNode;\n\n", writerVisitor.write());
  }

  @Test
  void writeReturnExprImports_basic() {
    ReturnExpr returnExpr =
        ReturnExpr.withExpr(
            MethodInvocationExpr.builder()
                .setMethodName("createExpr")
                .setReturnType(TypeNode.withReference(ConcreteReference.withClazz(Expr.class)))
                .build());
    returnExpr.accept(writerVisitor);
    assertEquals("import com.google.api.generator.engine.ast.Expr;\n\n", writerVisitor.write());
  }

  @Test
  void writeMethodDefinitionImports_templatedMixedNamesAndTypes() {
    Reference mapRef = ConcreteReference.withClazz(Map.class);
    List<VariableExpr> arguments =
        Arrays.asList(
            VariableExpr.builder()
                .setVariable(createVariable("x", TypeNode.withReference(mapRef)))
                .setIsDecl(true)
                .setTemplateObjects(
                    Arrays.asList(
                        "K",
                        TypeNode.withReference(ConcreteReference.withClazz(AssignmentExpr.class))))
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
            "import com.google.api.generator.engine.ast.AssignmentExpr;\n",
            "import java.util.Map;\n\n"),
        writerVisitor.write());
  }

  @Test
  void writeReferenceConstructorExprImports_basic() {
    VaporReference ref =
        VaporReference.builder().setName("Parent").setPakkage("com.google.example.v1").build();
    TypeNode classType = TypeNode.withReference(ref);
    ReferenceConstructorExpr referenceConstructorExpr =
        ReferenceConstructorExpr.superBuilder().setType(classType).build();
    referenceConstructorExpr.accept(writerVisitor);
    assertEquals("import com.google.example.v1.Parent;\n\n", writerVisitor.write());
  }

  @Test
  void writeReferenceConstructorExprImports_withArgs() {
    VaporReference ref =
        VaporReference.builder().setName("Student").setPakkage("com.google.example.v1").build();
    TypeNode classType = TypeNode.withReference(ref);
    VariableExpr streamVarExpr =
        VariableExpr.builder()
            .setVariable(
                createVariable(
                    "stream",
                    TypeNode.withReference(ConcreteReference.withClazz(LongStream.class))))
            .build();
    ReferenceConstructorExpr referenceConstructorExpr =
        ReferenceConstructorExpr.thisBuilder()
            .setArguments(Arrays.asList(streamVarExpr))
            .setType(classType)
            .build();
    referenceConstructorExpr.accept(writerVisitor);
  }

  @Test
  void writeArithmeticOperationExprImports() {
    MethodInvocationExpr lhsExpr =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(TypeNode.withReference(ConcreteReference.withClazz(Expr.class)))
            .setMethodName("getSomething")
            .setReturnType(TypeNode.STRING)
            .build();
    ValueExpr rhsExpr = ValueExpr.createNullExpr();
    ArithmeticOperationExpr arithmeticOperationExpr =
        ArithmeticOperationExpr.concatWithExprs(lhsExpr, rhsExpr);
    arithmeticOperationExpr.accept(writerVisitor);
    assertEquals("import com.google.api.generator.engine.ast.Expr;\n\n", writerVisitor.write());
  }

  @Test
  void writeSynchronizedStatementImports_basicThis() {
    SynchronizedStatement synchronizedStatement =
        SynchronizedStatement.builder()
            .setLock(
                ThisObjectValue.withType(
                    TypeNode.withReference(ConcreteReference.withClazz(Expr.class))))
            .setBody(
                ExprStatement.withExpr(
                    MethodInvocationExpr.builder()
                        .setMethodName("doStuff")
                        .setReturnType(
                            TypeNode.withReference(ConcreteReference.withClazz(Arrays.class)))
                        .build()))
            .build();
    synchronizedStatement.accept(writerVisitor);
    assertEquals(
        LineFormatter.lines(
            "import com.google.api.generator.engine.ast.Expr;\n", "import java.util.Arrays;\n\n"),
        writerVisitor.write());
  }

  @Test
  void writeSuperObjectValueImports() {
    VaporReference ref =
        VaporReference.builder()
            .setName("Student")
            .setPakkage("com.google.example.examples.v1")
            .build();
    TypeNode typeNode = TypeNode.withReference(ref);
    SuperObjectValue superObjectValue = SuperObjectValue.withType(typeNode);
    MethodInvocationExpr methodExpr =
        MethodInvocationExpr.builder()
            .setMethodName("getName")
            .setExprReferenceExpr(ValueExpr.withValue(superObjectValue))
            .setReturnType(TypeNode.STRING)
            .build();
    methodExpr.accept(writerVisitor);
    assertEquals("import com.google.example.examples.v1.Student;\n\n", writerVisitor.write());
  }

  @Test
  void writeSynchronizedStatementImports_basicVariableExpr() {
    VariableExpr strVarExpr =
        VariableExpr.withVariable(
            Variable.builder()
                .setName("str")
                .setType(TypeNode.withReference(ConcreteReference.withClazz(AssignmentExpr.class)))
                .build());

    SynchronizedStatement synchronizedStatement =
        SynchronizedStatement.builder()
            .setLock(strVarExpr)
            .setBody(
                ExprStatement.withExpr(
                    MethodInvocationExpr.builder()
                        .setMethodName("doStuff")
                        .setReturnType(
                            TypeNode.withReference(ConcreteReference.withClazz(Map.class)))
                        .build()))
            .build();
    synchronizedStatement.accept(writerVisitor);
    assertEquals(
        LineFormatter.lines(
            "import com.google.api.generator.engine.ast.AssignmentExpr;\n",
            "import java.util.Map;\n\n"),
        writerVisitor.write());
  }

  @Test
  void writeUnaryOperationExprImports_LogicalNot() {
    MethodInvocationExpr expr =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(TypeNode.withReference(ConcreteReference.withClazz(Expr.class)))
            .setMethodName("isEmpty")
            .setReturnType(TypeNode.BOOLEAN)
            .build();
    UnaryOperationExpr unaryOperationExpr = UnaryOperationExpr.logicalNotWithExpr(expr);
    unaryOperationExpr.accept(writerVisitor);
    assertEquals("import com.google.api.generator.engine.ast.Expr;\n\n", writerVisitor.write());
  }

  @Test
  void writeUnaryOperationExprImports_PostIncrement() {
    MethodInvocationExpr expr =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(TypeNode.withReference(ConcreteReference.withClazz(Expr.class)))
            .setMethodName("getNumber")
            .setReturnType(TypeNode.INT)
            .build();
    UnaryOperationExpr unaryOperationExpr = UnaryOperationExpr.postfixIncrementWithExpr(expr);
    unaryOperationExpr.accept(writerVisitor);
    assertEquals("import com.google.api.generator.engine.ast.Expr;\n\n", writerVisitor.write());
  }

  @Test
  void writeRelationalOperationExprImports() {
    MethodInvocationExpr lhsExpr =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(TypeNode.withReference(ConcreteReference.withClazz(Expr.class)))
            .setMethodName("getSomething")
            .setReturnType(TypeNode.STRING)
            .build();
    TypeNode someType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("SomeClass")
                .setPakkage("com.google.api.generator.engine")
                .build());
    MethodInvocationExpr rhsExpr =
        MethodInvocationExpr.builder()
            .setMethodName("getName")
            .setStaticReferenceType(someType)
            .setReturnType(TypeNode.STRING)
            .build();
    RelationalOperationExpr relationalOperationExpr =
        RelationalOperationExpr.equalToWithExprs(lhsExpr, rhsExpr);
    relationalOperationExpr.accept(writerVisitor);
    assertEquals(
        LineFormatter.lines(
            "import com.google.api.generator.engine.SomeClass;\n",
            "import com.google.api.generator.engine.ast.Expr;\n\n"),
        writerVisitor.write());
  }

  @Test
  void writeLogicalOperationExprImports() {
    MethodInvocationExpr lhsExpr =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(
                TypeNode.withReference(ConcreteReference.withClazz(UnaryOperationExpr.class)))
            .setMethodName("isValid")
            .setReturnType(TypeNode.BOOLEAN)
            .build();
    VariableExpr rhsExpr =
        VariableExpr.builder().setVariable(createVariable("isGood", TypeNode.BOOLEAN)).build();
    LogicalOperationExpr logicalOperationExpr =
        LogicalOperationExpr.logicalAndWithExprs(lhsExpr, rhsExpr);
    logicalOperationExpr.accept(writerVisitor);
    assertEquals(
        "import com.google.api.generator.engine.ast.UnaryOperationExpr;\n\n",
        writerVisitor.write());
  }

  @Test
  void writeEmptyLineStatementImports() {
    EmptyLineStatement statement = EmptyLineStatement.create();
    statement.accept(writerVisitor);
    assertThat(writerVisitor.write()).isEmpty();
  }

  @Test
  void writePackageInfoDefinitionImports() {
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
    assertEquals("import javax.annotation.Generated;\n\n", writerVisitor.write());
  }

  @Test
  void writeLambdaExprImports() {
    // Similar to method defnitions.
    Reference mapRef = ConcreteReference.withClazz(Map.class);
    List<VariableExpr> arguments =
        Arrays.asList(
            VariableExpr.builder()
                .setVariable(createVariable("x", TypeNode.withReference(mapRef)))
                .setIsDecl(true)
                .setTemplateObjects(
                    Arrays.asList(
                        "K",
                        TypeNode.withReference(ConcreteReference.withClazz(AssignmentExpr.class))))
                .build(),
            VariableExpr.builder()
                .setVariable(createVariable("y", TypeNode.withReference(mapRef)))
                .setIsDecl(true)
                .setTemplateObjects(Arrays.asList("T", "V"))
                .build());
    Statement bodyStatement =
        ExprStatement.withExpr(
            MethodInvocationExpr.builder()
                .setMethodName("doStuff")
                .setReturnType(TypeNode.withReference(ConcreteReference.withClazz(Arrays.class)))
                .build());
    TypeNode returnType = TypeNode.withReference(ConcreteReference.withClazz(Expr.class));
    LambdaExpr lambdaExpr =
        LambdaExpr.builder()
            .setArguments(arguments)
            .setBody(Arrays.asList(bodyStatement))
            .setReturnExpr(
                MethodInvocationExpr.builder()
                    .setMethodName("foobar")
                    .setReturnType(returnType)
                    .build())
            .build();
    lambdaExpr.accept(writerVisitor);
    assertEquals(
        LineFormatter.lines(
            "import com.google.api.generator.engine.ast.AssignmentExpr;\n",
            "import com.google.api.generator.engine.ast.Expr;\n",
            "import java.util.Arrays;\n",
            "import java.util.Map;\n\n"),
        writerVisitor.write());
  }

  @Test
  void importArrayExprTypes() {
    ArrayExpr arrayExpr =
        ArrayExpr.builder()
            .setType(
                TypeNode.createArrayTypeOf(
                    TypeNode.withReference(ConcreteReference.withClazz(UnaryOperationExpr.class))))
            .build();
    arrayExpr.accept(writerVisitor);
    assertEquals(
        "import com.google.api.generator.engine.ast.UnaryOperationExpr;\n\n",
        writerVisitor.write());
  }

  /** =============================== HELPERS =============================== */
  private static Variable createVariable(String variableName, TypeNode type) {
    return Variable.builder().setName(variableName).setType(type).build();
  }
}
