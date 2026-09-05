// Copyright 2026 Google LLC
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

package com.google.api.generator.gapic.composer.common;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.generator.engine.writer.JavaWriterVisitor;
import com.google.api.generator.gapic.composer.rest.ServiceSettingsClassComposer;
import com.google.api.generator.gapic.composer.rest.ServiceStubSettingsClassComposer;
import com.google.api.generator.gapic.model.GapicClass;
import com.google.api.generator.gapic.model.GapicContext;
import com.google.api.generator.gapic.model.GapicServiceConfig;
import com.google.api.generator.gapic.model.Service;
import com.google.api.generator.test.protoloader.RestTestProtoLoader;
import com.google.protobuf.Duration;
import io.grpc.serviceconfig.MethodConfig;
import io.grpc.serviceconfig.ServiceConfig;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class ResumableUploadSettingsComposerTest {

  @Test
  void generateServiceStubSettings_resumableUploadCallSettings() {
    GapicContext context = RestTestProtoLoader.instance().parseShowcaseResumableUpload();
    Service service = context.services().get(0);

    GapicClass clazz = ServiceStubSettingsClassComposer.instance().generate(context, service);
    JavaWriterVisitor visitor = new JavaWriterVisitor();
    clazz.classDefinition().accept(visitor);
    String code = visitor.write();

    // Verify import of ResumableUploadCallSettings
    assertThat(code).contains("import com.google.api.gax.rpc.ResumableUploadCallSettings;");

    // Verify field in outer class
    assertThat(code).contains("private final ResumableUploadCallSettings uploadMediaSettings;");

    // Verify getter in outer class
    assertThat(code)
        .contains(
            "public ResumableUploadCallSettings uploadMediaSettings() {\n"
                + "    return uploadMediaSettings;\n"
                + "  }");

    // Verify field in Builder class
    assertThat(code)
        .contains("private final ResumableUploadCallSettings.Builder uploadMediaSettings;");

    // Verify getter in Builder class
    assertThat(code)
        .contains(
            "public ResumableUploadCallSettings.Builder uploadMediaSettings() {\n"
                + "      return uploadMediaSettings;\n"
                + "    }");

    // Verify Builder constructor instantiates with ResumableUploadCallSettings.newBuilder()
    assertThat(code).contains("uploadMediaSettings = ResumableUploadCallSettings.newBuilder();");

    // Verify outer constructor builds the settings
    assertThat(code)
        .contains("uploadMediaSettings = settingsBuilder.uploadMediaSettings().build();");

    // Verify unaryMethodSettingsBuilders does NOT contain uploadMediaSettings
    assertThat(code).doesNotContain("unaryMethodSettingsBuilders.add(uploadMediaSettings);");
    assertThat(code)
        .doesNotContain("unaryMethodSettingsBuilders.add(builder.uploadMediaSettings());");

    // Verify Javadoc on settings getters
    assertThat(code)
        .contains("Note that custom retry settings and headers configured via ApiCallContext");
    assertThat(code).contains("the initial session initiation request.");
  }

  @Test
  void generateServiceSettings_resumableUploadCallSettings() {
    GapicContext context = RestTestProtoLoader.instance().parseShowcaseResumableUpload();
    Service service = context.services().get(0);

    GapicClass clazz = ServiceSettingsClassComposer.instance().generate(context, service);
    JavaWriterVisitor visitor = new JavaWriterVisitor();
    clazz.classDefinition().accept(visitor);
    String code = visitor.write();

    // Verify import of ResumableUploadCallSettings
    assertThat(code).contains("import com.google.api.gax.rpc.ResumableUploadCallSettings;");

    // Verify getter in outer ServiceSettings class delegating to stub settings
    assertThat(code)
        .contains(
            "public ResumableUploadCallSettings uploadMediaSettings() {\n"
                + "    return ((ResumableUploadServiceStubSettings)"
                + " getStubSettings()).uploadMediaSettings();\n"
                + "  }");

    // Verify getter in Builder class delegating to stub settings builder
    assertThat(code)
        .contains(
            "public ResumableUploadCallSettings.Builder uploadMediaSettings() {\n"
                + "      return getStubSettingsBuilder().uploadMediaSettings();\n"
                + "    }");

    // Verify Javadoc on settings getters
    assertThat(code)
        .contains("Note that custom retry settings and headers configured via ApiCallContext");
    assertThat(code).contains("the initial session initiation request.");
  }

  @Test
  void generateServiceStubSettings_withTimeoutConfig() {
    GapicContext baseContext = RestTestProtoLoader.instance().parseShowcaseResumableUpload();
    Service service = baseContext.services().get(0);

    ServiceConfig serviceConfig =
        ServiceConfig.newBuilder()
            .addMethodConfig(
                MethodConfig.newBuilder()
                    .addName(
                        MethodConfig.Name.newBuilder()
                            .setService("google.showcase.v1beta1.ResumableUploadService")
                            .setMethod("UploadMedia"))
                    .setTimeout(Duration.newBuilder().setSeconds(300)))
            .build();
    GapicServiceConfig gapicServiceConfig = GapicServiceConfig.create(Optional.of(serviceConfig));
    GapicContext context = baseContext.toBuilder().setServiceConfig(gapicServiceConfig).build();

    GapicClass clazz = ServiceStubSettingsClassComposer.instance().generate(context, service);
    JavaWriterVisitor visitor = new JavaWriterVisitor();
    clazz.classDefinition().accept(visitor);
    String code = visitor.write();

    // Verify global timeout is configured on builder.uploadMediaSettings()
    assertThat(code)
        .contains("builder.uploadMediaSettings().setGlobalTimeout(Duration.ofMillis(300000L));");

    // Verify retryable codes and retry settings are NOT attempted on ResumableUploadCallSettings
    assertThat(code).doesNotContain("builder.uploadMediaSettings().setRetryableCodes");
    assertThat(code).doesNotContain("builder.uploadMediaSettings().setRetrySettings");
  }
}
