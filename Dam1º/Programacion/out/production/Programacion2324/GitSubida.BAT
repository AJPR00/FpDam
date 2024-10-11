@echo off
ECHO 				 Git AJPR00
ECHO.
ECHO.
ECHO *************************** GIT STATUS ***************************
git status

pause
ECHO.
ECHO **************************** GIT ADD *****************************
git add .
pause
ECHO. 
ECHO *************************** GIT COMMIT ***************************
git commit -m "Script"
pause
ECHO. 
ECHO **************************** GIT PUSH ****************************
git push otros master

pause
