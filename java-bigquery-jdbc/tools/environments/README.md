# Test Environments

This directory contains Terraform configurations to provision environments for testing the BigQuery JDBC driver.

## Available Environments

### Private Service Connect (PSC)

Located in `private_service_connect/`.

This environment provisions:
- A custom VPC and subnet.
- Cloud NAT (allowing outbound internet access without public IPs).
- A Private Service Connect (PSC) endpoint for Google APIs (`all-apis`).
- A Compute Engine VM instance with no public IP, accessible via IAP (Identity-Aware Proxy).
- Firewall rules to allow IAP SSH access.

This setup is useful for testing connectivity to BigQuery via PSC and validating that traffic goes through the private endpoint.

## Deployment

To deploy an environment, you need Terraform installed and configured with Google Cloud credentials.

### Steps

1.  Navigate to the specific environment directory:
    ```bash
    cd tools/environments/private_service_connect
    ```

2.  Initialize Terraform:
    ```bash
    terraform init
    ```

3.  Create a `terraform.tfvars` file or pass variables on the command line.
    Required variables:
    - `project_id`: The GCP project ID where resources will be created.

    Optional variables (see `variables.tf` for defaults):
    - `region`: Defaults to `us-central1`.
    - `zone`: Defaults to `us-central1-a`.
    - `env_name`: Defaults to `demo`.

    Example `terraform.tfvars`:
    ```hcl
    project_id = "your-gcp-project-id"
    region     = "us-central1"
    zone       = "us-central1-a"
    env_name   = "jdbc-test"
    ```

4.  Plan the deployment:
    ```bash
    terraform plan
    ```

5.  Apply the configuration:
    ```bash
    terraform apply
    ```

6.  When done, you can destroy the environment:
    ```bash
    terraform destroy
    ```
