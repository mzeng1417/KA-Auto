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
https://docs.github.com/en/desktop/contributing-and-collaborating-using-github-desktop/adding-and-cloning-repositories/cloning-a-repository-from-github-to-github-desktop

There are scripts in the folder for Windows, Mac, and Linux. If you want to constantly complete your assignments, you may want to set up a cronjob or equivalent to execute the script once a week.
Additionally, you could also put it into a remote instance such as Amazon EC2, GCP, Azure, or if you wish, it may be possible to package the app into a web app, using free hosting services such as Render.com

To use, create a .env file that contains your username and password of your Khan Academy account, in a format of
```
username
password
```
We do not collect this, and this file should be treated as a protected file.

Then, run the script with the args of the name of the file. Note that the password file should be in the same folder as the .jar and the script folder.

```
./run.sh password.env
```

This will create a web browser that reads through your assignment, watches your videos, and completes your assignments in the background.
You may want to set videos at 2 time speed for the process to finish faster.

### Developers
The source code is availiable in the branch src-main.

If you wish to contribute to the source, you may clone the src-main branch, make the modifications, and issue a pull request. We will assume that if you know how to code for the project, you know how to use Git or a VCS to handle it yourself.
