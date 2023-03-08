# KA-Auto
Also known as Khan Academy Automation, this is a software designated to autocomplete Khan Academy Assignments.

## Set up
To set up the app, you must either have git installed, github desktop, or manually download and unzip the files.

### Usage
To use, download the release branch (default branch) as a zip, or use 
```
git clone https://github.com/mzeng1417/KA-Auto.git
```
You may also use github desktop with their instructions here:
[https://docs.github.com/en/desktop/contributing-and-collaborating-using-github-desktop/adding-and-cloning-repositories/cloning-a-repository-from-github-to-github-desktop]{https://docs.github.com/en/desktop/contributing-and-collaborating-using-github-desktop/adding-and-cloning-repositories/cloning-a-repository-from-github-to-github-desktop}

There are scripts in the /run folder for Windows, Mac, and Linux. If you want to constantly complete your assignments, you may want to set up a cronjob or equivalent to execute the script once a week.
Additionally, you could also put it into a remote instance such as Amazon EC2, GCP, Azure, or if you wish, it may be possible to package the app into a web app, using free hosting services such as Render.com

### Developers
If you wish to contribute to the source, you may clone the src-main branch, make the modifications, and issue a pull request. We will assume that if you know how to code for the project, you know how to use Git or a VCS to handle it yourself.
However, if you are meeting with issues, you can make an issue request in the Github.
