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

package com.google.api.generator.gapic.composer.rest;

import static org.junit.Assert.assertThrows;

import com.google.api.CustomHttpPattern;
import com.google.api.Http;
import com.google.api.HttpRule;
import com.google.api.generator.engine.ast.TypeNode;
import com.google.api.generator.engine.writer.JavaWriterVisitor;
import com.google.api.generator.gapic.model.Field;
import com.google.api.generator.gapic.model.GapicClass;
import com.google.api.generator.gapic.model.GapicContext;
import com.google.api.generator.gapic.model.HttpBindings.HttpBinding;
import com.google.api.generator.gapic.model.Service;
import com.google.api.generator.test.framework.Assert;
import com.google.api.generator.test.framework.GoldenFileWriter;
import com.google.api.generator.test.protoloader.RestTestProtoLoader;
import com.google.common.collect.ImmutableList;
import com.google.common.truth.Truth;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HttpJsonServiceStubClassComposerTest {

  private HttpJsonServiceStubClassComposer composer;

  @BeforeEach
  void setUp() throws Exception {
    composer = HttpJsonServiceStubClassComposer.instance();
  }

  @Test
  void generateComplianceServiceClasses() {
    GapicContext context = RestTestProtoLoader.instance().parseCompliance();
    Service complianceProtoServices = context.services().get(0);
    GapicClass clazz = composer.generate(context, complianceProtoServices);

    JavaWriterVisitor visitor = new JavaWriterVisitor();
    clazz.classDefinition().accept(visitor);
    GoldenFileWriter.saveCodegenToFile(
        this.getClass(), "HttpJsonComplianceStub.golden", visitor.write());
    Path goldenFilePath =
        Paths.get(GoldenFileWriter.getGoldenDir(this.getClass()), "HttpJsonComplianceStub.golden");
    Assert.assertCodeEquals(goldenFilePath, visitor.write());
  }

  @Test
  void generateEchoServiceClasses() {
    GapicContext context = RestTestProtoLoader.instance().parseEcho();
    Service echoProtoService = context.services().get(0);
    GapicClass clazz = composer.generate(context, echoProtoService);

    JavaWriterVisitor visitor = new JavaWriterVisitor();
    clazz.classDefinition().accept(visitor);
    GoldenFileWriter.saveCodegenToFile(this.getClass(), "HttpJsonEchoStub.golden", visitor.write());
    Path goldenFilePath =
        Paths.get(GoldenFileWriter.getGoldenDir(this.getClass()), "HttpJsonEchoStub.golden");
    Assert.assertCodeEquals(goldenFilePath, visitor.write());
  }

  @Test
  void getBindingFieldMethodName_shouldReturnGetFieldListIfTheFieldIsInLastPositionAndIsRepeated() {
    Field field =
        Field.builder()
            .setIsRepeated(true)
            .setName("doesNotMatter")
            .setType(TypeNode.OBJECT)
            .build();
    HttpBinding httpBinding =
        HttpBinding.builder().setField(field).setName("doesNotMatter").build();
    String actual = composer.getBindingFieldMethodName(httpBinding, 4, 3, "Values");
    Truth.assertThat(actual).isEqualTo("getValuesList");
  }

  @Test
  void getBindingFieldMethodName_shouldReturnGetFieldValueIfTheFieldIsInLastPositionAndIsEnum() {
    Field field =
        Field.builder().setIsEnum(true).setName("doesNotMatter").setType(TypeNode.OBJECT).build();
    HttpBinding httpBinding =
        HttpBinding.builder().setField(field).setName("doesNotMatter").build();
    String actual = composer.getBindingFieldMethodName(httpBinding, 4, 3, "Enums");
    Truth.assertThat(actual).isEqualTo("getEnumsValue");
  }

  @Test
  void
      getBindingFieldMethodName_shouldReturnGetFieldIfTheFieldIsInLastPositionAndNotRepeatedOrEnum() {
    Field field = Field.builder().setName("doesNotMatter").setType(TypeNode.OBJECT).build();
    HttpBinding httpBinding =
        HttpBinding.builder().setField(field).setName("doesNotMatter").build();
    String actual = composer.getBindingFieldMethodName(httpBinding, 4, 3, "Value");
    Truth.assertThat(actual).isEqualTo("getValue");
  }

  @Test
  void getBindingFieldMethodName_shouldReturnGetFieldIfTheFieldIsNotInLastPosition() {
    Field field = Field.builder().setName("doesNotMatter").setType(TypeNode.OBJECT).build();
    HttpBinding httpBinding =
        HttpBinding.builder().setField(field).setName("doesNotMatter").build();
    String actual = composer.getBindingFieldMethodName(httpBinding, 4, 1, "Value");
    Truth.assertThat(actual).isEqualTo("getValue");
  }

  @Test
  void parseOperationsCustomHttpRules_shouldReturnMapIfContextContainsValidServiceYaml() {
    List<HttpRule> httpRuleList =
        ImmutableList.of(
            HttpRule.newBuilder()
                .setSelector("google.longrunning.Operations.Get")
                .setGet("testGet")
                .build(),
            HttpRule.newBuilder()
                .setSelector("google.longrunning.Operations.Post")
                .setPost("testPost")
                .build(),
            HttpRule.newBuilder()
                .setSelector("google.longrunning.Operations.Delete")
                .setDelete("testDelete")
                .build());
    GapicContext contextServiceYaml = RestTestProtoLoader.instance().parseCompliance();
    contextServiceYaml =
        contextServiceYaml.toBuilder()
            .setServiceYamlProto(
                com.google.api.Service.newBuilder()
                    .setHttp(Http.newBuilder().addAllRules(httpRuleList))
                    .build())
            .build();
    Map<String, HttpRule> httpRuleMap = composer.parseOperationsCustomHttpRules(contextServiceYaml);
    Truth.assertThat(httpRuleMap.isEmpty()).isFalse();
    Truth.assertThat(httpRuleMap.size()).isEqualTo(httpRuleList.size());
  }

  @Test
  void parseOperationsCustomHttpRules_shouldReturnEmptyMapIfContextHasInvalidServiceYaml() {
    GapicContext contextNullServiceYaml = RestTestProtoLoader.instance().parseCompliance();
    contextNullServiceYaml = contextNullServiceYaml.toBuilder().setServiceYamlProto(null).build();
    Map<String, HttpRule> httpRuleMapNull =
        composer.parseOperationsCustomHttpRules(contextNullServiceYaml);
    Truth.assertThat(httpRuleMapNull.isEmpty()).isTrue();

    GapicContext contextEmptyServiceYaml = RestTestProtoLoader.instance().parseCompliance();
    contextNullServiceYaml =
        contextEmptyServiceYaml.toBuilder()
            .setServiceYamlProto(com.google.api.Service.newBuilder().build())
            .build();
    Map<String, HttpRule> httpRuleMapEmpty =
        composer.parseOperationsCustomHttpRules(contextNullServiceYaml);
    Truth.assertThat(httpRuleMapEmpty.isEmpty()).isTrue();
  }

  @Test
  void testGetOperationsURIValueFromHttpRule() {
    HttpRule getHttpRule = HttpRule.newBuilder().setGet("Get").build();
    Truth.assertThat(composer.getOperationsURIValueFromHttpRule(getHttpRule)).isEqualTo("Get");
    HttpRule postHttpRule = HttpRule.newBuilder().setPost("Post").build();
    Truth.assertThat(composer.getOperationsURIValueFromHttpRule(postHttpRule)).isEqualTo("Post");
    HttpRule deleteHttpRule = HttpRule.newBuilder().setDelete("Delete").build();
    Truth.assertThat(composer.getOperationsURIValueFromHttpRule(deleteHttpRule))
        .isEqualTo("Delete");

    HttpRule patchHttpRule = HttpRule.newBuilder().setPatch("Patch").build();
    assertThrows(
        IllegalArgumentException.class,
        () -> composer.getOperationsURIValueFromHttpRule(patchHttpRule));
    HttpRule putHttpRule = HttpRule.newBuilder().setPut("Put").build();
    assertThrows(
        IllegalArgumentException.class,
        () -> composer.getOperationsURIValueFromHttpRule(putHttpRule));
    HttpRule customHttpRule =
        HttpRule.newBuilder()
            .setCustom(CustomHttpPattern.newBuilder().setPath("Custom").build())
            .build();
    assertThrows(
        IllegalArgumentException.class,
        () -> composer.getOperationsURIValueFromHttpRule(customHttpRule));
  }

  @Test
  void generateGrpcServiceStubClass_routingHeaders() {
    GapicContext context =
        RestTestProtoLoader.instance().parseExplicitDynamicRoutingHeaderTesting();
    Service service = context.services().get(0);
    GapicClass clazz = HttpJsonServiceStubClassComposer.instance().generate(context, service);

    Assert.assertGoldenClass(this.getClass(), clazz, "HttpJsonRoutingHeadersStub.golden");
    Assert.assertEmptySamples(clazz.samples());
  }

  @Test
  void generateHttpJsonServiceStubClass_autopopulateField() {
    GapicContext context = RestTestProtoLoader.instance().parseAutoPopulateFieldTesting();
    Service service = context.services().get(0);
    GapicClass clazz = HttpJsonServiceStubClassComposer.instance().generate(context, service);

    Assert.assertGoldenClass(this.getClass(), clazz, "HttpJsonAutoPopulateFieldTestingStub.golden");
    Assert.assertEmptySamples(clazz.samples());
  }
}
