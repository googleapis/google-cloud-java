// Copyright 2022 Google LLC
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

package com.google.api.generator.gapic.composer.grpcrest;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.generator.engine.writer.JavaWriterVisitor;
import com.google.api.generator.gapic.model.GapicClass;
import com.google.api.generator.gapic.model.GapicContext;
import com.google.api.generator.gapic.model.Service;
import com.google.api.generator.test.framework.Assert;
import com.google.api.generator.test.framework.GoldenFileWriter;
import com.google.api.generator.test.protoloader.GrpcRestTestProtoLoader;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;

class HttpJsonServiceStubClassComposerTest {
  @Test
  void generateServiceClasses() {
    GapicContext context = GrpcRestTestProtoLoader.instance().parseShowcaseEcho();
    Service echoProtoService = context.services().get(0);
    GapicClass clazz =
        HttpJsonServiceStubClassComposer.instance().generate(context, echoProtoService);

    JavaWriterVisitor visitor = new JavaWriterVisitor();
    clazz.classDefinition().accept(visitor);
    GoldenFileWriter.saveCodegenToFile(this.getClass(), "HttpJsonEchoStub.golden", visitor.write());
    Path goldenFilePath =
        Paths.get(GoldenFileWriter.getGoldenDir(this.getClass()), "HttpJsonEchoStub.golden");
    Assert.assertCodeEquals(goldenFilePath, visitor.write());
  }

  @Test
  void generateServiceClassesWicked() {
    GapicContext context = GrpcRestTestProtoLoader.instance().parseShowcaseWicked();
    Service wickedProtoService = context.services().get(0);
    GapicClass clazz =
        HttpJsonServiceStubClassComposer.instance().generate(context, wickedProtoService);
    assertThat(clazz.kind()).isEqualTo(GapicClass.Kind.NON_GENERATED);
  }
}
