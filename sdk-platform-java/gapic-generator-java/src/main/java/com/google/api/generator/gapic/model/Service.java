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

import com.google.api.generator.engine.ast.TypeNode;
import com.google.auto.value.AutoValue;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import java.util.List;
import javax.annotation.Nullable;

@AutoValue
public abstract class Service {
  public abstract String name();

  @Nullable
  public abstract String apiVersion();

  public abstract String defaultHost();

  public abstract ImmutableList<String> oauthScopes();

  public abstract String pakkage();

  public abstract String protoPakkage();

  // For compatibility with other protoc-plugin code generators, e.g. gRPC.
  public abstract String originalJavaPackage();

  // New Java class name as defined in gapic.yaml's language settings.
  public abstract String overriddenName();

  public abstract boolean isDeprecated();

  public abstract ImmutableList<Method> methods();

  @Nullable
  public abstract String description();

  public boolean hasDescription() {
    return !Strings.isNullOrEmpty(description());
  }

  public boolean hasApiVersion() {
    return !Strings.isNullOrEmpty(apiVersion());
  }

  public String hostServiceName() {
    // Host Service Name is guaranteed to exist and be non-null and non-empty
    // Parser will fail if the default host is not supplied
    return parseHostServiceName(defaultHost());
  }

  public String apiShortName() {
    if (!Strings.isNullOrEmpty(defaultHost())) {
      return parseApiShortName(defaultHost());
    }
    return "";
  }

  public String packageVersion() {
    if (!Strings.isNullOrEmpty(protoPakkage())) {
      return parsePackageVersion(protoPakkage());
    }
    return "";
  }

  public Method operationPollingMethod() {
    for (Method method : methods()) {
      if (method.isOperationPollingMethod()) {
        return method;
      }
    }
    return null;
  }

  public TypeNode operationServiceStubType() {
    for (Method method : methods()) {
      if (method.hasLro() && method.lro().operationServiceStubType() != null) {
        // All methods within the same service must have the same operationServiceTypeName if
        // present
        return method.lro().operationServiceStubType();
      }
    }
    return null;
  }

  public TypeNode operationType() {
    for (Method method : methods()) {
      if (method.hasLro() && method.lro().operationServiceStubType() != null) {
        return method.outputType();
      }
    }
    return null;
  }

  public boolean hasLroMethods() {
    for (Method method : methods()) {
      if (method.hasLro()) {
        return true;
      }
    }
    return false;
  }

  public boolean hasStandardLroMethods() {
    for (Method method : methods()) {
      if (method.hasLro() && method.lro().operationServiceStubType() == null) {
        return true;
      }
    }
    return false;
  }

  /**
   * Wrapper for hasAnyEnabledMethodsForTransport(Transport). Some invocations are called with
   * `gRPC` which can't match with the correct Transport (GRPC)
   *
   * @param transportName String transport value
   * @return boolean if service contains any enabled methods for a transport
   */
  public boolean hasAnyEnabledMethodsForTransport(String transportName) {
    return hasAnyEnabledMethodsForTransport(Transport.parse(transportName));
  }

  /**
   * Determines if a Service contains any methods that are both eligible and enabled for the
   * Transport. GRPC+REST Transport is not supported as each transport's sub composers will invoke
   * this method the specific transport (GRPC or REST)
   *
   * @param transport Expects either GRPC or REST Transport
   * @return boolean if service contains any enabled methods for a transport
   */
  public boolean hasAnyEnabledMethodsForTransport(Transport transport) {
    if (transport == Transport.GRPC_REST) {
      throw new IllegalArgumentException(
          String.format("Invalid Transport: %s. Expecting GRPC or REST", transport.name()));
    }
    return methods().stream().anyMatch(x -> x.isSupportedByTransport(transport));
  }

  public abstract Builder toBuilder();

  public static Builder builder() {
    return new AutoValue_Service.Builder().setMethods(ImmutableList.of()).setIsDeprecated(false);
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder setName(String name);

    public abstract Builder setOverriddenName(String overriddenName);

    public abstract Builder setApiVersion(String apiVersion);

    public abstract Builder setDefaultHost(String defaultHost);

    public abstract Builder setOauthScopes(List<String> oauthScopes);

    public abstract Builder setPakkage(String pakkage);

    public abstract Builder setProtoPakkage(String pakkage);

    public abstract Builder setOriginalJavaPackage(String originalJavaPackage);

    public abstract Builder setIsDeprecated(boolean isDeprecated);

    public abstract Builder setMethods(List<Method> methods);

    public abstract Builder setDescription(String description);

    public abstract Service build();
  }

  private static String parsePackageVersion(String protoPackage) {
    //  parse protoPackage for packageVersion
    String[] pakkage = protoPackage.split("\\.");
    String packageVersion;
    //  e.g. v1, v2, v1beta1
    if (pakkage[pakkage.length - 1].matches("v[0-9].*")) {
      packageVersion = pakkage[pakkage.length - 1];
    } else {
      packageVersion = "";
    }
    return packageVersion;
  }

  // Parse the service name from the default host configured in the protos
  // or service yaml file. For Google Cloud Services, the default host value
  // is expected to contain `.googleapis.com`. Exceptions may exist (i.e. localhost),
  // in which case we will return an empty string.
  private static String parseHostServiceName(String defaultHost) {
    if (defaultHost.contains(".googleapis.com")) {
      return Iterables.getFirst(Splitter.on(".").split(defaultHost), defaultHost);
    }
    return "";
  }

  // Parse defaultHost for apiShortName for the RegionTag. Need to account for regional default
  // endpoints like
  // "us-east1-pubsub.googleapis.com".
  private static String parseApiShortName(String defaultHost) {
    // If the defaultHost is of the format "**.googleapis.com", take the name before the first
    // period.
    String apiShortName = Iterables.getFirst(Splitter.on(".").split(defaultHost), defaultHost);
    // If the defaultHost is of the format "**-**-**.googleapis.com", take the section before the
    // first period and after the last dash to follow CSharp's implementation here:
    // https://github.com/googleapis/gapic-generator-csharp/blob/main/Google.Api.Generator/Generation/ServiceDetails.cs#L70
    apiShortName = Iterables.getLast(Splitter.on("-").split(apiShortName), defaultHost);
    // `iam-meta-api` service is an exceptional case and is handled as a one-off
    if (defaultHost.contains("iam-meta-api")) {
      apiShortName = "iam";
    }
    return apiShortName;
  }
}
