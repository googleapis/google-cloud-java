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

package com.google.api.generator.gapic.composer.resourcename;

import com.google.api.generator.engine.ast.AnnotationNode;
import com.google.api.generator.engine.ast.AssignmentExpr;
import com.google.api.generator.engine.ast.AssignmentOperationExpr;
import com.google.api.generator.engine.ast.CastExpr;
import com.google.api.generator.engine.ast.ClassDefinition;
import com.google.api.generator.engine.ast.CommentStatement;
import com.google.api.generator.engine.ast.ConcreteReference;
import com.google.api.generator.engine.ast.Expr;
import com.google.api.generator.engine.ast.ExprStatement;
import com.google.api.generator.engine.ast.ForStatement;
import com.google.api.generator.engine.ast.IfStatement;
import com.google.api.generator.engine.ast.JavaDocComment;
import com.google.api.generator.engine.ast.LogicalOperationExpr;
import com.google.api.generator.engine.ast.MethodDefinition;
import com.google.api.generator.engine.ast.MethodInvocationExpr;
import com.google.api.generator.engine.ast.NewObjectExpr;
import com.google.api.generator.engine.ast.PrimitiveValue;
import com.google.api.generator.engine.ast.Reference;
import com.google.api.generator.engine.ast.RelationalOperationExpr;
import com.google.api.generator.engine.ast.ReturnExpr;
import com.google.api.generator.engine.ast.ScopeNode;
import com.google.api.generator.engine.ast.Statement;
import com.google.api.generator.engine.ast.StringObjectValue;
import com.google.api.generator.engine.ast.SynchronizedStatement;
import com.google.api.generator.engine.ast.TernaryExpr;
import com.google.api.generator.engine.ast.ThisObjectValue;
import com.google.api.generator.engine.ast.ThrowExpr;
import com.google.api.generator.engine.ast.TypeNode;
import com.google.api.generator.engine.ast.ValueExpr;
import com.google.api.generator.engine.ast.Variable;
import com.google.api.generator.engine.ast.VariableExpr;
import com.google.api.generator.gapic.composer.comment.CommentComposer;
import com.google.api.generator.gapic.composer.store.TypeStore;
import com.google.api.generator.gapic.model.GapicClass;
import com.google.api.generator.gapic.model.GapicContext;
import com.google.api.generator.gapic.model.ResourceName;
import com.google.api.generator.gapic.utils.JavaStyle;
import com.google.api.generator.gapic.utils.ResourceNameConstants;
import com.google.api.pathtemplate.PathTemplate;
import com.google.api.pathtemplate.ValidationException;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Generated;

public class ResourceNameHelperClassComposer {
  private static final String CLASS_NAME_PATTERN = "%sName";
  private static final String BUILDER_CLASS_HEADER_PATTERN = "Builder for %s.";

  private static final ResourceNameHelperClassComposer INSTANCE =
      new ResourceNameHelperClassComposer();

  private static final TypeStore FIXED_TYPESTORE = createStaticTypes();
  private static final Map<String, VariableExpr> FIXED_CLASS_VARS =
      createFixedClassMemberVariables();

  private static Reference javaObjectReference = ConcreteReference.withClazz(Object.class);

  private ResourceNameHelperClassComposer() {}

  public static ResourceNameHelperClassComposer instance() {
    return INSTANCE;
  }

  public GapicClass generate(ResourceName resourceName, GapicContext context) {
    // Set up types.
    List<List<String>> tokenHierarchies =
        ResourceNameTokenizer.parseTokenHierarchy(resourceName.patterns());
    TypeStore typeStore = createDynamicTypes(resourceName, tokenHierarchies);
    // Use the full name java.lang.Object if there is a proto message that is also named "Object".
    // Affects GCS.
    if (context.messages().keySet().stream()
        .anyMatch(s -> s.equals("Object") || s.endsWith(".Object"))) {
      javaObjectReference =
          ConcreteReference.builder().setClazz(Object.class).setUseFullName(true).build();
    }

    // Set up variables.
    List<VariableExpr> templateFinalVarExprs = createTemplateClassMembers(tokenHierarchies);
    Map<String, VariableExpr> patternTokenVarExprs =
        createPatternTokenClassMembers(tokenHierarchies);

    // Check invariants.
    Preconditions.checkState(
        patternTokenVarExprs.size() > 0,
        String.format("No patterns found for resource name %s", resourceName.resourceTypeString()));
    Preconditions.checkState(
        templateFinalVarExprs.size() > 0 && tokenHierarchies.size() == templateFinalVarExprs.size(),
        String.format(
            "Cardinalities of patterns (%d) and associated variables (%d) do not match for"
                + " resource name %s ",
            templateFinalVarExprs.size(),
            tokenHierarchies.size(),
            resourceName.resourceTypeString()));

    String className = getThisClassName(resourceName);

    ClassDefinition classDef =
        ClassDefinition.builder()
            .setPackageString(resourceName.pakkage())
            .setHeaderCommentStatements(CommentComposer.AUTO_GENERATED_CLASS_COMMENT)
            .setAnnotations(createClassAnnotations())
            .setScope(ScopeNode.PUBLIC)
            .setName(className)
            .setImplementsTypes(Arrays.asList(createImplementsTypes(className)))
            .setStatements(
                createClassStatements(
                    templateFinalVarExprs,
                    patternTokenVarExprs,
                    resourceName.patterns(),
                    tokenHierarchies))
            .setMethods(
                createClassMethods(
                    resourceName,
                    templateFinalVarExprs,
                    patternTokenVarExprs,
                    tokenHierarchies,
                    typeStore))
            .setNestedClasses(
                createNestedBuilderClasses(
                    resourceName, tokenHierarchies, templateFinalVarExprs, typeStore))
            .build();
    return GapicClass.create(GapicClass.Kind.PROTO, classDef);
  }

  private static List<AnnotationNode> createClassAnnotations() {
    return Arrays.asList(
        AnnotationNode.builder()
            .setType(FIXED_TYPESTORE.get("Generated"))
            .setDescription("by gapic-generator-java")
            .build());
  }

  /**
   * Returns a singleton list with {@code ResourceName} as its only member. Checks for collisions
   *
   * @param implementingClassName class that is implementing the resulting list
   */
  private static TypeNode createImplementsTypes(String implementingClassName) {
    // the original resource name reference has useFullName == false
    TypeNode originalResourceName = FIXED_TYPESTORE.get("ResourceName");
    if (implementingClassName.equals(originalResourceName.reference().name())) {
      // we create a copy with useFullName == true
      return TypeNode.withReference(
          ConcreteReference.builder()
              .setUseFullName(true)
              .setClazz(com.google.api.resourcenames.ResourceName.class)
              .setGenerics(originalResourceName.reference().generics())
              .setIsStaticImport(originalResourceName.reference().isStaticImport())
              .setWildcardUpperBound(originalResourceName.reference().wildcardUpperBound())
              .build());
    }
    return originalResourceName;
  }

  private static List<VariableExpr> createTemplateClassMembers(
      List<List<String>> tokenHierarchies) {
    return tokenHierarchies.stream()
        .map(
            ts ->
                VariableExpr.withVariable(
                    Variable.builder()
                        .setName(concatToUpperSnakeCaseName(ts))
                        .setType(
                            // PubSub special-case handling for the _deleted-topic_ pattern.
                            ts.contains(ResourceNameConstants.DELETED_TOPIC_LITERAL)
                                ? TypeNode.STRING
                                : FIXED_TYPESTORE.get("PathTemplate"))
                        .build()))
        .collect(Collectors.toList());
  }

  private static Map<String, VariableExpr> createPatternTokenClassMembers(
      List<List<String>> tokenHierarchies) {
    // PubSub special-case handling - exclude _deleted-topic_.
    List<List<String>> processedTokenHierarchies =
        tokenHierarchies.stream()
            .filter(ts -> !ts.contains(ResourceNameConstants.DELETED_TOPIC_LITERAL))
            .collect(Collectors.toList());
    Set<String> tokenSet = getTokenSet(processedTokenHierarchies);
    return tokenSet.stream()
        .collect(
            Collectors.toMap(
                t -> t,
                t ->
                    VariableExpr.withVariable(
                        Variable.builder()
                            .setName(JavaStyle.toLowerCamelCase(t))
                            .setType(TypeNode.STRING)
                            .build())));
  }

  private static List<Statement> createClassStatements(
      List<VariableExpr> templateFinalVarExprs,
      Map<String, VariableExpr> patternTokenVarExprs,
      List<String> patterns,
      List<List<String>> tokenHierarchies) {
    List<Expr> memberVars = new ArrayList<>();
    // Pattern string variables.
    // Example:
    // private static final PathTemplate PROJECT_LOCATION_AUTOSCALING_POLICY_PATH_TEMPLATE =
    //     PathTemplate.createWithoutUrlEncoding(
    //         "projects/{project}/locations/{location}/autoscalingPolicies/{autoscaling_policy}");
    for (int i = 0; i < patterns.size(); i++) {
      VariableExpr varExpr =
          templateFinalVarExprs.get(i).toBuilder()
              .setIsDecl(true)
              .setScope(ScopeNode.PRIVATE)
              .setIsStatic(true)
              .setIsFinal(true)
              .build();
      String pattern = patterns.get(i);
      Expr valueExpr =
          MethodInvocationExpr.builder()
              .setStaticReferenceType(FIXED_TYPESTORE.get("PathTemplate"))
              .setMethodName("createWithoutUrlEncoding")
              .setArguments(
                  Arrays.asList(ValueExpr.withValue(StringObjectValue.withValue(pattern))))
              .setReturnType(FIXED_TYPESTORE.get("PathTemplate"))
              .build();
      // PubSub special-case handling for _deleted-topic_.
      if (pattern.equals(ResourceNameConstants.DELETED_TOPIC_LITERAL)) {
        valueExpr = ValueExpr.withValue(StringObjectValue.withValue(pattern));
      }
      memberVars.add(
          AssignmentExpr.builder().setVariableExpr(varExpr).setValueExpr(valueExpr).build());
    }

    memberVars.add(
        FIXED_CLASS_VARS.get("fieldValuesMap").toBuilder()
            .setIsDecl(true)
            .setScope(ScopeNode.PRIVATE)
            .setIsVolatile(true)
            .build());

    boolean hasVariants = tokenHierarchies.size() > 1;
    if (hasVariants) {
      Function<VariableExpr, VariableExpr> toDeclFn =
          v -> v.toBuilder().setIsDecl(true).setScope(ScopeNode.PRIVATE).build();
      memberVars.add(toDeclFn.apply(FIXED_CLASS_VARS.get("pathTemplate")));
      memberVars.add(toDeclFn.apply(FIXED_CLASS_VARS.get("fixedValue")));
    }

    // Private per-token string variables.
    // Use the token set as a key to maintain ordering (for consistency).
    Function<VariableExpr, VariableExpr> toFinalDeclFn =
        v -> v.toBuilder().setIsDecl(true).setScope(ScopeNode.PRIVATE).setIsFinal(true).build();
    // Special-cased PubSub handling.
    List<List<String>> processedTokenHierarchies =
        tokenHierarchies.stream()
            .filter(tokens -> !tokens.contains(ResourceNameConstants.DELETED_TOPIC_LITERAL))
            .collect(Collectors.toList());
    memberVars.addAll(
        getTokenSet(processedTokenHierarchies).stream()
            .map(t -> toFinalDeclFn.apply(patternTokenVarExprs.get(t)))
            .collect(Collectors.toList()));
    return memberVars.stream().map(e -> ExprStatement.withExpr(e)).collect(Collectors.toList());
  }

  private static List<MethodDefinition> createClassMethods(
      ResourceName resourceName,
      List<VariableExpr> templateFinalVarExprs,
      Map<String, VariableExpr> patternTokenVarExprs,
      List<List<String>> tokenHierarchies,
      TypeStore typeStore) {
    List<MethodDefinition> javaMethods = new ArrayList<>();

    javaMethods.addAll(
        createConstructorMethods(
            resourceName,
            templateFinalVarExprs,
            patternTokenVarExprs,
            tokenHierarchies,
            typeStore));

    javaMethods.addAll(createTokenGetterMethods(patternTokenVarExprs, tokenHierarchies));

    javaMethods.addAll(createBuilderCreatorMethods(resourceName, tokenHierarchies, typeStore));
    javaMethods.addAll(
        createOfCreatorMethods(resourceName, patternTokenVarExprs, tokenHierarchies, typeStore));

    javaMethods.addAll(
        createFormatCreatorMethods(
            resourceName, patternTokenVarExprs, tokenHierarchies, typeStore));

    javaMethods.addAll(
        createParsingAndSplittingMethods(
            resourceName, templateFinalVarExprs, tokenHierarchies, typeStore));

    javaMethods.addAll(
        createFieldValueGetterMethods(
            resourceName, patternTokenVarExprs, tokenHierarchies, typeStore));
    javaMethods.add(
        createToStringMethod(templateFinalVarExprs, patternTokenVarExprs, tokenHierarchies));
    javaMethods.add(createEqualsMethod(resourceName, tokenHierarchies, typeStore));
    javaMethods.add(createHashCodeMethod(tokenHierarchies));
    return javaMethods;
  }

  private static List<MethodDefinition> createConstructorMethods(
      ResourceName resourceName,
      List<VariableExpr> templateFinalVarExprs,
      Map<String, VariableExpr> patternTokenVarExprs,
      List<List<String>> tokenHierarchies,
      TypeStore typeStore) {
    String thisClassName = getThisClassName(resourceName);
    TypeNode thisClassType = typeStore.get(thisClassName);
    boolean hasVariants = tokenHierarchies.size() > 1;

    List<MethodDefinition> javaMethods = new ArrayList<>();
    final ValueExpr nullExpr = ValueExpr.createNullExpr();
    Function<String, AssignmentExpr> assignTokenToNullExpr =
        t ->
            AssignmentExpr.builder()
                .setVariableExpr(patternTokenVarExprs.get(t))
                .setValueExpr(nullExpr)
                .build();

    // Special-cased PubSub handling.
    List<List<String>> processedTokenHierarchies =
        tokenHierarchies.stream()
            .filter(tokens -> !tokens.contains(ResourceNameConstants.DELETED_TOPIC_LITERAL))
            .collect(Collectors.toList());
    boolean hasDeletedTopicPattern = tokenHierarchies.size() > processedTokenHierarchies.size();

    // First deprecated constructor.
    javaMethods.add(
        MethodDefinition.constructorBuilder()
            .setAnnotations(
                Arrays.asList(
                    AnnotationNode.withType(
                        TypeNode.withReference(ConcreteReference.withClazz(Deprecated.class)))))
            .setScope(ScopeNode.PROTECTED)
            .setReturnType(thisClassType)
            .setBody(
                getTokenSet(processedTokenHierarchies).stream()
                    .map(t -> ExprStatement.withExpr(assignTokenToNullExpr.apply(t)))
                    .collect(Collectors.toList()))
            .build());

    for (int i = 0; i < processedTokenHierarchies.size(); i++) {
      List<String> tokens = processedTokenHierarchies.get(i);

      List<Expr> bodyExprs = new ArrayList<>();
      TypeNode argType = getBuilderType(typeStore, processedTokenHierarchies, i);
      VariableExpr builderArgExpr =
          VariableExpr.withVariable(Variable.builder().setName("builder").setType(argType).build());
      for (String token : tokens) {
        MethodInvocationExpr checkNotNullExpr =
            MethodInvocationExpr.builder()
                .setStaticReferenceType(FIXED_TYPESTORE.get("Preconditions"))
                .setMethodName("checkNotNull")
                .setReturnType(TypeNode.STRING)
                .setArguments(
                    Arrays.asList(
                        MethodInvocationExpr.builder()
                            .setExprReferenceExpr(builderArgExpr)
                            .setMethodName(
                                String.format("get%s", JavaStyle.toUpperCamelCase(token)))
                            .build()))
                .build();
        bodyExprs.add(
            AssignmentExpr.builder()
                .setVariableExpr(patternTokenVarExprs.get(token))
                .setValueExpr(checkNotNullExpr)
                .build());
      }
      // Initialize the rest to null.
      for (String token : getTokenSet(processedTokenHierarchies)) {
        if (tokens.contains(token)) {
          continue;
        }
        bodyExprs.add(assignTokenToNullExpr.apply(token));
      }

      if (hasVariants) {
        AssignmentExpr pathTemplateAssignExpr =
            AssignmentExpr.builder()
                .setVariableExpr(FIXED_CLASS_VARS.get("pathTemplate"))
                .setValueExpr(templateFinalVarExprs.get(i))
                .build();
        bodyExprs.add(pathTemplateAssignExpr);
      }

      // Private constructor.
      javaMethods.add(
          MethodDefinition.constructorBuilder()
              .setScope(ScopeNode.PRIVATE)
              .setReturnType(thisClassType)
              .setArguments(Arrays.asList(builderArgExpr.toBuilder().setIsDecl(true).build()))
              .setBody(
                  bodyExprs.stream()
                      .map(e -> ExprStatement.withExpr(e))
                      .collect(Collectors.toList()))
              .build());
    }

    if (hasDeletedTopicPattern) {
      Expr thisExpr = ValueExpr.withValue(ThisObjectValue.withType(thisClassType));
      // PubSub special-case handling for the _deleted-topic_ pattern - add an extra constructor.
      //  private TopicName(String fixedValue) {
      //    this.fixedValue = fixedValue;
      //    fieldValuesMap = ImmutableMap.of("", fixedValue);
      //  }
      VariableExpr fixedValueVarExpr =
          VariableExpr.withVariable(
              Variable.builder().setName("fixedValue").setType(TypeNode.STRING).build());
      List<Expr> specialCtorBodyExprs = new ArrayList<>();
      specialCtorBodyExprs.add(
          AssignmentExpr.builder()
              .setVariableExpr(
                  VariableExpr.builder()
                      .setExprReferenceExpr(thisExpr)
                      .setVariable(fixedValueVarExpr.variable())
                      .build())
              .setValueExpr(fixedValueVarExpr)
              .build());
      specialCtorBodyExprs.add(
          AssignmentExpr.builder()
              .setVariableExpr(FIXED_CLASS_VARS.get("fieldValuesMap"))
              .setValueExpr(
                  MethodInvocationExpr.builder()
                      .setStaticReferenceType(FIXED_TYPESTORE.get("ImmutableMap"))
                      .setMethodName("of")
                      .setArguments(
                          ValueExpr.withValue(StringObjectValue.withValue("")), fixedValueVarExpr)
                      .setReturnType(FIXED_TYPESTORE.get("ImmutableMap"))
                      .build())
              .build());
      specialCtorBodyExprs.addAll(
          getTokenSet(processedTokenHierarchies).stream()
              .map(t -> assignTokenToNullExpr.apply(t))
              .collect(Collectors.toList()));

      javaMethods.add(
          MethodDefinition.constructorBuilder()
              .setScope(ScopeNode.PRIVATE)
              .setReturnType(thisClassType)
              .setArguments(Arrays.asList(fixedValueVarExpr.toBuilder().setIsDecl(true).build()))
              .setBody(
                  specialCtorBodyExprs.stream()
                      .map(e -> ExprStatement.withExpr(e))
                      .collect(Collectors.toList()))
              .build());
    }

    return javaMethods;
  }

  private static List<MethodDefinition> createTokenGetterMethods(
      Map<String, VariableExpr> patternTokenVarExprs, List<List<String>> tokenHierarchies) {
    // PubSub special-case handling.
    List<List<String>> processedTokenHierarchies =
        tokenHierarchies.stream()
            .filter(ts -> !ts.contains(ResourceNameConstants.DELETED_TOPIC_LITERAL))
            .collect(Collectors.toList());
    return getTokenSet(processedTokenHierarchies).stream()
        .map(
            t ->
                MethodDefinition.builder()
                    .setScope(ScopeNode.PUBLIC)
                    .setReturnType(TypeNode.STRING)
                    .setName(String.format("get%s", JavaStyle.toUpperCamelCase(t)))
                    .setReturnExpr(patternTokenVarExprs.get(t))
                    .build())
        .collect(Collectors.toList());
  }

  private static List<MethodDefinition> createBuilderCreatorMethods(
      ResourceName resourceName, List<List<String>> tokenHierarchies, TypeStore typeStore) {
    List<MethodDefinition> javaMethods = new ArrayList<>();
    String newMethodNameFormat = "new%s";

    // Create the newBuilder and variation methods here.
    // Variation example: newProjectLocationAutoscalingPolicyBuilder().
    for (int i = 0; i < tokenHierarchies.size(); i++) {
      // PubSub special-case handling.
      if (tokenHierarchies.get(i).contains(ResourceNameConstants.DELETED_TOPIC_LITERAL)) {
        continue;
      }

      final TypeNode returnType = getBuilderType(typeStore, tokenHierarchies, i);
      final Expr returnExpr = NewObjectExpr.withType(returnType);

      Function<String, MethodDefinition.Builder> methodDefStarterFn =
          methodName ->
              MethodDefinition.builder()
                  .setScope(ScopeNode.PUBLIC)
                  .setIsStatic(true)
                  .setReturnType(returnType)
                  .setName(methodName)
                  .setReturnExpr(returnExpr);

      String variantName = getBuilderTypeName(tokenHierarchies, i);
      javaMethods.add(
          methodDefStarterFn.apply(String.format(newMethodNameFormat, variantName)).build());
      if (i == 0 && tokenHierarchies.size() > 1) {
        // Create another builder creator method, but with the per-variant name.
        javaMethods.add(
            methodDefStarterFn
                .apply(
                    String.format(newMethodNameFormat, getBuilderTypeName(tokenHierarchies.get(i))))
                .build());
      }
    }

    // TODO(miraleung, v2): It seems weird that we currently generate a toBuilder method only for
    // the default class, and none for the Builder variants.
    TypeNode toBuilderReturnType = getBuilderType(typeStore, tokenHierarchies, 0);
    TypeNode thisClassType = typeStore.get(getThisClassName(resourceName));
    javaMethods.add(
        MethodDefinition.builder()
            .setScope(ScopeNode.PUBLIC)
            .setReturnType(toBuilderReturnType)
            .setName("toBuilder")
            .setReturnExpr(
                NewObjectExpr.builder()
                    .setType(toBuilderReturnType)
                    .setArguments(
                        Arrays.asList(ValueExpr.withValue(ThisObjectValue.withType(thisClassType))))
                    .build())
            .build());
    return javaMethods;
  }

  private static List<MethodDefinition> createOfCreatorMethods(
      ResourceName resourceName,
      Map<String, VariableExpr> patternTokenVarExprs,
      List<List<String>> tokenHierarchies,
      TypeStore typeStore) {
    return createOfOrFormatMethodHelper(
        resourceName,
        patternTokenVarExprs,
        tokenHierarchies,
        typeStore,
        /* isFormatMethod= */ false);
  }

  private static List<MethodDefinition> createFormatCreatorMethods(
      ResourceName resourceName,
      Map<String, VariableExpr> patternTokenVarExprs,
      List<List<String>> tokenHierarchies,
      TypeStore typeStore) {
    return createOfOrFormatMethodHelper(
        resourceName,
        patternTokenVarExprs,
        tokenHierarchies,
        typeStore,
        /* isFormatMethod= */ true);
  }

  private static List<MethodDefinition> createOfOrFormatMethodHelper(
      ResourceName resourceName,
      Map<String, VariableExpr> patternTokenVarExprs,
      List<List<String>> tokenHierarchies,
      TypeStore typeStore,
      boolean isFormatMethod) {
    List<MethodDefinition> javaMethods = new ArrayList<>();
    String methodNameFormat = isFormatMethod ? "format%s" : "of%s";
    String newBuilderMethodNameFormat = "new%s";
    String setMethodNameFormat = "set%s";
    String buildMethodName = "build";
    String toStringMethodName = "toString";

    TypeNode thisClassType = typeStore.get(getThisClassName(resourceName));
    TypeNode returnType = isFormatMethod ? TypeNode.STRING : thisClassType;
    // Create the newBuilder and variation methods here.
    // Variation example: newProjectLocationAutoscalingPolicyBuilder().
    boolean hasVariants = tokenHierarchies.size() > 1;
    for (int i = 0; i < tokenHierarchies.size(); i++) {
      List<String> tokens = tokenHierarchies.get(i);
      // PubSub special-case handling.
      if (tokens.contains(ResourceNameConstants.DELETED_TOPIC_LITERAL)) {
        Expr deletedTopicStringValExpr =
            ValueExpr.withValue(
                StringObjectValue.withValue(ResourceNameConstants.DELETED_TOPIC_LITERAL));
        // Simply return `new TopicName("_deleted-topic_")` or the string value itself.
        javaMethods.add(
            MethodDefinition.builder()
                .setScope(ScopeNode.PUBLIC)
                .setIsStatic(true)
                .setReturnType(returnType)
                .setName(
                    String.format(methodNameFormat, concatToUpperCamelCaseName(tokens) + "Name"))
                .setReturnExpr(
                    returnType.equals(TypeNode.STRING)
                        ? deletedTopicStringValExpr
                        : NewObjectExpr.builder()
                            .setType(returnType)
                            .setArguments(deletedTopicStringValExpr)
                            .build())
                .build());
        continue;
      }

      String builderMethodName =
          String.format(newBuilderMethodNameFormat, getBuilderTypeName(tokenHierarchies, i));

      MethodInvocationExpr returnExpr =
          MethodInvocationExpr.builder().setMethodName(builderMethodName).build();
      for (String token : tokens) {
        String javaTokenVarName = JavaStyle.toLowerCamelCase(token);
        returnExpr =
            MethodInvocationExpr.builder()
                .setExprReferenceExpr(returnExpr)
                .setMethodName(
                    String.format(setMethodNameFormat, JavaStyle.toUpperCamelCase(token)))
                .setArguments(
                    Arrays.asList(
                        VariableExpr.withVariable(
                            Variable.builder()
                                .setName(javaTokenVarName)
                                .setType(TypeNode.STRING)
                                .build())))
                .build();
      }
      returnExpr =
          MethodInvocationExpr.builder()
              .setExprReferenceExpr(returnExpr)
              .setMethodName(buildMethodName)
              .setReturnType(thisClassType)
              .build();
      if (isFormatMethod) {
        returnExpr =
            MethodInvocationExpr.builder()
                .setExprReferenceExpr(returnExpr)
                .setMethodName(toStringMethodName)
                .setReturnType(TypeNode.STRING)
                .build();
      }
      List<VariableExpr> methodArgs =
          tokens.stream()
              .map(t -> patternTokenVarExprs.get(t).toBuilder().setIsDecl(true).build())
              .collect(Collectors.toList());
      javaMethods.add(
          MethodDefinition.builder()
              .setScope(ScopeNode.PUBLIC)
              .setIsStatic(true)
              .setReturnType(returnType)
              .setName(
                  String.format(
                      methodNameFormat, i == 0 ? "" : concatToUpperCamelCaseName(tokens) + "Name"))
              .setArguments(methodArgs)
              .setReturnExpr(returnExpr)
              .build());

      if (i == 0 && hasVariants) {
        javaMethods.add(
            MethodDefinition.builder()
                .setScope(ScopeNode.PUBLIC)
                .setIsStatic(true)
                .setReturnType(returnType)
                .setName(
                    String.format(
                        methodNameFormat,
                        concatToUpperCamelCaseName(tokenHierarchies.get(i)) + "Name"))
                .setArguments(methodArgs)
                .setReturnExpr(returnExpr)
                .build());
      }
    }
    return javaMethods;
  }

  private static List<MethodDefinition> createParsingAndSplittingMethods(
      ResourceName resourceName,
      List<VariableExpr> templateFinalVarExprs,
      List<List<String>> tokenHierarchies,
      TypeStore typeStore) {
    List<MethodDefinition> javaMethods = new ArrayList<>();
    TypeNode thisClassType = typeStore.get(getThisClassName(resourceName));
    javaMethods.add(
        createParseMethod(thisClassType, templateFinalVarExprs, tokenHierarchies, typeStore));
    javaMethods.add(createParseListMethod(thisClassType));
    javaMethods.add(createToStringListMethod(thisClassType));
    javaMethods.add(createIsParseableFromMethod(templateFinalVarExprs));

    return javaMethods;
  }

  private static MethodDefinition createParseMethod(
      TypeNode thisClassType,
      List<VariableExpr> templateFinalVarExprs,
      List<List<String>> tokenHierarchies,
      TypeStore typeStore) {
    String formattedStringArgName = "formattedString";
    VariableExpr formattedStringArgExpr =
        VariableExpr.withVariable(
            Variable.builder().setName(formattedStringArgName).setType(TypeNode.STRING).build());
    String exceptionMessageString =
        String.format(
            "%s.parse: %s not in valid format",
            thisClassType.reference().name(), formattedStringArgName);

    ValueExpr exceptionMessageExpr =
        ValueExpr.withValue(StringObjectValue.withValue(exceptionMessageString));
    TypeNode mapStringType =
        TypeNode.withReference(
            ConcreteReference.builder()
                .setClazz(Map.class)
                .setGenerics(
                    Arrays.asList(
                        ConcreteReference.withClazz(String.class),
                        ConcreteReference.withClazz(String.class)))
                .build());
    VariableExpr matchMapVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setName("matchMap").setType(mapStringType).build());

    List<Statement> body = new ArrayList<>();
    body.add(
        IfStatement.builder()
            .setConditionExpr(
                MethodInvocationExpr.builder()
                    .setExprReferenceExpr(formattedStringArgExpr)
                    .setMethodName("isEmpty")
                    .setReturnType(TypeNode.BOOLEAN)
                    .build())
            .setBody(
                Arrays.asList(
                    ExprStatement.withExpr(ReturnExpr.withExpr(ValueExpr.createNullExpr()))))
            .build());

    List<Expr> formattedStringArgList = Arrays.asList(formattedStringArgExpr);
    List<VariableExpr> formattedStringArgDeclList =
        Arrays.asList(formattedStringArgExpr.toBuilder().setIsDecl(true).build());
    boolean hasVariants = tokenHierarchies.size() > 1;
    if (!hasVariants) {
      List<Expr> methodArgs = Arrays.asList(formattedStringArgExpr, exceptionMessageExpr);
      MethodInvocationExpr validatedMatchExpr =
          MethodInvocationExpr.builder()
              .setExprReferenceExpr(templateFinalVarExprs.get(0))
              .setMethodName("validatedMatch")
              .setArguments(methodArgs)
              .setReturnType(mapStringType)
              .build();

      AssignmentExpr matchMapAssignExpr =
          AssignmentExpr.builder()
              .setVariableExpr(matchMapVarExpr.toBuilder().setIsDecl(true).build())
              .setValueExpr(validatedMatchExpr)
              .build();
      body.add(ExprStatement.withExpr(matchMapAssignExpr));

      List<Expr> ofMethodArgExprs =
          tokenHierarchies.get(0).stream()
              .map(
                  t ->
                      MethodInvocationExpr.builder()
                          .setExprReferenceExpr(matchMapVarExpr)
                          .setMethodName("get")
                          .setArguments(
                              Arrays.asList(ValueExpr.withValue(StringObjectValue.withValue(t))))
                          .build())
              .collect(Collectors.toList());

      MethodInvocationExpr ofMethodExpr =
          MethodInvocationExpr.builder()
              .setMethodName("of")
              .setArguments(ofMethodArgExprs)
              .setReturnType(thisClassType)
              .build();
      return MethodDefinition.builder()
          .setScope(ScopeNode.PUBLIC)
          .setIsStatic(true)
          .setReturnType(thisClassType)
          .setName("parse")
          .setArguments(formattedStringArgDeclList)
          .setBody(body)
          .setReturnExpr(ofMethodExpr)
          .build();
    }

    IfStatement.Builder ifStatementBuilder = IfStatement.builder();
    String ofMethodNamePattern = "of%sName";
    for (int i = 0; i < tokenHierarchies.size(); i++) {
      // PubSub special-case handling for the "_deleted-topic_" pattern.
      boolean isDeletedTopicPattern =
          tokenHierarchies.get(i).contains(ResourceNameConstants.DELETED_TOPIC_LITERAL);

      VariableExpr templateVarExpr = templateFinalVarExprs.get(i);
      MethodInvocationExpr conditionExpr =
          MethodInvocationExpr.builder()
              .setExprReferenceExpr(templateVarExpr)
              .setMethodName(isDeletedTopicPattern ? "equals" : "matches")
              .setArguments(formattedStringArgList)
              .setReturnType(TypeNode.BOOLEAN)
              .build();

      MethodInvocationExpr matchValueExpr =
          MethodInvocationExpr.builder()
              .setExprReferenceExpr(templateVarExpr)
              .setMethodName("match")
              .setArguments(formattedStringArgList)
              .setReturnType(mapStringType)
              .build();
      AssignmentExpr matchMapAssignExpr =
          AssignmentExpr.builder()
              .setVariableExpr(matchMapVarExpr.toBuilder().setIsDecl(true).build())
              .setValueExpr(matchValueExpr)
              .build();

      List<String> tokens = tokenHierarchies.get(i);
      MethodInvocationExpr ofMethodExpr =
          MethodInvocationExpr.builder()
              .setMethodName(String.format(ofMethodNamePattern, concatToUpperCamelCaseName(tokens)))
              .setArguments(
                  tokens.stream()
                      .map(
                          t ->
                              MethodInvocationExpr.builder()
                                  .setExprReferenceExpr(matchMapVarExpr)
                                  .setMethodName("get")
                                  .setArguments(
                                      Arrays.asList(
                                          ValueExpr.withValue(StringObjectValue.withValue(t))))
                                  .build())
                      .collect(Collectors.toList()))
              .setReturnType(thisClassType)
              .build();

      ReturnExpr subReturnExpr = ReturnExpr.withExpr(ofMethodExpr);

      List<Statement> ifStatements =
          Arrays.asList(matchMapAssignExpr, subReturnExpr).stream()
              .map(e -> ExprStatement.withExpr(e))
              .collect(Collectors.toList());
      if (i == 0) {
        ifStatementBuilder =
            ifStatementBuilder.setConditionExpr(conditionExpr).setBody(ifStatements);
      } else {
        // PubSub special-case handling - clobber ifStatements if the current pattern is
        // _deleted-topic_.
        if (isDeletedTopicPattern) {
          ifStatements.clear();
          ifStatements.add(
              ExprStatement.withExpr(
                  ReturnExpr.withExpr(
                      NewObjectExpr.builder()
                          .setType(thisClassType)
                          .setArguments(
                              ValueExpr.withValue(
                                  StringObjectValue.withValue(
                                      ResourceNameConstants.DELETED_TOPIC_LITERAL)))
                          .build())));
        }
        ifStatementBuilder = ifStatementBuilder.addElseIf(conditionExpr, ifStatements);
      }
    }

    body.add(ifStatementBuilder.build());
    body.add(
        ExprStatement.withExpr(
            ThrowExpr.builder()
                .setType(FIXED_TYPESTORE.get("ValidationException"))
                .setMessageExpr(exceptionMessageString)
                .build()));
    return MethodDefinition.builder()
        .setScope(ScopeNode.PUBLIC)
        .setIsStatic(true)
        .setReturnType(thisClassType)
        .setName("parse")
        .setArguments(formattedStringArgDeclList)
        .setBody(body)
        .build();
  }

  private static MethodDefinition createParseListMethod(TypeNode thisClassType) {
    TypeNode listStringType =
        TypeNode.withReference(
            ConcreteReference.builder()
                .setClazz(List.class)
                .setGenerics(Arrays.asList(ConcreteReference.withClazz(String.class)))
                .build());
    TypeNode returnType =
        TypeNode.withReference(
            ConcreteReference.builder()
                .setClazz(List.class)
                .setGenerics(Arrays.asList(thisClassType.reference()))
                .build());

    VariableExpr formattedStringsVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setName("formattedStrings").setType(listStringType).build());
    VariableExpr listVarExpr =
        VariableExpr.withVariable(Variable.builder().setName("list").setType(returnType).build());

    AssignmentExpr listAssignExpr =
        AssignmentExpr.builder()
            .setVariableExpr(listVarExpr.toBuilder().setIsDecl(true).build())
            .setValueExpr(
                NewObjectExpr.builder()
                    .setType(
                        TypeNode.withReference(
                            ConcreteReference.builder().setClazz(ArrayList.class).build()))
                    .setIsGeneric(true)
                    .setArguments(
                        Arrays.asList(
                            MethodInvocationExpr.builder()
                                .setExprReferenceExpr(formattedStringsVarExpr)
                                .setMethodName("size")
                                .build()))
                    .build())
            .build();

    VariableExpr singleStrVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setName("formattedString").setType(TypeNode.STRING).build());
    ForStatement forStatement =
        ForStatement.builder()
            .setLocalVariableExpr(singleStrVarExpr.toBuilder().setIsDecl(true).build())
            .setCollectionExpr(formattedStringsVarExpr)
            .setBody(
                Arrays.asList(
                    ExprStatement.withExpr(
                        MethodInvocationExpr.builder()
                            .setExprReferenceExpr(listVarExpr)
                            .setMethodName("add")
                            .setArguments(
                                Arrays.asList(
                                    MethodInvocationExpr.builder()
                                        .setMethodName("parse")
                                        .setArguments(Arrays.asList(singleStrVarExpr))
                                        .build()))
                            .build())))
            .build();

    return MethodDefinition.builder()
        .setScope(ScopeNode.PUBLIC)
        .setIsStatic(true)
        .setReturnType(returnType)
        .setName("parseList")
        .setArguments(Arrays.asList(formattedStringsVarExpr.toBuilder().setIsDecl(true).build()))
        .setBody(Arrays.asList(ExprStatement.withExpr(listAssignExpr), forStatement))
        .setReturnExpr(listVarExpr)
        .build();
  }

  private static MethodDefinition createToStringListMethod(TypeNode thisClassType) {
    TypeNode listClassType =
        TypeNode.withReference(
            ConcreteReference.builder()
                .setClazz(List.class)
                .setGenerics(Arrays.asList(thisClassType.reference()))
                .build());
    VariableExpr valuesVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setName("values").setType(listClassType).build());

    TypeNode listStringType =
        TypeNode.withReference(
            ConcreteReference.builder()
                .setClazz(List.class)
                .setGenerics(Arrays.asList(ConcreteReference.withClazz(String.class)))
                .build());
    VariableExpr listVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setName("list").setType(listStringType).build());

    AssignmentExpr listAssignExpr =
        AssignmentExpr.builder()
            .setVariableExpr(listVarExpr.toBuilder().setIsDecl(true).build())
            .setValueExpr(
                NewObjectExpr.builder()
                    .setType(TypeNode.withReference(ConcreteReference.withClazz(ArrayList.class)))
                    .setIsGeneric(true)
                    .setArguments(
                        Arrays.asList(
                            MethodInvocationExpr.builder()
                                .setExprReferenceExpr(valuesVarExpr)
                                .setMethodName("size")
                                .build()))
                    .build())
            .build();

    VariableExpr valueVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setName("value").setType(thisClassType).build());
    // We use an equality check instead of Objects.isNull() for Java 7 compatibility.
    Expr isNullCheck =
        RelationalOperationExpr.equalToWithExprs(valueVarExpr, ValueExpr.createNullExpr());
    Statement listAddEmptyStringStatement =
        ExprStatement.withExpr(
            MethodInvocationExpr.builder()
                .setExprReferenceExpr(listVarExpr)
                .setMethodName("add")
                .setArguments(Arrays.asList(ValueExpr.withValue(StringObjectValue.withValue(""))))
                .build());

    Statement listAddValueStatement =
        ExprStatement.withExpr(
            MethodInvocationExpr.builder()
                .setExprReferenceExpr(listVarExpr)
                .setMethodName("add")
                .setArguments(
                    Arrays.asList(
                        MethodInvocationExpr.builder()
                            .setExprReferenceExpr(valueVarExpr)
                            .setMethodName("toString")
                            .build()))
                .build());

    IfStatement ifStatement =
        IfStatement.builder()
            .setConditionExpr(isNullCheck)
            .setBody(Arrays.asList(listAddEmptyStringStatement))
            .setElseBody(Arrays.asList(listAddValueStatement))
            .build();
    ForStatement forStatement =
        ForStatement.builder()
            .setLocalVariableExpr(valueVarExpr.toBuilder().setIsDecl(true).build())
            .setCollectionExpr(valuesVarExpr)
            .setBody(Arrays.asList(ifStatement))
            .build();

    return MethodDefinition.builder()
        .setScope(ScopeNode.PUBLIC)
        .setIsStatic(true)
        .setReturnType(listStringType)
        .setName("toStringList")
        .setArguments(Arrays.asList(valuesVarExpr.toBuilder().setIsDecl(true).build()))
        .setBody(Arrays.asList(ExprStatement.withExpr(listAssignExpr), forStatement))
        .setReturnExpr(listVarExpr)
        .build();
  }

  private static MethodDefinition createIsParseableFromMethod(
      List<VariableExpr> templateFinalVarExprs) {
    VariableExpr formattedStringVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setName("formattedString").setType(TypeNode.STRING).build());
    Expr returnOrExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(templateFinalVarExprs.get(0))
            .setMethodName("matches")
            .setArguments(Arrays.asList(formattedStringVarExpr))
            .setReturnType(TypeNode.BOOLEAN)
            .build();
    for (int i = 1; i < templateFinalVarExprs.size(); i++) {
      VariableExpr templateVarExpr = templateFinalVarExprs.get(i);
      returnOrExpr =
          LogicalOperationExpr.logicalOrWithExprs(
              returnOrExpr,
              MethodInvocationExpr.builder()
                  .setExprReferenceExpr(templateVarExpr)
                  .setMethodName(
                      // PubSub special-case handling for the _deleted-topic_ pattern.
                      templateVarExpr.variable().identifier().name().equals("DELETED_TOPIC")
                          ? "equals"
                          : "matches")
                  .setArguments(Arrays.asList(formattedStringVarExpr))
                  .setReturnType(TypeNode.BOOLEAN)
                  .build());
    }

    return MethodDefinition.builder()
        .setScope(ScopeNode.PUBLIC)
        .setIsStatic(true)
        .setReturnType(TypeNode.BOOLEAN)
        .setName("isParsableFrom")
        .setArguments(Arrays.asList(formattedStringVarExpr.toBuilder().setIsDecl(true).build()))
        .setReturnExpr(returnOrExpr)
        .build();
  }

  private static List<MethodDefinition> createFieldValueGetterMethods(
      ResourceName resourceName,
      Map<String, VariableExpr> patternTokenVarExprs,
      List<List<String>> tokenHierarchies,
      TypeStore typeStore) {
    List<MethodDefinition> javaMethods = new ArrayList<>();
    TypeNode thisClassType = typeStore.get(getThisClassName(resourceName));
    javaMethods.add(
        createGetFieldValuesMapMethod(
            resourceName, thisClassType, patternTokenVarExprs, tokenHierarchies));
    javaMethods.add(createGetFieldValueMethod());
    return javaMethods;
  }

  private static MethodDefinition createGetFieldValuesMapMethod(
      ResourceName resourceName,
      TypeNode thisClassType,
      Map<String, VariableExpr> patternTokenVarExprs,
      List<List<String>> tokenHierarchies) {

    Reference strRef = TypeNode.STRING.reference();
    TypeNode mapBuilderType =
        TypeNode.withReference(
            ConcreteReference.builder()
                .setClazz(ImmutableMap.Builder.class)
                .setGenerics(Arrays.asList(strRef, strRef))
                .build());
    VariableExpr fieldMapBuilderVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setName("fieldMapBuilder").setType(mapBuilderType).build());

    AssignmentExpr builderAssignExpr =
        AssignmentExpr.builder()
            .setVariableExpr(fieldMapBuilderVarExpr.toBuilder().setIsDecl(true).build())
            .setValueExpr(
                MethodInvocationExpr.builder()
                    .setStaticReferenceType(FIXED_TYPESTORE.get("ImmutableMap"))
                    .setMethodName("builder")
                    .setReturnType(mapBuilderType)
                    .build())
            .build();

    // Special-cased PubSub handling.
    List<List<String>> processedTokenHierarchies =
        tokenHierarchies.stream()
            .filter(tokens -> !tokens.contains(ResourceNameConstants.DELETED_TOPIC_LITERAL))
            .collect(Collectors.toList());

    // Innermost if-blocks.
    List<Statement> tokenIfStatements = new ArrayList<>();
    for (String token : getTokenSet(processedTokenHierarchies)) {
      VariableExpr tokenVarExpr = patternTokenVarExprs.get(token);
      Preconditions.checkNotNull(
          tokenVarExpr,
          String.format("No variable found for %s among %s", token, patternTokenVarExprs.keySet()));
      StringObjectValue tokenStrVal = StringObjectValue.withValue(token);
      MethodInvocationExpr putExpr =
          MethodInvocationExpr.builder()
              .setExprReferenceExpr(fieldMapBuilderVarExpr)
              .setMethodName("put")
              .setArguments(ValueExpr.withValue(tokenStrVal), tokenVarExpr)
              .build();
      Expr notNullCheckExpr =
          RelationalOperationExpr.notEqualToWithExprs(tokenVarExpr, ValueExpr.createNullExpr());
      tokenIfStatements.add(
          IfStatement.builder()
              .setConditionExpr(notNullCheckExpr)
              .setBody(Arrays.asList(ExprStatement.withExpr(putExpr)))
              .build());
    }

    // Put the innermost if-statements and assignment expressions together.
    VariableExpr fieldValuesMapVarExpr = FIXED_CLASS_VARS.get("fieldValuesMap");
    AssignmentExpr fieldValuesMapAssignExpr =
        AssignmentExpr.builder()
            .setVariableExpr(fieldValuesMapVarExpr)
            .setValueExpr(
                MethodInvocationExpr.builder()
                    .setExprReferenceExpr(fieldMapBuilderVarExpr)
                    .setMethodName("build")
                    .setReturnType(fieldValuesMapVarExpr.type())
                    .build())
            .build();

    List<Statement> middleIfBlockStatements = new ArrayList<>();
    middleIfBlockStatements.add(ExprStatement.withExpr(builderAssignExpr));
    middleIfBlockStatements.addAll(tokenIfStatements);
    middleIfBlockStatements.add(ExprStatement.withExpr(fieldValuesMapAssignExpr));

    // Middle if-block, i.e. `if (fieldValuesMap == null)`.
    Expr fieldValuesMapNullCheckExpr =
        RelationalOperationExpr.equalToWithExprs(fieldValuesMapVarExpr, ValueExpr.createNullExpr());
    IfStatement fieldValuesMapIfStatement =
        IfStatement.builder()
            .setConditionExpr(fieldValuesMapNullCheckExpr)
            .setBody(middleIfBlockStatements)
            .build();

    // Outer if-block.
    IfStatement outerIfStatement =
        IfStatement.builder()
            .setConditionExpr(fieldValuesMapNullCheckExpr)
            .setBody(
                Arrays.asList(
                    SynchronizedStatement.builder()
                        .setLock(ThisObjectValue.withType(thisClassType))
                        .setBody(Arrays.asList(fieldValuesMapIfStatement))
                        .build()))
            .build();

    // Put the method together.
    TypeNode mapStringType = fieldValuesMapVarExpr.type();
    return MethodDefinition.builder()
        .setIsOverride(true)
        .setScope(ScopeNode.PUBLIC)
        .setReturnType(mapStringType)
        .setName("getFieldValuesMap")
        .setBody(Arrays.asList(outerIfStatement))
        .setReturnExpr(fieldValuesMapVarExpr)
        .build();
  }

  private static MethodDefinition createGetFieldValueMethod() {
    VariableExpr fieldNameVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setName("fieldName").setType(TypeNode.STRING).build());
    MethodInvocationExpr returnExpr =
        MethodInvocationExpr.builder().setMethodName("getFieldValuesMap").build();
    returnExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(returnExpr)
            .setMethodName("get")
            .setArguments(fieldNameVarExpr)
            .setReturnType(TypeNode.STRING)
            .build();
    return MethodDefinition.builder()
        .setScope(ScopeNode.PUBLIC)
        .setReturnType(TypeNode.STRING)
        .setName("getFieldValue")
        .setArguments(fieldNameVarExpr.toBuilder().setIsDecl(true).build())
        .setReturnExpr(returnExpr)
        .build();
  }

  private static MethodDefinition createToStringMethod(
      List<VariableExpr> templateFinalVarExprs,
      Map<String, VariableExpr> patternTokenVarExprs,
      List<List<String>> tokenHierarchies) {
    boolean hasVariants = tokenHierarchies.size() > 1;
    if (!hasVariants) {

      List<Expr> instantiateArgExprs = new ArrayList<>();
      List<String> tokens = getTokenSet(tokenHierarchies).stream().collect(Collectors.toList());
      for (String token : tokens) {
        Preconditions.checkNotNull(
            patternTokenVarExprs.get(token),
            String.format(
                "No expression found for token %s amongst values %s",
                token, patternTokenVarExprs.toString()));
        instantiateArgExprs.add(ValueExpr.withValue(StringObjectValue.withValue(token)));
        instantiateArgExprs.add(patternTokenVarExprs.get(token));
      }

      MethodInvocationExpr returnInstantiateExpr =
          MethodInvocationExpr.builder()
              .setExprReferenceExpr(templateFinalVarExprs.get(0))
              .setMethodName("instantiate")
              .setArguments(instantiateArgExprs)
              .setReturnType(TypeNode.STRING)
              .build();
      return MethodDefinition.builder()
          .setIsOverride(true)
          .setScope(ScopeNode.PUBLIC)
          .setReturnType(TypeNode.STRING)
          .setName("toString")
          .setReturnExpr(returnInstantiateExpr)
          .build();
    }

    VariableExpr fixedValueVarExpr = FIXED_CLASS_VARS.get("fixedValue");
    // Code:  return fixedValue != null ? fixedValue : pathTemplate.instantiate(getFieldValuesMap())
    Expr fixedValueNullCheck =
        RelationalOperationExpr.notEqualToWithExprs(fixedValueVarExpr, ValueExpr.createNullExpr());

    MethodInvocationExpr instantiateExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(FIXED_CLASS_VARS.get("pathTemplate"))
            .setMethodName("instantiate")
            .setArguments(MethodInvocationExpr.builder().setMethodName("getFieldValuesMap").build())
            .setReturnType(TypeNode.STRING)
            .build();

    TernaryExpr returnExpr =
        TernaryExpr.builder()
            .setConditionExpr(fixedValueNullCheck)
            .setElseExpr(instantiateExpr)
            .setThenExpr(fixedValueVarExpr)
            .build();

    return MethodDefinition.builder()
        .setIsOverride(true)
        .setScope(ScopeNode.PUBLIC)
        .setReturnType(TypeNode.STRING)
        .setName("toString")
        .setReturnExpr(returnExpr)
        .build();
  }

  private static MethodDefinition createEqualsMethod(
      ResourceName resourceName, List<List<String>> tokenHierarchies, TypeStore typeStore) {
    // Create method definition variables.
    Variable oVariable =
        Variable.builder()
            .setType(TypeNode.withReference(javaObjectReference))
            .setName("o")
            .build();
    VariableExpr argVarExpr =
        VariableExpr.builder().setIsDecl(false).setVariable(oVariable).build();
    TypeNode thisClassType = typeStore.get(getThisClassName(resourceName));
    ValueExpr thisValueExpr = ValueExpr.withValue(ThisObjectValue.withType(thisClassType));
    ValueExpr trueValueExpr =
        ValueExpr.withValue(
            PrimitiveValue.builder().setType(TypeNode.BOOLEAN).setValue("true").build());

    // Create first if statement's return expression
    ReturnExpr returnTrueExpr = ReturnExpr.withExpr(trueValueExpr);

    // Create second if statement's condition expression
    RelationalOperationExpr oEqualsThisExpr =
        RelationalOperationExpr.equalToWithExprs(argVarExpr, thisValueExpr);
    RelationalOperationExpr oNotEqualsNullExpr =
        RelationalOperationExpr.notEqualToWithExprs(argVarExpr, ValueExpr.createNullExpr());
    MethodInvocationExpr getClassMethodInvocationExpr =
        MethodInvocationExpr.builder().setMethodName("getClass").build();
    RelationalOperationExpr getClassEqualsExpr =
        RelationalOperationExpr.equalToWithExprs(
            getClassMethodInvocationExpr,
            getClassMethodInvocationExpr.toBuilder().setExprReferenceExpr(argVarExpr).build());
    LogicalOperationExpr andLogicalExpr =
        LogicalOperationExpr.logicalAndWithExprs(oNotEqualsNullExpr, getClassEqualsExpr);

    // Create second if statement's body assignment expression.
    Variable thatVariable = Variable.builder().setName("that").setType(thisClassType).build();
    VariableExpr thatVariableExpr =
        VariableExpr.builder().setIsDecl(false).setVariable(thatVariable).build();
    CastExpr oCastExpr = CastExpr.builder().setExpr(argVarExpr).setType(thisClassType).build();
    AssignmentExpr thatAssignmentExpr =
        AssignmentExpr.builder()
            .setVariableExpr(thatVariableExpr.toBuilder().setIsDecl(true).build())
            .setValueExpr(oCastExpr)
            .build();

    // PubSub special-case handling - exclude _deleted-topic_.
    List<List<String>> processedTokenHierarchies =
        tokenHierarchies.stream()
            .filter(ts -> !ts.contains(ResourceNameConstants.DELETED_TOPIC_LITERAL))
            .collect(Collectors.toList());

    // Create return expression in the second if statement's body.
    Set<String> tokenSet = getTokenSet(processedTokenHierarchies);
    Iterator<String> itToken = tokenSet.iterator();
    Expr curTokenExpr =
        createObjectsEqualsForTokenMethodExpr(
            thisValueExpr,
            thatVariableExpr,
            Variable.builder()
                .setType(TypeNode.STRING)
                .setName(JavaStyle.toLowerCamelCase(itToken.next()))
                .build());
    while (itToken.hasNext()) {
      Expr nextTokenExpr =
          createObjectsEqualsForTokenMethodExpr(
              thisValueExpr,
              thatVariableExpr,
              Variable.builder()
                  .setType(TypeNode.STRING)
                  .setName(JavaStyle.toLowerCamelCase(itToken.next()))
                  .build());
      curTokenExpr = LogicalOperationExpr.logicalAndWithExprs(curTokenExpr, nextTokenExpr);
    }
    ReturnExpr secondIfReturnExpr = ReturnExpr.withExpr(curTokenExpr);

    // Code: if (o == this) { return true;}
    IfStatement firstIfStatement =
        IfStatement.builder()
            .setConditionExpr(oEqualsThisExpr)
            .setBody(Arrays.asList(ExprStatement.withExpr(returnTrueExpr)))
            .build();
    // Code: if (o != null && getClass() == o.getClass()) { FoobarName that = ((FoobarName) o);
    // return ..}
    IfStatement secondIfStatement =
        IfStatement.builder()
            .setConditionExpr(andLogicalExpr)
            .setBody(
                Arrays.asList(
                    ExprStatement.withExpr(thatAssignmentExpr),
                    ExprStatement.withExpr(secondIfReturnExpr)))
            .build();

    // Create method's return expression.
    ValueExpr falseValueExpr =
        ValueExpr.withValue(
            PrimitiveValue.builder().setType(TypeNode.BOOLEAN).setValue("false").build());

    return MethodDefinition.builder()
        .setIsOverride(true)
        .setScope(ScopeNode.PUBLIC)
        .setArguments(argVarExpr.toBuilder().setIsDecl(true).build())
        .setReturnType(TypeNode.BOOLEAN)
        .setName("equals")
        .setReturnExpr(falseValueExpr)
        .setBody(Arrays.asList(firstIfStatement, secondIfStatement))
        .build();
  }

  private static MethodInvocationExpr createObjectsEqualsForTokenMethodExpr(
      Expr thisExpr, Expr thatExpr, Variable tokenVar) {
    VariableExpr varThisExpr =
        VariableExpr.builder().setVariable(tokenVar).setExprReferenceExpr(thisExpr).build();
    VariableExpr varThatExpr =
        VariableExpr.builder().setVariable(tokenVar).setExprReferenceExpr(thatExpr).build();
    return MethodInvocationExpr.builder()
        .setStaticReferenceType(FIXED_TYPESTORE.get("Objects"))
        .setMethodName("equals")
        .setArguments(Arrays.asList(varThisExpr, varThatExpr))
        .setReturnType(TypeNode.BOOLEAN)
        .build();
  }

  private static MethodDefinition createHashCodeMethod(List<List<String>> tokenHierarchies) {
    List<Statement> assignmentBody = new ArrayList<>();
    // code: int h = 1;
    Variable hVar = Variable.builder().setType(TypeNode.INT).setName("h").build();
    VariableExpr hVarExpr = VariableExpr.builder().setVariable(hVar).build();
    ValueExpr hValueExpr =
        ValueExpr.withValue(PrimitiveValue.builder().setType(TypeNode.INT).setValue("1").build());
    AssignmentExpr hAssignmentExpr =
        AssignmentExpr.builder()
            .setVariableExpr(hVarExpr.toBuilder().setIsDecl(true).build())
            .setValueExpr(hValueExpr)
            .build();
    assignmentBody.add(ExprStatement.withExpr(hAssignmentExpr));
    // code: h *= 1000003;
    // code: h ^= Objects.hashCode(...);
    ValueExpr numValueExpr =
        ValueExpr.withValue(
            PrimitiveValue.builder().setType(TypeNode.INT).setValue("1000003").build());
    AssignmentOperationExpr multiplyAssignmentOpExpr =
        AssignmentOperationExpr.multiplyAssignmentWithExprs(hVarExpr, numValueExpr);

    // PubSub special-case handling - exclude _deleted-topic_.
    List<List<String>> processedTokenHierarchies =
        tokenHierarchies.stream()
            .filter(ts -> !ts.contains(ResourceNameConstants.DELETED_TOPIC_LITERAL))
            .collect(Collectors.toList());

    // If it has variants, add the multiply and xor assignment operation exprs for fixedValue.
    boolean hasVariants = processedTokenHierarchies.size() > 1;
    if (hasVariants) {
      VariableExpr fixedValueVarExpr = FIXED_CLASS_VARS.get("fixedValue");
      assignmentBody.add(ExprStatement.withExpr(multiplyAssignmentOpExpr));
      assignmentBody.add(
          ExprStatement.withExpr(
              AssignmentOperationExpr.xorAssignmentWithExprs(
                  hVarExpr, createObjectsHashCodeForVarMethod(fixedValueVarExpr))));
    }
    // Add the multiply and xor assignment operation exprs for tokens.
    Set<String> tokenSet = getTokenSet(processedTokenHierarchies);
    tokenSet.stream()
        .forEach(
            token -> {
              VariableExpr tokenVarExpr =
                  VariableExpr.withVariable(
                      Variable.builder()
                          .setName(JavaStyle.toLowerCamelCase(token))
                          .setType(TypeNode.STRING)
                          .build());
              assignmentBody.add(ExprStatement.withExpr(multiplyAssignmentOpExpr));
              assignmentBody.add(
                  ExprStatement.withExpr(
                      AssignmentOperationExpr.xorAssignmentWithExprs(
                          hVarExpr, createObjectsHashCodeForVarMethod(tokenVarExpr))));
            });

    return MethodDefinition.builder()
        .setIsOverride(true)
        .setScope(ScopeNode.PUBLIC)
        .setReturnType(TypeNode.INT)
        .setName("hashCode")
        .setBody(assignmentBody)
        .setReturnExpr(hVarExpr)
        .build();
  }

  private static MethodInvocationExpr createObjectsHashCodeForVarMethod(VariableExpr varExpr) {
    // code: Objects.hashCode(varExpr)
    return MethodInvocationExpr.builder()
        .setMethodName("hashCode")
        .setStaticReferenceType(FIXED_TYPESTORE.get("Objects"))
        .setArguments(varExpr)
        .setReturnType(TypeNode.INT)
        .build();
  }

  private static List<ClassDefinition> createNestedBuilderClasses(
      ResourceName resourceName,
      List<List<String>> tokenHierarchies,
      List<VariableExpr> templateFinalVarExprs,
      TypeStore typeStore) {
    String thisClassName = getThisClassName(resourceName);
    TypeNode outerThisClassType = typeStore.get(thisClassName);
    boolean hasVariants = tokenHierarchies.size() > 1;
    List<ClassDefinition> nestedClasses = new ArrayList<>();
    for (int i = 0; i < tokenHierarchies.size(); i++) {
      List<String> tokens = tokenHierarchies.get(i);
      // PubSub special-case handling.
      if (tokens.contains(ResourceNameConstants.DELETED_TOPIC_LITERAL)) {
        continue;
      }
      nestedClasses.add(
          createNestedBuilderClass(
              outerThisClassType,
              tokens,
              templateFinalVarExprs.get(i),
              resourceName.patterns().get(i),
              typeStore,
              hasVariants,
              i == 0));
    }
    return nestedClasses;
  }

  private static ClassDefinition createNestedBuilderClass(
      TypeNode outerClassType,
      List<String> tokens,
      VariableExpr templateFinalVarExpr,
      String resourceNamePattern,
      TypeStore typeStore,
      boolean hasVariants,
      boolean isDefaultClass) {
    String className = isDefaultClass ? "Builder" : getBuilderTypeName(tokens);
    // Class member declarations.
    List<VariableExpr> classMemberVarExprs =
        tokens.stream()
            .map(
                t ->
                    VariableExpr.withVariable(
                        Variable.builder()
                            .setName(JavaStyle.toLowerCamelCase(t))
                            .setType(TypeNode.STRING)
                            .build()))
            .collect(Collectors.toList());
    List<Statement> classMemberDecls =
        classMemberVarExprs.stream()
            .map(
                v ->
                    ExprStatement.withExpr(
                        v.toBuilder().setIsDecl(true).setScope(ScopeNode.PRIVATE).build()))
            .collect(Collectors.toList());

    // Constructor.
    List<MethodDefinition> nestedClassMethods = new ArrayList<>();
    TypeNode thisClassType = typeStore.get(className);
    MethodDefinition ctor =
        MethodDefinition.constructorBuilder()
            .setScope(ScopeNode.PROTECTED)
            .setReturnType(thisClassType)
            .build();
    nestedClassMethods.add(ctor);

    // Getters and setters.
    List<MethodDefinition> getterMethods = new ArrayList<>();
    List<MethodDefinition> setterMethods = new ArrayList<>();
    ValueExpr thisExpr = ValueExpr.withValue(ThisObjectValue.withType(thisClassType));
    for (int i = 0; i < tokens.size(); i++) {
      String token = tokens.get(i);
      String upperCamelTokenName = JavaStyle.toUpperCamelCase(token);
      VariableExpr currClassTokenVarExpr = classMemberVarExprs.get(i);

      // Getter.
      MethodDefinition getterMethod =
          MethodDefinition.builder()
              .setScope(ScopeNode.PUBLIC)
              .setReturnType(TypeNode.STRING)
              .setName(String.format("get%s", upperCamelTokenName))
              .setReturnExpr(currClassTokenVarExpr)
              .build();
      getterMethods.add(getterMethod);

      // Setter.
      VariableExpr tokenArgVarExpr = currClassTokenVarExpr;
      AssignmentExpr fieldAssignExpr =
          AssignmentExpr.builder()
              .setVariableExpr(
                  currClassTokenVarExpr.toBuilder().setExprReferenceExpr(thisExpr).build())
              .setValueExpr(tokenArgVarExpr)
              .build();
      MethodDefinition setterMethod =
          MethodDefinition.builder()
              .setScope(ScopeNode.PUBLIC)
              .setReturnType(thisClassType)
              .setName(String.format("set%s", upperCamelTokenName))
              .setArguments(classMemberVarExprs.get(i).toBuilder().setIsDecl(true).build())
              .setBody(Arrays.asList(ExprStatement.withExpr(fieldAssignExpr)))
              .setReturnExpr(thisExpr)
              .build();
      setterMethods.add(setterMethod);
    }

    nestedClassMethods.addAll(getterMethods);
    nestedClassMethods.addAll(setterMethods);

    // Private builder constructor method.
    if (isDefaultClass) {
      VariableExpr outerClassVarExpr =
          VariableExpr.withVariable(
              Variable.builder()
                  .setName(JavaStyle.toLowerCamelCase(outerClassType.reference().name()))
                  .setType(outerClassType)
                  .build());
      List<Expr> builderCtorBodyExprs = new ArrayList<>();

      if (hasVariants) {
        // TODO(miraleung): Use eq operator instead.
        MethodInvocationExpr equalsCheckExpr =
            MethodInvocationExpr.builder()
                .setStaticReferenceType(FIXED_TYPESTORE.get("Objects"))
                .setMethodName("equals")
                .setArguments(
                    FIXED_CLASS_VARS.get("pathTemplate").toBuilder()
                        .setExprReferenceExpr(outerClassVarExpr)
                        .build(),
                    templateFinalVarExpr)
                .build();

        builderCtorBodyExprs.add(
            MethodInvocationExpr.builder()
                .setStaticReferenceType(FIXED_TYPESTORE.get("Preconditions"))
                .setMethodName("checkArgument")
                .setArguments(
                    equalsCheckExpr,
                    ValueExpr.withValue(
                        StringObjectValue.withValue(
                            String.format(
                                "toBuilder is only supported when %s has the pattern of %s",
                                outerClassType.reference().name(), resourceNamePattern))))
                .build());
      }

      for (VariableExpr memberVarExpr : classMemberVarExprs) {
        VariableExpr currClassTokenVarExpr =
            memberVarExpr.toBuilder().setExprReferenceExpr(thisExpr).build();
        builderCtorBodyExprs.add(
            AssignmentExpr.builder()
                .setVariableExpr(currClassTokenVarExpr)
                .setValueExpr(
                    currClassTokenVarExpr.toBuilder()
                        .setExprReferenceExpr(outerClassVarExpr)
                        .build())
                .build());
      }

      MethodDefinition fromOuterTypeCtor =
          MethodDefinition.constructorBuilder()
              .setScope(ScopeNode.PRIVATE)
              .setReturnType(thisClassType)
              .setArguments(outerClassVarExpr.toBuilder().setIsDecl(true).build())
              .setBody(
                  builderCtorBodyExprs.stream()
                      .map(e -> ExprStatement.withExpr(e))
                      .collect(Collectors.toList()))
              .build();
      nestedClassMethods.add(fromOuterTypeCtor);
    }

    // Last build() method.
    MethodDefinition buildMethod =
        MethodDefinition.builder()
            .setScope(ScopeNode.PUBLIC)
            .setReturnType(outerClassType)
            .setName("build")
            .setReturnExpr(
                NewObjectExpr.builder().setType(outerClassType).setArguments(thisExpr).build())
            .build();
    nestedClassMethods.add(buildMethod);

    // Return the class.

    return ClassDefinition.builder()
        .setHeaderCommentStatements(
            CommentStatement.withComment(
                JavaDocComment.withComment(
                    String.format(BUILDER_CLASS_HEADER_PATTERN, resourceNamePattern))))
        .setIsNested(true)
        .setScope(ScopeNode.PUBLIC)
        .setIsStatic(true)
        .setName(className)
        .setStatements(classMemberDecls)
        .setMethods(nestedClassMethods)
        .build();
  }

  private static TypeStore createStaticTypes() {
    List<Class<?>> concreteClazzes =
        Arrays.asList(
            ArrayList.class,
            Generated.class,
            ImmutableMap.class,
            List.class,
            Map.class,
            Objects.class,
            PathTemplate.class,
            Preconditions.class,
            com.google.api.resourcenames.ResourceName.class,
            ValidationException.class);
    return new TypeStore(concreteClazzes);
  }

  private static TypeStore createDynamicTypes(
      ResourceName resourceName, List<List<String>> tokenHierarchies) {
    String thisClassName = getThisClassName(resourceName);
    TypeStore typeStore = new TypeStore();
    typeStore.put(resourceName.pakkage(), thisClassName);
    typeStore.put(resourceName.pakkage(), "Builder", true, thisClassName);

    // Special-cased PubSub handling.
    List<List<String>> processedTokenHierarchies =
        tokenHierarchies.stream()
            .filter(tokens -> !tokens.contains(ResourceNameConstants.DELETED_TOPIC_LITERAL))
            .collect(Collectors.toList());

    if (processedTokenHierarchies.size() > 1) {
      typeStore.putAll(
          resourceName.pakkage(),
          tokenHierarchies.subList(1, tokenHierarchies.size()).stream()
              .map(ts -> getBuilderTypeName(ts))
              .collect(Collectors.toList()));
    }
    return typeStore;
  }

  private static Map<String, VariableExpr> createFixedClassMemberVariables() {
    Map<String, TypeNode> memberVars = new HashMap<>();
    Reference stringRef = ConcreteReference.withClazz(String.class);
    memberVars.put(
        "fieldValuesMap",
        TypeNode.withReference(
            ConcreteReference.builder()
                .setClazz(Map.class)
                .setGenerics(Arrays.asList(stringRef, stringRef))
                .build()));
    memberVars.put(
        "pathTemplate", TypeNode.withReference(ConcreteReference.withClazz(PathTemplate.class)));
    memberVars.put("fixedValue", TypeNode.STRING);
    return memberVars.entrySet().stream()
        .map(e -> Variable.builder().setName(e.getKey()).setType(e.getValue()).build())
        .collect(Collectors.toMap(v -> v.identifier().name(), v -> VariableExpr.withVariable(v)));
  }

  private static String getThisClassName(ResourceName resourceName) {
    return String.format(
        CLASS_NAME_PATTERN, JavaStyle.toUpperCamelCase(resourceName.resourceTypeName()));
  }

  private static String getBuilderTypeName(List<List<String>> tokenHierarchies, int index) {
    return index == 0 ? "Builder" : getBuilderTypeName(tokenHierarchies.get(index));
  }

  private static String getBuilderTypeName(List<String> tokens) {
    return String.format("%sBuilder", concatToUpperCamelCaseName(tokens));
  }

  private static TypeNode getBuilderType(
      TypeStore typeStore, List<List<String>> tokenHierarchies, int index) {
    return index == 0
        ? typeStore.get("Builder")
        : typeStore.get(getBuilderTypeName(tokenHierarchies, index));
  }

  @VisibleForTesting
  static Set<String> getTokenSet(List<List<String>> tokenHierarchy) {
    return tokenHierarchy.stream()
        .flatMap(tokens -> tokens.stream())
        .collect(Collectors.toCollection(LinkedHashSet::new));
  }

  @VisibleForTesting
  static String concatToUpperSnakeCaseName(List<String> tokens) {
    // Tokens are currently in lower_snake_case space.
    return JavaStyle.toUpperSnakeCase(tokens.stream().collect(Collectors.joining("_")));
  }

  @VisibleForTesting
  static String concatToUpperCamelCaseName(List<String> tokens) {
    // Tokens are currently in lower_snake_case space.
    return JavaStyle.toUpperCamelCase(tokens.stream().collect(Collectors.joining("_")));
  }
}
