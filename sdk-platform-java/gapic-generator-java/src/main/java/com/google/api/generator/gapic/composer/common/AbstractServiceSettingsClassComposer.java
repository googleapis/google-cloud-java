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

package com.google.api.generator.gapic.composer.common;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.BatchingCallSettings;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.ServerStreamingCallSettings;
import com.google.api.gax.rpc.StreamingCallSettings;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.generator.engine.ast.AnnotationNode;
import com.google.api.generator.engine.ast.CastExpr;
import com.google.api.generator.engine.ast.ClassDefinition;
import com.google.api.generator.engine.ast.CommentStatement;
import com.google.api.generator.engine.ast.ConcreteReference;
import com.google.api.generator.engine.ast.Expr;
import com.google.api.generator.engine.ast.ExprStatement;
import com.google.api.generator.engine.ast.MethodDefinition;
import com.google.api.generator.engine.ast.MethodInvocationExpr;
import com.google.api.generator.engine.ast.NewObjectExpr;
import com.google.api.generator.engine.ast.Reference;
import com.google.api.generator.engine.ast.ReferenceConstructorExpr;
import com.google.api.generator.engine.ast.ScopeNode;
import com.google.api.generator.engine.ast.SuperObjectValue;
import com.google.api.generator.engine.ast.ThisObjectValue;
import com.google.api.generator.engine.ast.TypeNode;
import com.google.api.generator.engine.ast.ValueExpr;
import com.google.api.generator.engine.ast.VaporReference;
import com.google.api.generator.engine.ast.Variable;
import com.google.api.generator.engine.ast.VariableExpr;
import com.google.api.generator.gapic.composer.comment.SettingsCommentComposer;
import com.google.api.generator.gapic.composer.samplecode.SampleCodeWriter;
import com.google.api.generator.gapic.composer.samplecode.SampleComposerUtil;
import com.google.api.generator.gapic.composer.samplecode.SettingsSampleComposer;
import com.google.api.generator.gapic.composer.store.TypeStore;
import com.google.api.generator.gapic.composer.utils.ClassNames;
import com.google.api.generator.gapic.composer.utils.CommonStrings;
import com.google.api.generator.gapic.composer.utils.PackageChecker;
import com.google.api.generator.gapic.model.GapicClass;
import com.google.api.generator.gapic.model.GapicClass.Kind;
import com.google.api.generator.gapic.model.GapicContext;
import com.google.api.generator.gapic.model.Method;
import com.google.api.generator.gapic.model.Method.Stream;
import com.google.api.generator.gapic.model.Sample;
import com.google.api.generator.gapic.model.Service;
import com.google.api.generator.gapic.utils.JavaStyle;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Generated;

public abstract class AbstractServiceSettingsClassComposer implements ClassComposer {
  private static final String BUILDER_CLASS_NAME = "Builder";

  protected static final TypeStore FIXED_TYPESTORE = createStaticTypes();

  private final TransportContext transportContext;

  protected AbstractServiceSettingsClassComposer(TransportContext transportContext) {
    this.transportContext = transportContext;
  }

  protected TransportContext getTransportContext() {
    return transportContext;
  }

  private static List<AnnotationNode> createMethodAnnotations(Method method) {
    List<AnnotationNode> annotations = new ArrayList<>();
    if (method.isDeprecated()) {
      annotations.add(AnnotationNode.withType(TypeNode.DEPRECATED));
    }

    if (method.isInternalApi()) {
      annotations.add(
          AnnotationNode.withTypeAndDescription(
              FIXED_TYPESTORE.get("InternalApi"), CommonStrings.INTERNAL_API_WARNING));
    }

    return annotations;
  }

  @Override
  public GapicClass generate(GapicContext context, Service service) {
    String pakkage = service.pakkage();
    TypeStore typeStore = createDynamicTypes(service);
    String className = ClassNames.getServiceSettingsClassName(service);
    GapicClass.Kind kind = Kind.MAIN;
    List<Sample> samples = new ArrayList<>();
    List<CommentStatement> classHeaderComments =
        createClassHeaderComments(service, typeStore.get(className), samples);
    ClassDefinition classDef =
        ClassDefinition.builder()
            .setPackageString(pakkage)
            .setHeaderCommentStatements(classHeaderComments)
            .setAnnotations(createClassAnnotations(service))
            .setScope(ScopeNode.PUBLIC)
            .setName(className)
            .setExtendsType(
                TypeNode.withReference(
                    FIXED_TYPESTORE
                        .get("ClientSettings")
                        .reference()
                        .copyAndSetGenerics(
                            Arrays.asList(
                                typeStore
                                    .get(ClassNames.getServiceSettingsClassName(service))
                                    .reference()))))
            .setMethods(createClassMethods(service, typeStore))
            .setNestedClasses(Arrays.asList(createNestedBuilderClass(service, typeStore)))
            .build();
    return GapicClass.create(kind, classDef, SampleComposerUtil.handleDuplicateSamples(samples))
        .withApiShortName(service.apiShortName())
        .withPackageVersion(service.packageVersion());
  }

  private static List<CommentStatement> createClassHeaderComments(
      Service service, TypeNode classType, List<Sample> samples) {
    // Pick the first public pure unary rpc method, if no such method exists, then pick the first
    // public in the
    // list.
    List<Method> publicMethods =
        service.methods().stream()
            .filter(m -> m.isInternalApi() == false)
            .collect(Collectors.toList());
    Optional<Method> methodOpt =
        publicMethods.isEmpty()
            ? Optional.empty()
            : Optional.of(
                publicMethods.stream()
                    .filter(m -> m.stream() == Stream.NONE && !m.hasLro() && !m.isPaged())
                    .findFirst()
                    .orElse(publicMethods.get(0)));
    Optional<String> methodNameOpt =
        methodOpt.isPresent() ? Optional.of(methodOpt.get().name()) : Optional.empty();
    Optional<Sample> sampleCode =
        SettingsSampleComposer.composeSettingsSample(
            methodNameOpt, ClassNames.getServiceSettingsClassName(service), classType);
    Optional<String> docSampleCode = Optional.empty();
    if (sampleCode.isPresent()) {
      samples.add(sampleCode.get());
      docSampleCode = Optional.of(SampleCodeWriter.writeInlineSample(sampleCode.get().body()));
    }
    // Create a sample for a LRO method using LRO-specific RetrySettings, if one exists in the
    // service.
    Optional<Method> lroMethodOpt =
        publicMethods.isEmpty()
            ? Optional.empty()
            : publicMethods.stream()
                .filter(m -> m.stream() == Stream.NONE && m.hasLro())
                .findFirst();
    Optional<String> lroMethodNameOpt =
        lroMethodOpt.isPresent() ? Optional.of(lroMethodOpt.get().name()) : Optional.empty();
    Optional<Sample> lroSampleCode =
        SettingsSampleComposer.composeLroSettingsSample(
            lroMethodNameOpt, ClassNames.getServiceSettingsClassName(service), classType);
    Optional<String> lroDocSampleCode = Optional.empty();
    if (lroSampleCode.isPresent()) {
      samples.add(lroSampleCode.get());
      lroDocSampleCode =
          Optional.of(SampleCodeWriter.writeInlineSample(lroSampleCode.get().body()));
    }

    return SettingsCommentComposer.createClassHeaderComments(
        ClassNames.getServiceClientClassName(service),
        service.defaultHost(),
        service.isDeprecated(),
        methodNameOpt,
        docSampleCode,
        lroMethodNameOpt,
        lroDocSampleCode,
        classType);
  }

  private static List<AnnotationNode> createClassAnnotations(Service service) {
    List<AnnotationNode> annotations = new ArrayList<>();
    if (!PackageChecker.isGaApi(service.pakkage())) {
      annotations.add(AnnotationNode.withType(FIXED_TYPESTORE.get("BetaApi")));
    }

    if (service.isDeprecated()) {
      annotations.add(AnnotationNode.withType(TypeNode.DEPRECATED));
    }

    annotations.add(
        AnnotationNode.builder()
            .setType(FIXED_TYPESTORE.get("Generated"))
            .setDescription("by gapic-generator-java")
            .build());
    return annotations;
  }

  private List<MethodDefinition> createClassMethods(Service service, TypeStore typeStore) {
    List<MethodDefinition> javaMethods = new ArrayList<>();
    javaMethods.addAll(createSettingsGetterMethods(service, typeStore));
    javaMethods.add(createCreatorMethod(service, typeStore));
    javaMethods.addAll(createDefaultGetterMethods(service, typeStore));
    javaMethods.addAll(
        createNewBuilderMethods(
            service,
            typeStore,
            "newBuilder",
            "createDefault",
            ImmutableList.of(),
            SettingsCommentComposer.NEW_BUILDER_METHOD_COMMENT));
    javaMethods.addAll(createBuilderHelperMethods(service, typeStore));
    javaMethods.add(createConstructorMethod(service, typeStore));
    return javaMethods;
  }

  private static MethodDefinition createConstructorMethod(Service service, TypeStore typeStore) {
    VariableExpr settingsBuilderVarExpr =
        VariableExpr.withVariable(
            Variable.builder()
                .setName("settingsBuilder")
                .setType(typeStore.get(BUILDER_CLASS_NAME))
                .build());
    TypeNode thisClassType = typeStore.get(ClassNames.getServiceSettingsClassName(service));
    return MethodDefinition.constructorBuilder()
        .setScope(ScopeNode.PROTECTED)
        .setReturnType(thisClassType)
        .setArguments(Arrays.asList(settingsBuilderVarExpr.toBuilder().setIsDecl(true).build()))
        .setThrowsExceptions(Arrays.asList(FIXED_TYPESTORE.get("IOException")))
        .setBody(
            Arrays.asList(
                ExprStatement.withExpr(
                    ReferenceConstructorExpr.superBuilder()
                        .setType(FIXED_TYPESTORE.get("ClientSettings"))
                        .setArguments(settingsBuilderVarExpr)
                        .build())))
        .build();
  }

  // TODO(miraleung): Consider merging this with createNestedBuilderSettingsGetterMethods.
  private static List<MethodDefinition> createSettingsGetterMethods(
      Service service, TypeStore typeStore) {
    TypeNode stubSettingsType = typeStore.get(ClassNames.getServiceStubSettingsClassName(service));
    BiFunction<TypeNode, String, MethodDefinition.Builder> methodMakerFn =
        (retType, javaMethodName) ->
            MethodDefinition.builder()
                .setScope(ScopeNode.PUBLIC)
                .setReturnType(retType)
                .setName(javaMethodName)
                .setReturnExpr(
                    MethodInvocationExpr.builder()
                        .setExprReferenceExpr(
                            CastExpr.builder()
                                .setType(stubSettingsType)
                                .setExpr(
                                    MethodInvocationExpr.builder()
                                        .setMethodName("getStubSettings")
                                        .setReturnType(FIXED_TYPESTORE.get("StubSettings"))
                                        .build())
                                .build())
                        .setMethodName(javaMethodName)
                        .setReturnType(retType)
                        .build());
    List<MethodDefinition> javaMethods = new ArrayList<>();
    for (Method protoMethod : service.methods()) {
      String javaStyleName = JavaStyle.toLowerCamelCase(protoMethod.name());
      String javaMethodName = String.format("%sSettings", javaStyleName);
      MethodDefinition.Builder methodBuilder =
          methodMakerFn.apply(getCallSettingsType(protoMethod, typeStore), javaMethodName);
      javaMethods.add(methodBuilderHelper(protoMethod, methodBuilder, javaMethodName));
      if (protoMethod.hasLro()) {
        String javaOperationSettingsMethodName =
            String.format("%sOperationSettings", javaStyleName);
        methodBuilder =
            methodMakerFn.apply(
                getOperationCallSettingsType(protoMethod), javaOperationSettingsMethodName);
        javaMethods.add(
            methodBuilderHelper(protoMethod, methodBuilder, javaOperationSettingsMethodName));
      }
    }
    return javaMethods;
  }

  // Add method header comment statements and annotations.
  private static MethodDefinition methodBuilderHelper(
      Method protoMethod, MethodDefinition.Builder methodBuilder, String javaMethodName) {
    return methodBuilder
        .setHeaderCommentStatements(
            SettingsCommentComposer.createCallSettingsGetterComment(
                getMethodNameFromSettingsVarName(javaMethodName),
                protoMethod.isDeprecated(),
                protoMethod.isInternalApi()))
        .setAnnotations(createMethodAnnotations(protoMethod))
        .build();
  }

  private static MethodDefinition createCreatorMethod(Service service, TypeStore typeStore) {
    TypeNode stubClassType = typeStore.get(ClassNames.getServiceStubSettingsClassName(service));
    VariableExpr stubVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setName("stub").setType(stubClassType).build());

    TypeNode thisClassType = typeStore.get(ClassNames.getServiceSettingsClassName(service));
    MethodInvocationExpr stubBuilderMethodExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(stubVarExpr)
            .setMethodName("toBuilder")
            .build();

    TypeNode stubBuilderType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("Builder")
                .setEnclosingClassNames(ClassNames.getServiceSettingsClassName(service))
                .setPakkage(service.pakkage())
                .build());
    Expr returnMethodExpr =
        NewObjectExpr.builder()
            .setType(stubBuilderType)
            .setArguments(stubBuilderMethodExpr)
            .build();
    returnMethodExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(returnMethodExpr)
            .setMethodName("build")
            .setReturnType(thisClassType)
            .build();
    return MethodDefinition.builder()
        .setScope(ScopeNode.PUBLIC)
        .setIsStatic(true)
        .setIsFinal(true)
        .setReturnType(thisClassType)
        .setName("create")
        .setArguments(Arrays.asList(stubVarExpr.toBuilder().setIsDecl(true).build()))
        .setThrowsExceptions(Arrays.asList(FIXED_TYPESTORE.get("IOException")))
        .setReturnExpr(returnMethodExpr)
        .build();
  }

  private List<MethodDefinition> createDefaultGetterMethods(Service service, TypeStore typeStore) {
    BiFunction<String, TypeNode, MethodDefinition.Builder> methodStarterFn =
        (mName, retType) ->
            MethodDefinition.builder()
                .setScope(ScopeNode.PUBLIC)
                .setIsStatic(true)
                .setReturnType(retType)
                .setName(mName)
                .setReturnExpr(
                    MethodInvocationExpr.builder()
                        .setStaticReferenceType(
                            typeStore.get(ClassNames.getServiceStubSettingsClassName(service)))
                        .setMethodName(mName)
                        .setReturnType(retType)
                        .build());
    BiFunction<MethodDefinition.Builder, CommentStatement, MethodDefinition> methodMakerFn =
        (methodDefBuilder, comment) -> methodDefBuilder.setHeaderCommentStatements(comment).build();
    Function<Class<?>, TypeNode> typeMakerFn =
        c -> TypeNode.withReference(ConcreteReference.withClazz(c));

    List<MethodDefinition> javaMethods = new ArrayList<>();
    javaMethods.add(
        methodMakerFn.apply(
            methodStarterFn.apply(
                "defaultExecutorProviderBuilder",
                typeMakerFn.apply(InstantiatingExecutorProvider.Builder.class)),
            SettingsCommentComposer.DEFAULT_EXECUTOR_PROVIDER_BUILDER_METHOD_COMMENT));
    javaMethods.add(
        methodMakerFn.apply(
            methodStarterFn.apply("getDefaultEndpoint", TypeNode.STRING),
            SettingsCommentComposer.DEFAULT_SERVICE_ENDPOINT_METHOD_COMMENT));
    javaMethods.add(
        methodMakerFn.apply(
            methodStarterFn.apply(
                "getDefaultServiceScopes",
                TypeNode.withReference(
                    ConcreteReference.builder()
                        .setClazz(List.class)
                        .setGenerics(Arrays.asList(TypeNode.STRING.reference()))
                        .build())),
            SettingsCommentComposer.DEFAULT_SERVICE_SCOPES_METHOD_COMMENT));
    javaMethods.add(
        methodMakerFn.apply(
            methodStarterFn.apply(
                "defaultCredentialsProviderBuilder",
                typeMakerFn.apply(GoogleCredentialsProvider.Builder.class)),
            SettingsCommentComposer.DEFAULT_CREDENTIALS_PROVIDER_BUILDER_METHOD_COMMENT));

    Iterator<String> providerBuilderNamesIt =
        getTransportContext().defaultTransportProviderBuilderNames().iterator();
    Iterator<Class<?>> channelProviderClassesIt =
        getTransportContext().instantiatingChannelProviderBuilderClasses().iterator();
    Iterator<String> transportNamesIt = getTransportContext().transportNames().iterator();

    boolean secondaryTransportProviderBuilder = false;
    while (providerBuilderNamesIt.hasNext()
        && channelProviderClassesIt.hasNext()
        && transportNamesIt.hasNext()) {
      String providerBuilderName = providerBuilderNamesIt.next();
      Class<?> channelProviderClass = channelProviderClassesIt.next();
      String transportName = transportNamesIt.next();

      if (!service.hasAnyEnabledMethodsForTransport(transportName)) {
        continue;
      }

      List<AnnotationNode> annotations = ImmutableList.of();

      // For clients supporting multiple transports (mainly grpc+rest case) make secondary transport
      // declared as @BetaApi for now.
      if (secondaryTransportProviderBuilder) {
        annotations =
            Arrays.asList(AnnotationNode.builder().setType(FIXED_TYPESTORE.get("BetaApi")).build());
      }
      CommentStatement commentStatement =
          SettingsCommentComposer.DEFAULT_TRANSPORT_PROVIDER_BUILDER_METHOD_COMMENT;
      if (getTransportContext().transportNames().size() > 1) {
        commentStatement =
            new SettingsCommentComposer(transportName).getTransportProviderBuilderMethodComment();
      }

      javaMethods.add(
          methodMakerFn.apply(
              methodStarterFn
                  .apply(providerBuilderName, typeMakerFn.apply(channelProviderClass))
                  .setAnnotations(annotations),
              commentStatement));
      secondaryTransportProviderBuilder = true;
    }

    javaMethods.add(
        methodStarterFn
            .apply(
                "defaultTransportChannelProvider",
                typeMakerFn.apply(TransportChannelProvider.class))
            .build());

    javaMethods.add(
        methodStarterFn
            .apply(
                "defaultApiClientHeaderProviderBuilder",
                TypeNode.withReference(
                    ConcreteReference.withClazz(ApiClientHeaderProvider.Builder.class)))
            .build());
    return javaMethods;
  }

  protected List<MethodDefinition> createNewBuilderMethods(
      Service service,
      TypeStore typeStore,
      String newBuilderMethodName,
      String createDefaultMethodName,
      List<AnnotationNode> annotations,
      CommentStatement comment) {
    TypeNode builderType = typeStore.get(BUILDER_CLASS_NAME);
    return ImmutableList.of(
        MethodDefinition.builder()
            .setHeaderCommentStatements(comment)
            .setAnnotations(annotations)
            .setScope(ScopeNode.PUBLIC)
            .setIsStatic(true)
            .setReturnType(builderType)
            .setName(newBuilderMethodName)
            .setReturnExpr(
                MethodInvocationExpr.builder()
                    .setStaticReferenceType(builderType)
                    .setMethodName(createDefaultMethodName)
                    .setReturnType(builderType)
                    .build())
            .build());
  }

  private static List<MethodDefinition> createBuilderHelperMethods(
      Service service, TypeStore typeStore) {
    TypeNode builderType = typeStore.get(BUILDER_CLASS_NAME);

    VariableExpr clientContextVarExpr =
        VariableExpr.withVariable(
            Variable.builder()
                .setName("clientContext")
                .setType(FIXED_TYPESTORE.get("ClientContext"))
                .build());

    MethodDefinition newBuilderMethodTwo =
        MethodDefinition.builder()
            .setHeaderCommentStatements(SettingsCommentComposer.NEW_BUILDER_METHOD_COMMENT)
            .setScope(ScopeNode.PUBLIC)
            .setIsStatic(true)
            .setReturnType(builderType)
            .setName("newBuilder")
            .setArguments(clientContextVarExpr.toBuilder().setIsDecl(true).build())
            .setReturnExpr(
                NewObjectExpr.builder()
                    .setType(builderType)
                    .setArguments(Arrays.asList(clientContextVarExpr))
                    .build())
            .build();

    MethodDefinition toBuilderMethod =
        MethodDefinition.builder()
            .setHeaderCommentStatements(SettingsCommentComposer.TO_BUILDER_METHOD_COMMENT)
            .setScope(ScopeNode.PUBLIC)
            .setReturnType(builderType)
            .setName("toBuilder")
            .setReturnExpr(
                NewObjectExpr.builder()
                    .setType(builderType)
                    .setArguments(
                        ValueExpr.withValue(
                            ThisObjectValue.withType(
                                typeStore.get(ClassNames.getServiceSettingsClassName(service)))))
                    .build())
            .build();

    return Arrays.asList(newBuilderMethodTwo, toBuilderMethod);
  }

  private ClassDefinition createNestedBuilderClass(Service service, TypeStore typeStore) {
    return ClassDefinition.builder()
        .setHeaderCommentStatements(
            SettingsCommentComposer.createBuilderClassComment(
                ClassNames.getServiceSettingsClassName(service)))
        .setIsNested(true)
        .setScope(ScopeNode.PUBLIC)
        .setIsStatic(true)
        .setName(BUILDER_CLASS_NAME)
        .setExtendsType(
            TypeNode.withReference(
                ConcreteReference.builder()
                    .setClazz(ClientSettings.Builder.class)
                    .setGenerics(
                        Arrays.asList(
                            typeStore
                                .get(ClassNames.getServiceSettingsClassName(service))
                                .reference(),
                            typeStore.get(BUILDER_CLASS_NAME).reference()))
                    .build()))
        .setMethods(createNestedBuilderClassMethods(service, typeStore))
        .build();
  }

  private List<MethodDefinition> createNestedBuilderClassMethods(
      Service service, TypeStore typeStore) {
    List<MethodDefinition> javaMethods = new ArrayList<>();
    javaMethods.addAll(createNestedBuilderConstructorMethods(service, typeStore));
    javaMethods.addAll(
        createNestedBuilderCreatorMethods(
            service, typeStore, "newBuilder", "createDefault", ImmutableList.of()));
    javaMethods.add(createNestedBuilderStubSettingsBuilderMethod(service, typeStore));
    javaMethods.add(createNestedBuilderApplyToAllUnaryMethod(service, typeStore));
    javaMethods.addAll(createNestedBuilderSettingsGetterMethods(service, typeStore));
    javaMethods.add(createNestedBuilderClassBuildMethod(service, typeStore));
    return javaMethods;
  }

  private static List<MethodDefinition> createNestedBuilderConstructorMethods(
      Service service, TypeStore typeStore) {
    TypeNode builderType = typeStore.get(BUILDER_CLASS_NAME);
    MethodDefinition noArgCtor =
        MethodDefinition.constructorBuilder()
            .setScope(ScopeNode.PROTECTED)
            .setReturnType(builderType)
            .setThrowsExceptions(Arrays.asList(FIXED_TYPESTORE.get("IOException")))
            .setBody(
                Arrays.asList(
                    ExprStatement.withExpr(
                        ReferenceConstructorExpr.thisBuilder()
                            .setType(builderType)
                            .setArguments(
                                CastExpr.builder()
                                    .setType(FIXED_TYPESTORE.get("ClientContext"))
                                    .setExpr(ValueExpr.createNullExpr())
                                    .build())
                            .build())))
            .build();

    BiFunction<VariableExpr, Expr, MethodDefinition> ctorMakerFn =
        (ctorArg, superArg) ->
            MethodDefinition.constructorBuilder()
                .setScope(ScopeNode.PROTECTED)
                .setReturnType(builderType)
                .setArguments(Arrays.asList(ctorArg.toBuilder().setIsDecl(true).build()))
                .setBody(
                    Arrays.asList(
                        ExprStatement.withExpr(
                            ReferenceConstructorExpr.superBuilder()
                                .setType(FIXED_TYPESTORE.get("ClientSettings"))
                                .setArguments(superArg)
                                .build())))
                .build();

    VariableExpr clientContextVarExpr =
        VariableExpr.withVariable(
            Variable.builder()
                .setName("clientContext")
                .setType(FIXED_TYPESTORE.get("ClientContext"))
                .build());
    MethodDefinition clientContextCtor =
        ctorMakerFn.apply(
            clientContextVarExpr,
            MethodInvocationExpr.builder()
                .setStaticReferenceType(
                    typeStore.get(ClassNames.getServiceStubSettingsClassName(service)))
                .setMethodName("newBuilder")
                .setArguments(Arrays.asList(clientContextVarExpr))
                .build());

    VariableExpr settingsVarExpr =
        VariableExpr.withVariable(
            Variable.builder()
                .setName("settings")
                .setType(typeStore.get(ClassNames.getServiceSettingsClassName(service)))
                .build());
    MethodInvocationExpr settingsBuilderMethodExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(settingsVarExpr)
            .setMethodName("getStubSettings")
            .build();
    settingsBuilderMethodExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(settingsBuilderMethodExpr)
            .setMethodName("toBuilder")
            .build();
    MethodDefinition settingsCtor = ctorMakerFn.apply(settingsVarExpr, settingsBuilderMethodExpr);

    TypeNode stubSettingsBuilderType = getStubSettingsBuilderType(service);
    VariableExpr stubSettingsVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setName("stubSettings").setType(stubSettingsBuilderType).build());
    MethodDefinition stubSettingsCtor = ctorMakerFn.apply(stubSettingsVarExpr, stubSettingsVarExpr);

    return Arrays.asList(noArgCtor, clientContextCtor, settingsCtor, stubSettingsCtor);
  }

  protected List<MethodDefinition> createNestedBuilderCreatorMethods(
      Service service,
      TypeStore typeStore,
      String newBuilderMethodName,
      String createDefaultMethodName,
      List<AnnotationNode> annotations) {
    MethodInvocationExpr ctorArg =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(
                typeStore.get(ClassNames.getServiceStubSettingsClassName(service)))
            .setMethodName(newBuilderMethodName)
            .build();

    TypeNode builderType = typeStore.get(BUILDER_CLASS_NAME);
    return ImmutableList.of(
        MethodDefinition.builder()
            .setAnnotations(annotations)
            .setScope(ScopeNode.PRIVATE)
            .setIsStatic(true)
            .setReturnType(builderType)
            .setName(createDefaultMethodName)
            .setReturnExpr(
                NewObjectExpr.builder().setType(builderType).setArguments(ctorArg).build())
            .build());
  }

  private static MethodDefinition createNestedBuilderStubSettingsBuilderMethod(
      Service service, TypeStore typeStore) {
    TypeNode retType = getStubSettingsBuilderType(service);
    return MethodDefinition.builder()
        .setScope(ScopeNode.PUBLIC)
        .setReturnType(retType)
        .setName("getStubSettingsBuilder")
        .setReturnExpr(
            CastExpr.builder()
                .setType(retType)
                .setExpr(
                    MethodInvocationExpr.builder()
                        .setMethodName("getStubSettings")
                        .setReturnType(FIXED_TYPESTORE.get("StubSettings"))
                        .build())
                .build())
        .build();
  }

  private static MethodDefinition createNestedBuilderApplyToAllUnaryMethod(
      Service service, TypeStore typeStore) {
    TypeNode builderType = typeStore.get(BUILDER_CLASS_NAME);
    String javaMethodName = "applyToAllUnaryMethods";

    TypeNode unaryCallSettingsType =
        TypeNode.withReference(
            ConcreteReference.builder()
                .setClazz(UnaryCallSettings.Builder.class)
                .setGenerics(
                    Arrays.asList(TypeNode.WILDCARD_REFERENCE, TypeNode.WILDCARD_REFERENCE))
                .build());
    VariableExpr settingsUpdaterVarExpr =
        VariableExpr.withVariable(
            Variable.builder()
                .setName("settingsUpdater")
                .setType(
                    TypeNode.withReference(
                        FIXED_TYPESTORE
                            .get("ApiFunction")
                            .reference()
                            .copyAndSetGenerics(
                                Arrays.asList(
                                    unaryCallSettingsType.reference(),
                                    TypeNode.VOID_OBJECT.reference()))))
                .build());

    MethodInvocationExpr builderMethodExpr =
        MethodInvocationExpr.builder().setMethodName("getStubSettingsBuilder").build();
    builderMethodExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(builderMethodExpr)
            .setMethodName("unaryMethodSettingsBuilders")
            .build();

    MethodInvocationExpr applyMethodExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(
                ValueExpr.withValue(
                    SuperObjectValue.withType(
                        TypeNode.withReference(
                            ConcreteReference.withClazz(ClientSettings.Builder.class)))))
            .setMethodName(javaMethodName)
            .setArguments(Arrays.asList(builderMethodExpr, settingsUpdaterVarExpr))
            .build();

    return MethodDefinition.builder()
        .setHeaderCommentStatements(
            SettingsCommentComposer.APPLY_TO_ALL_UNARY_METHODS_METHOD_COMMENTS)
        .setScope(ScopeNode.PUBLIC)
        .setReturnType(builderType)
        .setName(javaMethodName)
        .setArguments(Arrays.asList(settingsUpdaterVarExpr.toBuilder().setIsDecl(true).build()))
        .setBody(Arrays.asList(ExprStatement.withExpr(applyMethodExpr)))
        .setReturnExpr(ValueExpr.withValue(ThisObjectValue.withType(builderType)))
        .build();
  }

  private static List<MethodDefinition> createNestedBuilderSettingsGetterMethods(
      Service service, TypeStore typeStore) {
    BiFunction<TypeNode, String, MethodDefinition.Builder> methodMakerFn =
        (retType, methodName) ->
            MethodDefinition.builder()
                .setScope(ScopeNode.PUBLIC)
                .setReturnType(retType)
                .setName(methodName)
                .setReturnExpr(
                    MethodInvocationExpr.builder()
                        .setExprReferenceExpr(
                            MethodInvocationExpr.builder()
                                .setMethodName("getStubSettingsBuilder")
                                .build())
                        .setMethodName(methodName)
                        .setReturnType(retType)
                        .build());
    List<MethodDefinition> javaMethods = new ArrayList<>();
    for (Method protoMethod : service.methods()) {
      String javaStyleName = JavaStyle.toLowerCamelCase(protoMethod.name());
      String javaMethodName = String.format("%sSettings", javaStyleName);
      MethodDefinition.Builder methodBuilder =
          methodMakerFn.apply(getCallSettingsBuilderType(protoMethod, typeStore), javaMethodName);
      javaMethods.add(
          methodBuilder
              .setHeaderCommentStatements(
                  SettingsCommentComposer.createCallSettingsBuilderGetterComment(
                      getMethodNameFromSettingsVarName(javaMethodName),
                      protoMethod.isDeprecated(),
                      protoMethod.isInternalApi()))
              .setAnnotations(createMethodAnnotations(protoMethod))
              .build());

      if (protoMethod.hasLro()) {
        javaMethodName = String.format("%sOperationSettings", javaStyleName);
        methodBuilder =
            methodMakerFn.apply(getOperationCallSettingsBuilderType(protoMethod), javaMethodName);
        javaMethods.add(
            methodBuilder
                .setHeaderCommentStatements(
                    SettingsCommentComposer.createCallSettingsBuilderGetterComment(
                        getMethodNameFromSettingsVarName(javaMethodName),
                        protoMethod.isDeprecated(),
                        protoMethod.isInternalApi()))
                .setAnnotations(createMethodAnnotations(protoMethod))
                .build());
      }
    }
    return javaMethods;
  }

  private static MethodDefinition createNestedBuilderClassBuildMethod(
      Service service, TypeStore typeStore) {
    TypeNode builderType = typeStore.get(BUILDER_CLASS_NAME);
    TypeNode returnType = typeStore.get(ClassNames.getServiceSettingsClassName(service));
    return MethodDefinition.builder()
        .setIsOverride(true)
        .setScope(ScopeNode.PUBLIC)
        .setReturnType(returnType)
        .setName("build")
        .setThrowsExceptions(Arrays.asList(FIXED_TYPESTORE.get("IOException")))
        .setReturnExpr(
            NewObjectExpr.builder()
                .setType(returnType)
                .setArguments(ValueExpr.withValue(ThisObjectValue.withType(builderType)))
                .build())
        .build();
  }

  private static TypeStore createStaticTypes() {
    List<Class<?>> concreteClazzes =
        Arrays.asList(
            ApiClientHeaderProvider.class,
            ApiFunction.class,
            BetaApi.class,
            InternalApi.class,
            ClientContext.class,
            ClientSettings.class,
            Generated.class,
            GoogleCredentialsProvider.class,
            InstantiatingExecutorProvider.class,
            IOException.class,
            Operation.class,
            OperationCallSettings.class,
            PagedCallSettings.class,
            ServerStreamingCallSettings.class,
            StreamingCallSettings.class,
            StubSettings.class,
            TransportChannelProvider.class,
            UnaryCallSettings.class);
    return new TypeStore(concreteClazzes);
  }

  private static TypeStore createDynamicTypes(Service service) {
    TypeStore typeStore = new TypeStore();

    // ServiceStubSettings class.
    typeStore.put(
        String.format("%s.stub", service.pakkage()),
        ClassNames.getServiceStubSettingsClassName(service));

    // This class.
    typeStore.put(service.pakkage(), ClassNames.getServiceSettingsClassName(service));

    // Nested Builder class.
    typeStore.put(
        service.pakkage(),
        BUILDER_CLASS_NAME,
        true,
        ClassNames.getServiceSettingsClassName(service));

    // Pagination types.
    typeStore.putAll(
        service.pakkage(),
        service.methods().stream()
            .filter(m -> m.isPaged())
            .map(m -> String.format(CommonStrings.PAGED_RESPONSE_TYPE_NAME_PATTERN, m.name()))
            .collect(Collectors.toList()),
        true,
        ClassNames.getServiceClientClassName(service));
    return typeStore;
  }

  private static TypeNode getOperationCallSettingsType(Method protoMethod) {
    return getOperationCallSettingsTypeHelper(protoMethod, false);
  }

  private static TypeNode getOperationCallSettingsBuilderType(Method protoMethod) {
    return getOperationCallSettingsTypeHelper(protoMethod, true);
  }

  private static TypeNode getOperationCallSettingsTypeHelper(
      Method protoMethod, boolean isBuilder) {
    Preconditions.checkState(
        protoMethod.hasLro(),
        String.format("Cannot get OperationCallSettings on non-LRO method %s", protoMethod.name()));
    Class<?> callSettingsClazz =
        isBuilder ? OperationCallSettings.Builder.class : OperationCallSettings.class;
    return TypeNode.withReference(
        ConcreteReference.builder()
            .setClazz(callSettingsClazz)
            .setGenerics(
                Arrays.asList(
                    protoMethod.inputType().reference(),
                    protoMethod.lro().responseType().reference(),
                    protoMethod.lro().metadataType().reference()))
            .build());
  }

  private static TypeNode getCallSettingsType(Method protoMethod, TypeStore typeStore) {
    return getCallSettingsTypeHelper(protoMethod, typeStore, false);
  }

  private static TypeNode getCallSettingsBuilderType(Method protoMethod, TypeStore typeStore) {
    return getCallSettingsTypeHelper(protoMethod, typeStore, true);
  }

  private static TypeNode getCallSettingsTypeHelper(
      Method protoMethod, TypeStore typeStore, boolean isBuilder) {
    Class<?> callSettingsClazz =
        isBuilder ? UnaryCallSettings.Builder.class : UnaryCallSettings.class;
    if (protoMethod.isPaged()) {
      callSettingsClazz = isBuilder ? PagedCallSettings.Builder.class : PagedCallSettings.class;
    } else if (protoMethod.isBatching()) {
      callSettingsClazz =
          isBuilder ? BatchingCallSettings.Builder.class : BatchingCallSettings.class;
    } else {
      switch (protoMethod.stream()) {
        case CLIENT:
        // Fall through.
        case BIDI:
          callSettingsClazz =
              isBuilder ? StreamingCallSettings.Builder.class : StreamingCallSettings.class;
          break;
        case SERVER:
          callSettingsClazz =
              isBuilder
                  ? ServerStreamingCallSettings.Builder.class
                  : ServerStreamingCallSettings.class;
          break;
        case NONE:
        // Fall through
        default:
          // Fall through
      }
    }

    List<Reference> generics = new ArrayList<>();
    generics.add(protoMethod.inputType().reference());
    generics.add(protoMethod.outputType().reference());
    if (protoMethod.isPaged()) {
      generics.add(
          typeStore
              .get(
                  String.format(CommonStrings.PAGED_RESPONSE_TYPE_NAME_PATTERN, protoMethod.name()))
              .reference());
    }

    return TypeNode.withReference(
        ConcreteReference.builder().setClazz(callSettingsClazz).setGenerics(generics).build());
  }

  private static TypeNode getStubSettingsBuilderType(Service service) {
    return TypeNode.withReference(
        VaporReference.builder()
            .setPakkage(String.format("%s.stub", service.pakkage()))
            .setName(BUILDER_CLASS_NAME)
            .setEnclosingClassNames(ClassNames.getServiceStubSettingsClassName(service))
            .build());
  }

  /** Turns a name like "waitSettings" or "waitOperationSettings" into "wait". */
  private static String getMethodNameFromSettingsVarName(String settingsVarName) {
    BiFunction<String, String, String> methodNameSubstrFn =
        (s, literal) -> s.substring(0, s.length() - literal.length());
    if (settingsVarName.endsWith(CommonStrings.OPERATION_SETTINGS_LITERAL)) {
      return methodNameSubstrFn.apply(settingsVarName, CommonStrings.OPERATION_SETTINGS_LITERAL);
    }
    if (settingsVarName.endsWith(CommonStrings.SETTINGS_LITERAL)) {
      return methodNameSubstrFn.apply(settingsVarName, CommonStrings.SETTINGS_LITERAL);
    }
    return settingsVarName;
  }
}
