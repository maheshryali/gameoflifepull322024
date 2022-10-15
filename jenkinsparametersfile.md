pipeline {
    agent { label 'GAMEOFLIFE' }
    parameters {
        choice(name:'branchname', choices: ['master', 'branch1'], description: 'forbranchselection')
        choice(name:'MAVEN', choices: ['clean', 'package','clean install','clean package','test'], description: 'forbranchselection')
        //string(name: 'MAVEN1', defaultValue: 'package', description: 'forselectingmaven')
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
            sh "mvn ${params.MAVEN}"
            }
        }
    }
}