/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1;

import com.google.api.core.BetaApi;
import com.google.api.gax.httpjson.ApiMessage;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
public final class BackendService implements ApiMessage {
  private final Integer affinityCookieTtlSec;
  private final List<Backend> backends;
  private final BackendServiceCdnPolicy cdnPolicy;
  private final ConnectionDraining connectionDraining;
  private final String creationTimestamp;
  private final String description;
  private final Boolean enableCDN;
  private final String fingerprint;
  private final List<String> healthChecks;
  private final BackendServiceIAP iap;
  private final String id;
  private final String kind;
  private final String loadBalancingScheme;
  private final String name;
  private final Integer port;
  private final String portName;
  private final String protocol;
  private final String region;
  private final String securityPolicy;
  private final String selfLink;
  private final String sessionAffinity;
  private final Integer timeoutSec;

  private BackendService() {
    this.affinityCookieTtlSec = null;
    this.backends = null;
    this.cdnPolicy = null;
    this.connectionDraining = null;
    this.creationTimestamp = null;
    this.description = null;
    this.enableCDN = null;
    this.fingerprint = null;
    this.healthChecks = null;
    this.iap = null;
    this.id = null;
    this.kind = null;
    this.loadBalancingScheme = null;
    this.name = null;
    this.port = null;
    this.portName = null;
    this.protocol = null;
    this.region = null;
    this.securityPolicy = null;
    this.selfLink = null;
    this.sessionAffinity = null;
    this.timeoutSec = null;
  }

  private BackendService(
      Integer affinityCookieTtlSec,
      List<Backend> backends,
      BackendServiceCdnPolicy cdnPolicy,
      ConnectionDraining connectionDraining,
      String creationTimestamp,
      String description,
      Boolean enableCDN,
      String fingerprint,
      List<String> healthChecks,
      BackendServiceIAP iap,
      String id,
      String kind,
      String loadBalancingScheme,
      String name,
      Integer port,
      String portName,
      String protocol,
      String region,
      String securityPolicy,
      String selfLink,
      String sessionAffinity,
      Integer timeoutSec) {
    this.affinityCookieTtlSec = affinityCookieTtlSec;
    this.backends = backends;
    this.cdnPolicy = cdnPolicy;
    this.connectionDraining = connectionDraining;
    this.creationTimestamp = creationTimestamp;
    this.description = description;
    this.enableCDN = enableCDN;
    this.fingerprint = fingerprint;
    this.healthChecks = healthChecks;
    this.iap = iap;
    this.id = id;
    this.kind = kind;
    this.loadBalancingScheme = loadBalancingScheme;
    this.name = name;
    this.port = port;
    this.portName = portName;
    this.protocol = protocol;
    this.region = region;
    this.securityPolicy = securityPolicy;
    this.selfLink = selfLink;
    this.sessionAffinity = sessionAffinity;
    this.timeoutSec = timeoutSec;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("affinityCookieTtlSec")) {
      return affinityCookieTtlSec;
    }
    if (fieldName.equals("backends")) {
      return backends;
    }
    if (fieldName.equals("cdnPolicy")) {
      return cdnPolicy;
    }
    if (fieldName.equals("connectionDraining")) {
      return connectionDraining;
    }
    if (fieldName.equals("creationTimestamp")) {
      return creationTimestamp;
    }
    if (fieldName.equals("description")) {
      return description;
    }
    if (fieldName.equals("enableCDN")) {
      return enableCDN;
    }
    if (fieldName.equals("fingerprint")) {
      return fingerprint;
    }
    if (fieldName.equals("healthChecks")) {
      return healthChecks;
    }
    if (fieldName.equals("iap")) {
      return iap;
    }
    if (fieldName.equals("id")) {
      return id;
    }
    if (fieldName.equals("kind")) {
      return kind;
    }
    if (fieldName.equals("loadBalancingScheme")) {
      return loadBalancingScheme;
    }
    if (fieldName.equals("name")) {
      return name;
    }
    if (fieldName.equals("port")) {
      return port;
    }
    if (fieldName.equals("portName")) {
      return portName;
    }
    if (fieldName.equals("protocol")) {
      return protocol;
    }
    if (fieldName.equals("region")) {
      return region;
    }
    if (fieldName.equals("securityPolicy")) {
      return securityPolicy;
    }
    if (fieldName.equals("selfLink")) {
      return selfLink;
    }
    if (fieldName.equals("sessionAffinity")) {
      return sessionAffinity;
    }
    if (fieldName.equals("timeoutSec")) {
      return timeoutSec;
    }
    return null;
  }

  @Nullable
  @Override
  public ApiMessage getApiMessageRequestBody() {
    return null;
  }

  @Nullable
  @Override
  public List<String> getFieldMask() {
    return null;
  }

  public Integer getAffinityCookieTtlSec() {
    return affinityCookieTtlSec;
  }

  public List<Backend> getBackendsList() {
    return backends;
  }

  public BackendServiceCdnPolicy getCdnPolicy() {
    return cdnPolicy;
  }

  public ConnectionDraining getConnectionDraining() {
    return connectionDraining;
  }

  public String getCreationTimestamp() {
    return creationTimestamp;
  }

  public String getDescription() {
    return description;
  }

  public Boolean getEnableCDN() {
    return enableCDN;
  }

  public String getFingerprint() {
    return fingerprint;
  }

  public List<String> getHealthChecksList() {
    return healthChecks;
  }

  public BackendServiceIAP getIap() {
    return iap;
  }

  public String getId() {
    return id;
  }

  public String getKind() {
    return kind;
  }

  public String getLoadBalancingScheme() {
    return loadBalancingScheme;
  }

  public String getName() {
    return name;
  }

  public Integer getPort() {
    return port;
  }

  public String getPortName() {
    return portName;
  }

  public String getProtocol() {
    return protocol;
  }

  public String getRegion() {
    return region;
  }

  public String getSecurityPolicy() {
    return securityPolicy;
  }

  public String getSelfLink() {
    return selfLink;
  }

  public String getSessionAffinity() {
    return sessionAffinity;
  }

  public Integer getTimeoutSec() {
    return timeoutSec;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(BackendService prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static BackendService getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final BackendService DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new BackendService();
  }

  public static class Builder {
    private Integer affinityCookieTtlSec;
    private List<Backend> backends;
    private BackendServiceCdnPolicy cdnPolicy;
    private ConnectionDraining connectionDraining;
    private String creationTimestamp;
    private String description;
    private Boolean enableCDN;
    private String fingerprint;
    private List<String> healthChecks;
    private BackendServiceIAP iap;
    private String id;
    private String kind;
    private String loadBalancingScheme;
    private String name;
    private Integer port;
    private String portName;
    private String protocol;
    private String region;
    private String securityPolicy;
    private String selfLink;
    private String sessionAffinity;
    private Integer timeoutSec;

    Builder() {}

    public Builder mergeFrom(BackendService other) {
      if (other == BackendService.getDefaultInstance()) return this;
      if (other.getAffinityCookieTtlSec() != null) {
        this.affinityCookieTtlSec = other.affinityCookieTtlSec;
      }
      if (other.getBackendsList() != null) {
        this.backends = other.backends;
      }
      if (other.getCdnPolicy() != null) {
        this.cdnPolicy = other.cdnPolicy;
      }
      if (other.getConnectionDraining() != null) {
        this.connectionDraining = other.connectionDraining;
      }
      if (other.getCreationTimestamp() != null) {
        this.creationTimestamp = other.creationTimestamp;
      }
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getEnableCDN() != null) {
        this.enableCDN = other.enableCDN;
      }
      if (other.getFingerprint() != null) {
        this.fingerprint = other.fingerprint;
      }
      if (other.getHealthChecksList() != null) {
        this.healthChecks = other.healthChecks;
      }
      if (other.getIap() != null) {
        this.iap = other.iap;
      }
      if (other.getId() != null) {
        this.id = other.id;
      }
      if (other.getKind() != null) {
        this.kind = other.kind;
      }
      if (other.getLoadBalancingScheme() != null) {
        this.loadBalancingScheme = other.loadBalancingScheme;
      }
      if (other.getName() != null) {
        this.name = other.name;
      }
      if (other.getPort() != null) {
        this.port = other.port;
      }
      if (other.getPortName() != null) {
        this.portName = other.portName;
      }
      if (other.getProtocol() != null) {
        this.protocol = other.protocol;
      }
      if (other.getRegion() != null) {
        this.region = other.region;
      }
      if (other.getSecurityPolicy() != null) {
        this.securityPolicy = other.securityPolicy;
      }
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      if (other.getSessionAffinity() != null) {
        this.sessionAffinity = other.sessionAffinity;
      }
      if (other.getTimeoutSec() != null) {
        this.timeoutSec = other.timeoutSec;
      }
      return this;
    }

    Builder(BackendService source) {
      this.affinityCookieTtlSec = source.affinityCookieTtlSec;
      this.backends = source.backends;
      this.cdnPolicy = source.cdnPolicy;
      this.connectionDraining = source.connectionDraining;
      this.creationTimestamp = source.creationTimestamp;
      this.description = source.description;
      this.enableCDN = source.enableCDN;
      this.fingerprint = source.fingerprint;
      this.healthChecks = source.healthChecks;
      this.iap = source.iap;
      this.id = source.id;
      this.kind = source.kind;
      this.loadBalancingScheme = source.loadBalancingScheme;
      this.name = source.name;
      this.port = source.port;
      this.portName = source.portName;
      this.protocol = source.protocol;
      this.region = source.region;
      this.securityPolicy = source.securityPolicy;
      this.selfLink = source.selfLink;
      this.sessionAffinity = source.sessionAffinity;
      this.timeoutSec = source.timeoutSec;
    }

    public Integer getAffinityCookieTtlSec() {
      return affinityCookieTtlSec;
    }

    public Builder setAffinityCookieTtlSec(Integer affinityCookieTtlSec) {
      this.affinityCookieTtlSec = affinityCookieTtlSec;
      return this;
    }

    public List<Backend> getBackendsList() {
      return backends;
    }

    public Builder addAllBackends(List<Backend> backends) {
      if (this.backends == null) {
        this.backends = new LinkedList<>();
      }
      this.backends.addAll(backends);
      return this;
    }

    public Builder addBackends(Backend backends) {
      if (this.backends == null) {
        this.backends = new LinkedList<>();
      }
      this.backends.add(backends);
      return this;
    }

    public BackendServiceCdnPolicy getCdnPolicy() {
      return cdnPolicy;
    }

    public Builder setCdnPolicy(BackendServiceCdnPolicy cdnPolicy) {
      this.cdnPolicy = cdnPolicy;
      return this;
    }

    public ConnectionDraining getConnectionDraining() {
      return connectionDraining;
    }

    public Builder setConnectionDraining(ConnectionDraining connectionDraining) {
      this.connectionDraining = connectionDraining;
      return this;
    }

    public String getCreationTimestamp() {
      return creationTimestamp;
    }

    public Builder setCreationTimestamp(String creationTimestamp) {
      this.creationTimestamp = creationTimestamp;
      return this;
    }

    public String getDescription() {
      return description;
    }

    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    public Boolean getEnableCDN() {
      return enableCDN;
    }

    public Builder setEnableCDN(Boolean enableCDN) {
      this.enableCDN = enableCDN;
      return this;
    }

    public String getFingerprint() {
      return fingerprint;
    }

    public Builder setFingerprint(String fingerprint) {
      this.fingerprint = fingerprint;
      return this;
    }

    public List<String> getHealthChecksList() {
      return healthChecks;
    }

    public Builder addAllHealthChecks(List<String> healthChecks) {
      if (this.healthChecks == null) {
        this.healthChecks = new LinkedList<>();
      }
      this.healthChecks.addAll(healthChecks);
      return this;
    }

    public Builder addHealthChecks(String healthChecks) {
      if (this.healthChecks == null) {
        this.healthChecks = new LinkedList<>();
      }
      this.healthChecks.add(healthChecks);
      return this;
    }

    public BackendServiceIAP getIap() {
      return iap;
    }

    public Builder setIap(BackendServiceIAP iap) {
      this.iap = iap;
      return this;
    }

    public String getId() {
      return id;
    }

    public Builder setId(String id) {
      this.id = id;
      return this;
    }

    public String getKind() {
      return kind;
    }

    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    public String getLoadBalancingScheme() {
      return loadBalancingScheme;
    }

    public Builder setLoadBalancingScheme(String loadBalancingScheme) {
      this.loadBalancingScheme = loadBalancingScheme;
      return this;
    }

    public String getName() {
      return name;
    }

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public Integer getPort() {
      return port;
    }

    public Builder setPort(Integer port) {
      this.port = port;
      return this;
    }

    public String getPortName() {
      return portName;
    }

    public Builder setPortName(String portName) {
      this.portName = portName;
      return this;
    }

    public String getProtocol() {
      return protocol;
    }

    public Builder setProtocol(String protocol) {
      this.protocol = protocol;
      return this;
    }

    public String getRegion() {
      return region;
    }

    public Builder setRegion(String region) {
      this.region = region;
      return this;
    }

    public String getSecurityPolicy() {
      return securityPolicy;
    }

    public Builder setSecurityPolicy(String securityPolicy) {
      this.securityPolicy = securityPolicy;
      return this;
    }

    public String getSelfLink() {
      return selfLink;
    }

    public Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    public String getSessionAffinity() {
      return sessionAffinity;
    }

    public Builder setSessionAffinity(String sessionAffinity) {
      this.sessionAffinity = sessionAffinity;
      return this;
    }

    public Integer getTimeoutSec() {
      return timeoutSec;
    }

    public Builder setTimeoutSec(Integer timeoutSec) {
      this.timeoutSec = timeoutSec;
      return this;
    }

    public BackendService build() {

      return new BackendService(
          affinityCookieTtlSec,
          backends,
          cdnPolicy,
          connectionDraining,
          creationTimestamp,
          description,
          enableCDN,
          fingerprint,
          healthChecks,
          iap,
          id,
          kind,
          loadBalancingScheme,
          name,
          port,
          portName,
          protocol,
          region,
          securityPolicy,
          selfLink,
          sessionAffinity,
          timeoutSec);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setAffinityCookieTtlSec(this.affinityCookieTtlSec);
      newBuilder.addAllBackends(this.backends);
      newBuilder.setCdnPolicy(this.cdnPolicy);
      newBuilder.setConnectionDraining(this.connectionDraining);
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setDescription(this.description);
      newBuilder.setEnableCDN(this.enableCDN);
      newBuilder.setFingerprint(this.fingerprint);
      newBuilder.addAllHealthChecks(this.healthChecks);
      newBuilder.setIap(this.iap);
      newBuilder.setId(this.id);
      newBuilder.setKind(this.kind);
      newBuilder.setLoadBalancingScheme(this.loadBalancingScheme);
      newBuilder.setName(this.name);
      newBuilder.setPort(this.port);
      newBuilder.setPortName(this.portName);
      newBuilder.setProtocol(this.protocol);
      newBuilder.setRegion(this.region);
      newBuilder.setSecurityPolicy(this.securityPolicy);
      newBuilder.setSelfLink(this.selfLink);
      newBuilder.setSessionAffinity(this.sessionAffinity);
      newBuilder.setTimeoutSec(this.timeoutSec);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "BackendService{"
        + "affinityCookieTtlSec="
        + affinityCookieTtlSec
        + ", "
        + "backends="
        + backends
        + ", "
        + "cdnPolicy="
        + cdnPolicy
        + ", "
        + "connectionDraining="
        + connectionDraining
        + ", "
        + "creationTimestamp="
        + creationTimestamp
        + ", "
        + "description="
        + description
        + ", "
        + "enableCDN="
        + enableCDN
        + ", "
        + "fingerprint="
        + fingerprint
        + ", "
        + "healthChecks="
        + healthChecks
        + ", "
        + "iap="
        + iap
        + ", "
        + "id="
        + id
        + ", "
        + "kind="
        + kind
        + ", "
        + "loadBalancingScheme="
        + loadBalancingScheme
        + ", "
        + "name="
        + name
        + ", "
        + "port="
        + port
        + ", "
        + "portName="
        + portName
        + ", "
        + "protocol="
        + protocol
        + ", "
        + "region="
        + region
        + ", "
        + "securityPolicy="
        + securityPolicy
        + ", "
        + "selfLink="
        + selfLink
        + ", "
        + "sessionAffinity="
        + sessionAffinity
        + ", "
        + "timeoutSec="
        + timeoutSec
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof BackendService) {
      BackendService that = (BackendService) o;
      return Objects.equals(this.affinityCookieTtlSec, that.getAffinityCookieTtlSec())
          && Objects.equals(this.backends, that.getBackendsList())
          && Objects.equals(this.cdnPolicy, that.getCdnPolicy())
          && Objects.equals(this.connectionDraining, that.getConnectionDraining())
          && Objects.equals(this.creationTimestamp, that.getCreationTimestamp())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.enableCDN, that.getEnableCDN())
          && Objects.equals(this.fingerprint, that.getFingerprint())
          && Objects.equals(this.healthChecks, that.getHealthChecksList())
          && Objects.equals(this.iap, that.getIap())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.loadBalancingScheme, that.getLoadBalancingScheme())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.port, that.getPort())
          && Objects.equals(this.portName, that.getPortName())
          && Objects.equals(this.protocol, that.getProtocol())
          && Objects.equals(this.region, that.getRegion())
          && Objects.equals(this.securityPolicy, that.getSecurityPolicy())
          && Objects.equals(this.selfLink, that.getSelfLink())
          && Objects.equals(this.sessionAffinity, that.getSessionAffinity())
          && Objects.equals(this.timeoutSec, that.getTimeoutSec());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        affinityCookieTtlSec,
        backends,
        cdnPolicy,
        connectionDraining,
        creationTimestamp,
        description,
        enableCDN,
        fingerprint,
        healthChecks,
        iap,
        id,
        kind,
        loadBalancingScheme,
        name,
        port,
        portName,
        protocol,
        region,
        securityPolicy,
        selfLink,
        sessionAffinity,
        timeoutSec);
  }
}
