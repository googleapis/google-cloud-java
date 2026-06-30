package com.google.api.generator.gapic.model;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TransportTest {

  static Stream<Arguments> data() {
    return Stream.of(
        Arguments.of("grpc", Transport.GRPC),
        Arguments.of("Grpc", Transport.GRPC),
        Arguments.of("gRPC", Transport.GRPC),
        Arguments.of("rest", Transport.REST),
        Arguments.of("REST", Transport.REST),
        Arguments.of("rESt", Transport.REST),
        Arguments.of("grpc+rest", Transport.GRPC_REST),
        Arguments.of("gRPC+REST", Transport.GRPC_REST),
        Arguments.of("grPc+rEst", Transport.GRPC_REST));
  }

  @ParameterizedTest
  @MethodSource("data")
  void testParse_returnsValidTransport(String input, Transport expected) {
    assertThat(expected).isEqualTo(Transport.parse(input));
  }

  @Test
  void testParse_throwsException() {
    assertThrows(IllegalArgumentException.class, () -> Transport.parse("invalid transport"));
    assertThrows(IllegalArgumentException.class, () -> Transport.parse("grHttpc"));
  }
}
