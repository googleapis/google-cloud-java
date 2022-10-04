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
  activate_apis               = ["dialogflow.googleapis.com"]
}
resource "random_id" "id" {
  byte_length = 3
  keepers     = {
    project_id = var.inputs.project_id
  }
}
locals {
  agent_display_name = lower("google-cloud-java-tests-${random_id.id.hex}")
}
resource "google_dialogflow_agent" "design_time_agent" {
  display_name          = local.agent_display_name
  default_language_code = "en"
  time_zone             = "America/Los_Angeles"
  match_mode            = "MATCH_MODE_HYBRID"
  depends_on            = [module.project-services]
}
