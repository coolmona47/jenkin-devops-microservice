pipeline {
    agent {
        docker {
            image 'node:18-alpine'
        }
    }
    
    stages {
        stage('Build') {
            steps {
                sh 'node --version'
                sh 'npm --version'
                echo 'Build'
                // Add your actual npm commands here
                // sh 'npm install'
                // sh 'npm run build'
            }
        }
        stage('Test') {
            steps {
                echo 'Test'
                // sh 'npm test'
            }
        }
        stage('Integration Test') {
            steps {
                echo 'Integration Test'
                // sh 'npm run test:integration'
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