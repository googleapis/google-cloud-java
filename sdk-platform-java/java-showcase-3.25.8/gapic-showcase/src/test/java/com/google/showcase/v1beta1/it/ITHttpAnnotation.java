/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.showcase.v1beta1.it;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.common.collect.ImmutableMap;
import com.google.protobuf.util.JsonFormat;
import com.google.showcase.v1beta1.ComplianceClient;
import com.google.showcase.v1beta1.ComplianceData;
import com.google.showcase.v1beta1.ComplianceGroup;
import com.google.showcase.v1beta1.ComplianceSettings;
import com.google.showcase.v1beta1.ComplianceSuite;
import com.google.showcase.v1beta1.RepeatRequest;
import com.google.showcase.v1beta1.RepeatResponse;
import com.google.showcase.v1beta1.it.util.TestClientInitializer;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

// This test runs from the parameters in the compliance_suite.json file
// The file is downloaded from the gapic-showcase repo. Each compliance
// group is a set of HttpJson behaviors we want to test for. Each group
// tests the product of the rpc list and requests list.
class ITHttpAnnotation {

  static Stream<Arguments> data() {
    return Stream.of(
        Arguments.of("Fully working conversions, resources"),
        Arguments.of("Binding selection testing"),
        Arguments.of("Cases that apply to non-path requests"),
        Arguments.of("Fully working conversions, no resources"));
  }

  private static ComplianceClient httpjsonClient;
  private static ComplianceSuite complianceSuite;
  private static Map<String, Function<RepeatRequest, RepeatResponse>> validComplianceRpcMap;

  @BeforeAll
  static void createClients() throws IOException, GeneralSecurityException {
    ComplianceSuite.Builder builder = ComplianceSuite.newBuilder();
    JsonFormat.parser()
        .merge(
            new InputStreamReader(
                Objects.requireNonNull(
                    ITHttpAnnotation.class
                        .getClassLoader()
                        .getResourceAsStream("compliance_suite.json")),
                StandardCharsets.UTF_8),
            builder);
    complianceSuite = builder.build();

    ComplianceSettings httpjsonComplianceSettings =
        ComplianceSettings.newHttpJsonBuilder()
            .setCredentialsProvider(NoCredentialsProvider.create())
            .setTransportChannelProvider(
                ComplianceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(
                        new NetHttpTransport.Builder().doNotValidateCertificate().build())
                    .setEndpoint("http://localhost:7469")
                    .build())
            .build();
    httpjsonClient = ComplianceClient.create(httpjsonComplianceSettings);

    // Mapping of Compliance Suite file RPC Names to ComplianceClient methods
    validComplianceRpcMap =
        ImmutableMap.of(
            "Compliance.RepeatDataBody",
            httpjsonClient::repeatDataBody,
            "Compliance.RepeatDataBodyInfo",
            httpjsonClient::repeatDataBodyInfo,
            "Compliance.RepeatDataQuery",
            httpjsonClient::repeatDataQuery,
            "Compliance.RepeatDataSimplePath",
            httpjsonClient::repeatDataSimplePath,
            "Compliance.RepeatDataBodyPut",
            httpjsonClient::repeatDataBodyPut,
            "Compliance.RepeatDataBodyPatch",
            httpjsonClient::repeatDataBodyPatch,
            "Compliance.RepeatDataPathResource",
            httpjsonClient::repeatDataPathResource);
  }

  @AfterAll
  static void destroyClients() throws InterruptedException {
    httpjsonClient.close();
    httpjsonClient.awaitTermination(
        TestClientInitializer.AWAIT_TERMINATION_SECONDS, TimeUnit.SECONDS);
  }

  // Verify that the input's info is the same as the response's info
  // This ensures that the entire group's behavior over HttpJson
  // works as intended
  @ParameterizedTest
  @MethodSource("data")
  void testComplianceGroup(String groupName) {
    Optional<ComplianceGroup> complianceGroupOptional =
        complianceSuite.getGroupList().stream()
            .filter(x -> x.getName().equals(groupName))
            .findFirst();
    assertThat(complianceGroupOptional.isPresent()).isTrue();
    ComplianceGroup complianceGroup = complianceGroupOptional.get();
    List<String> validRpcList =
        complianceGroup.getRpcsList().stream()
            .filter(validComplianceRpcMap::containsKey)
            .collect(Collectors.toList());
    for (String rpcName : validRpcList) {
      Function<RepeatRequest, RepeatResponse> rpc = validComplianceRpcMap.get(rpcName);
      for (RepeatRequest repeatRequest : complianceGroup.getRequestsList()) {
        ComplianceData expectedData = repeatRequest.getInfo();
        RepeatResponse response = rpc.apply(repeatRequest);
        assertThat(response.getRequest().getInfo()).isEqualTo(expectedData);
      }
    }
  }
}
