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

package com.google.api.generator.gapic.model;

import com.google.protobuf.Duration;
import com.google.rpc.Code;
import io.grpc.serviceconfig.MethodConfig;
import io.grpc.serviceconfig.MethodConfig.RetryPolicy;
import io.grpc.serviceconfig.ServiceConfig;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class GapicServiceConfig {
  public static final RetryPolicy EMPTY_RETRY_POLICY = RetryPolicy.newBuilder().build();
  public static final Duration EMPTY_TIMEOUT = Duration.newBuilder().setSeconds(5).build();
  public static final List<Code> EMPTY_RETRY_CODES = Collections.emptyList();

  private static final String NO_RETRY_CODES_NAME = "no_retry_codes";
  private static final String NO_RETRY_PARAMS_NAME = "no_retry_params";

  private static final String NO_RETRY_CODES_PATTERN = "no_retry_%d_codes";
  private static final String NO_RETRY_PARAMS_PATTERN = "no_retry_%d_params";
  private static final String RETRY_CODES_PATTERN = "retry_policy_%d_codes";
  private static final String RETRY_PARAMS_PATTERN = "retry_policy_%d_params";

  private final List<MethodConfig> methodConfigs;
  private final Map<MethodConfig.Name, Integer> methodConfigTable;
  private final Map<MethodConfig.Name, GapicLroRetrySettings> lroRetrySettingsTable =
      new HashMap<>();
  private final Map<MethodConfig.Name, GapicBatchingSettings> batchingSettingsTable =
      new HashMap<>();

  private Optional<GapicLanguageSettings> languageSettingsOpt = Optional.empty();

  private GapicServiceConfig(
      List<MethodConfig> methodConfigs, Map<MethodConfig.Name, Integer> methodConfigTable) {
    this.methodConfigs = methodConfigs;
    this.methodConfigTable = methodConfigTable;
  }

  public static GapicServiceConfig create(Optional<ServiceConfig> serviceConfigOpt) {
    if (!serviceConfigOpt.isPresent()) {
      return new GapicServiceConfig(Collections.emptyList(), Collections.emptyMap());
    }

    ServiceConfig serviceConfig = serviceConfigOpt.get();
    Map<MethodConfig.Name, Integer> methodConfigTable = new HashMap<>();
    List<MethodConfig> methodConfigs = serviceConfig.getMethodConfigList();
    for (int i = 0; i < methodConfigs.size(); i++) {
      MethodConfig methodConfig = methodConfigs.get(i);
      for (MethodConfig.Name name : methodConfig.getNameList()) {
        methodConfigTable.put(name, i);
      }
    }

    return new GapicServiceConfig(methodConfigs, methodConfigTable);
  }

  public void setLroRetrySettings(Optional<List<GapicLroRetrySettings>> lroRetrySettingsOpt) {
    if (!lroRetrySettingsOpt.isPresent()) {
      return;
    }
    lroRetrySettingsTable.clear();
    for (GapicLroRetrySettings lroRetrySetting : lroRetrySettingsOpt.get()) {
      lroRetrySettingsTable.put(
          MethodConfig.Name.newBuilder()
              .setService(
                  String.format(
                      "%s.%s", lroRetrySetting.protoPakkage(), lroRetrySetting.serviceName()))
              .setMethod(lroRetrySetting.methodName())
              .build(),
          lroRetrySetting);
    }
  }

  public void setBatchingSettings(Optional<List<GapicBatchingSettings>> batchingSettingsOpt) {
    if (!batchingSettingsOpt.isPresent()) {
      return;
    }
    batchingSettingsTable.clear();
    for (GapicBatchingSettings batchingSetting : batchingSettingsOpt.get()) {
      batchingSettingsTable.put(
          MethodConfig.Name.newBuilder()
              .setService(
                  String.format(
                      "%s.%s", batchingSetting.protoPakkage(), batchingSetting.serviceName()))
              .setMethod(batchingSetting.methodName())
              .build(),
          batchingSetting);
    }
  }

  public void setLanguageSettings(Optional<GapicLanguageSettings> languageSettingsOpt) {
    this.languageSettingsOpt = languageSettingsOpt;
  }

  public Optional<GapicLanguageSettings> getLanguageSettingsOpt() {
    return languageSettingsOpt;
  }

  public Map<String, GapicRetrySettings> getAllGapicRetrySettings(Service service) {
    return service.methods().stream()
        .collect(
            Collectors.toMap(
                m -> getRetryParamsName(service, m),
                m -> toGapicRetrySettings(service, m),
                (r1, r2) -> r2,
                LinkedHashMap::new));
  }

  public Map<String, List<Code>> getAllRetryCodes(Service service) {
    return service.methods().stream()
        .collect(
            Collectors.toMap(
                m -> getRetryCodeName(service, m),
                m -> retryCodesLookup(service, m),
                (l1, l2) -> l2,
                LinkedHashMap::new));
  }

  public String getRetryCodeName(Service service, Method method) {
    Optional<Integer> retryPolicyIndexOpt = retryPolicyIndexLookup(service, method);
    if (retryPolicyIndexOpt.isPresent()) {
      return getRetryCodeName(retryPolicyIndexOpt.get());
    }
    return NO_RETRY_CODES_NAME;
  }

  public String getRetryParamsName(Service service, Method method) {
    Optional<Integer> retryPolicyIndexOpt = retryPolicyIndexLookup(service, method);
    if (retryPolicyIndexOpt.isPresent()) {
      return getRetryParamsName(retryPolicyIndexOpt.get());
    }
    return NO_RETRY_PARAMS_NAME;
  }

  public boolean hasLroRetrySetting(Service service, Method method) {
    return lroRetrySettingsTable.containsKey(toName(service, method));
  }

  public boolean hasBatchingSetting(Service service, Method method) {
    return batchingSettingsTable.containsKey(toName(service, method));
  }

  public boolean hasBatchingSetting(String protoPakkage, String serviceName, String methodName) {
    return batchingSettingsTable.containsKey(
        MethodConfig.Name.newBuilder()
            .setService(String.format("%s.%s", protoPakkage, serviceName))
            .setMethod(methodName)
            .build());
  }

  public Optional<GapicLroRetrySettings> getLroRetrySetting(Service service, Method method) {
    return hasLroRetrySetting(service, method)
        ? Optional.of(lroRetrySettingsTable.get(toName(service, method)))
        : Optional.empty();
  }

  public Optional<GapicBatchingSettings> getBatchingSetting(Service service, Method method) {
    return hasBatchingSetting(service, method)
        ? Optional.of(batchingSettingsTable.get(toName(service, method)))
        : Optional.empty();
  }

  private GapicRetrySettings toGapicRetrySettings(Service service, Method method) {
    GapicRetrySettings.Kind kind = GapicRetrySettings.Kind.FULL;
    Optional<Integer> retryPolicyIndexOpt = retryPolicyIndexLookup(service, method);
    if (!retryPolicyIndexOpt.isPresent()) {
      kind = GapicRetrySettings.Kind.NONE;
    } else {
      MethodConfig methodConfig = methodConfigs.get(retryPolicyIndexOpt.get());
      if (!methodConfig.hasTimeout() && !methodConfig.hasRetryPolicy()) {
        kind = GapicRetrySettings.Kind.NONE;
      } else {
        kind =
            methodConfig.hasRetryPolicy()
                ? GapicRetrySettings.Kind.FULL
                : GapicRetrySettings.Kind.NO_RETRY;
      }
    }

    return GapicRetrySettings.builder()
        .setTimeout(timeoutLookup(service, method))
        .setRetryPolicy(retryPolicyLookup(service, method))
        .setKind(kind)
        .build();
  }

  private List<Code> retryCodesLookup(Service service, Method method) {
    RetryPolicy retryPolicy = retryPolicyLookup(service, method);
    if (retryPolicy.equals(EMPTY_RETRY_POLICY)) {
      return Collections.emptyList();
    }
    return retryPolicy.getRetryableStatusCodesList();
  }

  private RetryPolicy retryPolicyLookup(Service service, Method method) {
    Optional<Integer> retryPolicyIndexOpt = retryPolicyIndexLookup(service, method);
    if (retryPolicyIndexOpt.isPresent()) {
      MethodConfig methodConfig = methodConfigs.get(retryPolicyIndexOpt.get());
      return methodConfig.hasRetryPolicy() ? methodConfig.getRetryPolicy() : EMPTY_RETRY_POLICY;
    }
    return EMPTY_RETRY_POLICY;
  }

  private Duration timeoutLookup(Service service, Method method) {
    Optional<Integer> retryPolicyIndexOpt = retryPolicyIndexLookup(service, method);
    if (retryPolicyIndexOpt.isPresent()) {
      MethodConfig methodConfig = methodConfigs.get(retryPolicyIndexOpt.get());
      return methodConfig.hasTimeout() ? methodConfig.getTimeout() : EMPTY_TIMEOUT;
    }
    return EMPTY_TIMEOUT;
  }

  private Optional<Integer> retryPolicyIndexLookup(Service service, Method method) {
    MethodConfig.Name serviceMethodName = toName(service, method);
    if (methodConfigTable.containsKey(serviceMethodName)) {
      return Optional.of(methodConfigTable.get(serviceMethodName));
    }
    MethodConfig.Name serviceName = toName(service);
    if (methodConfigTable.containsKey(serviceName)) {
      return Optional.of(methodConfigTable.get(serviceName));
    }
    return Optional.empty();
  }

  /**
   * @param codeIndex The index of the retryable code in the method config list.
   * @return The canonical name to be used in the generated client library.
   */
  private String getRetryCodeName(int methodConfigIndex) {
    MethodConfig methodConfig = methodConfigs.get(methodConfigIndex);
    if (!methodConfig.hasTimeout() && !methodConfig.hasRetryPolicy()) {
      return NO_RETRY_CODES_NAME;
    }
    return String.format(
        methodConfig.hasRetryPolicy() ? RETRY_CODES_PATTERN : NO_RETRY_CODES_PATTERN,
        methodConfigIndex);
  }

  /**
   * @param retryParamsIndex The index of the retry params in the method config list.
   * @return The canonical name to be used in the generated client library.
   */
  private String getRetryParamsName(int methodConfigIndex) {
    MethodConfig methodConfig = methodConfigs.get(methodConfigIndex);
    if (!methodConfig.hasTimeout() && !methodConfig.hasRetryPolicy()) {
      return NO_RETRY_PARAMS_NAME;
    }
    return String.format(
        methodConfig.hasRetryPolicy() ? RETRY_PARAMS_PATTERN : NO_RETRY_PARAMS_PATTERN,
        methodConfigIndex);
  }

  private MethodConfig.Name toName(Service service) {
    return MethodConfig.Name.newBuilder().setService(serviceToNameString(service)).build();
  }

  private MethodConfig.Name toName(Service service, Method method) {
    return MethodConfig.Name.newBuilder()
        .setService(serviceToNameString(service))
        .setMethod(method.name())
        .build();
  }

  private String serviceToNameString(Service service) {
    return String.format("%s.%s", service.protoPakkage(), service.name());
  }
}
