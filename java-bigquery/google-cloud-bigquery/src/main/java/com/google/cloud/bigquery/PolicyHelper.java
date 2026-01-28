/*
 * Copyright 2026 Google LLC
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
package com.google.cloud.bigquery;

import com.google.api.services.bigquery.model.Expr;
import com.google.cloud.Binding;
import com.google.cloud.Condition;
import com.google.cloud.Policy;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

class PolicyHelper {

  static Policy convertFromApiPolicy(com.google.api.services.bigquery.model.Policy apiPolicy) {
    Policy.Builder policyBuilder = Policy.newBuilder();
    List<com.google.api.services.bigquery.model.Binding> bindings = apiPolicy.getBindings();

    if (null != bindings) {
      ImmutableList.Builder<Binding> coreBindings = ImmutableList.builder();
      Binding.Builder bindingBuilder = Binding.newBuilder();
      for (com.google.api.services.bigquery.model.Binding binding : bindings) {
        bindingBuilder.setRole(binding.getRole());
        bindingBuilder.setMembers(binding.getMembers());
        if (binding.getCondition() != null) {
          Condition.Builder conditionBuilder = Condition.newBuilder();
          conditionBuilder.setTitle(binding.getCondition().getTitle());
          conditionBuilder.setDescription(binding.getCondition().getDescription());
          conditionBuilder.setExpression(binding.getCondition().getExpression());
          bindingBuilder.setCondition(conditionBuilder.build());
        }
        coreBindings.add(bindingBuilder.build());
      }
      policyBuilder.setBindings(coreBindings.build());
    }
    if (null != apiPolicy.getVersion()) {
      policyBuilder.setVersion(apiPolicy.getVersion());
    }
    return policyBuilder.setEtag(apiPolicy.getEtag()).build();
  }

  static com.google.api.services.bigquery.model.Policy convertToApiPolicy(Policy policy) {
    List<com.google.api.services.bigquery.model.Binding> bindings = null;
    if (policy.getBindingsList().size() != 0) {
      bindings = new ArrayList<>(policy.getBindingsList().size());

      for (Binding binding : policy.getBindingsList()) {
        com.google.api.services.bigquery.model.Binding apiBinding =
            new com.google.api.services.bigquery.model.Binding();
        apiBinding.setRole(binding.getRole());
        apiBinding.setMembers(new ArrayList<>(binding.getMembers()));
        if (binding.getCondition() != null) {
          Expr expr = new Expr();
          expr.setTitle(binding.getCondition().getTitle());
          expr.setDescription(binding.getCondition().getDescription());
          expr.setExpression(binding.getCondition().getExpression());
          apiBinding.setCondition(expr);
        }
        bindings.add(apiBinding);
      }
    }
    return new com.google.api.services.bigquery.model.Policy()
        .setBindings(bindings)
        .setEtag(policy.getEtag())
        .setVersion(policy.getVersion());
  }
}
