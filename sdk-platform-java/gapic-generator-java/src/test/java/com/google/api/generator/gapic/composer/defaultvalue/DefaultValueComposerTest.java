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

package com.google.api.generator.gapic.composer.defaultvalue;

import static org.junit.Assert.assertEquals;

import com.google.api.generator.engine.ast.ConcreteReference;
import com.google.api.generator.engine.ast.Expr;
import com.google.api.generator.engine.ast.TypeNode;
import com.google.api.generator.engine.writer.JavaWriterVisitor;
import com.google.api.generator.gapic.model.Field;
import com.google.api.generator.gapic.model.HttpBindings;
import com.google.api.generator.gapic.model.HttpBindings.HttpVerb;
import com.google.api.generator.gapic.model.Message;
import com.google.api.generator.gapic.model.ResourceName;
import com.google.api.generator.gapic.protoparser.Parser;
import com.google.api.generator.test.utils.LineFormatter;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.ByteString;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.StructProto;
import com.google.showcase.v1beta1.EchoOuterClass;
import com.google.showcase.v1beta1.MessagingOuterClass;
import com.google.testgapic.v1beta1.LockerProto;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DefaultValueComposerTest {
  private JavaWriterVisitor writerVisitor;

  @BeforeEach
  void setUp() {
    writerVisitor = new JavaWriterVisitor();
  }

  @Test
  void defaultValue_mapField() {
    // Incorrect and will never happen in real usage, but proves that map detection is based on
    // isMap rather than type().
    Field field =
        Field.builder()
            .setName("foobar")
            .setType(TypeNode.STRING)
            .setIsMap(true)
            .setIsRepeated(true)
            .build();
    Expr expr = DefaultValueComposer.createValue(field);
    expr.accept(writerVisitor);
    assertEquals("new HashMap<>()", writerVisitor.write());

    writerVisitor.clear();

    // isMap() and isRepeated() will be set by protoc simultaneously, but we check this edge case.
    // for completeness.
    field = Field.builder().setName("foobar").setType(TypeNode.STRING).setIsMap(true).build();
    expr = DefaultValueComposer.createValue(field);
    expr.accept(writerVisitor);
    assertEquals("\"foobar-1268878963\"", writerVisitor.write());
  }

  @Test
  void defaultValue_listField() {
    // Incorrect and will never happen in real usage, but proves that list detection is based on
    // isRepeated rather than type().
    Field field =
        Field.builder().setName("foobar").setType(TypeNode.STRING).setIsRepeated(true).build();
    Expr expr = DefaultValueComposer.createValue(field);
    expr.accept(writerVisitor);
    assertEquals("new ArrayList<>()", writerVisitor.write());
  }

  @Test
  void defaultValue_enumField() {
    // Incorrect and will never happen in real usage, but proves that enum detection is based on
    // isEnum() rather than type().
    Field field =
        Field.builder().setName("foobar").setType(TypeNode.STRING).setIsEnum(true).build();
    Expr expr = DefaultValueComposer.createValue(field);
    expr.accept(writerVisitor);
    assertEquals("String.forNumber(0)", writerVisitor.write());
  }

  @Test
  void defaultValue_messageField() {
    // Incorrect and will never happen in real usage, but proves that message detection is based on
    // isMessage() rather than type().
    Field field =
        Field.builder().setName("foobar").setType(TypeNode.STRING).setIsMessage(true).build();
    Expr expr = DefaultValueComposer.createValue(field);
    expr.accept(writerVisitor);
    assertEquals("String.newBuilder().build()", writerVisitor.write());
  }

  @Test
  void defaultValue_stringField() {
    Field field = Field.builder().setName("foobar").setType(TypeNode.STRING).build();
    Expr expr = DefaultValueComposer.createValue(field);
    expr.accept(writerVisitor);
    assertEquals("\"foobar-1268878963\"", writerVisitor.write());

    writerVisitor.clear();

    // Original name is very clearly in lower_camel_case.
    field = Field.builder().setName("foo_bar_baz").setType(TypeNode.STRING).build();
    expr = DefaultValueComposer.createValue(field);
    expr.accept(writerVisitor);
    assertEquals("\"fooBarBaz-2082080914\"", writerVisitor.write());
  }

  @Test
  void defaultValue_numericField() {
    Field field = Field.builder().setName("foobar").setType(TypeNode.INT).build();
    Expr expr = DefaultValueComposer.createValue(field);
    expr.accept(writerVisitor);
    assertEquals("-1268878963", writerVisitor.write());

    writerVisitor.clear();
    field = Field.builder().setName("foobar").setType(TypeNode.DOUBLE).build();
    expr = DefaultValueComposer.createValue(field);
    expr.accept(writerVisitor);
    assertEquals("-1268878963", writerVisitor.write());
  }

  @Test
  void defaultValue_booleanField() {
    Field field = Field.builder().setName("foobar").setType(TypeNode.BOOLEAN).build();
    Expr expr = DefaultValueComposer.createValue(field);
    expr.accept(writerVisitor);
    assertEquals("true", writerVisitor.write());
  }

  @Test
  void defaultValue_byteStringField() {
    Field field =
        Field.builder()
            .setName("foobar")
            .setType(TypeNode.withReference(ConcreteReference.withClazz(ByteString.class)))
            .build();
    Expr expr = DefaultValueComposer.createValue(field);
    expr.accept(writerVisitor);
    assertEquals("ByteString.EMPTY", writerVisitor.write());
  }

  @Test
  void defaultValue_resourceNameWithOnePattern() {
    FileDescriptor lockerServiceFileDescriptor = LockerProto.getDescriptor();
    Map<String, ResourceName> typeStringsToResourceNames =
        Parser.parseResourceNames(lockerServiceFileDescriptor);
    ResourceName resourceName =
        typeStringsToResourceNames.get("cloudbilling.googleapis.com/BillingAccount");
    Expr expr =
        DefaultValueComposer.createResourceHelperValue(
            resourceName,
            false,
            typeStringsToResourceNames.values().stream().collect(Collectors.toList()),
            "ignored",
            null);
    expr.accept(writerVisitor);
    assertEquals("BillingAccountName.of(\"[BILLING_ACCOUNT]\")", writerVisitor.write());
  }

  @Test
  void defaultValue_resourceNameWithMultiplePatterns_noBindings() {
    FileDescriptor lockerServiceFileDescriptor = LockerProto.getDescriptor();
    Map<String, ResourceName> typeStringsToResourceNames =
        Parser.parseResourceNames(lockerServiceFileDescriptor);
    ResourceName resourceName =
        typeStringsToResourceNames.get("cloudresourcemanager.googleapis.com/Folder");
    Expr expr =
        DefaultValueComposer.createResourceHelperValue(
            resourceName,
            false,
            typeStringsToResourceNames.values().stream().collect(Collectors.toList()),
            "ignored",
            null);
    expr.accept(writerVisitor);
    /*
    There are two patterns:
      - pattern: "projects/{project}/folders/{folder}"
      - pattern: "folders/{folder}"
      It matches the first one given no bindings
    */
    assertEquals(
        "FolderName.ofProjectFolderName(\"[PROJECT]\", \"[FOLDER]\")", writerVisitor.write());
  }

  @Test
  void defaultValue_resourceNameWithMultiplePatterns_matchesBindings() {
    FileDescriptor lockerServiceFileDescriptor = LockerProto.getDescriptor();
    Map<String, ResourceName> typeStringsToResourceNames =
        Parser.parseResourceNames(lockerServiceFileDescriptor);
    ResourceName resourceName =
        typeStringsToResourceNames.get("cloudresourcemanager.googleapis.com/Folder");
    Expr expr =
        DefaultValueComposer.createResourceHelperValue(
            resourceName,
            false,
            typeStringsToResourceNames.values().stream().collect(Collectors.toList()),
            "folder",
            HttpBindings.builder()
                .setHttpVerb(HttpVerb.POST)
                .setPattern("/v1/{name=folders/*}")
                .setAdditionalPatterns(ImmutableList.of())
                .setIsAsteriskBody(true)
                .build());
    expr.accept(writerVisitor);
    /*
    There are two patterns:
      - pattern: "projects/{project}/folders/{folder}"
      - pattern: "folders/{folder}"
      It attempts to match the correct HttpBinding
    */
    assertEquals("FolderName.ofFolderName(\"[FOLDER]\")", writerVisitor.write());
  }

  @Test
  void defaultValue_resourceNameWithWildcardPattern() {
    FileDescriptor lockerServiceFileDescriptor = LockerProto.getDescriptor();
    Map<String, ResourceName> typeStringsToResourceNames =
        Parser.parseResourceNames(lockerServiceFileDescriptor);
    ResourceName resourceName =
        typeStringsToResourceNames.get("cloudresourcemanager.googleapis.com/Anything");
    Expr expr =
        DefaultValueComposer.createResourceHelperValue(
            resourceName,
            false,
            typeStringsToResourceNames.values().stream().collect(Collectors.toList()),
            "ignored",
            null);
    expr.accept(writerVisitor);
    assertEquals("DocumentName.ofDocumentName(\"[DOCUMENT]\")", writerVisitor.write());
  }

  @Test
  void defaultValue_wildcardResourceNameWithOnlyDeletedTopic() {
    // Edge case that should never happen in practice.
    // Wildcard, but the resource names map has only other names that contain only the deleted-topic
    // constant.
    FileDescriptor lockerServiceFileDescriptor = LockerProto.getDescriptor();
    Map<String, ResourceName> typeStringsToResourceNames =
        Parser.parseResourceNames(lockerServiceFileDescriptor);
    ResourceName resourceName =
        typeStringsToResourceNames.get("cloudresourcemanager.googleapis.com/Anything");
    ResourceName topicResourceName = typeStringsToResourceNames.get("pubsub.googleapis.com/Topic");
    typeStringsToResourceNames.clear();
    typeStringsToResourceNames.put(topicResourceName.resourceTypeString(), topicResourceName);
    Expr expr =
        DefaultValueComposer.createResourceHelperValue(
            resourceName,
            false,
            typeStringsToResourceNames.values().stream().collect(Collectors.toList()),
            "ignored",
            null);
    expr.accept(writerVisitor);
    assertEquals("TopicName.ofDeletedTopic()", writerVisitor.write());
  }

  @Test
  void defaultValue_resourceNameWithOnlyWildcards_valueOnly() {
    // Edge case that occurs in GCS.
    // Wildcard, but the resource names map has only other names that contain only the deleted-topic
    // constant.
    FileDescriptor lockerServiceFileDescriptor = LockerProto.getDescriptor();
    Map<String, ResourceName> typeStringsToResourceNames =
        Parser.parseResourceNames(lockerServiceFileDescriptor);
    ResourceName resourceName =
        typeStringsToResourceNames.get("cloudresourcemanager.googleapis.com/Anything");
    String fallbackField = "foobar";
    Expr expr =
        DefaultValueComposer.createResourceHelperValue(
            resourceName,
            false,
            Collections.emptyList(),
            fallbackField,
            /* allowAnonResourceNameClass= */ false,
            null);
    expr.accept(writerVisitor);
    assertEquals(
        String.format("\"%s%s\"", fallbackField, fallbackField.hashCode()), writerVisitor.write());
  }

  @Test
  void defaultValue_resourceNameWithOnlyWildcards_matchingBinding() {
    FileDescriptor lockerServiceFileDescriptor = LockerProto.getDescriptor();
    Map<String, ResourceName> typeStringsToResourceNames =
        Parser.parseResourceNames(lockerServiceFileDescriptor);
    ResourceName resourceName =
        typeStringsToResourceNames.get("cloudresourcemanager.googleapis.com/Anything");
    String fallbackField = "foobar";

    ResourceName extraResourceName =
        ResourceName.builder()
            .setVariableName("topic")
            .setPakkage("com.google.pubsub.v1")
            .setResourceTypeString("pubsub.googleapis.com/Topic")
            .setPatterns(Arrays.asList("_deleted-topic_", "projects/{project}/topics/{topic}"))
            .setParentMessageName("com.google.pubsub.v1.Topic")
            .build();

    HttpBindings bindings =
        HttpBindings.builder()
            .setHttpVerb(HttpVerb.PUT)
            .setPattern("/v1/{name=projects/*/topics/*}")
            .setAdditionalPatterns(Collections.emptyList())
            .setIsAsteriskBody(true)
            .build();

    Expr expr =
        DefaultValueComposer.createResourceHelperValue(
            resourceName,
            false,
            Arrays.asList(resourceName, extraResourceName),
            fallbackField,
            /* allowAnonResourceNameClass= */ false,
            bindings);
    expr.accept(writerVisitor);
    assertEquals("TopicName.ofProjectTopicName(\"[PROJECT]\", \"[TOPIC]\")", writerVisitor.write());
  }

  @Test
  void defaultValue_resourceNameWithOnlyWildcards_mismatchingBinding() {
    FileDescriptor lockerServiceFileDescriptor = LockerProto.getDescriptor();
    Map<String, ResourceName> typeStringsToResourceNames =
        Parser.parseResourceNames(lockerServiceFileDescriptor);
    ResourceName resourceName =
        typeStringsToResourceNames.get("cloudresourcemanager.googleapis.com/Anything");
    String fallbackField = "foobar";

    ResourceName extraResourceName =
        ResourceName.builder()
            .setVariableName("topic")
            .setPakkage("com.google.pubsub.v1")
            .setResourceTypeString("pubsub.googleapis.com/Topic")
            .setPatterns(Arrays.asList("_deleted-topic_", "projects/{project}/topics/{topic}"))
            .setParentMessageName("com.google.pubsub.v1.Topic")
            .build();

    HttpBindings bindings =
        HttpBindings.builder()
            .setHttpVerb(HttpVerb.PUT)
            .setPattern("/v1/{name=projects/*/subscriptions/*}")
            .setAdditionalPatterns(Collections.emptyList())
            .setIsAsteriskBody(true)
            .build();

    Expr expr =
        DefaultValueComposer.createResourceHelperValue(
            resourceName,
            false,
            Arrays.asList(resourceName, extraResourceName),
            fallbackField,
            /* allowAnonResourceNameClass= */ false,
            bindings);
    expr.accept(writerVisitor);
    assertEquals(
        String.format("\"%s%s\"", fallbackField, fallbackField.hashCode()), writerVisitor.write());
  }

  @Test
  void defaultValue_resourceNameWithOnlyWildcards_allowAnonResourceNameClass() {
    // Edge case that occurs in GCS.
    // Wildcard, but the resource names map has only other names that contain only the deleted-topic
    // constant.
    FileDescriptor lockerServiceFileDescriptor = LockerProto.getDescriptor();
    Map<String, ResourceName> typeStringsToResourceNames =
        Parser.parseResourceNames(lockerServiceFileDescriptor);
    ResourceName resourceName =
        typeStringsToResourceNames.get("cloudresourcemanager.googleapis.com/Anything");
    String fallbackField = "foobar";
    Expr expr =
        DefaultValueComposer.createResourceHelperValue(
            resourceName, false, Collections.emptyList(), fallbackField, null);
    expr.accept(writerVisitor);
    String expected =
        LineFormatter.lines(
            "new ResourceName() {\n",
            "@Override\n",
            "public Map<String, String> getFieldValuesMap() {\n",
            "Map<String, String> fieldValuesMap = new HashMap<>();\n",
            "fieldValuesMap.put(\"foobar\", \"foobar-1268878963\");\n",
            "return fieldValuesMap;\n",
            "}\n",
            "\n",
            "@Override\n",
            "public String getFieldValue(String fieldName) {\n",
            "return getFieldValuesMap().get(fieldName);\n",
            "}\n",
            "\n",
            "@Override\n",
            "public String toString() {\n",
            "return \"foobar-1268878963\";\n",
            "}\n",
            "\n",
            "}");
    assertEquals(expected, writerVisitor.write());
  }

  @Test
  void createSimpleMessageBuilderValue_resourceNameMultiplePatterns_matchesHttpBinding() {
    FileDescriptor messagingFileDescriptor = MessagingOuterClass.getDescriptor();
    Map<String, Message> messageTypes = Parser.parseMessages(messagingFileDescriptor);
    Map<String, ResourceName> typeStringsToResourceNames =
        Parser.parseResourceNames(messagingFileDescriptor);
    /*
    Blurb Resource contains four patterns (in order of):
      - pattern: "users/{user}/profile/blurbs/legacy/{legacy_user}~{blurb}"
      - pattern: "users/{user}/profile/blurbs/{blurb}"
      - pattern: "rooms/{room}/blurbs/{blurb}"
      - pattern: "rooms/{room}/blurbs/legacy/{legacy_room}.{blurb}"
    */
    Message message = messageTypes.get("com.google.showcase.v1beta1.Blurb");

    HttpBindings bindings =
        HttpBindings.builder()
            .setHttpVerb(HttpVerb.PATCH)
            .setPattern("/v1beta1/{blurb.name=rooms/*/blurbs/*}")
            .setAdditionalPatterns(
                Collections.singletonList("/v1beta1/{blurb.name=users/*/profile/blurbs/*}"))
            .setIsAsteriskBody(false)
            .build();

    Expr expr =
        DefaultValueComposer.createSimpleMessageBuilderValue(
            message, typeStringsToResourceNames, messageTypes, bindings);
    expr.accept(writerVisitor);
    // Matches with the default pattern in the HttpBindings and uses the variables in the pattern
    assertEquals(
        "Blurb.newBuilder().setName(BlurbName.ofRoomBlurbName(\"[ROOM]\", \"[BLURB]\").toString()).build()",
        writerVisitor.write());
  }

  @Test
  void createSimpleMessageBuilderValue_resourceNameMultiplePatterns_matchesAdditionalHttpBinding() {
    FileDescriptor messagingFileDescriptor = MessagingOuterClass.getDescriptor();
    Map<String, Message> messageTypes = Parser.parseMessages(messagingFileDescriptor);
    Map<String, ResourceName> typeStringsToResourceNames =
        Parser.parseResourceNames(messagingFileDescriptor);
    /*
    Blurb Resource contains four patterns (in order of):
      - pattern: "users/{user}/profile/blurbs/legacy/{legacy_user}~{blurb}"
      - pattern: "users/{user}/profile/blurbs/{blurb}"
      - pattern: "rooms/{room}/blurbs/{blurb}"
      - pattern: "rooms/{room}/blurbs/legacy/{legacy_room}.{blurb}"
    */
    Message message = messageTypes.get("com.google.showcase.v1beta1.Blurb");

    HttpBindings bindings =
        HttpBindings.builder()
            .setHttpVerb(HttpVerb.PATCH)
            .setPattern("/v1beta1/{blurb.name=invalid/pattern/*}")
            .setAdditionalPatterns(
                Collections.singletonList("/v1beta1/{blurb.name=users/*/profile/blurbs/*}"))
            .setIsAsteriskBody(false)
            .build();

    Expr expr =
        DefaultValueComposer.createSimpleMessageBuilderValue(
            message, typeStringsToResourceNames, messageTypes, bindings);
    expr.accept(writerVisitor);
    // Because the default pattern does not match, it will attempt to match with patterns in the
    // additional bindings and use variables for any pattern that matches
    assertEquals(
        "Blurb.newBuilder().setName(BlurbName.ofUserBlurbName(\"[USER]\", \"[BLURB]\").toString()).build()",
        writerVisitor.write());
  }

  @Test
  void createSimpleMessageBuilderValue_resourceNameMultiplePatterns_doesNotMatchHttpBinding() {
    FileDescriptor messagingFileDescriptor = MessagingOuterClass.getDescriptor();
    Map<String, Message> messageTypes = Parser.parseMessages(messagingFileDescriptor);
    Map<String, ResourceName> typeStringsToResourceNames =
        Parser.parseResourceNames(messagingFileDescriptor);
    /*
    Blurb Resource contains four patterns (in order of):
      - pattern: "users/{user}/profile/blurbs/legacy/{legacy_user}~{blurb}"
      - pattern: "users/{user}/profile/blurbs/{blurb}"
      - pattern: "rooms/{room}/blurbs/{blurb}"
      - pattern: "rooms/{room}/blurbs/legacy/{legacy_room}.{blurb}"
    */
    Message message = messageTypes.get("com.google.showcase.v1beta1.Blurb");

    HttpBindings bindings =
        HttpBindings.builder()
            .setHttpVerb(HttpVerb.PATCH)
            .setPattern("/v1beta1/{blurb.name=invalid/pattern/*}")
            .setAdditionalPatterns(
                Collections.singletonList("/v1beta1/{blurb.name=nothing/matches/*}"))
            .setIsAsteriskBody(false)
            .build();

    Expr expr =
        DefaultValueComposer.createSimpleMessageBuilderValue(
            message, typeStringsToResourceNames, messageTypes, bindings);
    expr.accept(writerVisitor);
    // If no pattern matches (default and additional bindings), it will simply pick the first
    // resource pattern in the resource definition.
    assertEquals(
        "Blurb.newBuilder().setName(BlurbName.ofUserLegacyUserBlurbName(\"[USER]\", \"[LEGACY_USER]\", \"[BLURB]\").toString()).build()",
        writerVisitor.write());
  }

  @Test
  void defaultValue_resourceNameMultiplePatterns_noHttpBinding() {
    FileDescriptor messagingFileDescriptor = MessagingOuterClass.getDescriptor();
    Map<String, Message> messageTypes = Parser.parseMessages(messagingFileDescriptor);
    Map<String, ResourceName> typeStringsToResourceNames =
        Parser.parseResourceNames(messagingFileDescriptor);
    Message message = messageTypes.get("com.google.showcase.v1beta1.Blurb");

    Expr expr =
        DefaultValueComposer.createSimpleMessageBuilderValue(
            message, typeStringsToResourceNames, messageTypes, null);
    expr.accept(writerVisitor);
    // If no pattern matches (default and additional bindings), it will simply pick the first
    // resource pattern in the resource definition.
    assertEquals(
        "Blurb.newBuilder().setName(BlurbName.ofUserLegacyUserBlurbName(\"[USER]\", \"[LEGACY_USER]\", \"[BLURB]\").toString()).build()",
        writerVisitor.write());
  }

  @Test
  void createSimpleMessage_basicPrimitivesOnly() {
    FileDescriptor echoFileDescriptor = EchoOuterClass.getDescriptor();
    Map<String, Message> messageTypes = Parser.parseMessages(echoFileDescriptor);
    Map<String, ResourceName> typeStringsToResourceNames =
        Parser.parseResourceNames(echoFileDescriptor);
    Message message = messageTypes.get("com.google.showcase.v1beta1.Foobar");
    Expr expr =
        DefaultValueComposer.createSimpleMessageBuilderValue(
            message, typeStringsToResourceNames, messageTypes, null);
    expr.accept(writerVisitor);
    assertEquals(
        "Foobar.newBuilder().setName(FoobarName.ofProjectFoobarName(\"[PROJECT]\", \"[FOOBAR]\")"
            + ".toString()).setInfo(\"info3237038\").build()",
        writerVisitor.write());
  }

  @Test
  void createSimpleMessage_containsMessagesEnumsAndResourceName() {
    FileDescriptor echoFileDescriptor = EchoOuterClass.getDescriptor();
    Map<String, Message> messageTypes = Parser.parseMessages(echoFileDescriptor);
    Map<String, ResourceName> typeStringsToResourceNames =
        Parser.parseResourceNames(echoFileDescriptor);
    Message message = messageTypes.get("com.google.showcase.v1beta1.EchoRequest");
    Expr expr =
        DefaultValueComposer.createSimpleMessageBuilderValue(
            message, typeStringsToResourceNames, messageTypes, null);
    expr.accept(writerVisitor);
    assertEquals(
        "EchoRequest.newBuilder().setName("
            + "FoobarName.ofProjectFoobarName(\"[PROJECT]\", \"[FOOBAR]\").toString())"
            + ".setParent(FoobarName.ofProjectFoobarName(\"[PROJECT]\", \"[FOOBAR]\").toString())"
            + ".setSeverity(Severity.forNumber(0))"
            + ".setFoobar(Foobar.newBuilder().build()).build()",
        writerVisitor.write());
  }

  @Test
  void createSimpleMessage_valueField() {
    FileDescriptor echoFileDescriptor =
        com.google.showcase.grpcrest.v1beta1.EchoGrpcrest.getDescriptor();
    Map<String, Message> messageTypes = Parser.parseMessages(echoFileDescriptor);
    messageTypes.putAll(Parser.parseMessages(StructProto.getDescriptor()));
    Map<String, ResourceName> typeStringsToResourceNames =
        Parser.parseResourceNames(echoFileDescriptor);
    Message message = messageTypes.get("com.google.showcase.grpcrest.v1beta1.EchoResponse");
    Expr expr =
        DefaultValueComposer.createSimpleMessageBuilderValue(
            message, typeStringsToResourceNames, messageTypes, null);
    expr.accept(writerVisitor);
    assertEquals(
        "EchoResponse.newBuilder()"
            + ".setContent(\"content951530617\")"
            + ".setSeverity(Severity.forNumber(0))"
            + ".setValueField(Value.newBuilder().setBoolValue(true).build())"
            + ".build()",
        writerVisitor.write());
  }

  @Test
  void createSimpleMessage_containsRepeatedField() {
    FileDescriptor echoFileDescriptor = EchoOuterClass.getDescriptor();
    Map<String, Message> messageTypes = Parser.parseMessages(echoFileDescriptor);
    Map<String, ResourceName> typeStringsToResourceNames =
        Parser.parseResourceNames(echoFileDescriptor);
    Message message = messageTypes.get("com.google.showcase.v1beta1.PagedExpandResponse");
    Expr expr =
        DefaultValueComposer.createSimpleMessageBuilderValue(
            message, typeStringsToResourceNames, messageTypes, null);
    expr.accept(writerVisitor);
    assertEquals(
        "PagedExpandResponse.newBuilder().addAllResponses(new ArrayList<EchoResponse>())"
            + ".setNextPageToken(\"nextPageToken-1386094857\").build()",
        writerVisitor.write());
  }

  @Test
  void createSimpleMessage_onlyOneofs() {
    FileDescriptor echoFileDescriptor = EchoOuterClass.getDescriptor();
    Map<String, Message> messageTypes = Parser.parseMessages(echoFileDescriptor);
    Map<String, ResourceName> typeStringsToResourceNames =
        Parser.parseResourceNames(echoFileDescriptor);
    Message message = messageTypes.get("com.google.showcase.v1beta1.WaitRequest");
    Expr expr =
        DefaultValueComposer.createSimpleMessageBuilderValue(
            message, typeStringsToResourceNames, messageTypes, null);
    expr.accept(writerVisitor);
    assertEquals("WaitRequest.newBuilder().build()", writerVisitor.write());
  }

  @Test
  void createAnonymousResourceNameClass() {
    Expr expr = DefaultValueComposer.createAnonymousResourceNameClassValue("resource", null);
    expr.accept(writerVisitor);
    String expected =
        LineFormatter.lines(
            "new ResourceName() {\n",
            "@Override\n",
            "public Map<String, String> getFieldValuesMap() {\n",
            "Map<String, String> fieldValuesMap = new HashMap<>();\n",
            "fieldValuesMap.put(\"resource\", \"resource-341064690\");\n",
            "return fieldValuesMap;\n",
            "}\n",
            "\n",
            "@Override\n",
            "public String getFieldValue(String fieldName) {\n",
            "return getFieldValuesMap().get(fieldName);\n",
            "}\n",
            "\n",
            "@Override\n",
            "public String toString() {\n",
            "return \"resource-341064690\";\n",
            "}\n",
            "\n",
            "}");

    assertEquals(expected, writerVisitor.write());
  }
}
