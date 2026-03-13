// Copyright 2023 Google LLC
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

package com.google.api.generator.gapic.composer;

import static com.google.common.truth.Truth.assertThat;
import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

import com.google.api.generator.engine.ast.TypeNode;
import com.google.api.generator.gapic.model.GapicContext;
import com.google.api.generator.gapic.model.Message;
import com.google.api.generator.gapic.model.ReflectConfig;
import com.google.api.generator.test.protoloader.TestProtoLoader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class ClientLibraryReflectConfigComposerTest {

  private final Message.Builder testMessageBuilder =
      Message.builder()
          .setName("MESSAGE_NAME")
          .setFullProtoName("com.google.test.TestMessage")
          .setType(TypeNode.OBJECT);

  @Test
  void composeReflectConfigs_showcase() {
    final GapicContext context = TestProtoLoader.instance().parseShowcaseEcho();
    List<ReflectConfig> configs = Composer.composeNativeReflectConfig(context);
    assertThat(configs).isNotEmpty();

    List<String> configClassNames = configs.stream().map(ReflectConfig::getName).collect(toList());
    assertThat(configClassNames).containsNoDuplicates();
    assertThat(configClassNames).isInOrder();
    assertThat(configClassNames)
        .containsExactly(
            "com.google.showcase.v1beta1.BlockRequest",
            "com.google.showcase.v1beta1.BlockRequest$Builder",
            "com.google.showcase.v1beta1.BlockResponse",
            "com.google.showcase.v1beta1.BlockResponse$Builder",
            "com.google.showcase.v1beta1.EchoRequest",
            "com.google.showcase.v1beta1.EchoRequest$Builder",
            "com.google.showcase.v1beta1.EchoResponse",
            "com.google.showcase.v1beta1.EchoResponse$Builder",
            "com.google.showcase.v1beta1.ExpandRequest",
            "com.google.showcase.v1beta1.ExpandRequest$Builder",
            "com.google.showcase.v1beta1.Foobar",
            "com.google.showcase.v1beta1.Foobar$Builder",
            "com.google.showcase.v1beta1.Object",
            "com.google.showcase.v1beta1.Object$Builder",
            "com.google.showcase.v1beta1.PagedExpandLegacyRequest",
            "com.google.showcase.v1beta1.PagedExpandLegacyRequest$Builder",
            "com.google.showcase.v1beta1.PagedExpandRequest",
            "com.google.showcase.v1beta1.PagedExpandRequest$Builder",
            "com.google.showcase.v1beta1.PagedExpandResponse",
            "com.google.showcase.v1beta1.PagedExpandResponse$Builder",
            "com.google.showcase.v1beta1.Severity",
            "com.google.showcase.v1beta1.WaitMetadata",
            "com.google.showcase.v1beta1.WaitMetadata$Builder",
            "com.google.showcase.v1beta1.WaitRequest",
            "com.google.showcase.v1beta1.WaitRequest$Builder",
            "com.google.showcase.v1beta1.WaitResponse",
            "com.google.showcase.v1beta1.WaitResponse$Builder");
  }

  @Test
  void composeReflectConfigs_SimpleMessage() {
    List<String> entries =
        ClientLibraryReflectConfigComposer.calculateReflectConfigList(
            "foo.Bar", testMessageBuilder.build());

    assertThat(entries).hasSize(2);
    assertThat(entries).containsExactly("foo.Bar", "foo.Bar$Builder");
  }

  @Test
  void composeReflectConfigs_Enum() {
    List<String> entries =
        ClientLibraryReflectConfigComposer.calculateReflectConfigList(
            "e.Num",
            testMessageBuilder.setEnumValues(Collections.singletonMap("value", 0)).build());

    assertThat(entries).hasSize(1);
    assertThat(entries).containsExactly("e.Num");
  }

  @Test
  void composeReflectConfigs_NestedEnums() {
    List<String> nestedEnums = Arrays.asList("NestedEnum1", "NestedEnum2");
    List<String> entries =
        ClientLibraryReflectConfigComposer.calculateReflectConfigList(
            "message.withNestedEnums", testMessageBuilder.setNestedEnums(nestedEnums).build());

    assertThat(entries).hasSize(4);
    assertThat(entries)
        .containsExactly(
            "message.withNestedEnums",
            "message.withNestedEnums$Builder",
            "message.withNestedEnums$NestedEnum1",
            "message.withNestedEnums$NestedEnum2");
  }

  @Test
  void formatNestedClassFullyQualifiedNames_noNested() {
    assertEquals("a.B", ClientLibraryReflectConfigComposer.convertToBinaryName("a.B"));
    assertEquals("aa.bb.CC", ClientLibraryReflectConfigComposer.convertToBinaryName("aa.bb.CC"));
  }

  @Test
  void formatNestedClassFullyQualifiedNames_oneNested() {
    assertEquals("a.B$C", ClientLibraryReflectConfigComposer.convertToBinaryName("a.B.C"));
    assertEquals(
        "aa.bb.Cc$Dd", ClientLibraryReflectConfigComposer.convertToBinaryName("aa.bb.Cc.Dd"));
  }

  @Test
  void formatNestedClassFullyQualifiedNames_twoNested() {
    assertEquals("a.B$C$D", ClientLibraryReflectConfigComposer.convertToBinaryName("a.B.C.D"));
    assertEquals(
        "aa.bb.Cc$Dd$Ee", ClientLibraryReflectConfigComposer.convertToBinaryName("aa.bb.Cc.Dd.Ee"));
  }

  @Test
  void duplicateEntries_found() {
    assertThat(ClientLibraryReflectConfigComposer.calculateDuplicates(Arrays.asList("a", "a", "b")))
        .containsExactly("a");

    assertThat(ClientLibraryReflectConfigComposer.calculateDuplicates(Arrays.asList("a", "a", "a")))
        .containsExactly("a", "a");

    assertThat(ClientLibraryReflectConfigComposer.calculateDuplicates(Arrays.asList("a", "b")))
        .isEmpty();
  }
}
