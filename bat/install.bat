set EXEC_DIR=%~dp0
echo %EXEC_DIR%
pushd %~dp0..
set PROJECT_ROOT=%CD%
popd
echo %PROJECT_ROOT%

set INSTALL_PATH=%EXEC_DIR%commons-daemon-1.3.4-bin-windows\ServiceLauncher.exe
rem set INSTALL_PATH=%EXEC_DIR%commons-daemon-1.3.4-bin-windows\prunsrv.exe
@REM set CLASSPATH="%PROJECT_ROOT%\target;%PROJECT_ROOT%\target\java_deamon_sample-jar-with-dependencies.jar"
set CLASSPATH="C:\java_deamon_sample-jar-with-dependencies.jar"
rem JVMのパスを指定する。オプションでauto指定もできるがうまくいかない
set JavaHome="C:\Program Files (x86)\Eclipse Adoptium\jdk-8.0.392.8-hotspot\jre"  
set JVM_PATH="C:\Program Files (x86)\Eclipse Adoptium\jdk-8.0.392.8-hotspot\jre\bin\server\jvm.dll"  
rem cd commons-daemon-1.3.4-bin-windows
commons-daemon-1.3.4-bin-windows\ServiceLauncher.exe //IS//ServiceLauncher --DisplayName=ServiceLauncher --Install=%INSTALL_PATH% --Classpath=%CLASSPATH% --Startup=auto --JavaHome=%JavaHome% --Jvm=%JVM_PATH% --StartMode=jvm --StopMode=jvm --StartClass=com.example.ServiceLauncher --StartMethod=startService --StopClass=com.example.ServiceLauncher --StopMethod=stopService --LogPath=%EXEC_DIR% --LogLevel=DEBUG --StdOutput=auto --StdError=auto
rem cd commons-daemon-1.3.4-bin-windows
rem ServiceLauncher.exe //IS//ServiceLauncher --DisplayName=ServiceLauncher --Install=%INSTALL_PATH% --Classpath=%CLASSPATH% --Startup=auto --JavaHome=%JavaHome% --Jvm=%JVM_PATH% --StartMode=jvm --StopMode=jvm --StartClass=com.example.ServiceLauncher --StartMethod=startService --StopClass=com.example.ServiceLauncher --StopMethod=stopService --LogPath=%EXEC_DIR% --LogLevel=DEBUG --StdOutput=auto --StdError=auto
REM ++JvmOptions=-Dlog4j.configurationFile=%PROJECT_ROOT%setting\log4j2.xml
pause