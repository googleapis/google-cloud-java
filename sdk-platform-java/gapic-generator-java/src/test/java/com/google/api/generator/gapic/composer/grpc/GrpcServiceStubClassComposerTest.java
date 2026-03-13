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
import org.junit.jupiter.api.Test;

class GrpcServiceStubClassComposerTest {
  @Test
  void generateGrpcServiceStubClass_simple() {
    GapicContext context = GrpcTestProtoLoader.instance().parseShowcaseEcho();
    Service echoProtoService = context.services().get(0);
    GapicClass clazz = GrpcServiceStubClassComposer.instance().generate(context, echoProtoService);

    Assert.assertGoldenClass(this.getClass(), clazz, "GrpcEchoStub.golden");
    Assert.assertEmptySamples(clazz.samples());
  }

  @Test
  void generateGrpcServiceStubClass_deprecated() {
    GapicContext context = GrpcTestProtoLoader.instance().parseDeprecatedService();
    Service protoService = context.services().get(0);
    GapicClass clazz = GrpcServiceStubClassComposer.instance().generate(context, protoService);

    Assert.assertGoldenClass(this.getClass(), clazz, "GrpcDeprecatedServiceStub.golden");
    Assert.assertEmptySamples(clazz.samples());
  }

  @Test
  void generateGrpcServiceStubClass_httpBindings() {
    GapicContext context = GrpcTestProtoLoader.instance().parseShowcaseTesting();
    Service service = context.services().get(0);
    GapicClass clazz = GrpcServiceStubClassComposer.instance().generate(context, service);

    Assert.assertGoldenClass(this.getClass(), clazz, "GrpcTestingStub.golden");
    Assert.assertEmptySamples(clazz.samples());
  }

  @Test
  void generateGrpcServiceStubClass_routingHeaders() {
    GapicContext context =
        GrpcTestProtoLoader.instance().parseExplicitDynamicRoutingHeaderTesting();
    Service service = context.services().get(0);
    GapicClass clazz = GrpcServiceStubClassComposer.instance().generate(context, service);

    Assert.assertGoldenClass(this.getClass(), clazz, "GrpcRoutingHeadersStub.golden");
    Assert.assertEmptySamples(clazz.samples());
  }

  @Test
  void generateGrpcServiceStubClass_httpBindingsWithSubMessageFields() {
    GapicContext context = GrpcTestProtoLoader.instance().parsePubSubPublisher();
    Service service = context.services().get(0);
    GapicClass clazz = GrpcServiceStubClassComposer.instance().generate(context, service);

    Assert.assertGoldenClass(this.getClass(), clazz, "GrpcPublisherStub.golden");
    Assert.assertEmptySamples(clazz.samples());
  }

  @Test
  void generateGrpcServiceStubClass_createBatchingCallable() {
    GapicContext context = GrpcTestProtoLoader.instance().parseLogging();
    Service service = context.services().get(0);
    GapicClass clazz = GrpcServiceStubClassComposer.instance().generate(context, service);

    Assert.assertGoldenClass(this.getClass(), clazz, "GrpcLoggingStub.golden");
    Assert.assertEmptySamples(clazz.samples());
  }

  @Test
  void generateGrpcServiceStubClass_autopopulateField() {
    GapicContext context = GrpcTestProtoLoader.instance().parseAutoPopulateFieldTesting();
    Service service = context.services().get(0);
    GapicClass clazz = GrpcServiceStubClassComposer.instance().generate(context, service);

    Assert.assertGoldenClass(this.getClass(), clazz, "GrpcAutoPopulateFieldStub.golden");
    Assert.assertEmptySamples(clazz.samples());
  }

  @Test
  void generateGrpcServiceStubClass_callableNameType() {
    GapicContext context = GrpcTestProtoLoader.instance().parseCallabeNameType();
    Service service = context.services().get(0);
    GapicClass clazz = GrpcServiceStubClassComposer.instance().generate(context, service);
    Assert.assertGoldenClass(this.getClass(), clazz, "GrpcCallableNameTypeStub.golden");
    Assert.assertEmptySamples(clazz.samples());
  }

  @Test
  void generateGrpcServiceStubClass_bigQuery() {
    GapicContext context = GrpcTestProtoLoader.instance().parseBigqueryService();

    Service bigqueryJobService = context.services().get(0);
    GapicClass clazz =
        GrpcServiceStubClassComposer.instance().generate(context, bigqueryJobService);
    Assert.assertGoldenClass(this.getClass(), clazz, "GrpcBigQueryJobServiceStub.golden");
    Assert.assertEmptySamples(clazz.samples());
  }
}
