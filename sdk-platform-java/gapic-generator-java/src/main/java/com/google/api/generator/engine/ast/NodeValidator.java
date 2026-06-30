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

package com.google.api.generator.engine.ast;

import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;

public class NodeValidator {
  public static void checkNoNullElements(
      Collection<?> collection, String fieldTypeName, String nodeContextInfo) {
    Preconditions.checkState(
        collection.stream().allMatch(e -> !Objects.isNull(e)),
        String.format(
            "Found null expression in %s %s for %s", fieldTypeName, collection, nodeContextInfo));
  }

  public static void checkNoNullElements(
      Map<?, ?> map, String fieldTypeName, String nodeContextInfo) {
    checkNoNullElements(map.keySet(), String.format("key of %s", fieldTypeName), nodeContextInfo);
    checkNoNullElements(
        map.values(), String.format("values of %s", fieldTypeName), nodeContextInfo);
  }
}
