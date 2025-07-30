pipeline {
    agent {
        docker {
            image 'maven:3.6.3'
     
      
        }
    }
    
    stages {
        stage('Build') {
            steps {
                sh 'mvn --version'
                echo 'Build'
                // Add your actual Maven commands here
                // sh 'mvn clean compile'
            }
        }
        stage('Test') {
            steps {
                echo 'Test'
                // sh 'mvn test'
            }
        }
        stage('Integration Test') {
            steps {
                echo 'Integration Test'
                // sh 'mvn verify'
            }
        }
    }
    
    post {
        always {
            echo 'I am awesome. I run always.'
        }
        success {
            echo 'I run when you are successful.'
        }
        failure {
            echo 'I run when you fail.'
        }
    }
}