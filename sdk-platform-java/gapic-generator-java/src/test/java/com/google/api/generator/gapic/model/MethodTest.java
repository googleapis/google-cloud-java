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

package com.google.api.generator.gapic.model;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import com.google.api.generator.engine.ast.TypeNode;
import com.google.api.generator.gapic.model.HttpBindings.HttpBinding;
import com.google.api.generator.gapic.model.HttpBindings.HttpVerb;
import com.google.api.generator.gapic.model.Method.Stream;
import com.google.api.generator.gapic.model.RoutingHeaderRule.RoutingHeaderParam;
import com.google.common.collect.ImmutableSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class MethodTest {

  private static final Method METHOD =
      Method.builder()
          .setName("My method")
          .setInputType(TypeNode.STRING)
          .setOutputType(TypeNode.STRING)
          .build();
  private static final HttpBindings HTTP_BINDINGS =
      HttpBindings.builder()
          .setPathParameters(ImmutableSet.of(HttpBinding.builder().setName("table").build()))
          .setPattern("/pattern/test")
          .setAdditionalPatterns(Arrays.asList("/extra_pattern/test", "/extra_pattern/hey"))
          .setIsAsteriskBody(false)
          .setHttpVerb(HttpVerb.GET)
          .build();

  @Test
  void toStream() {
    // Argument order: isClientStreaming, isServerStreaming.
    assertThat(Method.toStream(false, false)).isEqualTo(Method.Stream.NONE);
    assertThat(Method.toStream(true, false)).isEqualTo(Method.Stream.CLIENT);
    assertThat(Method.toStream(false, true)).isEqualTo(Method.Stream.SERVER);
    assertThat(Method.toStream(true, true)).isEqualTo(Method.Stream.BIDI);
  }

  @Test
  void hasRoutingHeaders_shouldReturnFalseIfRoutingHeadersIsNull() {
    assertThat(METHOD.hasRoutingHeaderParams()).isFalse();
  }

  @Test
  void hasRoutingHeaders_shouldReturnFalseIfRoutingHeadersIsEmpty() {
    Method method =
        METHOD.toBuilder().setRoutingHeaderRule(RoutingHeaderRule.builder().build()).build();
    assertThat(method.hasRoutingHeaderParams()).isFalse();
  }

  @Test
  void hasRoutingHeaders_shouldReturnTrueIfRoutingHeadersIsNotEmpty() {
    Method method =
        METHOD.toBuilder()
            .setRoutingHeaderRule(
                RoutingHeaderRule.builder()
                    .addParam(RoutingHeaderParam.create("table", "routing_id", ""))
                    .build())
            .build();
    assertThat(method.hasRoutingHeaderParams()).isTrue();
  }

  @Test
  void shouldSetParamsExtractor_shouldReturnTrueIfHasRoutingHeaders() {
    Method method =
        METHOD.toBuilder()
            .setRoutingHeaderRule(
                RoutingHeaderRule.builder()
                    .addParam(RoutingHeaderParam.create("table", "routing_id", ""))
                    .build())
            .build();
    assertThat(method.shouldSetParamsExtractor()).isTrue();
  }

  @Test
  void shouldSetParamsExtractor_shouldReturnTrueIfHasHttpBindingsAndRoutingHeadersIsNull() {
    Method method =
        METHOD.toBuilder().setHttpBindings(HTTP_BINDINGS).setRoutingHeaderRule(null).build();
    assertThat(method.shouldSetParamsExtractor()).isTrue();
  }

  @Test
  void shouldSetParamsExtractor_shouldReturnFalseIfHasHttpBindingsAndRoutingHeadersIsEmpty() {
    Method method =
        METHOD.toBuilder()
            .setHttpBindings(HTTP_BINDINGS)
            .setRoutingHeaderRule(RoutingHeaderRule.builder().build())
            .build();
    assertThat(method.shouldSetParamsExtractor()).isFalse();
  }

  @Test
  void shouldSetParamsExtractor_shouldReturnFalseIfHasNoHttpBindingsAndNoRoutingHeaders() {
    Method method = METHOD.toBuilder().setHttpBindings(null).setRoutingHeaderRule(null).build();
    assertThat(method.shouldSetParamsExtractor()).isFalse();
  }

  @Test
  void hasAutoPopulatedFields_shouldReturnTrueIfMethodIsUnary() {
    List<String> autoPopulatedFields = Arrays.asList("field1", "field2");
    Method method = METHOD.toBuilder().setAutoPopulatedFields(autoPopulatedFields).build();
    method.toStream(false, false);
    assertEquals(true, method.hasAutoPopulatedFields());
  }

  @Test
  void hasAutoPopulatedFields_shouldReturnFalseIfMethodIsStreaming() {
    List<String> autoPopulatedFields = Arrays.asList("field1", "field2");
    Method method =
        METHOD.toBuilder()
            .setAutoPopulatedFields(autoPopulatedFields)
            .setStream(Stream.SERVER)
            .build();
    assertEquals(false, method.hasAutoPopulatedFields());

    method =
        METHOD.toBuilder()
            .setAutoPopulatedFields(autoPopulatedFields)
            .setStream(Stream.BIDI)
            .build();
    assertEquals(false, method.hasAutoPopulatedFields());

    method =
        METHOD.toBuilder()
            .setAutoPopulatedFields(autoPopulatedFields)
            .setStream(Stream.CLIENT)
            .build();
    assertEquals(false, method.hasAutoPopulatedFields());
  }

  @Test
  void hasAutoPopulatedFields_shouldReturnFalseIfAutoPopulatedFieldsIsEmpty() {
    List<String> autoPopulatedFields = new ArrayList<>();
    Method method =
        METHOD.toBuilder()
            .setAutoPopulatedFields(autoPopulatedFields)
            .setStream(Stream.NONE)
            .build();
    method.toStream(false, false);
    assertEquals(false, method.hasAutoPopulatedFields());
  }

  @Test
  void isSupportedByTransport_shouldReturnTrueIfHasHttpBindingsAndIsRESTEligibleForRESTTransport() {
    Method methodNoStreaming =
        METHOD.toBuilder().setHttpBindings(HTTP_BINDINGS).setStream(Method.Stream.NONE).build();
    assertThat(methodNoStreaming.isSupportedByTransport(Transport.REST)).isTrue();
    Method methodServerSideStreaming =
        METHOD.toBuilder().setHttpBindings(HTTP_BINDINGS).setStream(Method.Stream.SERVER).build();
    assertThat(methodServerSideStreaming.isSupportedByTransport(Transport.REST)).isTrue();
  }

  @Test
  void isSupportedByTransport_shouldReturnFalseIfNoHttpBindingsForRESTTransport() {
    Method methodNoStreaming =
        METHOD.toBuilder().setHttpBindings(null).setStream(Method.Stream.NONE).build();
    assertThat(methodNoStreaming.isSupportedByTransport(Transport.REST)).isFalse();
    Method methodServerSideStreaming =
        METHOD.toBuilder().setHttpBindings(null).setStream(Method.Stream.SERVER).build();
    assertThat(methodServerSideStreaming.isSupportedByTransport(Transport.REST)).isFalse();
  }

  @Test
  void
      isSupportedByTransport_shouldReturnFalseIfHasHttpBindingsAndIsNotRESTEligibleForRESTTransport() {
    Method methodClientSideStreaming =
        METHOD.toBuilder().setHttpBindings(HTTP_BINDINGS).setStream(Method.Stream.CLIENT).build();
    assertThat(methodClientSideStreaming.isSupportedByTransport(Transport.REST)).isFalse();
    Method methodBiDiStreaming =
        METHOD.toBuilder().setHttpBindings(HTTP_BINDINGS).setStream(Method.Stream.BIDI).build();
    assertThat(methodBiDiStreaming.isSupportedByTransport(Transport.REST)).isFalse();
  }

  @Test
  void isSupportedByTransport_shouldReturnTrueForGRPCTransport() {
    Method methodNoStreaming =
        METHOD.toBuilder().setHttpBindings(HTTP_BINDINGS).setStream(Method.Stream.NONE).build();
    assertThat(methodNoStreaming.isSupportedByTransport(Transport.GRPC)).isTrue();
    Method methodBiDiStreaming =
        METHOD.toBuilder().setHttpBindings(HTTP_BINDINGS).setStream(Method.Stream.BIDI).build();
    assertThat(methodBiDiStreaming.isSupportedByTransport(Transport.GRPC)).isTrue();
    Method methodNoStreamingNoHttpBindings =
        METHOD.toBuilder().setStream(Method.Stream.NONE).build();
    assertThat(methodNoStreamingNoHttpBindings.isSupportedByTransport(Transport.GRPC)).isTrue();
    Method methodBiDiStreamingNoHttpBindings =
        METHOD.toBuilder().setStream(Method.Stream.BIDI).build();
    assertThat(methodBiDiStreamingNoHttpBindings.isSupportedByTransport(Transport.GRPC)).isTrue();
  }

  @Test
  void isSupportedByTransport_shouldThrowExceptionIfPassedGRPCRESTTransport() {
    Method methodClientStreaming =
        METHOD.toBuilder().setHttpBindings(HTTP_BINDINGS).setStream(Method.Stream.CLIENT).build();
    assertThrows(
        IllegalArgumentException.class,
        () -> methodClientStreaming.isSupportedByTransport(Transport.GRPC_REST));
  }
}
