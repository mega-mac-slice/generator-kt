"use strict";
const Generator = require("yeoman-generator");
const chalk = require("chalk");
const yosay = require("yosay");
const path = require("path");

module.exports = class extends Generator {
  prompting() {
    // Have Yeoman greet the user.
    this.log(
      yosay(`Welcome to the epic ${chalk.red("generator-kt")} generator!`)
    );

    const dirName = process.cwd().split(path.sep).pop();
    const prompts = [
      {
        type: 'input',
        name: 'package',
        message: 'Application Package',
        default: dirName.toLowerCase()
      },
      {
        type: 'input',
        name: 'name',
        message: 'Application Name',
        default: dirName.charAt(0).toUpperCase() + dirName.substr(1)
      },
      {
        type: 'input',
        name: 'port',
        message: 'Application Port',
        default: 8080
      }
    ];

    return this.prompt(prompts).then(props => {
      // To access props later use this.props.someAnswer;
      this.props = props;
    });
  }
  runGradleInit() {
    return this.spawnCommandSync("gradle", ["wrapper", "--gradle-version", "5.0"]);
  }

  addTemplates() {
    return this.fs.copyTpl(
      this.templatePath(),
      this.destinationPath(),
      {...this.props}
    );
  }

  addDotFileTemplates() {
    return this.fs.copyTpl(
      this.templatePath('.*'),
      this.destinationPath(),
      {...this.props}
    );
  }

  gitDependencies() {
    this.spawnCommandSync('git', ['init']);
    this.spawnCommandSync('git', ['add', '.']);
    this.spawnCommandSync('git', ['commit', '-m', 'init']);
    this.spawnCommandSync('git', ['subtree', 'add', '--prefix', '.core-devops', 'git@gitlab.com:mega-mac-slice/core-devops.git', 'master', '--squash']);
  }


  writing() {
  }

  install() {
  }
};
