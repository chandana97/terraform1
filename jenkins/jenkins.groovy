pipeline{
  agent any
  tools {
      terraform 'Terraform'
    }
    environment{
	    AWS_ACCESS_KEY_ID     = credentials('aws_accesskey')
        AWS_SECRET_ACCESS_KEY = credentials('aws_secretkey')
	 }
	stages{
	stage('Git Checkout'){
	  steps{
	     git branch: 'master', url: 'https://github.com/chandana97/terraform1.git'
	 }
	}
	stage('Terraform Init'){
	    steps{
	       sh 'terraform init'
	    }
	 }
	 stage('Terraform apply'){
	   steps{
	     sh 'terraform apply --auto-approve'
	     }
	   }
	}
}
