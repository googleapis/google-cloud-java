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

import com.google.api.generator.engine.ast.AssignmentExpr;
import com.google.api.generator.engine.ast.ConcreteReference;
import com.google.api.generator.engine.ast.ExprStatement;
import com.google.api.generator.engine.ast.MethodInvocationExpr;
import com.google.api.generator.engine.ast.PrimitiveValue;
import com.google.api.generator.engine.ast.Statement;
import com.google.api.generator.engine.ast.TypeNode;
import com.google.api.generator.engine.ast.ValueExpr;
import com.google.api.generator.engine.ast.VaporReference;
import com.google.api.generator.engine.ast.Variable;
import com.google.api.generator.engine.ast.VariableExpr;
import com.google.api.generator.gapic.model.RegionTag;
import com.google.api.generator.gapic.model.Sample;
import com.google.api.generator.gapic.utils.JavaStyle;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public final class SettingsSampleComposer {

  public static Optional<Sample> composeSettingsSample(
      Optional<String> methodNameOpt, String settingsClassName, TypeNode classType) {
    if (!methodNameOpt.isPresent()) {
      return Optional.empty();
    }

    // Initialize services settingsBuilder with newBuilder()
    // e.g. FoobarSettings.Builder foobarSettingsBuilder = FoobarSettings.newBuilder();
    TypeNode builderType =
        TypeNode.withReference(
            VaporReference.builder()
                .setEnclosingClassNames(classType.reference().name())
                .setName("Builder")
                .setPakkage(classType.reference().pakkage())
                .build());
    VariableExpr localSettingsVarExpr =
        VariableExpr.withVariable(
            Variable.builder()
                .setName(JavaStyle.toLowerCamelCase(String.format("%sBuilder", settingsClassName)))
                .setType(builderType)
                .build());
    MethodInvocationExpr settingsBuilderMethodInvocationExpr =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(classType)
            .setMethodName("newBuilder")
            .setReturnType(builderType)
            .build();
    AssignmentExpr initLocalSettingsExpr =
        AssignmentExpr.builder()
            .setVariableExpr(localSettingsVarExpr.toBuilder().setIsDecl(true).build())
            .setValueExpr(settingsBuilderMethodInvocationExpr)
            .build();

    // Builder with set value method
    // e.g. foobarSettingBuilder.fooSetting().setRetrySettings(
    //        echoSettingsBuilder.echoSettings().getRetrySettings().toBuilder()
    //        .setTotalTimeoutDuration(Duration.ofSeconds(30)).build());
    MethodInvocationExpr settingBuilderMethodInvocationExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(localSettingsVarExpr)
            .setMethodName(
                JavaStyle.toLowerCamelCase(String.format("%sSettings", methodNameOpt.get())))
            .build();
    MethodInvocationExpr retrySettingsArgExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(settingBuilderMethodInvocationExpr)
            .setMethodName("getRetrySettings")
            .build();
    retrySettingsArgExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(retrySettingsArgExpr)
            .setMethodName("toBuilder")
            .build();
    MethodInvocationExpr ofOneSecondMethodInvocationExpr =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(
                TypeNode.withReference(ConcreteReference.withClazz(Duration.class)))
            .setMethodName("ofSeconds")
            .setArguments(
                ValueExpr.withValue(
                    PrimitiveValue.builder().setType(TypeNode.INT).setValue("1").build()))
            .build();
    MethodInvocationExpr ofFiveSecondsMethodInvocationExpr =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(
                TypeNode.withReference(ConcreteReference.withClazz(Duration.class)))
            .setMethodName("ofSeconds")
            .setArguments(
                ValueExpr.withValue(
                    PrimitiveValue.builder().setType(TypeNode.INT).setValue("5").build()))
            .build();
    MethodInvocationExpr ofThirtySecondsMethodInvocationExpr =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(
                TypeNode.withReference(ConcreteReference.withClazz(Duration.class)))
            .setMethodName("ofSeconds")
            .setArguments(
                ValueExpr.withValue(
                    PrimitiveValue.builder().setType(TypeNode.INT).setValue("30").build()))
            .build();
    MethodInvocationExpr ofSixtySecondsMethodInvocationExpr =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(
                TypeNode.withReference(ConcreteReference.withClazz(Duration.class)))
            .setMethodName("ofSeconds")
            .setArguments(
                ValueExpr.withValue(
                    PrimitiveValue.builder().setType(TypeNode.INT).setValue("60").build()))
            .build();
    MethodInvocationExpr ofThreeHundredSecondsMethodInvocationExpr =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(
                TypeNode.withReference(ConcreteReference.withClazz(Duration.class)))
            .setMethodName("ofSeconds")
            .setArguments(
                ValueExpr.withValue(
                    PrimitiveValue.builder().setType(TypeNode.INT).setValue("300").build()))
            .build();
    retrySettingsArgExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(retrySettingsArgExpr)
            .setMethodName("setInitialRetryDelayDuration")
            .setArguments(ofOneSecondMethodInvocationExpr)
            .build();
    retrySettingsArgExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(retrySettingsArgExpr)
            .setMethodName("setInitialRpcTimeoutDuration")
            .setArguments(ofFiveSecondsMethodInvocationExpr)
            .build();
    retrySettingsArgExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(retrySettingsArgExpr)
            .setMethodName("setMaxAttempts")
            .setArguments(
                ValueExpr.withValue(
                    PrimitiveValue.builder().setType(TypeNode.INT).setValue("5").build()))
            .build();
    retrySettingsArgExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(retrySettingsArgExpr)
            .setMethodName("setMaxRetryDelayDuration")
            .setArguments(ofThirtySecondsMethodInvocationExpr)
            .build();
    retrySettingsArgExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(retrySettingsArgExpr)
            .setMethodName("setMaxRpcTimeoutDuration")
            .setArguments(ofSixtySecondsMethodInvocationExpr)
            .build();
    double retryDelayMultiplier = 1.3;
    retrySettingsArgExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(retrySettingsArgExpr)
            .setMethodName("setRetryDelayMultiplier")
            .setArguments(
                ValueExpr.withValue(
                    PrimitiveValue.builder()
                        .setType(TypeNode.DOUBLE)
                        .setValue(String.format("%.1f", retryDelayMultiplier))
                        .build()))
            .build();
    double rpcTimeoutMultiplier = 1.5;
    retrySettingsArgExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(retrySettingsArgExpr)
            .setMethodName("setRpcTimeoutMultiplier")
            .setArguments(
                ValueExpr.withValue(
                    PrimitiveValue.builder()
                        .setType(TypeNode.DOUBLE)
                        .setValue(String.format("%.1f", rpcTimeoutMultiplier))
                        .build()))
            .build();
    retrySettingsArgExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(retrySettingsArgExpr)
            .setMethodName("setTotalTimeoutDuration")
            .setArguments(ofThreeHundredSecondsMethodInvocationExpr)
            .build();
    retrySettingsArgExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(retrySettingsArgExpr)
            .setMethodName("build")
            .build();
    settingBuilderMethodInvocationExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(settingBuilderMethodInvocationExpr)
            .setMethodName("setRetrySettings")
            .setArguments(retrySettingsArgExpr)
            .build();

    // Initialize clientSetting with builder() method.
    // e.g: Foobar<Stub>Settings foobarSettings = foobarSettingsBuilder.build();
    VariableExpr settingsVarExpr =
        VariableExpr.withVariable(
            Variable.builder()
                .setType(classType)
                .setName(JavaStyle.toLowerCamelCase(settingsClassName))
                .build());

    AssignmentExpr settingBuildAssignmentExpr =
        AssignmentExpr.builder()
            .setVariableExpr(settingsVarExpr.toBuilder().setIsDecl(true).build())
            .setValueExpr(
                MethodInvocationExpr.builder()
                    .setExprReferenceExpr(localSettingsVarExpr)
                    .setMethodName("build")
                    .setReturnType(classType)
                    .build())
            .build();

    List<Statement> statements =
        Arrays.asList(
                initLocalSettingsExpr,
                settingBuilderMethodInvocationExpr,
                settingBuildAssignmentExpr)
            .stream()
            .map(e -> ExprStatement.withExpr(e))
            .collect(Collectors.toList());

    // TODO: alicejli edit RegionTag to match other languages
    RegionTag regionTag =
        RegionTag.builder()
            .setServiceName(classType.reference().name())
            .setRpcName(methodNameOpt.get())
            .build();
    return Optional.of(Sample.builder().setBody(statements).setRegionTag(regionTag).build());
  }

  public static Optional<Sample> composeLroSettingsSample(
      Optional<String> methodNameOpt, String settingsClassName, TypeNode classType) {
    if (!methodNameOpt.isPresent()) {
      return Optional.empty();
    }
    // Initialize services settingsBuilder with newBuilder()
    // e.g. FoobarSettings.Builder foobarSettingsBuilder = FoobarSettings.newBuilder();
    TypeNode builderType =
        TypeNode.withReference(
            VaporReference.builder()
                .setEnclosingClassNames(classType.reference().name())
                .setName("Builder")
                .setPakkage(classType.reference().pakkage())
                .build());
    VariableExpr localSettingsVarExpr =
        VariableExpr.withVariable(
            Variable.builder()
                .setName(JavaStyle.toLowerCamelCase(String.format("%sBuilder", settingsClassName)))
                .setType(builderType)
                .build());
    MethodInvocationExpr settingsBuilderMethodInvocationExpr =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(classType)
            .setMethodName("newBuilder")
            .setReturnType(builderType)
            .build();
    AssignmentExpr initLocalSettingsExpr =
        AssignmentExpr.builder()
            .setVariableExpr(localSettingsVarExpr.toBuilder().setIsDecl(true).build())
            .setValueExpr(settingsBuilderMethodInvocationExpr)
            .build();

    // Initialize TimedRetryAlgorithm initialization
    // e.g. TimedRetryAlgorithm timedRetryAlgorithm = OperationalTimedPollAlgorithm.create(
    TypeNode TimedRetryAlgorithmType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("TimedRetryAlgorithm")
                .setPakkage("com.google.api.gax.retrying")
                .build());
    VariableExpr TimedRetryVarExpr =
        VariableExpr.withVariable(
            Variable.builder()
                .setName("timedRetryAlgorithm")
                .setType(TimedRetryAlgorithmType)
                .build());
    TypeNode OperationalTimedPollAlgorithmType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("OperationalTimedPollAlgorithm")
                .setPakkage("com.google.api.gax.longrunning")
                .build());

    // Set RetrySettings for TimedRetryAlgorithm
    TypeNode RetrySettingsType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("RetrySettings")
                .setPakkage("com.google.api.gax.retrying")
                .build());
    VariableExpr RetrySettingsVarExpr =
        VariableExpr.withVariable(
            Variable.builder().setName("RetrySettings").setType(RetrySettingsType).build());
    MethodInvocationExpr retrySettingsArgExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(RetrySettingsVarExpr)
            .setMethodName("newBuilder")
            .build();

    MethodInvocationExpr ofFiveHundredMillisMethodInvocationExpr =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(
                TypeNode.withReference(ConcreteReference.withClazz(Duration.class)))
            .setMethodName("ofMillis")
            .setArguments(
                ValueExpr.withValue(
                    PrimitiveValue.builder().setType(TypeNode.INT).setValue("500").build()))
            .build();
    MethodInvocationExpr ofFiveThousandMillisMethodInvocationExpr =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(
                TypeNode.withReference(ConcreteReference.withClazz(Duration.class)))
            .setMethodName("ofMillis")
            .setArguments(
                ValueExpr.withValue(
                    PrimitiveValue.builder().setType(TypeNode.INT).setValue("5000").build()))
            .build();
    MethodInvocationExpr ofTwentyFourHoursMethodInvocationExpr =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(
                TypeNode.withReference(ConcreteReference.withClazz(Duration.class)))
            .setMethodName("ofHours")
            .setArguments(
                ValueExpr.withValue(
                    PrimitiveValue.builder().setType(TypeNode.INT).setValue("24").build()))
            .build();

    retrySettingsArgExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(retrySettingsArgExpr)
            .setMethodName("setInitialRetryDelayDuration")
            .setArguments(ofFiveHundredMillisMethodInvocationExpr)
            .build();
    double retryDelayMultiplier = 1.5;
    retrySettingsArgExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(retrySettingsArgExpr)
            .setMethodName("setRetryDelayMultiplier")
            .setArguments(
                ValueExpr.withValue(
                    PrimitiveValue.builder()
                        .setType(TypeNode.DOUBLE)
                        .setValue(String.format("%.1f", retryDelayMultiplier))
                        .build()))
            .build();
    retrySettingsArgExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(retrySettingsArgExpr)
            .setMethodName("setMaxRetryDelayDuration")
            .setArguments(ofFiveThousandMillisMethodInvocationExpr)
            .build();
    retrySettingsArgExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(retrySettingsArgExpr)
            .setMethodName("setTotalTimeoutDuration")
            .setArguments(ofTwentyFourHoursMethodInvocationExpr)
            .build();

    MethodInvocationExpr RetrySettingsMethodInvocationExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(retrySettingsArgExpr)
            .setMethodName("build")
            .setReturnType(RetrySettingsType)
            .build();
    MethodInvocationExpr TimedRetryAlgorithmMethodInvocationExpr =
        MethodInvocationExpr.builder()
            .setStaticReferenceType(OperationalTimedPollAlgorithmType)
            .setMethodName("create")
            .setReturnType(TimedRetryAlgorithmType)
            .setArguments(RetrySettingsMethodInvocationExpr)
            .build();
    AssignmentExpr initTimedRetryAlgorithmMethodInvocationExpr =
        AssignmentExpr.builder()
            .setVariableExpr(TimedRetryVarExpr.toBuilder().setIsDecl(true).build())
            .setValueExpr(TimedRetryAlgorithmMethodInvocationExpr)
            .build();

    // Build the settings
    // e.g:
    // echoSettingsBuilder.createClusterOperationSettings().setPollingAlgorithm(timedRetryAlgorithm).build();

    MethodInvocationExpr builderMethodInvocationExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(localSettingsVarExpr)
            .setMethodName("createClusterOperationSettings")
            .setReturnType(builderType)
            .build();

    builderMethodInvocationExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(builderMethodInvocationExpr)
            .setMethodName("setPollingAlgorithm")
            .setArguments(TimedRetryVarExpr)
            .setReturnType(builderType)
            .build();

    builderMethodInvocationExpr =
        MethodInvocationExpr.builder()
            .setExprReferenceExpr(builderMethodInvocationExpr)
            .setMethodName("build")
            .setReturnType(builderType)
            .build();

    List<Statement> statements =
        Arrays.asList(
                initLocalSettingsExpr,
                initTimedRetryAlgorithmMethodInvocationExpr,
                builderMethodInvocationExpr)
            .stream()
            .map(e -> ExprStatement.withExpr(e))
            .collect(Collectors.toList());

    // TODO: alicejli edit RegionTag to match other languages
    RegionTag regionTag =
        RegionTag.builder()
            .setServiceName(classType.reference().name())
            .setRpcName(methodNameOpt.get())
            .build();
    return Optional.of(Sample.builder().setBody(statements).setRegionTag(regionTag).build());
  }
}
