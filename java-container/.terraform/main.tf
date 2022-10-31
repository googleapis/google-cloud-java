terraform {
  required_providers {
    google = {
      source = "hashicorp/google"
    }
  }
}
resource "google_project_service" "compute" {
  service            = "compute.googleapis.com"
  project            = var.inputs.project_id
  count              = var.inputs.should_enable_apis_on_apply ? 1 : 0
  disable_on_destroy = var.inputs.should_disable_apis_on_destroy
}
resource "google_project_service" "container" {
  service            = "container.googleapis.com"
  project            = var.inputs.project_id
  count              = var.inputs.should_enable_apis_on_apply ? 1 : 0
  disable_on_destroy = var.inputs.should_disable_apis_on_destroy
}
locals {
  container_network_name = "java-container-network"
}
resource "google_compute_network" "java_container_network" {
  count                   = var.inputs.should_create_networks ? 1 : 0
  name                    = local.container_network_name
  auto_create_subnetworks = true
  depends_on              = [
    google_project_service.compute,
    google_project_service.container
  ]
}
data "google_compute_network" "existing_network" {
  count = var.inputs.should_create_networks ? 0 : 1
  name  = local.container_network_name
}
