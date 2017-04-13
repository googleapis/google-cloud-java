/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

package com.google.cloud.storage;

import com.google.api.services.storage.model.Policy.Bindings;
import com.google.cloud.Identity;
import com.google.cloud.Policy;
import com.google.cloud.Role;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Helper for converting between the Policy model provided by the API and the Policy model provided
 * by this library.
 */
class PolicyHelper {

  static Policy convertFromApiPolicy(com.google.api.services.storage.model.Policy apiPolicy) {
    Policy.Builder policyBuilder = Policy.newBuilder();
    for (Bindings binding : apiPolicy.getBindings()) {
      for (String member : binding.getMembers()) {
        policyBuilder.addIdentity(Role.of(binding.getRole()), Identity.valueOf(member));
      }
    }
    return policyBuilder.setEtag(apiPolicy.getEtag()).build();
  }

  static com.google.api.services.storage.model.Policy convertToApiPolicy(Policy policy) {
    List<Bindings> bindings = new ArrayList<>(policy.getBindings().size());
    for (Map.Entry<Role, Set<Identity>> entry : policy.getBindings().entrySet()) {
      List<String> members = new ArrayList<>(entry.getValue().size());
      for (Identity identity : entry.getValue()) {
        members.add(identity.strValue());
      }
      bindings.add(new Bindings().setMembers(members).setRole(entry.getKey().getValue()));
    }
    return new com.google.api.services.storage.model.Policy()
        .setBindings(bindings)
        .setEtag(policy.getEtag());
  }

  private PolicyHelper() {
    // Intentionally left blank.
  }
}
