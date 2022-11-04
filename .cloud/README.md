# Introduction

When you experience integration test failures, they may be due to concurrent tests accessing the
same GCP project resources, required resources not existing on the GCP project, quota limits being
exceeded due to overreliance on a single project, incorrect permissions, disabled APIs, and/or
service account impersonation requirements.

[Terraform](https://www.terraform.io/) is an "Infrastructure as Code" (IaC) tool that allows cloud
and on-prem resources to be defined in configuration files to be versioned, reused, and shared. By
using Terraform to provision our GCP projects prior to running integration tests we:

* Ensure infrastructure provisioning consistency,
* Prevent conflicts between concurrent integration test invocations using the same GCP project by
  randomizing resource names,
* Provide a managed lifecycle including the ability to destroy short-lived testing environments,
* Version the infrastructure requirements with the test source.

# Running `google-cloud-java` Integration Tests

When you need to troubleshoot integration tests in the google-cloud-java repository, follow one of
the supported workflows below to provision a GCP project with the required configuration.

## Installation

1. Download and install the latest version of Terraform: https://www.terraform.io/downloads
2. *(Optional)* Update your default shell environment variables. (For Mac users,
   modify `~/.bash_profile`.
   For Linux users, modify `~/.bashrc`.)
    * See
      also: [About Cloud Billing accounts](https://cloud.google.com/billing/docs/how-to/manage-billing-account)
    * See
      also: [Creating and managing Folders](https://cloud.google.com/resource-manager/docs/creating-managing-folders)

```shell                       
export GOOGLE_CLOUD_FOLDER_ID="000000000000"
export GOOGLE_CLOUD_BILLING_ACCOUNT="000000-000000-000000"
export GOOGLE_CLOUD_PROJECT_PREFIX="my-project"
```

## Supported Workflows

During these workflows, you may be asked to authenticate one or two times with gcloud as it
optionally creates a GCP project, and then sets up the
[application-default credentials](https://cloud.google.com/docs/authentication/application-default-credentials)
to be used by Terraform and the client libraries.

A service account will be created, assigned `roles/owner`[^1], and used for all client library
integration tests. Your user credentials must have permission in the designated GCP project to
self-assign `roles/iam.serviceAccountTokenCreator` to impersonate the service account.

[^1]: Basic roles like `roles/owner` are
[not recommended in production environments](https://cloud.google.com/iam/docs/understanding-roles#basic)
.

### Workflow: Set up a GCP Project for **One or More** Client Libraries, then Test

1. Invoke `setup.sh` with the directory names of the selected client libraries:
   ```shell
   $ ./.cloud/setup.sh [library][,library ...]
   ```

   Examples:
    * `./.cloud/setup.sh java-accessapproval`
    * `./.cloud/setup.sh java-asset,java-compute,java-container`

2. When ready to begin testing, invoke `verify.sh`:
   ```shell
   $ ./.cloud/verify.sh [library][,library ...]
   ```

   Examples:
    * `./.cloud/verify.sh java-accessapproval`
    * `./.cloud/verify.sh java-asset,java-compute,java-container`

Note: Invoking `verify.sh` without arguments will begin performing integration testing on all client
libraries. In this workflow, the GCP project will only have been configured the project for a subset
of client libraries, this command is unlikely to succeed unless the GCP project has been previously
resourced and configured manually. If you wish to perform integration testing on all client
libraries, use the below workflow to first provision the project for all client libraries.

### Workflow: Set up a GCP Project for **All** Client Libraries, then Test

1. Invoke `setup.sh` without arguments:
   ```shell
   $ ./.cloud/setup.sh
   ```
   Every client library with a `.cloud` subdirectory will be included in the generated Terraform
   root module, and the GCP project will be prepared to test all client libraries.
2. When ready to begin testing, invoke `verify.sh` with or without arguments:
   ```shell
   $ ./.cloud/verify.sh
   ```
   The above will perform integration tests on all client libraries.
   ```shell
   $ ./.cloud/verify.sh [library][,library ...]
   ```
   The above will only perform integration testing on the specified client libraries.

   Examples:
    * `./.cloud/verify.sh`
    * `./.cloud/verify.sh java-accessapproval`
    * `./.cloud/verify.sh java-asset,java-compute,java-container`

### Workflow: Set up and Test with One Command

Use `test.sh` to perform a combination of both `setup.sh` and `verify.sh`.

```shell
$ ./.cloud/test.sh [library][,library ...]
```

Examples:

* `./.cloud/test.sh`
* `./.cloud/test.sh java-accessapproval`
* `./.cloud/test.sh java-asset,java-compute,java-container`

### Workflow: Clean up GCP Project of Test Resources

To clean-up (or “destroy”) all provisioned resources under Terraform’s management,
invoke `cleanup.sh`:

```shell
$ ./.cloud/cleanup.sh
```

### Workflow: Add / Remove Client Libraries in an Existing Test Configuration

Terraform will automatically manage the resources for a GCP project when regenerating the root
module to include different client libraries. No additional commands are necessary to support this
use-case.

Example:

```shell
$ ./.cloud/setup.sh java-bigqueryconnection
# Terraform provisions the project for java-bigqueryconnection's requirements.

$ ./.cloud/setup.sh java-accessapproval
# Terraform simultaneously destroys java-bigqueryconnection's resources that
# are no longer being used, and provisions the project for java-accessapproval's
# requirements.
# Warning: This 'implicit removal' is prone to errors. If an error occurs, an
# explicit invocation of 'cleanup.sh' may be required.

$ ./.cloud/setup.sh java-accessapproval,java-texttospeech
# Terraform maintains the java-accessapproval resources while also provisioning
# the project for java-texttospeech's requirements.
```
