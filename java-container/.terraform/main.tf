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
  depends_on              = [
    google_project_service.compute,
    google_project_service.container
  ]
}
