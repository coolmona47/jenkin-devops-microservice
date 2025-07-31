pipeline {
    agent any
//   agent {
//         docker {
//             image 'node:20-alpine'
     
//         }
//     }  

    stages {
        stage('Build') {
            steps {
         
                //sh 'node --version'
                echo "build"
                echo "PATH -$PATH"
                echo "BUILD_NUMBER - $env.BUILD_NUMBER"
                echo "BUILD_ID - $env.BUILD_ID"
                echo "BUILD_TAG - $env.BUILD_TAG"
                echo "BUILD_URL - $env.BUILD_URL"
         
            }
        }

        stage('Test') {
            steps {
                echo "Tests"
        
            }
        }

        stage('Integration Test') {
            steps {
                echo "🔗 Running Integration Tests..."
            }
        }
    }

    post {
        success {
            echo "✅ Pipeline completed successfully!"
        }
        failure {
            echo "❌ Pipeline failed. Please check logs."
        }
        always {
            echo "🔁 Pipeline finished."
        }
    }
}
