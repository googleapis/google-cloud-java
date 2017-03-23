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

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.api.services.storage.model.Policy;
import com.google.api.services.storage.model.Policy.Bindings;
import com.google.common.collect.ImmutableSet;

/**
 * Compares two {@link Policy} instances, which may have lists of {@link Bindings} that are not in
 * the same order but which are still logically equivalent.
 */
public class ApiPolicyComparator implements Comparator<Policy> {

  public static final ApiPolicyComparator INSTANCE = new ApiPolicyComparator();

  private ApiPolicyComparator() {
    // Intentionally left blank.
  }

  @Override
  public int compare(Policy p1, Policy p2) {
    int etagComparison = p1.getEtag().compareTo(p2.getEtag());
    if (etagComparison != 0) { return etagComparison; }
    
    Map<String, Set<String>> map1 = toMap(p1.getBindings());
    Map<String, Set<String>> map2 = toMap(p2.getBindings());
    
    if (map1.size() != map2.size()) {
      return map1.size() - map2.size();
    }
    
    for (Map.Entry<String, Set<String>> entry : map1.entrySet()) {
      String role = entry.getKey();
      Set<String> p1Members = entry.getValue();
      Set<String> p2Members = map2.get(role);
      if (p2Members == null) {
        return -1;
      }
      if (!p1Members.equals(p2Members)) {
        return p1Members.toString().compareTo(p2Members.toString());
      }
    }
    
    return 0;
  }

  private Map<String, Set<String>> toMap(List<Bindings> bindings) {
    Map<String, Set<String>> mapBindings = new HashMap<>();
    for (Bindings binding : bindings) {
      mapBindings.put(binding.getRole(), ImmutableSet.copyOf(binding.getMembers()));
    }
    
    return mapBindings;
  }
}
