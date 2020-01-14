pipeline {
    agent any

    stages {
        stage('clone') {
            steps {
                git credentialsId: '2ff0a5e3-a090-4615-a2b7-f86b6e4191a4', url: 'git@github.com:dingtongwang/hello-world.git'
            }
        }
    }
}