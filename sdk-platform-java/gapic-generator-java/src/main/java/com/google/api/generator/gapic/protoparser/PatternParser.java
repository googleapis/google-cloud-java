// Copyright 2022 Google LLC
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

import com.google.api.pathtemplate.PathTemplate;
import com.google.common.collect.ImmutableSortedSet;
import java.util.Set;

public class PatternParser {

  // This method tries to parse all named segments from pattern and sort in natual order
  // e.g. /v1beta1/{table_name=tests/*}/{routing_id=instances/*}/** -> (routing_id, table_name)
  public static Set<String> getPatternBindings(String pattern) {
    ImmutableSortedSet.Builder<String> bindings = ImmutableSortedSet.naturalOrder();
    if (pattern.isEmpty()) {
      return bindings.build();
    }

    PathTemplate template = PathTemplate.create(pattern);
    // Filter out any unbound variable like "$0, $1, etc.
    template.vars().stream().filter(s -> !s.contains("$")).forEach(bindings::add);
    return bindings.build();
  }
}
