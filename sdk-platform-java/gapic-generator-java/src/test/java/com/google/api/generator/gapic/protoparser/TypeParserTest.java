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

import com.google.api.generator.engine.ast.Reference;
import com.google.api.generator.gapic.model.LongrunningOperation;
import com.google.api.generator.gapic.model.Message;
import com.google.cloud.location.LocationsProto;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FileDescriptor;
import com.google.protobuf.Descriptors.MethodDescriptor;
import com.google.protobuf.Descriptors.ServiceDescriptor;
import com.google.showcase.v1beta1.EchoOuterClass;
import com.google.test.collisions.CollisionsOuterClass;
import com.google.testgapic.v1beta1.NestedMessageProto;
import java.util.Map;
import org.junit.jupiter.api.Test;

class TypeParserTest {
  // TODO(miraleung): Backfill with more tests (e.g. field, message, methods) for Parser.java.

  private static final FileDescriptor COLLISIONS_FILE_DESCRIPTOR =
      CollisionsOuterClass.getDescriptor();
  private static final FileDescriptor DESCRIPTOR_PROTOS_FILE_DESCRIPTOR =
      DescriptorProtos.getDescriptor();
  private static final FileDescriptor LOCATION_PROTO_FILE_DESCRIPTOR =
      LocationsProto.getDescriptor();
  private static final ServiceDescriptor COLLISIONS_SERVICE =
      COLLISIONS_FILE_DESCRIPTOR.getServices().get(0);

  @Test
  void parseMessageType_basic() {
    FileDescriptor echoFileDescriptor = EchoOuterClass.getDescriptor();
    ServiceDescriptor echoService = echoFileDescriptor.getServices().get(0);
    assertEquals("Echo", echoService.getName());

    MethodDescriptor echoMethodDescriptor = echoService.getMethods().get(0);
    Reference reference = TypeParser.parseMessageReference(echoMethodDescriptor.getInputType());
    assertEquals("com.google.showcase.v1beta1.EchoRequest", reference.fullName());
  }

  @Test
  void parseMessageType_nested() {
    FileDescriptor fileDescriptor = NestedMessageProto.getDescriptor();
    Descriptor messageDescriptor = fileDescriptor.getMessageTypes().get(0);
    assertEquals("Outer", messageDescriptor.getName());
    messageDescriptor = messageDescriptor.getNestedTypes().get(0);
    assertEquals("Middle", messageDescriptor.getName());
    messageDescriptor = messageDescriptor.getNestedTypes().get(0);
    assertEquals("Inner", messageDescriptor.getName());

    Reference reference = TypeParser.parseMessageReference(messageDescriptor);
    assertEquals("com.google.testgapic.v1beta1.Outer.Middle.Inner", reference.fullName());
  }

  @Test
  void parseLroResponseMetadataType_shortName_shouldMatchSamePackage() {
    Map<String, Message> messageTypes = Parser.parseMessages(COLLISIONS_FILE_DESCRIPTOR);
    messageTypes.putAll(Parser.parseMessages(DESCRIPTOR_PROTOS_FILE_DESCRIPTOR));
    messageTypes.putAll(Parser.parseMessages(LOCATION_PROTO_FILE_DESCRIPTOR));
    MethodDescriptor shouldUseSamePackageTypesLro = COLLISIONS_SERVICE.getMethods().get(0);

    assertEquals(COLLISIONS_SERVICE.getName(), "Collisions");
    assertThat(messageTypes)
        .containsKey("com.google.protobuf.DescriptorProtos.GeneratedCodeInfo.Annotation");
    assertThat(messageTypes)
        .containsKey("com.google.protobuf.DescriptorProtos.SourceCodeInfo.Location");
    assertThat(messageTypes).containsKey("com.google.cloud.location.Location");

    LongrunningOperation testLro =
        Parser.parseLro(
            TypeParser.getPackage(COLLISIONS_FILE_DESCRIPTOR),
            shouldUseSamePackageTypesLro,
            messageTypes);

    assertThat(testLro.responseType().reference().fullName())
        .isEqualTo("com.google.test.collisions.Annotation");
    assertThat(testLro.metadataType().reference().fullName())
        .isEqualTo("com.google.test.collisions.Location");
  }

  @Test
  void parseLroResponseMetadataType_shortName_shouldNotMatch() {
    Map<String, Message> messageTypes = Parser.parseMessages(COLLISIONS_FILE_DESCRIPTOR);
    messageTypes.putAll(Parser.parseMessages(DESCRIPTOR_PROTOS_FILE_DESCRIPTOR));
    MethodDescriptor shortNameMatchShouldThrowLro = COLLISIONS_SERVICE.getMethods().get(1);

    assertEquals(COLLISIONS_SERVICE.getName(), "Collisions");
    assertThat(messageTypes)
        .containsKey("com.google.protobuf.DescriptorProtos.ExtensionRangeOptions.Declaration");

    assertThrows(
        NullPointerException.class,
        () ->
            Parser.parseLro(
                TypeParser.getPackage(COLLISIONS_FILE_DESCRIPTOR),
                shortNameMatchShouldThrowLro,
                messageTypes));
  }

  @Test
  void parseLroResponseMetadataType_shortName_withFullyQualifiedCollision() {
    Map<String, Message> messageTypes = Parser.parseMessages(COLLISIONS_FILE_DESCRIPTOR);
    messageTypes.putAll(Parser.parseMessages(DESCRIPTOR_PROTOS_FILE_DESCRIPTOR));
    messageTypes.putAll(Parser.parseMessages(LOCATION_PROTO_FILE_DESCRIPTOR));
    MethodDescriptor fullNameForDifferentPackageLro = COLLISIONS_SERVICE.getMethods().get(2);

    assertEquals(COLLISIONS_SERVICE.getName(), "Collisions");
    assertThat(messageTypes).containsKey("com.google.cloud.location.Location");
    assertThat(messageTypes)
        .containsKey("com.google.protobuf.DescriptorProtos.SourceCodeInfo.Location");

    LongrunningOperation testLro =
        Parser.parseLro(
            TypeParser.getPackage(COLLISIONS_FILE_DESCRIPTOR),
            fullNameForDifferentPackageLro,
            messageTypes);

    assertThat(testLro.responseType().reference().fullName())
        .isEqualTo("com.google.cloud.location.Location");
    assertThat(testLro.metadataType().reference().fullName())
        .isEqualTo("com.google.test.collisions.Location");
  }
}
