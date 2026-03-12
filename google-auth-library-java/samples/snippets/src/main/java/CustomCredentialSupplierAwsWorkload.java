/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.google.auth.oauth2.AwsCredentials;
import com.google.auth.oauth2.AwsSecurityCredentials;
import com.google.auth.oauth2.AwsSecurityCredentialsSupplier;
import com.google.auth.oauth2.ExternalAccountSupplierContext;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.AwsSessionCredentials;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.regions.providers.DefaultAwsRegionProviderChain;

/**
 * This sample demonstrates how to use a custom AWS security credentials supplier to authenticate to
 * Google Cloud Storage.
 */
public class CustomCredentialSupplierAwsWorkload {

  public static void main(String[] args) {
    // TODO(Developer): Set these environment variable values.

    // 1. AWS Credentials:
    // If running on a local system, the user must set AWS_REGION, AWS_ACCESS_KEY_ID, and
    // AWS_SECRET_ACCESS_KEY as environment variables. If running in an AWS environment (e.g.,
    // ECS, EKS), these variables will be auto-detected.

    // 2. GCP_WORKLOAD_AUDIENCE:
    // The audience for the workload identity federation. This is the full resource name of the
    // Workload Identity Pool Provider, in the following format:
    // `//iam.googleapis.com/projects/<project-number>/locations/global/workloadIdentityPools/<pool-id>/providers/<provider-id>`
    String gcpWorkloadAudience = System.getenv("GCP_WORKLOAD_AUDIENCE");

    // 3. GCP_SERVICE_ACCOUNT_IMPERSONATION_URL (optional):
    // The service account impersonation URL. It should follow the format:
    // https://iamcredentials.googleapis.com/v1/projects/-/serviceAccounts/<service-account-email>:generateAccessToken
    // If not provided, you should grant access to the GCP bucket to the principal directly.
    String saImpersonationUrl = System.getenv("GCP_SERVICE_ACCOUNT_IMPERSONATION_URL");

    // 4. GCS_BUCKET_NAME:
    // The name of the bucket that you wish to fetch data for.
    String gcsBucketName = System.getenv("GCS_BUCKET_NAME");

    if (gcpWorkloadAudience == null || gcsBucketName == null) {
      System.out.println(
          "Missing required environment variables. Please check your environment settings. "
              + "Required: GCP_WORKLOAD_AUDIENCE, GCS_BUCKET_NAME");
      return;
    }

    customCredentialSupplierAwsWorkload(gcpWorkloadAudience, saImpersonationUrl, gcsBucketName);
  }

  public static void customCredentialSupplierAwsWorkload(
      String gcpWorkloadAudience, String saImpersonationUrl, String gcsBucketName) {
    // 1. Instantiate the custom supplier.
    CustomAwsSupplier customSupplier = new CustomAwsSupplier();

    // 2. Configure the AwsCredentials options.
    AwsCredentials.Builder credentialsBuilder =
        AwsCredentials.newBuilder()
            .setAudience(gcpWorkloadAudience)
            // This token type indicates that the subject token is an AWS Signature Version 4 signed
            // request. This is required for AWS Workload Identity Federation.
            .setSubjectTokenType("urn:ietf:params:aws:token-type:aws4_request")
            .setAwsSecurityCredentialsSupplier(customSupplier);

    if (saImpersonationUrl != null) {
      credentialsBuilder.setServiceAccountImpersonationUrl(saImpersonationUrl);
    }

    GoogleCredentials credentials = credentialsBuilder.build();

    // 3. Use the credentials to make an authenticated request.
    Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();

    System.out.println("Getting metadata for bucket: " + gcsBucketName + "...");
    Bucket bucket = storage.get(gcsBucketName);
    System.out.println(" --- SUCCESS! ---");
    System.out.println("Successfully authenticated and retrieved bucket data:");
    System.out.println(bucket.toString());
  }

  /**
   * Custom AWS Security Credentials Supplier.
   *
   * <p>This implementation resolves AWS credentials using the default provider chain from the AWS
   * SDK. This allows fetching credentials from environment variables, shared credential files
   * (~/.aws/credentials), or IAM roles for service accounts (IRSA) in EKS, etc.
   */
  private static class CustomAwsSupplier implements AwsSecurityCredentialsSupplier {

    private final AwsCredentialsProvider awsCredentialsProvider;
    private String region;

    public CustomAwsSupplier() {
      // The AWS SDK handles memoization (caching) and proactive refreshing internally.
      this.awsCredentialsProvider = DefaultCredentialsProvider.create();
    }

    /**
     * Returns the AWS region. This is required for signing the AWS request. It resolves the region
     * automatically by using the default AWS region provider chain, which searches for the region
     * in the standard locations (environment variables, AWS config file, etc.).
     */
    @Override
    public String getRegion(ExternalAccountSupplierContext context) {
      if (this.region == null) {
        Region awsRegion = new DefaultAwsRegionProviderChain().getRegion();
        if (awsRegion != null) {
          this.region = awsRegion.id();
        }
      }
      if (this.region == null) {
        throw new IllegalStateException(
            "CustomAwsSupplier: Unable to resolve AWS region. Please set the AWS_REGION "
                + "environment variable or configure it in your ~/.aws/config file.");
      }
      return this.region;
    }

    /** Retrieves AWS security credentials using the AWS SDK's default provider chain. */
    @Override
    public AwsSecurityCredentials getCredentials(ExternalAccountSupplierContext context) {
      software.amazon.awssdk.auth.credentials.AwsCredentials credentials =
          this.awsCredentialsProvider.resolveCredentials();
      if (credentials == null
          || credentials.accessKeyId() == null
          || credentials.secretAccessKey() == null) {
        throw new IllegalStateException(
            "Unable to resolve AWS credentials from the default provider chain. "
                + "Ensure your AWS CLI is configured, or AWS environment variables "
                + "(like AWS_ACCESS_KEY_ID) are set.");
      }

      String sessionToken = null;
      if (credentials instanceof AwsSessionCredentials) {
        sessionToken = ((AwsSessionCredentials) credentials).sessionToken();
      }

      return new com.google.auth.oauth2.AwsSecurityCredentials(
          credentials.accessKeyId(), credentials.secretAccessKey(), sessionToken);
    }
  }
}
