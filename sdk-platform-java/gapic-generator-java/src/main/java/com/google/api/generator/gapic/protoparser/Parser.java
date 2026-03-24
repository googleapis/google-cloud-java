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

package com.google.api.generator.gapic.protoparser;

import com.google.api.ClientLibrarySettings;
import com.google.api.ClientProto;
import com.google.api.DocumentationRule;
import com.google.api.FieldBehavior;
import com.google.api.FieldBehaviorProto;
import com.google.api.FieldInfo.Format;
import com.google.api.FieldInfoProto;
import com.google.api.HttpRule;
import com.google.api.MethodSettings;
import com.google.api.ResourceDescriptor;
import com.google.api.ResourceProto;
import com.google.api.SelectiveGapicGeneration;
import com.google.api.generator.engine.ast.TypeNode;
import com.google.api.generator.engine.ast.VaporReference;
import com.google.api.generator.gapic.model.Field;
import com.google.api.generator.gapic.model.GapicBatchingSettings;
import com.google.api.generator.gapic.model.GapicContext;
import com.google.api.generator.gapic.model.GapicLanguageSettings;
import com.google.api.generator.gapic.model.GapicLroRetrySettings;
import com.google.api.generator.gapic.model.GapicServiceConfig;
import com.google.api.generator.gapic.model.HttpBindings;
import com.google.api.generator.gapic.model.LongrunningOperation;
import com.google.api.generator.gapic.model.Message;
import com.google.api.generator.gapic.model.Method;
import com.google.api.generator.gapic.model.OperationResponse;
import com.google.api.generator.gapic.model.ResourceName;
import com.google.api.generator.gapic.model.ResourceReference;
import com.google.api.generator.gapic.model.RoutingHeaderRule;
import com.google.api.generator.gapic.model.Service;
import com.google.api.generator.gapic.model.SourceCodeInfoLocation;
import com.google.api.generator.gapic.model.Transport;
import com.google.api.generator.gapic.utils.ResourceNameConstants;
import com.google.cloud.ExtendedOperationsProto;
import com.google.cloud.OperationResponseMapping;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.longrunning.OperationInfo;
import com.google.longrunning.OperationsProto;
import com.google.protobuf.DescriptorProtos.FieldOptions;
import com.google.protobuf.DescriptorProtos.FileDescriptorProto;
import com.google.protobuf.DescriptorProtos.MessageOptions;
import com.google.protobuf.DescriptorProtos.MethodOptions;
import com.google.protobuf.DescriptorProtos.ServiceOptions;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.DescriptorValidationException;
import com.google.protobuf.Descriptors.EnumDescriptor;
import com.google.protobuf.Descriptors.EnumValueDescriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.Descriptors.MethodDescriptor;
import com.google.protobuf.Descriptors.ServiceDescriptor;
import com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Parser {
  enum SelectiveGapicType {
    // Methods will be generated and exposed externally as usual.
    PUBLIC,
    // Methods will not be generated.
    HIDDEN,
    // Methods will be generated and tagged @InternalApi (internal use) during generation.
    INTERNAL
  }

  private static final Logger LOGGER = Logger.getLogger(Parser.class.getName());
  private static final String COMMA = ",";
  private static final String COLON = ":";
  private static final String DEFAULT_PORT = "443";
  private static final String DOT = ".";
  private static final String SLASH = "/";

  private static final ResourceName WILDCARD_RESOURCE_NAME =
      ResourceName.createWildcard("*", "com.google.api.wildcard.placeholder");

  // Mirrors the sanitizer allowlist.
  private static final Set<String> MIXIN_ALLOWLIST =
      ImmutableSet.of(
          "google.iam.v1.IAMPolicy",
          "google.longrunning.Operations",
          "google.cloud.location.Locations");
  // These must be kept in sync with the above protos' java_package options.
  private static final Set<String> MIXIN_JAVA_PACKAGE_ALLOWLIST =
      ImmutableSet.of("com.google.iam.v1", "com.google.longrunning", "com.google.cloud.location");

  // List of BigQuery methods that can use max_result field as an alternative to page_size for
  // pagination.
  private static final ImmutableSet<String> BIGQUERY_LEGACY_PAGINATION_ALLOWLIST =
      ImmutableSet.of(
          "google.cloud.bigquery.v2.JobService.ListJobs",
          "google.cloud.bigquery.v2.RoutineService.ListRoutines",
          "google.cloud.bigquery.v2.DatasetService.ListDatasets",
          "google.cloud.bigquery.v2.ModelService.ListModels",
          "google.cloud.bigquery.v2.TableService.ListTables");

  // Allow other parsers to access this.
  protected static final SourceCodeInfoParser SOURCE_CODE_INFO_PARSER = new SourceCodeInfoParser();

  static class GapicParserException extends RuntimeException {
    public GapicParserException(String errorMessage) {
      super(errorMessage);
    }
  }

  public static GapicContext parse(CodeGeneratorRequest request) {
    Optional<String> gapicYamlConfigPathOpt =
        PluginArgumentParser.parseGapicYamlConfigPath(request);
    Optional<List<GapicBatchingSettings>> batchingSettingsOpt =
        BatchingSettingsConfigParser.parse(gapicYamlConfigPathOpt);
    Optional<List<GapicLroRetrySettings>> lroRetrySettingsOpt =
        GapicLroRetrySettingsParser.parse(gapicYamlConfigPathOpt);
    Optional<GapicLanguageSettings> languageSettingsOpt =
        GapicLanguageSettingsParser.parse(gapicYamlConfigPathOpt);
    Optional<String> transportOpt = PluginArgumentParser.parseTransport(request);
    Optional<String> repoOpt = PluginArgumentParser.parseRepo(request);
    Optional<String> artifactOpt = PluginArgumentParser.parseArtifact(request);

    boolean willGenerateMetadata = PluginArgumentParser.hasMetadataFlag(request);
    boolean willGenerateNumericEnum = PluginArgumentParser.hasNumericEnumFlag(request);

    Optional<String> serviceConfigPathOpt = PluginArgumentParser.parseJsonConfigPath(request);
    Optional<GapicServiceConfig> serviceConfigOpt =
        ServiceConfigParser.parse(serviceConfigPathOpt.orElse(null));
    if (serviceConfigOpt.isPresent()) {
      GapicServiceConfig serviceConfig = serviceConfigOpt.get();
      serviceConfig.setLroRetrySettings(lroRetrySettingsOpt);
      serviceConfig.setBatchingSettings(batchingSettingsOpt);
      serviceConfig.setLanguageSettings(languageSettingsOpt);
      serviceConfigOpt = Optional.of(serviceConfig);
    }

    Optional<String> serviceYamlConfigPathOpt =
        PluginArgumentParser.parseServiceYamlConfigPath(request);
    Optional<com.google.api.Service> serviceYamlProtoOpt =
        serviceYamlConfigPathOpt.flatMap(ServiceYamlParser::parse);

    // Collect the resource references seen in messages.
    Set<ResourceReference> outputResourceReferencesSeen = new HashSet<>();
    // Keep message and resource name parsing separate for cleaner logic.
    // While this takes an extra pass through the protobufs, the extra time is relatively trivial
    // and is worth the larger reduced maintenance cost.
    Map<String, Message> messages = parseMessages(request, outputResourceReferencesSeen);

    Map<String, ResourceName> resourceNames = parseResourceNames(request);
    messages = updateResourceNamesInMessages(messages, resourceNames.values());

    // Contains only resource names that are actually used. Usage refers to the presence of a
    // request message's field in an RPC's method_signature annotation. That is, resource name
    // definitions or references that are simply defined, but not used in such a manner,
    // will not have corresponding Java helper classes generated.
    // If selective api generation is configured via service yaml, Java helper classes are only
    // generated if resource names are actually used by methods selected to generate.
    Set<ResourceName> outputArgResourceNames = new HashSet<>();
    List<Service> mixinServices = new ArrayList<>();
    Transport transport = Transport.parse(transportOpt.orElse(Transport.GRPC.toString()));
    List<Service> services =
        parseServices(
            request,
            messages,
            resourceNames,
            outputArgResourceNames,
            serviceYamlProtoOpt,
            serviceConfigOpt,
            mixinServices,
            transport);

    if (services.isEmpty()) {
      LOGGER.warning("No services found to generate. This will cause a no-op (no files generated)");
      return GapicContext.EMPTY;
    }

    // TODO(vam-google): Figure out whether we should keep this allowlist or bring
    // back the unused resource names for all APIs.
    // Temporary workaround for Ads, who still need these resource names.
    if (services.get(0).protoPakkage().startsWith("google.ads.googleads.v")) {
      Function<ResourceName, String> typeNameFn =
          r -> r.resourceTypeString().substring(r.resourceTypeString().indexOf("/") + 1);
      Function<Set<ResourceName>, Set<String>> typeStringSetFn =
          sr -> sr.stream().map(typeNameFn).collect(Collectors.toSet());

      // Include all resource names present in message types for backwards-compatibility with the
      // monolith. In the future, this should be removed on a client library major semver update.
      // Resolve type name collisions with the ones present in the method arguments.
      final Set<String> typeStringSet = typeStringSetFn.apply(outputArgResourceNames);
      outputArgResourceNames.addAll(
          resourceNames.values().stream()
              .filter(r -> r.hasParentMessageName() && !typeStringSet.contains(typeNameFn.apply(r)))
              .collect(Collectors.toSet()));

      String servicePackage = services.get(0).pakkage();
      Map<String, ResourceName> patternsToResourceNames =
          ResourceParserHelpers.createPatternResourceNameMap(resourceNames);
      for (ResourceReference resourceReference : outputResourceReferencesSeen) {
        final Set<String> interimTypeStringSet = typeStringSetFn.apply(outputArgResourceNames);
        outputArgResourceNames.addAll(
            ResourceReferenceParser.parseResourceNames(
                    resourceReference, servicePackage, null, resourceNames, patternsToResourceNames)
                .stream()
                .filter(r -> !interimTypeStringSet.contains(typeNameFn.apply(r)))
                .collect(Collectors.toSet()));
      }
    }

    return GapicContext.builder()
        .setServices(services)
        .setMixinServices(
            // Mixin classes must share the package with the service they are mixed in, instead of
            // their original package
            mixinServices.stream()
                .map(s -> s.toBuilder().setPakkage(services.get(0).pakkage()).build())
                .collect(Collectors.toList()))
        .setMessages(messages)
        .setResourceNames(resourceNames)
        .setHelperResourceNames(outputArgResourceNames)
        .setServiceConfig(serviceConfigOpt.orElse(null))
        .setGapicMetadataEnabled(willGenerateMetadata)
        .setServiceYamlProto(serviceYamlProtoOpt.orElse(null))
        .setTransport(transport)
        .setRestNumericEnumsEnabled(willGenerateNumericEnum)
        .setRepo(repoOpt.orElse(null))
        .setArtifact(artifactOpt.orElse(null))
        .build();
  }

  public static List<Service> parseServices(
      CodeGeneratorRequest request,
      Map<String, Message> messageTypes,
      Map<String, ResourceName> resourceNames,
      Set<ResourceName> outputArgResourceNames,
      Optional<com.google.api.Service> serviceYamlProtoOpt,
      Optional<GapicServiceConfig> serviceConfigOpt,
      List<Service> outputMixinServices,
      Transport transport) {
    Map<String, FileDescriptor> fileDescriptors = getFilesToGenerate(request);

    List<Service> services = new ArrayList<>();
    for (String fileToGenerate : request.getFileToGenerateList()) {
      FileDescriptor fileDescriptor =
          Preconditions.checkNotNull(
              fileDescriptors.get(fileToGenerate),
              "Missing file descriptor for [%s]",
              fileToGenerate);

      services.addAll(
          parseService(
              fileDescriptor,
              messageTypes,
              resourceNames,
              serviceYamlProtoOpt,
              serviceConfigOpt,
              outputArgResourceNames,
              transport));
    }

    // Prevent codegen for mixed-in services if there are other services present, since that is an
    // indicator that we are not generating a GAPIC client for the mixed-in service on its own.
    Function<Service, String> serviceFullNameFn =
        s -> String.format("%s.%s", s.protoPakkage(), s.name());
    Set<Service> blockedCodegenMixinApis = new HashSet<>();
    Set<Service> definedServices = new HashSet<>();
    for (Service s : services) {
      if (MIXIN_ALLOWLIST.contains(serviceFullNameFn.apply(s))) {
        blockedCodegenMixinApis.add(s);
      } else {
        definedServices.add(s);
      }
    }
    // It's very unlikely the blocklisted APIs will contain the other, or any other service.
    boolean servicesContainBlocklistedApi =
        !blockedCodegenMixinApis.isEmpty() && !definedServices.isEmpty();
    // Service names that are stated in the YAML file (as mixins). Used to filter
    // blockedCodegenMixinApis.
    Set<String> mixedInApis =
        !serviceYamlProtoOpt.isPresent()
            ? Collections.emptySet()
            : serviceYamlProtoOpt.get().getApisList().stream()
                .filter(a -> MIXIN_ALLOWLIST.contains(a.getName()))
                .map(a -> a.getName())
                .collect(Collectors.toSet());
    // Holds the methods to be mixed in.
    // Key: proto_package.ServiceName.RpcName.
    // Value: HTTP rules, which clobber those in the proto.
    // Assumes that http.rules.selector always specifies RPC names in the above format.
    Map<String, HttpBindings> mixedInMethodsToHttpRules = new HashMap<>();
    Map<String, String> mixedInMethodsToDocs = new HashMap<>();
    // Parse HTTP rules and documentation, which will override the proto.
    if (serviceYamlProtoOpt.isPresent()) {
      for (HttpRule httpRule : serviceYamlProtoOpt.get().getHttp().getRulesList()) {
        HttpBindings httpBindings = HttpRuleParser.parseHttpRule(httpRule);
        if (httpBindings == null) {
          continue;
        }
        for (String rpcFullNameRaw : httpRule.getSelector().split(",")) {
          String rpcFullName = rpcFullNameRaw.trim();
          mixedInMethodsToHttpRules.put(rpcFullName, httpBindings);
        }
      }
      for (DocumentationRule docRule :
          serviceYamlProtoOpt.get().getDocumentation().getRulesList()) {
        for (String rpcFullNameRaw : docRule.getSelector().split(",")) {
          String rpcFullName = rpcFullNameRaw.trim();
          mixedInMethodsToDocs.put(rpcFullName, docRule.getDescription());
        }
      }
    }

    // Sort potential mixin services alphabetically.
    List<Service> orderedBlockedCodegenMixinApis =
        blockedCodegenMixinApis.stream()
            .sorted((s1, s2) -> s2.name().compareTo(s1.name()))
            .collect(Collectors.toList());

    Set<String> apiDefinedRpcs = new HashSet<>();
    for (Service service : services) {
      if (orderedBlockedCodegenMixinApis.contains(service)) {
        continue;
      }
      apiDefinedRpcs.addAll(
          service.methods().stream().map(m -> m.name()).collect(Collectors.toSet()));
    }
    // Mix-in APIs only if the protos are present and they're defined in the service.yaml file.
    Set<Service> outputMixinServiceSet = new HashSet<>();
    if (servicesContainBlocklistedApi && !mixedInApis.isEmpty()) {
      for (int i = 0; i < services.size(); i++) {
        Service originalService = services.get(i);
        List<Method> updatedOriginalServiceMethods = new ArrayList<>(originalService.methods());
        // If mixin APIs are present, add the methods to all other services.
        for (Service mixinService : orderedBlockedCodegenMixinApis) {
          final String mixinServiceFullName = serviceFullNameFn.apply(mixinService);
          if (!mixedInApis.contains(mixinServiceFullName)) {
            continue;
          }
          Function<Method, String> methodToFullProtoNameFn =
              m -> String.format("%s.%s", mixinServiceFullName, m.name());
          // Filter mixed-in methods based on those listed in the HTTP rules section of
          // service.yaml.
          List<Method> updatedMixinMethods =
              mixinService.methods().stream()
                  // Mixin method inclusion is based on the HTTP rules list in service.yaml.
                  .filter(
                      m -> mixedInMethodsToHttpRules.containsKey(methodToFullProtoNameFn.apply(m)))
                  .map(
                      m -> {
                        // HTTP rules and RPC documentation in the service.yaml file take
                        // precedence.
                        String fullMethodName = methodToFullProtoNameFn.apply(m);
                        HttpBindings httpBindings =
                            mixedInMethodsToHttpRules.containsKey(fullMethodName)
                                ? mixedInMethodsToHttpRules.get(fullMethodName)
                                : m.httpBindings();
                        String docs =
                            mixedInMethodsToDocs.containsKey(fullMethodName)
                                ? mixedInMethodsToDocs.get(fullMethodName)
                                : m.description();
                        return m.toBuilder()
                            .setHttpBindings(httpBindings)
                            .setDescription(docs)
                            .build();
                      })
                  .collect(Collectors.toList());
          // Overridden RPCs defined in the protos take precedence.
          updatedMixinMethods.stream()
              .filter(m -> !apiDefinedRpcs.contains(m.name()))
              .forEach(
                  m ->
                      updatedOriginalServiceMethods.add(
                          m.toBuilder()
                              .setMixedInApiName(serviceFullNameFn.apply(mixinService))
                              .build()));
          // Sort by method name, to ensure a deterministic method ordering (for tests).
          updatedMixinMethods =
              updatedMixinMethods.stream()
                  .sorted((m1, m2) -> m2.name().compareTo(m1.name()))
                  .collect(Collectors.toList());
          outputMixinServiceSet.add(
              mixinService.toBuilder().setMethods(updatedMixinMethods).build());
        }
        services.set(
            i, originalService.toBuilder().setMethods(updatedOriginalServiceMethods).build());
      }
    }

    if (servicesContainBlocklistedApi) {
      services =
          services.stream()
              .filter(s -> !MIXIN_ALLOWLIST.contains(serviceFullNameFn.apply(s)))
              .collect(Collectors.toList());
    }

    // Use a list to ensure ordering for deterministic tests.
    outputMixinServices.addAll(
        outputMixinServiceSet.stream()
            .sorted((s1, s2) -> s2.name().compareTo(s1.name()))
            .collect(Collectors.toList()));
    return services;
  }

  @VisibleForTesting
  public static List<Service> parseService(
      FileDescriptor fileDescriptor,
      Map<String, Message> messageTypes,
      Map<String, ResourceName> resourceNames,
      Optional<com.google.api.Service> serviceYamlProtoOpt,
      Set<ResourceName> outputArgResourceNames) {
    return parseService(
        fileDescriptor,
        messageTypes,
        resourceNames,
        serviceYamlProtoOpt,
        Optional.empty(),
        outputArgResourceNames,
        Transport.GRPC);
  }

  static SelectiveGapicType getMethodSelectiveGapicType(
      MethodDescriptor method,
      Optional<com.google.api.Service> serviceYamlProtoOpt,
      String protoPackage) {
    // default to include all when no service yaml or no library setting section.
    if (!serviceYamlProtoOpt.isPresent()
        || serviceYamlProtoOpt.get().getPublishing().getLibrarySettingsCount() == 0) {
      return SelectiveGapicType.PUBLIC;
    }
    List<ClientLibrarySettings> librarySettingsList =
        serviceYamlProtoOpt.get().getPublishing().getLibrarySettingsList();
    // Validate for logging purpose, this should be validated upstream.
    // If library_settings.version does not match with proto package name
    // Give warnings and disregard this config. default to include all.
    if (!librarySettingsList.get(0).getVersion().isEmpty()
        && !protoPackage.equals(librarySettingsList.get(0).getVersion())) {
      if (LOGGER.isLoggable(Level.WARNING)) {
        LOGGER.warning(
            String.format(
                "Service yaml config is misconfigured. Version in "
                    + "publishing.library_settings (%s) does not match proto package (%s)."
                    + "Disregarding selective generation settings.",
                librarySettingsList.get(0).getVersion(), protoPackage));
      }
      return SelectiveGapicType.PUBLIC;
    }
    // librarySettingsList is technically a list, but is processed upstream and
    // only leave with 1 element. Otherwise, it is a misconfiguration and
    // should be caught upstream.
    SelectiveGapicGeneration selectiveGapicGenerationConfig =
        librarySettingsList.get(0).getJavaSettings().getCommon().getSelectiveGapicGeneration();

    List<String> includeMethodsList = selectiveGapicGenerationConfig.getMethodsList();

    Boolean generateOmittedAsInternal =
        selectiveGapicGenerationConfig.getGenerateOmittedAsInternal();

    // Set method to PUBLIC if no SelectiveGapicGeneration Configuration is configured and
    // GenerateOmittedAsInternal is false.
    if (includeMethodsList.isEmpty() && generateOmittedAsInternal == false) {
      return SelectiveGapicType.PUBLIC;
    }

    // Set method to PUBLIC if the method is in the allow list.
    if (includeMethodsList.contains(method.getFullName())) {
      return SelectiveGapicType.PUBLIC;
    }
    // Otherwise, generate this method as INTERNAL or HIDDEN based on GenerateOmittedAsInternal
    // flag.

    return generateOmittedAsInternal ? SelectiveGapicType.INTERNAL : SelectiveGapicType.HIDDEN;
  }

  // A service is considered empty if it contains no methods, or only methods marked as HIDDEN.
  private static boolean isEmptyService(
      ServiceDescriptor serviceDescriptor,
      Optional<com.google.api.Service> serviceYamlProtoOpt,
      String protoPackage) {
    List<MethodDescriptor> methodsList = serviceDescriptor.getMethods();
    List<MethodDescriptor> methodListNotHidden =
        methodsList.stream()
            .filter(
                method ->
                    getMethodSelectiveGapicType(method, serviceYamlProtoOpt, protoPackage)
                        != SelectiveGapicType.HIDDEN)
            .collect(Collectors.toList());
    if (methodListNotHidden.isEmpty()) {
      LOGGER.log(
          Level.WARNING,
          "Service {0} has no public or internal RPC methods and will not be generated",
          serviceDescriptor.getName());
    }
    return methodListNotHidden.isEmpty();
  }

  public static List<Service> parseService(
      FileDescriptor fileDescriptor,
      Map<String, Message> messageTypes,
      Map<String, ResourceName> resourceNames,
      Optional<com.google.api.Service> serviceYamlProtoOpt,
      Optional<GapicServiceConfig> serviceConfigOpt,
      Set<ResourceName> outputArgResourceNames,
      Transport transport) {
    String protoPackage = fileDescriptor.getPackage();
    return fileDescriptor.getServices().stream()
        .filter(
            serviceDescriptor ->
                !isEmptyService(serviceDescriptor, serviceYamlProtoOpt, protoPackage))
        .map(
            s -> {
              // Workaround for a missing default_host and oauth_scopes annotation from a service
              // definition. This can happen for protos that bypass the publishing process.
              // TODO(miraleung): Remove this workaround later?
              ServiceOptions serviceOptions = s.getOptions();
              String defaultHost = null;
              if (serviceOptions.hasExtension(ClientProto.defaultHost)) {
                defaultHost =
                    sanitizeDefaultHost(serviceOptions.getExtension(ClientProto.defaultHost));
              } else if (serviceYamlProtoOpt.isPresent()) {
                // Fall back to the DNS name supplied in the service .yaml config.
                defaultHost = serviceYamlProtoOpt.get().getName();
              }
              Preconditions.checkState(
                  !Strings.isNullOrEmpty(defaultHost),
                  String.format(
                      "Default host not found in service YAML config file or annotation for %s",
                      s.getName()));

              List<String> oauthScopes = Collections.emptyList();
              if (serviceOptions.hasExtension(ClientProto.oauthScopes)) {
                oauthScopes =
                    Arrays.asList(
                        serviceOptions.getExtension(ClientProto.oauthScopes).split(COMMA));
              }

              boolean isDeprecated = false;
              if (serviceOptions.hasDeprecated()) {
                isDeprecated = serviceOptions.getDeprecated();
              }

              Service.Builder serviceBuilder = Service.builder();
              if (fileDescriptor.toProto().hasSourceCodeInfo()) {
                SourceCodeInfoLocation protoServiceLocation =
                    SOURCE_CODE_INFO_PARSER.getLocation(s);
                if (!Objects.isNull(protoServiceLocation)
                    && !Strings.isNullOrEmpty(protoServiceLocation.getLeadingComments())) {
                  serviceBuilder.setDescription(protoServiceLocation.getLeadingComments());
                }
              }

              if (serviceOptions.hasExtension(ClientProto.apiVersion)) {
                String apiVersion = serviceOptions.getExtension(ClientProto.apiVersion);
                serviceBuilder.setApiVersion(apiVersion);
              }

              String serviceName = s.getName();
              String overriddenServiceName = serviceName;
              String pakkage = TypeParser.getPackage(fileDescriptor);
              String originalJavaPackage = pakkage;
              // Override Java package with that specified in gapic.yaml.
              // this override is deprecated and legacy support only
              // see go/client-user-guide#configure-long-running-operation-polling-timeouts-optional
              if (serviceConfigOpt.isPresent()
                  && serviceConfigOpt.get().getLanguageSettingsOpt().isPresent()) {
                GapicLanguageSettings languageSettings =
                    serviceConfigOpt.get().getLanguageSettingsOpt().get();
                pakkage = languageSettings.pakkage();
                overriddenServiceName =
                    languageSettings.getJavaServiceName(fileDescriptor.getPackage(), s.getName());
              }
              return serviceBuilder
                  .setName(serviceName)
                  .setOverriddenName(overriddenServiceName)
                  .setDefaultHost(defaultHost)
                  .setOauthScopes(oauthScopes)
                  .setPakkage(pakkage)
                  .setOriginalJavaPackage(originalJavaPackage)
                  .setProtoPakkage(fileDescriptor.getPackage())
                  .setIsDeprecated(isDeprecated)
                  .setMethods(
                      parseMethods(
                          s,
                          protoPackage,
                          pakkage,
                          messageTypes,
                          resourceNames,
                          serviceConfigOpt,
                          serviceYamlProtoOpt,
                          outputArgResourceNames,
                          transport))
                  .build();
            })
        .collect(Collectors.toList());
  }

  public static Map<String, Message> parseMessages(
      CodeGeneratorRequest request, Set<ResourceReference> outputResourceReferencesSeen) {
    Map<String, FileDescriptor> fileDescriptors = getFilesToGenerate(request);
    Map<String, Message> messages = new HashMap<>();
    // Look for message types amongst all the protos, not just the ones to generate. This will
    // ensure we track commonly-used protos like Empty.
    for (FileDescriptor fileDescriptor : fileDescriptors.values()) {
      messages.putAll(parseMessages(fileDescriptor, outputResourceReferencesSeen));
    }

    return messages;
  }

  // TODO(miraleung): Propagate the internal method to all tests, and remove this wrapper.
  public static Map<String, Message> parseMessages(FileDescriptor fileDescriptor) {
    return parseMessages(fileDescriptor, new HashSet<>());
  }

  public static Map<String, Message> parseMessages(
      FileDescriptor fileDescriptor, Set<ResourceReference> outputResourceReferencesSeen) {
    // TODO(miraleung): Preserve nested type and package data in the type key.
    Map<String, Message> messages = new HashMap<>();
    for (Descriptor messageDescriptor : fileDescriptor.getMessageTypes()) {
      messages.putAll(parseMessages(messageDescriptor, outputResourceReferencesSeen));
    }
    // We treat enums as messages since we primarily care only about the type representation.
    for (EnumDescriptor enumDescriptor : fileDescriptor.getEnumTypes()) {
      String name = enumDescriptor.getName();
      List<EnumValueDescriptor> valueDescriptors = enumDescriptor.getValues();
      TypeNode enumType = TypeParser.parseType(enumDescriptor);
      messages.put(
          enumType.reference().fullName(),
          Message.builder()
              .setType(enumType)
              .setName(name)
              .setFullProtoName(enumDescriptor.getFullName())
              .setEnumValues(
                  valueDescriptors.stream().map(v -> v.getName()).collect(Collectors.toList()),
                  valueDescriptors.stream().map(v -> v.getNumber()).collect(Collectors.toList()))
              .build());
    }
    return messages;
  }

  private static Map<String, Message> parseMessages(
      Descriptor messageDescriptor, Set<ResourceReference> outputResourceReferencesSeen) {
    return parseMessages(messageDescriptor, outputResourceReferencesSeen, new ArrayList<>());
  }

  private static Map<String, Message> parseMessages(
      Descriptor messageDescriptor,
      Set<ResourceReference> outputResourceReferencesSeen,
      List<String> outerNestedTypes) {
    Map<String, Message> messages = new HashMap<>();
    String messageName = messageDescriptor.getName();

    for (Descriptor nestedMessage : messageDescriptor.getNestedTypes()) {
      if (isMapType(nestedMessage)) {
        continue;
      }
      List<String> currentNestedTypes = new ArrayList<>(outerNestedTypes);
      currentNestedTypes.add(messageName);
      messages.putAll(
          parseMessages(nestedMessage, outputResourceReferencesSeen, currentNestedTypes));
    }
    TypeNode messageType = TypeParser.parseType(messageDescriptor);

    List<FieldDescriptor> fields = messageDescriptor.getFields();
    HashMap<String, String> operationRequestFields = new HashMap<>();
    BiMap<String, String> operationResponseFields = HashBiMap.create();
    OperationResponse.Builder operationResponse = null;
    for (FieldDescriptor fd : fields) {
      if (fd.getOptions().hasExtension(ExtendedOperationsProto.operationRequestField)) {
        String orf = fd.getOptions().getExtension(ExtendedOperationsProto.operationRequestField);
        operationRequestFields.put(orf, fd.getName());
      }
      if (fd.getOptions().hasExtension(ExtendedOperationsProto.operationResponseField)) {
        String orf = fd.getOptions().getExtension(ExtendedOperationsProto.operationResponseField);
        operationResponseFields.put(orf, fd.getName());
      }
      if (fd.getOptions().hasExtension(ExtendedOperationsProto.operationField)) {
        OperationResponseMapping orm =
            fd.getOptions().getExtension(ExtendedOperationsProto.operationField);
        if (operationResponse == null) {
          operationResponse = OperationResponse.builder();
        }
        if (orm.equals(OperationResponseMapping.NAME)) {
          operationResponse.setNameFieldName(fd.getName());
        } else if (orm.equals(OperationResponseMapping.STATUS)) {
          operationResponse.setStatusFieldName(fd.getName());
          operationResponse.setStatusFieldTypeName(fd.toProto().getTypeName());
        } else if (orm.equals(OperationResponseMapping.ERROR_CODE)) {
          operationResponse.setErrorCodeFieldName(fd.getName());
        } else if (orm.equals(OperationResponseMapping.ERROR_MESSAGE)) {
          operationResponse.setErrorMessageFieldName(fd.getName());
        }
      }
    }

    List<String> nestedEnums =
        messageDescriptor.getEnumTypes().stream()
            .map(EnumDescriptor::getName)
            .collect(ImmutableList.toImmutableList());

    messages.put(
        messageType.reference().fullName(),
        Message.builder()
            .setNestedEnums(nestedEnums)
            .setType(messageType)
            .setName(messageName)
            .setFullProtoName(messageDescriptor.getFullName())
            .setFields(parseFields(messageDescriptor, outputResourceReferencesSeen))
            .setOuterNestedTypes(outerNestedTypes)
            .setOperationRequestFields(operationRequestFields)
            .setOperationResponseFields(operationResponseFields)
            .setOperationResponse(operationResponse != null ? operationResponse.build() : null)
            .build());
    return messages;
  }

  private static boolean isMapType(Descriptor messageDescriptor) {
    List<String> fieldNames =
        messageDescriptor.getFields().stream().map(f -> f.getName()).collect(Collectors.toList());
    // Ends in "Entry" and has exactly two fields, named "key" and "value".
    return messageDescriptor.getName().endsWith("Entry")
        && fieldNames.size() == 2
        && fieldNames.get(0).equals("key")
        && fieldNames.get(1).equals("value");
  }

  /**
   * Populates ResourceName objects in Message POJOs.
   *
   * @param messageTypes A map of the message type name (as in the protobuf) to Message POJOs.
   * @param resources A list of ResourceName POJOs.
   * @return The updated messageTypes map.
   */
  public static Map<String, Message> updateResourceNamesInMessages(
      Map<String, Message> messageTypes, Collection<ResourceName> resources) {
    Map<String, Message> updatedMessages = new HashMap<>(messageTypes);
    for (ResourceName resource : resources) {
      if (!resource.hasParentMessageName()) {
        continue;
      }
      String messageKey = resource.parentMessageName();
      Message messageToUpdate = updatedMessages.get(messageKey);
      updatedMessages.put(messageKey, messageToUpdate.toBuilder().setResource(resource).build());
    }
    return updatedMessages;
  }

  public static Map<String, ResourceName> parseResourceNames(CodeGeneratorRequest request) {
    String javaPackage = parseServiceJavaPackage(request);
    Map<String, FileDescriptor> fileDescriptors = getFilesToGenerate(request);
    Map<String, ResourceName> resourceNames = new HashMap<>();
    for (String fileToGenerate : request.getFileToGenerateList()) {
      FileDescriptor fileDescriptor =
          Preconditions.checkNotNull(
              fileDescriptors.get(fileToGenerate),
              "Missing file descriptor for [%s]",
              fileToGenerate);
      resourceNames.putAll(parseResourceNames(fileDescriptor, javaPackage));
    }
    return resourceNames;
  }

  // Convenience wrapper for package-external unit tests. DO NOT ADD NEW FUNCTIONALITY HERE.
  public static Map<String, ResourceName> parseResourceNames(FileDescriptor fileDescriptor) {
    return parseResourceNames(fileDescriptor, TypeParser.getPackage(fileDescriptor));
  }

  public static Map<String, ResourceName> parseResourceNames(
      FileDescriptor fileDescriptor, String javaPackage) {
    return ResourceNameParser.parseResourceNames(fileDescriptor, javaPackage);
  }

  @VisibleForTesting
  static List<Method> parseMethods(
      ServiceDescriptor serviceDescriptor,
      String protoPackage,
      String servicePackage,
      Map<String, Message> messageTypes,
      Map<String, ResourceName> resourceNames,
      Optional<GapicServiceConfig> serviceConfigOpt,
      Optional<com.google.api.Service> serviceYamlProtoOpt,
      Set<ResourceName> outputArgResourceNames,
      Transport transport) {
    List<Method> methods = new ArrayList<>();

    // Parse the serviceYaml for autopopulated methods and fields once and put into a map
    Map<String, List<String>> autoPopulatedMethodsWithFields =
        parseAutoPopulatedMethodsAndFields(serviceYamlProtoOpt);
    for (MethodDescriptor protoMethod : serviceDescriptor.getMethods()) {
      SelectiveGapicType methodSelectiveGapicType =
          getMethodSelectiveGapicType(protoMethod, serviceYamlProtoOpt, protoPackage);
      // Skip generation for methods marked as HIDDEN
      if (methodSelectiveGapicType == SelectiveGapicType.HIDDEN) {
        continue;
      }
      // Parse the method.
      TypeNode inputType = TypeParser.parseType(protoMethod.getInputType());
      Method.Builder methodBuilder = Method.builder();
      if (protoMethod.getFile().toProto().hasSourceCodeInfo()) {
        SourceCodeInfoLocation protoMethodLocation =
            SOURCE_CODE_INFO_PARSER.getLocation(protoMethod);
        if (!Objects.isNull(protoMethodLocation)
            && !Strings.isNullOrEmpty(protoMethodLocation.getLeadingComments())) {
          methodBuilder.setDescription(protoMethodLocation.getLeadingComments());
        }
      }

      // Associate the autopopulated fields with the correct method
      List<String> autoPopulatedFields = new ArrayList<>();
      if (autoPopulatedMethodsWithFields.containsKey(protoMethod.getFullName())) {
        autoPopulatedFields = autoPopulatedMethodsWithFields.get(protoMethod.getFullName());
      }

      boolean isDeprecated = false;
      if (protoMethod.getOptions().hasDeprecated()) {
        isDeprecated = protoMethod.getOptions().getDeprecated();
      }

      Message inputMessage = messageTypes.get(inputType.reference().fullName());
      Preconditions.checkNotNull(
          inputMessage, String.format("No message found for %s", inputType.reference().fullName()));
      HttpBindings httpBindings = HttpRuleParser.parse(protoMethod, inputMessage, messageTypes);
      boolean isBatching =
          !serviceConfigOpt.isPresent()
              ? false
              : serviceConfigOpt
                  .get()
                  .hasBatchingSetting(
                      /* protoPakkage */ protoMethod.getFile().getPackage(),
                      serviceDescriptor.getName(),
                      protoMethod.getName());

      boolean operationPollingMethod =
          protoMethod.getOptions().hasExtension(ExtendedOperationsProto.operationPollingMethod)
              ? protoMethod
                  .getOptions()
                  .getExtension(ExtendedOperationsProto.operationPollingMethod)
              : false;
      RoutingHeaderRule routingHeaderRule =
          RoutingRuleParser.parse(protoMethod, inputMessage, messageTypes);
      methods.add(
          methodBuilder
              .setName(protoMethod.getName())
              .setInputType(inputType)
              .setOutputType(TypeParser.parseType(protoMethod.getOutputType()))
              .setIsInternalApi(methodSelectiveGapicType == SelectiveGapicType.INTERNAL)
              .setStream(
                  Method.toStream(protoMethod.isClientStreaming(), protoMethod.isServerStreaming()))
              .setLro(parseLro(servicePackage, protoMethod, messageTypes))
              .setMethodSignatures(
                  MethodSignatureParser.parseMethodSignatures(
                      protoMethod,
                      servicePackage,
                      inputType,
                      messageTypes,
                      resourceNames,
                      outputArgResourceNames))
              .setHttpBindings(httpBindings)
              .setAutoPopulatedFields(autoPopulatedFields)
              .setRoutingHeaderRule(routingHeaderRule)
              .setIsBatching(isBatching)
              .setPageSizeFieldName(parsePageSizeFieldName(protoMethod, messageTypes, transport))
              .setIsDeprecated(isDeprecated)
              .setOperationPollingMethod(operationPollingMethod)
              .build());

      // Any input type that has a resource reference will need a resource name helper class.
      for (Field field : inputMessage.fields()) {
        if (field.hasResourceReference()) {
          String resourceTypeString = field.resourceReference().resourceTypeString();
          ResourceName resourceName = null;
          // Support older resource_references that specify only the final typename, e.g. FooBar
          // versus example.com/FooBar.
          if (resourceTypeString.indexOf(SLASH) < 0) {
            Optional<String> actualResourceTypeNameOpt =
                resourceNames.keySet().stream()
                    .filter(k -> k.substring(k.lastIndexOf(SLASH) + 1).equals(resourceTypeString))
                    .findFirst();
            if (actualResourceTypeNameOpt.isPresent()) {
              resourceName = resourceNames.get(actualResourceTypeNameOpt.get());
            }
          } else {
            resourceName = resourceNames.get(resourceTypeString);
          }

          if (ResourceNameConstants.WILDCARD_PATTERN.equals(resourceTypeString)) {
            resourceName = WILDCARD_RESOURCE_NAME;
          } else {
            Preconditions.checkNotNull(
                resourceName,
                String.format(
                    "Resource name %s not found; parsing field %s in message %s in method %s",
                    resourceTypeString, field.name(), inputMessage.name(), protoMethod.getName()));
          }

          outputArgResourceNames.add(resourceName);
        }
      }
    }

    return methods;
  }

  private static String fetchTypeFullName(String typeName, MethodDescriptor methodDescriptor) {
    // When provided type name is fully qualified, return as-is
    // When only shortname is provided, assume same proto package as method (See
    // https://aip.dev/151)
    int lastDotIndex = typeName.lastIndexOf('.');
    boolean isResponseTypeNameShortOnly = lastDotIndex < 0;
    String responseTypeShortName =
        lastDotIndex >= 0 ? typeName.substring(lastDotIndex + 1) : typeName;
    String typeFullName =
        isResponseTypeNameShortOnly
            ? methodDescriptor.getFile().getPackage() + "." + responseTypeShortName
            : typeName;
    return typeFullName;
  }

  @VisibleForTesting
  static LongrunningOperation parseLro(
      String servicePackage, MethodDescriptor methodDescriptor, Map<String, Message> messageTypes) {
    MethodOptions methodOptions = methodDescriptor.getOptions();

    TypeNode operationServiceStubType = null;
    String responseTypeName = null;
    String metadataTypeName = null;

    if (methodOptions.hasExtension(OperationsProto.operationInfo)) {
      OperationInfo lroInfo =
          methodDescriptor.getOptions().getExtension(OperationsProto.operationInfo);
      responseTypeName = lroInfo.getResponseType();
      metadataTypeName = lroInfo.getMetadataType();
    }
    if (methodOptions.hasExtension(ExtendedOperationsProto.operationService)) {
      // TODO: support full package name for operations_service annotation value
      String opServiceName = methodOptions.getExtension(ExtendedOperationsProto.operationService);
      operationServiceStubType =
          TypeNode.withReference(
              VaporReference.builder()
                  .setName(opServiceName + "Stub")
                  .setPakkage(servicePackage + ".stub")
                  .build());

      if (responseTypeName == null) {
        responseTypeName = methodDescriptor.getOutputType().getFullName();
      }
      if (metadataTypeName == null) {
        metadataTypeName = methodDescriptor.getOutputType().getFullName();
      }
    }

    if (responseTypeName == null || metadataTypeName == null) {
      return null;
    }

    Message responseMessage = null;
    Message metadataMessage = null;

    String responseTypeFullName = fetchTypeFullName(responseTypeName, methodDescriptor);
    String metadataTypeFullName = fetchTypeFullName(metadataTypeName, methodDescriptor);

    // The messageTypes map keys to the Java fully-qualified name.
    for (Map.Entry<String, Message> messageEntry : messageTypes.entrySet()) {
      Message candidateMessage = messageEntry.getValue();
      if (responseMessage == null
          && candidateMessage.fullProtoName().equals(responseTypeFullName)) {
        responseMessage = candidateMessage;
      }
      if (metadataMessage == null
          && candidateMessage.fullProtoName().equals(metadataTypeFullName)) {
        metadataMessage = candidateMessage;
      }
    }

    Preconditions.checkNotNull(
        responseMessage,
        String.format(
            "LRO response message %s not found on method %s",
            responseTypeName, methodDescriptor.getName()));
    // TODO(miraleung): Check that the packages are equal if those strings are not empty.
    Preconditions.checkNotNull(
        metadataMessage,
        String.format(
            "LRO metadata message %s not found in method %s",
            metadataTypeName, methodDescriptor.getName()));

    return LongrunningOperation.builder()
        .setResponseType(responseMessage.type())
        .setMetadataType(metadataMessage.type())
        .setOperationServiceStubType(operationServiceStubType)
        .build();
  }

  @VisibleForTesting
  static String parsePageSizeFieldName(
      MethodDescriptor methodDescriptor, Map<String, Message> messageTypes, Transport transport) {
    TypeNode inputMessageType = TypeParser.parseType(methodDescriptor.getInputType());
    TypeNode outputMessageType = TypeParser.parseType(methodDescriptor.getOutputType());
    Message inputMessage = messageTypes.get(inputMessageType.reference().fullName());
    Message outputMessage = messageTypes.get(outputMessageType.reference().fullName());

    // This should technically handle the absence of either of these fields (aip.dev/158), but we
    // gate on their collective presence to ensure the generated surface is backawrds-compatible
    // with monolith-gnerated libraries.
    String pagedFieldName = null;

    if (inputMessage != null
        && inputMessage.fieldMap().containsKey("page_token")
        && outputMessage != null
        && outputMessage.fieldMap().containsKey("next_page_token")) {
      // List of potential field names representing page size.
      // page_size gets priority over max_results if both are present
      List<String> fieldNames = new ArrayList<>();
      fieldNames.add("page_size");
      if ((transport == Transport.REST)
          || (BIGQUERY_LEGACY_PAGINATION_ALLOWLIST.contains(methodDescriptor.getFullName()))) {
        fieldNames.add("max_results");
      }
      for (String fieldName : fieldNames) {
        if (pagedFieldName == null && inputMessage.fieldMap().containsKey(fieldName)) {
          pagedFieldName = fieldName;
        }
      }
    }
    return pagedFieldName;
  }

  @VisibleForTesting
  static String sanitizeDefaultHost(String rawDefaultHost) {
    if (rawDefaultHost.contains(COLON)) {
      // A port is already present, just return the existing string.
      return rawDefaultHost;
    }
    return String.format("%s:%s", rawDefaultHost, DEFAULT_PORT);
  }

  private static List<Field> parseFields(
      Descriptor messageDescriptor, Set<ResourceReference> outputResourceReferencesSeen) {
    List<FieldDescriptor> fields = new ArrayList<>(messageDescriptor.getFields());
    // Sort by ascending field index order. This is important for paged responses, where the first
    // repeated type is taken.
    fields.sort((f1, f2) -> f1.getIndex() - f2.getIndex());

    // Mirror protoc's name conflict resolution behavior for fields.
    // If a singular field's name equals that of a repeated field with "Count" or "List" suffixed,
    // append the protobuf's field number to both fields' names.
    // See:
    // https://github.com/protocolbuffers/protobuf/blob/9df42757f97da9f748a464deeda96427a8f7ade0/src/google/protobuf/compiler/java/java_context.cc#L60
    Map<String, Integer> repeatedFieldNamesToNumber =
        fields.stream()
            .filter(f -> f.isRepeated())
            .collect(Collectors.toMap(f -> f.getName(), f -> f.getNumber()));
    Set<Integer> fieldNumbersWithConflicts = new HashSet<>();
    for (FieldDescriptor field : fields) {
      Set<String> conflictingRepeatedFieldNames =
          repeatedFieldNamesToNumber.keySet().stream()
              .filter(
                  n -> field.getName().equals(n + "_count") || field.getName().equals(n + "_list"))
              .collect(Collectors.toSet());
      if (!conflictingRepeatedFieldNames.isEmpty()) {
        fieldNumbersWithConflicts.addAll(
            conflictingRepeatedFieldNames.stream()
                .map(n -> repeatedFieldNamesToNumber.get(n))
                .collect(Collectors.toSet()));
        fieldNumbersWithConflicts.add(field.getNumber());
      }
    }

    return fields.stream()
        .map(
            f ->
                parseField(
                    f,
                    messageDescriptor,
                    fieldNumbersWithConflicts.contains(f.getNumber()),
                    outputResourceReferencesSeen))
        .collect(Collectors.toList());
  }

  private static Field parseField(
      FieldDescriptor fieldDescriptor,
      Descriptor messageDescriptor,
      boolean hasFieldNameConflict,
      Set<ResourceReference> outputResourceReferencesSeen) {
    FieldOptions fieldOptions = fieldDescriptor.getOptions();
    MessageOptions messageOptions = messageDescriptor.getOptions();
    ResourceReference resourceReference = null;
    boolean isRequired = false;
    Format fieldInfoFormat = null;
    if (fieldOptions.hasExtension(ResourceProto.resourceReference)) {
      com.google.api.ResourceReference protoResourceReference =
          fieldOptions.getExtension(ResourceProto.resourceReference);
      // Assumes only one of type or child_type is set.
      String typeString = protoResourceReference.getType();
      String childTypeString = protoResourceReference.getChildType();
      Preconditions.checkState(
          !Strings.isNullOrEmpty(typeString) ^ !Strings.isNullOrEmpty(childTypeString),
          String.format(
              "Exactly one of type or child_type must be set for resource_reference in field %s",
              fieldDescriptor.getName()));
      boolean isChildType = !Strings.isNullOrEmpty(childTypeString);
      resourceReference =
          isChildType
              ? ResourceReference.withChildType(childTypeString)
              : ResourceReference.withType(typeString);
      outputResourceReferencesSeen.add(resourceReference);

    } else if (messageOptions.hasExtension(ResourceProto.resource)) {
      ResourceDescriptor protoResource = messageOptions.getExtension(ResourceProto.resource);
      // aip.dev/4231.
      String resourceFieldNameValue = ResourceNameConstants.NAME_FIELD_NAME;
      if (!Strings.isNullOrEmpty(protoResource.getNameField())) {
        resourceFieldNameValue = protoResource.getNameField();
      }
      if (fieldDescriptor.getName().equals(resourceFieldNameValue)) {
        resourceReference = ResourceReference.withType(protoResource.getType());
      }
    }

    if (fieldOptions.hasExtension(FieldInfoProto.fieldInfo)) {
      fieldInfoFormat = fieldOptions.getExtension(FieldInfoProto.fieldInfo).getFormat();
    }

    // Cannot directly check fieldOptions.hasExtension(FieldBehaviorProto.fieldBehavior) because the
    // default is null
    if (fieldOptions.getExtensionCount(FieldBehaviorProto.fieldBehavior) > 0
        && fieldOptions
            .getExtension(FieldBehaviorProto.fieldBehavior)
            .contains(FieldBehavior.REQUIRED)) {
      isRequired = true;
    }

    Field.Builder fieldBuilder = Field.builder();
    if (fieldDescriptor.getFile().toProto().hasSourceCodeInfo()) {
      SourceCodeInfoLocation protoFieldLocation =
          SOURCE_CODE_INFO_PARSER.getLocation(fieldDescriptor);
      if (!Objects.isNull(protoFieldLocation)
          && !Strings.isNullOrEmpty(protoFieldLocation.getLeadingComments())) {
        fieldBuilder.setDescription(protoFieldLocation.getLeadingComments());
      }
    }

    // Mirror protoc's name conflict resolution behavior for fields.
    // For more context, trace hasFieldNameConflict back to where it gets passed in above.
    String actualFieldName =
        hasFieldNameConflict
            ? fieldDescriptor.getName() + fieldDescriptor.getNumber()
            : fieldDescriptor.getName();

    return fieldBuilder
        .setName(actualFieldName)
        .setOriginalName(fieldDescriptor.getName())
        .setType(TypeParser.parseType(fieldDescriptor))
        .setIsMessage(fieldDescriptor.getJavaType() == FieldDescriptor.JavaType.MESSAGE)
        .setIsEnum(fieldDescriptor.getJavaType() == FieldDescriptor.JavaType.ENUM)
        .setIsContainedInOneof(fieldDescriptor.getRealContainingOneof() != null)
        .setIsProto3Optional(
            fieldDescriptor.getContainingOneof() != null
                && fieldDescriptor.getRealContainingOneof() == null)
        .setIsRepeated(fieldDescriptor.isRepeated())
        .setIsRequired(isRequired)
        .setFieldInfoFormat(fieldInfoFormat)
        .setIsMap(fieldDescriptor.isMapField())
        .setResourceReference(resourceReference)
        .build();
  }

  private static Map<String, FileDescriptor> getFilesToGenerate(CodeGeneratorRequest request) {
    // Build the fileDescriptors map so that we can create the FDs for the filesToGenerate.
    Map<String, FileDescriptor> fileDescriptors = Maps.newHashMap();
    for (FileDescriptorProto fileDescriptorProto : request.getProtoFileList()) {
      // Look up the imported files from previous file descriptors.  It is sufficient to look at
      // only previous file descriptors because CodeGeneratorRequest guarantees that the files
      // are sorted in topological order.
      FileDescriptor[] deps = new FileDescriptor[fileDescriptorProto.getDependencyCount()];
      for (int i = 0; i < fileDescriptorProto.getDependencyCount(); i++) {
        String name = fileDescriptorProto.getDependency(i);
        deps[i] =
            Preconditions.checkNotNull(
                fileDescriptors.get(name), "Missing file descriptor for [%s]", name);
      }

      FileDescriptor fileDescriptor = null;
      try {
        fileDescriptor = FileDescriptor.buildFrom(fileDescriptorProto, deps);
      } catch (DescriptorValidationException e) {
        throw new GapicParserException(e.getMessage());
      }

      fileDescriptors.put(fileDescriptor.getName(), fileDescriptor);
    }
    return fileDescriptors;
  }

  @VisibleForTesting
  static String parseServiceJavaPackage(CodeGeneratorRequest request) {
    Map<String, Integer> javaPackageCount = new HashMap<>();
    Map<String, FileDescriptor> fileDescriptors = getFilesToGenerate(request);
    for (String fileToGenerate : request.getFileToGenerateList()) {
      FileDescriptor fileDescriptor =
          Preconditions.checkNotNull(
              fileDescriptors.get(fileToGenerate),
              "Missing file descriptor for [%s]",
              fileToGenerate);

      String javaPackage = fileDescriptor.getOptions().getJavaPackage();
      if (Strings.isNullOrEmpty(javaPackage)) {
        continue;
      }
      if (javaPackageCount.containsKey(javaPackage)) {
        javaPackageCount.put(javaPackage, javaPackageCount.get(javaPackage) + 1);
      } else {
        javaPackageCount.put(javaPackage, 1);
      }
    }

    // Filter out mixin packages.
    Map<String, Integer> processedJavaPackageCount =
        javaPackageCount.entrySet().stream()
            .filter(e -> !MIXIN_JAVA_PACKAGE_ALLOWLIST.contains(e.getKey()))
            .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));

    // An empty map indicates that only mixin packages were present, which means that we're
    // generating a standalone client for a mixin.
    if (processedJavaPackageCount.isEmpty()) {
      processedJavaPackageCount = javaPackageCount;
    }

    String finalJavaPackage = "";
    Optional<Entry<String, Integer>> finalPackageEntry =
        processedJavaPackageCount.entrySet().stream().max(Map.Entry.comparingByValue());
    if (finalPackageEntry.isPresent()) {
      finalJavaPackage = finalPackageEntry.get().getKey();
    }
    return finalJavaPackage;
  }

  /**
   * Retrieves the nested type name from a fully-qualified protobuf type name. Example:
   * google.ads.googleads.v3.resources.MutateJob.MutateJobMetadata > MutateJob.MutateJobMetadata.
   */
  @VisibleForTesting
  static String parseNestedProtoTypeName(String fullyQualifiedName) {
    if (!fullyQualifiedName.contains(DOT)) {
      return fullyQualifiedName;
    }
    // Find the first component in CapitalCamelCase. Assumes that proto package
    // components must be in all lowercase and type names are in CapitalCamelCase.
    String[] components = fullyQualifiedName.split("\\.");
    List<String> nestedTypeComponents =
        IntStream.range(0, components.length)
            .filter(i -> Character.isUpperCase(components[i].charAt(0)))
            .mapToObj(i -> components[i])
            .collect(Collectors.toList());
    return String.join(".", nestedTypeComponents);
  }

  /**
   * Converts a serviceYaml file to a map of methods and autopopulated fields. Note: this does NOT
   * currently support wildcards in MethodSettings.selectors.
   */
  @VisibleForTesting
  static Map<String, List<String>> parseAutoPopulatedMethodsAndFields(
      Optional<com.google.api.Service> serviceYamlProtoOpt) {
    if (!hasMethodSettings(serviceYamlProtoOpt)) {
      return ImmutableMap.<String, List<String>>builder().build();
    }
    return serviceYamlProtoOpt.get().getPublishing().getMethodSettingsList().stream()
        .collect(
            Collectors.toMap(
                MethodSettings::getSelector, MethodSettings::getAutoPopulatedFieldsList));
  }

  @VisibleForTesting
  static boolean hasMethodSettings(Optional<com.google.api.Service> serviceYamlProtoOpt) {
    return serviceYamlProtoOpt.isPresent() && serviceYamlProtoOpt.get().hasPublishing();
  }
}
