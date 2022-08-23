/*
 * Copyright 2022 Google LLC
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

/**
 * A client to Anthos Multi-Cloud API
 *
 * <p>The interfaces provided are listed below, along with usage samples.
 *
 * <p>======================= AwsClustersClient =======================
 *
 * <p>Service Description: The AwsClusters API provides a single centrally managed service to create
 * and manage Anthos clusters that run on AWS infrastructure.
 *
 * <p>Sample for AwsClustersClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated for illustrative purposes only.
 * // It may require modifications to work in your environment.
 * try (AwsClustersClient awsClustersClient = AwsClustersClient.create()) {
 *   AwsClusterName name = AwsClusterName.of("[PROJECT]", "[LOCATION]", "[AWS_CLUSTER]");
 *   AwsCluster response = awsClustersClient.getAwsCluster(name);
 * }
 * }</pre>
 *
 * <p>======================= AzureClustersClient =======================
 *
 * <p>Service Description: The AzureClusters API provides a single centrally managed service to
 * create and manage Anthos clusters that run on Azure infrastructure.
 *
 * <p>Sample for AzureClustersClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated for illustrative purposes only.
 * // It may require modifications to work in your environment.
 * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
 *   AzureClientName name = AzureClientName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLIENT]");
 *   AzureClient response = azureClustersClient.getAzureClient(name);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.gkemulticloud.v1;

import javax.annotation.Generated;
