# Guide to working in Git as a team
NEVER CHANGE ANYTHING IN THE MAIN BRANCH DONT YOU DARE TOUCH IT
TRIPLE CHECK BEFORE YOU WRITE ANY CODE THAT YOU ARE IN YOUR OWN BRANCH!!!!!
## Branching
Each member of the team must create their own branch. 

### Clone the repo
To do this, clone the git as normal to your device.
`git clone HTTPS-LINK-HERE`

### Create your own branch
Enter the cloned repo, your current directory should look like this:
`other-info/MyBridge`
Then, type this into your terminal:
`git checkout -b "YOUR-NAME"`

To make sure you are in your own branch:
`git branch`

It should display something like this:
> * Maria
> main

To save this branch to the repo, run:
`git add .`
`git commit -a -m "created own branch"`
`git push --set-upstream origin YOUR-NAME `

## Merging
To add your code into the main branch (the final product), you must merge what you have written into the main branch.
To do this, switch to the **main branch**
`git checkout main`

Only then do you send a merge request:
`git merge "Your name"`