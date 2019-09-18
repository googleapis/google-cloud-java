/*
 * Copyright 2017 Google LLC
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

import com.google.api.services.storage.model.Expr;
import com.google.api.services.storage.model.Policy.Bindings;
import com.google.cloud.*;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

import java.util.*;

/**
 * Helper for converting between the Policy model provided by the API and the Policy model provided
 * by this library.
 */
class PolicyHelper {

  static Policy convertFromApiPolicy(com.google.api.services.storage.model.Policy apiPolicy) {
    Policy.Builder policyBuilder = Policy.newBuilder();
    List<Binding> bindings = new ArrayList<>();
    for (Bindings binding : apiPolicy.getBindings()) {
      Binding.Builder bindingBuilder = Binding.newBuilder();
      bindingBuilder.setRole(Role.of(binding.getRole()));
      Set<Identity> identities = new HashSet<>();
      for (String member : binding.getMembers()) {
        identities.add(Identity.valueOf(member));
      }
      if (binding.getCondition() != null) {
        Condition.Builder conditionBuilder = Condition.newBuilder();
        conditionBuilder.setTitle(binding.getCondition().getTitle());
        conditionBuilder.setDescription(binding.getCondition().getDescription());
        conditionBuilder.setExpression(binding.getCondition().getExpression());
      }
      bindingBuilder.setIdentities(identities);
      bindings.add(bindingBuilder.build());
    }
    return policyBuilder.setBindingsV3(bindings).setEtag(apiPolicy.getEtag()).build();
  }

  static com.google.api.services.storage.model.Policy convertToApiPolicy(Policy policy) {
    List<Bindings> bindings = new ArrayList<>(policy.getBindingsV3().size());
    for (Binding binding : policy.getBindingsV3()) {
      Bindings newBinding = new Bindings().setRole(binding.getRole().getValue());
      List<String> members = new ArrayList<>(binding.getIdentities().size());
      for (Identity identity : binding.getIdentities()) {
        members.add(identity.strValue());
      }
      newBinding.setMembers(members);
      if (binding.getCondition() != null) {
        Condition condition = binding.getCondition();
        Expr expr = new Expr();
        expr.setExpression(condition.getExpression());
        expr.setTitle(condition.getTitle());
        expr.setDescription(condition.getDescription());
        newBinding.setCondition(expr);
      }
      bindings.add(newBinding);
    }
    return new com.google.api.services.storage.model.Policy()
            .setBindings(bindings)
            .setEtag(policy.getEtag());
  }

  private PolicyHelper() {
    // Intentionally left blank.
  }
}
