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

package com.google.api.generator.engine;

import com.google.api.generator.engine.ast.AnnotationNode;
import com.google.api.generator.engine.ast.AnonymousClassExpr;
import com.google.api.generator.engine.ast.AssignmentExpr;
import com.google.api.generator.engine.ast.BlockComment;
import com.google.api.generator.engine.ast.CastExpr;
import com.google.api.generator.engine.ast.ClassDefinition;
import com.google.api.generator.engine.ast.CommentStatement;
import com.google.api.generator.engine.ast.ConcreteReference;
import com.google.api.generator.engine.ast.EnumRefExpr;
import com.google.api.generator.engine.ast.Expr;
import com.google.api.generator.engine.ast.ExprStatement;
import com.google.api.generator.engine.ast.ForStatement;
import com.google.api.generator.engine.ast.IfStatement;
import com.google.api.generator.engine.ast.InstanceofExpr;
import com.google.api.generator.engine.ast.JavaDocComment;
import com.google.api.generator.engine.ast.LineComment;
import com.google.api.generator.engine.ast.MethodDefinition;
import com.google.api.generator.engine.ast.MethodInvocationExpr;
import com.google.api.generator.engine.ast.NewObjectExpr;
import com.google.api.generator.engine.ast.PrimitiveValue;
import com.google.api.generator.engine.ast.ReferenceConstructorExpr;
import com.google.api.generator.engine.ast.ReturnExpr;
import com.google.api.generator.engine.ast.ScopeNode;
import com.google.api.generator.engine.ast.StringObjectValue;
import com.google.api.generator.engine.ast.TernaryExpr;
import com.google.api.generator.engine.ast.ThisObjectValue;
import com.google.api.generator.engine.ast.ThrowExpr;
import com.google.api.generator.engine.ast.TryCatchStatement;
import com.google.api.generator.engine.ast.TypeNode;
import com.google.api.generator.engine.ast.ValueExpr;
import com.google.api.generator.engine.ast.VaporReference;
import com.google.api.generator.engine.ast.Variable;
import com.google.api.generator.engine.ast.VariableExpr;
import com.google.api.generator.engine.ast.WhileStatement;
import com.google.api.generator.engine.writer.JavaWriterVisitor;
import com.google.api.generator.test.framework.Assert;
import com.google.api.generator.test.framework.GoldenFileWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import org.junit.jupiter.api.Test;

class JavaCodeGeneratorTest {

  private static final String GOLDENFILES_DIRECTORY =
      "src/test/java/com/google/api/generator/engine/goldens/";
  // Create shared VaporReferences.
  private static final VaporReference stubRef = createVaporReference("com.google.gax.grpc", "Stub");
  private static final VaporReference bookKindRef =
      createVaporReference("com.google.exmaple.library.v1", "BookKind");
  private static final VaporReference libraryServiceRef =
      createVaporReference("com.google.exmaple.library", "LibraryService");
  private static final VaporReference shelfClassRef =
      createVaporReference("com.google.example.library.core", "Shelf");
  private static final VaporReference bookClassRef =
      createVaporReference("com.google.example.library.core", "Book");
  private static final VaporReference novelClassRef =
      createVaporReference("com.google.example.library.core", "Novel");
  // Create shared ConcreteReferences.
  private static final ConcreteReference shelfListRef =
      ConcreteReference.builder()
          .setClazz(List.class)
          .setGenerics(Arrays.asList(shelfClassRef))
          .build();
  private static final ConcreteReference stringRef = ConcreteReference.withClazz(String.class);
  private static final ConcreteReference shelfMapRef =
      ConcreteReference.builder()
          .setClazz(HashMap.class)
          .setGenerics(Arrays.asList(stringRef, shelfClassRef))
          .build();
  // Create shared variables.
  private static final Variable shelfVar = createVarFromVaporRef(shelfClassRef, "shelf");
  private static final Variable shelfListVar = createVarFromConcreteRef(shelfListRef, "shelfList");
  private static final Variable shelfMapVar = createVarFromConcreteRef(shelfMapRef, "shelfMap");
  private static final Variable shelfNameVar = createVarFromType(TypeNode.STRING, "shelfName");
  private static final Variable seriesNumVar = createVarFromType(TypeNode.INT, "seriesNum");
  private static final Variable shelfServiceNameVar =
      createVarFromType(TypeNode.STRING, "shelfServiceName");
  private static final Variable bookKindVar = createVarFromVaporRef(bookKindRef, "bookKind");

  @Test
  void validJavaClass() {
    // Create outer class variableDecls.
    // [code] private static final String serviceName = "LibraryServiceStub";
    VariableExpr serviceName = createServiceNameVarExpr();
    AssignmentExpr serviceNameDel =
        createAssignmentExpr(
            serviceName, ValueExpr.withValue(StringObjectValue.withValue("LibraryServiceStub")));

    // [code] protected List<Shelf> shelfList;
    VariableExpr shelfListExpr = createShelfListVarExpr();

    // [code] public static HashMap<String, Shelf> shelfMap;
    VariableExpr shelfMapExpr = createShelfMapVarExpr();

    // Create the LibraryServiceStub constructor
    MethodDefinition libraryServiceCtor = createLibServiceCtor();

    // Create nested class Shelf.
    ClassDefinition nestedClassShelf = createNestedClassShelf();

    // Create nested abstract class Book.
    ClassDefinition nestedClassBook = createNestedClassBook();

    // Create nested class Novel.
    ClassDefinition nestedClassNovel = createNestedClassNovel();

    // Create method `addShelf`
    MethodDefinition addShelfMethod = createAddShelfMethod();

    // Create method `updateShelfMap`
    MethodDefinition updateShelfMap = createUpdateShelfMap();

    // Create method `printShelfListToFile`
    MethodDefinition printShelfListToFile = createPrintShelfListToFile();

    // Create method `addBooksContainsNovel`
    MethodDefinition addBooksContainsNovel = createAddBooksContainsNovel();

    // Create private method `addBookToShelf`
    MethodDefinition addBookToShelf = createAddBookToShelf();

    // Create outer class LibraryServiceStub
    ClassDefinition libraryServiceStubClass =
        ClassDefinition.builder()
            .setFileHeader(Arrays.asList(createFileHeader()))
            .setHeaderCommentStatements(Arrays.asList(createOuterClassJavaDocComment()))
            .setPackageString("com.google.example.library.core")
            .setAnnotations(
                Arrays.asList(
                    AnnotationNode.withSuppressWarnings("all"),
                    AnnotationNode.DEPRECATED,
                    AnnotationNode.OVERRIDE))
            .setImplementsTypes(Arrays.asList(TypeNode.withReference(libraryServiceRef)))
            .setExtendsType(TypeNode.withReference(stubRef))
            .setScope(ScopeNode.PUBLIC)
            .setStatements(
                Arrays.asList(
                    ExprStatement.withExpr(serviceNameDel),
                    ExprStatement.withExpr(shelfListExpr),
                    ExprStatement.withExpr(shelfMapExpr)))
            .setMethods(
                Arrays.asList(
                    libraryServiceCtor,
                    addShelfMethod,
                    updateShelfMap,
                    printShelfListToFile,
                    addBooksContainsNovel,
                    addBookToShelf))
            .setNestedClasses(Arrays.asList(nestedClassShelf, nestedClassBook, nestedClassNovel))
            .setName("LibraryServiceStub")
            .build();
    JavaWriterVisitor javaWriterVisitor = new JavaWriterVisitor();
    libraryServiceStubClass.accept(javaWriterVisitor);
    GoldenFileWriter.saveCodegenToFile(
        this.getClass(), "JavaCodeGeneratorTest.golden", javaWriterVisitor.write());
    Path goldenFilePath = Paths.get(GOLDENFILES_DIRECTORY, "JavaCodeGeneratorTest.golden");
    Assert.assertCodeEquals(goldenFilePath, javaWriterVisitor.write());
  }

  // Private helpers.
  private CommentStatement createFileHeader() {
    String fileheader =
        "Copyright 2020 Gagpic-generator-java\n\n"
            + "Licensed description and license version 2.0 (the \"License\");\n\n"
            + "   https://www.foo.bar/licenses/LICENSE-2.0\n\n"
            + "Software distributed under the License is distributed on an \"AS IS\" BASIS.\n"
            + "See the License for the specific language governing permissions and\n"
            + "limitations under the License.";
    return CommentStatement.withComment(BlockComment.withComment(fileheader));
  }

  private CommentStatement createOuterClassJavaDocComment() {
    return CommentStatement.withComment(
        JavaDocComment.builder()
            .addComment("Service Description: This is a test comment.")
            .addComment("")
            .addSampleCode("LibraryServiceStub libServiceStub = new LibraryServiceStub()")
            .addOrderedList(
                Arrays.asList(
                    "A \"flattened\" method.",
                    "A \"request object\" method.",
                    "A \"callable\" method."))
            .setDeprecated("This is a deprecated message.")
            .build());
  }

  private CommentStatement createPreMethodLineComment(String commentString) {
    return CommentStatement.withComment(LineComment.withComment(commentString));
  }

  private List<CommentStatement> createPreMethodJavaDocComment() {
    return Arrays.asList(
        CommentStatement.withComment(
            JavaDocComment.builder()
                .addComment("Add books to Shelf and check if there is a novel,")
                .addComment("return string message as whether novel books are added to the shelf.")
                .addComment("")
                .addParam("shelf", "The Shelf object to which books will put.")
                .addParam("stack", "The Stack of the BookKinds.")
                .build()));
  }

  private static VaporReference createVaporReference(String pkgName, String name) {
    return VaporReference.builder().setPakkage(pkgName).setName(name).build();
  }

  private static Variable createVarFromConcreteRef(ConcreteReference ref, String name) {
    return Variable.builder().setName(name).setType(TypeNode.withReference(ref)).build();
  }

  private static Variable createVarFromVaporRef(VaporReference ref, String name) {
    return Variable.builder().setName(name).setType(TypeNode.withReference(ref)).build();
  }

  private static Variable createVarFromType(TypeNode ref, String name) {
    return Variable.builder().setName(name).setType(ref).build();
  }

  private PrimitiveValue createBooleanValue(String booleanValue) {
    return PrimitiveValue.builder().setValue(booleanValue).setType(TypeNode.BOOLEAN).build();
  }

  private VariableExpr createVarExprFromRefThisExpr(Variable var, VaporReference ref) {
    return VariableExpr.builder()
        .setVariable(var)
        .setExprReferenceExpr(
            ValueExpr.withValue(ThisObjectValue.withType(TypeNode.withReference(ref))))
        .build();
  }

  private VariableExpr createVarExprFromRefVarExpr(Variable var, Expr varRef) {
    return VariableExpr.builder().setVariable(var).setExprReferenceExpr(varRef).build();
  }

  private VariableExpr createServiceNameVarExpr() {
    return VariableExpr.builder()
        .setIsDecl(true)
        .setIsFinal(true)
        .setIsStatic(true)
        .setScope(ScopeNode.PRIVATE)
        .setVariable(createVarFromType(TypeNode.STRING, "serviceName"))
        .build();
  }

  private VariableExpr createShelfListVarExpr() {
    return VariableExpr.builder()
        .setIsDecl(true)
        .setScope(ScopeNode.PROTECTED)
        .setVariable(shelfListVar)
        .build();
  }

  private VariableExpr createShelfMapVarExpr() {
    return VariableExpr.builder()
        .setIsDecl(true)
        .setScope(ScopeNode.PUBLIC)
        .setIsStatic(true)
        .setVariable(shelfMapVar)
        .build();
  }

  private VariableExpr fieldFromShelfObjectExpr(Variable shelfVar, Variable field) {
    return createVarExprFromRefVarExpr(field, VariableExpr.withVariable(shelfVar));
  }

  private VariableExpr createVarDeclExpr(Variable var) {
    return VariableExpr.builder().setVariable(var).setIsDecl(true).build();
  }

  private VariableExpr createVarPublicDeclExpr(Variable var) {
    return VariableExpr.builder()
        .setIsDecl(true)
        .setScope(ScopeNode.PUBLIC)
        .setVariable(var)
        .build();
  }

  private NewObjectExpr createNewObjectExpr(Class<?> clazz) {
    return NewObjectExpr.builder()
        .setType(TypeNode.withReference(ConcreteReference.withClazz(clazz)))
        .setIsGeneric(true)
        .build();
  }

  private NewObjectExpr createNewObjectExprWithArg(Variable var) {
    return NewObjectExpr.builder()
        .setType(TypeNode.withReference(shelfClassRef))
        .setArguments(
            Arrays.asList(VariableExpr.withVariable(var), VariableExpr.withVariable(seriesNumVar)))
        .build();
  }

  private AssignmentExpr createAssignmentExpr(VariableExpr variableExpr, Expr valueExpr) {
    return AssignmentExpr.builder().setVariableExpr(variableExpr).setValueExpr(valueExpr).build();
  }

  private ReturnExpr createReturnExpr(String returnMsg) {
    return ReturnExpr.withExpr(ValueExpr.withValue(StringObjectValue.withValue(returnMsg)));
  }

  private MethodInvocationExpr methodExprWithRef(Variable var, String methodName) {
    return MethodInvocationExpr.builder()
        .setMethodName(methodName)
        .setExprReferenceExpr(VariableExpr.withVariable(var))
        .build();
  }

  private MethodInvocationExpr methodExprWithRefAndArg(
      Variable var, String methodName, List<Expr> args) {
    return MethodInvocationExpr.builder()
        .setMethodName(methodName)
        .setExprReferenceExpr(VariableExpr.withVariable(var))
        .setArguments(args)
        .build();
  }

  private MethodInvocationExpr methodExprWithRefArgAndReturn(Variable var, List<Expr> args) {
    return MethodInvocationExpr.builder()
        .setMethodName("containsKey")
        .setExprReferenceExpr(VariableExpr.withVariable(var))
        .setArguments(args)
        .setReturnType(TypeNode.BOOLEAN)
        .build();
  }

  private AnonymousClassExpr createAnonymousClass() {
    return AnonymousClassExpr.builder()
        .setType(TypeNode.withReference(bookClassRef))
        .setMethods(
            Arrays.asList(
                createOverrideCreateBookMethod(
                    bookClassRef, VariableExpr.withVariable(bookKindVar))))
        .build();
  }

  private TernaryExpr createTernaryExpr(Variable var) {
    return TernaryExpr.builder()
        .setConditionExpr(VariableExpr.withVariable(var))
        .setThenExpr(ValueExpr.withValue(StringObjectValue.withValue("Added novels")))
        .setElseExpr(ValueExpr.withValue(StringObjectValue.withValue("No novels added")))
        .build();
  }

  private MethodDefinition createLibServiceCtor() {
    VaporReference libraryServiceStubRef =
        createVaporReference("com.google.exmaple.library.core", "LibraryServiceStub");

    NewObjectExpr arrayList = createNewObjectExpr(ArrayList.class);
    NewObjectExpr hashMap = createNewObjectExpr(HashMap.class);

    ReferenceConstructorExpr superExpr =
        ReferenceConstructorExpr.superBuilder()
            .setType(TypeNode.withReference(libraryServiceStubRef))
            .build();
    ValueExpr thisValueExpr =
        ValueExpr.withValue(
            ThisObjectValue.withType(TypeNode.withReference(libraryServiceStubRef)));
    VariableExpr thisVariableExpr = createVarExprFromRefVarExpr(shelfListVar, thisValueExpr);

    AssignmentExpr shelfListAssignmentExpr = createAssignmentExpr(thisVariableExpr, arrayList);
    AssignmentExpr shelfMapAssignmentExpr =
        createAssignmentExpr(VariableExpr.withVariable(shelfMapVar), hashMap);
    return MethodDefinition.constructorBuilder()
        .setBody(
            Arrays.asList(
                ExprStatement.withExpr(superExpr),
                ExprStatement.withExpr(shelfListAssignmentExpr),
                ExprStatement.withExpr(shelfMapAssignmentExpr)))
        .setReturnType(TypeNode.withReference(libraryServiceStubRef))
        .setScope(ScopeNode.PUBLIC)
        .build();
  }

  private MethodDefinition createNestedShelfClassCtor() {
    VariableExpr thisShelfNameVariableExpr =
        createVarExprFromRefThisExpr(shelfNameVar, shelfClassRef);

    VariableExpr thisSeriesNumVariableExpr =
        createVarExprFromRefThisExpr(seriesNumVar, shelfClassRef);
    AssignmentExpr thisShelfNameAssignExpr =
        createAssignmentExpr(thisShelfNameVariableExpr, VariableExpr.withVariable(shelfNameVar));
    AssignmentExpr thisSeriesNumAssignExpr =
        createAssignmentExpr(thisSeriesNumVariableExpr, VariableExpr.withVariable(seriesNumVar));
    return MethodDefinition.constructorBuilder()
        .setArguments(
            Arrays.asList(createVarDeclExpr(shelfNameVar), createVarDeclExpr(seriesNumVar)))
        .setBody(
            Arrays.asList(
                ExprStatement.withExpr(thisShelfNameAssignExpr),
                ExprStatement.withExpr(thisSeriesNumAssignExpr)))
        .setReturnType(TypeNode.withReference(shelfClassRef))
        .setScope(ScopeNode.PUBLIC)
        .build();
  }

  private MethodDefinition createAbstractCreateBookMethod() {
    return MethodDefinition.builder()
        .setIsAbstract(true)
        .setArguments(
            Arrays.asList(createVarDeclExpr(seriesNumVar), createVarDeclExpr(bookKindVar)))
        .setReturnType(TypeNode.VOID)
        .setName("createBook")
        .setScope(ScopeNode.PUBLIC)
        .build();
  }

  private MethodDefinition createOverrideCreateBookMethod(
      VaporReference classRef, Expr bookKindDefaultExpr) {

    VariableExpr thisBookKindVariableExpr =
        createVarExprFromRefVarExpr(
            bookKindVar,
            ValueExpr.withValue(ThisObjectValue.withType(TypeNode.withReference(classRef))));
    VariableExpr thisSeriesNumVariableExpr =
        createVarExprFromRefVarExpr(
            seriesNumVar,
            ValueExpr.withValue(ThisObjectValue.withType(TypeNode.withReference(classRef))));

    AssignmentExpr thisSeriesNumAssignExpr =
        createAssignmentExpr(thisSeriesNumVariableExpr, VariableExpr.withVariable(seriesNumVar));
    AssignmentExpr thisBookKindAssignmentExpr =
        createAssignmentExpr(thisBookKindVariableExpr, bookKindDefaultExpr);

    MethodDefinition overrideCreateBook =
        MethodDefinition.builder()
            .setAnnotations(Arrays.asList(AnnotationNode.OVERRIDE))
            .setArguments(
                Arrays.asList(createVarDeclExpr(seriesNumVar), createVarDeclExpr(bookKindVar)))
            .setReturnType(TypeNode.VOID)
            .setName("createBook")
            .setScope(ScopeNode.PUBLIC)
            .setBody(
                Arrays.asList(
                    ExprStatement.withExpr(thisSeriesNumAssignExpr),
                    ExprStatement.withExpr(thisBookKindAssignmentExpr)))
            .build();
    return overrideCreateBook;
  }

  private MethodDefinition createAddShelfMethod() {
    Variable nameVar = createVarFromType(TypeNode.STRING, "name");
    Variable seriesDoubleNumVar = createVarFromType(TypeNode.DOUBLE, "seriesDoubleNum");
    CastExpr seriesNumDoubleToIntExpr =
        CastExpr.builder()
            .setExpr(VariableExpr.withVariable(seriesDoubleNumVar))
            .setType(TypeNode.INT)
            .build();
    AssignmentExpr castSeriesNumExpr =
        createAssignmentExpr(createVarDeclExpr(seriesNumVar), seriesNumDoubleToIntExpr);
    ReturnExpr maxValueReturnExpr = createReturnExpr("Series number equals to max int value.");
    ReturnExpr duplicateKeyReturnExpr = createReturnExpr("Shelf is already existing in the map.");
    // TODO: update the condition from `condition` to `seriesNum == MAX_VALUE`
    IfStatement maxValueCheck =
        IfStatement.builder()
            .setConditionExpr(
                VariableExpr.withVariable(createVarFromType(TypeNode.BOOLEAN, "condition")))
            .setBody(Arrays.asList(ExprStatement.withExpr(maxValueReturnExpr)))
            .build();
    NewObjectExpr newShelfExpr = createNewObjectExprWithArg(nameVar);
    MethodInvocationExpr addShelfToListExpr =
        methodExprWithRefAndArg(shelfListVar, "add", Arrays.asList(newShelfExpr));
    MethodInvocationExpr putShelfToMapExpr =
        methodExprWithRefAndArg(
            shelfMapVar, "put", Arrays.asList(VariableExpr.withVariable(nameVar), newShelfExpr));
    MethodInvocationExpr mapContainsKey =
        methodExprWithRefArgAndReturn(
            shelfMapVar, Arrays.asList(VariableExpr.withVariable(nameVar)));

    IfStatement mapContainsKeyCheck =
        IfStatement.builder()
            .setConditionExpr(mapContainsKey)
            .setBody(Arrays.asList(ExprStatement.withExpr(duplicateKeyReturnExpr)))
            .build();
    return MethodDefinition.builder()
        .setAnnotations(Arrays.asList(AnnotationNode.OVERRIDE))
        .setName("addShelf")
        .setReturnType(TypeNode.STRING)
        .setReturnExpr(ValueExpr.withValue(StringObjectValue.withValue("Shelf added.")))
        .setScope(ScopeNode.PUBLIC)
        .setBody(
            Arrays.asList(
                ExprStatement.withExpr(castSeriesNumExpr),
                maxValueCheck,
                ExprStatement.withExpr(addShelfToListExpr),
                mapContainsKeyCheck,
                ExprStatement.withExpr(putShelfToMapExpr)))
        .setArguments(
            Arrays.asList(createVarDeclExpr(nameVar), createVarDeclExpr(seriesDoubleNumVar)))
        .build();
  }

  private MethodDefinition createUpdateShelfMap() {
    ConcreteReference nonexistentShelfExceptionRef =
        ConcreteReference.builder().setClazz(Exception.class).build();
    Variable shelfVar = createVarFromVaporRef(shelfClassRef, "newShelf");
    VariableExpr shelfNameFromNewShelfObject =
        fieldFromShelfObjectExpr(shelfVar, createVarFromType(TypeNode.STRING, "shelfName"));

    MethodInvocationExpr mapContainsKeyExpr =
        methodExprWithRefArgAndReturn(shelfMapVar, Arrays.asList(shelfNameFromNewShelfObject));
    MethodInvocationExpr putShelfToMapExpr =
        methodExprWithRefAndArg(
            shelfMapVar,
            "put",
            Arrays.asList(shelfNameFromNewShelfObject, VariableExpr.withVariable(shelfVar)));
    ThrowExpr throwExpr =
        ThrowExpr.builder()
            .setMessageExpr("Updating shelf is not existing in the map")
            .setType(TypeNode.withReference(nonexistentShelfExceptionRef))
            .build();
    IfStatement updateShelfMapIfElseBlock =
        IfStatement.builder()
            .setConditionExpr(mapContainsKeyExpr)
            .setBody(Arrays.asList(ExprStatement.withExpr(putShelfToMapExpr)))
            .setElseBody(Arrays.asList(ExprStatement.withExpr(throwExpr)))
            .build();
    return MethodDefinition.builder()
        .setName("updateShelfMap")
        .setThrowsExceptions(Arrays.asList(TypeNode.withReference(nonexistentShelfExceptionRef)))
        .setReturnType(TypeNode.VOID)
        .setScope(ScopeNode.PUBLIC)
        .setBody(Arrays.asList(updateShelfMapIfElseBlock))
        .setArguments(
            Arrays.asList(VariableExpr.builder().setVariable(shelfVar).setIsDecl(true).build()))
        .build();
  }

  private MethodDefinition createPrintShelfListToFile() {
    ConcreteReference stringBuilderRef =
        ConcreteReference.builder().setClazz(StringBuilder.class).build();
    ConcreteReference fileWriterRef =
        ConcreteReference.builder().setClazz(FileWriter.class).build();
    Variable stringBuilderVar = createVarFromConcreteRef(stringBuilderRef, "sb");
    Variable fileNameVar = createVarFromType(TypeNode.STRING, "fileName");
    Variable shelfObject = createVarFromVaporRef(shelfClassRef, "s");
    Variable fileWriterVar = createVarFromConcreteRef(fileWriterRef, "fileWriter");
    Variable ioException =
        createVarFromConcreteRef(ConcreteReference.withClazz(IOException.class), "e");
    VariableExpr shelfNameFromShelfObject = fieldFromShelfObjectExpr(shelfObject, shelfNameVar);
    VariableExpr seriesNumFromShelfObject = fieldFromShelfObjectExpr(shelfObject, seriesNumVar);

    AssignmentExpr createStringBuilderExpr =
        createAssignmentExpr(
            createVarDeclExpr(stringBuilderVar),
            NewObjectExpr.withType(TypeNode.withReference(stringBuilderRef)));

    AssignmentExpr createFileWriterExpr =
        createAssignmentExpr(
            createVarDeclExpr(fileWriterVar),
            NewObjectExpr.builder()
                .setType(TypeNode.withReference(fileWriterRef))
                .setArguments(Arrays.asList(VariableExpr.withVariable(fileNameVar)))
                .build());
    MethodInvocationExpr appendShelfName =
        methodExprWithRefAndArg(
            stringBuilderVar, "append", Arrays.asList(shelfNameFromShelfObject));

    MethodInvocationExpr appendSeriesNum =
        MethodInvocationExpr.builder()
            .setMethodName("append")
            .setExprReferenceExpr(appendShelfName)
            .setArguments(seriesNumFromShelfObject)
            .build();
    MethodInvocationExpr stringBuilderToString = methodExprWithRef(stringBuilderVar, "toString");
    MethodInvocationExpr writeToFileWriter =
        methodExprWithRefAndArg(fileNameVar, "write", Arrays.asList(stringBuilderToString));
    MethodInvocationExpr closeFileWriter = methodExprWithRef(fileNameVar, "close");
    MethodInvocationExpr printError = methodExprWithRef(ioException, "printStackTrace");

    ForStatement loopShelfList =
        ForStatement.builder()
            .setLocalVariableExpr(createVarDeclExpr(shelfObject))
            .setCollectionExpr(VariableExpr.withVariable(shelfListVar))
            .setBody(Arrays.asList(ExprStatement.withExpr(appendSeriesNum)))
            .build();
    TryCatchStatement tryCatchStatement =
        TryCatchStatement.builder()
            .setTryBody(
                Arrays.asList(
                    ExprStatement.withExpr(createFileWriterExpr),
                    loopShelfList,
                    ExprStatement.withExpr(writeToFileWriter),
                    ExprStatement.withExpr(closeFileWriter)))
            .addCatch(
                createVarDeclExpr(ioException), Arrays.asList(ExprStatement.withExpr(printError)))
            .build();

    return MethodDefinition.builder()
        .setName("printShelfListToFile")
        .setReturnType(TypeNode.VOID)
        .setScope(ScopeNode.PUBLIC)
        .setBody(Arrays.asList(ExprStatement.withExpr(createStringBuilderExpr), tryCatchStatement))
        .setArguments(Arrays.asList(createVarDeclExpr(fileNameVar)))
        .build();
  }

  private MethodDefinition createAddBookToShelf() {
    Variable bookVar = createVarFromVaporRef(bookClassRef, "book");
    AnonymousClassExpr anonymousBookClassExpr = createAnonymousClass();
    AssignmentExpr createNewBook =
        createAssignmentExpr(createVarDeclExpr(bookVar), anonymousBookClassExpr);

    return MethodDefinition.builder()
        .setHeaderCommentStatements(Arrays.asList(createPreMethodLineComment("Private helper.")))
        .setName("addBookToShelf")
        .setReturnType(TypeNode.withReference(bookClassRef))
        .setArguments(Arrays.asList(createVarDeclExpr(bookKindVar), createVarDeclExpr(shelfVar)))
        .setScope(ScopeNode.PRIVATE)
        .setBody(Arrays.asList(ExprStatement.withExpr(createNewBook)))
        .setReturnExpr(VariableExpr.withVariable(bookVar))
        .build();
  }

  private MethodDefinition createAddBooksContainsNovel() {
    ConcreteReference bookKindStackRef =
        ConcreteReference.builder()
            .setClazz(Stack.class)
            .setGenerics(Arrays.asList(bookKindRef))
            .build();
    Variable bookKindStackVar = createVarFromConcreteRef(bookKindStackRef, "stack");
    Variable containsNovelVar = createVarFromType(TypeNode.BOOLEAN, "containsNovel");
    Variable bookVar = createVarFromVaporRef(bookClassRef, "addedBook");
    TernaryExpr ternaryExpr = createTernaryExpr(containsNovelVar);
    AssignmentExpr setContainsNovelToFalse =
        createAssignmentExpr(
            createVarDeclExpr(containsNovelVar), ValueExpr.withValue(createBooleanValue("false")));
    MethodInvocationExpr stackIsEmpty =
        MethodInvocationExpr.builder()
            .setMethodName("isEmpty")
            .setExprReferenceExpr(VariableExpr.withVariable(bookKindStackVar))
            .setReturnType(TypeNode.BOOLEAN)
            .build();
    MethodInvocationExpr stackPop = methodExprWithRef(bookKindStackVar, "pop");
    MethodInvocationExpr addBookToShelfMethod =
        MethodInvocationExpr.builder()
            .setMethodName("addBookToShelf")
            .setArguments(stackPop, VariableExpr.withVariable(shelfVar))
            .setReturnType(TypeNode.withReference(bookClassRef))
            .build();
    AssignmentExpr createNewAddedBook =
        createAssignmentExpr(createVarDeclExpr(bookVar), addBookToShelfMethod);

    InstanceofExpr addedBookIsNovelInstance =
        InstanceofExpr.builder()
            .setExpr(VariableExpr.withVariable(bookVar))
            .setCheckType(TypeNode.withReference(novelClassRef))
            .build();
    AssignmentExpr setContainsNovelToTrue =
        createAssignmentExpr(
            VariableExpr.withVariable(containsNovelVar),
            ValueExpr.withValue(createBooleanValue("true")));

    IfStatement ifStatement =
        IfStatement.builder()
            .setConditionExpr(addedBookIsNovelInstance)
            .setBody(Arrays.asList(ExprStatement.withExpr(setContainsNovelToTrue)))
            .build();
    // TODO: update the conditionExpr from `stack.isEmpty()` to `!stack.isEmpty()`
    WhileStatement whileStatement =
        WhileStatement.builder()
            .setConditionExpr(stackIsEmpty)
            .setBody(Arrays.asList(ExprStatement.withExpr(createNewAddedBook), ifStatement))
            .build();
    return MethodDefinition.builder()
        .setHeaderCommentStatements(createPreMethodJavaDocComment())
        .setArguments(
            Arrays.asList(createVarDeclExpr(shelfVar), createVarDeclExpr(bookKindStackVar)))
        .setName("addBooksContainsNovel")
        .setReturnType(TypeNode.STRING)
        .setScope(ScopeNode.PUBLIC)
        .setBody(Arrays.asList(ExprStatement.withExpr(setContainsNovelToFalse), whileStatement))
        .setReturnExpr(ternaryExpr)
        .build();
  }

  private ClassDefinition createNestedClassShelf() {
    VariableExpr shelfNameDel = createVarPublicDeclExpr(shelfNameVar);
    VariableExpr seriesNumDel = createVarPublicDeclExpr(seriesNumVar);
    VariableExpr shelfServiceNameDel = createVarPublicDeclExpr(shelfServiceNameVar);
    AssignmentExpr shelfServiceNameAssignmentExpr =
        createAssignmentExpr(
            shelfServiceNameDel,
            VariableExpr.withVariable(createVarFromType(TypeNode.STRING, "serviceName")));
    MethodDefinition nestedShelfClassCtor = createNestedShelfClassCtor();
    return ClassDefinition.builder()
        .setIsNested(true)
        .setMethods(Arrays.asList(nestedShelfClassCtor))
        .setStatements(
            Arrays.asList(
                ExprStatement.withExpr(shelfNameDel),
                ExprStatement.withExpr(seriesNumDel),
                ExprStatement.withExpr(shelfServiceNameAssignmentExpr)))
        .setName("Shelf")
        .setScope(ScopeNode.PUBLIC)
        .build();
  }

  private ClassDefinition createNestedClassBook() {
    VariableExpr bookKindDel = createVarPublicDeclExpr(bookKindVar);
    MethodDefinition createBookMethod = createAbstractCreateBookMethod();
    VariableExpr seriesNumDel = createVarPublicDeclExpr(seriesNumVar);
    return ClassDefinition.builder()
        .setHeaderCommentStatements(
            Arrays.asList(
                createPreMethodLineComment("Test nested abstract class and abstract method.")))
        .setMethods(Arrays.asList(createBookMethod))
        .setStatements(
            Arrays.asList(
                ExprStatement.withExpr(bookKindDel), ExprStatement.withExpr(seriesNumDel)))
        .setName("Book")
        .setScope(ScopeNode.PUBLIC)
        .setIsNested(true)
        .setIsAbstract(true)
        .build();
  }

  private ClassDefinition createNestedClassNovel() {
    EnumRefExpr bookKindNovelEnumExpr =
        EnumRefExpr.builder().setName("NOVEL").setType(bookKindVar.type()).build();
    return ClassDefinition.builder()
        .setName("Novel")
        .setScope(ScopeNode.PUBLIC)
        .setIsNested(true)
        .setExtendsType(TypeNode.withReference(bookClassRef))
        .setMethods(
            Arrays.asList(createOverrideCreateBookMethod(novelClassRef, bookKindNovelEnumExpr)))
        .build();
  }
}
