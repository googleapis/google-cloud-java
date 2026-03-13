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

import com.google.api.MonitoredResourceDescriptor;
import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.core.ObsoleteApi;
import com.google.api.gax.batching.BatchingSettings;
import com.google.api.gax.batching.FlowControlSettings;
import com.google.api.gax.batching.FlowController.LimitExceededBehavior;
import com.google.api.gax.batching.PartitionKey;
import com.google.api.gax.batching.RequestBuilder;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.longrunning.OperationTimedPollAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.BatchedRequestIssuer;
import com.google.api.gax.rpc.BatchingCallSettings;
import com.google.api.gax.rpc.BatchingDescriptor;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.LibraryMetadata;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.ServerStreamingCallSettings;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StreamingCallSettings;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.generator.engine.ast.AnnotationNode;
import com.google.api.generator.engine.ast.AnonymousClassExpr;
import com.google.api.generator.engine.ast.AssignmentExpr;
import com.google.api.generator.engine.ast.CastExpr;
import com.google.api.generator.engine.ast.ClassDefinition;
import com.google.api.generator.engine.ast.CommentStatement;
import com.google.api.generator.engine.ast.ConcreteReference;
import com.google.api.generator.engine.ast.EmptyLineStatement;
import com.google.api.generator.engine.ast.Expr;
import com.google.api.generator.engine.ast.ExprStatement;
import com.google.api.generator.engine.ast.IfStatement;
import com.google.api.generator.engine.ast.MethodDefinition;
import com.google.api.generator.engine.ast.MethodInvocationExpr;
import com.google.api.generator.engine.ast.NewObjectExpr;
import com.google.api.generator.engine.ast.PrimitiveValue;
import com.google.api.generator.engine.ast.Reference;
import com.google.api.generator.engine.ast.ReferenceConstructorExpr;
import com.google.api.generator.engine.ast.ReturnExpr;
import com.google.api.generator.engine.ast.ScopeNode;
import com.google.api.generator.engine.ast.Statement;
import com.google.api.generator.engine.ast.StringObjectValue;
import com.google.api.generator.engine.ast.SuperObjectValue;
import com.google.api.generator.engine.ast.ThisObjectValue;
import com.google.api.generator.engine.ast.ThrowExpr;
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
import com.google.api.generator.gapic.model.Field;
import com.google.api.generator.gapic.model.GapicBatchingSettings;
import com.google.api.generator.gapic.model.GapicClass;
import com.google.api.generator.gapic.model.GapicContext;
import com.google.api.generator.gapic.model.GapicServiceConfig;
import com.google.api.generator.gapic.model.Message;
import com.google.api.generator.gapic.model.Method;
import com.google.api.generator.gapic.model.Method.Stream;
import com.google.api.generator.gapic.model.Sample;
import com.google.api.generator.gapic.model.Service;
import com.google.api.generator.gapic.utils.JavaStyle;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Generated;
import javax.annotation.Nullable;

public abstract class AbstractServiceStubSettingsClassComposer implements ClassComposer {
  private static final Statement EMPTY_LINE_STATEMENT = EmptyLineStatement.create();

  private static final String BATCHING_DESC_PATTERN = "%s_BATCHING_DESC";
  private static final String PAGE_STR_DESC_PATTERN = "%s_PAGE_STR_DESC";
  private static final String PAGED_RESPONSE_FACTORY_PATTERN = "%s_PAGE_STR_FACT";
  private static final String NESTED_BUILDER_CLASS_NAME = "Builder";
  private static final String NESTED_UNARY_METHOD_SETTINGS_BUILDERS_VAR_NAME =
      "unaryMethodSettingsBuilders";
  private static final String NESTED_RETRYABLE_CODE_DEFINITIONS_VAR_NAME =
      "RETRYABLE_CODE_DEFINITIONS";
  private static final String NESTED_RETRY_PARAM_DEFINITIONS_VAR_NAME = "RETRY_PARAM_DEFINITIONS";
  private static final String DOT = ".";

  protected static final TypeStore FIXED_TYPESTORE = createStaticTypes();

  private static final VariableExpr NESTED_UNARY_METHOD_SETTINGS_BUILDERS_VAR_EXPR =
      createNestedUnaryMethodSettingsBuildersVarExpr();
  private static final VariableExpr NESTED_RETRYABLE_CODE_DEFINITIONS_VAR_EXPR =
      createNestedRetryableCodeDefinitionsVarExpr();
  private static final VariableExpr NESTED_RETRY_PARAM_DEFINITIONS_VAR_EXPR =
      createNestedRetryParamDefinitionsVarExpr();

  private final TransportContext transportContext;

  // Maps of BigQuery methods to pagination types.
  private static final ImmutableMap<String, TypeNode> BIGQUERY_PAGINATE_MAX_RESULT_TYPES =
      ImmutableMap.of(
          "com.google.cloud.bigquery.v2.ListDatasets",
          TypeNode.UINT32VALUE,
          "com.google.cloud.bigquery.v2.ListJobs",
          TypeNode.INT32VALUE,
          "com.google.cloud.bigquery.v2.ListModels",
          TypeNode.UINT32VALUE,
          "com.google.cloud.bigquery.v2.ListRoutines",
          TypeNode.UINT32VALUE,
          "com.google.cloud.bigquery.v2.ListTables",
          TypeNode.UINT32VALUE);

  protected static final VariableExpr DEFAULT_SERVICE_SCOPES_VAR_EXPR =
      createDefaultServiceScopesVarExpr();

  protected AbstractServiceStubSettingsClassComposer(TransportContext transportContext) {
    this.transportContext = transportContext;
  }

  public TransportContext getTransportContext() {
    return transportContext;
  }

  @Override
  public GapicClass generate(GapicContext context, Service service) {
    // TODO(miraleung): Robustify this against a null serviceConfig.
    GapicServiceConfig serviceConfig = context.serviceConfig();
    Map<String, Message> messageTypes = context.messages();
    String pakkage = String.format("%s.stub", service.pakkage());
    TypeStore typeStore = createDynamicTypes(service, pakkage);

    List<Sample> samples = new ArrayList<>();
    Set<String> deprecatedSettingVarNames = new HashSet<>();
    Set<String> internalSettingVarNames = new HashSet<>();
    Map<String, VariableExpr> methodSettingsMemberVarExprs =
        createMethodSettingsClassMemberVarExprs(
            service,
            serviceConfig,
            typeStore,
            /* isNestedClass= */ false,
            deprecatedSettingVarNames,
            internalSettingVarNames);
    String className = ClassNames.getServiceStubSettingsClassName(service);
    List<CommentStatement> classHeaderComments =
        createClassHeaderComments(service, typeStore.get(className), samples);
    ClassDefinition classDef =
        ClassDefinition.builder()
            .setPackageString(pakkage)
            .setHeaderCommentStatements(classHeaderComments)
            .setAnnotations(createClassAnnotations(service))
            .setScope(ScopeNode.PUBLIC)
            .setName(className)
            .setExtendsType(createExtendsType(service, typeStore))
            .setStatements(
                createClassStatements(
                    service, serviceConfig, methodSettingsMemberVarExprs, messageTypes, typeStore))
            .setMethods(
                createClassMethods(
                    context,
                    service,
                    methodSettingsMemberVarExprs,
                    deprecatedSettingVarNames,
                    internalSettingVarNames,
                    typeStore))
            .setNestedClasses(
                Arrays.asList(createNestedBuilderClass(service, serviceConfig, typeStore)))
            .build();
    return GapicClass.create(
            GapicClass.Kind.STUB, classDef, SampleComposerUtil.handleDuplicateSamples(samples))
        .withApiShortName(service.apiShortName())
        .withPackageVersion(service.packageVersion());
  }

  protected MethodDefinition createDefaultCredentialsProviderBuilderMethod() {
    TypeNode returnType =
        TypeNode.withReference(
            ConcreteReference.withClazz(GoogleCredentialsProvider.Builder.class));
    MethodInvocationExpr credsProviderBuilderExpr =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(FIXED_TYPESTORE.get("GoogleCredentialsProvider"))
            .setMethodName("newBuilder")
            .build();
    credsProviderBuilderExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(credsProviderBuilderExpr)
            .setMethodName("setScopesToApply")
            .setArguments(DEFAULT_SERVICE_SCOPES_VAR_EXPR)
            .setReturnType(returnType)
            .build();
    // enable self signed JWT.
    credsProviderBuilderExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(credsProviderBuilderExpr)
            .setMethodName("setUseJwtAccessWithScope")
            .setArguments(
                ValueExpr.withValue(
                    PrimitiveValue.builder().setType(TypeNode.BOOLEAN).setValue("true").build()))
            .setReturnType(returnType)
            .build();
    return MethodDefinition.builder()
        .setHeaderCommentStatements(
            SettingsCommentComposer.DEFAULT_CREDENTIALS_PROVIDER_BUILDER_METHOD_COMMENT)
        .setScope(ScopeNode.PUBLIC)
        .setIsStatic(true)
        .setReturnType(returnType)
        .setName("defaultCredentialsProviderBuilder")
        .setReturnExpr(credsProviderBuilderExpr)
        .build();
  }

  protected List<MethodDefinition> createDefaultTransportTransportProviderBuilderMethods(
      Service service) {
    // Create the defaultGrpcTransportProviderBuilder method.
    Iterator<Class<?>> providerClassIt =
        getTransportContext().instantiatingChannelProviderClasses().iterator();
    Iterator<Class<?>> providerBuilderClassIt =
        getTransportContext().instantiatingChannelProviderBuilderClasses().iterator();
    Iterator<String> builderNamesIt =
        getTransportContext().defaultTransportProviderBuilderNames().iterator();
    Iterator<String> transportNamesIt = getTransportContext().transportNames().iterator();

    List<MethodDefinition> methods = new ArrayList<>();

    while (providerClassIt.hasNext()
        && providerBuilderClassIt.hasNext()
        && builderNamesIt.hasNext()
        && transportNamesIt.hasNext()) {
      Class<?> providerClass = providerClassIt.next();
      Class<?> providerBuilderClass = providerBuilderClassIt.next();
      String builderName = builderNamesIt.next();
      String transportName = transportNamesIt.next();

      if (!service.hasAnyEnabledMethodsForTransport(transportName)) {
        continue;
      }

      TypeNode returnType =
          TypeNode.withReference(ConcreteReference.withClazz(providerBuilderClass));
      TypeNode channelProviderType =
          TypeNode.withReference(ConcreteReference.withClazz(providerClass));

      MethodInvocationExpr transportChannelProviderBuilderExpr =
          MethodInvocationExpr.builder()
              .setStaticReferenceType(channelProviderType)
              .setMethodName("newBuilder")
              .setReturnType(returnType)
              .build();
      Expr returnExpr =
          initializeTransportProviderBuilder(transportChannelProviderBuilderExpr, returnType);

      List<AnnotationNode> annotations = new ArrayList<>();
      if (!methods.isEmpty()) {
        annotations.add(AnnotationNode.builder().setType(FIXED_TYPESTORE.get("BetaApi")).build());
      }
      CommentStatement commentStatement =
          SettingsCommentComposer.DEFAULT_TRANSPORT_PROVIDER_BUILDER_METHOD_COMMENT;
      if (getTransportContext().transportNames().size() > 1) {
        commentStatement =
            new SettingsCommentComposer(transportName).getTransportProviderBuilderMethodComment();
      }

      MethodDefinition method =
          MethodDefinition.builder()
              .setHeaderCommentStatements(commentStatement)
              .setAnnotations(annotations)
              .setScope(ScopeNode.PUBLIC)
              .setIsStatic(true)
              .setReturnType(returnType)
              .setName(builderName)
              .setReturnExpr(returnExpr)
              .build();

      methods.add(method);
    }

    return methods;
  }

  protected Expr initializeTransportProviderBuilder(
      MethodInvocationExpr transportChannelProviderBuilderExpr, TypeNode returnType) {
    return transportChannelProviderBuilderExpr;
  }

  protected abstract List<MethodDefinition> createApiClientHeaderProviderBuilderMethods(
      Service service, TypeStore typeStore);

  protected MethodDefinition createApiClientHeaderProviderBuilderMethod(
      Service service,
      TypeStore typeStore,
      String methodName,
      TypeNode gaxPropertiesType,
      String getTokenMethodName,
      String getVersionMethodName) {
    TypeNode returnType =
        TypeNode.withReference(ConcreteReference.withClazz(ApiClientHeaderProvider.Builder.class));
    MethodInvocationExpr returnExpr =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(FIXED_TYPESTORE.get("ApiClientHeaderProvider"))
            .setMethodName("newBuilder")
            .build();

    MethodInvocationExpr versionArgExpr =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(FIXED_TYPESTORE.get("GaxProperties"))
            .setMethodName("getLibraryVersion")
            .setArguments(
                VariableExpr.builder()
                    .setVariable(
                        Variable.builder().setType(TypeNode.CLASS_OBJECT).setName("class").build())
                    .setStaticReferenceType(
                        typeStore.get(ClassNames.getServiceStubSettingsClassName(service)))
                    .build())
            .build();

    returnExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(returnExpr)
            .setMethodName("setGeneratedLibToken")
            .setArguments(ValueExpr.withValue(StringObjectValue.withValue("gapic")), versionArgExpr)
            .build();
    returnExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(returnExpr)
            .setMethodName("setTransportToken")
            .setArguments(
                MethodInvocationExpr.builder()
                    .setStaticReferenceType(gaxPropertiesType)
                    .setMethodName(getTokenMethodName)
                    .build(),
                MethodInvocationExpr.builder()
                    .setStaticReferenceType(gaxPropertiesType)
                    .setMethodName(getVersionMethodName)
                    .build())
            .setReturnType(returnType)
            .build();

    if (service.hasApiVersion()) {

      returnExpr =
          MethodInvocationExpr.builder()
              .setExprReferenceExpr(returnExpr)
              .setMethodName("setApiVersionToken")
              .setArguments(ValueExpr.withValue(StringObjectValue.withValue(service.apiVersion())))
              .setReturnType(returnType)
              .build();
    }
    return MethodDefinition.builder()
        .setScope(ScopeNode.PUBLIC)
        .setIsStatic(true)
        .setReturnType(returnType)
        .setName(methodName)
        .setReturnExpr(returnExpr)
        .build();
  }

  public abstract MethodDefinition createDefaultTransportChannelProviderMethod();

  private List<AnnotationNode> createClassAnnotations(Service service) {
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

    // Suppress the error-prone CanonicalDuration warning in generated code.
    annotations.add(
        AnnotationNode.builder()
            .setType(FIXED_TYPESTORE.get("SuppressWarnings"))
            .setDescription("CanonicalDuration")
            .build());
    return annotations;
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
    Optional<String> methodNameOpt = methodOpt.map(Method::name);

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
        ClassNames.getServiceStubClassName(service),
        service.defaultHost(),
        service.isDeprecated(),
        methodNameOpt,
        docSampleCode,
        lroMethodNameOpt,
        lroDocSampleCode,
        classType);
  }

  private TypeNode createExtendsType(Service service, TypeStore typeStore) {
    TypeNode thisClassType = typeStore.get(ClassNames.getServiceStubSettingsClassName(service));
    return TypeNode.withReference(
        FIXED_TYPESTORE
            .get("StubSettings")
            .reference()
            .copyAndSetGenerics(Arrays.asList(thisClassType.reference())));
  }

  private static Map<String, VariableExpr> createMethodSettingsClassMemberVarExprs(
      Service service,
      GapicServiceConfig serviceConfig,
      TypeStore typeStore,
      boolean isNestedClass,
      Set<String> deprecatedSettingVarNames,
      Set<String> internalSettingVarNames) {
    Map<String, VariableExpr> varExprs = new LinkedHashMap<>();

    // Creates class variables <method>Settings, e.g. echoSettings.
    for (Method method : service.methods()) {
      boolean hasBatchingSettings =
          !Objects.isNull(serviceConfig) && serviceConfig.hasBatchingSetting(service, method);
      TypeNode settingsType =
          getCallSettingsType(method, typeStore, hasBatchingSettings, isNestedClass);
      String varName = String.format("%sSettings", JavaStyle.toLowerCamelCase(method.name()));
      if (method.isDeprecated()) {
        deprecatedSettingVarNames.add(varName);
      }
      if (method.isInternalApi()) {
        internalSettingVarNames.add(varName);
      }
      varExprs.put(
          varName,
          VariableExpr.withVariable(
              Variable.builder().setType(settingsType).setName(varName).build()));
      if (method.hasLro()) {
        settingsType = getOperationCallSettingsType(method, isNestedClass);
        varName = JavaStyle.toLowerCamelCase(String.format("%sOperationSettings", method.name()));
        varExprs.put(
            varName,
            VariableExpr.withVariable(
                Variable.builder().setType(settingsType).setName(varName).build()));
      }
    }

    return varExprs;
  }

  private static List<Statement> createClassStatements(
      Service service,
      GapicServiceConfig serviceConfig,
      Map<String, VariableExpr> methodSettingsMemberVarExprs,
      Map<String, Message> messageTypes,
      TypeStore typeStore) {
    // Maintain insertion order.
    Function<Expr, Statement> exprToStatementFn = e -> ExprStatement.withExpr(e);
    List<Statement> statements = new ArrayList<>();

    // Assign DEFAULT_SERVICE_SCOPES.
    statements.add(SettingsCommentComposer.DEFAULT_SCOPES_COMMENT);
    VariableExpr defaultServiceScopesDeclVarExpr =
        DEFAULT_SERVICE_SCOPES_VAR_EXPR.toBuilder()
            .setIsDecl(true)
            .setScope(ScopeNode.PRIVATE)
            .setIsStatic(true)
            .setIsFinal(true)
            .build();
    MethodInvocationExpr listBuilderExpr =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(FIXED_TYPESTORE.get("ImmutableList"))
            .setGenerics(Arrays.asList(ConcreteReference.withClazz(String.class)))
            .setMethodName("builder")
            .build();
    for (String serviceScope : service.oauthScopes()) {

      listBuilderExpr =
          MethodInvocationExpr.builder()
              .setExprReferenceExpr(listBuilderExpr)
              .setMethodName("add")
              .setArguments(ValueExpr.withValue(StringObjectValue.withValue(serviceScope)))
              .build();
    }
    listBuilderExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(listBuilderExpr)
            .setMethodName("build")
            .setReturnType(DEFAULT_SERVICE_SCOPES_VAR_EXPR.type())
            .build();

    statements.add(
        exprToStatementFn.apply(
            AssignmentExpr.builder()
                .setVariableExpr(defaultServiceScopesDeclVarExpr)
                .setValueExpr(listBuilderExpr)
                .build()));

    // Declare settings members.
    statements.addAll(
        methodSettingsMemberVarExprs.values().stream()
            .map(
                v ->
                    exprToStatementFn.apply(
                        v.toBuilder()
                            .setIsDecl(true)
                            .setScope(ScopeNode.PRIVATE)
                            .setIsFinal(true)
                            .build()))
            .collect(Collectors.toList()));
    statements.add(EMPTY_LINE_STATEMENT);

    for (Expr pagingAssignExpr :
        createPagingStaticAssignExprs(service, serviceConfig, messageTypes, typeStore)) {
      statements.add(exprToStatementFn.apply(pagingAssignExpr));
      statements.add(EMPTY_LINE_STATEMENT);
    }

    for (Method method : service.methods()) {
      Optional<GapicBatchingSettings> batchingSettingOpt =
          Objects.isNull(serviceConfig)
              ? Optional.empty()
              : serviceConfig.getBatchingSetting(service, method);
      if (batchingSettingOpt.isPresent()) {
        statements.add(
            exprToStatementFn.apply(
                BatchingDescriptorComposer.createBatchingDescriptorFieldDeclExpr(
                    method, batchingSettingOpt.get(), messageTypes)));
      }
      statements.add(EMPTY_LINE_STATEMENT);
    }

    return statements;
  }

  private static List<Expr> createPagingStaticAssignExprs(
      Service service,
      GapicServiceConfig serviceConfig,
      Map<String, Message> messageTypes,
      TypeStore typeStore) {
    List<Expr> descExprs = new ArrayList<>();
    List<Expr> factoryExprs = new ArrayList<>();
    for (Method method : service.methods()) {
      if (!method.isPaged()) {
        continue;
      }

      // Find the repeated type.
      String pagedResponseMessageKey = method.outputType().reference().fullName();
      if (method.hasLro()) {
        pagedResponseMessageKey = method.lro().responseType().reference().fullName();
      }
      Message pagedResponseMessage = messageTypes.get(pagedResponseMessageKey);
      Preconditions.checkNotNull(
          pagedResponseMessage,
          String.format(
              "No method found for message type %s for method %s among %s",
              pagedResponseMessageKey, method.name(), messageTypes.keySet()));

      Field repeatedPagedResultsField = pagedResponseMessage.findAndUnwrapPaginatedRepeatedField();
      Preconditions.checkNotNull(
          repeatedPagedResultsField,
          String.format(
              "No repeated type found for paged reesponse %s for method %s",
              method.outputType().reference().name(), method.name()));

      TypeNode repeatedResponseType = repeatedPagedResultsField.type();
      String repeatedFieldName = repeatedPagedResultsField.name();

      // Create the PAGE_STR_DESC variable.
      TypeNode pagedListDescType =
          TypeNode.withReference(
              ConcreteReference.builder()
                  .setClazz(PagedListDescriptor.class)
                  .setGenerics(
                      Arrays.asList(method.inputType(), method.outputType(), repeatedResponseType)
                          .stream()
                          .map(t -> t.reference())
                          .collect(Collectors.toList()))
                  .build());
      String pageStrDescVarName =
          String.format(PAGE_STR_DESC_PATTERN, JavaStyle.toUpperSnakeCase(method.name()));
      VariableExpr pagedListDescVarExpr =
          VariableExpr.withVariable(
              Variable.builder().setType(pagedListDescType).setName(pageStrDescVarName).build());

      descExprs.add(
          createPagedListDescriptorAssignExpr(
              pagedListDescVarExpr,
              method,
              repeatedResponseType,
              repeatedFieldName,
              messageTypes,
              typeStore));
      factoryExprs.add(
          createPagedListResponseFactoryAssignExpr(
              pagedListDescVarExpr, method, repeatedResponseType, typeStore));
    }

    descExprs.addAll(factoryExprs);
    return descExprs;
  }

  private static Expr createPagedListDescriptorAssignExpr(
      VariableExpr pagedListDescVarExpr,
      Method method,
      TypeNode repeatedResponseType,
      String repeatedFieldName,
      Map<String, Message> messageTypes,
      TypeStore typeStore) {
    MethodDefinition.Builder methodStarterBuilder =
        MethodDefinition.builder().setIsOverride(true).setScope(ScopeNode.PUBLIC);
    List<MethodDefinition> anonClassMethods = new ArrayList<>();

    // Create emptyToken method.
    anonClassMethods.add(
        methodStarterBuilder
            .setReturnType(TypeNode.STRING)
            .setName("emptyToken")
            .setReturnExpr(ValueExpr.withValue(StringObjectValue.withValue("")))
            .build());

    // Create injectToken method.
    VariableExpr payloadVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setType(method.inputType()).setName("payload").build());
    VariableExpr strTokenVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setType(TypeNode.STRING).setName("token").build());
    TypeNode returnType = method.inputType();
    Expr newBuilderExpr =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(method.inputType())
            .setMethodName("newBuilder")
            .setArguments(payloadVarExpr)
            .build();
    Expr returnExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(newBuilderExpr)
            .setMethodName("setPageToken")
            .setArguments(strTokenVarExpr)
            .build();
    returnExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(returnExpr)
            .setMethodName("build")
            .setReturnType(returnType)
            .build();
    anonClassMethods.add(
        methodStarterBuilder
            .setReturnType(method.inputType())
            .setName("injectToken")
            .setArguments(
                Arrays.asList(payloadVarExpr, strTokenVarExpr).stream()
                    .map(v -> v.toBuilder().setIsDecl(true).build())
                    .collect(Collectors.toList()))
            .setReturnExpr(returnExpr)
            .build());

    // Create injectPageSize method.
    String methodFullName =
        String.format("%s.%s", method.inputType().reference().pakkage(), method.name());
    VariableExpr pageSizeVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setType(TypeNode.INT).setName("pageSize").build());

    // Re-declare for clarity and easier readability.
    returnType = method.inputType();
    returnExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(newBuilderExpr)
            .setMethodName("set" + JavaStyle.toUpperCamelCase(method.pageSizeFieldName()))
            .setArguments(pageSizeVarExpr)
            .build();
    if (BIGQUERY_PAGINATE_MAX_RESULT_TYPES.containsKey(methodFullName)) {
      returnExpr =
          MethodInvocationExpr.builder()
              .setExprReferenceExpr(newBuilderExpr)
              .setMethodName("set" + JavaStyle.toUpperCamelCase(method.pageSizeFieldName()))
              .setArguments(
                  MethodInvocationExpr.builder()
                      .setStaticReferenceType(
                          BIGQUERY_PAGINATE_MAX_RESULT_TYPES.get(methodFullName))
                      .setMethodName("of")
                      .setArguments(pageSizeVarExpr)
                      .build())
              .build();
    }
    returnExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(returnExpr)
            .setMethodName("build")
            .setReturnType(returnType)
            .build();
    anonClassMethods.add(
        methodStarterBuilder
            .setReturnType(method.inputType())
            .setName("injectPageSize")
            .setArguments(
                Arrays.asList(payloadVarExpr, pageSizeVarExpr).stream()
                    .map(v -> v.toBuilder().setIsDecl(true).build())
                    .collect(Collectors.toList()))
            .setReturnExpr(returnExpr)
            .build());

    // TODO(miraleung): Test the edge cases where these proto fields aren't present.
    // Create extractPageSize method.
    returnType = TypeNode.INT_OBJECT;
    returnExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(payloadVarExpr)
            .setMethodName("get" + JavaStyle.toUpperCamelCase(method.pageSizeFieldName()))
            .setReturnType(returnType)
            .build();
    if (BIGQUERY_PAGINATE_MAX_RESULT_TYPES.containsKey(methodFullName)) {
      // Return type is UINT32VALUE or INT32VALUE so use getValue to unwrap.
      returnExpr =
          MethodInvocationExpr.builder()
              .setExprReferenceExpr(payloadVarExpr)
              .setMethodName("get" + JavaStyle.toUpperCamelCase(method.pageSizeFieldName()))
              .build();
      returnExpr =
          MethodInvocationExpr.builder()
              .setExprReferenceExpr(returnExpr)
              .setMethodName("getValue")
              .setReturnType(returnType)
              .build();
    }
    anonClassMethods.add(
        methodStarterBuilder
            .setReturnType(returnType)
            .setName("extractPageSize")
            .setArguments(payloadVarExpr.toBuilder().setIsDecl(true).build())
            .setReturnExpr(returnExpr)
            .build());

    // Create extractNextToken method.
    returnType = TypeNode.STRING;
    payloadVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setType(method.outputType()).setName("payload").build());
    anonClassMethods.add(
        methodStarterBuilder
            .setReturnType(returnType)
            .setName("extractNextToken")
            .setArguments(payloadVarExpr.toBuilder().setIsDecl(true).build())
            .setReturnExpr(
                MethodInvocationExpr.builder()
                    .setExprReferenceExpr(payloadVarExpr)
                    .setMethodName("getNextPageToken")
                    .setReturnType(returnType)
                    .build())
            .build());

    // Create extractResources method.
    returnType =
        TypeNode.withReference(
            ConcreteReference.builder()
                .setClazz(Iterable.class)
                .setGenerics(Arrays.asList(repeatedResponseType.reference()))
                .build());

    if (repeatedResponseType.reference() != null
        && "java.util.Map.Entry".equals(repeatedResponseType.reference().fullName())) {
      returnExpr =
          MethodInvocationExpr.builder()
              .setMethodName("entrySet")
              .setExprReferenceExpr(
                  MethodInvocationExpr.builder()
                      .setExprReferenceExpr(payloadVarExpr)
                      .setMethodName(
                          String.format("get%sMap", JavaStyle.toUpperCamelCase(repeatedFieldName)))
                      .build())
              .setReturnType(returnType)
              .build();
    } else {
      returnExpr =
          MethodInvocationExpr.builder()
              .setExprReferenceExpr(payloadVarExpr)
              .setMethodName(
                  String.format("get%sList", JavaStyle.toUpperCamelCase(repeatedFieldName)))
              .setReturnType(returnType)
              .build();
    }
    anonClassMethods.add(
        methodStarterBuilder
            .setReturnType(returnType)
            .setName("extractResources")
            .setArguments(payloadVarExpr.toBuilder().setIsDecl(true).build())
            .setReturnExpr(returnExpr)
            .build());

    // Create the anonymous class.
    AnonymousClassExpr pagedListDescAnonClassExpr =
        AnonymousClassExpr.builder()
            .setType(pagedListDescVarExpr.type())
            .setMethods(anonClassMethods)
            .build();

    // Declare and assign the variable.
    return AssignmentExpr.builder()
        .setVariableExpr(
            pagedListDescVarExpr.toBuilder()
                .setIsDecl(true)
                .setScope(ScopeNode.PRIVATE)
                .setIsStatic(true)
                .setIsFinal(true)
                .build())
        .setValueExpr(pagedListDescAnonClassExpr)
        .build();
  }

  private static Expr createPagedListResponseFactoryAssignExpr(
      VariableExpr pageStrDescVarExpr,
      Method method,
      TypeNode repeatedResponseType,
      TypeStore typeStore) {
    Preconditions.checkState(
        method.isPaged(), String.format("Method %s is not paged", method.name()));

    // Create the PagedListResponseFactory.
    TypeNode pagedResponseType = typeStore.get(getPagedResponseTypeName(method.name()));
    TypeNode apiFutureType =
        TypeNode.withReference(
            ConcreteReference.builder()
                .setClazz(ApiFuture.class)
                .setGenerics(Arrays.asList(pagedResponseType.reference()))
                .build());

    VariableExpr callableVarExpr =
        VariableExpr.withVariable(
            Variable.builder()
                .setType(
                    TypeNode.withReference(
                        ConcreteReference.builder()
                            .setClazz(UnaryCallable.class)
                            .setGenerics(
                                Arrays.asList(
                                    method.inputType().reference(),
                                    method.outputType().reference()))
                            .build()))
                .setName("callable")
                .build());
    VariableExpr requestVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setType(method.inputType()).setName("request").build());
    VariableExpr contextVarExpr =
        VariableExpr.withVariable(
            Variable.builder()
                .setType(FIXED_TYPESTORE.get("ApiCallContext"))
                .setName("context")
                .build());
    VariableExpr futureResponseVarExpr =
        VariableExpr.withVariable(
            Variable.builder()
                .setType(
                    TypeNode.withReference(
                        ConcreteReference.builder()
                            .setClazz(ApiFuture.class)
                            .setGenerics(Arrays.asList(method.outputType().reference()))
                            .build()))
                .setName("futureResponse")
                .build());

    TypeNode pageContextType =
        TypeNode.withReference(
            ConcreteReference.builder()
                .setClazz(PageContext.class)
                .setGenerics(
                    Arrays.asList(method.inputType(), method.outputType(), repeatedResponseType)
                        .stream()
                        .map(t -> t.reference())
                        .collect(Collectors.toList()))
                .build());
    VariableExpr pageContextVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setType(pageContextType).setName("pageContext").build());
    AssignmentExpr pageContextAssignExpr =
        AssignmentExpr.builder()
            .setVariableExpr(pageContextVarExpr.toBuilder().setIsDecl(true).build())
            .setValueExpr(
                MethodInvocationExpr.builder()
                    .setStaticReferenceType(FIXED_TYPESTORE.get("PageContext"))
                    .setMethodName("create")
                    .setArguments(
                        callableVarExpr, pageStrDescVarExpr, requestVarExpr, contextVarExpr)
                    .setReturnType(pageContextVarExpr.type())
                    .build())
            .build();

    Expr returnExpr =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(typeStore.get(getPagedResponseTypeName(method.name())))
            .setMethodName("createAsync")
            .setArguments(pageContextVarExpr, futureResponseVarExpr)
            .setReturnType(apiFutureType)
            .build();

    MethodDefinition getFuturePagedResponseMethod =
        MethodDefinition.builder()
            .setIsOverride(true)
            .setScope(ScopeNode.PUBLIC)
            .setReturnType(apiFutureType)
            .setName("getFuturePagedResponse")
            .setArguments(
                Arrays.asList(
                        callableVarExpr, requestVarExpr, contextVarExpr, futureResponseVarExpr)
                    .stream()
                    .map(v -> v.toBuilder().setIsDecl(true).build())
                    .collect(Collectors.toList()))
            .setBody(Arrays.asList(ExprStatement.withExpr(pageContextAssignExpr)))
            .setReturnExpr(returnExpr)
            .build();

    // Create the variable.
    TypeNode pagedResponseFactoryType =
        TypeNode.withReference(
            ConcreteReference.builder()
                .setClazz(PagedListResponseFactory.class)
                .setGenerics(
                    Arrays.asList(
                            method.inputType(),
                            method.outputType(),
                            typeStore.get(getPagedResponseTypeName(method.name())))
                        .stream()
                        .map(t -> t.reference())
                        .collect(Collectors.toList()))
                .build());
    String varName =
        String.format(PAGED_RESPONSE_FACTORY_PATTERN, JavaStyle.toUpperSnakeCase(method.name()));
    VariableExpr pagedListResponseFactoryVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setType(pagedResponseFactoryType).setName(varName).build());
    AnonymousClassExpr factoryAnonClassExpr =
        AnonymousClassExpr.builder()
            .setType(pagedResponseFactoryType)
            .setMethods(Arrays.asList(getFuturePagedResponseMethod))
            .build();

    return AssignmentExpr.builder()
        .setVariableExpr(
            pagedListResponseFactoryVarExpr.toBuilder()
                .setIsDecl(true)
                .setScope(ScopeNode.PRIVATE)
                .setIsStatic(true)
                .setIsFinal(true)
                .build())
        .setValueExpr(factoryAnonClassExpr)
        .build();
  }

  private List<MethodDefinition> createClassMethods(
      GapicContext context,
      Service service,
      Map<String, VariableExpr> methodSettingsMemberVarExprs,
      Set<String> deprecatedSettingVarNames,
      Set<String> internalSettingVarNames,
      TypeStore typeStore) {
    List<MethodDefinition> javaMethods = new ArrayList<>();
    javaMethods.addAll(
        createMethodSettingsGetterMethods(
            methodSettingsMemberVarExprs, deprecatedSettingVarNames, internalSettingVarNames));
    javaMethods.add(createCreateStubMethod(service, typeStore));
    javaMethods.addAll(createDefaultHelperAndGetterMethods(service, typeStore));
    javaMethods.addAll(
        createNewBuilderMethods(
            service,
            typeStore,
            "newBuilder",
            "createDefault",
            SettingsCommentComposer.NEW_BUILDER_METHOD_COMMENT));
    javaMethods.addAll(createBuilderHelperMethods(service, typeStore));
    javaMethods.add(createClassConstructor(service, methodSettingsMemberVarExprs, typeStore));
    javaMethods.add(createGetLibraryMetadataMethod(context));
    return javaMethods;
  }

  private static List<AnnotationNode> createMethodAnnotation(
      boolean isDeprecated, boolean isInternal) {
    List<AnnotationNode> annotations = new ArrayList<>();
    if (isDeprecated) {
      annotations.add(AnnotationNode.withType(TypeNode.DEPRECATED));
    }
    if (isInternal) {
      annotations.add(
          AnnotationNode.withTypeAndDescription(
              FIXED_TYPESTORE.get("InternalApi"), CommonStrings.INTERNAL_API_WARNING));
    }
    return annotations;
  }

  private static List<MethodDefinition> createMethodSettingsGetterMethods(
      Map<String, VariableExpr> methodSettingsMemberVarExprs,
      final Set<String> deprecatedSettingVarNames,
      final Set<String> internalSettingVarNames) {
    Function<Map.Entry<String, VariableExpr>, MethodDefinition> varToMethodFn =
        e -> {
          boolean isDeprecated = deprecatedSettingVarNames.contains(e.getKey());
          boolean isInternal = internalSettingVarNames.contains(e.getKey());
          return MethodDefinition.builder()
              .setHeaderCommentStatements(
                  SettingsCommentComposer.createCallSettingsGetterComment(
                      getMethodNameFromSettingsVarName(e.getKey()), isDeprecated, isInternal))
              .setAnnotations(createMethodAnnotation(isDeprecated, isInternal))
              .setScope(ScopeNode.PUBLIC)
              .setReturnType(e.getValue().type())
              .setName(e.getKey())
              .setReturnExpr(e.getValue())
              .build();
        };
    return methodSettingsMemberVarExprs.entrySet().stream()
        .map(e -> varToMethodFn.apply(e))
        .collect(Collectors.toList());
  }

  private MethodDefinition createCreateStubMethod(Service service, TypeStore typeStore) {
    // Set up the if-statement.
    List<Statement> bodyStatements = new ArrayList<>();

    Expr getTransportNameExpr =
        MethodInvocationExpr.builder().setMethodName("getTransportChannelProvider").build();
    getTransportNameExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(getTransportNameExpr)
            .setMethodName("getTransportName")
            .build();

    Iterator<String> transportNamesIt = getTransportContext().transportNames().iterator();
    Iterator<TypeNode> channelTypesIt = getTransportContext().transportChannelTypes().iterator();
    Iterator<String> getterNameIt = getTransportContext().transportGetterNames().iterator();
    Iterator<String> serivceStubClassNameIt =
        getTransportContext().classNames().getTransportServiceStubClassNames(service).iterator();

    while (channelTypesIt.hasNext() && getterNameIt.hasNext()) {
      String transportName = transportNamesIt.next();
      TypeNode channelType = channelTypesIt.next();
      String getterName = getterNameIt.next();
      String serivceStubClassName = serivceStubClassNameIt.next();

      if (!service.hasAnyEnabledMethodsForTransport(transportName)) {
        continue;
      }

      Expr transportNameExpr =
          MethodInvocationExpr.builder()
              .setStaticReferenceType(channelType)
              .setMethodName(getterName)
              .build();

      Expr ifConditionExpr =
          MethodInvocationExpr.builder()
              .setExprReferenceExpr(getTransportNameExpr)
              .setMethodName("equals")
              .setArguments(transportNameExpr)
              .setReturnType(TypeNode.BOOLEAN)
              .build();

      Expr createExpr =
          MethodInvocationExpr.builder()
              .setStaticReferenceType(typeStore.get(serivceStubClassName))
              .setMethodName("create")
              .setArguments(
                  ValueExpr.withValue(
                      ThisObjectValue.withType(
                          typeStore.get(ClassNames.getServiceStubSettingsClassName(service)))))
              .build();

      IfStatement ifStatement =
          IfStatement.builder()
              .setConditionExpr(ifConditionExpr)
              .setBody(Arrays.asList(ExprStatement.withExpr(ReturnExpr.withExpr(createExpr))))
              .build();

      bodyStatements.add(ifStatement);
    }

    // Set up exception throwing.
    Expr errorMessageExpr =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(TypeNode.STRING)
            .setMethodName("format")
            .setArguments(
                ValueExpr.withValue(StringObjectValue.withValue("Transport not supported: %s")),
                getTransportNameExpr)
            .setReturnType(TypeNode.STRING)
            .build();
    TypeNode exceptionType = TypeNode.withExceptionClazz(UnsupportedOperationException.class);
    Statement throwStatement =
        ExprStatement.withExpr(
            ThrowExpr.builder().setType(exceptionType).setMessageExpr(errorMessageExpr).build());

    bodyStatements.add(throwStatement);

    // Put the method together.
    TypeNode returnType = typeStore.get(ClassNames.getServiceStubClassName(service));

    return MethodDefinition.builder()
        .setScope(ScopeNode.PUBLIC)
        .setReturnType(returnType)
        .setName("createStub")
        .setThrowsExceptions(Arrays.asList(TypeNode.withExceptionClazz(IOException.class)))
        .setBody(bodyStatements)
        .build();
  }

  private List<MethodDefinition> createDefaultHelperAndGetterMethods(
      Service service, TypeStore typeStore) {
    List<MethodDefinition> javaMethods = new ArrayList<>();
    TypeNode returnType;

    // Create the getServiceName method.
    if (!Strings.isNullOrEmpty(service.hostServiceName())) {
      returnType = TypeNode.STRING;
      javaMethods.add(
          MethodDefinition.builder()
              .setHeaderCommentStatements(
                  SettingsCommentComposer.DEFAULT_SERVICE_NAME_METHOD_COMMENT)
              .setIsOverride(true)
              .setScope(ScopeNode.PUBLIC)
              .setIsStatic(false)
              .setReturnType(returnType)
              .setName("getServiceName")
              .setReturnExpr(
                  ValueExpr.withValue(StringObjectValue.withValue(service.hostServiceName())))
              .build());
    }

    // Create the defaultExecutorProviderBuilder method.
    returnType =
        TypeNode.withReference(
            ConcreteReference.withClazz(InstantiatingExecutorProvider.Builder.class));
    javaMethods.add(
        MethodDefinition.builder()
            .setHeaderCommentStatements(
                SettingsCommentComposer.DEFAULT_EXECUTOR_PROVIDER_BUILDER_METHOD_COMMENT)
            .setScope(ScopeNode.PUBLIC)
            .setIsStatic(true)
            .setReturnType(returnType)
            .setName("defaultExecutorProviderBuilder")
            .setReturnExpr(
                MethodInvocationExpr.builder()
                    .setStaticReferenceType(FIXED_TYPESTORE.get("InstantiatingExecutorProvider"))
                    .setMethodName("newBuilder")
                    .setReturnType(returnType)
                    .build())
            .build());

    // Create the getDefaultEndpoint method.
    returnType = TypeNode.STRING;
    javaMethods.add(
        MethodDefinition.builder()
            .setHeaderCommentStatements(
                SettingsCommentComposer.DEFAULT_SERVICE_ENDPOINT_METHOD_COMMENT)
            .setScope(ScopeNode.PUBLIC)
            .setIsStatic(true)
            .setReturnType(returnType)
            .setName("getDefaultEndpoint")
            .setReturnExpr(ValueExpr.withValue(StringObjectValue.withValue(service.defaultHost())))
            .setAnnotations(
                ImmutableList.of(
                    AnnotationNode.builder()
                        .setType(FIXED_TYPESTORE.get(ObsoleteApi.class.getSimpleName()))
                        .setDescription("Use getEndpoint() instead")
                        .build()))
            .build());

    // Create the getDefaultMtlsEndpoint method.
    returnType = TypeNode.STRING;
    javaMethods.add(
        MethodDefinition.builder()
            .setHeaderCommentStatements(
                SettingsCommentComposer.DEFAULT_SERVICE_MTLS_ENDPOINT_METHOD_COMMENT)
            .setScope(ScopeNode.PUBLIC)
            .setIsStatic(true)
            .setReturnType(returnType)
            .setName("getDefaultMtlsEndpoint")
            .setReturnExpr(
                ValueExpr.withValue(
                    StringObjectValue.withValue(
                        service.defaultHost().replace(".googleapis.com", ".mtls.googleapis.com"))))
            .build());

    // Create the getDefaultServiceScopes method.
    returnType =
        TypeNode.withReference(
            ConcreteReference.builder()
                .setClazz(List.class)
                .setGenerics(Arrays.asList(TypeNode.STRING.reference()))
                .build());
    javaMethods.add(
        MethodDefinition.builder()
            .setHeaderCommentStatements(
                SettingsCommentComposer.DEFAULT_SERVICE_SCOPES_METHOD_COMMENT)
            .setScope(ScopeNode.PUBLIC)
            .setIsStatic(true)
            .setReturnType(returnType)
            .setName("getDefaultServiceScopes")
            .setReturnExpr(DEFAULT_SERVICE_SCOPES_VAR_EXPR)
            .build());

    javaMethods.add(createDefaultCredentialsProviderBuilderMethod());
    javaMethods.addAll(createDefaultTransportTransportProviderBuilderMethods(service));
    javaMethods.add(createDefaultTransportChannelProviderMethod());
    javaMethods.addAll(createApiClientHeaderProviderBuilderMethods(service, typeStore));

    return javaMethods;
  }

  protected List<MethodDefinition> createNewBuilderMethods(
      Service service,
      TypeStore typeStore,
      String newBuilderMethodName,
      String createDefaultMethodName,
      CommentStatement methodComment) {
    // Create the newBuilder() method.
    final TypeNode builderReturnType = typeStore.get(NESTED_BUILDER_CLASS_NAME);
    return ImmutableList.of(
        MethodDefinition.builder()
            .setHeaderCommentStatements(methodComment)
            .setScope(ScopeNode.PUBLIC)
            .setIsStatic(true)
            .setReturnType(builderReturnType)
            .setName(newBuilderMethodName)
            .setReturnExpr(
                MethodInvocationExpr.builder()
                    .setStaticReferenceType(builderReturnType)
                    .setMethodName(createDefaultMethodName)
                    .setReturnType(builderReturnType)
                    .build())
            .build());
  }

  protected List<MethodDefinition> createBuilderHelperMethods(
      Service service, TypeStore typeStore) {
    List<MethodDefinition> javaMethods = new ArrayList<>();
    final TypeNode builderReturnType = typeStore.get(NESTED_BUILDER_CLASS_NAME);
    // Create the newBuilder(ClientContext) method.
    Function<Expr, NewObjectExpr> newBuilderFn =
        argExpr -> NewObjectExpr.builder().setType(builderReturnType).setArguments(argExpr).build();
    VariableExpr clientContextVarExpr =
        VariableExpr.withVariable(
            Variable.builder()
                .setType(FIXED_TYPESTORE.get("ClientContext"))
                .setName("clientContext")
                .build());
    javaMethods.add(
        MethodDefinition.builder()
            .setHeaderCommentStatements(SettingsCommentComposer.NEW_BUILDER_METHOD_COMMENT)
            .setScope(ScopeNode.PUBLIC)
            .setIsStatic(true)
            .setReturnType(builderReturnType)
            .setName("newBuilder")
            .setArguments(clientContextVarExpr.toBuilder().setIsDecl(true).build())
            .setReturnExpr(newBuilderFn.apply(clientContextVarExpr))
            .build());

    // Create the toBuilder method.
    javaMethods.add(
        MethodDefinition.builder()
            .setHeaderCommentStatements(SettingsCommentComposer.TO_BUILDER_METHOD_COMMENT)
            .setScope(ScopeNode.PUBLIC)
            .setReturnType(builderReturnType)
            .setName("toBuilder")
            .setReturnExpr(
                newBuilderFn.apply(
                    ValueExpr.withValue(
                        ThisObjectValue.withType(
                            typeStore.get(ClassNames.getServiceStubClassName(service))))))
            .build());

    return javaMethods;
  }

  private static MethodDefinition createClassConstructor(
      Service service,
      Map<String, VariableExpr> methodSettingsMemberVarExprs,
      TypeStore typeStore) {
    TypeNode thisType = typeStore.get(ClassNames.getServiceStubSettingsClassName(service));
    final VariableExpr settingsBuilderVarExpr =
        VariableExpr.withVariable(
            Variable.builder()
                .setType(typeStore.get(NESTED_BUILDER_CLASS_NAME))
                .setName("settingsBuilder")
                .build());

    Expr superCtorExpr =
        ReferenceConstructorExpr.superBuilder()
            .setType(FIXED_TYPESTORE.get("StubSettings"))
            .setArguments(settingsBuilderVarExpr)
            .build();

    List<Statement> bodyStatements = new ArrayList<>();
    bodyStatements.add(ExprStatement.withExpr(superCtorExpr));
    bodyStatements.add(EMPTY_LINE_STATEMENT);

    Function<Map.Entry<String, VariableExpr>, AssignmentExpr> varInitExprFn =
        e ->
            AssignmentExpr.builder()
                .setVariableExpr(e.getValue())
                .setValueExpr(
                    MethodInvocationExpr.builder()
                        .setExprReferenceExpr(
                            MethodInvocationExpr.builder()
                                .setExprReferenceExpr(settingsBuilderVarExpr)
                                .setMethodName(e.getKey())
                                .build())
                        .setMethodName("build")
                        .setReturnType(e.getValue().type())
                        .build())
                .build();
    bodyStatements.addAll(
        methodSettingsMemberVarExprs.entrySet().stream()
            .map(e -> ExprStatement.withExpr(varInitExprFn.apply(e)))
            .collect(Collectors.toList()));

    return MethodDefinition.constructorBuilder()
        .setScope(ScopeNode.PROTECTED)
        .setReturnType(thisType)
        .setArguments(settingsBuilderVarExpr.toBuilder().setIsDecl(true).build())
        .setThrowsExceptions(Arrays.asList(TypeNode.withExceptionClazz(IOException.class)))
        .setBody(bodyStatements)
        .build();
  }

  private ClassDefinition createNestedBuilderClass(
      Service service, @Nullable GapicServiceConfig serviceConfig, TypeStore typeStore) {
    // TODO(miraleung): Robustify this against a null serviceConfig.
    String thisClassName = ClassNames.getServiceStubSettingsClassName(service);

    String className = "Builder";

    TypeNode extendsType =
        TypeNode.withReference(
            ConcreteReference.builder()
                .setClazz(StubSettings.Builder.class)
                .setGenerics(
                    Arrays.asList(typeStore.get(thisClassName), typeStore.get(className)).stream()
                        .map(t -> t.reference())
                        .collect(Collectors.toList()))
                .build());

    Set<String> nestedDeprecatedSettingVarNames = new HashSet<>();
    Set<String> nestedInternalSettingVarNames = new HashSet<>();
    Map<String, VariableExpr> nestedMethodSettingsMemberVarExprs =
        createMethodSettingsClassMemberVarExprs(
            service,
            serviceConfig,
            typeStore,
            /* isNestedClass= */ true,
            nestedDeprecatedSettingVarNames,
            nestedInternalSettingVarNames);

    // TODO(miraleung): Fill this out.
    return ClassDefinition.builder()
        .setIsNested(true)
        .setHeaderCommentStatements(
            SettingsCommentComposer.createBuilderClassComment(
                ClassNames.getServiceStubSettingsClassName(service)))
        .setScope(ScopeNode.PUBLIC)
        .setIsStatic(true)
        .setName(className)
        .setExtendsType(extendsType)
        .setStatements(
            createNestedClassStatements(service, serviceConfig, nestedMethodSettingsMemberVarExprs))
        .setMethods(
            createNestedClassMethods(
                service,
                serviceConfig,
                extendsType,
                nestedMethodSettingsMemberVarExprs,
                nestedDeprecatedSettingVarNames,
                nestedInternalSettingVarNames,
                typeStore))
        .build();
  }

  private static List<Statement> createNestedClassStatements(
      Service service,
      GapicServiceConfig serviceConfig,
      Map<String, VariableExpr> nestedMethodSettingsMemberVarExprs) {
    List<Expr> exprs = new ArrayList<>();

    // Declare unaryMethodSettingsBuilders.
    Function<VariableExpr, VariableExpr> varDeclFn =
        v -> v.toBuilder().setIsDecl(true).setScope(ScopeNode.PRIVATE).setIsFinal(true).build();
    exprs.add(varDeclFn.apply(NESTED_UNARY_METHOD_SETTINGS_BUILDERS_VAR_EXPR));

    // Declare all the settings fields.
    exprs.addAll(
        nestedMethodSettingsMemberVarExprs.values().stream()
            .map(v -> varDeclFn.apply(v))
            .collect(Collectors.toList()));

    // Declare the RETRYABLE_CODE_DEFINITIONS field.
    Function<VariableExpr, VariableExpr> varStaticDeclFn =
        v ->
            v.toBuilder()
                .setIsDecl(true)
                .setScope(ScopeNode.PRIVATE)
                .setIsStatic(true)
                .setIsFinal(true)
                .build();
    Function<Expr, Statement> exprStatementFn = e -> ExprStatement.withExpr(e);

    List<Statement> statements = new ArrayList<>();
    statements.addAll(
        exprs.stream().map(e -> exprStatementFn.apply(e)).collect(Collectors.toList()));

    // Declare and set the RETRYABLE_CODE_DEFINITIONS field.
    statements.add(
        exprStatementFn.apply((varStaticDeclFn.apply(NESTED_RETRYABLE_CODE_DEFINITIONS_VAR_EXPR))));
    statements.add(
        RetrySettingsComposer.createRetryCodesDefinitionsBlock(
            service, serviceConfig, NESTED_RETRYABLE_CODE_DEFINITIONS_VAR_EXPR));

    // Declare the RETRY_PARAM_DEFINITIONS field.
    statements.add(
        exprStatementFn.apply(varStaticDeclFn.apply(NESTED_RETRY_PARAM_DEFINITIONS_VAR_EXPR)));

    statements.add(
        RetrySettingsComposer.createRetryParamDefinitionsBlock(
            service, serviceConfig, NESTED_RETRY_PARAM_DEFINITIONS_VAR_EXPR));

    return statements;
  }

  private List<MethodDefinition> createNestedClassMethods(
      Service service,
      GapicServiceConfig serviceConfig,
      TypeNode superType,
      Map<String, VariableExpr> nestedMethodSettingsMemberVarExprs,
      Set<String> nestedDeprecatedSettingVarNames,
      Set<String> nestedInternalSettingVarNames,
      TypeStore typeStore) {
    List<MethodDefinition> nestedClassMethods = new ArrayList<>();
    nestedClassMethods.addAll(
        createNestedClassConstructorMethods(
            service, serviceConfig, nestedMethodSettingsMemberVarExprs, typeStore));
    nestedClassMethods.addAll(createNestedClassCreateDefaultMethods(service, typeStore));
    nestedClassMethods.add(createNestedClassInitDefaultsMethod(service, serviceConfig, typeStore));
    nestedClassMethods.add(createNestedClassApplyToAllUnaryMethodsMethod(superType, typeStore));
    nestedClassMethods.add(createNestedClassUnaryMethodSettingsBuilderGetterMethod());
    nestedClassMethods.addAll(
        createNestedClassSettingsBuilderGetterMethods(
            nestedMethodSettingsMemberVarExprs,
            nestedDeprecatedSettingVarNames,
            nestedInternalSettingVarNames));
    nestedClassMethods.add(createNestedClassBuildMethod(service, typeStore));
    return nestedClassMethods;
  }

  private MethodDefinition createNestedClassInitDefaultsMethod(
      Service service, @Nullable GapicServiceConfig serviceConfig, TypeStore typeStore) {
    // TODO(miraleung): Robustify this against a null serviceConfig.
    TypeNode builderType = typeStore.get(NESTED_BUILDER_CLASS_NAME);
    VariableExpr builderVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setType(builderType).setName("builder").build());

    List<Statement> bodyStatements = new ArrayList<>();
    // Iterate through methods twice to so we can have LRO expressions appear last.
    for (Method method : service.methods()) {
      Method.Stream streamKind = method.stream();
      if (streamKind.equals(Method.Stream.CLIENT) || streamKind.equals(Method.Stream.BIDI)) {
        continue;
      }
      if (!Objects.isNull(serviceConfig) && serviceConfig.hasBatchingSetting(service, method)) {
        Optional<GapicBatchingSettings> batchingSettingOpt =
            serviceConfig.getBatchingSetting(service, method);
        Preconditions.checkState(
            batchingSettingOpt.isPresent(),
            String.format(
                "No batching setting found for service %s, method %s",
                service.name(), method.name()));
        String settingsGetterMethodName =
            String.format("%sSettings", JavaStyle.toLowerCamelCase(method.name()));
        bodyStatements.add(
            ExprStatement.withExpr(
                RetrySettingsComposer.createBatchingBuilderSettingsExpr(
                    settingsGetterMethodName, batchingSettingOpt.get(), builderVarExpr)));
        bodyStatements.add(EMPTY_LINE_STATEMENT);
      }

      bodyStatements.add(
          ExprStatement.withExpr(
              RetrySettingsComposer.createSimpleBuilderSettingsExpr(
                  service,
                  serviceConfig,
                  method,
                  builderVarExpr,
                  NESTED_RETRYABLE_CODE_DEFINITIONS_VAR_EXPR,
                  NESTED_RETRY_PARAM_DEFINITIONS_VAR_EXPR)));
      bodyStatements.add(EMPTY_LINE_STATEMENT);
    }
    for (Method method : service.methods()) {
      if (!method.hasLro()) {
        continue;
      }
      bodyStatements.add(
          ExprStatement.withExpr(
              RetrySettingsComposer.createLroSettingsBuilderExpr(
                  service,
                  serviceConfig,
                  method,
                  builderVarExpr,
                  NESTED_RETRYABLE_CODE_DEFINITIONS_VAR_EXPR,
                  NESTED_RETRY_PARAM_DEFINITIONS_VAR_EXPR,
                  getTransportContext().operationResponseTransformerType(),
                  getTransportContext().operationMetadataTransformerType())));
      bodyStatements.add(EMPTY_LINE_STATEMENT);
    }

    return MethodDefinition.builder()
        .setScope(ScopeNode.PRIVATE)
        .setIsStatic(true)
        .setReturnType(builderType)
        .setName("initDefaults")
        .setArguments(builderVarExpr.toBuilder().setIsDecl(true).build())
        .setBody(bodyStatements)
        .setReturnExpr(builderVarExpr)
        .build();
  }

  private static List<MethodDefinition> createNestedClassConstructorMethods(
      Service service,
      GapicServiceConfig serviceConfig,
      Map<String, VariableExpr> nestedMethodSettingsMemberVarExprs,
      TypeStore typeStore) {
    TypeNode builderType = typeStore.get(NESTED_BUILDER_CLASS_NAME);

    List<MethodDefinition> ctorMethods = new ArrayList<>();

    // First argument-less contructor.
    ctorMethods.add(
        MethodDefinition.constructorBuilder()
            .setScope(ScopeNode.PROTECTED)
            .setReturnType(builderType)
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
            .build());

    // Second ctor that takes a clientContext argument.
    VariableExpr clientContextVarExpr =
        VariableExpr.withVariable(
            Variable.builder()
                .setType(FIXED_TYPESTORE.get("ClientContext"))
                .setName("clientContext")
                .build());
    Reference pagedSettingsBuilderRef =
        ConcreteReference.withClazz(PagedCallSettings.Builder.class);
    Reference batchingSettingsBuilderRef =
        ConcreteReference.withClazz(BatchingCallSettings.Builder.class);
    Reference unaryCallSettingsBuilderRef =
        ConcreteReference.withClazz(UnaryCallSettings.Builder.class);
    Function<TypeNode, Boolean> isUnaryCallSettingsBuilderFn =
        t ->
            t.reference()
                .copyAndSetGenerics(ImmutableList.of())
                .equals(unaryCallSettingsBuilderRef);
    Function<TypeNode, Boolean> isPagedCallSettingsBuilderFn =
        t -> t.reference().copyAndSetGenerics(ImmutableList.of()).equals(pagedSettingsBuilderRef);
    Function<TypeNode, Boolean> isBatchingCallSettingsBuilderFn =
        t ->
            t.reference().copyAndSetGenerics(ImmutableList.of()).equals(batchingSettingsBuilderRef);
    Function<TypeNode, TypeNode> builderToCallSettingsFn =
        t ->
            TypeNode.withReference(
                VaporReference.builder()
                    .setName(String.join(DOT, t.reference().enclosingClassNames()))
                    .setPakkage(t.reference().pakkage())
                    .build());
    List<Statement> ctorBodyStatements = new ArrayList<>();
    ctorBodyStatements.add(
        ExprStatement.withExpr(
            ReferenceConstructorExpr.superBuilder()
                .setType(builderType)
                .setArguments(clientContextVarExpr)
                .build()));
    ctorBodyStatements.add(EMPTY_LINE_STATEMENT);

    ctorBodyStatements.addAll(
        nestedMethodSettingsMemberVarExprs.entrySet().stream()
            .map(
                e -> {
                  // TODO(miraleung): Extract this into another method.
                  // Name is fooBarSettings.
                  VariableExpr varExpr = e.getValue();
                  TypeNode varType = varExpr.type();
                  Preconditions.checkState(
                      e.getKey().endsWith(CommonStrings.SETTINGS_LITERAL),
                      String.format("%s expected to end with \"Settings\"", e.getKey()));
                  String methodName = getMethodNameFromSettingsVarName(e.getKey());

                  if (!isPagedCallSettingsBuilderFn.apply(varType)) {
                    if (!isBatchingCallSettingsBuilderFn.apply(varType)) {
                      boolean isUnaryCallSettings = isUnaryCallSettingsBuilderFn.apply(varType);
                      Expr builderExpr =
                          AssignmentExpr.builder()
                              .setVariableExpr(varExpr)
                              .setValueExpr(
                                  MethodInvocationExpr.builder()
                                      .setStaticReferenceType(
                                          builderToCallSettingsFn.apply(varExpr.type()))
                                      .setMethodName(
                                          isUnaryCallSettings
                                              ? "newUnaryCallSettingsBuilder"
                                              : "newBuilder")
                                      .setReturnType(varExpr.type())
                                      .build())
                              .build();
                      return ExprStatement.withExpr(builderExpr);
                    }
                    Expr newBatchingSettingsExpr =
                        MethodInvocationExpr.builder()
                            .setStaticReferenceType(FIXED_TYPESTORE.get("BatchingSettings"))
                            .setMethodName("newBuilder")
                            .build();
                    newBatchingSettingsExpr =
                        MethodInvocationExpr.builder()
                            .setExprReferenceExpr(newBatchingSettingsExpr)
                            .setMethodName("build")
                            .build();

                    String batchingDescVarName =
                        String.format(
                            BATCHING_DESC_PATTERN, JavaStyle.toUpperSnakeCase(methodName));
                    Expr batchingSettingsBuilderExpr =
                        MethodInvocationExpr.builder()
                            .setStaticReferenceType(builderToCallSettingsFn.apply(varType))
                            .setMethodName("newBuilder")
                            .setArguments(
                                VariableExpr.withVariable(
                                    Variable.builder()
                                        .setType(FIXED_TYPESTORE.get("BatchingDescriptor"))
                                        .setName(batchingDescVarName)
                                        .build()))
                            .build();
                    batchingSettingsBuilderExpr =
                        MethodInvocationExpr.builder()
                            .setExprReferenceExpr(batchingSettingsBuilderExpr)
                            .setMethodName("setBatchingSettings")
                            .setArguments(newBatchingSettingsExpr)
                            .setReturnType(varType)
                            .build();

                    Expr builderExpr =
                        AssignmentExpr.builder()
                            .setVariableExpr(varExpr)
                            .setValueExpr(batchingSettingsBuilderExpr)
                            .build();
                    return ExprStatement.withExpr(builderExpr);
                  }
                  String memberVarName =
                      String.format(
                          PAGED_RESPONSE_FACTORY_PATTERN, JavaStyle.toUpperSnakeCase(methodName));
                  VariableExpr argVar =
                      VariableExpr.withVariable(
                          Variable.builder()
                              .setType(FIXED_TYPESTORE.get("PagedListResponseFactory"))
                              .setName(memberVarName)
                              .build());
                  Expr builderExpr =
                      AssignmentExpr.builder()
                          .setVariableExpr(varExpr)
                          .setValueExpr(
                              MethodInvocationExpr.builder()
                                  .setStaticReferenceType(
                                      builderToCallSettingsFn.apply(varExpr.type()))
                                  .setMethodName("newBuilder")
                                  .setArguments(argVar)
                                  .setReturnType(varExpr.type())
                                  .build())
                          .build();
                  return ExprStatement.withExpr(builderExpr);
                })
            .collect(Collectors.toList()));

    Expr unaryMethodSettingsBuildersAssignExpr =
        AssignmentExpr.builder()
            .setVariableExpr(NESTED_UNARY_METHOD_SETTINGS_BUILDERS_VAR_EXPR)
            .setValueExpr(
                MethodInvocationExpr.builder()
                    .setStaticReferenceType(FIXED_TYPESTORE.get("ImmutableList"))
                    .setGenerics(
                        NESTED_UNARY_METHOD_SETTINGS_BUILDERS_VAR_EXPR
                            .type()
                            .reference()
                            .generics())
                    .setMethodName("of")
                    .setArguments(
                        nestedMethodSettingsMemberVarExprs.values().stream()
                            .filter(
                                v ->
                                    isUnaryCallSettingsBuilderFn.apply(v.type())
                                        || isPagedCallSettingsBuilderFn.apply(v.type())
                                        || isBatchingCallSettingsBuilderFn.apply(v.type()))
                            .collect(Collectors.toList()))
                    .setReturnType(NESTED_UNARY_METHOD_SETTINGS_BUILDERS_VAR_EXPR.type())
                    .build())
            .build();
    ctorBodyStatements.add(EMPTY_LINE_STATEMENT);

    ctorBodyStatements.add(ExprStatement.withExpr(unaryMethodSettingsBuildersAssignExpr));

    ctorBodyStatements.add(
        ExprStatement.withExpr(
            MethodInvocationExpr.builder()
                .setMethodName("initDefaults")
                .setArguments(ValueExpr.withValue(ThisObjectValue.withType(builderType)))
                .build()));

    ctorMethods.add(
        MethodDefinition.constructorBuilder()
            .setScope(ScopeNode.PROTECTED)
            .setReturnType(builderType)
            .setArguments(clientContextVarExpr.toBuilder().setIsDecl(true).build())
            .setBody(ctorBodyStatements)
            .build());

    // Third constructor that takes a ServiceStubSettings.
    TypeNode outerSettingsType = typeStore.get(ClassNames.getServiceStubSettingsClassName(service));
    VariableExpr settingsVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setType(outerSettingsType).setName("settings").build());
    ctorBodyStatements = new ArrayList<>();
    ctorBodyStatements.add(
        ExprStatement.withExpr(
            ReferenceConstructorExpr.superBuilder()
                .setType(builderType)
                .setArguments(settingsVarExpr)
                .build()));
    ctorBodyStatements.add(EMPTY_LINE_STATEMENT);

    // TODO(cleanup): Technically this should actually use the outer class's <method>Settings
    // members to avoid decoupling variable names.
    ctorBodyStatements.addAll(
        nestedMethodSettingsMemberVarExprs.values().stream()
            .map(
                v ->
                    ExprStatement.withExpr(
                        AssignmentExpr.builder()
                            .setVariableExpr(v)
                            .setValueExpr(
                                MethodInvocationExpr.builder()
                                    .setExprReferenceExpr(
                                        VariableExpr.builder()
                                            .setExprReferenceExpr(settingsVarExpr)
                                            .setVariable(v.variable())
                                            .build())
                                    .setMethodName("toBuilder")
                                    .setReturnType(v.type())
                                    .build())
                            .build()))
            .collect(Collectors.toList()));
    ctorBodyStatements.add(EMPTY_LINE_STATEMENT);

    ctorBodyStatements.add(ExprStatement.withExpr(unaryMethodSettingsBuildersAssignExpr));

    ctorMethods.add(
        MethodDefinition.constructorBuilder()
            .setScope(ScopeNode.PROTECTED)
            .setReturnType(builderType)
            .setArguments(settingsVarExpr.toBuilder().setIsDecl(true).build())
            .setBody(ctorBodyStatements)
            .build());

    return ctorMethods;
  }

  protected List<MethodDefinition> createNestedClassCreateDefaultMethods(
      Service service, TypeStore typeStore) {
    if (service.hasAnyEnabledMethodsForTransport(getTransportContext().transport())) {
      return Arrays.asList(
          createNestedClassCreateDefaultMethod(
              typeStore,
              "createDefault",
              "defaultTransportChannelProvider",
              null,
              "defaultApiClientHeaderProviderBuilder"));
    } else {
      return Collections.emptyList();
    }
  }

  protected MethodDefinition createNestedClassCreateDefaultMethod(
      TypeStore typeStore,
      String methodName,
      String defaultTransportChannelProvider,
      String defaultTransportChannelProviderBuilder,
      String defaultApiClientHeaderProviderBuilder) {
    List<Statement> bodyStatements = new ArrayList<>();

    // Initialize the builder: Builder builder = new Builder((ClientContext) null);
    TypeNode builderType = typeStore.get(NESTED_BUILDER_CLASS_NAME);
    VariableExpr builderVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setType(builderType).setName("builder").build());
    bodyStatements.add(
        ExprStatement.withExpr(
            AssignmentExpr.builder()
                .setVariableExpr(builderVarExpr.toBuilder().setIsDecl(true).build())
                .setValueExpr(
                    NewObjectExpr.builder()
                        .setType(builderType)
                        .setArguments(
                            CastExpr.builder()
                                .setType(FIXED_TYPESTORE.get("ClientContext"))
                                .setExpr(ValueExpr.createNullExpr())
                                .build())
                        .build())
                .build()));
    bodyStatements.add(EMPTY_LINE_STATEMENT);

    List<Expr> bodyExprs = new ArrayList<>();

    if (defaultTransportChannelProvider != null) {
      bodyExprs.add(
          MethodInvocationExpr.builder()
              .setExprReferenceExpr(builderVarExpr)
              .setMethodName("setTransportChannelProvider")
              .setArguments(
                  MethodInvocationExpr.builder()
                      .setMethodName(defaultTransportChannelProvider)
                      .build())
              .build());
    } else {
      bodyExprs.add(
          MethodInvocationExpr.builder()
              .setExprReferenceExpr(builderVarExpr)
              .setMethodName("setTransportChannelProvider")
              .setArguments(
                  MethodInvocationExpr.builder()
                      .setExprReferenceExpr(
                          MethodInvocationExpr.builder()
                              .setMethodName(defaultTransportChannelProviderBuilder)
                              .build())
                      .setMethodName("build")
                      .build())
              .build());
    }

    bodyExprs.add(
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(builderVarExpr)
            .setMethodName("setCredentialsProvider")
            .setArguments(
                MethodInvocationExpr.builder()
                    .setExprReferenceExpr(
                        MethodInvocationExpr.builder()
                            .setMethodName("defaultCredentialsProviderBuilder")
                            .build())
                    .setMethodName("build")
                    .build())
            .build());

    bodyExprs.add(
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(builderVarExpr)
            .setMethodName("setInternalHeaderProvider")
            .setArguments(
                MethodInvocationExpr.builder()
                    .setExprReferenceExpr(
                        MethodInvocationExpr.builder()
                            .setMethodName(defaultApiClientHeaderProviderBuilder)
                            .build())
                    .setMethodName("build")
                    .build())
            .build());
    bodyExprs.add(
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(builderVarExpr)
            .setMethodName("setMtlsEndpoint")
            .setArguments(
                MethodInvocationExpr.builder().setMethodName("getDefaultMtlsEndpoint").build())
            .build());
    bodyExprs.add(
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(builderVarExpr)
            .setMethodName("setSwitchToMtlsEndpointAllowed")
            .setArguments(
                ValueExpr.withValue(
                    PrimitiveValue.builder().setType(TypeNode.BOOLEAN).setValue("true").build()))
            .build());
    bodyStatements.addAll(
        bodyExprs.stream().map(e -> ExprStatement.withExpr(e)).collect(Collectors.toList()));
    bodyStatements.add(EMPTY_LINE_STATEMENT);

    Expr returnExpr =
        MethodInvocationExpr.builder()
            .setMethodName("initDefaults")
            .setArguments(builderVarExpr)
            .setReturnType(builderType)
            .build();

    return MethodDefinition.builder()
        .setScope(ScopeNode.PRIVATE)
        .setIsStatic(true)
        .setReturnType(builderType)
        .setName(methodName)
        .setBody(bodyStatements)
        .setReturnExpr(returnExpr)
        .build();
  }

  private static MethodDefinition createNestedClassApplyToAllUnaryMethodsMethod(
      TypeNode superType, TypeStore typeStore) {
    List<Reference> apiFunctionTypeGenerics = new ArrayList<>();
    apiFunctionTypeGenerics.addAll(
        NESTED_UNARY_METHOD_SETTINGS_BUILDERS_VAR_EXPR.type().reference().generics());
    apiFunctionTypeGenerics.add(TypeNode.VOID_OBJECT.reference());

    TypeNode settingsUpdaterType =
        TypeNode.withReference(
            ConcreteReference.builder()
                .setClazz(ApiFunction.class)
                .setGenerics(apiFunctionTypeGenerics)
                .build());
    VariableExpr settingsUpdaterVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setType(settingsUpdaterType).setName("settingsUpdater").build());

    String methodName = "applyToAllUnaryMethods";
    Expr superApplyExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(ValueExpr.withValue(SuperObjectValue.withType(superType)))
            .setMethodName(methodName)
            .setArguments(NESTED_UNARY_METHOD_SETTINGS_BUILDERS_VAR_EXPR, settingsUpdaterVarExpr)
            .build();

    TypeNode returnType = typeStore.get(NESTED_BUILDER_CLASS_NAME);
    Expr returnExpr = ValueExpr.withValue(ThisObjectValue.withType(returnType));

    return MethodDefinition.builder()
        .setHeaderCommentStatements(
            SettingsCommentComposer.APPLY_TO_ALL_UNARY_METHODS_METHOD_COMMENTS)
        .setScope(ScopeNode.PUBLIC)
        .setReturnType(returnType)
        .setName(methodName)
        .setArguments(settingsUpdaterVarExpr.toBuilder().setIsDecl(true).build())
        .setBody(Arrays.asList(ExprStatement.withExpr(superApplyExpr)))
        .setReturnExpr(returnExpr)
        .build();
  }

  private static MethodDefinition createNestedClassUnaryMethodSettingsBuilderGetterMethod() {
    return MethodDefinition.builder()
        .setScope(ScopeNode.PUBLIC)
        .setReturnType(NESTED_UNARY_METHOD_SETTINGS_BUILDERS_VAR_EXPR.type())
        .setName("unaryMethodSettingsBuilders")
        .setReturnExpr(NESTED_UNARY_METHOD_SETTINGS_BUILDERS_VAR_EXPR)
        .build();
  }

  private static List<MethodDefinition> createNestedClassSettingsBuilderGetterMethods(
      Map<String, VariableExpr> nestedMethodSettingsMemberVarExprs,
      Set<String> nestedDeprecatedSettingVarNames,
      Set<String> nestedInternalSettingVarNames) {
    Reference operationCallSettingsBuilderRef =
        ConcreteReference.withClazz(OperationCallSettings.Builder.class);
    Function<TypeNode, Boolean> isOperationCallSettingsBuilderFn =
        t ->
            t.reference()
                .copyAndSetGenerics(ImmutableList.of())
                .equals(operationCallSettingsBuilderRef);

    List<MethodDefinition> javaMethods = new ArrayList<>();
    for (Map.Entry<String, VariableExpr> settingsVarEntry :
        nestedMethodSettingsMemberVarExprs.entrySet()) {
      String varName = settingsVarEntry.getKey();
      VariableExpr settingsVarExpr = settingsVarEntry.getValue();

      boolean isDeprecated = nestedDeprecatedSettingVarNames.contains(varName);
      boolean isInternal = nestedInternalSettingVarNames.contains(varName);

      javaMethods.add(
          MethodDefinition.builder()
              .setHeaderCommentStatements(
                  SettingsCommentComposer.createCallSettingsBuilderGetterComment(
                      getMethodNameFromSettingsVarName(varName), isDeprecated, isInternal))
              .setAnnotations(createMethodAnnotation(isDeprecated, isInternal))
              .setScope(ScopeNode.PUBLIC)
              .setReturnType(settingsVarExpr.type())
              .setName(settingsVarExpr.variable().identifier().name())
              .setReturnExpr(settingsVarExpr)
              .build());
    }
    return javaMethods;
  }

  private static MethodDefinition createNestedClassBuildMethod(
      Service service, TypeStore typeStore) {
    TypeNode outerClassType = typeStore.get(ClassNames.getServiceStubSettingsClassName(service));
    TypeNode builderType = typeStore.get(NESTED_BUILDER_CLASS_NAME);

    return MethodDefinition.builder()
        .setIsOverride(true)
        .setScope(ScopeNode.PUBLIC)
        .setReturnType(outerClassType)
        .setName("build")
        .setThrowsExceptions(Arrays.asList(TypeNode.withExceptionClazz(IOException.class)))
        .setReturnExpr(
            NewObjectExpr.builder()
                .setType(outerClassType)
                .setArguments(ValueExpr.withValue(ThisObjectValue.withType(builderType)))
                .build())
        .build();
  }

  private MethodDefinition createGetLibraryMetadataMethod(GapicContext context) {
    TypeNode returnType = FIXED_TYPESTORE.get("LibraryMetadata");
    MethodInvocationExpr libraryMetadataBuilderExpr =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(FIXED_TYPESTORE.get("LibraryMetadata"))
            .setMethodName("newBuilder")
            .build();

    if (!Strings.isNullOrEmpty(context.artifact())) {
      libraryMetadataBuilderExpr =
          MethodInvocationExpr.builder()
              .setExprReferenceExpr(libraryMetadataBuilderExpr)
              .setMethodName("setArtifactName")
              .setArguments(ValueExpr.withValue(StringObjectValue.withValue(context.artifact())))
              .build();
    }

    if (!Strings.isNullOrEmpty(context.repo())) {
      libraryMetadataBuilderExpr =
          MethodInvocationExpr.builder()
              .setExprReferenceExpr(libraryMetadataBuilderExpr)
              .setMethodName("setRepository")
              .setArguments(ValueExpr.withValue(StringObjectValue.withValue(context.repo())))
              .build();
    }

    Expr returnExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(libraryMetadataBuilderExpr)
            .setMethodName("build")
            .setReturnType(returnType)
            .build();

    return MethodDefinition.builder()
        .setIsOverride(true)
        .setScope(ScopeNode.PROTECTED)
        .setReturnType(returnType)
        .setName("getLibraryMetadata")
        .setReturnExpr(returnExpr)
        .build();
  }

  private static TypeStore createStaticTypes() {
    List<Class<?>> concreteClazzes =
        Arrays.asList(
            ApiCallContext.class,
            ApiClientHeaderProvider.class,
            ApiFunction.class,
            ApiFuture.class,
            BatchedRequestIssuer.class,
            BatchingCallSettings.class,
            BatchingDescriptor.class,
            BatchingSettings.class,
            BetaApi.class,
            InternalApi.class,
            ClientContext.class,
            Duration.class,
            Empty.class,
            FlowControlSettings.class,
            GaxProperties.class,
            Generated.class,
            GoogleCredentialsProvider.class,
            IOException.class,
            ImmutableList.class,
            ImmutableMap.class,
            ImmutableSet.class,
            InstantiatingExecutorProvider.class,
            LibraryMetadata.class,
            LimitExceededBehavior.class,
            List.class,
            Lists.class,
            MonitoredResourceDescriptor.class,
            ObsoleteApi.class,
            Operation.class,
            OperationCallSettings.class,
            OperationSnapshot.class,
            OperationTimedPollAlgorithm.class,
            PageContext.class,
            PagedCallSettings.class,
            PagedListDescriptor.class,
            PagedListResponseFactory.class,
            PartitionKey.class,
            RequestBuilder.class,
            RetrySettings.class,
            ServerStreamingCallSettings.class,
            StatusCode.class,
            StreamingCallSettings.class,
            StubSettings.class,
            SuppressWarnings.class,
            TransportChannelProvider.class,
            UnaryCallSettings.class,
            UnaryCallable.class);
    return new TypeStore(concreteClazzes);
  }

  private TypeStore createDynamicTypes(Service service, String pakkage) {
    TypeStore typeStore = new TypeStore();

    // This type.
    String thisClassName = ClassNames.getServiceStubSettingsClassName(service);
    typeStore.putAll(
        pakkage,
        Arrays.asList(
            thisClassName,
            ClassNames.getServiceStubSettingsClassName(service),
            ClassNames.getServiceStubClassName(service)));

    typeStore.putAll(
        pakkage, getTransportContext().classNames().getTransportServiceStubClassNames(service));

    // Nested builder class.
    typeStore.put(pakkage, NESTED_BUILDER_CLASS_NAME, true, thisClassName);

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

  private static VariableExpr createDefaultServiceScopesVarExpr() {
    TypeNode listStringType =
        TypeNode.withReference(
            ConcreteReference.builder()
                .setClazz(ImmutableList.class)
                .setGenerics(Arrays.asList(ConcreteReference.withClazz(String.class)))
                .build());
    return VariableExpr.withVariable(
        Variable.builder().setName("DEFAULT_SERVICE_SCOPES").setType(listStringType).build());
  }

  private static VariableExpr createNestedUnaryMethodSettingsBuildersVarExpr() {
    Reference builderRef =
        ConcreteReference.builder()
            .setClazz(UnaryCallSettings.Builder.class)
            .setGenerics(Arrays.asList(TypeNode.WILDCARD_REFERENCE, TypeNode.WILDCARD_REFERENCE))
            .build();
    TypeNode varType =
        TypeNode.withReference(
            ConcreteReference.builder()
                .setClazz(ImmutableList.class)
                .setGenerics(Arrays.asList(builderRef))
                .build());
    return VariableExpr.withVariable(
        Variable.builder()
            .setType(varType)
            .setName(NESTED_UNARY_METHOD_SETTINGS_BUILDERS_VAR_NAME)
            .build());
  }

  private static VariableExpr createNestedRetryableCodeDefinitionsVarExpr() {
    TypeNode immutableSetType =
        TypeNode.withReference(
            ConcreteReference.builder()
                .setClazz(ImmutableSet.class)
                .setGenerics(Arrays.asList(ConcreteReference.withClazz(StatusCode.Code.class)))
                .build());
    TypeNode varType =
        TypeNode.withReference(
            ConcreteReference.builder()
                .setClazz(ImmutableMap.class)
                .setGenerics(
                    Arrays.asList(TypeNode.STRING, immutableSetType).stream()
                        .map(t -> t.reference())
                        .collect(Collectors.toList()))
                .build());
    return VariableExpr.withVariable(
        Variable.builder()
            .setType(varType)
            .setName(NESTED_RETRYABLE_CODE_DEFINITIONS_VAR_NAME)
            .build());
  }

  private static VariableExpr createNestedRetryParamDefinitionsVarExpr() {
    TypeNode varType =
        TypeNode.withReference(
            ConcreteReference.builder()
                .setClazz(ImmutableMap.class)
                .setGenerics(
                    Arrays.asList(TypeNode.STRING, FIXED_TYPESTORE.get("RetrySettings")).stream()
                        .map(t -> t.reference())
                        .collect(Collectors.toList()))
                .build());
    return VariableExpr.withVariable(
        Variable.builder()
            .setType(varType)
            .setName(NESTED_RETRY_PARAM_DEFINITIONS_VAR_NAME)
            .build());
  }

  private static String getPagedResponseTypeName(String methodName) {
    return String.format(
        CommonStrings.PAGED_RESPONSE_TYPE_NAME_PATTERN, JavaStyle.toUpperCamelCase(methodName));
  }

  private static TypeNode getCallSettingsType(
      Method method,
      TypeStore typeStore,
      boolean isBatchingSettings,
      final boolean isSettingsBuilder) {
    Function<Class<?>, TypeNode> typeMakerFn =
        clz -> TypeNode.withReference(ConcreteReference.withClazz(clz));
    // Default: No streaming.
    TypeNode callSettingsType =
        method.isPaged()
            ? typeMakerFn.apply(
                isSettingsBuilder ? PagedCallSettings.Builder.class : PagedCallSettings.class)
            : typeMakerFn.apply(
                isSettingsBuilder ? UnaryCallSettings.Builder.class : UnaryCallSettings.class);
    if (isBatchingSettings) {
      callSettingsType =
          typeMakerFn.apply(
              isSettingsBuilder ? BatchingCallSettings.Builder.class : BatchingCallSettings.class);
    }

    // Streaming takes precedence over paging, as per the monolith's existing behavior.
    switch (method.stream()) {
      case SERVER:
        callSettingsType =
            typeMakerFn.apply(
                isSettingsBuilder
                    ? ServerStreamingCallSettings.Builder.class
                    : ServerStreamingCallSettings.class);
        break;
      case CLIENT:
      // Fall through.
      case BIDI:
        callSettingsType =
            typeMakerFn.apply(
                isSettingsBuilder
                    ? StreamingCallSettings.Builder.class
                    : StreamingCallSettings.class);
        break;
      case NONE:
      // Fall through.
      default:
        break;
    }

    List<Reference> generics = new ArrayList<>();
    generics.add(method.inputType().reference());
    generics.add(method.outputType().reference());
    if (method.isPaged()) {
      generics.add(typeStore.get(getPagedResponseTypeName(method.name())).reference());
    }
    return TypeNode.withReference(callSettingsType.reference().copyAndSetGenerics(generics));
  }

  private static TypeNode getOperationCallSettingsType(Method method, boolean isSettingsBuilder) {
    Preconditions.checkState(
        method.hasLro(),
        String.format("Cannot get OperationCallSettings for non-LRO method %s", method.name()));
    List<Reference> generics = new ArrayList<>();
    generics.add(method.inputType().reference());
    generics.add(method.lro().responseType().reference());
    generics.add(method.lro().metadataType().reference());
    return TypeNode.withReference(
        ConcreteReference.builder()
            .setClazz(
                isSettingsBuilder
                    ? OperationCallSettings.Builder.class
                    : OperationCallSettings.class)
            .setGenerics(generics)
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
