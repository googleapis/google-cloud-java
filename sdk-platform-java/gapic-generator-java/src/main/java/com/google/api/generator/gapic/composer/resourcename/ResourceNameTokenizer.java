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

package com.google.api.generator.gapic.composer.resourcename;

import com.google.api.generator.gapic.utils.ResourceNameConstants;
import com.google.api.pathtemplate.PathTemplate;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ResourceNameTokenizer {
  private static final String LEFT_BRACE = "{";
  private static final String RIGHT_BRACE = "}";
  private static final String SLASH = "/";
  private static final String EMPTY = "";

  private static final String EQUALS_WILDCARD = "=*";
  private static final String EQUALS_PATH_WILDCARD = "=**";

  private static final String NON_SLASH_SEP_REGEX = "\\}(_|\\-|\\.|~)\\{";

  public static List<List<String>> parseTokenHierarchy(List<String> patterns) {
    List<List<String>> tokenHierachies = new ArrayList<>();
    for (String pattern : patterns) {
      List<String> hierarchy = new ArrayList<>();
      Set<String> vars = PathTemplate.create(pattern).vars();
      String[] rawPatternTokens = pattern.split(SLASH);
      List<String> patternTokens = new ArrayList<>();

      // Process variables.
      for (String rawPatternToken : rawPatternTokens) {
        // PubSub exception case.
        if (rawPatternToken.equals(ResourceNameConstants.DELETED_TOPIC_LITERAL)) {
          hierarchy.add(rawPatternToken);
          continue;
        }

        if (!rawPatternToken.startsWith(LEFT_BRACE) || !rawPatternToken.endsWith(RIGHT_BRACE)) {
          continue;
        }
        // Add any non-slash separated tokens in the order that they're seen.
        for (String subToken : rawPatternToken.split(NON_SLASH_SEP_REGEX)) {
          String processedSubToken =
              subToken.replace(LEFT_BRACE, EMPTY).replace(RIGHT_BRACE, EMPTY);
          if (!patternTokens.contains(processedSubToken)) {
            patternTokens.add(processedSubToken);
          }
        }
      }

      for (String patternToken : patternTokens) {
        // Handle wildcards.
        final String processedPatternToken =
            // Replacement order matters - ensure the first is not a subcomponent of the second.
            patternToken.replace(EQUALS_PATH_WILDCARD, EMPTY).replace(EQUALS_WILDCARD, EMPTY);

        List<String> candidateVars =
            vars.stream()
                // Check that the token matches the variable exactly, to avoid mismatching on
                // variables with same-named subcomponents.
                // Otherwise, "customer_client_link" will match with "customer".
                .filter(v -> processedPatternToken.equals(v))
                .collect(Collectors.toList());
        Preconditions.checkState(
            !candidateVars.isEmpty(),
            String.format(
                "No variable candidates found for token %s in pattern %s among variables %s",
                processedPatternToken, pattern, vars));
        hierarchy.add(processedPatternToken);
      }
      tokenHierachies.add(hierarchy);
    }
    return tokenHierachies;
  }
}
