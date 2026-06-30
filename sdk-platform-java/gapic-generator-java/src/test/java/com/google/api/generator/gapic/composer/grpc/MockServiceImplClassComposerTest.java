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

package com.google.api.generator.gapic.composer.grpc;

import com.google.api.generator.gapic.model.GapicClass;
import com.google.api.generator.gapic.model.GapicContext;
import com.google.api.generator.gapic.model.Service;
import com.google.api.generator.test.framework.Assert;
import com.google.api.generator.test.protoloader.GrpcTestProtoLoader;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MockServiceImplClassComposerTest {
  static Stream<Arguments> data() {
    return Stream.of(
        Arguments.of("MockEchoImpl", GrpcTestProtoLoader.instance().parseShowcaseEcho()),
        Arguments.of(
            "MockDeprecatedServiceImpl", GrpcTestProtoLoader.instance().parseDeprecatedService()));
  }

  @ParameterizedTest
  @MethodSource("data")
  void generateMockServiceImplClasses(String name, GapicContext context) {
    Service service = context.services().get(0);
    GapicClass clazz = MockServiceImplClassComposer.instance().generate(context, service);

    Assert.assertGoldenClass(this.getClass(), clazz, name + ".golden");
    Assert.assertEmptySamples(clazz.samples());
  }
}
