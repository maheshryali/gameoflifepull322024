pipeline {
    agent {label 'GAMEOFLIFE'}
    parameters {
        choice (name:'branchname', choices: ['master', 'branch1'], description: 'forbranchselection')
        string(name: 'MAVEN', defaultValue: 'package', description: 'forselectingmaven')
    }
    stages {
        stage('vcs') {
            steps {
            git branch: "${params.branchname}",
                   url: 'https://github.com/maheshryali/game-of-life.git'
                   }
        }
        stage('mavenbuild') {
            steps {
            sh '${params.MAVEN}'
            }
        }
        stage('archieve') {
            steps {
            junit '**/surefire-reports/*.xml'
            }
        }
    }
}