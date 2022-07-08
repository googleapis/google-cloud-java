/*
 * Copyright 2016 Google LLC
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

package com.google.cloud.resourcemanager;

import com.google.api.services.cloudresourcemanager.model.Binding;
import com.google.cloud.Identity;
import com.google.cloud.Policy;
import com.google.cloud.Policy.Marshaller;
import com.google.cloud.Role;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/** @deprecated v3 GAPIC client of ResourceManager is now available */
@Deprecated
final class PolicyMarshaller
    extends Marshaller<com.google.api.services.cloudresourcemanager.model.Policy> {

  static final PolicyMarshaller INSTANCE = new PolicyMarshaller();

  private PolicyMarshaller() {}

  private static class Builder extends Policy.Builder {

    private Builder(Map<Role, Set<Identity>> bindings, String etag, Integer version) {
      setBindings(bindings);
      setEtag(etag);
      if (version != null) {
        setVersion(version);
      }
    }
  }

  @Override
  protected Policy fromPb(com.google.api.services.cloudresourcemanager.model.Policy policyPb) {
    Map<Role, Set<Identity>> bindings = new HashMap<>();
    if (policyPb.getBindings() != null) {
      for (Binding bindingPb : policyPb.getBindings()) {
        bindings.put(
            Role.of(bindingPb.getRole()),
            ImmutableSet.copyOf(
                Lists.transform(
                    bindingPb.getMembers(),
                    new Function<String, Identity>() {
                      @Override
                      public Identity apply(String s) {
                        return IDENTITY_VALUE_OF_FUNCTION.apply(s);
                      }
                    })));
      }
    }
    return new Builder(bindings, policyPb.getEtag(), policyPb.getVersion()).build();
  }

  @Override
  protected com.google.api.services.cloudresourcemanager.model.Policy toPb(Policy policy) {
    com.google.api.services.cloudresourcemanager.model.Policy policyPb =
        new com.google.api.services.cloudresourcemanager.model.Policy();
    List<Binding> bindingPbList = new LinkedList<>();
    for (Map.Entry<Role, Set<Identity>> binding : policy.getBindings().entrySet()) {
      Binding bindingPb = new Binding();
      bindingPb.setRole(binding.getKey().getValue());
      bindingPb.setMembers(
          Lists.transform(
              new ArrayList<>(binding.getValue()),
              new Function<Identity, String>() {
                @Override
                public String apply(Identity identity) {
                  return IDENTITY_STR_VALUE_FUNCTION.apply(identity);
                }
              }));
      bindingPbList.add(bindingPb);
    }
    policyPb.setBindings(bindingPbList);
    policyPb.setEtag(policy.getEtag());
    policyPb.setVersion(policy.getVersion());
    return policyPb;
  }
}
