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

package com.google.api.generator.gapic.protoparser;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.api.generator.gapic.model.Message;
import com.google.api.generator.gapic.model.RoutingHeaderRule;
import com.google.api.generator.gapic.model.RoutingHeaderRule.RoutingHeaderParam;
import com.google.explicit.dynamic.routing.header.RoutingRuleParserTestingOuterClass;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.Descriptors.MethodDescriptor;
import com.google.protobuf.Descriptors.ServiceDescriptor;
import java.util.Map;
import org.junit.jupiter.api.Test;

class RoutingRuleParserTest {

  private static final FileDescriptor TESTING_FILE_DESCRIPTOR =
      RoutingRuleParserTestingOuterClass.getDescriptor();
  private static final ServiceDescriptor TESTING_SERVICE =
      TESTING_FILE_DESCRIPTOR.getServices().get(0);

  @Test
  void parse_shouldReturnNullRoutingHeadersIfMethodHasNoRoutingRules() {
    RoutingHeaderRule actual = getRoutingHeaders(0);
    assertThat(actual).isNull();
  }

  @Test
  void parse_shouldSetPathTemplateToWildcardIfNotDefined() {
    RoutingHeaderRule actual = getRoutingHeaders(1);
    RoutingHeaderParam expected =
        RoutingHeaderParam.create("name", "name", String.format("{%s=**}", "name"));
    assertThat(actual.routingHeaderParams()).containsExactly(expected);
  }

  @Test
  void parse_shouldThrowExceptionIfPathTemplateHasZeroNamedSegment() {
    IllegalArgumentException illegalArgumentException =
        assertThrows(IllegalArgumentException.class, () -> getRoutingHeaders(2));
    assertThat(illegalArgumentException.getMessage())
        .isEqualTo(
            String.format(
                "There needs to be one and only one named segment in path template %s",
                "/v1beta1/tests/*"));
  }

  @Test
  void parse_shouldThrowExceptionIfPathTemplateHasMoreThanOneNamedSegment() {
    IllegalArgumentException illegalArgumentException =
        assertThrows(IllegalArgumentException.class, () -> getRoutingHeaders(3));
    assertThat(illegalArgumentException.getMessage())
        .isEqualTo(
            String.format(
                "There needs to be one and only one named segment in path template %s",
                "/v1beta1/{name=tests/*}/{second_name=*}"));
  }

  @Test
  void parse_shouldParseRoutingRulesWithOneParameter() {
    RoutingHeaderRule actual = getRoutingHeaders(4);
    RoutingHeaderParam expected =
        RoutingHeaderParam.create("name", "rename", "/v1beta1/{rename=tests/*}");
    assertThat(actual.routingHeaderParams()).containsExactly(expected);
  }

  @Test
  void parse_shouldParseRoutingRulesWithMultipleParameter() {
    RoutingHeaderRule actual = getRoutingHeaders(5);
    RoutingHeaderParam expectedHeader1 =
        RoutingHeaderParam.create("name", "rename", "/v1beta1/{rename=tests/*}");
    RoutingHeaderParam expectedHeader2 =
        RoutingHeaderParam.create("routing_id", "id", "/v1beta1/{id=projects/*}/tables/*");
    assertThat(actual.routingHeaderParams())
        .containsExactly(expectedHeader1, expectedHeader2)
        .inOrder();
  }

  @Test
  void parse_shouldParseRoutingRulesWithNestedFields() {
    RoutingHeaderRule actual = getRoutingHeaders(6);
    RoutingHeaderParam expectedHeader1 =
        RoutingHeaderParam.create("account.name", "rename", "/v1beta1/{rename=tests/*}");
    assertThat(actual.routingHeaderParams()).containsExactly(expectedHeader1);
  }

  @Test
  void parse_shouldThrowExceptionIfFieldValidationFailed() {
    assertThrows(Exception.class, () -> getRoutingHeaders(7));
  }

  private RoutingHeaderRule getRoutingHeaders(int testingIndex) {
    MethodDescriptor rpcMethod = TESTING_SERVICE.getMethods().get(testingIndex);
    Map<String, Message> messages = Parser.parseMessages(TESTING_FILE_DESCRIPTOR);
    Message inputMessage = messages.get("com." + rpcMethod.getInputType().getFullName());
    return RoutingRuleParser.parse(rpcMethod, inputMessage, messages);
  }
}
