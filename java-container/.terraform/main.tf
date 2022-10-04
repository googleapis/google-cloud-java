terraform {
  required_providers {
    google = {
      source = "hashicorp/google"
    }
  }
}
module "project-services" {
  source = "terraform-google-modules/project-factory/google//modules/project_services"

  project_id                  = random_id.id.keepers.project_id
  enable_apis                 = var.inputs.should_enable_apis_on_apply
  disable_services_on_destroy = var.inputs.should_disable_apis_on_destroy
  activate_apis               = [
    "compute.googleapis.com",
    "container.googleapis.com",
  ]
}
resource "random_id" "id" {
  byte_length = 3
  keepers     = {
    project_id = var.inputs.project_id
  }
}
locals {
  container_network_name = lower("java-container-network-${random_id.id.hex}")
}
resource "google_compute_network" "java_container_network" {
  name                    = local.container_network_name
  auto_create_subnetworks = true
  depends_on              = [module.project-services]
}
