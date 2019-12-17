pipeline
{
    agent any
   
    
    
    
        
    
 stages
    {
    
    stage('Clone repository') {
        /* Let's make sure we have the repository cloned to our workspace */
steps{
        checkout scm
    }
    }
    
     stage('NPM INSTALL'){
       steps{
        sh 'npm install'
    }
    }
    
     
        
        
     
        
        
        
                stage('Build Docker Image') { 
            steps { 
                sh 'docker build -t demoangular .' 
            } 
        } 
    

stage('Push Docker Image to ECR') { 
            steps { 
            withCredentials([[$class: 'AmazonWebServicesCredentialsBinding', accessKeyVariable: 'AWS_ACCESS_KEY_ID', credentialsId: 'aws-gred', secretKeyVariable: 'AWS_SECRET_ACCESS_KEY']]) {
    // some block


                sh '$(aws ecr get-login --no-include-email --region us-east-1)' 
                sh 'docker tag demoangular:latest 347201031454.dkr.ecr.us-east-1.amazonaws.com/terrraform' 
                sh '347201031454.dkr.ecr.us-east-1.amazonaws.com/terrraform' 
            } 
        } 
        }
    }
}
