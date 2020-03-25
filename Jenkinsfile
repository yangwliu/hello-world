pipeline {
    agent any

    tools {
        gradle "gradle-local"
    }

    stages {
        stage('clone') {
            steps {
                git url: 'https://github.com/sunming93/hello-world.git'
            }
        }

        stage('Unit test') {
            steps {
                sh 'gradle test -i'
            }
        }

        stage('Build') {
            steps {
                sh 'gradle build -i'
            }
        }

        stage('Build Image') {
            steps {
                script{
                  def dockerPath = tool 'docker-local'
                  env.PATH = "${dockerPath}/bin:${env.PATH}"
                  sh 'docker build -t hello-simple:test .'
                }
            }
        }

        stage('Deploy') {
            steps {
              sh 'docker run -p 8081:8080 hello-simple:test &'
              script {
                 wrap([$class: 'BuildUser']) {
                     echo "BUILD_USER=${BUILD_USER}"
                     echo "BUILD_USER_FIRST_NAME=${BUILD_USER_FIRST_NAME}"
                     echo "BUILD_USER_EMAIL=${BUILD_USER_EMAIL}"
                     echo "---"
                     echo "env.BUILD_USER=${env.BUILD_USER}"
                     echo "env.BUILD_USER_FIRST_NAME=${env.BUILD_USER_FIRST_NAME}"
                     echo "env.BUILD_USER_LAST_NAME=${env.BUILD_USER_LAST_NAME}"
                     echo "env.BUILD_USER_ID=${env.BUILD_USER_ID}"
                     echo "env.BUILD_USER_EMAIL=${env.BUILD_USER_EMAIL}"
                 }
              }
            }
        }
    }
}
