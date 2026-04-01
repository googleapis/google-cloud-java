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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.api.generator.gapic.model.HttpBindings;
import com.google.api.generator.gapic.model.HttpBindings.HttpBinding;
import com.google.api.generator.gapic.model.Message;
import com.google.common.truth.Truth;
import com.google.http.rule.parser.HttpRuleParserTestingOuterClass;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.Descriptors.MethodDescriptor;
import com.google.protobuf.Descriptors.ServiceDescriptor;
import com.google.showcase.v1beta1.TestingOuterClass;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class HttpRuleParserTest {
  @Test
  void parseHttpAnnotation_basic() {
    FileDescriptor testingFileDescriptor = TestingOuterClass.getDescriptor();
    ServiceDescriptor testingService = testingFileDescriptor.getServices().get(0);
    assertEquals("Testing", testingService.getName());

    Map<String, Message> messages = Parser.parseMessages(testingFileDescriptor);

    // CreateSession method.
    MethodDescriptor rpcMethod = testingService.getMethods().get(0);
    Message inputMessage = messages.get("com.google.showcase.v1beta1.CreateSessionRequest");
    HttpBindings httpBindings = HttpRuleParser.parse(rpcMethod, inputMessage, messages);
    assertTrue(httpBindings.pathParameters().isEmpty());

    // GetSession method.
    rpcMethod = testingService.getMethods().get(1);
    inputMessage = messages.get("com.google.showcase.v1beta1.GetSessionRequest");
    httpBindings = HttpRuleParser.parse(rpcMethod, inputMessage, messages);
    assertThat(
            httpBindings.pathParameters().stream()
                .map(HttpBinding::name)
                .collect(Collectors.toList()))
        .containsExactly("name");
  }

  @Test
  void parseHttpAnnotation_multipleBindings() {
    FileDescriptor testingFileDescriptor = TestingOuterClass.getDescriptor();
    ServiceDescriptor testingService = testingFileDescriptor.getServices().get(0);
    assertEquals("Testing", testingService.getName());

    Map<String, Message> messages = Parser.parseMessages(testingFileDescriptor);

    // VerityTest method.
    MethodDescriptor rpcMethod =
        testingService.getMethods().get(testingService.getMethods().size() - 1);
    Message inputMessage = messages.get("com.google.showcase.v1beta1.VerifyTestRequest");
    HttpBindings httpBindings = HttpRuleParser.parse(rpcMethod, inputMessage, messages);
    assertThat(
            httpBindings.pathParameters().stream()
                .map(HttpBinding::name)
                .collect(Collectors.toList()))
        .containsExactly("answer", "foo", "name", "test_to_verify.name", "type");
  }

  @Test
  void parseHttpAnnotation_missingFieldFromMessage() {
    FileDescriptor testingFileDescriptor = TestingOuterClass.getDescriptor();
    ServiceDescriptor testingService = testingFileDescriptor.getServices().get(0);
    assertEquals("Testing", testingService.getName());

    Map<String, Message> messages = Parser.parseMessages(testingFileDescriptor);

    // VerityTest method.
    MethodDescriptor rpcMethod =
        testingService.getMethods().get(testingService.getMethods().size() - 1);
    Message inputMessage = messages.get("com.google.showcase.v1beta1.CreateSessionRequest");
    assertThrows(
        IllegalStateException.class, () -> HttpRuleParser.parse(rpcMethod, inputMessage, messages));
  }

  @Test
  void parseHttpAnnotation_shouldPutAllFieldsIntoQueryParamsIfPathParamAndBodyAreNotConfigured() {
    FileDescriptor fileDescriptor = HttpRuleParserTestingOuterClass.getDescriptor();
    ServiceDescriptor serviceDescriptor = fileDescriptor.getServices().get(0);
    assertEquals("HttpRuleParserTesting", serviceDescriptor.getName());

    Map<String, Message> messages = Parser.parseMessages(fileDescriptor);

    MethodDescriptor rpcMethod =
        serviceDescriptor.getMethods().stream()
            .filter(
                methodDescriptor -> methodDescriptor.getName().equals("QueryParamHappyPathTest"))
            .findAny()
            .get();
    Message inputMessage = messages.get("com.google.http.rule.parser.QueryParamRequest");
    HttpBindings actual = HttpRuleParser.parse(rpcMethod, inputMessage, messages);

    HttpBinding expected1 =
        HttpBinding.builder().setName("name").setField(inputMessage.fieldMap().get("name")).build();
    HttpBinding expected2 =
        HttpBinding.builder()
            .setName("nested_object")
            .setField(inputMessage.fieldMap().get("nested_object"))
            .build();
    Truth.assertThat(new HashSet<>(actual.queryParameters())).containsExactly(expected1, expected2);
  }

  @Disabled
  @Test
  //               request
  //             /         \
  //     nested_object     name
  //     /          \
  //  name       continent
  // Given a request above, if nested_object.name is configured as path param, we should only
  // include nested_object.continent and name as query param.
  // However, the current logic put the name and the whole nested_object as query params, gax-java
  // will then serialize all sub fields to query params.
  // We need to either traverse all the leaf level fields and exclude field in the generator or pass
  // the excluded fields to gax-java. Re-enable this test once
  // https://github.com/googleapis/sdk-platform-java/issues/1041 is fixed
  void parseHttpAnnotation_shouldExcludeFieldsFromQueryParamsIfPathParamsAreConfigured() {
    FileDescriptor fileDescriptor = HttpRuleParserTestingOuterClass.getDescriptor();
    ServiceDescriptor serviceDescriptor = fileDescriptor.getServices().get(0);
    assertEquals("HttpRuleParserTesting", serviceDescriptor.getName());

    Map<String, Message> messages = Parser.parseMessages(fileDescriptor);

    MethodDescriptor rpcMethod =
        serviceDescriptor.getMethods().stream()
            .filter(
                methodDescriptor ->
                    methodDescriptor.getName().equals("ExcludePathParamsQueryParamTest"))
            .findAny()
            .get();
    Message inputMessage = messages.get("com.google.http.rule.parser.QueryParamRequest");

    HttpBindings actual = HttpRuleParser.parse(rpcMethod, inputMessage, messages);

    Message nestedObjectMessage = messages.get("com.google.http.rule.parser.NestedObject");

    HttpBinding expected1 =
        HttpBinding.builder().setName("name").setField(inputMessage.fieldMap().get("name")).build();
    HttpBinding expected2 =
        HttpBinding.builder()
            .setName("nested_object.continent")
            .setField(nestedObjectMessage.fieldMap().get("continent"))
            .build();
    HttpBinding expectedPathParam =
        HttpBinding.builder()
            .setName("nested_object.name")
            .setField(nestedObjectMessage.fieldMap().get("name"))
            .build();

    Truth.assertThat(new HashSet<>(actual.queryParameters())).containsExactly(expected1, expected2);
    Truth.assertThat(new HashSet<>(actual.pathParameters())).containsExactly(expectedPathParam);
  }
}
