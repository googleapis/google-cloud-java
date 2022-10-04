terraform {
  required_providers {
    google = {
      source = "hashicorp/google"
    }
  }
}
module "project-services" {
  source = "terraform-google-modules/project-factory/google//modules/project_services"

  project_id                  = var.inputs.project_id
  enable_apis                 = var.inputs.should_enable_apis_on_apply
  disable_services_on_destroy = var.inputs.should_disable_apis_on_destroy
  activate_apis               = ["iam.googleapis.com"]
}

resource "random_id" "id" {
  byte_length = 3
}
locals {
  service_account_id = lower("service-account-id-${random_id.id.hex}")
}
resource "google_service_account" "service_account" {
  account_id   = local.service_account_id
  display_name = "Service Account"
  depends_on   = [module.project-services]
}
