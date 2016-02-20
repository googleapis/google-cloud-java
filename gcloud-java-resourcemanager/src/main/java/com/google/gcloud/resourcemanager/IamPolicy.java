/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.gcloud.resourcemanager;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.gcloud.BaseIamPolicy;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Base class for Identity and Access Management (IAM) policies. IAM policies are used to specify
 * access settings for Cloud Platform resources. A Policy consists of a list of bindings. An binding
 * assigns a list of identities to a role, where the identities can be user accounts, Google groups,
 * Google domains, and service accounts. A role is a named list of permissions defined by IAM.
 *
 * @see <a href="https://cloud.google.com/iam/reference/rest/v1/Policy">Policy</a>
 */
public class IamPolicy extends BaseIamPolicy<String> implements Serializable {

  private static final long serialVersionUID = -5573557282693961850L;

  /**
   * Builder for an IAM Policy.
   */
  protected static class Builder extends BaseBuilder<String, Builder> {

    Builder() {}

    Builder(Map<String, List<Identity>> bindings, String etag, int version) {
      bindings(bindings).etag(etag).version(version);
    }

    @Override
    public IamPolicy build() {
      return new IamPolicy(this);
    }
  }

  private IamPolicy(Builder builder) {
    super(builder);
  }

  @Override
  public int hashCode() {
    return baseHashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof IamPolicy)) {
      return false;
    }
    IamPolicy other = (IamPolicy) obj;
    return Objects.equals(bindings(), other.bindings())
        && Objects.equals(etag(), other.etag())
        && Objects.equals(version(), other.version());
  }

  public static Builder builder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(bindings(), etag(), version());
  }

  static String identityToPb(Identity identity) {
    switch (identity.type()) {
      case ALL_USERS:
        return "allUsers";
      case ALL_AUTHENTICATED_USERS:
        return "allAuthenticatedUsers";
      case USER:
        return "user:" + identity.id();
      case SERVICE_ACCOUNT:
        return "serviceAccount:" + identity.id();
      case GROUP:
        return "group:" + identity.id();
      default:
        return "domain:" + identity.id();
    }
  }

  static Identity identityFromPb(String identityStr) {
    String[] info = identityStr.split(":");
    switch (info[0]) {
      case "allUsers":
        return Identity.allUsers();
      case "allAuthenticatedUsers":
        return Identity.allAuthenticatedUsers();
      case "user":
        return Identity.user(info[1]);
      case "serviceAccount":
        return Identity.serviceAccount(info[1]);
      case "group":
        return Identity.group(info[1]);
      case "domain":
        return Identity.domain(info[1]);
      default:
        throw new IllegalArgumentException("Unexpected identity type: " + info[0]);
    }
  }

  com.google.api.services.cloudresourcemanager.model.Policy toPb() {
    com.google.api.services.cloudresourcemanager.model.Policy policyPb =
        new com.google.api.services.cloudresourcemanager.model.Policy();
    List<com.google.api.services.cloudresourcemanager.model.Binding> bindingPbList =
        new LinkedList<>();
    for (Map.Entry<String, List<Identity>> binding : bindings().entrySet()) {
      com.google.api.services.cloudresourcemanager.model.Binding bindingPb =
          new com.google.api.services.cloudresourcemanager.model.Binding();
      bindingPb.setRole("roles/" + binding.getKey());
      bindingPb.setMembers(Lists.transform(binding.getValue(), new Function<Identity, String>() {
            @Override
            public String apply(Identity identity) {
              return identityToPb(identity);
            }
          }));
      bindingPbList.add(bindingPb);
    }
    policyPb.setBindings(bindingPbList);
    policyPb.setEtag(etag());
    policyPb.setVersion(version());
    return policyPb;
  }

  static IamPolicy fromPb(
      com.google.api.services.cloudresourcemanager.model.Policy policyPb) {
    Map<String, List<Identity>> bindings = new HashMap<>();
    for (com.google.api.services.cloudresourcemanager.model.Binding bindingPb :
        policyPb.getBindings()) {
      bindings.put(bindingPb.getRole().substring("roles/".length()),
          Lists.transform(bindingPb.getMembers(), new Function<String, Identity>() {
                @Override
                public Identity apply(String identityPb) {
                  return identityFromPb(identityPb);
                }
              }));
    }
    return new IamPolicy.Builder(bindings, policyPb.getEtag(), policyPb.getVersion()).build();
  }
}
