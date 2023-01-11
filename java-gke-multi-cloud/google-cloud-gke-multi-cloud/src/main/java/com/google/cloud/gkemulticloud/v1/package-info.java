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
 * <p>======================= AttachedClustersClient =======================
 *
 * <p>Service Description: The AttachedClusters API provides a single centrally managed service to
 * register and manage Anthos attached clusters that run on customer's owned infrastructure.
 *
 * <p>Sample for AttachedClustersClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (AttachedClustersClient attachedClustersClient = AttachedClustersClient.create()) {
 *   AttachedClusterName name =
 *       AttachedClusterName.of("[PROJECT]", "[LOCATION]", "[ATTACHED_CLUSTER]");
 *   AttachedCluster response = attachedClustersClient.getAttachedCluster(name);
 * }
 * }</pre>
 *
 * <p>======================= AwsClustersClient =======================
 *
 * <p>Service Description: The AwsClusters API provides a single centrally managed service to create
 * and manage Anthos clusters that run on AWS infrastructure.
 *
 * <p>Sample for AwsClustersClient:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (AzureClustersClient azureClustersClient = AzureClustersClient.create()) {
 *   AzureClientName name = AzureClientName.of("[PROJECT]", "[LOCATION]", "[AZURE_CLIENT]");
 *   AzureClient response = azureClustersClient.getAzureClient(name);
 * }
 * }</pre>
 */
@Generated("by gapic-generator-java")
package com.google.cloud.gkemulticloud.v1;

import javax.annotation.Generated;
