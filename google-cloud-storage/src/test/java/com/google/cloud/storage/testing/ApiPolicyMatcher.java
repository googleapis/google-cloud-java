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

package com.google.cloud.storage.testing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.easymock.EasyMock;
import org.easymock.IArgumentMatcher;

import com.google.api.services.storage.model.Policy;
import com.google.api.services.storage.model.Policy.Bindings;
import com.google.common.collect.ImmutableSet;

/**
 * Matches two {@link Policy} instances, which may have lists of {@link Bindings} that are not in
 * the same order but which are still logically equivalent.
 */
public class ApiPolicyMatcher implements IArgumentMatcher {

  private final Map<String, Set<String>> expectedBindings;
  private final String expectedEtag;

  public ApiPolicyMatcher(Policy expected) {
    expectedBindings = toMap(expected.getBindings());
    expectedEtag = expected.getEtag();
  }

  @Override
  public boolean matches(Object object) {
    if (!(object instanceof Policy)) {
      return false;
    }
    Policy actual = (Policy) object;
    Map<String, Set<String>> actualBindings = toMap(actual.getBindings());
    String actualEtag = actual.getEtag();

    if (expectedEtag == null) {
      if (actualEtag != null) {
        return false;
      }
    } else {
      if (!expectedEtag.equals(actual.getEtag())) {
        return false;
      }
    }

    if (expectedBindings.size() != actualBindings.size()) {
      return false;
    }
    
    for (Map.Entry<String, Set<String>> entry : expectedBindings.entrySet()) {
      String role = entry.getKey();
      Set<String> expectedMembers = entry.getValue();
      Set<String> actualMembers = actualBindings.get(role);
      if (!expectedMembers.equals(actualMembers)) {
        return false;
      }
    }
    
    return true;
  }

  @Override
  public void appendTo(StringBuffer buffer) {
    buffer.append("eqApiPolicy(");
    buffer.append("etag=");
    buffer.append(expectedEtag);
    buffer.append(",bindings=");
    buffer.append(expectedBindings);
    buffer.append(")");
  }

  public static Policy eqApiPolicy(Policy in) {
    EasyMock.reportMatcher(new ApiPolicyMatcher(in));
    return null;
  }

  private Map<String, Set<String>> toMap(List<Bindings> bindings) {
    Map<String, Set<String>> mapBindings = new HashMap<>();
    if (bindings != null) {
      for (Bindings binding : bindings) {
        mapBindings.put(binding.getRole(), ImmutableSet.copyOf(binding.getMembers()));
      }
    }
    return mapBindings;
  }
}
